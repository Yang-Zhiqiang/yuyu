package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 処理コントロールテーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNayoseKekkaBySntkinfotaisyousyakbnEdano {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("791112220");
            Assert.assertEquals(null, syoriCtl1.getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, 1));

            HT_NayoseKekka nayoseKekka1 = syoriCtl1.createNayoseKekka();
            nayoseKekka1.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
            nayoseKekka1.setEdano(1);

            HT_NayoseKekka nayoseKekka2 = syoriCtl1.createNayoseKekka();
            nayoseKekka2.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
            nayoseKekka2.setEdano(1);

            HT_NayoseKekka nayoseKekka3 = syoriCtl1.createNayoseKekka();
            nayoseKekka3.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
            nayoseKekka3.setEdano(2);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        Assert.assertEquals(null, syoriCtl.getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.HIHOKENSYA, 2));

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        HT_NayoseKekka nayoseKekka = syoriCtl.getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA,1 );
        Assert.assertEquals("791112220", nayoseKekka.getMosno());
        Assert.assertEquals(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, nayoseKekka.getSntkinfotaisyousyakbn());
        Assert.assertEquals(Integer.valueOf(1), nayoseKekka.getEdano());
    }

}
