package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * IBNR備金明細表作成<br />
 * 保険金給付金備金管理テーブルエンティティリスト（大量）取得　備金例外区分など<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisByBknkktymdItems {

    @Inject
    private SiharaiDomManager siharaiDomManager;


    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByBknkktymdItems(BizDate.valueOf(20160401), BizDate.valueOf(20160301), BizDate.valueOf(20160501), C_BknrigiKbn.valueOf("0"))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20160501), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160401), "A001");
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        siBikinkanri1.setCalckijyunymd(BizDate.valueOf(20160301));

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20160509), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160401), "A001");
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        siBikinkanri2.setCalckijyunymd(BizDate.valueOf(20160301));

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20160501), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160331), "A001");
        siBikinkanri3.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        siBikinkanri3.setCalckijyunymd(BizDate.valueOf(20160301));

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("B004", "11807111118", BizDate.valueOf(20160501), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160401), "A001");
        siBikinkanri4.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        siBikinkanri4.setCalckijyunymd(BizDate.valueOf(20160229));

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("B008", "11807111118", BizDate.valueOf(20160501), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160401), "A001");
        siBikinkanri5.setBknrigikbn(C_BknrigiKbn.valueOf("1"));
        siBikinkanri5.setCalckijyunymd(BizDate.valueOf(20160301));

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("B005", "11807111118", BizDate.valueOf(20160508), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160408), "A001");
        siBikinkanri6.setBknrigikbn(C_BknrigiKbn.valueOf("2"));
        siBikinkanri6.setCalckijyunymd(BizDate.valueOf(20160308));

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("B006", "11807111118", BizDate.valueOf(20160508), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160409), "A001");
        siBikinkanri7.setBknrigikbn(C_BknrigiKbn.valueOf("2"));
        siBikinkanri7.setCalckijyunymd(BizDate.valueOf(20160309));

        siharaiDomManager.insert(siBikinkanri7);

        JT_SiBikinkanri siBikinkanri8 = new JT_SiBikinkanri("B007", "11807111118", BizDate.valueOf(20160508), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160410), "A001");
        siBikinkanri8.setBknrigikbn(C_BknrigiKbn.valueOf("2"));
        siBikinkanri8.setCalckijyunymd(BizDate.valueOf(20160310));

        siharaiDomManager.insert(siBikinkanri8);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByBknkktymdItems(BizDate.valueOf(20160411), BizDate.valueOf(20160311), BizDate.valueOf(20160511), C_BknrigiKbn.valueOf("0"))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByBknkktymdItems(BizDate.valueOf(20160401), BizDate.valueOf(20160301), BizDate.valueOf(20160501), C_BknrigiKbn.valueOf("0"))) {

            Iterator<JT_SiBikinkanri> iter = exDBResults.iterator();
            JT_SiBikinkanri siBikinkanri = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                siBikinkanri=iter.next();

                Assert.assertEquals("B001", siBikinkanri.getSkno());
                Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160501), siBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.BLNK, siBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160401), siBikinkanri.getBknkktymd());
                Assert.assertEquals("A001", siBikinkanri.getKyuuhucd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("B005","11807111118",BizDate.valueOf(20160508),C_BkncdKbn.BLNK,BizDate.valueOf(20160408),"A001"), "1");
        datamap.put($("B006","11807111118",BizDate.valueOf(20160508),C_BkncdKbn.BLNK,BizDate.valueOf(20160409),"A001"), "1");
        datamap.put($("B007","11807111118",BizDate.valueOf(20160508),C_BkncdKbn.BLNK,BizDate.valueOf(20160410),"A001"), "1");

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByBknkktymdItems(BizDate.valueOf(20160408), BizDate.valueOf(20160308), BizDate.valueOf(20160508), C_BknrigiKbn.valueOf("2"))) {

            Iterator<JT_SiBikinkanri> iter = exDBResults.iterator();
            JT_SiBikinkanri siBikinkanri = null;

            while(iter.hasNext()) {
                siBikinkanri=iter.next();

                datamap.remove($(
                    siBikinkanri.getSkno(),
                    siBikinkanri.getSyono(),
                    siBikinkanri.getKessankijyunymd(),
                    siBikinkanri.getBkncdkbn(),
                    siBikinkanri.getBknkktymd(),
                    siBikinkanri.getKyuuhucd()));

            }

            Assert.assertTrue(datamap.isEmpty());
        }
    }
}
