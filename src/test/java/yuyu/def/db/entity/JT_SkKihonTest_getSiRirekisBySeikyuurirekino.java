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
 * 支払履歴テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSiRirekisBySeikyuurirekino {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private final static String skno1 = "sk101";
    private final static String skno2 = "sk102";

    private final static String syono1 = "11807111118";

    private final static Integer seikyuurirekino1 = 101;
    private final static Integer seikyuurirekino2 = 102;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        JT_SkKihon skKihon1 = siharaiDomManager.getSkKihon(skno1, syono1);
        if (skKihon1 == null) {
            skKihon1 = new JT_SkKihon(skno1, syono1);

            List<JT_SiRireki> siRirekiLst = skKihon1.getSiRirekisBySeikyuurirekino(seikyuurirekino1);
            Assert.assertEquals(0, siRirekiLst.size());

            JT_SiRireki siRireki1 = skKihon1.createSiRireki();
            siRireki1.setShrsikibetukey("1001");
            siRireki1.setSeikyuurirekino(seikyuurirekino2);

            JT_SiRireki siRireki2 = skKihon1.createSiRireki();
            siRireki2.setShrsikibetukey("1002");
            siRireki2.setSeikyuurirekino(seikyuurirekino1);

            JT_SiRireki siRireki3 = skKihon1.createSiRireki();
            siRireki3.setShrsikibetukey("1003");
            siRireki3.setSeikyuurirekino(seikyuurirekino1);

            JT_SiRireki siRireki4 = skKihon1.createSiRireki();
            siRireki4.setShrsikibetukey("1004");
            siRireki4.setSeikyuurirekino(seikyuurirekino1);

            siharaiDomManager.insert(skKihon1);
        }
        JT_SkKihon skKihon2 = siharaiDomManager.getSkKihon(skno2, syono1);
        if (skKihon2 == null) {
            skKihon2 = new JT_SkKihon(skno2, syono1);
            JT_SiRireki siRireki1 = skKihon2.createSiRireki();
            siRireki1.setShrsikibetukey("1001");
            siRireki1.setSeikyuurirekino(seikyuurirekino1);
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
        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSkKihon(skno2, syono1).getSiRirekisBySeikyuurirekino(seikyuurirekino2);
        Assert.assertEquals(0, siRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSkKihon(skno1, syono1).getSiRirekisBySeikyuurirekino(seikyuurirekino2);
        Assert.assertEquals(1, siRirekiLst.size());

        Assert.assertEquals(skno1, siRirekiLst.get(0).getSkno());
        Assert.assertEquals(syono1, siRirekiLst.get(0).getSyono());
        Assert.assertEquals("1001", siRirekiLst.get(0).getShrsikibetukey());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<JT_SiRireki> siRirekiLst = siharaiDomManager.getSkKihon(skno1, syono1).getSiRirekisBySeikyuurirekino(seikyuurirekino1);
        Assert.assertEquals(3, siRirekiLst.size());

        Assert.assertEquals(skno1, siRirekiLst.get(0).getSkno());
        Assert.assertEquals(syono1, siRirekiLst.get(0).getSyono());
        Assert.assertEquals("1002", siRirekiLst.get(0).getShrsikibetukey());

        Assert.assertEquals(skno1, siRirekiLst.get(1).getSkno());
        Assert.assertEquals(syono1, siRirekiLst.get(1).getSyono());
        Assert.assertEquals("1003", siRirekiLst.get(1).getShrsikibetukey());

        Assert.assertEquals(skno1, siRirekiLst.get(2).getSkno());
        Assert.assertEquals(syono1, siRirekiLst.get(2).getSyono());
        Assert.assertEquals("1004", siRirekiLst.get(2).getShrsikibetukey());
    }
}

