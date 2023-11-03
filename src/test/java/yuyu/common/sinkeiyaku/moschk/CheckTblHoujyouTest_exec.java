package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 報状TBLチェッククラスのメソッド {@link CheckTblHoujyou#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblHoujyouTest_exec {

    @Inject
    private CheckTblHoujyou checkTblHoujyou;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_報状TBLチェック";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional()
    public static void insertTestData(){
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckTblHoujyouTest_exec.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111118");

        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150625));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "871111118", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "（特認済）告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
        exStringEquals(hubiMsg.get(1).getMosno(), "871111118", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "診査日（再診）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111126");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150625));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "871111126", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
        exStringEquals(hubiMsg.get(1).getMosno(), "871111126", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "診査日（再診）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        try{
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111134");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            checkTblHoujyou.exec(mosnaiCheckParam);
        }catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 = 871111134", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111142");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150625));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "871111142", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "診査日（初診）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111159");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150625));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "871111159", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "診査日（初診）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111167");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150627));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "871111167", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "871111167", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "初診と再診の診査日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");


    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111175");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150601));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "871111175", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "871111175", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "診査日（再診）が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(2).getMosno(), "871111175", "申込番号");
        exNumericEquals(hubiMsg.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "初診と再診の診査日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(3).getMosno(), "871111175", "申込番号");
        exNumericEquals(hubiMsg.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "喫煙本数の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(3).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111183");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150627));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "871111183", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "871111183", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "喫煙本数は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111191");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150627));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111209");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150627));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "871111209", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("871111217");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150627));
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);

        checkTblHoujyou.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "871111217", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }
}