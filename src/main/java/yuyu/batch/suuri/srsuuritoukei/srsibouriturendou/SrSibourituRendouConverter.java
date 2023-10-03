package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import yuyu.def.db.entity.ZT_SbRituRendouTy;

import com.google.common.base.Strings;

/**
 * 数理統計 数理統計 死亡率用連動情報作成コンバーター
 */
public class SrSibourituRendouConverter {

    public static void convertPadding(ZT_SbRituRendouTy pZtSbRituRendouTy) {

        pZtSbRituRendouTy.setZtyaatukaisosikicd(Strings.padStart(pZtSbRituRendouTy.getZtyaatukaisosikicd(), 7, '0'));
        pZtSbRituRendouTy.setZtysykgycd(Strings.padStart(pZtSbRituRendouTy.getZtysykgycd(), 3, '0'));
        pZtSbRituRendouTy.setZtyaatukaikojincd(Strings.padStart(pZtSbRituRendouTy.getZtyaatukaikojincd(), 6, '0'));
        pZtSbRituRendouTy.setZtydakuhiketteiriyuucdx1(
            Strings.padStart(pZtSbRituRendouTy.getZtydakuhiketteiriyuucdx1(), 2, '0'));
        pZtSbRituRendouTy.setZtydakuhiketteiriyuucdx2(
            Strings.padStart(pZtSbRituRendouTy.getZtydakuhiketteiriyuucdx2(), 2, '0'));
        pZtSbRituRendouTy.setZtydakuhiketteiriyuucdx3(
            Strings.padStart(pZtSbRituRendouTy.getZtydakuhiketteiriyuucdx3(), 2, '0'));
        pZtSbRituRendouTy.setZtydakuhiketteiriyuucdx4(
            Strings.padStart(pZtSbRituRendouTy.getZtydakuhiketteiriyuucdx4(), 2, '0'));
        pZtSbRituRendouTy.setZtykawaseratetekiyouymd(
            Strings.padStart(pZtSbRituRendouTy.getZtykawaseratetekiyouymd(), 8, '0'));
        pZtSbRituRendouTy.setZtykituenhonsuu(
            Strings.padStart(pZtSbRituRendouTy.getZtykituenhonsuu(), 2, '0'));
        pZtSbRituRendouTy.setZtykeiyakukakuninsyuruikbn(
            Strings.padStart(pZtSbRituRendouTy.getZtykeiyakukakuninsyuruikbn(), 2, '0'));
        pZtSbRituRendouTy.setZtykykjiqpackhyj(
            Strings.padStart(pZtSbRituRendouTy.getZtykykjiqpackhyj(), 1, '0'));
        pZtSbRituRendouTy.setZtykeikanensuux1(
            Strings.padStart(pZtSbRituRendouTy.getZtykeikanensuux1(), 2, '0'));
        pZtSbRituRendouTy.setZtykeikanensuux2(
            Strings.padStart(pZtSbRituRendouTy.getZtykeikanensuux2(), 2, '0'));
        pZtSbRituRendouTy.setZtysaimnkkykhyj(
            Strings.padStart(pZtSbRituRendouTy.getZtysaimnkkykhyj(), 1, '0'));
        pZtSbRituRendouTy.setZtyhhknnentysihyj(
            Strings.padStart(pZtSbRituRendouTy.getZtyhhknnentysihyj(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x10(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x10(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x11(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x11(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x12(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x12(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x13(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x13(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x14(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x14(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x15(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x15(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x5(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x5(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x6(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x6(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x7(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x7(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x8(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x8(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi1x9(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi1x9(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x10(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x10(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x3(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x3(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x4(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x4(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x5(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x5(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x6(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x6(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x7(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x7(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x8(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x8(), 1, '0'));
        pZtSbRituRendouTy.setZtyhokensyuruikigouyobi3x9(
            Strings.padStart(pZtSbRituRendouTy.getZtyhokensyuruikigouyobi3x9(), 1, '0'));

    }
}
