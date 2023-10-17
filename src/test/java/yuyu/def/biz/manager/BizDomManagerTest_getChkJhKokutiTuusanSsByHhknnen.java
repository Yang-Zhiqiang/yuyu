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
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 告知扱通算限度Ｓ事方書チェックマスタエンティティリスト取得 被保険者年齢のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhKokutiTuusanSsByHhknnen {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhKokutiTuusanS> chkJhKokutiTuusanSList = bizDomManager.getChkJhKokutiTuusanSsByHhknnen(BizNumber.ZERO);

        Assert.assertEquals(0, chkJhKokutiTuusanSList.size());

        BM_ChkJhKokutiTuusanS chkJhKokutiTuusanS1 = new BM_ChkJhKokutiTuusanS(BizNumber.ZERO, BizNumber.ZERO, C_KijiKbn.BLNK, 1, 1);

        bizDomManager.insert(chkJhKokutiTuusanS1);

        BM_ChkJhKokutiTuusanS chkJhKokutiTuusanS2 = new BM_ChkJhKokutiTuusanS(BizNumber.ZERO, BizNumber.ONE, C_KijiKbn.BLNK, 2, 1);

        bizDomManager.insert(chkJhKokutiTuusanS2);

        BM_ChkJhKokutiTuusanS chkJhKokutiTuusanS3 = new BM_ChkJhKokutiTuusanS(BizNumber.ONE, BizNumber.valueOf(9), C_KijiKbn.BLNK, 3, 1);

        bizDomManager.insert(chkJhKokutiTuusanS3);

        BM_ChkJhKokutiTuusanS chkJhKokutiTuusanS4 = new BM_ChkJhKokutiTuusanS(BizNumber.TEN, BizNumber.TEN, C_KijiKbn.BLNK, 4, 1);

        bizDomManager.insert(chkJhKokutiTuusanS4);

        BM_ChkJhKokutiTuusanS chkJhKokutiTuusanS5 = new BM_ChkJhKokutiTuusanS(BizNumber.ONE, BizNumber.ZERO, C_KijiKbn.BLNK, 5, 1);

        bizDomManager.insert(chkJhKokutiTuusanS5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkJhKokutiTuusanS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkJhKokutiTuusanS> chkJhKokutiTuusanSList = bizDomManager.getChkJhKokutiTuusanSsByHhknnen(BizNumber.valueOf(11));

        Assert.assertEquals(0, chkJhKokutiTuusanSList.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<BM_ChkJhKokutiTuusanS> chkJhKokutiTuusanSList = bizDomManager.getChkJhKokutiTuusanSsByHhknnen(BizNumber.TEN);

        Assert.assertEquals(1, chkJhKokutiTuusanSList.size());

        Assert.assertEquals(BizNumber.TEN, chkJhKokutiTuusanSList.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.TEN, chkJhKokutiTuusanSList.get(0).getHhkntonen());
        Assert.assertEquals(C_KijiKbn.BLNK, chkJhKokutiTuusanSList.get(0).getKijikbn());
        Assert.assertEquals(Integer.valueOf(4), chkJhKokutiTuusanSList.get(0).getIktkktkbnfrom());
        Assert.assertEquals(Integer.valueOf(1), chkJhKokutiTuusanSList.get(0).getIktkktkbnto());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkJhKokutiTuusanS> chkJhKokutiTuusanSList = bizDomManager.getChkJhKokutiTuusanSsByHhknnen(BizNumber.ONE);

        Assert.assertEquals(2, chkJhKokutiTuusanSList.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(BizNumber.ZERO, BizNumber.ONE, C_KijiKbn.BLNK, Integer.valueOf(2), Integer.valueOf(1)),"1");
        map.put($(BizNumber.ONE, BizNumber.valueOf(9), C_KijiKbn.BLNK, Integer.valueOf(3), Integer.valueOf(1)),"1");

        assertTrue(map.containsKey($(chkJhKokutiTuusanSList.get(0).getHhknfromnen(), chkJhKokutiTuusanSList.get(0).getHhkntonen(), chkJhKokutiTuusanSList.get(0).getKijikbn(), chkJhKokutiTuusanSList.get(0).getIktkktkbnfrom(), chkJhKokutiTuusanSList.get(0).getIktkktkbnto())));
        assertTrue(map.containsKey($(chkJhKokutiTuusanSList.get(1).getHhknfromnen(), chkJhKokutiTuusanSList.get(1).getHhkntonen(), chkJhKokutiTuusanSList.get(1).getKijikbn(), chkJhKokutiTuusanSList.get(1).getIktkktkbnfrom(), chkJhKokutiTuusanSList.get(1).getIktkktkbnto())));

        map.remove($(chkJhKokutiTuusanSList.get(0).getHhknfromnen(), chkJhKokutiTuusanSList.get(0).getHhkntonen(), chkJhKokutiTuusanSList.get(0).getKijikbn(), chkJhKokutiTuusanSList.get(0).getIktkktkbnfrom(), chkJhKokutiTuusanSList.get(0).getIktkktkbnto()));
        map.remove($(chkJhKokutiTuusanSList.get(1).getHhknfromnen(), chkJhKokutiTuusanSList.get(1).getHhkntonen(), chkJhKokutiTuusanSList.get(1).getKijikbn(), chkJhKokutiTuusanSList.get(1).getIktkktkbnfrom(), chkJhKokutiTuusanSList.get(1).getIktkktkbnto()));

        assertTrue(map.isEmpty());
    }
}
