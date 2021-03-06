package com.mraof.minestuck.entity.carapacian;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class BlackRookEntity extends RookEntity
{
	public BlackRookEntity(EntityType<? extends BlackRookEntity> type, World world)
	{
		super(type, world);
	}
	
	@Override
	public EnumEntityKingdom getKingdom()
	{
		return EnumEntityKingdom.DERSITE;
	}
}
