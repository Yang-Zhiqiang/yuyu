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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 基本情報設定のメソッド{@link SetKihon#exec(KhozenCommonParam, SetKihonExecUiBeanParam)}
 *                         テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKihonTest_exec {
    private final static String dSyono1 = "12806345672";
    private final static String dSyono2 = "12806345683";
    private final static String dSyono3 = "12806345694";

    private KhozenCommonParam khozenCommonParam;

    private SetKihonExecUiBeanParamImpl setKihonExecUiBeanParamImpl;

    private final static String fileName = "UT_SP_単体テスト仕様書_基本情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKihonTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKihonExecUiBeanParamImpl = SWAKInjector.getInstance(SetKihonExecUiBeanParamImpl.class);
        setKihonExecUiBeanParamImpl.setSyono(dSyono1);
        boolean syorikeka = SetKihon.exec(khozenCommonParam, setKihonExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, false, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKihonExecUiBeanParamImpl = SWAKInjector.getInstance(SetKihonExecUiBeanParamImpl.class);

        setKihonExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = SetKihon.exec(khozenCommonParam, setKihonExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, true, "処理結果");
        exStringEquals(setKihonExecUiBeanParamImpl.getVkihnsyono(), "12806345683", "証券番号");
        exDateEquals(setKihonExecUiBeanParamImpl.getVkihnlastsyosaihkymd(), BizDate.valueOf(20151220), "最終証券再発行日");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnyuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnkykjyoutai(), C_Kykjyoutai.PMEN, "契約状態");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnsyoumetujiyuu(), C_Syoumetujiyuu.SBMUKOU, "消滅事由");
        exDateEquals(setKihonExecUiBeanParamImpl.getVkihnsyoumetuymd(),BizDate.valueOf(20151220), "消滅日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setKihonExecUiBeanParamImpl = SWAKInjector.getInstance(SetKihonExecUiBeanParamImpl.class);
        setKihonExecUiBeanParamImpl.setSyono(dSyono3);
        boolean syorikeka = SetKihon.exec(khozenCommonParam, setKihonExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, false, "処理結果");
    }
}
