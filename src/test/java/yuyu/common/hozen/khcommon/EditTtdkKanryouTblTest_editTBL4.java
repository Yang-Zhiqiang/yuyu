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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.AS_Kinou;
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
public class EditTtdkKanryouTblTest_editTBL4 extends AbstractTest {

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinoInfo;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20191128";

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoForHozen.class);
                bind(BzGetSosikiMadogutiInfo.class).to(BzGetSosikiMadogutiInfoMockForHozen.class);
            }
        });
        GetKhKykdrInfoForHozen.caller = EditTtdkKanryouTblTest_editTBL4.class;
        BzGetSosikiMadogutiInfoMockForHozen.caller = EditTtdkKanryouTblTest_editTBL4.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL4.class, fileName, sheetName);
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

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        bizDomManager.delete(bizDomManager.getAllGinkou());

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
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.SYOUMETUJISOUHUSAKI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU );

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "05", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111152", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "・特別配当金", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "源泉徴収税額", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "お支払配当金利息", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.HU, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(3), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(1), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(1), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.JPY, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１０　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約日時点の当社所定の為替レート", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "解約", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();

        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setPminyuuSyoumetuShrtyousyoOutZumiFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "09", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111196", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getShskyno(), "", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "", "送付先住所１（漢字）");
        exStringEquals(ttdkKan.getShsadr2kj(), "", "送付先住所２（漢字）");
        exStringEquals(ttdkKan.getShsadr3kj(), "", "送付先住所３（漢字）");
        exStringEquals(ttdkKan.getShsnmkj(), "", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111118", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(20), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１９年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111130", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１０　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※書類完備日時点の当社所定の為替レート", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(20), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１９年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(5), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "死亡", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.KAIYAKU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "08", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111185", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１０　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約日時点の当社所定の為替レート", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(20), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１９年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), -1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(5), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "解約", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.ARI);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "06", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111163", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.JPY, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(20), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１９年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "死亡", "Ｄ精算支払手続名");
    }


    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.ARI);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.SK_SAKUJOKYKMEISAILIST);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111129", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(0), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(0), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.BLNK, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(0), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.BLNK,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.NONE, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111200");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.BLNK);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "00", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111200", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１０　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(20), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１９年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "※ご契約期間中に契約者の変更がありました。", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "　確定申告については所轄の税務署にお問い合わせください。", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), -1, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(5), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "", "Ｄ精算支払手続名");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        MockObjectManager.initialize();
        kinoInfo.setKinouId("EditTtdkKanryouTbl");
        kinoInfo.setCategoryId("khcommon");
        baseUserInfo.getUser().setUserId("Y001");
        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
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

        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setYuuyokknTyoukaUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editTtdkKanryouParam.setDseisantetudukimeiKbn(C_DseisantetudukimeiKbn.SIBOU);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn,
            C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "04", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "11807111141", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR, "書類コード");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENSIHARAISV, "担当室区分");
        exStringEquals(ttdkKan.getTekiyou1(), "お支払配当金額", "摘要１");
        exStringEquals(ttdkKan.getTekiyou2(), "（明細）", "摘要２");
        exStringEquals(ttdkKan.getTekiyou3(), "・配当金", "摘要３");
        exStringEquals(ttdkKan.getTekiyou4(), "", "摘要４");
        exStringEquals(ttdkKan.getTekiyou5(), "", "摘要５");
        exStringEquals(ttdkKan.getTekiyou6(), "", "摘要６");
        exStringEquals(ttdkKan.getTekiyou7(), "", "摘要７");
        exStringEquals(ttdkKan.getTekiyou8(), "", "摘要８");
        exStringEquals(ttdkKan.getTekiyou9(), "", "摘要９");
        exStringEquals(ttdkKan.getTekiyou10(), "", "摘要１０");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou1(), C_HugouKbn.SEI, "支払金額明細符号１");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou2(), C_HugouKbn.SEI, "支払金額明細符号２");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou3(), C_HugouKbn.SEI, "支払金額明細符号３");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou4(), C_HugouKbn.SEI, "支払金額明細符号４");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou5(), C_HugouKbn.SEI, "支払金額明細符号５");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou6(), C_HugouKbn.SEI, "支払金額明細符号６");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou7(), C_HugouKbn.SEI, "支払金額明細符号７");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou8(), C_HugouKbn.SEI, "支払金額明細符号８");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou9(), C_HugouKbn.SEI, "支払金額明細符号９");
        exClassificationEquals(ttdkKan.getShrkngkmeisaihugou10(), C_HugouKbn.SEI, "支払金額明細符号１０");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai1(), BizCurrency.valueOf(10), "金額明細１");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai2(), BizCurrency.valueOf(0), "金額明細２");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai3(), BizCurrency.valueOf(2), "金額明細３");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai4(), BizCurrency.valueOf(0), "金額明細４");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai5(), BizCurrency.valueOf(0), "金額明細５");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai6(), BizCurrency.valueOf(0), "金額明細６");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai7(), BizCurrency.valueOf(0), "金額明細７");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai8(), BizCurrency.valueOf(0), "金額明細８");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai9(), BizCurrency.valueOf(0), "金額明細９");
        exBizCalcbleEquals(ttdkKan.getKngkmeisai10(), BizCurrency.valueOf(0), "金額明細１０");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu1(), C_Tuukasyu.BLNK, "金額明細通貨種類１");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu2(), C_Tuukasyu.BLNK, "金額明細通貨種類２");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu3(), C_Tuukasyu.JPY, "金額明細通貨種類３");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu4(), C_Tuukasyu.BLNK, "金額明細通貨種類４");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu5(), C_Tuukasyu.BLNK, "金額明細通貨種類５");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu6(), C_Tuukasyu.BLNK, "金額明細通貨種類６");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu7(), C_Tuukasyu.BLNK, "金額明細通貨種類７");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu8(), C_Tuukasyu.BLNK, "金額明細通貨種類８");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu9(), C_Tuukasyu.BLNK, "金額明細通貨種類９");
        exClassificationEquals(ttdkKan.getKngkmisituukasyu10(), C_Tuukasyu.BLNK, "金額明細通貨種類１０");
        exStringEquals(ttdkKan.getBikou1(), "・お支払配当金額はお支払配当金額（円）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　を外貨に換算した金額です。　（１）÷（２)", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　（１）お支払配当金額（円）", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　　　１０　円", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　（２）適用為替レート：２３．５６　円（※）", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※書類完備日時点の当社所定の為替レート", "支払内容補足文言１");
        exBizCalcbleEquals(ttdkKan.getSynykngk(), BizCurrency.valueOf(10), "収入金額");
        exBizCalcbleEquals(ttdkKan.getHtykeihi(), BizCurrency.valueOf(20), "必要経費");
        exStringEquals(ttdkKan.getZeimumongon1(), "※２０１９年の所得となります。", "税務文言１");
        exStringEquals(ttdkKan.getZeimumongon2(), "", "税務文言２");
        exStringEquals(ttdkKan.getZeimumongon3(), "", "税務文言３");
        exStringEquals(ttdkKan.getZeimumongon4(), "", "税務文言４");
        exStringEquals(ttdkKan.getZeimumongon5(), "", "税務文言５");
        exClassificationEquals(ttdkKan.getZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI,
            "税務内容編集制御区分");
        exClassificationEquals(ttdkKan.getZeimumongonoutkbn(), C_UmuKbn.ARI, "税務文言出力区分");
        exNumericEquals(ttdkKan.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(ttdkKan.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exStringEquals(ttdkKan.getDseisanshrttdknm(), "死亡", "Ｄ精算支払手続名");
    }

}