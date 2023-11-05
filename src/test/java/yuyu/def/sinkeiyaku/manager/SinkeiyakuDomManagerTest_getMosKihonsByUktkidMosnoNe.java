package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 新契約<br />
 * SMBC進捗管理データ作成<br />
 * 申込基本テーブルエンティティリスト取得　申込番号Neのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMosKihonsByUktkidMosnoNe {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe("10000000001", "791112238");

        Assert.assertEquals(0, mosKihonLst.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setUktkid("10000000001");

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setUktkid("10000000001");

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setUktkid("10000000002");

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setUktkid("10000000003");

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setUktkid("10000000003");

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setUktkid("10000000003");

        sinkeiyakuDomManager.insert(syoriCTL6);
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe("10000000000", "791112238");

        Assert.assertEquals(0, mosKihonLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe("10000000001", "791112238");

        Assert.assertEquals(1, mosKihonLst.size());
        Assert.assertEquals("791112220", mosKihonLst.get(0).getMosno());
        Assert.assertEquals("10000000001", mosKihonLst.get(0).getUktkid());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> khBikinkanriMap = new HashMap<String, String>();
        khBikinkanriMap.put($("791112253", "10000000003"),"1");
        khBikinkanriMap.put($("791112261", "10000000003"),"1");
        khBikinkanriMap.put($("791112279", "10000000003"),"1");

        List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe("10000000003", "791112238");

        Assert.assertEquals(3, mosKihonLst.size());

        khBikinkanriMap.remove($(mosKihonLst.get(0).getMosno(), mosKihonLst.get(0).getUktkid()));
        khBikinkanriMap.remove($(mosKihonLst.get(1).getMosno(), mosKihonLst.get(1).getUktkid()));
        khBikinkanriMap.remove($(mosKihonLst.get(2).getMosno(), mosKihonLst.get(2).getUktkid()));
        assertTrue(khBikinkanriMap.isEmpty());
    }


    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe("", "791112238");

        Assert.assertEquals(0, mosKihonLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        Map<String,String> khBikinkanriMap = new HashMap<String, String>();
        khBikinkanriMap.put($("791112253", "10000000003"),"1");
        khBikinkanriMap.put($("791112261", "10000000003"),"1");
        khBikinkanriMap.put($("791112279", "10000000003"),"1");

        List<HT_MosKihon> mosKihonLst = sinkeiyakuDomManager.getMosKihonsByUktkidMosnoNe("10000000003", "");

        Assert.assertEquals(3, mosKihonLst.size());

        khBikinkanriMap.remove($(mosKihonLst.get(0).getMosno(), mosKihonLst.get(0).getUktkid()));
        khBikinkanriMap.remove($(mosKihonLst.get(1).getMosno(), mosKihonLst.get(1).getUktkid()));
        khBikinkanriMap.remove($(mosKihonLst.get(2).getMosno(), mosKihonLst.get(2).getUktkid()));
        assertTrue(khBikinkanriMap.isEmpty());
    }

    @Transactional
    public static void deleteTestSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SyoriCTL> syoriCTLList = sinkeiyakuDomManager.getAllSyoriCTL();
        if (syoriCTLList.size() > 0) {
            sinkeiyakuDomManager.delete(syoriCTLList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}