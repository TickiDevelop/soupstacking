package com.tickidev.tickidev.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemMixin {
    
    @Inject(method = "getMaxStackSize", at = @At("RETURN"), cancellable = true)
    private void modifySoupStackSize(CallbackInfoReturnable<Integer> cir) {
        ItemStack stack = (ItemStack) (Object) this;
        if (isSoupItem(stack)) {
            cir.setReturnValue(16);
        }
    }
    
    private static boolean isSoupItem(ItemStack stack) {
        try {
            String displayName = stack.getHoverName().getString().toLowerCase();
            
            // Check if the name contains "soup" in various languages
            // English: soup, Russian: суп, German: suppe, French: soupe, Spanish: sopa, Italian: zuppa
            // Russian stewed items: тушённый, тушёная, тушёное, тушённые
            return displayName.contains("soup") || 
                   displayName.contains("суп") || 
                   displayName.contains("suppe") || 
                   displayName.contains("soupe") || 
                   displayName.contains("sopa") || 
                   displayName.contains("zuppa") ||
                   displayName.contains("тушённый") ||
                   displayName.contains("тушёная") ||
                   displayName.contains("тушёное") ||
                   displayName.contains("тушённые");
        } catch (Exception e) {
            return false;
        }
    }
}
