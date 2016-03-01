package com.malqua.thunderstone.items;

import com.malqua.thunderstone.ThunderstoneMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Malqua on 2/29/2016.
 */
public class ItemThunderSword extends ItemSword {
    public ItemThunderSword(ToolMaterial material) {
        super(material);
    }

    public double chainRadius = 3;
    public int chainCountMax = 3;

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker){
        Vec3 targetPos = target.getPositionVector();
        Vec3 origin = new Vec3(targetPos.xCoord, targetPos.yCoord + target.getEyeHeight()/2, targetPos.zCoord);
        AxisAlignedBB aabb = target.getEntityBoundingBox();
        double size = aabb.maxX - aabb.minX;
        aabb = aabb.contract(size,size,size);
        aabb = aabb.expand(chainRadius, chainRadius, chainRadius);

        List<EntityLivingBase> entitiesWithinAABB = attacker.worldObj.getEntitiesWithinAABB(target.getClass(), aabb);

        entitiesWithinAABB.sort(new Comparator<EntityLivingBase>() {
            @Override
            public int compare(EntityLivingBase o1, EntityLivingBase o2) {
                double dist0 = o1.getPositionVector().subtract(origin).lengthVector();
                double dist1 = o2.getPositionVector().subtract(origin).lengthVector();
                return (dist0 < dist1) ? -1 : 1;
            }
        });

        int count = MathHelper.clamp_int(entitiesWithinAABB.size(), 0, chainCountMax);
        for (int i = 0; i < count; i++){
            EntityLivingBase elb = entitiesWithinAABB.get(i);
            elb.attackEntityFrom(DamageSource.generic, 1);
            Vec3 pos = elb.getPositionVector();
            Vec3 motion = new Vec3(pos.xCoord - origin.xCoord, pos.yCoord - origin.yCoord, pos.zCoord - origin.zCoord);
            double distance = motion.lengthVector();
            motion = new Vec3(motion.normalize().xCoord * distance * distance, motion.normalize().yCoord, motion.normalize().zCoord * distance * distance);
            World world = attacker.worldObj;
            if(!world.isRemote) {
                ThunderstoneMod.proxy.SpawnParticle(world, origin, motion);
            }

        }

        return super.hitEntity(stack, target, attacker);
    }
}
