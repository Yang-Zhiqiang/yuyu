package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 契約保全 契約保全共通 契約保全モニタリングデータ共通項目編集クラスのメソッド {@link EditCommonMonitoringdata#exec(EditCommonMonitoringdataBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditCommonMonitoringdataTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約保全モニタリングデータ共通項目編集";
    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetTyotikuseihokenhyouji.class).to(SetTyotikuseihokenhyoujiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        SetTyotikuseihokenhyoujiMockForHozen.caller = EditCommonMonitoringdataTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SetTyotikuseihokenhyoujiMockForHozen.caller =null;
        SetTyotikuseihokenhyoujiMockForHozen.SYORIPTN =null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditCommonMonitoringdataTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {
            EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);
            EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
            editCommonMonitoringdataBean = editCommonMonitoringdata.exec(null,BizDateYM.valueOf("201808"));
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='契約基本テーブル',value='null'", "メッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetTyotikuseihokenhyoujiMockForHozen.SYORIPTN = SetTyotikuseihokenhyoujiMockForHozen.TESTPATTERN1;

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,null);

        exStringEquals(editCommonMonitoringdataBean.getSyono(), "11807111129", "証券番号");
        exStringEquals(editCommonMonitoringdataBean.getOkyksmno(), "0000000000", "お客さま番号");
        exStringEquals(editCommonMonitoringdataBean.getKyknmkn(), "ｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶﾅｶ", "カナ契約者名");
        exStringEquals(editCommonMonitoringdataBean.getKyknmkj(), "漢字漢字漢字漢字漢字漢字漢字漢", "漢字契約者名");
        exDateEquals(editCommonMonitoringdataBean.getSeiymd(), BizDate.valueOf(19850502), "生年月日");
        exStringEquals(editCommonMonitoringdataBean.getKihontikucd(), "1234570", "基本地区コード");
        exDateEquals(editCommonMonitoringdataBean.getKykymd(), BizDate.valueOf(20190502), "契約年月日");
        exDateEquals(editCommonMonitoringdataBean.getZougakukeii(), BizDate.valueOf(00000000), "増額経緯");
        exBizCalcbleEquals(editCommonMonitoringdataBean.getZougakukingaku(), BizCurrency.valueOf(0), "増額金額");
        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(20190723), "名変経緯");
        exStringEquals(editCommonMonitoringdataBean.getHrkkeirokbn(), "1", "払込経路区分");
        exStringEquals(editCommonMonitoringdataBean.getSyuunoukeirokbn(), "3", "収納経路区分");
        exClassificationEquals(editCommonMonitoringdataBean.getKzkykdoukbn(), C_KzkykdouKbn.SITEI, "口座名義契約者同一人区分");
        exStringEquals(editCommonMonitoringdataBean.getAtukaisisyacd(), "000", "扱支社コード");
        exStringEquals(editCommonMonitoringdataBean.getAtukaisibucd(), "0000", "扱支部コード");
        exStringEquals(editCommonMonitoringdataBean.getAtukaikojincd(), "123457", "扱者個人コード");
        exClassificationEquals(editCommonMonitoringdataBean.getMrkykhyj(), C_UmuKbn.NONE, "MR契約表示");
        exClassificationEquals(editCommonMonitoringdataBean.getNaibukykhyj(), C_UmuKbn.NONE, "内部契約表示");
        exClassificationEquals(editCommonMonitoringdataBean.getJikokykhyj(), C_UmuKbn.NONE, "自己契約表示");
        exClassificationEquals(editCommonMonitoringdataBean.getHjnkykhyj(), C_UmuKbn.NONE, "法人契約表示");
        exStringEquals(editCommonMonitoringdataBean.getSyouhnbunruikbn(), "C", "商品分類区分");
        exStringEquals(editCommonMonitoringdataBean.getSyouhnnmkbn(), "35", "商品名称区分");
        exClassificationEquals(editCommonMonitoringdataBean.getHouteityotkhknhyj(), C_UmuKbn.ARI, "法定貯蓄性保険表示");
        exClassificationEquals(editCommonMonitoringdataBean.getTyotkhknhyj(), C_UmuKbn.NONE, "貯蓄性保険表示");
        exStringEquals(editCommonMonitoringdataBean.getHighcverrorkbn(), "99", "高ＣＶ計算エラー区分");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.ARI, "リスク「高」フラグ（注意契約№74フラグ）");

        MockObjectManager.assertArgumentPassed(BzKbnHenkanUtil.class, "convKbn", 0,"1");
        MockObjectManager.assertArgumentPassed(BzKbnHenkanUtil.class, "convKbn", 1, C_Hrkkeiro.class);
        MockObjectManager.assertArgumentPassed(BzKbnHenkanUtil.class, "convKbn", 2, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetTyotikuseihokenhyoujiMockForHozen.SYORIPTN = SetTyotikuseihokenhyoujiMockForHozen.TESTPATTERN2;

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,null);

        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(00000000), "名変経緯");
        exClassificationEquals(editCommonMonitoringdataBean.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一人区分");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.ARI, "リスク「高」フラグ（注意契約№74フラグ）");
        exClassificationEquals(editCommonMonitoringdataBean.getHouteityotkhknhyj(), C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(editCommonMonitoringdataBean.getTyotkhknhyj(), C_UmuKbn.ARI, "貯蓄性保険表示");
        exStringEquals(editCommonMonitoringdataBean.getHighcverrorkbn(), "0", "高ＣＶ計算エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SetTyotikuseihokenhyoujiMockForHozen.SYORIPTN = SetTyotikuseihokenhyoujiMockForHozen.TESTPATTERN3;

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(00000000), "名変経緯");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.NONE, "リスク「高」フラグ（注意契約№74フラグ）");
        exClassificationEquals(editCommonMonitoringdataBean.getHouteityotkhknhyj(), C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(editCommonMonitoringdataBean.getTyotkhknhyj(), C_UmuKbn.NONE, "貯蓄性保険表示");
        exStringEquals(editCommonMonitoringdataBean.getHighcverrorkbn(), "0", "高ＣＶ計算エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111152");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(20180801), "名変経緯");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.NONE, "リスク「高」フラグ（注意契約№74フラグ）");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(20180901), "名変経緯");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.NONE, "リスク「高」フラグ（注意契約№74フラグ）");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(20190701), "名変経緯");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.NONE, "リスク「高」フラグ（注意契約№74フラグ）");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        SetTyotikuseihokenhyoujiMockForHozen.SYORIPTN = SetTyotikuseihokenhyoujiMockForHozen.TESTPATTERN4;

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(20190801), "名変経緯");
        exClassificationEquals(editCommonMonitoringdataBean.getHighriskflg(), C_UmuKbn.NONE, "リスク「高」フラグ（注意契約№74フラグ）");
        exClassificationEquals(editCommonMonitoringdataBean.getHouteityotkhknhyj(), C_UmuKbn.ARI, "法定貯蓄性保険表示");
        exClassificationEquals(editCommonMonitoringdataBean.getTyotkhknhyj(), C_UmuKbn.NONE, "貯蓄性保険表示");
        exStringEquals(editCommonMonitoringdataBean.getHighcverrorkbn(), "0", "高ＣＶ計算エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exStringEquals(editCommonMonitoringdataBean.getKyknmkn(), "ｶﾞﾅｶﾞﾅｶﾞﾅｶﾞﾅｶﾞﾅｶﾞﾅｶﾞﾅｶﾞ", "カナ契約者名");
        exClassificationEquals(editCommonMonitoringdataBean.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一人区分");
        exStringEquals(editCommonMonitoringdataBean.getAtukaikojincd(), "123464", "扱者個人コード");
        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(00000000), "名変経緯");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        EditCommonMonitoringdataBean editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111200");

        EditCommonMonitoringdata editCommonMonitoringdata = SWAKInjector.getInstance(EditCommonMonitoringdata.class);
        editCommonMonitoringdataBean = editCommonMonitoringdata.exec(kykKihon,BizDateYM.valueOf("201908"));

        exStringEquals(editCommonMonitoringdataBean.getKyknmkn(), "KANJIKA HUKA", "カナ契約者名");
        exDateEquals(editCommonMonitoringdataBean.getMeighnkkeii(), BizDate.valueOf(00000000), "名変経緯");
    }

}
