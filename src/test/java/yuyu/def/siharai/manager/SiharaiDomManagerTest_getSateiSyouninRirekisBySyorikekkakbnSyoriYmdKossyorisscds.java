package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds {

    @Inject
    SiharaiDomManager siharaiDomManager;

    private final static String[] dSyukouteikanriid1 = {"M1000000001","M1000000006"};
    private final static String[] dSyukouteikanriid2 = {"M1000000003","M1000000004", "M1000000005"};
    private final static String[] dSyukouteikanriid3 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        try (ExDBResults<JT_SateiSyouninRireki> beans =
                siharaiDomManager.getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn.BLNK, BizDate.valueOf(20160214), BizDate.valueOf(20160216), dSyukouteikanriid1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("10000000001", "11807111118");

        JT_SateiSyouninRireki sateiSyouninRireki1 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki1.setSateisyouninskbtkey("201520161001");
        sateiSyouninRireki1.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);

        JT_SateiSyouninRireki sateiSyouninRireki2 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki2.setSateisyouninskbtkey("201520161002");
        sateiSyouninRireki2.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);

        JT_SateiSyouninRireki sateiSyouninRireki3 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki3.setSateisyouninskbtkey("201520161003");
        sateiSyouninRireki3.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);

        JT_TtdkRireki ttdkRireki1 = skKihon1.createTtdkRireki();
        ttdkRireki1.setTtdkrrkskbtkey("201520162001");
        ttdkRireki1.setSyoriYmd(BizDate.valueOf(20160215));
        ttdkRireki1.setSateisyouninskbtkey("201520161001");
        ttdkRireki1.setKossyorisscd("M1000000001");

        JT_TtdkRireki ttdkRireki4 = skKihon1.createTtdkRireki();
        ttdkRireki4.setTtdkrrkskbtkey("201520162002");
        ttdkRireki4.setSyoriYmd(BizDate.valueOf(20160215));
        ttdkRireki4.setSateisyouninskbtkey("201520161003");
        ttdkRireki4.setKossyorisscd("M1000000001");

        JT_TtdkRireki ttdkRireki5 = skKihon1.createTtdkRireki();
        ttdkRireki5.setTtdkrrkskbtkey("201520162003");
        ttdkRireki5.setSyoriYmd(BizDate.valueOf(20160215));
        ttdkRireki5.setSateisyouninskbtkey("201520161001");
        ttdkRireki5.setKossyorisscd("M1000000002");

        JT_TtdkRireki ttdkRireki6 = skKihon1.createTtdkRireki();
        ttdkRireki6.setTtdkrrkskbtkey("201520162004");
        ttdkRireki6.setSyoriYmd(BizDate.valueOf(20160213));
        ttdkRireki6.setSateisyouninskbtkey("201520161001");
        ttdkRireki6.setKossyorisscd("M1000000001");

        JT_TtdkRireki ttdkRireki7 = skKihon1.createTtdkRireki();
        ttdkRireki7.setTtdkrrkskbtkey("201520162012");
        ttdkRireki7.setSyoriYmd(BizDate.valueOf(20160217));
        ttdkRireki7.setSateisyouninskbtkey("201520161001");
        ttdkRireki7.setKossyorisscd("M1000000001");

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("10000000002", "11807111118");

        JT_TtdkRireki ttdkRireki2 = skKihon2.createTtdkRireki();
        ttdkRireki2.setTtdkrrkskbtkey("201520162001");
        ttdkRireki2.setSyoriYmd(BizDate.valueOf(20160215));
        ttdkRireki2.setSateisyouninskbtkey("201520161001");
        ttdkRireki2.setKossyorisscd("M1000000001");

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("10000000001", "11807111129");

        JT_TtdkRireki ttdkRireki3 = skKihon3.createTtdkRireki();
        ttdkRireki3.setTtdkrrkskbtkey("201520162001");
        ttdkRireki3.setSyoriYmd(BizDate.valueOf(20160215));
        ttdkRireki3.setSateisyouninskbtkey("201520161001");
        ttdkRireki3.setKossyorisscd("M1000000001");

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("10000000003", "11807111152");

        JT_SateiSyouninRireki sateiSyouninRireki4 = skKihon4.createSateiSyouninRireki();
        sateiSyouninRireki4.setSateisyouninskbtkey("201520161004");
        sateiSyouninRireki4.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_TtdkRireki ttdkRireki8 = skKihon4.createTtdkRireki();
        ttdkRireki8.setTtdkrrkskbtkey("201520162005");
        ttdkRireki8.setSyoriYmd(BizDate.valueOf(20160218));
        ttdkRireki8.setSateisyouninskbtkey("201520161004");
        ttdkRireki8.setKossyorisscd("M1000000003");

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("10000000004", "11807111130");

        JT_SateiSyouninRireki sateiSyouninRireki6 = skKihon5.createSateiSyouninRireki();
        sateiSyouninRireki6.setSateisyouninskbtkey("201520161006");
        sateiSyouninRireki6.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_TtdkRireki ttdkRireki10 = skKihon5.createTtdkRireki();
        ttdkRireki10.setTtdkrrkskbtkey("201520162007");
        ttdkRireki10.setSyoriYmd(BizDate.valueOf(20160219));
        ttdkRireki10.setSateisyouninskbtkey("201520161006");
        ttdkRireki10.setKossyorisscd("M1000000005");

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("10000000005", "11807111130");

        JT_SateiSyouninRireki sateiSyouninRireki5 = skKihon6.createSateiSyouninRireki();
        sateiSyouninRireki5.setSateisyouninskbtkey("201520161004");
        sateiSyouninRireki5.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_TtdkRireki ttdkRireki9 = skKihon6.createTtdkRireki();
        ttdkRireki9.setTtdkrrkskbtkey("201520162006");
        ttdkRireki9.setSyoriYmd(BizDate.valueOf(20160220));
        ttdkRireki9.setSateisyouninskbtkey("201520161004");
        ttdkRireki9.setKossyorisscd("M1000000004");

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("10000000005", "11807111141");

        JT_SateiSyouninRireki sateiSyouninRireki8 = skKihon7.createSateiSyouninRireki();
        sateiSyouninRireki8.setSateisyouninskbtkey("201520161004");
        sateiSyouninRireki8.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_TtdkRireki ttdkRireki12 = skKihon7.createTtdkRireki();
        ttdkRireki12.setTtdkrrkskbtkey("201520162009");
        ttdkRireki12.setSyoriYmd(BizDate.valueOf(20160224));
        ttdkRireki12.setSateisyouninskbtkey("201520161004");
        ttdkRireki12.setKossyorisscd("M1000000004");

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("10000000005", "11807111152");

        JT_SateiSyouninRireki sateiSyouninRireki7 = skKihon8.createSateiSyouninRireki();
        sateiSyouninRireki7.setSateisyouninskbtkey("201520161004");
        sateiSyouninRireki7.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_SateiSyouninRireki sateiSyouninRireki9 = skKihon8.createSateiSyouninRireki();
        sateiSyouninRireki9.setSateisyouninskbtkey("201520161006");
        sateiSyouninRireki9.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_SateiSyouninRireki sateiSyouninRireki10 = skKihon8.createSateiSyouninRireki();
        sateiSyouninRireki10.setSateisyouninskbtkey("201520161005");
        sateiSyouninRireki10.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);

        JT_TtdkRireki ttdkRireki11 = skKihon8.createTtdkRireki();
        ttdkRireki11.setTtdkrrkskbtkey("201520162008");
        ttdkRireki11.setSyoriYmd(BizDate.valueOf(20160222));
        ttdkRireki11.setSateisyouninskbtkey("201520161004");
        ttdkRireki11.setKossyorisscd("M1000000003");

        JT_TtdkRireki ttdkRireki13 = skKihon8.createTtdkRireki();
        ttdkRireki13.setTtdkrrkskbtkey("201520162010");
        ttdkRireki13.setSyoriYmd(BizDate.valueOf(20160221));
        ttdkRireki13.setSateisyouninskbtkey("201520161006");
        ttdkRireki13.setKossyorisscd("M1000000005");

        JT_TtdkRireki ttdkRireki14 = skKihon8.createTtdkRireki();
        ttdkRireki14.setTtdkrrkskbtkey("201520162011");
        ttdkRireki14.setSyoriYmd(BizDate.valueOf(20160225));
        ttdkRireki14.setSateisyouninskbtkey("201520161005");
        ttdkRireki14.setKossyorisscd("M1000000005");

        siharaiDomManager.insert(skKihon8);
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
                siharaiDomManager.getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn.TENSOU, BizDate.valueOf(20160202), BizDate.valueOf(20160213), dSyukouteikanriid1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        ExDBResults<JT_SateiSyouninRireki> beans = siharaiDomManager
                .getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn.BLNK, BizDate.valueOf(20160214), BizDate.valueOf(20160216), dSyukouteikanriid1);

        int iCount = 0;
        for (JT_SateiSyouninRireki sateiSyouninRireki : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("10000000001", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111118", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161001", sateiSyouninRireki.getSateisyouninskbtkey());
            }
        }

        Assert.assertEquals(1, iCount);
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        ExDBResults<JT_SateiSyouninRireki> beans = siharaiDomManager
                .getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn.TENSOU_TENKEN_1, BizDate.valueOf(20160218), BizDate.valueOf(20160225), dSyukouteikanriid2);

        int iCount = 0;
        for (JT_SateiSyouninRireki sateiSyouninRireki : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("10000000003", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111152", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161004", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (2 == iCount) {
                Assert.assertEquals("10000000004", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111130", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161006", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (3 == iCount) {
                Assert.assertEquals("10000000005", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111130", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161004", sateiSyouninRireki.getSateisyouninskbtkey());
            }
            if (4 == iCount) {
                Assert.assertEquals("10000000005", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111141", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161004", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (5 == iCount) {
                Assert.assertEquals("10000000005", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111152", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161006", sateiSyouninRireki.getSateisyouninskbtkey());
            }

            if (6 == iCount) {
                Assert.assertEquals("10000000005", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111152", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161005", sateiSyouninRireki.getSateisyouninskbtkey());
            }
            if (7 == iCount) {
                Assert.assertEquals("10000000005", sateiSyouninRireki.getSkno());
                Assert.assertEquals("11807111152", sateiSyouninRireki.getSyono());
                Assert.assertEquals("201520161004", sateiSyouninRireki.getSateisyouninskbtkey());
            }
        }
        Assert.assertEquals(7, iCount);
    }
    @Test
    @TestOrder(40)
    public void noResult2(){

        try (ExDBResults<JT_SateiSyouninRireki> beans =
                siharaiDomManager.getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn.BLNK, BizDate.valueOf(20160214), BizDate.valueOf(20160216), dSyukouteikanriid3)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

    }
}
