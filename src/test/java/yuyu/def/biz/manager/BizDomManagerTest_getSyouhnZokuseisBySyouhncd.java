package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性マスタのテストクラス
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisBySyouhncd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd("A111");

        Assert.assertEquals(0, syouhnZokuseiLst.size());

        BM_SyouhnZokusei syouhnZokuse1 = new BM_SyouhnZokusei("A111",1);
        syouhnZokuse1.setSyouhnnm("商品あ");
        bizDomManager.insert(syouhnZokuse1);

        BM_SyouhnZokusei syouhnZokuse2 = new BM_SyouhnZokusei("A112",2);
        syouhnZokuse2.setSyouhnnm("商品い");
        bizDomManager.insert(syouhnZokuse2);

        BM_SyouhnZokusei syouhnZokuse3 = new BM_SyouhnZokusei("A113",3);
        syouhnZokuse3.setSyouhnnm("商品う");
        bizDomManager.insert(syouhnZokuse3);

        BM_SyouhnZokusei syouhnZokuse4 = new BM_SyouhnZokusei("A113",4);
        syouhnZokuse4.setSyouhnnm("商品え");
        bizDomManager.insert(syouhnZokuse4);

        BM_SyouhnZokusei syouhnZokuse5 = new BM_SyouhnZokusei("A113",5);
        syouhnZokuse5.setSyouhnnm("商品お");
        bizDomManager.insert(syouhnZokuse5);



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

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd("A116");

        Assert.assertEquals(0, syouhnZokuseiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd("A111");

        Assert.assertEquals(1, syouhnZokuseiLst.size());
        assertEquals("A111", syouhnZokuseiLst.get(0).getSyouhncd());
        assertEquals(1, syouhnZokuseiLst.get(0).getSyouhnsdno().intValue());
        assertEquals("商品あ", syouhnZokuseiLst.get(0).getSyouhnnm());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd("A113");

        Assert.assertEquals(3, syouhnZokuseiLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("A113",3,"商品う"), "1");
        map.put($("A113",4,"商品え"), "1");
        map.put($("A113",5,"商品お"), "1");

        for(BM_SyouhnZokusei syouhnZokusei : syouhnZokuseiLst){
            map.remove($(syouhnZokusei.getSyouhncd(),syouhnZokusei.getSyouhnsdno().intValue(),syouhnZokusei.getSyouhnnm()));
        }
        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd("");

        Assert.assertEquals(0, syouhnZokuseiLst.size());
    }

}
