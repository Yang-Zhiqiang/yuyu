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

import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込商品TBLチェック<br />
 * 型区分チェックマスタエンティティリスト取得(主キー範囲)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkKatasByPk {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "M210";
    static String P_SYOUHNCD_02 = "M870";
    static String P_SYOUHNCD_03 = "M960";
    static Integer P_SYOUHNSDNO_01 = new Integer(10);
    static Integer P_SYOUHNSDNO_02 = new Integer(5);
    static Integer P_SYOUHNSDNO_03 = new Integer(15);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkKata> chkKataLst = bizDomManager.getChkKatasByPk(P_SYOUHNCD_01, P_SYOUHNSDNO_03, C_UmuKbn.ARI, C_KataKbn.HONNIN_TUMA);

        Assert.assertEquals(0, chkKataLst.size());

        BM_ChkKata bM_ChkKata1 = new BM_ChkKata();
        bM_ChkKata1.setSyouhncd("M210");
        bM_ChkKata1.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata1.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata1.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata1.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata1);

        BM_ChkKata bM_ChkKata2 = new BM_ChkKata();
        bM_ChkKata2.setSyouhncd("M960");
        bM_ChkKata2.setSyusyouhnsdnofrom(Integer.valueOf(16));
        bM_ChkKata2.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata2.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata2.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata2);

        BM_ChkKata bM_ChkKata3 = new BM_ChkKata();
        bM_ChkKata3.setSyouhncd("M960");
        bM_ChkKata3.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata3.setSyusyouhnsdnoto(Integer.valueOf(14));
        bM_ChkKata3.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata3.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata3);

        BM_ChkKata bM_ChkKata4 = new BM_ChkKata();
        bM_ChkKata4.setSyouhncd("M960");
        bM_ChkKata4.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata4.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata4.setTktanbrumu(C_UmuKbn.NONE);
        bM_ChkKata4.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata4);

        BM_ChkKata bM_ChkKata5 = new BM_ChkKata();
        bM_ChkKata5.setSyouhncd("M960");
        bM_ChkKata5.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata5.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata5.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata5.setKatakbn(C_KataKbn.HONNIN_SAISI);
        bizDomManager.insert(bM_ChkKata5);

        BM_ChkKata bM_ChkKata6 = new BM_ChkKata();
        bM_ChkKata6.setSyouhncd("M960");
        bM_ChkKata6.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata6.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata6.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata6.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata6);

        BM_ChkKata bM_ChkKata7 = new BM_ChkKata();
        bM_ChkKata7.setSyouhncd("M960");
        bM_ChkKata7.setSyusyouhnsdnofrom(Integer.valueOf(15));
        bM_ChkKata7.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata7.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata7.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata7);

        BM_ChkKata bM_ChkKata8 = new BM_ChkKata();
        bM_ChkKata8.setSyouhncd("M960");
        bM_ChkKata8.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata8.setSyusyouhnsdnoto(Integer.valueOf(15));
        bM_ChkKata8.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata8.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata8);

        BM_ChkKata bM_ChkKata9 = new BM_ChkKata();
        bM_ChkKata9.setSyouhncd("M960");
        bM_ChkKata9.setSyusyouhnsdnofrom(Integer.valueOf(15));
        bM_ChkKata9.setSyusyouhnsdnoto(Integer.valueOf(15));
        bM_ChkKata9.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata9.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata9);

        BM_ChkKata bM_ChkKata10 = new BM_ChkKata();
        bM_ChkKata10.setSyouhncd("M220");
        bM_ChkKata10.setSyusyouhnsdnofrom(Integer.valueOf(14));
        bM_ChkKata10.setSyusyouhnsdnoto(Integer.valueOf(16));
        bM_ChkKata10.setTktanbrumu(C_UmuKbn.ARI);
        bM_ChkKata10.setKatakbn(C_KataKbn.HONNIN_TUMA);
        bizDomManager.insert(bM_ChkKata10);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkKata());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkKata> chkKataLst = bizDomManager.getChkKatasByPk(P_SYOUHNCD_02, P_SYOUHNSDNO_02, C_UmuKbn.NONE, C_KataKbn.HONNIN_SAISI);

        Assert.assertEquals(0, chkKataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkKata> chkKataLst = bizDomManager.getChkKatasByPk(P_SYOUHNCD_01, P_SYOUHNSDNO_03, C_UmuKbn.ARI, C_KataKbn.HONNIN_TUMA);

        Assert.assertEquals(1, chkKataLst.size());

        Assert.assertEquals("M210", chkKataLst.get(0).getSyouhncd());

        Assert.assertEquals(Integer.valueOf(14), chkKataLst.get(0).getSyusyouhnsdnofrom());

        Assert.assertEquals(Integer.valueOf(16), chkKataLst.get(0).getSyusyouhnsdnoto());

        Assert.assertEquals(C_UmuKbn.ARI, chkKataLst.get(0).getTktanbrumu());

        Assert.assertEquals(C_KataKbn.HONNIN_TUMA, chkKataLst.get(0).getKatakbn());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkKata> chkKataLst = bizDomManager.getChkKatasByPk(P_SYOUHNCD_03, P_SYOUHNSDNO_03, C_UmuKbn.ARI, C_KataKbn.HONNIN_TUMA);

        Assert.assertEquals(4, chkKataLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("M960",Integer.valueOf(14),Integer.valueOf(15),C_UmuKbn.ARI,C_KataKbn.HONNIN_TUMA), "1");
        map.put($("M960",Integer.valueOf(14),Integer.valueOf(16),C_UmuKbn.ARI,C_KataKbn.HONNIN_TUMA), "1");
        map.put($("M960",Integer.valueOf(15),Integer.valueOf(15),C_UmuKbn.ARI,C_KataKbn.HONNIN_TUMA), "1");
        map.put($("M960",Integer.valueOf(15),Integer.valueOf(16),C_UmuKbn.ARI,C_KataKbn.HONNIN_TUMA), "1");

        assertTrue(map.containsKey($(chkKataLst.get(0).getSyouhncd(), chkKataLst.get(0).getSyusyouhnsdnofrom(), chkKataLst.get(0).getSyusyouhnsdnoto(), chkKataLst.get(0).getTktanbrumu(),chkKataLst.get(0).getKatakbn())));
        assertTrue(map.containsKey($(chkKataLst.get(1).getSyouhncd(), chkKataLst.get(1).getSyusyouhnsdnofrom(), chkKataLst.get(1).getSyusyouhnsdnoto(), chkKataLst.get(1).getTktanbrumu(),chkKataLst.get(1).getKatakbn())));
        assertTrue(map.containsKey($(chkKataLst.get(2).getSyouhncd(), chkKataLst.get(2).getSyusyouhnsdnofrom(), chkKataLst.get(2).getSyusyouhnsdnoto(), chkKataLst.get(2).getTktanbrumu(),chkKataLst.get(2).getKatakbn())));
        assertTrue(map.containsKey($(chkKataLst.get(3).getSyouhncd(), chkKataLst.get(3).getSyusyouhnsdnofrom(), chkKataLst.get(3).getSyusyouhnsdnoto(), chkKataLst.get(3).getTktanbrumu(),chkKataLst.get(3).getKatakbn())));
        map.remove($(chkKataLst.get(0).getSyouhncd(), chkKataLst.get(0).getSyusyouhnsdnofrom(), chkKataLst.get(0).getSyusyouhnsdnoto(), chkKataLst.get(0).getTktanbrumu(),chkKataLst.get(0).getKatakbn()));
        map.remove($(chkKataLst.get(1).getSyouhncd(), chkKataLst.get(1).getSyusyouhnsdnofrom(), chkKataLst.get(1).getSyusyouhnsdnoto(), chkKataLst.get(1).getTktanbrumu(),chkKataLst.get(1).getKatakbn()));
        map.remove($(chkKataLst.get(2).getSyouhncd(), chkKataLst.get(2).getSyusyouhnsdnofrom(), chkKataLst.get(2).getSyusyouhnsdnoto(), chkKataLst.get(2).getTktanbrumu(),chkKataLst.get(2).getKatakbn()));
        map.remove($(chkKataLst.get(3).getSyouhncd(), chkKataLst.get(3).getSyusyouhnsdnofrom(), chkKataLst.get(3).getSyusyouhnsdnoto(), chkKataLst.get(3).getTktanbrumu(),chkKataLst.get(3).getKatakbn()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkKata> chkKataLst = bizDomManager.getChkKatasByPk("", P_SYOUHNSDNO_03, C_UmuKbn.ARI, C_KataKbn.HONNIN_TUMA);

        Assert.assertEquals(0, chkKataLst.size());
    }
}
