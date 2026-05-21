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
            
            // Check if the name contains "soup" or "stewed" in various languages
            // European languages
            return displayName.contains("soup") || 
                   displayName.contains("sopa") || 
                   displayName.contains("suppe") || 
                   displayName.contains("soupe") || 
                   displayName.contains("zuppa") ||
                   displayName.contains("soep") ||
                   displayName.contains("soppa") ||
                   displayName.contains("supă") ||
                   displayName.contains("polévka") ||
                   displayName.contains("polievka") ||
                   displayName.contains("juha") ||
                   displayName.contains("zupa") ||
                   displayName.contains("leves") ||
                   displayName.contains("keitto") ||
                   displayName.contains("minestra") ||
                   displayName.contains("sriuba") ||
                   displayName.contains("σούπα") ||
                   displayName.contains("суп") ||
                   displayName.contains("супа") ||
                   displayName.contains("汤") || // Chinese simplified
                   displayName.contains("湯") || // Chinese traditional
                   displayName.contains("スープ") || // Japanese
                   displayName.contains("국") || // Korean
                   displayName.contains("ซุป") || // Thai
                   displayName.contains("çorba") || // Turkish
                   displayName.contains("сорпа") || // Kazakh
                   displayName.contains("шорпо") || // Kyrgyz
                   displayName.contains("шӯрбо") || // Tajik
                   displayName.contains("шөл") || // Mongolian
                   displayName.contains("حساء") || // Arabic
                   displayName.contains("מרק") || // Hebrew
                   displayName.contains("سوپ") || // Persian/Urdu/Pashto
                   displayName.contains("canh") || // Vietnamese
                   displayName.contains("sup") || // Indonesian/Malay
                   displayName.contains("sabaw") || // Filipino/Cebuano
                   displayName.contains("supu") || // Swahili
                   displayName.contains("isupu") || // Kinyarwanda
                   displayName.contains("isuphu") || // Xhosa
                   displayName.contains("isobho") || // Zulu
                   displayName.contains("স্যুপ") || // Bengali
                   displayName.contains("સૂપ") || // Gujarati
                   displayName.contains("शोरबा") || // Hindi
                   displayName.contains("सूप") || // Marathi/Nepali
                   displayName.contains("ಸೂಪ್") || // Kannada
                   displayName.contains("സൂപ്പ്") || // Malayalam
                   displayName.contains("சூப்") || // Tamil
                   displayName.contains("చారు") || // Telugu
                   displayName.contains("සුප්") || // Sinhala
                   displayName.contains("ស៊ុប") || // Khmer
                   displayName.contains("ဟင်းချို") || // Burmese
                   displayName.contains("სუპი") || // Georgian
                   displayName.contains("ապուր") || // Armenian
                   displayName.contains("şorba") || // Azerbaijani
                   displayName.contains("supë") || // Albanian
                   displayName.contains("zopa") || // Basque
                   displayName.contains("supa") || // Bosnian/Galician/Hawaiian/Samoan
                   displayName.contains("zuppa") || // Corsican/Latvian
                   displayName.contains("cawl") || // Welsh
                   displayName.contains("brot") || // Scots Gaelic
                   displayName.contains("аш") || // Tatar
                   displayName.contains("ແກງ") || // Lao
                   displayName.contains("hupa") || // Maori
                   displayName.contains("lasopy") || // Malagasy
                   displayName.contains("sop") || // Afrikaans/Frisian
                   displayName.contains("ሾርባ") || // Amharic
                   displayName.contains("miya") || // Hausa
                   displayName.contains("ofe") || // Igbo
                   displayName.contains("sopho") || // Sesotho
                   displayName.contains("muto") || // Shona
                   displayName.contains("maraq") || // Somali
                   displayName.contains("bimo") || // Yoruba
                   displayName.contains("supo") || // Esperanto
                   displayName.contains("pulmenti") || // Latin
                   // Stewed items in various languages
                   displayName.contains("тушёный") ||
                   displayName.contains("тушёная") ||
                   displayName.contains("тушёное") ||
                   displayName.contains("тушённые") ||
                   displayName.contains("тушеный") ||
                   displayName.contains("тушковані") ||
                   displayName.contains("задушени") ||
                   displayName.contains("душенé") ||
                   displayName.contains("dušena") ||
                   displayName.contains("duszony") ||
                   displayName.contains("dušené") ||
                   displayName.contains("estofado") ||
                   displayName.contains("estufado") ||
                   displayName.contains("ragoût") ||
                   displayName.contains("cuit") ||
                   displayName.contains("gedünstet") ||
                   displayName.contains("stuvet") ||
                   displayName.contains("stuvad") ||
                   displayName.contains("stuet") ||
                   displayName.contains("gestoofd") ||
                   displayName.contains("haudutettu") ||
                   displayName.contains("in umido") ||
                   displayName.contains("párolt") ||
                   displayName.contains("înăbușită") ||
                   displayName.contains("炖") || // Chinese simplified
                   displayName.contains("燉") || // Chinese traditional
                   displayName.contains("煮込み") || // Japanese
                   displayName.contains("스튜") || // Korean
                   displayName.contains("estofado") || // Spanish
                   displayName.contains("guisat") || // Catalan
                   displayName.contains("stufatu") || // Corsican
                   displayName.contains("pirjana") || // Croatian
                   displayName.contains("динстано") || // Serbian
                   displayName.contains("bişmiş") || // Azerbaijani
                   displayName.contains("кацсаρόлας") || // Greek
                   displayName.contains("soðið") || // Icelandic
                   displayName.contains("wedi'i stiwio") || // Welsh
                   displayName.contains("շոգեխաշած") || // Armenian
                   displayName.contains("ჩაშუშული") || // Georgian
                   displayName.contains("दम किया हुआ") || // Hindi
                   displayName.contains("бұқтырылған") || // Kazakh
                   displayName.contains("бышырылган") || // Kyrgyz
                   displayName.contains("чанасан") || // Mongolian
                   displayName.contains("စွပ်ပြုတ်") || // Burmese
                   displayName.contains("पकाएको") || // Nepali
                   displayName.contains("پخه شوی") || // Pashto
                   displayName.contains("пухта") || // Tajik
                   displayName.contains("ಬೇಯಿಸಿದ") || // Kannada
                   displayName.contains("പായസം") || // Malayalam
                   displayName.contains("शिजवलेले") || // Marathi
                   displayName.contains("ຕົ້ມ") || // Lao
                   displayName.contains("உருவாக்கப்பட்ட") || // Tamil
                   displayName.contains("ඉස්ටුවක්") || // Sinhala
                   displayName.contains("stewed") || // English base form
                   displayName.contains("stew"); // English base form
        } catch (Exception e) {
            return false;
        }
    }
}
