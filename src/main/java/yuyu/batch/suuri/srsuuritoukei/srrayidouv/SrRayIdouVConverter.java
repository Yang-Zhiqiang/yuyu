package yuyu.batch.suuri.srsuuritoukei.srrayidouv;

import yuyu.def.db.entity.ZT_RayIdouVTy;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 ＲＡＹ異動Ｖ情報作成のコンバータークラス
 */
public class SrRayIdouVConverter {

    public SrRayIdouVConverter() {
        super();
    }

    public static void convertPadding(ZT_RayIdouVTy pRayIdouVTy) {

        pRayIdouVTy.setZtyaatukaisosikicd(
            Strings.padStart(pRayIdouVTy.getZtyaatukaisosikicd(), 7, '0'));
        pRayIdouVTy.setZtyaatukaikojincd(
            Strings.padStart(pRayIdouVTy.getZtyaatukaikojincd(), 6, '0'));
        pRayIdouVTy.setZtysykgycd(Strings.padStart(pRayIdouVTy.getZtysykgycd(), 3, '0'));
        pRayIdouVTy.setZtylnshrgenincd(
            Strings.padStart(pRayIdouVTy.getZtylnshrgenincd(), 4, '0'));
        pRayIdouVTy.setZtymrarihyj(
            Strings.padStart(pRayIdouVTy.getZtymrarihyj(), 1, '0'));
        pRayIdouVTy.setZtygnspshrgenincd(
            Strings.padStart(pRayIdouVTy.getZtygnspshrgenincd(), 4, '0'));
        pRayIdouVTy.setZtygnspshrhyj(
            Strings.padStart(pRayIdouVTy.getZtygnspshrhyj(), 1, '0'));
        pRayIdouVTy.setZtylivingneedstkykarihyj(
            Strings.padStart(pRayIdouVTy.getZtylivingneedstkykarihyj(), 1, '0'));
        pRayIdouVTy.setZtyanniskcd(
            Strings.padStart(pRayIdouVTy.getZtyanniskcd(), 8, '0'));
        pRayIdouVTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pRayIdouVTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pRayIdouVTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pRayIdouVTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pRayIdouVTy.setZtykituenhonsuu(
            Strings.padStart(pRayIdouVTy.getZtykituenhonsuu(), 2, '0'));
        pRayIdouVTy.setZtykyksyanen(
            Strings.padStart(pRayIdouVTy.getZtykyksyanen(), 2, '0'));
        pRayIdouVTy.setZtykeijyouym(
            Strings.padStart(pRayIdouVTy.getZtykeijyouym(), 6, '0'));
        pRayIdouVTy.setZtysaimnkkykhyj(
            Strings.padStart(pRayIdouVTy.getZtysaimnkkykhyj(), 1, '0'));
        pRayIdouVTy.setZtydai2hhknnen(
            Strings.padStart(pRayIdouVTy.getZtydai2hhknnen(), 2, '0'));
        pRayIdouVTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pRayIdouVTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pRayIdouVTy.setZtydakuhikettisyacd(
            Strings.padStart(pRayIdouVTy.getZtydakuhikettisyacd(), 2, '0'));
        pRayIdouVTy.setZtytenkankaisuu(
            Strings.padStart(pRayIdouVTy.getZtytenkankaisuu(), 1, '0'));
        pRayIdouVTy.setZtydenymd(
            Strings.padStart(pRayIdouVTy.getZtydenymd(), 8, '0'));
        pRayIdouVTy.setZtytkjykbn(
            Strings.padStart(pRayIdouVTy.getZtytkjykbn(), 1, '0'));
        pRayIdouVTy.setZtyhhknnentysihyj(
            Strings.padStart(pRayIdouVTy.getZtyhhknnentysihyj(), 1, '0'));
        pRayIdouVTy.setZtynknshry(
            Strings.padStart(pRayIdouVTy.getZtynknshry(), 2, '0'));
        pRayIdouVTy.setZtybnkttnknkbn(
            Strings.padStart(pRayIdouVTy.getZtybnkttnknkbn(), 1, '0'));
        pRayIdouVTy.setZtyheiyoubaraikeiyakukbn(
            Strings.padStart(pRayIdouVTy.getZtyheiyoubaraikeiyakukbn(), 1, '0'));
        pRayIdouVTy.setZtyhsyuikktminaosikaisu(
            Strings.padStart(pRayIdouVTy.getZtyhsyuikktminaosikaisu(), 2, '0'));
        pRayIdouVTy.setZtyhjncd(
            Strings.padStart(pRayIdouVTy.getZtyhjncd(), 9, '0'));
        pRayIdouVTy.setZtyhjnkykhyj(
            Strings.padStart(pRayIdouVTy.getZtyhjnkykhyj(), 1, '0'));
        pRayIdouVTy.setZtysisuukbn(
            Strings.padStart(pRayIdouVTy.getZtysisuukbn(), 2, '0'));
        pRayIdouVTy.setZtyphrkkikn(
            Strings.padStart(pRayIdouVTy.getZtyphrkkikn(), 2, '0'));

    }
}