package com.malqua.thunderstone.items;

import com.malqua.thunderstone.entity.EntityThunderBolt;
import com.malqua.thunderstone.events.EventManagerServer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import scala.Console;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ItemThunderWandDebug extends ItemThunderWand {
    public ItemThunderWandDebug(){
        super();
        debugBolts = true;
    }
}
