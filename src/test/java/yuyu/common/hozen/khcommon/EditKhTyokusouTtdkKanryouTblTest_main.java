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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkHnkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保全直送用手続完了ＴＢＬ編集のメソッド{@link EditKhTyokusouTtdkKanryouTbl#main(KhozenCommonParam, IT_KykKihon, List<IT_KykSyouhn>, IT_KykSya, IT_HhknSya, EditTtdkKanryouParam, IT_KykSonotaTkyk, BizDate, C_HassouKbn, C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKhTyokusouTtdkKanryouTblTest_main extends AbstractTest{

    @Inject
    private EditKhTyokusouTtdkKanryouTbl editKhTyokusouTtdkKanryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouParam editTtdkKanryouParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinoInfo;

    private static String uketimecallcenter1;

    private static String uketimecallcenter2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全直送手続完了TBL編集";

    private final static String sheetName = "INデータ_20200819";

    @BeforeClass
    @Transactional
    public static void testInit() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;
        uketimecallcenter1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
        uketimecallcenter2 = YuyuBizConfig.getInstance().getUketimecallcenter2();

        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKhTyokusouTtdkKanryouTblTest_main.class, fileName, sheetName);
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

        YuyuBizConfig.getInstance().setUketimecallcenter1(uketimecallcenter1);
        YuyuBizConfig.getInstance().setUketimecallcenter2(uketimecallcenter2);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testMain_A1() {

        khozenCommonParam.setSikibetuKey("20200701102134233");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 0, "手続完了テーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testMain_A2() {

        changeSystemDate(BizDate.valueOf(20200713));

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK1);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.TOUROKU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj(null);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001021", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "020200701102134234", "変更識別キー");
        exClassificationEquals(ttdkKan.getSyoruiCd(), C_SyoruiCdKbn.KK_YENDTHNK_SKS, "書類コード");
        exDateEquals(ttdkKan.getTyouhyouymd(), BizDate.valueOf(20200713), "帳票作成日");
        exClassificationEquals(ttdkKan.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(ttdkKan.getTantousitukbn(), C_TantousituKbn.HOZENHENKOUSV, "担当室区分");
        exClassificationEquals(ttdkKan.getSyoukendhumukbn(), C_UmuKbn.NONE, "証券同封有無区分");
        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字）（３０桁）");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKan.getShsadr3kj(), "中田市", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKan.getShsnmkj(), "被名　一あ", "送付先氏名（漢字）");
        exStringEquals(ttdkKan.getToiawasesosikinmkj(), "スミセイコールセンター", "問合せ先組織名（漢字）");
        exStringEquals(ttdkKan.getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(ttdkKan.getToiawaseadr1kj(), "大阪市中央区城見", "問合せ先住所１（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr2kj(), "１－４－３５", "問合せ先住所２（漢字）");
        exStringEquals(ttdkKan.getToiawaseadr3kj(), "東京都中央区築地", "問合せ先住所３（漢字）");
        exStringEquals(ttdkKan.getToiawasekaisyanmkj(), "住友生命保険相互会社", "問合せ先会社名（漢字）");
        exStringEquals(ttdkKan.getToiawasetelno(), "0120-506-081", "問合せ先電話番号");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(ttdkKan.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exClassificationEquals(ttdkKan.getShrumu(), C_UmuKbn.ARI, "支払有無区分");
        exClassificationEquals(ttdkKan.getSyorikbn(), C_SyoriKbn.CLGOFF, "処理区分");
        exStringEquals(ttdkKan.getKyknmkj(), "ユ被名　一あ", "契約者名（漢字）");
        exDateEquals(ttdkKan.getKykymd(), BizDate.valueOf(20170424), "契約日");
        exStringEquals(ttdkKan.getSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名");
        exStringEquals(ttdkKan.getHhknnmkj(), "ユ名　一あ", "被保険者名（漢字）");
        exStringEquals(ttdkKan.getGyoumuKousinKinou(), "EditKhTyokusouTtdkKanryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinsyaId(), "Y001", "業務用更新者ＩＤ");
        exStringEquals(ttdkKan.getGyoumuKousinTime().substring(0, 8), "20200713", "業務用更新時間");
        exStringEquals(ttdkKan.getDocumentid(), "123456", "ドキュメントＩＤ");
        exClassificationEquals(ttdkKan.getSksmongonkbn1(), C_SksmongonKbn.YENDTSYSN, "請求書文言区分１");
        exClassificationEquals(ttdkKan.getSksmongonkbn2(), C_SksmongonKbn.YENDTSYSN, "請求書文言区分２");
        exNumericEquals(ttdkKan.getHozonKikan(), 7, "保存期間");
        exStringEquals(ttdkKan.getTsintelno(), "01-2345-6789", "通信先電話番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "08", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "11", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "03", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testMain_A3() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        TyokusouTaisyouBean tyokusouTaisyouBean1 =new TyokusouTaisyouBean();
        tyokusouTaisyouBean1.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK1);
        tyokusouTaisyouBean1.setNmkj("被名　一あ二");
        tyokusouTaisyouBean1.setSeiYmd(BizDate.valueOf(20190102));
        tyokusouTaisyouBean1.setYno("0100002");
        tyokusouTaisyouBean1.setAdr1kj("秋田市２");
        tyokusouTaisyouBean1.setAdr2kj("中通２");
        tyokusouTaisyouBean1.setAdr3kj("中田市２");
        tyokusouTaisyouBean1.setTelno("02-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean1);

        TyokusouTaisyouBean tyokusouTaisyouBean2 =new TyokusouTaisyouBean();
        tyokusouTaisyouBean2.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN);
        tyokusouTaisyouBean2.setNmkj("被名　一あ三");
        tyokusouTaisyouBean2.setSeiYmd(BizDate.valueOf(20190103));
        tyokusouTaisyouBean2.setYno("0100003");
        tyokusouTaisyouBean2.setAdr1kj("秋田市３");
        tyokusouTaisyouBean2.setAdr2kj("中通３");
        tyokusouTaisyouBean2.setAdr3kj("中田市３");
        tyokusouTaisyouBean2.setTelno("03-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean2);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 3, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001032", "証券番号");
        exStringEquals(ttdkKan.getHenkousikibetukey(), "020200701102134234", "変更識別キー");
        exStringEquals(ttdkKan.getShskyno(), "0100001", "送付先郵便番号");
        exStringEquals(ttdkKan.getShsadr1kj(), "秋田市", "送付先住所１（漢字（３０桁））");
        exStringEquals(ttdkKan.getShsadr2kj(), "中通", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKan.getShsadr3kj(), "中田市", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKan.getShsnmkj(), "被名　一あ", "送付先氏名（漢字）");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");

        IT_TtdkKan ttdkKan1 = ttdkKanList.get(1);

        exStringEquals(ttdkKan1.getSyono(), "99806001032", "証券番号");
        exStringEquals(ttdkKan1.getHenkousikibetukey(), "020200701102134235", "変更識別キー");
        exStringEquals(ttdkKan1.getShskyno(), "0100002", "送付先郵便番号");
        exStringEquals(ttdkKan1.getShsadr1kj(), "秋田市２", "送付先住所１（漢字（３０桁））");
        exStringEquals(ttdkKan1.getShsadr2kj(), "中通２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKan1.getShsadr3kj(), "中田市２", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKan1.getShsnmkj(), "被名　一あ二", "送付先氏名（漢字）");
        exClassificationEquals(ttdkKan1.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan1.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan1.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan1.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan1.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan1.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan1.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan1.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan1.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan1.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan1.getKzkaistmsgkbn1(), "08", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan1.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan1.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan1.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan1.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan1.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan1.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan1.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan1.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan1.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");

        IT_TtdkKan ttdkKan2 = ttdkKanList.get(2);

        exStringEquals(ttdkKan2.getSyono(), "99806001032", "証券番号");
        exStringEquals(ttdkKan2.getHenkousikibetukey(), "020200701102134236", "変更識別キー");
        exStringEquals(ttdkKan2.getShskyno(), "0100003", "送付先郵便番号");
        exStringEquals(ttdkKan2.getShsadr1kj(), "秋田市３", "送付先住所１（漢字（３０桁））");
        exStringEquals(ttdkKan2.getShsadr2kj(), "中通３", "送付先住所２（漢字）（３０桁）");
        exStringEquals(ttdkKan2.getShsadr3kj(), "中田市３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(ttdkKan2.getShsnmkj(), "被名　一あ三", "送付先氏名（漢字）");
        exClassificationEquals(ttdkKan2.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan2.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan2.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan2.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan2.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan2.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan2.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan2.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan2.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan2.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan2.getKzkaistmsgkbn1(), "08", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan2.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan2.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan2.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan2.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan2.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan2.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan2.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan2.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan2.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testMain_A4() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001043", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testMain_A5() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001054");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDTRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001054", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "30", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testMain_A6() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001065");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001065", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "31", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testMain_A7() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001076");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001076", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "31", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testMain_A8() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001087");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDKYKDRN);
        tyokusouTaisyouBean.setNmkj("被名　一あ一");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.KYK);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001087", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testMain_A9() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001098");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.KYK);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001098", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.BLNK, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testMain_A10() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001102");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001102", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testMain_A11() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001113");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001113", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testMain_A12() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001124");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001124", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "09", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testMain_A13() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001135");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001135", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testMain_A14() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001146");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj(null);
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001146", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testMain_A15() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001157");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001157", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testMain_A16() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001168");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001168", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "09", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testMain_A17() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001179");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001179", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testMain_A18() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001180");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj(null);
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001180", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testMain_A19() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001191");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001191", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testMain_A20() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001205");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001205", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testMain_A21() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001216");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK1);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001216", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "11", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "03", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testMain_A22() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001227");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK2);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001227", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "02", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "10", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "14", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "03", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testMain_A23() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001238");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.TRKKZK2);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001238", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "03", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testMain_A24() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001249");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.SONOTA);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001249", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "03", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testMain_A25() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001250");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MEIGIHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.SONOTA);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001250", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "41", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "31", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "03", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testMain_A26() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001261");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MEIGIHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.SONOTA);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIJYO);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001261", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "42", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testMain_A27() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001272");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.MEIGIHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.SONOTA);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001272", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testMain_A28() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001283");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.ADRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.SONOTA);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001283", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testMain_A29() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001294");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001294", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testMain_A30() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001308");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.TOUROKU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001308", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testMain_A31() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001319");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.SAKUJYO);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001319", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "28", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testMain_A32() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001320");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001320", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "27", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testMain_A33() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001331");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001331", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "07", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "11", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "02", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "03", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "1", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testMain_A34() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001342");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001342", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "08", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "12", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testMain_A35() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001353");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001353", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "07", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "12", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "02", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testMain_A36() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001364");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001364", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "31", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testMain_A37() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001375");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001375", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "22", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testMain_A38() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001386");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001386", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "23", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testMain_A39() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001397");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.SYUURYOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001397", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testMain_A40() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001401");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001401", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testMain_A41() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001412");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.BLNK);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.TOUROKU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "99806001412", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "08", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "12", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "01", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "1", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testMain_A42() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000024", "証券番号");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "09", "家族１用挨拶ＭＳＧ区分");
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testMain_A43() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.HENKOU);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.KAIYAKU);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.HENKOU);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.HENKOU);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000035", "証券番号");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testMain_A44() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000046", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(450)
    @Transactional
    public void testMain_A45() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TYUUTOHUKA);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000057", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "09", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(460)
    @Transactional
    public void testMain_A46() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000068", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testMain_A47() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.HENKOU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU1);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000079", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "05", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "01", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "09", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "13", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "02", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "1", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(480)
    @Transactional
    public void testMain_A48() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.SONOTA);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000080", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

    @Test
    @TestOrder(490)
    @Transactional
    public void testMain_A49() {

        khozenCommonParam.setSikibetuKey("20200701102134233");
        kinoInfo.setKinouId("EditKhTyokusouTtdkKanryouTbl");
        baseUserInfo.getUser().setUserId("Y001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<TyokusouTaisyouBean> TyokusouTaisyouBeanList = new ArrayList<>();
        TyokusouTaisyouBean tyokusouTaisyouBean =new TyokusouTaisyouBean();
        tyokusouTaisyouBean.setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn.TRKKZK2);
        tyokusouTaisyouBean.setNmkj("被名　一あ");
        tyokusouTaisyouBean.setSeiYmd(BizDate.valueOf(20190101));
        tyokusouTaisyouBean.setYno("0100001");
        tyokusouTaisyouBean.setAdr1kj("秋田市");
        tyokusouTaisyouBean.setAdr2kj("中通");
        tyokusouTaisyouBean.setAdr3kj("中田市");
        tyokusouTaisyouBean.setTelno("01-2345-6789");
        TyokusouTaisyouBeanList.add(tyokusouTaisyouBean);

        editTtdkKanryouParam.setTyokusouTaisyouList(TyokusouTaisyouBeanList);
        editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KZKTRKKYKDRHNK);
        editTtdkKanryouParam.setMousideninKbn(C_MousideninKbn.KYKHONNIN);
        editTtdkKanryouParam.setTrkKzkServicettdkKbn(C_KzkTrkServicettdkKbn.BLNK);
        editTtdkKanryouParam.setKykdrtkykttdkKbn(C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU);
        editTtdkKanryouParam.setBfrKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setAftKykdairinKbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdruktkbn(C_UktKbn.TOUROKUKAZOKU2);
        editTtdkKanryouParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.BLNK);
        editTtdkKanryouParam.setKykdairinmkj("ユヒメイ　イチ");
        editTtdkKanryouParam.setStdrsknmkj("ヒメイ　イチ");
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn1(C_TrkKzkHnkKbn.BLNK);
        editTtdkKanryouParam.setTrkkzkttdkKbn1(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setTrkKzkHnkNiyuKbn2(C_TrkKzkHnkKbn.SAKUJYO);
        editTtdkKanryouParam.setTrkkzkttdkKbn2(C_TrkkzkttdkKbn.BLNK);
        editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
        editTtdkKanryouParam.setSyorikbn(C_SyoriKbn.CLGOFF);
        editTtdkKanryouParam.setDocumentId("123456");
        editTtdkKanryouParam.setSksmongonKbn1(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setSksmongonKbn2(C_SksmongonKbn.YENDTSYSN);
        editTtdkKanryouParam.setHozonKikanY(7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        BizDate dispsyoriymd = BizDate.valueOf(20200713);
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        List<IT_TtdkKan> ttdkKanList = editKhTyokusouTtdkKanryouTbl.main(khozenCommonParam, kykKihon, kykSyouhnLst, kykSya, hhknSya,
            editTtdkKanryouParam, kykSonotaTkyk, dispsyoriymd, hassouKbn, C_SyoruiCdKbn.KK_YENDTHNK_SKS);

        exNumericEquals(ttdkKanList.size(), 1, "手続完了テーブルエンティティリストの件数");

        IT_TtdkKan ttdkKan = ttdkKanList.get(0);

        exStringEquals(ttdkKan.getSyono(), "17806000091", "証券番号");
        exClassificationEquals(ttdkKan.getTrkkzkkbn1(), C_TrkKzkKbn.TRKKZK1, "登録家族区分１");
        exStringEquals(ttdkKan.getTrkkzknmkj1(), "被名　一あ", "登録家族名（漢字）１");
        exDateEquals(ttdkKan.getTrkkzkseiymd1(), BizDate.valueOf(20190101), "登録家族生年月日１");
        exStringEquals(ttdkKan.getTrkkzkyno1(), "0100001", "登録家族郵便番号１");
        exStringEquals(ttdkKan.getTrkkzkadr1kj1(), "秋田市", "登録家族住所１（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr2kj1(), "中通", "登録家族住所２（漢字）１");
        exStringEquals(ttdkKan.getTrkkzkadr3kj1(), "中田市", "登録家族住所３（漢字）１");
        exStringEquals(ttdkKan.getTrkkzktelno1(), "01-2345-6789", "登録家族電話番号１");
        exStringEquals(ttdkKan.getKzkomttutkbn1(), "01", "家族１用表通知区分");
        exStringEquals(ttdkKan.getKzkurtutkbn1(), "", "家族１用裏通知区分");
        exStringEquals(ttdkKan.getKzkaistmsgkbn1(), "29", "家族１用挨拶ＭＳＧ区分");
        exStringEquals(ttdkKan.getKzktaisyoukykkbn(), "2", "家族用対象契約区分");
        exStringEquals(ttdkKan.getKzkmoshnkniymsg21(), "", "家族１用申込変更内容ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKzkhhkdrmsg1(), "11", "家族１用被保険者代理ＭＳＧ区分");
        exStringEquals(ttdkKan.getKykigaidhbtmsg1(), "", "契約者以外用同封物ＭＳＧ区分１");
        exStringEquals(ttdkKan.getKykigaidhbtmsg2(), "", "契約者以外用同封物ＭＳＧ区分２");
        exStringEquals(ttdkKan.getKykigaidhbtmsg3(), "", "契約者以外用同封物ＭＳＧ区分３");
        exStringEquals(ttdkKan.getKzktrktrshuunyuuhyouji1(), "", "登録チラシ封入表示（家族１）");
        exStringEquals(ttdkKan.getKykdrhuunyuuhyouji(), "", "契約者代理封入表示");
        exStringEquals(ttdkKan.getHhkdrhuunyuuhyouji(), "", "被保険者代理封入表示");
    }

}
