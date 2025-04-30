package net.gazerbeam2.spelltech.screen;

import net.gazerbeam2.spelltech.spelltree.SpellNode;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SpellNodeWidget extends ButtonWidget {
    private final Identifier icon;
    private final String spellId;
    private final String spellName;
    private final boolean unlocked;

    public SpellNodeWidget(int x, int y, int width, int height, SpellNode spellNode, boolean unlocked, PressAction onPress) {
        super(x, y, width, height, Text.of(""), onPress, DEFAULT_NARRATION_SUPPLIER);
        this.spellName = spellNode.getName();
        this.icon = spellNode.getIcon();
        this.spellId = spellNode.getId();
        this.unlocked = unlocked;
    }

    public void renderCustom(DrawContext context) {
        int alpha = unlocked ? 255 : 100;
        int color = (alpha << 24) | 0xFFFFFF; // RGBA
        context.drawTexture(
                RenderLayer::getGuiTextured,
                icon,
                this.getX(), this.getY(),
                0f, 0f,
                this.getWidth(), this.getHeight(),
                this.getWidth(), this.getHeight(),
                color
        );
    }

    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        renderCustom(context);

        if (this.isHovered()) {
            context.drawTooltip(
                    MinecraftClient.getInstance().textRenderer,
                    Text.of(spellName),
                    mouseX, mouseY
            );
        }
    }
}