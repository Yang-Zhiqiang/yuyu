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

import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約
 * 申込商品TBLチェック
 * 商品単位告知上限Ｓチェックマスタエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkSyouhnKokutiJougenSsByPk {

    @Inject
    private BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "M210";
    static String P_SYOUHNCD_02 = "M230";
    static Integer P_SYOUHNSDNO_01 = new Integer(20);
    static Integer P_SYOUHNSDNO_02 = new Integer(30);
    static BizNumber P_HHKNNEN_01 = BizNumber.valueOf(28);
    static Integer P_MOSKBN_01 = new Integer(4);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkSyouhnKokutiJougenS> chkSyouhnKokutiJougenSLst = bizDomManager.getChkSyouhnKokutiJougenSsByPk(
            P_SYOUHNCD_02, P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(0, chkSyouhnKokutiJougenSLst.size());

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS1 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS1.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS1.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS1.setSyusyouhnsdnoto(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS1.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS1.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS1.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS1.setMoskbnto(Integer.valueOf(5));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS1);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS2 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS2.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS2.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS2.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS2.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS2.setHhkntonen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS2.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS2.setMoskbnto(Integer.valueOf(5));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS2);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS3 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS3.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS3.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS3.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS3.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS3.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS3.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS3.setMoskbnto(Integer.valueOf(3));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS3);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS4 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS4.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS4.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS4.setSyusyouhnsdnoto(Integer.valueOf(20));
        bM_ChkSyouhnKokutiJougenS4.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS4.setHhkntonen(BizNumber.valueOf(28));
        bM_ChkSyouhnKokutiJougenS4.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS4.setMoskbnto(Integer.valueOf(4));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS4);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS5 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS5.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS5.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS5.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS5.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS5.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS5.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS5.setMoskbnto(Integer.valueOf(5));
        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS5);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS6 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS6.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS6.setSyusyouhnsdnofrom(Integer.valueOf(20));
        bM_ChkSyouhnKokutiJougenS6.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS6.setHhknfromnen(BizNumber.valueOf(28));
        bM_ChkSyouhnKokutiJougenS6.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS6.setMoskbnfrom(Integer.valueOf(4));
        bM_ChkSyouhnKokutiJougenS6.setMoskbnto(Integer.valueOf(5));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS6);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS7 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS7.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS7.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS7.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS7.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS7.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS7.setMoskbnfrom(Integer.valueOf(5));
        bM_ChkSyouhnKokutiJougenS7.setMoskbnto(Integer.valueOf(5));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS7);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS8 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS8.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS8.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkSyouhnKokutiJougenS8.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS8.setHhknfromnen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS8.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS8.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS8.setMoskbnto(Integer.valueOf(5));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS8);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS9 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS9.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkSyouhnKokutiJougenS9.setSyusyouhnsdnofrom(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS9.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkSyouhnKokutiJougenS9.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkSyouhnKokutiJougenS9.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkSyouhnKokutiJougenS9.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkSyouhnKokutiJougenS9.setMoskbnto(Integer.valueOf(5));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS9);

        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS10 = new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS10.setSyouhncd(P_SYOUHNCD_02);
        bM_ChkSyouhnKokutiJougenS10.setSyusyouhnsdnofrom(Integer.valueOf(20));
        bM_ChkSyouhnKokutiJougenS10.setSyusyouhnsdnoto(Integer.valueOf(20));
        bM_ChkSyouhnKokutiJougenS10.setHhknfromnen(BizNumber.valueOf(28));
        bM_ChkSyouhnKokutiJougenS10.setHhkntonen(BizNumber.valueOf(28));
        bM_ChkSyouhnKokutiJougenS10.setMoskbnfrom(Integer.valueOf(4));
        bM_ChkSyouhnKokutiJougenS10.setMoskbnto(Integer.valueOf(4));

        bizDomManager.insert(bM_ChkSyouhnKokutiJougenS10);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkSyouhnKokutiJougenS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkSyouhnKokutiJougenS> chkSyouhnKokutiJougenSLst = bizDomManager.getChkSyouhnKokutiJougenSsByPk(
            P_SYOUHNCD_02, P_SYOUHNSDNO_02, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(0, chkSyouhnKokutiJougenSLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkSyouhnKokutiJougenS> chkSyouhnKokutiJougenSLst = bizDomManager.getChkSyouhnKokutiJougenSsByPk(
            P_SYOUHNCD_02, P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(1, chkSyouhnKokutiJougenSLst.size());

        Assert.assertEquals(P_SYOUHNCD_02, chkSyouhnKokutiJougenSLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(20), chkSyouhnKokutiJougenSLst.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(Integer.valueOf(20), chkSyouhnKokutiJougenSLst.get(0).getSyusyouhnsdnoto());
        Assert.assertEquals(BizNumber.valueOf(28), chkSyouhnKokutiJougenSLst.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.valueOf(28), chkSyouhnKokutiJougenSLst.get(0).getHhkntonen());
        Assert.assertEquals(Integer.valueOf(4), chkSyouhnKokutiJougenSLst.get(0).getMoskbnfrom());
        Assert.assertEquals(Integer.valueOf(4), chkSyouhnKokutiJougenSLst.get(0).getMoskbnto());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkSyouhnKokutiJougenS> chkSyouhnKokutiJougenSLst = bizDomManager.getChkSyouhnKokutiJougenSsByPk(
            P_SYOUHNCD_01, P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(3, chkSyouhnKokutiJougenSLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYOUHNCD_01,new Integer(19),new Integer(20),BizNumber.valueOf(27),BizNumber.valueOf(28),new Integer(3),new Integer(4)),"1");
        map.put($(P_SYOUHNCD_01,new Integer(19),new Integer(21),BizNumber.valueOf(27),BizNumber.valueOf(29),new Integer(3),new Integer(5)),"1");
        map.put($(P_SYOUHNCD_01,new Integer(20),new Integer(21),BizNumber.valueOf(28),BizNumber.valueOf(29),new Integer(4),new Integer(5)),"1");

        assertTrue(map.containsKey($(chkSyouhnKokutiJougenSLst.get(0).getSyouhncd(), chkSyouhnKokutiJougenSLst.get(0).getSyusyouhnsdnofrom(), chkSyouhnKokutiJougenSLst.get(0).getSyusyouhnsdnoto()
            , chkSyouhnKokutiJougenSLst.get(0).getHhknfromnen(), chkSyouhnKokutiJougenSLst.get(0).getHhkntonen(), chkSyouhnKokutiJougenSLst.get(0).getMoskbnfrom(), chkSyouhnKokutiJougenSLst.get(0).getMoskbnto())));

        assertTrue(map.containsKey($(chkSyouhnKokutiJougenSLst.get(1).getSyouhncd(), chkSyouhnKokutiJougenSLst.get(1).getSyusyouhnsdnofrom(), chkSyouhnKokutiJougenSLst.get(1).getSyusyouhnsdnoto()
            , chkSyouhnKokutiJougenSLst.get(1).getHhknfromnen(), chkSyouhnKokutiJougenSLst.get(1).getHhkntonen(), chkSyouhnKokutiJougenSLst.get(1).getMoskbnfrom(), chkSyouhnKokutiJougenSLst.get(1).getMoskbnto())));

        assertTrue(map.containsKey($(chkSyouhnKokutiJougenSLst.get(2).getSyouhncd(), chkSyouhnKokutiJougenSLst.get(2).getSyusyouhnsdnofrom(), chkSyouhnKokutiJougenSLst.get(2).getSyusyouhnsdnoto()
            , chkSyouhnKokutiJougenSLst.get(2).getHhknfromnen(), chkSyouhnKokutiJougenSLst.get(2).getHhkntonen(), chkSyouhnKokutiJougenSLst.get(2).getMoskbnfrom(), chkSyouhnKokutiJougenSLst.get(2).getMoskbnto())));

        map.remove($(chkSyouhnKokutiJougenSLst.get(0).getSyouhncd(), chkSyouhnKokutiJougenSLst.get(0).getSyusyouhnsdnofrom(), chkSyouhnKokutiJougenSLst.get(0).getSyusyouhnsdnoto()
            , chkSyouhnKokutiJougenSLst.get(0).getHhknfromnen(), chkSyouhnKokutiJougenSLst.get(0).getHhkntonen(), chkSyouhnKokutiJougenSLst.get(0).getMoskbnfrom(), chkSyouhnKokutiJougenSLst.get(0).getMoskbnto()));

        map.remove($(chkSyouhnKokutiJougenSLst.get(1).getSyouhncd(), chkSyouhnKokutiJougenSLst.get(1).getSyusyouhnsdnofrom(), chkSyouhnKokutiJougenSLst.get(1).getSyusyouhnsdnoto()
            , chkSyouhnKokutiJougenSLst.get(1).getHhknfromnen(), chkSyouhnKokutiJougenSLst.get(1).getHhkntonen(), chkSyouhnKokutiJougenSLst.get(1).getMoskbnfrom(), chkSyouhnKokutiJougenSLst.get(1).getMoskbnto()));

        map.remove($(chkSyouhnKokutiJougenSLst.get(2).getSyouhncd(), chkSyouhnKokutiJougenSLst.get(2).getSyusyouhnsdnofrom(), chkSyouhnKokutiJougenSLst.get(2).getSyusyouhnsdnoto()
            , chkSyouhnKokutiJougenSLst.get(2).getHhknfromnen(), chkSyouhnKokutiJougenSLst.get(2).getHhkntonen(), chkSyouhnKokutiJougenSLst.get(2).getMoskbnfrom(), chkSyouhnKokutiJougenSLst.get(2).getMoskbnto()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkSyouhnKokutiJougenS> chkSyouhnKokutiJougenSLst = bizDomManager.getChkSyouhnKokutiJougenSsByPk(
            "", P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(0, chkSyouhnKokutiJougenSLst.size());
    }
}
