package com.mraof.minestuck.world.biome;

import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.Layer;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LandBiomeProvider extends BiomeProvider
{
	private final Layer genLevelLayer;
	private final Layer blockLevelLayer;
	
	public LandBiomeProvider(LandBiomeProviderSettings settings)
	{
		topBlocksCache.add(settings.getGenSettings().getBlockRegistry().getBlockState("surface"));
		
		Layer[] layers = LandBiomeLayers.buildLandProcedure(settings.getSeed(), settings.getGenSettings());
		
		genLevelLayer = layers[0];
		blockLevelLayer = layers[1];
	}
	
	@Override
	public Biome getBiome(int x, int z)
	{
		return blockLevelLayer.func_215738_a(x, z);
	}
	
	@Override
	public Biome func_222366_b(int x, int z)
	{
		return genLevelLayer.func_215738_a(x, z);
	}
	
	@Override
	public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag)
	{
		return blockLevelLayer.generateBiomes(x, z, width, length);
	}
	
	@Override
	public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength)
	{
		int minX = centerX - sideLength >> 2;
		int minZ = centerZ - sideLength >> 2;
		int maxX = centerX + sideLength >> 2;
		int maxZ = centerZ + sideLength >> 2;
		int sizeX = maxX - minX + 1;
		int sizeZ = maxZ - minZ + 1;
		Set<Biome> set = Sets.newHashSet();
		Collections.addAll(set, genLevelLayer.generateBiomes(minX, minZ, sizeX, sizeZ));
		return set;
	}
	
	@Nullable
	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random)
	{
		int minX = x - range >> 2;
		int minZ = z - range >> 2;
		int maxX = x + range >> 2;
		int maxZ = z + range >> 2;
		int sizeX = maxX - minX + 1;
		int sizeZ = maxZ - minZ + 1;
		Biome[] abiome = genLevelLayer.generateBiomes(minX, minZ, sizeX, sizeZ);
		BlockPos pos = null;
		int matches = 0;
		
		for(int index = 0; index < sizeX * sizeZ; ++index)
		{
			int posX = minX + index % sizeX << 2;
			int posZ = minZ + index / sizeX << 2;
			if (biomes.contains(abiome[index]))
			{
				if (pos == null || random.nextInt(matches + 1) == 0)
					pos = new BlockPos(posX, 0, posZ);
				
				matches++;
			}
		}
		
		return pos;
	}
	
	@Override
	public boolean hasStructure(Structure<?> structureIn)
	{
		return false;
	}
	
	@Override
	public Set<BlockState> getSurfaceBlocks()
	{
		return topBlocksCache;
	}
}