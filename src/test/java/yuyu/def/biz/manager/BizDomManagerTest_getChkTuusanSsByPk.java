package yuyu.def.biz.manager;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.db.entity.BM_ChkTuusanS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 通算限度Ｓチェックマスタエンティティリスト取得(主キー範囲)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkTuusanSsByPk {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkTuusanS> chkTuusanSs = bizDomManager.getChkTuusanSsByPk(BizNumber.ZERO);

        Assert.assertEquals(0, chkTuusanSs.size());

        BM_ChkTuusanS chkTuusanS1 = new BM_ChkTuusanS(BizNumber.ZERO, BizNumber.ONE);

        bizDomManager.insert(chkTuusanS1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkTuusanS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkTuusanS> chkTuusanSs = bizDomManager.getChkTuusanSsByPk(BizNumber.TEN);

        Assert.assertEquals(0, chkTuusanSs.size());
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        List<BM_ChkTuusanS> chkTuusanSs = bizDomManager.getChkTuusanSsByPk(BizNumber.ZERO);

        Assert.assertEquals(1, chkTuusanSs.size());

        Assert.assertEquals(BizNumber.ZERO, chkTuusanSs.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.ONE, chkTuusanSs.get(0).getHhkntonen());
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {


        BM_ChkTuusanS chkTuusanS2 = new BM_ChkTuusanS(BizNumber.ZERO, BizNumber.TEN);

        bizDomManager.insert(chkTuusanS2);

        BM_ChkTuusanS chkTuusanS3 = new BM_ChkTuusanS(BizNumber.ONE, BizNumber.TEN);

        bizDomManager.insert(chkTuusanS3);

        BM_ChkTuusanS chkTuusanS4 = new BM_ChkTuusanS(BizNumber.TEN, BizNumber.ONE);

        bizDomManager.insert(chkTuusanS4);

        BM_ChkTuusanS chkTuusanS5 = new BM_ChkTuusanS(BizNumber.ONE, BizNumber.ZERO);

        bizDomManager.insert(chkTuusanS5);
    }

    @Test
    @TestOrder(30)
    public void normal20() {

        List<BM_ChkTuusanS> chkTuusanSs = bizDomManager.getChkTuusanSsByPk(BizNumber.ONE);

        Assert.assertEquals(3, chkTuusanSs.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(BizNumber.ZERO,BizNumber.ONE), "1");
        map.put($(BizNumber.ZERO,BizNumber.TEN), "1");
        map.put($(BizNumber.ONE,BizNumber.TEN), "1");

        assertTrue(map.containsKey($(chkTuusanSs.get(0).getHhknfromnen(),chkTuusanSs.get(0).getHhkntonen())));
        assertTrue(map.containsKey($(chkTuusanSs.get(1).getHhknfromnen(),chkTuusanSs.get(1).getHhkntonen())));
        assertTrue(map.containsKey($(chkTuusanSs.get(2).getHhknfromnen(),chkTuusanSs.get(2).getHhkntonen())));

        map.remove($(chkTuusanSs.get(0).getHhknfromnen(),chkTuusanSs.get(0).getHhkntonen()));
        map.remove($(chkTuusanSs.get(1).getHhknfromnen(),chkTuusanSs.get(1).getHhkntonen()));
        map.remove($(chkTuusanSs.get(2).getHhknfromnen(),chkTuusanSs.get(2).getHhkntonen()));

        assertTrue(map.isEmpty());

    }
}
