package yuyu.common.hozen.khcommon;

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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 帳票本番確認手続完了通知判定クラスのメソッド {@link CheckTyohyouHnbnKknTtdkKanryou#exec(IT_KykKihon, IT_TtdkKan, List<TyohyouHonbanKakuninBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTyohyouHnbnKknTtdkKanryouTest_exec {

    @Inject
    private HozenDomManager hozenManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_帳票本番確認手続完了通知判定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTmttkinItenTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }


    @Test
    @TestOrder(360)
    public void testExec_A36() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100012");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("090");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);
        tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("090");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "090", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100023");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("090");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);
        tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("090");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100034");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("090");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100045");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);


        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "100", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100056");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "100", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100067");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100078");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100089");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("100");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100506");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("002");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "002", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100517");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("001");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100528");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("002");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100539");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("002");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }


    @Test
    @TestOrder(480)
    public void testExec_A48() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100540");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("004");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "004", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100551");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("004");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100562");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("005");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100573");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("005");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "005", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100584");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("005");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100595");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("004");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }


    @Test
    @TestOrder(540)
    public void testExec_A54() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100609");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("006");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "006", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100610");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("006");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100621");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("007");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }


    @Test
    @TestOrder(570)
    public void testExec_A57() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100632");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("007");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "007", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100643");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("007");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100654");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("006");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }


    @Test
    @TestOrder(600)
    public void testExec_A60() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100665");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "012", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100676");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100687");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("013");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100698");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("013");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "013", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100702");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("013");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100713");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }


    @Test
    @TestOrder(660)
    public void testExec_A66() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100724");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("019");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "019", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100735");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("019");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100746");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("020");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }


    @Test
    @TestOrder(690)
    public void testExec_A69() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100757");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("020");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "080", "条件分類１");
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui2(), "020", "条件分類２");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100768");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("020");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("60806100779");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000010");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("080");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("019");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exListEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList(), null, "帳票本番確認Beanリスト");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.NONE, "更新区分");
    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("99806030409");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000170");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリストのサイズ");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "110", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("99806032009");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000110");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("110");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "110", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("21806000308");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000110");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("120");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "120", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("21806000010");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000110");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("120");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "120", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("21806000319");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000110");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("120");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "120", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("21806000320");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000110");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("120");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "120", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

    @Test
    @TestOrder(780)
    public void testExec_A78() {

        IT_KykKihon kykkihon = hozenManager.getKykKihon("21806000032");
        IT_TtdkKan ttdkKan = kykkihon.getTtdkKanByHenkousikibetukey("000000000000000110");
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninList = new ArrayList<>();
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = new TyohyouHonbanKakuninBean();
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("120");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR);
        tyohyouHonbanKakuninList.add(tyohyouHonbanKakuninBean);

        HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(kykkihon, ttdkKan,
            tyohyouHonbanKakuninList);

        exNumericEquals(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size(), 1, "帳票本番確認Beanリスト");
        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBeanO = hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().get(0);
        exStringEquals(tyohyouHonbanKakuninBeanO.getJyoukenbunrui1(), "120", "条件分類１");
        exClassificationEquals(tyohyouHonbanKakuninBeanO.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exClassificationEquals(hanteiKekkaBean.getUpdateKbn(), C_UmuKbn.ARI, "更新区分");
    }

}