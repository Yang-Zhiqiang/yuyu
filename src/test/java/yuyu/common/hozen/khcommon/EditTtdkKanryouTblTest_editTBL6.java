package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GengkhouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
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
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editTBL(KhozenCommonParam, IT_KykKihon, List<IT_KykSyouhn>, IT_KykSya, IT_HhknSya, EditTtdkKanryouParam, IT_KhShrRireki, IT_KhHasseijiKazeiRireki, IT_KykSonotaTkyk, BizDate, C_HassouKbn, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editTBL6 extends AbstractTest{

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20200619";

    @Before
    public void beforeTest() {
        changeSystemDate(BizDate.valueOf(2015, 12, 20));
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editTBL1.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        bizDomManager.delete(bizDomManager.getAllGinkou());
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｹ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "01", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001010", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）積立金相当額", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　９，９９９，９９９，９９９，９９９　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：基準金額×控除率　（契約日からの経過年数１年未満につき１１０．００％）", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、市場金利の変動に応じた市場価格調整（※）を適用し計算するため、市場金利の", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　変動により解約日の積立金額から増減します。また、解約時等にかかる費用（解約控除）として、", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　基準金額の一定割合（契約日からの経過年数に応じた所定の控除率）を差し引きます。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　（※）市場価格調整について", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　　しくみをいいます。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　・一般的に市場金利が高くなると資産の価値が減少するため解約返戻金額は減少し、市場金利が", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　　　　低くなると資産の価値が増加するため解約返戻金額も増加します。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１６");
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

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕﾍ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.ARI);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "02", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001021", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）－（３）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）積立金相当額", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "　（３）解約控除額（※）", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "　　　９，９９９，９９９，９９９，９９９　円", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "※解約控除額：基準金額×控除率　（契約日からの経過年数１年未満につき１１０．００％）", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、市場金利の変動に応じた市場価格調整（※）を適用し計算するため、市場金利の", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　変動により解約日の積立金額から増減します。また、解約時等にかかる費用（解約控除）として、", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　基準金額の一定割合（契約日からの経過年数に応じた所定の控除率）を差し引きます。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "　　（※）市場価格調整について", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "　　　　・市場価格調整とは、市場金利の変動に応じた運用資産の価格変動を解約返戻金額に反映させる", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　　　　　しくみをいいます。", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　　　・一般的に市場金利が高くなると資産の価値が減少するため解約返戻金額は減少し、市場金利が", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　　　　　低くなると資産の価値が増加するため解約返戻金額も増加します。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "【解約返戻金に対する税務のご説明】", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言１３");
        exStringEquals(ttdkKan.getOsirasemongon14(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言１４");
        exStringEquals(ttdkKan.getOsirasemongon15(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１５");
        exStringEquals(ttdkKan.getOsirasemongon16(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１６");
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

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        khozenCommonParam.setSikibetuKey("20151201102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(C_SyutkKbn.SYU, "ﾕｱ", 1, 1);
        kykSyouhnLst.add(kykSyouhn);
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhShrRireki();
        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20151201102134233").getKhHasseijiKazeiRireki();
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate dispsyoriymd = null;
        editTtdkKanryouParam.setShsyno("7654321");
        editTtdkKanryouParam.setShsadr1kj("送付先住所１");
        editTtdkKanryouParam.setShsadr2kj("送付先住所２");
        editTtdkKanryouParam.setShsadr3kj("送付先住所３");
        editTtdkKanryouParam.setShsnmkj("送付先氏名");
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.TARGETSYUUSINHENKOU);
        editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.KYKSB);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setBfrNenkinsyu(C_Nenkinsyu.BLNK);
        editTtdkKanryouParam.setBfrNenkinkkn(5);
        editTtdkKanryouParam.setBfrTargettkmokuhyouti(1000);
        editTtdkKanryouParam.setStdrskKjkhuka(C_KjkhukaKbn.BLNK);
        editTtdkKanryouParam.setStdrsknmkj("指定代理請求人名");
        editTtdkKanryouParam.setStdrsknmkn("代理請求人名");
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.BLNK);
        editTtdkKanryouParam.setHhknseiymdHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setHhknseiHnUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setCalckijyunYMD(BizDate.valueOf(20160401));
        editTtdkKanryouParam.setBfrKihons(BizCurrency.valueOf(400));
        editTtdkKanryouParam.setGengkhou(C_GengkhouKbn.SD);
        editTtdkKanryouParam.setBfrP(BizCurrency.valueOf(600));
        editTtdkKanryouParam.setYenShrTkHnkKbn(C_YenShrTkHnkKbn.TOKUYAKUHUKA);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.BLNK);
        editTtdkKanryouParam.setSoukinsakisiteikbn(C_SoukinsakisiteiKbn.BLNK);
        editTtdkKanryouParam.setGsbunritaisyouFlg(C_UmuKbn.NONE);

        IT_TtdkKan ttdkKan = editTtdkKanryouTbl.editTBL(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, khShrRireki, khHasseijiKazeiRireki, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);

        exStringEquals(ttdkKan.getKbnkey(), "03", "区分キー");
        exStringEquals(ttdkKan.getSyono(), "99806001032", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "20151201102134233", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "書類コード");
        exStringEquals(ttdkKan.getBikou1(), "解約返戻金額＝（１）×（２）", "備考１");
        exStringEquals(ttdkKan.getBikou2(), "　（１）保険料積立金", "備考２");
        exStringEquals(ttdkKan.getBikou3(), "　　　２３，５４３　円", "備考３");
        exStringEquals(ttdkKan.getBikou4(), "　（２）市場価格調整率", "備考４");
        exStringEquals(ttdkKan.getBikou5(), "　　　１１０．００００００００％", "備考５");
        exStringEquals(ttdkKan.getBikou6(), "", "備考６");
        exStringEquals(ttdkKan.getBikou7(), "", "備考７");
        exStringEquals(ttdkKan.getBikou8(), "", "備考８");
        exStringEquals(ttdkKan.getBikou9(), "必要書類の受付日翌日から５営業日を超えた２５日分", "備考９");
        exStringEquals(ttdkKan.getBikou10(), "", "備考１０");

        exStringEquals(ttdkKan.getShrnaiyouhskmongon1(), "", "支払内容補足文言１");
        exStringEquals(ttdkKan.getShrnaiyouhskmongon2(), "", "支払内容補足文言２");

        exStringEquals(ttdkKan.getOsirasemongon1(), "【お支払内容について】", "お知らせ文言１");
        exStringEquals(ttdkKan.getOsirasemongon2(), "　◆解約日は完備された手続書類を当社が受け付けた日となります。", "お知らせ文言２");
        exStringEquals(ttdkKan.getOsirasemongon3(), "　◆解約返戻金額は、契約日から一定期間（解約日が第１保険期間または第２保険期間となる場合）、", "お知らせ文言３");
        exStringEquals(ttdkKan.getOsirasemongon4(), "　　市場金利の変動に応じた市場価格調整（※）を適用し計算するため、解約日の保険料積立金額から", "お知らせ文言４");
        exStringEquals(ttdkKan.getOsirasemongon5(), "　　増減します。", "お知らせ文言５");
        exStringEquals(ttdkKan.getOsirasemongon6(), "", "お知らせ文言６");
        exStringEquals(ttdkKan.getOsirasemongon7(), "【解約返戻金に対する税務のご説明】", "お知らせ文言７");
        exStringEquals(ttdkKan.getOsirasemongon8(), "　◆この生命保険契約は日本国内において締結されたものであることから、税制上のお取扱いは、外貨（指定通", "お知らせ文言８");
        exStringEquals(ttdkKan.getOsirasemongon9(), "　　貨または選択通貨）を円貨に換算したうえで、円建の生命保険と同様に取り扱います。", "お知らせ文言９");
        exStringEquals(ttdkKan.getOsirasemongon10(), "　◆収入金額は、解約日の為替レートにて円換算した金額です。", "お知らせ文言１０");
        exStringEquals(ttdkKan.getOsirasemongon11(), "　◆税務取扱および申告手続の詳細については、所轄の税務署にお問い合わせください。", "お知らせ文言１１");
        exStringEquals(ttdkKan.getOsirasemongon12(), "", "お知らせ文言１２");
        exStringEquals(ttdkKan.getOsirasemongon13(), "", "お知らせ文言１３");
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

    }

}
