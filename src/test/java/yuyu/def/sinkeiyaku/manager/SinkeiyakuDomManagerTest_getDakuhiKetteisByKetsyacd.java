package yuyu.def.sinkeiyaku.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
 * 諾否決定テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getDakuhiKetteisByKetsyacd {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_DakuhiKettei> dakuhiKetteiLst = sinkeiyakuDomManager.getDakuhiKetteisByKetsyacd("M001");

        Assert.assertEquals(0,dakuhiKetteiLst.size());


        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if( null == syoriCTL1 ) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");

            HT_DakuhiKettei dakuhiKettei1 = syoriCTL1.createDakuhiKettei();
            dakuhiKettei1.setDakuhiktrenno(1);
            dakuhiKettei1.setKetsyacd("M001");

            sinkeiyakuDomManager.insert(syoriCTL1);

            HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("10000000070");

            HT_DakuhiKettei dakuhiKettei2 = syoriCTL2.createDakuhiKettei();
            dakuhiKettei2.setDakuhiktrenno(1);
            dakuhiKettei2.setKetsyacd("M002");

            HT_DakuhiKettei dakuhiKettei3 = syoriCTL2.createDakuhiKettei();
            dakuhiKettei3.setDakuhiktrenno(2);
            dakuhiKettei3.setKetsyacd("M002");

            HT_DakuhiKettei dakuhiKettei4 = syoriCTL2.createDakuhiKettei();
            dakuhiKettei4.setDakuhiktrenno(3);
            dakuhiKettei4.setKetsyacd("M002");

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
    @TestOrder(20)
    public void noResult1(){

        List<HT_DakuhiKettei> dakuhiKetteiLst = sinkeiyakuDomManager.getDakuhiKetteisByKetsyacd("M010");

        Assert.assertEquals(0,dakuhiKetteiLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_DakuhiKettei> dakuhiKetteiLst = sinkeiyakuDomManager.getDakuhiKetteisByKetsyacd("M001");

        Assert.assertEquals(1,dakuhiKetteiLst.size());
        Assert.assertEquals("10000000060", dakuhiKetteiLst.get(0).getMosno());
        Assert.assertEquals(1, dakuhiKetteiLst.get(0).getDakuhiktrenno().intValue());
        Assert.assertEquals("M001", dakuhiKetteiLst.get(0).getKetsyacd());

    }
    @Test
    @TestOrder(40)
    public void normal2(){

        Map<String,String> dakuhiKetteiMap = new HashMap<String, String>();
        dakuhiKetteiMap.put($("10000000070",1,"M002"),"1");
        dakuhiKetteiMap.put($("10000000070",2,"M002"),"1");
        dakuhiKetteiMap.put($("10000000070",3,"M002"),"1");

        List<HT_DakuhiKettei> dakuhiKetteiLst = sinkeiyakuDomManager.getDakuhiKetteisByKetsyacd("M002");

        Assert.assertEquals(3,dakuhiKetteiLst.size());

        assertTrue(dakuhiKetteiMap.containsKey($(dakuhiKetteiLst.get(0).getMosno(),dakuhiKetteiLst.get(0).getDakuhiktrenno().intValue(),dakuhiKetteiLst.get(0).getKetsyacd())));
        dakuhiKetteiMap.remove($(dakuhiKetteiLst.get(0).getMosno(),dakuhiKetteiLst.get(0).getDakuhiktrenno().intValue(),dakuhiKetteiLst.get(0).getKetsyacd()));
        assertTrue(dakuhiKetteiMap.containsKey($(dakuhiKetteiLst.get(1).getMosno(),dakuhiKetteiLst.get(1).getDakuhiktrenno().intValue(),dakuhiKetteiLst.get(1).getKetsyacd())));
        dakuhiKetteiMap.remove($(dakuhiKetteiLst.get(1).getMosno(),dakuhiKetteiLst.get(1).getDakuhiktrenno().intValue(),dakuhiKetteiLst.get(1).getKetsyacd()));
        assertTrue(dakuhiKetteiMap.containsKey($(dakuhiKetteiLst.get(2).getMosno(),dakuhiKetteiLst.get(2).getDakuhiktrenno().intValue(),dakuhiKetteiLst.get(2).getKetsyacd())));
        dakuhiKetteiMap.remove($(dakuhiKetteiLst.get(2).getMosno(),dakuhiKetteiLst.get(2).getDakuhiktrenno().intValue(),dakuhiKetteiLst.get(2).getKetsyacd()));

    }

    @Test
    @TestOrder(50)
    public void blank() {

        List<HT_DakuhiKettei> dakuhiKetteiLst = sinkeiyakuDomManager.getDakuhiKetteisByKetsyacd("");

        Assert.assertEquals(0,dakuhiKetteiLst.size());

    }
}
