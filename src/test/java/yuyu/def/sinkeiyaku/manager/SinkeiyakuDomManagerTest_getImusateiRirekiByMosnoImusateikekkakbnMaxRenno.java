package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 新契約選択情報作成<br />
 * 医務査定履歴テーブルエンティティ取得　連番(最大)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getImusateiRirekiByMosnoImusateikekkakbnMaxRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.
                getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(P_MOSNO_01, C_SyorikekkaKbn.BLNK);

        Assert.assertEquals(null, imusateiRireki);

        HT_SyoriCTL syoriCtl1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_ImusateiRireki imusateiRireki1 = syoriCtl1.createImusateiRireki();
        imusateiRireki1.setRenno(new Integer(12));
        imusateiRireki1.setImusateikekkakbn(C_SyorikekkaKbn.BLNK);

        HT_ImusateiRireki imusateiRireki2 = syoriCtl1.createImusateiRireki();
        imusateiRireki2.setRenno(new Integer(13));
        imusateiRireki2.setImusateikekkakbn(C_SyorikekkaKbn.BLNK);

        HT_ImusateiRireki imusateiRireki3 = syoriCtl1.createImusateiRireki();
        imusateiRireki3.setRenno(new Integer(15));
        imusateiRireki3.setImusateikekkakbn(C_SyorikekkaKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCtl1);

        HT_SyoriCTL syoriCtl2 =  new HT_SyoriCTL(P_MOSNO_02);

        HT_ImusateiRireki imusateiRireki4 = syoriCtl2.createImusateiRireki();
        imusateiRireki4.setRenno(new Integer(15));
        imusateiRireki4.setImusateikekkakbn(C_SyorikekkaKbn.HORYUU);

        sinkeiyakuDomManager.insert(syoriCtl2);

        HT_SyoriCTL syoriCtl3 =  new HT_SyoriCTL(P_MOSNO_03);

        HT_ImusateiRireki imusateiRireki5 = syoriCtl3.createImusateiRireki();
        imusateiRireki5.setRenno(new Integer(16));
        imusateiRireki5.setImusateikekkakbn(C_SyorikekkaKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCtl3);
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

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.
                getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(P_MOSNO_02, C_SyorikekkaKbn.BLNK);

        Assert.assertEquals(null, imusateiRireki);
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.
                getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(P_MOSNO_01, C_SyorikekkaKbn.BLNK);

        Assert.assertEquals(P_MOSNO_01, imusateiRireki.getMosno());
        Assert.assertEquals(new Integer(15), imusateiRireki.getRenno());
        Assert.assertEquals(C_SyorikekkaKbn.BLNK, imusateiRireki.getImusateikekkakbn());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.
                getImusateiRirekiByMosnoImusateikekkakbnMaxRenno("", C_SyorikekkaKbn.BLNK);

        Assert.assertEquals(null, imusateiRireki);
    }
}
