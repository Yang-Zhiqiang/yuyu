package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRirituRendouSeigyosByYoteirirituhanteid() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRirituRendouSeigyosByYoteirirituhanteid {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRirituRendouSeigyo> yoteiRirituRendouSeigyoLst = bizDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid("99");
        Assert.assertEquals(0, yoteiRirituRendouSeigyoLst.size());

        BM_YoteiRirituRendouSeigyo yoteiRirituRendouSeigyo1 = new BM_YoteiRirituRendouSeigyo("01", "15", "ﾕｱ");
        bizDomManager.insert(yoteiRirituRendouSeigyo1);

        BM_YoteiRirituRendouSeigyo yoteiRirituRendouSeigyo2 = new BM_YoteiRirituRendouSeigyo("16", "31", "ﾕｲ");
        bizDomManager.insert(yoteiRirituRendouSeigyo2);

        BM_YoteiRirituRendouSeigyo yoteiRirituRendouSeigyo3 = new BM_YoteiRirituRendouSeigyo("16", "31", "ﾕｳ");
        bizDomManager.insert(yoteiRirituRendouSeigyo3);

        BM_YoteiRirituRendouSeigyo yoteiRirituRendouSeigyo4 = new BM_YoteiRirituRendouSeigyo("16", "31", "ﾕｴ");
        bizDomManager.insert(yoteiRirituRendouSeigyo4);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_YoteiRirituRendouSeigyo> yoteiRirituRendouSeigyoLst = bizDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid("99");

        Assert.assertEquals(0, yoteiRirituRendouSeigyoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_YoteiRirituRendouSeigyo> yoteiRirituRendouSeigyoLst = bizDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid("01");

        Assert.assertEquals(1, yoteiRirituRendouSeigyoLst.size());
        Assert.assertEquals("01", yoteiRirituRendouSeigyoLst.get(0).getYoteirirituhanteidfrom());
        Assert.assertEquals("15", yoteiRirituRendouSeigyoLst.get(0).getYoteirirituhanteidto());
        Assert.assertEquals("ﾕｱ", yoteiRirituRendouSeigyoLst.get(0).getSyouhncd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_YoteiRirituRendouSeigyo> yoteiRirituRendouSeigyoLst = bizDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid("20");

        Assert.assertEquals(3, yoteiRirituRendouSeigyoLst.size());

        Assert.assertEquals("16", yoteiRirituRendouSeigyoLst.get(0).getYoteirirituhanteidfrom());
        Assert.assertEquals("31", yoteiRirituRendouSeigyoLst.get(0).getYoteirirituhanteidto());
        Assert.assertEquals("ﾕｲ", yoteiRirituRendouSeigyoLst.get(0).getSyouhncd());

        Assert.assertEquals("16", yoteiRirituRendouSeigyoLst.get(1).getYoteirirituhanteidfrom());
        Assert.assertEquals("31", yoteiRirituRendouSeigyoLst.get(1).getYoteirirituhanteidto());
        Assert.assertEquals("ﾕｳ", yoteiRirituRendouSeigyoLst.get(1).getSyouhncd());

        Assert.assertEquals("16", yoteiRirituRendouSeigyoLst.get(2).getYoteirirituhanteidfrom());
        Assert.assertEquals("31", yoteiRirituRendouSeigyoLst.get(2).getYoteirirituhanteidto());
        Assert.assertEquals("ﾕｴ", yoteiRirituRendouSeigyoLst.get(2).getSyouhncd());

    }

}
