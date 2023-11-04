package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst = bizDomManager.
            getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns("104",
                C_SyoruiTorikomiHouKbn.PDF, C_UmuKbn.NONE, C_SkeijimuKbn.SMTB);
        Assert.assertEquals(0, torikomiSyoruiHukaInfoLst.size());

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo1 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo1.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        torikomiSyoruiHukaInfo1.setSubSystemId("104");
        torikomiSyoruiHukaInfo1.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.TIFF);
        torikomiSyoruiHukaInfo1.setSkeijimukbn(C_SkeijimuKbn.SMTB);
        torikomiSyoruiHukaInfo1.setQrsealumukbn(C_UmuKbn.NONE);
        torikomiSyoruiHukaInfo1.setSortNo(453);
        bizDomManager.insert(torikomiSyoruiHukaInfo1);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo2 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo2.setSyoruiCd(C_SyoruiCdKbn.CM_LINC_MISSLIST);
        torikomiSyoruiHukaInfo2.setSubSystemId("103");
        torikomiSyoruiHukaInfo2.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo2.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        torikomiSyoruiHukaInfo2.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo2.setSortNo(456);
        bizDomManager.insert(torikomiSyoruiHukaInfo2);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo3 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo3.setSyoruiCd(C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_2);
        torikomiSyoruiHukaInfo3.setSubSystemId("103");
        torikomiSyoruiHukaInfo3.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo3.setSkeijimukbn(C_SkeijimuKbn.BLNK);
        torikomiSyoruiHukaInfo3.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo3.setSortNo(100);
        bizDomManager.insert(torikomiSyoruiHukaInfo3);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo4 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo4.setSyoruiCd(C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1);
        torikomiSyoruiHukaInfo4.setSubSystemId("103");
        torikomiSyoruiHukaInfo4.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo4.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        torikomiSyoruiHukaInfo4.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo4.setSortNo(211);
        bizDomManager.insert(torikomiSyoruiHukaInfo4);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo5 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo5.setSyoruiCd(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        torikomiSyoruiHukaInfo5.setSubSystemId("103");
        torikomiSyoruiHukaInfo5.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo5.setSkeijimukbn(C_SkeijimuKbn.SMTB);
        torikomiSyoruiHukaInfo5.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo5.setSortNo(167);
        bizDomManager.insert(torikomiSyoruiHukaInfo5);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo6 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo6.setSyoruiCd(C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_1);
        torikomiSyoruiHukaInfo6.setSubSystemId("105");
        torikomiSyoruiHukaInfo6.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo6.setSkeijimukbn(C_SkeijimuKbn.SMTB);
        torikomiSyoruiHukaInfo6.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo6.setSortNo(123);
        bizDomManager.insert(torikomiSyoruiHukaInfo6);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo7 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo7.setSyoruiCd(C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_2);
        torikomiSyoruiHukaInfo7.setSubSystemId("103");
        torikomiSyoruiHukaInfo7.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.SCAN_QR);
        torikomiSyoruiHukaInfo7.setSkeijimukbn(C_SkeijimuKbn.SMTB);
        torikomiSyoruiHukaInfo7.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo7.setSortNo(222);
        bizDomManager.insert(torikomiSyoruiHukaInfo7);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo8 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo8.setSyoruiCd(C_SyoruiCdKbn.CM_ONLINE_FBSOUKINMEISAI_1);
        torikomiSyoruiHukaInfo8.setSubSystemId("103");
        torikomiSyoruiHukaInfo8.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo8.setSkeijimukbn(C_SkeijimuKbn.MIZUHO);
        torikomiSyoruiHukaInfo8.setQrsealumukbn(C_UmuKbn.ARI);
        torikomiSyoruiHukaInfo8.setSortNo(111);
        bizDomManager.insert(torikomiSyoruiHukaInfo8);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo9 = new BM_TorikomiSyoruiHukaInfo();
        torikomiSyoruiHukaInfo9.setSyoruiCd(C_SyoruiCdKbn.CM_ONLINE_FBSOUKINMEISAI_2);
        torikomiSyoruiHukaInfo9.setSubSystemId("103");
        torikomiSyoruiHukaInfo9.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.PDF);
        torikomiSyoruiHukaInfo9.setSkeijimukbn(C_SkeijimuKbn.SMTB);
        torikomiSyoruiHukaInfo9.setQrsealumukbn(C_UmuKbn.NONE);
        torikomiSyoruiHukaInfo9.setSortNo(765);
        bizDomManager.insert(torikomiSyoruiHukaInfo9);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst = bizDomManager.
            getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns("106",
                C_SyoruiTorikomiHouKbn.SAKUSEI_DOUJI, C_UmuKbn.NONE, C_SkeijimuKbn.SMTB);
        Assert.assertEquals(0, torikomiSyoruiHukaInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst = bizDomManager.
            getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns("103",
                C_SyoruiTorikomiHouKbn.PDF, C_UmuKbn.ARI, C_SkeijimuKbn.BLNK);
        Assert.assertEquals(1, torikomiSyoruiHukaInfoLst.size());
        Assert.assertEquals(C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_2, torikomiSyoruiHukaInfoLst.get(0).getSyoruiCd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst = bizDomManager.
            getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns("104",
                C_SyoruiTorikomiHouKbn.TIFF, C_UmuKbn.NONE, C_SkeijimuKbn.SMTB);
        Assert.assertEquals(1, torikomiSyoruiHukaInfoLst.size());
        Assert.assertEquals(C_SyoruiCdKbn.BLNK, torikomiSyoruiHukaInfoLst.get(0).getSyoruiCd());
    }

    @Test
    @TestOrder(40)
    public void normal3() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst = bizDomManager.
            getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns("103",
                C_SyoruiTorikomiHouKbn.PDF, C_UmuKbn.ARI, C_SkeijimuKbn.SMTB, C_SkeijimuKbn.TIGINSINKIN,
                C_SkeijimuKbn.BLNK, C_SkeijimuKbn.SMBC);
        Assert.assertEquals(4, torikomiSyoruiHukaInfoLst.size());

        Assert.assertEquals(C_SyoruiCdKbn.CM_ONLINE_FBFURIKOMIKEI_2, torikomiSyoruiHukaInfoLst.get(0).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU, torikomiSyoruiHukaInfoLst.get(1).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.CM_ONLINE_GKFBFURIKOMIKEI_1, torikomiSyoruiHukaInfoLst.get(2).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.CM_LINC_MISSLIST, torikomiSyoruiHukaInfoLst.get(3).getSyoruiCd());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {
        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst = bizDomManager.
            getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbnQrsealumukbnSkeijimukbns("",
                C_SyoruiTorikomiHouKbn.TIFF, C_UmuKbn.NONE, C_SkeijimuKbn.SMTB);
        Assert.assertEquals(0, torikomiSyoruiHukaInfoLst.size());
    }

}