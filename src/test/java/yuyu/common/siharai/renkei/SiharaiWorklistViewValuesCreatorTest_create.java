package yuyu.common.siharai.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払ワークリスト用表示情報生成のメソッド{@link SiharaiWorklistViewValuesCreator#create(List<WorklistViewValuesBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiWorklistViewValuesCreatorTest_create {
    @Inject
    private SiharaiWorklistViewValuesCreator siharaiWorklistViewValuesCreator;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金給付金支払ワークリスト用表示情報生成";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiharaiWorklistViewValuesCreatorTest_create.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager mgr = SWAKInjector.getInstance(BizDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
        mgr.delete(mgr.getSyouhnZokusei("M110", 1));
        mgr.delete(mgr.getSyouhnZokusei("M111", 1));
        mgr.delete(mgr.getSyouhnZokusei("M112", 1));
    }

    @Test
    @TestOrder(10)
    public void testCreate_A1() {
        List<WorklistViewValuesBean> worklistViewValuesBeanList = new ArrayList<>();
        List<WorklistViewValuesBean> worklistViewValuesBeanListResult = new ArrayList<>();
        worklistViewValuesBeanListResult = siharaiWorklistViewValuesCreator.create(worklistViewValuesBeanList);
        exNumericEquals(worklistViewValuesBeanListResult.size(), 0, "ワークリスト用表示情報Beanリストのサイズ");
    }

    @Test
    @TestOrder(20)
    public void testCreate_A2() {
        MockObjectManager.initialize();
        List<WorklistViewValuesBean> worklistViewValuesBeanList = new ArrayList<>();
        WorklistViewValuesBean WorklistViewValuesBean = SWAKInjector.getInstance(WorklistViewValuesBean.class);
        WorklistViewValuesBean.setSyono("99806001010");
        worklistViewValuesBeanList.add(WorklistViewValuesBean);
        List<WorklistViewValuesBean> worklistViewValuesBeanListResult = new ArrayList<>();
        worklistViewValuesBeanListResult = siharaiWorklistViewValuesCreator.create(worklistViewValuesBeanList);
        exNumericEquals(worklistViewValuesBeanListResult.size(), 1, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanListResult.get(0).getDispsyouhnnmworklist(), "入院保険１", "商品名（ワークリスト用）");
        exStringEquals(worklistViewValuesBeanListResult.get(0).getKyknmkj(), "契約者名１", "契約者名（漢字）");
        exStringEquals(worklistViewValuesBeanListResult.get(0).getKyknmkn(), "カナ１", "契約者名（カナ）");

        KeiyakuPrm param = (KeiyakuPrm) MockObjectManager.getArgument(KeiyakuInfoSyutoku.class, "getInfos",
            0, 0);
        exStringEquals(param.getSyono(), "99806001010", " 証券番号");
    }

    @Test
    @TestOrder(30)
    public void testCreate_A3() {
        List<WorklistViewValuesBean> worklistViewValuesBeanList = new ArrayList<>();
        WorklistViewValuesBean WorklistViewValuesBean = new WorklistViewValuesBean();
        WorklistViewValuesBean.setSyono("99806001010");
        worklistViewValuesBeanList.add(WorklistViewValuesBean);
        WorklistViewValuesBean WorklistViewValuesBeanSecond = new WorklistViewValuesBean();
        WorklistViewValuesBeanSecond.setSyono("99806001021");
        worklistViewValuesBeanList.add(WorklistViewValuesBeanSecond);
        WorklistViewValuesBean WorklistViewValuesBeanThird = new WorklistViewValuesBean();
        WorklistViewValuesBeanThird.setSyono("99806001032");
        worklistViewValuesBeanList.add(WorklistViewValuesBeanThird);
        List<WorklistViewValuesBean> worklistViewValuesBeanListResult = new ArrayList<>();
        worklistViewValuesBeanListResult = siharaiWorklistViewValuesCreator.create(worklistViewValuesBeanList);
        exNumericEquals(worklistViewValuesBeanListResult.size(), 3, "ワークリスト用表示情報Beanリストのサイズ");
        exStringEquals(worklistViewValuesBeanListResult.get(0).getDispsyouhnnmworklist(), "入院保険１", "商品名（ワークリスト用）");
        exStringEquals(worklistViewValuesBeanListResult.get(0).getKyknmkj(), "契約者名１", "契約者名（漢字）");
        exStringEquals(worklistViewValuesBeanListResult.get(0).getKyknmkn(), "カナ１", "契約者名（カナ）");

        exStringEquals(worklistViewValuesBeanListResult.get(1).getDispsyouhnnmworklist(), "入院保険２", "商品名（ワークリスト用）");
        exStringEquals(worklistViewValuesBeanListResult.get(1).getKyknmkj(), "契約者名２", "契約者名（漢字）");
        exStringEquals(worklistViewValuesBeanListResult.get(1).getKyknmkn(), "カナ２", "契約者名（カナ）");

        exStringEquals(worklistViewValuesBeanListResult.get(2).getDispsyouhnnmworklist(), "入院保険３", "商品名（ワークリスト用）");
        exStringEquals(worklistViewValuesBeanListResult.get(2).getKyknmkj(), "契約者名３", "契約者名（漢字）");
        exStringEquals(worklistViewValuesBeanListResult.get(2).getKyknmkn(), "カナ３", "契約者名（カナ）");
    }
}
