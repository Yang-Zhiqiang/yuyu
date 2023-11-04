package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckTyohyouHnbnKknSyoukenクラスのメソッド {@link CheckTyohyouHnbnKknSyouken#exec(IT_KykKihon,IT_HokenSyouken)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTyohyouHnbnKknSyoukenTest_exec {

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_帳票本番確認保険証券判定";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckMaxSStaniTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @SuppressWarnings("static-access")
    @Test
    @TestOrder(10)
    public void testExec_A1() {

        CheckTyohyouHnbnKknSyouken checkTyohyouHnbnKknSyouken = SWAKInjector.getInstance(CheckTyohyouHnbnKknSyouken.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11810111200");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20180401"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();

        HanteiKekkaBean hanteiKekkaBean = checkTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11809111114");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20180401"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("020");

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exNumericEquals(tyohyouHonbanKakuninBeanList.size(), 1, "帳票本番確認Beanリストのサイズ");

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "020", "条件分類１");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11810111129");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20180401"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("020");

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11810111130");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20180401"));

        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");

        jyoukenList.add(tyohyouHonbanKakuninBean);

        tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("020");

        jyoukenList.add(tyohyouHonbanKakuninBean);

        tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("030");

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exNumericEquals(tyohyouHonbanKakuninBeanList.size(), 2, "帳票本番確認Beanリストのサイズ");

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "020", "条件分類１");

        exStringEquals(tyohyouHonbanKakuninBeanList.get(1).getJyoukenbunrui1(), "030", "条件分類１");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100012");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "100", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100023");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "100", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100034");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100045");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100056");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100067");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SAISYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "100", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SAISYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100078");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SAISYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100089");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100090");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100104");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100115");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100126");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100137");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100148");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100159");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100160");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100171");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100182");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "110", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100193");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100207");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("60806100218");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20201005"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exListEquals(tyohyouHonbanKakuninBeanList, null, "帳票本番確認Beanリストのサイズ");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030409");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20210212"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("120");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SAISYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "120", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SAISYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");

        exNumericEquals(tyohyouHonbanKakuninBeanList.size(), 1, "帳票本番確認Beanリストのサイズ");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("21806000308");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20210412"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("130");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SKSYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "130", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SKSYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");

        exNumericEquals(tyohyouHonbanKakuninBeanList.size(), 1, "帳票本番確認Beanリストのサイズ");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("21806000010");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20210412"));
        List<TyohyouHonbanKakuninBean> jyoukenList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("130");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SAISYOUKEN);

        jyoukenList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(kykKihon, hokenSyouken, jyoukenList);

        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList();

        exStringEquals(tyohyouHonbanKakuninBeanList.get(0).getJyoukenbunrui1(), "130", "条件分類１");

        exClassificationEquals(tyohyouHonbanKakuninBeanList.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SAISYOUKEN, "書類コード");

        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");

        exNumericEquals(tyohyouHonbanKakuninBeanList.size(), 1, "帳票本番確認Beanリストのサイズ");
    }
}
