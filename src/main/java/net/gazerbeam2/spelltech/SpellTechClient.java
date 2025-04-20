package net.gazerbeam2.spelltech;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class SpellTechClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANA_CRYSTAL, RenderLayer.getCutout());
    }
}
