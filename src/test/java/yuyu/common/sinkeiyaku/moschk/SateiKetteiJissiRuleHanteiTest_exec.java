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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 査定・決定実施ルール判定クラスのメソッド {@link SateiKetteiJissiRuleHantei#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SateiKetteiJissiRuleHanteiTest_exec  {

    private final static String fileName = "UT_SP_単体テスト仕様書_査定・決定実施ルール判定";

    private final static String sheetName = "INデータ_20160817";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HandSateiKetteiHantei.class).to(HandSateiKetteiHanteiMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        HandSateiKetteiHanteiMockForSinkeiyaku.caller = SateiKetteiJissiRuleHanteiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HandSateiKetteiHanteiMockForSinkeiyaku.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SateiKetteiJissiRuleHanteiTest_exec.class, fileName, sheetName);
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

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112220");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIMATI_KANI_MD, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();

        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 2, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 2, "環境査定履歴テーブルエンティティリストの件数");

        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(knksateiRirekiLst.get(1).getMosno(), "791112220", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(1).getRenno(), 2, "連番");
        exDateEquals(knksateiRirekiLst.get(1).getSyoriYmd(), BizDate.valueOf("20160325"), "処理年月日");
        exClassificationEquals(knksateiRirekiLst.get(1).getSateiketsyorinmkbn(), C_SateiketsyorinmKbn.RULEHANTEI, "査定・決定処理名区分");
        exClassificationEquals(knksateiRirekiLst.get(1).getKnksateikekkakbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2A, "環境査定査定結果区分");
        exStringEquals(knksateiRirekiLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(knksateiRirekiLst.get(1).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(imusateiRirekiLst.get(1).getMosno(), "791112220", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(1).getRenno(), 2, "連番");
        exDateEquals(imusateiRirekiLst.get(1).getSyoriYmd(), BizDate.valueOf("20160325"), "処理年月日");
        exClassificationEquals(imusateiRirekiLst.get(1).getSateiketsyorinmkbn(), C_SateiketsyorinmKbn.RULEHANTEI, "査定・決定処理名区分");
        exClassificationEquals(imusateiRirekiLst.get(1).getImusateikekkakbn(), C_SyorikekkaKbn.TENSOU_IMU_KANIMD, "医務査定結果区分");
        exStringEquals(imusateiRirekiLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(imusateiRirekiLst.get(1).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112238");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112238");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();

        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112246");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112246");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2B, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 3, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 2, "環境査定履歴テーブルエンティティリストの件数");

        exStringEquals(ruleHanteiMsgLst.get(0).getMosno(), "791112246", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(0).getRulehanteimsg(), C_Rulehanteimsg.MOSTENKEN, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(ruleHanteiMsgLst.get(0).getRulehanteimsgid(), "EBA0023", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(0).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(1).getMosno(), "791112246", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(1).getRulehanteimsg(), C_Rulehanteimsg.KNKSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(1).getRenno(), 1, "連番");
        exStringEquals(ruleHanteiMsgLst.get(1).getRulehanteimsgid(), "EBA0024", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(1).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(2).getMosno(), "791112246", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(2).getRulehanteimsg(), C_Rulehanteimsg.IMUSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(2).getRenno(), 1, "連番");
        exStringEquals(ruleHanteiMsgLst.get(2).getRulehanteimsgid(), "EBA0025", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(2).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(knksateiRirekiLst.get(1).getMosno(), "791112246", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(1).getRenno(), 2, "連番");
        exDateEquals(knksateiRirekiLst.get(1).getSyoriYmd(), BizDate.valueOf("20160325"), "処理年月日");
        exClassificationEquals(knksateiRirekiLst.get(1).getSateiketsyorinmkbn(), C_SateiketsyorinmKbn.RULEHANTEI, "査定・決定処理名区分");
        exClassificationEquals(knksateiRirekiLst.get(1).getKnksateikekkakbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2B, "環境査定査定結果区分");
        exStringEquals(knksateiRirekiLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(knksateiRirekiLst.get(1).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112246", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112253");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112253");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2B, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 9, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 2, "環境査定履歴テーブルエンティティリストの件数");

        exStringEquals(ruleHanteiMsgLst.get(0).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(0).getRulehanteimsg(), C_Rulehanteimsg.IMUSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(ruleHanteiMsgLst.get(0).getRulehanteimsgid(), "EBA0027", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(0).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(1).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(1).getRulehanteimsg(), C_Rulehanteimsg.MOSTENKEN, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(1).getRenno(), 1, "連番");
        exStringEquals(ruleHanteiMsgLst.get(1).getRulehanteimsgid(), "EBA0021", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(1).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(2).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(2).getRulehanteimsg(), C_Rulehanteimsg.MOSTENKEN, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(2).getRenno(), 2, "連番");
        exStringEquals(ruleHanteiMsgLst.get(2).getRulehanteimsgid(), "EBA0022", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(2).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(3).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(3).getRulehanteimsg(), C_Rulehanteimsg.MOSTENKEN, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(3).getRenno(), 3, "連番");
        exStringEquals(ruleHanteiMsgLst.get(3).getRulehanteimsgid(), "EBA0023", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(3).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(4).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(4).getRulehanteimsg(), C_Rulehanteimsg.KNKSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(4).getRenno(), 1, "連番");
        exStringEquals(ruleHanteiMsgLst.get(4).getRulehanteimsgid(), "EBA0024", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(4).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(5).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(5).getRulehanteimsg(), C_Rulehanteimsg.KNKSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(5).getRenno(), 2, "連番");
        exStringEquals(ruleHanteiMsgLst.get(5).getRulehanteimsgid(), "EBA0025", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(5).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(6).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(6).getRulehanteimsg(), C_Rulehanteimsg.KNKSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(6).getRenno(), 3, "連番");
        exStringEquals(ruleHanteiMsgLst.get(6).getRulehanteimsgid(), "EBA0026", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(6).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(6).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(7).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(7).getRulehanteimsg(), C_Rulehanteimsg.IMUSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(7).getRenno(), 2, "連番");
        exStringEquals(ruleHanteiMsgLst.get(7).getRulehanteimsgid(), "EBA0028", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(7).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(7).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(ruleHanteiMsgLst.get(8).getMosno(), "791112253", "申込番号");
        exClassificationEquals(ruleHanteiMsgLst.get(8).getRulehanteimsg(), C_Rulehanteimsg.IMUSATEI, "ルール判定結果メッセージ区分");
        exNumericEquals(ruleHanteiMsgLst.get(8).getRenno(), 3, "連番");
        exStringEquals(ruleHanteiMsgLst.get(8).getRulehanteimsgid(), "EBA0029", "ルール判定結果メッセージＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(8).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(ruleHanteiMsgLst.get(8).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(knksateiRirekiLst.get(1).getMosno(), "791112253", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(1).getRenno(), 2, "連番");
        exDateEquals(knksateiRirekiLst.get(1).getSyoriYmd(), BizDate.valueOf("20160325"), "処理年月日");
        exClassificationEquals(knksateiRirekiLst.get(1).getSateiketsyorinmkbn(), C_SateiketsyorinmKbn.RULEHANTEI, "査定・決定処理名区分");
        exClassificationEquals(knksateiRirekiLst.get(1).getKnksateikekkakbn(), C_SyorikekkaKbn.TENSOU_KANKYOU_2B, "環境査定査定結果区分");
        exStringEquals(knksateiRirekiLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(knksateiRirekiLst.get(1).getGyoumuKousinTime(), "20160325111400000", "業務用更新時間");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN5;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112261");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112261");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_2, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");
        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN6;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112279");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112279");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");
        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN7;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112287");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112287");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_2, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");
        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112295");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112295");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");
        exStringEquals(knksateiRirekiLst.get(0).getMosno(), "791112295", "申込番号");
        exNumericEquals(knksateiRirekiLst.get(0).getRenno(), 1, "連番");

        exStringEquals(imusateiRirekiLst.get(0).getMosno(), "791112295", "申込番号");
        exNumericEquals(imusateiRirekiLst.get(0).getRenno(), 1, "連番");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112303");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        try {
            sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);
        }catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号＝791112303", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(100)
    public void testExec_A10() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN8;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112311");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        try {
            sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);
        }catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号＝791112311", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN9;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112329");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112329");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.MOSTENKEN_ZUMI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN10;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112337");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.TNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112337");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.NONE, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_HUBI, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN11;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112345");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112345");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN12;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112352");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112352");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN13;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112360");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112360");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN13;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112378");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112378");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN14;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112386");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112386");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN14;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112394");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112394");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN14;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112402");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112402");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN14;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112410");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112410");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN15;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112428");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112428");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2B, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN15;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112436");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112436");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2B, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN15;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112444");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112444");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIZUMI, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 1, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN15;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112451");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112451");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN16;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112469");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112469");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.NONE, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112477");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112477");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIMATI_KANI_MD, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112485");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112485");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN17;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112493");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112493");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN18;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112501");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("791112501");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIZUMI, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 1, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN19;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112220");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112220");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN20;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112238");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112238");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIMATI_KANI_UW, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN21;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112246");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112246");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.YOU_B, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2B, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.SATEIMATI_KANI_MD, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN22;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112253");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112253");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.NONE, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.NONE, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_2, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN23;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112261");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112261");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.NONE, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.YOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_1, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN24;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112279");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112279");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.NONE, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.TENKENMATI_1, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = HandSateiKetteiHanteiMockForSinkeiyaku.TESTPATTERN25;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112287");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112287");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.NONE, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = "";
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112295");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112295");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = "";
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112303");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112303");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = "";
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112311");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112311");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(390)
    public void testExec_A40() {
        HandSateiKetteiHanteiMockForSinkeiyaku.SYORIPTN = "";
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112329");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160325"));
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160325111400000");

        SateiKetteiJissiRuleHantei sateiKetteiJissiRuleHantei = SWAKInjector.getInstance(SateiKetteiJissiRuleHantei.class);
        sateiKetteiJissiRuleHantei.exec(mosnaiCheckParam);

        HT_SyoriCTL syoriCTLUpd = sinkeiyakuDomManager.getSyoriCTL("981112329");

        exClassificationEquals(syoriCTLUpd.getMostenken1jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenken2jiyhkbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei1jiyhkbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(syoriCTLUpd.getKnkysatei2jiyhkbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");
        exClassificationEquals(syoriCTLUpd.getImusateikaniyhkbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
        exClassificationEquals(syoriCTLUpd.getMostenkenjoukbn(), C_MostenkenjyouKbn.NONE, "申込点検状態区分");
        exClassificationEquals(syoriCTLUpd.getKnkysateijyoukbn(), C_KnkysateijyouKbn.NONE, "環境査定状態区分");
        exClassificationEquals(syoriCTLUpd.getImusateijyoukbn(), C_ImusateijyouKbn.NONE, "医務査定状態区分");
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTLUpd.getRuleHanteiMsgs();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTLUpd.getKnksateiRirekis();
        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTLUpd.getImusateiRirekis();
        exNumericEquals(ruleHanteiMsgLst.size(), 0, "ルール判定結果メッセージテーブルエンティティリストの件数");
        exNumericEquals(imusateiRirekiLst.size(), 0, "医務査定履歴テーブルエンティティリストの件数");
        exNumericEquals(knksateiRirekiLst.size(), 0, "環境査定履歴テーブルエンティティリストの件数");

    }
}
