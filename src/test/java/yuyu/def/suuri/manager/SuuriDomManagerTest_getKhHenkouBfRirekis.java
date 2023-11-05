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
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理統計共通機能DAOクラスのメソッド {@link SrCommonKinouDao#getKhHenkouBfRirekis}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKhHenkouBfRirekis {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhHenkouBfRirekis";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> kekkaBeanList =
            srCommonKinouDao.getKhHenkouBfRirekis("11807111129", "IT_KykSonotaTkyk", "targettkmokuhyouti");

        assertEquals(0, kekkaBeanList.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                SuuriDomManagerTest_getKhHenkouBfRirekis.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KhHenkouRireki").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> kekkaBeanList =
            srCommonKinouDao.getKhHenkouBfRirekis("11807111118", "IT_KykSonotaTkyk", "targettkmokuhyouti");

        assertEquals(0, kekkaBeanList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> kekkaBeanList =
            srCommonKinouDao.getKhHenkouBfRirekis("11807111129", "IT_KykSonotaTkyk", "targettkmokuhyouti");

        assertEquals(1, kekkaBeanList.size());

        exStringEquals("000000000000000110", kekkaBeanList.get(0).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("100000", kekkaBeanList.get(0).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("0", kekkaBeanList.get(0).getNewnaiyouoriginal(), "変更後内容原本");
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> kekkaBeanList =
            srCommonKinouDao.getKhHenkouBfRirekis("11807111130", "IT_KykSonotaTkyk", "targettkmokuhyouti");

        assertEquals(5, kekkaBeanList.size());

        exStringEquals("000000000000000110", kekkaBeanList.get(0).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("20200601", kekkaBeanList.get(0).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("111", kekkaBeanList.get(0).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000090", kekkaBeanList.get(1).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("111", kekkaBeanList.get(1).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("20200601", kekkaBeanList.get(1).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000050", kekkaBeanList.get(2).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("110", kekkaBeanList.get(2).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("0", kekkaBeanList.get(2).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000030", kekkaBeanList.get(3).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("8873000", kekkaBeanList.get(3).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("0", kekkaBeanList.get(3).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000010", kekkaBeanList.get(4).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("20170704", kekkaBeanList.get(4).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("20200709", kekkaBeanList.get(4).getNewnaiyouoriginal(), "変更後内容原本");
    }

    @Test
    @TestOrder(40)
    public void blank1Condition() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
            srCommonKinouDao.getKhHenkouBfRirekis("","","");

        assertEquals(0, khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size());
    }
}
