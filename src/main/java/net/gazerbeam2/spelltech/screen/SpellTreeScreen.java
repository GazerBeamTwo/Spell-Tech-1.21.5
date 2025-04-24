package net.gazerbeam2.spelltech.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class SpellTreeScreen extends Screen {
    private final MinecraftClient client;
    private List<SpellTreeWidget> buttons = new ArrayList<>();

    public SpellTreeScreen(MinecraftClient client) {
        super(Text.of("Spell Trees"));
        this.client = client;
    }


    @Override
    protected void init() {

        String[] spellNames = {"Air Spell Tree", "Earth Spell Tree", "Fire Spell Tree", "Water Spell Tree",
                "Light Spell Tree", "Dark Spell Tree", "Void  Spell Tree", "Nature  Spell Tree", "Universal  Spell Tree"};
        Identifier[] bgTextures = {
                Identifier.of("spelltech", "textures/gui/icons/air_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/earth_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/fire_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/water_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/light_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/dark_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/void_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/nature_spell_tree.png"),
                Identifier.of("spelltech", "textures/gui/icons/universal_spell_tree.png"),
        };
        // Create buttons for each spell tree
        buttons.clear();
        for (int i = 0; i < 9; i++) {
            int y = 10 + i * 42;

            SpellTreeWidget button = new SpellTreeWidget(
                    -40, 0, y, 48, 32,
                    Text.empty(),
                    btn -> {
                        SpellTreeWidget thisBtn = (SpellTreeWidget) btn;
                        boolean alreadyPinned = thisBtn.isPinnedOpen();
                        for (SpellTreeWidget b : buttons) b.setPinnedOpen(false);
                        thisBtn.setPinnedOpen(!alreadyPinned);
                    },
                    bgTextures[i]
            );
            System.out.println("Drawing Texture: " + bgTextures[i]);
            buttons.add(button);
            addDrawableChild(button);
        }
    }

    // Handle when a button is clicked
    private void openSpellTree(int treeIndex) {
        System.out.println("Opening Spell Tree " + treeIndex);
        // Add logic to display the spell tree content
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        // Update positions based on hover
        for (SpellTreeWidget btn : buttons) {
            btn.update(mouseX, mouseY);
        }

        // Draw screen background
        this.renderBackground(context, mouseX, mouseY, delta);

        // Draw title
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);

        // Now render widgets normally
        super.render(context, mouseX, mouseY, delta);

        for (SpellTreeWidget btn : buttons) {
            btn.renderCustom(context);
        }


    }

    @Override
    public boolean shouldPause() {
        return false; // Don’t pause the game when this screen is open
    }
}