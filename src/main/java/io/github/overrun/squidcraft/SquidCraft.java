package io.github.overrun.squidcraft;

import io.github.overrun.squidcraft.api.registry.BulkRegistry;
import io.github.overrun.squidcraft.block.Blocks;
import io.github.overrun.squidcraft.block.entity.BlockEntityTypes;
import io.github.overrun.squidcraft.cmd.Commands;
import io.github.overrun.squidcraft.config.Configs;
import io.github.overrun.squidcraft.fluid.Fluids;
import io.github.overrun.squidcraft.item.Items;
import io.github.overrun.squidcraft.world.Biomes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootTableRange;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext.EntityTarget;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class SquidCraft implements ModInitializer {
    public static final Logger logger = LogManager.getLogger();
    public static final String ID = "squidcraft";
    public static final Identifier SQUID_LOOT_TABLE_ID = new Identifier("entities/squid");

    @Override
    public void onInitialize() {
        BulkRegistry.registerFluid(Fluids.class);
        BulkRegistry.registerBlock(Blocks.class);
        BulkRegistry.registerBET(BlockEntityTypes.class);
        BulkRegistry.registerItem(Items.class);
        Biomes.register();
        addLootTables();
        Commands.register();
        Configs.init();
    }

    private LootTableRange range(int range) {
        return ConstantLootTableRange.create(range);
    }

    private LootFunction count(float min,
                               float max) {
        return SetCountLootFunction.builder(new UniformLootTableRange(min, max)).build();
    }

    private EntityPredicate onFire(boolean onFire) {
        return EntityPredicate.Builder.create().flags(
                EntityFlagsPredicate.Builder.create().onFire(onFire).build()
        ).build();
    }

    private LootFunction enchant(float min,
                                 float max) {
        return LootingEnchantLootFunction.builder(new UniformLootTableRange(min, max)).build();
    }

    private LootPoolEntry entry(ItemConvertible item) {
        return ItemEntry.builder(item).build();
    }

    private LootFunction smelt(EntityTarget target, boolean onFire) {
        return FurnaceSmeltLootFunction.builder().conditionally(
                EntityPropertiesLootCondition.builder(
                        target,
                        onFire(onFire)
                )
        ).build();
    }

    private void addLootTables() {
        LootTableLoadingCallback.EVENT.register((resourceManager,
                                                 lootManager,
                                                 id,
                                                 builder,
                                                 setter) -> {
            if (SQUID_LOOT_TABLE_ID.equals(id)) {
                builder.withPool(FabricLootPoolBuilder.builder()
                        .rolls(range(1))
                        .withFunction(count(1.0f, 3.0f))
                        .withFunction(smelt(EntityTarget.THIS, true))
                        .withFunction(enchant(0.0f, 1.0f))
                        .withEntry(entry(Items.SHREDDED_SQUID))
                        .build()
                );
            }
        });
    }
}
