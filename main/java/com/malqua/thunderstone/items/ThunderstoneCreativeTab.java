package com.malqua.thunderstone.items;

import com.malqua.thunderstone.init.ThunderstoneItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Malqua on 2/28/2016.
 */
public class ThunderstoneCreativeTab extends CreativeTabs {

    public ThunderstoneCreativeTab(String label){
        super(label);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ThunderstoneItems.thunder_sword);
    }

    @Override
    public Item getTabIconItem() {
        return getIconItemStack().getItem();
    }
}
