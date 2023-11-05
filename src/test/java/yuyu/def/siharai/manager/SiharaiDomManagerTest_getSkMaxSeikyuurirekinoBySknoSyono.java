package yuyu.def.siharai.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSkMaxSeikyuurirekinoBySknoSyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkMaxSeikyuurirekinoBySknoSyono {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        Integer MaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono("ASD123","10000000060");
        Assert.assertEquals(null,MaxSeikyuurirekino);

        JT_SkKihon skKihon1 = new JT_SkKihon("ASD123", "10000000060");

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(1);

        JT_Sk sk4 = skKihon1.createSk();
        sk4.setSeikyuurirekino(4);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("ASD124", "10000000060");

        JT_Sk sk2 = skKihon2.createSk();
        sk2.setSeikyuurirekino(5);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("ASD123", "10000000070");

        JT_Sk sk3 = skKihon3.createSk();
        sk3.setSeikyuurirekino(6);

        siharaiDomManager.insert(skKihon3);

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

        Integer MaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono("ASD123","10000000080");
        Assert.assertEquals(null,MaxSeikyuurirekino);

    }

    @Test
    @TestOrder(20)
    public void blank1() {

        Integer MaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono("","10000000060");
        Assert.assertEquals(null,MaxSeikyuurirekino);

    }

    @Test
    @TestOrder(30)
    public void blank2() {

        Integer MaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono("ASD123","");
        Assert.assertEquals(null,MaxSeikyuurirekino);

    }

    @Test
    @TestOrder(40)
    public void normal1() {

        Integer MaxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono("ASD123","10000000060");
        Assert.assertEquals(Integer.valueOf(4),MaxSeikyuurirekino);
    }
}
