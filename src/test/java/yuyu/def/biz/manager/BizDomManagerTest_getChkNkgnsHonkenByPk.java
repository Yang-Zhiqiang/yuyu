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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.BM_ChkNkgnsHonken;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkNkgnsHonkenByPk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkNkgnsHonkenByPk {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkNkgnsHonkenByPk";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkNkgnsHonken> chkNkgnsHonkenLst = bizDomManager.getChkNkgnsHonkenByPk("ﾕｹ", 50, 50);

        Assert.assertEquals(0, chkNkgnsHonkenLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkNkgnsHonkenByPk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkNkgnsHonken());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkNkgnsHonken> chkNkgnsHonkenLst = bizDomManager.getChkNkgnsHonkenByPk("ﾕｼ", 50, 50);

        Assert.assertEquals(0, chkNkgnsHonkenLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkNkgnsHonken> chkNkgnsHonkenLst = bizDomManager.getChkNkgnsHonkenByPk("ﾕｹ", 50, 50);

        Assert.assertEquals(1, chkNkgnsHonkenLst.size());

        Assert.assertEquals("ﾕｹ", chkNkgnsHonkenLst.get(0).getSyouhncd());
        Assert.assertEquals(1, chkNkgnsHonkenLst.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(99, chkNkgnsHonkenLst.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(BizNumber.valueOf(0), chkNkgnsHonkenLst.get(0).getHhknfromnen());
        Assert.assertEquals(BizNumber.valueOf(999), chkNkgnsHonkenLst.get(0).getHhkntonen());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkNkgnsHonken> chkNkgnsHonkenLst = bizDomManager.getChkNkgnsHonkenByPk("ﾕｿ", 25, 35);

        Assert.assertEquals(4, chkNkgnsHonkenLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("ﾕｿ", 24, 26, BizNumber.valueOf(34), BizNumber.valueOf(36)), "1");
        map.put($("ﾕｿ", 25, 26, BizNumber.valueOf(34), BizNumber.valueOf(35)), "1");
        map.put($("ﾕｿ", 24, 25, BizNumber.valueOf(35), BizNumber.valueOf(36)), "1");
        map.put($("ﾕｿ", 25, 25, BizNumber.valueOf(35), BizNumber.valueOf(35)), "1");

        for (BM_ChkNkgnsHonken chkNkgnsHonken : chkNkgnsHonkenLst) {
            map.remove($(chkNkgnsHonken.getSyouhncd(), chkNkgnsHonken.getSyusyouhnsdnofrom(),
                chkNkgnsHonken.getSyusyouhnsdnoto(), chkNkgnsHonken.getHhknfromnen(), chkNkgnsHonken.getHhkntonen()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkNkgnsHonken> chkNkgnsHonkenLst = bizDomManager.getChkNkgnsHonkenByPk("", 25, 35);

        Assert.assertEquals(0, chkNkgnsHonkenLst.size());

    }
}
