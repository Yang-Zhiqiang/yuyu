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
 * 査定承認履歴テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_SateiSyouninRirekiEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        String pSkno1 = "1111111111";
        String pSyono1 = "SYONO000001";

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);

        String pSateisyouninskbtkey1 = "11111111111";

        JT_SateiSyouninRireki jT_SateiSyouninRireki1 = jT_SkKihon1.createSateiSyouninRireki();
        jT_SateiSyouninRireki1.setSateisyouninskbtkey(pSateisyouninskbtkey1);

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
        List<JT_SateiSyouninRireki> JT_SateiSyouninRirekis = jT_SkKihon1.getSateiSyouninRirekis();
        JT_SateiSyouninRireki JT_SateiSyouninRireki1 = JT_SateiSyouninRirekis.get(0);
        JT_SkKihon jT_SkKihon2 = JT_SateiSyouninRireki1.getSkKihon();
        Assert.assertEquals(pSyono1, jT_SkKihon2.getSyono());
        Assert.assertEquals(pSkno1, jT_SkKihon2.getSkno());
    }
}
