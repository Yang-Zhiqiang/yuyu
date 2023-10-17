package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込基本TBLチェック<br />
 * 最大商品世代番号を持つ商品属性マスタエンティティ取得(商品コード)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseiBySyouhncdMaxSyouhnsdno {

    @Inject
    private BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SY01";
    static String P_SYOUHNCD_02 = "SY02";
    static String P_SYOUHNCD_03 = "SY03";
    static Integer P_SYOUHNSD_01 = 11;
    static Integer P_SYOUHNSD_02 = 12;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(P_SYOUHNCD_01);
        Assert.assertNull(syouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei(P_SYOUHNCD_01, P_SYOUHNSD_01);
        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei(P_SYOUHNCD_01, P_SYOUHNSD_02);
        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei(P_SYOUHNCD_02, P_SYOUHNSD_01);
        bizDomManager.insert(syouhnZokusei3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(P_SYOUHNCD_03);

        Assert.assertNull(syouhnZokusei);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(P_SYOUHNCD_01);

        Assert.assertEquals(P_SYOUHNCD_01, syouhnZokusei.getSyouhncd());
        Assert.assertEquals(P_SYOUHNSD_02, syouhnZokusei.getSyouhnsdno());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("");

        Assert.assertNull(syouhnZokusei);
    }
}
