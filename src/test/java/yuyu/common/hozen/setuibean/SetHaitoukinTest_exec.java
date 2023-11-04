package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当金情報設定クラスのメソッド {@link SetHaitoukin#exec(KhozenCommonParam,SetHaitoukinExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHaitoukinTest_exec {

    @Inject
    private SetHaitoukinExecUiBeanParamImpl setHaitoukinExecUiBeanParamImpl;

    @Inject
    private SetHaitoukin setHaitoukin;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当金情報設定";

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
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        setHaitoukin.init(setHaitoukinExecUiBeanParamImpl);
        setHaitoukinExecUiBeanParamImpl.setSyono("60806000011");

        boolean result = setHaitoukin.exec(khozenCommonParam, setHaitoukinExecUiBeanParamImpl);


        exStringEquals(setHaitoukinExecUiBeanParamImpl.getSyono(), "60806000011", "証券番号");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "（配当金情報）配当金受取方法区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitounendo(), null, "（配当金情報）配当年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttounendod(), BizCurrency.optional(), "（配当金情報）当年度Ｄ");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatenendo(), null, "（配当金情報）積立年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitated(), BizCurrency.optional(), "（配当金情報）積立Ｄ");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedtumitateymd(), null, "（配当金情報）積立Ｄ積立年月日");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedshrkrkymd(), null, "（配当金情報）積立Ｄ支払効力日");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        setHaitoukin.init(setHaitoukinExecUiBeanParamImpl);
        setHaitoukinExecUiBeanParamImpl.setSyono("60806000022");

        boolean result = setHaitoukin.exec(khozenCommonParam, setHaitoukinExecUiBeanParamImpl);


        exStringEquals(setHaitoukinExecUiBeanParamImpl.getSyono(), "60806000022", "証券番号");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "（配当金情報）配当金受取方法区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitounendo(), BizDateY.valueOf(2018), "（配当金情報）配当年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttounendod(), BizCurrency.valueOf(100000000), "（配当金情報）当年度Ｄ");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatenendo(), null, "（配当金情報）積立年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitated(), BizCurrency.optional(), "（配当金情報）積立Ｄ");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedtumitateymd(), null, "（配当金情報）積立Ｄ積立年月日");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedshrkrkymd(), null, "（配当金情報）積立Ｄ支払効力日");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        setHaitoukin.init(setHaitoukinExecUiBeanParamImpl);
        setHaitoukinExecUiBeanParamImpl.setSyono("60806000033");


        boolean result = setHaitoukin.exec(khozenCommonParam, setHaitoukinExecUiBeanParamImpl);


        exStringEquals(setHaitoukinExecUiBeanParamImpl.getSyono(), "60806000033", "証券番号");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "（配当金情報）配当金受取方法区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitounendo(), null, "（配当金情報）配当年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttounendod(), BizCurrency.optional(), "（配当金情報）当年度Ｄ");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatenendo(), null, "（配当金情報）積立年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitated(), BizCurrency.valueOf(200000000), "（配当金情報）積立Ｄ");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedtumitateymd(), BizDate.valueOf(20181019), "（配当金情報）積立Ｄ積立年月日");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedshrkrkymd(), BizDate.valueOf(20181022), "（配当金情報）積立Ｄ支払効力日");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        setHaitoukin.init(setHaitoukinExecUiBeanParamImpl);
        setHaitoukinExecUiBeanParamImpl.setSyono("60806000044");

        boolean result = setHaitoukin.exec(khozenCommonParam, setHaitoukinExecUiBeanParamImpl);


        exStringEquals(setHaitoukinExecUiBeanParamImpl.getSyono(), "60806000044", "証券番号");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "（配当金情報）配当金受取方法区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitounendo(), BizDateY.valueOf(2018), "（配当金情報）配当年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttounendod(), BizCurrency.valueOf(300000000), "（配当金情報）当年度Ｄ");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "（配当金情報）内定確定区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatenendo(),  BizDateY.valueOf(2018), "（配当金情報）積立年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitated(), BizCurrency.valueOf(400000000), "（配当金情報）積立Ｄ");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedtumitateymd(), BizDate.valueOf(20181014), "（配当金情報）積立Ｄ積立年月日");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedshrkrkymd(), BizDate.valueOf(20181023), "（配当金情報）積立Ｄ支払効力日");
        exBooleanEquals(result, true, "処理結果");
    }

}
