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
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 配当共通計算のメソッド {@link KeisanDCommon#calcD(String, BizDate, BizDate, BizDate, C_UmuKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonTest_calcD {

    @Inject
    private KeisanDCommon keisanDCommon;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当共通計算";

    private final static String sheetName = "INデータ";

    private static final String SYONO = "18806000014";

    private static final BizDate DRATEKJYMD = BizDate.valueOf(20171222);

    private static final BizDate CALCKIJYUNYMD = BizDate.valueOf(20170301);

    private static final BizDate SYORIYMD = BizDate.valueOf(20170420);

    private static final C_UmuKbn KESSANUMU = C_UmuKbn.ARI;

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SetDNnd.class).to(SetDNndMockForHozen.class);
                bind(KeisanD.class).to(KeisanDMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker
                .getInData(CheckDSeigouTest_checkHaitoukanriTBL.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @BeforeClass
    public static void testInit() {

        SetDNndMockForHozen.caller = KeisanDCommonTest_calcD.class;
        KeisanDMockForHozen.caller = KeisanDCommonTest_calcD.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.caller = null;
        SetDNndMockForHozen.SYORIPTN = null;
        KeisanDMockForHozen.caller = null;
        KeisanDMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testCalcD_A1() {

        C_ErrorKbn errorKbn = keisanDCommon.calcD(null, DRATEKJYMD, CALCKIJYUNYMD, SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testCalcD_A2() {

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, null, CALCKIJYUNYMD, SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testCalcD_A3() {

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, DRATEKJYMD, null, SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testCalcD_A4() {

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, DRATEKJYMD, CALCKIJYUNYMD, null, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(50)
    public void testCalcD_A5() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, DRATEKJYMD, CALCKIJYUNYMD, SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommon.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class).getClass()
            .getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");

        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 0);
        exStringEquals(kykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(kykKihon.getSyono(), SYONO, "証券番号");
        IT_KykSyouhn kykSyouhn = (IT_KykSyouhn) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 1);
        exStringEquals(kykSyouhn.getKbnkey(), "01", "区分キー");
        exStringEquals(kykSyouhn.getSyono(), SYONO, "証券番号");
        exClassificationEquals(kykSyouhn.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhn.getSyouhncd(), "M210", "商品コード");
        exNumericEquals(kykSyouhn.getSyouhnsdno(), 55, "商品世代番号");
        exNumericEquals(kykSyouhn.getKyksyouhnrenno(), 19, "契約商品連番");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 2), DRATEKJYMD, "Ｄレート基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 3), CALCKIJYUNYMD, "計算基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 4), SYORIYMD, "処理年月日");
        exClassificationEquals((C_UmuKbn) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 5), KESSANUMU,
            "決算使用有無");
    }

    @Test
    @TestOrder(60)
    public void testCalcD_A6() {

        MockObjectManager.initialize();
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, DRATEKJYMD, CALCKIJYUNYMD, SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommon.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(KeisanD.class).getClass()
            .getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");

        KeisanDBean keisanDBean = (KeisanDBean) MockObjectManager.getArgument(KeisanDMockForHozen.class, "exec", 0, 0);
        exStringEquals(keisanDBean.getDRateSyutokuInfoBean().getSyouhncd(), "M111", "商品コード");
        exClassificationEquals(keisanDBean.getTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(keisanDBean.getKihonS(), BizCurrency.valueOf(12000000), "基本Ｓ");
        exClassificationEquals(keisanDBean.getKsnSiyouUmu(), KESSANUMU, "決算使用有無");
        exDateEquals(keisanDBean.getHaitouKaisuuBeanList().get(0).getKikanfrom(), BizDate.valueOf(20020203), "期間（自）");
    }

    @Test
    @TestOrder(70)
    public void testCalcD_A7() {

        MockObjectManager.initialize();
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, DRATEKJYMD, CALCKIJYUNYMD, SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(80)
    public void testCalcD_A8() {

        MockObjectManager.initialize();

        C_ErrorKbn errorKbn = keisanDCommon.calcD(SYONO, DRATEKJYMD, BizDate.valueOf(20000102), SYORIYMD, KESSANUMU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        BizCurrency haitouD = keisanDCommon.getD();
        exBizCalcbleEquals(haitouD, BizCurrency.valueOf(0), "配当金");

        keisanDCommon.detachKykKihon();
    }
}
