package com.mraof.minestuck.world.gen.feature.tree;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class RainbowTree extends Tree
{
	
	@Nullable
	@Override
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random)
	{
		return new RainbowTreeFeature(NoFeatureConfig::deserialize, true);
	}
}