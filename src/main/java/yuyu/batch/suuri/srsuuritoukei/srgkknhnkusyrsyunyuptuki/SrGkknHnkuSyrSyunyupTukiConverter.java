package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;

import com.google.common.base.Strings;

/**
 * 数理 数理統計 月間変更処理収入Ｐ統計情報作成のコンバータークラス
 */
public class SrGkknHnkuSyrSyunyupTukiConverter {

    public SrGkknHnkuSyrSyunyupTukiConverter() {
        super();
    }

    public static void convertPadding(ZT_GkknHnkuSyrSynypTukiTy pGkknHnkuSyrSynypTukiTy) {

        pGkknHnkuSyrSynypTukiTy.setZtyaatukaisosikicd(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtyaatukaisosikicd(), 7, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtyaatukaikojincd(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtyaatukaikojincd(), 6, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtyanniskcd(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtyanniskcd(), 8, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtysotodasiphkbnmnoshyouji(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtysotodasiphkbnmnoshyouji(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtystdsstkjytkyuhyj(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtystdsstkjytkyuhyj(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtykykjiqpackhyj(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtykykjiqpackhyj(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtykyksyanen(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtykyksyanen(), 2, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtysaimnkkykhyj(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtysaimnkkykhyj(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtyjidoukousinhyouji(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtyjidoukousinhyouji(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtydai2hhknnen(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtydai2hhknnen(), 2, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtydai2hhknnentysihyj(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtydai2hhknnentysihyj(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtyhhknnentysihyj(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtyhhknnentysihyj(), 1, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtysisuukbn(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtysisuukbn(), 2, '0'));
        pGkknHnkuSyrSynypTukiTy.setZtyphrkkikn(
            Strings.padStart(pGkknHnkuSyrSynypTukiTy.getZtyphrkkikn(), 2, '0'));
    }
}