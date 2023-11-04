package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * ルール判定結果メッセージテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_RuleHanteiMsgEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL("MOSNOD00001");

        HT_RuleHanteiMsg hT_RuleHanteiMsg = hT_SyoriCTL1.createRuleHanteiMsg();
        hT_RuleHanteiMsg.setRulehanteimsg(C_Rulehanteimsg.IMUSATEI);
        hT_RuleHanteiMsg.setRenno(1);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {
        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {
        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {
        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {
        Assert.assertTrue(true);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getSyoriCTL() {

        String pMosno1 = "MOSNOD00001";
        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno1);
        HT_RuleHanteiMsg hT_RuleHanteiMsg = hT_SyoriCTL.getRuleHanteiMsgs().get(0);
        HT_SyoriCTL result_hT_SyoriCTL = hT_RuleHanteiMsg.getSyoriCTL();

        Assert.assertEquals(result_hT_SyoriCTL.getMosno(), pMosno1);

    }

}