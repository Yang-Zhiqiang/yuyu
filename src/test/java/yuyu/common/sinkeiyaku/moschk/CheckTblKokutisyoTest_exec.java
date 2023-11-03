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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 告知書TBLチェックのメソッド {@link CheckTblKokutisyo#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblKokutisyoTest_exec {

    @Inject
    private CheckTblKokutisyo checkTblKokutisyo;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_告知書TBLチェック";
    private final static String sheetName = "テストデータ";

    private static Integer kktKakoKyoyou;


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckTblKokutisyoTest_exec.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

        kktKakoKyoyou = YuyuSinkeiyakuConfig.getInstance().getKktKakoKyoyou();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(kktKakoKyoyou);

        MockObjectManager.initialize();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        try{
            HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setKosID("user001");
            checkTblKokutisyo.exec(mosnaiCheckParam);
        }
        catch(CommonBizAppException e){
            exStringEquals(e.getMessage(),"システム整合性エラーです。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150604"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(1);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "KBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "（特認済）告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "家族記事区分は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150607"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(-2);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "TBC0046", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】告知日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "喫煙本数は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        exStringEquals(hubiMsg.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsg.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsg.get(2).getMessageId(), "EBC0007", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "家族記事区分は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150605"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(0);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150606"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(2);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "喫煙本数の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150605"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(1);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150605"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(1);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "家族記事区分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150605"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");

        YuyuSinkeiyakuConfig.getInstance().setKktKakoKyoyou(0);
        checkTblKokutisyo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

}
