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
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 最高ＳＳ単位事方書チェックマスタエンティティリスト取得(主キー範囲)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhSaikouSSTanisByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static String P_SYOUHNCD_03 = "SH03";
    static String P_SYOUHNCD_04 = "SH04";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTanis = bizDomManager.getChkJhSaikouSSTanisByPk(P_SYOUHNCD_03, 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.JPY);

        Assert.assertEquals(0, chkJhSaikouSSTanis.size());

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani1 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_01, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani1);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani2 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 7, 8, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani2);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani3 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 4, 5, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani3);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani4 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(11), BizNumber.valueOf(12), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani4);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani5 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(8), BizNumber.valueOf(9), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani5);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani6 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 4, 5, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani6);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani7 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 1, 2, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani7);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani8 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaikouSSTani8);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani9 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 5, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani9);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani10 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 7, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani10);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani11 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(9), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani11);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani12 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(11), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani12);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani13 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 2, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani13);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani14 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 4, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani14);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani15 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkJhSaikouSSTani15);

        BM_ChkJhSaikouSSTani chkJhSaikouSSTani16 = new BM_ChkJhSaikouSSTani(P_SYOUHNCD_03, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.JPY);

        bizDomManager.insert(chkJhSaikouSSTani16);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkJhSaikouSSTani());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTanis = bizDomManager.getChkJhSaikouSSTanisByPk(P_SYOUHNCD_04, 1,
            BizNumber.valueOf(0), 1, C_Tuukasyu.JPY);

        Assert.assertEquals(0, chkJhSaikouSSTanis.size());
    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTanis = bizDomManager.getChkJhSaikouSSTanisByPk(P_SYOUHNCD_03, 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.JPY);

        Assert.assertEquals(1, chkJhSaikouSSTanis.size());

        Assert.assertEquals(P_SYOUHNCD_03, chkJhSaikouSSTanis.get(0).getSyouhncd());
        Assert.assertEquals(6, chkJhSaikouSSTanis.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(6, chkJhSaikouSSTanis.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(BizNumber.valueOf(10), chkJhSaikouSSTanis.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.valueOf(10), chkJhSaikouSSTanis.get(0).getHhkntonen());
        Assert.assertEquals(3, chkJhSaikouSSTanis.get(0).getMoskbnfrom().intValue());
        Assert.assertEquals(3, chkJhSaikouSSTanis.get(0).getMoskbnto().intValue());
        Assert.assertEquals(C_Tuukasyu.JPY, chkJhSaikouSSTanis.get(0).getTuukasyu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTanis = bizDomManager.getChkJhSaikouSSTanisByPk(P_SYOUHNCD_02, 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.USD);

        Assert.assertEquals(7, chkJhSaikouSSTanis.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(P_SYOUHNCD_02,5,6,BizNumber.valueOf(10),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(9),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(10),2,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(10),3,4,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(11),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,7,BizNumber.valueOf(10),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");

        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(0).getSyouhncd(),chkJhSaikouSSTanis.get(0).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(0).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(0).getHhknfromnen(),chkJhSaikouSSTanis.get(0).getHhkntonen(),
            chkJhSaikouSSTanis.get(0).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(0).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(0).getTuukasyu())));


        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(1).getSyouhncd(),chkJhSaikouSSTanis.get(1).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(1).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(1).getHhknfromnen(),chkJhSaikouSSTanis.get(1).getHhkntonen(),
            chkJhSaikouSSTanis.get(1).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(1).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(1).getTuukasyu())));


        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(2).getSyouhncd(),chkJhSaikouSSTanis.get(2).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(2).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(2).getHhknfromnen(),chkJhSaikouSSTanis.get(2).getHhkntonen(),
            chkJhSaikouSSTanis.get(2).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(2).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(2).getTuukasyu())));


        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(3).getSyouhncd(),chkJhSaikouSSTanis.get(3).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(3).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(3).getHhknfromnen(),chkJhSaikouSSTanis.get(3).getHhkntonen(),
            chkJhSaikouSSTanis.get(3).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(3).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(3).getTuukasyu())));


        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(4).getSyouhncd(),chkJhSaikouSSTanis.get(4).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(4).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(4).getHhknfromnen(),chkJhSaikouSSTanis.get(4).getHhkntonen(),
            chkJhSaikouSSTanis.get(4).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(4).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(4).getTuukasyu())));


        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(5).getSyouhncd(),chkJhSaikouSSTanis.get(5).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(5).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(5).getHhknfromnen(),chkJhSaikouSSTanis.get(5).getHhkntonen(),
            chkJhSaikouSSTanis.get(5).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(5).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(5).getTuukasyu())));


        assertTrue(map.containsKey($(chkJhSaikouSSTanis.get(6).getSyouhncd(),chkJhSaikouSSTanis.get(6).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(6).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(6).getHhknfromnen(),chkJhSaikouSSTanis.get(6).getHhkntonen(),
            chkJhSaikouSSTanis.get(6).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(6).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(6).getTuukasyu())));

        map.remove($(chkJhSaikouSSTanis.get(0).getSyouhncd(),chkJhSaikouSSTanis.get(0).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(0).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(0).getHhknfromnen(),chkJhSaikouSSTanis.get(0).getHhkntonen(),
            chkJhSaikouSSTanis.get(0).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(0).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(0).getTuukasyu()));

        map.remove($(chkJhSaikouSSTanis.get(1).getSyouhncd(),chkJhSaikouSSTanis.get(1).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(1).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(1).getHhknfromnen(),chkJhSaikouSSTanis.get(1).getHhkntonen(),
            chkJhSaikouSSTanis.get(1).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(1).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(1).getTuukasyu()));

        map.remove($(chkJhSaikouSSTanis.get(2).getSyouhncd(),chkJhSaikouSSTanis.get(2).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(2).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(2).getHhknfromnen(),chkJhSaikouSSTanis.get(2).getHhkntonen(),
            chkJhSaikouSSTanis.get(2).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(2).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(2).getTuukasyu()));

        map.remove($(chkJhSaikouSSTanis.get(3).getSyouhncd(),chkJhSaikouSSTanis.get(3).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(3).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(3).getHhknfromnen(),chkJhSaikouSSTanis.get(3).getHhkntonen(),
            chkJhSaikouSSTanis.get(3).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(3).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(3).getTuukasyu()));

        map.remove($(chkJhSaikouSSTanis.get(4).getSyouhncd(),chkJhSaikouSSTanis.get(4).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(4).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(4).getHhknfromnen(),chkJhSaikouSSTanis.get(4).getHhkntonen(),
            chkJhSaikouSSTanis.get(4).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(4).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(4).getTuukasyu()));


        map.remove($(chkJhSaikouSSTanis.get(5).getSyouhncd(),chkJhSaikouSSTanis.get(5).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(5).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(5).getHhknfromnen(),chkJhSaikouSSTanis.get(5).getHhkntonen(),
            chkJhSaikouSSTanis.get(5).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(5).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(5).getTuukasyu()));


        map.remove($(chkJhSaikouSSTanis.get(6).getSyouhncd(),chkJhSaikouSSTanis.get(6).getSyusyouhnsdnofrom().intValue(),
            chkJhSaikouSSTanis.get(6).getSyusyouhnsdnoto().intValue(),chkJhSaikouSSTanis.get(6).getHhknfromnen(),chkJhSaikouSSTanis.get(6).getHhkntonen(),
            chkJhSaikouSSTanis.get(6).getMoskbnfrom().intValue(),chkJhSaikouSSTanis.get(6).getMoskbnto().intValue(),chkJhSaikouSSTanis.get(6).getTuukasyu()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTanis = bizDomManager.getChkJhSaikouSSTanisByPk("", 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.JPY);

        Assert.assertEquals(0, chkJhSaikouSSTanis.size());
    }
}
