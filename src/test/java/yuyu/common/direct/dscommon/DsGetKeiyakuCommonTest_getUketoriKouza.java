package yuyu.common.direct.dscommon;

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
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getUketoriKouza(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getUketoriKouza extends AbstractTest {

    private final static String SYONO1 = "99806001010";
    private final static String SYONO2 = "99806001021";
    private final static String SYONO3 = "99806001032";
    private final static String SYONO4 = "99806001043";
    private final static String SYONO5 = "99806001054";
    private final static String SYONO6 = "99806001065";
    private final static String SYONO7 = "99806001076";

    @Inject
    private DsGetKeiyakuCommon dsGetKeiyakuCommon;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ契約共通情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuCommonTest_getKykKihon.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testGetUketoriKouza_A1() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO1);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(uktKzBeanLst.size(), 0, "受取口座情報Beanリストのサイズ");
    }

    @Test
    @TestOrder(20)
    public void testGetUketoriKouza_A2() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO2);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(uktKzBeanLst.size(), 0, "受取口座情報Beanリストのサイズ");
    }

    @Test
    @TestOrder(30)
    public void testGetUketoriKouza_A3() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO3);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(uktKzBeanLst.size(), 0, "受取口座情報Beanリストのサイズ");
    }

    @Test
    @TestOrder(40)
    public void testGetUketoriKouza_A4() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO4);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(uktKzBeanLst.size(), 0, "受取口座情報Beanリストのサイズ");
    }

    @Test
    @TestOrder(50)
    public void testGetUketoriKouza_A5() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO5);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(uktKzBeanLst.size(), 0, "受取口座情報Beanリストのサイズ");
    }

    @Test
    @TestOrder(60)
    public void testGetUketoriKouza_A6() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO6);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(uktKzBeanLst.size(), 1, "受取口座情報Beanリストのサイズ");

        exClassificationEquals(uktKzBeanLst.get(0).getUktsyuKbn(), C_UktsyuKbn.TKSHKUKT, "受取人種類区分");
        exClassificationEquals(uktKzBeanLst.get(0).getKzsyuruiKbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(uktKzBeanLst.get(0).getBankCd(), "0010", "銀行コード");
        exStringEquals(uktKzBeanLst.get(0).getSitenCd(), "005", "支店コード");
        exStringEquals(uktKzBeanLst.get(0).getBankNmkj(), "りそな銀行", "銀行コード");
        exStringEquals(uktKzBeanLst.get(0).getSitenNmkj(), "天理支店", "支店コード");
        exClassificationEquals(uktKzBeanLst.get(0).getYokinKbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(uktKzBeanLst.get(0).getKouzaNo(), "1234567", "口座番号");
        exStringEquals(uktKzBeanLst.get(0).getKzmeigiNmkn(), "シメイ　カナ", "口座名義人氏名（カナ）");
    }

    @Test
    @TestOrder(70)
    public void testGetUketoriKouza_A7() {
        C_ErrorKbn kekkaKbn = dsGetKeiyakuCommon.getUketoriKouza(SYONO7);
        List<UketoriKouzaBean> uktKzBeanLst = dsGetKeiyakuCommon.getUketoriKouzaBeanList();

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(uktKzBeanLst.size(), 3, "受取口座情報Beanリストのサイズ");
        exClassificationEquals(uktKzBeanLst.get(0).getUktsyuKbn(), C_UktsyuKbn.TKSHKUKT, "受取人種類区分");
        exClassificationEquals(uktKzBeanLst.get(0).getKzsyuruiKbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(uktKzBeanLst.get(0).getBankCd(), "0010", "銀行コード");
        exStringEquals(uktKzBeanLst.get(0).getSitenCd(), "055", "支店コード");
        exStringEquals(uktKzBeanLst.get(0).getBankNmkj(), "りそな銀行", "銀行コード");
        exStringEquals(uktKzBeanLst.get(0).getSitenNmkj(), "ＪＲ西日本出張所", "支店コード");
        exClassificationEquals(uktKzBeanLst.get(0).getYokinKbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(uktKzBeanLst.get(0).getKouzaNo(), "1234565", "口座番号");
        exStringEquals(uktKzBeanLst.get(0).getKzmeigiNmkn(), "シメイ　イチ", "口座名義人氏名（カナ）");
        exClassificationEquals(uktKzBeanLst.get(1).getUktsyuKbn(), C_UktsyuKbn.TKSHKUKT, "受取人種類区分");
        exClassificationEquals(uktKzBeanLst.get(1).getKzsyuruiKbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(uktKzBeanLst.get(1).getBankCd(), "0130", "銀行コード");
        exStringEquals(uktKzBeanLst.get(1).getSitenCd(), "041", "支店コード");
        exStringEquals(uktKzBeanLst.get(1).getBankNmkj(), "常陽銀行", "銀行コード");
        exStringEquals(uktKzBeanLst.get(1).getSitenNmkj(), "笠間支店", "支店コード");
        exClassificationEquals(uktKzBeanLst.get(1).getYokinKbn(), C_YokinKbn.TOUZA, "預金種目区分");
        exStringEquals(uktKzBeanLst.get(1).getKouzaNo(), "1234566", "口座番号");
        exStringEquals(uktKzBeanLst.get(1).getKzmeigiNmkn(), "シメイ　ニ", "口座名義人氏名（カナ）");
        exClassificationEquals(uktKzBeanLst.get(2).getUktsyuKbn(), C_UktsyuKbn.TKSHKUKT, "受取人種類区分");
        exClassificationEquals(uktKzBeanLst.get(2).getKzsyuruiKbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(uktKzBeanLst.get(2).getBankCd(), "1111", "銀行コード");
        exStringEquals(uktKzBeanLst.get(2).getSitenCd(), "111", "支店コード");
        exStringEquals(uktKzBeanLst.get(2).getBankNmkj(), "金融機関コード1111", "銀行コード");
        exStringEquals(uktKzBeanLst.get(2).getSitenNmkj(), "支店コード111", "支店コード");
        exClassificationEquals(uktKzBeanLst.get(2).getYokinKbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(uktKzBeanLst.get(2).getKouzaNo(), "1234567", "口座番号");
        exStringEquals(uktKzBeanLst.get(2).getKzmeigiNmkn(), "シメイ　サン", "口座名義人氏名（カナ）");
    }
}
