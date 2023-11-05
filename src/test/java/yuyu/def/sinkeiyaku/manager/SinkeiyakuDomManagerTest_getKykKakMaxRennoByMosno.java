package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約確認テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKykKakMaxRennoByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("800000001");

        if(syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("800000001");

            HT_KykKak hT_KykKak1 = syoriCTL1.createKykKak();
            hT_KykKak1.setRenno(1);

            HT_KykKak hT_KykKak2 = syoriCTL1.createKykKak();
            hT_KykKak2.setRenno(2);

            HT_KykKak hT_KykKak3 = syoriCTL1.createKykKak();
            hT_KykKak3.setRenno(3);

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("800000002");
        if(syoriCTL2 == null) {

            syoriCTL2 = new HT_SyoriCTL("800000002");

            HT_KykKak hT_KykKak4 = syoriCTL2.createKykKak();
            hT_KykKak4.setRenno(4);

            sinkeiyakuDomManager.insert(syoriCTL2);
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
    public void noresult1() {

        Integer maxRennoByMosno = sinkeiyakuDomManager.getKykKakMaxRennoByMosno("800000003");
        Assert.assertEquals(null, maxRennoByMosno);

    }
    @Test
    @TestOrder(20)
    public void normal1() {

        Integer maxRennoByMosno = sinkeiyakuDomManager.getKykKakMaxRennoByMosno("800000001");
        Assert.assertEquals(Integer.valueOf(3), maxRennoByMosno);
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        Integer maxRennoByMosno = sinkeiyakuDomManager.getKykKakMaxRennoByMosno("");
        Assert.assertEquals(null, maxRennoByMosno);

    }

}
