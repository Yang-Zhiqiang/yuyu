package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummaryMock;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSkKihonKanri(SiSetUiBeanSetSkKihonKanriUiBeanParam, List<DoujiSeikyuuInfosBySknoSyonoNeBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSkKihonKanri {

    @Inject
    private SiSetUiBeanSetSkKihonKanriUiBeanParamImpl siSetUiBeanSetSkKihonKanriUiBeanParamImpl;

    @Inject
    private SiSetUiBean siSetUiBean;

    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMock.caller = SiSetUiBeanTest_setSkKihonKanri.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMock.caller = null;
        BzGetProcessSummaryMock.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testSetSkKihonKanri_A1() {

        siSetUiBeanSetSkKihonKanriUiBeanParamImpl = null;

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = new ArrayList<>();
        DoujiSeikyuuInfosBySknoSyonoNeBean doujiSeikyuuInfosBySknoSyonoNeBean =
            new DoujiSeikyuuInfosBySknoSyonoNeBean(
                "001",
                "10000000001",
                null,
                C_SyoriJyoutaiKbn.KANRYOU,
                C_HubiJyoukyouKbn.HUBI,
                C_TyousaJyoukyouKbn.HUBI,
                BizDate.valueOf(20150101));

        doujiSeikyuuInfosBySknoSyonoNeBeanLst.add(doujiSeikyuuInfosBySknoSyonoNeBean);

        boolean result = siSetUiBean.setSkKihonKanri(siSetUiBeanSetSkKihonKanriUiBeanParamImpl,
            doujiSeikyuuInfosBySknoSyonoNeBeanLst);

        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(20)
    public void testSetSkKihonKanri_A2() {

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = null;

        boolean result = siSetUiBean.setSkKihonKanri(siSetUiBeanSetSkKihonKanriUiBeanParamImpl,
            doujiSeikyuuInfosBySknoSyonoNeBeanLst);

        List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> skKihonKanriInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetSkKihonKanriUiBeanParamImpl
            .getSkKihonKanriInfo();

        exBooleanEquals(result, false, "結果");

        Assert.assertNull(skKihonKanriInfoDataSourceBeanCommonParamImplLst);
    }

    @Test
    @TestOrder(30)
    public void testSetSkKihonKanri_A3() {

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = new ArrayList<>();

        boolean result = siSetUiBean.setSkKihonKanri(siSetUiBeanSetSkKihonKanriUiBeanParamImpl,
            doujiSeikyuuInfosBySknoSyonoNeBeanLst);

        List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> skKihonKanriInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetSkKihonKanriUiBeanParamImpl
            .getSkKihonKanriInfo();

        exBooleanEquals(result, true, "結果");
        exNumericEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.size(), 0, "データ格納用のリストの件数");
    }

    @Test
    @TestOrder(40)
    public void testSetSkKihonKanri_A4() {

        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN2;

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = new ArrayList<>();
        DoujiSeikyuuInfosBySknoSyonoNeBean doujiSeikyuuInfosBySknoSyonoNeBean =
            new DoujiSeikyuuInfosBySknoSyonoNeBean(
                "001",
                "10000000001",
                null,
                C_SyoriJyoutaiKbn.SYORITYUU,
                C_HubiJyoukyouKbn.HUBI,
                C_TyousaJyoukyouKbn.HUBI,
                BizDate.valueOf(20150101));

        doujiSeikyuuInfosBySknoSyonoNeBeanLst.add(doujiSeikyuuInfosBySknoSyonoNeBean);

        boolean result = siSetUiBean.setSkKihonKanri(siSetUiBeanSetSkKihonKanriUiBeanParamImpl,
            doujiSeikyuuInfosBySknoSyonoNeBeanLst);

        List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> skKihonKanriInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetSkKihonKanriUiBeanParamImpl
            .getSkKihonKanriInfo();

        exBooleanEquals(result, true, "結果");

        exNumericEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.size(), 1, "データ格納用のリストの件数");

        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispsyono(), "10000000001",
            "（表示用）証券番号");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispskno(), "001", "（表示用）請求番号");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDisphubikbn(),
            C_HubiJyoukyouKbn.HUBI, "（表示用）不備区分");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDisptyousajkkbn(),
            C_TyousaJyoukyouKbn.HUBI, "（表示用）調査区分");
        exDateEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispsyoriymd(),
            BizDate.valueOf(20150101), "（表示用）処理日");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispnextsyorinm(), "", "（表示用）次処理名");
    }

    @Test
    @TestOrder(50)
    public void testSetSkKihonKanri_A5() {

        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;

        List<DoujiSeikyuuInfosBySknoSyonoNeBean> doujiSeikyuuInfosBySknoSyonoNeBeanLst = new ArrayList<>();
        DoujiSeikyuuInfosBySknoSyonoNeBean doujiSeikyuuInfosBySknoSyonoNeBean =
            new DoujiSeikyuuInfosBySknoSyonoNeBean(
                "001",
                "10000000001",
                null,
                C_SyoriJyoutaiKbn.SYORITYUU,
                C_HubiJyoukyouKbn.HUBI,
                C_TyousaJyoukyouKbn.HUBI,
                BizDate.valueOf(20150101));

        DoujiSeikyuuInfosBySknoSyonoNeBean doujiSeikyuuInfosBySknoSyonoNeBean2 =
            new DoujiSeikyuuInfosBySknoSyonoNeBean(
                "002",
                "10000000002",
                null,
                C_SyoriJyoutaiKbn.KANRYOU,
                C_HubiJyoukyouKbn.KAISYOU,
                C_TyousaJyoukyouKbn.KAITOU,
                BizDate.valueOf(20150202));

        DoujiSeikyuuInfosBySknoSyonoNeBean doujiSeikyuuInfosBySknoSyonoNeBean3 =
            new DoujiSeikyuuInfosBySknoSyonoNeBean(
                "003",
                "10000000003",
                null,
                C_SyoriJyoutaiKbn.KANRYOU,
                C_HubiJyoukyouKbn.HUBI,
                C_TyousaJyoukyouKbn.KAITOU,
                BizDate.valueOf(20150303));

        doujiSeikyuuInfosBySknoSyonoNeBeanLst.add(doujiSeikyuuInfosBySknoSyonoNeBean);
        doujiSeikyuuInfosBySknoSyonoNeBeanLst.add(doujiSeikyuuInfosBySknoSyonoNeBean2);
        doujiSeikyuuInfosBySknoSyonoNeBeanLst.add(doujiSeikyuuInfosBySknoSyonoNeBean3);

        boolean result = siSetUiBean.setSkKihonKanri(siSetUiBeanSetSkKihonKanriUiBeanParamImpl,
            doujiSeikyuuInfosBySknoSyonoNeBeanLst);

        List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> skKihonKanriInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetSkKihonKanriUiBeanParamImpl
            .getSkKihonKanriInfo();

        exBooleanEquals(result, true, "結果");

        exNumericEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.size(), 3, "データ格納用のリストの件数");

        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispsyono(), "10000000001",
            "（表示用）証券番号");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispskno(), "001", "（表示用）請求番号");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDisphubikbn(),
            C_HubiJyoukyouKbn.HUBI, "（表示用）不備区分");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDisptyousajkkbn(),
            C_TyousaJyoukyouKbn.HUBI, "（表示用）調査区分");
        exDateEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispsyoriymd(),
            BizDate.valueOf(20150101), "（表示用）処理日");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(0).getDispnextsyorinm(), "現在ノード名001",
            "（表示用）次処理名");

        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(1).getDispsyono(), "10000000002",
            "（表示用）証券番号");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(1).getDispskno(), "002", "（表示用）請求番号");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(1).getDisphubikbn(),
            C_HubiJyoukyouKbn.KAISYOU, "（表示用）不備区分");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(1).getDisptyousajkkbn(),
            C_TyousaJyoukyouKbn.KAITOU, "（表示用）調査区分");
        exDateEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(1).getDispsyoriymd(),
            BizDate.valueOf(20150202), "（表示用）処理日");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(1).getDispnextsyorinm(), "完了", "（表示用）次処理名");

        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(2).getDispsyono(), "10000000003",
            "（表示用）証券番号");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(2).getDispskno(), "003", "（表示用）請求番号");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(2).getDisphubikbn(),
            C_HubiJyoukyouKbn.HUBI, "（表示用）不備区分");
        exClassificationEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(2).getDisptyousajkkbn(),
            C_TyousaJyoukyouKbn.KAITOU, "（表示用）調査区分");
        exDateEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(2).getDispsyoriymd(),
            BizDate.valueOf(20150303), "（表示用）処理日");
        exStringEquals(skKihonKanriInfoDataSourceBeanCommonParamImplLst.get(2).getDispnextsyorinm(), "完了", "（表示用）次処理名");
    }
}
