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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getAzukarikin メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getAzukarikin {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getAzukarikin";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        IT_Azukarikin azukarikin = srCommonKinouDao.
            getAzukarikin("60806000033", "1001", C_Tuukasyu.JPY);

        assertNull(azukarikin);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("03", "60806000022");
        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "60806000033");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getAzukarikin.class, fileName,
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
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
        em.createJPQL("delete from IT_Azukarikin").executeUpdate();
        //List<IT_Azukarikin> azukarikin = hozenDomManager.getAzukarikinsBySyono("60806000033");
        //if (azukarikin.size() > 0) {
        //   hozenDomManager.delete(azukarikin);
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

        IT_Azukarikin azukarikin = srCommonKinouDao.
            getAzukarikin("60806000022", "1001", C_Tuukasyu.JPY);

        assertNull(azukarikin);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_Azukarikin azukarikin = srCommonKinouDao.
            getAzukarikin("60806000033", "1001", C_Tuukasyu.JPY);


        assertNotNull(azukarikin);

        exStringEquals("03", azukarikin.getKbnkey(), "区分キー");
        exStringEquals("60806000033", azukarikin.getSyono(), "証券番号");
        exStringEquals("1001", azukarikin.getHenkousikibetukey(), "変更識別キー");
        exClassificationEquals(C_Tuukasyu.JPY, azukarikin.getTuukasyu(), "通貨種類");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        IT_Azukarikin azukarikin = srCommonKinouDao.
            getAzukarikin("", "", C_Tuukasyu.JPY);

        assertNull(azukarikin);

    }
}
