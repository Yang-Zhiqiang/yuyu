package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;


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

import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 新契約当日異動内容編集<br />
 * 当日異動内容新契約テーブルエンティティリスト取得(申込番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTjtIdouNySksByMosno {

    @Inject
    BizDomManager bizDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";
    static String P_MOSNO_04 = "791112253";
    static Integer P_RENNO3KETA_01 = new Integer(100);
    static Integer P_RENNO3KETA_02 = new Integer(200);
    static Integer P_RENNO3KETA_03 = new Integer(300);
    static Integer P_RENNO3KETA_04 = new Integer(400);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_TjtIdouNySk> bT_TjtIdouNySks = bizDomManager.getTjtIdouNySksByMosno(P_MOSNO_01);

        Assert.assertEquals(0, bT_TjtIdouNySks.size());

        BT_TjtIdouNySk bT_TjtIdouNySk1 = new BT_TjtIdouNySk(P_MOSNO_01, P_RENNO3KETA_01);
        bizDomManager.insert(bT_TjtIdouNySk1);

        BT_TjtIdouNySk bT_TjtIdouNySk2 = new BT_TjtIdouNySk(P_MOSNO_03, P_RENNO3KETA_02);
        bizDomManager.insert(bT_TjtIdouNySk2);

        BT_TjtIdouNySk bT_TjtIdouNySk3 = new BT_TjtIdouNySk(P_MOSNO_03, P_RENNO3KETA_03);
        bizDomManager.insert(bT_TjtIdouNySk3);

        BT_TjtIdouNySk bT_TjtIdouNySk4 = new BT_TjtIdouNySk(P_MOSNO_03, P_RENNO3KETA_04);
        bizDomManager.insert(bT_TjtIdouNySk4);

        BT_TjtIdouNySk bT_TjtIdouNySk5 = new BT_TjtIdouNySk(P_MOSNO_04, P_RENNO3KETA_04);
        bizDomManager.insert(bT_TjtIdouNySk5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_TjtIdouNySk> bT_TjtIdouNySks = bizDomManager.getTjtIdouNySksByMosno(P_MOSNO_02);

        Assert.assertEquals(0, bT_TjtIdouNySks.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_TjtIdouNySk> bT_TjtIdouNySks = bizDomManager.getTjtIdouNySksByMosno(P_MOSNO_01);

        Assert.assertEquals(1, bT_TjtIdouNySks.size());

        Assert.assertEquals(P_MOSNO_01, bT_TjtIdouNySks.get(0).getMosno());
        Assert.assertEquals(P_RENNO3KETA_01, bT_TjtIdouNySks.get(0).getRenno3keta());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_TjtIdouNySk> bT_TjtIdouNySks = bizDomManager.getTjtIdouNySksByMosno(P_MOSNO_03);

        Assert.assertEquals(3, bT_TjtIdouNySks.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_MOSNO_03,P_RENNO3KETA_02), "1");
        map.put($(P_MOSNO_03,P_RENNO3KETA_03), "1");
        map.put($(P_MOSNO_03,P_RENNO3KETA_04), "1");
        for(BT_TjtIdouNySk tjtIdouNySk : bT_TjtIdouNySks){
            map.remove($(tjtIdouNySk.getMosno(),tjtIdouNySk.getRenno3keta()));
        }
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_TjtIdouNySk> bT_TjtIdouNySks = bizDomManager.getTjtIdouNySksByMosno("");

        assertEquals(0, bT_TjtIdouNySks.size());
    }
}
