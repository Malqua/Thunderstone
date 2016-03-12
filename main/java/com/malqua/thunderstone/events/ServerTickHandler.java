package com.malqua.thunderstone.events;

import com.malqua.thunderstone.init.ThunderstoneBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Malqua on 3/11/2016.
 */
public class ServerTickHandler {

    private static int id = 0;
    public static void OnTickInGame(){
        if (FMLCommonHandler.instance() == null || FMLCommonHandler.instance().getMinecraftServerInstance() == null)
        {
            return;
        }

        World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);

        List<Entity> weatherEffects = new ArrayList<Entity>();
        weatherEffects.addAll(world.weatherEffects);

        weatherEffects.removeIf(entity -> !(entity instanceof EntityLightningBolt));
        for (int i = 0; i < weatherEffects.size(); i++){
            Entity e = weatherEffects.get(i);
            System.out.println(e.hashCode());
            if(id == e.hashCode()){
                System.out.println(" == " + id);
                continue;
            }
            BlockPos pos = e.getPosition();
            GenerateOre(world, pos);
            id = e.hashCode();
        }
    }

    private static void GenerateOre(World world, BlockPos pos) {
        BlockPos bp = pos;
        //todo: config for which blocks cannot be replaced
        if (world.getBlockState(bp.add(0,-1,0)).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(world, bp))
        {
            return;
        }

        //ROOT
        bp = bp.add(0,-1,0);
        world.setBlockState(bp, ThunderstoneBlocks.thunderstone_ore.getDefaultState());
        //BASE
        bp = bp.add(0,1,0);
        world.setBlockState(bp, ThunderstoneBlocks.thunderstone_ore.getDefaultState());
        for (int i = 0; i < 4; i++){
            boolean west = (i % 2) == 0;
            boolean north = (i / 2) == 0;

            Vec3i offset = new Vec3i(west ? -1 : 1, 0, north ? -1 : 1);
            world.setBlockState(bp.add(offset), Blocks.fire.getDefaultState());
        }

        //LEAVES
        for (int i = 0; i < 8; i++){
            boolean west = i % 4 == 0;
            boolean east = i % 4 == 1;
            boolean north = i % 4 == 2;
            boolean south = i % 4 == 3;
            boolean extend = i / 4 > 0;

            Vec3i offset = new Vec3i((west?1:(east?-1:0)) * (extend ? 2 : 1), (extend ? 1 : 0), (north?1:(south?-1:0)) * (extend ? 2 : 1));
            world.setBlockState(bp.add(offset), ThunderstoneBlocks.thunderstone_ore.getDefaultState());
        }

        //STEM
        bp = bp.add(0,1,0);
        int j = world.rand.nextInt(4);
        boolean west = j % 4 == 0;
        boolean east = j % 4 == 1;
        boolean north = j % 4 == 2;
        boolean south = j % 4 == 3;

        for (int i = 0; i < 5; i++){
            boolean tail = i % 5 >= 3;

            if(tail) {
                Vec3i offset = new Vec3i((west?1:(east?-1:0)),i-1,(north?1:(south?-1:0)));
                world.setBlockState(bp.add(offset), ThunderstoneBlocks.thunderstone_ore.getDefaultState());
            }else{
                Vec3i offset = new Vec3i(0,i,0);
                world.setBlockState(bp.add(offset), ThunderstoneBlocks.thunderstone_ore.getDefaultState());
            }
        }
    }
}
