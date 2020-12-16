package com.mraof.minestuck.entity;

import com.mraof.minestuck.entity.item.GristEntity;
import com.mraof.minestuck.item.MSItems;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BulletEntity extends DamagingProjectileEntity{
    public BulletEntity(EntityType<? extends BulletEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    //@OnlyIn(Dist.CLIENT)
    public BulletEntity(double x, double y, double z, World worldIn, double accelX, double accelY, double accelZ)
    {
        super(MSEntityTypes.BULLET, x, y, z, accelX, accelY, accelZ, worldIn);
    }

    public BulletEntity(World worldIn, double accelX, double accelY, double accelZ, LivingEntity shooter)
    {
        super(MSEntityTypes.BULLET, shooter, accelX, accelY, accelZ, worldIn);
    }

    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.getType() == RayTraceResult.Type.ENTITY) {
                Entity entity = ((EntityRayTraceResult)result).getEntity();
                entity.attackEntityFrom(DamageSource.GENERIC, 6.0F);
                this.applyEnchantments(this.shootingEntity, entity);
            }
        }
    }

    public void writeAdditional(CompoundNBT compound){
        super.writeAdditional(compound);
    }

    public void readAdditional(CompoundNBT compound){
        super.readAdditional(compound);
    }

    public void shoot(PlayerEntity playerIn, float rotationPitch, float rotationYaw, float v, float v1, float v2) {
    }
}
