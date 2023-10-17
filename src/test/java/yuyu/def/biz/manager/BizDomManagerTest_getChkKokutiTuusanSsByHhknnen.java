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

import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 告知扱通算限度Ｓチェックマスタエンティティリスト取得 被保険者年齢のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkKokutiTuusanSsByHhknnen {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkKokutiTuusanS> chkKokutiTuusanSList = bizDomManager.getChkKokutiTuusanSsByHhknnen(BizNumber.ZERO);

        Assert.assertEquals(0, chkKokutiTuusanSList.size());

        BM_ChkKokutiTuusanS chkKokutiTuusanS1 = new BM_ChkKokutiTuusanS(BizNumber.ZERO, BizNumber.ONE, C_KijiKbn.BLNK, 1, 1);

        bizDomManager.insert(chkKokutiTuusanS1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkKokutiTuusanS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkKokutiTuusanS> chkKokutiTuusanSList = bizDomManager.getChkKokutiTuusanSsByHhknnen(BizNumber.TEN);

        Assert.assertEquals(0, chkKokutiTuusanSList.size());
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        List<BM_ChkKokutiTuusanS> chkKokutiTuusanSList = bizDomManager.getChkKokutiTuusanSsByHhknnen(BizNumber.ZERO);

        Assert.assertEquals(1, chkKokutiTuusanSList.size());

        Assert.assertEquals(BizNumber.ZERO, chkKokutiTuusanSList.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.ONE, chkKokutiTuusanSList.get(0).getHhkntonen());
        Assert.assertEquals(C_KijiKbn.BLNK, chkKokutiTuusanSList.get(0).getKijikbn());
        Assert.assertEquals(Integer.valueOf(1), chkKokutiTuusanSList.get(0).getIktkktkbnfrom());
        Assert.assertEquals(Integer.valueOf(1), chkKokutiTuusanSList.get(0).getIktkktkbnto());
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        BM_ChkKokutiTuusanS chkKokutiTuusanS2 = new BM_ChkKokutiTuusanS(BizNumber.ZERO, BizNumber.TEN, C_KijiKbn.BLNK, 2, 1);

        bizDomManager.insert(chkKokutiTuusanS2);

        BM_ChkKokutiTuusanS chkKokutiTuusanS3 = new BM_ChkKokutiTuusanS(BizNumber.ONE, BizNumber.TEN, C_KijiKbn.BLNK, 3, 1);

        bizDomManager.insert(chkKokutiTuusanS3);

        BM_ChkKokutiTuusanS chkKokutiTuusanS4 = new BM_ChkKokutiTuusanS(BizNumber.TEN, BizNumber.ONE, C_KijiKbn.BLNK, 4, 1);

        bizDomManager.insert(chkKokutiTuusanS4);

        BM_ChkKokutiTuusanS chkKokutiTuusanS5 = new BM_ChkKokutiTuusanS(BizNumber.ONE, BizNumber.ZERO, C_KijiKbn.BLNK, 5, 1);

        bizDomManager.insert(chkKokutiTuusanS5);
    }

    @Test
    @TestOrder(30)
    public void normal20() {

        List<BM_ChkKokutiTuusanS> chkKokutiTuusanSList = bizDomManager.getChkKokutiTuusanSsByHhknnen(BizNumber.ONE);

        Assert.assertEquals(3, chkKokutiTuusanSList.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(BizNumber.ZERO,BizNumber.ONE,C_KijiKbn.BLNK,Integer.valueOf(1),Integer.valueOf(1)), "1");
        map.put($(BizNumber.ZERO,BizNumber.TEN,C_KijiKbn.BLNK,Integer.valueOf(2),Integer.valueOf(1)), "1");
        map.put($(BizNumber.ONE,BizNumber.TEN,C_KijiKbn.BLNK,Integer.valueOf(3),Integer.valueOf(1)), "1");

        assertTrue(map.containsKey($(chkKokutiTuusanSList.get(0).getHhknfromnen(), chkKokutiTuusanSList.get(0).getHhkntonen(), chkKokutiTuusanSList.get(0).getKijikbn()
            , chkKokutiTuusanSList.get(0).getIktkktkbnfrom(), chkKokutiTuusanSList.get(0).getIktkktkbnto())));
        assertTrue(map.containsKey($(chkKokutiTuusanSList.get(1).getHhknfromnen(), chkKokutiTuusanSList.get(1).getHhkntonen(), chkKokutiTuusanSList.get(1).getKijikbn()
            , chkKokutiTuusanSList.get(1).getIktkktkbnfrom(), chkKokutiTuusanSList.get(1).getIktkktkbnto())));
        assertTrue(map.containsKey($(chkKokutiTuusanSList.get(2).getHhknfromnen(), chkKokutiTuusanSList.get(2).getHhkntonen(), chkKokutiTuusanSList.get(2).getKijikbn()
            , chkKokutiTuusanSList.get(2).getIktkktkbnfrom(), chkKokutiTuusanSList.get(2).getIktkktkbnto())));
        map.remove($(chkKokutiTuusanSList.get(0).getHhknfromnen(), chkKokutiTuusanSList.get(0).getHhkntonen(), chkKokutiTuusanSList.get(0).getKijikbn()
            , chkKokutiTuusanSList.get(0).getIktkktkbnfrom(), chkKokutiTuusanSList.get(0).getIktkktkbnto()));
        map.remove($(chkKokutiTuusanSList.get(1).getHhknfromnen(), chkKokutiTuusanSList.get(1).getHhkntonen(), chkKokutiTuusanSList.get(1).getKijikbn()
            , chkKokutiTuusanSList.get(1).getIktkktkbnfrom(), chkKokutiTuusanSList.get(1).getIktkktkbnto()));
        map.remove($(chkKokutiTuusanSList.get(2).getHhknfromnen(), chkKokutiTuusanSList.get(2).getHhkntonen(), chkKokutiTuusanSList.get(2).getKijikbn()
            , chkKokutiTuusanSList.get(2).getIktkktkbnfrom(), chkKokutiTuusanSList.get(2).getIktkktkbnto()));

        assertTrue(map.isEmpty());
    }
}
