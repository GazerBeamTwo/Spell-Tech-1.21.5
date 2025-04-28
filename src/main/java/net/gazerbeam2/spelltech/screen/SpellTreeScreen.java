package net.gazerbeam2.spelltech.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.gazerbeam2.spelltech.SpellTech;
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
    private String selectedTree; // Default selected tree
    private List<SpellNodeWidget> spellNodes = new ArrayList<>();

    public SpellTreeScreen(MinecraftClient client) {
        super(Text.of("Spell Trees"));
        this.client = client;
    }

    private void loadSpellTree(String treeName) {
        spellNodes.clear();

        int startX = 150; // Leave space for tree buttons on the left
        int spacingX = 60;
        int yBasic = 100, yIntermediate = 40, yAdvanced = 40, yMaster = 100, yUltimate = 160;

        if (treeName.equals("Air")) {
            addTier("air_basic", 3, startX, yBasic, spacingX);
            addTier("air_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("air_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("air_master", 3, startX + 300, yMaster, spacingX);
            addTier("air_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Earth")) {
            addTier("earth_basic", 3, startX, yBasic, spacingX);
            addTier("earth_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("earth_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("earth_master", 3, startX + 300, yMaster, spacingX);
            addTier("earth_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Fire")) {
            addTier("fire_basic", 3, startX, yBasic, spacingX);
            addTier("fire_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("fire_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("fire_master", 3, startX + 300, yMaster, spacingX);
            addTier("fire_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Water")) {
            addTier("water_basic", 3, startX, yBasic, spacingX);
            addTier("water_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("water_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("water_master", 3, startX + 300, yMaster, spacingX);
            addTier("water_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Light")) {
            addTier("light_basic", 3, startX, yBasic, spacingX);
            addTier("light_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("light_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("light_master", 3, startX + 300, yMaster, spacingX);
            addTier("light_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Dark")) {
            addTier("dark_basic", 3, startX, yBasic, spacingX);
            addTier("dark_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("dark_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("dark_master", 3, startX + 300, yMaster, spacingX);
            addTier("dark_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Nature")) {
            addTier("nature_basic", 3, startX, yBasic, spacingX);
            addTier("nature_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("nature_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("nature_master", 3, startX + 300, yMaster, spacingX);
            addTier("nature_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Void")) {
            addTier("void_basic", 3, startX, yBasic, spacingX);
            addTier("void_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("void_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("void_master", 3, startX + 300, yMaster, spacingX);
            addTier("void_ultimate", 1, startX + 400, yUltimate, spacingX);
        } else if (treeName.equals("Universal")) {
            addTier("universal_basic", 3, startX, yBasic, spacingX);
            addTier("universal_intermediate", 5, startX + 100, yIntermediate, spacingX);
            addTier("universal_advanced", 5, startX + 200, yAdvanced, spacingX);
            addTier("universal_master", 3, startX + 300, yMaster, spacingX);
            addTier("universal_ultimate", 1, startX + 400, yUltimate, spacingX);
        }
    }

    private void addTier(String tierName, int count, int startX, int y, int spacingX) {
        for (int i = 0; i < count; i++) {
            int setY = y + i * spacingX;
            Identifier icon = Identifier.of(SpellTech.MOD_ID, "textures/gui/spells/" + tierName + "_" + i + ".png");

            SpellNodeWidget node = new SpellNodeWidget(startX, setY, 48, 48, tierName + "_" + i, icon, btn -> {
                System.out.println("Clicked " + tierName + " spell ");
            });

            spellNodes.add(node);
            addDrawableChild(node);
        }
    }

    @Override
    protected void init() {
        buttons.clear();
        spellNodes.clear();

        String[] spellNames = {"Air", "Earth", "Fire", "Water",
                "Light", "Dark", "Void", "Nature", "Universal"};
        Identifier[] bgTextures = {
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/air_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/earth_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/fire_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/water_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/light_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/dark_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/void_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/nature_spell_tree.png"),
                Identifier.of(SpellTech.MOD_ID, "textures/gui/icons/universal_spell_tree.png"),
        };


        for (int i = 0; i < spellNames.length; i++) {
            int y = 10 + i * 42;
            String treeName = spellNames[i];

            SpellTreeWidget button = new SpellTreeWidget(
                    -24, 0, y, 48, 32,
                    Text.empty(),
                    btn -> {
                        SpellTreeWidget thisBtn = (SpellTreeWidget) btn;
                        boolean alreadyPinned = thisBtn.isPinnedOpen();

                        for (SpellTreeWidget b : buttons) b.setPinnedOpen(false);
                        thisBtn.setPinnedOpen(!alreadyPinned);

                        this.selectedTree = treeName;
                        loadSpellTree(treeName);

                    },
                    bgTextures[i],
                    treeName // Pass spell tree name
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

        // Draw title
        context.drawCenteredTextWithShadow(this.textRenderer, selectedTree, this.width / 2, 20, 0xFFFFFF);

        // Now render widgets normally
        super.render(context, mouseX, mouseY, delta);

//        // Draw screen background
//        renderBackgroundTexture(
//                context,
//                Identifier.of(SpellTech.MOD_ID, "textures/gui/bg/void_spell_tree.png"),
//                0, 0,
//                0f, 0f,
//                1920, 1080
//        );

        // Draw lines between spell nodes
//        renderConnections(context);

        for (SpellNodeWidget node : spellNodes) {
            node.renderCustom(context);
        }

        for (SpellTreeWidget btn : buttons) {
            btn.renderCustom(context);
        }
    }

//    private void renderConnections(DrawContext context) {
//        MatrixStack matrices = context.getMatrices();
//        matrices.push(); // Always push before manipulating
//
//        // Get matrix for buffer vertex
//        Matrix4f matrix = matrices.peek().getPositionMatrix();
//
//        // Prepare tessellator and buffer
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder buffer = tessellator.begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
//
//        // Set shader — required!;
//        RenderSystem.setShaderColor(1f, 1f, 1f, 1f); // White
//
//        for (int i = 0; i < spellNodes.size() - 1; i++) {
//            SpellNodeWidget nodeA = spellNodes.get(i);
//            SpellNodeWidget nodeB = spellNodes.get(i + 1);
//
//            int xA = nodeA.getX() + nodeA.getWidth() / 2;
//            int yA = nodeA.getY() + nodeA.getHeight() / 2;
//            int xB = nodeB.getX() + nodeB.getWidth() / 2;
//            int yB = nodeB.getY() + nodeB.getHeight() / 2;
//
//            buffer.vertex(matrix, xA, yA, 0).color(255, 255, 255, 255);
//            buffer.vertex(matrix, xB, yB, 0).color(255, 255, 255, 255);
//        }
//
//        matrices.pop(); // Restore matrix
//
//    }

    @Override
    public boolean shouldPause() {
        return false; // Don’t pause the game when this screen is open
    }
}