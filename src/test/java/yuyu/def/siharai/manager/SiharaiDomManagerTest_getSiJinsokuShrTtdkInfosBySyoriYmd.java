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

import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiJinsokuShrTtdkInfosBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiJinsokuShrTtdkInfosBySyoriYmd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiJinsokuShrTtdkInfo> exDBRes_JT_SiJinsokuShrTtdkInfo =
            siharaiDomManager.getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate.valueOf(20160824), BizDate.valueOf(20160826))) {

            Assert.assertFalse(exDBRes_JT_SiJinsokuShrTtdkInfo.iterator().hasNext());
        }

        JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo1 = new JT_SiJinsokuShrTtdkInfo("1000001", "1111", "10",
            BizDate.valueOf(20160828), BizDate.valueOf(20160825), BizDate.valueOf(20160824), "11807111118");

        siharaiDomManager.insert(siJinsokuShrTtdkInfo1);

        JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo2 = new JT_SiJinsokuShrTtdkInfo("1000002", "1111", "10",
            BizDate.valueOf(20160828), BizDate.valueOf(20160822), BizDate.valueOf(20160824), "11807111118");

        siharaiDomManager.insert(siJinsokuShrTtdkInfo2);

        JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo3 = new JT_SiJinsokuShrTtdkInfo("1000003", "1111", "10",
            BizDate.valueOf(20160828), BizDate.valueOf(20160828), BizDate.valueOf(20160824), "11807111118");

        siharaiDomManager.insert(siJinsokuShrTtdkInfo3);

        JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo4 = new JT_SiJinsokuShrTtdkInfo("1000004", "1111", "10",
            BizDate.valueOf(20160828), BizDate.valueOf(20160827), BizDate.valueOf(20160824), "11807111118");

        siharaiDomManager.insert(siJinsokuShrTtdkInfo4);

        JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo5 = new JT_SiJinsokuShrTtdkInfo("1000005", "1111", "10",
            BizDate.valueOf(20160828), BizDate.valueOf(20160823), BizDate.valueOf(20160824), "11807111118");

        siharaiDomManager.insert(siJinsokuShrTtdkInfo5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiJinsokuShrTtdkInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<JT_SiJinsokuShrTtdkInfo> exDBRes_JT_SiJinsokuShrTtdkInfo =
            siharaiDomManager.getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate.valueOf(20160924), BizDate.valueOf(20160926))) {

            Assert.assertFalse(exDBRes_JT_SiJinsokuShrTtdkInfo.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        try (ExDBResults<JT_SiJinsokuShrTtdkInfo> exDBRes_JT_SiJinsokuShrTtdkInfo =
            siharaiDomManager.getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate.valueOf(20160824), BizDate.valueOf(20160826))) {

            Iterator<JT_SiJinsokuShrTtdkInfo> iter = exDBRes_JT_SiJinsokuShrTtdkInfo.iterator();
            JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                siJinsokuShrTtdkInfo=iter.next();

                Assert.assertEquals("1000001", siJinsokuShrTtdkInfo.getSyorisosikicd());
                Assert.assertEquals("1111", siJinsokuShrTtdkInfo.getSyoricd());
                Assert.assertEquals("10", siJinsokuShrTtdkInfo.getHknknshrsntkno());
                Assert.assertEquals(BizDate.valueOf(20160828), siJinsokuShrTtdkInfo.getSyoruiukeymd());
                Assert.assertEquals(BizDate.valueOf(20160825), siJinsokuShrTtdkInfo.getSyoriYmd());
                Assert.assertEquals(BizDate.valueOf(20160824), siJinsokuShrTtdkInfo.getDenymd());
                Assert.assertEquals("11807111118", siJinsokuShrTtdkInfo.getSyono());

            }
            Assert.assertEquals(1, iCount);
        }

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1000001","1111","10",BizDate.valueOf(20160828),BizDate.valueOf(20160825),BizDate.valueOf(20160824),"11807111118"), "1");
        datamap.put($("1000004","1111","10",BizDate.valueOf(20160828),BizDate.valueOf(20160827),BizDate.valueOf(20160824),"11807111118"), "1");
        datamap.put($("1000005","1111","10",BizDate.valueOf(20160828),BizDate.valueOf(20160823),BizDate.valueOf(20160824),"11807111118"), "1");

        try (ExDBResults<JT_SiJinsokuShrTtdkInfo> exDBRes_JT_SiJinsokuShrTtdkInfo =
            siharaiDomManager.getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate.valueOf(20160823), BizDate.valueOf(20160827))) {

            Iterator<JT_SiJinsokuShrTtdkInfo> iter = exDBRes_JT_SiJinsokuShrTtdkInfo.iterator();
            JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo = null;

            while(iter.hasNext()) {

                siJinsokuShrTtdkInfo=iter.next();

                datamap.remove($(
                    siJinsokuShrTtdkInfo.getSyorisosikicd(),
                    siJinsokuShrTtdkInfo.getSyoricd(),
                    siJinsokuShrTtdkInfo.getHknknshrsntkno(),
                    siJinsokuShrTtdkInfo.getSyoruiukeymd(),
                    siJinsokuShrTtdkInfo.getSyoriYmd(),
                    siJinsokuShrTtdkInfo.getDenymd(),
                    siJinsokuShrTtdkInfo.getSyono()));

            }

            Assert.assertTrue(datamap.isEmpty());
        }

    }

}


