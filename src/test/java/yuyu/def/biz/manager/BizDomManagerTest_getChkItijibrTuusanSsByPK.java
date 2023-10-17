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

import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 一時払通算限度Ｓチェックマスタエンティティリスト取得 主キー範囲のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkItijibrTuusanSsByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkItijibrTuusanS> chkItijibrTuusanSs = bizDomManager.getChkItijibrTuusanSsByPK(BizNumber.ZERO);

        Assert.assertEquals(0, chkItijibrTuusanSs.size());

        BM_ChkItijibrTuusanS chkItijibrTuusanS1 = new BM_ChkItijibrTuusanS(BizNumber.ZERO, BizNumber.ZERO);

        bizDomManager.insert(chkItijibrTuusanS1);

        BM_ChkItijibrTuusanS chkItijibrTuusanS2 = new BM_ChkItijibrTuusanS(BizNumber.ZERO, BizNumber.ONE);

        bizDomManager.insert(chkItijibrTuusanS2);

        BM_ChkItijibrTuusanS chkItijibrTuusanS3 = new BM_ChkItijibrTuusanS(BizNumber.ONE, BizNumber.valueOf(9));

        bizDomManager.insert(chkItijibrTuusanS3);

        BM_ChkItijibrTuusanS chkItijibrTuusanS4 = new BM_ChkItijibrTuusanS(BizNumber.TEN, BizNumber.TEN);

        bizDomManager.insert(chkItijibrTuusanS4);

        BM_ChkItijibrTuusanS chkItijibrTuusanS5 = new BM_ChkItijibrTuusanS(BizNumber.ONE, BizNumber.ZERO);

        bizDomManager.insert(chkItijibrTuusanS5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkItijibrTuusanS());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkItijibrTuusanS> chkItijibrTuusanSs = bizDomManager.getChkItijibrTuusanSsByPK(BizNumber.valueOf(11));

        Assert.assertEquals(0, chkItijibrTuusanSs.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<BM_ChkItijibrTuusanS> chkItijibrTuusanSs = bizDomManager.getChkItijibrTuusanSsByPK(BizNumber.TEN);

        Assert.assertEquals(1, chkItijibrTuusanSs.size());

        Assert.assertEquals(BizNumber.TEN, chkItijibrTuusanSs.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.TEN, chkItijibrTuusanSs.get(0).getHhkntonen());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkItijibrTuusanS> chkItijibrTuusanSs = bizDomManager.getChkItijibrTuusanSsByPK(BizNumber.ONE);

        Assert.assertEquals(2, chkItijibrTuusanSs.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(BizNumber.ZERO, BizNumber.ONE),"1");
        map.put($(BizNumber.ONE, BizNumber.valueOf(9)),"2");

        assertTrue(map.containsKey($(chkItijibrTuusanSs.get(0).getHhknfromnen(), chkItijibrTuusanSs.get(0).getHhkntonen())));
        assertTrue(map.containsKey($(chkItijibrTuusanSs.get(1).getHhknfromnen(), chkItijibrTuusanSs.get(1).getHhkntonen())));

        map.remove($(chkItijibrTuusanSs.get(0).getHhknfromnen(), chkItijibrTuusanSs.get(0).getHhkntonen()));
        map.remove($(chkItijibrTuusanSs.get(1).getHhknfromnen(), chkItijibrTuusanSs.get(1).getHhkntonen()));

        assertTrue(map.isEmpty());
    }
}
