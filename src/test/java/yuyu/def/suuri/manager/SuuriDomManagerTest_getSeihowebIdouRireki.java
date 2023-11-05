package yuyu.def.suuri.manager;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getSeihowebIdouRireki メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSeihowebIdouRireki {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSeihowebIdouRireki";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setKbnkey("03");
        kykKihon.setSyono("60806000033");
        hozenDomManager.insert(kykKihon);

        IT_SeihowebIdouRireki seihowebIdouRireki = srCommonKinouDao.getSeihowebIdouRireki("60806000033", "000000000000000010");

        assertNull(seihowebIdouRireki);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getSeihowebIdouRireki.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_SeihowebIdouRireki seihowebIdouRireki = srCommonKinouDao.getSeihowebIdouRireki("60806000033", "000000000000000030");

        assertNull(seihowebIdouRireki);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_SeihowebIdouRireki seihowebIdouRireki = srCommonKinouDao.getSeihowebIdouRireki("60806000033", "000000000000000010");

        assertNotNull(seihowebIdouRireki);

        exStringEquals("03", seihowebIdouRireki.getKbnkey(), "区分キー");
        exStringEquals("60806000033", seihowebIdouRireki.getSyono(), "証券番号");
        exStringEquals("000000000000000010", seihowebIdouRireki.getHenkousikibetukey(), "変更識別キー");
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        IT_SeihowebIdouRireki seihowebIdouRireki = srCommonKinouDao.getSeihowebIdouRireki("60806000033", "");

        assertNull(seihowebIdouRireki);
    }

    @Test
    @TestOrder(40)
    public void tableNull() {

        IT_SeihowebIdouRireki seihowebIdouRireki = srCommonKinouDao.getSeihowebIdouRireki("11807111118", "000000000000000010");

        assertNull(seihowebIdouRireki);
    }
}
