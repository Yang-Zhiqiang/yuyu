package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getMosKihonsByUktkid() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMosKihonsByUktkid {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_MosKihon> ｍosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkid("11111111111");

        Assert.assertEquals(0,ｍosKihonLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setUktkid("11111111111");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setUktkid("11111111111");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setUktkid("11111111111");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");

        HT_MosKihon mosKihon5 = syoriCTL4.createMosKihon();
        mosKihon5.setUktkid("11111111112");

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");

        sinkeiyakuDomManager.insert(syoriCTL5);

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

        List<HT_MosKihon> ｍosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkid("11111111113");

        Assert.assertEquals(0,ｍosKihonLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_MosKihon> ｍosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkid("11111111112");

        Assert.assertEquals(1,ｍosKihonLst.size());

        Assert.assertEquals("791112253", ｍosKihonLst.get(0).getMosno());

    }

    @Test
    @TestOrder(40)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112220"), "1");
        datamap.put($("791112238"), "1");
        datamap.put($("791112246"), "1");

        List<HT_MosKihon> ｍosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkid("11111111111");

        for(HT_MosKihon mosKihon:ｍosKihonLst){
            datamap.remove($(mosKihon.getMosno()));
        }

        Assert.assertEquals(3,ｍosKihonLst.size());

        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_MosKihon> ｍosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkid("");

        Assert.assertEquals(0,ｍosKihonLst.size());

    }
}
