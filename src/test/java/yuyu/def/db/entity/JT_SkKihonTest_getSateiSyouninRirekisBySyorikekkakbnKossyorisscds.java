package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定承認履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSateiSyouninRirekisBySyorikekkakbnKossyorisscds {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private final static String[] kossyorisscd1 = {"K001"};
    private final static String[] kossyorisscd2 = {"K003", "K004"};
    private final static String[] kossyorisscd3 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon skKihon1 = siharaiDomManager.getSkKihon("10000000001", "11807111118");
        if (skKihon1 == null) {
            skKihon1 = new JT_SkKihon("10000000001", "11807111118");
            Assert.assertEquals(0, skKihon1.getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn.BLNK, kossyorisscd1).size());

            JT_SateiSyouninRireki sateiSyouninRireki1 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki1.setSateisyouninskbtkey("201520161001");
            sateiSyouninRireki1.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
            sateiSyouninRireki1.setKossyorisscd("K001");

            JT_SateiSyouninRireki sateiSyouninRireki2 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki2.setSateisyouninskbtkey("201520161002");
            sateiSyouninRireki2.setSyorikekkakbn(C_SyorikekkaKbn.HORYUU);
            sateiSyouninRireki2.setKossyorisscd("K001");

            JT_SateiSyouninRireki sateiSyouninRireki3 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki3.setSateisyouninskbtkey("201520161003");
            sateiSyouninRireki3.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
            sateiSyouninRireki3.setKossyorisscd("K002");

            siharaiDomManager.insert(skKihon1);
        }

        JT_SkKihon skKihon2 = siharaiDomManager.getSkKihon("10000000002", "11807111129");
        if (skKihon2 == null) {
            skKihon2 = new JT_SkKihon("10000000002", "11807111129");

            JT_SateiSyouninRireki sateiSyouninRireki4 = skKihon2.createSateiSyouninRireki();
            sateiSyouninRireki4.setSateisyouninskbtkey("201520161006");
            sateiSyouninRireki4.setSyorikekkakbn(C_SyorikekkaKbn.HUBI);
            sateiSyouninRireki4.setKossyorisscd("K003");

            JT_SateiSyouninRireki sateiSyouninRireki5 = skKihon2.createSateiSyouninRireki();
            sateiSyouninRireki5.setSateisyouninskbtkey("201520161005");
            sateiSyouninRireki5.setSyorikekkakbn(C_SyorikekkaKbn.HUBI);
            sateiSyouninRireki5.setKossyorisscd("K004");

            JT_SateiSyouninRireki sateiSyouninRireki6 = skKihon2.createSateiSyouninRireki();
            sateiSyouninRireki6.setSateisyouninskbtkey("201520161004");
            sateiSyouninRireki6.setSyorikekkakbn(C_SyorikekkaKbn.HUBI);
            sateiSyouninRireki6.setKossyorisscd("K003");

            siharaiDomManager.insert(skKihon2);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        JT_SkKihon SkKihon = siharaiDomManager.getSkKihon("10000000001", "11807111118");
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn.HUSYOUNIN, kossyorisscd1);

        Assert.assertEquals(0, sateiSyouninRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        JT_SkKihon SkKihon = siharaiDomManager.getSkKihon("10000000001", "11807111118");
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn.BLNK, kossyorisscd1);

        Assert.assertEquals(1, sateiSyouninRirekiList.size());

        Assert.assertEquals("10000000001", sateiSyouninRirekiList.get(0).getSkno());
        Assert.assertEquals("11807111118", sateiSyouninRirekiList.get(0).getSyono());
        Assert.assertEquals("201520161001", sateiSyouninRirekiList.get(0).getSateisyouninskbtkey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        JT_SkKihon SkKihon = siharaiDomManager.getSkKihon("10000000002", "11807111129");
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn.HUBI, kossyorisscd2);

        Assert.assertEquals(3, sateiSyouninRirekiList.size());

        Assert.assertEquals("10000000002", sateiSyouninRirekiList.get(0).getSkno());
        Assert.assertEquals("11807111129", sateiSyouninRirekiList.get(0).getSyono());
        Assert.assertEquals("201520161004", sateiSyouninRirekiList.get(0).getSateisyouninskbtkey());

        Assert.assertEquals("10000000002", sateiSyouninRirekiList.get(1).getSkno());
        Assert.assertEquals("11807111129", sateiSyouninRirekiList.get(1).getSyono());
        Assert.assertEquals("201520161005", sateiSyouninRirekiList.get(1).getSateisyouninskbtkey());

        Assert.assertEquals("10000000002", sateiSyouninRirekiList.get(2).getSkno());
        Assert.assertEquals("11807111129", sateiSyouninRirekiList.get(2).getSyono());
        Assert.assertEquals("201520161006", sateiSyouninRirekiList.get(2).getSateisyouninskbtkey());

    }

    @Test
    @TestOrder(40)
    public void blank() {
        JT_SkKihon SkKihon = siharaiDomManager.getSkKihon("10000000002", "11807111129");
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn.HUBI, kossyorisscd3);

        Assert.assertEquals(0, sateiSyouninRirekiList.size());
    }
}
