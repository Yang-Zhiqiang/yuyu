package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_YoteiRiritu2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritu2sBySyouhncdKijyuntoymdMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritu2sBySyouhncdKijyuntoymdMax {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu2> yoteiRiritu2Lst = bizDomManager.getYoteiRiritu2sBySyouhncdKijyuntoymdMax("9999");
        Assert.assertEquals(0, yoteiRiritu2Lst.size());

        BM_YoteiRiritu2 yoteiRiritu21 = new BM_YoteiRiritu2("0001", "", "", BizDate.valueOf(20190101), BizDate.valueOf(20190105));
        bizDomManager.insert(yoteiRiritu21);

        BM_YoteiRiritu2 yoteiRiritu22 = new BM_YoteiRiritu2("0001", "", "", BizDate.valueOf(20190106), BizDate.valueOf(20190110));
        bizDomManager.insert(yoteiRiritu22);

        BM_YoteiRiritu2 yoteiRiritu23 = new BM_YoteiRiritu2("0002", "1", "11", BizDate.valueOf(20190101), BizDate.valueOf(20190110));
        bizDomManager.insert(yoteiRiritu23);

        BM_YoteiRiritu2 yoteiRiritu24 = new BM_YoteiRiritu2("0002", "2", "22", BizDate.valueOf(20190102), BizDate.valueOf(20190110));
        bizDomManager.insert(yoteiRiritu24);

        BM_YoteiRiritu2 yoteiRiritu25 = new BM_YoteiRiritu2("0002", "3", "33", BizDate.valueOf(20190103), BizDate.valueOf(20190109));
        bizDomManager.insert(yoteiRiritu25);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu2());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_YoteiRiritu2> yoteiRiritu2Lst = bizDomManager.getYoteiRiritu2sBySyouhncdKijyuntoymdMax("9999");

        Assert.assertEquals(0, yoteiRiritu2Lst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_YoteiRiritu2> yoteiRiritu2Lst = bizDomManager.getYoteiRiritu2sBySyouhncdKijyuntoymdMax("0001");

        Assert.assertEquals(1, yoteiRiritu2Lst.size());

        Assert.assertEquals("0001", yoteiRiritu2Lst.get(0).getSyouhncd());
        Assert.assertEquals("", yoteiRiritu2Lst.get(0).getYoteiriritutkybr1());
        Assert.assertEquals("", yoteiRiritu2Lst.get(0).getYoteiriritutkybr2());
        Assert.assertEquals(BizDate.valueOf(20190106), yoteiRiritu2Lst.get(0).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20190110), yoteiRiritu2Lst.get(0).getKijyuntoymd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_YoteiRiritu2> yoteiRiritu2Lst = bizDomManager.getYoteiRiritu2sBySyouhncdKijyuntoymdMax("0002");

        Assert.assertEquals(2, yoteiRiritu2Lst.size());

        Assert.assertEquals("0002", yoteiRiritu2Lst.get(0).getSyouhncd());
        Assert.assertEquals("1", yoteiRiritu2Lst.get(0).getYoteiriritutkybr1());
        Assert.assertEquals("11", yoteiRiritu2Lst.get(0).getYoteiriritutkybr2());
        Assert.assertEquals(BizDate.valueOf(20190101), yoteiRiritu2Lst.get(0).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20190110), yoteiRiritu2Lst.get(0).getKijyuntoymd());

        Assert.assertEquals("0002", yoteiRiritu2Lst.get(1).getSyouhncd());
        Assert.assertEquals("2", yoteiRiritu2Lst.get(1).getYoteiriritutkybr1());
        Assert.assertEquals("22", yoteiRiritu2Lst.get(1).getYoteiriritutkybr2());
        Assert.assertEquals(BizDate.valueOf(20190102), yoteiRiritu2Lst.get(1).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20190110), yoteiRiritu2Lst.get(1).getKijyuntoymd());

    }

}
