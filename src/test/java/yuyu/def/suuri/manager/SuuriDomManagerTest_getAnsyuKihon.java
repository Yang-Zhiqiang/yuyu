package yuyu.def.suuri.manager;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getAnsyuKihon メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getAnsyuKihon {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getAnsyuKihon";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        IT_AnsyuKihon ansyuKihon = srCommonKinouDao.
            getAnsyuKihon("60806000033");

        assertNull(ansyuKihon);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("02", "60806000022");
        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "60806000033");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getAnsyuKihon.class, fileName,
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
        em.createJPQL("delete from IT_AnsyuKihon").executeUpdate();
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_AnsyuKihon ansyuKihon = srCommonKinouDao.getAnsyuKihon("60806000022");


        assertNull(ansyuKihon);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_AnsyuKihon ansyuKihon = srCommonKinouDao.getAnsyuKihon("60806000033");


        assertNotNull(ansyuKihon);

        exStringEquals("03", ansyuKihon.getKbnkey(), "区分キー");
        exStringEquals("60806000033", ansyuKihon.getSyono(), "証券番号");
    }
}
