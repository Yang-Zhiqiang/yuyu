package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 訂正履歴情報登録のメソッド {@link TsRrkInfoTouroku#rgstrKokutisyo(
 * TsRrkInfoTourokuRgstrKokutisyoUiBeanParam, String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TsRrkInfoTourokuTest_rgstrKokutisyo {

    private static final String SYSTIME = "20160429100000001";
    private static final String KINOUID = "TsRrkInfoTouroku";
    private static final String KINOUMODEID = "skcommon";
    private static final String SOUSASYACD = "sousasyatest";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_訂正履歴情報登録";

    private final static String sheetName = "INデータ";

    @Inject
    private TsRrkInfoTouroku tsRrkInfoTouroku;

    @Inject
    private TsRrkInfoTourokuRgstrKokutisyoUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(TsRrkInfoTourokuTest_rgstrKokutisyo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap, true);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(110)
    @Transactional
    public void testRgstrKokutisyo_A1() {
        uiBean.setMosno("861110005");
        try {
            tsRrkInfoTouroku.rgstrKokutisyo(uiBean, SYSTIME, KINOUID, KINOUMODEID, SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110005", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(120)
    @Transactional
    public void testRgstrKokutisyo_A2() {
        uiBean.setMosno("861110013");
        try {
            tsRrkInfoTouroku.rgstrKokutisyo(uiBean, SYSTIME, KINOUID, KINOUMODEID, SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110013", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testRgstrKokutisyo_B1() {
        String mosno = "861110021";
        uiBean.setMosno(mosno);
        uiBean.setKktymd(BizDate.valueOf(20160418));
        uiBean.setSintyou(160);
        uiBean.setTaijyuu(50);
        uiBean.setKijikbn(C_KijiKbn.ARI);
        uiBean.setHbcmnt("不備コメント１");
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrKokutisyo(uiBean, SYSTIME, KINOUID, KINOUMODEID, SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testRgstrKokutisyo_B2() {
        String mosno = "861110039";
        uiBean.setMosno(mosno);
        uiBean.setKktymd(BizDate.valueOf(20160420));
        uiBean.setSintyou(165);
        uiBean.setTaijyuu(55);
        uiBean.setKijikbn(C_KijiKbn.ARI);
        uiBean.setHbcmnt("");
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrKokutisyo(uiBean, SYSTIME, KINOUID, KINOUMODEID, SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 5, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110039", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "TsRrkInfoTouroku", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "skcommon", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "告知日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "2016. 4.19", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "2016. 4.20", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "身長", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "170", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "165", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "体重", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "60", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "55", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "詳細記事有無", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "あり", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "不備コメント", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "入力あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "入力なし", "訂正後内容");
    }
}