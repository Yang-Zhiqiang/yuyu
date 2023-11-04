package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約者代理人情報取得クラスのメソッド {@link GetKhKykdrInfo＃exec(IT_KykKihon)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class GetKhKykdrInfoTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約者代理人情報取得";

    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    private final String syoNo1="99806001010";

    private final String syoNo2="99806001021";

    private final String syoNo3="99806001032";

    private final String syoNo4="99806032032";

    private final String syoNo5="99806001043";

    private final String syoNo6="99806032043";

    private final String syoNo7="99806001054";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(GetKhKykdrInfoTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
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
    public void testExec_A1(){
        IT_KykKihon pKykkihon = null;

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);
        try {

            getKhKykdrInfo.exec(pKykkihon);

        } catch (Exception e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。パラメータエラー　param='契約基本テーブル',value='null'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(20)
    public void testExec_A2(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo1);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(pKykkihon);

        exStringEquals(getKhKykdrInfoBean.getKkdairinmKn(),"","契約者代理人氏名（カナ）");
        exStringEquals(getKhKykdrInfoBean.getKkdairinmKj(),"","契約者代理人氏名（漢字）");
        exClassificationEquals(getKhKykdrInfoBean.getKkdairinmKjkhukaKbn(),C_KjkhukaKbn.BLNK, "契約者代理人名漢字化不可区分");
        exStringEquals(getKhKykdrInfoBean.getKykdryNo(),"","契約者代理人郵便番号");
        exStringEquals(getKhKykdrInfoBean.getKykdradr1(),"", "契約者代理人住所1");
        exStringEquals(getKhKykdrInfoBean.getKykdradr2(),"", "契約者代理人住所2");
        exStringEquals(getKhKykdrInfoBean.getKykdradr3(),"", "契約者代理人住所3");
        exStringEquals(getKhKykdrInfoBean.getKykdrtelno(),"", "契約者代理人電話番号");
        assertNull(getKhKykdrInfoBean.getkykdrseiymd());
        exClassificationEquals(getKhKykdrInfoBean.getKykdruktKbn(),C_UktKbn.BLNK, "契約者代理人受取人区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo2);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(pKykkihon);

        exStringEquals(getKhKykdrInfoBean.getKkdairinmKn(),"ウケトリカナ","契約者代理人氏名（カナ）");
        exStringEquals(getKhKykdrInfoBean.getKkdairinmKj(),"受取人名漢字","契約者代理人氏名（漢字）");
        exClassificationEquals(getKhKykdrInfoBean.getKkdairinmKjkhukaKbn(),C_KjkhukaKbn.BLNK, "契約者代理人名漢字化不可区分");
        exStringEquals(getKhKykdrInfoBean.getKykdryNo(),"0000009","契約者代理人郵便番号");
        exStringEquals(getKhKykdrInfoBean.getKykdradr1(),"住所１", "契約者代理人住所1");
        exStringEquals(getKhKykdrInfoBean.getKykdradr2(),"住所２", "契約者代理人住所2");
        exStringEquals(getKhKykdrInfoBean.getKykdradr3(),"住所３", "契約者代理人住所3");
        exStringEquals(getKhKykdrInfoBean.getKykdrtelno(),"", "契約者代理人電話番号");
        exDateEquals(getKhKykdrInfoBean.getkykdrseiymd(), BizDate.valueOf("19460322"), "契約者代理人生年月日");
        exClassificationEquals(getKhKykdrInfoBean.getKykdruktKbn(),C_UktKbn.TOKUTEIMEIGI, "契約者代理人受取人区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo3);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        try {

            getKhKykdrInfo.exec(pKykkihon);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),"システム整合性エラーです。テーブル取得エラー　IT_TrkKzk　key:syono=99806001032","エラーメッセージ");
        }

    }

    @Test
    @TestOrder(50)
    public void testExec_A5(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo4);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(pKykkihon);

        exStringEquals(getKhKykdrInfoBean.getKkdairinmKn(),"トウロクカゾクカナ１","契約者代理人氏名（カナ）");
        exStringEquals(getKhKykdrInfoBean.getKkdairinmKj(),"登録家族漢字１","契約者代理人氏名（漢字）");
        exClassificationEquals(getKhKykdrInfoBean.getKkdairinmKjkhukaKbn(),C_KjkhukaKbn.BLNK, "契約者代理人名漢字化不可区分");
        exStringEquals(getKhKykdrInfoBean.getKykdryNo(),"0000002","契約者代理人郵便番号");
        exStringEquals(getKhKykdrInfoBean.getKykdradr1(),"住所４", "契約者代理人住所1");
        exStringEquals(getKhKykdrInfoBean.getKykdradr2(),"住所５", "契約者代理人住所2");
        exStringEquals(getKhKykdrInfoBean.getKykdradr3(),"住所６", "契約者代理人住所3");
        exStringEquals(getKhKykdrInfoBean.getKykdrtelno(),"010-1234-5678", "契約者代理人電話番号");
        exDateEquals(getKhKykdrInfoBean.getkykdrseiymd(), BizDate.valueOf("19700522"), "契約者代理人生年月日");
        exClassificationEquals(getKhKykdrInfoBean.getKykdruktKbn(),C_UktKbn.TOUROKUKAZOKU1, "契約者代理人受取人区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo5);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        try {

            getKhKykdrInfo.exec(pKykkihon);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),"システム整合性エラーです。テーブル取得エラー　IT_TrkKzk　key:syono=99806001043","エラーメッセージ");
        }

    }

    @Test
    @TestOrder(70)
    public void testExec_A7(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo6);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(pKykkihon);

        exStringEquals(getKhKykdrInfoBean.getKkdairinmKn(),"トウロクカゾクカナ２","契約者代理人氏名（カナ）");
        exStringEquals(getKhKykdrInfoBean.getKkdairinmKj(),"","契約者代理人氏名（漢字）");
        exClassificationEquals(getKhKykdrInfoBean.getKkdairinmKjkhukaKbn(),C_KjkhukaKbn.KJKHUKA, "契約者代理人名漢字化不可区分");
        exStringEquals(getKhKykdrInfoBean.getKykdryNo(),"0000003","契約者代理人郵便番号");
        exStringEquals(getKhKykdrInfoBean.getKykdradr1(),"住所７", "契約者代理人住所1");
        exStringEquals(getKhKykdrInfoBean.getKykdradr2(),"住所８", "契約者代理人住所2");
        exStringEquals(getKhKykdrInfoBean.getKykdradr3(),"住所９", "契約者代理人住所3");
        exStringEquals(getKhKykdrInfoBean.getKykdrtelno(),"010-1234-5679", "契約者代理人電話番号");
        exDateEquals(getKhKykdrInfoBean.getkykdrseiymd(), BizDate.valueOf("19700413"), "契約者代理人生年月日");
        exClassificationEquals(getKhKykdrInfoBean.getKykdruktKbn(),C_UktKbn.TOUROKUKAZOKU2, "契約者代理人受取人区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8(){

        IT_KykKihon pKykkihon = hozenDomManager.getKykKihon(syoNo7);

        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);

        try {

            getKhKykdrInfo.exec(pKykkihon);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),"システム整合性エラーです。テーブル取得エラー　IT_TrkKzk　key:syono=99806001054","エラーメッセージ");
        }

    }
}
