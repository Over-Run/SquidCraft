package io.github.overrun.squidcraft.config;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.util.Objects;
import java.util.StringJoiner;

import static net.minecraft.util.registry.Registry.ITEM;

/**
 * @author squid233
 * @since 2021/02/02
 */
public final class CompressorRecipe {
    private Entry in;
    private Entry out;

    public CompressorRecipe(Entry in, Entry out) {
        this.in = in;
        this.out = out;
    }

    public CompressorRecipe() {
        this(new Entry(), new Entry());
    }

    public Entry getInput() {
        return in;
    }

    public void setInput(Entry in) {
        this.in = in;
    }

    public Entry getOutput() {
        return out;
    }

    public void setOutput(Entry out) {
        this.out = out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CompressorRecipe that = (CompressorRecipe) o;
        return Objects.equals(in, that.in) && Objects.equals(out, that.out);
    }

    @Override
    public int hashCode() {
        return Objects.hash(in, out);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CompressorRecipe.class.getSimpleName() + "[", "]")
                .add("in=" + in)
                .add("out=" + out)
                .toString();
    }

    public static final class Serializer {
        public static void write(JsonWriter out, CompressorRecipe value) throws IOException {
            out.beginObject().name("in");
            Entry.Serializer.write(out, value.getInput());
            out.name("out");
            Entry.Serializer.write(out, value.getOutput());
            out.endObject();
        }

        public static CompressorRecipe read(JsonReader in) throws IOException {
            CompressorRecipe recipe = new CompressorRecipe();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "in":
                        recipe.setInput(Entry.Serializer.read(in));
                        break;
                    case "out":
                        recipe.setOutput(Entry.Serializer.read(in));
                        break;
                    default:
                }
            }
            in.endObject();
            return recipe;
        }
    }

    public static final class Entry {
        private String item;
        private int count;

        public Entry(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public Entry(String item) {
            this(item, 1);
        }

        public Entry(ItemConvertible item, int count) {
            this.item = ITEM.getId(item.asItem()).toString();
            this.count = count;
        }

        public Entry(ItemConvertible item) {
            this(item, 1);
        }

        public Entry() {
            this("air");
        }

        public String getItem() {
            return item;
        }

        public Item getAsItem() {
            return ITEM.get(new Identifier(getItem()));
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Entry e = (Entry) o;
            return getCount() == e.getCount() && Objects.equals(getItem(), e.getItem());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getItem(), getCount());
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Entry.class.getSimpleName() + "[", "]")
                    .add("item='" + item + "'")
                    .add("count=" + count)
                    .toString();
        }

        public static final class Serializer {
            public static void write(JsonWriter out, Entry value) throws IOException {
                out.beginObject().name("item").value(value.getItem()).name("count").value(value.getCount()).endObject();
            }

            public static Entry read(JsonReader in) throws IOException {
                Entry e = new Entry();
                in.beginObject();
                while (in.hasNext()) {
                    switch (in.nextName()) {
                        case "item":
                            e.setItem(in.nextString());
                            break;
                        case "count":
                            e.setCount(in.nextInt());
                            break;
                        default:
                    }
                }
                in.endObject();
                return e;
            }
        }
    }
}
