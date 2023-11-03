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
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 差異データ登録のメソッド {@link SaiDataTouroku#registerSaiDataKokutisyo(
 * SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParam, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaiDataTourokuTest_registerSaiDataKokutisyo {

    private static final String SOUSASYACD = "sousasyatest";
    private static final String SYSDATE = "20160420";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_差異データ登録";

    private final static String sheetName = "INデータ";

    @Inject
    private SaiDataTouroku saiDataTouroku;

    @Inject
    private SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaiDataTourokuTest_registerSaiDataKokutisyo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap, true);
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
    @TestOrder(10)
    @Transactional
    public void testRegisterSaiDataKokutisyo_A1() {
        uiBean.setMosno("861110005");
        try {
            saiDataTouroku.registerSaiDataKokutisyo(uiBean, SOUSASYACD, SYSDATE);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110005", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testRegisterSaiDataKokutisyo_B1() {
        String mosNo = "861110013";
        uiBean.setMosno(mosNo);
        uiBean.setKktymd(BizDate.valueOf(20160418));
        uiBean.setSintyou(160);
        uiBean.setTaijyuu(50);
        uiBean.setKijikbn(C_KijiKbn.ARI);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataKokutisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_KOKUTISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testRegisterSaiDataKokutisyo_B2() {
        String mosNo = "861110021";
        uiBean.setMosno(mosNo);
        uiBean.setKktymd(BizDate.valueOf(20160418));
        uiBean.setSintyou(160);
        uiBean.setTaijyuu(50);
        uiBean.setKijikbn(C_KijiKbn.ARI);
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataKokutisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_KOKUTISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 4, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110021", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "KOKUTISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "告知日", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "2016. 4.19", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "2016. 4.18", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "身長", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "170", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "160", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "体重", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "55", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "50", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "詳細記事区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "なし", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "あり", "２次入力");
    }
}