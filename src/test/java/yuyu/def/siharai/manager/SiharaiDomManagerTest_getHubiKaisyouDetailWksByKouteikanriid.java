package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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

import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金不備解消<br />
 * 支払不備解消詳細ワークテーブルエンティティリスト取得(工程管理ＩＤ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getHubiKaisyouDetailWksByKouteikanriid {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_KOUTEIKANRIID_01 = "KID00000001";
    static String P_KOUTEIKANRIID_02 = "KID00000002";
    static String P_KOUTEIKANRIID_03 = "KID00000003";
    static Integer P_RENNO3KETA01 = new Integer(111);
    static Integer P_RENNO3KETA02 = new Integer(222);
    static Integer P_RENNO3KETA03 = new Integer(333);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JW_HubiKaisyouDetailWk> HubiKaisyouDetailWkLst = siharaiDomManager
            .getHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_02);

        Assert.assertEquals(0, HubiKaisyouDetailWkLst.size());

        JW_HubiKaisyouDetailWk jW_HubiKaisyouDetailWk1 = new JW_HubiKaisyouDetailWk();
        jW_HubiKaisyouDetailWk1.setKouteikanriid(P_KOUTEIKANRIID_01);
        jW_HubiKaisyouDetailWk1.setRenno3keta(P_RENNO3KETA01);

        siharaiDomManager.insert(jW_HubiKaisyouDetailWk1);

        JW_HubiKaisyouDetailWk jW_HubiKaisyouDetailWk2 = new JW_HubiKaisyouDetailWk();
        jW_HubiKaisyouDetailWk2.setKouteikanriid(P_KOUTEIKANRIID_01);
        jW_HubiKaisyouDetailWk2.setRenno3keta(P_RENNO3KETA02);

        siharaiDomManager.insert(jW_HubiKaisyouDetailWk2);

        JW_HubiKaisyouDetailWk jW_HubiKaisyouDetailWk3 = new JW_HubiKaisyouDetailWk();
        jW_HubiKaisyouDetailWk3.setKouteikanriid(P_KOUTEIKANRIID_01);
        jW_HubiKaisyouDetailWk3.setRenno3keta(P_RENNO3KETA03);

        siharaiDomManager.insert(jW_HubiKaisyouDetailWk3);

        JW_HubiKaisyouDetailWk jW_HubiKaisyouDetailWk4 = new JW_HubiKaisyouDetailWk();
        jW_HubiKaisyouDetailWk4.setKouteikanriid(P_KOUTEIKANRIID_02);
        jW_HubiKaisyouDetailWk4.setRenno3keta(P_RENNO3KETA01);

        siharaiDomManager.insert(jW_HubiKaisyouDetailWk4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllHubiKaisyouDetailWk());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<JW_HubiKaisyouDetailWk> HubiKaisyouDetailWkLst = siharaiDomManager
            .getHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_03);

        Assert.assertEquals(0, HubiKaisyouDetailWkLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JW_HubiKaisyouDetailWk> HubiKaisyouDetailWkLst = siharaiDomManager
            .getHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_02);

        Assert.assertEquals(1, HubiKaisyouDetailWkLst.size());

        Assert.assertEquals(P_KOUTEIKANRIID_02, HubiKaisyouDetailWkLst.get(0).getKouteikanriid());
        Assert.assertEquals(P_RENNO3KETA01, HubiKaisyouDetailWkLst.get(0).getRenno3keta());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_KOUTEIKANRIID_01,P_RENNO3KETA01), "1");
        datamap.put($(P_KOUTEIKANRIID_01,P_RENNO3KETA02), "1");
        datamap.put($(P_KOUTEIKANRIID_01,P_RENNO3KETA03), "1");

        List<JW_HubiKaisyouDetailWk> HubiKaisyouDetailWkLst = siharaiDomManager
            .getHubiKaisyouDetailWksByKouteikanriid(P_KOUTEIKANRIID_01);

        for(JW_HubiKaisyouDetailWk hubiKaisyouDetailWk:HubiKaisyouDetailWkLst){
            datamap.remove($(
                hubiKaisyouDetailWk.getKouteikanriid(),
                hubiKaisyouDetailWk.getRenno3keta()));
        }
        Assert.assertEquals(3, HubiKaisyouDetailWkLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<JW_HubiKaisyouDetailWk> HubiKaisyouDetailWkLst = siharaiDomManager
            .getHubiKaisyouDetailWksByKouteikanriid("");

        Assert.assertEquals(0, HubiKaisyouDetailWkLst.size());
    }
}
