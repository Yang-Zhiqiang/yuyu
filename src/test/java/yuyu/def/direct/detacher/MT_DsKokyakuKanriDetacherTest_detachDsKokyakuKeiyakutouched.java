package yuyu.def.direct.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス（Ｗｅｂ）<br />
 * 本人確認処理<br />
 * デタッチ取得[ＤＳ顧客契約テーブル](ＤＳ顧客管理テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriDetacherTest_detachDsKokyakuKeiyakutouched {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("DSKOKNO01");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111118");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111129");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("11807111130");

        directDomManager.insert(dsKokyakuKanri1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager .class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri("DSKOKNO01");

        MT_DsKokyakuKanri entity = MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakutouched(mT_DsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyaku = entity.getDsKokyakuKeiyakus();

        Assert.assertEquals("DSKOKNO01", mT_DsKokyakuKeiyaku.get(0).getDskokno());
        Assert.assertEquals("11807111118", mT_DsKokyakuKeiyaku.get(0).getSyono());

        Assert.assertEquals("DSKOKNO01", mT_DsKokyakuKeiyaku.get(1).getDskokno());
        Assert.assertEquals("11807111129", mT_DsKokyakuKeiyaku.get(1).getSyono());

        Assert.assertEquals("DSKOKNO01", mT_DsKokyakuKeiyaku.get(2).getDskokno());
        Assert.assertEquals("11807111130", mT_DsKokyakuKeiyaku.get(2).getSyono());

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = null;

        Assert.assertNull(MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakutouched(mT_DsKokyakuKanri));
    }
}
