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

import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 一時払通算限度Pチェックマスタエンティティリスト取得 主キー範囲のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkItijibrTuusanPsByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkItijibrTuusanP> chkItijibrTuusanPs = bizDomManager.getChkItijibrTuusanPsByPK(BizNumber.ZERO);

        Assert.assertEquals(0, chkItijibrTuusanPs.size());

        BM_ChkItijibrTuusanP chkItijibrTuusanP1 = new BM_ChkItijibrTuusanP(BizNumber.ZERO, BizNumber.ZERO);

        bizDomManager.insert(chkItijibrTuusanP1);

        BM_ChkItijibrTuusanP chkItijibrTuusanP2 = new BM_ChkItijibrTuusanP(BizNumber.ZERO, BizNumber.ONE);

        bizDomManager.insert(chkItijibrTuusanP2);

        BM_ChkItijibrTuusanP chkItijibrTuusanP3 = new BM_ChkItijibrTuusanP(BizNumber.ONE, BizNumber.valueOf(9));

        bizDomManager.insert(chkItijibrTuusanP3);

        BM_ChkItijibrTuusanP chkItijibrTuusanP4 = new BM_ChkItijibrTuusanP(BizNumber.TEN, BizNumber.TEN);

        bizDomManager.insert(chkItijibrTuusanP4);

        BM_ChkItijibrTuusanP chkItijibrTuusanP5 = new BM_ChkItijibrTuusanP(BizNumber.ONE, BizNumber.ZERO);

        bizDomManager.insert(chkItijibrTuusanP5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkItijibrTuusanP());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkItijibrTuusanP> chkItijibrTuusanPs = bizDomManager.getChkItijibrTuusanPsByPK(BizNumber.valueOf(11));

        Assert.assertEquals(0, chkItijibrTuusanPs.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<BM_ChkItijibrTuusanP> chkItijibrTuusanPs = bizDomManager.getChkItijibrTuusanPsByPK(BizNumber.TEN);

        Assert.assertEquals(1, chkItijibrTuusanPs.size());

        Assert.assertEquals(BizNumber.TEN, chkItijibrTuusanPs.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.TEN, chkItijibrTuusanPs.get(0).getHhkntonen());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkItijibrTuusanP> chkItijibrTuusanPs = bizDomManager.getChkItijibrTuusanPsByPK(BizNumber.ONE);;

        Assert.assertEquals(2, chkItijibrTuusanPs.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(BizNumber.ZERO, BizNumber.ONE),"1");
        map.put($(BizNumber.ONE, BizNumber.valueOf(9)),"2");

        assertTrue(map.containsKey($(chkItijibrTuusanPs.get(0).getHhknfromnen(), chkItijibrTuusanPs.get(0).getHhkntonen())));
        assertTrue(map.containsKey($(chkItijibrTuusanPs.get(1).getHhknfromnen(), chkItijibrTuusanPs.get(1).getHhkntonen())));

        map.remove($(chkItijibrTuusanPs.get(0).getHhknfromnen(), chkItijibrTuusanPs.get(0).getHhkntonen()));
        map.remove($(chkItijibrTuusanPs.get(1).getHhknfromnen(), chkItijibrTuusanPs.get(1).getHhkntonen()));

        assertTrue(map.isEmpty());
    }
}
