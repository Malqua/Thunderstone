package com.malqua.thunderstone.init;

import com.malqua.thunderstone.Reference;
import com.malqua.thunderstone.ThunderstoneMod;
import com.malqua.thunderstone.items.ItemThunderWand;
import com.malqua.thunderstone.items.ItemThunderWandDebug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ThunderstoneItems {

    public static Item thunder_dust;
    public static Item thunder_coatedIngot;
    public static Item thunder_ingot;
    public static Item thunder_sword;
    public static Item thunder_gem;

    public static Item thunder_wand;
    public static Item thunder_wandDebug;

    public static void init(){
        thunder_dust = new Item().setUnlocalizedName("thunder_dust");
        thunder_coatedIngot = new Item().setUnlocalizedName("thunder_coatedIngot");
        thunder_ingot = new Item().setUnlocalizedName("thunder_ingot");
        thunder_sword = new ItemSword(Item.ToolMaterial.EMERALD).setUnlocalizedName("thunder_sword");

        thunder_wand = new ItemThunderWand().setUnlocalizedName("thunder_wand");
        thunder_wandDebug = new ItemThunderWandDebug().setUnlocalizedName("thunder_wandDebug");
    }

    public static void register(){
        registerItemAndName(thunder_dust).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_coatedIngot).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_ingot).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_sword).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_wand).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_wandDebug).setCreativeTab(ThunderstoneMod.tabs);
    }

    private static Item registerItemAndName(Item item){
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        return item;
    }

    public static void registerRenders(){
        registerRender(thunder_dust);
        registerRender(thunder_coatedIngot);
        registerRender(thunder_ingot);
        registerRender(thunder_sword);
        registerRender(thunder_wand);
        registerRender(thunder_wandDebug);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));

    }
}
