package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 経理伝票データ作成共通処理クラスのメソッド {@link BzKeiriDenDataSksKyoutuu#getDenpyoKawaseRate(BT_DenpyoData)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKeiriDenDataSksKyoutuuTest_getDenpyoKawaseRate extends AbstractTest {

    @Inject
    private BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_経理伝票データ作成共通処理";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzKeiriDenDataSksKyoutuuTest_getDenpyoKawaseRate.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testGetDenpyoKawaseRate_A1() {

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setKakokawaserateshiteiflg(true);
        btDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData.setTuukasyu(C_Tuukasyu.EUR);

        BizNumber kawaserate = bzKeiriDenDataSksKyoutuu.getDenpyoKawaseRate(btDenpyoData);

        exBizCalcbleEquals(kawaserate, BizNumber.valueOf(8), "伝票用為替レート");

    }

    @Test
    @TestOrder(20)
    public void testGetDenpyoKawaseRate_A2() {

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setKakokawaserateshiteiflg(false);
        btDenpyoData.setKakokawaserateshiteiymd(BizDate.valueOf("20160101"));
        btDenpyoData.setTuukasyu(C_Tuukasyu.USD);

        BizDate syoriYmd = BizDate.valueOf("20160220");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BizNumber kawaserate = bzKeiriDenDataSksKyoutuu.getDenpyoKawaseRate(btDenpyoData);

        exBizCalcbleEquals(kawaserate, BizNumber.valueOf(6), "伝票用為替レート");

    }
}
