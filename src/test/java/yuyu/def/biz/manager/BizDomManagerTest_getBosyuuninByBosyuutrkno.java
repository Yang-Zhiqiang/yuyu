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

import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getBosyuuninByBosyuutrkno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getBosyuuninByBosyuutrkno {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Bosyuunin> bosyuuninList = bizDomManager.getBosyuuninByBosyuutrkno("000002");
        Assert.assertEquals(0,bosyuuninList.size());

        BM_Bosyuunin bosyuunin1 = new BM_Bosyuunin("07");
        bosyuunin1.setBosyuuningyouhaiymd(BizDate.valueOf(20160507));
        bosyuunin1.setBosyuutrkno("000001");

        bizDomManager.insert(bosyuunin1);

        BM_Bosyuunin bosyuunin2 = new BM_Bosyuunin("04");
        bosyuunin2.setBosyuuningyouhaiymd(BizDate.valueOf(20160522));
        bosyuunin2.setBosyuutrkno("000002");

        bizDomManager.insert(bosyuunin2);

        BM_Bosyuunin bosyuunin3 = new BM_Bosyuunin("00");
        bosyuunin3.setBosyuuningyouhaiymd(BizDate.valueOf(20160523));
        bosyuunin3.setBosyuutrkno("000002");

        bizDomManager.insert(bosyuunin3);

        BM_Bosyuunin bosyuunin4 = new BM_Bosyuunin("03");
        bosyuunin4.setBosyuuningyouhaiymd(BizDate.valueOf(20160524));
        bosyuunin4.setBosyuutrkno("000002");

        bizDomManager.insert(bosyuunin4);

        BM_Bosyuunin bosyuunin5 = new BM_Bosyuunin("02");
        bosyuunin5.setBosyuuningyouhaiymd(BizDate.valueOf(20160524));
        bosyuunin5.setBosyuutrkno("000002");

        bizDomManager.insert(bosyuunin5);

        BM_Bosyuunin bosyuunin6 = new BM_Bosyuunin("01");
        bosyuunin6.setBosyuuningyouhaiymd(BizDate.valueOf(20160524));
        bosyuunin6.setBosyuutrkno("000002");

        bizDomManager.insert(bosyuunin6);

        BM_Bosyuunin bosyuunin7 = new BM_Bosyuunin("05");
        bosyuunin7.setBosyuuningyouhaiymd(BizDate.valueOf(20160525));
        bosyuunin7.setBosyuutrkno("000003");

        bizDomManager.insert(bosyuunin7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }
    @Test
    @TestOrder(10)
    public void noResult() {

        List<BM_Bosyuunin> bosyuuninList = bizDomManager.getBosyuuninByBosyuutrkno("000004");
        Assert.assertEquals(0,bosyuuninList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_Bosyuunin> bosyuuninList = bizDomManager.getBosyuuninByBosyuutrkno("000001");
        Assert.assertEquals(1,bosyuuninList.size());

        Assert.assertEquals("07",bosyuuninList.get(0).getBosyuucd());
        Assert.assertEquals(BizDate.valueOf(20160507),bosyuuninList.get(0).getBosyuuningyouhaiymd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_Bosyuunin> bosyuuninList = bizDomManager.getBosyuuninByBosyuutrkno("000002");
        Assert.assertEquals(5,bosyuuninList.size());

        Assert.assertEquals("01",bosyuuninList.get(0).getBosyuucd());
        Assert.assertEquals(BizDate.valueOf(20160524),bosyuuninList.get(0).getBosyuuningyouhaiymd());

        Assert.assertEquals("02",bosyuuninList.get(1).getBosyuucd());
        Assert.assertEquals(BizDate.valueOf(20160524),bosyuuninList.get(1).getBosyuuningyouhaiymd());

        Assert.assertEquals("03",bosyuuninList.get(2).getBosyuucd());
        Assert.assertEquals(BizDate.valueOf(20160524),bosyuuninList.get(2).getBosyuuningyouhaiymd());

        Assert.assertEquals("00",bosyuuninList.get(3).getBosyuucd());
        Assert.assertEquals(BizDate.valueOf(20160523),bosyuuninList.get(3).getBosyuuningyouhaiymd());

        Assert.assertEquals("04",bosyuuninList.get(4).getBosyuucd());
        Assert.assertEquals(BizDate.valueOf(20160522),bosyuuninList.get(4).getBosyuuningyouhaiymd());

    }

    @Test
    @TestOrder(40)
    public void blank() {

        List<BM_Bosyuunin> bosyuuninList = bizDomManager.getBosyuuninByBosyuutrkno("");
        Assert.assertEquals(0,bosyuuninList.size());

    }
}

