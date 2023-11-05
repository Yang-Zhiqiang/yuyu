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

import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 通算限度Ｓ事方書チェックマスタエンティティリスト取得(主キー範囲)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhTuusanSsByPk {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhTuusanS> chkJhTuusanSs = bizDomManager.getChkJhTuusanSsByPk(BizNumber.ZERO);

        Assert.assertEquals(0, chkJhTuusanSs.size());

        BM_ChkJhTuusanS chkJhTuusanS1 = new BM_ChkJhTuusanS(BizNumber.ZERO, BizNumber.ONE);

        bizDomManager.insert(chkJhTuusanS1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkJhTuusanS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkJhTuusanS> chkJhTuusanSs = bizDomManager.getChkJhTuusanSsByPk(BizNumber.TEN);

        Assert.assertEquals(0, chkJhTuusanSs.size());
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        List<BM_ChkJhTuusanS> chkJhTuusanSs = bizDomManager.getChkJhTuusanSsByPk(BizNumber.ZERO);

        Assert.assertEquals(1, chkJhTuusanSs.size());

        Assert.assertEquals(BizNumber.ZERO, chkJhTuusanSs.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.ONE, chkJhTuusanSs.get(0).getHhkntonen());
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        BM_ChkJhTuusanS chkJhTuusanS2 = new BM_ChkJhTuusanS(BizNumber.ZERO, BizNumber.TEN);

        bizDomManager.insert(chkJhTuusanS2);

        BM_ChkJhTuusanS chkJhTuusanS3 = new BM_ChkJhTuusanS(BizNumber.ONE, BizNumber.TEN);

        bizDomManager.insert(chkJhTuusanS3);

        BM_ChkJhTuusanS chkJhTuusanS4 = new BM_ChkJhTuusanS(BizNumber.TEN, BizNumber.ONE);

        bizDomManager.insert(chkJhTuusanS4);

        BM_ChkJhTuusanS chkJhTuusanS5 = new BM_ChkJhTuusanS(BizNumber.ONE, BizNumber.ZERO);

        bizDomManager.insert(chkJhTuusanS5);
    }

    @Test
    @TestOrder(30)
    public void normal20() {

        List<BM_ChkJhTuusanS> chkJhTuusanSs = bizDomManager.getChkJhTuusanSsByPk(BizNumber.ONE);

        Assert.assertEquals(3, chkJhTuusanSs.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($(BizNumber.ZERO,BizNumber.ONE), "1");
        map.put($(BizNumber.ZERO,BizNumber.TEN), "1");
        map.put($(BizNumber.ONE,BizNumber.TEN), "1");

        assertTrue(map.containsKey($(chkJhTuusanSs.get(0).getHhknfromnen(),chkJhTuusanSs.get(0).getHhkntonen())));
        assertTrue(map.containsKey($(chkJhTuusanSs.get(1).getHhknfromnen(),chkJhTuusanSs.get(1).getHhkntonen())));
        assertTrue(map.containsKey($(chkJhTuusanSs.get(2).getHhknfromnen(),chkJhTuusanSs.get(2).getHhkntonen())));

        map.remove($(chkJhTuusanSs.get(0).getHhknfromnen(),chkJhTuusanSs.get(0).getHhkntonen()));
        map.remove($(chkJhTuusanSs.get(1).getHhknfromnen(),chkJhTuusanSs.get(1).getHhkntonen()));
        map.remove($(chkJhTuusanSs.get(2).getHhknfromnen(),chkJhTuusanSs.get(2).getHhkntonen()));

        assertTrue(map.isEmpty());

    }
}
