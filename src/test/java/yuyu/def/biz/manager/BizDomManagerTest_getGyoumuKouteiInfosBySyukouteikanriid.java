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

import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * AKS連動ファイル作成<br />
 * 業務用工程情報テーブルエンティティリスト取得　主工程管理ＩＤのテストクラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGyoumuKouteiInfosBySyukouteikanriid {

    @Inject
    BizDomManager bizDomManager;

    static String P_KOUTEIKANRIID_01 = "KTKRID110";
    static String P_KOUTEIKANRIID_02 = "KTKRID120";
    static String P_KOUTEIKANRIID_03 = "KTKRID130";
    static String P_KOUTEIKANRIID_04 = "KTKRID140";
    static String P_SYUKOUTEIKANRIID_01 = "SKTKRID01";
    static String P_SYUKOUTEIKANRIID_02 = "SKTKRID02";
    static String P_SYUKOUTEIKANRIID_03 = "SKTKRID03";
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriid(P_SYUKOUTEIKANRIID_01);

        Assert.assertEquals(0,bT_GyoumuKouteiInfoLst.size());

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo1 = new BT_GyoumuKouteiInfo(P_KOUTEIKANRIID_01);
        bT_GyoumuKouteiInfo1.setSyukouteikanriid(P_SYUKOUTEIKANRIID_01);
        bizDomManager.insert(bT_GyoumuKouteiInfo1);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo2 = new BT_GyoumuKouteiInfo(P_KOUTEIKANRIID_02);
        bT_GyoumuKouteiInfo2.setSyukouteikanriid(P_SYUKOUTEIKANRIID_02);
        bizDomManager.insert(bT_GyoumuKouteiInfo2);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo3 = new BT_GyoumuKouteiInfo(P_KOUTEIKANRIID_03);
        bT_GyoumuKouteiInfo3.setSyukouteikanriid(P_SYUKOUTEIKANRIID_02);
        bizDomManager.insert(bT_GyoumuKouteiInfo3);

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo4 = new BT_GyoumuKouteiInfo(P_KOUTEIKANRIID_04);
        bT_GyoumuKouteiInfo4.setSyukouteikanriid(P_SYUKOUTEIKANRIID_02);
        bizDomManager.insert(bT_GyoumuKouteiInfo4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriid(P_SYUKOUTEIKANRIID_03);

        Assert.assertEquals(0,bT_GyoumuKouteiInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriid(P_SYUKOUTEIKANRIID_01);

        Assert.assertEquals(1,bT_GyoumuKouteiInfoLst.size());

        assertEquals(P_KOUTEIKANRIID_01,bT_GyoumuKouteiInfoLst.get(0).getKouteikanriid());

        assertEquals(P_SYUKOUTEIKANRIID_01,bT_GyoumuKouteiInfoLst.get(0).getSyukouteikanriid());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriid(P_SYUKOUTEIKANRIID_02);

        Assert.assertEquals(3,bT_GyoumuKouteiInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_KOUTEIKANRIID_02,P_SYUKOUTEIKANRIID_02),"1");
        map.put($(P_KOUTEIKANRIID_03,P_SYUKOUTEIKANRIID_02),"1");
        map.put($(P_KOUTEIKANRIID_04,P_SYUKOUTEIKANRIID_02),"1");

        assertTrue(map.containsKey($(bT_GyoumuKouteiInfoLst.get(0).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(0).getSyukouteikanriid())));
        assertTrue(map.containsKey($(bT_GyoumuKouteiInfoLst.get(1).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(1).getSyukouteikanriid())));
        assertTrue(map.containsKey($(bT_GyoumuKouteiInfoLst.get(2).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(2).getSyukouteikanriid())));

        map.remove($(bT_GyoumuKouteiInfoLst.get(0).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(0).getSyukouteikanriid()));
        map.remove($(bT_GyoumuKouteiInfoLst.get(1).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(1).getSyukouteikanriid()));
        map.remove($(bT_GyoumuKouteiInfoLst.get(2).getKouteikanriid(),bT_GyoumuKouteiInfoLst.get(2).getSyukouteikanriid()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosBySyukouteikanriid("");

        Assert.assertEquals(0, bT_GyoumuKouteiInfoLst.size());
    }
}
