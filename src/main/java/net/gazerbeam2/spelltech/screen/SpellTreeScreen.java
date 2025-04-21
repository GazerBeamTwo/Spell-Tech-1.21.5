package net.gazerbeam2.spelltech.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

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
        // Create buttons for each spell tree
        buttons.clear();
        for (int i = 0; i < 9; i++) {
            int index = i;
            int y = 10 + i * 50;
            SpellTreeWidget button = new SpellTreeWidget(
                    -90, 0, y, 100, 40,
                    Text.of("Spell Tree " + (index + 1)),
                    btn -> {
                        System.out.println("Clicked Spell Tree " + (index + 1));

                        SpellTreeWidget thisBtn = (SpellTreeWidget) btn;

                        boolean alreadyPinned = thisBtn.isPinnedOpen();

                        for (SpellTreeWidget b : buttons) {
                            b.setPinnedOpen(false);
                        }

                        // Toggle the clicked button
                        thisBtn.setPinnedOpen(!alreadyPinned);
                    }
            );
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

        this.renderBackground(context, mouseX, mouseY, delta); // updated to use DrawContext
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);

        // Let buttons draw themselves
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false; // Don’t pause the game when this screen is open
    }
}