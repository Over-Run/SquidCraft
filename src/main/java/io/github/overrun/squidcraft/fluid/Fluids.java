package io.github.overrun.squidcraft.fluid;

import io.github.overrun.squidcraft.api.registry.BulkRegistry;
import net.minecraft.fluid.FlowableFluid;

import static io.github.overrun.squidcraft.SquidCraft.ID;

/**
 * @author squid233
 * @since 0.12.0
 */
@BulkRegistry.ModID(ID)
public class Fluids {
    @BulkRegistry.Name("milk")
    public static final FlowableFluid STILL_MILK = new MilkFluid.Still();
    public static final FlowableFluid FLOWING_MILK = new MilkFluid.Flowing();
}
