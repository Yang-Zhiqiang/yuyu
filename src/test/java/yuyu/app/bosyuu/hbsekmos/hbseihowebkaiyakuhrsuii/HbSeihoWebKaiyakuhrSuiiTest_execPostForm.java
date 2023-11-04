package yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.WSuiihyouParam;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin2;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin2MockForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebKaiyakuhrSuiiOutputBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ解約返戻金推移表作成のメイン処理{@link HbSeihoWebKaiyakuhrSuiiImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebKaiyakuhrSuiiTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebKaiyakuhrSuiiImpl hbSeihoWebKaiyakuhrSuiiImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ解約返戻金推移表作成";

    private final static String sheetName = "INデータ";

    private final static String requestSheetName = "業務データ";

    private static Map<String, String> gyoumuInfoMap;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
                bind(WSuiihyouSyuusin2.class).to(WSuiihyouSyuusin2MockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class;

        WSuiihyouSyuusin2MockForSinkeiyaku.caller = HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class, fileName, requestSheetName);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("D001", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("D002", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("D003", 1));

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI, 1));
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, 1));
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getSkHokenSyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, 2));
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A1"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(10), "（ＩＷＳ）解約時市場価格調整用利率１");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(20), "（ＩＷＳ）解約時市場価格調整用利率２");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(30), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(1200), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(2300), "（ＩＷＳ）解約時市場価格調整用利率３");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(100), "（ＩＷＳ）毎年解約返戻金１＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(1100), "（ＩＷＳ）毎年解約返戻金２＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(11100), "（ＩＷＳ）毎年解約返戻金３＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(200), "（ＩＷＳ）毎年積立金１＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(200), "（ＩＷＳ）毎年積立金２＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(200), "（ＩＷＳ）毎年積立金３＿１");

        exDateEquals((BizDate)MockObjectManager.getArgument(BizDomManagerImpl.class,                 "getSyouhnZokuseisByKykymdItems", 0, 0), BizDate.valueOf("20171120"), "契約日");
        exClassificationEquals((C_SyutkKbn)MockObjectManager.getArgument(BizDomManagerImpl.class,    "getSyouhnZokuseisByKykymdItems", 0, 1), C_SyutkKbn.SYU,              "主契約特約区分");
        exClassificationEquals((C_HknsyuruiNo)MockObjectManager.getArgument(BizDomManagerImpl.class, "getSyouhnZokuseisByKykymdItems", 0, 2), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI, "保険種類番号");
        exNumericEquals((Integer)MockObjectManager.getArgument(BizDomManagerImpl.class,              "getSyouhnZokuseisByKykymdItems", 0, 3), 0,                  "年金原資最低保証率");
        exNumericEquals((Integer)MockObjectManager.getArgument(BizDomManagerImpl.class,              "getSyouhnZokuseisByKykymdItems", 0, 4), 15,                 "第１保険期間");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(BizDomManagerImpl.class,    "getSyouhnZokuseisByKykymdItems", 0, 5), C_Tuukasyu.USD,     "通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(BizDomManagerImpl.class,      "getSyouhnZokuseisByKykymdItems", 0, 6), C_UmuKbn.ARI,       "初期死亡時円換算最低保証特約適用有無");
        exClassificationEquals((C_Sknenkinsyu)MockObjectManager.getArgument(BizDomManagerImpl.class, "getSyouhnZokuseisByKykymdItems", 0, 7), C_Sknenkinsyu.BLNK, "新契約年金種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(BizDomManagerImpl.class,      "getSyouhnZokuseisByKykymdItems", 0, 8), C_UmuKbn.NONE,      "定期支払金有無");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN8;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率１");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率２");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(1300), "（ＩＷＳ）毎年解約返戻金１＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(1300), "（ＩＷＳ）毎年解約返戻金２＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(1300), "（ＩＷＳ）毎年解約返戻金３＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(2100), "（ＩＷＳ）毎年積立金１＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(2100), "（ＩＷＳ）毎年積立金２＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(2100), "（ＩＷＳ）毎年積立金３＿１");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(10), "（ＩＷＳ）解約時市場価格調整用利率１");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(20), "（ＩＷＳ）解約時市場価格調整用利率２");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(30), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(1200), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(2300), "（ＩＷＳ）解約時市場価格調整用利率３");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(100), "（ＩＷＳ）毎年解約返戻金１＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x2(), BizNumber.valueOf(200), "（ＩＷＳ）毎年解約返戻金１＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x3(), BizNumber.valueOf(300), "（ＩＷＳ）毎年解約返戻金１＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x4(), BizNumber.valueOf(400), "（ＩＷＳ）毎年解約返戻金１＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x5(), BizNumber.valueOf(500), "（ＩＷＳ）毎年解約返戻金１＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x6(), BizNumber.valueOf(600), "（ＩＷＳ）毎年解約返戻金１＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x7(), BizNumber.valueOf(700), "（ＩＷＳ）毎年解約返戻金１＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x8(), BizNumber.valueOf(800), "（ＩＷＳ）毎年解約返戻金１＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x9(), BizNumber.valueOf(900), "（ＩＷＳ）毎年解約返戻金１＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x10(), BizNumber.valueOf(1000), "（ＩＷＳ）毎年解約返戻金１＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x11(), BizNumber.valueOf(1100), "（ＩＷＳ）毎年解約返戻金１＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x12(), BizNumber.valueOf(1200), "（ＩＷＳ）毎年解約返戻金１＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x13(), BizNumber.valueOf(1300), "（ＩＷＳ）毎年解約返戻金１＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x14(), BizNumber.valueOf(1400), "（ＩＷＳ）毎年解約返戻金１＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x15(), BizNumber.valueOf(1500), "（ＩＷＳ）毎年解約返戻金１＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x16(), BizNumber.valueOf(1600), "（ＩＷＳ）毎年解約返戻金１＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x17(), BizNumber.valueOf(1700), "（ＩＷＳ）毎年解約返戻金１＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x18(), BizNumber.valueOf(1800), "（ＩＷＳ）毎年解約返戻金１＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x19(), BizNumber.valueOf(1900), "（ＩＷＳ）毎年解約返戻金１＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x20(), BizNumber.valueOf(2000), "（ＩＷＳ）毎年解約返戻金１＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x21(), BizNumber.valueOf(2100), "（ＩＷＳ）毎年解約返戻金１＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x22(), BizNumber.valueOf(2200), "（ＩＷＳ）毎年解約返戻金１＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x23(), BizNumber.valueOf(2300), "（ＩＷＳ）毎年解約返戻金１＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x24(), BizNumber.valueOf(2400), "（ＩＷＳ）毎年解約返戻金１＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x25(), BizNumber.valueOf(2500), "（ＩＷＳ）毎年解約返戻金１＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x26(), BizNumber.valueOf(2600), "（ＩＷＳ）毎年解約返戻金１＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x27(), BizNumber.valueOf(2700), "（ＩＷＳ）毎年解約返戻金１＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x28(), BizNumber.valueOf(2800), "（ＩＷＳ）毎年解約返戻金１＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x29(), BizNumber.valueOf(2900), "（ＩＷＳ）毎年解約返戻金１＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x30(), BizNumber.valueOf(3000), "（ＩＷＳ）毎年解約返戻金１＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x31(), BizNumber.valueOf(3100), "（ＩＷＳ）毎年解約返戻金１＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x32(), BizNumber.valueOf(3200), "（ＩＷＳ）毎年解約返戻金１＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x33(), BizNumber.valueOf(3300), "（ＩＷＳ）毎年解約返戻金１＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x34(), BizNumber.valueOf(3400), "（ＩＷＳ）毎年解約返戻金１＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x35(), BizNumber.valueOf(3500), "（ＩＷＳ）毎年解約返戻金１＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x36(), BizNumber.valueOf(3600), "（ＩＷＳ）毎年解約返戻金１＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x37(), BizNumber.valueOf(3700), "（ＩＷＳ）毎年解約返戻金１＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x38(), BizNumber.valueOf(3800), "（ＩＷＳ）毎年解約返戻金１＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x39(), BizNumber.valueOf(3900), "（ＩＷＳ）毎年解約返戻金１＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x40(), BizNumber.valueOf(4000), "（ＩＷＳ）毎年解約返戻金１＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x41(), BizNumber.valueOf(4100), "（ＩＷＳ）毎年解約返戻金１＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x42(), BizNumber.valueOf(4200), "（ＩＷＳ）毎年解約返戻金１＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x43(), BizNumber.valueOf(4300), "（ＩＷＳ）毎年解約返戻金１＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x44(), BizNumber.valueOf(4400), "（ＩＷＳ）毎年解約返戻金１＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x45(), BizNumber.valueOf(4500), "（ＩＷＳ）毎年解約返戻金１＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x46(), BizNumber.valueOf(4600), "（ＩＷＳ）毎年解約返戻金１＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x47(), BizNumber.valueOf(4700), "（ＩＷＳ）毎年解約返戻金１＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x48(), BizNumber.valueOf(4800), "（ＩＷＳ）毎年解約返戻金１＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x49(), BizNumber.valueOf(4900), "（ＩＷＳ）毎年解約返戻金１＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x50(), BizNumber.valueOf(5000), "（ＩＷＳ）毎年解約返戻金１＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x51(), BizNumber.valueOf(5100), "（ＩＷＳ）毎年解約返戻金１＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x52(), BizNumber.valueOf(5200), "（ＩＷＳ）毎年解約返戻金１＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x53(), BizNumber.valueOf(5300), "（ＩＷＳ）毎年解約返戻金１＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x54(), BizNumber.valueOf(5400), "（ＩＷＳ）毎年解約返戻金１＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x55(), BizNumber.valueOf(5500), "（ＩＷＳ）毎年解約返戻金１＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x56(), BizNumber.valueOf(5600), "（ＩＷＳ）毎年解約返戻金１＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x57(), BizNumber.valueOf(5700), "（ＩＷＳ）毎年解約返戻金１＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x58(), BizNumber.valueOf(5800), "（ＩＷＳ）毎年解約返戻金１＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x59(), BizNumber.valueOf(5900), "（ＩＷＳ）毎年解約返戻金１＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x60(), BizNumber.valueOf(6000), "（ＩＷＳ）毎年解約返戻金１＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x61(), BizNumber.valueOf(6100), "（ＩＷＳ）毎年解約返戻金１＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x62(), BizNumber.valueOf(6200), "（ＩＷＳ）毎年解約返戻金１＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x63(), BizNumber.valueOf(6300), "（ＩＷＳ）毎年解約返戻金１＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x64(), BizNumber.valueOf(6400), "（ＩＷＳ）毎年解約返戻金１＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x65(), BizNumber.valueOf(6500), "（ＩＷＳ）毎年解約返戻金１＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x66(), BizNumber.valueOf(6600), "（ＩＷＳ）毎年解約返戻金１＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x67(), BizNumber.valueOf(6700), "（ＩＷＳ）毎年解約返戻金１＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x68(), BizNumber.valueOf(6800), "（ＩＷＳ）毎年解約返戻金１＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x69(), BizNumber.valueOf(6900), "（ＩＷＳ）毎年解約返戻金１＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x70(), BizNumber.valueOf(7000), "（ＩＷＳ）毎年解約返戻金１＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x71(), BizNumber.valueOf(7100), "（ＩＷＳ）毎年解約返戻金１＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x72(), BizNumber.valueOf(7200), "（ＩＷＳ）毎年解約返戻金１＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x73(), BizNumber.valueOf(7300), "（ＩＷＳ）毎年解約返戻金１＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x74(), BizNumber.valueOf(7400), "（ＩＷＳ）毎年解約返戻金１＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x75(), BizNumber.valueOf(7500), "（ＩＷＳ）毎年解約返戻金１＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x76(), BizNumber.valueOf(7600), "（ＩＷＳ）毎年解約返戻金１＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x77(), BizNumber.valueOf(7700), "（ＩＷＳ）毎年解約返戻金１＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x78(), BizNumber.valueOf(7800), "（ＩＷＳ）毎年解約返戻金１＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x79(), BizNumber.valueOf(7900), "（ＩＷＳ）毎年解約返戻金１＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x80(), BizNumber.valueOf(8000), "（ＩＷＳ）毎年解約返戻金１＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x81(), BizNumber.valueOf(8100), "（ＩＷＳ）毎年解約返戻金１＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x82(), BizNumber.valueOf(8200), "（ＩＷＳ）毎年解約返戻金１＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x83(), BizNumber.valueOf(8300), "（ＩＷＳ）毎年解約返戻金１＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x84(), BizNumber.valueOf(8400), "（ＩＷＳ）毎年解約返戻金１＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x85(), BizNumber.valueOf(8500), "（ＩＷＳ）毎年解約返戻金１＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x86(), BizNumber.valueOf(8600), "（ＩＷＳ）毎年解約返戻金１＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x87(), BizNumber.valueOf(8700), "（ＩＷＳ）毎年解約返戻金１＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x88(), BizNumber.valueOf(8800), "（ＩＷＳ）毎年解約返戻金１＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x89(), BizNumber.valueOf(8900), "（ＩＷＳ）毎年解約返戻金１＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x90(), BizNumber.valueOf(9000), "（ＩＷＳ）毎年解約返戻金１＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x91(), BizNumber.valueOf(9100), "（ＩＷＳ）毎年解約返戻金１＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x92(), BizNumber.valueOf(9200), "（ＩＷＳ）毎年解約返戻金１＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x93(), BizNumber.valueOf(9300), "（ＩＷＳ）毎年解約返戻金１＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x94(), BizNumber.valueOf(9400), "（ＩＷＳ）毎年解約返戻金１＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x95(), BizNumber.valueOf(9500), "（ＩＷＳ）毎年解約返戻金１＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x96(), BizNumber.valueOf(9600), "（ＩＷＳ）毎年解約返戻金１＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x97(), BizNumber.valueOf(9700), "（ＩＷＳ）毎年解約返戻金１＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x98(), BizNumber.valueOf(9800), "（ＩＷＳ）毎年解約返戻金１＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x99(), BizNumber.valueOf(9900), "（ＩＷＳ）毎年解約返戻金１＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(20100), "（ＩＷＳ）毎年解約返戻金２＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x2(), BizNumber.valueOf(20200), "（ＩＷＳ）毎年解約返戻金２＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x3(), BizNumber.valueOf(20300), "（ＩＷＳ）毎年解約返戻金２＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x4(), BizNumber.valueOf(20400), "（ＩＷＳ）毎年解約返戻金２＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x5(), BizNumber.valueOf(20500), "（ＩＷＳ）毎年解約返戻金２＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x6(), BizNumber.valueOf(20600), "（ＩＷＳ）毎年解約返戻金２＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x7(), BizNumber.valueOf(20700), "（ＩＷＳ）毎年解約返戻金２＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x8(), BizNumber.valueOf(20800), "（ＩＷＳ）毎年解約返戻金２＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x9(), BizNumber.valueOf(20900), "（ＩＷＳ）毎年解約返戻金２＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x10(), BizNumber.valueOf(21000), "（ＩＷＳ）毎年解約返戻金２＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x11(), BizNumber.valueOf(21100), "（ＩＷＳ）毎年解約返戻金２＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x12(), BizNumber.valueOf(21200), "（ＩＷＳ）毎年解約返戻金２＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x13(), BizNumber.valueOf(21300), "（ＩＷＳ）毎年解約返戻金２＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x14(), BizNumber.valueOf(21400), "（ＩＷＳ）毎年解約返戻金２＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x15(), BizNumber.valueOf(21500), "（ＩＷＳ）毎年解約返戻金２＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x16(), BizNumber.valueOf(21600), "（ＩＷＳ）毎年解約返戻金２＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x17(), BizNumber.valueOf(21700), "（ＩＷＳ）毎年解約返戻金２＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x18(), BizNumber.valueOf(21800), "（ＩＷＳ）毎年解約返戻金２＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x19(), BizNumber.valueOf(21900), "（ＩＷＳ）毎年解約返戻金２＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x20(), BizNumber.valueOf(22000), "（ＩＷＳ）毎年解約返戻金２＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x21(), BizNumber.valueOf(22100), "（ＩＷＳ）毎年解約返戻金２＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x22(), BizNumber.valueOf(22200), "（ＩＷＳ）毎年解約返戻金２＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x23(), BizNumber.valueOf(22300), "（ＩＷＳ）毎年解約返戻金２＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x24(), BizNumber.valueOf(22400), "（ＩＷＳ）毎年解約返戻金２＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x25(), BizNumber.valueOf(22500), "（ＩＷＳ）毎年解約返戻金２＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x26(), BizNumber.valueOf(22600), "（ＩＷＳ）毎年解約返戻金２＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x27(), BizNumber.valueOf(22700), "（ＩＷＳ）毎年解約返戻金２＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x28(), BizNumber.valueOf(22800), "（ＩＷＳ）毎年解約返戻金２＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x29(), BizNumber.valueOf(22900), "（ＩＷＳ）毎年解約返戻金２＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x30(), BizNumber.valueOf(23000), "（ＩＷＳ）毎年解約返戻金２＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x31(), BizNumber.valueOf(23100), "（ＩＷＳ）毎年解約返戻金２＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x32(), BizNumber.valueOf(23200), "（ＩＷＳ）毎年解約返戻金２＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x33(), BizNumber.valueOf(23300), "（ＩＷＳ）毎年解約返戻金２＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x34(), BizNumber.valueOf(23400), "（ＩＷＳ）毎年解約返戻金２＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x35(), BizNumber.valueOf(23500), "（ＩＷＳ）毎年解約返戻金２＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x36(), BizNumber.valueOf(23600), "（ＩＷＳ）毎年解約返戻金２＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x37(), BizNumber.valueOf(23700), "（ＩＷＳ）毎年解約返戻金２＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x38(), BizNumber.valueOf(23800), "（ＩＷＳ）毎年解約返戻金２＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x39(), BizNumber.valueOf(23900), "（ＩＷＳ）毎年解約返戻金２＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x40(), BizNumber.valueOf(24000), "（ＩＷＳ）毎年解約返戻金２＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x41(), BizNumber.valueOf(24100), "（ＩＷＳ）毎年解約返戻金２＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x42(), BizNumber.valueOf(24200), "（ＩＷＳ）毎年解約返戻金２＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x43(), BizNumber.valueOf(24300), "（ＩＷＳ）毎年解約返戻金２＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x44(), BizNumber.valueOf(24400), "（ＩＷＳ）毎年解約返戻金２＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x45(), BizNumber.valueOf(24500), "（ＩＷＳ）毎年解約返戻金２＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x46(), BizNumber.valueOf(24600), "（ＩＷＳ）毎年解約返戻金２＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x47(), BizNumber.valueOf(24700), "（ＩＷＳ）毎年解約返戻金２＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x48(), BizNumber.valueOf(24800), "（ＩＷＳ）毎年解約返戻金２＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x49(), BizNumber.valueOf(24900), "（ＩＷＳ）毎年解約返戻金２＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x50(), BizNumber.valueOf(25000), "（ＩＷＳ）毎年解約返戻金２＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x51(), BizNumber.valueOf(25100), "（ＩＷＳ）毎年解約返戻金２＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x52(), BizNumber.valueOf(25200), "（ＩＷＳ）毎年解約返戻金２＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x53(), BizNumber.valueOf(25300), "（ＩＷＳ）毎年解約返戻金２＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x54(), BizNumber.valueOf(25400), "（ＩＷＳ）毎年解約返戻金２＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x55(), BizNumber.valueOf(25500), "（ＩＷＳ）毎年解約返戻金２＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x56(), BizNumber.valueOf(25600), "（ＩＷＳ）毎年解約返戻金２＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x57(), BizNumber.valueOf(25700), "（ＩＷＳ）毎年解約返戻金２＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x58(), BizNumber.valueOf(25800), "（ＩＷＳ）毎年解約返戻金２＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x59(), BizNumber.valueOf(25900), "（ＩＷＳ）毎年解約返戻金２＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x60(), BizNumber.valueOf(26000), "（ＩＷＳ）毎年解約返戻金２＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x61(), BizNumber.valueOf(26100), "（ＩＷＳ）毎年解約返戻金２＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x62(), BizNumber.valueOf(26200), "（ＩＷＳ）毎年解約返戻金２＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x63(), BizNumber.valueOf(26300), "（ＩＷＳ）毎年解約返戻金２＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x64(), BizNumber.valueOf(26400), "（ＩＷＳ）毎年解約返戻金２＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x65(), BizNumber.valueOf(26500), "（ＩＷＳ）毎年解約返戻金２＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x66(), BizNumber.valueOf(26600), "（ＩＷＳ）毎年解約返戻金２＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x67(), BizNumber.valueOf(26700), "（ＩＷＳ）毎年解約返戻金２＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x68(), BizNumber.valueOf(26800), "（ＩＷＳ）毎年解約返戻金２＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x69(), BizNumber.valueOf(26900), "（ＩＷＳ）毎年解約返戻金２＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x70(), BizNumber.valueOf(27000), "（ＩＷＳ）毎年解約返戻金２＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x71(), BizNumber.valueOf(27100), "（ＩＷＳ）毎年解約返戻金２＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x72(), BizNumber.valueOf(27200), "（ＩＷＳ）毎年解約返戻金２＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x73(), BizNumber.valueOf(27300), "（ＩＷＳ）毎年解約返戻金２＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x74(), BizNumber.valueOf(27400), "（ＩＷＳ）毎年解約返戻金２＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x75(), BizNumber.valueOf(27500), "（ＩＷＳ）毎年解約返戻金２＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x76(), BizNumber.valueOf(27600), "（ＩＷＳ）毎年解約返戻金２＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x77(), BizNumber.valueOf(27700), "（ＩＷＳ）毎年解約返戻金２＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x78(), BizNumber.valueOf(27800), "（ＩＷＳ）毎年解約返戻金２＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x79(), BizNumber.valueOf(27900), "（ＩＷＳ）毎年解約返戻金２＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x80(), BizNumber.valueOf(28000), "（ＩＷＳ）毎年解約返戻金２＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x81(), BizNumber.valueOf(28100), "（ＩＷＳ）毎年解約返戻金２＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x82(), BizNumber.valueOf(28200), "（ＩＷＳ）毎年解約返戻金２＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x83(), BizNumber.valueOf(28300), "（ＩＷＳ）毎年解約返戻金２＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x84(), BizNumber.valueOf(28400), "（ＩＷＳ）毎年解約返戻金２＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x85(), BizNumber.valueOf(28500), "（ＩＷＳ）毎年解約返戻金２＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x86(), BizNumber.valueOf(28600), "（ＩＷＳ）毎年解約返戻金２＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x87(), BizNumber.valueOf(28700), "（ＩＷＳ）毎年解約返戻金２＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x88(), BizNumber.valueOf(28800), "（ＩＷＳ）毎年解約返戻金２＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x89(), BizNumber.valueOf(28900), "（ＩＷＳ）毎年解約返戻金２＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x90(), BizNumber.valueOf(29000), "（ＩＷＳ）毎年解約返戻金２＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x91(), BizNumber.valueOf(29100), "（ＩＷＳ）毎年解約返戻金２＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x92(), BizNumber.valueOf(29200), "（ＩＷＳ）毎年解約返戻金２＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x93(), BizNumber.valueOf(29300), "（ＩＷＳ）毎年解約返戻金２＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x94(), BizNumber.valueOf(29400), "（ＩＷＳ）毎年解約返戻金２＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x95(), BizNumber.valueOf(29500), "（ＩＷＳ）毎年解約返戻金２＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x96(), BizNumber.valueOf(29600), "（ＩＷＳ）毎年解約返戻金２＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x97(), BizNumber.valueOf(29700), "（ＩＷＳ）毎年解約返戻金２＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x98(), BizNumber.valueOf(29800), "（ＩＷＳ）毎年解約返戻金２＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x99(), BizNumber.valueOf(29900), "（ＩＷＳ）毎年解約返戻金２＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(40100), "（ＩＷＳ）毎年解約返戻金３＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x2(), BizNumber.valueOf(40200), "（ＩＷＳ）毎年解約返戻金３＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x3(), BizNumber.valueOf(40300), "（ＩＷＳ）毎年解約返戻金３＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x4(), BizNumber.valueOf(40400), "（ＩＷＳ）毎年解約返戻金３＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x5(), BizNumber.valueOf(40500), "（ＩＷＳ）毎年解約返戻金３＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x6(), BizNumber.valueOf(40600), "（ＩＷＳ）毎年解約返戻金３＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x7(), BizNumber.valueOf(40700), "（ＩＷＳ）毎年解約返戻金３＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x8(), BizNumber.valueOf(40800), "（ＩＷＳ）毎年解約返戻金３＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x9(), BizNumber.valueOf(40900), "（ＩＷＳ）毎年解約返戻金３＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x10(), BizNumber.valueOf(41000), "（ＩＷＳ）毎年解約返戻金３＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x11(), BizNumber.valueOf(41100), "（ＩＷＳ）毎年解約返戻金３＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x12(), BizNumber.valueOf(41200), "（ＩＷＳ）毎年解約返戻金３＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x13(), BizNumber.valueOf(41300), "（ＩＷＳ）毎年解約返戻金３＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x14(), BizNumber.valueOf(41400), "（ＩＷＳ）毎年解約返戻金３＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x15(), BizNumber.valueOf(41500), "（ＩＷＳ）毎年解約返戻金３＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x16(), BizNumber.valueOf(41600), "（ＩＷＳ）毎年解約返戻金３＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x17(), BizNumber.valueOf(41700), "（ＩＷＳ）毎年解約返戻金３＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x18(), BizNumber.valueOf(41800), "（ＩＷＳ）毎年解約返戻金３＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x19(), BizNumber.valueOf(41900), "（ＩＷＳ）毎年解約返戻金３＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x20(), BizNumber.valueOf(42000), "（ＩＷＳ）毎年解約返戻金３＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x21(), BizNumber.valueOf(42100), "（ＩＷＳ）毎年解約返戻金３＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x22(), BizNumber.valueOf(42200), "（ＩＷＳ）毎年解約返戻金３＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x23(), BizNumber.valueOf(42300), "（ＩＷＳ）毎年解約返戻金３＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x24(), BizNumber.valueOf(42400), "（ＩＷＳ）毎年解約返戻金３＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x25(), BizNumber.valueOf(42500), "（ＩＷＳ）毎年解約返戻金３＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x26(), BizNumber.valueOf(42600), "（ＩＷＳ）毎年解約返戻金３＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x27(), BizNumber.valueOf(42700), "（ＩＷＳ）毎年解約返戻金３＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x28(), BizNumber.valueOf(42800), "（ＩＷＳ）毎年解約返戻金３＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x29(), BizNumber.valueOf(42900), "（ＩＷＳ）毎年解約返戻金３＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x30(), BizNumber.valueOf(43000), "（ＩＷＳ）毎年解約返戻金３＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x31(), BizNumber.valueOf(43100), "（ＩＷＳ）毎年解約返戻金３＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x32(), BizNumber.valueOf(43200), "（ＩＷＳ）毎年解約返戻金３＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x33(), BizNumber.valueOf(43300), "（ＩＷＳ）毎年解約返戻金３＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x34(), BizNumber.valueOf(43400), "（ＩＷＳ）毎年解約返戻金３＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x35(), BizNumber.valueOf(43500), "（ＩＷＳ）毎年解約返戻金３＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x36(), BizNumber.valueOf(43600), "（ＩＷＳ）毎年解約返戻金３＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x37(), BizNumber.valueOf(43700), "（ＩＷＳ）毎年解約返戻金３＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x38(), BizNumber.valueOf(43800), "（ＩＷＳ）毎年解約返戻金３＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x39(), BizNumber.valueOf(43900), "（ＩＷＳ）毎年解約返戻金３＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x40(), BizNumber.valueOf(44000), "（ＩＷＳ）毎年解約返戻金３＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x41(), BizNumber.valueOf(44100), "（ＩＷＳ）毎年解約返戻金３＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x42(), BizNumber.valueOf(44200), "（ＩＷＳ）毎年解約返戻金３＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x43(), BizNumber.valueOf(44300), "（ＩＷＳ）毎年解約返戻金３＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x44(), BizNumber.valueOf(44400), "（ＩＷＳ）毎年解約返戻金３＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x45(), BizNumber.valueOf(44500), "（ＩＷＳ）毎年解約返戻金３＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x46(), BizNumber.valueOf(44600), "（ＩＷＳ）毎年解約返戻金３＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x47(), BizNumber.valueOf(44700), "（ＩＷＳ）毎年解約返戻金３＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x48(), BizNumber.valueOf(44800), "（ＩＷＳ）毎年解約返戻金３＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x49(), BizNumber.valueOf(44900), "（ＩＷＳ）毎年解約返戻金３＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x50(), BizNumber.valueOf(45000), "（ＩＷＳ）毎年解約返戻金３＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x51(), BizNumber.valueOf(45100), "（ＩＷＳ）毎年解約返戻金３＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x52(), BizNumber.valueOf(45200), "（ＩＷＳ）毎年解約返戻金３＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x53(), BizNumber.valueOf(45300), "（ＩＷＳ）毎年解約返戻金３＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x54(), BizNumber.valueOf(45400), "（ＩＷＳ）毎年解約返戻金３＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x55(), BizNumber.valueOf(45500), "（ＩＷＳ）毎年解約返戻金３＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x56(), BizNumber.valueOf(45600), "（ＩＷＳ）毎年解約返戻金３＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x57(), BizNumber.valueOf(45700), "（ＩＷＳ）毎年解約返戻金３＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x58(), BizNumber.valueOf(45800), "（ＩＷＳ）毎年解約返戻金３＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x59(), BizNumber.valueOf(45900), "（ＩＷＳ）毎年解約返戻金３＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x60(), BizNumber.valueOf(46000), "（ＩＷＳ）毎年解約返戻金３＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x61(), BizNumber.valueOf(46100), "（ＩＷＳ）毎年解約返戻金３＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x62(), BizNumber.valueOf(46200), "（ＩＷＳ）毎年解約返戻金３＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x63(), BizNumber.valueOf(46300), "（ＩＷＳ）毎年解約返戻金３＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x64(), BizNumber.valueOf(46400), "（ＩＷＳ）毎年解約返戻金３＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x65(), BizNumber.valueOf(46500), "（ＩＷＳ）毎年解約返戻金３＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x66(), BizNumber.valueOf(46600), "（ＩＷＳ）毎年解約返戻金３＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x67(), BizNumber.valueOf(46700), "（ＩＷＳ）毎年解約返戻金３＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x68(), BizNumber.valueOf(46800), "（ＩＷＳ）毎年解約返戻金３＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x69(), BizNumber.valueOf(46900), "（ＩＷＳ）毎年解約返戻金３＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x70(), BizNumber.valueOf(47000), "（ＩＷＳ）毎年解約返戻金３＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x71(), BizNumber.valueOf(47100), "（ＩＷＳ）毎年解約返戻金３＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x72(), BizNumber.valueOf(47200), "（ＩＷＳ）毎年解約返戻金３＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x73(), BizNumber.valueOf(47300), "（ＩＷＳ）毎年解約返戻金３＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x74(), BizNumber.valueOf(47400), "（ＩＷＳ）毎年解約返戻金３＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x75(), BizNumber.valueOf(47500), "（ＩＷＳ）毎年解約返戻金３＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x76(), BizNumber.valueOf(47600), "（ＩＷＳ）毎年解約返戻金３＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x77(), BizNumber.valueOf(47700), "（ＩＷＳ）毎年解約返戻金３＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x78(), BizNumber.valueOf(47800), "（ＩＷＳ）毎年解約返戻金３＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x79(), BizNumber.valueOf(47900), "（ＩＷＳ）毎年解約返戻金３＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x80(), BizNumber.valueOf(48000), "（ＩＷＳ）毎年解約返戻金３＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x81(), BizNumber.valueOf(48100), "（ＩＷＳ）毎年解約返戻金３＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x82(), BizNumber.valueOf(48200), "（ＩＷＳ）毎年解約返戻金３＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x83(), BizNumber.valueOf(48300), "（ＩＷＳ）毎年解約返戻金３＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x84(), BizNumber.valueOf(48400), "（ＩＷＳ）毎年解約返戻金３＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x85(), BizNumber.valueOf(48500), "（ＩＷＳ）毎年解約返戻金３＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x86(), BizNumber.valueOf(48600), "（ＩＷＳ）毎年解約返戻金３＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x87(), BizNumber.valueOf(48700), "（ＩＷＳ）毎年解約返戻金３＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x88(), BizNumber.valueOf(48800), "（ＩＷＳ）毎年解約返戻金３＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x89(), BizNumber.valueOf(48900), "（ＩＷＳ）毎年解約返戻金３＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x90(), BizNumber.valueOf(49000), "（ＩＷＳ）毎年解約返戻金３＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x91(), BizNumber.valueOf(49100), "（ＩＷＳ）毎年解約返戻金３＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x92(), BizNumber.valueOf(49200), "（ＩＷＳ）毎年解約返戻金３＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x93(), BizNumber.valueOf(49300), "（ＩＷＳ）毎年解約返戻金３＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x94(), BizNumber.valueOf(49400), "（ＩＷＳ）毎年解約返戻金３＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x95(), BizNumber.valueOf(49500), "（ＩＷＳ）毎年解約返戻金３＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x96(), BizNumber.valueOf(49600), "（ＩＷＳ）毎年解約返戻金３＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x97(), BizNumber.valueOf(49700), "（ＩＷＳ）毎年解約返戻金３＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x98(), BizNumber.valueOf(49800), "（ＩＷＳ）毎年解約返戻金３＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x99(), BizNumber.valueOf(49900), "（ＩＷＳ）毎年解約返戻金３＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(10100), "（ＩＷＳ）毎年積立金１＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x2(), BizNumber.valueOf(10200), "（ＩＷＳ）毎年積立金１＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x3(), BizNumber.valueOf(10300), "（ＩＷＳ）毎年積立金１＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x4(), BizNumber.valueOf(10400), "（ＩＷＳ）毎年積立金１＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x5(), BizNumber.valueOf(10500), "（ＩＷＳ）毎年積立金１＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x6(), BizNumber.valueOf(10600), "（ＩＷＳ）毎年積立金１＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x7(), BizNumber.valueOf(10700), "（ＩＷＳ）毎年積立金１＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x8(), BizNumber.valueOf(10800), "（ＩＷＳ）毎年積立金１＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x9(), BizNumber.valueOf(10900), "（ＩＷＳ）毎年積立金１＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x10(), BizNumber.valueOf(11000), "（ＩＷＳ）毎年積立金１＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x11(), BizNumber.valueOf(11100), "（ＩＷＳ）毎年積立金１＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x12(), BizNumber.valueOf(11200), "（ＩＷＳ）毎年積立金１＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x13(), BizNumber.valueOf(11300), "（ＩＷＳ）毎年積立金１＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x14(), BizNumber.valueOf(11400), "（ＩＷＳ）毎年積立金１＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x15(), BizNumber.valueOf(11500), "（ＩＷＳ）毎年積立金１＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x16(), BizNumber.valueOf(11600), "（ＩＷＳ）毎年積立金１＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x17(), BizNumber.valueOf(11700), "（ＩＷＳ）毎年積立金１＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x18(), BizNumber.valueOf(11800), "（ＩＷＳ）毎年積立金１＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x19(), BizNumber.valueOf(11900), "（ＩＷＳ）毎年積立金１＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x20(), BizNumber.valueOf(12000), "（ＩＷＳ）毎年積立金１＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x21(), BizNumber.valueOf(12100), "（ＩＷＳ）毎年積立金１＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x22(), BizNumber.valueOf(12200), "（ＩＷＳ）毎年積立金１＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x23(), BizNumber.valueOf(12300), "（ＩＷＳ）毎年積立金１＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x24(), BizNumber.valueOf(12400), "（ＩＷＳ）毎年積立金１＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x25(), BizNumber.valueOf(12500), "（ＩＷＳ）毎年積立金１＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x26(), BizNumber.valueOf(12600), "（ＩＷＳ）毎年積立金１＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x27(), BizNumber.valueOf(12700), "（ＩＷＳ）毎年積立金１＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x28(), BizNumber.valueOf(12800), "（ＩＷＳ）毎年積立金１＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x29(), BizNumber.valueOf(12900), "（ＩＷＳ）毎年積立金１＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x30(), BizNumber.valueOf(13000), "（ＩＷＳ）毎年積立金１＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x31(), BizNumber.valueOf(13100), "（ＩＷＳ）毎年積立金１＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x32(), BizNumber.valueOf(13200), "（ＩＷＳ）毎年積立金１＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x33(), BizNumber.valueOf(13300), "（ＩＷＳ）毎年積立金１＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x34(), BizNumber.valueOf(13400), "（ＩＷＳ）毎年積立金１＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x35(), BizNumber.valueOf(13500), "（ＩＷＳ）毎年積立金１＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x36(), BizNumber.valueOf(13600), "（ＩＷＳ）毎年積立金１＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x37(), BizNumber.valueOf(13700), "（ＩＷＳ）毎年積立金１＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x38(), BizNumber.valueOf(13800), "（ＩＷＳ）毎年積立金１＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x39(), BizNumber.valueOf(13900), "（ＩＷＳ）毎年積立金１＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x40(), BizNumber.valueOf(14000), "（ＩＷＳ）毎年積立金１＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x41(), BizNumber.valueOf(14100), "（ＩＷＳ）毎年積立金１＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x42(), BizNumber.valueOf(14200), "（ＩＷＳ）毎年積立金１＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x43(), BizNumber.valueOf(14300), "（ＩＷＳ）毎年積立金１＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x44(), BizNumber.valueOf(14400), "（ＩＷＳ）毎年積立金１＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x45(), BizNumber.valueOf(14500), "（ＩＷＳ）毎年積立金１＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x46(), BizNumber.valueOf(14600), "（ＩＷＳ）毎年積立金１＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x47(), BizNumber.valueOf(14700), "（ＩＷＳ）毎年積立金１＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x48(), BizNumber.valueOf(14800), "（ＩＷＳ）毎年積立金１＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x49(), BizNumber.valueOf(14900), "（ＩＷＳ）毎年積立金１＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x50(), BizNumber.valueOf(15000), "（ＩＷＳ）毎年積立金１＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x51(), BizNumber.valueOf(15100), "（ＩＷＳ）毎年積立金１＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x52(), BizNumber.valueOf(15200), "（ＩＷＳ）毎年積立金１＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x53(), BizNumber.valueOf(15300), "（ＩＷＳ）毎年積立金１＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x54(), BizNumber.valueOf(15400), "（ＩＷＳ）毎年積立金１＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x55(), BizNumber.valueOf(15500), "（ＩＷＳ）毎年積立金１＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x56(), BizNumber.valueOf(15600), "（ＩＷＳ）毎年積立金１＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x57(), BizNumber.valueOf(15700), "（ＩＷＳ）毎年積立金１＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x58(), BizNumber.valueOf(15800), "（ＩＷＳ）毎年積立金１＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x59(), BizNumber.valueOf(15900), "（ＩＷＳ）毎年積立金１＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x60(), BizNumber.valueOf(16000), "（ＩＷＳ）毎年積立金１＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x61(), BizNumber.valueOf(16100), "（ＩＷＳ）毎年積立金１＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x62(), BizNumber.valueOf(16200), "（ＩＷＳ）毎年積立金１＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x63(), BizNumber.valueOf(16300), "（ＩＷＳ）毎年積立金１＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x64(), BizNumber.valueOf(16400), "（ＩＷＳ）毎年積立金１＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x65(), BizNumber.valueOf(16500), "（ＩＷＳ）毎年積立金１＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x66(), BizNumber.valueOf(16600), "（ＩＷＳ）毎年積立金１＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x67(), BizNumber.valueOf(16700), "（ＩＷＳ）毎年積立金１＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x68(), BizNumber.valueOf(16800), "（ＩＷＳ）毎年積立金１＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x69(), BizNumber.valueOf(16900), "（ＩＷＳ）毎年積立金１＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x70(), BizNumber.valueOf(17000), "（ＩＷＳ）毎年積立金１＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x71(), BizNumber.valueOf(17100), "（ＩＷＳ）毎年積立金１＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x72(), BizNumber.valueOf(17200), "（ＩＷＳ）毎年積立金１＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x73(), BizNumber.valueOf(17300), "（ＩＷＳ）毎年積立金１＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x74(), BizNumber.valueOf(17400), "（ＩＷＳ）毎年積立金１＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x75(), BizNumber.valueOf(17500), "（ＩＷＳ）毎年積立金１＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x76(), BizNumber.valueOf(17600), "（ＩＷＳ）毎年積立金１＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x77(), BizNumber.valueOf(17700), "（ＩＷＳ）毎年積立金１＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x78(), BizNumber.valueOf(17800), "（ＩＷＳ）毎年積立金１＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x79(), BizNumber.valueOf(17900), "（ＩＷＳ）毎年積立金１＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x80(), BizNumber.valueOf(18000), "（ＩＷＳ）毎年積立金１＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x81(), BizNumber.valueOf(18100), "（ＩＷＳ）毎年積立金１＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x82(), BizNumber.valueOf(18200), "（ＩＷＳ）毎年積立金１＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x83(), BizNumber.valueOf(18300), "（ＩＷＳ）毎年積立金１＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x84(), BizNumber.valueOf(18400), "（ＩＷＳ）毎年積立金１＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x85(), BizNumber.valueOf(18500), "（ＩＷＳ）毎年積立金１＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x86(), BizNumber.valueOf(18600), "（ＩＷＳ）毎年積立金１＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x87(), BizNumber.valueOf(18700), "（ＩＷＳ）毎年積立金１＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x88(), BizNumber.valueOf(18800), "（ＩＷＳ）毎年積立金１＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x89(), BizNumber.valueOf(18900), "（ＩＷＳ）毎年積立金１＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x90(), BizNumber.valueOf(19000), "（ＩＷＳ）毎年積立金１＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x91(), BizNumber.valueOf(19100), "（ＩＷＳ）毎年積立金１＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x92(), BizNumber.valueOf(19200), "（ＩＷＳ）毎年積立金１＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x93(), BizNumber.valueOf(19300), "（ＩＷＳ）毎年積立金１＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x94(), BizNumber.valueOf(19400), "（ＩＷＳ）毎年積立金１＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x95(), BizNumber.valueOf(19500), "（ＩＷＳ）毎年積立金１＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x96(), BizNumber.valueOf(19600), "（ＩＷＳ）毎年積立金１＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x97(), BizNumber.valueOf(19700), "（ＩＷＳ）毎年積立金１＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x98(), BizNumber.valueOf(19800), "（ＩＷＳ）毎年積立金１＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x99(), BizNumber.valueOf(19900), "（ＩＷＳ）毎年積立金１＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(10100), "（ＩＷＳ）毎年積立金２＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x2(), BizNumber.valueOf(10200), "（ＩＷＳ）毎年積立金２＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x3(), BizNumber.valueOf(10300), "（ＩＷＳ）毎年積立金２＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x4(), BizNumber.valueOf(10400), "（ＩＷＳ）毎年積立金２＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x5(), BizNumber.valueOf(10500), "（ＩＷＳ）毎年積立金２＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x6(), BizNumber.valueOf(10600), "（ＩＷＳ）毎年積立金２＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x7(), BizNumber.valueOf(10700), "（ＩＷＳ）毎年積立金２＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x8(), BizNumber.valueOf(10800), "（ＩＷＳ）毎年積立金２＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x9(), BizNumber.valueOf(10900), "（ＩＷＳ）毎年積立金２＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x10(), BizNumber.valueOf(11000), "（ＩＷＳ）毎年積立金２＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x11(), BizNumber.valueOf(11100), "（ＩＷＳ）毎年積立金２＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x12(), BizNumber.valueOf(11200), "（ＩＷＳ）毎年積立金２＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x13(), BizNumber.valueOf(11300), "（ＩＷＳ）毎年積立金２＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x14(), BizNumber.valueOf(11400), "（ＩＷＳ）毎年積立金２＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x15(), BizNumber.valueOf(11500), "（ＩＷＳ）毎年積立金２＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x16(), BizNumber.valueOf(11600), "（ＩＷＳ）毎年積立金２＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x17(), BizNumber.valueOf(11700), "（ＩＷＳ）毎年積立金２＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x18(), BizNumber.valueOf(11800), "（ＩＷＳ）毎年積立金２＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x19(), BizNumber.valueOf(11900), "（ＩＷＳ）毎年積立金２＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x20(), BizNumber.valueOf(12000), "（ＩＷＳ）毎年積立金２＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x21(), BizNumber.valueOf(12100), "（ＩＷＳ）毎年積立金２＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x22(), BizNumber.valueOf(12200), "（ＩＷＳ）毎年積立金２＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x23(), BizNumber.valueOf(12300), "（ＩＷＳ）毎年積立金２＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x24(), BizNumber.valueOf(12400), "（ＩＷＳ）毎年積立金２＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x25(), BizNumber.valueOf(12500), "（ＩＷＳ）毎年積立金２＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x26(), BizNumber.valueOf(12600), "（ＩＷＳ）毎年積立金２＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x27(), BizNumber.valueOf(12700), "（ＩＷＳ）毎年積立金２＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x28(), BizNumber.valueOf(12800), "（ＩＷＳ）毎年積立金２＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x29(), BizNumber.valueOf(12900), "（ＩＷＳ）毎年積立金２＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x30(), BizNumber.valueOf(13000), "（ＩＷＳ）毎年積立金２＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x31(), BizNumber.valueOf(13100), "（ＩＷＳ）毎年積立金２＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x32(), BizNumber.valueOf(13200), "（ＩＷＳ）毎年積立金２＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x33(), BizNumber.valueOf(13300), "（ＩＷＳ）毎年積立金２＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x34(), BizNumber.valueOf(13400), "（ＩＷＳ）毎年積立金２＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x35(), BizNumber.valueOf(13500), "（ＩＷＳ）毎年積立金２＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x36(), BizNumber.valueOf(13600), "（ＩＷＳ）毎年積立金２＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x37(), BizNumber.valueOf(13700), "（ＩＷＳ）毎年積立金２＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x38(), BizNumber.valueOf(13800), "（ＩＷＳ）毎年積立金２＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x39(), BizNumber.valueOf(13900), "（ＩＷＳ）毎年積立金２＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x40(), BizNumber.valueOf(14000), "（ＩＷＳ）毎年積立金２＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x41(), BizNumber.valueOf(14100), "（ＩＷＳ）毎年積立金２＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x42(), BizNumber.valueOf(14200), "（ＩＷＳ）毎年積立金２＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x43(), BizNumber.valueOf(14300), "（ＩＷＳ）毎年積立金２＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x44(), BizNumber.valueOf(14400), "（ＩＷＳ）毎年積立金２＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x45(), BizNumber.valueOf(14500), "（ＩＷＳ）毎年積立金２＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x46(), BizNumber.valueOf(14600), "（ＩＷＳ）毎年積立金２＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x47(), BizNumber.valueOf(14700), "（ＩＷＳ）毎年積立金２＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x48(), BizNumber.valueOf(14800), "（ＩＷＳ）毎年積立金２＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x49(), BizNumber.valueOf(14900), "（ＩＷＳ）毎年積立金２＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x50(), BizNumber.valueOf(15000), "（ＩＷＳ）毎年積立金２＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x51(), BizNumber.valueOf(15100), "（ＩＷＳ）毎年積立金２＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x52(), BizNumber.valueOf(15200), "（ＩＷＳ）毎年積立金２＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x53(), BizNumber.valueOf(15300), "（ＩＷＳ）毎年積立金２＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x54(), BizNumber.valueOf(15400), "（ＩＷＳ）毎年積立金２＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x55(), BizNumber.valueOf(15500), "（ＩＷＳ）毎年積立金２＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x56(), BizNumber.valueOf(15600), "（ＩＷＳ）毎年積立金２＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x57(), BizNumber.valueOf(15700), "（ＩＷＳ）毎年積立金２＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x58(), BizNumber.valueOf(15800), "（ＩＷＳ）毎年積立金２＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x59(), BizNumber.valueOf(15900), "（ＩＷＳ）毎年積立金２＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x60(), BizNumber.valueOf(16000), "（ＩＷＳ）毎年積立金２＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x61(), BizNumber.valueOf(16100), "（ＩＷＳ）毎年積立金２＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x62(), BizNumber.valueOf(16200), "（ＩＷＳ）毎年積立金２＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x63(), BizNumber.valueOf(16300), "（ＩＷＳ）毎年積立金２＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x64(), BizNumber.valueOf(16400), "（ＩＷＳ）毎年積立金２＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x65(), BizNumber.valueOf(16500), "（ＩＷＳ）毎年積立金２＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x66(), BizNumber.valueOf(16600), "（ＩＷＳ）毎年積立金２＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x67(), BizNumber.valueOf(16700), "（ＩＷＳ）毎年積立金２＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x68(), BizNumber.valueOf(16800), "（ＩＷＳ）毎年積立金２＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x69(), BizNumber.valueOf(16900), "（ＩＷＳ）毎年積立金２＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x70(), BizNumber.valueOf(17000), "（ＩＷＳ）毎年積立金２＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x71(), BizNumber.valueOf(17100), "（ＩＷＳ）毎年積立金２＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x72(), BizNumber.valueOf(17200), "（ＩＷＳ）毎年積立金２＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x73(), BizNumber.valueOf(17300), "（ＩＷＳ）毎年積立金２＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x74(), BizNumber.valueOf(17400), "（ＩＷＳ）毎年積立金２＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x75(), BizNumber.valueOf(17500), "（ＩＷＳ）毎年積立金２＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x76(), BizNumber.valueOf(17600), "（ＩＷＳ）毎年積立金２＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x77(), BizNumber.valueOf(17700), "（ＩＷＳ）毎年積立金２＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x78(), BizNumber.valueOf(17800), "（ＩＷＳ）毎年積立金２＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x79(), BizNumber.valueOf(17900), "（ＩＷＳ）毎年積立金２＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x80(), BizNumber.valueOf(18000), "（ＩＷＳ）毎年積立金２＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x81(), BizNumber.valueOf(18100), "（ＩＷＳ）毎年積立金２＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x82(), BizNumber.valueOf(18200), "（ＩＷＳ）毎年積立金２＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x83(), BizNumber.valueOf(18300), "（ＩＷＳ）毎年積立金２＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x84(), BizNumber.valueOf(18400), "（ＩＷＳ）毎年積立金２＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x85(), BizNumber.valueOf(18500), "（ＩＷＳ）毎年積立金２＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x86(), BizNumber.valueOf(18600), "（ＩＷＳ）毎年積立金２＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x87(), BizNumber.valueOf(18700), "（ＩＷＳ）毎年積立金２＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x88(), BizNumber.valueOf(18800), "（ＩＷＳ）毎年積立金２＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x89(), BizNumber.valueOf(18900), "（ＩＷＳ）毎年積立金２＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x90(), BizNumber.valueOf(19000), "（ＩＷＳ）毎年積立金２＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x91(), BizNumber.valueOf(19100), "（ＩＷＳ）毎年積立金２＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x92(), BizNumber.valueOf(19200), "（ＩＷＳ）毎年積立金２＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x93(), BizNumber.valueOf(19300), "（ＩＷＳ）毎年積立金２＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x94(), BizNumber.valueOf(19400), "（ＩＷＳ）毎年積立金２＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x95(), BizNumber.valueOf(19500), "（ＩＷＳ）毎年積立金２＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x96(), BizNumber.valueOf(19600), "（ＩＷＳ）毎年積立金２＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x97(), BizNumber.valueOf(19700), "（ＩＷＳ）毎年積立金２＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x98(), BizNumber.valueOf(19800), "（ＩＷＳ）毎年積立金２＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x99(), BizNumber.valueOf(19900), "（ＩＷＳ）毎年積立金２＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(10100), "（ＩＷＳ）毎年積立金３＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x2(), BizNumber.valueOf(10200), "（ＩＷＳ）毎年積立金３＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x3(), BizNumber.valueOf(10300), "（ＩＷＳ）毎年積立金３＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x4(), BizNumber.valueOf(10400), "（ＩＷＳ）毎年積立金３＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x5(), BizNumber.valueOf(10500), "（ＩＷＳ）毎年積立金３＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x6(), BizNumber.valueOf(10600), "（ＩＷＳ）毎年積立金３＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x7(), BizNumber.valueOf(10700), "（ＩＷＳ）毎年積立金３＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x8(), BizNumber.valueOf(10800), "（ＩＷＳ）毎年積立金３＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x9(), BizNumber.valueOf(10900), "（ＩＷＳ）毎年積立金３＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x10(), BizNumber.valueOf(11000), "（ＩＷＳ）毎年積立金３＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x11(), BizNumber.valueOf(11100), "（ＩＷＳ）毎年積立金３＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x12(), BizNumber.valueOf(11200), "（ＩＷＳ）毎年積立金３＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x13(), BizNumber.valueOf(11300), "（ＩＷＳ）毎年積立金３＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x14(), BizNumber.valueOf(11400), "（ＩＷＳ）毎年積立金３＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x15(), BizNumber.valueOf(11500), "（ＩＷＳ）毎年積立金３＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x16(), BizNumber.valueOf(11600), "（ＩＷＳ）毎年積立金３＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x17(), BizNumber.valueOf(11700), "（ＩＷＳ）毎年積立金３＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x18(), BizNumber.valueOf(11800), "（ＩＷＳ）毎年積立金３＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x19(), BizNumber.valueOf(11900), "（ＩＷＳ）毎年積立金３＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x20(), BizNumber.valueOf(12000), "（ＩＷＳ）毎年積立金３＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x21(), BizNumber.valueOf(12100), "（ＩＷＳ）毎年積立金３＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x22(), BizNumber.valueOf(12200), "（ＩＷＳ）毎年積立金３＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x23(), BizNumber.valueOf(12300), "（ＩＷＳ）毎年積立金３＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x24(), BizNumber.valueOf(12400), "（ＩＷＳ）毎年積立金３＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x25(), BizNumber.valueOf(12500), "（ＩＷＳ）毎年積立金３＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x26(), BizNumber.valueOf(12600), "（ＩＷＳ）毎年積立金３＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x27(), BizNumber.valueOf(12700), "（ＩＷＳ）毎年積立金３＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x28(), BizNumber.valueOf(12800), "（ＩＷＳ）毎年積立金３＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x29(), BizNumber.valueOf(12900), "（ＩＷＳ）毎年積立金３＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x30(), BizNumber.valueOf(13000), "（ＩＷＳ）毎年積立金３＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x31(), BizNumber.valueOf(13100), "（ＩＷＳ）毎年積立金３＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x32(), BizNumber.valueOf(13200), "（ＩＷＳ）毎年積立金３＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x33(), BizNumber.valueOf(13300), "（ＩＷＳ）毎年積立金３＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x34(), BizNumber.valueOf(13400), "（ＩＷＳ）毎年積立金３＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x35(), BizNumber.valueOf(13500), "（ＩＷＳ）毎年積立金３＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x36(), BizNumber.valueOf(13600), "（ＩＷＳ）毎年積立金３＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x37(), BizNumber.valueOf(13700), "（ＩＷＳ）毎年積立金３＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x38(), BizNumber.valueOf(13800), "（ＩＷＳ）毎年積立金３＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x39(), BizNumber.valueOf(13900), "（ＩＷＳ）毎年積立金３＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x40(), BizNumber.valueOf(14000), "（ＩＷＳ）毎年積立金３＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x41(), BizNumber.valueOf(14100), "（ＩＷＳ）毎年積立金３＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x42(), BizNumber.valueOf(14200), "（ＩＷＳ）毎年積立金３＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x43(), BizNumber.valueOf(14300), "（ＩＷＳ）毎年積立金３＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x44(), BizNumber.valueOf(14400), "（ＩＷＳ）毎年積立金３＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x45(), BizNumber.valueOf(14500), "（ＩＷＳ）毎年積立金３＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x46(), BizNumber.valueOf(14600), "（ＩＷＳ）毎年積立金３＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x47(), BizNumber.valueOf(14700), "（ＩＷＳ）毎年積立金３＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x48(), BizNumber.valueOf(14800), "（ＩＷＳ）毎年積立金３＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x49(), BizNumber.valueOf(14900), "（ＩＷＳ）毎年積立金３＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x50(), BizNumber.valueOf(15000), "（ＩＷＳ）毎年積立金３＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x51(), BizNumber.valueOf(15100), "（ＩＷＳ）毎年積立金３＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x52(), BizNumber.valueOf(15200), "（ＩＷＳ）毎年積立金３＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x53(), BizNumber.valueOf(15300), "（ＩＷＳ）毎年積立金３＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x54(), BizNumber.valueOf(15400), "（ＩＷＳ）毎年積立金３＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x55(), BizNumber.valueOf(15500), "（ＩＷＳ）毎年積立金３＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x56(), BizNumber.valueOf(15600), "（ＩＷＳ）毎年積立金３＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x57(), BizNumber.valueOf(15700), "（ＩＷＳ）毎年積立金３＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x58(), BizNumber.valueOf(15800), "（ＩＷＳ）毎年積立金３＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x59(), BizNumber.valueOf(15900), "（ＩＷＳ）毎年積立金３＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x60(), BizNumber.valueOf(16000), "（ＩＷＳ）毎年積立金３＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x61(), BizNumber.valueOf(16100), "（ＩＷＳ）毎年積立金３＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x62(), BizNumber.valueOf(16200), "（ＩＷＳ）毎年積立金３＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x63(), BizNumber.valueOf(16300), "（ＩＷＳ）毎年積立金３＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x64(), BizNumber.valueOf(16400), "（ＩＷＳ）毎年積立金３＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x65(), BizNumber.valueOf(16500), "（ＩＷＳ）毎年積立金３＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x66(), BizNumber.valueOf(16600), "（ＩＷＳ）毎年積立金３＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x67(), BizNumber.valueOf(16700), "（ＩＷＳ）毎年積立金３＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x68(), BizNumber.valueOf(16800), "（ＩＷＳ）毎年積立金３＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x69(), BizNumber.valueOf(16900), "（ＩＷＳ）毎年積立金３＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x70(), BizNumber.valueOf(17000), "（ＩＷＳ）毎年積立金３＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x71(), BizNumber.valueOf(17100), "（ＩＷＳ）毎年積立金３＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x72(), BizNumber.valueOf(17200), "（ＩＷＳ）毎年積立金３＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x73(), BizNumber.valueOf(17300), "（ＩＷＳ）毎年積立金３＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x74(), BizNumber.valueOf(17400), "（ＩＷＳ）毎年積立金３＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x75(), BizNumber.valueOf(17500), "（ＩＷＳ）毎年積立金３＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x76(), BizNumber.valueOf(17600), "（ＩＷＳ）毎年積立金３＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x77(), BizNumber.valueOf(17700), "（ＩＷＳ）毎年積立金３＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x78(), BizNumber.valueOf(17800), "（ＩＷＳ）毎年積立金３＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x79(), BizNumber.valueOf(17900), "（ＩＷＳ）毎年積立金３＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x80(), BizNumber.valueOf(18000), "（ＩＷＳ）毎年積立金３＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x81(), BizNumber.valueOf(18100), "（ＩＷＳ）毎年積立金３＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x82(), BizNumber.valueOf(18200), "（ＩＷＳ）毎年積立金３＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x83(), BizNumber.valueOf(18300), "（ＩＷＳ）毎年積立金３＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x84(), BizNumber.valueOf(18400), "（ＩＷＳ）毎年積立金３＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x85(), BizNumber.valueOf(18500), "（ＩＷＳ）毎年積立金３＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x86(), BizNumber.valueOf(18600), "（ＩＷＳ）毎年積立金３＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x87(), BizNumber.valueOf(18700), "（ＩＷＳ）毎年積立金３＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x88(), BizNumber.valueOf(18800), "（ＩＷＳ）毎年積立金３＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x89(), BizNumber.valueOf(18900), "（ＩＷＳ）毎年積立金３＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x90(), BizNumber.valueOf(19000), "（ＩＷＳ）毎年積立金３＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x91(), BizNumber.valueOf(19100), "（ＩＷＳ）毎年積立金３＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x92(), BizNumber.valueOf(19200), "（ＩＷＳ）毎年積立金３＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x93(), BizNumber.valueOf(19300), "（ＩＷＳ）毎年積立金３＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x94(), BizNumber.valueOf(19400), "（ＩＷＳ）毎年積立金３＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x95(), BizNumber.valueOf(19500), "（ＩＷＳ）毎年積立金３＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x96(), BizNumber.valueOf(19600), "（ＩＷＳ）毎年積立金３＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x97(), BizNumber.valueOf(19700), "（ＩＷＳ）毎年積立金３＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x98(), BizNumber.valueOf(19800), "（ＩＷＳ）毎年積立金３＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x99(), BizNumber.valueOf(19900), "（ＩＷＳ）毎年積立金３＿９９)");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(10), "（ＩＷＳ）解約時市場価格調整用利率１");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(20), "（ＩＷＳ）解約時市場価格調整用利率２");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(30), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(1200), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(2300), "（ＩＷＳ）解約時市場価格調整用利率３");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(100), "（ＩＷＳ）毎年解約返戻金１＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(20100), "（ＩＷＳ）毎年解約返戻金２＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(40100), "（ＩＷＳ）毎年解約返戻金３＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(10100), "（ＩＷＳ）毎年積立金１＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(10100), "（ＩＷＳ）毎年積立金２＿１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(10100), "（ＩＷＳ）毎年積立金３＿１");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x2(), BizNumber.valueOf(200), "（ＩＷＳ）毎年解約返戻金１＿２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x2(), BizNumber.valueOf(20200), "（ＩＷＳ）毎年解約返戻金２＿２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x2(), BizNumber.valueOf(40200), "（ＩＷＳ）毎年解約返戻金３＿２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x2(), BizNumber.valueOf(10200), "（ＩＷＳ）毎年積立金１＿２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x2(), BizNumber.valueOf(10200), "（ＩＷＳ）毎年積立金２＿２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x2(), BizNumber.valueOf(10200), "（ＩＷＳ）毎年積立金３＿２");
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A5"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号１");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率１");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号２");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率２");
        exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿９９)");

        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿２９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿３９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿４９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿５９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿６９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿７９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿８９)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９０)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９１)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９２)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９３)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９４)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９５)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９６)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９７)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９８)");
        exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿９９)");
    }

     @Test
     @TestOrder(70)
     public void testExecPostForm_A7() throws Exception {

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A7"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "才満期表示エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }

     @Test
     @TestOrder(80)
     public void testExecPostForm_A8() throws Exception {

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A8"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "端末権限エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }

     @Test
     @TestOrder(90)
     public void testExecPostForm_A9() throws Exception {

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A9"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "使用者権限エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }

     @Test
     @TestOrder(110)
     public void testExecPostForm_A11() throws Exception {

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
         WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN6;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A11"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }

     @Test
     @TestOrder(120)
     public void testExecPostForm_A12() throws Exception {

         MockObjectManager.initialize();

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
         WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN1;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A12"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

         exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(10), "（ＩＷＳ）解約時市場価格調整用利率１");
         exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号２");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(20), "（ＩＷＳ）解約時市場価格調整用利率２");
         exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.HU, "（ＩＷＳ）解約時市場価格調整用利率負号３");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(30), "（ＩＷＳ）解約時市場価格調整用利率３");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(1200), "（ＩＷＳ）解約時市場価格調整用利率３");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(2300), "（ＩＷＳ）解約時市場価格調整用利率３");

         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(100), "（ＩＷＳ）毎年解約返戻金１＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(1100), "（ＩＷＳ）毎年解約返戻金２＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(11100), "（ＩＷＳ）毎年解約返戻金３＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(200), "（ＩＷＳ）毎年積立金１＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(200), "（ＩＷＳ）毎年積立金２＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(200), "（ＩＷＳ）毎年積立金３＿１");

         WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouSyuusin2MockForSinkeiyaku.class, "exec", 0, 0);

         KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
         exStringEquals(keisanWExtBean.getSyouhncd(), "D001", "商品コード");
         exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
         exStringEquals(keisanWExtBean.getRyouritusdno(), "6", "料率世代番号");
         exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.1056), "予定利率");
         exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
         exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
         exNumericEquals(keisanWExtBean.getHrkkkn(), 30, "払込期間");
         exNumericEquals(keisanWExtBean.getHknkkn(), 99, "保険期間");
         exNumericEquals(keisanWExtBean.getHhknnen(), 0, "被保険者年齢");
         exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
         exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(41215123145.12, BizCurrencyTypes.DOLLAR), "基本Ｓ");
         exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "保険料");
         exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20171120), "契約日");
         exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
         exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0.1124), "契約時市場価格調整用利率");
         exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0.1234), "積立利率");

         exDateEquals(wSuiihyouParam.getKwsratekjymd(), null, "為替レート基準日");
         exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20171120), "計算基準日");
         exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
         exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.BLNK, "証券再発行区分");
         exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
         exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 20, "ＭＶＡ適用期間");
         exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.ZERO, "設定倍率");
         exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.ZERO, "積立金増加率上限");
         exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(0), "ターゲット特約基準金額");
     }

     @Test
     @TestOrder(130)
     public void testExecPostForm_A13() throws Exception {

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
         WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN2;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A13"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }

     @Test
     @TestOrder(140)
     public void testExecPostForm_A14() throws Exception {

         MockObjectManager.initialize();

         HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
         WSuiihyouSyuusin2MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin2MockForSinkeiyaku.TESTPATTERN1;

         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A14"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

         exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn1(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt1(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率１");
         exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn2(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号２");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt2(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率２");
         exClassificationEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrtfgukbn3(), C_HugouKbn.SEI, "（ＩＷＳ）解約時市場価格調整用利率負号３");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsKykjsjkkktyusirrt3(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgw(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMvatkykknmnryutykgv(), BizNumber.valueOf(0), "（ＩＷＳ）解約時市場価格調整用利率３");

         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin1x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金１＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin2x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金２＿１");
         exBizCalcbleEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsMaitositumitatekin3x1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年積立金３＿１");

         MockObjectManager.assertNotCalled(WSuiihyouSyuusin2MockForSinkeiyaku.class, "exec");
     }

     @Test
     @TestOrder(150)
     public void testExecPostForm_B1() throws Exception {
         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", " ");
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");

         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }

     @Test
     @TestOrder(160)
     public void testExecPostForm_B2() throws Exception {
         MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
             "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

         pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_B2"));
         pMap.add("operatorId", "testId");
         pMap.add("orgCode", "testCode");
         pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuii");
         pMap.add("coopClass", "01");


         WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebKaiyakuhrSuiiImpl.execPostForm(pMap);

         WsHbSeihoWebKaiyakuhrSuiiOutputBean wsHbSeihoWebKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
             .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                 WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "申込Ｓエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
         exStringEquals(wsHbSeihoWebKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
     }
}
