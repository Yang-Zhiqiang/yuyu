package yuyu.def.siharai.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.result.bean.SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        try (ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> exDBRsBeans =
                siharaiDomManager.getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu.SDSSHR, BizDate.valueOf(20160110), BizDate.valueOf(20160115))) {

            Assert.assertFalse(exDBRsBeans.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("101", "11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("6"));

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("1");
        siRireki1.setShrsyoriymd(BizDate.valueOf(20160112));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("108", "11807111118");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("7"));

        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey("2");
        siRireki2.setShrsyoriymd(BizDate.valueOf(20150109));

        JT_SiRireki siRireki3 = skKihon2.createSiRireki();
        siRireki3.setShrsikibetukey("3");
        siRireki3.setShrsyoriymd(BizDate.valueOf(20150116));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("102", "11807111118");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("6"));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("108", "11807111129");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("6"));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("105", "11807111152");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));

        JT_SiRireki siRireki4 = skKihon5.createSiRireki();
        siRireki4.setShrsikibetukey("4");
        siRireki4.setShrsyoriymd(BizDate.valueOf(20170310));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("104", "11807111152");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));

        JT_SiRireki siRireki5 = skKihon6.createSiRireki();
        siRireki5.setShrsikibetukey("5");
        siRireki5.setShrsyoriymd(BizDate.valueOf(20170311));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("103", "11807111152");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));

        JT_SiRireki siRireki6 = skKihon7.createSiRireki();
        siRireki6.setShrsikibetukey("6");
        siRireki6.setShrsyoriymd(BizDate.valueOf(20170312));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("105", "11807111141");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));

        JT_SiRireki siRireki7 = skKihon8.createSiRireki();
        siRireki7.setShrsikibetukey("7");
        siRireki7.setShrsyoriymd(BizDate.valueOf(20170313));

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("105", "11807111130");
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));

        JT_SiRireki siRireki8 = skKihon9.createSiRireki();
        siRireki8.setShrsikibetukey("8");
        siRireki8.setShrsyoriymd(BizDate.valueOf(20170314));

        siharaiDomManager.insert(skKihon9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> exDBRsBeans =
                siharaiDomManager.getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu.SDSSHR, BizDate.valueOf(20150110), BizDate.valueOf(20150115))) {

            Assert.assertFalse(exDBRsBeans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        try (ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> exDBRsBeans =
                siharaiDomManager.getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu.SDSSHR, BizDate.valueOf(20160110), BizDate.valueOf(20160115))) {

            int iCount = 0;
            Iterator<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> iter = exDBRsBeans.iterator();
            SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                Assert.assertEquals("101", bean.getJT_SkKihon().getSkno());
                Assert.assertEquals("11807111118", bean.getJT_SkKihon().getSyono());
                Assert.assertEquals("101", bean.getJT_SiRireki().getSkno());
                Assert.assertEquals("11807111118", bean.getJT_SiRireki().getSyono());
                Assert.assertEquals("1", bean.getJT_SiRireki().getShrsikibetukey());
            }

            Assert.assertEquals(1, iCount);
        }

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        try (ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> exDBRsBeans =
                siharaiDomManager.getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu.KOUSG, BizDate.valueOf(20170310), BizDate.valueOf(20170314))) {

            int iCount = 0;
            Iterator<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean> iter = exDBRsBeans.iterator();
            SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("105", bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals("11807111130", bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals("105", bean.getJT_SiRireki().getSkno());
                    Assert.assertEquals("11807111130", bean.getJT_SiRireki().getSyono());
                    Assert.assertEquals("8", bean.getJT_SiRireki().getShrsikibetukey());

                    continue;
                }

                if (2 == iCount) {
                    Assert.assertEquals("105", bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals("11807111141", bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals("105", bean.getJT_SiRireki().getSkno());
                    Assert.assertEquals("11807111141", bean.getJT_SiRireki().getSyono());
                    Assert.assertEquals("7", bean.getJT_SiRireki().getShrsikibetukey());

                    continue;
                }

                if (3 == iCount) {
                    Assert.assertEquals("103", bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals("11807111152", bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals("103", bean.getJT_SiRireki().getSkno());
                    Assert.assertEquals("11807111152", bean.getJT_SiRireki().getSyono());
                    Assert.assertEquals("6", bean.getJT_SiRireki().getShrsikibetukey());

                    continue;
                }

                if (4 == iCount) {
                    Assert.assertEquals("104", bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals("11807111152", bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals("104", bean.getJT_SiRireki().getSkno());
                    Assert.assertEquals("11807111152", bean.getJT_SiRireki().getSyono());
                    Assert.assertEquals("5", bean.getJT_SiRireki().getShrsikibetukey());

                    continue;
                }

                if (5 == iCount) {
                    Assert.assertEquals("105", bean.getJT_SkKihon().getSkno());
                    Assert.assertEquals("11807111152", bean.getJT_SkKihon().getSyono());
                    Assert.assertEquals("105", bean.getJT_SiRireki().getSkno());
                    Assert.assertEquals("11807111152", bean.getJT_SiRireki().getSyono());
                    Assert.assertEquals("4", bean.getJT_SiRireki().getShrsikibetukey());

                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
        }
    }

}

