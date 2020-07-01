package com.twmicro.practical.types.not_deferred;

import com.twmicro.practical.utils.interfaces.INotDeferredList;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.util.ArrayList;

public class ModKeybindings implements INotDeferredList<KeyBinding> {
    private static final ArrayList<KeyBinding> REGISTRY_OBJECTS = new ArrayList<>();
    public static final KeyBinding USE_SPECIAL_FEATURE = new KeyBinding("key.use_special_feature.desc", 82, "key.categories.misc");
    static
    {
        REGISTRY_OBJECTS.add(USE_SPECIAL_FEATURE);
    }
    public void register()
    {
        for(KeyBinding keyBinding : REGISTRY_OBJECTS)
            ClientRegistry.registerKeyBinding(keyBinding);
    }
}
