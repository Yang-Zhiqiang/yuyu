package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 申出受付<br />
 * 支払商品属性マスタエンティティリスト取得(商品コード、給付限度型区分、商品世代番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiSyouhnZokuseisByKyuuhu {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static String P_SYOUHNCD_03 = "SH03";
    static Integer P_SYOUHNSDNO_01 = new Integer(10);
    static Integer P_SYOUHNSDNO_02 = new Integer(20);
    static Integer P_SYOUHNSDNO_03 = new Integer(30);
    static String P_KYUUHUCD_01 = "KY01";
    static String P_KYUUHUCD_02 = "KY02";
    static String P_KYUUHUCD_03 = "KY03";
    static String P_KYUUHUCD_04 = "KY04";
    static String P_KYUUHUCD_05 = "KY05";

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        assertEquals(0, siharaiDomManager.getSiSyouhnZokuseisByKyuuhu(P_SYOUHNCD_01, C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_01).size());

        JM_Kyuuhu jm_Kyuuhu1 = new JM_Kyuuhu(P_KYUUHUCD_01);
        siharaiDomManager.insert(jm_Kyuuhu1);

        JM_Kyuuhu jm_Kyuuhu2 = new JM_Kyuuhu(P_KYUUHUCD_02);
        siharaiDomManager.insert(jm_Kyuuhu2);

        JM_Kyuuhu jm_Kyuuhu3 = new JM_Kyuuhu(P_KYUUHUCD_03);
        siharaiDomManager.insert(jm_Kyuuhu3);

        JM_Kyuuhu jm_Kyuuhu4 = new JM_Kyuuhu(P_KYUUHUCD_04);
        siharaiDomManager.insert(jm_Kyuuhu4);

        JM_Kyuuhu jm_Kyuuhu5 = new JM_Kyuuhu(P_KYUUHUCD_05);
        siharaiDomManager.insert(jm_Kyuuhu5);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei1 = new JM_SiSyouhnZokusei(P_SYOUHNCD_01, C_KyhgndkataKbn.TYPE120, P_SYOUHNSDNO_01, P_KYUUHUCD_01);
        siharaiDomManager.insert(jM_SiSyouhnZokusei1);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei2 = new JM_SiSyouhnZokusei(P_SYOUHNCD_01, C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_02, P_KYUUHUCD_01);
        siharaiDomManager.insert(jM_SiSyouhnZokusei2);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei3 = new JM_SiSyouhnZokusei(P_SYOUHNCD_02, C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_01, P_KYUUHUCD_01);
        siharaiDomManager.insert(jM_SiSyouhnZokusei3);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei4 = new JM_SiSyouhnZokusei(P_SYOUHNCD_02, C_KyhgndkataKbn.TYPE120, P_SYOUHNSDNO_02, P_KYUUHUCD_02);
        siharaiDomManager.insert(jM_SiSyouhnZokusei4);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei5 = new JM_SiSyouhnZokusei(P_SYOUHNCD_03, C_KyhgndkataKbn.TYPE180, P_SYOUHNSDNO_03, P_KYUUHUCD_03);
        siharaiDomManager.insert(jM_SiSyouhnZokusei5);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei6 = new JM_SiSyouhnZokusei(P_SYOUHNCD_03, C_KyhgndkataKbn.TYPE180, P_SYOUHNSDNO_03, P_KYUUHUCD_04);
        siharaiDomManager.insert(jM_SiSyouhnZokusei6);

        JM_SiSyouhnZokusei jM_SiSyouhnZokusei7 = new JM_SiSyouhnZokusei(P_SYOUHNCD_03, C_KyhgndkataKbn.TYPE180, P_SYOUHNSDNO_03, P_KYUUHUCD_05);
        siharaiDomManager.insert(jM_SiSyouhnZokusei7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
        siharaiDomManager.delete(siharaiDomManager.getAllKyuuhu());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        assertEquals(0, siharaiDomManager.getSiSyouhnZokuseisByKyuuhu(P_SYOUHNCD_01, C_KyhgndkataKbn.TYPE60, P_SYOUHNSDNO_01).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiList = siharaiDomManager.getSiSyouhnZokuseisByKyuuhu(P_SYOUHNCD_02, C_KyhgndkataKbn.TYPE120, P_SYOUHNSDNO_02);
        Assert.assertEquals(1, siSyouhnZokuseiList.size());

        Assert.assertEquals(P_SYOUHNCD_02, siSyouhnZokuseiList.get(0).getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_02, siSyouhnZokuseiList.get(0).getSyouhnsdno());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE120, siSyouhnZokuseiList.get(0).getKyhgndkatakbn());
        Assert.assertEquals(P_KYUUHUCD_02, siSyouhnZokuseiList.get(0).getKyuuhucd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_SYOUHNCD_03,P_SYOUHNSDNO_03,C_KyhgndkataKbn.TYPE180,P_KYUUHUCD_03), "1");
        datamap.put($(P_SYOUHNCD_03,P_SYOUHNSDNO_03,C_KyhgndkataKbn.TYPE180,P_KYUUHUCD_04), "2");
        datamap.put($(P_SYOUHNCD_03,P_SYOUHNSDNO_03,C_KyhgndkataKbn.TYPE180,P_KYUUHUCD_05), "2");

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiList = siharaiDomManager.getSiSyouhnZokuseisByKyuuhu(P_SYOUHNCD_03, C_KyhgndkataKbn.TYPE180, P_SYOUHNSDNO_03);

        for(JM_SiSyouhnZokusei siSyouhnZokusei:siSyouhnZokuseiList){
            datamap.remove($(
                siSyouhnZokusei.getSyouhncd(),
                siSyouhnZokusei.getSyouhnsdno(),
                siSyouhnZokusei.getKyhgndkatakbn(),
                siSyouhnZokusei.getKyuuhucd()));
        }

        Assert.assertEquals(3, siSyouhnZokuseiList.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiList = siharaiDomManager.getSiSyouhnZokuseisByKyuuhu("", C_KyhgndkataKbn.TYPE180, P_SYOUHNSDNO_03);
        assertEquals(0, siSyouhnZokuseiList.size());
    }
}
