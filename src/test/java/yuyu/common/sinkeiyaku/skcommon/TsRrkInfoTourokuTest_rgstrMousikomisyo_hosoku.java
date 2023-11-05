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
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 訂正履歴情報登録のメソッド {@link TsRrkInfoTouroku#rgstrMousikomisyo(
 * TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam, String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TsRrkInfoTourokuTest_rgstrMousikomisyo_hosoku {

    private static final String SYSTIME = "20160429100000001";
    private static final String SOUSASYACD = "sousasyatest";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_訂正履歴情報登録";

    private final static String sheetName = "INデータ (ケース補足)";

    @Inject
    private TsRrkInfoTouroku tsRrkInfoTouroku;

    @Inject
    private TsRrkInfoTourokuRgstrMousikomisyoUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(TsRrkInfoTourokuTest_rgstrMousikomisyo.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap, true);
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

    @Test
    @TestOrder(10)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A1() {
        String mosno = "860000017";
        uiBean.setMosno(mosno);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.HUTUU);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET105);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstksbnkkn(1);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 13, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000017", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "指定通貨建年金保険定期支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "付加する", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "定期支払金支払通貨", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "円貨", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "支払金指定口座情報銀行コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "0001", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "支払金指定口座情報支店コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "001", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "支払金指定口座情報預金種目", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "普通", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "支払金指定口座情報口座番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "1234567", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "支払金指定口座情報口座名義人同一区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "同一", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "指定", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "支払金指定口座情報口座名義人", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "あああ　ああああ", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "１０５％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "初期死亡時円換算支払額最低保証特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "付加する", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "重度介護前払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "付加する", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "年金支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "付加する", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "年金支払特約期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "1", "訂正後内容");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A2() {
        String mosno = "860000025";
        uiBean.setMosno(mosno);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.NONE);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        uiBean.setYokinkbn(C_YokinKbn.TOUZA);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET110);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 7, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000025", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "指定通貨建年金保険定期支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "付加しない", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "定期支払金支払通貨", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "円貨", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "指定通貨", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "支払金指定口座情報預金種目", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "普通", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "当座", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "１０５％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "１１０％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "初期死亡時円換算支払額最低保証特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "付加しない", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "重度介護前払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "付加しない", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "年金支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "付加しない", "訂正後内容");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A3() {
        String mosno = "860000033";
        uiBean.setMosno(mosno);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET120);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 7, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000033", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "指定通貨建年金保険定期支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "定期支払金支払通貨", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "指定通貨", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "支払金指定口座情報預金種目", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "当座", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "１１０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "１２０％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "初期死亡時円換算支払額最低保証特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "重度介護前払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "年金支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "", "訂正後内容");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A4() {
        String mosno = "860000041";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET130);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000041", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１２０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１３０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A5() {
        String mosno = "860000058";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET140);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000058", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１３０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１４０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A6() {
        String mosno = "860000066";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET150);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000066", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１４０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１５０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A7() {
        String mosno = "860000074";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET160);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000074", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１５０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１６０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A8() {
        String mosno = "860000082";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET170);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000082", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１６０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１７０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A9() {
        String mosno = "860000090";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET180);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000090", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１７０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１８０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A10() {
        String mosno = "860000108";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET190);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000108", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１８０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "１９０％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A11() {
        String mosno = "860000116";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET200);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000116", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "１９０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "２００％", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A12() {
        String mosno = "860000124";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000124", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "２００％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "設定しない", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A13() {
        String mosno = "860000132";
        uiBean.setMosno(mosno);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.BLNK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000132", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "設定しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A14() {
        String mosno = "860000140";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf("19700101"));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.HGU);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("100-0001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzktelno1("03-0000-0001");

        uiBean.setTrkkzknmkn2("イイイ　イイイイ");
        uiBean.setTrkkzknmkj2("いいい　いいいい");
        uiBean.setTrkkzknmkjkhukakbn2(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd2(BizDate.valueOf("19700102"));
        uiBean.setTrkkzksei2(C_Seibetu.MALE);
        uiBean.setTrkkzktdk2(C_Tdk.HGU);
        uiBean.setTrkkzktsindousiteikbn2(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno2("100-0002");
        uiBean.setTrkkzkadr1kj2("東京都千代田区");
        uiBean.setTrkkzktelno2("03-0000-0002");

        uiBean.setKykdrtkykhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKykdrkbn(C_UktKbn.TOUROKUKAZOKU1);

        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setSiteidruktnmkn("エエエ　エエエエ");
        uiBean.setSiteidruktnmkj("えええ　ええええ");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf("19700104"));
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 31, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000140", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "ご家族登録サービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "申し込む", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族氏名（カナ）１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "アアア　アアアア", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "登録家族氏名（漢字）１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "あああ　ああああ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "登録家族名漢字化不可１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "漢字化不可", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "登録家族生年月日１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "S45. 1. 1", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "登録家族性別１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "男性", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "配偶者", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "登録家族通信先同一指定１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "指定あり", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "登録家族郵便番号１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "100-0001", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "登録家族住所１（漢字）１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "東京都千代田区", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "登録家族通信先電話番号１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "03-0000-0001", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "登録家族氏名（カナ）２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "イイイ　イイイイ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "登録家族氏名（漢字）２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "いいい　いいいい", "訂正後内容");


        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "登録家族名漢字化不可２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "漢字化不可", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "登録家族生年月日２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "S45. 1. 2", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "登録家族性別２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "男性", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "配偶者", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "登録家族通信先同一指定２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "指定あり", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "登録家族郵便番号２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "100-0002", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "登録家族住所１（漢字）２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "東京都千代田区", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "登録家族通信先電話番号２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "03-0000-0002", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "保険契約者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "付加する", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(22).getTskmnm(), "契約者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(22).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(22).getTsgonaiyou(), "登録家族１人目と同じ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(23).getTskmnm(), "被保険者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(23).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(23).getTsgonaiyou(), "付加する", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(24).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(24).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(24).getTsgonaiyou(), "登録家族１人目と同じ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(25).getTskmnm(), "被保険者代理人氏名（カナ）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(25).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(25).getTsgonaiyou(), "エエエ　エエエエ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(26).getTskmnm(), "被保険者代理人氏名（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(26).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(26).getTsgonaiyou(), "えええ　ええええ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(27).getTskmnm(), "被保険者代理人名漢字化不可区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(27).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(27).getTsgonaiyou(), "漢字化不可", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(28).getRenno3keta(), 29, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(28).getTskmnm(), "被保険者代理人生年月日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(28).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(28).getTsgonaiyou(), "S45. 1. 4", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(29).getRenno3keta(), 30, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(29).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(29).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(29).getTsgonaiyou(), "配偶者", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(30).getRenno3keta(), 31, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(30).getTskmnm(), "ダイレクトサービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(30).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(30).getTsgonaiyou(), "申し込む", "訂正後内容");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A15() {
        String mosno = "860000157";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.NONE);
        uiBean.setTrkkzksei1(C_Seibetu.FEMALE);
        uiBean.setTrkkzktdk1(C_Tdk.KO);
        uiBean.setTrkkzkadr2kj1("千代田");

        uiBean.setTrkkzksei2(C_Seibetu.FEMALE);
        uiBean.setTrkkzktdk2(C_Tdk.KO);
        uiBean.setTrkkzkadr2kj2("皇居外延");

        uiBean.setKykdrtkykhukakbn(C_Tkhukaumu.NONE);
        uiBean.setKykdrkbn(C_UktKbn.TOUROKUKAZOKU2);

        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        uiBean.setStdrsktdk(C_Tdk.KO);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 13, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000157", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "ご家族登録サービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "申し込む", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "申し込まない", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族性別１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "男性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "女性", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "配偶者", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "子", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "登録家族住所２（漢字）１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "千代田", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "登録家族性別２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "男性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "女性", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "配偶者", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "子", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "登録家族住所２（漢字）２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "皇居外延", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "保険契約者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "付加しない", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "契約者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "登録家族１人目と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "登録家族２人目と同じ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "被保険者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "付加しない", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "登録家族１人目と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "登録家族２人目と同じ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "配偶者", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "子", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "ダイレクトサービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "申し込む", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "申し込まない", "訂正後内容");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A16() {
        String mosno = "860000165";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzksei1(C_Seibetu.BLNK);
        uiBean.setTrkkzktdk1(C_Tdk.MAGO);
        uiBean.setTrkkzkadr3kj1("０００１");

        uiBean.setTrkkzksei2(C_Seibetu.BLNK);
        uiBean.setTrkkzktdk2(C_Tdk.MAGO);
        uiBean.setTrkkzkadr3kj2("０００２");

        uiBean.setKykdrtkykhukakbn(C_Tkhukaumu.BLNK);
        uiBean.setKykdrkbn(C_UktKbn.TOKUTEIMEIGI);

        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.KYK);
        uiBean.setStdrsktdk(C_Tdk.OYA);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 13, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000165", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "ご家族登録サービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "申し込まない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族性別１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "女性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "子", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "孫", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "登録家族住所３（漢字）１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "０００１", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "登録家族性別２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "女性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "子", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "孫", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "登録家族住所３（漢字）２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "０００２", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "保険契約者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "契約者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "登録家族２人目と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "被保険者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "登録家族２人目と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "契約者と同じ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "子", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "親", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "ダイレクトサービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "申し込まない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "後続事務で確認", "訂正後内容");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A17() {
        String mosno = "860000173";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setTrkkzktdk1(C_Tdk.KYDSM);
        uiBean.setTrkkzktdk2(C_Tdk.KYDSM);
        uiBean.setKykdrkbn(C_UktKbn.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setStdrsktdk(C_Tdk.MAGO);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 5, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000173", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "孫", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "兄弟姉妹", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "孫", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "兄弟姉妹", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "契約者と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "特定名義", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "親", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "孫", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "ダイレクトサービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "後続事務で確認", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "", "訂正後内容");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A18() {
        String mosno = "860000181";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setTrkkzktdk1(C_Tdk.OIMEI);
        uiBean.setTrkkzktdk2(C_Tdk.OIMEI);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.SHB);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 4, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000181", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "兄弟姉妹", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "兄弟姉妹", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "特定名義", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "孫", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "祖父母", "訂正後内容");

    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A19() {
        String mosno = "860000199";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setTrkkzktdk1(C_Tdk.BLNK);
        uiBean.setTrkkzktdk2(C_Tdk.BLNK);
        uiBean.setStdrsktdk(C_Tdk.KYDSM);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000199", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "祖父母", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "兄弟姉妹", "訂正後内容");

    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A20() {
        String mosno = "860000207";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setTrkkzktdk1(C_Tdk.OYA);
        uiBean.setTrkkzktdk2(C_Tdk.OYA);

        uiBean.setStdrsktdk(C_Tdk.SINTOU3);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000207", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "兄弟姉妹", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "３親等の親族", "訂正後内容");

    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A21() {
        String mosno = "860000215";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setTrkkzktdk1(C_Tdk.SONOTA);
        uiBean.setTrkkzktdk2(C_Tdk.SONOTA);
        uiBean.setStdrsktdk(C_Tdk.SONOTA);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 3, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000215", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "親", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "その他", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "親", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "その他", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "３親等の親族", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "その他", "訂正後内容");

    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testRgstrMousikomisyo_hosoku_A22() {
        String mosno = "860000223";
        uiBean.setMosno(mosno);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setTrkkzktdk1(C_Tdk.BLNK);
        uiBean.setTrkkzktdk2(C_Tdk.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 3, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000223", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "登録家族続柄１", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "その他", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族続柄２", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "その他", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "その他", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "", "訂正後内容");

    }
}
