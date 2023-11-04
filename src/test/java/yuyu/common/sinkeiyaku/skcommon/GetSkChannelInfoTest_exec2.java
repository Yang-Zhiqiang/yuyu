package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約チャネル情報取得クラスのメソッド {@link GetSkChannelInfo#exec(C_Channelcd, String)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetSkChannelInfoTest_exec2 {

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約チャネル情報取得";

    private final static String sheetName = "テストデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Inject
    private GetSkChannelInfo getSkChannelInfo;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();

            testDataAndTblMap = testDataMaker.getInData(GetSkChannelInfoTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllTyouhyourenrakusaki());

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkChannel());
        testDataAndTblMap.clear();
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        getSkChannelInfo.exec(null, null);

        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN, "帳票連絡先識別区分");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

        exClassificationEquals(getSkChannelInfo.getSkeiJimuKbn(), C_SkeijimuKbn.SHOP, "新契約事務区分");
        exClassificationEquals(getSkChannelInfo.getAisyoumeiChannelKbn(), C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");
        exClassificationEquals(getSkChannelInfo.getKiteichkchannelcd(), C_Channelcd.MIZUHO, "規定チェック用チャネルコード取得");
        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN,
            "帳票連絡先識別区分");
        exNumericEquals(getSkChannelInfo.getSortNo(), 1, "ソート番号");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        getSkChannelInfo.exec(null, "9988776");

        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN, "帳票連絡先識別区分");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

        exClassificationEquals(getSkChannelInfo.getSkeiJimuKbn(), C_SkeijimuKbn.SHOP, "新契約事務区分");
        exClassificationEquals(getSkChannelInfo.getAisyoumeiChannelKbn(), C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");
        exClassificationEquals(getSkChannelInfo.getKiteichkchannelcd(), C_Channelcd.MIZUHO, "規定チェック用チャネルコード取得");
        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN,
            "帳票連絡先識別区分");
        exNumericEquals(getSkChannelInfo.getSortNo(), 1, "ソート番号");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        getSkChannelInfo.exec(C_Channelcd.SONOTAMADOHAN, "MS123");

        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN, "帳票連絡先識別区分");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

        exClassificationEquals(getSkChannelInfo.getSkeiJimuKbn(), C_SkeijimuKbn.SHOP, "新契約事務区分");
        exClassificationEquals(getSkChannelInfo.getAisyoumeiChannelKbn(), C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");
        exClassificationEquals(getSkChannelInfo.getKiteichkchannelcd(), C_Channelcd.MIZUHO, "規定チェック用チャネルコード取得");
        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN,
            "帳票連絡先識別区分");
        exNumericEquals(getSkChannelInfo.getSortNo(), 1, "ソート番号");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        getSkChannelInfo.exec(null, "MS321");

        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN, "帳票連絡先識別区分");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

        exClassificationEquals(getSkChannelInfo.getSkeiJimuKbn(), C_SkeijimuKbn.SHOP, "新契約事務区分");
        exClassificationEquals(getSkChannelInfo.getAisyoumeiChannelKbn(), C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");
        exClassificationEquals(getSkChannelInfo.getKiteichkchannelcd(), C_Channelcd.MIZUHO, "規定チェック用チャネルコード取得");
        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN,
            "帳票連絡先識別区分");
        exNumericEquals(getSkChannelInfo.getSortNo(), 1, "ソート番号");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

    }

    @Test
    @TestOrder(59)
    @Transactional
    public void testExec_A6_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {

        try {

            getSkChannelInfo.exec(null, "");
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。", "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(69)
    @Transactional
    public void testExec_A7_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }


    @Test
    @TestOrder(70)
    public void testExec_A7() {

        getSkChannelInfo.exec(null, "2101123");

        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN, "帳票連絡先識別区分");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

        exClassificationEquals(getSkChannelInfo.getSkeiJimuKbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(getSkChannelInfo.getAisyoumeiChannelKbn(), C_AisyoumeiChannelKbn.SMBCNIKKOU, "愛称名チャネル区分");
        exClassificationEquals(getSkChannelInfo.getKiteichkchannelcd(), C_Channelcd.MIZUHO, "規定チェック用チャネルコード取得");
        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN,
            "帳票連絡先識別区分");
        exNumericEquals(getSkChannelInfo.getSortNo(), 1, "ソート番号");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8900", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2100", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");
    }

    @Test
    @TestOrder(71)
    @Transactional
    public void testExec_A8_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(72)
    public void testExec_A8() {

        getSkChannelInfo.exec(C_Channelcd.SONOTAMADOHAN, "MS123");

        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN, "帳票連絡先識別区分");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8901", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2101", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");

        exClassificationEquals(getSkChannelInfo.getSkeiJimuKbn(), C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(getSkChannelInfo.getAisyoumeiChannelKbn(), C_AisyoumeiChannelKbn.SMBCNIKKOU, "愛称名チャネル区分");
        exClassificationEquals(getSkChannelInfo.getKiteichkchannelcd(), C_Channelcd.TIGIN, "規定チェック用チャネルコード取得");
        exClassificationEquals(getSkChannelInfo.getTyhyrenrakusikibetukbn(),
            C_TyhyrenrakusikibetuKbn.MADOHAN_TIGINSINKIN,
            "帳票連絡先識別区分");
        exNumericEquals(getSkChannelInfo.getSortNo(), 1, "ソート番号");
        exStringEquals(getSkChannelInfo.getCctelno(), "123-4567-8901", "コールセンター電話番号");
        exStringEquals(getSkChannelInfo.getCcimagepath(), "Abc", "コールセンター画像パス");
        exStringEquals(getSkChannelInfo.getSapodetelno(), "987-6543-2101", "サポートデスク電話番号");
        exStringEquals(getSkChannelInfo.getSapodeimagepath(), "Cba", "サポートデスク画像パス");
        exStringEquals(getSkChannelInfo.getSapodefaxno(), "987-6543-0001", "サポートデスクＦＡＸ番号");
    }
}