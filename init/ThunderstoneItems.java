package com.malqua.thunderstone.init;

import com.malqua.thunderstone.Reference;
import com.malqua.thunderstone.items.ItemThunderWand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ThunderstoneItems {

    public static Item thunder_dust;
    public static Item thunderstone_ingot;
    public static Item thunderstone_gem;

    public static Item thunder_wand;

    public static void init(){
        thunder_wand = new ItemThunderWand().setUnlocalizedName("thunder_wand");
    }

    public static void register(){
        GameRegistry.registerItem(thunder_wand, thunder_wand.getUnlocalizedName().substring(5));
    }

    public static void registerRenders(){
        registerRender(thunder_wand);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));

    }
}
