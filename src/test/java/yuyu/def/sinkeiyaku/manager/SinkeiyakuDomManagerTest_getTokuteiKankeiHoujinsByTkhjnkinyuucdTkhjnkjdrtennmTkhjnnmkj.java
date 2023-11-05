package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("3", "共", "履");

        Assert.assertEquals(0,tokuteiKankeiHoujinLst.size());

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin1 = new HM_TokuteiKankeiHoujin("211", BizNumber.ZERO);
        tokuteiKankeiHoujin1.setTkhjnkjdrtennm("約保約");
        tokuteiKankeiHoujin1.setTkhjnnmkj("五丕五");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin1);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin2 = new HM_TokuteiKankeiHoujin("122", BizNumber.ONE);
        tokuteiKankeiHoujin2.setTkhjnkjdrtennm("保約保");
        tokuteiKankeiHoujin2.setTkhjnnmkj("丕五丕");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin2);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin3 = new HM_TokuteiKankeiHoujin("2", BizNumber.TEN);
        tokuteiKankeiHoujin3.setTkhjnkjdrtennm("保");
        tokuteiKankeiHoujin3.setTkhjnnmkj("丕");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin3);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin4 = new HM_TokuteiKankeiHoujin("1", BizNumber.ZERO);
        tokuteiKankeiHoujin4.setTkhjnkjdrtennm("約");
        tokuteiKankeiHoujin4.setTkhjnnmkj("五");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin4);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin5 = new HM_TokuteiKankeiHoujin("222", BizNumber.ONE);
        tokuteiKankeiHoujin5.setTkhjnkjdrtennm("保保保");
        tokuteiKankeiHoujin5.setTkhjnnmkj("丕丕丕");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin5);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin6 = new HM_TokuteiKankeiHoujin("111", BizNumber.TEN);
        tokuteiKankeiHoujin6.setTkhjnkjdrtennm("約約約");
        tokuteiKankeiHoujin6.setTkhjnnmkj("五五五");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin6);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin7 = new HM_TokuteiKankeiHoujin("345", BizNumber.ZERO);
        tokuteiKankeiHoujin7.setTkhjnkjdrtennm("務共変");
        tokuteiKankeiHoujin7.setTkhjnnmkj("更履歴");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin7);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin8 = new HM_TokuteiKankeiHoujin("988", BizNumber.ONE);
        tokuteiKankeiHoujin8.setTkhjnkjdrtennm("約保約");
        tokuteiKankeiHoujin8.setTkhjnnmkj("五丕五");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin8);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin9 = new HM_TokuteiKankeiHoujin("211", BizNumber.TEN);
        tokuteiKankeiHoujin9.setTkhjnkjdrtennm("仕様仕");
        tokuteiKankeiHoujin9.setTkhjnnmkj("五丕五");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin9);

        HM_TokuteiKankeiHoujin tokuteiKankeiHoujin10 = new HM_TokuteiKankeiHoujin("211", BizNumber.ONE);
        tokuteiKankeiHoujin10.setTkhjnkjdrtennm("約保約");
        tokuteiKankeiHoujin10.setTkhjnnmkj("紙表紙");

        sinkeiyakuDomManager.insert(tokuteiKankeiHoujin10);
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllTokuteiKankeiHoujin());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("8", "共", "履");

        Assert.assertEquals(0,tokuteiKankeiHoujinLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("3", "共", "履");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst.get(0).getMeisaino());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("22", "保保", "丕丕");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst.size());
        Assert.assertEquals("222", tokuteiKankeiHoujinLst.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst.get(0).getMeisaino());
    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("2", "保", "丕");

        Assert.assertEquals(3,tokuteiKankeiHoujinLst.size());
        Assert.assertEquals("2", tokuteiKankeiHoujinLst.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.TEN, tokuteiKankeiHoujinLst.get(0).getMeisaino());

        Assert.assertEquals("211", tokuteiKankeiHoujinLst.get(1).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst.get(1).getMeisaino());

        Assert.assertEquals("222", tokuteiKankeiHoujinLst.get(2).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst.get(2).getMeisaino());
    }

    @Test
    @TestOrder(50)
    public void blank1() {

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("", "共", "履");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst.get(0).getMeisaino());
    }

    @Test
    @TestOrder(60)
    public void blank2() {

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst1 = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("3", "", "履");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst1.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst1.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst1.get(0).getMeisaino());
    }

    @Test
    @TestOrder(70)
    public void blank3() {
        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst2 = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("3", "共", "");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst2.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst2.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst2.get(0).getMeisaino());

    }

    @Test
    @TestOrder(80)
    public void blank4() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("211",BizNumber.ZERO), "1");
        datamap.put($("211",BizNumber.ONE), "1");
        datamap.put($("211",BizNumber.TEN), "1");

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst2 = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("", "", "");

        Assert.assertEquals(10,tokuteiKankeiHoujinLst2.size());
        Assert.assertEquals("1", tokuteiKankeiHoujinLst2.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst2.get(0).getMeisaino());

        Assert.assertEquals("111", tokuteiKankeiHoujinLst2.get(1).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.TEN, tokuteiKankeiHoujinLst2.get(1).getMeisaino());

        Assert.assertEquals("122", tokuteiKankeiHoujinLst2.get(2).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst2.get(2).getMeisaino());

        Assert.assertEquals("2", tokuteiKankeiHoujinLst2.get(3).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.TEN, tokuteiKankeiHoujinLst2.get(3).getMeisaino());


        datamap.remove($(
            tokuteiKankeiHoujinLst2.get(4).getTkhjnkinyuucd(),
            tokuteiKankeiHoujinLst2.get(4).getMeisaino()));

        datamap.remove($(
            tokuteiKankeiHoujinLst2.get(5).getTkhjnkinyuucd(),
            tokuteiKankeiHoujinLst2.get(5).getMeisaino()));

        datamap.remove($(
            tokuteiKankeiHoujinLst2.get(6).getTkhjnkinyuucd(),
            tokuteiKankeiHoujinLst2.get(6).getMeisaino()));

        Assert.assertTrue(datamap.isEmpty());


        Assert.assertEquals("222", tokuteiKankeiHoujinLst2.get(7).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst2.get(7).getMeisaino());

        Assert.assertEquals("345", tokuteiKankeiHoujinLst2.get(8).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst2.get(8).getMeisaino());

        Assert.assertEquals("988", tokuteiKankeiHoujinLst2.get(9).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst2.get(9).getMeisaino());

    }

    @Test
    @TestOrder(90)
    public void blank5() {

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(null, "共", "履");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst.get(0).getMeisaino());
    }

    @Test
    @TestOrder(100)
    public void blank6() {

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst1 = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("3", null, "履");

        Assert.assertEquals(1,tokuteiKankeiHoujinLst1.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst1.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst1.get(0).getMeisaino());
    }

    @Test
    @TestOrder(110)
    public void blank7() {
        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst2 = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj("3", "共", null);

        Assert.assertEquals(1,tokuteiKankeiHoujinLst2.size());
        Assert.assertEquals("345", tokuteiKankeiHoujinLst2.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst2.get(0).getMeisaino());

    }

    @Test
    @TestOrder(120)
    public void blank8() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("211",BizNumber.ZERO), "1");
        datamap.put($("211",BizNumber.ONE), "1");
        datamap.put($("211",BizNumber.TEN), "1");

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst2 = sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(null, null, null);

        Assert.assertEquals(10,tokuteiKankeiHoujinLst2.size());
        Assert.assertEquals("1", tokuteiKankeiHoujinLst2.get(0).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst2.get(0).getMeisaino());

        Assert.assertEquals("111", tokuteiKankeiHoujinLst2.get(1).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.TEN, tokuteiKankeiHoujinLst2.get(1).getMeisaino());

        Assert.assertEquals("122", tokuteiKankeiHoujinLst2.get(2).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst2.get(2).getMeisaino());

        Assert.assertEquals("2", tokuteiKankeiHoujinLst2.get(3).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.TEN, tokuteiKankeiHoujinLst2.get(3).getMeisaino());


        datamap.remove($(
            tokuteiKankeiHoujinLst2.get(4).getTkhjnkinyuucd(),
            tokuteiKankeiHoujinLst2.get(4).getMeisaino()));

        datamap.remove($(
            tokuteiKankeiHoujinLst2.get(5).getTkhjnkinyuucd(),
            tokuteiKankeiHoujinLst2.get(5).getMeisaino()));

        datamap.remove($(
            tokuteiKankeiHoujinLst2.get(6).getTkhjnkinyuucd(),
            tokuteiKankeiHoujinLst2.get(6).getMeisaino()));

        Assert.assertTrue(datamap.isEmpty());


        Assert.assertEquals("222", tokuteiKankeiHoujinLst2.get(7).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst2.get(7).getMeisaino());

        Assert.assertEquals("345", tokuteiKankeiHoujinLst2.get(8).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ZERO, tokuteiKankeiHoujinLst2.get(8).getMeisaino());

        Assert.assertEquals("988", tokuteiKankeiHoujinLst2.get(9).getTkhjnkinyuucd());
        Assert.assertEquals(BizNumber.ONE, tokuteiKankeiHoujinLst2.get(9).getMeisaino());
    }
}
