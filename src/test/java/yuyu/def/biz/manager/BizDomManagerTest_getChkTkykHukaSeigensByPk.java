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

import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 特約付加制限チェックマスタエンティティリスト取得(主キー範囲)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkTkykHukaSeigensByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYUSYOUHNCD_01 = "SH01";
    static String P_SYUSYOUHNCD_02 = "SH02";
    static String P_SYUSYOUHNCD_03 = "SH03";
    static String P_SYUSYOUHNCD_04 = "SH04";

    static Integer SYUSYOUHNSDNOFROM_29 = Integer.valueOf(29);
    static Integer SYUSYOUHNSDNOFROM_30 = Integer.valueOf(30);
    static Integer SYUSYOUHNSDNOFROM_31 = Integer.valueOf(31);
    static Integer SYUSYOUHNSDNOTO_29 = Integer.valueOf(29);
    static Integer SYUSYOUHNSDNOTO_30 = Integer.valueOf(30);
    static Integer SYUSYOUHNSDNOTO_31 = Integer.valueOf(31);

    static Integer SNTKHOUKBNFROM_5 = Integer.valueOf(5);
    static Integer SNTKHOUKBNFROM_6 = Integer.valueOf(6);
    static Integer SNTKHOUKBNFROM_7 = Integer.valueOf(7);
    static Integer SNTKHOUKBNTO_5 = Integer.valueOf(5);
    static Integer SNTKHOUKBNTO_6 = Integer.valueOf(6);
    static Integer SNTKHOUKBNTO_7 = Integer.valueOf(7);

    static BizNumber HHKNFROMNEN_39 = BizNumber.valueOf(39);
    static BizNumber HHKNFROMNEN_40 = BizNumber.valueOf(40);
    static BizNumber HHKNFROMNEN_41 = BizNumber.valueOf(41);
    static BizNumber HHKNTONEN_39 = BizNumber.valueOf(39);
    static BizNumber HHKNTONEN_40 = BizNumber.valueOf(40);
    static BizNumber HHKNTONEN_41 = BizNumber.valueOf(41);

    static Integer P_SYOUHNSDNO_30 = Integer.valueOf(30);
    static Integer P_SNTKHOUKBN_6 = Integer.valueOf(6);
    static BizNumber P_HHKNNEN_40 = BizNumber.valueOf(40);
    static String P_TKSYOUHNCD_01 = "TS01";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst = bizDomManager.getChkTkykHukaSeigensByPk(P_SYUSYOUHNCD_01,
            P_SYOUHNSDNO_30, P_SNTKHOUKBN_6, P_HHKNNEN_40, P_TKSYOUHNCD_01);

        Assert.assertEquals(0, chkTkykHukaSeigenLst.size());

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen1 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_01, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen1);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen2 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_29,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_5, SNTKHOUKBNTO_6, HHKNFROMNEN_39, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen2);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen3 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen3);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen4 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_31, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_7, HHKNFROMNEN_40, HHKNTONEN_41, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen4);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen5 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_40, HHKNTONEN_40, "TS02");

        bizDomManager.insert(chkTkykHukaSeigen5);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen6 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_39, HHKNTONEN_39, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen6);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen7 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_41, HHKNTONEN_41, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen7);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen8 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_5, SNTKHOUKBNTO_5, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen8);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen9 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_7, SNTKHOUKBNTO_7, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen9);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen10 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_29,
            SYUSYOUHNSDNOTO_29, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen10);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen11 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_02, SYUSYOUHNSDNOFROM_31,
            SYUSYOUHNSDNOTO_31, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen11);

        BM_ChkTkykHukaSeigen chkTkykHukaSeigen12 = new BM_ChkTkykHukaSeigen(P_SYUSYOUHNCD_03, SYUSYOUHNSDNOFROM_30,
            SYUSYOUHNSDNOTO_30, SNTKHOUKBNFROM_6, SNTKHOUKBNTO_6, HHKNFROMNEN_40, HHKNTONEN_40, "TS01");

        bizDomManager.insert(chkTkykHukaSeigen12);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkTkykHukaSeigen());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst = bizDomManager.getChkTkykHukaSeigensByPk(P_SYUSYOUHNCD_04,
            P_SYOUHNSDNO_30, P_SNTKHOUKBN_6, P_HHKNNEN_40, P_TKSYOUHNCD_01);

        Assert.assertEquals(0, chkTkykHukaSeigenLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst = bizDomManager.getChkTkykHukaSeigensByPk(P_SYUSYOUHNCD_01,
            P_SYOUHNSDNO_30, P_SNTKHOUKBN_6, P_HHKNNEN_40, P_TKSYOUHNCD_01);

        Assert.assertEquals(1, chkTkykHukaSeigenLst.size());

        Assert.assertEquals(P_SYUSYOUHNCD_01, chkTkykHukaSeigenLst.get(0).getSyusyouhncd());
        Assert.assertEquals(SYUSYOUHNSDNOFROM_30, chkTkykHukaSeigenLst.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(SYUSYOUHNSDNOTO_30, chkTkykHukaSeigenLst.get(0).getSyusyouhnsdnoto());
        Assert.assertEquals(SNTKHOUKBNFROM_6, chkTkykHukaSeigenLst.get(0).getSntkhoukbnfrom());
        Assert.assertEquals(SNTKHOUKBNTO_6, chkTkykHukaSeigenLst.get(0).getSntkhoukbnto());
        Assert.assertEquals(HHKNFROMNEN_40, chkTkykHukaSeigenLst.get(0).getHhknfromnen());
        Assert.assertEquals(HHKNTONEN_40, chkTkykHukaSeigenLst.get(0).getHhkntonen());
        Assert.assertEquals(P_TKSYOUHNCD_01, chkTkykHukaSeigenLst.get(0).getTksyouhncd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst = bizDomManager.getChkTkykHukaSeigensByPk(P_SYUSYOUHNCD_02,
            P_SYOUHNSDNO_30, P_SNTKHOUKBN_6, P_HHKNNEN_40, P_TKSYOUHNCD_01);

        Assert.assertEquals(3, chkTkykHukaSeigenLst.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYUSYOUHNCD_02,SYUSYOUHNSDNOFROM_29,SYUSYOUHNSDNOTO_30,SNTKHOUKBNFROM_5,SNTKHOUKBNTO_6,HHKNFROMNEN_39,HHKNTONEN_40,P_TKSYOUHNCD_01),"1");
        map.put($(P_SYUSYOUHNCD_02,SYUSYOUHNSDNOFROM_30,SYUSYOUHNSDNOTO_30,SNTKHOUKBNFROM_6,SNTKHOUKBNTO_6,HHKNFROMNEN_40,HHKNTONEN_40,P_TKSYOUHNCD_01),"1");
        map.put($(P_SYUSYOUHNCD_02,SYUSYOUHNSDNOFROM_30,SYUSYOUHNSDNOTO_31,SNTKHOUKBNFROM_6,SNTKHOUKBNTO_7,HHKNFROMNEN_40,HHKNTONEN_41,P_TKSYOUHNCD_01),"1");

        assertTrue(map.containsKey($(chkTkykHukaSeigenLst.get(0).getSyusyouhncd(), chkTkykHukaSeigenLst.get(0).getSyusyouhnsdnofrom(), chkTkykHukaSeigenLst.get(0).getSyusyouhnsdnoto()
            , chkTkykHukaSeigenLst.get(0).getSntkhoukbnfrom(), chkTkykHukaSeigenLst.get(0).getSntkhoukbnto(), chkTkykHukaSeigenLst.get(0).getHhknfromnen(), chkTkykHukaSeigenLst.get(0).getHhkntonen()
            , chkTkykHukaSeigenLst.get(0).getTksyouhncd())));

        assertTrue(map.containsKey($(chkTkykHukaSeigenLst.get(1).getSyusyouhncd(), chkTkykHukaSeigenLst.get(1).getSyusyouhnsdnofrom(), chkTkykHukaSeigenLst.get(1).getSyusyouhnsdnoto()
            , chkTkykHukaSeigenLst.get(1).getSntkhoukbnfrom(), chkTkykHukaSeigenLst.get(1).getSntkhoukbnto(), chkTkykHukaSeigenLst.get(1).getHhknfromnen(), chkTkykHukaSeigenLst.get(1).getHhkntonen()
            , chkTkykHukaSeigenLst.get(1).getTksyouhncd())));

        assertTrue(map.containsKey($(chkTkykHukaSeigenLst.get(2).getSyusyouhncd(), chkTkykHukaSeigenLst.get(2).getSyusyouhnsdnofrom(), chkTkykHukaSeigenLst.get(2).getSyusyouhnsdnoto()
            , chkTkykHukaSeigenLst.get(2).getSntkhoukbnfrom(), chkTkykHukaSeigenLst.get(2).getSntkhoukbnto(), chkTkykHukaSeigenLst.get(2).getHhknfromnen(), chkTkykHukaSeigenLst.get(2).getHhkntonen()
            , chkTkykHukaSeigenLst.get(2).getTksyouhncd())));

        map.remove($(chkTkykHukaSeigenLst.get(0).getSyusyouhncd(), chkTkykHukaSeigenLst.get(0).getSyusyouhnsdnofrom(), chkTkykHukaSeigenLst.get(0).getSyusyouhnsdnoto()
            , chkTkykHukaSeigenLst.get(0).getSntkhoukbnfrom(), chkTkykHukaSeigenLst.get(0).getSntkhoukbnto(), chkTkykHukaSeigenLst.get(0).getHhknfromnen(), chkTkykHukaSeigenLst.get(0).getHhkntonen()
            , chkTkykHukaSeigenLst.get(0).getTksyouhncd()));

        map.remove($(chkTkykHukaSeigenLst.get(1).getSyusyouhncd(), chkTkykHukaSeigenLst.get(1).getSyusyouhnsdnofrom(), chkTkykHukaSeigenLst.get(1).getSyusyouhnsdnoto()
            , chkTkykHukaSeigenLst.get(1).getSntkhoukbnfrom(), chkTkykHukaSeigenLst.get(1).getSntkhoukbnto(), chkTkykHukaSeigenLst.get(1).getHhknfromnen(), chkTkykHukaSeigenLst.get(1).getHhkntonen()
            , chkTkykHukaSeigenLst.get(1).getTksyouhncd()));

        map.remove($(chkTkykHukaSeigenLst.get(2).getSyusyouhncd(), chkTkykHukaSeigenLst.get(2).getSyusyouhnsdnofrom(), chkTkykHukaSeigenLst.get(2).getSyusyouhnsdnoto()
            , chkTkykHukaSeigenLst.get(2).getSntkhoukbnfrom(), chkTkykHukaSeigenLst.get(2).getSntkhoukbnto(), chkTkykHukaSeigenLst.get(2).getHhknfromnen(), chkTkykHukaSeigenLst.get(2).getHhkntonen()
            , chkTkykHukaSeigenLst.get(2).getTksyouhncd()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst = bizDomManager.getChkTkykHukaSeigensByPk("",
            P_SYOUHNSDNO_30, P_SNTKHOUKBN_6, P_HHKNNEN_40, P_TKSYOUHNCD_01);

        Assert.assertEquals(0, chkTkykHukaSeigenLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst = bizDomManager.getChkTkykHukaSeigensByPk(P_SYUSYOUHNCD_02,
            P_SYOUHNSDNO_30, P_SNTKHOUKBN_6, P_HHKNNEN_40, "");

        Assert.assertEquals(0, chkTkykHukaSeigenLst.size());
    }
}
