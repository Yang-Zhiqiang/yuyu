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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoMockForHozen;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykniyuhenkouKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBean;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editTBL(KhozenCommonParam, IT_KykKihon, List, IT_KykSya, IT_HhknSya, EditTtdkKanryouParam, IT_KhShrRireki, IT_KykSonotaTkyk, BizDate, C_HassouKbn, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editTBL2 extends AbstractTest {

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20190606";

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf(2015, 12, 20));
    }

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
                bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMockForHozen.class);
            }
        });
        RayHttpHeaderBeanMockForHozen.caller = EditTtdkKanryouTblTest_editTBL2.class;
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL2.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL2.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        RayHttpHeaderBeanMockForHozen.caller = null;
        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;

        GetKhKykdrInfoForHozen.caller = null;
        GetKhKykdrInfoForHozen.SYORIPTN = null;

        BzGetSosikiMadogutiInfoMockForHozen.caller = null;
        BzGetSosikiMadogutiInfoMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL2.class, fileName, sheetName);
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
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000018");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(null);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.BLNK);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000018", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), null, "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(1));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(null);
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTSYSN, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(1), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は１２３，４５６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "（※３）円建終身保険の原資となる解約返戻金の円換算額は１００　円です。", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "　　　　到達日の解約返戻金の円換算額との差額を円建変更時返戻金額としてお支払いいたします。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　　　　お手続き方法などの詳細につきましては、裏面をご確認くださいますようお願いいたします。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "代理店事務サービス室", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(1));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(null);
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTSYSN, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（円建基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(1), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）円建基準金額は１２３，４５６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.YENDTHNKNINI_NEN);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(1));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(null);
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTNNKN_TMTTKINITENKEIINASI, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "（円建基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※）基準金額は「変更請求日の解約返戻金額（３００．００　米ドル）の円換算額", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　（４５６，７８９　円）」です。（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806000018");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "T110", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(1));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(null);
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "12806000018", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.BLNK, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "（円建基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(0), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(-1));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20190613));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTNNKN_TMTTKINITENKEIIARI, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "４５６，７８９　円（※）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は「円貨払込額（１２３，４５６　円）」です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(-1));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20190613));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTNNKN_TMTTKINITENKEIIARI, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（円建基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）円建基準金額は「円貨払込額（１２３，４５６　円）」です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(0));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20190613));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTSYSN, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は１２３，４５６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　　（円換算に使用した為替レート：１米ドル＝１．２３円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "（※３）円建終身保険の原資となる解約返戻金の円換算額は１００　円です。", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "　　　　到達日の解約返戻金の円換算額との差額を円建変更時返戻金額としてお支払いいたします。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "　　　　お手続き方法などの詳細につきましては、裏面をご確認くださいますようお願いいたします。", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "代理店事務サービス室", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(0));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20190613));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTSYSN, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（円建基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）円建基準金額は１２３，４５６　円です。", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　　（円換算に使用した為替レート：１米ドル＝１．２３円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(0));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20190613));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTSYSN, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）基準金額は「一時払保険料（２００　円）の円換算額", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　　（１２３，４５６　円）」です。（円換算に使用した為替レート：１米ドル＝１．２３円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20170816);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MKHGKTTTYENDTHNK);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYendthnkHr(BizCurrency.valueOf(0));
        editTtdkKanryouParam.setGengakukeiiUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setBfrTargetTkKjnKngk(BizCurrency.valueOf(123456));
        editTtdkKanryouParam.setBfrTuukasyu(C_Tuukasyu.USD);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(300 , BizCurrencyTypes.DOLLAR));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(456789));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(1.23));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(2.36));
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf(20190613));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf(20160401));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getKykniyuhnkkbn(), C_KykniyuhenkouKbn.YENDTSYSN, "契約内容変更区分");
        exDateEquals(ttdkKan.getKykniyuhnkymd(), BizDate.valueOf(20160401), "契約内容変更日");
        exStringEquals(ttdkKan.getKykniyuhnkinfo(), "１，２３４，５６０　円（円建基準金額（※１）の１０００％）", "契約内容変更情報");
        exClassificationEquals(ttdkKan.getKykniyuhnkgkhugou1(), C_HugouKbn.SEI, "契約内容変更金額明細符号１");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk1(), BizCurrency.valueOf(456789), "契約内容変更金額１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu1(), C_Tuukasyu.JPY, "契約内容変更金額通貨種類１");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngkhugou2(), C_HugouKbn.SEI, "契約内容変更金額明細符号２");
        exBizCalcbleEquals(ttdkKan.getKykniyuhnkkngk2(), BizCurrency.valueOf(0), "契約内容変更金額２");
        exClassificationEquals(ttdkKan.getKykniyuhnkkngktuksyu2(), C_Tuukasyu.BLNK, "契約内容変更金額通貨種類２");
        exClassificationEquals(ttdkKan.getTtdknaiyouumukbn(), C_UmuKbn.NONE, "手続内容有無区分");
        exStringEquals(ttdkKan.getTtdknaiyou1(), "（※１）円建基準金額は「一時払保険料（２００　円）の円換算額", "手続内容１");
        exStringEquals(ttdkKan.getTtdknaiyou2(), "　　　（１２３，４５６　円）」です。（円換算に使用した為替レート：１米ドル＝１．２３円）", "手続内容２");
        exStringEquals(ttdkKan.getTtdknaiyou3(), "（※２）到達日の解約返戻金額は３００．００　米ドルです。", "手続内容３");
        exStringEquals(ttdkKan.getTtdknaiyou4(), "　　　（円換算に使用した為替レート：１米ドル＝２．３６円）", "手続内容４");
        exStringEquals(ttdkKan.getTtdknaiyou5(), "", "手続内容５");
        exStringEquals(ttdkKan.getTtdknaiyou6(), "変更後の契約内容詳細につきましては、同封の保険証券をご確認ください。", "手続内容６");
        exStringEquals(ttdkKan.getTtdknaiyou7(), "", "手続内容７");
        exStringEquals(ttdkKan.getTtdknaiyou8(), "", "手続内容８");
        exStringEquals(ttdkKan.getTtdknaiyou9(), "", "手続内容９");
        exStringEquals(ttdkKan.getTtdknaiyou10(), "", "手続内容１０");
        exStringEquals(ttdkKan.getDocumentid(), "", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.BLNK, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.BLNK, "請求書文言区分２");
        exStringEquals(ttdkKan.getToritugisyasyozokunm(), "", "取次者所属名");
        exStringEquals(ttdkKan.getToritugisyakjncd(), "", "取次者個人コード");
        exStringEquals(ttdkKan.getToritugisyanm(), "", "取次者氏名");
        exNumericEquals(ttdkKan.getHozonKikan(), 0, "保存期間");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
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
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111141", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "配当金", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "特別配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "その他精算金", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10000), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(2), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(3), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(4), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：１２３．４０　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　４００　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約返戻金は、解約返戻金を消滅日の当社所定の為替レートで円貨に換算した金額です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆消滅日の属する年の所得となります。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exClassificationEquals(ttdkKan.getYuuyokkntyoukaumu(), C_UmuKbn.ARI, "猶予期間超過有無");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111152");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
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
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111152", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10000), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：１２３．４０　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　４００　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約返戻金は、解約返戻金を消滅日の当社所定の為替レートで円貨に換算した金額です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【解約返戻金に対する税務のご説明】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exClassificationEquals(ttdkKan.getYuuyokkntyoukaumu(), C_UmuKbn.ARI, "猶予期間超過有無");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
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
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111163", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10000), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：１２３．４０　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　４００　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約返戻金は、解約返戻金を消滅日の当社所定の為替レートで円貨に換算した金額です。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【解約返戻金に対する税務のご説明】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆消滅日の属する年の所得となります。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exClassificationEquals(ttdkKan.getYuuyokkntyoukaumu(), C_UmuKbn.ARI, "猶予期間超過有無");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
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

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111174", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "その他支払金合計", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "（明細）", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・保険料（円貨払込額）", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "・その他精算金", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "・配当金", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "・特別配当金", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10000), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(1), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(1100), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(4), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(2), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(3), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.JPY, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.JPY, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.JPY, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.JPY, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：１２３．４０　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　４００　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "・その他支払金合計はその他支払金明細の合計額です。", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exClassificationEquals(ttdkKan.getYuuyokkntyoukaumu(), C_UmuKbn.NONE, "猶予期間超過有無");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
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

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111185", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10000), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：１２３．４０　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　４００　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exClassificationEquals(ttdkKan.getYuuyokkntyoukaumu(), C_UmuKbn.NONE, "猶予期間超過有無");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {

        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
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

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111196", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getTekiyou1(), "解約返戻金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10000), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）適用為替レート：１２３．４０　円", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（２）解約返戻金", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　４００　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　上記解約返戻金には以下の契約変更時返戻金（注）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　　を含みます。", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　１０　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getOsirasemongonhyoudai(), "「お手続き完了のお知らせ」について", "お知らせ文言表題");
        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆円貨支払いのご請求により、解約返戻金を外貨（指定通貨または選択通貨）にかえて解約日時点の当社", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　所定の為替レート（※１）で円貨に換算してお支払いしています。", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）－５０銭」（※３）となります。", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＢを下回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exClassificationEquals(ttdkKan.getYuuyokkntyoukaumu(), C_UmuKbn.NONE, "猶予期間超過有無");
    }

}