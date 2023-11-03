package yuyu.common.hozen.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全ワークリスト用表示情報生成のメソッド {@link HozenWorklistViewValuesCreator#create(List<WorklistViewValuesBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HozenWorklistViewValuesCreatorTest_create extends AbstractTest {

    @Inject
    private HozenWorklistViewValuesCreator sozenWorklistViewValuesCreator;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約保全ワークリスト用表示情報生成";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenWorklistViewValuesCreatorTest_create.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager  = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        List<WorklistViewValuesBean> pWorklistViewValuesBeanLst = new ArrayList<>();
        pWorklistViewValuesBeanLst = sozenWorklistViewValuesCreator.create(pWorklistViewValuesBeanLst);
        exNumericEquals(pWorklistViewValuesBeanLst.size(), 0, "ワークリスト用表示情報Beanリストの件数");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        List<WorklistViewValuesBean> pWorklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100100");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);

        try {

            sozenWorklistViewValuesCreator.create(pWorklistViewValuesBeanLst);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約基本TBLにデータが存在しません。", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        List<WorklistViewValuesBean> pWorklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100122");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);

        try {

            sozenWorklistViewValuesCreator.create(pWorklistViewValuesBeanLst);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品TBLにデータが存在しません。", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        List<WorklistViewValuesBean> pWorklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100133");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);

        try {

            sozenWorklistViewValuesCreator.create(pWorklistViewValuesBeanLst);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性マスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        List<WorklistViewValuesBean> pWorklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100144");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);

        pWorklistViewValuesBeanLst = sozenWorklistViewValuesCreator.create(pWorklistViewValuesBeanLst);
        exNumericEquals(pWorklistViewValuesBeanLst.size(), 1, "ワークリスト用表示情報Beanリストの件数");
        exStringEquals(pWorklistViewValuesBeanLst.get(0).getDispsyouhnnmworklist(),"ワーク１","商品名（ワークリスト用）");
        exStringEquals(pWorklistViewValuesBeanLst.get(0).getKyknmkj(),"漢字１","契約者名（漢字）");
        exStringEquals(pWorklistViewValuesBeanLst.get(0).getKyknmkn(),"カナ１","契約者名（カナ）");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        List<WorklistViewValuesBean> pWorklistViewValuesBeanLst = new ArrayList<>();
        WorklistViewValuesBean worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100144");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);
        worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100155");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);
        worklistViewValuesBean = new WorklistViewValuesBean();
        worklistViewValuesBean.setSyono("11806100166");
        pWorklistViewValuesBeanLst.add(worklistViewValuesBean);

        pWorklistViewValuesBeanLst = sozenWorklistViewValuesCreator.create(pWorklistViewValuesBeanLst);
        exNumericEquals(pWorklistViewValuesBeanLst.size(), 3, "ワークリスト用表示情報Beanリストの件数");
        exStringEquals(pWorklistViewValuesBeanLst.get(0).getDispsyouhnnmworklist(),"ワーク１","商品名（ワークリスト用）");
        exStringEquals(pWorklistViewValuesBeanLst.get(0).getKyknmkj(),"漢字１","契約者名（漢字）");
        exStringEquals(pWorklistViewValuesBeanLst.get(0).getKyknmkn(),"カナ１","契約者名（カナ）");
        exStringEquals(pWorklistViewValuesBeanLst.get(1).getDispsyouhnnmworklist(),"ワーク２","商品名（ワークリスト用）");
        exStringEquals(pWorklistViewValuesBeanLst.get(1).getKyknmkj(),"漢字２","契約者名（漢字）");
        exStringEquals(pWorklistViewValuesBeanLst.get(1).getKyknmkn(),"カナ２","契約者名（カナ）");
        exStringEquals(pWorklistViewValuesBeanLst.get(2).getDispsyouhnnmworklist(),"ワーク３","商品名（ワークリスト用）");
        exStringEquals(pWorklistViewValuesBeanLst.get(2).getKyknmkj(),"漢字３","契約者名（漢字）");
        exStringEquals(pWorklistViewValuesBeanLst.get(2).getKyknmkn(),"カナ３","契約者名（カナ）");

    }
}
