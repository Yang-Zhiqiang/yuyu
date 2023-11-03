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
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス（Ｗｅｂ）<br />
 * 本人確認処理<br />
 * ＤＳ顧客管理テーブルエンティティをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriDetacherTest_detachDsKokyakuKanritouched {

    @Inject
    DirectDomManager directDomManager;

    static String P_DSKOKNO_01 = "KKBG001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.insert(new MT_DsKokyakuKanri(P_DSKOKNO_01));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri(P_DSKOKNO_01);

        MT_DsKokyakuKanri entity = MT_DsKokyakuKanriDetacher.detachDsKokyakuKanritouched(mT_DsKokyakuKanri);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = null;

        Assert.assertNull(MT_DsKokyakuKanriDetacher.detachDsKokyakuKanritouched(mT_DsKokyakuKanri));
    }
}
