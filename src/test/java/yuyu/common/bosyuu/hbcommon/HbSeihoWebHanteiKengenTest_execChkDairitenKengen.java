package yuyu.common.bosyuu.hbcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.configuration.YuyuBosyuuConfig;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ権限判定 {@link HbSeihoWebHanteiKengen#execChkDairitenKengen(WsBzWebserviceReqParamBean,
 *  List<BzGetAgInfoBean>, List<BzGetAgInfoBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbSeihoWebHanteiKengenTest_execChkDairitenKengen {

    @Inject
    private HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ権限判定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebHanteiKengenTest_execChkDairitenKengen.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }

    @Test
    @TestOrder(10)
    public void testExecChkDairitenKengen_A1() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("123456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            null, null);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(20)
    public void testExecChkDairitenKengen_A2() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        wsBzWebserviceReqParamBean.setOperatorId("123456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(30)
    public void testExecChkDairitenKengen_A3() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();

        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("5134567");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(40)
    public void testExecChkDairitenKengen_A4() {

        YuyuBosyuuConfig.getInstance().addSyoukaiKanouDrtnCd("2101079");

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456749012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("2101079");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.BLNK);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(50)
    public void testExecChkDairitenKengen_A5() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456759012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(60)
    public void testExecChkDairitenKengen_A6() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();

        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("5834567");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.BLNK);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.KEIYAKUERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(70)
    public void testExecChkDairitenKengen_A7() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana0 = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeana1 = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeana2 = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb0 = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb1 = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb2 = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456779012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana0.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
        bzGetAgInfoBeana0.setDrtenCd("1300071");
        bzGetAgInfoBeana0.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.BLNK);
        bzGetAgInfoBeana1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
        bzGetAgInfoBeana1.setDrtenCd("1300071");
        bzGetAgInfoBeana1.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.BLNK);
        bzGetAgInfoBeana2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana2.setDrtenCd("1300071");
        bzGetAgInfoBeana2.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb0.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
        bzGetAgInfoBeanb0.setDrtenCd("1300072");
        bzGetAgInfoBeanb1.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.SHITEIKO);
        bzGetAgInfoBeanb1.setDrtenCd("1300072");
        bzGetAgInfoBeanb2.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb2.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana0);
        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana1);
        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana2);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb0);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb1);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb2);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(80)
    public void testExecChkDairitenKengen_A8() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("013456769012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(90)
    public void testExecChkDairitenKengen_A9() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("563456769012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(100)
    public void testExecChkDairitenKengen_A10() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("593456769012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }


    @Test
    @TestOrder(110)
    public void testExecChkDairitenKengen_A11() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("063456769012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }


    @Test
    @TestOrder(120)
    public void testExecChkDairitenKengen_A12() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = null;

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456889012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(130)
    public void testExecChkDairitenKengen_A13() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456799012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }


    @Test
    @TestOrder(140)
    public void testExecChkDairitenKengen_A14() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456809012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("1300071");

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(150)
    public void testExecChkDairitenKengen_A15() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstA = new ArrayList<>();

        List<BzGetAgInfoBean> bzGetAgInfoBeanLstB = new ArrayList<>();

        BzGetAgInfoBean bzGetAgInfoBeana = new BzGetAgInfoBean();
        BzGetAgInfoBean bzGetAgInfoBeanb = new BzGetAgInfoBean();

        wsBzWebserviceReqParamBean.setOperatorId("013456769012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        bzGetAgInfoBeana.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeana.setDrtenCd("");
        bzGetAgInfoBeana.setMdhnSchemeDrtenHyouji(C_MdhnSchemeDrtenHyouji.MDHNSCHEME);

        bzGetAgInfoBeanb.setDiritenJyouhouKbn(C_DiritenjyouhouKbn.KEISYOUOYA);
        bzGetAgInfoBeanb.setDrtenCd("1300072");

        bzGetAgInfoBeanLstA.add(bzGetAgInfoBeana);
        bzGetAgInfoBeanLstB.add(bzGetAgInfoBeanb);

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(wsBzWebserviceReqParamBean,
            bzGetAgInfoBeanLstA, bzGetAgInfoBeanLstB);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.DRTENSYOUKAERROR, "生保Ｗｅｂ権限区分");
    }
}
