package yuyu.common.direct.dscommon;

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
import yuyu.def.classification.C_CheckDsMkhgkHenkouKekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ目標額変更共通チェッククラスのメソッド {@link CheckDsMkhgkHenkou#chkMkhgkHnkInputNaiyou(String pSyono, Integer pHnkgoMkhgkWari)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsMkhgkHenkouTest_chkMkhgkHnkInputNaiyou extends AbstractTest {

    @Inject
    private CheckDsMkhgkHenkou checkDsMkhgkHenkou;

    private final static String fileName = "UT_SP_単体テスト仕様書_ＤＳ目標額変更共通チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDsMkhgkHenkouTest_chkMkhgkHnkInputNaiyou.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU));
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
    }

    @Test
    @TestOrder(10)
    public void testChkMkhgkHnkInputNaiyou_A1() {

        String syono = "99806001010";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.BLANK, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(20)
    public void testChkMkhgkHnkInputNaiyou_A2() {

        String syono = "99806001010";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("010000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(30)
    public void testChkMkhgkHnkInputNaiyou_A3() {

        String syono = null;
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.HUKA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(40)
    public void testChkMkhgkHnkInputNaiyou_A4() {

        String syono = "";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.HUKA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(50)
    public void testChkMkhgkHnkInputNaiyou_A5() {

        String syono = "99806001010";
        Integer hnkgoMkhgkWari = null;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.HUKA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(60)
    public void testChkMkhgkHnkInputNaiyou_A6() {

        String syono = "11807111118";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(70)
    public void testChkMkhgkHnkInputNaiyou_A7() {

        String syono = "99806001021";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARIGENZAIHENKOUNASHI, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(80)
    public void testChkMkhgkHnkInputNaiyou_A8() {

        String syono = "99806001032";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.BLANK, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(90)
    public void testChkMkhgkHnkInputNaiyou_A9() {

        String syono = "99806001043";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARITETUDUKITYUUHENKOUNASHI, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(100)
    public void testChkMkhgkHnkInputNaiyou_A10() {

        String syono = "99806001054";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.BLANK, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }

    @Test
    @TestOrder(110)
    public void testChkMkhgkHnkInputNaiyou_A11() {

        String syono = "99806001065";
        Integer hnkgoMkhgkWari = 110;
        changeSystemDate(BizDate.valueOf("20200714"));
        YuyuDswebConfig.getInstance().setYakanJobKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkDsMkhgkHenkou.chkMkhgkHnkInputNaiyou(syono, hnkgoMkhgkWari);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsMkhgkHenkou.getCheckDsMkhgkHenkouKekkaKbn(),
            C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI, "ＤＳ目標額変更共通チェック結果区分");
        exClassificationEquals(checkDsMkhgkHenkou.getMkhgkHenkoukykKahiKbn(),
            C_KahiKbn.KA, "目標額変更契約表示可否区分");
    }
}
