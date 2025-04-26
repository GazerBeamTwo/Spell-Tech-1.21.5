package net.gazerbeam2.spelltech.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SpellNodeWidget extends ButtonWidget {
    private final Identifier icon;
    private final String spellId;

    public SpellNodeWidget(int x, int y, int width, int height, String spellId, Identifier icon, PressAction onPress) {
        super(x, y, width, height, Text.of(""), onPress, DEFAULT_NARRATION_SUPPLIER);
        this.icon = icon;
        this.spellId = spellId;
    }

    public void renderCustom(DrawContext context) {
        context.drawTexture(
                RenderLayer::getGuiTextured,
                icon,
                this.getX(), this.getY(),
                0f, 0f,
                this.getWidth(), this.getHeight(),
                this.getWidth(), this.getHeight(),
                0xFFFFFFFF
        );
    }

    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        renderCustom(context);
    }
}