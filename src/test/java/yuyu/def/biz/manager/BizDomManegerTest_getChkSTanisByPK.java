package yuyu.def.biz.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkSTanisByPK() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManegerTest_getChkSTanisByPK {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK("0001", 12, BizNumber.valueOf(22), C_Tuukasyu.BLNK);

        Assert.assertEquals(0, chkSTaniLst.size());

        BM_ChkSTani chkSTani1 = new BM_ChkSTani("0001", 11, 13, BizNumber.valueOf(21), BizNumber.valueOf(23), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani1);

        BM_ChkSTani chkSTani2 = new BM_ChkSTani("0002", 11, 13, BizNumber.valueOf(21), BizNumber.valueOf(23), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani2);

        BM_ChkSTani chkSTani3 = new BM_ChkSTani("0001", 13, 13, BizNumber.valueOf(21), BizNumber.valueOf(23), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani3);

        BM_ChkSTani chkSTani4 = new BM_ChkSTani("0001", 11, 11, BizNumber.valueOf(21), BizNumber.valueOf(23), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani4);

        BM_ChkSTani chkSTani5 = new BM_ChkSTani("0001", 11, 13, BizNumber.valueOf(23), BizNumber.valueOf(23), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani5);

        BM_ChkSTani chkSTani6 = new BM_ChkSTani("0001", 11, 13, BizNumber.valueOf(21), BizNumber.valueOf(21), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani6);

        BM_ChkSTani chkSTani7 = new BM_ChkSTani("0001", 11, 13, BizNumber.valueOf(21), BizNumber.valueOf(23), C_Tuukasyu.JPY);

        bizDomManager.insert(chkSTani7);

        BM_ChkSTani chkSTani8 = new BM_ChkSTani("0003", 11, 12, BizNumber.valueOf(21), BizNumber.valueOf(22), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani8);

        BM_ChkSTani chkSTani9 = new BM_ChkSTani("0003", 10, 11, BizNumber.valueOf(20), BizNumber.valueOf(21), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani9);

        BM_ChkSTani chkSTani10 = new BM_ChkSTani("0003", 11, 11, BizNumber.valueOf(21), BizNumber.valueOf(21), C_Tuukasyu.BLNK);

        bizDomManager.insert(chkSTani10);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkSTani());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK("1000", 12, BizNumber.valueOf(22), C_Tuukasyu.BLNK);

        Assert.assertEquals(0,chkSTaniLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK("0001", 12, BizNumber.valueOf(22), C_Tuukasyu.BLNK);

        Assert.assertEquals(1,chkSTaniLst.size());

        assertEquals("0001", chkSTaniLst.get(0).getSyouhncd());
        assertEquals(11, chkSTaniLst.get(0).getSyusyouhnsdnofrom().intValue());
        assertEquals(13, chkSTaniLst.get(0).getSyusyouhnsdnoto().intValue());
        assertEquals(BizNumber.valueOf(21), chkSTaniLst.get(0).getHhknfromnen());
        assertEquals(BizNumber.valueOf(23), chkSTaniLst.get(0).getHhkntonen());
        assertEquals(C_Tuukasyu.BLNK, chkSTaniLst.get(0).getTuukasyu());

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK("0003", 11, BizNumber.valueOf(21), C_Tuukasyu.BLNK);

        Assert.assertEquals(3,chkSTaniLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("0003",10,11,BizNumber.valueOf(20),BizNumber.valueOf(21),C_Tuukasyu.BLNK), "1");
        map.put($("0003",11,11,BizNumber.valueOf(21),BizNumber.valueOf(21),C_Tuukasyu.BLNK), "1");
        map.put($("0003",11,12,BizNumber.valueOf(21),BizNumber.valueOf(22),C_Tuukasyu.BLNK), "1");

        for(BM_ChkSTani chkSTani : chkSTaniLst){
            map.remove($(chkSTani.getSyouhncd(),chkSTani.getSyusyouhnsdnofrom().intValue(),chkSTani.getSyusyouhnsdnoto().intValue(),chkSTani.getHhknfromnen(),
                chkSTani.getHhkntonen(),chkSTani.getTuukasyu()));
        }
        assertTrue(map.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK("", 12, BizNumber.valueOf(22), C_Tuukasyu.BLNK);

        Assert.assertEquals(0,chkSTaniLst.size());
    }
}


