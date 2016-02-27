package com.malqua.thunderstone.entity.renderers;

import com.malqua.thunderstone.entity.EntityThunderBolt;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by Malqua on 2/26/2016.
 */
public class EntityThunderBoltFactory implements IRenderFactory<EntityThunderBolt>{

    @Override
    public Render<? super EntityThunderBolt> createRenderFor(RenderManager manager) {
        return new EntityThunderBoltRender(manager);
    }
}