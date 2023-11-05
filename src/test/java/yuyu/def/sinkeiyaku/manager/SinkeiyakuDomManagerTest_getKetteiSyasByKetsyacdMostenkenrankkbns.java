package yuyu.def.sinkeiyaku.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 決定者マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKetteiSyasByKetsyacdMostenkenrankkbns {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns("100000001",
            new C_MostenkenRankKbn[] { C_MostenkenRankKbn.ITIJI, C_MostenkenRankKbn.NIJI
            ,C_MostenkenRankKbn.HUBI
        });

        Assert.assertEquals(0, ketteiSyaList.size());

        HM_KetteiSya ketteiSya1 = new HM_KetteiSya();
        ketteiSya1.setKetsyacd("100000001");
        ketteiSya1.setMostenkenrankkbn(C_MostenkenRankKbn.ITIJI);
        sinkeiyakuDomManager.insert(ketteiSya1);

        HM_KetteiSya ketteiSya3 = new HM_KetteiSya();
        ketteiSya3.setKetsyacd("100000003");
        ketteiSya3.setMostenkenrankkbn(C_MostenkenRankKbn.NIJI);
        sinkeiyakuDomManager.insert(ketteiSya3);

        HM_KetteiSya ketteiSya2 = new HM_KetteiSya();
        ketteiSya2.setKetsyacd("100000002");
        ketteiSya2.setMostenkenrankkbn(C_MostenkenRankKbn.HUBI);
        sinkeiyakuDomManager.insert(ketteiSya2);

        HM_KetteiSya ketteiSya4 = new HM_KetteiSya();
        ketteiSya4.setKetsyacd("100000004");
        ketteiSya4.setMostenkenrankkbn(C_MostenkenRankKbn.NONE);
        sinkeiyakuDomManager.insert(ketteiSya4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllKetteiSya());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns("100000003",
            new C_MostenkenRankKbn[] { C_MostenkenRankKbn.NIJI });

        Assert.assertEquals(0, ketteiSyaList.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns("100000001",
            new C_MostenkenRankKbn[] { C_MostenkenRankKbn.NIJI });

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("100000003", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals(C_MostenkenRankKbn.NIJI, ketteiSyaList.get(0).getMostenkenrankkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns("100000004",
            new C_MostenkenRankKbn[] { C_MostenkenRankKbn.ITIJI, C_MostenkenRankKbn.NIJI
            ,C_MostenkenRankKbn.HUBI
        });

        Assert.assertEquals(3, ketteiSyaList.size());

        Assert.assertEquals("100000001", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("100000002", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("100000003", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals(C_MostenkenRankKbn.ITIJI, ketteiSyaList.get(0).getMostenkenrankkbn());
        Assert.assertEquals(C_MostenkenRankKbn.HUBI, ketteiSyaList.get(1).getMostenkenrankkbn());
        Assert.assertEquals(C_MostenkenRankKbn.NIJI, ketteiSyaList.get(2).getMostenkenrankkbn());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns("",
            new C_MostenkenRankKbn[] { C_MostenkenRankKbn.ITIJI, C_MostenkenRankKbn.NIJI
            ,C_MostenkenRankKbn.HUBI
        });

        Assert.assertEquals(3, ketteiSyaList.size());
        Assert.assertEquals("100000001", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("100000002", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("100000003", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals(C_MostenkenRankKbn.ITIJI, ketteiSyaList.get(0).getMostenkenrankkbn());
        Assert.assertEquals(C_MostenkenRankKbn.HUBI, ketteiSyaList.get(1).getMostenkenrankkbn());
        Assert.assertEquals(C_MostenkenRankKbn.NIJI, ketteiSyaList.get(2).getMostenkenrankkbn());

    }

}
