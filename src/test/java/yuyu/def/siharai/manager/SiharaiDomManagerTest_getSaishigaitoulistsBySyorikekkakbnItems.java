package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * SiharaiDomManagerTest_getSaishigaitoulistsBySyorikekkakbnItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSaishigaitoulistsBySyorikekkakbnItems {

    @Inject
    SiharaiDomManager siharaiDomManager;

    private final static String[] kossyorisscd1 = {"3","4","5"};
    private final static String[] kossyorisscd2 = {"1","3"};
    private final static String[] kossyorisscd3 = {"5","6","7"};
    private final static String[] kossyorisscdB = {""};


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        try (ExDBResults<JT_SateiSyouninRireki> beans =
                siharaiDomManager.getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.BLNK,kossyorisscd2,BizDate.valueOf(20160804),
                        BizDate.valueOf(20160806),C_SaigaiHigaitouKbn.BLNK)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("0001", "11807111118");
        skKihon1.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki1 = skKihon1.createTtdkRireki();
        ttdkRireki1.setTtdkrrkskbtkey("111");
        ttdkRireki1.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki1.setSateisyouninskbtkey("11111");
        ttdkRireki1.setKossyorisscd("1");

        JT_TtdkRireki ttdkRireki4 = skKihon1.createTtdkRireki();
        ttdkRireki4.setTtdkrrkskbtkey("444");
        ttdkRireki4.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki4.setSateisyouninskbtkey("22222");
        ttdkRireki4.setKossyorisscd("1");

        JT_TtdkRireki ttdkRireki5 = skKihon1.createTtdkRireki();
        ttdkRireki5.setTtdkrrkskbtkey("555");
        ttdkRireki5.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki5.setSateisyouninskbtkey("33333");
        ttdkRireki5.setKossyorisscd("1");

        JT_TtdkRireki ttdkRireki6 = skKihon1.createTtdkRireki();
        ttdkRireki6.setTtdkrrkskbtkey("1600");
        ttdkRireki6.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki6.setSateisyouninskbtkey("11111");
        ttdkRireki6.setKossyorisscd("2");

        JT_TtdkRireki ttdkRireki7 = skKihon1.createTtdkRireki();
        ttdkRireki7.setTtdkrrkskbtkey("666");
        ttdkRireki7.setSyoriYmd(BizDate.valueOf(20160803));
        ttdkRireki7.setSateisyouninskbtkey("11111");
        ttdkRireki7.setKossyorisscd("1");

        JT_TtdkRireki ttdkRireki8 = skKihon1.createTtdkRireki();
        ttdkRireki8.setTtdkrrkskbtkey("777");
        ttdkRireki8.setSyoriYmd(BizDate.valueOf(20160807));
        ttdkRireki8.setSateisyouninskbtkey("11111");
        ttdkRireki8.setKossyorisscd("1");

        JT_SateiSyouninRireki sateiSyouninRireki1 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki1.setSateisyouninskbtkey("11111");
        sateiSyouninRireki1.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);

        JT_SateiSyouninRireki sateiSyouninRireki2 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki2.setSateisyouninskbtkey("33333");
        sateiSyouninRireki2.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("0002", "11807111118");
        skKihon2.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki2 = skKihon2.createTtdkRireki();
        ttdkRireki2.setTtdkrrkskbtkey("222");
        ttdkRireki2.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki2.setSateisyouninskbtkey("11111");
        ttdkRireki2.setKossyorisscd("1");

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("0001", "11807111129");
        skKihon3.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki3 = skKihon3.createTtdkRireki();
        ttdkRireki3.setTtdkrrkskbtkey("333");
        ttdkRireki3.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki3.setSateisyouninskbtkey("11111");
        ttdkRireki3.setKossyorisscd("1");

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("0003", "11807111118");
        skKihon4.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("0001", "11807111130");
        skKihon5.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("0007", "11807111222");
        skKihon6.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki9 = skKihon6.createTtdkRireki();
        ttdkRireki9.setTtdkrrkskbtkey("888");
        ttdkRireki9.setSyoriYmd(BizDate.valueOf(20160804));
        ttdkRireki9.setSateisyouninskbtkey("77777");
        ttdkRireki9.setKossyorisscd("5");

        JT_TtdkRireki ttdkRireki10 = skKihon6.createTtdkRireki();
        ttdkRireki10.setTtdkrrkskbtkey("999");
        ttdkRireki10.setSyoriYmd(BizDate.valueOf(20160806));
        ttdkRireki10.setSateisyouninskbtkey("88888");
        ttdkRireki10.setKossyorisscd("6");

        JT_TtdkRireki ttdkRireki11 = skKihon6.createTtdkRireki();
        ttdkRireki11.setTtdkrrkskbtkey("1000");
        ttdkRireki11.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki11.setSateisyouninskbtkey("99999");
        ttdkRireki11.setKossyorisscd("7");

        JT_SateiSyouninRireki sateiSyouninRireki7 = skKihon6.createSateiSyouninRireki();
        sateiSyouninRireki7.setSateisyouninskbtkey("99999");
        sateiSyouninRireki7.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        JT_SateiSyouninRireki sateiSyouninRireki8 = skKihon6.createSateiSyouninRireki();
        sateiSyouninRireki8.setSateisyouninskbtkey("77777");
        sateiSyouninRireki8.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        JT_SateiSyouninRireki sateiSyouninRireki9 = skKihon6.createSateiSyouninRireki();
        sateiSyouninRireki9.setSateisyouninskbtkey("88888");
        sateiSyouninRireki9.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("0007", "11807111233");
        skKihon7.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki12 = skKihon7.createTtdkRireki();
        ttdkRireki12.setTtdkrrkskbtkey("1100");
        ttdkRireki12.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki12.setSateisyouninskbtkey("99999");
        ttdkRireki12.setKossyorisscd("7");

        JT_SateiSyouninRireki sateiSyouninRireki6 = skKihon7.createSateiSyouninRireki();
        sateiSyouninRireki6.setSateisyouninskbtkey("99999");
        sateiSyouninRireki6.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("0007", "11807111244");
        skKihon8.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki13 = skKihon8.createTtdkRireki();
        ttdkRireki13.setTtdkrrkskbtkey("1200");
        ttdkRireki13.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki13.setSateisyouninskbtkey("99999");
        ttdkRireki13.setKossyorisscd("7");

        JT_SateiSyouninRireki sateiSyouninRireki5 = skKihon8.createSateiSyouninRireki();
        sateiSyouninRireki5.setSateisyouninskbtkey("99999");
        sateiSyouninRireki5.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("0008", "11807111211");
        skKihon9.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki14 = skKihon9.createTtdkRireki();
        ttdkRireki14.setTtdkrrkskbtkey("1300");
        ttdkRireki14.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki14.setSateisyouninskbtkey("99999");
        ttdkRireki14.setKossyorisscd("7");

        JT_SateiSyouninRireki sateiSyouninRireki4 = skKihon9.createSateiSyouninRireki();
        sateiSyouninRireki4.setSateisyouninskbtkey("99999");
        sateiSyouninRireki4.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("0009", "11807111244");
        skKihon10.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);

        JT_TtdkRireki ttdkRireki15 = skKihon10.createTtdkRireki();
        ttdkRireki15.setTtdkrrkskbtkey("1400");
        ttdkRireki15.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki15.setSateisyouninskbtkey("99999");
        ttdkRireki15.setKossyorisscd("7");

        JT_SateiSyouninRireki sateiSyouninRireki3 = skKihon10.createSateiSyouninRireki();
        sateiSyouninRireki3.setSateisyouninskbtkey("99999");
        sateiSyouninRireki3.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        siharaiDomManager.insert(skKihon10);

        JT_SkKihon skKihon11 = new JT_SkKihon("0006", "11807111174");
        skKihon11.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.SAIGAIHIGAITOU);

        JT_TtdkRireki ttdkRireki16 = skKihon11.createTtdkRireki();
        ttdkRireki16.setTtdkrrkskbtkey("1500");
        ttdkRireki16.setSyoriYmd(BizDate.valueOf(20160805));
        ttdkRireki16.setSateisyouninskbtkey("55555");
        ttdkRireki16.setKossyorisscd("1");

        JT_SateiSyouninRireki sateiSyouninRireki10 = skKihon11.createSateiSyouninRireki();
        sateiSyouninRireki10.setSateisyouninskbtkey("55555");
        sateiSyouninRireki10.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_2);

        siharaiDomManager.insert(skKihon11);

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

        try (ExDBResults<JT_SateiSyouninRireki> beans =
                siharaiDomManager.getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.BLNK,kossyorisscd1,BizDate.valueOf(20160804),
                        BizDate.valueOf(20160806),C_SaigaiHigaitouKbn.BLNK)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        ExDBResults<JT_SateiSyouninRireki> beans = siharaiDomManager.getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.BLNK,kossyorisscd2,BizDate.valueOf(20160804),
                BizDate.valueOf(20160806),C_SaigaiHigaitouKbn.BLNK);

        int iCount = 0;
        for (JT_SateiSyouninRireki sateiSyouninRireki : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("0001", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111118", sateiSyouninRireki.getSyono());
                Assert.assertEquals("11111", sateiSyouninRireki.getSateisyouninskbtkey());
            }
        }

        Assert.assertEquals(1, iCount);
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        ExDBResults<JT_SateiSyouninRireki> beans = siharaiDomManager.getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.TENSOU_TENKEN_2,kossyorisscd3,BizDate.valueOf(20160804),
                BizDate.valueOf(20160806),C_SaigaiHigaitouKbn.BLNK);

        int iCount = 0;
        for (JT_SateiSyouninRireki sateiSyouninRireki : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("0007", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111222", sateiSyouninRireki.getSyono());
                Assert.assertEquals("99999", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (2 == iCount) {
                Assert.assertEquals("0007", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111222", sateiSyouninRireki.getSyono());
                Assert.assertEquals("88888", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (3 == iCount) {
                Assert.assertEquals("0007", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111222", sateiSyouninRireki.getSyono());
                Assert.assertEquals("77777", sateiSyouninRireki.getSateisyouninskbtkey());
            }
            if (4 == iCount) {
                Assert.assertEquals("0007", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111233", sateiSyouninRireki.getSyono());
                Assert.assertEquals("99999", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (5 == iCount) {
                Assert.assertEquals("0007", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111244", sateiSyouninRireki.getSyono());
                Assert.assertEquals("99999", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (6 == iCount) {
                Assert.assertEquals("0008", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111211", sateiSyouninRireki.getSyono());
                Assert.assertEquals("99999", sateiSyouninRireki.getSateisyouninskbtkey());
            }
            if (7 == iCount) {
                Assert.assertEquals("0009", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111244", sateiSyouninRireki.getSyono());
                Assert.assertEquals("99999", sateiSyouninRireki.getSateisyouninskbtkey());
            }
        }
        Assert.assertEquals(7, iCount);
    }
    @Test
    @TestOrder(40)
    public void blankCondition(){

        try (ExDBResults<JT_SateiSyouninRireki> beans =
                siharaiDomManager.getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn.BLNK,kossyorisscdB,BizDate.valueOf(20160804),
                        BizDate.valueOf(20160806),C_SaigaiHigaitouKbn.BLNK)){

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }
}
