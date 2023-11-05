package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.result.bean.SyouhnZokuseiHaitoukbnSeg1cdByPKBean;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyouhnZokuseiHaitoukbnSeg1cdByPK() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseiHaitoukbnSeg1cdByPK {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        SyouhnZokuseiHaitoukbnSeg1cdByPKBean  Bean = bizDomManager.getSyouhnZokuseiHaitoukbnSeg1cdByPK("A110", 1);
        Assert.assertEquals(null, Bean);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("A110", 1);
        syouhnZokusei1.setHaitoukbn(C_HaitouKbn.YUUHAI);
        syouhnZokusei1.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("B110", 1);
        syouhnZokusei2.setHaitoukbn(C_HaitouKbn.RISAHAI);
        syouhnZokusei2.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("A110", 3);
        syouhnZokusei3.setHaitoukbn(C_HaitouKbn.NONE);
        syouhnZokusei3.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        bizDomManager.insert(syouhnZokusei3);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        SyouhnZokuseiHaitoukbnSeg1cdByPKBean  Bean = bizDomManager.getSyouhnZokuseiHaitoukbnSeg1cdByPK("A110", 2);
        Assert.assertEquals(null, Bean);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        SyouhnZokuseiHaitoukbnSeg1cdByPKBean  Bean = bizDomManager.getSyouhnZokuseiHaitoukbnSeg1cdByPK("A110", 1);

        Assert.assertEquals(C_HaitouKbn.YUUHAI, Bean.getHaitoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, Bean.getSeg1cd());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        SyouhnZokuseiHaitoukbnSeg1cdByPKBean  Bean = bizDomManager.getSyouhnZokuseiHaitoukbnSeg1cdByPK("", 1);
        Assert.assertEquals(null, Bean);
    }


}