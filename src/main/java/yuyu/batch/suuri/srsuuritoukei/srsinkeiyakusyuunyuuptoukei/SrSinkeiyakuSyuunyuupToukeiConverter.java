package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigTy;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 新契約収入Ｐ統計情報作成のコンバータークラス
 */
public class SrSinkeiyakuSyuunyuupToukeiConverter {

    public SrSinkeiyakuSyuunyuupToukeiConverter() {
        super();
    }

    public static void ztSkeisynyptoukeiksnTyConvertPadding(ZT_SkeisynyptoukeiksnTy pSkeisynyptoukeiksnTy) {

        pSkeisynyptoukeiksnTy.setZtyaatukaisosikicd(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtyaatukaisosikicd(), 7, '0'));
        pSkeisynyptoukeiksnTy.setZtyaatukaikojincd(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtyaatukaikojincd(), 6, '0'));
        pSkeisynyptoukeiksnTy.setZtyanniskcd(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtyanniskcd(), 8, '0'));
        pSkeisynyptoukeiksnTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtykykjiqpackhyj(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtykykjiqpackhyj(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtykyksyanen(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtykyksyanen(), 2, '0'));
        pSkeisynyptoukeiksnTy.setZtysaimnkkykhyj(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtysaimnkkykhyj(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtyjidoukousinhyouji(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtyjidoukousinhyouji(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtydai2hhknnen(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtydai2hhknnen(), 2, '0'));
        pSkeisynyptoukeiksnTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtyhhknnentysihyj(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtyhhknnentysihyj(), 1, '0'));
        pSkeisynyptoukeiksnTy.setZtysisuukbn(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtysisuukbn(), 2, '0'));
        pSkeisynyptoukeiksnTy.setZtyphrkkikn(
            Strings.padStart(pSkeisynyptoukeiksnTy.getZtyphrkkikn(), 2, '0'));
    }

    public static void ztSkeisynyptoukeirigTyConvertPadding(ZT_SkeisynyptoukeirigTy pSkeisynyptoukeirigTy) {

        pSkeisynyptoukeirigTy.setZtyaatukaisosikicd(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtyaatukaisosikicd(), 7, '0'));
        pSkeisynyptoukeirigTy.setZtyaatukaikojincd(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtyaatukaikojincd(), 6, '0'));
        pSkeisynyptoukeirigTy.setZtyanniskcd(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtyanniskcd(), 8, '0'));
        pSkeisynyptoukeirigTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtykykjiqpackhyj(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtykykjiqpackhyj(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtykyksyanen(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtykyksyanen(), 2, '0'));
        pSkeisynyptoukeirigTy.setZtysaimnkkykhyj(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtysaimnkkykhyj(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtyjidoukousinhyouji(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtyjidoukousinhyouji(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtydai2hhknnen(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtydai2hhknnen(), 2, '0'));
        pSkeisynyptoukeirigTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtyhhknnentysihyj(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtyhhknnentysihyj(), 1, '0'));
        pSkeisynyptoukeirigTy.setZtysisuukbn(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtysisuukbn(), 2, '0'));
        pSkeisynyptoukeirigTy.setZtyphrkkikn(
            Strings.padStart(pSkeisynyptoukeirigTy.getZtyphrkkikn(), 2, '0'));
    }

}