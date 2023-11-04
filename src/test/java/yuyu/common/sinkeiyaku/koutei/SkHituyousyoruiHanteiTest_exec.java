package yuyu.common.sinkeiyaku.koutei;

import static org.junit.Assert.*;
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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SkHituyousyoruiHanteiクラスのメソッド {@link SkHituyousyoruiHantei#exec(MosnaiCheckParam)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkHituyousyoruiHanteiTest_exec {

    @Inject
    private SkHituyousyoruiHantei skHituyousyoruiHantei;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791112253";

    private final static String mosNo5 = "791112261";

    private final static String mosNo6 = "791112279";

    private final static String mosNo8 = "860083641";

    private final static String mosNo9 = "870001161";

    private final static String mosNo10 = "860000058";

    private final static String fileName = "UT-SP_単体テスト仕様書_新契約必要書類判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkHituyousyoruiHanteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1111");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 9, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSKOKUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(4).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(4).getSyoruiCd(), C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(5).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(5).getSyoruiCd(), C_SyoruiCdKbn.SK_FATCAKAKUNINSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(5).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(6).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(6).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(6).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(7).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(7).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(7).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(8).getKouteikanriid(), "1111", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(8).getSyoruiCd(), C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(8).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exNumericEquals(skHituyousyoruiHantei.getHuyousyoruiValueList().size(), 0, "不要書類コード値リスト");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1112");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 5, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1112", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1112", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1112", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1112", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_FATCAKAKUNINSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(4).getKouteikanriid(), "1112", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(4).getSyoruiCd(), C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1113");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 6, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1113", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1113", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_TORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1113", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_IKOUKAKSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1113", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_KOKUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(4).getKouteikanriid(), "1113", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(4).getSyoruiCd(), C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(5).getKouteikanriid(), "1113", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(5).getSyoruiCd(), C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(5).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1114");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 3, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1114", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1114", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_TORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1114", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_IKOUKAKSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(skHituyousyoruiHantei.getHuyousyoruiValueList().get(0), "sk016", "不要書類コード値リスト");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1115");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 4, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1115", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1115", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_TORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1115", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_IKOUKAKSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1115", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1116");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 3, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1116", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_MOSSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1116", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_TORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1116", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_IKOUKAKSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1117");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        assertNull(gyoumuKouteiInfo);
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1118");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 6, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1118", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1118", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1118", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSKOKUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1118", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(4).getKouteikanriid(), "1118", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(4).getSyoruiCd(), C_SyoruiCdKbn.SK_FATCAKAKUNINSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(5).getKouteikanriid(), "1118", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(5).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(5).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1119");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 8, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSKOKUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(4).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(4).getSyoruiCd(), C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(5).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(5).getSyoruiCd(), C_SyoruiCdKbn.SK_FATCAKAKUNINSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(5).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(6).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(6).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(6).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(7).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(7).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(7).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1119");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        skHituyousyoruiHantei.exec(mosnaiCheckParam);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();

        exNumericEquals(hituyouSyoruiKanriList.size(), 8, "件数");

        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(1).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(1).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(2).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(2).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSKOKUSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(3).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(3).getSyoruiCd(), C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO,
            "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(4).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(4).getSyoruiCd(), C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(5).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(5).getSyoruiCd(), C_SyoruiCdKbn.SK_FATCAKAKUNINSYO, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(5).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(6).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(6).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(6).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

        exStringEquals(hituyouSyoruiKanriList.get(7).getKouteikanriid(), "1119", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(7).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "書類コード");
        exStringEquals(hituyouSyoruiKanriList.get(7).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ID");

    }

}
