package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 死亡仮受付テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SibouKariuketsukeEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        jT_SkKihon1.createSibouKariuketsuke();

        siharaiDomManager.insert(jT_SkKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);

        siharaiDomManager.delete(jT_SkKihon1);
    }

    @Test
    @TestOrder(10)
    public void getSkKihon() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        JT_SibouKariuketsuke JT_SibouKariuketsuke1 = jT_SkKihon1.getSibouKariuketsuke();
        JT_SkKihon jT_SkKihon2 = JT_SibouKariuketsuke1.getSkKihon();
        Assert.assertEquals(pSyono1, jT_SkKihon2.getSyono());
        Assert.assertEquals(pSkno1, jT_SkKihon2.getSkno());
    }
}
