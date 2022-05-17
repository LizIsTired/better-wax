package net.lizistired.betterwax.utils;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lizistired.betterwax.data.blocks.WaxBlock;
import net.lizistired.betterwax.data.blocks.liquids.LiquidWax;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.lizistired.betterwax.BetterWax.namespace;

public class RegHelper {

    public static Block WAX_BLOCK = new WaxBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT, MapColor.YELLOW).ticksRandomly().strength(0.5f).sounds(BlockSoundGroup.CANDLE));
    public static Block BLACK_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.BLACK));
    public static Block BLUE_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.BLUE));
    public static Block BROWN_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.BROWN));
    public static Block CYAN_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.CYAN));
    public static Block GRAY_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.GRAY));
    public static Block GREEN_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.GREEN));
    public static Block LIGHT_BLUE_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.LIGHT_BLUE));
    public static Block LIGHT_GRAY_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.LIGHT_GRAY));
    public static Block LIME_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.LIME));
    public static Block MAGENTA_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.MAGENTA));
    public static Block ORANGE_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.ORANGE));
    public static Block PINK_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.PINK));
    public static Block PURPLE_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.PURPLE));
    public static Block RED_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.RED));
    public static Block WHITE_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.WHITE));
    public static Block YELLOW_WAX_BLOCK = new WaxBlock(FabricBlockSettings.copyOf(WAX_BLOCK).mapColor(MapColor.YELLOW));



    public static final ItemGroup BETTERWAX_GROUP = FabricItemGroupBuilder.create(new Identifier(namespace, "betterwax")).stacksForDisplay(itemStacks -> Registry.ITEM.forEach(item -> {
        if (Registry.ITEM.getId(item).getNamespace().equals(namespace)) {
            itemStacks.add(new ItemStack(item));
        }
    })).icon(() -> new ItemStack(WAX_BLOCK)).build();
    public static FlowableFluid STILL_LIQUIDWAX;
    public static FlowableFluid FLOWING_LIQUIDWAX;
    public static Item WAX_BUCKET = new BucketItem(STILL_LIQUIDWAX, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1));
    public static Block LIQUID_WAX;


    public void RegisterEverything(){
        registerBlocks();
        registerFluids();
        registerItems();
    }

    void registerBlocks(){
        WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "wax_block"), WAX_BLOCK);
        BLACK_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "black_wax_block"), BLACK_WAX_BLOCK);
        BLUE_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "blue_wax_block"), BLUE_WAX_BLOCK);
        BROWN_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "brown_wax_block"), BROWN_WAX_BLOCK);
        CYAN_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "cyan_wax_block"), CYAN_WAX_BLOCK);
        GRAY_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "gray_wax_block"), GRAY_WAX_BLOCK);
        GREEN_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "green_wax_block"), GREEN_WAX_BLOCK);
        LIGHT_BLUE_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "light_blue_wax_block"), LIGHT_BLUE_WAX_BLOCK);
        LIGHT_GRAY_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "light_gray_wax_block"), LIGHT_GRAY_WAX_BLOCK);
        LIME_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "lime_wax_block"), LIME_WAX_BLOCK);
        MAGENTA_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "magenta_wax_block"), MAGENTA_WAX_BLOCK);
        ORANGE_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "orange_wax_block"), ORANGE_WAX_BLOCK);
        PINK_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "pink_wax_block"), PINK_WAX_BLOCK);
        PURPLE_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "purple_wax_block"), PURPLE_WAX_BLOCK);
        RED_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "red_wax_block"), RED_WAX_BLOCK);
        WHITE_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "white_wax_block"), WHITE_WAX_BLOCK);
        YELLOW_WAX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(namespace, "yellow_wax_block"), YELLOW_WAX_BLOCK);
    }

    void registerFluids(){
        STILL_LIQUIDWAX = Registry.register(Registry.FLUID, new Identifier(namespace, "still_liquidwax"), new LiquidWax.Still());
        FLOWING_LIQUIDWAX = Registry.register(Registry.FLUID, new Identifier(namespace, "flowing_liquidwax"), new LiquidWax.Flowing());
        LIQUID_WAX = Registry.register(Registry.BLOCK, new Identifier(namespace, "liquid_wax"), new FluidBlock(STILL_LIQUIDWAX, FabricBlockSettings.copy(Blocks.WATER)){});
    }
    void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(namespace, "wax_block"), new BlockItem(WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "black_wax_block"), new BlockItem(BLACK_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "blue_wax_block"), new BlockItem(BLUE_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "brown_wax_block"), new BlockItem(BROWN_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "cyan_wax_block"), new BlockItem(CYAN_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "gray_wax_block"), new BlockItem(GRAY_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "green_wax_block"), new BlockItem(GREEN_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "light_blue_wax_block"), new BlockItem(LIGHT_BLUE_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "light_gray_wax_block"), new BlockItem(LIGHT_GRAY_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "lime_wax_block"), new BlockItem(LIME_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "magenta_wax_block"), new BlockItem(MAGENTA_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "orange_wax_block"), new BlockItem(ORANGE_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "pink_wax_block"), new BlockItem(PINK_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "purple_wax_block"), new BlockItem(PURPLE_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "red_wax_block"), new BlockItem(RED_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "white_wax_block"), new BlockItem(WHITE_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_wax_block"), new BlockItem(YELLOW_WAX_BLOCK, new FabricItemSettings().group(BETTERWAX_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(namespace, "wax_bucket"), WAX_BUCKET);
    }
}
