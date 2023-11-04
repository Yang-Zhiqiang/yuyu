package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyouhnZokuseisByHyoujidateItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisByHyoujidateItems {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateItems(BizDate.valueOf(20160811), C_SyutkKbn.NONE,
            C_HknsyuruiNo.BLNK, 111, 11);

        Assert.assertEquals(0,syouhnZokuseiLst.size());

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("M101", 1);
        syouhnZokusei1.setHyoujifromymd(BizDate.valueOf(20160809));
        syouhnZokusei1.setHyoujitoymd(BizDate.valueOf(20160815));
        syouhnZokusei1.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        syouhnZokusei1.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        syouhnZokusei1.setNkgnshosyouritu(111);
        syouhnZokusei1.setDai1hknkkn(11);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("M101", 2);
        syouhnZokusei2.setHyoujifromymd(BizDate.valueOf(20160812));
        syouhnZokusei2.setHyoujitoymd(BizDate.valueOf(20160815));
        syouhnZokusei2.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        syouhnZokusei2.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        syouhnZokusei2.setNkgnshosyouritu(111);
        syouhnZokusei2.setDai1hknkkn(11);

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("M101", 3);
        syouhnZokusei3.setHyoujifromymd(BizDate.valueOf(20160809));
        syouhnZokusei3.setHyoujitoymd(BizDate.valueOf(20160810));
        syouhnZokusei3.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        syouhnZokusei3.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        syouhnZokusei3.setNkgnshosyouritu(111);
        syouhnZokusei3.setDai1hknkkn(11);

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("M101", 4);
        syouhnZokusei4.setHyoujifromymd(BizDate.valueOf(20160809));
        syouhnZokusei4.setHyoujitoymd(BizDate.valueOf(20160815));
        syouhnZokusei4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        syouhnZokusei4.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        syouhnZokusei4.setNkgnshosyouritu(111);
        syouhnZokusei4.setDai1hknkkn(11);

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei("M101", 5);
        syouhnZokusei5.setHyoujifromymd(BizDate.valueOf(20160809));
        syouhnZokusei5.setHyoujitoymd(BizDate.valueOf(20160815));
        syouhnZokusei5.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        syouhnZokusei5.setHknsyuruino(C_HknsyuruiNo.valueOf("441"));
        syouhnZokusei5.setNkgnshosyouritu(111);
        syouhnZokusei5.setDai1hknkkn(11);

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei("M101", 6);
        syouhnZokusei6.setHyoujifromymd(BizDate.valueOf(20160809));
        syouhnZokusei6.setHyoujitoymd(BizDate.valueOf(20160815));
        syouhnZokusei6.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        syouhnZokusei6.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        syouhnZokusei6.setNkgnshosyouritu(222);
        syouhnZokusei6.setDai1hknkkn(11);

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei7 = new BM_SyouhnZokusei("M101", 7);
        syouhnZokusei7.setHyoujifromymd(BizDate.valueOf(20160809));
        syouhnZokusei7.setHyoujitoymd(BizDate.valueOf(20160815));
        syouhnZokusei7.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        syouhnZokusei7.setHknsyuruino(C_HknsyuruiNo.valueOf("000"));
        syouhnZokusei7.setNkgnshosyouritu(111);
        syouhnZokusei7.setDai1hknkkn(22);

        bizDomManager.insert(syouhnZokusei7);

        BM_SyouhnZokusei syouhnZokusei8 = new BM_SyouhnZokusei("M102", 1);
        syouhnZokusei8.setHyoujifromymd(BizDate.valueOf(20160909));
        syouhnZokusei8.setHyoujitoymd(BizDate.valueOf(20160911));
        syouhnZokusei8.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        syouhnZokusei8.setHknsyuruino(C_HknsyuruiNo.valueOf("442"));
        syouhnZokusei8.setNkgnshosyouritu(333);
        syouhnZokusei8.setDai1hknkkn(33);

        bizDomManager.insert(syouhnZokusei8);

        BM_SyouhnZokusei syouhnZokusei9 = new BM_SyouhnZokusei("M103", 1);
        syouhnZokusei9.setHyoujifromymd(BizDate.valueOf(20160910));
        syouhnZokusei9.setHyoujitoymd(BizDate.valueOf(20160912));
        syouhnZokusei9.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        syouhnZokusei9.setHknsyuruino(C_HknsyuruiNo.valueOf("442"));
        syouhnZokusei9.setNkgnshosyouritu(333);
        syouhnZokusei9.setDai1hknkkn(33);

        bizDomManager.insert(syouhnZokusei9);

        BM_SyouhnZokusei syouhnZokusei10 = new BM_SyouhnZokusei("M104", 1);
        syouhnZokusei10.setHyoujifromymd(BizDate.valueOf(20160908));
        syouhnZokusei10.setHyoujitoymd(BizDate.valueOf(20160910));
        syouhnZokusei10.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        syouhnZokusei10.setHknsyuruino(C_HknsyuruiNo.valueOf("442"));
        syouhnZokusei10.setNkgnshosyouritu(333);
        syouhnZokusei10.setDai1hknkkn(33);

        bizDomManager.insert(syouhnZokusei10);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateItems(BizDate.valueOf(20160811), C_SyutkKbn.SYU,
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, 222, 22);

        assertEquals(0, syouhnZokuseiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateItems(BizDate.valueOf(20160811), C_SyutkKbn.NONE,
            C_HknsyuruiNo.BLNK, 111, 11);

        assertEquals(1, syouhnZokuseiLst.size());
        assertEquals("M101", syouhnZokuseiLst.get(0).getSyouhncd());
        assertEquals(1, syouhnZokuseiLst.get(0).getSyouhnsdno().intValue());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateItems(BizDate.valueOf(20160910), C_SyutkKbn.TK,
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, 333, 33);

        assertEquals(3, syouhnZokuseiLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("M102",1), "1");
        map.put($("M103",1), "1");
        map.put($("M104",1), "1");

        for(BM_SyouhnZokusei syouhnZokusei:syouhnZokuseiLst){
            map.remove($(syouhnZokusei.getSyouhncd(),syouhnZokusei.getSyouhnsdno().intValue()));
        }
        assertTrue(map.isEmpty());
    }
}
