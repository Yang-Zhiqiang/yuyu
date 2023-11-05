package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * WorkflowDomManagerクラスの、<br />
 * getJimutetuzukisBySubSystemId() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SinkeiyakuDomManagerTest_getKnksateiRirekiByMosnoMaxRenno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_KnksateiRireki knksateiRireki8 = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno("10000000001");
        assertEquals(null, knksateiRireki8);
        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getAllSyoriCTL();

        if (syoriCTLLst.size() == 0) {

            HT_SyoriCTL syoriCTL = new HT_SyoriCTL("10000000001");
            HT_KnksateiRireki knksateiRireki = syoriCTL.createKnksateiRireki();
            knksateiRireki.setRenno(1);
            HT_KnksateiRireki knksateiRireki2 = syoriCTL.createKnksateiRireki();
            knksateiRireki2.setRenno(2);
            HT_KnksateiRireki knksateiRireki3 = syoriCTL.createKnksateiRireki();
            knksateiRireki3.setRenno(3);
            sinkeiyakuDomManager.insert(syoriCTL);

            HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("10000000002");
            HT_KnksateiRireki knksateiRireki5 = syoriCTL2.createKnksateiRireki();
            knksateiRireki5.setRenno(4);
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
    @Transactional
    public void noResult1(){

        HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno("10000000003");
        assertEquals(null, knksateiRireki);

    }

    @Test
    public void noResult2(){

        HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno("");
        assertEquals(null, knksateiRireki);
    }

    @Test
    public void normal1(){

        HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno("10000000001");
        assertEquals("10000000001", knksateiRireki.getMosno());
        assertEquals(Integer.valueOf("3"), knksateiRireki.getRenno());
    }

}
