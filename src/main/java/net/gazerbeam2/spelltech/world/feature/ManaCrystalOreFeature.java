package net.gazerbeam2.spelltech.world.feature;

import com.mojang.serialization.Codec;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class ManaCrystalOreFeature extends Feature<OreFeatureConfig> {
    public ManaCrystalOreFeature(Codec<OreFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<OreFeatureConfig> context) {

        WorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos origin = context.getOrigin();
        OreFeatureConfig config = context.getConfig();

        float angle = random.nextFloat() * (float)Math.PI;
        float veinSize = config.size;
        double dx = origin.getX() + 8 + Math.sin(angle) * veinSize / 8.0;
        double dx2 = origin.getX() + 8 - Math.sin(angle) * veinSize / 8.0;
        double dz = origin.getZ() + 8 + Math.cos(angle) * veinSize / 8.0;
        double dz2 = origin.getZ() + 8 - Math.cos(angle) * veinSize / 8.0;
        double dy = origin.getY() + random.nextInt(3) - 2;
        double dy2 = origin.getY() + random.nextInt(3) - 2;

        for (int i = 0; i <= veinSize; ++i) {
            float t = (float)i / (float)veinSize;
            double x = dx + (dx2 - dx) * t;
            double y = dy + (dy2 - dy) * t;
            double z = dz + (dz2 - dz) * t;
            double fuzz = random.nextDouble() * veinSize / 16.0;
            double rX = (Math.sin(Math.PI * t) + 1.0) * fuzz + 1;
            double rY = (Math.sin(Math.PI * t) + 1.0) * fuzz + 1;

            int minX = (int)(x - rX / 2);
            int minY = (int)(y - rY / 2);
            int minZ = (int)(z - rX / 2);
            int maxX = (int)(x + rX / 2);
            int maxY = (int)(y + rY / 2);
            int maxZ = (int)(z + rX / 2);

            for (int bx = minX; bx <= maxX; ++bx) {
                double dX = (bx + 0.5 - x) / (rX / 2.0);
                if (dX * dX >= 1.0) continue;

                for (int by = minY; by <= maxY; ++by) {
                    double dY = (by + 0.5 - y) / (rY / 2.0);
                    if (dX * dX + dY * dY >= 1.0) continue;

                    for (int bz = minZ; bz <= maxZ; ++bz) {
                        double dZ = (bz + 0.5 - z) / (rX / 2.0);
                        if (dX * dX + dY * dY + dZ * dZ >= 1.0) continue;

                        BlockPos pos = new BlockPos(bx, by, bz);
                        BlockState currentState = world.getBlockState(pos);

                        for (OreFeatureConfig.Target target : config.targets) {
                            if (target.target.test(currentState, context.getRandom())) {
                                world.setBlockState(pos, ModBlocks.MANA_CRYSTAL_BLOCK.getDefaultState(), Block.NOTIFY_ALL);

                                // Cluster generation around each placed ore
                                for (Direction dir : Direction.values()) {
                                    BlockPos adjacent = pos.offset(dir);
                                    if (world.getBlockState(adjacent).isAir() && random.nextFloat() < 0.3f) {
                                        BlockState cluster = ModBlocks.MANA_CRYSTAL.getDefaultState()
                                                .with(AmethystClusterBlock.FACING, dir);
                                        world.setBlockState(adjacent, cluster, Block.NOTIFY_ALL);
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
