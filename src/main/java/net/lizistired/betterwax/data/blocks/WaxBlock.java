package net.lizistired.betterwax.data.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import static net.lizistired.betterwax.utils.RegHelper.*;

import java.util.Random;

public class WaxBlock extends TransparentBlock {

    public WaxBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.afterBreak(world, player, pos, state, blockEntity, stack);
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            if (world.getDimension().isUltrawarm()) {
                world.removeBlock(pos, false);
                return;
            }
            Material material = world.getBlockState(pos.down()).getMaterial();
            if (material.blocksMovement() || material.isLiquid()) {
                world.setBlockState(pos, LIQUID_WAX.getDefaultState());
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity(world, pos)) {
            this.melt(state, world, pos);
        }
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().isUltrawarm()) {
            world.removeBlock(pos, false);
            return;
        }
        world.setBlockState(pos, LIQUID_WAX.getDefaultState());
        world.updateNeighbor(pos, LIQUID_WAX, pos);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }
}
