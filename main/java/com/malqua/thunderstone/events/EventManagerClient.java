package com.malqua.thunderstone.events;

import com.malqua.thunderstone.entity.EntityThunderBolt;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Malqua on 2/26/2016.
 */
@SideOnly(Side.CLIENT)
public class EventManagerClient {

    public static World getWorld() {
        return FMLClientHandler.instance().getClient().theWorld;
    }

    public static void nbtSyncFromServer(NBTTagCompound parNBT){
        String command = parNBT.getString("command");

        switch(command){
            case "syncThunderBolt": {
                NBTTagCompound nbt = parNBT.getCompoundTag("data");

                int posXS = nbt.getInteger("posX");
                int posYS = nbt.getInteger("posY");
                int posZS = nbt.getInteger("posZ");

                double posX = (double) posXS;// / 32D;
                double posY = (double) posYS;// / 32D;
                double posZ = (double) posZS;// / 32D;

                EntityThunderBolt ent = new EntityThunderBolt(getWorld(), posX, posY, posZ);
                ent.serverPosX = posXS;
                ent.serverPosY = posYS;
                ent.serverPosZ = posZS;
                ent.rotationYaw = 0.0F;
                ent.rotationPitch = 0.0F;
                ent.setEntityId(nbt.getInteger("entityID"));
                getWorld().addWeatherEffect(ent);
                break;
            }
            case "syncLightningBolt": {
                NBTTagCompound nbt = parNBT.getCompoundTag("data");

                int posXS = nbt.getInteger("posX");
                int posYS = nbt.getInteger("posY");
                int posZS = nbt.getInteger("posZ");

                double posX = (double) posXS;// / 32D;
                double posY = (double) posYS;// / 32D;
                double posZ = (double) posZS;// / 32D;

                EntityLightningBolt ent = new EntityLightningBolt(getWorld(), posX, posY, posZ);
                ent.serverPosX = posXS;
                ent.serverPosY = posYS;
                ent.serverPosZ = posZS;
                ent.rotationYaw = 0.0F;
                ent.rotationPitch = 0.0F;
                ent.setEntityId(nbt.getInteger("entityID"));
                getWorld().addWeatherEffect(ent);
                break;
            }
            default:
                return;
        }
    }
}
