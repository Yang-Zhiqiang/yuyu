package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金自動支払<br />
 * 当日異動内容年金支払テーブルエンティティリスト取得（年金証書番号）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNyNksByNksysyno {

    @Inject
    private BizDomManager bizDomManager;

    static String NKSYSYNO_1 = "11807111200";
    static String NKSYSYNO_2 = "11807111211";
    static String NKSYSYNO_3 = "11807111222";
    static String NKSYSYNO_4 = "";
    static Integer RENNO3KETA_01 = new Integer(101);
    static Integer RENNO3KETA_02 = new Integer(102);
    static Integer RENNO3KETA_03 = new Integer(103);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_TjtIdouNyNk> tjtIdouNyNks = bizDomManager.getTjtIdouNyNksByNksysyno(NKSYSYNO_1);
        Assert.assertEquals(0, tjtIdouNyNks.size());

        BT_TjtIdouNyNk bT_TjtIdouNyNk1 = new BT_TjtIdouNyNk(NKSYSYNO_1, RENNO3KETA_01);
        bizDomManager.insert(bT_TjtIdouNyNk1);

        BT_TjtIdouNyNk bT_TjtIdouNyNk2 = new BT_TjtIdouNyNk(NKSYSYNO_2, RENNO3KETA_01);
        bizDomManager.insert(bT_TjtIdouNyNk2);

        BT_TjtIdouNyNk bT_TjtIdouNyNk3 = new BT_TjtIdouNyNk(NKSYSYNO_2, RENNO3KETA_02);
        bizDomManager.insert(bT_TjtIdouNyNk3);

        BT_TjtIdouNyNk bT_TjtIdouNyNk4 = new BT_TjtIdouNyNk(NKSYSYNO_2, RENNO3KETA_03);
        bizDomManager.insert(bT_TjtIdouNyNk4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_TjtIdouNyNk> tjtIdouNyNks = bizDomManager.getTjtIdouNyNksByNksysyno(NKSYSYNO_3);

        Assert.assertEquals(0, tjtIdouNyNks.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_TjtIdouNyNk> tjtIdouNyNks = bizDomManager.getTjtIdouNyNksByNksysyno(NKSYSYNO_1);

        Assert.assertEquals(1, tjtIdouNyNks.size());
        Assert.assertEquals(NKSYSYNO_1, tjtIdouNyNks.get(0).getNksysyno());
        Assert.assertEquals(RENNO3KETA_01, tjtIdouNyNks.get(0).getRenno3keta());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_TjtIdouNyNk> tjtIdouNyNks = bizDomManager.getTjtIdouNyNksByNksysyno(NKSYSYNO_2);

        Assert.assertEquals(3, tjtIdouNyNks.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(NKSYSYNO_2,RENNO3KETA_01), "1");
        map.put($(NKSYSYNO_2,RENNO3KETA_02), "1");
        map.put($(NKSYSYNO_2,RENNO3KETA_03), "1");
        for(BT_TjtIdouNyNk tjtIdouNyNk : tjtIdouNyNks){
            map.remove($(tjtIdouNyNk.getNksysyno(),tjtIdouNyNk.getRenno3keta()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_TjtIdouNyNk> tjtIdouNyNks = bizDomManager.getTjtIdouNyNksByNksysyno(NKSYSYNO_4);

        Assert.assertEquals(0, tjtIdouNyNks.size());
    }
}
