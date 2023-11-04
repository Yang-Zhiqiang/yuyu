package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkJhSaiteiSsByPk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhSaiteiSsByPk {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst = bizDomManager.getChkJhSaiteiSsByPk("0001", 12, 2, 2, 6, BizNumber.valueOf(22), 6, 6, C_Tuukasyu.BLNK);

        Assert.assertEquals(0, chkJhSaiteiSLst.size());

        BM_ChkJhSaiteiS chkJhSaiteiS1 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS1);

        BM_ChkJhSaiteiS chkJhSaiteiS2 = new BM_ChkJhSaiteiS("1111", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS2);

        BM_ChkJhSaiteiS chkJhSaiteiS3 = new BM_ChkJhSaiteiS("0001", 13, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS3);

        BM_ChkJhSaiteiS chkJhSaiteiS4 = new BM_ChkJhSaiteiS("0001", 11, 11, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS4);

        BM_ChkJhSaiteiS chkJhSaiteiS5 = new BM_ChkJhSaiteiS("0001", 11, 13, 3, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS5);

        BM_ChkJhSaiteiS chkJhSaiteiS6 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 1, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS6);

        BM_ChkJhSaiteiS chkJhSaiteiS7 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 7, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS7);

        BM_ChkJhSaiteiS chkJhSaiteiS8 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 5, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS8);

        BM_ChkJhSaiteiS chkJhSaiteiS9 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(23), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS9);

        BM_ChkJhSaiteiS chkJhSaiteiS10 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(21), 5, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS10);

        BM_ChkJhSaiteiS chkJhSaiteiS11 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 7, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS11);

        BM_ChkJhSaiteiS chkJhSaiteiS12 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 5, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS12);

        BM_ChkJhSaiteiS chkJhSaiteiS13 = new BM_ChkJhSaiteiS("0001", 11, 13, 1, 3, 5, 7, BizNumber.valueOf(21), BizNumber.valueOf(23), 5, 7, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS13);

        BM_ChkJhSaiteiS chkJhSaiteiS14 = new BM_ChkJhSaiteiS("0002", 12, 12, 2, 4, 6, 6, BizNumber.valueOf(22), BizNumber.valueOf(22), 4, 6, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS14);

        BM_ChkJhSaiteiS chkJhSaiteiS15 = new BM_ChkJhSaiteiS("0002", 11, 12, 1, 4, 5, 6, BizNumber.valueOf(21), BizNumber.valueOf(22), 3, 6, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS15);

        BM_ChkJhSaiteiS chkJhSaiteiS16 = new BM_ChkJhSaiteiS("0002", 12, 13, 2, 5, 6, 7, BizNumber.valueOf(22), BizNumber.valueOf(23), 4, 7, C_Tuukasyu.BLNK);

        bizDomManager.insert(chkJhSaiteiS16);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst = bizDomManager.getChkJhSaiteiSsByPk("2222", 12, 2, 2, 6, BizNumber.valueOf(22), 6, 6, C_Tuukasyu.BLNK);

        Assert.assertEquals(0, chkJhSaiteiSLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst = bizDomManager.getChkJhSaiteiSsByPk("0001", 12, 2, 2, 6, BizNumber.valueOf(22), 6, 6, C_Tuukasyu.BLNK);

        Assert.assertEquals(1, chkJhSaiteiSLst.size());

        Assert.assertEquals("0001", chkJhSaiteiSLst.get(0).getSyouhncd());
        Assert.assertEquals(11, chkJhSaiteiSLst.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(13, chkJhSaiteiSLst.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(1, chkJhSaiteiSLst.get(0).getDntsdnumufrom().intValue());
        Assert.assertEquals(3, chkJhSaiteiSLst.get(0).getDntsdnumuto().intValue());
        Assert.assertEquals(5, chkJhSaiteiSLst.get(0).getHrkkknsmnkbnfrom().intValue());
        Assert.assertEquals(7, chkJhSaiteiSLst.get(0).getHrkkknsmnkbnto().intValue());
        Assert.assertEquals(BizNumber.valueOf(21), chkJhSaiteiSLst.get(0).getHknkknfrom());
        Assert.assertEquals(BizNumber.valueOf(23), chkJhSaiteiSLst.get(0).getHknkknto());
        Assert.assertEquals(5, chkJhSaiteiSLst.get(0).getSaiteisknwtkumufrom().intValue());
        Assert.assertEquals(7, chkJhSaiteiSLst.get(0).getSaiteisknwtkumuto().intValue());
        Assert.assertEquals(C_Tuukasyu.BLNK, chkJhSaiteiSLst.get(0).getTuukasyu());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst = bizDomManager.getChkJhSaiteiSsByPk("0002", 12, 2, 4, 6, BizNumber.valueOf(22), 4, 6, C_Tuukasyu.BLNK);

        Assert.assertEquals(3, chkJhSaiteiSLst.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($("0002",11,12,1,4,5,6,BizNumber.valueOf(21),BizNumber.valueOf(22),3,6,C_Tuukasyu.BLNK),"1");
        map.put($("0002",12,12,2,4,6,6,BizNumber.valueOf(22),BizNumber.valueOf(22),4,6,C_Tuukasyu.BLNK),"1");
        map.put($("0002",12,13,2,5,6,7,BizNumber.valueOf(22),BizNumber.valueOf(23),4,7,C_Tuukasyu.BLNK),"1");

        assertTrue(map.containsKey($(chkJhSaiteiSLst.get(0).getSyouhncd(),chkJhSaiteiSLst.get(0).getSyusyouhnsdnofrom().intValue(), chkJhSaiteiSLst.get(0).getSyusyouhnsdnoto().intValue()
            , chkJhSaiteiSLst.get(0).getDntsdnumufrom().intValue(), chkJhSaiteiSLst.get(0).getDntsdnumuto().intValue(), chkJhSaiteiSLst.get(0).getHrkkknsmnkbnfrom().intValue()
            , chkJhSaiteiSLst.get(0).getHrkkknsmnkbnto().intValue(), chkJhSaiteiSLst.get(0).getHknkknfrom(), chkJhSaiteiSLst.get(0).getHknkknto(), chkJhSaiteiSLst.get(0).getSaiteisknwtkumufrom().intValue()
            , chkJhSaiteiSLst.get(0).getSaiteisknwtkumuto().intValue(), chkJhSaiteiSLst.get(0).getTuukasyu())));

        assertTrue(map.containsKey($(chkJhSaiteiSLst.get(1).getSyouhncd(),chkJhSaiteiSLst.get(1).getSyusyouhnsdnofrom().intValue(), chkJhSaiteiSLst.get(1).getSyusyouhnsdnoto().intValue()
            , chkJhSaiteiSLst.get(1).getDntsdnumufrom().intValue(), chkJhSaiteiSLst.get(1).getDntsdnumuto().intValue(), chkJhSaiteiSLst.get(1).getHrkkknsmnkbnfrom().intValue()
            , chkJhSaiteiSLst.get(1).getHrkkknsmnkbnto().intValue(), chkJhSaiteiSLst.get(1).getHknkknfrom(), chkJhSaiteiSLst.get(1).getHknkknto(), chkJhSaiteiSLst.get(1).getSaiteisknwtkumufrom().intValue()
            , chkJhSaiteiSLst.get(1).getSaiteisknwtkumuto().intValue(), chkJhSaiteiSLst.get(1).getTuukasyu())));

        assertTrue(map.containsKey($(chkJhSaiteiSLst.get(2).getSyouhncd(),chkJhSaiteiSLst.get(2).getSyusyouhnsdnofrom().intValue(), chkJhSaiteiSLst.get(2).getSyusyouhnsdnoto().intValue()
            , chkJhSaiteiSLst.get(2).getDntsdnumufrom().intValue(), chkJhSaiteiSLst.get(2).getDntsdnumuto().intValue(), chkJhSaiteiSLst.get(2).getHrkkknsmnkbnfrom().intValue()
            , chkJhSaiteiSLst.get(2).getHrkkknsmnkbnto().intValue(), chkJhSaiteiSLst.get(2).getHknkknfrom(), chkJhSaiteiSLst.get(2).getHknkknto(), chkJhSaiteiSLst.get(2).getSaiteisknwtkumufrom().intValue()
            , chkJhSaiteiSLst.get(2).getSaiteisknwtkumuto().intValue(), chkJhSaiteiSLst.get(2).getTuukasyu())));

        map.remove($(chkJhSaiteiSLst.get(0).getSyouhncd(),chkJhSaiteiSLst.get(0).getSyusyouhnsdnofrom().intValue(), chkJhSaiteiSLst.get(0).getSyusyouhnsdnoto().intValue()
            , chkJhSaiteiSLst.get(0).getDntsdnumufrom().intValue(), chkJhSaiteiSLst.get(0).getDntsdnumuto().intValue(), chkJhSaiteiSLst.get(0).getHrkkknsmnkbnfrom().intValue()
            , chkJhSaiteiSLst.get(0).getHrkkknsmnkbnto().intValue(), chkJhSaiteiSLst.get(0).getHknkknfrom(), chkJhSaiteiSLst.get(0).getHknkknto(), chkJhSaiteiSLst.get(0).getSaiteisknwtkumufrom().intValue()
            , chkJhSaiteiSLst.get(0).getSaiteisknwtkumuto().intValue(), chkJhSaiteiSLst.get(0).getTuukasyu()));

        map.remove($(chkJhSaiteiSLst.get(1).getSyouhncd(),chkJhSaiteiSLst.get(1).getSyusyouhnsdnofrom().intValue(), chkJhSaiteiSLst.get(1).getSyusyouhnsdnoto().intValue()
            , chkJhSaiteiSLst.get(1).getDntsdnumufrom().intValue(), chkJhSaiteiSLst.get(1).getDntsdnumuto().intValue(), chkJhSaiteiSLst.get(1).getHrkkknsmnkbnfrom().intValue()
            , chkJhSaiteiSLst.get(1).getHrkkknsmnkbnto().intValue(), chkJhSaiteiSLst.get(1).getHknkknfrom(), chkJhSaiteiSLst.get(1).getHknkknto(), chkJhSaiteiSLst.get(1).getSaiteisknwtkumufrom().intValue()
            , chkJhSaiteiSLst.get(1).getSaiteisknwtkumuto().intValue(), chkJhSaiteiSLst.get(1).getTuukasyu()));

        map.remove($(chkJhSaiteiSLst.get(2).getSyouhncd(),chkJhSaiteiSLst.get(2).getSyusyouhnsdnofrom().intValue(), chkJhSaiteiSLst.get(2).getSyusyouhnsdnoto().intValue()
            , chkJhSaiteiSLst.get(2).getDntsdnumufrom().intValue(), chkJhSaiteiSLst.get(2).getDntsdnumuto().intValue(), chkJhSaiteiSLst.get(2).getHrkkknsmnkbnfrom().intValue()
            , chkJhSaiteiSLst.get(2).getHrkkknsmnkbnto().intValue(), chkJhSaiteiSLst.get(2).getHknkknfrom(), chkJhSaiteiSLst.get(2).getHknkknto(), chkJhSaiteiSLst.get(2).getSaiteisknwtkumufrom().intValue()
            , chkJhSaiteiSLst.get(2).getSaiteisknwtkumuto().intValue(), chkJhSaiteiSLst.get(2).getTuukasyu()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst = bizDomManager.getChkJhSaiteiSsByPk("", 12, 2, 2, 6, BizNumber.valueOf(22), 6, 6, C_Tuukasyu.BLNK);

        Assert.assertEquals(0, chkJhSaiteiSLst.size());
    }

}


