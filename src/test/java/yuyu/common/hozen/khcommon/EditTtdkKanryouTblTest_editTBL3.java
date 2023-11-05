package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoMockForHozen;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editTBL(KhozenCommonParam, IT_KykKihon, List, IT_KykSya, IT_HhknSya, EditTtdkKanryouParam, IT_KhShrRireki, IT_KykSonotaTkyk, BizDate, C_HassouKbn, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editTBL3 extends AbstractTest {

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20190902";

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf(2015, 12, 20));
    }

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
                bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMockForHozen.class);
            }
        });
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL3.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL3.class;
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        MockObjectManager.initialize();
        GetKhKykdrInfoForHozen.SYORIPTN = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL3.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

        MockObjectManager.initialize();
        GetKhKykdrInfoForHozen.caller = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;

        BzGetSosikiMadogutiInfoMockForHozen.caller = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾉ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数２年以上につき１１０．００％）", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾉ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数２年以上につき１１０．００％）", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾊ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数３年以上４年未満につき１１０．００％）", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾊ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数３年以上４年未満につき１１０．００％）", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾋ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　－１　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "（注）個人年金保険料税制適格特約（’９０）付加のため、契約変更時にお預かりしていた返戻金", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾌ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111141", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　１００　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111152");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕF", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111152", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額は解約返戻金額明細の合計額（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：１２３．４０　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）解約返戻金額明細の合計額（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　４００　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆ご契約当初１５年間の解約返戻金額は市場価格調整（※）を適用し計算するため、市場金利の変動に", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　より、解約日の保険料積立金額から増減します。また、ご契約当初１０年間は、一時払保険料相当額", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　に一定割合（契約日からの経過年数に応じた所定の控除率）を乗じた金額を差し引きます（解約", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　控除）。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T001", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111163", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額は解約返戻金額明細の合計額（外貨）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を円貨に換算した金額です。　（１）×（２）", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）適用為替レート：１２３．４０　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）解約返戻金額明細の合計額（外貨）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　４００　円", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾉ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111174", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数１年未満につき１１０．００％）", "支払内容補足文言１");

    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111185", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：基準金額×控除率　（契約日からの経過年数３年以上４年未満につき１１０．００％）", "支払内容補足文言１");

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾋ", 2, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111196", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：一時払保険料相当額×控除率　（契約日からの経過年数３年以上につき１１０．００％）", "支払内容補足文言１");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        MockObjectManager.initialize();

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111200");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111200", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");

    }

}