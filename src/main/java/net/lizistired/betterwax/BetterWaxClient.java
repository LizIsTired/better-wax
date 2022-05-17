package net.lizistired.betterwax;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.lizistired.betterwax.utils.RegHelper;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class BetterWaxClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0xfedd89
        ));
        /*FluidRenderHandlerRegistry.INSTANCE.register(RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x0aff54
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0xff5263
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x52baff
        ));*/


        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RegHelper.STILL_LIQUIDWAX, RegHelper.FLOWING_LIQUIDWAX);

        //if you want to use custom textures they needs to be registered.
        //In this example this is unnecessary because the vanilla water textures are already registered.
        //To register your custom textures use this method.
        //ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
        //    registry.register(new Identifier("modid:block/custom_fluid_still"));
        //    registry.register(new Identifier("modid:block/custom_fluid_flowing"));
        //});

        // ...
    }
}
