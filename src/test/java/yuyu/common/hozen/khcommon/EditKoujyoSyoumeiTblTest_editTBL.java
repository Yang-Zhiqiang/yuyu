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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明書TBL編集クラスのメソッド {@link EditKoujyoSyoumeiTbl#editTBL(KhozenCommonParam,IT_KykKihon,
            List,IT_KykSya,List,IT_KykUkt,List,IT_KhTtdkTyuui,
            EditKoujyoSyoumeiParam,C_HassouKbn,BizDate,int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKoujyoSyoumeiTblTest_editTBL {

    @Inject
    private EditKoujyoSyoumeiTbl editKoujyoSyoumeiTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditKoujyoSyoumeiParam editKoujyoSyoumeiParam;

    @Inject
    private AS_Kinou kinou;

    private final static String syoNo1 = "17806000013";

    private final static String syoNo2 = "17806000024";

    private final static String syoNo3 = "17806000035";

    private final static String syoNo4 = "17806000046";

    private final static String syoNo5 = "17806000057";

    private final static String syoNo6 = "17806000068";

    private final static String syoNo7 = "17806000079";

    private final static String syoNo8 = "17806000080";

    private final static String syoNo9 = "24809221158";

    private final static String syoNo10 = "24809221169";

    private final static String syoNo11 = "86809001231";

    private final static String syoNo12 = "17806000091";

    private final static String fileName = "UT_SP_単体テスト仕様書_控除証明書TBL編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuWaribikiPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());
        bizDomManager.delete(bizDomManager.getAllDairiten());
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        IT_KykKihon kykKihon = new IT_KykKihon();
        List<IT_KykSyouhn> kykSyohnSyuLst = null;
        IT_KykSya kykSya = new IT_KykSya();
        List<IT_KykUkt> kykUktLst = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        List<IT_KykDairiten> kyDaritenLst = new ArrayList<>();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        Assert.assertNull(null, koujyoSym);
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        IT_KykKihon kykKihon = new IT_KykKihon();
        List<IT_KykSyouhn> kykSyohnSyuLst = new ArrayList<>();
        IT_KykSya kykSya = new IT_KykSya();
        List<IT_KykUkt> kykUktLst = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        List<IT_KykDairiten> kyDaritenLst = new ArrayList<>();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        Assert.assertNull(null, koujyoSym);
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(null);
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setKoujyosyoumeimsgKbn(C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK);

        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo1, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exBooleanEquals(koujyoSym.getSyoumeistartym() == null, true, "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 0, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 0, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "保険証券をご覧ください。" ,"受取人名（漢字）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(0),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０２組織区分名０２", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "111-2222", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所２１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所２２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所２３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "444-5555-6666", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.NONE, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");
        exClassificationEquals(koujyoSym.getKoujyosyoumeimsgkbn(), C_KoujyosyoumeimsgKbn.YENHNDSNKKYTGKKSNHK,
            "控除証明メッセージ区分");

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(null);
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(2500));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setKoujyosyoumeimsgKbn(C_KoujyosyoumeimsgKbn.BLANK);

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo2, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201401), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), null, "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 0, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 0, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）００", "契約者名（カナ）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "契約者０１　様" ,"受取人名（漢字）");
        exStringEquals(koujyoSym.getUktnmkn(), "契約者名（カナ）００", "受取人名（カナ）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(2500), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(0),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所１２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所１３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");
        exClassificationEquals(koujyoSym.getKoujyosyoumeimsgkbn(), C_KoujyosyoumeimsgKbn.BLANK,
            "控除証明メッセージ区分");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(3500));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));

        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo3, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201601), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 1, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 0, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "被保険者名０３　様" ,"受取人名（漢字）");
        exStringEquals(koujyoSym.getUktnmkn(), "被保険者名（カナ）０３", "受取人名（カナ）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(0),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(3500),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０２組織区分名０２", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "111-2222", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所２１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所２２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所２３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "444-5555-6666", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");
        exClassificationEquals(koujyoSym.getSaihkhyjkbn(), C_SaihkHyjKbn.HIHYOUJI ,"再発行表示区分");

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201801));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(4500));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));

        YuyuBizConfig.getInstance().setCallcentersosikicd("test01");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo4, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201801), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 25, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 2, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "法定相続人様" ,"受取人名（漢字）");
        exStringEquals(koujyoSym.getUktnmkn(), "", "受取人名（カナ）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(0),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(4500), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０２組織区分名０２", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "111-2222", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所２１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所２２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所２３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "444-5555-6666", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(2600));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo5, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201401), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 25, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 2, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）０３" ,"契約者名（カナ） ");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "受取人０１　様" ,"受取人名（漢字）");
        exStringEquals(koujyoSym.getUktnmkn(), "受取人名（カナ）１２", "受取人名（カナ）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(2600),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所１２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所１３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(3600));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo6, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201401), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 25, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 2, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "契約者０１　様" ,"受取人名（漢字）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(0),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(3600),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所１２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所１３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(2500));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(2600));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(3500));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(3600));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(4500));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo7, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201401), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 25, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 2, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(2500), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(2600),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(3500),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(3600),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(4500), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所１２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所１３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = null;
        IT_KykUkt kykUkt = null;
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(2500));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(2600));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(3500));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(3600));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(4500));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(0));

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getSyono(), syoNo8, "証券番号");
        exStringEquals(koujyoSym.getNendo(), "2016" ,"年度");
        exDateEquals(koujyoSym.getTyouhyouymd(), BizDate.valueOf(20160418), "帳票作成日");
        exNumericEquals(koujyoSym.getRenno(), 1, "連番");
        exClassificationEquals(koujyoSym.getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exStringEquals(koujyoSym.getSyoumeiymd(), "20160401", "証明日");
        exDateYMEquals(koujyoSym.getSyoumeistartym(), BizDateYM.valueOf(201401), "証明開始年月");
        exDateYMEquals(koujyoSym.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exNumericEquals(koujyoSym.getSyoumeikkntukisuu(), 25, "証明期間月数");
        exNumericEquals(koujyoSym.getSyoumeikknnensuu(), 2, "証明期間年数");
        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）０６" ,"契約者名（カナ） ");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "" ,"受取人名（漢字）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(koujyoSym.getHknsyuruinmrykkj(), "商品略称０１" ,"保険種類略称（漢字）");
        exDateEquals(koujyoSym.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getNenkanhrkkaisuu(), 2, "年間払込回数");
        exNumericEquals(koujyoSym.getPhrkkkn(), 0, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, true, "年金支払開始日");
        exStringEquals(koujyoSym.getNknshry(), "" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(koujyoSym.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(koujyoSym.getHaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekip(), BizCurrency.valueOf(1100),"旧制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanp(), BizCurrency.valueOf(1200), "旧制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekihaitoukin(),BizCurrency.valueOf(1300), "旧制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getOldippannenkanhaitoukin(), BizCurrency.valueOf(1400),"旧制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getOldippanjissekisyoumeigk(), BizCurrency.valueOf(1500), "旧制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getOldippannenkansyoumeigk(), BizCurrency.valueOf(1600), "旧制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekip(), BizCurrency.valueOf(2100), "新制度一般実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanp(), BizCurrency.valueOf(2200), "新制度一般年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekihaitoukin(), BizCurrency.valueOf(2300), "新制度一般実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewippannenkanhaitoukin(), BizCurrency.valueOf(2400), "新制度一般年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(2500), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(2600),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekip(), BizCurrency.valueOf(3100),"新制度介護医療実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanp(), BizCurrency.valueOf(3200),"新制度介護医療年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekihaitoukin(), BizCurrency.valueOf(3300),"新制度介護医療実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkanhaitoukin(), BizCurrency.valueOf(3400),"新制度介護医療年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(3500),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(3600),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekip(), BizCurrency.valueOf(4100), "新制度年金実績保険料");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanp(), BizCurrency.valueOf(4200),"新制度年金年間保険料");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekihaitoukin(), BizCurrency.valueOf(4300), "新制度年金実績配当金");
        exBizCalcbleEquals(koujyoSym.getNewnknenkanhaitoukin(), BizCurrency.valueOf(4400) ,"新制度年金年間配当金");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(4500), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(0), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.NONE, "個人年金控除有無");
        exStringEquals(koujyoSym.getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(koujyoSym.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(koujyoSym.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(koujyoSym.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasesosikinmkj(), "漢字組織名０１組織区分名０１", "問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawaseyno(), "777-8888", "問合せ先郵便番号");
        exStringEquals(koujyoSym.getToiawaseadr1kj(), "漢字組織住所１１", "問合せ先住所１（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr2kj(), "漢字組織住所１２", "問合せ先住所２（漢字）");
        exStringEquals(koujyoSym.getToiawaseadr3kj(), "漢字組織住所１３", "問合せ先住所３（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno(), "111-2222-3333", "問合せ先電話番号");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou1(), "20160401", "問合せ先電話受付可能時間１");
        exStringEquals(koujyoSym.getToiawaseteluktkkanou2(), "20160402", "問合せ先電話受付可能時間２");
        exStringEquals(koujyoSym.getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(koujyoSym.getToiawasetelno2(), "", "第２問合せ先電話番号");
        exClassificationEquals(koujyoSym.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exStringEquals(koujyoSym.getDrtencd(), "", "代理店コード");
        exStringEquals(koujyoSym.getDrtennmkj(), "", "代理店名（漢字）");
        exClassificationEquals(koujyoSym.getHengakuumu(), C_UmuKbn.ARI, "変額保険有無");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exStringEquals(koujyoSym.getGyoumuKousinKinou(), "EditKoujyoSyoumeiTblTest_editTBL" ,"業務用更新機能ＩＤ");
        exStringEquals(koujyoSym.getGyoumuKousinsyaId(), "JUnit" ,"業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(4600));
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.IPPAN);
        editKoujyoSyoumeiParam.setSaihkhyjkbn(C_SaihkHyjKbn.HYOUJI);

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "被保険者名（漢字）１１　様" ,"受取人名（漢字）");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), BizDate.valueOf(20160101), "年金受取人生年月日");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(8), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getPhrkkkn(), 36, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, false, "年金支払開始日");
        exBizCalcbleEquals(koujyoSym.getNewippanjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度一般実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryoujissekisyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewnkjissekisyoumeigk(), BizCurrency.valueOf(0), "新制度年金実績証明額");
        exBizCalcbleEquals(koujyoSym.getNewippannenkansyoumeigk(), BizCurrency.valueOf(0),"新制度一般年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewiryounenkansyoumeigk(), BizCurrency.valueOf(0),"新制度介護医療年間証明額");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(4600), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getNewsyoumeigkumukbn(), C_UmuKbn.ARI, "新制度証明額有無区分");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.ARI, "個人年金控除有無");
        exStringEquals(koujyoSym.getNknshry(), "12" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKoujyosyoumeisentakukbn(), C_KoujyosyoumeisentakuKbn.BLANK ,"控除証明選択区分");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）０７", "契約者名（カナ）");
        exStringEquals(koujyoSym.getUktnmkn(), "被保険者名（カナ）１１", "受取人名（カナ）");
        exClassificationEquals(koujyoSym.getSaihkhyjkbn(), C_SaihkHyjKbn.HYOUJI ,"再発行表示区分");


    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(2500));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(2600));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(3600));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(4600));
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.NK);
        editKoujyoSyoumeiParam.setSaihkhyjkbn(C_SaihkHyjKbn.HYOUJI);

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getKyknmkj(), "契約者名（漢字）１２" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "契約者名（漢字）１２　様" ,"受取人名（漢字）");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分（主契約）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), BizDate.valueOf(20160101), "年金受取人生年月日");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(10), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getPhrkkkn(), 38, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, false, "年金支払開始日");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(4600), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.ARI, "個人年金控除有無");
        exStringEquals(koujyoSym.getNknshry(), "12" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKoujyosyoumeisentakukbn(), C_KoujyosyoumeisentakuKbn.BLANK ,"控除証明選択区分");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）１２", "契約者名（カナ）");
        exStringEquals(koujyoSym.getUktnmkn(), "契約者名（カナ）１２", "受取人名（カナ）");
        exClassificationEquals(koujyoSym.getSaihkhyjkbn(), C_SaihkHyjKbn.HYOUJI ,"再発行表示区分");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(2500));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(2600));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(3600));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(4600));
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.NK);
        editKoujyoSyoumeiParam.setSaihkhyjkbn(C_SaihkHyjKbn.HYOUJI);

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "" ,"受取人名（漢字）");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分（主契約）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(99), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getPhrkkkn(), 38, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, false, "年金支払開始日");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(4600), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.ARI, "個人年金控除有無");
        exStringEquals(koujyoSym.getNknshry(), "12" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKoujyosyoumeisentakukbn(), C_KoujyosyoumeisentakuKbn.BLANK ,"控除証明選択区分");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）０９", "契約者名（カナ）");
        exStringEquals(koujyoSym.getUktnmkn(), "", "受取人名（カナ）");
        exClassificationEquals(koujyoSym.getSaihkhyjkbn(), C_SaihkHyjKbn.HYOUJI ,"再発行表示区分");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo12);
        List<IT_KykSyouhn> kykSyohnSyuLst = kykKihon.getKykSyouhns();
        IT_KykSya kykSya = kykKihon.getKykSya();
        List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);
        List<IT_KykDairiten> kyDaritenLst = kykKihon.getKykDairitens();
        IT_KhTtdkTyuui khTtdkTyuui= new IT_KhTtdkTyuui();
        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;
        BizDate syoriYMD = BizDate.valueOf(20160418);
        int renNo = 1;
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKoujyoSyoumeiParam.setSinkiSakusei(C_SinsakuseiKbn.SIN);
        editKoujyoSyoumeiParam.setSyoumeiStartYm(BizDateYM.valueOf(201401));
        editKoujyoSyoumeiParam.setSyoumeiEndYm(BizDateYM.valueOf(201601));
        editKoujyoSyoumeiParam.setKoujyoNendo("2016");
        editKoujyoSyoumeiParam.setTekiyouSeidoKbn(C_TekiyouseidoKbn.NEWSD);
        editKoujyoSyoumeiParam.setSyoumeiYmd(BizDate.valueOf(20160401));
        editKoujyoSyoumeiParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        editKoujyoSyoumeiParam.setOldIppanJissekiP(BizCurrency.valueOf(1100));
        editKoujyoSyoumeiParam.setOldIppanNenkanP(BizCurrency.valueOf(1200));
        editKoujyoSyoumeiParam.setOldIppanJissekiHaitoukin(BizCurrency.valueOf(1300));
        editKoujyoSyoumeiParam.setOldIppanNenkanHaitoukin(BizCurrency.valueOf(1400));
        editKoujyoSyoumeiParam.setOldIppanJissekiSyoumeigk(BizCurrency.valueOf(1500));
        editKoujyoSyoumeiParam.setOldIppanNenkanSyoumeigk(BizCurrency.valueOf(1600));
        editKoujyoSyoumeiParam.setNewIppanJissekiP(BizCurrency.valueOf(2100));
        editKoujyoSyoumeiParam.setNewIppanNenkanP(BizCurrency.valueOf(2200));
        editKoujyoSyoumeiParam.setNewIppanJissekiHaitoukin(BizCurrency.valueOf(2300));
        editKoujyoSyoumeiParam.setNewIppanNenkanHaitoukin(BizCurrency.valueOf(2400));
        editKoujyoSyoumeiParam.setNewIppanJissekiSyoumeigk(BizCurrency.valueOf(2500));
        editKoujyoSyoumeiParam.setNewIppanNenkanSyoumeigk(BizCurrency.valueOf(2600));
        editKoujyoSyoumeiParam.setNewIryouJissekiP(BizCurrency.valueOf(3100));
        editKoujyoSyoumeiParam.setNewIryouNenkanP(BizCurrency.valueOf(3200));
        editKoujyoSyoumeiParam.setNewIryouJissekiHaitoukin(BizCurrency.valueOf(3300));
        editKoujyoSyoumeiParam.setNewIryouNenkanHaitoukin(BizCurrency.valueOf(3400));
        editKoujyoSyoumeiParam.setNewIryouJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewIryouNenkanSyoumeigk(BizCurrency.valueOf(3600));
        editKoujyoSyoumeiParam.setNewNenkinJissekiP(BizCurrency.valueOf(4100));
        editKoujyoSyoumeiParam.setNewNenkinNenkanP(BizCurrency.valueOf(4200));
        editKoujyoSyoumeiParam.setNewNenkinJissekiHaitoukin(BizCurrency.valueOf(4300));
        editKoujyoSyoumeiParam.setNewNenkinNenkanHaitoukin(BizCurrency.valueOf(4400));
        editKoujyoSyoumeiParam.setNewNenkinJissekiSyoumeigk(BizCurrency.valueOf(0));
        editKoujyoSyoumeiParam.setNewNenkinNenkanSyoumeigk(BizCurrency.valueOf(4600));
        editKoujyoSyoumeiParam.setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn.NK);
        editKoujyoSyoumeiParam.setSaihkhyjkbn(C_SaihkHyjKbn.HYOUJI);

        YuyuBizConfig.getInstance().setCallcentersosikicd("0010001");
        YuyuBizConfig.getInstance().setUketimecallcenter1("20160401");
        YuyuBizConfig.getInstance().setUketimecallcenter2("20160402");
        YuyuBizConfig.getInstance().setUketimetantousitu1("20160403");
        YuyuBizConfig.getInstance().setUketimetantousitu2("20160404");

        IT_KoujyoSym koujyoSym = editKoujyoSyoumeiTbl.editTBL(khozenCommonParam, kykKihon, kykSyohnSyuLst, kykSya,
            kykUktLst, kykUkt, kyDaritenLst, khTtdkTyuui, editKoujyoSyoumeiParam, hassouKbn, syoriYMD , renNo);

        exStringEquals(koujyoSym.getKyknmkj(), "契約者０１" ,"契約者名（漢字）");
        exStringEquals(koujyoSym.getUktnmkjaddsama(), "" ,"受取人名（漢字）");
        exClassificationEquals(koujyoSym.getHknkknsmnkbnsyu(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分（主契約）");
        exDateEquals(koujyoSym.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exBizCalcbleEquals(koujyoSym.getHknkknsyu(), BizNumber.valueOf(99), "保険期間（主契約）");
        exNumericEquals(koujyoSym.getPhrkkkn(), 38, "保険料払込期間");
        exBooleanEquals(koujyoSym.getNkshrstartymd() == null, false, "年金支払開始日");
        exBizCalcbleEquals(koujyoSym.getNewnknenkansyoumeigk(), BizCurrency.valueOf(4600), "新制度年金年間証明額");
        exClassificationEquals(koujyoSym.getKjnnkkoujyum(), C_UmuKbn.ARI, "個人年金控除有無");
        exStringEquals(koujyoSym.getNknshry(), "12" ,"年金支払期間");
        exClassificationEquals(koujyoSym.getKoujyosyoumeisentakukbn(), C_KoujyosyoumeisentakuKbn.BLANK ,"控除証明選択区分");
        exStringEquals(koujyoSym.getKyknmkn(), "契約者名（カナ）０９", "契約者名（カナ）");
        exStringEquals(koujyoSym.getUktnmkn(), "", "受取人名（カナ）");
        exClassificationEquals(koujyoSym.getSaihkhyjkbn(), C_SaihkHyjKbn.HYOUJI ,"再発行表示区分");
    }
}
