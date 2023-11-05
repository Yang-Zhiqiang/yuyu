package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 配当元利金計算クラスのメソッド
 * {@link KeisanDGanrikin#exec(IT_KhTumitateDKanri, BizDate, BizDate, BizDate, BizDate, C_UmuKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDGanrikinTest_exec3 {

    C_ErrorKbn  errorKbn;

    @Inject
    KeisanDGanrikin keisanDGanrikin;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当元利金計算";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SetDNnd.class).to(SetDNndMockForHozen.class);
                bind(NaiteiKakuteiRateHantei.class).to(NaiteiKakuteiRateHanteiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanDGanrikinTest_exec1.class, fileName, sheetName);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManagerImpl bizDomManagerImpl = SWAKInjector.getInstance(BizDomManagerImpl.class);
        bizDomManagerImpl.delete(bizDomManagerImpl.getAllHaitouRiritu());
    }

    @BeforeClass
    public static void testInit() {

        SetDNndMockForHozen.caller = KeisanDGanrikinTest_exec3.class;
        NaiteiKakuteiRateHanteiMockForHozen.caller = KeisanDGanrikinTest_exec3.class;

    }

    @AfterClass
    public static void testClear() {

        SetDNndMockForHozen.caller = null;
        NaiteiKakuteiRateHanteiMockForHozen.caller = null;

        MockObjectManager.initialize();
    }
    @Test
    @TestOrder(10)
    public void testExec_C1() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        khTumitateDKanri = null;
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_C2() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20181111");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = null;
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_C3() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20181111");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20180521");
        BizDate pKykymd = null;
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_C4() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20181111");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20180521");
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = null;
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "必須の引数にnullが含まれます", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testExec_C5() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20181111");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1111");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "整合性エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "引数より算出された計算基準日自とエンティティから算出した計算基準日が一致しません", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(60)
    public void testExec_C6() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20170512");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1111");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(1).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");

        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.ARI, "決算使用有無");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20180721), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20150512), "円建変更日");
        IT_KhTumitateDKanri khTumitateDKanri1 = (IT_KhTumitateDKanri)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 2);
        exDateEquals(khTumitateDKanri1.getTumitatedtumitateymd(), BizDate.valueOf("20170512"), "積立D積立年月日");
        exClassificationEquals(khTumitateDKanri1.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exBizCalcbleEquals(khTumitateDKanri1.getTumitated(), BizCurrency.valueOf(1000), "積立Ｄ");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20170616), "計算基準日");


    }

    @Test
    @TestOrder(70)
    public void testExec_C7() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20170512");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("0102");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "整合性エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "確定期間中に内定レコードを処理対象にしています", "エラー情報２（小分類）");

        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0),  BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.ARI, "決算使用有無");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_C8_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_C8() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20181101");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("0102");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN4;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1100), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181121"), "計算基準日至");

        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.ARI, "決算使用有無");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_C9_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_C9() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20181101");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN4;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1100), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181121"), "計算基準日至");

        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.NONE, "決算使用有無");

    }

    @Test
    @TestOrder(120)
    public void testExec_C10() {

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        BizDate haitounendo = BizDate.valueOf("20170512");
        khTumitateDKanri.setTumitatedtumitateymd(haitounendo);
        khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);
        BizCurrency tumitated = BizCurrency.valueOf(1000);
        khTumitateDKanri.setTumitated(tumitated);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20150512");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khTumitateDKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(1).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");

    }
}
