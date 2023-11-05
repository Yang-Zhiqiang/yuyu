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

import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 決定者マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKetteiSyasByKetsyacdImusateirankkbns {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns("100001",
                new C_ImusateirankKbn[] { C_ImusateirankKbn.KANI_MD, C_ImusateirankKbn.KANI_UW});

        Assert.assertEquals(0, ketteiSyaList.size());

        HM_KetteiSya ketteiSya1 = new HM_KetteiSya();
        ketteiSya1.setKetsyacd("100001");
        ketteiSya1.setImusateirankkbn(C_ImusateirankKbn.BLNK);
        sinkeiyakuDomManager.insert(ketteiSya1);

        HM_KetteiSya ketteiSya2 = new HM_KetteiSya();
        ketteiSya2.setKetsyacd("100003");
        ketteiSya2.setImusateirankkbn(C_ImusateirankKbn.KANI_UW);
        sinkeiyakuDomManager.insert(ketteiSya2);

        HM_KetteiSya ketteiSya3 = new HM_KetteiSya();
        ketteiSya3.setKetsyacd("100005");
        ketteiSya3.setImusateirankkbn(C_ImusateirankKbn.KANI_MD);
        sinkeiyakuDomManager.insert(ketteiSya3);

        HM_KetteiSya ketteiSya4 = new HM_KetteiSya();
        ketteiSya4.setKetsyacd("100002");
        ketteiSya4.setImusateirankkbn(C_ImusateirankKbn.NONE);
        sinkeiyakuDomManager.insert(ketteiSya4);

        HM_KetteiSya ketteiSya5 = new HM_KetteiSya();
        ketteiSya5.setKetsyacd("100004");
        ketteiSya5.setImusateirankkbn(C_ImusateirankKbn.KANI_MD);
        sinkeiyakuDomManager.insert(ketteiSya5);
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

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns("100001",
                new C_ImusateirankKbn[] { C_ImusateirankKbn.BLNK});

        Assert.assertEquals(0, ketteiSyaList.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns("100001",
                new C_ImusateirankKbn[] {C_ImusateirankKbn.KANI_UW});

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("100003", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_UW, ketteiSyaList.get(0).getImusateirankkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns("100001",
                new C_ImusateirankKbn[] { C_ImusateirankKbn.KANI_MD, C_ImusateirankKbn.KANI_UW});

        Assert.assertEquals(3, ketteiSyaList.size());

        Assert.assertEquals("100003", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_UW, ketteiSyaList.get(0).getImusateirankkbn());

        Assert.assertEquals("100004", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_MD, ketteiSyaList.get(1).getImusateirankkbn());

        Assert.assertEquals("100005", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_MD, ketteiSyaList.get(2).getImusateirankkbn());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns("",
                new C_ImusateirankKbn[] { C_ImusateirankKbn.KANI_MD, C_ImusateirankKbn.KANI_UW});

        Assert.assertEquals(3, ketteiSyaList.size());

        Assert.assertEquals("100003", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_UW, ketteiSyaList.get(0).getImusateirankkbn());

        Assert.assertEquals("100004", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_MD, ketteiSyaList.get(1).getImusateirankkbn());

        Assert.assertEquals("100005", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals(C_ImusateirankKbn.KANI_MD, ketteiSyaList.get(2).getImusateirankkbn());

    }

}
