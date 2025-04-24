package net.gazerbeam2.spelltech.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpellTreeWidget extends ButtonWidget {
    private final Identifier backgroundTexture;
    private final int collapsedX;
    private final int expandedX;
    private boolean isHovered = false;
    private boolean isPinnedOpen = false;
    private int targetX;
    private int currentX;

    public void setPinnedOpen(boolean pinned) {
        this.isPinnedOpen = pinned;
        System.out.println("Button [" + getMessage().getString() + "] pinned: " + pinned);
    }

    public boolean isPinnedOpen() {
        return isPinnedOpen;
    }

    public SpellTreeWidget(int collapsedX, int expandedX, int y, int width, int height, Text message, PressAction onPress, Identifier backgroundTexture) {
        super(collapsedX, y, width, height, message, onPress, DEFAULT_NARRATION_SUPPLIER);
        this.backgroundTexture = backgroundTexture;
        this.collapsedX = collapsedX;
        this.expandedX = expandedX;
        this.currentX = collapsedX;
        this.targetX = collapsedX;
        this.setPosition(currentX, y);
    }

    public void renderCustom(DrawContext context) {
        context.drawTexture(
                RenderLayer::getGuiTextured,
                this.backgroundTexture,
                this.getX(), this.getY(),
                0f, 0f,
                this.getWidth(), this.getHeight(),
                this.getWidth(), this.getHeight(),
                0xFFFFFFFF
        );
    }

    public void update(int mouseX, int mouseY) {
        // First, apply current position
        this.setPosition((int) currentX, this.getY());

        isHovered = this.isMouseOver(mouseX, mouseY);

        if (isPinnedOpen || isHovered) {
            targetX = expandedX;
        } else {
            targetX = collapsedX;
        }

        currentX += (targetX - currentX) * 0.2;
        this.setPosition((int) currentX, this.getY());
    }
}