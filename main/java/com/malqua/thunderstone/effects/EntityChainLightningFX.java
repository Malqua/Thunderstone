package com.malqua.thunderstone.effects;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

/**
 * Created by Malqua on 2/29/2016.
 */
public class EntityChainLightningFX extends EntityFX {
    public EntityChainLightningFX(World world, double x, double y, double z, double vx, double vy, double vz){
        super(world, x,y,z,vx,vy,vz);
        setParticleTextureIndex(65);
        particleScale = 2f;
        particleGravity = 0;
        setRBGColorF(0, 0.25f , 1f);
    }
}
