package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＭＲ関連チェックのメソッド {@link CheckMRKanren#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMRKanrenTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_ＭＲ関連チェック";

    private final static String sheetName = "INデータ";


    @Inject
    private CheckMRKanren checkMRKanren;

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
            testDataAndTblMap = testDataMaker.getInData(CheckMRKanrenTest_exec.class, fileName, sheetName);
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

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try{
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150603111400000");
            checkMRKanren.exec(mosnaiCheckParam);

        } catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号：791112220", "エラーメッセージ");
            throw e;

        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 8, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】被保険者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】死亡受取人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】死亡受取人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(4).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "【特認可能】被保険者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(5).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "【特認可能】死亡受取人に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(6).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(6).getRenno(), 7, "連番");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "【特認可能】契約者代理人に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(7).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsgLst.get(7).getRenno(), 8, "連番");
        exStringEquals(hubiMsgLst.get(7).getHubimsg(), "【特認可能】被保険者代理人に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(7).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(7).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(7).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(7).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(7).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 9, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】被保険者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】契約者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】契約者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(4).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "【特認可能】死亡受取人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(5).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "【特認可能】死亡受取人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(6).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(6).getRenno(), 7, "連番");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "【特認可能】被保険者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(7).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(7).getRenno(), 8, "連番");
        exStringEquals(hubiMsgLst.get(7).getHubimsg(), "【特認可能】契約者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(7).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(7).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(7).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(7).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(7).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(8).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(8).getRenno(), 9, "連番");
        exStringEquals(hubiMsgLst.get(8).getHubimsg(), "【特認可能】死亡受取人に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(8).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(8).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(8).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(8).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(8).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 7, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】被保険者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】契約者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】契約者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(4).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "【特認可能】死亡受取人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(5).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "【特認可能】死亡受取人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(6).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(6).getRenno(), 7, "連番");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "【特認可能】被保険者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 7, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】被保険者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】契約者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】契約者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(4).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "【特認可能】死亡受取人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(5).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "【特認可能】死亡受取人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(6).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(6).getRenno(), 7, "連番");
        exStringEquals(hubiMsgLst.get(6).getHubimsg(), "【特認可能】契約者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(6).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(6).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(6).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 4, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者に取扱注意情報（新）があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1059", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約者に取扱注意情報（新）があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1059", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】死亡受取人に取扱注意情報（新）があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1059", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】死亡受取人に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 3, "件数");

        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約者にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112253", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】死亡受取人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 6, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】被保険者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約者に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】死亡受取人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】被保険者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(4).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsgLst.get(4).getRenno(), 5, "連番");
        exStringEquals(hubiMsgLst.get(4).getHubimsg(), "【特認可能】契約者に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(4).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(4).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(4).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(5).getMosno(), "791112261", "申込番号");
        exNumericEquals(hubiMsgLst.get(5).getRenno(), 6, "連番");
        exStringEquals(hubiMsgLst.get(5).getHubimsg(), "【特認可能】死亡受取人に手続注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(5).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(5).getMessageId(), "THC1049", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(5).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SISAN);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　申込書作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊　設計書作成できません　住友生命へ連絡してください　＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　申込書作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 4, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】契約者代理人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約者代理人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】被保険者代理人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】被保険者代理人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 4, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】契約者代理人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約者代理人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】被保険者代理人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】被保険者代理人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 4, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】契約者代理人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】契約者代理人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsgLst.get(2).getHubimsg(), "【特認可能】被保険者代理人に取扱注意情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(2).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(2).getMessageId(), "THC1010", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(3).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsgLst.get(3).getHubimsg(), "【特認可能】被保険者代理人にシグナル情報があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(3).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(3).getMessageId(), "THC1011", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 2, "件数");
        exStringEquals(hubiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "【特認可能】契約者代理人に取扱注意情報（新）があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "THC1059", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

        exStringEquals(hubiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(hubiMsgLst.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsgLst.get(1).getHubimsg(), "【特認可能】被保険者代理人に取扱注意情報（新）があります。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(1).getGyoumuKousinTime(), "20191223111400000", "業務用更新時間");
        exStringEquals(hubiMsgLst.get(1).getMessageId(), "THC1059", "メッセージＩＤ");
        exClassificationEquals(hubiMsgLst.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");

    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);


        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_HubiMsg> hubiMsgLst = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgLst);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20191223111400000");
        checkMRKanren.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsgLst.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "＊＊＊＊＊＊＊　作成できません　住友生命へ連絡してください　＊＊＊＊＊＊＊", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }
}
