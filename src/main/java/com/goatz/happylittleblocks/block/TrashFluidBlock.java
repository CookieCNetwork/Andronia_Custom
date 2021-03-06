package com.goatz.happylittleblocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

public class TrashFluidBlock extends FlowingFluidBlock {
    public TrashFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
        super(supplier, properties);
    }
    @ParametersAreNonnullByDefault
    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof LivingEntity)
        {
            ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 200, 0));
            ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
        }
    }
}
