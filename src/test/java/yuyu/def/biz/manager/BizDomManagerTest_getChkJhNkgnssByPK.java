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

import yuyu.def.db.entity.BM_ChkJhNkgns;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 通算チェック<br />
 * 年金原資限度事方書チェックマスタエンティティリスト取得 主キー範囲のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkJhNkgnssByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkJhNkgns> chkJhNkgns = bizDomManager.getChkJhNkgnssByPK(BizNumber.ZERO);

        Assert.assertEquals(0, chkJhNkgns.size());

        BM_ChkJhNkgns chkJhNkgns1 = new BM_ChkJhNkgns(BizNumber.ZERO, BizNumber.ONE);

        bizDomManager.insert(chkJhNkgns1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllChkJhNkgns());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkJhNkgns> chkJhNkgns = bizDomManager.getChkJhNkgnssByPK(BizNumber.TEN);

        Assert.assertEquals(0, chkJhNkgns.size());
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        List<BM_ChkJhNkgns> chkJhNkgns = bizDomManager.getChkJhNkgnssByPK(BizNumber.ZERO);

        Assert.assertEquals(1, chkJhNkgns.size());

        Assert.assertEquals(BizNumber.ZERO, chkJhNkgns.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.ONE, chkJhNkgns.get(0).getHhkntonen());
    }


    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        BM_ChkJhNkgns chkJhNkgns2 = new BM_ChkJhNkgns(BizNumber.ZERO, BizNumber.TEN);

        bizDomManager.insert(chkJhNkgns2);

        BM_ChkJhNkgns chkJhNkgns3 = new BM_ChkJhNkgns(BizNumber.ONE, BizNumber.TEN);

        bizDomManager.insert(chkJhNkgns3);

        BM_ChkJhNkgns chkJhNkgns4 = new BM_ChkJhNkgns(BizNumber.TEN, BizNumber.ONE);

        bizDomManager.insert(chkJhNkgns4);

        BM_ChkJhNkgns chkJhNkgns5 = new BM_ChkJhNkgns(BizNumber.ONE, BizNumber.ZERO);

        bizDomManager.insert(chkJhNkgns5);
    }

    @Test
    @TestOrder(30)
    public void normal20() {

        List<BM_ChkJhNkgns> chkJhNkgns = bizDomManager.getChkJhNkgnssByPK(BizNumber.ONE);

        Assert.assertEquals(3, chkJhNkgns.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($(BizNumber.ZERO,BizNumber.ONE),"1");
        map.put($(BizNumber.ZERO,BizNumber.TEN),"1");
        map.put($(BizNumber.ONE,BizNumber.TEN),"1");

        assertTrue(map.containsKey($(chkJhNkgns.get(0).getHhknfromnen(),chkJhNkgns.get(0).getHhkntonen())));
        assertTrue(map.containsKey($(chkJhNkgns.get(1).getHhknfromnen(),chkJhNkgns.get(1).getHhkntonen())));
        assertTrue(map.containsKey($(chkJhNkgns.get(2).getHhknfromnen(),chkJhNkgns.get(2).getHhkntonen())));

        map.remove($(chkJhNkgns.get(0).getHhknfromnen(),chkJhNkgns.get(0).getHhkntonen()));
        map.remove($(chkJhNkgns.get(1).getHhknfromnen(),chkJhNkgns.get(1).getHhkntonen()));
        map.remove($(chkJhNkgns.get(2).getHhknfromnen(),chkJhNkgns.get(2).getHhkntonen()));

        assertTrue(map.isEmpty());
    }
}
