package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 被保険者代理人情報設定のメソッド{@link SetSiteiseikyuu#exec(KhozenCommonParam, SetSiteiseikyuuExecUiBeanParam)}
                                     テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSiteiseikyuuTest_exec {
    private final static String dSyono1 = "12806345672";
    private final static String dSyono2 = "12806345683";

    private KhozenCommonParam khozenCommonParam;
    private SetSiteiseikyuuExecUiBeanParamImpl setSiteiseikyuuExecUiBeanParamImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書_被保険者代理人情報設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSiteiseikyuuTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono2));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSiteiseikyuuExecUiBeanParamImpl = SWAKInjector.getInstance(SetSiteiseikyuuExecUiBeanParamImpl.class);
        setSiteiseikyuuExecUiBeanParamImpl.setSyono(dSyono1);
        boolean syorikeka = SetSiteiseikyuu.exec(khozenCommonParam, setSiteiseikyuuExecUiBeanParamImpl);

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstsksiteidruktkbn(), C_UktKbn.BLNK,
            "（指定代理請求人情報）指定代理受取人区分");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkn(), "",
            "（指定代理請求人情報）指定代理請求人名（カナ）");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkj(), "",
            "(（指定代理請求人情報）指定代理請求人名（漢字）");

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkjhukakbn(), C_KjkhukaKbn.BLNK,
            "（指定代理請求人情報）指定代理請求人名漢字化不可区分");

        exDateEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrskseiymd(), null,
                "（指定代理請求人情報）指定代理請求人生年月日");

        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSiteiseikyuuExecUiBeanParamImpl = SWAKInjector.getInstance(SetSiteiseikyuuExecUiBeanParamImpl.class);
        setSiteiseikyuuExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = SetSiteiseikyuu.exec(khozenCommonParam, setSiteiseikyuuExecUiBeanParamImpl);

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstsksiteidruktkbn(), C_UktKbn.STDRNIN,
            "（指定代理請求人情報）指定代理受取人区分");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkn(), "アイウエオ",
            "（指定代理請求人情報）指定代理請求人名（カナ）");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkj(), "１２３４５",
            "(（指定代理請求人情報）指定代理請求人名（漢字）");

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkjhukakbn(), C_KjkhukaKbn.KJKHUKA,
            "（指定代理請求人情報）指定代理請求人名漢字化不可区分");

        exDateEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrskseiymd(), BizDate.valueOf("19751229"),
                "（指定代理請求人情報）指定代理請求人生年月日");

        exBooleanEquals(syorikeka, true, "処理結果");
    }
}
