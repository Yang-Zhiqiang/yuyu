package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
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
public class BzSetMasterTorikomiRirituTest_exec {

    @Test
    @TestOrder(10)
    public void testExce_A1() {

        BzSetMasterTorikomiRiritu bzSetMasterTorikomiRiritu = SWAKInjector.getInstance(BzSetMasterTorikomiRiritu.class);
        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu.exec(C_RirituSyuruiKbn.YOTEIRIRITU);

        BM_YoteiRiritu3 yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(8);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｹ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(9);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｺ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.015),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.005),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.006),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(10);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｻ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(11);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｼ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(12);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｽ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(13);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｾ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(14);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕｿ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(15);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾀ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0060),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(1.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(16);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾁ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0093),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(17);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾂ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0093),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");


        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(18);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾃ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0093),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(19);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾄ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0093),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(20);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾅ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0092),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(21);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾆ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0092),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(22);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾇ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0092),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(23);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾈ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20210101),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20210101),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0092),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0000),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getTmttknzoukaritujygn(),BizNumber.valueOf(0.0000),"積立金増加率上限");
        exBizCalcbleEquals(yoteiRiritu.getSetteibairitu(),BizNumber.valueOf(0.00),"設定倍率");
        exBizCalcbleEquals(yoteiRiritu.getLoadinghnkgtumitateriritu(),BizNumber.valueOf(0.0000),"ローディング変更後積立利率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(28);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾍ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0065),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0015),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0685),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(29);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾍ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(30);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾎ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0065),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0015),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0685),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(31);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾎ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(32);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾏ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0065),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0015),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0685),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(33);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾏ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(34);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾐ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.00650),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0015),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0685),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(35);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾐ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(36);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾕ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0060),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0010),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0455),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(37);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾕ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(38);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾖ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0060),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0010),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0455),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(39);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾖ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(40);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾗ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0060),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0010),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0455),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(41);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾗ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(42);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾘ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"5","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0060),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0010),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.0455),"連動率");

        yoteiRiritu = bzSetMasterTorikomiRirituBean.getYoteiRirituList().get(43);

        exStringEquals(yoteiRiritu.getSyouhncd(),"ﾕﾘ","商品コード");
        exClassificationEquals(yoteiRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr1(),"10","予定利率適用分類１");
        exStringEquals(yoteiRiritu.getYoteiriritutkybr2(),"","予定利率適用分類２");
        exDateEquals(yoteiRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(yoteiRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exBizCalcbleEquals(yoteiRiritu.getYoteiriritu(),BizNumber.valueOf(0.0150),"予定利率");
        exBizCalcbleEquals(yoteiRiritu.getTumitateriritu(),BizNumber.valueOf(0.0050),"積立利率");
        exBizCalcbleEquals(yoteiRiritu.getRendouritu(),BizNumber.valueOf(0.2240),"連動率");

        assertEquals(bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList(),null);

    }

    @Test
    @TestOrder(20)
    public void testExce_A2() {

        BzSetMasterTorikomiRiritu bzSetMasterTorikomiRiritu = SWAKInjector.getInstance(BzSetMasterTorikomiRiritu.class);
        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu.exec(C_RirituSyuruiKbn.SJKKKTYOUSEIYOURIRITU);

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(8);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｹ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(9);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｹ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(10);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｺ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(11);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｺ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(12);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｻ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(13);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｻ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(14);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｼ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(15);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｼ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(16);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｽ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(17);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｽ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(18);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｾ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(19);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｾ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(20);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｿ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(21);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕｿ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(22);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾀ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(23);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾀ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(24);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾉ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0234),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(25);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾊ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0139),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(26);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾋ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0234),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(27);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾌ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0139),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(28);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾍ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(29);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾍ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(30);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾎ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(31);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾎ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(32);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾏ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(33);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾏ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(34);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾐ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0110),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(35);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾐ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0192),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(36);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾕ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(37);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾕ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(38);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾖ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(39);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾖ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(40);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾗ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(41);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾗ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(42);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾘ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"5","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0047),"市場価格調整用利率");

        sjkkkTyouseiyouRiritu = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList().get(43);

        exStringEquals(sjkkkTyouseiyouRiritu.getSyouhncd(),"ﾕﾘ","商品コード");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr1(),"10","市場価格調整用利率適用分類１");
        exStringEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiriritutkybr2(),"","市場価格調整用利率適用分類２");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyunfromymd(),BizDate.valueOf(20201201),"基準日自");
        exDateEquals(sjkkkTyouseiyouRiritu.getKijyuntoymd(),BizDate.valueOf(20201215),"基準日至");
        exClassificationEquals(sjkkkTyouseiyouRiritu.getTuukasyu(),C_Tuukasyu.AUD,"通貨種類");
        exBizCalcbleEquals(sjkkkTyouseiyouRiritu.getSjkkktyouseiyouriritu(),BizNumber.valueOf(0.0127),"市場価格調整用利率");

        assertEquals(bzSetMasterTorikomiRirituBean.getYoteiRirituList(),null);
    }
}
