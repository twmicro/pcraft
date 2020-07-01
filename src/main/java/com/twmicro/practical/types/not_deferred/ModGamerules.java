package com.twmicro.practical.types.not_deferred;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.utils.interfaces.INotDeferredList;
import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.world.GameRules;

import java.util.ArrayList;

import static com.twmicro.practical.utils.classes.ModReflector.*;


public class ModGamerules implements INotDeferredList<GameRules.RuleKey<?>> {
    private static final ImmutableMap.Builder<GameRules.RuleType<?>, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static final ArrayList<GameRules.Category> CATEGORIES = new ArrayList<>();
    public static GameRules.RuleKey<GameRules.BooleanValue> ENABLE_TANK_RANDOM_MOVEMENT;
    private static void add(GameRules.RuleType<?> rule, GameRules.Category category, String name)
    {
        REGISTRY_MAP.put(rule, name);
        CATEGORIES.add(category);
    }
    static
    {
        add(createBoolean(false), GameRules.Category.MOBS, "enableTankRandomMovement");
    }

    @Override
    public void register() {
        int index = 0;
        REGISTRY_MAP.build().forEach((rule, name) ->
            GameRules.func_234903_a_(name, CATEGORIES.get(index), rule)
        );
    }

    public static GameRules.RuleType<GameRules.BooleanValue> createBoolean(boolean value)
    {
        return (GameRules.RuleType<GameRules.BooleanValue>) invokeMethod(getMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class), GameRules.BooleanValue.class, value);
    }
    public static GameRules.RuleType<GameRules.IntegerValue> createInteger(int value)
    {
        return (GameRules.RuleType<GameRules.IntegerValue>) invokeMethod(getMethod(GameRules.IntegerValue.class, "func_223568_b", int.class), GameRules.IntegerValue.class, value);
    }
}
