package me.randomhashtags.itemskins.util;

import com.sun.istack.internal.NotNull;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public interface RPItemStack extends Versionable {
    default void removeRPItemStackValue(@NotNull ItemStack is, String key) {
        removeRPItemStackValues(is, key);
    }
    default void removeRPItemStackValues(@NotNull ItemStack is, String...keys) {
        if(EIGHT) {
            final net.minecraft.server.v1_8_R3.ItemStack n = org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_8_R3.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_8_R3.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(NINE) {
            final net.minecraft.server.v1_9_R2.ItemStack n = org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_9_R2.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_9_R2.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(TEN) {
            final net.minecraft.server.v1_10_R1.ItemStack n = org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_10_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_10_R1.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(ELEVEN) {
            final net.minecraft.server.v1_11_R1.ItemStack n = org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_11_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_11_R1.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(TWELVE) {
            final net.minecraft.server.v1_12_R1.ItemStack n = org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_12_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_12_R1.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(THIRTEEN) {
            final net.minecraft.server.v1_13_R2.ItemStack n = org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_13_R2.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_13_R2.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(FOURTEEN) {
            final net.minecraft.server.v1_14_R1.ItemStack n = org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_14_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_14_R1.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(FIFTEEN) {
            final net.minecraft.server.v1_15_R1.ItemStack n = org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_15_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_15_R1.NBTTagCompound();
            for(String s : keys) {
                t.remove(s);
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        }
    }
    default void addRPItemStackValue(@NotNull ItemStack is, String key, String value) {
        addRPItemStackValues(is, new HashMap<String, String>() {{
            put(key, value);
        }});
    }
    default void addRPItemStackValues(@NotNull ItemStack is, HashMap<String, String> values) {
        if(EIGHT) {
            final net.minecraft.server.v1_8_R3.ItemStack n = org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_8_R3.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_8_R3.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(NINE) {
            final net.minecraft.server.v1_9_R2.ItemStack n = org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_9_R2.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_9_R2.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(TEN) {
            final net.minecraft.server.v1_10_R1.ItemStack n = org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_10_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_10_R1.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(ELEVEN) {
            final net.minecraft.server.v1_11_R1.ItemStack n = org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_11_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_11_R1.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(TWELVE) {
            final net.minecraft.server.v1_12_R1.ItemStack n = org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_12_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_12_R1.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(THIRTEEN) {
            final net.minecraft.server.v1_13_R2.ItemStack n = org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_13_R2.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_13_R2.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(FOURTEEN) {
            final net.minecraft.server.v1_14_R1.ItemStack n = org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_14_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_14_R1.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        } else if(FIFTEEN) {
            final net.minecraft.server.v1_15_R1.ItemStack n = org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack.asNMSCopy(is);
            final net.minecraft.server.v1_15_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : new net.minecraft.server.v1_15_R1.NBTTagCompound();
            for(String s : values.keySet()) {
                t.setString(s, values.get(s));
            }
            is.setItemMeta(org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack.asCraftMirror(n).getItemMeta());
        }
    }
    default String getRPItemStackValue(@NotNull ItemStack is, String key) {
        if(is != null) {
            if(EIGHT) {
                final net.minecraft.server.v1_8_R3.ItemStack n = org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_8_R3.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(NINE) {
                final net.minecraft.server.v1_9_R2.ItemStack n = org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_9_R2.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(TEN) {
                final net.minecraft.server.v1_10_R1.ItemStack n = org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_10_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(ELEVEN) {
                final net.minecraft.server.v1_11_R1.ItemStack n = org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_11_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(TWELVE) {
                final net.minecraft.server.v1_12_R1.ItemStack n = org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_12_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(THIRTEEN) {
                final net.minecraft.server.v1_13_R2.ItemStack n = org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_13_R2.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(FOURTEEN) {
                final net.minecraft.server.v1_14_R1.ItemStack n = org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_14_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            } else if(FIFTEEN) {
                final net.minecraft.server.v1_15_R1.ItemStack n = org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack.asNMSCopy(is);
                final net.minecraft.server.v1_15_R1.NBTTagCompound t = n.hasTag() ? n.getTag() : null;
                return t != null && t.hasKey(key) ? t.getString(key) : null;
            }
        }
        return null;
    }
    default String asNMSCopy(@NotNull ItemStack itemstack) {
        if(EIGHT) {
            return org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_8_R3.NBTTagCompound()).toString();
        } else if(NINE) {
            return org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_9_R2.NBTTagCompound()).toString();
        } else if(TEN) {
            return org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_10_R1.NBTTagCompound()).toString();
        } else if(ELEVEN) {
            return org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_11_R1.NBTTagCompound()).toString();
        } else if(TWELVE) {
            return org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_12_R1.NBTTagCompound()).toString();
        } else if(THIRTEEN) {
            return org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_13_R2.NBTTagCompound()).toString();
        } else if(FOURTEEN) {
            return org.bukkit.craftbukkit.v1_14_R1.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_14_R1.NBTTagCompound()).toString();
        } else if(FIFTEEN) {
            return org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack.asNMSCopy(itemstack).save(new net.minecraft.server.v1_15_R1.NBTTagCompound()).toString();
        } else {
            return null;
        }
    }
}

