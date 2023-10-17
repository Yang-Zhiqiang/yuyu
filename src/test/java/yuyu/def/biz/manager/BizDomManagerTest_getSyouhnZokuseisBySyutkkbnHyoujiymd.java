package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性マスタのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisBySyutkkbnHyoujiymd {

    @Inject
    private BizDomManager bizDomManager;
    private final static BizDate hyoujiDate1 = BizDate.valueOf(20150410);
    private final static BizDate hyoujiDate2 = BizDate.valueOf(20150112);
    private final static BizDate hyoujiDate3 = BizDate.valueOf(20150425);

    private final static C_SyutkKbn syutkKbn0 = C_SyutkKbn.NONE;
    private final static C_SyutkKbn syutkKbn1 = C_SyutkKbn.SYU;
    private final static C_SyutkKbn syutkKbn2 = C_SyutkKbn.TK;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyutkkbnHyoujiymd(syutkKbn1,
            hyoujiDate3);
        Assert.assertEquals(0, syouhnZokuseiLst.size());

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("M110", 1);
        syouhnZokusei1.setMossyohnsortno(2);
        syouhnZokusei1.setHyoujifromymd(BizDate.valueOf(20150401));
        syouhnZokusei1.setHyoujitoymd(BizDate.valueOf(20150501));
        syouhnZokusei1.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("M110", 2);
        syouhnZokusei2.setMossyohnsortno(2);
        syouhnZokusei2.setHyoujifromymd(BizDate.valueOf(20150425));
        syouhnZokusei2.setHyoujitoymd(BizDate.valueOf(20150425));
        syouhnZokusei2.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("M110", 3);
        syouhnZokusei3.setMossyohnsortno(2);
        syouhnZokusei3.setHyoujifromymd(BizDate.valueOf(20150424));
        syouhnZokusei3.setHyoujitoymd(BizDate.valueOf(20150426));
        syouhnZokusei3.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("M110", 4);
        syouhnZokusei4.setMossyohnsortno(2);
        syouhnZokusei4.setHyoujifromymd(BizDate.valueOf(20150424));
        syouhnZokusei4.setHyoujitoymd(BizDate.valueOf(20150426));
        syouhnZokusei4.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei("M110", 8);
        syouhnZokusei5.setMossyohnsortno(2);
        syouhnZokusei5.setHyoujifromymd(BizDate.valueOf(20150426));
        syouhnZokusei5.setHyoujitoymd(BizDate.valueOf(20150426));
        syouhnZokusei5.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei("M110", 9);
        syouhnZokusei6.setMossyohnsortno(2);
        syouhnZokusei6.setHyoujifromymd(BizDate.valueOf(20150423));
        syouhnZokusei6.setHyoujitoymd(BizDate.valueOf(20150424));
        syouhnZokusei6.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei7 = new BM_SyouhnZokusei("M110", 7);
        syouhnZokusei7.setMossyohnsortno(2);
        syouhnZokusei7.setHyoujifromymd(BizDate.valueOf(20150425));
        syouhnZokusei7.setHyoujitoymd(BizDate.valueOf(20150425));
        syouhnZokusei7.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei7);

        BM_SyouhnZokusei syouhnZokusei8 = new BM_SyouhnZokusei("M120", 6);
        syouhnZokusei8.setMossyohnsortno(3);
        syouhnZokusei8.setHyoujifromymd(BizDate.valueOf(20150425));
        syouhnZokusei8.setHyoujitoymd(BizDate.valueOf(20150425));
        syouhnZokusei8.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei8);

        BM_SyouhnZokusei syouhnZokusei9 = new BM_SyouhnZokusei("M120", 5);
        syouhnZokusei9.setMossyohnsortno(3);
        syouhnZokusei9.setHyoujifromymd(BizDate.valueOf(20150301));
        syouhnZokusei9.setHyoujitoymd(BizDate.valueOf(20150601));
        syouhnZokusei9.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei9);

        BM_SyouhnZokusei syouhnZokusei10 = new BM_SyouhnZokusei("M120", 7);
        syouhnZokusei10.setMossyohnsortno(3);
        syouhnZokusei10.setHyoujifromymd(BizDate.valueOf(20150426));
        syouhnZokusei10.setHyoujitoymd(BizDate.valueOf(20150601));
        syouhnZokusei10.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei10);

        BM_SyouhnZokusei syouhnZokusei11 = new BM_SyouhnZokusei("M120", 8);
        syouhnZokusei11.setMossyohnsortno(3);
        syouhnZokusei11.setHyoujifromymd(BizDate.valueOf(20150324));
        syouhnZokusei11.setHyoujitoymd(BizDate.valueOf(20150401));
        syouhnZokusei11.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei11);

        BM_SyouhnZokusei syouhnZokusei12 = new BM_SyouhnZokusei("M120", 9);
        syouhnZokusei12.setMossyohnsortno(3);
        syouhnZokusei12.setHyoujifromymd(BizDate.valueOf(20150424));
        syouhnZokusei12.setHyoujitoymd(BizDate.valueOf(20150429));
        syouhnZokusei12.setSyutkkbn(C_SyutkKbn.TK);

        bizDomManager.insert(syouhnZokusei12);

        BM_SyouhnZokusei syouhnZokusei13 = new BM_SyouhnZokusei("M130", 1);
        syouhnZokusei13.setMossyohnsortno(4);
        syouhnZokusei13.setHyoujifromymd(BizDate.valueOf(20150424));
        syouhnZokusei13.setHyoujitoymd(BizDate.valueOf(20150426));
        syouhnZokusei13.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei13);

        BM_SyouhnZokusei syouhnZokusei14 = new BM_SyouhnZokusei("M130", 2);
        syouhnZokusei14.setMossyohnsortno(4);
        syouhnZokusei14.setHyoujifromymd(BizDate.valueOf(20150425));
        syouhnZokusei14.setHyoujitoymd(BizDate.valueOf(20150425));
        syouhnZokusei14.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei14);

        BM_SyouhnZokusei syouhnZokusei15 = new BM_SyouhnZokusei("M150", 1);
        syouhnZokusei15.setMossyohnsortno(1);
        syouhnZokusei15.setHyoujifromymd(BizDate.valueOf(20150425));
        syouhnZokusei15.setHyoujitoymd(BizDate.valueOf(20150425));
        syouhnZokusei15.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei15);

        BM_SyouhnZokusei syouhnZokusei16 = new BM_SyouhnZokusei("M150", 2);
        syouhnZokusei16.setMossyohnsortno(1);
        syouhnZokusei16.setHyoujifromymd(BizDate.valueOf(20150421));
        syouhnZokusei16.setHyoujitoymd(BizDate.valueOf(20150426));
        syouhnZokusei16.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei16);

        BM_SyouhnZokusei syouhnZokusei17 = new BM_SyouhnZokusei("M150", 3);
        syouhnZokusei17.setMossyohnsortno(1);
        syouhnZokusei17.setHyoujifromymd(BizDate.valueOf(20150425));
        syouhnZokusei17.setHyoujitoymd(BizDate.valueOf(20150425));
        syouhnZokusei17.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei17);

        BM_SyouhnZokusei syouhnZokusei18 = new BM_SyouhnZokusei("M150", 4);
        syouhnZokusei18.setMossyohnsortno(1);
        syouhnZokusei18.setHyoujifromymd(BizDate.valueOf(20150426));
        syouhnZokusei18.setHyoujitoymd(BizDate.valueOf(20150424));
        syouhnZokusei18.setSyutkkbn(C_SyutkKbn.SYU);

        bizDomManager.insert(syouhnZokusei18);

        BM_SyouhnZokusei syouhnZokusei19 = new BM_SyouhnZokusei("M140", 1);
        syouhnZokusei19.setMossyohnsortno(5);
        syouhnZokusei19.setHyoujifromymd(BizDate.valueOf(20150111));
        syouhnZokusei19.setHyoujitoymd(BizDate.valueOf(20150113));
        syouhnZokusei19.setSyutkkbn(C_SyutkKbn.TK);

        bizDomManager.insert(syouhnZokusei19);

        BM_SyouhnZokusei syouhnZokusei20 = new BM_SyouhnZokusei("M140", 2);
        syouhnZokusei20.setMossyohnsortno(5);
        syouhnZokusei20.setHyoujifromymd(BizDate.valueOf(20150112));
        syouhnZokusei20.setHyoujitoymd(BizDate.valueOf(20150112));
        syouhnZokusei20.setSyutkkbn(C_SyutkKbn.TK);

        bizDomManager.insert(syouhnZokusei20);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyutkkbnHyoujiymd(syutkKbn0,
            hyoujiDate1);
        Assert.assertEquals(0, syouhnZokuseiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyutkkbnHyoujiymd(syutkKbn2,
            hyoujiDate2);
        Assert.assertEquals(1, syouhnZokuseiLst.size());

        Assert.assertEquals("M140", syouhnZokuseiLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(2), syouhnZokuseiLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(5), syouhnZokuseiLst.get(0).getMossyohnsortno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyutkkbnHyoujiymd(syutkKbn1,
            hyoujiDate3);
        Assert.assertEquals(3, syouhnZokuseiLst.size());

        Assert.assertEquals("M150", syouhnZokuseiLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(3), syouhnZokuseiLst.get(0).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(1), syouhnZokuseiLst.get(0).getMossyohnsortno());

        Assert.assertEquals("M110", syouhnZokuseiLst.get(1).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(7), syouhnZokuseiLst.get(1).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(2), syouhnZokuseiLst.get(1).getMossyohnsortno());

        Assert.assertEquals("M130", syouhnZokuseiLst.get(2).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(2), syouhnZokuseiLst.get(2).getSyouhnsdno());
        Assert.assertEquals(Integer.valueOf(4), syouhnZokuseiLst.get(2).getMossyohnsortno());
    }
}
