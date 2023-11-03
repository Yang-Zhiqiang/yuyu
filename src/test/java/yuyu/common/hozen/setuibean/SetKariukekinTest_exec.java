package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受金情報設定クラスのメソッド {@link SetKariukekin#exec(KhozenCommonParam,SetKariukekinExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKariukekinTest_exec {

    @Inject
    private SetKariukekin setKariukekin;

    @Inject
    private SetKariukekinExecUiBeanParamImpl setKariukekinUiBeanParamImpl;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_仮受金情報設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKariukekinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
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

        setKariukekinUiBeanParamImpl.setSyono("60806000011");

        boolean result = setKariukekin.exec(khozenCommonParam, setKariukekinUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().size(), 0, "仮受金情報の件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        setKariukekinUiBeanParamImpl.setSyono("60806000022");

        boolean result = setKariukekin.exec(khozenCommonParam, setKariukekinUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().size(), 1, "仮受金情報の件数");

        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkno(), 1, "仮受番号");
        exDateEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkkeijyoymd(),  BizDate.valueOf(20181001), "仮受計上処理日");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukhrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkuknykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkuknyknaiyoukbn(), C_NyknaiyouKbn.HARAIHENYOUP, "入金内容区分");
        exDateYMEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukjyuutouym(), BizDateYM.valueOf(201812), "充当年月");
        exStringEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukjyutoukaisuu(), "１２年　", "充当回数");
        exDateEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukryosyuymd(), BizDate.valueOf(20181012), "領収日");
        exBizCalcbleEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkgk(), BizCurrency.valueOf(100000000), "仮受金額");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        setKariukekinUiBeanParamImpl.setSyono("60806000033");

        boolean result = setKariukekin.exec(khozenCommonParam, setKariukekinUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().size(), 2, "仮受金情報の件数");

        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkno(), 2, "仮受番号");
        exDateEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkkeijyoymd(), BizDate.valueOf(20181002), "仮受計上処理日");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkriyuukbn(), C_KrkriyuuKbn.YUYOKKNGONYKN, "仮受理由区分");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukhrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkuknykkeiro(), C_Nykkeiro.CONVENI, "入金経路");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkuknyknaiyoukbn(), C_NyknaiyouKbn.HOZENHENKOUYOUP, "入金内容区分");
        exDateYMEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukjyuutouym(), BizDateYM.valueOf(201811), "充当年月");
        exStringEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukjyutoukaisuu(), "", "充当回数");
        exDateEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukryosyuymd(), BizDate.valueOf(20181013), "領収日");
        exBizCalcbleEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(0).getVkukkrkgk(), BizCurrency.valueOf(200000000), "仮受金額");

        exNumericEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukkrkno(), 1, "仮受番号");
        exDateEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukkrkkeijyoymd(), BizDate.valueOf(20181001), "仮受計上処理日");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukkrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukhrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkuknykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exClassificationEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkuknyknaiyoukbn(), C_NyknaiyouKbn.HARAIHENYOUP, "入金内容区分");
        exDateYMEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukjyuutouym(), BizDateYM.valueOf(201812), "充当年月");
        exStringEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukjyutoukaisuu(), "１２か月", "充当回数");
        exDateEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukryosyuymd(), BizDate.valueOf(20181012), "領収日");
        exBizCalcbleEquals(setKariukekinUiBeanParamImpl.getKariukekinInfo().get(1).getVkukkrkgk(), BizCurrency.valueOf(100000000), "仮受金額");

    }

}
