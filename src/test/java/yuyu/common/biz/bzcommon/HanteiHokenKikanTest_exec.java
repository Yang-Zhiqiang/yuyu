package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険期間判定クラスのメイン処理{@link HanteiHokenKikan#exec(HanteiHokenKikanBean pHanteiHokenKikanBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiHokenKikanTest_exec {

    @Inject
    private HanteiHokenKikan hanteiHokenKikan;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.BLNK, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), null, "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20180401"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.BLNK, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), null, "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180330"));
        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180331"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20180401"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.NONE);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.BLNK, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), null, "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20180421"));

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.BLNK, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), null, "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20180331"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20200331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20180401"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20190401"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20200401"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20180402"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.BLNK, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), null, "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), null, "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180330"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180331"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20180401"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20190330"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20190331"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI3HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20170331"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20190401"));

        hanteiHokenKikanBean.setDai1hknkkn(1);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(2);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI3HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20180331"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20190331"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(1010)
    public void testExec_B1() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20200229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20250228"));

        hanteiHokenKikanBean.setDai1hknkkn(5);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20250301"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20350301"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(1020)
    public void testExec_B2() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20200229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20250301"));

        hanteiHokenKikanBean.setDai1hknkkn(5);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20250301"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20350301"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(1030)
    public void testExec_B3() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20200229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20350228"));

        hanteiHokenKikanBean.setDai1hknkkn(5);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20250301"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20350301"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(1040)
    public void testExec_B4() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20200229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20350301"));

        hanteiHokenKikanBean.setDai1hknkkn(5);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕｱ");
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI3HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20250301"), "メンバ変数．第２保険期間開始日");

        exDateEquals(hanteiHokenKikan.getDai3HknkknStartYmd(), BizDate.valueOf("20350301"), "メンバ変数．第３保険期間開始日");

    }

    @Test
    @TestOrder(1050)
    public void testExec_B5() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20200229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20220228"));

        hanteiHokenKikanBean.setDai1hknkkn(2);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾉ");
        syouhnZokusei.setMvatekikkn(99);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20220301"), "メンバ変数．第２保険期間開始日");

    }

    @Test
    @TestOrder(1060)
    public void testExec_B6() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20200229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20220301"));

        hanteiHokenKikanBean.setDai1hknkkn(2);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾕﾉ");
        syouhnZokusei.setMvatekikkn(99);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20220301"), "メンバ変数．第２保険期間開始日");

    }

    @Test
    @TestOrder(1070)
    public void testExec_B7() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20240229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20290227"));

        hanteiHokenKikanBean.setDai1hknkkn(5);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾆｱ");
        syouhnZokusei.setMvatekikkn(99);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI1HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20290228"), "メンバ変数．第２保険期間開始日");

    }

    @Test
    @TestOrder(1080)
    public void testExec_B8() {

        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(BizDate.valueOf("20240229"));

        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.valueOf("20290228"));

        hanteiHokenKikanBean.setDai1hknkkn(5);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("ﾆｱ");
        syouhnZokusei.setMvatekikkn(99);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);

        C_HknKknKbn cHknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

        exClassificationEquals(cHknKknKbn, C_HknKknKbn.DAI2HKNKKN, "保険期間区分");

        exDateEquals(hanteiHokenKikan.getDai2HknkknStartYmd(), BizDate.valueOf("20290228"), "メンバ変数．第２保険期間開始日");

    }

}
