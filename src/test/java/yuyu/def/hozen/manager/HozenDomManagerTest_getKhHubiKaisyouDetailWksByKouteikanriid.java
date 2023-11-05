package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全不備解消<br />
 * 契約保全不備解消詳細ワークテーブルエンティティリスト取得（工程管理ＩＤ）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHubiKaisyouDetailWksByKouteikanriid {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KOUTEIKANRIID_01 = "CH11807111118";
    static String P_KOUTEIKANRIID_02 = "CH11807111119";
    static String P_KOUTEIKANRIID_03 = "CH11807111120";
    static String P_KOUTEIKANRIID_04 = "CH11807111121";
    static Integer P_RENNO3KETA_01 = new Integer(123);
    static Integer P_RENNO3KETA_02 = new Integer(124);
    static Integer P_RENNO3KETA_03 = new Integer(125);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IW_KhHubiKaisyouDetailWk> iW_KhHubiKaisyouDetailWkLst = hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_01);

        Assert.assertEquals(0, iW_KhHubiKaisyouDetailWkLst.size());

        IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk1 = new IW_KhHubiKaisyouDetailWk(P_KOUTEIKANRIID_01,P_RENNO3KETA_01);
        hozenDomManager.insert(khHubiKaisyouDetailWk1);

        IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk2 = new IW_KhHubiKaisyouDetailWk(P_KOUTEIKANRIID_02,P_RENNO3KETA_01);
        hozenDomManager.insert(khHubiKaisyouDetailWk2);

        IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk3 = new IW_KhHubiKaisyouDetailWk(P_KOUTEIKANRIID_02,P_RENNO3KETA_02);
        hozenDomManager.insert(khHubiKaisyouDetailWk3);

        IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk4 = new IW_KhHubiKaisyouDetailWk(P_KOUTEIKANRIID_02,P_RENNO3KETA_03);
        hozenDomManager.insert(khHubiKaisyouDetailWk4);

        IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk5 = new IW_KhHubiKaisyouDetailWk(P_KOUTEIKANRIID_04,P_RENNO3KETA_03);
        hozenDomManager.insert(khHubiKaisyouDetailWk5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhHubiKaisyouDetailWk());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IW_KhHubiKaisyouDetailWk> iW_KhHubiKaisyouDetailWkLst = hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_03);

        assertEquals(0, iW_KhHubiKaisyouDetailWkLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IW_KhHubiKaisyouDetailWk> iW_KhHubiKaisyouDetailWkLst = hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_01);
        Assert.assertEquals(1, iW_KhHubiKaisyouDetailWkLst.size());

        Assert.assertEquals(P_KOUTEIKANRIID_01, iW_KhHubiKaisyouDetailWkLst.get(0).getKouteikanriid());
        Assert.assertEquals(P_RENNO3KETA_01, iW_KhHubiKaisyouDetailWkLst.get(0).getRenno3keta());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("CH11807111119","123"), "1");
        datamap.put($("CH11807111119","124"), "2");
        datamap.put($("CH11807111119","125"), "3");

        List<IW_KhHubiKaisyouDetailWk> iW_KhHubiKaisyouDetailWkLst = hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_02);

        for(IW_KhHubiKaisyouDetailWk khHubiKaisyouDetailWk:iW_KhHubiKaisyouDetailWkLst){
            datamap.remove($(khHubiKaisyouDetailWk.getKouteikanriid(),khHubiKaisyouDetailWk.getRenno3keta()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IW_KhHubiKaisyouDetailWk> iW_KhHubiKaisyouDetailWkLst = hozenDomManager.getKhHubiKaisyouDetailWksByKouteikanriid("");

        assertEquals(0, iW_KhHubiKaisyouDetailWkLst.size());
    }
}
