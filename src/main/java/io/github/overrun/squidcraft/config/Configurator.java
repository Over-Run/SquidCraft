package io.github.overrun.squidcraft.config;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author squid233
 * @since 2021/02/02
 */
public final class Configurator {
    private CobblestoneFarmRoll[] rolls;
    private CompressorRecipe[] recipes;

    public Configurator(CobblestoneFarmRoll[] rolls, CompressorRecipe[] recipes) {
        this.rolls = rolls;
        this.recipes = recipes;
    }

    public CobblestoneFarmRoll[] getRolls() {
        return rolls;
    }

    public void setRolls(CobblestoneFarmRoll[] rolls) {
        this.rolls = rolls;
    }

    public CompressorRecipe[] getRecipes() {
        return recipes;
    }

    public void setRecipes(CompressorRecipe[] recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Configurator that = (Configurator) o;
        return Arrays.equals(getRolls(), that.getRolls()) && Arrays.equals(getRecipes(), that.getRecipes());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getRolls());
        result = 31 * result + Arrays.hashCode(getRecipes());
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Configurator.class.getSimpleName() + "[", "]")
                .add("rolls=" + Arrays.toString(rolls))
                .add("recipes=" + Arrays.toString(recipes))
                .toString();
    }

    public static final class Serializer extends TypeAdapter<Configurator> {
        @Override
        public void write(JsonWriter out, Configurator value) throws IOException {
            out.beginObject().name("cobblestone_farm_rolls").beginArray();
            for (CobblestoneFarmRoll roll : value.getRolls()) {
                CobblestoneFarmRoll.Serializer.write(out, roll);
            }
            out.endArray().name("compressor_recipes").beginArray();
            for (CompressorRecipe recipe : value.getRecipes()) {
                CompressorRecipe.Serializer.write(out, recipe);
            }
            out.endArray().endObject();
        }

        @Override
        public Configurator read(JsonReader in) throws IOException {
            List<CobblestoneFarmRoll> rolls = new ArrayList<>();
            List<CompressorRecipe> recipes = new ArrayList<>();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "cobblestone_farm_rolls":
                        in.beginArray();
                        while (in.hasNext()) {
                           rolls.add(CobblestoneFarmRoll.Serializer.read(in));
                        }
                        in.endArray();
                        break;
                    case "compressor_recipes":
                        in.beginArray();
                        while (in.hasNext()) {
                            recipes.add(CompressorRecipe.Serializer.read(in));
                        }
                        in.endArray();
                        break;
                    default:
                }
            }
            in.endObject();
            return new Configurator(rolls.toArray(new CobblestoneFarmRoll[0]), recipes.toArray(new CompressorRecipe[0]));
        }
    }
}
