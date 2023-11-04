package yuyu.def.hozen.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 新契約保険証券Ｆ作成<br />
 * デタッチ取得[控除証明書テーブル](契約基本テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKoujyoSymtouched {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_NENDO_01 = "2016";
    static BizDate P_TYOUHYOUYMD_01 = BizDate.valueOf("20160418");
    static Integer P_RENNO_01 = 1;
    static Integer P_RENNO_02 = 2;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon = new IT_KykKihon(P_SYONO_01);

        IT_KoujyoSym iT_KoujyoSym1 = iT_KykKihon.createKoujyoSym();
        iT_KoujyoSym1.setNendo(P_NENDO_01);
        iT_KoujyoSym1.setTyouhyouymd(P_TYOUHYOUYMD_01);
        iT_KoujyoSym1.setRenno(P_RENNO_01);

        IT_KoujyoSym iT_KoujyoSym2 = iT_KykKihon.createKoujyoSym();
        iT_KoujyoSym2.setNendo(P_NENDO_01);
        iT_KoujyoSym2.setTyouhyouymd(P_TYOUHYOUYMD_01);
        iT_KoujyoSym2.setRenno(P_RENNO_02);

        hozenDomManager.insert(iT_KykKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon(P_SYONO_01);

        IT_KykKihon entity = IT_KykKihonDetacher.detachKoujyoSymtouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_KoujyoSym> iT_KoujyoSyms = entity.getKoujyoSyms();

        Assert.assertEquals(2, iT_KoujyoSyms.size());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachKoujyoSymtouched(iT_KykKihon));
    }
}
