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

import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約
 * 申込商品TBLチェック
 * 契約単位最高Ｓチェックマスタエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkKeiyakuTaniSaikouSsByPk {

    @Inject
    private BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SH01";
    static String P_SYOUHNCD_02 = "SH02";
    static Integer P_SYOUHNSDNO_01 = new Integer(20);
    static Integer P_SYOUHNSDNO_02 = new Integer(30);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkKeiyakuTaniSaikouS> chkKeiyakuTaniSaikouSLst = bizDomManager.getChkKeiyakuTaniSaikouSsByPk(
            P_SYOUHNCD_02, P_SYOUHNSDNO_01);

        Assert.assertEquals(0, chkKeiyakuTaniSaikouSLst.size());

        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS1 = new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS1.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkKeiyakuTaniSaikouS1.setSyusyouhnsdnofrom(Integer.valueOf(18));
        bM_ChkKeiyakuTaniSaikouS1.setSyusyouhnsdnoto(Integer.valueOf(19));

        bizDomManager.insert(bM_ChkKeiyakuTaniSaikouS1);

        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS2 = new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS2.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkKeiyakuTaniSaikouS2.setSyusyouhnsdnofrom(Integer.valueOf(19));
        bM_ChkKeiyakuTaniSaikouS2.setSyusyouhnsdnoto(Integer.valueOf(20));

        bizDomManager.insert(bM_ChkKeiyakuTaniSaikouS2);

        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS3 = new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS3.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkKeiyakuTaniSaikouS3.setSyusyouhnsdnofrom(Integer.valueOf(20));
        bM_ChkKeiyakuTaniSaikouS3.setSyusyouhnsdnoto(Integer.valueOf(20));

        bizDomManager.insert(bM_ChkKeiyakuTaniSaikouS3);

        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS4 = new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS4.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkKeiyakuTaniSaikouS4.setSyusyouhnsdnofrom(Integer.valueOf(20));
        bM_ChkKeiyakuTaniSaikouS4.setSyusyouhnsdnoto(Integer.valueOf(21));

        bizDomManager.insert(bM_ChkKeiyakuTaniSaikouS4);

        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS5 = new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS5.setSyouhncd(P_SYOUHNCD_01);
        bM_ChkKeiyakuTaniSaikouS5.setSyusyouhnsdnofrom(Integer.valueOf(21));
        bM_ChkKeiyakuTaniSaikouS5.setSyusyouhnsdnoto(Integer.valueOf(22));

        bizDomManager.insert(bM_ChkKeiyakuTaniSaikouS5);

        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS6 = new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS6.setSyouhncd(P_SYOUHNCD_02);
        bM_ChkKeiyakuTaniSaikouS6.setSyusyouhnsdnofrom(Integer.valueOf(20));
        bM_ChkKeiyakuTaniSaikouS6.setSyusyouhnsdnoto(Integer.valueOf(22));

        bizDomManager.insert(bM_ChkKeiyakuTaniSaikouS6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkKeiyakuTaniSaikouS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkKeiyakuTaniSaikouS> chkKeiyakuTaniSaikouSLst = bizDomManager.getChkKeiyakuTaniSaikouSsByPk(
            P_SYOUHNCD_01, P_SYOUHNSDNO_02);

        Assert.assertEquals(0, chkKeiyakuTaniSaikouSLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkKeiyakuTaniSaikouS> chkKeiyakuTaniSaikouSLst = bizDomManager.getChkKeiyakuTaniSaikouSsByPk(
            P_SYOUHNCD_02, P_SYOUHNSDNO_01);

        Assert.assertEquals(1, chkKeiyakuTaniSaikouSLst.size());

        Assert.assertEquals(P_SYOUHNCD_02, chkKeiyakuTaniSaikouSLst.get(0).getSyouhncd());
        Assert.assertEquals(Integer.valueOf(20), chkKeiyakuTaniSaikouSLst.get(0).getSyusyouhnsdnofrom());
        Assert.assertEquals(Integer.valueOf(22), chkKeiyakuTaniSaikouSLst.get(0).getSyusyouhnsdnoto());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkKeiyakuTaniSaikouS> chkKeiyakuTaniSaikouSLst = bizDomManager.getChkKeiyakuTaniSaikouSsByPk(
            P_SYOUHNCD_01, P_SYOUHNSDNO_01);

        Assert.assertEquals(3, chkKeiyakuTaniSaikouSLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(P_SYOUHNCD_01,Integer.valueOf(19),Integer.valueOf(20)), "1");
        map.put($(P_SYOUHNCD_01,Integer.valueOf(20),Integer.valueOf(20)), "1");
        map.put($(P_SYOUHNCD_01,Integer.valueOf(20),Integer.valueOf(21)), "1");

        assertTrue(map.containsKey($(chkKeiyakuTaniSaikouSLst.get(0).getSyouhncd(), chkKeiyakuTaniSaikouSLst.get(0).getSyusyouhnsdnofrom(), chkKeiyakuTaniSaikouSLst.get(0).getSyusyouhnsdnoto())));
        assertTrue(map.containsKey($(chkKeiyakuTaniSaikouSLst.get(1).getSyouhncd(), chkKeiyakuTaniSaikouSLst.get(1).getSyusyouhnsdnofrom(), chkKeiyakuTaniSaikouSLst.get(1).getSyusyouhnsdnoto())));
        assertTrue(map.containsKey($(chkKeiyakuTaniSaikouSLst.get(2).getSyouhncd(), chkKeiyakuTaniSaikouSLst.get(2).getSyusyouhnsdnofrom(), chkKeiyakuTaniSaikouSLst.get(2).getSyusyouhnsdnoto())));
        map.remove($(chkKeiyakuTaniSaikouSLst.get(0).getSyouhncd(), chkKeiyakuTaniSaikouSLst.get(0).getSyusyouhnsdnofrom(), chkKeiyakuTaniSaikouSLst.get(0).getSyusyouhnsdnoto()));
        map.remove($(chkKeiyakuTaniSaikouSLst.get(1).getSyouhncd(), chkKeiyakuTaniSaikouSLst.get(1).getSyusyouhnsdnofrom(), chkKeiyakuTaniSaikouSLst.get(1).getSyusyouhnsdnoto()));
        map.remove($(chkKeiyakuTaniSaikouSLst.get(2).getSyouhncd(), chkKeiyakuTaniSaikouSLst.get(2).getSyusyouhnsdnofrom(), chkKeiyakuTaniSaikouSLst.get(2).getSyusyouhnsdnoto()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<BM_ChkKeiyakuTaniSaikouS> chkKeiyakuTaniSaikouSLst = bizDomManager.getChkKeiyakuTaniSaikouSsByPk(
            "", P_SYOUHNSDNO_01);

        Assert.assertEquals(0, chkKeiyakuTaniSaikouSLst.size());
    }
}
