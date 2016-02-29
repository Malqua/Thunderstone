package com.malqua.thunderstone.proxy;

import com.malqua.thunderstone.init.ThunderstoneBlocks;
import com.malqua.thunderstone.init.ThunderstoneEntities;
import com.malqua.thunderstone.init.ThunderstoneItems;

/**
 * Created by Malqua on 2/25/2016.
 */
public class ClientProxy extends CommonProxy{
    @Override
    public void registerRenders(){
        ThunderstoneItems.registerRenders();
        ThunderstoneEntities.registerRenders();
        ThunderstoneBlocks.registerRenders();
    }
}
