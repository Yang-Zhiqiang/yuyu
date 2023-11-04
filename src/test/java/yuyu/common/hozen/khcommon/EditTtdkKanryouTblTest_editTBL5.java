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
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkHnkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YenShrTkHnkKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
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
public class EditTtdkKanryouTblTest_editTBL5 extends AbstractTest {

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;


    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20200210";

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf(2015, 12, 20));
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(RayHttpHeaderBean.class).to(RayHttpHeaderBeanMockForHozen.class);
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
                bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        RayHttpHeaderBeanMockForHozen.caller = EditTtdkKanryouTblTest_editTBL5.class;
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL5.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL5.class;
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
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL5.class, fileName, sheetName);
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
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200").getKhShrRireki();

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｵ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "5160000", "組織コード");

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001010", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.DOLLAR), "収入金額");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　０．１０　米ドル", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

        exStringEquals(ttdkKan.getShskyno(), "", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "", "送付先氏名（漢字）");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");

        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）３");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");
        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");
        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getDuhubutumsg(), "", "同封物ＭＳＧ区分");
        exStringEquals(ttdkKan.getKiyakuhunyuuhyouji(), "", "規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｵ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI);


        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001010", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.BLNK, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　０．１０　米ドル", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

        exStringEquals(ttdkKan.getShskyno(), "", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "", "送付先氏名（漢字）");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");

        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）３");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");
        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");
        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getDuhubutumsg(), "", "同封物ＭＳＧ区分");
        exStringEquals(ttdkKan.getKiyakuhunyuuhyouji(), "", "規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "test01", "組織コード");

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001021", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "008", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "吉野支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exStringEquals(ttdkKan.getBikou1(), "・解約返戻金額には以下の契約変更時返戻金（注）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を含みます。", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　０．１０　米ドル", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "・その他支払金合計はその他支払金明細の合計額（円）", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　を外貨に換算した金額です。　（１）÷（２)", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（１）その他支払金明細の合計額（円）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　３．００　米ドル", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "　（２）適用為替レート：２３．５６　円", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

        exStringEquals(ttdkKan.getShskyno(), "4354001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ受名　一あ", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　当社から金融機関あてに次回の保険料（円貨払込額）の振替依頼は完了しています。行き違いに保険料（円", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　貨払込額）が振り替えられたときは、当社へ着金しだい振替口座へご返金させていただきます。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊口座振替日　２０１９年　６月２７日", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　＊口座振替依頼金額　１０，０００　円　２０１９年　６月から１か月分を", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　ご案内しています。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");
        exStringEquals(ttdkKan.getOsirasemongon22(), "【解約返戻金に対する税務のご説明】", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言２９");
        exStringEquals(ttdkKan.getOsirasemongon30(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言３０");
        exStringEquals(ttdkKan.getOsirasemongon31(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言３１");
        exStringEquals(ttdkKan.getOsirasemongon32(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言３２");
        exStringEquals(ttdkKan.getOsirasemongon33(), "　◆所轄の税務署あてに、支払調書を提出いたします。", "お知らせ文言３３");
        exStringEquals(ttdkKan.getOsirasemongon34(), "", "お知らせ文言３４");
        exStringEquals(ttdkKan.getOsirasemongon35(), "", "お知らせ文言３５");
        exStringEquals(ttdkKan.getOsirasemongon36(), "", "お知らせ文言３６");
        exStringEquals(ttdkKan.getOsirasemongon37(), "", "お知らせ文言３７");
        exStringEquals(ttdkKan.getOsirasemongon38(), "", "お知らせ文言３８");
        exStringEquals(ttdkKan.getOsirasemongon39(), "", "お知らせ文言３９");
        exStringEquals(ttdkKan.getOsirasemongon40(), "", "お知らせ文言４０");

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001032", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "010", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "東生駒支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.DOLLAR), "収入金額");


        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一う", "送付先氏名（漢字）");

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
        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　６月から１か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　１０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・後日、クレジットカ－ドの決済（口座振替）が行われたときには、上記保険料は、当社へ着金しだい、", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　【解約手続時の支払指定口座】へご返金いたします。何とぞご了承ください。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");

        exStringEquals(ttdkKan.getOsirasemongon22(), "【解約返戻金に対する税務のご説明】", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆保険料負担者が受け取る場合は、一時所得として総合課税の対象となります。", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "　　（なお、保険料負担者以外が受け取る場合は、税務上の取扱いや課税額が異なることがあります。）", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "　◆以下の金額がプラスの場合、他の所得と合算され、所得税の対象となり確定申告が必要となります。", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "　　｛収入金額－必要経費－特別控除（５０万円）｝×１／２", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "　　　※特別控除は他の一時所得と合算して年間５０万円までとなります。", "お知らせ文言２７");
        exStringEquals(ttdkKan.getOsirasemongon28(), "　◆収入金額、必要経費は「お手続き完了のお知らせ」に記載のとおりです。「お手続き完了のお知らせ」", "お知らせ文言２８");
        exStringEquals(ttdkKan.getOsirasemongon29(), "　　は、確定申告の際の参考資料となりますので、大切に保管してください。", "お知らせ文言２９");
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

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001043", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "013", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "小泉支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.DOLLAR), "収入金額");


        exStringEquals(ttdkKan.getShskyno(), "8599999", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名（漢字）", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　９月から６か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　４０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・後日、クレジットカ－ドの決済（口座振替）が行われたときには、上記保険料は、当社へ着金しだい、", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　　別途ご返金いたします。何とぞご了承ください。", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "", "お知らせ文言２１");

        exStringEquals(ttdkKan.getOsirasemongon22(), "【解約返戻金に対する税務のご説明】", "お知らせ文言２２");
        exStringEquals(ttdkKan.getOsirasemongon23(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言２３");
        exStringEquals(ttdkKan.getOsirasemongon24(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言２４");
        exStringEquals(ttdkKan.getOsirasemongon25(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言２５");
        exStringEquals(ttdkKan.getOsirasemongon26(), "　◆既払込保険料等は既に払い込まれた円貨払込額の合計額等です。", "お知らせ文言２６");
        exStringEquals(ttdkKan.getOsirasemongon27(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言２７");
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

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001054");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190802"));
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001054", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "005", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "天理支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");


        exStringEquals(ttdkKan.getShskyno(), "", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名（漢字）", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
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

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001054");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("1234567");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190701"));

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001054", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "005", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "天理支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");


        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
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

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001065");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("1234567");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001065", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "008", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "吉野支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");


        exStringEquals(ttdkKan.getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "送付先住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "送付先住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "送付先住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "送付先氏名（漢字）", "送付先氏名（漢字）");

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

        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　６月から１か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　１０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・今般の解約手続時のお支払金額は、上記保険料をいただくことを前提に計算した内容になっています。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　・ご指定のクレジットカ－ド発行会社により、後日、ご精求金額の決済が行われることがありますが、こ", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　　の保険料の返金はできませんので、何とぞご了承ください。", "お知らせ文言２１");

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

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001076");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "07", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001076", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exStringEquals(ttdkKan.getBankcd(), "0010", "銀行コード");
        exStringEquals(ttdkKan.getSitencd(), "010", "支店コード");
        exStringEquals(ttdkKan.getBanknmkj(), "りそな銀行", "銀行名（漢字）");
        exStringEquals(ttdkKan.getSitennmkj(), "東生駒支店", "支店名（漢字）");
        exClassificationEquals(ttdkKan.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exClassificationEquals(ttdkKan.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(ttdkKan.getKouzano(), "", "口座番号");
        exStringEquals(ttdkKan.getKzmeiginmkn(), "ユヒメイ　イチア", "口座名義人氏名（カナ）");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");


        exStringEquals(ttdkKan.getShskyno(), "4354001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ受名　一あ", "送付先氏名（漢字）");

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

        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　６月から１か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　１０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・上記保険料は、今般の解約手続時のお支払金額【その他精算金】に含めてご返金しています。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　・行き違いにより、後日、クレジットカ－ドの決済が行われることがあります。何とぞご了承ください。", "お知らせ文言２０");
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

    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001087");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001087", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");

        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一く", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");

        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　６月から１か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　１０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・今般の解約手続時のお支払金額は、上記保険料をいただくことを前提に計算した内容になっています。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　・ご指定のクレジットカ－ド発行会社により、後日、ご精求金額の決済が行われることがありますが、こ", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　　の保険料の返金はできませんので、何とぞご了承ください。", "お知らせ文言２１");

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

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001098");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001098", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");

        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一け", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");

        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　６月から１か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　１０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・今般の解約手続時のお支払金額は、上記保険料をいただくことを前提に計算した内容になっています。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　・ご指定のクレジットカ－ド発行会社により、後日、ご精求金額の決済が行われることがありますが、こ", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　　の保険料の返金はできませんので、何とぞご了承ください。", "お知らせ文言２１");

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

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001102");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001102", "証券番号");

        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_SAIKENSYA_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");

        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一こ", "送付先氏名（漢字）");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "【適用為替レートについて】", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　◆その他支払金合計は、その他支払金明細の合計額（円貨）を解約日時点の当社所定の為替レート（※１）", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　で外貨（指定通貨または選択通貨）に換算してお支払いしています。", "お知らせ文言６");

        exStringEquals(ttdkKan.getOsirasemongon7(), "　◆当社所定の為替レートは、「ＴＴＭ（対顧客電信売買相場仲値）（※２）＋５０銭」（※３）となります。", "お知らせ文言７");

        exStringEquals(ttdkKan.getOsirasemongon8(), "　（※１）当社が指標として指定する金融機関が休業日の場合は、その日の直後に到来する金融機関の営業", "お知らせ文言８");

        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　日とします。", "お知らせ文言９");

        exStringEquals(ttdkKan.getOsirasemongon10(), "　（※２）当社が指標として指定する金融機関が公示するＴＴＳ（対顧客電信売相場）とＴＴＢ（対顧客電", "お知らせ文言１０");

        exStringEquals(ttdkKan.getOsirasemongon11(), "　　　　信買相場）の仲値とします。なお、１日のうちに公示の変更があった場合には、その日の最初の", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "　　　　公示値とします。", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　（※３）当社が指標として指定する金融機関が公示するＴＴＳを上回ることはありません。", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "", "お知らせ文言１４");

        exStringEquals(ttdkKan.getOsirasemongon15(), "【保険料のご返金について】 ", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　・２０１９年　６月から１か月分保険料は、当社からクレジットカ－ド発行会社あてに請求を完了して", "お知らせ文言１６");
        exStringEquals(ttdkKan.getOsirasemongon17(), "　　います。", "お知らせ文言１７");
        exStringEquals(ttdkKan.getOsirasemongon18(), "　＊ご請求金額　１０，０００　円", "お知らせ文言１８");
        exStringEquals(ttdkKan.getOsirasemongon19(), "　・今般の解約手続時のお支払金額は、上記保険料をいただくことを前提に計算した内容になっています。", "お知らせ文言１９");
        exStringEquals(ttdkKan.getOsirasemongon20(), "　・ご指定のクレジットカ－ド発行会社により、後日、ご精求金額の決済が行われることがありますが、こ", "お知らせ文言２０");
        exStringEquals(ttdkKan.getOsirasemongon21(), "　　の保険料の返金はできませんので、何とぞご了承ください。", "お知らせ文言２１");

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

    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001102");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(300));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(12));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(13));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf("20190605"));

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001102", "証券番号");
        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一こ", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getHnsnhutouhuunyuuhyouji(), "1", "返信用封筒封入表示");


    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001102");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(300));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(12));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(13));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf("20190605"));
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001102", "証券番号");
        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一こ", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getHnsnhutouhuunyuuhyouji(), "0", "返信用封筒封入表示");


    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001102");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrGaika(BizCurrency.valueOf(100));
        editTtdkKanryouParam.setYendtHnkjikaiyakuhrYen(BizCurrency.valueOf(200));
        editTtdkKanryouParam.setNewKaiyakuhr(BizCurrency.valueOf(300));
        editTtdkKanryouParam.setBfrHrkP(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setNyknKawaserate(BizNumber.valueOf(12));
        editTtdkKanryouParam.setYendtHnkjiKawaserate(BizNumber.valueOf(13));
        editTtdkKanryouParam.setKykniyuhnkymd(BizDate.valueOf("20190605"));
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setKouryokuYMD(BizDate.valueOf("20190601"));
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001102", "証券番号");
        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一こ", "送付先氏名（漢字）");

    }


    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "5640000", "組織コード");

    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "5640000", "組織コード");

    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A18() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "6620000", "組織コード");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A19() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "6620000", "組織コード");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A20() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBKAIJYO_KYKTRKSTTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "test01", "組織コード");

    }

    @Test
    @TestOrder(210)
    public void testEditTBL_A21() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBMENSEKI_KYKTRKSTTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "test01", "組織コード");

    }

    @Test
    @TestOrder(220)
    public void testEditTBL_A22() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_SBMUKOU_KYKTRKSTTDKKR);

        exStringEquals((String) MockObjectManager.getArgument(BzGetSosikiMadogutiInfoMockForHozen.class, "exec", 0, 0),
            "test01", "組織コード");

    }

    @Test
    @TestOrder(230)
    public void testEditTBL_A23() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_A24() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(30, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(250)
    public void testEditTBL_A25() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(260)
    public void testEditTBL_A26() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(50, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(270)
    public void testEditTBL_A27() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.SKS);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(280)
    public void testEditTBL_A28() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "税務内容編集制御区分");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR), "収入金額");
    }

    @Test
    @TestOrder(290)
    public void testEditTBL_A29() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000116", "証券番号");

        exStringEquals(ttdkKan.getShskyno(), "4354001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "住所１", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "住所２", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "住所３", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ受名　一あ", "送付先氏名（漢字）");


        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一い", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800203), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "2345678", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "070-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一い", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800204), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "4567890", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "080-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");
        exStringEquals(ttdkKan.getKykomttutkbn(), "00", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "00", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(300)
    public void testEditTBL_A30() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000127");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK2);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean = new DouhuuTaisyouBean();
        douhuuTaisyouBean.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBean.setNmkj("氏名（漢字）１１");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000127", "証券番号");

        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "田打", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "ユ被名　一こ", "送付先氏名（漢字）");


        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一お", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(ttdkKan.getKykomttutkbn(), "03", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "05", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "03", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(310)
    public void testEditTBL_A31() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000138");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.KYK);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean = new DouhuuTaisyouBean();
        douhuuTaisyouBean.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBean.setNmkj("氏名（漢字）１１");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000138", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一お", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "04", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "23", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "01", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(320)
    public void testEditTBL_A32() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.HHKN);
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.BLNK);
        douhuuTaisyouBean1.setNmkj("氏名（漢字）１１");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.BLNK);
        douhuuTaisyouBean2.setNmkj("氏名（漢字）２２");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        DouhuuTaisyouBean douhuuTaisyouBean3 = new DouhuuTaisyouBean();
        douhuuTaisyouBean3.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK2);
        douhuuTaisyouBean3.setTrkKzkKbn(C_TrkKzkKbn.BLNK);
        douhuuTaisyouBean3.setNmkj("氏名（漢字）３３");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean3);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean1);
        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean2);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000149", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "氏名（漢字）３３", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "01", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "07", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "01", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "07", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "09", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "12", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "03", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "06", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(330)
    public void testEditTBL_A33() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBean1.setNmkj("氏名（漢字）１１");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBean2.setNmkj("氏名（漢字）２２");
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "04", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "27", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "23", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(340)
    public void testEditTBL_A34() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "04", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "23", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "27", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(350)
    public void testEditTBL_A35() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.KYK);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "03", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "07", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(360)
    public void testEditTBL_A36() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "00", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "04", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "00", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "11", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "06", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(370)
    public void testEditTBL_A37() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "01", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "24", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "削除登録家族名１", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(380)
    public void testEditTBL_A38() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "03", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "02", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "25", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(390)
    public void testEditTBL_A39() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "00", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "50", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(400)
    public void testEditTBL_A40() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.SONOTA);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();
        tyokusouTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean1);
        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();
        tyokusouTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean2);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "00", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "00", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "50", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(410)
    public void testEditTBL_A41() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "05", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(420)
    public void testEditTBL_A42() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK2);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000105", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一い", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800202), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "04", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "05", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "11", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "09", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(430)
    public void testEditTBL_A43() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "04", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "28", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "23", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(440)
    public void testEditTBL_A44() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "04", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "27", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "22", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(450)
    public void testEditTBL_A45() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "04", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "22", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "27", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(460)
    public void testEditTBL_A46() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "04", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "23", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "28", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(470)
    public void testEditTBL_A47() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "03", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(480)
    public void testEditTBL_A48() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "05", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "06", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "01", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "07", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "50", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(490)
    public void testEditTBL_A49() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "06", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(500)
    public void testEditTBL_A50() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "29", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "06", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(510)
    public void testEditTBL_A51() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "04", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(520)
    public void testEditTBL_A52() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "31", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(530)
    public void testEditTBL_A53() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(540)
    public void testEditTBL_A54() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();
        tyokusouTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean1);
        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();
        tyokusouTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean2);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "03", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "11", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "50", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(550)
    public void testEditTBL_A55() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.KYK);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "00", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "00", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "06", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "09", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(560)
    public void testEditTBL_A56() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "28", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(570)
    public void testEditTBL_A57() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "04", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "01", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "07", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(580)
    public void testEditTBL_A58() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "31", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "02", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "00", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "00", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(590)
    public void testEditTBL_A59() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "29", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "01", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "09", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "50", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(600)
    public void testEditTBL_A60() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "03", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "29", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "11", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "01", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "09", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(610)
    public void testEditTBL_A61() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名（漢字）");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK2);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "03", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "00", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "05", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "12", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "00", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "03", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "01", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "指定代理請求人名（漢字）", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "09", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(620)
    public void testEditTBL_A62() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");
        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "01", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "24", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "削除登録家族名２", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "09", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "03", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(630)
    public void testEditTBL_A63() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "01", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "24", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "削除登録家族名２", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "10", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "06", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "11", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "50", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(640)
    public void testEditTBL_A64() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "01", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "24", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "02", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "07", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "09", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "50", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(650)
    public void testEditTBL_A65() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("契約者代理人名（漢字）");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);

        List<DouhuuTaisyouBean> douhuuTaisyouBeanLst = new ArrayList<DouhuuTaisyouBean>();
        DouhuuTaisyouBean douhuuTaisyouBean1 = new DouhuuTaisyouBean();
        douhuuTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK1);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean1);
        DouhuuTaisyouBean douhuuTaisyouBean2 = new DouhuuTaisyouBean();
        douhuuTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
        douhuuTaisyouBeanLst.add(douhuuTaisyouBean2);
        editTtdkKanryouParam.setDouhuuTaisyouList(douhuuTaisyouBeanLst);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean1);
        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean2);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000149", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一お", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "契約者代理人名（漢字）", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "01", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "08", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "01", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "06", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "07", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "09", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "03", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "06", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "50", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(660)
    public void testEditTBL_A66() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean1);
        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean2);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000149", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一お", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "01", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "01", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "01", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "07", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "09", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "50", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(670)
    public void testEditTBL_A67() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000149", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一お", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "01", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "01", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "07", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "09", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "50", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(680)
    public void testEditTBL_A68() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");


        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.KYK);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "03", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "00", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "00", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "09", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(690)
    public void testEditTBL_A69() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.HHKNHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setSakujyoTrkKzknm1("削除登録家族名１");
        editTtdkKanryouParam.setSakujyoTrkKzknm2("削除登録家族名２");

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean = new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.BLNK, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "01", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "02", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "06", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "24", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "02", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "02", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "04", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "50", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "00", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "0", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "0", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "1", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

    @Test
    @TestOrder(700)
    public void testEditTBL_A70() {
        GetKhKykdrInfoForHozen.SYORIPTN = GetKhKykdrInfoForHozen.TESTPATTERN1;
        MockObjectManager.initialize();
        khozenCommonParam.setSikibetuKey("20201201102134200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20201201102134200");

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾁ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = null;
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate dispsyoriymd = BizDate.valueOf(20200202);

        editTtdkKanryouParam.setShsyno("8599999");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名（漢字）");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.NKTKYKHUKA);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setStdrsknmkn("ユヒメイ");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setKykdairinmkj("");

        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20200301));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.BLNK);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.BLNK);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setTmttknitenYmd(BizDate.valueOf("20200302"));
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setDseisanzeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanLst = new ArrayList<TyokusouTaisyouBean>();
        TyokusouTaisyouBean tyokusouTaisyouBean1 = new TyokusouTaisyouBean();
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean1);
        TyokusouTaisyouBean tyokusouTaisyouBean2 = new TyokusouTaisyouBean();
        tyokusouTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBeanLst.add(tyokusouTaisyouBean2);
        editTtdkKanryouParam.setTyokusouTaisyouList(tyokusouTaisyouBeanLst);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "17806000149", "証券番号");

        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "ユ被名　一お", "登録家族名（漢字）１");
        exClassificationEquals(ttdkKan.getTrkkzksei1(), C_Seibetu.BLNK, "登録家族性別１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(19800205), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "7654321", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "登録家族住所１１", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "登録家族住所２２", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "登録家族住所３３", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "050-1235-5698", "登録家族電話番号１");
        exClassificationEquals(ttdkKan.getTrkkzktdk1(), C_Tdk.BLNK, "登録家族続柄１");


        exClassificationEquals(ttdkKan.getTrkkzkkbn2(), C_TrkKzkKbn.TRKKZK2, "登録家族区分２");
        exStringEquals(ttdkKan.getTrkkzknmkj2(), "ユ被名　一お", "登録家族名（漢字）２");
        exClassificationEquals(ttdkKan.getTrkkzksei2(), C_Seibetu.BLNK, "登録家族性別２ ");
        exDateEquals(ttdkKan.getTrkkzkseiymd2(), BizDate.valueOf(19800205), "登録家族生年月日２");
        exStringEquals(ttdkKan.getTrkkzkyno2(), "7654321", "登録家族郵便番号２");
        exStringEquals(ttdkKan.getTrkkzkadr1kj2(), "登録家族住所１１", "登録家族住所１（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr2kj2(), "登録家族住所２２", "登録家族住所２（漢字）２");
        exStringEquals(ttdkKan.getTrkkzkadr3kj2(), "登録家族住所３３", "登録家族住所３（漢字）２");
        exStringEquals(ttdkKan.getTrkkzktelno2(), "050-1235-5698", "登録家族電話番号２");
        exClassificationEquals(ttdkKan.getTrkkzktdk2(), C_Tdk.BLNK, "登録家族続柄２");

        exStringEquals(ttdkKan.getKykdairinmkj(), "", "契約者代理人名（漢字）");

        exStringEquals(ttdkKan.getKykomttutkbn(), "02", "契約者用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "00", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkomttutkbn2(), "00", "家族２用表通知区分");
        exStringEquals(ttdkKan.getHhkomttutkbn(), "00", "被保険者用表通知区分");
        exStringEquals(ttdkKan.getKykurtutkbn(), "01", "契約者用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn2(), "", "家族２用裏通知区分");

        exStringEquals(ttdkKan.getKykaistmsgkbn(), "04", "契約者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "00", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn2(), "00", "家族２用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkaistmsgkbn(), "00", "被保険者用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getSakujyokzknmkj(), "", "削除家族名");

        exStringEquals(ttdkKan.getTtdknaiyoukbn(), "01", "手続内容区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "", "家族用対象契約区分");

        exStringEquals(ttdkKan.getMoshnkniymsgkbn1(), "01", "申込変更内容ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykmoshnkniymsg2(), "01", "契約者用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg22(), "", "家族２用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykdrmsgkbn(), "00", "契約者代理ＭＳＧ区分");

        exStringEquals(ttdkKan.getKykhhkdrmsg(), "00", "契約者用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzkhhkdrmsg2(), "", "家族２用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getHhkdrnmkj(), "", "被保険者代理人名（漢字）");

        exStringEquals(ttdkKan.getDuhubutumsg1(), "01", "同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getDuhubutumsg2(), "04", "同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getDuhubutumsg3(), "50", "同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getDuhubutumsg4(), "00", "同封物ＭＳＧ区分４");
        exStringEquals(ttdkKan.getDuhubutumsg5(), "00", "同封物ＭＳＧ区分５");
        exStringEquals(ttdkKan.getDuhubutumsg6(), "00", "同封物ＭＳＧ区分６");
        exStringEquals(ttdkKan.getDuhubutumsg7(), "00", "同封物ＭＳＧ区分７");
        exStringEquals(ttdkKan.getYakkankiyakuhunyuuhyouji(), "1", "約款規約封入表示");
        exStringEquals(ttdkKan.getKyktrktrshuunyuuhyouji(), "0", "登録チラシ封入表示（契）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji2(), "0", "登録チラシ封入表示（家族２）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "0", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "0", "被保険者代理封入表示");

    }

}