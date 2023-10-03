package yuyu.batch.suuri.srsuuritoukei.srtuujyouhaitousyoyougaku;

import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import com.google.common.base.Strings;

/**
 * 数理 数理統計 通常配当所要額情報作成のコンバータークラス
 */
public class SrTuujyouHaitousyoyougakuConverter {

    public SrTuujyouHaitousyoyougakuConverter() {
        super();
    }

    public static void convertPadding(TuujyuHitusyyugkParam pTuujyuHitusyyugkParam) {

        pTuujyuHitusyyugkParam.setZtysaimnkkykhyj(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtysaimnkkykhyj(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtytenkankaisuu(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtytenkankaisuu(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x10(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x10(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x11(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x11(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x12(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x12(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x13(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x13(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x14(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x14(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x15(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x15(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x5(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x5(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x6(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x6(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x7(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x7(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x8(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x8(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi1x9(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi1x9(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x10(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x10(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x3(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x3(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x4(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x4(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x5(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x5(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x6(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x6(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x7(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x7(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x8(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x8(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtyhokensyuruikigouyobi3x9(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyhokensyuruikigouyobi3x9(), 1, '0'));
        pTuujyuHitusyyugkParam.setZtykawaseratetekiyouymd(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtykawaseratetekiyouymd(), 8, '0'));
        pTuujyuHitusyyugkParam.setZtyphrkkikn(
            Strings.padStart(pTuujyuHitusyyugkParam.getZtyphrkkikn(), 2, '0'));

    }

}