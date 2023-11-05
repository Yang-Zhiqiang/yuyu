package yuyu.def.db.entity;

import java.util.List;

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
 * 高度障害状態該当可否テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_KoudosgJytGtKahiEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        Integer pSeikyuurirekino = 111;

        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(pSeikyuurirekino);

        JT_KoudosgJytGtKahi jT_KoudosgJytGtKahi1 = jT_Sk1.createKoudosgJytGtKahi();
        jT_KoudosgJytGtKahi1.setSeikyuurirekino(pSeikyuurirekino);

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
    public void getSk() {

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";
        Integer pSeikyuurirekino = 111;

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_KoudosgJytGtKahi JT_KoudosgJytGtKahi1 = jT_Sk1.getKoudosgJytGtKahi();
        JT_Sk jT_Sk2 = JT_KoudosgJytGtKahi1.getSk();

        Assert.assertEquals(pSyono1, jT_Sk2.getSyono());
        Assert.assertEquals(pSkno1, jT_Sk2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, jT_Sk2.getSeikyuurirekino());
    }

}
