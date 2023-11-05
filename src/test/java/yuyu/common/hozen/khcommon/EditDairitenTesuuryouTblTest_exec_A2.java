package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * EditDairitenTesuuryouTblクラスのメソッド {@link EditDairitenTesuuryouTbl#exec(KhozenCommonParam,String,C_TsrysyoriKbn,BizDateYM,int,int,BizCurrency,BizCurrency,IT_BAK_KykKihon)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditDairitenTesuuryouTblTest_exec_A2 {

    private final static String syoNo1 = "12806345764";

    private final static String kbnKey1 = "06";

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private EditDairitenTesuuryouTbl editDairitenTesuuryouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo userInfo ;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_代理店手数料情報TBL編集";
    private final static String sheetName = "INデータ";

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo1, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo1, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo1, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.getSysDate(), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.NONE, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234567890), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), null, "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161011), "円換算適用為替レート基準日");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo1, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(0).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf(20160607), "消滅日");
        exDateEquals(tesuuryouSyouhnList.get(0).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnList.get(0).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnList.get(0).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnList.get(0).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnList.get(0).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnList.get(0).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnList.get(0).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnList.get(0).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnList.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(0).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo1, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getSyoumetuymd(), BizDate.valueOf(20160607), "消滅日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditDairitenTesuuryouTblTest_exec_A2.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

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
        hozenDomManager.delete(hozenDomManager.getAllBAKKykKihon());
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo1, C_Nyktrksflg.BLNK));

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }
}
