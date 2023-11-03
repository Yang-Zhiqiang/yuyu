package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医事統計用Ｓ項目編集のメソッド
 * {@link EditIjitoukeiS#sinkeiyakuEdit(HT_MosKihon, List<HT_MosSyouhn>)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditIjitoukeiSTest_idougoEdit {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_医事統計用Ｓ項目編集";

    private final static String sheetName = "INデータ";

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
    public void testIdougoEdit_A1() {


        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBean = null;

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBean, BizDate.valueOf("20190501"));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testIdougoEdit_A2() {


        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBean = new ArrayList<TkJitenKeiyakuSyouhinKijyunBean>();

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBean, BizDate.valueOf("20190501"));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(25)
    public void testIdougoEdit_A3() {

        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBeanList = new ArrayList<TkJitenKeiyakuSyouhinKijyunBean>();
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("ﾕｱ");
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhnsdno(1);
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.USD);
        tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(C_SyutkKbn.SYU);
        tkJitenKeiyakuSyouhinKijyunBean.setKihons(BizCurrency.valueOf(2,BizCurrencyTypes.DOLLAR));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean.setPharaikomisougaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBeanList.add(tkJitenKeiyakuSyouhinKijyunBean);

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBeanList, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testIdougoEdit_B1() {


        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBeanList = new ArrayList<TkJitenKeiyakuSyouhinKijyunBean>();
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("ﾕｱ");
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhnsdno(1);
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.USD);
        tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(C_SyutkKbn.SYU);
        tkJitenKeiyakuSyouhinKijyunBean.setKihons(BizCurrency.valueOf(200,BizCurrencyTypes.DOLLAR));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean.setPharaikomisougaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBeanList.add(tkJitenKeiyakuSyouhinKijyunBean);

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBeanList, BizDate.valueOf("20190501"));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(2,BizCurrencyTypes.MANYEN), "死亡Ｓ");
    }

    @Test
    @TestOrder(40)
    public void testIdougoEdit_B2() {


        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBeanList = new ArrayList<TkJitenKeiyakuSyouhinKijyunBean>();
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("ﾕｱ");
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhnsdno(1);
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.USD);
        tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(C_SyutkKbn.SYU);
        tkJitenKeiyakuSyouhinKijyunBean.setKihons(BizCurrency.valueOf(300,BizCurrencyTypes.DOLLAR));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean.setPharaikomisougaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean2 = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean2.setSyouhncd("T1");
        tkJitenKeiyakuSyouhinKijyunBean2.setSyouhnsdno(1);
        tkJitenKeiyakuSyouhinKijyunBean2.setKyktuukasyu(C_Tuukasyu.USD);
        tkJitenKeiyakuSyouhinKijyunBean2.setSyutkKbn(C_SyutkKbn.TK);
        tkJitenKeiyakuSyouhinKijyunBean2.setKihons(BizCurrency.valueOf(400,BizCurrencyTypes.DOLLAR));
        tkJitenKeiyakuSyouhinKijyunBean2.setHokenryou(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean2.setPharaikomisougaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));

        tkJitenKeiyakuSyouhinKijyunBeanList.add(tkJitenKeiyakuSyouhinKijyunBean);
        tkJitenKeiyakuSyouhinKijyunBeanList.add(tkJitenKeiyakuSyouhinKijyunBean2);

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBeanList, BizDate.valueOf("20190501"));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(7,BizCurrencyTypes.MANYEN), "死亡Ｓ");
    }

    @Test
    @TestOrder(50)
    public void testIdougoEdit_B3() {


        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBeanList = new ArrayList<TkJitenKeiyakuSyouhinKijyunBean>();
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("ﾕｹ");
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhnsdno(1);
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.USD);
        tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(C_SyutkKbn.SYU);
        tkJitenKeiyakuSyouhinKijyunBean.setKihons(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(450,BizCurrencyTypes.DOLLAR));
        tkJitenKeiyakuSyouhinKijyunBean.setPharaikomisougaku(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBeanList.add(tkJitenKeiyakuSyouhinKijyunBean);

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBeanList, BizDate.valueOf("20190501"));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(5,BizCurrencyTypes.MANYEN), "死亡Ｓ");
    }

    @Test
    @TestOrder(60)
    public void testIdougoEdit_B4() {


        List<TkJitenKeiyakuSyouhinKijyunBean> tkJitenKeiyakuSyouhinKijyunBeanList = new ArrayList<TkJitenKeiyakuSyouhinKijyunBean>();
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = new TkJitenKeiyakuSyouhinKijyunBean();
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhncd("ﾕﾁ");
        tkJitenKeiyakuSyouhinKijyunBean.setSyouhnsdno(1);
        tkJitenKeiyakuSyouhinKijyunBean.setKyktuukasyu(C_Tuukasyu.USD);
        tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(C_SyutkKbn.SYU);
        tkJitenKeiyakuSyouhinKijyunBean.setKihons(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean.setHokenryou(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBean.setPharaikomisougaku(BizCurrency.valueOf(14000,BizCurrencyTypes.YEN));
        tkJitenKeiyakuSyouhinKijyunBeanList.add(tkJitenKeiyakuSyouhinKijyunBean);

        C_ErrorKbn errorKbn = editIjitoukeiS.idougoEdit(tkJitenKeiyakuSyouhinKijyunBeanList, BizDate.valueOf("20190501"));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(editIjitoukeiS.getSibouS(), BizCurrency.valueOf(1,BizCurrencyTypes.MANYEN), "死亡Ｓ");
    }
}

