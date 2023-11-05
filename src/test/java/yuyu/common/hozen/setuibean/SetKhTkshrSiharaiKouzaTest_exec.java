package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 定期支払金支払先口座情報設定のメソッド{@link SetKhTkshrSiharaiKouza#exec(KhozenCommonParam, SetKhTkshrSiharaiKouzaExecUiBeanParam)}
                                     テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKhTkshrSiharaiKouzaTest_exec {
    private final static String dSyono1 = "99806001010";
    private final static String dSyono2 = "99806001021";

    private KhozenCommonParam khozenCommonParam;
    private SetKhTkshrSiharaiKouzaExecUiBeanParamImpl setKhTkshrSiharaiKouzaExecUiBeanParamImpl;
    private SetKhTkshrSiharaiKouza setKhTkshrSiharaiKouza;
    private final static String fileName = "UT-SP_単体テスト仕様書_定期支払金支払先口座情報設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetTrkKazokuTest_exec.class, fileName, sheetName);
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
        setKhTkshrSiharaiKouzaExecUiBeanParamImpl = SWAKInjector.getInstance(SetKhTkshrSiharaiKouzaExecUiBeanParamImpl.class);
        setKhTkshrSiharaiKouza = SWAKInjector.getInstance(SetKhTkshrSiharaiKouza.class);
        setKhTkshrSiharaiKouzaExecUiBeanParamImpl.setSyono(dSyono1);

        boolean syorikeka = setKhTkshrSiharaiKouza.exec(khozenCommonParam,setKhTkshrSiharaiKouzaExecUiBeanParamImpl);

        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "（定期支払金支払先口座情報）口座種類区分");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzbankcd(), "", "（定期支払金支払先口座情報）銀行コード");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzbanknmkj(), "", "（定期支払金支払先口座情報）銀行名（漢字）");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzsitencd(), "", "（定期支払金支払先口座情報）支店コード");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzsitennmkj(), "", "（定期支払金支払先口座情報）支店名（漢字）");
        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzyokinkbn(), C_YokinKbn.BLNK, "（定期支払金支払先口座情報）預金種目区分");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkouzano(), "", "（定期支払金支払先口座情報）口座番号");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkzmeiginmkn(), "", "（定期支払金支払先口座情報）口座名義人氏名（カナ）");
        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getTeikishrtkykhukaumu(), C_UmuKbn.NONE, "定期支払特約付加有無");

        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKhTkshrSiharaiKouzaExecUiBeanParamImpl = SWAKInjector.getInstance(SetKhTkshrSiharaiKouzaExecUiBeanParamImpl.class);
        setKhTkshrSiharaiKouza = SWAKInjector.getInstance(SetKhTkshrSiharaiKouza.class);

        setKhTkshrSiharaiKouzaExecUiBeanParamImpl.setSyono(dSyono2);

        boolean syorikeka = setKhTkshrSiharaiKouza.exec(khozenCommonParam,setKhTkshrSiharaiKouzaExecUiBeanParamImpl);

        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "（定期支払金支払先口座情報）口座種類区分");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzbankcd(), "0010", "（定期支払金支払先口座情報）銀行コード");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzbanknmkj(), "りそな銀行", "（定期支払金支払先口座情報）銀行名（漢字）");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzsitencd(), "005", "（定期支払金支払先口座情報）支店コード");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzsitennmkj(), "天理支店", "（定期支払金支払先口座情報）支店名（漢字）");
        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzyokinkbn(), C_YokinKbn.HUTUU, "（定期支払金支払先口座情報）預金種目区分");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkouzano(), "1234567", "（定期支払金支払先口座情報）口座番号");
        exStringEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getVktikskzkzmeiginmkn(), "フクモト　イチロウ", "（定期支払金支払先口座情報）口座名義人氏名（カナ）");
        exClassificationEquals(setKhTkshrSiharaiKouzaExecUiBeanParamImpl.getTeikishrtkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
        exBooleanEquals(syorikeka, true, "処理結果");
    }
}
