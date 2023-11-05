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
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getDenpyoDatasHnkuNyukinPBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getSkKihons {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getSkKihons";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        List<JT_SkKihon> skKihonList = srGkknHnkuSyrSyunyupTukiDao
            .getSkKihons("17806000079", C_SeikyuuSyubetu.SB);

        Assert.assertFalse(skKihonList.iterator().hasNext());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkeiyakuSyuunyuupToukeiDaoTest_getSkKihons.class,
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
        em.createJPQL("delete from JT_SkKihon").executeUpdate();

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

        List<JT_SkKihon> skKihonList = srGkknHnkuSyrSyunyupTukiDao
            .getSkKihons("17806000024", C_SeikyuuSyubetu.SB);

        Assert.assertFalse(skKihonList.iterator().hasNext());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SkKihon> skKihonList = srGkknHnkuSyrSyunyupTukiDao
            .getSkKihons("17806000035", C_SeikyuuSyubetu.SB);

        int iCount = 0;
        Iterator<JT_SkKihon> iter = skKihonList.iterator();
        JT_SkKihon skKihon = null;
        while (iter.hasNext()) {

            skKihon = iter.next();
            iCount++;

            exStringEquals("1", skKihon.getSkno(), "請求番号");
            exStringEquals("17806000035", skKihon.getSyono(), "証券番号");
        }

        exNumericEquals(1, iCount, "取得件数");

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($("0","17806000046"), "1");
        risanomiTuujyuHitusyyugkMap.put($("1","17806000046"), "1");
        risanomiTuujyuHitusyyugkMap.put($("2","17806000046"), "1");
        List<JT_SkKihon> skKihonList = srGkknHnkuSyrSyunyupTukiDao
            .getSkKihons("17806000046", C_SeikyuuSyubetu.SB);

        int iCount = 0;
        Iterator<JT_SkKihon> iter = skKihonList.iterator();
        JT_SkKihon skKihon = null;
        while (iter.hasNext()) {
            skKihon = iter.next();
            iCount++;
            if(iCount == 1){
                risanomiTuujyuHitusyyugkMap.remove($("2", "17806000046"));
            }else if(iCount == 2){
                risanomiTuujyuHitusyyugkMap.remove($("1", "17806000046"));
            }else if(iCount == 3){
                risanomiTuujyuHitusyyugkMap.remove($("0", "17806000046"));
            }
        }
        Assert.assertEquals(3, iCount);
        assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
    }
}
