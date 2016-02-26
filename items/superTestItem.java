package com.malqua.thunderstone.items;

import com.malqua.thunderstone.entity.EntityThunderBolt;
import com.malqua.thunderstone.events.EventManagerClient;
import com.malqua.thunderstone.events.EventManagerServer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import scala.Console;

/**
 * Created by Malqua on 2/25/2016.
 */
public class superTestItem extends Item {
    public superTestItem(){
        super();
    }


    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){

        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
        if(mop == null){
            return stack;
        }else{
            switch(mop.typeOfHit){
                case BLOCK:{
                    BlockPos bp = mop.getBlockPos();
                    if(!world.isBlockModifiable(player, bp)){
                        return stack;
                    }

                    IBlockState blockState = world.getBlockState(bp);
                    Block block = blockState.getBlock();

                    if(!world.isRemote){
                        EntityThunderBolt bolt = new EntityThunderBolt(world, 0D,0D,0D);
                        bolt.setLocationAndAngles(bp.getX(), bp.getY(), bp.getZ(), 0, 0.0f);
                        world.addWeatherEffect(bolt);
                        EventManagerServer.syncLightningNew(bolt);
                    }

                    return stack;
//                    break;
                }
                case ENTITY: {
                    Console.println("Fuck you entity!");
                    return stack;
//                    break;
                }
                default: return stack;
            }
        }
    }
}
