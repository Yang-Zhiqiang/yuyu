package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn("11807111118");
        Assert.assertEquals(null, kykKihon);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");
        kykKihon1.setFstphrkkeirokbn(C_FstphrkkeiroKbn.valueOf("3"));

        sinkeiyakuDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "11807111130");
        kykKihon2.setFstphrkkeirokbn(C_FstphrkkeiroKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(kykKihon2);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setUriagesousinkbn(C_UriagesousinKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112279");
        syoriCTL2.setSyono("11807111129");
        syoriCTL2.setUriagesousinkbn(C_UriagesousinKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112253");
        syoriCTL3.setSyono("11807111118");
        syoriCTL3.setUriagesousinkbn(C_UriagesousinKbn.valueOf("2"));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112238");
        syoriCTL4.setSyono("11807111118");
        syoriCTL4.setUriagesousinkbn(C_UriagesousinKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112249");
        syoriCTL5.setSyono("11807111118");
        syoriCTL5.setUriagesousinkbn(C_UriagesousinKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112261");
        syoriCTL6.setSyono("11807111130");
        syoriCTL6.setUriagesousinkbn(C_UriagesousinKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL6);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn("11807111152");
        Assert.assertEquals(null, kykKihon);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn("11807111130");
        Assert.assertEquals(null, kykKihon1);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn("11807111118");

        Assert.assertEquals("01", kykKihon.getKbnkey());
        Assert.assertEquals("11807111118", kykKihon.getSyono());

    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihonBySyonoFstphrkkeirokbnUriagesousinkbn("");
        Assert.assertEquals(null, kykKihon);
    }
}
