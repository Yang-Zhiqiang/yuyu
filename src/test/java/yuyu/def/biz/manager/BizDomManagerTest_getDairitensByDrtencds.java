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

import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDairitensByDrtencds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDairitensByDrtencds {

    @Inject
    BizDomManager bizDomManager;

    private final static String[] drtencd1 = {"M10001","M10006"};
    private final static String[] drtencd2 = {"M10006","M10007"};
    private final static String[] drtencd3 = {"M10003","M10004","M10005"};
    private final static String[] drtencd4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByDrtencds(drtencd1);

        Assert.assertEquals(0,dairitenLst.size());

        BM_Dairiten dairiten1 = new BM_Dairiten("M10001");

        bizDomManager.insert(dairiten1);

        BM_Dairiten dairiten2 = new BM_Dairiten("M10002");

        bizDomManager.insert(dairiten2);

        BM_Dairiten dairiten3 = new BM_Dairiten("M10003");

        bizDomManager.insert(dairiten3);

        BM_Dairiten dairiten4 = new BM_Dairiten("M10004");

        bizDomManager.insert(dairiten4);

        BM_Dairiten dairiten5 = new BM_Dairiten("M10005");

        bizDomManager.insert(dairiten5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByDrtencds(drtencd2);

        assertEquals(0, dairitenLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByDrtencds(drtencd1);

        assertEquals(1, dairitenLst.size());
        assertEquals("M10001", dairitenLst.get(0).getDrtencd());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByDrtencds(drtencd3);

        assertEquals(3, dairitenLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("M10003"), "1");
        map.put($("M10004"), "1");
        map.put($("M10005"), "1");

        assertTrue(map.containsKey($(dairitenLst.get(0).getDrtencd())));
        assertTrue(map.containsKey($(dairitenLst.get(1).getDrtencd())));
        assertTrue(map.containsKey($(dairitenLst.get(2).getDrtencd())));

        map.remove($(dairitenLst.get(0).getDrtencd()));
        map.remove($(dairitenLst.get(1).getDrtencd()));
        map.remove($(dairitenLst.get(2).getDrtencd()));

        assertTrue(map.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_Dairiten> dairitenLst = bizDomManager.getDairitensByDrtencds(drtencd4);

        assertEquals(0, dairitenLst.size());
    }
}
