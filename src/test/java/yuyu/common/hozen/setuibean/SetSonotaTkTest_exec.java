package yuyu.common.hozen.setuibean;

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
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * その他特約特則設定クラスのメソッド {@link SetSonotaTk#exec(KhozenCommonParam,SetSonotaTkExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSonotaTkTest_exec {

    @Inject
    private SetSonotaTkExecUiBeanParamImpl setSonotaTkExecUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_その他特約特則設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSonotaTkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345672");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345672", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345683");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345683", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>指定通貨建年金保険定期支払特約　（支払通貨： 米ドル　　定期支払金額： 1,263,580,235,541 円）<br/>目標到達時円建終身保険変更特約　（基準金額： 1,000,000,000,000 円　　目標額割合： 指定なし）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345694");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345694", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>指定通貨建年金保険定期支払特約　（支払通貨： 米ドル　　定期支払金額： 2,287,080,235,541 円）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345708");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345708", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>指定通貨建年金保険定期支払特約　（支払通貨： 米ドル　　定期支払金額： 33,105,802,355.41 米ドル）<br/>目標到達時円建終身保険変更特約　（基準金額： " + "1,000,000,000,000 円　　目標額割合： 指定なし）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }


    @Test
    @TestOrder(50)
    public void testExec_A5() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345719");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345719", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料円貨払込特約（一時払い）<br/>指定通貨建年金保険定期支払特約　（支払通貨： 米ドル　　定期支払金額： 33,105,802,355.41 米ドル）<br/>目標到達時円建終身保険変更特約　（基準金額： 1,000,000,000,000 円　　目標額割合： 指定なし）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345720");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345720", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料指定外通貨払込特約<br/>指定通貨建年金保険定期支払特約　（支払通貨： 米ドル　　定期支払金額： 33,105,802,355.41 米ドル）<br/>目標到達時円建年金保険変更特約　（円建基準金額： 1,000,000,000,000 円　　目標額割合： 指定なし）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345731");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345731", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>目標到達時円建終身保険変更特約　（基準金額： 1,000,000,000,000 円　　目標額割合： 100 ％）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }


    @Test
    @TestOrder(80)
    public void testExec_A8() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345742");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345742", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345753");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345753", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>指定通貨建年金保険定期支払特約　（支払通貨： 円　　定期支払金額： 33,105,802,355.41 米ドル）<br/>目標到達時円建終身保険変更特約　（基準金額： 1,000,000,000,000 円　　目標額割合： 指定なし）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        setSonotaTkExecUiBeanParamImpl.setSyono("12806345764");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "12806345764", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険契約者代理特約<br/>被保険者代理特約<br/>保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>指定通貨建年金保険定期支払特約　（支払通貨： 円　　定期支払金額： 33,105,802,355.41 米ドル）<br/>目標到達時円建終身保険変更特約　（基準金額： 1,000,000,000,000 円　　目標額割合： 指定なし）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        setSonotaTkExecUiBeanParamImpl.setSyono("18808000973");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "18808000973", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>目標到達時円建年金保険変更特約　（円建基準金額： 1,000,000,000,000 円　　目標額割合： 100 ％）<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        setSonotaTkExecUiBeanParamImpl.setSyono("18808000010");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "18808000010", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        setSonotaTkExecUiBeanParamImpl.setSyono("18808000021");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "18808000021", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険料円貨払込特約（一時払い）<br/>保険料指定外通貨払込特約<br/>初期死亡時円換算支払額最低保証特約　（基準金額： 1,234,567,890 円）<br/>重度介護前払特約", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        setSonotaTkExecUiBeanParamImpl.setSyono("60806000011");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "60806000011", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険料円貨払込特約（円貨払込額指定型）<br/>個人年金保険料税制適格特約（\\'90）", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        setSonotaTkExecUiBeanParamImpl.setSyono("60806000022");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "60806000022", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "保険料円貨払込特約（円貨払込額指定型）", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        setSonotaTkExecUiBeanParamImpl.setSyono("60806000033");


        boolean result = SetSonotaTk.exec(khozenCommonParam, setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getSyono(), "60806000033", "証券番号");
        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "個人年金保険料税制適格特約（\\'90）", "（表示用）特約付加情報");
        exBooleanEquals(result, true, "処理結果");
    }
}
