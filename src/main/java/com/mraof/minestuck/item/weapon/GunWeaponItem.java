package com.mraof.minestuck.item.weapon;

import com.mraof.minestuck.entity.BulletEntity;
import com.mraof.minestuck.util.MSSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.Random;

public class GunWeaponItem extends Item {

    public GunWeaponItem(Item.Properties properties)
    {
        super(properties);
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack item = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote)
        {
            EntityType entityType = EntityType.PLAYER;
            /*Random rand = new Random();
            int durability = rand.nextInt(14) + 1;
            item.damageItem(durability, playerIn, playerEntity -> playerEntity.sendBreakAnimation(Hand.MAIN_HAND));*/

            playerIn.world.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, MSSoundEvents.ITEM_BULLET_FIRE_USE, SoundCategory.AMBIENT, 1.5F, 1.0F);

            BulletEntity bullet = new BulletEntity(entityType, worldIn);
            bullet.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.5F);
            bullet.posX = (this.getBoundingBox().minX + this.getBoundingBox().maxX) / 2.0F  + vec3.x * d8;
            bullet.posY = (this.getBoundingBox().minY + this.getBoundingBox().maxY) / (double)(this.getHeight() / 2.0F);
            bullet.posZ = (this.getBoundingBox().minZ + this.getBoundingBox().maxZ) / 2.0F + vec3.z * d8;
            worldIn.addEntity(bullet);
        }
        if(worldIn.isRemote)
        {
            return new ActionResult<>(ActionResultType.SUCCESS, item);
        } else
        {
            return new ActionResult<>(ActionResultType.PASS, item);
        }

    }
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entity, int timeLeft)
    {
        entity.resetActiveHand();
        super.onPlayerStoppedUsing(stack, world, entity, timeLeft);
    }

    public void weaponUseTick(World world, LivingEntity entity, ItemStack stack, int timeLeft)
    {

    }

    public void onPlayerCooldownEnd(World world, PlayerEntity player, ItemStack stack)
    {

    }
}
