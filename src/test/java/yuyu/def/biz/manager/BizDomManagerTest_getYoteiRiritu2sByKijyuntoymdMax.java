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

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu2;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritu2sByKijyuntoymdMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritu2sByKijyuntoymdMax {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu2> yoteiRirituLst = bizDomManager.getYoteiRiritu2sByKijyuntoymdMax();
        Assert.assertEquals(0, yoteiRirituLst.size());

        BM_YoteiRiritu2 yoteiRiritu1 = new BM_YoteiRiritu2("0001", "0", "0", BizDate.valueOf(20160606), BizDate.valueOf(20171010));
        yoteiRiritu1.setTuukasyu(C_Tuukasyu.BLNK);

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu2 yoteiRiritu2 = new BM_YoteiRiritu2("0001", "0", "0", BizDate.valueOf(20160606), BizDate.valueOf(20171009));
        yoteiRiritu2.setTuukasyu(C_Tuukasyu.BLNK);

        bizDomManager.insert(yoteiRiritu2);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu2());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        List<BM_YoteiRiritu2> yoteiRirituLst = bizDomManager.getYoteiRiritu2sByKijyuntoymdMax();

        Assert.assertEquals(1, yoteiRirituLst.size());

        Assert.assertEquals("0001", yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals("0", yoteiRirituLst.get(0).getYoteiriritutkybr1());
        Assert.assertEquals("0", yoteiRirituLst.get(0).getYoteiriritutkybr2());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(0).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(0).getKijyuntoymd());
        Assert.assertEquals(C_Tuukasyu.BLNK ,yoteiRirituLst.get(0).getTuukasyu());

        bizDomManager.delete(bizDomManager.getAllYoteiRiritu2());

        BM_YoteiRiritu2 yoteiRiritu1 = new BM_YoteiRiritu2("0003", "2", "2",
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));
        yoteiRiritu1.setTuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu2 yoteiRiritu2 = new BM_YoteiRiritu2("0002", "2", "2",
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));
        yoteiRiritu2.setTuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu2 yoteiRiritu3 = new BM_YoteiRiritu2("0001", "2", "2",
                BizDate.valueOf(20160607), BizDate.valueOf(20171010));
        yoteiRiritu3.setTuukasyu(C_Tuukasyu.USD);

        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu2 yoteiRiritu4 = new BM_YoteiRiritu2("0001", "0", "0",
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));
        yoteiRiritu4.setTuukasyu(C_Tuukasyu.JPY);

        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu2 yoteiRiritu5 = new BM_YoteiRiritu2("0001", "2", "2",
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));
        yoteiRiritu5.setTuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu2 yoteiRiritu6 = new BM_YoteiRiritu2("0001", "1", "1",
                BizDate.valueOf(20160604), BizDate.valueOf(20171010));
        yoteiRiritu6.setTuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu2 yoteiRiritu7 = new BM_YoteiRiritu2("0001", "0", "2",
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));
        yoteiRiritu7.setTuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(yoteiRiritu7);

        BM_YoteiRiritu2 yoteiRiritu8 = new BM_YoteiRiritu2("0001", "0", "2",
                BizDate.valueOf(20160605), BizDate.valueOf(20171010));
        yoteiRiritu8.setTuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(yoteiRiritu8);

        BM_YoteiRiritu2 yoteiRiritu9 = new BM_YoteiRiritu2("0001", "0", "1",
                BizDate.valueOf(20160604), BizDate.valueOf(20171010));
        yoteiRiritu9.setTuukasyu(C_Tuukasyu.EUR);

        bizDomManager.insert(yoteiRiritu9);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        List<BM_YoteiRiritu2> yoteiRirituLst = bizDomManager.getYoteiRiritu2sByKijyuntoymdMax();

        Assert.assertEquals(9, yoteiRirituLst.size());

        Assert.assertEquals("0001", yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals("0", yoteiRirituLst.get(0).getYoteiriritutkybr1());
        Assert.assertEquals("0", yoteiRirituLst.get(0).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.JPY , yoteiRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(0).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(0).getKijyuntoymd());

        Assert.assertEquals("0001", yoteiRirituLst.get(1).getSyouhncd());
        Assert.assertEquals("0", yoteiRirituLst.get(1).getYoteiriritutkybr1());
        Assert.assertEquals("1", yoteiRirituLst.get(1).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.EUR , yoteiRirituLst.get(1).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160604),yoteiRirituLst.get(1).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(1).getKijyuntoymd());

        Assert.assertEquals("0001", yoteiRirituLst.get(2).getSyouhncd());
        Assert.assertEquals("0", yoteiRirituLst.get(2).getYoteiriritutkybr1());
        Assert.assertEquals("2", yoteiRirituLst.get(2).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.EUR , yoteiRirituLst.get(2).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160605),yoteiRirituLst.get(2).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(2).getKijyuntoymd());

        Assert.assertEquals("0001", yoteiRirituLst.get(3).getSyouhncd());
        Assert.assertEquals("0", yoteiRirituLst.get(3).getYoteiriritutkybr1());
        Assert.assertEquals("2", yoteiRirituLst.get(3).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.EUR , yoteiRirituLst.get(3).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(3).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(3).getKijyuntoymd());

        Assert.assertEquals("0001", yoteiRirituLst.get(4).getSyouhncd());
        Assert.assertEquals("1", yoteiRirituLst.get(4).getYoteiriritutkybr1());
        Assert.assertEquals("1", yoteiRirituLst.get(4).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.EUR , yoteiRirituLst.get(4).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160604),yoteiRirituLst.get(4).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(4).getKijyuntoymd());

        Assert.assertEquals("0001", yoteiRirituLst.get(5).getSyouhncd());
        Assert.assertEquals("2", yoteiRirituLst.get(5).getYoteiriritutkybr1());
        Assert.assertEquals("2", yoteiRirituLst.get(5).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.EUR , yoteiRirituLst.get(5).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(5).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(5).getKijyuntoymd());

        Assert.assertEquals("0001", yoteiRirituLst.get(6).getSyouhncd());
        Assert.assertEquals("2", yoteiRirituLst.get(6).getYoteiriritutkybr1());
        Assert.assertEquals("2", yoteiRirituLst.get(6).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.USD , yoteiRirituLst.get(6).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160607),yoteiRirituLst.get(6).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(6).getKijyuntoymd());

        Assert.assertEquals("0002", yoteiRirituLst.get(7).getSyouhncd());
        Assert.assertEquals("2", yoteiRirituLst.get(7).getYoteiriritutkybr1());
        Assert.assertEquals("2", yoteiRirituLst.get(7).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.EUR , yoteiRirituLst.get(7).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(7).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(7).getKijyuntoymd());

        Assert.assertEquals("0003", yoteiRirituLst.get(8).getSyouhncd());
        Assert.assertEquals("2", yoteiRirituLst.get(8).getYoteiriritutkybr1());
        Assert.assertEquals("2", yoteiRirituLst.get(8).getYoteiriritutkybr2());
        Assert.assertEquals(C_Tuukasyu.USD , yoteiRirituLst.get(8).getTuukasyu());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(8).getKijyunfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(8).getKijyuntoymd());

    }
}

