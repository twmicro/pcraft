package com.twmicro.practical.structures;

import com.mojang.datafixers.Dynamic;
import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.structures.pieces.LegendaryBasePiece;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.function.Function;

public class LegendaryBase extends ScatteredStructure<NoFeatureConfig> {
    public LegendaryBase(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    protected int getSeedModifier() {
        return 165745296;
    }

    @Override
    public Structure.IStartFactory getStartFactory() {
        return LegendaryBase.Start::new;
    }

    @Override
    public String getStructureName() {
        return PracticalMod.BASE_LOC.toString();
    }

    @Override
    public int getSize() {
        return 1;
    }

    public class Start extends StructureStart {

        public Start(Structure<?> structIn, int int_1, int int_2, MutableBoundingBox mutableBB, int int_3, long long_1) {
            super(structIn, int_1, int_2, mutableBB, int_3, long_1);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            int worldX = chunkX * 16;
            int worldZ = chunkZ * 16;
            BlockPos blockpos = new BlockPos(worldX, 0, worldZ);
            this.components.add(new LegendaryBasePiece.Piece(templateManagerIn, PracticalMod.BASE_LOC, blockpos, Rotation.NONE, 1));
            this.recalculateStructureSize();
        }

    }
}
