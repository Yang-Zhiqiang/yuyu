package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst =
            bizDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn("biz",C_SyoruiTorikomiHouKbn.SCAN_QR);
        Assert.assertEquals(0, torikomiSyoruiHukaInfoLst.size());

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo1 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_HYOUSI);
        torikomiSyoruiHukaInfo1.setSubSystemId("biz");
        torikomiSyoruiHukaInfo1.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.valueOf("1"));

        bizDomManager.insert(torikomiSyoruiHukaInfo1);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo2 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_QRSEAL);
        torikomiSyoruiHukaInfo2.setSubSystemId("workflow");
        torikomiSyoruiHukaInfo2.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.valueOf("1"));

        bizDomManager.insert(torikomiSyoruiHukaInfo2);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo3 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.USERITIRANHYOU);
        torikomiSyoruiHukaInfo3.setSubSystemId("biz");
        torikomiSyoruiHukaInfo3.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.valueOf("5"));

        bizDomManager.insert(torikomiSyoruiHukaInfo3);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo4 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.HK_SHRMESS);
        torikomiSyoruiHukaInfo4.setSubSystemId("biz");
        torikomiSyoruiHukaInfo4.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.valueOf("5"));

        bizDomManager.insert(torikomiSyoruiHukaInfo4);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo5 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        torikomiSyoruiHukaInfo5.setSubSystemId("biz");
        torikomiSyoruiHukaInfo5.setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn.valueOf("5"));

        bizDomManager.insert(torikomiSyoruiHukaInfo5);
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

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst =
            bizDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn("sinkeiyaku",C_SyoruiTorikomiHouKbn.SCAN_QR);
        Assert.assertEquals(0, torikomiSyoruiHukaInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst =
            bizDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn("biz",C_SyoruiTorikomiHouKbn.SCAN_QR);
        Assert.assertEquals(1, torikomiSyoruiHukaInfoLst.size());

        Assert.assertEquals(C_SyoruiCdKbn.WF_HYOUSI, torikomiSyoruiHukaInfoLst.get(0).getSyoruiCd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst =
            bizDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn("biz",C_SyoruiTorikomiHouKbn.PDF);
        Assert.assertEquals(3, torikomiSyoruiHukaInfoLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(C_SyoruiCdKbn.USERITIRANHYOU), "1");
        map.put($(C_SyoruiCdKbn.HK_SHRMESS), "1");
        map.put($(C_SyoruiCdKbn.HK_SHMEISAI_SDS), "1");
        for(BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo : torikomiSyoruiHukaInfoLst){
            map.remove($(torikomiSyoruiHukaInfo.getSyoruiCd()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_TorikomiSyoruiHukaInfo>  torikomiSyoruiHukaInfoLst =
            bizDomManager.getTorikomiSyoruiHukaInfosBySubSystemIdSyoruitorikomihoukbn("",C_SyoruiTorikomiHouKbn.SCAN_QR);
        Assert.assertEquals(0, torikomiSyoruiHukaInfoLst.size());
    }

}