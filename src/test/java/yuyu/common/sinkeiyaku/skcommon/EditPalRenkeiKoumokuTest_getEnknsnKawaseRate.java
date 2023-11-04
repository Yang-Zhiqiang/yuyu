package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#getEnknsnKawaseRate(C_Tuukasyu, BizDate, C_Hrkkaisuu, C_UmuKbn, C_IkkatubaraiKbn)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getEnknsnKawaseRate {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ連携項目編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_getKzktrkServiceKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ010", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void testGetEnknsnKawaseRate_A1() {
        BizNumber enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
            C_Tuukasyu.JPY, BizDate.valueOf(20160303), C_Hrkkaisuu.ITIJI, C_UmuKbn.NONE, C_IkkatubaraiKbn.IKKATU);

        exBizCalcbleEquals(enknsnKawaseRate, BizNumber.ZERO, "円換算為替レート");
    }

    @Test
    @TestOrder(20)
    public void testGetEnknsnKawaseRate_A2() {

        BizNumber enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
            C_Tuukasyu.USD, BizDate.valueOf(20160303), C_Hrkkaisuu.ITIJI, C_UmuKbn.NONE, C_IkkatubaraiKbn.IKKATU);

        exBizCalcbleEquals(enknsnKawaseRate, BizNumber.valueOf(99), "円換算為替レート");
    }

    @Test
    @TestOrder(30)
    public void testGetEnknsnKawaseRate_A3() {
        try {
            BizNumber enknsnKawaseRate = editPalRenkeiKoumoku.getEnknsnKawaseRate(
                C_Tuukasyu.USD, BizDate.valueOf(20160303), C_Hrkkaisuu.BLNK, C_UmuKbn.NONE, C_IkkatubaraiKbn.IKKATU);

            fail("【円換算為替レート】[エラーを出力しない] 検証値：" + enknsnKawaseRate + " 期待値：" + new CommonBizAppException());
        } catch (CommonBizAppException cbaException) {
            exStringEquals(cbaException.getMessage(), "システム整合性エラーです。評価額算出用為替レート取得に失敗しました。領収日：20160303　元通貨：米ドル　換算通貨：円　前営業日為替レート取得要否：要　払込回数：　前納申出有無：なし　一括払区分：一括払", "円換算為替レート");
        }
    }

}
