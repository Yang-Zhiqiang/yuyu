package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getDakuhiKetteiMaxDakuhiktrennoByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getDakuhiKetteiMaxDakuhiktrennoByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Integer maxMosno = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno("10000000060");
        Assert.assertEquals(null,maxMosno);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if( syoriCTL == null ) {
            syoriCTL = new HT_SyoriCTL("10000000060");

            HT_DakuhiKettei dakuhiKettei = syoriCTL.createDakuhiKettei();
            dakuhiKettei.setDakuhiktrenno(3);
            dakuhiKettei.setMosno("10000000060");

            HT_DakuhiKettei dakuhiKettei1 = syoriCTL.createDakuhiKettei();
            dakuhiKettei1.setDakuhiktrenno(2);
            dakuhiKettei1.setMosno("10000000060");

            HT_DakuhiKettei dakuhiKettei2 = syoriCTL.createDakuhiKettei();
            dakuhiKettei2.setDakuhiktrenno(1);
            dakuhiKettei2.setMosno("10000000060");
            sinkeiyakuDomManager.insert(syoriCTL);

        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("10000000070");
        HT_DakuhiKettei dakuhiKettei3 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei3.setDakuhiktrenno(4);
        dakuhiKettei3.setMosno("10000000070");
        sinkeiyakuDomManager.insert(syoriCTL1);

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

        Integer maxMosno = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno("10000000080");
        Assert.assertEquals(null,maxMosno);

    }

    @Test
    @TestOrder(20)
    public void blankCondition() {

        Integer maxMosno = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno("");
        Assert.assertEquals(null,maxMosno);

    }
    @Test
    @TestOrder(30)
    public void normal1() {

        Integer maxMosno = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno("10000000060");
        Assert.assertEquals(3,maxMosno.intValue());
    }
}
