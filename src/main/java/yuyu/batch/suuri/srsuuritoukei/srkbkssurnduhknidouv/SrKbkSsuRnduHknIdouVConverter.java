package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknidouv;

import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 株価指数連動保険異動Ｖ情報作成のコンバータークラス
 */
public class SrKbkSsuRnduHknIdouVConverter {

    public SrKbkSsuRnduHknIdouVConverter() {
        super();
    }

    public static void convertPadding(ZT_KbkSsuRnduHknIdouVTy pKbkSsuRnduHknIdouVTy) {

        pKbkSsuRnduHknIdouVTy.setZtyaatukaisosikicd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyaatukaisosikicd(), 7, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyaatukaikojincd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyaatukaikojincd(), 6, '0'));
        pKbkSsuRnduHknIdouVTy.setZtysykgycd(Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtysykgycd(), 3, '0'));
        pKbkSsuRnduHknIdouVTy.setZtylnshrgenincd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtylnshrgenincd(), 4, '0'));
        pKbkSsuRnduHknIdouVTy.setZtymrarihyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtymrarihyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtygnspshrgenincd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtygnspshrgenincd(), 4, '0'));
        pKbkSsuRnduHknIdouVTy.setZtygnspshrhyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtygnspshrhyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtylivingneedstkykarihyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyanniskcd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyanniskcd(), 8, '0'));
        pKbkSsuRnduHknIdouVTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtykituenhonsuu(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtykituenhonsuu(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtykyksyanen(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtykyksyanen(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtykeijyouym(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtykeijyouym(), 6, '0'));
        pKbkSsuRnduHknIdouVTy.setZtysaimnkkykhyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtysaimnkkykhyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtydai2hhknnen(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtydai2hhknnen(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtydakuhikettisyacd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtydakuhikettisyacd(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtytenkankaisuu(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtytenkankaisuu(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtydenymd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtydenymd(), 8, '0'));
        pKbkSsuRnduHknIdouVTy.setZtytkjykbn(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtytkjykbn(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyhhknnentysihyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyhhknnentysihyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtynknshry(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtynknshry(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtybnkttnknkbn(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtybnkttnknkbn(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyhjncd(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyhjncd(), 9, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyhjnkykhyj(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyhjnkykhyj(), 1, '0'));
        pKbkSsuRnduHknIdouVTy.setZtysisuukbn(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtysisuukbn(), 2, '0'));
        pKbkSsuRnduHknIdouVTy.setZtyphrkkikn(
            Strings.padStart(pKbkSsuRnduHknIdouVTy.getZtyphrkkikn(), 2, '0'));

    }
}