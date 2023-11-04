package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManegerTest_getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd {

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_BunsyonoSettei> bunsyonoSetteiLst = bizDomManager
            .getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn.SIORIYAKKAN,
                C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, BizDate.valueOf(20190215));

        Assert.assertEquals(0, bunsyonoSetteiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker
                .getInData(BizDomManegerTest_getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd.class,
                    fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBunsyonoSettei());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_BunsyonoSettei> bunsyonoSetteiLst = bizDomManager
            .getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn.SIORIYAKKAN,
                C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, BizDate.valueOf(20180215));

        Assert.assertEquals(0, bunsyonoSetteiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_BunsyonoSettei> bunsyonoSetteiLst = bizDomManager
            .getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn.SIORIYAKKAN,
                C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, BizDate.valueOf(20190215));

        Assert.assertEquals(1, bunsyonoSetteiLst.size());

        assertEquals(C_BunsyoSyubetuKbn.SIORIYAKKAN, bunsyonoSetteiLst.get(0).getBunsyosyubetukbn());
        assertEquals(C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, bunsyonoSetteiLst.get(0).getAisyoumeikbn());
        assertEquals(C_Channelcd.SMBC, bunsyonoSetteiLst.get(0).getChannelcd());
        assertEquals("D001", bunsyonoSetteiLst.get(0).getOyadrtencd());
        assertEquals(1, bunsyonoSetteiLst.get(0).getRenno().intValue());

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_BunsyonoSettei> bunsyonoSetteiLst = bizDomManager
            .getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(C_BunsyoSyubetuKbn.SIORIYAKKAN,
                C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, BizDate.valueOf(20190315));

        Assert.assertEquals(3, bunsyonoSetteiLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($(C_BunsyoSyubetuKbn.SIORIYAKKAN, C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, "D002", 1),
            "1");
        map.put($(C_BunsyoSyubetuKbn.SIORIYAKKAN, C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, "D002", 2),
            "1");
        map.put($(C_BunsyoSyubetuKbn.SIORIYAKKAN, C_AisyoumeiKbn.GAIKASYUUSIN_K2_SMBC, C_Channelcd.SMBC, "D002", 3),
            "1");

        for (BM_BunsyonoSettei bunsyonoSettei : bunsyonoSetteiLst) {
            map.remove($(bunsyonoSettei.getBunsyosyubetukbn(), bunsyonoSettei.getAisyoumeikbn(),
                bunsyonoSettei.getChannelcd(), bunsyonoSettei.getOyadrtencd(), bunsyonoSettei.getRenno()));
        }
        assertTrue(map.isEmpty());
    }
}