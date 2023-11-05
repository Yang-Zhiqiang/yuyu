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
 * 数理統計共通機能DAOクラスのメソッド {@link SrCommonKinouDao#getTargetTokuyakuBefaAftMokuhyoutiDescList}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getTargetTokuyakuBefaAftMokuhyoutiDescList {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getTargetTokuyakuBefaAftMokuhyoutiDescList";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
            srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList("11807111129");

        assertEquals(0, khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                SuuriDomManagerTest_getTargetTokuyakuBefaAftMokuhyoutiDescList.class, fileName, sheetName);
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

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
            srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList("11807111118");

        assertEquals(0, khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
            srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList("11807111129");

        assertEquals(1, khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size());

        exStringEquals("000000000000000110", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("100000", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("0", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getNewnaiyouoriginal(), "変更後内容原本");
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
            srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList("11807111130");

        assertEquals(5, khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size());

        exStringEquals("000000000000000110", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("20200601", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("111", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000090", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(1).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("111", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(1).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("20200601", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(1).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000050", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(2).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("110", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(2).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("0", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(2).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000030", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(3).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("8873000", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(3).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("0", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(3).getNewnaiyouoriginal(), "変更後内容原本");

        exStringEquals("000000000000000010", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(4).getHenkousikibetukey(), "変更識別キー");
        exStringEquals("20170704", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(4).getBfrnaiyouoriginal(), "変更前内容原本");
        exStringEquals("20200709", khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(4).getNewnaiyouoriginal(), "変更後内容原本");
    }

    @Test
    @TestOrder(40)
    public void blank1Condition() {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
            srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList("");

        assertEquals(0, khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size());
    }
}
