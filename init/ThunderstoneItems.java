package com.malqua.thunderstone.init;

import com.malqua.thunderstone.Reference;
import com.malqua.thunderstone.items.superTestItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ThunderstoneItems {

    public static Item test_item;

    public static void init(){
        test_item = new superTestItem().setUnlocalizedName("test_item");
    }

    public static void register(){
        GameRegistry.registerItem(test_item, test_item.getUnlocalizedName().substring(5));
    }

    public static void registerRenders(){
        registerRender(test_item);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));

    }
}
