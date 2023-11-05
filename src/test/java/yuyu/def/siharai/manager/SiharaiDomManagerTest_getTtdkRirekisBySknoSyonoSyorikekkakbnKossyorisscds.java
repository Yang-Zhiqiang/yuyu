package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

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
 * getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds {

    @Inject
    SiharaiDomManager siharaiDomManager;

    private final static String[] kossyorisscd1 = {"qwert","asdfg"};
    private final static String[] kossyorisscd2 = {"12345","qdvfr"};
    private final static String[] kossyorisscd3 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds("11807", "11807111118", C_SyorikekkaKbn.TENSOU, kossyorisscd1);

        Assert.assertEquals(null,ttdkRireki);

        JT_SkKihon skKihon1 = new JT_SkKihon("11807", "11807111118");

        JT_TtdkRireki ttdkRireki1 = skKihon1.createTtdkRireki();
        ttdkRireki1.setTtdkrrkskbtkey("5000");
        ttdkRireki1.setSateisyouninskbtkey("C100");

        JT_TtdkRireki ttdkRireki4 = skKihon1.createTtdkRireki();
        ttdkRireki4.setTtdkrrkskbtkey("5003");
        ttdkRireki4.setSateisyouninskbtkey("C200");

        JT_TtdkRireki ttdkRireki7 = skKihon1.createTtdkRireki();
        ttdkRireki7.setTtdkrrkskbtkey("5006");
        ttdkRireki7.setSateisyouninskbtkey("C300");

        JT_TtdkRireki ttdkRireki8 = skKihon1.createTtdkRireki();
        ttdkRireki8.setTtdkrrkskbtkey("1000");
        ttdkRireki8.setSateisyouninskbtkey("C150");

        JT_SateiSyouninRireki sateiSyouninRireki1 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki1.setSateisyouninskbtkey("C100");
        sateiSyouninRireki1.setSyorikekkakbn(C_SyorikekkaKbn.valueOf("110"));
        sateiSyouninRireki1.setKossyorisscd("qwert");

        JT_SateiSyouninRireki sateiSyouninRireki4 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki4.setSateisyouninskbtkey("C300");
        sateiSyouninRireki4.setSyorikekkakbn(C_SyorikekkaKbn.valueOf("510"));
        sateiSyouninRireki4.setKossyorisscd("qwert");

        JT_SateiSyouninRireki sateiSyouninRireki5 = skKihon1.createSateiSyouninRireki();
        sateiSyouninRireki5.setSateisyouninskbtkey("C150");
        sateiSyouninRireki5.setSyorikekkakbn(C_SyorikekkaKbn.valueOf("110"));
        sateiSyouninRireki5.setKossyorisscd("asdfg");

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("11807", "11807111129");

        JT_TtdkRireki ttdkRireki2 = skKihon2.createTtdkRireki();
        ttdkRireki2.setTtdkrrkskbtkey("5001");
        ttdkRireki2.setSateisyouninskbtkey("C100");

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("11806", "11807111118");

        JT_TtdkRireki ttdkRireki3 = skKihon3.createTtdkRireki();
        ttdkRireki3.setTtdkrrkskbtkey("5002");
        ttdkRireki3.setSateisyouninskbtkey("C100");

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("11807", "11807111130");

        JT_TtdkRireki ttdkRireki5 = skKihon4.createTtdkRireki();
        ttdkRireki5.setTtdkrrkskbtkey("5004");
        ttdkRireki5.setSateisyouninskbtkey("C100");

        JT_SateiSyouninRireki sateiSyouninRireki2 = skKihon4.createSateiSyouninRireki();
        sateiSyouninRireki2.setSateisyouninskbtkey("C100");
        sateiSyouninRireki2.setSyorikekkakbn(C_SyorikekkaKbn.valueOf("110"));
        sateiSyouninRireki2.setKossyorisscd("qwert");

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("11805", "11807111118");

        JT_TtdkRireki ttdkRireki6 = skKihon5.createTtdkRireki();
        ttdkRireki6.setTtdkrrkskbtkey("5005");
        ttdkRireki6.setSateisyouninskbtkey("C100");

        JT_SateiSyouninRireki sateiSyouninRireki3 = skKihon5.createSateiSyouninRireki();
        sateiSyouninRireki3.setSateisyouninskbtkey("C100");
        sateiSyouninRireki3.setSyorikekkakbn(C_SyorikekkaKbn.valueOf("110"));
        sateiSyouninRireki3.setKossyorisscd("qwert");

        siharaiDomManager.insert(skKihon5);

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

        JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds("11807", "11807111118", C_SyorikekkaKbn.TENSOU, kossyorisscd2);

        Assert.assertEquals(null,ttdkRireki);
    }

    @Test
    @TestOrder(20)
    public void blankCondition1(){

        JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds("", "11807111118", C_SyorikekkaKbn.TENSOU, kossyorisscd1);

        Assert.assertEquals(null,ttdkRireki);
    }

    @Test
    @TestOrder(30)
    public void blankCondition2(){

        JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds("11807", "", C_SyorikekkaKbn.TENSOU, kossyorisscd1);

        Assert.assertEquals(null,ttdkRireki);
    }

    @Test
    @TestOrder(40)
    public void blankCondition3(){

        JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds("11807", "11807111118", C_SyorikekkaKbn.TENSOU, kossyorisscd3);

        Assert.assertEquals(null,ttdkRireki);
    }

    @Test
    @TestOrder(50)
    public void normal1(){

        JT_TtdkRireki ttdkRireki = siharaiDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds("11807", "11807111118", C_SyorikekkaKbn.TENSOU, kossyorisscd1);

        Assert.assertEquals("11807",ttdkRireki.getSkno());
        Assert.assertEquals("11807111118",ttdkRireki.getSyono());
        Assert.assertEquals("5000",ttdkRireki.getTtdkrrkskbtkey());
    }

}
