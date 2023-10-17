package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ削除<br />
 * 外貨振込入金データテーブルエンティティリスト取得（申込番号、親代理店コード、振込依頼人名、取引金額）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_HRKMIRNINNM_01 = "茅野";
    static String P_OYADRTENCD_01  = "TENCD01";
    static String P_OYADRTENCD_02  = "TENCD02";
    static BizCurrency P_TRHKKGK_01 = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, P_OYADRTENCD_01,
                P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, gaikaHrkmNyknDatas.size());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO1");
        gaikaHrkmNyknData1.setNykmosno("791112220");
        gaikaHrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setHrkmirninnm("茅野");
        gaikaHrkmNyknData1.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO2");
        gaikaHrkmNyknData2.setNykmosno("791112238");
        gaikaHrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setHrkmirninnm("茅野");
        gaikaHrkmNyknData2.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO3");
        gaikaHrkmNyknData3.setNykmosno("791112238");
        gaikaHrkmNyknData3.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData3.setHrkmirninnm("茅野");
        gaikaHrkmNyknData3.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO4");
        gaikaHrkmNyknData4.setNykmosno("791112238");
        gaikaHrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setHrkmirninnm("茅野");
        gaikaHrkmNyknData4.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO5");
        gaikaHrkmNyknData5.setNykmosno("791112238");
        gaikaHrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData5.setHrkmirninnm("茅野");
        gaikaHrkmNyknData5.setOyadrtencd("TENCD02");
        gaikaHrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO6");
        gaikaHrkmNyknData6.setNykmosno("791112238");
        gaikaHrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData6.setHrkmirninnm("早見");
        gaikaHrkmNyknData6.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO7");
        gaikaHrkmNyknData7.setNykmosno("791112238");
        gaikaHrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(2000));
        gaikaHrkmNyknData7.setHrkmirninnm("茅野");
        gaikaHrkmNyknData7.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO8");
        gaikaHrkmNyknData8.setNykmosno("791112246");
        gaikaHrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData8.setHrkmirninnm("茅野");
        gaikaHrkmNyknData8.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData9 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160405), "ITIRENNO9");
        gaikaHrkmNyknData9.setNykmosno("791112238");
        gaikaHrkmNyknData9.setTrhkkgk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        gaikaHrkmNyknData9.setHrkmirninnm("茅野");
        gaikaHrkmNyknData9.setOyadrtencd("TENCD01");
        gaikaHrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData9);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, P_OYADRTENCD_02,
                P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, gaikaHrkmNyknDatas.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, P_OYADRTENCD_01,
                P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(1, gaikaHrkmNyknDatas.size());

        Assert.assertEquals(C_DensysKbn.BLNK, gaikaHrkmNyknDatas.get(0).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf(20160405), gaikaHrkmNyknDatas.get(0).getSyoriYmd());
        Assert.assertEquals("ITIRENNO1", gaikaHrkmNyknDatas.get(0).getItirenno());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_02, P_OYADRTENCD_01,
                P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(3, gaikaHrkmNyknDatas.size());
        Map<String,String> resultMap = new HashMap<String,String>();

        resultMap.put($(C_DensysKbn.BLNK,"20160405", "ITIRENNO2"),"1");
        resultMap.put($(C_DensysKbn.BLNK,"20160405", "ITIRENNO3"),"1");
        resultMap.put($(C_DensysKbn.BLNK,"20160405", "ITIRENNO4"), "1");

        for(HT_GaikaHrkmNyknData data:gaikaHrkmNyknDatas){
            resultMap.remove($(data.getDensyskbn(),data.getSyoriYmd(),data.getItirenno()));
        }

        assertTrue(resultMap.isEmpty());
        //
        //        Assert.assertEquals(C_DensysKbn.BLNK, gaikaHrkmNyknDatas.get(0).getDensyskbn());
        //        Assert.assertEquals(BizDate.valueOf(20160405), gaikaHrkmNyknDatas.get(0).getSyoriYmd());
        //        Assert.assertEquals("ITIRENNO2", gaikaHrkmNyknDatas.get(0).getItirenno());
        //
        //        Assert.assertEquals(C_DensysKbn.BLNK, gaikaHrkmNyknDatas.get(1).getDensyskbn());
        //        Assert.assertEquals(BizDate.valueOf(20160405), gaikaHrkmNyknDatas.get(1).getSyoriYmd());
        //        Assert.assertEquals("ITIRENNO3", gaikaHrkmNyknDatas.get(1).getItirenno());
        //
        //        Assert.assertEquals(C_DensysKbn.BLNK, gaikaHrkmNyknDatas.get(2).getDensyskbn());
        //        Assert.assertEquals(BizDate.valueOf(20160405), gaikaHrkmNyknDatas.get(2).getSyoriYmd());
        //        Assert.assertEquals("ITIRENNO4", gaikaHrkmNyknDatas.get(2).getItirenno());
    }

    @Test
    @TestOrder(40)
    public void Blank1(){

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk("", P_OYADRTENCD_02,
                P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, gaikaHrkmNyknDatas.size());
    }

    @Test
    @TestOrder(50)
    public void Blank2(){

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, "",
                P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, gaikaHrkmNyknDatas.size());
    }

    @Test
    @TestOrder(60)
    public void Blank3(){

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatas = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, P_OYADRTENCD_02,
                "", P_TRHKKGK_01);

        Assert.assertEquals(0, gaikaHrkmNyknDatas.size());
    }
}
