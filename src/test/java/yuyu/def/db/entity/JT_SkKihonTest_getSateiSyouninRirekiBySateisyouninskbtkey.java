package yuyu.def.db.entity;

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
public class JT_SkKihonTest_getSateiSyouninRirekiBySateisyouninskbtkey {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon("ASD120","10000000060");
        if (skKihon == null) {
            skKihon = new JT_SkKihon("ASD120","10000000060");

            JT_SateiSyouninRireki sateiSyouninRireki = skKihon.getSateiSyouninRirekiBySateisyouninskbtkey("SNK123");
            Assert.assertEquals(null, sateiSyouninRireki);

            JT_SkKihon skKihon1 = new JT_SkKihon("ASD120", "10000000060");

            JT_SateiSyouninRireki sateiSyouninRireki1 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki1.setSateisyouninskbtkey("SNK123");

            JT_SateiSyouninRireki sateiSyouninRireki2 = skKihon1.createSateiSyouninRireki();
            sateiSyouninRireki2.setSateisyouninskbtkey("SNK124");

            siharaiDomManager.insert(skKihon1);
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
        JT_SkKihon skKihon = siharaiDomManager.getSkKihon("ASD120","10000000060");

        JT_SateiSyouninRireki sateiSyouninRireki = skKihon.getSateiSyouninRirekiBySateisyouninskbtkey("SNK125");
        Assert.assertEquals(null, sateiSyouninRireki);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        JT_SkKihon skKihon = siharaiDomManager.getSkKihon("ASD120","10000000060");

        JT_SateiSyouninRireki sateiSyouninRireki = skKihon.getSateiSyouninRirekiBySateisyouninskbtkey("SNK123");

        Assert.assertEquals("ASD120", sateiSyouninRireki.getSkno());
        Assert.assertEquals("10000000060", sateiSyouninRireki.getSyono());
        Assert.assertEquals("SNK123", sateiSyouninRireki.getSateisyouninskbtkey());
    }

    @Test
    @TestOrder(30)
    public void blank() {
        JT_SkKihon skKihon = siharaiDomManager.getSkKihon("ASD120","10000000060");

        JT_SateiSyouninRireki sateiSyouninRireki = skKihon.getSateiSyouninRirekiBySateisyouninskbtkey("");
        Assert.assertEquals(null, sateiSyouninRireki);
    }
}
