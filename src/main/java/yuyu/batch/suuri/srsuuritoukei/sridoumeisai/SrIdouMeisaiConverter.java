package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ZT_IdouMeisaiTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 異動明細情報コンバーター
 */
public class SrIdouMeisaiConverter {

    public static void convertPadding(ZT_IdouMeisaiTy pZtIdouMeisaiTy) {

        pZtIdouMeisaiTy.setZtyaatukaisosikicd(Strings.padStart(pZtIdouMeisaiTy.getZtyaatukaisosikicd(), 7, '0'));
        pZtIdouMeisaiTy.setZtyaatukaikojincd(Strings.padStart(pZtIdouMeisaiTy.getZtyaatukaikojincd(), 6, '0'));
        pZtIdouMeisaiTy.setZtysykgycd(Strings.padStart(pZtIdouMeisaiTy.getZtysykgycd(), 3, '0'));
        pZtIdouMeisaiTy.setZtylnshrgenincd(
            Strings.padStart(pZtIdouMeisaiTy.getZtylnshrgenincd(), 4, '0'));
        pZtIdouMeisaiTy.setZtymrarihyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtymrarihyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtygnspshrgenincd(
            Strings.padStart(pZtIdouMeisaiTy.getZtygnspshrgenincd(), 4, '0'));
        pZtIdouMeisaiTy.setZtygnspshrhyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtygnspshrhyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtyfollowtantousyakbn(
            Strings.padStart(pZtIdouMeisaiTy.getZtyfollowtantousyakbn(), 2, '0'));
        pZtIdouMeisaiTy.setZtylivingneedstkykarihyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtyanniskcd(
            Strings.padStart(pZtIdouMeisaiTy.getZtyanniskcd(), 8, '0'));
        pZtIdouMeisaiTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtIdouMeisaiTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtIdouMeisaiTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtykituenhonsuu(
            Strings.padStart(pZtIdouMeisaiTy.getZtykituenhonsuu(), 2, '0'));
        pZtIdouMeisaiTy.setZtykykjiqpackhyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtykykjiqpackhyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtykyksyaskinmeino(
            Strings.padStart(pZtIdouMeisaiTy.getZtykyksyaskinmeino(), 10, '0'));
        pZtIdouMeisaiTy.setZtykyksyanen(
            Strings.padStart(pZtIdouMeisaiTy.getZtykyksyanen(), 2, '0'));
        pZtIdouMeisaiTy.setZtykyksyhhknsydouituhyouji(
            Strings.padStart(pZtIdouMeisaiTy.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pZtIdouMeisaiTy.setZtykeijyouym(
            Strings.padStart(pZtIdouMeisaiTy.getZtykeijyouym(), 6, '0'));
        pZtIdouMeisaiTy.setZtysaimnkkykhyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtysaimnkkykhyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtyjikaipjyuutouym(
            Strings.padStart(pZtIdouMeisaiTy.getZtyjikaipjyuutouym(), 6, '0'));
        pZtIdouMeisaiTy.setZtydai2hhknnen(
            Strings.padStart(pZtIdouMeisaiTy.getZtydai2hhknnen(), 2, '0'));
        pZtIdouMeisaiTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtytenkankaisuu(
            Strings.padStart(pZtIdouMeisaiTy.getZtytenkankaisuu(), 1, '0'));
        pZtIdouMeisaiTy.setZtytkjykbn(
            Strings.padStart(pZtIdouMeisaiTy.getZtytkjykbn(), 1, '0'));
        pZtIdouMeisaiTy.setZtyhhknnentysihyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtyhhknnentysihyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtybnkttnknkbn(
            Strings.padStart(pZtIdouMeisaiTy.getZtybnkttnknkbn(), 1, '0'));
        pZtIdouMeisaiTy.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pZtIdouMeisaiTy.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pZtIdouMeisaiTy.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pZtIdouMeisaiTy.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pZtIdouMeisaiTy.setZtyhjncd(
            Strings.padStart(pZtIdouMeisaiTy.getZtyhjncd(), 9, '0'));
        pZtIdouMeisaiTy.setZtyhjnkykhyj(
            Strings.padStart(pZtIdouMeisaiTy.getZtyhjnkykhyj(), 1, '0'));
        pZtIdouMeisaiTy.setZtysisuukbn(
            Strings.padStart(pZtIdouMeisaiTy.getZtysisuukbn(), 2, '0'));
        pZtIdouMeisaiTy.setZtynknshry(
            Strings.padStart(pZtIdouMeisaiTy.getZtynknshry(), 2, '0'));
        pZtIdouMeisaiTy.setZtyphrkkikn(
            Strings.padStart(pZtIdouMeisaiTy.getZtyphrkkikn(), 2, '0'));
    }

    public static void convertPadding(ST_IdouMeisaiTyukeiyouItzHzn pZtIdouMeisaiTyItzHzn) {

        pZtIdouMeisaiTyItzHzn.setZtyaatukaisosikicd(Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyaatukaisosikicd(), 7, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyaatukaikojincd(Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyaatukaikojincd(), 6, '0'));
        pZtIdouMeisaiTyItzHzn.setZtysykgycd(Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtysykgycd(), 3, '0'));
        pZtIdouMeisaiTyItzHzn.setZtylnshrgenincd(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtylnshrgenincd(), 4, '0'));
        pZtIdouMeisaiTyItzHzn.setZtymrarihyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtymrarihyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtygnspshrgenincd(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtygnspshrgenincd(), 4, '0'));
        pZtIdouMeisaiTyItzHzn.setZtygnspshrhyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtygnspshrhyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyfollowtantousyakbn(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyfollowtantousyakbn(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtylivingneedstkykarihyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtylivingneedstkykarihyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyanniskcd(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyanniskcd(), 8, '0'));
        pZtIdouMeisaiTyItzHzn.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtystdsstkjytkyuhyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtystdsstkjytkyuhyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtykituenhonsuu(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtykituenhonsuu(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtykykjiqpackhyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtykykjiqpackhyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtykyksyaskinmeino(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtykyksyaskinmeino(), 10, '0'));
        pZtIdouMeisaiTyItzHzn.setZtykyksyanen(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtykyksyanen(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtykyksyhhknsydouituhyouji(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtykeijyouym(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtykeijyouym(), 6, '0'));
        pZtIdouMeisaiTyItzHzn.setZtysaimnkkykhyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtysaimnkkykhyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyjikaipjyuutouym(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyjikaipjyuutouym(), 6, '0'));
        pZtIdouMeisaiTyItzHzn.setZtydai2hhknnen(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtydai2hhknnen(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtydai2hhknnentysihyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtydai2hhknnentysihyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtytenkankaisuu(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtytenkankaisuu(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtytkjykbn(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtytkjykbn(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyhhknnentysihyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyhhknnentysihyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtybnkttnknkbn(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtybnkttnknkbn(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyhjncd(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyhjncd(), 9, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyhjnkykhyj(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyhjnkykhyj(), 1, '0'));
        pZtIdouMeisaiTyItzHzn.setZtysisuukbn(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtysisuukbn(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtynknshry(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtynknshry(), 2, '0'));
        pZtIdouMeisaiTyItzHzn.setZtyphrkkikn(
            Strings.padStart(pZtIdouMeisaiTyItzHzn.getZtyphrkkikn(), 2, '0'));
    }
}
