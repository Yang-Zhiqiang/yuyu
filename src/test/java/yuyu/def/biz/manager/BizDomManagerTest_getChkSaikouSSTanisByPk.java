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
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 最高ＳＳ単位チェックマスタエンティティリスト取得(主キー範囲)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkSaikouSSTanisByPk {

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

        List<BM_ChkSaikouSSTani> chkSaikouSSTanis = bizDomManager.getChkSaikouSSTanisByPk(P_SYOUHNCD_03, 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.JPY);

        Assert.assertEquals(0, chkSaikouSSTanis.size());

        BM_ChkSaikouSSTani chkSaikouSSTani1 = new BM_ChkSaikouSSTani(P_SYOUHNCD_01, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani1);

        BM_ChkSaikouSSTani chkSaikouSSTani2 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 7, 8, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani2);

        BM_ChkSaikouSSTani chkSaikouSSTani3 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 4, 5, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani3);

        BM_ChkSaikouSSTani chkSaikouSSTani4 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(11), BizNumber.valueOf(12), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani4);

        BM_ChkSaikouSSTani chkSaikouSSTani5 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(8), BizNumber.valueOf(9), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani5);

        BM_ChkSaikouSSTani chkSaikouSSTani6 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 4, 5, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani6);

        BM_ChkSaikouSSTani chkSaikouSSTani7 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 1, 2, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani7);

        BM_ChkSaikouSSTani chkSaikouSSTani8 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.JPY);

        bizDomManager.insert(chkSaikouSSTani8);

        BM_ChkSaikouSSTani chkSaikouSSTani9 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 5, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani9);

        BM_ChkSaikouSSTani chkSaikouSSTani10 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 7, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani10);

        BM_ChkSaikouSSTani chkSaikouSSTani11 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(9), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani11);

        BM_ChkSaikouSSTani chkSaikouSSTani12 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(11), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani12);

        BM_ChkSaikouSSTani chkSaikouSSTani13 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 2, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani13);

        BM_ChkSaikouSSTani chkSaikouSSTani14 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 4, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani14);

        BM_ChkSaikouSSTani chkSaikouSSTani15 = new BM_ChkSaikouSSTani(P_SYOUHNCD_02, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.USD);

        bizDomManager.insert(chkSaikouSSTani15);

        BM_ChkSaikouSSTani chkSaikouSSTani16 = new BM_ChkSaikouSSTani(P_SYOUHNCD_03, 6, 6, BizNumber.valueOf(10), BizNumber.valueOf(10), 3, 3, C_Tuukasyu.JPY);

        bizDomManager.insert(chkSaikouSSTani16);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkSaikouSSTani());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkSaikouSSTani> chkSaikouSSTanis = bizDomManager.getChkSaikouSSTanisByPk(P_SYOUHNCD_04, 1,
            BizNumber.valueOf(0), 1, C_Tuukasyu.JPY);

        Assert.assertEquals(0, chkSaikouSSTanis.size());
    }


    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkSaikouSSTani> chkSaikouSSTanis = bizDomManager.getChkSaikouSSTanisByPk(P_SYOUHNCD_03, 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.JPY);

        Assert.assertEquals(1, chkSaikouSSTanis.size());

        Assert.assertEquals(P_SYOUHNCD_03, chkSaikouSSTanis.get(0).getSyouhncd());
        Assert.assertEquals(6, chkSaikouSSTanis.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(6, chkSaikouSSTanis.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(BizNumber.valueOf(10), chkSaikouSSTanis.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.valueOf(10), chkSaikouSSTanis.get(0).getHhkntonen());
        Assert.assertEquals(3, chkSaikouSSTanis.get(0).getMoskbnfrom().intValue());
        Assert.assertEquals(3, chkSaikouSSTanis.get(0).getMoskbnto().intValue());
        Assert.assertEquals(C_Tuukasyu.JPY, chkSaikouSSTanis.get(0).getTuukasyu());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkSaikouSSTani> chkSaikouSSTanis = bizDomManager.getChkSaikouSSTanisByPk(P_SYOUHNCD_02, 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.USD);

        Assert.assertEquals(7, chkSaikouSSTanis.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYOUHNCD_02,5,6,BizNumber.valueOf(10),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(9),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(10),2,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(10),3,4,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,6,BizNumber.valueOf(10),BizNumber.valueOf(11),3,3,C_Tuukasyu.USD),"1");
        map.put($(P_SYOUHNCD_02,6,7,BizNumber.valueOf(10),BizNumber.valueOf(10),3,3,C_Tuukasyu.USD),"1");

        assertTrue(map.containsKey($(chkSaikouSSTanis.get(0).getSyouhncd(), chkSaikouSSTanis.get(0).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(0).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(0).getHhknfromnen(), chkSaikouSSTanis.get(0).getHhkntonen(), chkSaikouSSTanis.get(0).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(0).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(0).getTuukasyu())));
        assertTrue(map.containsKey($(chkSaikouSSTanis.get(1).getSyouhncd(), chkSaikouSSTanis.get(1).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(1).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(1).getHhknfromnen(), chkSaikouSSTanis.get(1).getHhkntonen(), chkSaikouSSTanis.get(1).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(1).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(1).getTuukasyu())));
        assertTrue(map.containsKey($(chkSaikouSSTanis.get(2).getSyouhncd(), chkSaikouSSTanis.get(2).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(2).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(2).getHhknfromnen(), chkSaikouSSTanis.get(2).getHhkntonen(), chkSaikouSSTanis.get(2).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(2).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(2).getTuukasyu())));
        assertTrue(map.containsKey($(chkSaikouSSTanis.get(3).getSyouhncd(), chkSaikouSSTanis.get(3).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(3).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(3).getHhknfromnen(), chkSaikouSSTanis.get(3).getHhkntonen(), chkSaikouSSTanis.get(3).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(3).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(3).getTuukasyu())));
        assertTrue(map.containsKey($(chkSaikouSSTanis.get(4).getSyouhncd(), chkSaikouSSTanis.get(4).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(4).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(4).getHhknfromnen(), chkSaikouSSTanis.get(4).getHhkntonen(), chkSaikouSSTanis.get(4).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(4).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(4).getTuukasyu())));
        assertTrue(map.containsKey($(chkSaikouSSTanis.get(5).getSyouhncd(), chkSaikouSSTanis.get(5).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(5).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(5).getHhknfromnen(), chkSaikouSSTanis.get(5).getHhkntonen(), chkSaikouSSTanis.get(5).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(5).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(5).getTuukasyu())));
        assertTrue(map.containsKey($(chkSaikouSSTanis.get(6).getSyouhncd(), chkSaikouSSTanis.get(6).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(6).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(6).getHhknfromnen(), chkSaikouSSTanis.get(6).getHhkntonen(), chkSaikouSSTanis.get(6).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(6).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(6).getTuukasyu())));

        map.remove($(chkSaikouSSTanis.get(0).getSyouhncd(), chkSaikouSSTanis.get(0).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(0).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(0).getHhknfromnen(), chkSaikouSSTanis.get(0).getHhkntonen(), chkSaikouSSTanis.get(0).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(0).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(0).getTuukasyu()));
        map.remove($(chkSaikouSSTanis.get(1).getSyouhncd(), chkSaikouSSTanis.get(1).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(1).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(1).getHhknfromnen(), chkSaikouSSTanis.get(1).getHhkntonen(), chkSaikouSSTanis.get(1).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(1).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(1).getTuukasyu()));
        map.remove($(chkSaikouSSTanis.get(2).getSyouhncd(), chkSaikouSSTanis.get(2).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(2).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(2).getHhknfromnen(), chkSaikouSSTanis.get(2).getHhkntonen(), chkSaikouSSTanis.get(2).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(2).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(2).getTuukasyu()));
        map.remove($(chkSaikouSSTanis.get(3).getSyouhncd(), chkSaikouSSTanis.get(3).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(3).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(3).getHhknfromnen(), chkSaikouSSTanis.get(3).getHhkntonen(), chkSaikouSSTanis.get(3).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(3).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(3).getTuukasyu()));
        map.remove($(chkSaikouSSTanis.get(4).getSyouhncd(), chkSaikouSSTanis.get(4).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(4).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(4).getHhknfromnen(), chkSaikouSSTanis.get(4).getHhkntonen(), chkSaikouSSTanis.get(4).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(4).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(4).getTuukasyu()));
        map.remove($(chkSaikouSSTanis.get(5).getSyouhncd(), chkSaikouSSTanis.get(5).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(5).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(5).getHhknfromnen(), chkSaikouSSTanis.get(5).getHhkntonen(), chkSaikouSSTanis.get(5).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(5).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(5).getTuukasyu()));
        map.remove($(chkSaikouSSTanis.get(6).getSyouhncd(), chkSaikouSSTanis.get(6).getSyusyouhnsdnofrom().intValue(), chkSaikouSSTanis.get(6).getSyusyouhnsdnoto().intValue()
            , chkSaikouSSTanis.get(6).getHhknfromnen(), chkSaikouSSTanis.get(6).getHhkntonen(), chkSaikouSSTanis.get(6).getMoskbnfrom().intValue(), chkSaikouSSTanis.get(6).getMoskbnto().intValue()
            , chkSaikouSSTanis.get(6).getTuukasyu()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_ChkSaikouSSTani> chkSaikouSSTanis = bizDomManager.getChkSaikouSSTanisByPk("", 6,
            BizNumber.valueOf(10), 3, C_Tuukasyu.JPY);

        Assert.assertEquals(0, chkSaikouSSTanis.size());
    }
}
