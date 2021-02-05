package io.github.overrun.squidcraft.config;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.IOException;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author squid233
 * @since 2021/02/02
 */
public final class CompressorRecipe {
    private In in;
    private Out out;

    public CompressorRecipe(In in, Out out) {
        this.in = in;
        this.out = out;
    }

    public CompressorRecipe() {
        this(new In(), new Out());
    }

    public In getInput() {
        return in;
    }

    public void setInput(In in) {
        this.in = in;
    }

    public Out getOutput() {
        return out;
    }

    public void setOutput(Out out) {
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
            CompressorRecipe.In.Serializer.write(out, value.getInput());
            out.name("out");
            CompressorRecipe.Out.Serializer.write(out, value.getOutput());
            out.endObject();
        }

        public static CompressorRecipe read(JsonReader in) throws IOException {
            CompressorRecipe recipe = new CompressorRecipe();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "in":
                        recipe.setInput(CompressorRecipe.In.Serializer.read(in));
                        break;
                    case "out":
                        recipe.setOutput(CompressorRecipe.Out.Serializer.read(in));
                        break;
                    default:
                }
            }
            in.endObject();
            return recipe;
        }
    }

    public static final class In {
        private String item;
        private int count;

        public In(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public In(String item) {
            this(item, 1);
        }

        public In() {
            this("air");
        }

        public String getItem() {
            return item;
        }

        public Item getAsItem() {
            return Registry.ITEM.get(new Identifier(getItem()));
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
            In in = (In) o;
            return getCount() == in.getCount() && Objects.equals(getItem(), in.getItem());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getItem(), getCount());
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", In.class.getSimpleName() + "[", "]")
                    .add("item='" + item + "'")
                    .add("count=" + count)
                    .toString();
        }

        public static final class Serializer {
            public static void write(JsonWriter out, In value) throws IOException {
                out.beginObject().name("item").value(value.getItem()).name("count").value(value.getCount()).endObject();
            }

            public static In read(JsonReader in) throws IOException {
                In input = new In();
                in.beginObject();
                while (in.hasNext()) {
                    switch (in.nextName()) {
                        case "item":
                            input.setItem(in.nextString());
                            break;
                        case "count":
                            input.setCount(in.nextInt());
                            break;
                        default:
                    }
                }
                in.endObject();
                return input;
            }
        }
    }

    public static final class Out {
        private String item;
        private int count;

        public Out(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public Out(String item) {
            this(item, 1);
        }

        public Out() {
            this("air");
        }

        public String getItem() {
            return item;
        }

        public Item getAsItem() {
            return Registry.ITEM.get(new Identifier(getItem()));
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
            Out out = (Out) o;
            return getCount() == out.getCount() && Objects.equals(getItem(), out.getItem());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getItem(), getCount());
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Out.class.getSimpleName() + "[", "]")
                    .add("item='" + item + "'")
                    .add("count=" + count)
                    .toString();
        }

        public static final class Serializer {
            public static void write(JsonWriter out, Out value) throws IOException {
                out.beginObject().name("item").value(value.getItem()).name("count").value(value.getCount()).endObject();
            }

            public static Out read(JsonReader in) throws IOException {
                Out out = new Out();
                in.beginObject();
                while (in.hasNext()) {
                    switch (in.nextName()) {
                        case "item":
                            out.setItem(in.nextString());
                            break;
                        case "count":
                            out.setCount(in.nextInt());
                            break;
                        default:
                    }
                }
                in.endObject();
                return out;
            }
        }
    }
}
