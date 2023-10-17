package yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbNyknkwsrateOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金用為替レート照会のメイン処理{@link HbNyknkwsrateImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbNyknkwsrateTest_execPostForm extends AbstractTest {

    @Inject
    private HbNyknkwsrateImpl dbNyknkwsrateImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_入金用為替レート照会";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbNyknkwsrateTest_execPostForm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

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
    public void testExecPostForm_A1() throws Exception {
        MockObjectManager.initialize();
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "20181010");
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrate");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dbNyknkwsrateImpl.execPostForm(pMap);

        WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbNyknkwsrateOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy1(), BizDate.valueOf("20181010"), "（ＩＷＳ）為替レート適用日＿米ドル－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy2(), BizDate.valueOf("20181009"), "（ＩＷＳ）為替レート適用日＿米ドル－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy3(), BizDate.valueOf("20181005"), "（ＩＷＳ）為替レート適用日＿米ドル－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy4(), BizDate.valueOf("20181004"), "（ＩＷＳ）為替レート適用日＿米ドル－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy5(), BizDate.valueOf("20181003"), "（ＩＷＳ）為替レート適用日＿米ドル－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy1(), BizNumber.valueOf(1), "（ＩＷＳ）為替レート＿米ドル－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy2(), BizNumber.valueOf(1), "（ＩＷＳ）為替レート＿米ドル－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy3(), BizNumber.valueOf(1), "（ＩＷＳ）為替レート＿米ドル－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy4(), BizNumber.valueOf(1), "（ＩＷＳ）為替レート＿米ドル－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy5(), BizNumber.valueOf(1), "（ＩＷＳ）為替レート＿米ドル－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy1(), BizDate.valueOf("20181010"), "（ＩＷＳ）為替レート適用日＿豪ドル－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy2(), BizDate.valueOf("20181009"), "（ＩＷＳ）為替レート適用日＿豪ドル－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy3(), BizDate.valueOf("20181005"), "（ＩＷＳ）為替レート適用日＿豪ドル－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy4(), BizDate.valueOf("20181004"), "（ＩＷＳ）為替レート適用日＿豪ドル－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy5(), BizDate.valueOf("20181003"), "（ＩＷＳ）為替レート適用日＿豪ドル－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy1(), BizNumber.valueOf(2), "（ＩＷＳ）為替レート＿豪ドル－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy2(), BizNumber.valueOf(2), "（ＩＷＳ）為替レート＿豪ドル－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy3(), BizNumber.valueOf(2), "（ＩＷＳ）為替レート＿豪ドル－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy4(), BizNumber.valueOf(2), "（ＩＷＳ）為替レート＿豪ドル－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy5(), BizNumber.valueOf(2), "（ＩＷＳ）為替レート＿豪ドル－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd1(), BizDate.valueOf("20181010"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd2(), BizDate.valueOf("20181009"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd3(), BizDate.valueOf("20181005"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd4(), BizDate.valueOf("20181004"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd5(), BizDate.valueOf("20181003"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd1(), BizNumber.valueOf(300), "（ＩＷＳ）為替レート＿豪ドル－米ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd2(), BizNumber.valueOf(300), "（ＩＷＳ）為替レート＿豪ドル－米ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd3(), BizNumber.valueOf(300), "（ＩＷＳ）為替レート＿豪ドル－米ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd4(), BizNumber.valueOf(300), "（ＩＷＳ）為替レート＿豪ドル－米ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd5(), BizNumber.valueOf(300), "（ＩＷＳ）為替レート＿豪ドル－米ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud1(), BizDate.valueOf("20181010"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud2(), BizDate.valueOf("20181009"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud3(), BizDate.valueOf("20181005"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud4(), BizDate.valueOf("20181004"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud5(), BizDate.valueOf("20181003"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud1(), BizNumber.valueOf(400), "（ＩＷＳ）為替レート＿米ドル－豪ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud2(), BizNumber.valueOf(400), "（ＩＷＳ）為替レート＿米ドル－豪ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud3(), BizNumber.valueOf(400), "（ＩＷＳ）為替レート＿米ドル－豪ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud4(), BizNumber.valueOf(400), "（ＩＷＳ）為替レート＿米ドル－豪ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud5(), BizNumber.valueOf(400), "（ＩＷＳ）為替レート＿米ドル－豪ドル５");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "20180910");
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrate");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dbNyknkwsrateImpl.execPostForm(pMap);

        WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbNyknkwsrateOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy1(), BizDate.valueOf("20180910"), "（ＩＷＳ）為替レート適用日＿米ドル－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy2(), BizDate.valueOf("20180907"), "（ＩＷＳ）為替レート適用日＿米ドル－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy3(), BizDate.valueOf("20180906"), "（ＩＷＳ）為替レート適用日＿米ドル－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy4(), BizDate.valueOf("20180905"), "（ＩＷＳ）為替レート適用日＿米ドル－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy5(), BizDate.valueOf("20180904"), "（ＩＷＳ）為替レート適用日＿米ドル－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy1(), BizDate.valueOf("20180910"), "（ＩＷＳ）為替レート適用日＿豪ドル－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy2(), BizDate.valueOf("20180907"), "（ＩＷＳ）為替レート適用日＿豪ドル－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy3(), BizDate.valueOf("20180906"), "（ＩＷＳ）為替レート適用日＿豪ドル－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy4(), BizDate.valueOf("20180905"), "（ＩＷＳ）為替レート適用日＿豪ドル－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy5(), BizDate.valueOf("20180904"), "（ＩＷＳ）為替レート適用日＿豪ドル－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd1(), BizDate.valueOf("20180910"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd2(), BizDate.valueOf("20180907"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd3(), BizDate.valueOf("20180906"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd4(), BizDate.valueOf("20180905"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd5(), BizDate.valueOf("20180904"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud1(), BizDate.valueOf("20180910"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud2(), BizDate.valueOf("20180907"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud3(), BizDate.valueOf("20180906"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud4(), BizDate.valueOf("20180905"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud5(), BizDate.valueOf("20180904"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル５");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_B1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "00000000");
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrate");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dbNyknkwsrateImpl.execPostForm(pMap);

        WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbNyknkwsrateOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdjpy5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurjpy5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－円１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－円２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－円３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－円４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudjpy5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－円５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudjpy5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－円５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeurusd5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－米ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeurusd5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－米ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdeuraud5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿ユーロ－豪ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateeuraud5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿ユーロ－豪ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdaudusd5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿豪ドル－米ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateaudusd5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿豪ドル－米ドル５");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud1(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル１");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud2(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル２");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud3(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル３");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud4(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル４");
        exDateEquals(wsHbNyknkwsrateOutputBean.getIwsKwsratetekiymdusdaud5(), BizDate.valueOf("00000000"), "（ＩＷＳ）為替レート適用日＿米ドル－豪ドル５");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud1(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル１");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud2(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル２");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud3(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル３");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud4(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル４");
        exBizCalcbleEquals(wsHbNyknkwsrateOutputBean.getIwsKwsrateusdaud5(), BizNumber.valueOf(00000), "（ＩＷＳ）為替レート＿米ドル－豪ドル５");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_B2() throws Exception {

        try {
            MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
                "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
            pMap.add("gyoumuData", " ");
            pMap.add("operatorId", "testId");
            pMap.add("orgCode", "testCode");
            pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrate");
            pMap.add("coopClass", "01");

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dbNyknkwsrateImpl.execPostForm(pMap);

            WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbNyknkwsrateOutputBean.class);

            exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "Unexpected error while string To Bean For Fixedlength.", "エラーメッセージ");

        }
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_B3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "20181010");
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbnyknkwsrate.HbNyknkwsrate");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dbNyknkwsrateImpl.execPostForm(pMap);

        WsHbNyknkwsrateOutputBean wsHbNyknkwsrateOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbNyknkwsrateOutputBean.class);

        exStringEquals(wsHbNyknkwsrateOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
    }
}
