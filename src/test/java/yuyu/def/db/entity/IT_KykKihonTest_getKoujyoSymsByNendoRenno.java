package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明書テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class IT_KykKihonTest_getKoujyoSymsByNendoRenno {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        List<IT_KykKihon> kykKihonList = hozenDomManager.getAllKykKihon();
        if (kykKihonList.size() == 0) {
            IT_KykKihon kykKihon1= new IT_KykKihon("01","11807111118");

            List<IT_KoujyoSym> koujyoSymList = kykKihon1.getKoujyoSymsByNendoRenno("2016", 1);
            Assert.assertEquals(0, koujyoSymList.size());

            IT_KoujyoSym koujyoSym = kykKihon1.createKoujyoSym();
            koujyoSym.setNendo("2016");
            koujyoSym.setTyouhyouymd(BizDate.valueOf("20160418"));
            koujyoSym.setRenno(1);

            IT_KoujyoSym koujyoSym1 = kykKihon1.createKoujyoSym();
            koujyoSym1.setNendo("2016");
            koujyoSym1.setTyouhyouymd(BizDate.valueOf("20160418"));
            koujyoSym1.setRenno(2);

            IT_KoujyoSym koujyoSym2 = kykKihon1.createKoujyoSym();
            koujyoSym2.setNendo("2016");
            koujyoSym2.setTyouhyouymd(BizDate.valueOf("20160419"));
            koujyoSym2.setRenno(1);

            IT_KoujyoSym koujyoSym3 = kykKihon1.createKoujyoSym();
            koujyoSym3.setNendo("2015");
            koujyoSym3.setTyouhyouymd(BizDate.valueOf("20160418"));
            koujyoSym3.setRenno(1);

            hozenDomManager.insert(kykKihon1);
        }

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

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSym> koujyoSymList = kykKihon.getKoujyoSymsByNendoRenno("2017", 1);

        Assert.assertEquals(0, koujyoSymList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSym> koujyoSymList = kykKihon.getKoujyoSymsByNendoRenno("2016", 2);

        Assert.assertEquals(1, koujyoSymList.size());
        Assert.assertEquals("11807111118", koujyoSymList.get(0).getSyono());
        Assert.assertEquals("2016", koujyoSymList.get(0).getNendo());
        Assert.assertEquals(BizDate.valueOf("20160418"), koujyoSymList.get(0).getTyouhyouymd());
        Assert.assertEquals(Integer.valueOf(2),  koujyoSymList.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSym> koujyoSymList = kykKihon.getKoujyoSymsByNendoRenno("2016", 1);

        Assert.assertEquals(2, koujyoSymList.size());
        Assert.assertEquals("11807111118", koujyoSymList.get(0).getSyono());
        Assert.assertEquals("2016", koujyoSymList.get(0).getNendo());
        Assert.assertEquals(BizDate.valueOf("20160418"), koujyoSymList.get(0).getTyouhyouymd());
        Assert.assertEquals(Integer.valueOf(1),  koujyoSymList.get(0).getRenno());
        Assert.assertEquals("11807111118", koujyoSymList.get(1).getSyono());
        Assert.assertEquals("2016", koujyoSymList.get(1).getNendo());
        Assert.assertEquals(BizDate.valueOf("20160419"), koujyoSymList.get(1).getTyouhyouymd());
        Assert.assertEquals(Integer.valueOf(1),  koujyoSymList.get(1).getRenno());

    }

    @Test
    @TestOrder(40)
    public void blankCondition() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KoujyoSym> koujyoSymList = kykKihon.getKoujyoSymsByNendoRenno("", 1);
        Assert.assertEquals(0, koujyoSymList.size());
    }

}
