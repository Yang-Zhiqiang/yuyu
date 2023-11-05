package yuyu.def.hozen.manager;

import static org.junit.Assert.*;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.result.bean.SmbckykdtlInfosByKakutyoujobcdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSmbckykdtlInfosByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSmbckykdtlInfosByKakutyoujobcd {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSmbckykdtlInfosByKakutyoujobcd";

    private final static String sheetName = "INデータ";

    @Inject
    HozenDomManager hozenDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> exDBResBean = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSmbckykdtlInfosByKakutyoujobcd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> exDBResBean = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSmbckykdtlInfosByKakutyoujobcd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> exDBResBean = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")) {

            int iCount = 0;
            Iterator<SmbckykdtlInfosByKakutyoujobcdBean> iter = exDBResBean.iterator();
            SmbckykdtlInfosByKakutyoujobcdBean resultBean = null;
            while (iter.hasNext()) {

                resultBean = iter.next();
                iCount++;

                assertEquals("01", resultBean.getIT_KykKihon().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykKihon().getSyono());

                assertEquals("01", resultBean.getIT_KykSyouhn().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykSyouhn().getSyono());
                assertEquals(C_SyutkKbn.SYU, resultBean.getIT_KykSyouhn().getSyutkkbn());
                assertEquals("SH01", resultBean.getIT_KykSyouhn().getSyouhncd());
                assertEquals(Integer.valueOf(11), resultBean.getIT_KykSyouhn().getSyouhnsdno());
                assertEquals(Integer.valueOf(2), resultBean.getIT_KykSyouhn().getKyksyouhnrenno());

                assertEquals("01", resultBean.getIT_KykSonotaTkyk().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykSonotaTkyk().getSyono());

                assertEquals("01", resultBean.getIT_HhknSya().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_HhknSya().getSyono());

                assertEquals("01", resultBean.getIT_KykSya().getKbnkey());
                assertEquals("11807111118", resultBean.getIT_KykSya().getSyono());
            }
            assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSmbckykdtlInfosByKakutyoujobcd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> exDBResBean = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")) {
            Map<String,String> map = new HashMap<String,String>();
            map.put($("01", "11807111118","01","11807111118",C_SyutkKbn.SYU,"SH01",Integer.valueOf(11),Integer.valueOf(1),"01","11807111118","01","11807111118","01","11807111118"),"1");
            map.put($("02", "11807111129","02","11807111129",C_SyutkKbn.SYU,"SH01",Integer.valueOf(11),Integer.valueOf(1),"02","11807111129","02","11807111129","02","11807111129"),"1");
            map.put($("03", "11807111130","03","11807111130",C_SyutkKbn.SYU,"SH01",Integer.valueOf(11),Integer.valueOf(1),"03","11807111130","03","11807111130","03","11807111130"),"1");


            int iCount = 0;
            Iterator<SmbckykdtlInfosByKakutyoujobcdBean> iter = exDBResBean.iterator();
            SmbckykdtlInfosByKakutyoujobcdBean resultBean = null;
            while (iter.hasNext()) {

                resultBean = iter.next();
                iCount++;

                if (iCount == 1) {
                    map.remove($(resultBean.getIT_KykKihon().getKbnkey(), resultBean.getIT_KykKihon().getSyono(),
                        resultBean.getIT_KykSyouhn().getKbnkey(),resultBean.getIT_KykSyouhn().getSyono(),
                        resultBean.getIT_KykSyouhn().getSyutkkbn(), resultBean.getIT_KykSyouhn().getSyouhncd(),
                        resultBean.getIT_KykSyouhn().getSyouhnsdno(), resultBean.getIT_KykSyouhn().getKyksyouhnrenno(),
                        resultBean.getIT_KykSonotaTkyk().getKbnkey(), resultBean.getIT_KykSonotaTkyk().getSyono(),
                        resultBean.getIT_HhknSya().getKbnkey(), resultBean.getIT_HhknSya().getSyono(),
                        resultBean.getIT_KykSya().getKbnkey(), resultBean.getIT_KykSya().getSyono()));
                    continue;

                }
                if (iCount == 2) {
                    map.remove($(resultBean.getIT_KykKihon().getKbnkey(), resultBean.getIT_KykKihon().getSyono(),
                        resultBean.getIT_KykSyouhn().getKbnkey(),resultBean.getIT_KykSyouhn().getSyono(),
                        resultBean.getIT_KykSyouhn().getSyutkkbn(), resultBean.getIT_KykSyouhn().getSyouhncd(),
                        resultBean.getIT_KykSyouhn().getSyouhnsdno(), resultBean.getIT_KykSyouhn().getKyksyouhnrenno(),
                        resultBean.getIT_KykSonotaTkyk().getKbnkey(), resultBean.getIT_KykSonotaTkyk().getSyono(),
                        resultBean.getIT_HhknSya().getKbnkey(), resultBean.getIT_HhknSya().getSyono(),
                        resultBean.getIT_KykSya().getKbnkey(), resultBean.getIT_KykSya().getSyono()));
                    continue;

                }
                if (iCount == 3) {

                    map.remove($(resultBean.getIT_KykKihon().getKbnkey(), resultBean.getIT_KykKihon().getSyono(),
                        resultBean.getIT_KykSyouhn().getKbnkey(),resultBean.getIT_KykSyouhn().getSyono(),
                        resultBean.getIT_KykSyouhn().getSyutkkbn(), resultBean.getIT_KykSyouhn().getSyouhncd(),
                        resultBean.getIT_KykSyouhn().getSyouhnsdno(), resultBean.getIT_KykSyouhn().getKyksyouhnrenno(),
                        resultBean.getIT_KykSonotaTkyk().getKbnkey(), resultBean.getIT_KykSonotaTkyk().getSyono(),
                        resultBean.getIT_HhknSya().getKbnkey(), resultBean.getIT_HhknSya().getSyono(),
                        resultBean.getIT_KykSya().getKbnkey(), resultBean.getIT_KykSya().getSyono()));
                    continue;
                }
            }
            assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    public void testSkippedFilter11() {

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> beans = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")){

            int iCount = 0;

            Iterator<SmbckykdtlInfosByKakutyoujobcdBean> iter = beans.iterator();

            SmbckykdtlInfosByKakutyoujobcdBean SmbckykdtlInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                SmbckykdtlInfosByKakutyoujobcdBean = iter.next();
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSmbckykdtlInfosByKakutyoujobcd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> beans = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")){
            int iCount = 0;

            Iterator<SmbckykdtlInfosByKakutyoujobcdBean> iter = beans.iterator();

            SmbckykdtlInfosByKakutyoujobcdBean SmbckykdtlInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                SmbckykdtlInfosByKakutyoujobcdBean = iter.next();
                boolean result1 =
                    (SmbckykdtlInfosByKakutyoujobcdBean.getIT_KykKihon().getKbnkey().equals("01")) &&
                    (SmbckykdtlInfosByKakutyoujobcdBean.getIT_KykKihon().getSyono().equals("11807111118"));


                assertFalse(result1);
                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getSmbckykdtlInfosByKakutyoujobcd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(60)
    public void testSkippedFilter3(){

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> beans = hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd("RBG0")){

            int iCount = 0;

            Iterator<SmbckykdtlInfosByKakutyoujobcdBean> iter = beans.iterator();

            SmbckykdtlInfosByKakutyoujobcdBean SmbckykdtlInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                SmbckykdtlInfosByKakutyoujobcdBean = iter.next();
                boolean result1 =
                    (SmbckykdtlInfosByKakutyoujobcdBean.getIT_KykKihon().getKbnkey().equals("01")) &&
                    (SmbckykdtlInfosByKakutyoujobcdBean.getIT_KykKihon().getSyono().equals("11807111118"));
                boolean result2 =
                    (SmbckykdtlInfosByKakutyoujobcdBean.getIT_KykKihon().getKbnkey().equals("02")) &&
                    (SmbckykdtlInfosByKakutyoujobcdBean.getIT_KykKihon().getSyono().equals("11807111129"));
                assertFalse(result1);
                assertFalse(result2);
                iCount++;
            }

            Assert.assertEquals(1, iCount);

        }
    }


    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        List<IT_KykKihon> kykKihonList = hozenDomManager.getAllKykKihon();

        if(kykKihonList.size() > 0) {
            hozenDomManager.delete(kykKihonList);
        }

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_RecoveryFilter> recoveryFilterlst = bizDomManager.getAllRecoveryFilter();
        if(recoveryFilterlst.size() > 0){
            bizDomManager.delete(recoveryFilterlst);
        }
        List<BT_SkipKey> skipKeylst = bizDomManager.getAllSkipKey();
        if(skipKeylst.size() > 0){
            bizDomManager.delete(skipKeylst);
        }
    }



    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }
}
