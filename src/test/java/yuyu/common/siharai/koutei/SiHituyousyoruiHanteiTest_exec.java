package yuyu.common.siharai.koutei;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払必要書類判定クラスのメソッド {@link SiHituyousyoruiHantei#exec(SiHituyousyoruiHanteiInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiHituyousyoruiHanteiTest_exec {

    @Inject
    private SiHituyousyoruiHantei siHituyousyoruiHantei;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SiHituyousyoruiHanteiInBean pSiHituyousyoruiHanteiInBean;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払必要書類判定";

    private final static String sheetName = "テストデータ";

    @Inject
    BaseUserInfo baseUserInfo;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiHituyousyoruiHanteiTest_exec.class, fileName, sheetName);
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
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HGU);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10000");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        exNumericEquals(syoruiCdLst.size(), 0, "書類コードリストのサイズ");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHENKANKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HGU);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10001");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        exNumericEquals(syoruiCdLst.size(), 0, "書類コードリストのサイズ");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HGU);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10002");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10002");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 4, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10002", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10002", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10002", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(3).getKouteikanriid(), "10002", "工程管理ID");
        exClassificationEquals(list.get(3).getSyoruiCd(), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コード");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 4, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[2]");
        exClassificationEquals(syoruiCdLst.get(3), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コードリスト[3]");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.BLNK);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HGU);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10003");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10003");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 7, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(3).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(3).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コード");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(4).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(4).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_DAIHYOU, "書類コード");
        exStringEquals(list.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(5).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(5).getSyoruiCd(), C_SyoruiCdKbn.HK_KD_JIKOJKS, "書類コード");
        exStringEquals(list.get(5).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(6).getKouteikanriid(), "10003", "工程管理ID");
        exClassificationEquals(list.get(6).getSyoruiCd(), C_SyoruiCdKbn.HK_MYNUMBER_CHYOU, "書類コード");
        exStringEquals(list.get(6).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 7, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[2]");
        exClassificationEquals(syoruiCdLst.get(3), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コードリスト[3]");
        exClassificationEquals(syoruiCdLst.get(4), C_SyoruiCdKbn.HK_SB_DAIHYOU, "書類コードリスト[4]");
        exClassificationEquals(syoruiCdLst.get(5), C_SyoruiCdKbn.HK_KD_JIKOJKS, "書類コードリスト[5]");
        exClassificationEquals(syoruiCdLst.get(6), C_SyoruiCdKbn.HK_MYNUMBER_CHYOU, "書類コードリスト[6]");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HONNIN);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10004");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10004");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 4, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(3).getKouteikanriid(), "10004", "工程管理ID");
        exClassificationEquals(list.get(3).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コード");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 4, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[2]");
        exClassificationEquals(syoruiCdLst.get(3), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コードリスト[3]");
    }


    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.BLNK);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HGU);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10005");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10005");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 3, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10005", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10005", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10005", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 3, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コードリスト[2]");
    }


    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HONNIN);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10006");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10006");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 4, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10006", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10006", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10006", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(3).getKouteikanriid(), "10006", "工程管理ID");
        exClassificationEquals(list.get(3).getSyoruiCd(), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コード");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 4, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[2]");
        exClassificationEquals(syoruiCdLst.get(3), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コードリスト[3]");
    }


    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.BLNK);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HONNIN);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10007");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10007");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 4, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10007", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10007", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10007", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(3).getKouteikanriid(), "10007", "工程管理ID");
        exClassificationEquals(list.get(3).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コード");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 4, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[2]");
        exClassificationEquals(syoruiCdLst.get(3), C_SyoruiCdKbn.HK_SB_HOKEN_SKS, "書類コードリスト[3]");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        pSiHituyousyoruiHanteiInBean = new SiHituyousyoruiHanteiInBean();

        pSiHituyousyoruiHanteiInBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);

        pSiHituyousyoruiHanteiInBean.setSbjiShrKbn(C_SbjiShrKbn.SBHOKENKIN);

        pSiHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setJisatumensekiumukbn(C_UmuKbn.ARI);

        pSiHituyousyoruiHanteiInBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.BLNK);

        pSiHituyousyoruiHanteiInBean.setJikojksumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(C_UmuKbn.NONE);

        pSiHituyousyoruiHanteiInBean.setKkkyktdk(C_Tdk.HONNIN);

        pSiHituyousyoruiHanteiInBean.setKouteiKanriId("10008");

        List<C_SyoruiCdKbn> syoruiCdLst = siHituyousyoruiHantei.exec(pSiHituyousyoruiHanteiInBean);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("10008");
        List<BT_HituyouSyoruiKanri> list = bT_GyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(list.size(), 4, "必要書類管理テーブルエンティティリストのサイズ");
        exStringEquals(list.get(0).getKouteikanriid(), "10008", "工程管理ID");
        exClassificationEquals(list.get(0).getSyoruiCd(), C_SyoruiCdKbn.HK_STI_KAS, "書類コード");
        exStringEquals(list.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(1).getKouteikanriid(), "10008", "工程管理ID");
        exClassificationEquals(list.get(1).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コード");
        exStringEquals(list.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(2).getKouteikanriid(), "10008", "工程管理ID");
        exClassificationEquals(list.get(2).getSyoruiCd(), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コード");
        exStringEquals(list.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(list.get(3).getKouteikanriid(), "10008", "工程管理ID");
        exClassificationEquals(list.get(3).getSyoruiCd(), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コード");
        exStringEquals(list.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(syoruiCdLst.size(), 4, "書類コードリストのサイズ");
        exClassificationEquals(syoruiCdLst.get(0), C_SyoruiCdKbn.HK_STI_KAS, "書類コードリスト[0]");
        exClassificationEquals(syoruiCdLst.get(1), C_SyoruiCdKbn.HK_SB_KOSEKI, "書類コードリスト[1]");
        exClassificationEquals(syoruiCdLst.get(2), C_SyoruiCdKbn.HK_SB_HONNINSR, "書類コードリスト[2]");
        exClassificationEquals(syoruiCdLst.get(3), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コードリスト[3]");
    }
}
