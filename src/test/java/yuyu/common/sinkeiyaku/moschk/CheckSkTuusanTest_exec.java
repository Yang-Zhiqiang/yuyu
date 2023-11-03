package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.TakeiyakuTuusanInfoParam;
import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.common.biz.bzcommon.TuusanKeiyakuInfoParam;
import yuyu.common.biz.bzcommon.TuusanMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwariMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_SkeikikeiyakuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約通算チェッククラスのメソッド {@link CheckSkTuusan#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckSkTuusanTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約通算チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckTuusan.class).to(CheckTuusanMockForSinkeiyaku.class);
                bind(Tuusan.class).to(TuusanMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
                bind(BzGetTuukeiBunwari.class).to(BzGetTuukeiBunwariMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        CheckTuusanMockForSinkeiyaku.caller = CheckSkTuusanTest_exec.class;
        TuusanMockForSinkeiyaku.caller = CheckSkTuusanTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.caller = CheckSkTuusanTest_exec.class;
        BzGetTuukeiBunwariMockForSinkeiyaku.caller = CheckSkTuusanTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CheckTuusanMockForSinkeiyaku.caller = null;
        CheckTuusanMockForSinkeiyaku.SYORIPTN = null;

        TuusanMockForSinkeiyaku.caller = null;
        TuusanMockForSinkeiyaku.SYORIPTN = null;

        SetHubiMsgMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        BzGetTuukeiBunwariMockForSinkeiyaku.caller = null;
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSkTuusanTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllChkTuusanS());
        bizDomManager.delete(bizDomManager.getAllChkKokutiTuusanS());
        bizDomManager.delete(bizDomManager.getKijyungkHanteiKawaseRate("2015", C_Tuukasyu.valueOf("USD")));
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000017");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        try {
            CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
            checkSkTuusan.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号 =860000017", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN1;
        MockObjectManager.initialize();
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000025");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);

        checkSkTuusan.exec(mosnaiCheckParam);
        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(2103), "通算決定総死亡S");
        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exClassificationEquals(tuusanKeiyakuInfoParam.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam.getHrkKaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getKihonS(), BizCurrency.valueOf(2000), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getItijibrp(), BizCurrency.valueOf(100), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getJituHsgk(), BizCurrency.valueOf(0), "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getNkgnsgk(), BizCurrency.valueOf(0), "年金原資額");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSyuusinhknUmu(), C_UmuKbn.ARI, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getStsnUmu(), C_UmuKbn.ARI, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNkgnsTuusanUmu(), C_UmuKbn.ARI, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNenbtSouSbusTuusanUmu(), C_UmuKbn.ARI, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.ARI, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.ARI, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk1TuusanUmu(), C_UmuKbn.ARI, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk2TuusanUmu(), C_UmuKbn.ARI, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKykDrtenTuusanUmuKbn(), C_UmuKbn.ARI, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getItijibrpTsnUmu(), C_UmuKbn.ARI, "一時払Ｐ通算有無");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), BizCurrency.valueOf(0), "通計保留用基本S");

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = (TakeiyakuTuusanInfoParam)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 1);
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSibouS(), BizCurrency.valueOf(100), "通算総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenMikeikaS(), BizCurrency.valueOf(101), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenKeikaS(), BizCurrency.valueOf(102), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS(), BizCurrency.valueOf(103), "通算決定総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS2(), BizCurrency.valueOf(104), "通算決定総死亡Ｓ２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSouKktJituHsgk(), BizCurrency.valueOf(105), "通算総告知書実保障額");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk1(), BizCurrency.valueOf(106), "通算告知書実保障額１");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk2(), BizCurrency.valueOf(107), "通算告知書実保障額２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktItijibrSysnJs(), BizCurrency.valueOf(108), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNkgns(), BizCurrency.valueOf(109), "通算年金原資");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnMsnyNenbtSousbus(), BizCurrency.valueOf(110), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNenbtItijibrSsbs(), BizCurrency.valueOf(111), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getKykDrtenTsns(), BizCurrency.valueOf(112), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnItijibrSysnp(), BizCurrency.valueOf(120), "通算一時払終身Ｐ");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;
        MockObjectManager.initialize();
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000033");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20200309));

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 2);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);

        checkSkTuusan.exec(mosnaiCheckParam);
        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(50000), "通算決定総死亡S");
        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exClassificationEquals(tuusanKeiyakuInfoParam.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam.getHrkKaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getKihonS(), BizCurrency.valueOf(50000, BizCurrencyTypes.YEN), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getItijibrp(), BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getJituHsgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "実保障額");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSyuusinhknUmu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getStsnUmu(), C_UmuKbn.NONE, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNkgnsTuusanUmu(), C_UmuKbn.NONE, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNenbtSouSbusTuusanUmu(), C_UmuKbn.NONE, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.NONE, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.NONE, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk1TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk2TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKykDrtenTuusanUmuKbn(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");

        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), BizCurrency.valueOf(0), "通計保留用基本S");

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = (TakeiyakuTuusanInfoParam)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 1);
        assertNull(takeiyakuTuusanInfoParam);
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000041");

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKosID("JunitTest");
        mosnaiCheckParam.setKosTime("20160513100830000");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),C_KetsrhkosKbn.KETHORYU_HUBI, "決定成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),"EHC1021 通算金額の円換算処理でエラーが発生しました。通算チェックが未実施です。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),C_MsgKbn.ERROR, "メッセージ区分");

        MockObjectManager.assertNotCalled(TuusanMockForSinkeiyaku.class, "exec");
        MockObjectManager.assertNotCalled(CheckTuusanMockForSinkeiyaku.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN3;
        MockObjectManager.initialize();
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("860000058");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        List<BM_SyouhnZokusei> syouhnZokuseiLst = new ArrayList<BM_SyouhnZokusei>();
        BM_SyouhnZokusei syouhnZokusei1 = bizDomManager.getSyouhnZokusei("0001", 4);
        BM_SyouhnZokusei syouhnZokusei2 = bizDomManager.getSyouhnZokusei("0002", 5);
        BM_SyouhnZokusei syouhnZokusei3 = bizDomManager.getSyouhnZokusei("0003", 6);
        syouhnZokuseiLst.add(syouhnZokusei1);
        syouhnZokuseiLst.add(syouhnZokusei2);
        syouhnZokuseiLst.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiLst);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);

        checkSkTuusan.exec(mosnaiCheckParam);
        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(703), "通算決定総死亡S");

        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = tuusanKeiyakuInfoParamLst.get(0);

        exClassificationEquals(tuusanKeiyakuInfoParam1.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam1.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam1.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam1.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getHrkKaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getKihonS(), BizCurrency.valueOf(200), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getItijibrp(), BizCurrency.valueOf(400), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getJituHsgk(), BizCurrency.valueOf(0), "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getNkgnsgk(), BizCurrency.valueOf(0), "年金原資額");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getSyuusinhknUmu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getStsnUmu(), C_UmuKbn.NONE, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getNkgnsTuusanUmu(), C_UmuKbn.NONE, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getNenbtSouSbusTuusanUmu(), C_UmuKbn.NONE, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.NONE, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.NONE, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getKktJituHsgk1TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getKktJituHsgk2TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getKykDrtenTuusanUmuKbn(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.BLNK, "特定保険種類通算区分");

        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getTkhKihonS(), BizCurrency.valueOf(0), "通計保留用基本S");

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam2 = tuusanKeiyakuInfoParamLst.get(1);

        exClassificationEquals(tuusanKeiyakuInfoParam2.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam2.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam2.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam2.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getHrkKaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam2.getKihonS(), BizCurrency.valueOf(300), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam2.getItijibrp(), BizCurrency.valueOf(500), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam2.getJituHsgk(), BizCurrency.valueOf(0), "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam2.getNkgnsgk(), BizCurrency.valueOf(0), "年金原資額");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getSyuusinhknUmu(), C_UmuKbn.ARI, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getStsnUmu(), C_UmuKbn.ARI, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getNkgnsTuusanUmu(), C_UmuKbn.ARI, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getNenbtSouSbusTuusanUmu(), C_UmuKbn.ARI, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.ARI, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.ARI, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getKktJituHsgk1TuusanUmu(), C_UmuKbn.ARI, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getKktJituHsgk2TuusanUmu(), C_UmuKbn.ARI, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getKykDrtenTuusanUmuKbn(), C_UmuKbn.ARI, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getItijibrpTsnUmu(), C_UmuKbn.ARI, "一時払Ｐ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam2.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN, "特定保険種類通算区分");

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam3 = tuusanKeiyakuInfoParamLst.get(2);

        exClassificationEquals(tuusanKeiyakuInfoParam3.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam3.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam3.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam3.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getHrkKaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam3.getKihonS(), BizCurrency.valueOf(100), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam3.getItijibrp(), BizCurrency.valueOf(600), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam3.getJituHsgk(), BizCurrency.valueOf(0), "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam3.getNkgnsgk(), BizCurrency.valueOf(0), "年金原資額");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getSyuusinhknUmu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getStsnUmu(), C_UmuKbn.NONE, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getNkgnsTuusanUmu(), C_UmuKbn.NONE, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getNenbtSouSbusTuusanUmu(), C_UmuKbn.NONE, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.NONE, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.NONE, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getKktJituHsgk1TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getKktJituHsgk2TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getKykDrtenTuusanUmuKbn(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam3.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.BLNK, "特定保険種類通算区分");

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = (TakeiyakuTuusanInfoParam)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 1);
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSibouS(), BizCurrency.valueOf(100), "通算総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenMikeikaS(), BizCurrency.valueOf(101), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenKeikaS(), BizCurrency.valueOf(102), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS(), BizCurrency.valueOf(103), "通算決定総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS2(), BizCurrency.valueOf(104), "通算決定総死亡Ｓ２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSouKktJituHsgk(), BizCurrency.valueOf(105), "通算総告知書実保障額");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk1(), BizCurrency.valueOf(106), "通算告知書実保障額１");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk2(), BizCurrency.valueOf(107), "通算告知書実保障額２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktItijibrSysnJs(), BizCurrency.valueOf(108), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNkgns(), BizCurrency.valueOf(109), "通算年金原資");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnMsnyNenbtSousbus(), BizCurrency.valueOf(110), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNenbtItijibrSsbs(), BizCurrency.valueOf(111), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getKykDrtenTsns(), BizCurrency.valueOf(112), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnItijibrSysnp(), BizCurrency.valueOf(125), "通算一時払終身Ｐ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSntktuukaHijynSysns(), BizCurrency.valueOf(126), "通算選択通貨建平準払終身Ｓ");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("861112464");

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKosID("JunitTest");
        mosnaiCheckParam.setKosTime("20160513100830000");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),C_KetsrhkosKbn.KETHORYU_HUBI, "決定成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),"EHC1021 通算金額の円換算処理でエラーが発生しました。通算チェックが未実施です。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),C_MsgKbn.ERROR, "メッセージ区分");

        MockObjectManager.assertNotCalled(TuusanMockForSinkeiyaku.class, "exec");
        MockObjectManager.assertNotCalled(CheckTuusanMockForSinkeiyaku.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("861112480");

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKosID("JunitTest");
        mosnaiCheckParam.setKosTime("20160513100830000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20200309));
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");

        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), BizCurrency.valueOf(151), "通計保留用基本S");

        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 0), "1200009", "代理店コード１");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 1), "1200001", "親代理店コード１");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 2), BizNumber.valueOf(1), "分担割合１");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 3), "1200009", "代理店コード２");
        exStringEquals((String)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 4), "1200001", "親代理店コード２");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 5), BizNumber.valueOf(2), "分担割合２");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 6), BizDateYM.valueOf(202003), "基準年月");
        exClassificationEquals((C_DrtSyouhinSikibetuKbn)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 7), C_DrtSyouhinSikibetuKbn.GONENRISAHAITOUSITEITUUKAKJNNKITIJI, "代理店商品識別区分");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 8), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals((C_DiritenplannmKbn)MockObjectManager.getArgument(BzGetTuukeiBunwariMockForSinkeiyaku.class, "exec", 0, 9), C_DiritenplannmKbn.BLNK, "代理店プラン名区分");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        BzGetTuukeiBunwariMockForSinkeiyaku.SYORIPTN = BzGetTuukeiBunwariMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("861112514");

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("JunitTest");
        mosnaiCheckParam.setKosTime("20160513100830000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20200309));
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
        exClassificationEquals(mosnaiCheckParam.getTkrtkKinyuuknUmuKbn(), C_UmuKbn.ARI, "特例地域金融機関表示");
        exClassificationEquals(mosnaiCheckParam.getKydsskKinyuuknUmuKbn(), C_UmuKbn.NONE, "協同組織金融機関有無区分");

        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), BizCurrency.valueOf(301), "通計保留用基本S");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKosID("JunitTest");
        mosnaiCheckParam.setKosTime("20160513100830000");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 3);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.SEIJYOU, "索引通算区分");
        exClassificationEquals(mosnaiCheckParam.getTkrtkKinyuuknUmuKbn(), C_UmuKbn.NONE, "特例地域金融機関表示");
        exClassificationEquals(mosnaiCheckParam.getKydsskKinyuuknUmuKbn(), C_UmuKbn.ARI, "協同組織金融機関有無区分");

        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), BizCurrency.valueOf(0), "通計保留用基本S");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112238");

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        mosnaiCheckParam.setKosID("JunitTest");
        mosnaiCheckParam.setKosTime("20160513100830000");
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 3);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),C_KetsrhkosKbn.KETHORYU_HUBI, "決定成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),"EHC0125 システム障害が発生しています。サポートデスクへお問い合わせください。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),C_MsgKbn.ERROR, "メッセージ区分");

        MockObjectManager.assertNotCalled(TuusanMockForSinkeiyaku.class, "exec");
        MockObjectManager.assertNotCalled(CheckTuusanMockForSinkeiyaku.class, "exec");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN2;

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000015");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);
        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(50103), "通算決定総死亡S");

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = (TakeiyakuTuusanInfoParam)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 1);
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSibouS(), BizCurrency.valueOf(100), "通算総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenMikeikaS(), BizCurrency.valueOf(101), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNinenKeikaS(), BizCurrency.valueOf(102), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS(), BizCurrency.valueOf(103), "通算決定総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKetSibouS2(), BizCurrency.valueOf(104), "通算決定総死亡Ｓ２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnSouKktJituHsgk(), BizCurrency.valueOf(105), "通算総告知書実保障額");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk1(), BizCurrency.valueOf(106), "通算告知書実保障額１");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktJituHsgk2(), BizCurrency.valueOf(107), "通算告知書実保障額２");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnKktItijibrSysnJs(), BizCurrency.valueOf(108), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNkgns(), BizCurrency.valueOf(109), "通算年金原資");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnMsnyNenbtSousbus(), BizCurrency.valueOf(110), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnNenbtItijibrSsbs(), BizCurrency.valueOf(111), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getKykDrtenTsns(), BizCurrency.valueOf(112), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(takeiyakuTuusanInfoParam.getTsnItijibrSysnp(), BizCurrency.valueOf(120), "通算一時払終身Ｐ");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000023");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0001", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        try {
            checkSkTuusan.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込代理店件数異常 申込番号：870000023", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN1;
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000031");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(300), "通算決定総死亡S");

        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exClassificationEquals(tuusanKeiyakuInfoParam.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam.getHrkKaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getKihonS(), BizCurrency.valueOf(300), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getItijibrp(), BizCurrency.valueOf(800), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getJituHsgk(), BizCurrency.valueOf(0), "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getNkgnsgk(), BizCurrency.valueOf(0), "年金原資額");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSyuusinhknUmu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getStsnUmu(), C_UmuKbn.NONE, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNkgnsTuusanUmu(), C_UmuKbn.NONE, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNenbtSouSbusTuusanUmu(), C_UmuKbn.NONE, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.NONE, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.NONE, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk1TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk2TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKykDrtenTuusanUmuKbn(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = (TakeiyakuTuusanInfoParam)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 1);
        assertNull(takeiyakuTuusanInfoParam);
        MockObjectManager.assertCalled(HenkanTuuka.class, "henkanTuukaTypeToKbn");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000049");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾁ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");

        exClassificationEquals((C_KetsrhkosKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),C_KetsrhkosKbn.KETHORYU_HUBI, "決定成立保留更新区分");
        exStringEquals((String)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),"EHC0125 システム障害が発生しています。サポートデスクへお問い合わせください。", "メッセージ文言");
        exClassificationEquals((C_TknKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),C_MsgKbn.ERROR, "メッセージ区分");

        MockObjectManager.assertNotCalled(TuusanMockForSinkeiyaku.class, "exec");
        MockObjectManager.assertNotCalled(CheckTuusanMockForSinkeiyaku.class, "exec");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        CheckTuusanMockForSinkeiyaku.SYORIPTN = CheckTuusanMockForSinkeiyaku.TESTPATTERN1;
        TuusanMockForSinkeiyaku.SYORIPTN = TuusanMockForSinkeiyaku.TESTPATTERN1;

        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("870000056");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL1);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        mosnaiCheckParam.setSyuSyouhnZokusei(syouhnZokusei);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        CheckSkTuusan checkSkTuusan = SWAKInjector.getInstance(CheckSkTuusan.class);
        checkSkTuusan.exec(mosnaiCheckParam);

        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(515), "通算決定総死亡S");

        List<TuusanKeiyakuInfoParam> tuusanKeiyakuInfoParamLst = (List<TuusanKeiyakuInfoParam>)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 0);
        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = tuusanKeiyakuInfoParamLst.get(0);

        exClassificationEquals(tuusanKeiyakuInfoParam.getSkeiKikeiyakuKbn(), C_SkeikikeiyakuKbn.SKEI, "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam.getKijyunYmd(), BizDate.valueOf(20160101), "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam.getHhknNen(), 20, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam.getHrkKaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getKihonS(), BizCurrency.valueOf(515), "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getItijibrp(), BizCurrency.valueOf(15), "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getJituHsgk(), BizCurrency.valueOf(500), "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getNkgnsgk(), BizCurrency.valueOf(515), "年金原資額");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSyuusinhknUmu(), C_UmuKbn.NONE, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getStsnUmu(), C_UmuKbn.NONE, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNkgnsTuusanUmu(), C_UmuKbn.NONE, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNenbtSouSbusTuusanUmu(), C_UmuKbn.NONE, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSouKktJituHsgkTuusanUmu(), C_UmuKbn.NONE, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getMsnyNenbtSbusTuusanUmu(), C_UmuKbn.NONE, "未成年年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk1TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk2TuusanUmu(), C_UmuKbn.NONE, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKykDrtenTuusanUmuKbn(), C_UmuKbn.NONE, "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), BizCurrency.valueOf(0), "通計保留用基本S");

        TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = (TakeiyakuTuusanInfoParam)MockObjectManager.getArgument(TuusanMockForSinkeiyaku.class, "exec", 0, 1);
        assertNull(takeiyakuTuusanInfoParam);
    }

}