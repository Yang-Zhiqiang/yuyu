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
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
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
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 差異データ登録のメソッド {@link SaiDataTouroku#registerSaiDataMousikomisyo(
 * SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaiDataTourokuTest_registerSaiDataMousikomisyo_hosoku extends AbstractTest{

    private static final String SOUSASYACD = "sousasyatest";
    private static final String SYSDATE = "20160420";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_差異データ登録";

    private final static String sheetName = "INデータ (ケース補足)";

    @Inject
    private SaiDataTouroku saiDataTouroku;

    @Inject
    private SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaiDataTourokuTest_registerSaiDataMousikomisyo_hosoku.class, fileName, sheetName);
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
    @TestOrder(110)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A1() {
        String mosNo = "861110005";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.BLNK);
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
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 14, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110005", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "指定通貨建年金保険定期支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "支払金指定口座情報入力保留", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "保留", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "定期支払金支払通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "円貨", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "支払金指定口座情報銀行コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "0001", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "支払金指定口座情報支店コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "001", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "支払金指定口座情報預金種目", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "普通", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "支払金指定口座情報口座番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "1234567", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "支払金指定口座情報口座名義人同一区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "同一", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "指定", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "支払金指定口座情報口座名義人", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "あああ　ああああ", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "１０５％", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "初期死亡時円換算支払額最低保証特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "付加する", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "重度介護前払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "付加する", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "年金支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "付加する", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "年金支払特約期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "1", "２次入力");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A2() {
        String mosNo = "861110013";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.NONE);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.TOUZA);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET110);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 8, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110013", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "指定通貨建年金保険定期支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "付加しない", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "支払金指定口座情報入力保留", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "保留", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "定期支払金支払通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "円貨", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "指定通貨", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "支払金指定口座情報預金種目", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "普通", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "当座", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "１０５％", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "１１０％", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "初期死亡時円換算支払額最低保証特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "重度介護前払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "年金支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "付加しない", "２次入力");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A3() {
        String mosNo = "861110021";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET120);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 7, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110021", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "指定通貨建年金保険定期支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "定期支払金支払通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "指定通貨", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "支払金指定口座情報預金種目", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "当座", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "１１０％", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "１２０％", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "初期死亡時円換算支払額最低保証特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "重度介護前払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "年金支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "", "２次入力");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A4() {
        String mosNo = "861110039";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET130);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110039", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１２０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１３０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A5() {
        String mosNo = "861110047";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET140);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110047", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１３０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１４０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A6() {
        String mosNo = "861110054";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET150);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110054", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１４０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１５０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A7() {
        String mosNo = "861110062";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET160);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110062", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１５０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１６０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A8() {
        String mosNo = "861110070";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET170);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110070", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１６０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１７０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A9() {
        String mosNo = "861110088";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET180);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110088", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１７０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１８０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A10() {
        String mosNo = "861110096";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET190);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110096", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１８０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "１９０％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A11() {
        String mosNo = "861110104";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET200);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110104", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "１９０％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "２００％", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A12() {
        String mosNo = "861110112";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110112", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "２００％", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "設定しない", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A13() {
        String mosNo = "861110120";
        uiBean.setMosno(mosNo);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("0001");
        uiBean.setSitencd("001");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("1234567");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("あああ　ああああ");
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.BLNK);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstkhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setNstksbnkkn(10);

        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110120", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "設定しない", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A14() {
        String mosNo = "861110138";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.HGU);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("100-0001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 21, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110138", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "ご家族登録サービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "申し込む", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "登録家族名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "アアア　アアアア", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "登録家族名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "あああ　ああああ", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "登録家族名漢字化不可", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "登録家族生年月日", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "S45. 1. 1", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "登録家族性別", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "男性", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "配偶者", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "登録家族通信先同一指定区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "指定あり", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "登録家族郵便番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "100-0001", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "登録家族住所１（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "東京都千代田区", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "登録家族住所２（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "千代田", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "登録家族住所３（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "０００１", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "登録家族電話番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "03-0000-0001", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "被保険者代理特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "付加する", "２次入力");
        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "登録家族１人目と同じ", "２次入力");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "被保険者代理人氏名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "イイイ　イイイイ", "２次入力");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "被保険者代理人氏名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "いいい　いいいい", "２次入力");
        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "被保険者代理人名漢字化不可区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "被保険者代理人生年月日", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "S45. 1. 2", "２次入力");
        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "配偶者", "２次入力");
        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "ダイレクトサービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "申し込む", "２次入力");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A15() {
        String mosNo = "861110146";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.NONE);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.FEMALE);
        uiBean.setTrkkzktdk1(C_Tdk.KO);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.KO);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 7, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110146", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "ご家族登録サービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "申し込む", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "申し込まない", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "登録家族性別", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "男性", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "女性", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "配偶者", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "子", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "被保険者代理特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "登録家族１人目と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "登録家族２人目と同じ", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "配偶者", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "子", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "ダイレクトサービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "申し込む", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "申し込まない", "２次入力");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A16() {
        String mosNo = "861110153";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.BLNK);
        uiBean.setTrkkzktdk1(C_Tdk.MAGO);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.KYK);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.OYA);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 7, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110153", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "ご家族登録サービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "申し込まない", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "登録家族性別", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "女性", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "子", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "孫", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "被保険者代理特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "登録家族２人目と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "契約者と同じ", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "子", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "親", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "ダイレクトサービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "申し込まない", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "後続事務で確認", "２次入力");
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A17() {
        String mosNo = "861110161";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.KYDSM);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.MAGO);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 4, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110161", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "孫", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "兄弟姉妹", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "契約者と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "特定名義", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "親", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "孫", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "ダイレクトサービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "後続事務で確認", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "", "２次入力");
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A18() {
        String mosNo = "861110179";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.OIMEI);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.SHB);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 3, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110179", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "兄弟姉妹", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "特定名義", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "孫", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "祖父母", "２次入力");
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A19() {
        String mosNo = "861110187";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.KYDSM);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110187", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "祖父母", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "兄弟姉妹", "２次入力");
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A20() {
        String mosNo = "861110195";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.SINTOU3);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110195", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "兄弟姉妹", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "３親等の親族", "２次入力");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A21() {
        String mosNo = "861110203";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.SONOTA);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.SONOTA);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 2, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110203", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "親", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "その他", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "３親等の親族", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "その他", "２次入力");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_hosoku_A22() {
        String mosNo = "861110211";
        uiBean.setMosno(mosNo);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("アアア　アアアア");
        uiBean.setTrkkzknmkj1("あああ　ああああ");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf(19700101));
        uiBean.setTrkkzksei1(C_Seibetu.MALE);
        uiBean.setTrkkzktdk1(C_Tdk.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.ARI);
        uiBean.setTrkkzkyno1("1000001");
        uiBean.setTrkkzkadr1kj1("東京都千代田区");
        uiBean.setTrkkzkadr2kj1("千代田");
        uiBean.setTrkkzkadr3kj1("０００１");
        uiBean.setTrkkzktelno1("03-0000-0001");
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setSiteidruktnmkn("イイイ　イイイイ");
        uiBean.setSiteidruktnmkj("いいい　いいいい");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrskseiymd(BizDate.valueOf(19700102));
        uiBean.setStdrsktdk(C_Tdk.BLNK);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        BizPropertyInitializer.initialize(uiBean);

        changeSystemDate(BizDate.valueOf(20180323));

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 2, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "その他", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "その他", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");
    }

}