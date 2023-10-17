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
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getDenpyoDatasHnkuNyukinPBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getSks {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getSks";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        List<JT_Sk> skList = srGkknHnkuSyrSyunyupTukiDao
            .getSks("1", "17806000149");

        Assert.assertFalse(skList.iterator().hasNext());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkeiyakuSyuunyuupToukeiDaoTest_getSks.class,
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
        em.createJPQL("delete from JT_Sk").executeUpdate();

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

        List<JT_Sk> skList = srGkknHnkuSyrSyunyupTukiDao
            .getSks("1", "17806000183");

        Assert.assertFalse(skList.iterator().hasNext());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_Sk> skList = srGkknHnkuSyrSyunyupTukiDao
            .getSks("1", "17806000035");

        int iCount = 0;
        Iterator<JT_Sk> iter = skList.iterator();
        JT_Sk sk = null;
        while (iter.hasNext()) {

            sk = iter.next();
            iCount++;

            exStringEquals("1", sk.getSkno(), "請求番号");
            exStringEquals("17806000035", sk.getSyono(), "証券番号");
            exNumericEquals(1, sk.getSeikyuurirekino(), "請求履歴番号");
        }

        exNumericEquals(1, iCount, "取得件数");

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($("1","17806000046","1"), "1");
        risanomiTuujyuHitusyyugkMap.put($("1","17806000046","2"), "1");
        risanomiTuujyuHitusyyugkMap.put($("1","17806000046","3"), "1");
        List<JT_Sk> skList = srGkknHnkuSyrSyunyupTukiDao
            .getSks("1", "17806000046");

        int iCount = 0;
        Iterator<JT_Sk> iter = skList.iterator();
        JT_Sk sk = null;
        while (iter.hasNext()) {
            sk = iter.next();
            iCount++;
            if(iCount == 1){
                risanomiTuujyuHitusyyugkMap.remove($("1", "17806000046","3"));
            }else if(iCount == 2){
                risanomiTuujyuHitusyyugkMap.remove($("1", "17806000046","2"));
            }else if(iCount == 3){
                risanomiTuujyuHitusyyugkMap.remove($("1", "17806000046","1"));
            }
        }
        Assert.assertEquals(3, iCount);
        assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
    }
}
