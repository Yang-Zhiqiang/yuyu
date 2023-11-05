package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ顧客契約テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsKokyakuKeiyakuBySyono {
    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        if (dsKokyakuKanri1 == null) {
            dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri1.getDsKokyakuKeiyakuBySyono("11807111118");
            Assert.assertEquals(null, dsKokyakuKeiyaku);

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
            dsKokyakuKeiyaku1.setSyono("11807111118");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
            dsKokyakuKeiyaku2.setSyono("11807111129");

            directDomManager.insert(dsKokyakuKanri1);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(20)
    public void noResult1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri1.getDsKokyakuKeiyakuBySyono("11807111174");
        Assert.assertEquals(null, dsKokyakuKeiyaku);
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri1.getDsKokyakuKeiyakuBySyono("11807111118");

        Assert.assertEquals("100001", dsKokyakuKeiyaku.getDskokno());
        Assert.assertEquals("11807111118", dsKokyakuKeiyaku.getSyono());

    }

    @Test
    @TestOrder(30)
    public void blankCondition2() {
        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri1.getDsKokyakuKeiyakuBySyono("");

        Assert.assertEquals(null, dsKokyakuKeiyaku);

    }

}
