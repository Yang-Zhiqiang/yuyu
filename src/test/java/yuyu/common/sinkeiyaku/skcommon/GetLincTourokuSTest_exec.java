package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＬＩＮＣ登録S（日額）取得クラスのメソッド {@link GetLincTourokuS#exec(String)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class GetLincTourokuSTest_exec {

    @Inject
    private GetLincTourokuS getLincTourokuS;

    private final static String fileName = "UT-SP_単体テスト仕様書_ＬＩＮＣ登録S（日額）取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetLincTourokuSTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getMosKihonsByUktkid("780000022"));
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getMosKihonsByUktkid("780000030"));
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getMosKihonsByUktkid("780000048"));
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getMosKihonsByUktkid("780000055"));
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
        bizDomManager.delete(bizDomManager.getAllSyokugyou());

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        MosnaiCheckParam pMosnaiCheckParam = new MosnaiCheckParam();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("780000014");
        pMosnaiCheckParam.setDataSyoriControl(syoriCTL);
        try {
            getLincTourokuS.exec(pMosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=780000014", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        MosnaiCheckParam pMosnaiCheckParam = new MosnaiCheckParam();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("780000022");
        pMosnaiCheckParam.setDataSyoriControl(syoriCTL);
        try {
            getLincTourokuS.exec(pMosnaiCheckParam);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=780000022", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MosnaiCheckParam pMosnaiCheckParam = new MosnaiCheckParam();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("780000030");
        pMosnaiCheckParam.setDataSyoriControl(syoriCTL);
        getLincTourokuS.exec(pMosnaiCheckParam);

        exBizCalcbleEquals(getLincTourokuS.getHutusibous(), BizCurrency.valueOf(100), "普通死亡保険金額");
        exBizCalcbleEquals(getLincTourokuS.getSonotanyuinng(), BizCurrency.valueOf(0), "その他入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSaigaisibous(), BizCurrency.valueOf(100), "災害死亡時加算保険金額");
        exBizCalcbleEquals(getLincTourokuS.getSippeinyuinng(), BizCurrency.valueOf(100), "疾病入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSaigainyuinng(), BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSeijinnyuinng(), BizCurrency.valueOf(100), "成人病入院給付金日額");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MosnaiCheckParam pMosnaiCheckParam = new MosnaiCheckParam();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("780000048");
        pMosnaiCheckParam.setDataSyoriControl(syoriCTL);
        getLincTourokuS.exec(pMosnaiCheckParam);

        exBizCalcbleEquals(getLincTourokuS.getHutusibous(), BizCurrency.valueOf(0), "普通死亡保険金額");
        exBizCalcbleEquals(getLincTourokuS.getSaigaisibous(), BizCurrency.valueOf(0), "災害死亡時加算保険金額");
        exBizCalcbleEquals(getLincTourokuS.getSippeinyuinng(), BizCurrency.valueOf(0), "疾病入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSaigainyuinng(), BizCurrency.valueOf(0), "災害入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSeijinnyuinng(), BizCurrency.valueOf(0), "成人病入院給付金日額");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MosnaiCheckParam pMosnaiCheckParam = new MosnaiCheckParam();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("780000055");
        pMosnaiCheckParam.setDataSyoriControl(syoriCTL);
        getLincTourokuS.exec(pMosnaiCheckParam);

        getLincTourokuS.exec(pMosnaiCheckParam);

        exBizCalcbleEquals(getLincTourokuS.getHutusibous(), BizCurrency.valueOf(648), "普通死亡保険金額");
        exBizCalcbleEquals(getLincTourokuS.getSaigaisibous(), BizCurrency.valueOf(648), "災害死亡時加算保険金額");
        exBizCalcbleEquals(getLincTourokuS.getSippeinyuinng(), BizCurrency.valueOf(648), "疾病入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSaigainyuinng(), BizCurrency.valueOf(648), "災害入院給付金日額");
        exBizCalcbleEquals(getLincTourokuS.getSeijinnyuinng(), BizCurrency.valueOf(648), "成人病入院給付金日額");
    }
}

