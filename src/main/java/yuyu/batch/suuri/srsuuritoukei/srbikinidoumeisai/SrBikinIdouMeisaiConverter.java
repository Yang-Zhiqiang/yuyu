package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 備金異動明細情報コンバーター
 */
public class SrBikinIdouMeisaiConverter {

    public static void convertPadding(ZT_BikinIdouMeisaiTy pZtBikinIdouMeisaiTy){

        pZtBikinIdouMeisaiTy.setZtyaatukaisosikicd(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyaatukaisosikicd(), 7, '0'));
        pZtBikinIdouMeisaiTy.setZtyaatukaikojincd(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyaatukaikojincd(), 6, '0'));
        pZtBikinIdouMeisaiTy.setZtysykgycd(Strings.padStart(pZtBikinIdouMeisaiTy.getZtysykgycd(), 3, '0'));
        pZtBikinIdouMeisaiTy.setZtylnshrgenincd(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtylnshrgenincd(), 4, '0'));
        pZtBikinIdouMeisaiTy.setZtymrarihyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtymrarihyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtygnspshrgenincd(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtygnspshrgenincd(), 4, '0'));
        pZtBikinIdouMeisaiTy.setZtygnspshrhyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtygnspshrhyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtyfollowtantousyakbn(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyfollowtantousyakbn(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtylivingneedstkykarihyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtyanniskcd(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyanniskcd(), 8, '0'));
        pZtBikinIdouMeisaiTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtykituenhonsuu(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtykituenhonsuu(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtykykjiqpackhyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtykykjiqpackhyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtykyksyaskinmeino(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtykyksyaskinmeino(), 10, '0'));
        pZtBikinIdouMeisaiTy.setZtykyksyanen(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtykyksyanen(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtykyksyhhknsydouituhyouji(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtykeijyouym(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtykeijyouym(), 6, '0'));
        pZtBikinIdouMeisaiTy.setZtysaimnkkykhyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtysaimnkkykhyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtyjikaipjyuutouym(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyjikaipjyuutouym(), 6, '0'));
        pZtBikinIdouMeisaiTy.setZtydai2hhknnen(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtydai2hhknnen(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtytenkankaisuu(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtytenkankaisuu(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtytkjykbn(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtytkjykbn(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtyhhknnentysihyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyhhknnentysihyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtybnkttnknkbn(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtybnkttnknkbn(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtyhjncd(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyhjncd(), 9, '0'));
        pZtBikinIdouMeisaiTy.setZtyhjnkykhyj(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyhjnkykhyj(), 1, '0'));
        pZtBikinIdouMeisaiTy.setZtysisuukbn(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtysisuukbn(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtynknshry(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtynknshry(), 2, '0'));
        pZtBikinIdouMeisaiTy.setZtyphrkkikn(
            Strings.padStart(pZtBikinIdouMeisaiTy.getZtyphrkkikn(), 2, '0'));
    }

    public static void convertPadding(ST_IdouMeisaiTyukeiyouItzHzn pZtBikinIdouMeisaiTyItzHzn){

        pZtBikinIdouMeisaiTyItzHzn.setZtyaatukaisosikicd(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyaatukaisosikicd(), 7, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyaatukaikojincd(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyaatukaikojincd(), 6, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtysykgycd(Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtysykgycd(), 3, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtylnshrgenincd(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtylnshrgenincd(), 4, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtymrarihyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtymrarihyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtygnspshrgenincd(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtygnspshrgenincd(), 4, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtygnspshrhyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtygnspshrhyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyfollowtantousyakbn(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyfollowtantousyakbn(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtylivingneedstkykarihyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtylivingneedstkykarihyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyanniskcd(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyanniskcd(), 8, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtystdsstkjytkyuhyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtystdsstkjytkyuhyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtykituenhonsuu(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtykituenhonsuu(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtykykjiqpackhyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtykykjiqpackhyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtykyksyaskinmeino(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtykyksyaskinmeino(), 10, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtykyksyanen(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtykyksyanen(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtykyksyhhknsydouituhyouji(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtykeijyouym(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtykeijyouym(), 6, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtysaimnkkykhyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtysaimnkkykhyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyjikaipjyuutouym(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyjikaipjyuutouym(), 6, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtydai2hhknnen(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtydai2hhknnen(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtydai2hhknnentysihyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtydai2hhknnentysihyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtytenkankaisuu(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtytenkankaisuu(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtytkjykbn(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtytkjykbn(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyhhknnentysihyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyhhknnentysihyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtybnkttnknkbn(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtybnkttnknkbn(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyhjncd(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyhjncd(), 9, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyhjnkykhyj(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyhjnkykhyj(), 1, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtysisuukbn(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtysisuukbn(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtynknshry(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtynknshry(), 2, '0'));
        pZtBikinIdouMeisaiTyItzHzn.setZtyphrkkikn(
            Strings.padStart(pZtBikinIdouMeisaiTyItzHzn.getZtyphrkkikn(), 2, '0'));
    }
}
