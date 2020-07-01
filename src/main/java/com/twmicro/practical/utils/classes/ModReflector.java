package com.twmicro.practical.utils.classes;

import com.twmicro.practical.PracticalMod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.LogManager;

public class ModReflector {
    public static Method getMethod (Class<?> whereToFind, String methodName, Class<?> ... params)
    {
        try
        {
            Method method = ObfuscationReflectionHelper.findMethod(whereToFind, methodName, params);
            method.setAccessible(true);
            return method;
        }
        catch(Exception e)
        {
            LogManager.getLogManager().getLogger(PracticalMod.MODID).warning(e.getLocalizedMessage());
            return null;
        }
    }
    public static Object invokeMethod (Method method, @Nullable Object instance, Object ... params)
    {
        try
        {
            return method.invoke(instance, params);
        }
        catch(Exception e)
        {
            LogManager.getLogManager().getLogger(PracticalMod.MODID).warning(e.getLocalizedMessage());
            return null;
        }
    }

    public static void invokeStatic(Method method, Object ... params)
    {
        invokeMethod(method, null, params);
    }

    public static Field getField(Class<?> whereToFind, String fieldName)
    {
        try
        {
            Field field = whereToFind.getField(fieldName);
            field.setAccessible(true);
            return field;
        }
        catch(Exception e)
        {
            LogManager.getLogManager().getLogger(PracticalMod.MODID).warning(e.getLocalizedMessage());
            return null;
        }
    }
}
