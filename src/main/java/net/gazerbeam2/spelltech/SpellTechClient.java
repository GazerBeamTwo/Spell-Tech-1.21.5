package net.gazerbeam2.spelltech;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.gazerbeam2.spelltech.screen.SpellTreeScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class SpellTechClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANA_CRYSTAL, RenderLayer.getCutout());

        KeyBinding openSpellTreeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.spelltech.openspelltree",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.spelltech"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openSpellTreeKey.wasPressed()) {
                client.setScreen(new SpellTreeScreen(client));
            }
        });
    }

}
