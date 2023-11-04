package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医事統計用Ｓ項目編集のメソッド
 * {@link EditIjitoukeiS#sinkeiyakuEdit(HT_MosKihon, List<HT_MosSyouhn>)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditIjitoukeiSTest_sinkeiyakuEdit {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_医事統計用Ｓ項目編集";

    private final static String sheetName = "INデータ";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;


    @Inject
    private EditIjitoukeiS editIjitoukeiS;

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditNenkinKoumokuUtilTest_getSkNkgnsKijyunGk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testSinkeiyakuEdit_A1() {
        HT_MosKihon mosKihon= null;
        List<HT_MosSyouhn> mosSyouhn= null;
        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testSinkeiyakuEdit_A2() {
        HT_MosKihon mosKihon= null;
        List<HT_MosSyouhn> mosSyouhn = new ArrayList<>();

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testSinkeiyakuEdit_A3() {
        HT_MosKihon mosKihon= new HT_MosKihon();
        List<HT_MosSyouhn> mosSyouhn = null;

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testSinkeiyakuEdit_B1() {


        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000017");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosSyouhn> mosSyouhn = syoriCTL.getMosSyouhns();

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "死亡Ｓ");
    }

    @Test
    @TestOrder(50)
    public void testSinkeiyakuEdit_B2() {


        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000025");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosSyouhn> mosSyouhn = syoriCTL.getMosSyouhns();

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR), "死亡Ｓ");
    }

    @Test
    @TestOrder(60)
    public void testSinkeiyakuEdit_B3() {


        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000033");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosSyouhn> mosSyouhn = syoriCTL.getMosSyouhns();

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(7, BizCurrencyTypes.DOLLAR), "死亡Ｓ");
    }

    @Test
    @TestOrder(70)
    public void testSinkeiyakuEdit_B4() {


        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000041");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosSyouhn> mosSyouhn = syoriCTL.getMosSyouhns();

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(5, BizCurrencyTypes.DOLLAR), "死亡Ｓ");
    }

    @Test
    @TestOrder(80)
    public void testSinkeiyakuEdit_B5() {


        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000058");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<HT_MosSyouhn> mosSyouhn = syoriCTL.getMosSyouhns();

        C_ErrorKbn errorKbn = editIjitoukeiS.sinkeiyakuEdit(mosKihon, mosSyouhn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "死亡Ｓ");
    }
}

