package yuyu.common.hozen.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全必要書類判定クラスのメソッド {@link KhHituyousyoruiHantei#exec(KhHituyousyoruiHanteiInBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KhHituyousyoruiHanteiTest_exec {

    @Inject
    private KhHituyousyoruiHantei khHituyousyoruiHantei;
    @Inject
    private BizDomManager bizDomManager;
    @Inject
    private KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約保全必要書類判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KhHituyousyoruiHanteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10001");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10001");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10001", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_ADRHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_ADRHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10002");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10002");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10002", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_ADRHNK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_ADRHNK_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10003");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10003");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_ADRHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_ADRHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10004");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10004");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 3, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 3, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdList.get(1), C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdList.get(2), C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK, "書類コードリスト[2]");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10005");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10005");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10005", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10006");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10006");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10006", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MEIGIHNK_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10007");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10007");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10007", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10008");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HUKKATU);
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10008");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10009");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HUKKATU);
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10009");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10010");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10010");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 2, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10010", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10010", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 2, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdList.get(1), C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN, "書類コードリスト[1]");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10011");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10011");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10011", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10012");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10012");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10012", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIYAKU_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10013");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10013");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10013", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10014");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10014");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10014", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_GENGAKU_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10015");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10015");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10015", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_GENGAKU_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10016");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10016");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10016", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_GENGAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_GENGAKU_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10017");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10017");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10017", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10018");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10018");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10018", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10019");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10019");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10019", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10020");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10020");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10020", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SYOSAIHK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SYOSAIHK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10021");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10021");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10021", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SYOSAIHK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SYOSAIHK_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10022");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10022");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10022", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SYOSAIHK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SYOSAIHK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10023");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HUKKATU);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10023");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10024");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10024");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10025");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10025");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10025", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SBKAIJYO_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SBKAIJYO_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10026");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10026");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10027");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MENSEKI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10027");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10028");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MENSEKI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10028");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10029");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MENSEKI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10029");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10030");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10030");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10031");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10031");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10031", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KYKTORIKESI_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KYKTORIKESI_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10032");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10032");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10033");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10033");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10034");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10034");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10034", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIJYO_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIJYO_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10035");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10035");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10036");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10036");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10036", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_CLGOFF_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_CLGOFF_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10037");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10037");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10038");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10038");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10038", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MUKOU_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MUKOU_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10039");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10039");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10040");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_NENKINSHRTKYKHNK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10040");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10041");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_NENKINSHRTKYKHNK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10041");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10042");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_NENKINSHRTKYKHNK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10042");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10043");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10043");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10043", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_STDRHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_STDRHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10044");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10044");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10044", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_STDRHNK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_STDRHNK_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(450)
    public void testExec_A45() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10045");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10045");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10045", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_STDRHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_STDRHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(460)
    public void testExec_A46() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10046");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_TARGETTKYKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10046");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(470)
    public void testExec_A47() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10047");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_TARGETTKYKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10047");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(480)
    public void testExec_A48() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10048");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_TARGETTKYKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10048");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(490)
    public void testExec_A49() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10049");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SHRKOUZAJYHHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10049");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(500)
    public void testExec_A50() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10050");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SHRKOUZAJYHHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10050");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(510)
    public void testExec_A51() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10051");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SHRKOUZAJYHHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10051");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(),0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(520)
    public void testExec_A52() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10052");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_GANMUKOU);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10052");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(530)
    public void testExec_A53() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10053");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MOUSIDEMUKOU);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10053");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(540)
    public void testExec_A54() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10054");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10054");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 2, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10054", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10054", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 2, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdList.get(1), C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN, "書類コードリスト[1]");
    }

    @Test
    @Transactional
    @TestOrder(550)
    public void testExec_A55() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10055");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10055");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 2, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10055", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10055", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 2, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MEIGIHNK_SKS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdList.get(1), C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK, "書類コードリスト[1]");
    }

    @Test
    @Transactional
    @TestOrder(560)
    public void testExec_A56() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10056");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10056");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 2, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10056", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10056", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 2, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdList.get(1), C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN, "書類コードリスト[1]");

    }

    @Test
    @Transactional
    @TestOrder(570)
    public void testExec_A57() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10057");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
        khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10057");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10057", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIYAKU_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(580)
    public void testExec_B1() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10058");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10058");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10058", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(590)
    public void testExec_B2() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10059");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10059");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10059", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(600)
    public void testExec_B3() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10060");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10060");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10060", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOU_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SBMUKOU_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(610)
    public void testExec_B4() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10061");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10061");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(620)
    public void testExec_B5() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10062");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10062");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10062", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(630)
    public void testExec_B6() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10063");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10063");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(640)
    public void testExec_B7() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10064");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10064");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10064", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKI_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SBMENSEKI_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(650)
    public void testExec_B8() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10065");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10065");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(660)
    public void testExec_B9() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10066");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10066");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10066", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(670)
    public void testExec_B10() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10067");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10067");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(680)
    public void testExec_B11() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10068");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10068");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10068", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MKHGKHNK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MKHGKHNK_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(690)
    public void testExec_B12() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10069");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10069");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10069", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_MKHGKHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_MKHGKHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(700)
    public void testExec_B13() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10070");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10070");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10070", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(710)
    public void testExec_B14() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10071");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10071");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10071", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(720)
    public void testExec_B15() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10072");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10072");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10072", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(730)
    public void testExec_B16() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10073");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10073");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 2, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10073", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 2, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS, "書類コードリスト[0]");

        exClassificationEquals(syoruiCdList.get(1), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_DAIHYOUSN, "書類コードリスト[1]");
    }

    @Test
    @Transactional
    @TestOrder(740)
    public void testExec_B17() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10074");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10074");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10074", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(750)
    public void testExec_C1() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10075");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10075");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10075", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_DSHR_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_DSHR_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(760)
    public void testExec_C2() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10076");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10076");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10076", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_DSHR_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_DSHR_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(770)
    public void testExec_C3() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10077");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10077");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10077", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_DSHR_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_DSHR_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(790)
    public void testExec_C5() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10079");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10079");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10079", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(800)
    public void testExec_C6() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10080");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10080");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10080", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.AS_HRHN_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.AS_HRHN_HB, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(810)
    public void testExec_C7() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10081");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10081");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10081", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(811)
    public void testExec_C8() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10085");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setHenkougoHrkkeiro(C_Hrkkeiro.KOUHURI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10085");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10085", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.AS_PKZHRIKEIRAI, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.AS_PKZHRIKEIRAI, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(812)
    public void testExec_C9() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10086");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setHenkougoHrkkeiro(C_Hrkkeiro.CREDIT);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10086");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10086", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.AS_CREDITCARDMOS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.AS_CREDITCARDMOS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(813)
    public void testExec_C10() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10087");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);
        khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.ARI);
        khHituyousyoruiHanteiInBean.setHenkougoHrkkeiro(C_Hrkkeiro.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10087");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 0, "必要書類管理テーブルエンティティリストのサイズ");

        exNumericEquals(syoruiCdList.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(820)
    public void testExec_D1() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10082");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10082");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10082", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_YENDTHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(830)
    public void testExec_D2() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10083");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10083");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10083", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_NINI_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_YENDTHNK_NINI_HB, "書類コードリスト[0]");

    }

    @Test
    @Transactional
    @TestOrder(840)
    public void testExec_D3() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10084");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10084");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10084", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_YENDTHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(850)
    public void testExec_E1() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10088");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10088");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10088", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, "書類コードリスト[0]");
    }

    @Test
    @Transactional
    @TestOrder(860)
    public void testExec_E2() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10089");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.ARI);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10089");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10089", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HB, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HB, "書類コードリスト[0]");

    }

    @Test
    @Transactional
    @TestOrder(870)
    public void testExec_E3() {

        khHituyousyoruiHanteiInBean = new KhHituyousyoruiHanteiInBean();

        khHituyousyoruiHanteiInBean.setKouteikanriId("10090");
        khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK);
        khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.BLNK);

        List<C_SyoruiCdKbn> syoruiCdList = khHituyousyoruiHantei.exec(khHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10090");

        List<BT_HituyouSyoruiKanri> list = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 1, "必要書類管理テーブルエンティティリストのサイズ");

        exStringEquals(list.get(0).getKouteikanriid(), "10090", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdList.size(), 1, "書類コードリストのサイズ");

        exClassificationEquals(syoruiCdList.get(0), C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS, "書類コードリスト[0]");
    }
}
