package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込書入力<br />
 * 商品属性マスタエンティティリスト取得（表示日、主契約特約区分、保険種類番号、年金原資最低保証率）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_001 = "1111";
    static Integer P_SYOUHNSDNO_001 = new Integer(10);
    static Integer P_SYOUHNSDNO_002 = new Integer(11);
    static Integer P_SYOUHNSDNO_003 = new Integer(12);
    static Integer P_SYOUHNSDNO_004 = new Integer(13);
    static Integer P_SYOUHNSDNO_005 = new Integer(14);
    static Integer P_SYOUHNSDNO_006 = new Integer(15);
    static Integer P_SYOUHNSDNO_007 = new Integer(16);
    static Integer P_SYOUHNSDNO_008 = new Integer(17);
    static Integer P_SYOUHNSDNO_009 = new Integer(18);
    static BizDate P_HYOUJIDATE1 = BizDate.valueOf(20160315);
    static Integer P_NKGNSHOSYOURITU_001 = new Integer(111);
    static Integer P_NKGNSHOSYOURITU_002 = new Integer(222);
    static Integer P_NKGNSHOSYOURITU_003 = new Integer(333);
    static Integer P_NKGNSHOSYOURITU_004 = new Integer(444);
    static Integer P_NKGNSHOSYOURITU_005 = new Integer(121);
    static Integer P_NKGNSHOSYOURITU_006 = new Integer(122);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(P_HYOUJIDATE1, C_SyutkKbn.SYU, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, new Integer(122));
        Assert.assertEquals(0,syouhnZokuseiLst.size());

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_001);
        syouhnZokusei1.setHyoujifromymd(BizDate.valueOf(20160316));
        syouhnZokusei1.setHyoujitoymd(BizDate.valueOf(20160316));
        syouhnZokusei1.setSyutkkbn(C_SyutkKbn.SYU);
        syouhnZokusei1.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei1.setNkgnshosyouritu(P_NKGNSHOSYOURITU_001);

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_002);
        syouhnZokusei2.setHyoujifromymd(BizDate.valueOf(20160314));
        syouhnZokusei2.setHyoujitoymd(BizDate.valueOf(20160314));
        syouhnZokusei2.setSyutkkbn(C_SyutkKbn.SYU);
        syouhnZokusei2.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei2.setNkgnshosyouritu(P_NKGNSHOSYOURITU_002);

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_003);
        syouhnZokusei3.setHyoujifromymd(BizDate.valueOf(20160315));
        syouhnZokusei3.setHyoujitoymd(BizDate.valueOf(20160315));
        syouhnZokusei3.setSyutkkbn(C_SyutkKbn.SYU);
        syouhnZokusei3.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei3.setNkgnshosyouritu(P_NKGNSHOSYOURITU_003);

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_004);
        syouhnZokusei4.setHyoujifromymd(BizDate.valueOf(20160315));
        syouhnZokusei4.setHyoujitoymd(BizDate.valueOf(20160315));
        syouhnZokusei4.setSyutkkbn(C_SyutkKbn.SYU);
        syouhnZokusei4.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);
        syouhnZokusei4.setNkgnshosyouritu(P_NKGNSHOSYOURITU_004);

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_005);
        syouhnZokusei5.setHyoujifromymd(BizDate.valueOf(20160315));
        syouhnZokusei5.setHyoujitoymd(BizDate.valueOf(20160315));
        syouhnZokusei5.setSyutkkbn(C_SyutkKbn.SYU);
        syouhnZokusei5.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei5.setNkgnshosyouritu(P_NKGNSHOSYOURITU_005);

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_006);
        syouhnZokusei6.setHyoujifromymd(BizDate.valueOf(20160315));
        syouhnZokusei6.setHyoujitoymd(BizDate.valueOf(20160315));
        syouhnZokusei6.setSyutkkbn(C_SyutkKbn.SYU);
        syouhnZokusei6.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei6.setNkgnshosyouritu(P_NKGNSHOSYOURITU_006);

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei7 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_007);
        syouhnZokusei7.setHyoujifromymd(BizDate.valueOf(20160314));
        syouhnZokusei7.setHyoujitoymd(BizDate.valueOf(20160315));
        syouhnZokusei7.setSyutkkbn(C_SyutkKbn.TK);
        syouhnZokusei7.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei7.setNkgnshosyouritu(P_NKGNSHOSYOURITU_006);

        bizDomManager.insert(syouhnZokusei7);

        BM_SyouhnZokusei syouhnZokusei8 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_008);
        syouhnZokusei8.setHyoujifromymd(BizDate.valueOf(20160315));
        syouhnZokusei8.setHyoujitoymd(BizDate.valueOf(20160316));
        syouhnZokusei8.setSyutkkbn(C_SyutkKbn.TK);
        syouhnZokusei8.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei8.setNkgnshosyouritu(P_NKGNSHOSYOURITU_006);

        bizDomManager.insert(syouhnZokusei8);

        BM_SyouhnZokusei syouhnZokusei9 = new BM_SyouhnZokusei(P_SYOUHNCD_001, P_SYOUHNSDNO_009);
        syouhnZokusei9.setHyoujifromymd(BizDate.valueOf(20160314));
        syouhnZokusei9.setHyoujitoymd(BizDate.valueOf(20160316));
        syouhnZokusei9.setSyutkkbn(C_SyutkKbn.TK);
        syouhnZokusei9.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        syouhnZokusei9.setNkgnshosyouritu(P_NKGNSHOSYOURITU_006);

        bizDomManager.insert(syouhnZokusei9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(P_HYOUJIDATE1, C_SyutkKbn.SYU, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, new Integer(121));

        Assert.assertEquals(0,syouhnZokuseiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(P_HYOUJIDATE1, C_SyutkKbn.SYU, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, new Integer(122));

        Assert.assertEquals(1,syouhnZokuseiLst.size());

        Assert.assertEquals(P_SYOUHNCD_001, syouhnZokuseiLst.get(0).getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_006, syouhnZokuseiLst.get(0).getSyouhnsdno());
        Assert.assertEquals(BizDate.valueOf(20160315), syouhnZokuseiLst.get(0).getHyoujifromymd());
        Assert.assertEquals(BizDate.valueOf(20160315), syouhnZokuseiLst.get(0).getHyoujitoymd());
        Assert.assertEquals(C_SyutkKbn.SYU, syouhnZokuseiLst.get(0).getSyutkkbn());
        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, syouhnZokuseiLst.get(0).getHknsyuruino());
        Assert.assertEquals(P_NKGNSHOSYOURITU_006, syouhnZokuseiLst.get(0).getNkgnshosyouritu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(P_HYOUJIDATE1, C_SyutkKbn.TK, C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, new Integer(122));

        Assert.assertEquals(3,syouhnZokuseiLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYOUHNCD_001,P_SYOUHNSDNO_007,BizDate.valueOf(20160314),BizDate.valueOf(20160315),C_SyutkKbn.TK,C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,P_NKGNSHOSYOURITU_006), "1");
        map.put($(P_SYOUHNCD_001,P_SYOUHNSDNO_008,BizDate.valueOf(20160315),BizDate.valueOf(20160316),C_SyutkKbn.TK,C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,P_NKGNSHOSYOURITU_006), "1");
        map.put($(P_SYOUHNCD_001,P_SYOUHNSDNO_009,BizDate.valueOf(20160314),BizDate.valueOf(20160316),C_SyutkKbn.TK,C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU,P_NKGNSHOSYOURITU_006), "1");

        for(BM_SyouhnZokusei syouhnZokusei:syouhnZokuseiLst){

            map.remove($(syouhnZokusei.getSyouhncd(),syouhnZokusei.getSyouhnsdno(),syouhnZokusei.getHyoujifromymd(),syouhnZokusei.getHyoujitoymd(),syouhnZokusei.getSyutkkbn(),syouhnZokusei.getHknsyuruino(),syouhnZokusei.getNkgnshosyouritu()));
        }
        assertTrue(map.isEmpty());
    }

}
