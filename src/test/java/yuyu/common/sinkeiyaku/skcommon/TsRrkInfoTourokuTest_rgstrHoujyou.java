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
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 訂正履歴情報登録のメソッド {@link TsRrkInfoTouroku#rgstrHoujyou(
 * TsRrkInfoTourokuRgstrHoujyouUiBeanParam, String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TsRrkInfoTourokuTest_rgstrHoujyou {

    private static final String SYSTIME = "20160429100000001";
    private static final String SOUSASYACD = "sousasyatest";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_訂正履歴情報登録";

    private final static String sheetName = "INデータ";

    @Inject
    private TsRrkInfoTouroku tsRrkInfoTouroku;

    @Inject
    private TsRrkInfoTourokuRgstrHoujyouUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(TsRrkInfoTourokuTest_rgstrHoujyou.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap, true);
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
    public void testRgstrHoujyou_A1() {
        uiBean.setMosno("861110005");
        try {
            tsRrkInfoTouroku.rgstrHoujyou(uiBean, SYSTIME, "houjyou", "houjyou_upd_syosin", SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110005", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(120)
    @Transactional
    public void testRgstrHoujyou_A2() {
        uiBean.setMosno("861110013");
        try {
            tsRrkInfoTouroku.rgstrHoujyou(uiBean, SYSTIME, "houjyou", "houjyou_upd_saisin", SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110013", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testRgstrHoujyou_B1() {
        String mosno = "861110021";
        uiBean.setMosno(mosno);
        uiBean.setSyosaikbn(C_SyosaiKbn.SOYSIN);
        uiBean.setKktymd(BizDate.valueOf(20160418));
        uiBean.setSintyou(160);
        uiBean.setTaijyuu(50);
        uiBean.setSinsakbn(C_SinsaKbn.SYAI_SYOKUTAKUI);
        uiBean.setSinsaymd(BizDate.valueOf(20160501));
        uiBean.setHbcmnt("不備コメント１");
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrHoujyou(uiBean, SYSTIME, "houjyou", "houjyou_upd_saisin", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testRgstrHoujyou_B2() {
        String mosno = "861110039";
        uiBean.setMosno(mosno);
        uiBean.setSyosaikbn(C_SyosaiKbn.SOYSIN);
        uiBean.setKktymd(BizDate.valueOf(20160420));
        uiBean.setSintyou(165);
        uiBean.setTaijyuu(55);
        uiBean.setSinsakbn(C_SinsaKbn.KNKSINDANKEKKATUUTIS);
        uiBean.setSinsaymd(BizDate.valueOf(20160602));
        uiBean.setHbcmnt("不備コメント１２");
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrHoujyou(uiBean, SYSTIME, "houjyou", "houjyou_upd_syosin", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 6, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110039", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "houjyou", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "houjyou_upd_syosin", "機能モードＩＤ");
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
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "診査区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "人間ドック", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "健康診断結果通知書", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "診査日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "2016. 5. 2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "2016. 6. 2", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "不備コメント", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "入力なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "入力あり", "訂正後内容");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testRgstrHoujyou_B3() {
        String mosno = "861110047";
        uiBean.setMosno(mosno);
        uiBean.setSyosaikbn(C_SyosaiKbn.SAISIN);
        uiBean.setSinsakbn(C_SinsaKbn.KNKSINDANKEKKATUUTIS);
        uiBean.setSinsaymd(BizDate.valueOf(20160503));
        uiBean.setHbcmnt("不備コメント３");
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrHoujyou(uiBean, SYSTIME, "houjyou", "houjyou_upd_saisin", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testRgstrHoujyou_B4() {
        String mosno = "861110054";
        uiBean.setMosno(mosno);
        uiBean.setSyosaikbn(C_SyosaiKbn.SAISIN);
        uiBean.setSinsakbn(C_SinsaKbn.SYAI_SYOKUTAKUI);
        uiBean.setSinsaymd(BizDate.valueOf(20160604));
        uiBean.setHbcmnt("");
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrHoujyou(uiBean, SYSTIME, "houjyou", "houjyou_upd_saisin", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 3, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110054", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "houjyou", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "houjyou_upd_saisin", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "診査区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "健康管理証明書", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "社医・嘱託医", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "診査日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "2016. 5. 4", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "2016. 6. 4", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "不備コメント", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "入力あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "入力なし", "訂正後内容");
    }
}