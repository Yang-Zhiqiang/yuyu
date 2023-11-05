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
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金データ訂正<br />
 * 外貨振込入金データテーブル取得(入金)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaikaHrkmNyknDatasByBankcdSitencdItems {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1001", "351", "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20160408), 1);

        Assert.assertEquals(0, gaikaHrkmNyknDatalst.size());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO01");
        gaikaHrkmNyknData1.setBankcd("1001");
        gaikaHrkmNyknData1.setSitencd("351");
        gaikaHrkmNyknData1.setKouzano("KZNO01");
        gaikaHrkmNyknData1.setIribaraikbn(1);
        gaikaHrkmNyknData1.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData1.setHrkmirninnm("茅野");
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO02");
        gaikaHrkmNyknData2.setBankcd("1003");
        gaikaHrkmNyknData2.setSitencd("351");
        gaikaHrkmNyknData2.setKouzano("KZNO01");
        gaikaHrkmNyknData2.setIribaraikbn(3);
        gaikaHrkmNyknData2.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData2.setHrkmirninnm("茅野");
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO03");
        gaikaHrkmNyknData3.setBankcd("1003");
        gaikaHrkmNyknData3.setSitencd("351");
        gaikaHrkmNyknData3.setKouzano("KZNO01");
        gaikaHrkmNyknData3.setIribaraikbn(3);
        gaikaHrkmNyknData3.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData3.setHrkmirninnm("茅野");
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO04");
        gaikaHrkmNyknData4.setBankcd("1003");
        gaikaHrkmNyknData4.setSitencd("351");
        gaikaHrkmNyknData4.setKouzano("KZNO01");
        gaikaHrkmNyknData4.setIribaraikbn(3);
        gaikaHrkmNyknData4.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData4.setHrkmirninnm("茅野");
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData5 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO05");
        gaikaHrkmNyknData5.setBankcd("1001");
        gaikaHrkmNyknData5.setSitencd("351");
        gaikaHrkmNyknData5.setKouzano("KZNO01");
        gaikaHrkmNyknData5.setIribaraikbn(1);
        gaikaHrkmNyknData5.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData5.setHrkmirninnm("茅野");
        gaikaHrkmNyknData5.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData5);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData6 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO06");
        gaikaHrkmNyknData6.setBankcd("1010");
        gaikaHrkmNyknData6.setSitencd("351");
        gaikaHrkmNyknData6.setKouzano("KZNO01");
        gaikaHrkmNyknData6.setIribaraikbn(1);
        gaikaHrkmNyknData6.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData6.setHrkmirninnm("茅野");
        gaikaHrkmNyknData6.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData6);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData7 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO07");
        gaikaHrkmNyknData7.setBankcd("1001");
        gaikaHrkmNyknData7.setSitencd("310");
        gaikaHrkmNyknData7.setKouzano("KZNO01");
        gaikaHrkmNyknData7.setIribaraikbn(1);
        gaikaHrkmNyknData7.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData7.setHrkmirninnm("茅野");
        gaikaHrkmNyknData7.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData7);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData8 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO09");
        gaikaHrkmNyknData8.setBankcd("1001");
        gaikaHrkmNyknData8.setSitencd("351");
        gaikaHrkmNyknData8.setKouzano("KZNO10");
        gaikaHrkmNyknData8.setIribaraikbn(1);
        gaikaHrkmNyknData8.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData8.setHrkmirninnm("茅野");
        gaikaHrkmNyknData8.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData8);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData9 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO10");
        gaikaHrkmNyknData9.setBankcd("1001");
        gaikaHrkmNyknData9.setSitencd("351");
        gaikaHrkmNyknData9.setKouzano("KZNO01");
        gaikaHrkmNyknData9.setIribaraikbn(1);
        gaikaHrkmNyknData9.setTrhkkgk(BizCurrency.valueOf(2000));
        gaikaHrkmNyknData9.setHrkmirninnm("茅野");
        gaikaHrkmNyknData9.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData9);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData10 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO11");
        gaikaHrkmNyknData10.setBankcd("1001");
        gaikaHrkmNyknData10.setSitencd("351");
        gaikaHrkmNyknData10.setKouzano("KZNO01");
        gaikaHrkmNyknData10.setIribaraikbn(1);
        gaikaHrkmNyknData10.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData10.setHrkmirninnm("早見");
        gaikaHrkmNyknData10.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData10);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData11 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160409), "IRNO12");
        gaikaHrkmNyknData11.setBankcd("1001");
        gaikaHrkmNyknData11.setSitencd("351");
        gaikaHrkmNyknData11.setKouzano("KZNO01");
        gaikaHrkmNyknData11.setIribaraikbn(1);
        gaikaHrkmNyknData11.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData11.setHrkmirninnm("茅野");
        gaikaHrkmNyknData11.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData11);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData12 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160408), "IRNO13");
        gaikaHrkmNyknData12.setBankcd("1001");
        gaikaHrkmNyknData12.setSitencd("351");
        gaikaHrkmNyknData12.setKouzano("KZNO01");
        gaikaHrkmNyknData12.setIribaraikbn(2);
        gaikaHrkmNyknData12.setTrhkkgk(BizCurrency.valueOf(1000));
        gaikaHrkmNyknData12.setHrkmirninnm("茅野");
        gaikaHrkmNyknData12.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData12);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1001", "352", "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20160408), 1);

        Assert.assertEquals(0, gaikaHrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_GaikaHrkmNyknData> HT_GaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1001", "351", "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20160408), 1);

        Assert.assertEquals(1, HT_GaikaHrkmNyknDatalst.size());

        Assert.assertEquals(C_DensysKbn.BLNK, HT_GaikaHrkmNyknDatalst.get(0).getDensyskbn());
        Assert.assertEquals(BizDate.valueOf(20160408), HT_GaikaHrkmNyknDatalst.get(0).getSyoriYmd());
        Assert.assertEquals("IRNO01", HT_GaikaHrkmNyknDatalst.get(0).getItirenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> hrkmNyknDataMap = new HashMap<String,String>();
        hrkmNyknDataMap.put($(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO02"), "1");
        hrkmNyknDataMap.put($(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO03"), "1");
        hrkmNyknDataMap.put($(C_DensysKbn.BLNK, BizDate.valueOf(20161223), "IRNO04"), "1");

        List<HT_GaikaHrkmNyknData> HT_GaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1003", "351", "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(3, HT_GaikaHrkmNyknDatalst.size());

        hrkmNyknDataMap.remove($(HT_GaikaHrkmNyknDatalst.get(0).getDensyskbn(), HT_GaikaHrkmNyknDatalst.get(0).getSyoriYmd(), HT_GaikaHrkmNyknDatalst.get(0).getItirenno()));

        hrkmNyknDataMap.remove($(HT_GaikaHrkmNyknDatalst.get(1).getDensyskbn(), HT_GaikaHrkmNyknDatalst.get(1).getSyoriYmd(), HT_GaikaHrkmNyknDatalst.get(1).getItirenno()));

        hrkmNyknDataMap.remove($(HT_GaikaHrkmNyknDatalst.get(2).getDensyskbn(), HT_GaikaHrkmNyknDatalst.get(2).getSyoriYmd(), HT_GaikaHrkmNyknDatalst.get(2).getItirenno()));

        assertTrue(hrkmNyknDataMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_GaikaHrkmNyknData> HT_GaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("", "351", "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, HT_GaikaHrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<HT_GaikaHrkmNyknData> HT_GaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1003", "", "KZNO01", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, HT_GaikaHrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<HT_GaikaHrkmNyknData> HT_GaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1003", "351", "", BizCurrency.valueOf(1000),
                "茅野", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, HT_GaikaHrkmNyknDatalst.size());
    }

    @Test
    @TestOrder(70)
    public void blank4() {

        List<HT_GaikaHrkmNyknData> HT_GaikaHrkmNyknDatalst = sinkeiyakuDomManager
            .getGaikaHrkmNyknDatasByBankcdSitencdItems("1003", "351", "KZNO01", BizCurrency.valueOf(1000),
                "", BizDate.valueOf(20161223), 3);

        Assert.assertEquals(0, HT_GaikaHrkmNyknDatalst.size());
    }
}
