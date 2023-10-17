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
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSjkkkTyouseiyouRiritusByKyktoymdMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSjkkkTyouseiyouRiritusByKyktoymdMax {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusByKyktoymdMax();
        Assert.assertEquals(0,sjkkkTyouseiyouRirituLst.size());

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu1 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu1);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu2 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606), BizDate.valueOf(20171009));

        bizDomManager.insert(sjkkkTyouseiyouRiritu2);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu());

    }

    @Test
    @TestOrder(10)
    public void normal10() {

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusByKyktoymdMax();

        Assert.assertEquals(1,sjkkkTyouseiyouRirituLst.size());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.BLNK ,sjkkkTyouseiyouRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,sjkkkTyouseiyouRirituLst.get(0).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(0).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(0).getKyktoymd());
    }

    @Test
    @TestOrder(11)
    @Transactional
    public void normal11() {

        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu());

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu1 = new BM_SjkkkTyouseiyouRiritu("0003", C_Tuukasyu.USD, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu1);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu2 = new BM_SjkkkTyouseiyouRiritu("0002", C_Tuukasyu.EUR, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu2);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu3 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.USD, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu3);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu4 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu4);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu5 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu5);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu6 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.NANAJYUUGOSAIIKA, BizDate.valueOf(20160604), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu6);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu7 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, BizDate.valueOf(20160606), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu7);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu8 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, BizDate.valueOf(20160605), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu8);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu9 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.EUR, C_HhknNenKbn.BLNK, BizDate.valueOf(20160604), BizDate.valueOf(20171010));

        bizDomManager.insert(sjkkkTyouseiyouRiritu9);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusByKyktoymdMax();

        Assert.assertEquals(9,sjkkkTyouseiyouRirituLst.size());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(0).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,sjkkkTyouseiyouRirituLst.get(0).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,sjkkkTyouseiyouRirituLst.get(0).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160604),sjkkkTyouseiyouRirituLst.get(0).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(0).getKyktoymd());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(1).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,sjkkkTyouseiyouRirituLst.get(1).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,sjkkkTyouseiyouRirituLst.get(1).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160605),sjkkkTyouseiyouRirituLst.get(1).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(1).getKyktoymd());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(2).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,sjkkkTyouseiyouRirituLst.get(2).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,sjkkkTyouseiyouRirituLst.get(2).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(2).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(2).getKyktoymd());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(3).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,sjkkkTyouseiyouRirituLst.get(3).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUGOSAIIKA,sjkkkTyouseiyouRirituLst.get(3).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160604),sjkkkTyouseiyouRirituLst.get(3).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(3).getKyktoymd());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(4).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,sjkkkTyouseiyouRirituLst.get(4).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,sjkkkTyouseiyouRirituLst.get(4).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(4).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(4).getKyktoymd());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(5).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.JPY ,sjkkkTyouseiyouRirituLst.get(5).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.BLNK,sjkkkTyouseiyouRirituLst.get(5).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(5).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(5).getKyktoymd());

        Assert.assertEquals("0001",sjkkkTyouseiyouRirituLst.get(6).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.USD ,sjkkkTyouseiyouRirituLst.get(6).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,sjkkkTyouseiyouRirituLst.get(6).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(6).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(6).getKyktoymd());

        Assert.assertEquals("0002",sjkkkTyouseiyouRirituLst.get(7).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.EUR ,sjkkkTyouseiyouRirituLst.get(7).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,sjkkkTyouseiyouRirituLst.get(7).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(7).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(7).getKyktoymd());

        Assert.assertEquals("0003",sjkkkTyouseiyouRirituLst.get(8).getSyouhncd());
        Assert.assertEquals(C_Tuukasyu.USD ,sjkkkTyouseiyouRirituLst.get(8).getTuukasyu());
        Assert.assertEquals(C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,sjkkkTyouseiyouRirituLst.get(8).getHhknnenkbn());
        Assert.assertEquals(BizDate.valueOf(20160606),sjkkkTyouseiyouRirituLst.get(8).getKykfromymd());
        Assert.assertEquals(BizDate.valueOf(20171010),sjkkkTyouseiyouRirituLst.get(8).getKyktoymd());
    }
}


