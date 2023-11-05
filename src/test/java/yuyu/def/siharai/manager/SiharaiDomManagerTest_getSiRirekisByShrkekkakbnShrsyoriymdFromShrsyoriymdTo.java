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

import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn.SHR, BizDate.valueOf(20160829),BizDate.valueOf(20160829))) {

            Assert.assertFalse(jT_SiRirekiResults.iterator().hasNext());
        }
        JT_SkKihon skKihon1 = new JT_SkKihon("10000001", "11807111118");

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("1001");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki1.setShrsyoriymd(BizDate.valueOf(20160829));

        JT_SiRireki siRireki2 = skKihon1.createSiRireki();
        siRireki2.setShrsikibetukey("1002");
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki2.setShrsyoriymd(BizDate.valueOf(20160829));

        JT_SiRireki siRireki3 = skKihon1.createSiRireki();
        siRireki3.setShrsikibetukey("1003");
        siRireki3.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki3.setShrsyoriymd(BizDate.valueOf(20160828));

        JT_SiRireki siRireki4 = skKihon1.createSiRireki();
        siRireki4.setShrsikibetukey("1004");
        siRireki4.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki4.setShrsyoriymd(BizDate.valueOf(20160830));

        JT_SiRireki siRireki5 = skKihon1.createSiRireki();
        siRireki5.setShrsikibetukey("1005");
        siRireki5.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki5.setShrsyoriymd(BizDate.valueOf(20160810));

        JT_SiRireki siRireki6 = skKihon1.createSiRireki();
        siRireki6.setShrsikibetukey("1006");
        siRireki6.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki6.setShrsyoriymd(BizDate.valueOf(20160811));

        JT_SiRireki siRireki7 = skKihon1.createSiRireki();
        siRireki7.setShrsikibetukey("1007");
        siRireki7.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki7.setShrsyoriymd(BizDate.valueOf(20160812));

        siharaiDomManager.insert(skKihon1);
    }


    @AfterClass
    @Transactional
    public static void deleteTestData(){

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn.SHR, BizDate.valueOf(20150810),BizDate.valueOf(20150812))) {

            Assert.assertFalse(jT_SiRirekiResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn.SHR, BizDate.valueOf(20160829),BizDate.valueOf(20160829))) {

            int iCount = 0;
            Iterator<JT_SiRireki> iter = jT_SiRirekiResults.iterator();
            JT_SiRireki jT_SiRireki = null;
            while (iter.hasNext()) {

                jT_SiRireki = iter.next();
                iCount++;

                Assert.assertEquals("10000001", jT_SiRireki.getSkno());
                Assert.assertEquals("11807111118", jT_SiRireki.getSyono());
                Assert.assertEquals("1001", jT_SiRireki.getShrsikibetukey());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000001","11807111118","1005"), "1");
        datamap.put($("10000001","11807111118","1006"), "2");
        datamap.put($("10000001","11807111118","1007"), "2");

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn.SHR, BizDate.valueOf(20160810),BizDate.valueOf(20160812))) {

            Iterator<JT_SiRireki> iter = jT_SiRirekiResults.iterator();
            JT_SiRireki jT_SiRireki = null;
            while (iter.hasNext()) {

                jT_SiRireki = iter.next();

                datamap.remove($(
                    jT_SiRireki.getSkno(),
                    jT_SiRireki.getSyono(),
                    jT_SiRireki.getShrsikibetukey()));
            }

            Assert.assertTrue(datamap.isEmpty());
        }
    }
}
