package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getDenpyoDatasHnkuNyukinPBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getDenpyoDatasHnkuNyukinPBySyoriYmd {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getDenpyoDatasHnkuNyukinPBySyoriYmd";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        try (ExDBResults<BT_DenpyoData> exDBResEntity = srGkknHnkuSyrSyunyupTukiDao
            .getDenpyoDatasHnkuNyukinPBySyoriYmd(BizDate.valueOf(20170202), BizDate.valueOf(20170302))) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkeiyakuSyuunyuupToukeiDaoTest_getDenpyoDatasHnkuNyukinPBySyoriYmd.class,
                fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        //em.createJPQL("delete from IT_KykKihon").executeUpdate();
        em.createJPQL("delete from BT_DenpyoData").executeUpdate();

        //BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        // List<BT_DenpyoData> denpyoDataLst = bizDomManager.getAllDenpyoData();
        // if (denpyoDataLst.size() > 0) {

        //   bizDomManager.delete(denpyoDataLst);
        //}
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_DenpyoData> exDBResEntity = srGkknHnkuSyrSyunyupTukiDao
            .getDenpyoDatasHnkuNyukinPBySyoriYmd(BizDate.valueOf(20150202), BizDate.valueOf(20160202))) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_DenpyoData> exDBResEntity = srGkknHnkuSyrSyunyupTukiDao
            .getDenpyoDatasHnkuNyukinPBySyoriYmd(BizDate.valueOf(20170202), BizDate.valueOf(20170302))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResEntity.iterator();
            BT_DenpyoData denpyoData = null;
            while (iter.hasNext()) {

                denpyoData = iter.next();
                iCount++;

                exClassificationEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn(), "伝票用システム区分");
                exStringEquals("20000000000000000002", denpyoData.getDenrenno(), "伝票データ連番");
                exBooleanEquals(denpyoData.getEdano() == 4, true, "枝番号");
            }

            exNumericEquals(1, iCount, "取得件数");
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "80000000000000000002", Integer.valueOf(1)), "6");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "70000000000000000002", Integer.valueOf(2)), "5");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HOZEN, "70000000000000000002", Integer.valueOf(1)), "4");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HOZEN, "30000000000000000002", Integer.valueOf(1)), "1");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "60000000000000000002", Integer.valueOf(3)), "3");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "50000000000000000002", Integer.valueOf(3)), "2");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(4)), "7");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(8)), "8");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(5)), "9");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(6)), "10");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(7)), "11");
        risanomiTuujyuHitusyyugkMap.put($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(9)), "12");
        try (ExDBResults<BT_DenpyoData> exDBResEntity = srGkknHnkuSyrSyunyupTukiDao
            .getDenpyoDatasHnkuNyukinPBySyoriYmd(BizDate.valueOf(20180202), BizDate.valueOf(20180302))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = exDBResEntity.iterator();
            BT_DenpyoData denpyoData = null;
            while (iter.hasNext()) {
                denpyoData = iter.next();
                iCount++;
                if(iCount == 1){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HOZEN, "30000000000000000002", Integer.valueOf(1)));
                }else if(iCount == 2){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "50000000000000000002", Integer.valueOf(3)));
                }else if(iCount == 3){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "60000000000000000002", Integer.valueOf(3)));
                }else if(iCount == 4){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HOZEN, "70000000000000000002", Integer.valueOf(1)));
                }else if(iCount == 5){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "70000000000000000002", Integer.valueOf(2)));
                }else if(iCount == 6){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "80000000000000000002", Integer.valueOf(1)));
                }else if(iCount == 7){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(4)));
                }else if(iCount == 8){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(8)));
                }else if(iCount == 9){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(5)));
                }else if(iCount == 10){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(6)));
                }else if(iCount == 11){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(7)));
                }else if(iCount == 12){
                    risanomiTuujyuHitusyyugkMap.remove($(C_DensysKbn.HKSIHARAI, "90000000000000000002", Integer.valueOf(9)));
                }
            }

            Assert.assertEquals(12, iCount);
            assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
        }
    }
}
