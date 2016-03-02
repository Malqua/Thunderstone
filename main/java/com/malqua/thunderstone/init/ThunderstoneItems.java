package com.malqua.thunderstone.init;

import com.malqua.thunderstone.Reference;
import com.malqua.thunderstone.ThunderstoneMod;
import com.malqua.thunderstone.items.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ThunderstoneItems {

    public static Item thunder_dust;
    public static Item thunder_coatedIngot;
    public static Item thunder_ingot;
    public static Item thunder_sword;
    public static Item thunder_bow;
    public static Item thunder_arrow;

    public static Item thunder_pick;
    public static Item thunder_axe;
    public static Item thunder_shovel;
    public static Item thunder_hoe;

    public static Item thunder_gem;

    public static Item thunder_wand;
    public static Item thunder_wandDebug;

    public static void init(){
        //BASICS
        thunder_dust = new Item().setUnlocalizedName("thunder_dust");
        thunder_coatedIngot = new Item().setUnlocalizedName("thunder_coatedIngot");
        thunder_ingot = new Item().setUnlocalizedName("thunder_ingot");

        //WEAPONS
        thunder_sword = new ItemThunderSword(Item.ToolMaterial.EMERALD).setUnlocalizedName("thunder_sword");
        thunder_bow = new ItemThunderBow().setUnlocalizedName("thunder_bow");
        thunder_wand = new ItemThunderWand().setUnlocalizedName("thunder_wand");
        thunder_wandDebug = new ItemThunderWandDebug().setUnlocalizedName("thunder_wandDebug");
        thunder_arrow = new Item().setUnlocalizedName("thunder_arrow");

        //TOOLS
        thunder_pick = new ItemThunderPick(Item.ToolMaterial.EMERALD).setUnlocalizedName("thunder_pick");
        thunder_axe = new ItemThunderAxe(Item.ToolMaterial.EMERALD).setUnlocalizedName("thunder_axe");
        thunder_shovel = new ItemThunderShovel(Item.ToolMaterial.EMERALD).setUnlocalizedName("thunder_shovel");
        thunder_hoe = new ItemThunderHoe(Item.ToolMaterial.EMERALD).setUnlocalizedName("thunder_hoe");
    }

    public static void register(){
        //BASICS
        registerItemAndName(thunder_dust).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_coatedIngot).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_ingot).setCreativeTab(ThunderstoneMod.tabs);

        //WEAPONS
        registerItemAndName(thunder_sword).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_wand).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_wandDebug).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_bow).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_arrow).setCreativeTab(ThunderstoneMod.tabs);

        //TOOLS
        registerItemAndName(thunder_pick).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_axe).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_shovel).setCreativeTab(ThunderstoneMod.tabs);
        registerItemAndName(thunder_hoe).setCreativeTab(ThunderstoneMod.tabs);
    }

    private static Item registerItemAndName(Item item){
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        return item;
    }

    public static void registerRenders(){
        //BASICS
        registerRender(thunder_dust);
        registerRender(thunder_coatedIngot);
        registerRender(thunder_ingot);

        //WEAPONS
        registerRender(thunder_sword);
        registerRender(thunder_wand);
        registerRender(thunder_wandDebug);
        registerRender(thunder_bow);
        registerRender(thunder_arrow);

        //TOOLS
        registerRender(thunder_pick);
        registerRender(thunder_axe);
        registerRender(thunder_shovel);
        registerRender(thunder_hoe);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));

    }
}
