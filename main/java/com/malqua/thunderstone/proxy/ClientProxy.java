package com.malqua.thunderstone.proxy;

import com.malqua.thunderstone.effects.EntityChainLightningFX;
import com.malqua.thunderstone.init.ThunderstoneBlocks;
import com.malqua.thunderstone.init.ThunderstoneEntities;
import com.malqua.thunderstone.init.ThunderstoneItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ClientProxy extends CommonProxy{
    @Override
    public void registerRenders(){
        ThunderstoneItems.registerRenders();
        ThunderstoneEntities.registerRenders();
        ThunderstoneBlocks.registerRenders();
    }

    @Override
    public void SpawnParticle(World world, Vec3 origin, Vec3 motion){
//        world.spawnParticle(particleType,
//                origin.xCoord, origin.yCoord, origin.zCoord,
//                motion.xCoord, motion.yCoord, motion.zCoord, new int[0]);

        EntityFX particle = new EntityChainLightningFX(world,
                origin.xCoord,origin.yCoord,origin.zCoord,
                motion.xCoord,motion.yCoord,motion.zCoord);

        Minecraft.getMinecraft().effectRenderer.addEffect(particle);
    }
}
