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

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ訂正<br />
 * 振込入金データテーブル取得(入金)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknDatasByBankcdSitencdItems {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1001", "351", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20160408), 1);

        Assert.assertEquals(0, hT_HrkmNyknDatalst.size());

        HT_HrkmNyknData hrkmNyknData1 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO01");
        hrkmNyknData1.setBankcd("1001");
        hrkmNyknData1.setSitencd("351");
        hrkmNyknData1.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData1.setKouzano("KZNO01");
        hrkmNyknData1.setIribaraikbn(1);
        hrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData1.setHrkmirninnm("茅野");
        hrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData1);

        HT_HrkmNyknData hrkmNyknData2 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO02");
        hrkmNyknData2.setBankcd("1003");
        hrkmNyknData2.setSitencd("351");
        hrkmNyknData2.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData2.setKouzano("KZNO01");
        hrkmNyknData2.setIribaraikbn(3);
        hrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData2.setHrkmirninnm("茅野");
        hrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData2);

        HT_HrkmNyknData hrkmNyknData3 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO03");
        hrkmNyknData3.setBankcd("1003");
        hrkmNyknData3.setSitencd("351");
        hrkmNyknData3.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData3.setKouzano("KZNO01");
        hrkmNyknData3.setIribaraikbn(3);
        hrkmNyknData3.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData3.setHrkmirninnm("茅野");
        hrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData3);

        HT_HrkmNyknData hrkmNyknData4 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO04");
        hrkmNyknData4.setBankcd("1003");
        hrkmNyknData4.setSitencd("351");
        hrkmNyknData4.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData4.setKouzano("KZNO01");
        hrkmNyknData4.setIribaraikbn(3);
        hrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData4.setHrkmirninnm("茅野");
        hrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData4);

        HT_HrkmNyknData hrkmNyknData5 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO05");
        hrkmNyknData5.setBankcd("1001");
        hrkmNyknData5.setSitencd("351");
        hrkmNyknData5.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData5.setKouzano("KZNO01");
        hrkmNyknData5.setIribaraikbn(1);
        hrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData5.setHrkmirninnm("茅野");
        hrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(hrkmNyknData5);

        HT_HrkmNyknData hrkmNyknData6 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO06");
        hrkmNyknData6.setBankcd("1010");
        hrkmNyknData6.setSitencd("351");
        hrkmNyknData6.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData6.setKouzano("KZNO01");
        hrkmNyknData6.setIribaraikbn(1);
        hrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData6.setHrkmirninnm("茅野");
        hrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData6);

        HT_HrkmNyknData hrkmNyknData7 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO07");
        hrkmNyknData7.setBankcd("1001");
        hrkmNyknData7.setSitencd("310");
        hrkmNyknData7.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData7.setKouzano("KZNO01");
        hrkmNyknData7.setIribaraikbn(1);
        hrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData7.setHrkmirninnm("茅野");
        hrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData7);

        HT_HrkmNyknData hrkmNyknData8 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO08");
        hrkmNyknData8.setBankcd("1001");
        hrkmNyknData8.setSitencd("351");
        hrkmNyknData8.setYokinkbn(C_YokinKbn.HUTUU);
        hrkmNyknData8.setKouzano("KZNO01");
        hrkmNyknData8.setIribaraikbn(1);
        hrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData8.setHrkmirninnm("茅野");
        hrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData8);

        HT_HrkmNyknData hrkmNyknData9 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO09");
        hrkmNyknData9.setBankcd("1001");
        hrkmNyknData9.setSitencd("351");
        hrkmNyknData9.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData9.setKouzano("KZNO10");
        hrkmNyknData9.setIribaraikbn(1);
        hrkmNyknData9.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData9.setHrkmirninnm("茅野");
        hrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData9);

        HT_HrkmNyknData hrkmNyknData10 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO10");
        hrkmNyknData10.setBankcd("1001");
        hrkmNyknData10.setSitencd("351");
        hrkmNyknData10.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData10.setKouzano("KZNO01");
        hrkmNyknData10.setIribaraikbn(1);
        hrkmNyknData10.setTrhkkgk(BizCurrency.valueOf(2000));
        hrkmNyknData10.setHrkmirninnm("茅野");
        hrkmNyknData10.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData10);

        HT_HrkmNyknData hrkmNyknData11 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO11");
        hrkmNyknData11.setBankcd("1001");
        hrkmNyknData11.setSitencd("351");
        hrkmNyknData11.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData11.setKouzano("KZNO01");
        hrkmNyknData11.setIribaraikbn(1);
        hrkmNyknData11.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData11.setHrkmirninnm("早見");
        hrkmNyknData11.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData11);

        HT_HrkmNyknData hrkmNyknData12 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160409), "IRNO12");
        hrkmNyknData12.setBankcd("1001");
        hrkmNyknData12.setSitencd("351");
        hrkmNyknData12.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData12.setKouzano("KZNO01");
        hrkmNyknData12.setIribaraikbn(1);
        hrkmNyknData12.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData12.setHrkmirninnm("茅野");
        hrkmNyknData12.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData12);

        HT_HrkmNyknData hrkmNyknData13 = new HT_HrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO13");
        hrkmNyknData13.setBankcd("1001");
        hrkmNyknData13.setSitencd("351");
        hrkmNyknData13.setYokinkbn(C_YokinKbn.BLNK);
        hrkmNyknData13.setKouzano("KZNO01");
        hrkmNyknData13.setIribaraikbn(2);
        hrkmNyknData13.setTrhkkgk(BizCurrency.valueOf(1000));
        hrkmNyknData13.setHrkmirninnm("茅野");
        hrkmNyknData13.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(hrkmNyknData13);
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

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1001", "352", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20160408), 1);

        Assert.assertEquals(0, hT_HrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1001", "351", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20160408), 1);

        Assert.assertEquals(1, hT_HrkmNyknDatalst.size());

        Assert.assertEquals(C_DensysKbn.BLNK, hT_HrkmNyknDatalst.get(0).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf(20160408), hT_HrkmNyknDatalst.get(0).getSyoriYmd());
        Assert.assertEquals("IRNO01", hT_HrkmNyknDatalst.get(0).getItirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> hrkmNyknDataMap = new HashMap<String,String>();
        hrkmNyknDataMap.put($(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO02"), "1");
        hrkmNyknDataMap.put($(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO03"), "1");
        hrkmNyknDataMap.put($(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO04"), "1");

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1003", "351", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(3, hT_HrkmNyknDatalst.size());

        hrkmNyknDataMap.remove($(hT_HrkmNyknDatalst.get(0).getDensyskbn(), hT_HrkmNyknDatalst.get(0).getSyoriYmd(), hT_HrkmNyknDatalst.get(0).getItirenno()));

        hrkmNyknDataMap.remove($(hT_HrkmNyknDatalst.get(1).getDensyskbn(), hT_HrkmNyknDatalst.get(1).getSyoriYmd(), hT_HrkmNyknDatalst.get(1).getItirenno()));

        hrkmNyknDataMap.remove($(hT_HrkmNyknDatalst.get(2).getDensyskbn(), hT_HrkmNyknDatalst.get(2).getSyoriYmd(), hT_HrkmNyknDatalst.get(2).getItirenno()));

        assertTrue(hrkmNyknDataMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("", "351", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, hT_HrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1003", "", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, hT_HrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1003", "351", C_YokinKbn.BLNK, "", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, hT_HrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(70)
    public void blank4() {

        List<HT_HrkmNyknData> hT_HrkmNyknDatalst = sinkeiyakuDomManager
            .getHrkmNyknDatasByBankcdSitencdItems("1003", "351", C_YokinKbn.BLNK, "KZNO01", BizCurrency.valueOf(1000),
                "", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, hT_HrkmNyknDatalst.size());
    }
}
