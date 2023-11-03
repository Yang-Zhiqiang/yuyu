package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 基本給付金額倍率チェックマスタエンティティリスト取得(主キー範囲)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkKhnKyhKgBairitusByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "M210";
    static String P_SYOUHNCD_02 = "M310";
    static String P_SYOUHNCD_03 = "M780";
    static Integer P_SYOUHNSDNO_01 = new Integer(8);
    static Integer P_SYOUHNSDNO_02 = new Integer(20);
    static Integer P_SYOUHNSDNO_03 = new Integer(40);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkKhnKyhKgBairitu> chkKhnKyhKgBairituLst = bizDomManager.getChkKhnKyhKgBairitusByPk(P_SYOUHNCD_01,
            P_SYOUHNSDNO_01, C_KhnkyhkgbairituKbn.ITIBAI);

        Assert.assertEquals(0, chkKhnKyhKgBairituLst.size());

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu1 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu1.setSyouhncd("M210");
        bM_ChkKhnKyhKgBairitu1.setSyusyouhnsdnofrom(Integer.valueOf(7));
        bM_ChkKhnKyhKgBairitu1.setSyusyouhnsdnoto(Integer.valueOf(9));
        bM_ChkKhnKyhKgBairitu1.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu1);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu2 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu2.setSyouhncd("M220");
        bM_ChkKhnKyhKgBairitu2.setSyusyouhnsdnofrom(Integer.valueOf(39));
        bM_ChkKhnKyhKgBairitu2.setSyusyouhnsdnoto(Integer.valueOf(41));
        bM_ChkKhnKyhKgBairitu2.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu2);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu3 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu3.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu3.setSyusyouhnsdnofrom(Integer.valueOf(41));
        bM_ChkKhnKyhKgBairitu3.setSyusyouhnsdnoto(Integer.valueOf(41));
        bM_ChkKhnKyhKgBairitu3.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu3);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu4 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu4.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu4.setSyusyouhnsdnofrom(Integer.valueOf(39));
        bM_ChkKhnKyhKgBairitu4.setSyusyouhnsdnoto(Integer.valueOf(39));
        bM_ChkKhnKyhKgBairitu4.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu4);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu5 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu5.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu5.setSyusyouhnsdnofrom(Integer.valueOf(39));
        bM_ChkKhnKyhKgBairitu5.setSyusyouhnsdnoto(Integer.valueOf(41));
        bM_ChkKhnKyhKgBairitu5.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.NIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu5);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu6 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu6.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu6.setSyusyouhnsdnofrom(Integer.valueOf(39));
        bM_ChkKhnKyhKgBairitu6.setSyusyouhnsdnoto(Integer.valueOf(40));
        bM_ChkKhnKyhKgBairitu6.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu6);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu7 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu7.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu7.setSyusyouhnsdnofrom(Integer.valueOf(40));
        bM_ChkKhnKyhKgBairitu7.setSyusyouhnsdnoto(Integer.valueOf(41));
        bM_ChkKhnKyhKgBairitu7.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu7);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu8 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu8.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu8.setSyusyouhnsdnofrom(Integer.valueOf(39));
        bM_ChkKhnKyhKgBairitu8.setSyusyouhnsdnoto(Integer.valueOf(41));
        bM_ChkKhnKyhKgBairitu8.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu8);

        BM_ChkKhnKyhKgBairitu bM_ChkKhnKyhKgBairitu9 = new BM_ChkKhnKyhKgBairitu();
        bM_ChkKhnKyhKgBairitu9.setSyouhncd("M780");
        bM_ChkKhnKyhKgBairitu9.setSyusyouhnsdnofrom(Integer.valueOf(40));
        bM_ChkKhnKyhKgBairitu9.setSyusyouhnsdnoto(Integer.valueOf(40));
        bM_ChkKhnKyhKgBairitu9.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.ITIBAI);
        bizDomManager.insert(bM_ChkKhnKyhKgBairitu9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkKhnKyhKgBairitu());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkKhnKyhKgBairitu> chkKhnKyhKgBairituLst = bizDomManager.getChkKhnKyhKgBairitusByPk(P_SYOUHNCD_02,
            P_SYOUHNSDNO_02, C_KhnkyhkgbairituKbn.BLNK);

        Assert.assertEquals(0, chkKhnKyhKgBairituLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkKhnKyhKgBairitu> chkKhnKyhKgBairituLst = bizDomManager.getChkKhnKyhKgBairitusByPk(P_SYOUHNCD_01,
            P_SYOUHNSDNO_01, C_KhnkyhkgbairituKbn.ITIBAI);

        Assert.assertEquals(1, chkKhnKyhKgBairituLst.size());

        Assert.assertEquals("M210", chkKhnKyhKgBairituLst.get(0).getSyouhncd());

        Assert.assertEquals(Integer.valueOf(7), chkKhnKyhKgBairituLst.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(9), chkKhnKyhKgBairituLst.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_KhnkyhkgbairituKbn.ITIBAI, chkKhnKyhKgBairituLst.get(0).getKhnkyhkgbairitukbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkKhnKyhKgBairitu> chkKhnKyhKgBairituLst = bizDomManager.getChkKhnKyhKgBairitusByPk(P_SYOUHNCD_03,
            P_SYOUHNSDNO_03, C_KhnkyhkgbairituKbn.ITIBAI);

        Assert.assertEquals(4, chkKhnKyhKgBairituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("M780",Integer.valueOf(39),Integer.valueOf(40),C_KhnkyhkgbairituKbn.ITIBAI), "1");
        map.put($("M780",Integer.valueOf(39),Integer.valueOf(41),C_KhnkyhkgbairituKbn.ITIBAI), "1");
        map.put($("M780",Integer.valueOf(40),Integer.valueOf(40),C_KhnkyhkgbairituKbn.ITIBAI), "1");
        map.put($("M780",Integer.valueOf(40),Integer.valueOf(41),C_KhnkyhkgbairituKbn.ITIBAI), "1");

        assertTrue(map.containsKey($(chkKhnKyhKgBairituLst.get(0).getSyouhncd(),chkKhnKyhKgBairituLst.get(0).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(0).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(0).getKhnkyhkgbairitukbn())));
        assertTrue(map.containsKey($(chkKhnKyhKgBairituLst.get(1).getSyouhncd(),chkKhnKyhKgBairituLst.get(1).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(1).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(1).getKhnkyhkgbairitukbn())));
        assertTrue(map.containsKey($(chkKhnKyhKgBairituLst.get(2).getSyouhncd(),chkKhnKyhKgBairituLst.get(2).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(2).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(2).getKhnkyhkgbairitukbn())));
        assertTrue(map.containsKey($(chkKhnKyhKgBairituLst.get(3).getSyouhncd(),chkKhnKyhKgBairituLst.get(3).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(3).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(3).getKhnkyhkgbairitukbn())));

        map.remove($(chkKhnKyhKgBairituLst.get(0).getSyouhncd(),chkKhnKyhKgBairituLst.get(0).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(0).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(0).getKhnkyhkgbairitukbn()));
        map.remove($(chkKhnKyhKgBairituLst.get(1).getSyouhncd(),chkKhnKyhKgBairituLst.get(1).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(1).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(1).getKhnkyhkgbairitukbn()));
        map.remove($(chkKhnKyhKgBairituLst.get(2).getSyouhncd(),chkKhnKyhKgBairituLst.get(2).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(2).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(2).getKhnkyhkgbairitukbn()));
        map.remove($(chkKhnKyhKgBairituLst.get(3).getSyouhncd(),chkKhnKyhKgBairituLst.get(3).getSyusyouhnsdnofrom(),
            chkKhnKyhKgBairituLst.get(3).getSyusyouhnsdnoto(),chkKhnKyhKgBairituLst.get(3).getKhnkyhkgbairitukbn()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkKhnKyhKgBairitu> chkKhnKyhKgBairituLst = bizDomManager.getChkKhnKyhKgBairitusByPk("",
            P_SYOUHNSDNO_03, C_KhnkyhkgbairituKbn.ITIBAI);

        Assert.assertEquals(0, chkKhnKyhKgBairituLst.size());
    }
}
