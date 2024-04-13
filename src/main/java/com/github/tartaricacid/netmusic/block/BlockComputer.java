package com.github.tartaricacid.netmusic.block;

import com.github.tartaricacid.netmusic.inventory.ComputerMenu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockComputer extends HorizontalBlock {
    protected static final VoxelShape NORTH_AABB = makeShape();
    protected static final VoxelShape SOUTH_AABB = rotateShape(Direction.SOUTH, Direction.NORTH, NORTH_AABB);
    protected static final VoxelShape EAST_AABB = rotateShape(Direction.SOUTH, Direction.EAST, NORTH_AABB);
    protected static final VoxelShape WEST_AABB = rotateShape(Direction.NORTH, Direction.EAST, NORTH_AABB);

    public BlockComputer() {
        super(Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(0.5f).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    private static VoxelShape makeShape() {
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0.40625, 1, 0.3125, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.1875, 0.3125, 0.40625, 0.8125, 0.375, 0.875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.125, 0.375, 0.53125, 0.875, 0.84375, 0.9375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.1250625, 0.5608175, 0.47502125, 0.8749375, 0.9356925, 0.88114625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.1875, 0.4375, 0.40625, 0.8125, 0.9375, 0.59375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.0625, 0.3125, 0.34375, 0.9375, 0.4375, 0.59375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.0625, 0.9375, 0.34375, 0.9375, 1.0625, 0.59375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.8125, 0.4375, 0.34375, 0.9375, 0.9375, 0.59375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.0625, 0.4375, 0.34375, 0.1875, 0.9375, 0.59375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.0625, 0.03125, 1, 0.1875, 0.375), IBooleanFunction.OR);
        return shape;
    }

    private static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};
        int times = (to.ordinal() - from.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1], VoxelShapes.create(new AxisAlignedBB(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX))));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }
        return buffer[0];
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, direction);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case SOUTH:
                return SOUTH_AABB;
            case EAST:
                return EAST_AABB;
            case WEST:
                return WEST_AABB;
            default:
                return NORTH_AABB;
        }
    }

    @Override
    public ActionResultType use(BlockState blockState, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (level.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            player.openMenu(blockState.getMenuProvider(level, pos));
            return ActionResultType.CONSUME;
        }
    }

    @Override
    public INamedContainerProvider getMenuProvider(BlockState blockState, World worldIn, BlockPos blockPos) {
        return new SimpleNamedContainerProvider((id, inventory, player) -> new ComputerMenu(id, inventory), new StringTextComponent("computer"));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader level, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("block.netmusic.computer.web_link.desc").withStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("block.netmusic.computer.local_file.desc").withStyle(TextFormatting.GRAY));
    }
}
