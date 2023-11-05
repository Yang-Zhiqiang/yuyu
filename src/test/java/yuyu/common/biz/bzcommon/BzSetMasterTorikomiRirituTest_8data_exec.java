package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_RirituSyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * マスタ取込利率設定クラスのメソッド {@link BzSetMasterTorikomiRiritu#exec(int)} テスト用クラスです。 <br />
 */
@RunWith(OrderedRunner.class)
public class BzSetMasterTorikomiRirituTest_8data_exec {

    @Inject
    private BzSetMasterTorikomiRiritu bzSetMasterTorikomiRiritu;

    @Test
    @TestOrder(10)
    public void testExce_A1() {

        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu.exec(C_RirituSyuruiKbn.YOTEIRIRITU);

        BM_YoteiRiritu3 yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(0);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｱ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0375),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(1);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｲ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0300),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(2);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｳ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0375),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(3);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｴ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0300),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(4);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｵ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0375),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(5);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｶ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0300),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(6);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｷ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0375),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(7);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｸ","商品コード");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0300),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");


        assertEquals(bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList(),null);

    }

    @Test
    @TestOrder(20)
    public void testExce_A2() {

        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu.exec(C_RirituSyuruiKbn.SJKKKTYOUSEIYOURIRITU);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(0);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｱ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0297),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(1);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｲ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0220),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(2);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｳ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0297),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(3);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｴ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0220),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(4);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｵ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0297),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(5);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｶ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0220),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(6);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｷ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0297),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(7);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｸ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20180701),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20180715),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0220),"市場価格調整用利率");


        assertEquals(bzSetMasterTorikomiRirituBean.getYoteiRirituList(),null);

    }

    @Test
    @TestOrder(30)
    public void testExce_A3() {

        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu.exec(C_RirituSyuruiKbn.BLNK);

        assertEquals(bzSetMasterTorikomiRirituBean.getYoteiRirituList(),null);
        assertEquals(bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList(),null);


    }

    @Test
    @TestOrder(40)
    public void testExce_A4() {

        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu.exec(null);

        assertEquals(bzSetMasterTorikomiRirituBean.getYoteiRirituList(),null);
        assertEquals(bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList(),null);

    }
}
