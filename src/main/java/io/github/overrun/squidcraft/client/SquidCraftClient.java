package io.github.overrun.squidcraft.client;

import io.github.overrun.squidcraft.block.Blocks;
import io.github.overrun.squidcraft.screen.CompressorScreen;
import io.github.overrun.squidcraft.screen.ScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

import static io.github.overrun.squidcraft.SquidCraft.ID;
import static io.github.overrun.squidcraft.fluid.Fluids.FLOWING_MILK;
import static io.github.overrun.squidcraft.fluid.Fluids.STILL_MILK;
import static net.minecraft.resource.ResourceType.CLIENT_RESOURCES;
import static net.minecraft.screen.PlayerScreenHandler.BLOCK_ATLAS_TEXTURE;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class SquidCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        setupFluidRendering(STILL_MILK, FLOWING_MILK, new Identifier(ID, "milk"), 0xf5fffa);
        ScreenRegistry.register(ScreenHandlers.COMPRESSOR_SCREEN_HANDLER, CompressorScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.COMPRESSOR_BLOCK, RenderLayer.getCutout());
    }

    public static void setupFluidRendering(final Fluid still,
                                           final Fluid flowing,
                                           final Identifier textureFluidId,
                                           final int color) {
        final Identifier stillSpriteId = new Identifier(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_still");
        final Identifier flowingSpriteId = new Identifier(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_flow");

        // If they're not already present, add the sprites to the block atlas
        ClientSpriteRegistryCallback.event(BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(stillSpriteId);
            registry.register(flowingSpriteId);
        });

        final Identifier fluidId = Registry.FLUID.getId(still);
        final Identifier listenerId = new Identifier(fluidId.getNamespace(), fluidId.getPath() + "_reload_listener");

        final Sprite[] fluidSprites = {null, null};

        ResourceManagerHelper.get(CLIENT_RESOURCES).registerReloadListener((FluidResourceRL) manager -> {
            if (manager == null) {
                return listenerId;
            }
            final Function<Identifier, Sprite> atlas =
                    MinecraftClient.getInstance().getSpriteAtlas(BLOCK_ATLAS_TEXTURE);
            fluidSprites[0] = atlas.apply(stillSpriteId);
            fluidSprites[1] = atlas.apply(flowingSpriteId);
            return null;
        });

        // The FluidRenderer gets the sprites and color from a FluidRenderHandler during rendering
        final FluidRenderHandler renderHandler =
                (CombFluidRH) (view, pos, state) -> new Pair<>(fluidSprites, color);

        FluidRenderHandlerRegistry.INSTANCE.register(still, renderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(flowing, renderHandler);
    }
}
