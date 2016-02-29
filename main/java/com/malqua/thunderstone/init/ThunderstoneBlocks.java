package com.malqua.thunderstone.init;

import com.malqua.thunderstone.Reference;
import com.malqua.thunderstone.ThunderstoneMod;
import com.malqua.thunderstone.blocks.ThunderstoneOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Malqua on 2/28/2016.
 */
public class ThunderstoneBlocks {

    public static Block thunderstone_ore;

    public static void init(){
        thunderstone_ore = new ThunderstoneOre(Material.rock).setUnlocalizedName("thunderstone_ore");
    }

    public static void register(){
        registerBlockAndName(thunderstone_ore).setCreativeTab(ThunderstoneMod.tabs);
    }

    private static Block registerBlockAndName(Block block){
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
        return block;
    }

    public static void registerRenders(){
        registerRender(thunderstone_ore);
//        Block.blockRegistry.getObject()
    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));

    }
}
