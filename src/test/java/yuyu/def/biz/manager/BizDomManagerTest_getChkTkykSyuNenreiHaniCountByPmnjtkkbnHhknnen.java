package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import yuyu.testinfr.TestOrder;

/**
 * 特約種類年齢範囲チェックマスタのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.SANDAISIPPMNJTOK, 19);
        Assert.assertEquals(new Long(0), count);

        BM_ChkTkykSyuNenreiHani chkTkykSyuNenreiHani1 = new BM_ChkTkykSyuNenreiHani(C_PmnjtkKbn.SANDAISIPPMNJTOK);
        chkTkykSyuNenreiHani1.setHhknfromnen(BizNumber.valueOf(20));
        chkTkykSyuNenreiHani1.setHhkntonen(BizNumber.valueOf(22));
        bizDomManager.insert(chkTkykSyuNenreiHani1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkTkykSyuNenreiHani());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.NONE, 20);

        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(20)
    public void noResult2() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.NONE, 21);

        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(30)
    public void noResult3() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.NONE, 22);

        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(40)
    public void noResult4() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.SANDAISIPPMNJTOK, 19);

        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(50)
    public void noResult5() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.SANDAISIPPMNJTOK, 23);

        Assert.assertEquals(new Long(0), count);
    }
    @Test
    @TestOrder(60)
    public void normal1() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.SANDAISIPPMNJTOK, 20);

        Assert.assertEquals(new Long(1), count);
    }
    @Test
    @TestOrder(70)
    public void normal2() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.SANDAISIPPMNJTOK, 21);

        Assert.assertEquals(new Long(1), count);
    }
    @Test
    @TestOrder(80)
    public void normal3() {

        Long count = bizDomManager.getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn.SANDAISIPPMNJTOK, 22);

        Assert.assertEquals(new Long(1), count);
    }
}
