package yuyu.def.direct.detacher;

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
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス（Ｗｅｂ）<br />
 * 本人確認処理<br />
 * デタッチ取得[ＤＳログイン管理テーブル](ＤＳ顧客管理テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriDetacherTest_detachDsLoginKanritouched {

    @Inject
    DirectDomManager directDomManager;

    static String P_DSKOKNO = "DSKOKNO01";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri mT_DsKokyakuKanri = new MT_DsKokyakuKanri(P_DSKOKNO);

        mT_DsKokyakuKanri.createDsLoginKanri();

        directDomManager.insert(mT_DsKokyakuKanri);
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

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri(P_DSKOKNO);

        MT_DsKokyakuKanri entity = MT_DsKokyakuKanriDetacher.detachDsLoginKanritouched(mT_DsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        MT_DsLoginKanri mT_DsLoginKanri = entity.getDsLoginKanri();

        Assert.assertEquals(P_DSKOKNO, mT_DsLoginKanri.getDskokno());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = null;

        Assert.assertNull(MT_DsKokyakuKanriDetacher.detachDsLoginKanritouched(mT_DsKokyakuKanri));
    }
}
