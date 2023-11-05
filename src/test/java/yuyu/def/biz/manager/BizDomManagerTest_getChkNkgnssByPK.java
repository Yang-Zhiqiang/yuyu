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

import yuyu.def.db.entity.BM_ChkNkgns;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 年金原資限度チェックマスタエンティティリスト取得 主キー範囲のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkNkgnssByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNkgns> chkNkgns = bizDomManager.getChkNkgnssByPK(BizNumber.ZERO);

        Assert.assertEquals(0, chkNkgns.size());

        BM_ChkNkgns chkNkgns1 = new BM_ChkNkgns(BizNumber.ZERO, BizNumber.ONE);

        bizDomManager.insert(chkNkgns1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkNkgns());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkNkgns> chkNkgns = bizDomManager.getChkNkgnssByPK(BizNumber.TEN);

        Assert.assertEquals(0, chkNkgns.size());
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        List<BM_ChkNkgns> chkNkgns = bizDomManager.getChkNkgnssByPK(BizNumber.ZERO);

        Assert.assertEquals(1, chkNkgns.size());

        Assert.assertEquals(BizNumber.ZERO, chkNkgns.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.ONE, chkNkgns.get(0).getHhkntonen());
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        BM_ChkNkgns chkNkgns2 = new BM_ChkNkgns(BizNumber.ZERO, BizNumber.TEN);

        bizDomManager.insert(chkNkgns2);

        BM_ChkNkgns chkNkgns3 = new BM_ChkNkgns(BizNumber.ONE, BizNumber.TEN);

        bizDomManager.insert(chkNkgns3);

        BM_ChkNkgns chkNkgns4 = new BM_ChkNkgns(BizNumber.TEN, BizNumber.ONE);

        bizDomManager.insert(chkNkgns4);

        BM_ChkNkgns chkNkgns5 = new BM_ChkNkgns(BizNumber.ONE, BizNumber.ZERO);

        bizDomManager.insert(chkNkgns5);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkNkgns> chkNkgns = bizDomManager.getChkNkgnssByPK(BizNumber.ONE);

        Assert.assertEquals(3, chkNkgns.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($(BizNumber.ZERO,BizNumber.ONE),"1");
        map.put($(BizNumber.ZERO,BizNumber.TEN),"1");
        map.put($(BizNumber.ONE,BizNumber.TEN),"1");

        assertTrue(map.containsKey($(chkNkgns.get(0).getHhknfromnen(), chkNkgns.get(0).getHhkntonen())));
        assertTrue(map.containsKey($(chkNkgns.get(1).getHhknfromnen(), chkNkgns.get(1).getHhkntonen())));
        assertTrue(map.containsKey($(chkNkgns.get(2).getHhknfromnen(), chkNkgns.get(2).getHhkntonen())));
        map.remove($(chkNkgns.get(0).getHhknfromnen(), chkNkgns.get(0).getHhkntonen()));
        map.remove($(chkNkgns.get(1).getHhknfromnen(), chkNkgns.get(1).getHhkntonen()));
        map.remove($(chkNkgns.get(2).getHhknfromnen(), chkNkgns.get(2).getHhkntonen()));

        assertTrue(map.isEmpty());
    }
}
