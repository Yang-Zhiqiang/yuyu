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
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ削除<br />
 * 振込入金データテーブルエンティティリスト取得（申込番号、親代理店コード、振込依頼人名、取引金額）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static BizDate P_SYORIYMD_01 = BizDate.valueOf(20160405);
    static String P_MOSNO_01 = "791112220";
    static BizCurrency P_TRHKKGK_01 = BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN);
    static String P_HRKMIRNINNM_01 = "茅野";
    static String P_OYADRTENCD_01 = "1";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk("791112253", P_OYADRTENCD_01, P_HRKMIRNINNM_01, P_TRHKKGK_01);
        Assert.assertEquals(0, hrkmNyknDataList.size());

        HT_HrkmNyknData hrkmNyknData1 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20150405), "1111");
        hrkmNyknData1.setNykmosno("791112253");
        hrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData1.setHrkmirninnm("茅野");
        hrkmNyknData1.setOyadrtencd("1");
        hrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData1);

        HT_HrkmNyknData hrkmNyknData2 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "2222");
        hrkmNyknData2.setNykmosno("791112238");
        hrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData2.setHrkmirninnm("茅野");
        hrkmNyknData2.setOyadrtencd("1");
        hrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData2);

        HT_HrkmNyknData hrkmNyknData3 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "3333");
        hrkmNyknData3.setNykmosno("791112220");
        hrkmNyknData3.setTrhkkgk(BizCurrency.valueOf(22222222, BizCurrencyTypes.YEN));
        hrkmNyknData3.setHrkmirninnm("茅野");
        hrkmNyknData3.setOyadrtencd("1");
        hrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData3);

        HT_HrkmNyknData hrkmNyknData4 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "4444");
        hrkmNyknData4.setNykmosno("791112220");
        hrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData4.setHrkmirninnm("早見");
        hrkmNyknData4.setOyadrtencd("1");
        hrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData4);

        HT_HrkmNyknData hrkmNyknData5 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "5555");
        hrkmNyknData5.setNykmosno("791112220");
        hrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData5.setHrkmirninnm("茅野");
        hrkmNyknData5.setOyadrtencd("2");
        hrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData5);

        HT_HrkmNyknData hrkmNyknData6 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "6666");
        hrkmNyknData6.setNykmosno("791112220");
        hrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData6.setHrkmirninnm("茅野");
        hrkmNyknData6.setOyadrtencd("1");
        hrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData6);

        HT_HrkmNyknData hrkmNyknData7 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "7777");
        hrkmNyknData7.setNykmosno("791112220");
        hrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData7.setHrkmirninnm("茅野");
        hrkmNyknData7.setOyadrtencd("1");
        hrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData7);

        HT_HrkmNyknData hrkmNyknData8 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "8888");
        hrkmNyknData8.setNykmosno("791112220");
        hrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData8.setHrkmirninnm("茅野");
        hrkmNyknData8.setOyadrtencd("1");
        hrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData8);

        HT_HrkmNyknData hrkmNyknData9 = new HT_HrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160405), "9999");
        hrkmNyknData9.setNykmosno("791112220");
        hrkmNyknData9.setTrhkkgk(BizCurrency.valueOf(11111111, BizCurrencyTypes.YEN));
        hrkmNyknData9.setHrkmirninnm("茅野");
        hrkmNyknData9.setOyadrtencd("1");
        hrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(hrkmNyknData9);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknData());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk("791112246", P_OYADRTENCD_01, P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, hrkmNyknDataList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk("791112253", P_OYADRTENCD_01, P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(1, hrkmNyknDataList.size());

        Assert.assertEquals(C_DensysKbn.SKEI, hrkmNyknDataList.get(0).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf(20150405), hrkmNyknDataList.get(0).getSyoriYmd());
        Assert.assertEquals("1111", hrkmNyknDataList.get(0).getItirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, P_OYADRTENCD_01, P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(3, hrkmNyknDataList.size());

        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put($(C_DensysKbn.SKEI,P_SYORIYMD_01,"6666"), "1");
        resultMap.put($(C_DensysKbn.SKEI,P_SYORIYMD_01,"7777"), "1");
        resultMap.put($(C_DensysKbn.SKEI,P_SYORIYMD_01,"8888"), "1");

        for(HT_HrkmNyknData data:hrkmNyknDataList){
            resultMap.remove($(data.getDensyskbn(),data.getSyoriYmd(),data.getItirenno()));
        }
        assertTrue(resultMap.isEmpty());
        //
        //        Assert.assertEquals(C_DensysKbn.SKEI, hrkmNyknDataList.get(0).getDensyskbn());
        //        Assert.assertEquals(P_SYORIYMD_01, hrkmNyknDataList.get(0).getSyoriYmd());
        //        Assert.assertEquals("6666", hrkmNyknDataList.get(0).getItirenno());
        //
        //        Assert.assertEquals(C_DensysKbn.SKEI, hrkmNyknDataList.get(1).getDensyskbn());
        //        Assert.assertEquals(P_SYORIYMD_01, hrkmNyknDataList.get(1).getSyoriYmd());
        //        Assert.assertEquals("7777", hrkmNyknDataList.get(1).getItirenno());
        //
        //        Assert.assertEquals(C_DensysKbn.SKEI, hrkmNyknDataList.get(2).getDensyskbn());
        //        Assert.assertEquals(P_SYORIYMD_01, hrkmNyknDataList.get(2).getSyoriYmd());
        //        Assert.assertEquals("8888", hrkmNyknDataList.get(2).getItirenno());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk("", P_OYADRTENCD_01, P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, hrkmNyknDataList.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, "", P_HRKMIRNINNM_01, P_TRHKKGK_01);

        Assert.assertEquals(0, hrkmNyknDataList.size());
    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<HT_HrkmNyknData> hrkmNyknDataList = sinkeiyakuDomManager.getHrkmNyknDatasByMosnoOyadrtencdHrkmirninnmTrhkkgk(P_MOSNO_01, P_OYADRTENCD_01, "", P_TRHKKGK_01);

        Assert.assertEquals(0, hrkmNyknDataList.size());
    }
}
