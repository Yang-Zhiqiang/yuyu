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

import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 決定者マスタのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKetteiSyasByKetsyacdKetsyanm {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("C", "え");

        Assert.assertEquals(0, ketteiSyaList.size());

        HM_KetteiSya ketteiSya = new HM_KetteiSya();
        ketteiSya.setKetsyacd("CDE");
        ketteiSya.setKetsyanm("うえお");
        sinkeiyakuDomManager.insert(ketteiSya);

        HM_KetteiSya ketteiSya1 = new HM_KetteiSya();
        ketteiSya1.setKetsyacd("BAA");
        ketteiSya1.setKetsyanm("あいあ");
        sinkeiyakuDomManager.insert(ketteiSya1);

        HM_KetteiSya ketteiSya2 = new HM_KetteiSya();
        ketteiSya2.setKetsyacd("ABB");
        ketteiSya2.setKetsyanm("いあい");
        sinkeiyakuDomManager.insert(ketteiSya2);

        HM_KetteiSya ketteiSya3 = new HM_KetteiSya();
        ketteiSya3.setKetsyacd("B");
        ketteiSya3.setKetsyanm("い");
        sinkeiyakuDomManager.insert(ketteiSya3);

        HM_KetteiSya ketteiSya4 = new HM_KetteiSya();
        ketteiSya4.setKetsyacd("A");
        ketteiSya4.setKetsyanm("あ");
        sinkeiyakuDomManager.insert(ketteiSya4);

        HM_KetteiSya ketteiSya5 = new HM_KetteiSya();
        ketteiSya5.setKetsyacd("BBB");
        ketteiSya5.setKetsyanm("いいい");
        sinkeiyakuDomManager.insert(ketteiSya5);

        HM_KetteiSya ketteiSya6 = new HM_KetteiSya();
        ketteiSya6.setKetsyacd("AAA");
        ketteiSya6.setKetsyanm("あああ");
        sinkeiyakuDomManager.insert(ketteiSya6);

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

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("F", "い");

        Assert.assertEquals(0, ketteiSyaList.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HM_KetteiSya> ketteiSyaList1 = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("C", "え");

        Assert.assertEquals(1, ketteiSyaList1.size());

        Assert.assertEquals("CDE", ketteiSyaList1.get(0).getKetsyacd());
        Assert.assertEquals("うえお", ketteiSyaList1.get(0).getKetsyanm());

        List<HM_KetteiSya> ketteiSyaList2 = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("BB", "いい");

        Assert.assertEquals(1, ketteiSyaList2.size());

        Assert.assertEquals("BBB", ketteiSyaList2.get(0).getKetsyacd());
        Assert.assertEquals("いいい", ketteiSyaList2.get(0).getKetsyanm());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("B", "い");

        Assert.assertEquals(3, ketteiSyaList.size());

        Assert.assertEquals("B", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("BAA", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("BBB", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals("い", ketteiSyaList.get(0).getKetsyanm());
        Assert.assertEquals("あいあ", ketteiSyaList.get(1).getKetsyanm());
        Assert.assertEquals("いいい", ketteiSyaList.get(2).getKetsyanm());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("", "え");

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("CDE", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("うえお", ketteiSyaList.get(0).getKetsyanm());

    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("C", "");

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("CDE", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("うえお", ketteiSyaList.get(0).getKetsyanm());

    }

    @Test
    @TestOrder(60)
    public void blank3() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("", "");

        Assert.assertEquals(7, ketteiSyaList.size());

        Assert.assertEquals("A", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("AAA", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("ABB", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals("B", ketteiSyaList.get(3).getKetsyacd());
        Assert.assertEquals("BAA", ketteiSyaList.get(4).getKetsyacd());
        Assert.assertEquals("BBB", ketteiSyaList.get(5).getKetsyacd());
        Assert.assertEquals("CDE", ketteiSyaList.get(6).getKetsyacd());
        Assert.assertEquals("あ", ketteiSyaList.get(0).getKetsyanm());
        Assert.assertEquals("あああ", ketteiSyaList.get(1).getKetsyanm());
        Assert.assertEquals("いあい", ketteiSyaList.get(2).getKetsyanm());
        Assert.assertEquals("い", ketteiSyaList.get(3).getKetsyanm());
        Assert.assertEquals("あいあ", ketteiSyaList.get(4).getKetsyanm());
        Assert.assertEquals("いいい", ketteiSyaList.get(5).getKetsyanm());
        Assert.assertEquals("うえお", ketteiSyaList.get(6).getKetsyanm());
    }

    @Test
    @TestOrder(70)
    public void null1() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm(null, "え");

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("CDE", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("うえお", ketteiSyaList.get(0).getKetsyanm());

    }

    @Test
    @TestOrder(80)
    public void null2() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm("C", null);

        Assert.assertEquals(1, ketteiSyaList.size());

        Assert.assertEquals("CDE", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("うえお", ketteiSyaList.get(0).getKetsyanm());

    }

    @Test
    @TestOrder(90)
    public void null3() {

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKetsyanm(null, null);

        Assert.assertEquals(7, ketteiSyaList.size());

        Assert.assertEquals("A", ketteiSyaList.get(0).getKetsyacd());
        Assert.assertEquals("AAA", ketteiSyaList.get(1).getKetsyacd());
        Assert.assertEquals("ABB", ketteiSyaList.get(2).getKetsyacd());
        Assert.assertEquals("B", ketteiSyaList.get(3).getKetsyacd());
        Assert.assertEquals("BAA", ketteiSyaList.get(4).getKetsyacd());
        Assert.assertEquals("BBB", ketteiSyaList.get(5).getKetsyacd());
        Assert.assertEquals("CDE", ketteiSyaList.get(6).getKetsyacd());
        Assert.assertEquals("あ", ketteiSyaList.get(0).getKetsyanm());
        Assert.assertEquals("あああ", ketteiSyaList.get(1).getKetsyanm());
        Assert.assertEquals("いあい", ketteiSyaList.get(2).getKetsyanm());
        Assert.assertEquals("い", ketteiSyaList.get(3).getKetsyanm());
        Assert.assertEquals("あいあ", ketteiSyaList.get(4).getKetsyanm());
        Assert.assertEquals("いいい", ketteiSyaList.get(5).getKetsyanm());
        Assert.assertEquals("うえお", ketteiSyaList.get(6).getKetsyanm());
    }

}
