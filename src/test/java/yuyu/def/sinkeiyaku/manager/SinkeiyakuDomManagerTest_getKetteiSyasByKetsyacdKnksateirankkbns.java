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

import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 決定者マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKetteiSyasByKetsyacdKnksateirankkbns {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns("100000001",
                new C_KnksateirankKbn[] { C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA,
                C_KnksateirankKbn.NIJIB });

        Assert.assertEquals(0, ketteiSyaList.size());

        HM_KetteiSya ketteiSya1 = new HM_KetteiSya();
        ketteiSya1.setKetsyacd("100000001");
        ketteiSya1.setKnksateirankkbn(C_KnksateirankKbn.ITIJI);
        sinkeiyakuDomManager.insert(ketteiSya1);

        HM_KetteiSya ketteiSya3 = new HM_KetteiSya();
        ketteiSya3.setKetsyacd("100000003");
        ketteiSya3.setKnksateirankkbn(C_KnksateirankKbn.NIJIA);
        sinkeiyakuDomManager.insert(ketteiSya3);

        HM_KetteiSya ketteiSya2 = new HM_KetteiSya();
        ketteiSya2.setKetsyacd("100000002");
        ketteiSya2.setKnksateirankkbn(C_KnksateirankKbn.NIJIB);
        sinkeiyakuDomManager.insert(ketteiSya2);

        HM_KetteiSya ketteiSya4 = new HM_KetteiSya();
        ketteiSya4.setKetsyacd("100000004");
        ketteiSya4.setKnksateirankkbn(C_KnksateirankKbn.NONE);
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

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns("100000003",
                new C_KnksateirankKbn[] { C_KnksateirankKbn.BLNK });

        Assert.assertEquals(0, ketteiSyaList.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns("100000001",
                new C_KnksateirankKbn[] { C_KnksateirankKbn.NIJIA });

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("100000003", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals(C_KnksateirankKbn.NIJIA, ketteiSyaList.get(0).getKnksateirankkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns("100000004",
                new C_KnksateirankKbn[] { C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA,
                C_KnksateirankKbn.NIJIB });

        Assert.assertEquals(3, ketteiSyaList.size());

        Assert.assertEquals("100000001", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("100000002", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("100000003", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals(C_KnksateirankKbn.ITIJI, ketteiSyaList.get(0).getKnksateirankkbn());
        Assert.assertEquals(C_KnksateirankKbn.NIJIB, ketteiSyaList.get(1).getKnksateirankkbn());
        Assert.assertEquals(C_KnksateirankKbn.NIJIA, ketteiSyaList.get(2).getKnksateirankkbn());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns("",
                new C_KnksateirankKbn[] { C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA,
                C_KnksateirankKbn.NIJIB });

        Assert.assertEquals(3, ketteiSyaList.size());
        Assert.assertEquals("100000001", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("100000002", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("100000003", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals(C_KnksateirankKbn.ITIJI, ketteiSyaList.get(0).getKnksateirankkbn());
        Assert.assertEquals(C_KnksateirankKbn.NIJIB, ketteiSyaList.get(1).getKnksateirankkbn());
        Assert.assertEquals(C_KnksateirankKbn.NIJIA, ketteiSyaList.get(2).getKnksateirankkbn());

    }

}
