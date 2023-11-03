package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当元利金計算クラスのメソッド
 * {@link KeisanDGanrikin#exec(IT_KhHaitouKanri, BizDate, BizDate, BizDate, BizDate, C_UmuKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDGanrikinTest_exec2 {

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
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
                bind(NaiteiKakuteiRateHantei.class).to(NaiteiKakuteiRateHanteiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SetDNndMockForHozen.caller = KeisanDGanrikinTest_exec2.class;
        SetHokenNndMockForHozen.caller = KeisanDGanrikinTest_exec2.class;
        NaiteiKakuteiRateHanteiMockForHozen.caller = KeisanDGanrikinTest_exec2.class;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanDGanrikinTest_exec1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
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

    @AfterClass
    public static void testClear() {

        SetDNndMockForHozen.caller = null;
        SetHokenNndMockForHozen.caller = null;
        NaiteiKakuteiRateHanteiMockForHozen.caller = null;

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_B1() {

        IT_KhHaitouKanri khHaitouKanri = null;
        BizDate pCalckijyunymd = BizDate.valueOf("20181115");
        BizDate pKykymd = BizDate.valueOf("20181115");
        BizDate pYendthnkymd = BizDate.valueOf("20181115");
        BizDate pSyoriYmd = BizDate.valueOf("20181115");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_B2() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2018);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = null;
        BizDate pKykymd = BizDate.valueOf("20181115");
        BizDate pYendthnkymd = BizDate.valueOf("20181115");
        BizDate pSyoriYmd = BizDate.valueOf("20181115");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_B3() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2018);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20181115");
        BizDate pKykymd = null;
        BizDate pYendthnkymd = BizDate.valueOf("20181115");
        BizDate pSyoriYmd = BizDate.valueOf("20181115");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_B4() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2018);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20181115");
        BizDate pKykymd = BizDate.valueOf("20181115");
        BizDate pYendthnkymd = BizDate.valueOf("20181115");
        BizDate pSyoriYmd = null;
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "必須の引数にnullが含まれます", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testExec_B5() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2018);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20151113");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1111");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "整合性エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "引数より算出された計算基準日自とエンティティから算出した計算基準日が一致しません", "エラー情報２（小分類）");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20150512), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20180607), "判定日");


    }

    @Test
    @TestOrder(60)
    public void testExec_B6() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2017);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20150513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1111");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20150512), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20180607), "判定日");
        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20150513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.ARI, "決算使用有無");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20180721), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20150512), "円建変更日");
        IT_KhHaitouKanri khHaitouKanri1 = (IT_KhHaitouKanri)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 2);
        exDateYEquals(khHaitouKanri1.getHaitounendo(), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals(khHaitouKanri1.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exBizCalcbleEquals(khHaitouKanri1.getKariwariatedruigk(), BizCurrency.valueOf(1000), "仮割当Ｄ累計額");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20170616), "計算基準日");



    }

    @Test
    @TestOrder(70)
    public void testExec_B7() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2017);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("0102");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "整合性エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "確定期間中に内定レコードを処理対象にしています", "エラー情報２（小分類）");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20150512), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20180607), "判定日");
        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.ARI, "決算使用有無");

    }

    @Test
    @TestOrder(80)
    public void testExec_B8() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2017);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("0102");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN5;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1100), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181121"), "計算基準日至");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20150512), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20181101), "判定日");
        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.ARI, "決算使用有無");

    }

    @Test
    @TestOrder(90)
    public void testExec_B9() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2017);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180521");
        BizDate pYendthnkymd = BizDate.valueOf("20150512");
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN5;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1100), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181121"), "計算基準日至");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20150512), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20181101), "判定日");
        exDateEquals((BizDate)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20170513), "基準日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2017), "Dレート年度");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 2), C_UmuKbn.NONE, "決算使用有無");

    }

    @Test
    @TestOrder(100)
    public void testExec_B10() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2017);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20150512");
        BizDate pYendthnkymd = null;
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> HaitouErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(HaitouErrorInfoLst.get(1).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
    }

    @Test
    @TestOrder(110)
    public void testExec_B11() {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();
        BizDateY haitounendo = BizDateY.valueOf(2017);
        khHaitouKanri.setHaitounendo(haitounendo);
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);
        BizCurrency kariwariatedruigk = BizCurrency.valueOf(1000);
        khHaitouKanri.setKariwariatedruigk(kariwariatedruigk);
        BizDate pCalckijyunymd = BizDate.valueOf("20170616");
        BizDate pKykymd = BizDate.valueOf("20180721");
        BizDate pYendthnkymd = null;
        BizDate pSyoriYmd = BizDate.valueOf("20170513");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("0101");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");
        YuyuHozenConfig.getInstance().setKessanKijunbi("0511");

        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN4;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = keisanDGanrikin.exec(khHaitouKanri, pCalckijyunymd, pKykymd, pYendthnkymd, pSyoriYmd, pKessanSiyouUmu);
        List<HaitouErrorInfo> HaitouErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20180721), "基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1),null, "判定日");
        exStringEquals(HaitouErrorInfoLst.get(1).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");


    }
}
