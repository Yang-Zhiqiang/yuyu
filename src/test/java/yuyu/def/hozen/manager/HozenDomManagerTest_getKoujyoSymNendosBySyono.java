package yuyu.def.hozen.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKoujyoSymNendosBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymNendosBySyono {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<String> nendoLst = hozenDomManager.getKoujyoSymNendosBySyono("11807111118");

        Assert.assertEquals(0,nendoLst.size());

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        if( null == kykKihon ) {
            kykKihon = new IT_KykKihon("a", "11807111118");

            IT_KoujyoSym iT_KoujyoSym1 = kykKihon.createKoujyoSym();
            iT_KoujyoSym1.setNendo("1");
            iT_KoujyoSym1.setTyouhyouymd(BizDate.valueOf("20160219"));
            iT_KoujyoSym1.setRenno(1);

            IT_KoujyoSym iT_KoujyoSym2 = kykKihon.createKoujyoSym();
            iT_KoujyoSym2.setNendo("1");
            iT_KoujyoSym2.setTyouhyouymd(BizDate.valueOf("20160219"));
            iT_KoujyoSym2.setRenno(2);

            hozenDomManager.insert(kykKihon);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111129");
        if( null == kykKihon2 ) {
            kykKihon2 = new IT_KykKihon("a", "11807111129");

            IT_KoujyoSym iT_KoujyoSym3 = kykKihon2.createKoujyoSym();
            iT_KoujyoSym3.setNendo("1");
            iT_KoujyoSym3.setTyouhyouymd(BizDate.valueOf("20160219"));
            iT_KoujyoSym3.setRenno(1);

            IT_KoujyoSym iT_KoujyoSym4 = kykKihon2.createKoujyoSym();
            iT_KoujyoSym4.setNendo("1");
            iT_KoujyoSym4.setTyouhyouymd(BizDate.valueOf("20160219"));
            iT_KoujyoSym4.setRenno(4);

            IT_KoujyoSym iT_KoujyoSym5 = kykKihon2.createKoujyoSym();
            iT_KoujyoSym5.setNendo("2");
            iT_KoujyoSym5.setTyouhyouymd(BizDate.valueOf("20160219"));
            iT_KoujyoSym5.setRenno(1);

            IT_KoujyoSym iT_KoujyoSym6 = kykKihon2.createKoujyoSym();
            iT_KoujyoSym6.setNendo("3");
            iT_KoujyoSym6.setTyouhyouymd(BizDate.valueOf("20160219"));
            iT_KoujyoSym6.setRenno(1);

            hozenDomManager.insert(kykKihon2);

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

        List<String> nendoLst = hozenDomManager.getKoujyoSymNendosBySyono("11807111130");
        Assert.assertEquals(0, nendoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<String> nendoLst = hozenDomManager.getKoujyoSymNendosBySyono("11807111118");
        Assert.assertEquals(1, nendoLst.size());

        Assert.assertEquals("1", nendoLst.get(0));
    }

    @Test
    @TestOrder(30)
    public void normal3() {

        List<String> nendoLst = hozenDomManager.getKoujyoSymNendosBySyono("11807111129");
        Assert.assertEquals(3, nendoLst.size());

        Assert.assertEquals("3", nendoLst.get(0));
        Assert.assertEquals("2", nendoLst.get(1));
        Assert.assertEquals("1", nendoLst.get(2));
    }

    @Test
    @TestOrder(40)
    public void blank() {

        List<String> nendoLst = hozenDomManager.getKoujyoSymNendosBySyono("");
        Assert.assertEquals(0, nendoLst.size());

    }
}
