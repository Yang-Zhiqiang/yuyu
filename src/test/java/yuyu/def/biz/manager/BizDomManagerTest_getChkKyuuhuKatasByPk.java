package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 給付型チェックマスタエンティティリスト取得(主キー範囲)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkKyuuhuKatasByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "M210";
    static String P_SYOUHNCD_02 = "M710";
    static String P_SYOUHNCD_03 = "T110";
    static Integer P_SYOUHNSDNO_01 = new Integer(51);
    static Integer P_SYOUHNSDNO_02 = new Integer(30);
    static Integer P_SYOUHNSDNO_03 = new Integer(33);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkKyuuhuKata> chkKyuuhuKataLst = bizDomManager.getChkKyuuhuKatasByPk(P_SYOUHNCD_01, P_SYOUHNSDNO_01,
            C_KyhgndkataKbn.TYPE120);

        Assert.assertEquals(0, chkKyuuhuKataLst.size());

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata1 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata1.setSyouhncd("M210");
        bM_ChkKyuuhuKata1.setSyusyouhnsdnofrom(Integer.valueOf(50));
        bM_ChkKyuuhuKata1.setSyusyouhnsdnoto(Integer.valueOf(52));
        bM_ChkKyuuhuKata1.setKyhkatakbn(C_KyhgndkataKbn.TYPE120);
        bizDomManager.insert(bM_ChkKyuuhuKata1);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata2 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata2.setSyouhncd("M220");
        bM_ChkKyuuhuKata2.setSyusyouhnsdnofrom(Integer.valueOf(32));
        bM_ChkKyuuhuKata2.setSyusyouhnsdnoto(Integer.valueOf(34));
        bM_ChkKyuuhuKata2.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata2);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata3 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata3.setSyouhncd("T110");
        bM_ChkKyuuhuKata3.setSyusyouhnsdnofrom(Integer.valueOf(34));
        bM_ChkKyuuhuKata3.setSyusyouhnsdnoto(Integer.valueOf(34));
        bM_ChkKyuuhuKata3.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata3);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata4 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata4.setSyouhncd("T110");
        bM_ChkKyuuhuKata4.setSyusyouhnsdnofrom(Integer.valueOf(32));
        bM_ChkKyuuhuKata4.setSyusyouhnsdnoto(Integer.valueOf(32));
        bM_ChkKyuuhuKata4.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata4);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata5 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata5.setSyouhncd("T110");
        bM_ChkKyuuhuKata5.setSyusyouhnsdnofrom(Integer.valueOf(32));
        bM_ChkKyuuhuKata5.setSyusyouhnsdnoto(Integer.valueOf(34));
        bM_ChkKyuuhuKata5.setKyhkatakbn(C_KyhgndkataKbn.TYPE180);
        bizDomManager.insert(bM_ChkKyuuhuKata5);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata6 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata6.setSyouhncd("T110");
        bM_ChkKyuuhuKata6.setSyusyouhnsdnofrom(Integer.valueOf(32));
        bM_ChkKyuuhuKata6.setSyusyouhnsdnoto(Integer.valueOf(33));
        bM_ChkKyuuhuKata6.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata6);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata7 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata7.setSyouhncd("T110");
        bM_ChkKyuuhuKata7.setSyusyouhnsdnofrom(Integer.valueOf(33));
        bM_ChkKyuuhuKata7.setSyusyouhnsdnoto(Integer.valueOf(34));
        bM_ChkKyuuhuKata7.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata7);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata8 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata8.setSyouhncd("T110");
        bM_ChkKyuuhuKata8.setSyusyouhnsdnofrom(Integer.valueOf(32));
        bM_ChkKyuuhuKata8.setSyusyouhnsdnoto(Integer.valueOf(34));
        bM_ChkKyuuhuKata8.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata8);

        BM_ChkKyuuhuKata bM_ChkKyuuhuKata9 = new BM_ChkKyuuhuKata();
        bM_ChkKyuuhuKata9.setSyouhncd("T110");
        bM_ChkKyuuhuKata9.setSyusyouhnsdnofrom(Integer.valueOf(33));
        bM_ChkKyuuhuKata9.setSyusyouhnsdnoto(Integer.valueOf(33));
        bM_ChkKyuuhuKata9.setKyhkatakbn(C_KyhgndkataKbn.TYPE60);
        bizDomManager.insert(bM_ChkKyuuhuKata9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkKyuuhuKata());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkKyuuhuKata> chkKyuuhuKataLst = bizDomManager.getChkKyuuhuKatasByPk(P_SYOUHNCD_02, P_SYOUHNSDNO_02,
            C_KyhgndkataKbn.TYPE180);

        Assert.assertEquals(0, chkKyuuhuKataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkKyuuhuKata> chkKyuuhuKataLst = bizDomManager.getChkKyuuhuKatasByPk(P_SYOUHNCD_01, P_SYOUHNSDNO_01,
            C_KyhgndkataKbn.TYPE120);

        Assert.assertEquals(1, chkKyuuhuKataLst.size());

        Assert.assertEquals("M210", chkKyuuhuKataLst.get(0).getSyouhncd());

        Assert.assertEquals(Integer.valueOf(50), chkKyuuhuKataLst.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(52), chkKyuuhuKataLst.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KyhgndkataKbn.TYPE120, chkKyuuhuKataLst.get(0).getKyhkatakbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkKyuuhuKata> chkKyuuhuKataLst = bizDomManager.getChkKyuuhuKatasByPk(P_SYOUHNCD_03, P_SYOUHNSDNO_03,
            C_KyhgndkataKbn.TYPE60);

        Assert.assertEquals(4, chkKyuuhuKataLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("T110",Integer.valueOf(32),Integer.valueOf(33),C_KyhgndkataKbn.TYPE60), "1");
        map.put($("T110",Integer.valueOf(32),Integer.valueOf(34),C_KyhgndkataKbn.TYPE60), "1");
        map.put($("T110",Integer.valueOf(33),Integer.valueOf(33),C_KyhgndkataKbn.TYPE60), "1");
        map.put($("T110",Integer.valueOf(33),Integer.valueOf(34),C_KyhgndkataKbn.TYPE60), "1");

        assertTrue(map.containsKey($(chkKyuuhuKataLst.get(0).getSyouhncd(),chkKyuuhuKataLst.get(0).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(0).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(0).getKyhkatakbn())));
        assertTrue(map.containsKey($(chkKyuuhuKataLst.get(1).getSyouhncd(),chkKyuuhuKataLst.get(1).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(1).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(1).getKyhkatakbn())));
        assertTrue(map.containsKey($(chkKyuuhuKataLst.get(2).getSyouhncd(),chkKyuuhuKataLst.get(2).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(2).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(2).getKyhkatakbn())));
        assertTrue(map.containsKey($(chkKyuuhuKataLst.get(3).getSyouhncd(),chkKyuuhuKataLst.get(3).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(3).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(3).getKyhkatakbn())));

        map.remove($(chkKyuuhuKataLst.get(0).getSyouhncd(),chkKyuuhuKataLst.get(0).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(0).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(0).getKyhkatakbn()));
        map.remove($(chkKyuuhuKataLst.get(1).getSyouhncd(),chkKyuuhuKataLst.get(1).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(1).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(1).getKyhkatakbn()));
        map.remove($(chkKyuuhuKataLst.get(2).getSyouhncd(),chkKyuuhuKataLst.get(2).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(2).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(2).getKyhkatakbn()));
        map.remove($(chkKyuuhuKataLst.get(3).getSyouhncd(),chkKyuuhuKataLst.get(3).getSyusyouhnsdnofrom(),chkKyuuhuKataLst.get(3).getSyusyouhnsdnoto(),chkKyuuhuKataLst.get(3).getKyhkatakbn()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkKyuuhuKata> chkKyuuhuKataLst = bizDomManager.getChkKyuuhuKatasByPk("", P_SYOUHNSDNO_03, C_KyhgndkataKbn.TYPE60);

        Assert.assertEquals(0, chkKyuuhuKataLst.size());
    }
}
