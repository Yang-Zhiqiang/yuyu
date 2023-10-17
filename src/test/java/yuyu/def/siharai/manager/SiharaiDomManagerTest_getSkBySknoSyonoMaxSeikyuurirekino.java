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
 * getSkBySknoSyonoMaxSeikyuurirekino() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkBySknoSyonoMaxSeikyuurirekino {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_Sk sk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("10000000001","10000000010");
        Assert.assertEquals(null, sk);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon("10000000001","10000000010");
        if (skKihon == null) {
            skKihon = new JT_SkKihon("10000000001","10000000010");

            JT_Sk sk4 = skKihon.createSk();
            sk4.setSeikyuurirekino(101);

            siharaiDomManager.insert(skKihon);
        }

        JT_SkKihon skKihon2 = siharaiDomManager.getSkKihon("10000000002","10000000011");
        if (skKihon2 == null) {
            skKihon2 = new JT_SkKihon("10000000002","10000000011");

            JT_Sk sk1 = skKihon2.createSk();
            sk1.setSeikyuurirekino(101);

            JT_Sk sk2 = skKihon2.createSk();
            sk2.setSeikyuurirekino(102);

            JT_Sk sk3 = skKihon2.createSk();
            sk3.setSeikyuurirekino(103);

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

        JT_Sk sk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("10000000003","10000000010");
        Assert.assertEquals(null, sk);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_Sk sk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("10000000002","10000000011");
        Assert.assertEquals("10000000002", sk.getSkno());
        Assert.assertEquals("10000000011", sk.getSyono());
        Assert.assertEquals(103, sk.getSeikyuurirekino().intValue());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        JT_Sk sk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("","10000000010");
        Assert.assertEquals(null, sk);

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        JT_Sk sk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("10000000001","");
        Assert.assertEquals(null, sk);

    }

}