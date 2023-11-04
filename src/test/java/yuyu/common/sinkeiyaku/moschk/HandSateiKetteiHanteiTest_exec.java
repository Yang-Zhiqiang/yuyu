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
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.GetSyoruittykymdMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ImusateikaniyhKbn;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;
import yuyu.def.classification.C_Knkysatei2jiyhKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ハンド査定・決定判定クラスのメソッド {@link HandSateiKetteiHantei#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HandSateiKetteiHanteiTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_ハンド査定・決定判定";

    private final static String sheetName = "INデータ_20160811";

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
                bind(GetSyoruittykymd.class).to(GetSyoruittykymdMockForSinkeiyaku.class);
                bind(SetHutuuSibouS.class).to(SetHutuuSibouSMockForSinkeiyaku.class);
                bind(BzGetImageProps.class).to(BzGetImagePropsMockForSinkeiyaku.class);
                bind(SetTyotikuseihokenhyouji.class).to(SetTyotikuseihokenhyoujiMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        GetSyoruittykymdMockForSinkeiyaku.caller = HandSateiKetteiHanteiTest_exec.class;
        SetHutuuSibouSMockForSinkeiyaku.caller = HandSateiKetteiHanteiTest_exec.class;
        BzGetImagePropsMockForSinkeiyaku.caller = HandSateiKetteiHanteiTest_exec.class;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.caller = HandSateiKetteiHanteiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.caller = null;
        SetHutuuSibouSMockForSinkeiyaku.caller = null;
        BzGetImagePropsMockForSinkeiyaku.caller = null;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.caller = null;

        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = null;
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = null;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = null;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HandSateiKetteiHanteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        bizDomManager.delete(bizDomManager.getKijyungkHanteiKawaseRate("2015", C_Tuukasyu.valueOf("USD")));

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112220");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1011", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 3, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1014", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1017", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1049", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.YOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1029", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112238");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1002", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1011", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 3, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1015", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1018", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1049", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.YOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1030", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112246");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1051", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1013", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 2, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1016", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1020", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.YOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1028", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("981112253");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1051", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1003", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 2, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1017", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1021", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1031", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1004", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1052", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1007", "申込点検指示メッセージＩＤ");

        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 3, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1018", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1022", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1026", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1032", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112238");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.YOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1005", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1019", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1033", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112246");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1006", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1023", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112253");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1007", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN3;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112261");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 4, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1006", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1007", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1011", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1012", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 2, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1022", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1049", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112279");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1007", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112287");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1007", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1026", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112295");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1002", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1022", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112303");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1008", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1024", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112311");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1008", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1025", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN3;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112329");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1009", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        SetHutuuSibouSMockForSinkeiyaku.SYORIPTN = SetHutuuSibouSMockForSinkeiyaku.TESTPATTERN4;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112337");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(55000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1011", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1049", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112345");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1012", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1022", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112402");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1012", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112410");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1036", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112428");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1036", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112436");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1037", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112444");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1010", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(230)
    public void testExec_A23() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112352");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        try {
            handSateiKetteiHantei.exec(mosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112352", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        handSateiKetteiHantei.setMostenken1yhKbn(C_MostenkenyhKbn.YOU);
        handSateiKetteiHantei.setMostenken2yhKbn(C_MostenkenyhKbn.YOU);
        handSateiKetteiHantei.setKnkysatei1jiyhKbn(C_Knkysatei1jiyhKbn.HUYOU);
        handSateiKetteiHantei.setKnkySatei2jiYhKbn(C_Knkysatei2jiyhKbn.HUYOU);
        handSateiKetteiHantei.setImuSateiKaniYhKbn(C_ImusateikaniyhKbn.YOU_KANI_MD);

        List<String> mosTenkenMsgIdList = new ArrayList<>();
        mosTenkenMsgIdList.add("Test001");
        List<String> knkySateiSijiMsgIdList = new ArrayList<>();
        knkySateiSijiMsgIdList.add("Test002");
        List<String> imuSateiSijiMsgIdList = new ArrayList<>();
        imuSateiSijiMsgIdList.add("Test003");
        handSateiKetteiHantei.setMosTenkenSijiMsgIdList(mosTenkenMsgIdList);
        handSateiKetteiHantei.setKnkySateiSijiMsgIdList(knkySateiSijiMsgIdList);
        handSateiKetteiHantei.setImuSateiSijiMsgIdList(imuSateiSijiMsgIdList);
        mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "Test001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "Test002", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "Test003", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_MD, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN4;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("861112225");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1036", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1037", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1038", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("861112233");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1038", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("861112241");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN4;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("861112258");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN5;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("861112266");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860011253");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 4, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1042", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1043", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1044", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1041", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 5, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1045", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1046", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1047", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1048", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "WHC0008", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000017");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1050", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000025");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000033");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000041");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1050", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000058");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1050", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000066");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1050", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000074");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(34999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }
    @Test
    @TestOrder(380)
    public void testExec_A38() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870000791");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1022", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001070");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001088");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(29999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1011", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1049", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001112");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(50000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1022", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001120");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(50000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001138");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(49999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001146");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1011", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001153");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1011", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001161");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("870001179");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("980000012");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean =
            (HanteiTyotikuseihokenBean) MockObjectManager.getArgument(SetTyotikuseihokenhyoujiMockForSinkeiyaku.class, "hanteiTyotikuseihoken", 0, 0);
        exNumericEquals(hanteiTyotikuseihokenBean.getDai1hknkkn(), 1, "第１保険期間");
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("980000020");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("980000038");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1056", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1057", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1058", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 3, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1053", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1054", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1055", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("980000046");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }
    @Test
    @TestOrder(520)
    public void testExec_A52() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("980000053");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 3, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1053", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1054", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1055", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000090");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 6, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1060", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1059", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1076", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1075", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(4), "IHC1006", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(5), "IHC1052", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 9, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1064", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1063", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1072", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1071", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1023", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(5), "IHC1066", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(6), "IHC1065", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(7), "IHC1074", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(8), "IHC1073", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000108");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1060", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1059", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1006", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 5, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1064", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1063", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1071", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1023", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1065", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000447");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1006", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 5, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1062", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1061", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1072", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1023", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1066", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.YOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000322");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1075", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1006", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1052", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 4, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1062", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1061", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1023", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1073", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.YOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000504");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 6, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1068", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1067", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1076", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1075", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(4), "IHC1006", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(5), "IHC1052", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 9, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1070", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1069", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1072", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1071", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1023", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(5), "IHC1066", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(6), "IHC1065", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(7), "IHC1074", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(8), "IHC1073", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000116");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 4, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1076", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1075", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1006", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1052", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 7, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1072", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1071", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1023", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1066", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1065", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(5), "IHC1074", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(6), "IHC1073", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1034", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000010");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000028");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000036");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1077", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000044");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1077", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000051");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000069");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000077");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000085");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1078", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000093");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1078", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000101");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1078", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000119");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000127");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1078", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000135");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1078", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000143");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000150");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("990000168");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(54999999));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000173");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 3, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1004", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1052", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1007", "申込点検指示メッセージＩＤ");

        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 3, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1018", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1022", "環境査定指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1026", "環境査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 1, "医務査定指示メッセージＩＤリストの件数");
        exStringEquals(imuSateiSijiMsgIdList.get(0), "IHC1032", "医務査定指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.YOU_KANI_UW, "医務査定（簡易）要否区分");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN5;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000181");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 2, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1079", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000199");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1001", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(780)
    public void testExec_A78() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000207");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1079", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(790)
    public void testExec_A79() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000223");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(false);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(35000000));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");
    }

    @Test
    @TestOrder(800)
    public void testExec_A80() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860001999");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1056", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1053", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1057", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1054", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1058", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1055", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }


    @Test
    @TestOrder(840)
    public void testExec_A84() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1076", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1074", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(840)
    public void testExec_A85() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 1, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1075", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1073", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860001999");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 5, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1056", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1057", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1058", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1076", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(4), "IHC1075", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 5, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1053", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1054", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1055", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1074", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1073", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN3;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 5, "申込点検指示メッセージＩＤリストの件数");
        exStringEquals(mosTenkenMsgIdList.get(0), "IHC1056", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(1), "IHC1057", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(2), "IHC1058", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(3), "IHC1076", "申込点検指示メッセージＩＤ");
        exStringEquals(mosTenkenMsgIdList.get(4), "IHC1075", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.YOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 5, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "IHC1053", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(1), "IHC1054", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(2), "IHC1055", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(3), "IHC1074", "申込点検指示メッセージＩＤ");
        exStringEquals(knkySateiSijiMsgIdList.get(4), "IHC1073", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860001981");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

    }


    @Test
    @TestOrder(890)
    public void testExec_A89() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        SetTyotikuseihokenhyoujiMockForSinkeiyaku.SYORIPTN = SetTyotikuseihokenhyoujiMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002062");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（2次）要否区分");
        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

    }


    @Test
    @TestOrder(900)
    public void testExec_A90() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002088");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        exNumericEquals(knkySateiSijiMsgIdList.size(), 1, "環境査定指示メッセージＩＤリストの件数");
        exStringEquals(knkySateiSijiMsgIdList.get(0), "WHC0028", "申込点検指示メッセージＩＤ");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.YOU_A, "環境査定（２次）要否区分");

    }


    @Test
    @TestOrder(910)
    public void testExec_A91() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002096");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(920)
    public void testExec_A92() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860002104");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.NONE);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

    }

    @Test
    @TestOrder(930)
    public void testExec_A93() {

        HandSateiKetteiHantei handSateiKetteiHantei = SWAKInjector.getInstance(HandSateiKetteiHantei.class);
        MockObjectManager.initialize();
        GetSyoruittykymdMockForSinkeiyaku.SYORIPTN = GetSyoruittykymdMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000082");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo("1001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);
        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(30000001));
        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        handSateiKetteiHantei.exec(mosnaiCheckParam);
        List<String> mosTenkenMsgIdList = handSateiKetteiHantei.getMosTenkenSijiMsgIdList();
        List<String> knkySateiSijiMsgIdList = handSateiKetteiHantei.getKnkySateiSijiMsgIdList();
        List<String> imuSateiSijiMsgIdList = handSateiKetteiHantei.getImuSateiSijiMsgIdList();

        exNumericEquals(mosTenkenMsgIdList.size(), 0, "申込点検指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getMostenken1yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getMostenken2yhKbn(), C_MostenkenyhKbn.HUYOU, "申込点検（２次）要否区分");

        exNumericEquals(knkySateiSijiMsgIdList.size(), 0, "環境査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getKnkysatei1jiyhKbn(), C_Knkysatei1jiyhKbn.HUYOU, "環境査定（１次）要否区分");
        exClassificationEquals(handSateiKetteiHantei.getKnkySatei2jiYhKbn(), C_Knkysatei2jiyhKbn.HUYOU, "環境査定（２次）要否区分");

        exNumericEquals(imuSateiSijiMsgIdList.size(), 0, "医務査定指示メッセージＩＤリストの件数");
        exClassificationEquals(handSateiKetteiHantei.getImuSateiKaniYhKbn(), C_ImusateikaniyhKbn.HUYOU, "医務査定（簡易）要否区分");
    }

}
