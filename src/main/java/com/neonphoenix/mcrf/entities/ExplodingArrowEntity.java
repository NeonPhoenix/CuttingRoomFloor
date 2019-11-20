package com.neonphoenix.mcrf.entities;

import com.neonphoenix.mcrf.lists.ModdedItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ExplodingArrowEntity extends ArrowEntity
{
    public ExplodingArrowEntity(final EntityType<? extends ExplodingArrowEntity> entityType, final World world) {
        super(entityType, world);
    }

    public ExplodingArrowEntity(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
    }

    public ExplodingArrowEntity(final World world, final LivingEntity shooter) {
        super(world, shooter);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(ModdedItems.EXPLODING_ARROW);
    }

    @Override
    protected void onHit(RayTraceResult rayTraceResult)
    {
        RayTraceResult.Type raytraceresult$type = rayTraceResult.getType();

        if (raytraceresult$type == RayTraceResult.Type.ENTITY)
        {
            final Entity entity = ((EntityRayTraceResult)rayTraceResult).getEntity();

            entity.attackEntityFrom(DamageSource.causeExplosionDamage(this.world.createExplosion(entity, entity.getPosition().getX(), entity.getPosition().getY() + entity.getHeight(), entity.getPosition().getZ(), 4.0F, Explosion.Mode.BREAK)), 8.0F);
            //DamageSource.causeExplosionDamage(this.world.createExplosion(entity, entity.getPosition().getX(), entity.getPosition().getY() + entity.getHeight(), entity.getPosition().getZ(), 4.0F, Explosion.Mode.BREAK));

            this.remove();
        }
        else if (raytraceresult$type == RayTraceResult.Type.BLOCK)
        {
            final BlockPos pos = ((BlockRayTraceResult)rayTraceResult).getPos();

            this.world.createExplosion(this, pos.getX(), pos.getY(), pos.getZ(), 4.0F, Explosion.Mode.BREAK);

            this.remove();
        }
    }
}
