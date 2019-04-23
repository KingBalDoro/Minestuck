package com.mraof.minestuck.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MinestuckTiles
{
	public static final TileEntityType<TileEntityComputer> COMPUTER = new TileEntityType<>(TileEntityComputer::new,null);
	public static final TileEntityType<TileEntitySburbMachine> SBURB_MACHINE = new TileEntityType<>(TileEntitySburbMachine::new,null);
	public static final TileEntityType<TileEntityCruxtruder> CRUXTRUDER = new TileEntityType<>(TileEntityCruxtruder::new,null);
	public static final TileEntityType<TileEntityTotemLathe> TOTEM_LATHE = new TileEntityType<>(TileEntityTotemLathe::new,null);
	public static final TileEntityType<TileEntityAlchemiter> ALCHEMITER = new TileEntityType<>(TileEntityAlchemiter::new,null);
	public static final TileEntityType<TileEntityPunchDesignix> PUNCH_DESIGNIX = new TileEntityType<>(TileEntityPunchDesignix::new,null);
	public static final TileEntityType<TileEntityCrockerMachine> CROCKER_MACHINE = new TileEntityType<>(TileEntityCrockerMachine::new,null);
	public static final TileEntityType<TileEntityTransportalizer> TRANSPORTALIZER = new TileEntityType<>(TileEntityTransportalizer::new,null);
	public static final TileEntityType<TileEntityItemStack> ITEM_STACK = new TileEntityType<>(TileEntityItemStack::new,null);
	public static final TileEntityType<TileEntityUraniumCooker> URANIUM_COOKER = new TileEntityType<>(TileEntityUraniumCooker::new,null);
	public static final TileEntityType<TileEntityJumperBlock> JUMPER_BLOCK = new TileEntityType<>(TileEntityJumperBlock::new,null);
	public static final TileEntityType<TileEntityAlchemiterUpgrade> ALCHEMITER_UPGRADE = new TileEntityType<>(TileEntityAlchemiterUpgrade::new,null);
	public static final TileEntityType<TileEntityUpgradedAlchemiter> UPGRADE_ALCHEMITER = new TileEntityType<>(TileEntityUpgradedAlchemiter::new,null);
	public static final TileEntityType<TileEntityHolopad> HOLOPAD = new TileEntityType<>(TileEntityHolopad::new,null);
	public static final TileEntityType<TileEntitySkaiaPortal> SKAIA_PORTAL = new TileEntityType<>(TileEntitySkaiaPortal::new,null);
	public static final TileEntityType<TileEntityGate> GATE = new TileEntityType<>(TileEntityGate::new,null);
	
	@SubscribeEvent
	public static void registerTileEntityType(RegistryEvent.Register<TileEntityType<?>> event)
	{
		event.getRegistry().register(COMPUTER.setRegistryName("computer"));
		event.getRegistry().register(SBURB_MACHINE.setRegistryName("sburb_machine"));
		event.getRegistry().register(CRUXTRUDER.setRegistryName("cruxtruder"));
		event.getRegistry().register(TOTEM_LATHE.setRegistryName("totem_lathe"));
		event.getRegistry().register(ALCHEMITER.setRegistryName("alchemiter"));
		event.getRegistry().register(PUNCH_DESIGNIX.setRegistryName("punch_designix"));
		event.getRegistry().register(CROCKER_MACHINE.setRegistryName("crocker_machine"));
		event.getRegistry().register(TRANSPORTALIZER.setRegistryName("transportalizer"));
		event.getRegistry().register(ITEM_STACK.setRegistryName("item_stack"));
		event.getRegistry().register(URANIUM_COOKER.setRegistryName("uranium_cooker"));
		event.getRegistry().register(JUMPER_BLOCK.setRegistryName("jumper_block"));
		event.getRegistry().register(ALCHEMITER_UPGRADE.setRegistryName("alchemiter_upgrade"));
		event.getRegistry().register(UPGRADE_ALCHEMITER.setRegistryName("upgrade_alchemiter"));
		event.getRegistry().register(HOLOPAD.setRegistryName("holopad"));
		event.getRegistry().register(SKAIA_PORTAL.setRegistryName("skaia_portal"));
		event.getRegistry().register(GATE.setRegistryName("gate"));
	}
}