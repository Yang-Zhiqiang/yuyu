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

import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 告知上限Ｓチェックマスタエンティティリスト取得(主キー範囲)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkKokutiJougenSsByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "M210";
    static String P_SYOUHNCD_02 = "T340";
    static String P_SYOUHNCD_03 = "B320";
    static Integer P_SYOUHNSDNO_01 = new Integer(20);
    static Integer P_SYOUHNSDNO_02 = new Integer(15);
    static Integer P_SYOUHNSDNO_03 = new Integer(30);
    static BizNumber P_HHKNNEN_01 = BizNumber.valueOf(28);
    static BizNumber P_HHKNNEN_02 = BizNumber.valueOf(25);
    static Integer P_MOSKBN_01 = new Integer(4);
    static Integer P_MOSKBN_02 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkKokutiJougenS> chkKokutiJougenSLst = bizDomManager.getChkKokutiJougenSsByPk(
            P_SYOUHNCD_01, P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(0, chkKokutiJougenSLst.size());

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS1 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS1.setSyouhncd("M210");
        bM_ChkKokutiJougenS1.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkKokutiJougenS1.setSyusyouhnsdnoto(Integer.valueOf(21));
        bM_ChkKokutiJougenS1.setHhknfromnen(BizNumber.valueOf(27));
        bM_ChkKokutiJougenS1.setHhkntonen(BizNumber.valueOf(29));
        bM_ChkKokutiJougenS1.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkKokutiJougenS1.setMoskbnto(Integer.valueOf(5));
        bizDomManager.insert(bM_ChkKokutiJougenS1);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS2 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS2.setSyouhncd("M230");
        bM_ChkKokutiJougenS2.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS2.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS2.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS2.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS2.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS2.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS2);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS3 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS3.setSyouhncd("B320");
        bM_ChkKokutiJougenS3.setSyusyouhnsdnofrom(Integer.valueOf(31));
        bM_ChkKokutiJougenS3.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS3.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS3.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS3.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS3.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS3);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS4 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS4.setSyouhncd("B320");
        bM_ChkKokutiJougenS4.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS4.setSyusyouhnsdnoto(Integer.valueOf(29));
        bM_ChkKokutiJougenS4.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS4.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS4.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS4.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS4);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS5 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS5.setSyouhncd("B320");
        bM_ChkKokutiJougenS5.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS5.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS5.setHhknfromnen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS5.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS5.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS5.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS5);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS6 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS6.setSyouhncd("B320");
        bM_ChkKokutiJougenS6.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS6.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS6.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS6.setHhkntonen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS6.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS6.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS6);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS7 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS7.setSyouhncd("B320");
        bM_ChkKokutiJougenS7.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS7.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS7.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS7.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS7.setMoskbnfrom(Integer.valueOf(3));
        bM_ChkKokutiJougenS7.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS7);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS8 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS8.setSyouhncd("B320");
        bM_ChkKokutiJougenS8.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS8.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS8.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS8.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS8.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS8.setMoskbnto(Integer.valueOf(1));
        bizDomManager.insert(bM_ChkKokutiJougenS8);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS9 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS9.setSyouhncd("B320");
        bM_ChkKokutiJougenS9.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS9.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS9.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS9.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS9.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS9.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS9);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS10 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS10.setSyouhncd("B320");
        bM_ChkKokutiJougenS10.setSyusyouhnsdnofrom(Integer.valueOf(29));
        bM_ChkKokutiJougenS10.setSyusyouhnsdnoto(Integer.valueOf(30));
        bM_ChkKokutiJougenS10.setHhknfromnen(BizNumber.valueOf(24));
        bM_ChkKokutiJougenS10.setHhkntonen(BizNumber.valueOf(25));
        bM_ChkKokutiJougenS10.setMoskbnfrom(Integer.valueOf(1));
        bM_ChkKokutiJougenS10.setMoskbnto(Integer.valueOf(2));
        bizDomManager.insert(bM_ChkKokutiJougenS10);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS11 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS11.setSyouhncd("B320");
        bM_ChkKokutiJougenS11.setSyusyouhnsdnofrom(Integer.valueOf(30));
        bM_ChkKokutiJougenS11.setSyusyouhnsdnoto(Integer.valueOf(31));
        bM_ChkKokutiJougenS11.setHhknfromnen(BizNumber.valueOf(25));
        bM_ChkKokutiJougenS11.setHhkntonen(BizNumber.valueOf(26));
        bM_ChkKokutiJougenS11.setMoskbnfrom(Integer.valueOf(2));
        bM_ChkKokutiJougenS11.setMoskbnto(Integer.valueOf(3));
        bizDomManager.insert(bM_ChkKokutiJougenS11);

        BM_ChkKokutiJougenS bM_ChkKokutiJougenS12 = new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS12.setSyouhncd("B320");
        bM_ChkKokutiJougenS12.setSyusyouhnsdnofrom(Integer.valueOf(30));
        bM_ChkKokutiJougenS12.setSyusyouhnsdnoto(Integer.valueOf(30));
        bM_ChkKokutiJougenS12.setHhknfromnen(BizNumber.valueOf(25));
        bM_ChkKokutiJougenS12.setHhkntonen(BizNumber.valueOf(25));
        bM_ChkKokutiJougenS12.setMoskbnfrom(Integer.valueOf(2));
        bM_ChkKokutiJougenS12.setMoskbnto(Integer.valueOf(2));
        bizDomManager.insert(bM_ChkKokutiJougenS12);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkKokutiJougenS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkKokutiJougenS> chkKokutiJougenSLst = bizDomManager.getChkKokutiJougenSsByPk(
            P_SYOUHNCD_02, P_SYOUHNSDNO_02, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(0, chkKokutiJougenSLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkKokutiJougenS> chkKokutiJougenSLst = bizDomManager.getChkKokutiJougenSsByPk(
            P_SYOUHNCD_01, P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(1, chkKokutiJougenSLst.size());

        Assert.assertEquals("M210", chkKokutiJougenSLst.get(0).getSyouhncd());

        Assert.assertEquals(Integer.valueOf(19), chkKokutiJougenSLst.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(21), chkKokutiJougenSLst.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(BizNumber.valueOf(27), chkKokutiJougenSLst.get(0).getHhknfromnen());

        Assert.assertEquals(BizNumber.valueOf(29), chkKokutiJougenSLst.get(0).getHhkntonen());

        Assert.assertEquals(Integer.valueOf(3), chkKokutiJougenSLst.get(0).getMoskbnfrom());

        Assert.assertEquals(Integer.valueOf(5), chkKokutiJougenSLst.get(0).getMoskbnto());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkKokutiJougenS> chkKokutiJougenSLst = bizDomManager.getChkKokutiJougenSsByPk(
            P_SYOUHNCD_03, P_SYOUHNSDNO_03, P_HHKNNEN_02, P_MOSKBN_02);

        Assert.assertEquals(4, chkKokutiJougenSLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("B320",Integer.valueOf(29),Integer.valueOf(30),Integer.valueOf(24),Integer.valueOf(25),Integer.valueOf(1),Integer.valueOf(2)), "1");
        map.put($("B320",Integer.valueOf(29),Integer.valueOf(31),Integer.valueOf(24),Integer.valueOf(26),Integer.valueOf(1),Integer.valueOf(3)), "1");
        map.put($("B320",Integer.valueOf(30),Integer.valueOf(30),Integer.valueOf(25),Integer.valueOf(25),Integer.valueOf(2),Integer.valueOf(2)), "1");
        map.put($("B320",Integer.valueOf(30),Integer.valueOf(31),Integer.valueOf(25),Integer.valueOf(26),Integer.valueOf(2),Integer.valueOf(3)), "1");

        assertTrue(map.containsKey($(chkKokutiJougenSLst.get(0).getSyouhncd(),chkKokutiJougenSLst.get(0).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(0).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(0).getHhknfromnen(),chkKokutiJougenSLst.get(0).getHhkntonen(),chkKokutiJougenSLst.get(0).getMoskbnfrom(),chkKokutiJougenSLst.get(0).getMoskbnto())));
        assertTrue(map.containsKey($(chkKokutiJougenSLst.get(1).getSyouhncd(),chkKokutiJougenSLst.get(1).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(1).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(1).getHhknfromnen(),chkKokutiJougenSLst.get(1).getHhkntonen(),chkKokutiJougenSLst.get(1).getMoskbnfrom(),chkKokutiJougenSLst.get(1).getMoskbnto())));
        assertTrue(map.containsKey($(chkKokutiJougenSLst.get(2).getSyouhncd(),chkKokutiJougenSLst.get(2).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(2).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(2).getHhknfromnen(),chkKokutiJougenSLst.get(2).getHhkntonen(),chkKokutiJougenSLst.get(2).getMoskbnfrom(),chkKokutiJougenSLst.get(2).getMoskbnto())));
        assertTrue(map.containsKey($(chkKokutiJougenSLst.get(3).getSyouhncd(),chkKokutiJougenSLst.get(3).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(3).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(3).getHhknfromnen(),chkKokutiJougenSLst.get(3).getHhkntonen(),chkKokutiJougenSLst.get(3).getMoskbnfrom(),chkKokutiJougenSLst.get(3).getMoskbnto())));
        map.remove($(chkKokutiJougenSLst.get(0).getSyouhncd(),chkKokutiJougenSLst.get(0).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(0).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(0).getHhknfromnen(),chkKokutiJougenSLst.get(0).getHhkntonen(),chkKokutiJougenSLst.get(0).getMoskbnfrom(),chkKokutiJougenSLst.get(0).getMoskbnto()));
        map.remove($(chkKokutiJougenSLst.get(1).getSyouhncd(),chkKokutiJougenSLst.get(1).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(1).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(1).getHhknfromnen(),chkKokutiJougenSLst.get(1).getHhkntonen(),chkKokutiJougenSLst.get(1).getMoskbnfrom(),chkKokutiJougenSLst.get(1).getMoskbnto()));
        map.remove($(chkKokutiJougenSLst.get(2).getSyouhncd(),chkKokutiJougenSLst.get(2).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(2).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(2).getHhknfromnen(),chkKokutiJougenSLst.get(2).getHhkntonen(),chkKokutiJougenSLst.get(2).getMoskbnfrom(),chkKokutiJougenSLst.get(2).getMoskbnto()));
        map.remove($(chkKokutiJougenSLst.get(3).getSyouhncd(),chkKokutiJougenSLst.get(3).getSyusyouhnsdnofrom(),chkKokutiJougenSLst.get(3).getSyusyouhnsdnoto()
            ,chkKokutiJougenSLst.get(3).getHhknfromnen(),chkKokutiJougenSLst.get(3).getHhkntonen(),chkKokutiJougenSLst.get(3).getMoskbnfrom(),chkKokutiJougenSLst.get(3).getMoskbnto()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkKokutiJougenS> chkKokutiJougenSLst = bizDomManager.getChkKokutiJougenSsByPk(
            "", P_SYOUHNSDNO_01, P_HHKNNEN_01, P_MOSKBN_01);

        Assert.assertEquals(0, chkKokutiJougenSLst.size());
    }
}
