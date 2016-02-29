package com.malqua.thunderstone.init;

import com.malqua.thunderstone.ThunderstoneMod;
import com.malqua.thunderstone.entity.EntityThunderBolt;
import com.malqua.thunderstone.entity.renderers.EntityThunderBoltRender;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Malqua on 2/26/2016.
 */
public class ThunderstoneEntities {

    private static int modEntityID = -1;
    public static void init(){
        EntityRegistry.registerModEntity(EntityThunderBolt.class, "Thunder Bolt", ++modEntityID, ThunderstoneMod.instance, 0, 0, false);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
//        RenderingRegistry.registerEntityRenderingHandler(EntityThunderBolt.class, new EntityThunderBoltFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityThunderBolt.class, new EntityThunderBoltRender(Minecraft.getMinecraft().getRenderManager()));
    }
}
