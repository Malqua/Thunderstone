package com.malqua.thunderstone.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

/**
 * Created by Malqua on 3/1/2016.
 */
public class EntityThunderArrow extends EntityArrow {
    public EntityThunderArrow(World worldIn, EntityLivingBase shooter, float velocity) {
        super(worldIn, shooter, velocity);
    }
}
