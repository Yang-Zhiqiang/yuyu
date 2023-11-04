package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhou#seisanLastSiwakeMeisai()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_seisanLastSiwakeMeisai{

    @Inject
    private BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_振替伝票情報";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzFurikaeDenpyouJouhouTest_seisanLastSiwakeMeisai.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTantouCd());
    }

    @Test
    @TestOrder(10)
    public void testSeisanLastSiwakeMeisai_A1() {
        FurikaeDenpyouSiwakeMeisai bean = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean.setDenKanjoKamokuNm("name3");
        bean.setKinGk(BizCurrency.valueOf(30));
        bean.setTekiyouKm("project3");
        bean.setKjTekiyouKm("漢字摘要三");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("101");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(C_TaisyakuKbn.KASIKATA, BizCurrency.valueOf(70));

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        FurikaeDenpyouPage furikaeDenpyouPage = resultLst.get(0);

        BizCurrency kasigoukeigk = furikaeDenpyouPage.getKasiGoukeiGk();
        exBizCalcbleEquals(kasigoukeigk, BizCurrency.valueOf(100), "貸方合計金額");

        BizCurrency karigoukeigk = furikaeDenpyouPage.getKariGoukeiGk();
        exBizCalcbleEquals(karigoukeigk, BizCurrency.valueOf(0), "借方合計金額");
    }

    @Test
    @TestOrder(20)
    public void testSeisanLastSiwakeMeisai_A2() {
        FurikaeDenpyouSiwakeMeisai bean = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean.setDenKanjoKamokuNm("name4");
        bean.setKinGk(BizCurrency.valueOf(50));
        bean.setTekiyouKm("project4");
        bean.setKjTekiyouKm("漢字摘要四");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("101");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(false);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean, C_TaisyakuKbn.KARIKATA);

        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(C_TaisyakuKbn.KARIKATA, BizCurrency.valueOf(60));

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        FurikaeDenpyouPage furikaeDenpyouPage = resultLst.get(0);

        BizCurrency kasigoukeigk = furikaeDenpyouPage.getKasiGoukeiGk();
        exBizCalcbleEquals(kasigoukeigk, BizCurrency.valueOf(0), "貸方合計金額");

        BizCurrency karigoukeigk = furikaeDenpyouPage.getKariGoukeiGk();
        exBizCalcbleEquals(karigoukeigk, BizCurrency.valueOf(110), "借方合計金額");
    }

    @Test
    @TestOrder(30)
    public void testSeisanLastSiwakeMeisai_A3() {
        FurikaeDenpyouSiwakeMeisai bean = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean.setDenKanjoKamokuNm("name5");
        bean.setKinGk(BizCurrency.valueOf(80));
        bean.setTekiyouKm("project5");
        bean.setKjTekiyouKm("漢字摘要五");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("101");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(false);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(C_TaisyakuKbn.KASIKATA, BizCurrency.valueOf(100));

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name6");
        bean1.setKinGk(BizCurrency.valueOf(90));
        bean1.setTekiyouKm("project6");
        bean1.setKjTekiyouKm("漢字摘要六");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("101");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KARIKATA);

        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(C_TaisyakuKbn.KARIKATA, BizCurrency.valueOf(120));

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        FurikaeDenpyouPage furikaeDenpyouPage = resultLst.get(0);

        BizCurrency kasigoukeigk = furikaeDenpyouPage.getKasiGoukeiGk();
        exBizCalcbleEquals(kasigoukeigk, BizCurrency.valueOf(180), "貸方合計金額");

        BizCurrency karigoukeigk = furikaeDenpyouPage.getKariGoukeiGk();
        exBizCalcbleEquals(karigoukeigk, BizCurrency.valueOf(210), "借方合計金額");
    }

}
