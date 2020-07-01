package com.twmicro.practical.world.gen;

import com.twmicro.practical.types.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {
    private static final CountRangeConfig copper_cfg = new CountRangeConfig(15,0,0,255);
    private static final int copper_veinsize = 4;

    public static void setup(){
        ForgeRegistries.BIOMES.getValues().stream()
                .filter(biome -> biome.getCategory() != Biome.Category.THEEND)
                .filter(biome -> biome.getCategory() != Biome.Category.NETHER)
                .forEach(biome -> {
                    biome.addFeature(
                            GenerationStage.Decoration.UNDERGROUND_DECORATION,
                            Feature.ORE.withConfiguration(
                                    new OreFeatureConfig(
                                            OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                            ModBlocks.RUBY_SHARD_ORE.getDefaultState(),
                                            copper_veinsize
                                    )
                            )
                                    .withPlacement(Placement.COUNT_RANGE.configure(copper_cfg))
                    );
                });
    }
}
