package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ZT_HoyuuMeisaiTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 保有明細情報コンバーター
 */
public class SrHoyuuMeisaiConverter {

    public static void convertPadding(ZT_HoyuuMeisaiTy pZtHoyuuMeisaiTy) {

        pZtHoyuuMeisaiTy.setZtyaatukaisosikicd(Strings.padStart(pZtHoyuuMeisaiTy.getZtyaatukaisosikicd(), 7, '0'));
        pZtHoyuuMeisaiTy.setZtyaatukaikojincd(Strings.padStart(pZtHoyuuMeisaiTy.getZtyaatukaikojincd(), 6, '0'));
        pZtHoyuuMeisaiTy.setZtysykgycd(Strings.padStart(pZtHoyuuMeisaiTy.getZtysykgycd(), 3, '0'));
        pZtHoyuuMeisaiTy.setZtylnshrgenincd(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtylnshrgenincd(), 4, '0'));
        pZtHoyuuMeisaiTy.setZtymrarihyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtymrarihyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtygnspshrgenincd(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtygnspshrgenincd(), 4, '0'));
        pZtHoyuuMeisaiTy.setZtygnspshrhyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtygnspshrhyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtyfollowtantousyakbn(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyfollowtantousyakbn(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtylivingneedstkykarihyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtyanniskcd(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyanniskcd(), 8, '0'));
        pZtHoyuuMeisaiTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtykituenhonsuu(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtykituenhonsuu(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtykykjiqpackhyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtykykjiqpackhyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtykyksyaskinmeino(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtykyksyaskinmeino(), 10, '0'));
        pZtHoyuuMeisaiTy.setZtykyksyanen(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtykyksyanen(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtykyksyhhknsydouituhyouji(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtysaimnkkykhyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtysaimnkkykhyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtyjikaipjyuutouym(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyjikaipjyuutouym(), 6, '0'));
        pZtHoyuuMeisaiTy.setZtydai2hhknnen(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtydai2hhknnen(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtytenkankaisuu(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtytenkankaisuu(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtytkjykbn(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtytkjykbn(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtyhhknnentysihyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyhhknnentysihyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtybnkttnknkbn(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtybnkttnknkbn(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtyhjncd(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyhjncd(), 9, '0'));
        pZtHoyuuMeisaiTy.setZtyhjnkykhyj(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyhjnkykhyj(), 1, '0'));
        pZtHoyuuMeisaiTy.setZtysisuukbn(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtysisuukbn(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtynknshry(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtynknshry(), 2, '0'));
        pZtHoyuuMeisaiTy.setZtyphrkkikn(
            Strings.padStart(pZtHoyuuMeisaiTy.getZtyphrkkikn(), 2, '0'));

    }

    public static void convertPadding(ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyItzHzn) {

        pStHoyuuMeisaiTyItzHzn.setZtyaatukaisosikicd(Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyaatukaisosikicd(), 7, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyaatukaikojincd(Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyaatukaikojincd(), 6, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtysykgycd(Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtysykgycd(), 3, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtylnshrgenincd(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtylnshrgenincd(), 4, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtymrarihyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtymrarihyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtygnspshrgenincd(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtygnspshrgenincd(), 4, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtygnspshrhyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtygnspshrhyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyfollowtantousyakbn(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyfollowtantousyakbn(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtylivingneedstkykarihyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtylivingneedstkykarihyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyanniskcd(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyanniskcd(), 8, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtystdsstkjytkyuhyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtystdsstkjytkyuhyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtykituenhonsuu(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtykituenhonsuu(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtykykjiqpackhyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtykykjiqpackhyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtykyksyaskinmeino(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtykyksyaskinmeino(), 10, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtykyksyanen(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtykyksyanen(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtykyksyhhknsydouituhyouji(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtykyksyhhknsydouituhyouji(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtysaimnkkykhyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtysaimnkkykhyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyjikaipjyuutouym(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyjikaipjyuutouym(), 6, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtydai2hhknnen(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtydai2hhknnen(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtydai2hhknnentysihyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtydai2hhknnentysihyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtytenkankaisuu(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtytenkankaisuu(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtytkjykbn(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtytkjykbn(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyhhknnentysihyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyhhknnentysihyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtybnkttnknkbn(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtybnkttnknkbn(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyhjncd(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyhjncd(), 9, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyhjnkykhyj(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyhjnkykhyj(), 1, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtysisuukbn(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtysisuukbn(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtynknshry(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtynknshry(), 2, '0'));
        pStHoyuuMeisaiTyItzHzn.setZtyphrkkikn(
            Strings.padStart(pStHoyuuMeisaiTyItzHzn.getZtyphrkkikn(), 2, '0'));

    }
}
