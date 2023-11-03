package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医事統計用Ｓ項目編集のメソッド
 * {@link EditIjitoukeiS#torikomiEdit(ZT_IjiToukeiIdouInfoTr, HT_IjitoukeiMeisai)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditIjitoukeiSTest_torikomiEdit {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_医事統計用Ｓ項目編集";

    private final static String sheetName = "INデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;


    @Inject
    private ZdbDomManager zdbDomManager;


    @Inject
    private EditIjitoukeiS editIjitoukeiS;

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditNenkinKoumokuUtilTest_getSkNkgnsKijyunGk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllIjitoukeiMeisai());
        zdbDomManager.delete(zdbDomManager.getAllIjiToukeiIdouInfoTr());
    }

    @Test
    @TestOrder(10)
    public void testTorikomiEdit_A1() {
        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = null;
        HT_IjitoukeiMeisai ijitoukeiMeisai = null;
        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testTorikomiEdit_A2() {
        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = null;
        HT_IjitoukeiMeisai ijitoukeiMeisai = new HT_IjitoukeiMeisai();
        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testTorikomiEdit_A3() {
        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = new ZT_IjiToukeiIdouInfoTr();
        HT_IjitoukeiMeisai ijitoukeiMeisai = null;
        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testTorikomiEdit_B1() {


        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806024206", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806024206", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getImustiyuS(), BizCurrency.valueOf(99999990000l, BizCurrencyTypes.YEN), "医務査定用死亡Ｓ");

    }

    @Test
    @TestOrder(50)
    public void testTorikomiEdit_B2() {


        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806002378", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806002378", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
   }

    @Test
    @TestOrder(60)
    public void testTorikomiEdit_B3() {

        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806010232", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806010232", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testTorikomiEdit_B4() {


        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806011071", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806011071", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getImustiyuS(), BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.DOLLAR), "医務査定用死亡Ｓ");
    }

    @Test
    @TestOrder(80)
    public void testTorikomiEdit_B5() {


        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806011462", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806011462", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getImustiyuS(), BizCurrency.valueOf(99999990000.00, BizCurrencyTypes.DOLLAR), "医務査定用死亡Ｓ");
    }
    @Test
    @TestOrder(90)
    public void testTorikomiEdit_B6() {


        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806022503", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806022503", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getImustiyuS(), BizCurrency.valueOf(1694.92, BizCurrencyTypes.DOLLAR), "医務査定用死亡Ｓ");
    }
    @Test
    @TestOrder(100)
    public void testTorikomiEdit_B7() {


        ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr = zdbDomManager.getIjiToukeiIdouInfoTr("60806022743", 1);
        HT_IjitoukeiMeisai ijitoukeiMeisai = sinkeiyakuDomManager.getIjitoukeiMeisai("60806022743", 1);

        C_ErrorKbn errorKbn = editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, ijitoukeiMeisai);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getImustiyuS(), BizCurrency.valueOf(2439.02, BizCurrencyTypes.DOLLAR), "医務査定用死亡Ｓ");
    }
}

