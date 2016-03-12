package com.malqua.thunderstone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created by Malqua on 2/28/2016.
 */
public class ThunderstoneOre extends Block {

    public ThunderstoneOre(Material materialIn) {
        super(materialIn);
        
    }
//
//    /** Whether this fence connects in the northern direction */
//    public static final PropertyBool NORTH = PropertyBool.create("north");
//    /** Whether this fence connects in the eastern direction */
//    public static final PropertyBool EAST = PropertyBool.create("east");
//    /** Whether this fence connects in the southern direction */
//    public static final PropertyBool SOUTH = PropertyBool.create("south");
//    /** Whether this fence connects in the western direction */
//    public static final PropertyBool WEST = PropertyBool.create("west");
//
//    public boolean isOpaqueCube()
//    {
//        return false;
//    }
//
//    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
//    {
//        Block block = worldIn.getBlockState(pos).getBlock();
//        return block == Blocks.barrier ? false : ((!(block instanceof ThunderstoneOre) || block.getMaterial() != this.blockMaterial) && !(block instanceof BlockFenceGate) ? (block.getMaterial().isOpaque() && block.isFullCube() ? block.getMaterial() != Material.gourd : false) : true);
//    }
//
//    public int getMetaFromState(IBlockState state)
//    {
//        return 0;
//    }
//
//    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
//    {
//        return state.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north()))).withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east()))).withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south()))).withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
//    }
//
//    protected BlockState createBlockState()
//    {
//        return new BlockState(this, new IProperty[] {NORTH, EAST, WEST, SOUTH});
//    }
}
