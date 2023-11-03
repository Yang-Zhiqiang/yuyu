package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブルエンティティから、<br />
 * 年度、帳票作成日を指定して、<br />
 * 控除証明書テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKoujyoSymByNnendoTyouhyouymdRennoEq {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_SYONO_001 = "11807111118";
    static String P_NENDO_001 = "2016";
    static String P_NENDO_002 = "2017";
    static String P_NENDO_003 = "2015";
    static BizDate P_TYOUHYOUYMD_001 = BizDate.valueOf(20160418);
    static BizDate P_TYOUHYOUYMD_002 = BizDate.valueOf(20160419);
    static Integer P_RENNO_001 = 1;
    static Integer P_RENNO_002 = 2;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon = new IT_KykKihon(P_SYONO_001);

        Assert.assertEquals(null, iT_KykKihon.getKoujyoSymByNnendoTyouhyouymdRennoEq(P_NENDO_001, P_TYOUHYOUYMD_001));

        IT_KoujyoSym iT_KoujyoSym1 = iT_KykKihon.createKoujyoSym();
        iT_KoujyoSym1.setNendo(P_NENDO_001);
        iT_KoujyoSym1.setTyouhyouymd(P_TYOUHYOUYMD_001);
        iT_KoujyoSym1.setRenno(P_RENNO_001);

        IT_KoujyoSym iT_KoujyoSym2 = iT_KykKihon.createKoujyoSym();
        iT_KoujyoSym2.setNendo(P_NENDO_001);
        iT_KoujyoSym2.setTyouhyouymd(P_TYOUHYOUYMD_001);
        iT_KoujyoSym2.setRenno(P_RENNO_002);

        IT_KoujyoSym iT_KoujyoSym3 = iT_KykKihon.createKoujyoSym();
        iT_KoujyoSym3.setNendo(P_NENDO_001);
        iT_KoujyoSym3.setTyouhyouymd(P_TYOUHYOUYMD_002);
        iT_KoujyoSym3.setRenno(P_RENNO_001);

        IT_KoujyoSym iT_KoujyoSym4 = iT_KykKihon.createKoujyoSym();
        iT_KoujyoSym4.setNendo(P_NENDO_003);
        iT_KoujyoSym4.setTyouhyouymd(P_TYOUHYOUYMD_001);
        iT_KoujyoSym4.setRenno(P_RENNO_001);

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
    public void noResult1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(P_SYONO_001);

        Assert.assertEquals(null, kykKihon.getKoujyoSymByNnendoTyouhyouymdRennoEq(P_NENDO_002, P_TYOUHYOUYMD_001));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(P_SYONO_001);

        IT_KoujyoSym iT_KoujyoSym = kykKihon.getKoujyoSymByNnendoTyouhyouymdRennoEq(P_NENDO_001, P_TYOUHYOUYMD_001);

        Assert.assertEquals(P_SYONO_001, iT_KoujyoSym.getSyono());
        Assert.assertEquals(P_NENDO_001, iT_KoujyoSym.getNendo());
        Assert.assertEquals(P_TYOUHYOUYMD_001, iT_KoujyoSym.getTyouhyouymd());
        Assert.assertEquals(P_RENNO_001, iT_KoujyoSym.getRenno());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(P_SYONO_001);

        Assert.assertEquals(null, kykKihon.getKoujyoSymByNnendoTyouhyouymdRennoEq("", P_TYOUHYOUYMD_001));
    }
}
