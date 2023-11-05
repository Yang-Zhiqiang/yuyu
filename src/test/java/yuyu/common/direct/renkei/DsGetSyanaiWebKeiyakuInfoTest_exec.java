package yuyu.common.direct.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.direct.dscommon.CheckKaiyakuUketuke;
import yuyu.common.direct.dscommon.CheckKaiyakuUketukeMockForDirect;
import yuyu.def.biz.bean.webservice.IwssnSyanaiDsInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ダイレクトサービス ダイレクトサービス共通 社内Web用DS契約内容情報取得クラスのメソッド
 *  {@link DsGetSyanaiWebKeiyakuInfo#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetSyanaiWebKeiyakuInfoTest_exec extends AbstractTest {

    private final static String syoNo1 = "99806001010";

    private final static String syoNo2 = "99806001021";

    private final static String syoNo3 = "99806001032";

    private final static String syoNo4 = "99806001043";

    private final static String syoNo5 = "99806001054";

    private final static String syoNo6 = "99806001065";

    private final static String syoNo7 = "99806001076";

    private final static String syoNo8 = "99806001087";

    private final static String syoNo9 = "99806001098";

    private final static String syoNo10 = "99806001102";

    private final static String syoNo11 = "99806001113";

    private final static String syoNo12 = "99806001124";

    private final static String syoNo13 = "99806001135";

    private final static String syoNo14 = "99806000248";

    private final static String syoNo15 = "99806000259";

    private final static String syoNo16 = "99806000260";

    private final static String syoNo17 = "99806000282";

    @Inject
    private DsGetSyanaiWebKeiyakuInfo dsGetSyanaiWebKeiyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_社内Web用DS契約内容情報取得";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckKaiyakuUketuke.class).to(CheckKaiyakuUketukeMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        CheckKaiyakuUketukeMockForDirect.caller = DsGetSyanaiWebKeiyakuInfoTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        CheckKaiyakuUketukeMockForDirect.caller = null;
        CheckKaiyakuUketukeMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetSyanaiWebKeiyakuInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo1);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000000", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), "123456789@123.com", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "1", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "有効取引中", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "1", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), " ", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "　", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), "123412341234", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), "ｶﾅ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "ゆうちょ銀行", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "神保町支店", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "普通", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "1", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "円口座", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), "0009", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), "001", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), "1", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), "1", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "同一", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo2);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000001", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), "123456789@124.com", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "2", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "一時停止", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191011", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "1", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), " ", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "　", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), "123412341234", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), "ｶﾅ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "普通", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "1", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "円口座", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), null, "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), "002", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), "1", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), "1", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "同一", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo3);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000002", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "1", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "有効取引中", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191012", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), "123412341234", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), "ｶﾅ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "当座", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "1", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "円口座", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), "0011", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), null, "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), "2", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), "2", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "指定", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo4);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000003", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "2", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "一時停止", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191013", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo5);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo6);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo7);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo8);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo9);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo10);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo11);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000010", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), "123456789@133.com", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "1", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "有効取引中", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191020", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "1", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), " ", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "　", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo12);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000011", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), "999999999@134.com", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "1", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "有効取引中", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191021", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "99", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "システムエラー", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo13);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000012", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), "999999999@134.com", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "1", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "有効取引中", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191022", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo14);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }
    @Test
    @TestOrder(150)
    public void testExec_A15() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo15);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN3;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo16);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "0", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), " ", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), " ", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "00000000", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "0", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "不可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), "01", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "稼動時間外", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        CheckKaiyakuUketukeMockForDirect.SYORIPTN = CheckKaiyakuUketukeMockForDirect.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = dsGetSyanaiWebKeiyakuInfo.exec(syoNo17);
        IwssnSyanaiDsInfoOutputBean infoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(infoOutputBean.getIwssnDsokyksmno(), "1100000016", "（ＩＷＳＳＮ）ＤＳお客さま番号");
        exStringEquals(infoOutputBean.getIwssnDsmailaddress(), "123456789@133.com", "（ＩＷＳＳＮ）ＤＳメールアドレス");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbn(), "1", "（ＩＷＳＳＮ）ＤＳ顧客状態区分");
        exStringEquals(infoOutputBean.getIwssnDskokyakujtkbnnm(), "有効取引中", "（ＩＷＳＳＮ）ＤＳ顧客状態（区分名称）");
        exStringEquals(infoOutputBean.getIwssnKaripasswordhkymd(), "20191020", "（ＩＷＳＳＮ）仮パス発行日");
        exStringEquals(infoOutputBean.getIwssnTelttdkkahikbn(), "1", "（ＩＷＳＳＮ）電話手続可否区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkahikbnnm(), "可", "（ＩＷＳＳＮ）電話手続可否（区分名称）");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbn(), " ", "（ＩＷＳＳＮ）電話手続不可理由区分");
        exStringEquals(infoOutputBean.getIwssnTelttdkhukariyuukbnnm(), "　", "（ＩＷＳＳＮ）電話手続不可理由（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskouzano(), " ", "（ＩＷＳＳＮ）ＤＳ口座番号");
        exStringEquals(infoOutputBean.getIwssnDskzmeigii(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人");
        exStringEquals(infoOutputBean.getIwssnDskinyunm(), "　", "（ＩＷＳＳＮ）ＤＳ金融機関名");
        exStringEquals(infoOutputBean.getIwssnSitennm(), "　", "（ＩＷＳＳＮ）ＤＳ支店名");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ預金種目（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbn(), "0", "（ＩＷＳＳＮ）ＤＳ口座種類区分");
        exStringEquals(infoOutputBean.getIwssnDskzsyuruikbnnm(), "", "（ＩＷＳＳＮ）ＤＳ口座種類（区分名称）");
        exStringEquals(infoOutputBean.getIwssnDsbankcd(), " ", "（ＩＷＳＳＮ）ＤＳ銀行コード");
        exStringEquals(infoOutputBean.getIwssnDssitencd(), " ", "（ＩＷＳＳＮ）ＤＳ支店コード");
        exStringEquals(infoOutputBean.getIwssnDsyokinkbn(), " ", "（ＩＷＳＳＮ）ＤＳ預金種目区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbn(), " ", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分");
        exStringEquals(infoOutputBean.getIwssnDskzdoukbnnm(), "　", "（ＩＷＳＳＮ）ＤＳ口座名義人同一区分（区分名称）");
    }
}

