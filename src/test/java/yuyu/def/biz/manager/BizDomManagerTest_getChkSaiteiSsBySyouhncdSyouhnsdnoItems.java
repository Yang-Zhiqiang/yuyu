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

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 最低Ｓチェック情報取得(商品コード、商品世代番号、払込経路、最低Ｓ緩和特約有無指定)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkSaiteiSsBySyouhncdSyouhnsdnoItems {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SH01";
    static Integer P_SYOUHNSDNO = new Integer(6);
    static Integer P_SAITEISKNWTKUMU = new Integer(6);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkSaiteiS> beans = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(P_SYOUHNCD_01, P_SYOUHNSDNO, C_Hrkkeiro.DANTAI,
            P_SAITEISKNWTKUMU, C_Tuukasyu.USD);

        Assert.assertEquals(0, beans.size());

        BM_ChkSaiteiS chkJhSaiteiS1 = new BM_ChkSaiteiS("SH01", 6, 6, 1, 1, 1, 1, BizNumber.ONE, BizNumber.ONE, 6, 7, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS1);

        BM_ChkSaiteiS chkJhSaiteiS2 = new BM_ChkSaiteiS("SH01", 5, 6, 0, 1, 1, 2, BizNumber.ONE, BizNumber.ONE, 6, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS2);

        BM_ChkSaiteiS chkJhSaiteiS3 = new BM_ChkSaiteiS("SH01", 6, 7, 1, 2, 1, 3, BizNumber.ONE, BizNumber.ONE, 5, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS3);

        BM_ChkSaiteiS chkJhSaiteiS4 = new BM_ChkSaiteiS("SH01", 5, 5, 0, 1, 1, 4, BizNumber.ONE, BizNumber.ONE, 6, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS4);

        BM_ChkSaiteiS chkJhSaiteiS5 = new BM_ChkSaiteiS("SH01", 6, 6, 0, 1, 1, 5, BizNumber.ONE, BizNumber.ONE, 7, 7, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS5);

        BM_ChkSaiteiS chkJhSaiteiS6 = new BM_ChkSaiteiS("SH01", 6, 6, 2, 2, 1, 6, BizNumber.ONE, BizNumber.ONE, 6, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS6);

        BM_ChkSaiteiS chkJhSaiteiS7 = new BM_ChkSaiteiS("SH01", 5, 6, 0, 0, 1, 7, BizNumber.ONE, BizNumber.ONE, 5, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS7);

        BM_ChkSaiteiS chkJhSaiteiS8 = new BM_ChkSaiteiS("SH01", 5, 6, -1, 0, 1, 8, BizNumber.ONE, BizNumber.ONE, 5, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS8);

        BM_ChkSaiteiS chkJhSaiteiS9 = new BM_ChkSaiteiS("SH01", 6, 7, 1, 1, 1, 9, BizNumber.ONE, BizNumber.ONE, 5, 6, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaiteiS9);

        BM_ChkSaiteiS chkJhSaiteiS10 = new BM_ChkSaiteiS("SH02", 6, 7, 1, 1, 1, 9, BizNumber.ONE, BizNumber.ONE, 5, 6, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaiteiS10);

        BM_ChkSaiteiS chkJhSaiteiS11 = new BM_ChkSaiteiS("SH01", 7, 7, 0, 1, 2, 9, BizNumber.ONE, BizNumber.ONE, 6, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS11);

        BM_ChkSaiteiS chkJhSaiteiS12 = new BM_ChkSaiteiS("SH01", 6, 6, 0, 1, 3, 9, BizNumber.ONE, BizNumber.ONE, 5, 5, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS12);

        BM_ChkSaiteiS chkJhSaiteiS13 = new BM_ChkSaiteiS("SH01", 6, 6, -1, -1, 4, 9, BizNumber.ONE, BizNumber.ONE, 6, 6, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaiteiS13);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkSaiteiS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkSaiteiS> beans = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(P_SYOUHNCD_01, P_SYOUHNSDNO, C_Hrkkeiro.DANTAI,
            P_SAITEISKNWTKUMU, C_Tuukasyu.EUR);

        Assert.assertEquals(0, beans.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkSaiteiS> beans = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(P_SYOUHNCD_01, P_SYOUHNSDNO, C_Hrkkeiro.DANTAI,
            P_SAITEISKNWTKUMU, C_Tuukasyu.USD);

        Assert.assertEquals(1, beans.size());

        Assert.assertEquals("SH01", beans.get(0).getSyouhncd());
        Assert.assertEquals(new Integer(6), beans.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(new Integer(7), beans.get(0).getSyusyouhnsdnoto());
        Assert.assertEquals(new Integer(1), beans.get(0).getDntsdnumufrom());
        Assert.assertEquals(new Integer(1), beans.get(0).getDntsdnumuto());
        Assert.assertEquals(new Integer(1), beans.get(0).getHrkkknsmnkbnfrom());
        Assert.assertEquals(new Integer(9), beans.get(0).getHrkkknsmnkbnto());
        Assert.assertEquals(BizNumber.ONE, beans.get(0).getHknkknfrom());
        Assert.assertEquals(BizNumber.ONE, beans.get(0).getHknkknto());
        Assert.assertEquals(new Integer(5), beans.get(0).getSaiteisknwtkumufrom());
        Assert.assertEquals(new Integer(6), beans.get(0).getSaiteisknwtkumuto());
        Assert.assertEquals(C_Tuukasyu.USD, beans.get(0).getTuukasyu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkSaiteiS> beans = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(P_SYOUHNCD_01, P_SYOUHNSDNO, C_Hrkkeiro.SYUUDAN,
            P_SAITEISKNWTKUMU, C_Tuukasyu.JPY);

        Assert.assertEquals(3, beans.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("SH01",new Integer(5),new Integer(6),new Integer(0),new Integer(1),new Integer(1),new Integer(2),BizNumber.ONE,BizNumber.ONE,new Integer(6),new Integer(6),C_Tuukasyu.JPY),"1");
        map.put($("SH01",new Integer(6),new Integer(6),new Integer(1),new Integer(1),new Integer(1),new Integer(1),BizNumber.ONE,BizNumber.ONE,new Integer(6),new Integer(7),C_Tuukasyu.JPY),"1");
        map.put($("SH01",new Integer(6),new Integer(7),new Integer(1),new Integer(2),new Integer(1),new Integer(3),BizNumber.ONE,BizNumber.ONE,new Integer(5),new Integer(6),C_Tuukasyu.JPY),"1");

        assertTrue(map.containsKey($(beans.get(0).getSyouhncd(), beans.get(0).getSyusyouhnsdnofrom(), beans.get(0).getSyusyouhnsdnoto(), beans.get(0).getDntsdnumufrom(), beans.get(0).getDntsdnumuto()
            , beans.get(0).getHrkkknsmnkbnfrom(), beans.get(0).getHrkkknsmnkbnto(), beans.get(0).getHknkknfrom(), beans.get(0).getHknkknto(), beans.get(0).getSaiteisknwtkumufrom()
            , beans.get(0).getSaiteisknwtkumuto(), beans.get(0).getTuukasyu())));

        assertTrue(map.containsKey($(beans.get(1).getSyouhncd(), beans.get(1).getSyusyouhnsdnofrom(), beans.get(1).getSyusyouhnsdnoto(), beans.get(1).getDntsdnumufrom(), beans.get(1).getDntsdnumuto()
            , beans.get(1).getHrkkknsmnkbnfrom(), beans.get(1).getHrkkknsmnkbnto(), beans.get(1).getHknkknfrom(), beans.get(1).getHknkknto(), beans.get(1).getSaiteisknwtkumufrom()
            , beans.get(1).getSaiteisknwtkumuto(), beans.get(1).getTuukasyu())));

        assertTrue(map.containsKey($(beans.get(2).getSyouhncd(), beans.get(2).getSyusyouhnsdnofrom(), beans.get(2).getSyusyouhnsdnoto(), beans.get(2).getDntsdnumufrom(), beans.get(2).getDntsdnumuto()
            , beans.get(2).getHrkkknsmnkbnfrom(), beans.get(2).getHrkkknsmnkbnto(), beans.get(2).getHknkknfrom(), beans.get(2).getHknkknto(), beans.get(2).getSaiteisknwtkumufrom()
            , beans.get(2).getSaiteisknwtkumuto(), beans.get(2).getTuukasyu())));

        map.remove($(beans.get(0).getSyouhncd(), beans.get(0).getSyusyouhnsdnofrom(), beans.get(0).getSyusyouhnsdnoto(), beans.get(0).getDntsdnumufrom(), beans.get(0).getDntsdnumuto()
            , beans.get(0).getHrkkknsmnkbnfrom(), beans.get(0).getHrkkknsmnkbnto(), beans.get(0).getHknkknfrom(), beans.get(0).getHknkknto(), beans.get(0).getSaiteisknwtkumufrom()
            , beans.get(0).getSaiteisknwtkumuto(), beans.get(0).getTuukasyu()));

        map.remove($(beans.get(1).getSyouhncd(), beans.get(1).getSyusyouhnsdnofrom(), beans.get(1).getSyusyouhnsdnoto(), beans.get(1).getDntsdnumufrom(), beans.get(1).getDntsdnumuto()
            , beans.get(1).getHrkkknsmnkbnfrom(), beans.get(1).getHrkkknsmnkbnto(), beans.get(1).getHknkknfrom(), beans.get(1).getHknkknto(), beans.get(1).getSaiteisknwtkumufrom()
            , beans.get(1).getSaiteisknwtkumuto(), beans.get(1).getTuukasyu()));

        map.remove($(beans.get(2).getSyouhncd(), beans.get(2).getSyusyouhnsdnofrom(), beans.get(2).getSyusyouhnsdnoto(), beans.get(2).getDntsdnumufrom(), beans.get(2).getDntsdnumuto()
            , beans.get(2).getHrkkknsmnkbnfrom(), beans.get(2).getHrkkknsmnkbnto(), beans.get(2).getHknkknfrom(), beans.get(2).getHknkknto(), beans.get(2).getSaiteisknwtkumufrom()
            , beans.get(2).getSaiteisknwtkumuto(), beans.get(2).getTuukasyu()));

        assertTrue(map.isEmpty());
    }

    /*
    @Test
    @TestOrder(40)
    public void normal3() {

        List<BM_ChkSaiteiS> beans = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(P_SYOUHNCD_01, P_SYOUHNSDNO, C_Hrkkeiro.ZENNOU,
            P_SAITEISKNWTKUMU, C_Tuukasyu.JPY);

        Assert.assertEquals(3, beans.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("SH01",new Integer(5),new Integer(6),new Integer(-1),new Integer(0),new Integer(1),new Integer(8),BizNumber.ONE,BizNumber.ONE,new Integer(5),new Integer(6),C_Tuukasyu.JPY),"1");
        map.put($("SH01",new Integer(5),new Integer(6),new Integer(0),new Integer(0),new Integer(1),new Integer(7),BizNumber.ONE,BizNumber.ONE,new Integer(5),new Integer(6),C_Tuukasyu.JPY),"1");
        map.put($("SH01",new Integer(5),new Integer(6),new Integer(0),new Integer(1),new Integer(1),new Integer(2),BizNumber.ONE,BizNumber.ONE,new Integer(6),new Integer(6),C_Tuukasyu.JPY),"1");

        assertTrue(map.containsKey($(beans.get(0).getSyouhncd(), beans.get(0).getSyusyouhnsdnofrom(), beans.get(0).getSyusyouhnsdnoto(), beans.get(0).getDntsdnumufrom(), beans.get(0).getDntsdnumuto()
            , beans.get(0).getHrkkknsmnkbnfrom(), beans.get(0).getHrkkknsmnkbnto(), beans.get(0).getHknkknfrom(), beans.get(0).getHknkknto(), beans.get(0).getSaiteisknwtkumufrom()
            , beans.get(0).getSaiteisknwtkumuto(), beans.get(0).getTuukasyu())));

        assertTrue(map.containsKey($(beans.get(1).getSyouhncd(), beans.get(1).getSyusyouhnsdnofrom(), beans.get(1).getSyusyouhnsdnoto(), beans.get(1).getDntsdnumufrom(), beans.get(1).getDntsdnumuto()
            , beans.get(1).getHrkkknsmnkbnfrom(), beans.get(1).getHrkkknsmnkbnto(), beans.get(1).getHknkknfrom(), beans.get(1).getHknkknto(), beans.get(1).getSaiteisknwtkumufrom()
            , beans.get(1).getSaiteisknwtkumuto(), beans.get(1).getTuukasyu())));

        assertTrue(map.containsKey($(beans.get(2).getSyouhncd(), beans.get(2).getSyusyouhnsdnofrom(), beans.get(2).getSyusyouhnsdnoto(), beans.get(2).getDntsdnumufrom(), beans.get(2).getDntsdnumuto()
            , beans.get(2).getHrkkknsmnkbnfrom(), beans.get(2).getHrkkknsmnkbnto(), beans.get(2).getHknkknfrom(), beans.get(2).getHknkknto(), beans.get(2).getSaiteisknwtkumufrom()
            , beans.get(2).getSaiteisknwtkumuto(), beans.get(2).getTuukasyu())));

        map.remove($(beans.get(0).getSyouhncd(), beans.get(0).getSyusyouhnsdnofrom(), beans.get(0).getSyusyouhnsdnoto(), beans.get(0).getDntsdnumufrom(), beans.get(0).getDntsdnumuto()
            , beans.get(0).getHrkkknsmnkbnfrom(), beans.get(0).getHrkkknsmnkbnto(), beans.get(0).getHknkknfrom(), beans.get(0).getHknkknto(), beans.get(0).getSaiteisknwtkumufrom()
            , beans.get(0).getSaiteisknwtkumuto(), beans.get(0).getTuukasyu()));

        map.remove($(beans.get(1).getSyouhncd(), beans.get(1).getSyusyouhnsdnofrom(), beans.get(1).getSyusyouhnsdnoto(), beans.get(1).getDntsdnumufrom(), beans.get(1).getDntsdnumuto()
            , beans.get(1).getHrkkknsmnkbnfrom(), beans.get(1).getHrkkknsmnkbnto(), beans.get(1).getHknkknfrom(), beans.get(1).getHknkknto(), beans.get(1).getSaiteisknwtkumufrom()
            , beans.get(1).getSaiteisknwtkumuto(), beans.get(1).getTuukasyu()));

        map.remove($(beans.get(2).getSyouhncd(), beans.get(2).getSyusyouhnsdnofrom(), beans.get(2).getSyusyouhnsdnoto(), beans.get(2).getDntsdnumufrom(), beans.get(2).getDntsdnumuto()
            , beans.get(2).getHrkkknsmnkbnfrom(), beans.get(2).getHrkkknsmnkbnto(), beans.get(2).getHknkknfrom(), beans.get(2).getHknkknto(), beans.get(2).getSaiteisknwtkumufrom()
            , beans.get(2).getSaiteisknwtkumuto(), beans.get(2).getTuukasyu()));

        assertTrue(map.isEmpty());
    }
    */

    /*
    public void blank1() {

        List<BM_ChkSaiteiS> beans = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems("", P_SYOUHNSDNO, C_Hrkkeiro.ZENNOU,
            P_SAITEISKNWTKUMU, C_Tuukasyu.JPY);

        Assert.assertEquals(0, beans.size());
    }
    */
}

