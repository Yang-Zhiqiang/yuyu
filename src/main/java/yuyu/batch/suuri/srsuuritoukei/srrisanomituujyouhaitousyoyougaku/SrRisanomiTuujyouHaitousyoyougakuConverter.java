package yuyu.batch.suuri.srsuuritoukei.srrisanomituujyouhaitousyoyougaku;

import yuyu.common.suuri.srcommon.RisanomiTjHitsyyugkParam;
import com.google.common.base.Strings;

/**
 * 数理 数理統計 利差のみ通常配当所要額情報のコンバータークラス
 */
public class SrRisanomiTuujyouHaitousyoyougakuConverter {

    public SrRisanomiTuujyouHaitousyoyougakuConverter() {
        super();
    }

    public static void convertPadding(RisanomiTjHitsyyugkParam pRisanomiTjHitsyyugkParam) {

        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x10(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x10(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x11(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x11(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x12(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x12(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x13(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x13(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x14(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x14(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x15(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x15(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x5(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x5(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x6(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x6(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x7(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x7(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x8(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x8(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi1x9(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi1x9(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x10(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x10(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x3(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x3(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x4(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x4(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x5(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x5(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x6(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x6(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x7(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x7(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x8(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x8(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtyhokensyuruikigouyobi3x9(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyhokensyuruikigouyobi3x9(), 1, '0'));
        pRisanomiTjHitsyyugkParam.setZtykawaseratetekiyouymd(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtykawaseratetekiyouymd(), 8, '0'));
        pRisanomiTjHitsyyugkParam.setZtyphrkkikn(
            Strings.padStart(pRisanomiTjHitsyyugkParam.getZtyphrkkikn(), 2, '0'));

    }

}