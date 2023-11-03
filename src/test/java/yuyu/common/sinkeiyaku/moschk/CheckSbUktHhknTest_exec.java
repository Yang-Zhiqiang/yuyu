package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 死亡受取人≠被保険者チェックのメソッド {@link CheckSbUktHhkn#exec(MosnaiCheckParam,List<HT_Uketorinin>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckSbUktHhknTest_exec {

    private final static String mosNo1 = "981112220";

    private final static String mosNo2 = "981112238";

    private final static String mosNo3 = "981112246";

    private final static String fileName = "UT_SP_単体テスト仕様書_死亡受取人≠被保険者チェック";

    private final static String sheetName = "テストデータ";


    @Inject
    private CheckSbUktHhkn checkSbUktHhkn;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSbUktHhknTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        List<HT_Uketorinin> HT_UketorininLst = new ArrayList<>();
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkSbUktHhkn.exec(mosnaiCheckParam, HT_UketorininLst);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティの件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        List<HT_Uketorinin> HT_UketorininLst = new ArrayList<>();
        HT_Uketorinin uketorininWk = new HT_Uketorinin();
        uketorininWk.setUktkbn(C_UktKbn.KYK);
        HT_UketorininLst.add(uketorininWk);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        syoriCTL.setKetteikbn(C_KetteiKbn.BLNK);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610134500000");

        checkSbUktHhkn.exec(mosnaiCheckParam, HT_UketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHA1002", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人区分に「契約者と同じ」は指定できません。", "不備メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150610134500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        List<HT_Uketorinin> HT_UketorininLst = new ArrayList<>();
        HT_Uketorinin uketorininWk = new HT_Uketorinin();
        uketorininWk.setUktkbn(C_UktKbn.BLNK);

        HT_Uketorinin uketorininWk1 = new HT_Uketorinin();
        uketorininWk1.setUktkbn(C_UktKbn.KYK);

        HT_Uketorinin uketorininWk2 = new HT_Uketorinin();
        uketorininWk2.setUktkbn(C_UktKbn.KYK);

        HT_UketorininLst.add(uketorininWk);
        HT_UketorininLst.add(uketorininWk1);
        HT_UketorininLst.add(uketorininWk2);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        syoriCTL.setKetteikbn(C_KetteiKbn.BLNK);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610134500000");

        checkSbUktHhkn.exec(mosnaiCheckParam, HT_UketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHA1002", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人区分に「契約者と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150610134500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B1() {
        List<HT_Uketorinin> HT_UketorininLst = new ArrayList<>();
        HT_Uketorinin uketorininWk1 = new HT_Uketorinin();
        uketorininWk1.setUktkbn(C_UktKbn.KYK);

        HT_UketorininLst.add(uketorininWk1);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        checkSbUktHhkn.exec(mosnaiCheckParam, HT_UketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティの件数");
    }
}
