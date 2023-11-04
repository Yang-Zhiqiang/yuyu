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

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定承認履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSateiSyouninRirekisBySeikyuurirekino {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon skKihon1 = siharaiDomManager.getSkKihon("10000000001", "11807111118");
        if (skKihon1 == null) {
            skKihon1 = new JT_SkKihon("10000000001", "11807111118");
            Assert.assertEquals(0, skKihon1.getSateiSyouninRirekisBySeikyuurirekino(101).size());

            JT_SateiSyouninRireki sateiSyouninRireki1 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki1.setSateisyouninskbtkey("201520161001");
            sateiSyouninRireki1.setSeikyuurirekino(101);

            JT_SateiSyouninRireki sateiSyouninRireki2 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki2.setSateisyouninskbtkey("201520161002");
            sateiSyouninRireki2.setSeikyuurirekino(102);

            siharaiDomManager.insert(skKihon1);
        }

        JT_SkKihon skKihon2 = new JT_SkKihon("10000000002", "11807111129");

        JT_SateiSyouninRireki sateiSyouninRireki3 = skKihon2.createSateiSyouninRireki();
        sateiSyouninRireki3.setSateisyouninskbtkey("201520161003");
        sateiSyouninRireki3.setSeikyuurirekino(103);

        JT_SateiSyouninRireki sateiSyouninRireki4 = skKihon2.createSateiSyouninRireki();
        sateiSyouninRireki4.setSateisyouninskbtkey("201520161004");
        sateiSyouninRireki4.setSeikyuurirekino(103);

        JT_SateiSyouninRireki sateiSyouninRireki5 = skKihon2.createSateiSyouninRireki();
        sateiSyouninRireki5.setSateisyouninskbtkey("201520161005");
        sateiSyouninRireki5.setSeikyuurirekino(103);

        siharaiDomManager.insert(skKihon2);
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
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySeikyuurirekino(104);

        Assert.assertEquals(0, sateiSyouninRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        JT_SkKihon SkKihon = siharaiDomManager.getSkKihon("10000000001", "11807111118");
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySeikyuurirekino(101);

        Assert.assertEquals(1, sateiSyouninRirekiList.size());

        Assert.assertEquals("10000000001", sateiSyouninRirekiList.get(0).getSkno());
        Assert.assertEquals("11807111118", sateiSyouninRirekiList.get(0).getSyono());
        Assert.assertEquals("201520161001", sateiSyouninRirekiList.get(0).getSateisyouninskbtkey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        JT_SkKihon SkKihon = siharaiDomManager.getSkKihon("10000000002", "11807111129");
        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = SkKihon.getSateiSyouninRirekisBySeikyuurirekino(103);

        Assert.assertEquals(3, sateiSyouninRirekiList.size());

        Assert.assertEquals("10000000002", sateiSyouninRirekiList.get(0).getSkno());
        Assert.assertEquals("11807111129", sateiSyouninRirekiList.get(0).getSyono());
        Assert.assertEquals("201520161003", sateiSyouninRirekiList.get(0).getSateisyouninskbtkey());

        Assert.assertEquals("10000000002", sateiSyouninRirekiList.get(1).getSkno());
        Assert.assertEquals("11807111129", sateiSyouninRirekiList.get(1).getSyono());
        Assert.assertEquals("201520161004", sateiSyouninRirekiList.get(1).getSateisyouninskbtkey());

        Assert.assertEquals("10000000002", sateiSyouninRirekiList.get(2).getSkno());
        Assert.assertEquals("11807111129", sateiSyouninRirekiList.get(2).getSyono());
        Assert.assertEquals("201520161005", sateiSyouninRirekiList.get(2).getSateisyouninskbtkey());

    }
}
