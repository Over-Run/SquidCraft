package io.github.overrun.squidcraft.config;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.IOException;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author squid233
 * @since 2021/02/02
 */
public final class CobblestoneFarmRoll {
    private String block;
    private int percent;

    public CobblestoneFarmRoll(String block, int percent) {
        this.block = block;
        this.percent = percent;
    }

    public CobblestoneFarmRoll() {
        this("air", 0);
    }

    public String getBlock() {
        return block;
    }

    public Block getAsBlock() {
        return Registry.BLOCK.get(new Identifier(getBlock()));
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CobblestoneFarmRoll roll = (CobblestoneFarmRoll) o;
        return getPercent() == roll.getPercent() && Objects.equals(getBlock(), roll.getBlock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlock(), getPercent());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CobblestoneFarmRoll.class.getSimpleName() + "[", "]")
                .add("block='" + block + "'")
                .add("percent=" + percent)
                .toString();
    }

    public static final class Serializer {
        public static void write(JsonWriter out, CobblestoneFarmRoll value) throws IOException {
            out.beginObject().name("block").value(value.getBlock()).name("percent").value(value.getPercent()).endObject();
        }

        public static CobblestoneFarmRoll read(JsonReader in) throws IOException {
            CobblestoneFarmRoll roll = new CobblestoneFarmRoll();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "block":
                        roll.setBlock(in.nextString());
                        break;
                    case "percent":
                        roll.setPercent(in.nextInt());
                        break;
                    default:
                }
            }
            in.endObject();
            return roll;
        }
    }
}
