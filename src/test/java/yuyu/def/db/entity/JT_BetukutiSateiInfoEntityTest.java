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
 * 別口査定情報テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class JT_BetukutiSateiInfoEntityTest {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private static final String pSkno1 = "1111111111";
    private static final String pSyono1 = "SYONO000001";

    private static final Integer pSeikyuurirekino = 111;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(pSkno1, pSyono1);


        JT_Sk jT_Sk1 = jT_SkKihon1.createSk();
        jT_Sk1.setSeikyuurirekino(pSeikyuurirekino);


        jT_Sk1.createBetukutiSateiInfo();

        siharaiDomManager.insert(jT_SkKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);

        siharaiDomManager.delete(jT_SkKihon1);
    }

    @Test
    @TestOrder(10)
    public void getSk() {

        JT_SkKihon jT_SkKihon1 = siharaiDomManager.getSkKihon(pSkno1, pSyono1);
        List<JT_Sk> jT_Sks = jT_SkKihon1.getSks();
        JT_Sk jT_Sk1 = jT_Sks.get(0);
        JT_BetukutiSateiInfo JT_BetukutiSateiInfo1 = jT_Sk1.getBetukutiSateiInfo();
        JT_Sk jT_Sk2 = JT_BetukutiSateiInfo1.getSk();

        Assert.assertEquals(pSyono1, jT_Sk2.getSyono());
        Assert.assertEquals(pSkno1, jT_Sk2.getSkno());
        Assert.assertEquals(pSeikyuurirekino, jT_Sk2.getSeikyuurirekino());
    }

}
