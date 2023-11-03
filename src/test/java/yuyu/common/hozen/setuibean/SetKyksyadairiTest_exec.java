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
 * 契約者代理人情報設定のメソッド{@link SetKyksyadairi#exec(KhozenCommonParam, SetKyksyadairiExecUiBeanParam)}
                                     テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKyksyadairiTest_exec {

    private final static String dSyono1 = "12806345683";
    private final static String dSyono2 = "12806345672";

    private KhozenCommonParam khozenCommonParam;
    private SetKyksyadairiExecUiBeanParamImpl setKyksyadairiExecUiBeanParamImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書_契約者代理人情報設定";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKyksyadairiTest_exec.class, fileName, sheetName);
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

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKyksyadairiExecUiBeanParamImpl = SWAKInjector.getInstance(SetKyksyadairiExecUiBeanParamImpl.class);
        setKyksyadairiExecUiBeanParamImpl.setSyono(dSyono1);
        boolean syorikeka = SetKyksyadairi.exec(khozenCommonParam, setKyksyadairiExecUiBeanParamImpl);

        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrkbn(), C_UktKbn.STDRNIN,
            "（契約者代理人情報）契約者代理人区分");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkn(), "アイウエオ",
            "（契約者代理人情報）契約者代理人名（カナ）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkj(), "あいうえお",
            "（契約者代理人情報）契約者代理人名（漢字）");
        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkjkhukakbn(), C_KjkhukaKbn.KJKHUKA,
            "（契約者代理人情報）契約者代理人名漢字化不可区分");
        exDateEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrseiymd(), BizDate.valueOf("20191016"),
            "（契約者代理人情報）契約者代理人生年月日");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdryno(), "1003124",
            "（契約者代理人情報）契約者代理人郵便番号");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr1kj(), "とうきょう",
            "（契約者代理人情報）契約者代理人住所１（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr2kj(), "おおさか",
            "（契約者代理人情報）契約者代理人住所２（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr3kj(), "なごや",
            "（契約者代理人情報）契約者代理人住所３（漢字）");
        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKyksyadairiExecUiBeanParamImpl = SWAKInjector.getInstance(SetKyksyadairiExecUiBeanParamImpl.class);
        setKyksyadairiExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = SetKyksyadairi.exec(khozenCommonParam, setKyksyadairiExecUiBeanParamImpl);

        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrkbn(), C_UktKbn.BLNK,
            "（契約者代理人情報）契約者代理人区分");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkn(), "",
            "（契約者代理人情報）契約者代理人名（カナ）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkj(), "",
            "（契約者代理人情報）契約者代理人名（漢字）");
        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkjkhukakbn(), C_KjkhukaKbn.BLNK,
            "（契約者代理人情報）契約者代理人名漢字化不可区分");
        exDateEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrseiymd(), null,
            "（契約者代理人情報）契約者代理人生年月日");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdryno(), "",
            "（契約者代理人情報）契約者代理人郵便番号");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr1kj(), "",
            "（契約者代理人情報）契約者代理人住所１（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr2kj(), "",
            "（契約者代理人情報）契約者代理人住所２（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr3kj(), "",
            "（契約者代理人情報）契約者代理人住所３（漢字）");
        exBooleanEquals(syorikeka, true, "処理結果");
    }
}
