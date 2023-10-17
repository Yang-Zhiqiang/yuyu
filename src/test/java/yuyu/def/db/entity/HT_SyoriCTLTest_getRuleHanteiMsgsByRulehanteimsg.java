package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ルール判定結果メッセージテーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getRuleHanteiMsgsByRulehanteimsg {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL("10000000001");
            List<HT_RuleHanteiMsg> ruleHanteiMsgList = syoriCTL1
                    .getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            Assert.assertEquals(0, ruleHanteiMsgList.size());

            HT_RuleHanteiMsg ruleHanteiMsg1 = syoriCTL1.createRuleHanteiMsg();
            ruleHanteiMsg1.setMosno("10000000001");
            ruleHanteiMsg1.setRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            ruleHanteiMsg1.setRenno(Integer.valueOf(1));

            HT_RuleHanteiMsg ruleHanteiMsg2 = syoriCTL1.createRuleHanteiMsg();
            ruleHanteiMsg2.setMosno("10000000001");
            ruleHanteiMsg2.setRulehanteimsg(C_Rulehanteimsg.IMUSATEI);
            ruleHanteiMsg2.setRenno(Integer.valueOf(3));

            HT_RuleHanteiMsg ruleHanteiMsg03 = syoriCTL1.createRuleHanteiMsg();
            ruleHanteiMsg03.setMosno("10000000001");
            ruleHanteiMsg03.setRulehanteimsg(C_Rulehanteimsg.KNKSATEI);
            ruleHanteiMsg03.setRenno(Integer.valueOf(4));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCTL2 == null) {

            syoriCTL2 = new HT_SyoriCTL("10000000002");
            List<HT_RuleHanteiMsg> ruleHanteiMsgList = syoriCTL2
                    .getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            Assert.assertEquals(0, ruleHanteiMsgList.size());

            HT_RuleHanteiMsg ruleHanteiMsg1 = syoriCTL2.createRuleHanteiMsg();
            ruleHanteiMsg1.setMosno("10000000002");
            ruleHanteiMsg1.setRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            ruleHanteiMsg1.setRenno(Integer.valueOf(2));

            HT_RuleHanteiMsg ruleHanteiMsg2 = syoriCTL2.createRuleHanteiMsg();
            ruleHanteiMsg2.setMosno("10000000002");
            ruleHanteiMsg2.setRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            ruleHanteiMsg2.setRenno(Integer.valueOf(1));

            HT_RuleHanteiMsg ruleHanteiMsg3 = syoriCTL2.createRuleHanteiMsg();
            ruleHanteiMsg3.setMosno("10000000002");
            ruleHanteiMsg3.setRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
            ruleHanteiMsg3.setRenno(Integer.valueOf(3));

            sinkeiyakuDomManager.insert(syoriCTL2);
        }

        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        if (syoriCTL3 == null) {
            syoriCTL3 = new HT_SyoriCTL("10000000003");
            sinkeiyakuDomManager.insert(syoriCTL3);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        List<HT_RuleHanteiMsg> ruleHanteiMsgList = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
        Assert.assertEquals(0, ruleHanteiMsgList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_RuleHanteiMsg> ruleHanteiMsgList1 = syoriCTL
                .getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
        Assert.assertEquals(1, ruleHanteiMsgList1.size());
        Assert.assertEquals("10000000001", ruleHanteiMsgList1.get(0).getMosno());
        Assert.assertEquals(C_Rulehanteimsg.MOSTENKEN, ruleHanteiMsgList1.get(0).getRulehanteimsg());
        Assert.assertEquals(Integer.valueOf(1), ruleHanteiMsgList1.get(0).getRenno());

        List<HT_RuleHanteiMsg> ruleHanteiMsgList2 = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.IMUSATEI);
        Assert.assertEquals(1, ruleHanteiMsgList2.size());
        Assert.assertEquals("10000000001", ruleHanteiMsgList2.get(0).getMosno());
        Assert.assertEquals(C_Rulehanteimsg.IMUSATEI, ruleHanteiMsgList2.get(0).getRulehanteimsg());
        Assert.assertEquals(Integer.valueOf(3), ruleHanteiMsgList2.get(0).getRenno());

        List<HT_RuleHanteiMsg> ruleHanteiMsgList3 = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.KNKSATEI);
        Assert.assertEquals(1, ruleHanteiMsgList3.size());
        Assert.assertEquals("10000000001", ruleHanteiMsgList3.get(0).getMosno());
        Assert.assertEquals(C_Rulehanteimsg.KNKSATEI, ruleHanteiMsgList3.get(0).getRulehanteimsg());
        Assert.assertEquals(Integer.valueOf(4), ruleHanteiMsgList3.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        List<HT_RuleHanteiMsg> ruleHanteiMsgList = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.MOSTENKEN);
        Assert.assertEquals(3, ruleHanteiMsgList.size());

        Assert.assertEquals("10000000002", ruleHanteiMsgList.get(0).getMosno());
        Assert.assertEquals("10000000002", ruleHanteiMsgList.get(1).getMosno());
        Assert.assertEquals("10000000002", ruleHanteiMsgList.get(2).getMosno());
        Assert.assertEquals(C_Rulehanteimsg.MOSTENKEN, ruleHanteiMsgList.get(0).getRulehanteimsg());
        Assert.assertEquals(C_Rulehanteimsg.MOSTENKEN, ruleHanteiMsgList.get(1).getRulehanteimsg());
        Assert.assertEquals(C_Rulehanteimsg.MOSTENKEN, ruleHanteiMsgList.get(2).getRulehanteimsg());
        Assert.assertEquals(Integer.valueOf(1), ruleHanteiMsgList.get(0).getRenno());
        Assert.assertEquals(Integer.valueOf(2), ruleHanteiMsgList.get(1).getRenno());
        Assert.assertEquals(Integer.valueOf(3), ruleHanteiMsgList.get(2).getRenno());
    }
}
