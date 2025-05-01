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
    private final String spellDes;
    private final SpellNode spellNode;
    private final boolean spellIsActive;
    private final boolean unlocked;

    public SpellNodeWidget(int x, int y, int width, int height, SpellNode spellNode, boolean unlocked, PressAction onPress) {
        super(x, y, width, height, Text.of(""), onPress, DEFAULT_NARRATION_SUPPLIER);
        this.spellName = spellNode.getName();
        this.spellNode = spellNode;
        this.icon = spellNode.getIcon();
        this.spellDes = spellNode.getDescription();
        this.spellId = spellNode.getId();
        this.spellIsActive = spellNode.getActive();
        this.unlocked = unlocked;

        this.active = unlocked; // only clickable if already unlocked or eligible for unlocking
    }

    public SpellNode getSpellNode() {
        return this.spellNode;
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

        // Draw a gray overlay if the spell is not unlocked but is eligible to be unlocked
        if (!unlocked) {
            context.fill(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), 0x88000000); // Semi-transparent gray
        }
    }

    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        renderCustom(context);
        String status = spellIsActive ? "§eActive§r" : "§7Passive§r";
        String req = unlocked ? "" : ", §4Requirements not met.§r";

        if (this.isHovered()) {
            context.drawTooltip(
                    MinecraftClient.getInstance().textRenderer,
                    Text.of(spellName + ": " + spellDes + " " + status + req),
                    mouseX, mouseY
            );
        }
    }

}