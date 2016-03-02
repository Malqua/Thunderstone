package com.malqua.thunderstone.items;

import com.malqua.thunderstone.entity.weather.EntityThunderBolt;
import com.malqua.thunderstone.events.EventManagerServer;
import net.minecraft.entity.effect.EntityLightningBolt;
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
public class ItemThunderWand extends Item {
    public ItemThunderWand(){
        super();
    }

    private static double boltRange = 25.0;
    protected boolean debugBolts;

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){

//        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
        //        MovingObjectPosition mop = player.rayTrace(boltRange, 1);
        Vec3 playerPositionVector = player.getPositionVector();
        Vec3 origin = new Vec3(playerPositionVector.xCoord, playerPositionVector.yCoord + player.getEyeHeight(), playerPositionVector.zCoord);
        Vec3 lookDir = player.getLookVec();
        Vec3 target = new Vec3(lookDir.xCoord * boltRange, lookDir.yCoord * boltRange, lookDir.zCoord * boltRange);
        MovingObjectPosition mop = world.rayTraceBlocks(origin, origin.add(target), false);

//        world.rayTraceBlocks()

        if(mop == null){
            return stack;
        }else{
            switch(mop.typeOfHit){
                case BLOCK:{
                    BlockPos bp = mop.getBlockPos();
                    if(!world.isBlockModifiable(player, bp)){
                        return stack;
                    }

//                    IBlockState blockState = world.getBlockState(bp);
//                    Block block = blockState.getBlock();

                    if(!world.isRemote){
                        if(debugBolts){
                            EntityLightningBolt bolt = new EntityLightningBolt(world, 0D,0D,0D);
                            bolt.setLocationAndAngles(bp.getX(), bp.getY()+1, bp.getZ(), 0, 0.0f);

                            //CLIENT VISUAL, DOES NOTHING REALLY
                            world.weatherEffects.add(bolt);

                            //SERVER BOLT, DOES THE HARD WORK
                            EventManagerServer.syncLightningBolt(bolt);
                        }else{
                            EntityThunderBolt bolt = new EntityThunderBolt(world, 0D,0D,0D);
                            bolt.setLocationAndAngles(bp.getX(), bp.getY()+1, bp.getZ(), 0, 0.0f);

                            //CLIENT VISUAL, DOES NOTHING REALLY
                            world.weatherEffects.add(bolt);

                            //SERVER BOLT, DOES THE HARD WORK
                            EventManagerServer.syncThunderBolt(bolt);
                        }
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
