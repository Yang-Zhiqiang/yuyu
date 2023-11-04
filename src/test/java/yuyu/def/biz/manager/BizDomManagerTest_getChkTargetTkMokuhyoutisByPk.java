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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 申込基本TBLチェック<br />
 * ターゲット特約目標値チェックマスタエンティティリスト取得(商品コード、商品世代番号、ターゲット特約目標値)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkTargetTkMokuhyoutisByPk {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkTargetTkMokuhyoutisByPk";

    private final static String sheetName = "INデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst = bizDomManager.getChkTargetTkMokuhyoutisByPk("0003",
            2, C_Channelcd.SMBC, 5);

        Assert.assertEquals(0, chkTargetTkMokuhyoutiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkTargetTkMokuhyoutisByPk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkTargetTkMokuhyouti());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst = bizDomManager.getChkTargetTkMokuhyoutisByPk("0001",
            1, C_Channelcd.SMBC, 3);

        Assert.assertEquals(0, chkTargetTkMokuhyoutiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst = bizDomManager.getChkTargetTkMokuhyoutisByPk("0003",
            2, C_Channelcd.SMBC, 5);

        Assert.assertEquals(1, chkTargetTkMokuhyoutiLst.size());
        Assert.assertEquals("0003", chkTargetTkMokuhyoutiLst.get(0).getSyouhncd());
        Assert.assertEquals(2, chkTargetTkMokuhyoutiLst.get(0).getSyusyouhnsdnofrom().intValue());
        Assert.assertEquals(2, chkTargetTkMokuhyoutiLst.get(0).getSyusyouhnsdnoto().intValue());
        Assert.assertEquals(C_Channelcd.SMBC, chkTargetTkMokuhyoutiLst.get(0).getChannelcd());
        Assert.assertEquals(5, chkTargetTkMokuhyoutiLst.get(0).getTargettkmokuhyouti().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst = bizDomManager.getChkTargetTkMokuhyoutisByPk("0004",
            4, C_Channelcd.TIGIN, 5);

        Assert.assertEquals(3, chkTargetTkMokuhyoutiLst.size());
        Map<String, String> map = new HashMap<String, String>();
        map.put($("0004", 3, 4, C_Channelcd.TIGIN, 5), "1");
        map.put($("0004", 4, 4, C_Channelcd.TIGIN, 5), "1");
        map.put($("0004", 4, 5, C_Channelcd.TIGIN, 5), "1");

        for (BM_ChkTargetTkMokuhyouti chkTargetTkMokuhyouti : chkTargetTkMokuhyoutiLst) {
            map.remove($(chkTargetTkMokuhyouti.getSyouhncd(), chkTargetTkMokuhyouti.getSyusyouhnsdnofrom(),
                chkTargetTkMokuhyouti.getSyusyouhnsdnoto(), chkTargetTkMokuhyouti.getChannelcd(),
                chkTargetTkMokuhyouti.getTargettkmokuhyouti()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_ChkTargetTkMokuhyouti> chkTargetTkMokuhyoutiLst = bizDomManager.getChkTargetTkMokuhyoutisByPk("", 4,
            C_Channelcd.TIGIN, 5);

        Assert.assertEquals(0, chkTargetTkMokuhyoutiLst.size());
    }
}
