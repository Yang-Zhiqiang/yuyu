package yuyu.common.hozen.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuMockForHozen;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutaiMockForHozen;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForHozen;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKeiyakuInfo;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 社内Web用保全契約内容情報取得のメソッド {@link KhGetSyanaiWebKeiyakuInfo#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhGetSyanaiWebKeiyakuInfoTest_exec extends AbstractTest {

    @Inject
    KhGetSyanaiWebKeiyakuInfo KhGetSyanaiWebKeiyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_社内Web用保全契約内容情報取得";

    private final static String sheetName = "INデータ";


    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMockForHozen.class);
                bind(CheckKaiyaku.class).to(CheckKaiyakuMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker
                .getInData(KhGetSyanaiWebKeiyakuInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        List<IT_KykKihon> kykKihonList= hozenDomManager.getAllKykKihon();
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        for (IT_KykKihon kykKihon : kykKihonList) {
            hozenDomManager.delete(kykKihon.getKykSyouhns());
            hozenDomManager.delete(hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(kykKihon.getSyono()));
            hozenDomManager.delete(hozenDomManager.getKhHenreikinYendtMbrsBySyono(kykKihon.getSyono()));
            hozenDomManager.delete(kykKihon.getHhknSya());
            hozenDomManager.delete(kykKihon.getKykSya());
            hozenDomManager.delete(kykKihon.getKykUkts());
            hozenDomManager.delete(kykKihon.getKykSonotaTkyk());
            hozenDomManager.delete(kykKihon.getKykDairitens());
            hozenDomManager.delete(kykKihon.getKhTtdkTyuui());
            hozenDomManager.delete(kykKihon.getKhTtdkRirekis());
            hozenDomManager.delete(kykKihon.getNyknJissekiRirekis());

        }
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("17806000013");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.GAITOUKEIYAKUNASI_ERROR, "処理結果区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "17806000013", "（ＩＷＳＳＮ）証券番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), null, "（ＩＷＳＳＮ）商品コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        changeSystemDate(BizDate.valueOf(20200107));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001021");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806001021", "（ＩＷＳＳＮ）証券番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾕｵ", "（ＩＷＳＳＮ）商品コード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        changeSystemDate(BizDate.valueOf(20200107));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001032");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806001032", "（ＩＷＳＳＮ）証券番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾕﾉ", "（ＩＷＳＳＮ）商品コード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        changeSystemDate(BizDate.valueOf(20200107));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001043");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806001043", "（ＩＷＳＳＮ）証券番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾕｹ", "（ＩＷＳＳＮ）商品コード");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        changeSystemDate(BizDate.valueOf(20200107));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001054");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806001054", "（ＩＷＳＳＮ）証券番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾕﾁ", "（ＩＷＳＳＮ）商品コード");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        changeSystemDate(BizDate.valueOf(20200107));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001065");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.SOUGOUSYOUKAI_MITAIOUSYOUHN, "処理結果区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806001065", "（ＩＷＳＳＮ）証券番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ｳ1", "（ＩＷＳＳＮ）商品コード");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        changeSystemDate(BizDate.valueOf(20200107));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =null;
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiHozenInfoOutputBean.class);
        try {

            iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001076");
            iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();
        } catch (Exception e) {

            exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "処理結果区分");
            exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806001076", "（ＩＷＳＳＮ）証券番号");
            exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾕｵ", "（ＩＷＳＳＮ）商品コード");
        }


    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        changeSystemDate(BizDate.valueOf(20200709));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =null;
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiHozenInfoOutputBean.class);
        try {

            iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806044624");
            iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();
        } catch (Exception e) {

            exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "処理結果区分");
            exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806044624", "（ＩＷＳＳＮ）証券番号");
            exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾕﾍ", "（ＩＷＳＳＮ）商品コード");
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        changeSystemDate(BizDate.valueOf(20210909));

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =null;
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiHozenInfoOutputBean.class);
        try {

            iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806062787");
            iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();
        } catch (Exception e) {

            exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "処理結果区分");
            exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono(), "99806062787", "（ＩＷＳＳＮ）証券番号");
            exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd(), "ﾆｱ", "（ＩＷＳＳＮ）商品コード");
        }
    }

}
