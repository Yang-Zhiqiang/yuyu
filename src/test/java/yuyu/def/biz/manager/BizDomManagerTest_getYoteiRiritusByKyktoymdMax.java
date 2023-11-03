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

import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritusByKyktoymdMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritusByKyktoymdMax {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByKyktoymdMax();
        Assert.assertEquals(0,yoteiRirituLst.size());

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu("0001", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu("0001", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606), BizDate.valueOf(20171009));

        bizDomManager.insert(yoteiRiritu2);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByKyktoymdMax();

        Assert.assertEquals(1,yoteiRirituLst.size());

        Assert.assertEquals("0001",yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.BLNK ,yoteiRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,yoteiRirituLst.get(0).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(0).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(0).getKyktoymd());

        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu("0003", C_Tuukasyu.USD, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu("0002", C_Tuukasyu.EUR, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu("0001", C_Tuukasyu.USD, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu("0001", C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606),
                BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,
                BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.NANAJYUUGOSAIIKA,
                BizDate.valueOf(20160604), BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu yoteiRiritu7 = new BM_YoteiRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606),
                BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu7);

        BM_YoteiRiritu yoteiRiritu8 = new BM_YoteiRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, BizDate.valueOf(20160605),
                BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu8);

        BM_YoteiRiritu yoteiRiritu9 = new BM_YoteiRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, BizDate.valueOf(20160604),
                BizDate.valueOf(20171010));

        bizDomManager.insert(yoteiRiritu9);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusByKyktoymdMax();

        Assert.assertEquals(9,yoteiRirituLst.size());

        Assert.assertEquals("0001",yoteiRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,yoteiRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,yoteiRirituLst.get(0).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160604),yoteiRirituLst.get(0).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(0).getKyktoymd());

        Assert.assertEquals("0001",yoteiRirituLst.get(1).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,yoteiRirituLst.get(1).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,yoteiRirituLst.get(1).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160605),yoteiRirituLst.get(1).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(1).getKyktoymd());

        Assert.assertEquals("0001",yoteiRirituLst.get(2).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,yoteiRirituLst.get(2).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,yoteiRirituLst.get(2).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(2).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(2).getKyktoymd());

        Assert.assertEquals("0001",yoteiRirituLst.get(3).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,yoteiRirituLst.get(3).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUGOSAIIKA,yoteiRirituLst.get(3).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160604),yoteiRirituLst.get(3).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(3).getKyktoymd());

        Assert.assertEquals("0001",yoteiRirituLst.get(4).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,yoteiRirituLst.get(4).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,yoteiRirituLst.get(4).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(4).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(4).getKyktoymd());

        Assert.assertEquals("0001",yoteiRirituLst.get(5).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.JPY ,yoteiRirituLst.get(5).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,yoteiRirituLst.get(5).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(5).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(5).getKyktoymd());

        Assert.assertEquals("0001",yoteiRirituLst.get(6).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.USD ,yoteiRirituLst.get(6).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,yoteiRirituLst.get(6).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(6).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(6).getKyktoymd());

        Assert.assertEquals("0002",yoteiRirituLst.get(7).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,yoteiRirituLst.get(7).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,yoteiRirituLst.get(7).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(7).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(7).getKyktoymd());

        Assert.assertEquals("0003",yoteiRirituLst.get(8).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.USD ,yoteiRirituLst.get(8).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,yoteiRirituLst.get(8).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),yoteiRirituLst.get(8).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),yoteiRirituLst.get(8).getKyktoymd());
    }
}

