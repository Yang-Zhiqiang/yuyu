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
import yuyu.common.biz.exception.CommonBizAppException;
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
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.AbstractTest;

/**
 * EditDairitenTesuuryouTblクラスのメソッド {@link EditDairitenTesuuryouTbl#exec(KhozenCommonParam,String,C_TsrysyoriKbn,BizDateYM,int,int,BizCurrency,BizCurrency,BizDate,IT_BAK_KykKihon)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditDairitenTesuuryouTblTest_exec_A1 extends AbstractTest {

    private final static String syoNo1 = "12806345672";

    private final static String syoNo2 = "12806345683";

    private final static String syoNo3 = "12806345694";

    private final static String syoNo4 = "12806345719";

    private final static String syoNo5 = "12806345720";

    private final static String syoNo6 = "12806345731";

    private final static String syoNo7 = "12806345742";

    private final static String syoNo8 = "12806345753";

    private final static String syoNo9 = "12806345764";

    private final static String syoNo10 = "12806345775";

    private final static String kbnKey1 = "07";

    private final static String kbnKey2 = "08";

    private final static String kbnKey3 = "09";

    private final static String kbnKey4 = "01";

    private final static String kbnKey5 = "02";

    private final static String kbnKey6 = "03";

    private final static String kbnKey7 = "04";

    private final static String kbnKey8 = "05";

    private final static String kbnKey9 = "06";

    private final static String kbnKey10 = "07";

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
    @TestOrder(30)
    public void testExec_A3() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("EditDairitenTesuuryouTbl");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo9, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161011), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "EditDairitenTesuuryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo9, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 12, "連番");
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
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "EditDairitenTesuuryouTbl", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo3, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo3, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo3, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161011), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo3, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo3, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo4, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo4, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo4, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.getSysDate(), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.getSysDate(), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo4, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(0).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
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

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo4, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo5, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo5, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo5, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.getSysDate(), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.getSysDate(), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo5, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(0).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
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

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo5, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo6, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo6, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.getSysDate(), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), null, "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.getSysDate(), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 3, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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

        exStringEquals(tesuuryouSyouhnList.get(1).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(1).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(1).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(1).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(1).getKyksyouhnrenno(), 2, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(1).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(1).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
        exDateEquals(tesuuryouSyouhnList.get(1).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnList.get(1).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnList.get(1).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnList.get(1).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnList.get(1).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnList.get(1).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnList.get(1).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnList.get(1).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnList.get(1).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnList.get(1).getRyouritusdno(), "002", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(1).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(1).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(1).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(1).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        exStringEquals(tesuuryouSyouhnList.get(2).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(2).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(2).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(2).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(2).getKyksyouhnrenno(), 3, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(2).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(2).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
        exDateEquals(tesuuryouSyouhnList.get(2).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnList.get(2).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnList.get(2).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnList.get(2).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnList.get(2).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnList.get(2).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnList.get(2).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnList.get(2).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnList.get(2).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnList.get(2).getRyouritusdno(), "003", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(2).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(2).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(2).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(2).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 3, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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

        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getKyksyouhnrenno(), 2, "契約商品連番");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getHenkousikibetukey(), "100000000000000002", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getSyoumetuymd(), BizDate.valueOf(20160607), "消滅日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getRyouritusdno(), "002", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getKyksyouhnrenno(), 3, "契約商品連番");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getHenkousikibetukey(), "100000000000000003", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getSyoumetuymd(), BizDate.valueOf(20160607), "消滅日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getRyouritusdno(), "003", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo10);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo10, "123");

        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        khozenCommonParam.setBatchBakKykKihon(bakKykKihon);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo10, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon(syoNo10);

        List<IT_Tesuuryou> tesuuryouList = kykKihon1.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo10, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.getSysDate(), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.getSysDate(), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo10, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(0).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
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
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo10, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {

        try
        {

            kinou.setKinouKbn(C_KinouKbn.ONLINE);

            BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
            int nyknKaisuuY = 20;
            int nyknKaisuuM = 12;
            BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
            BizCurrency iktP = BizCurrency.valueOf(1234561234);
            BizDate nyknYMD = BizDate.valueOf(20160301);
            IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo2, "123");

            editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo2, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
                nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);
        }
        catch(CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。入金実績履歴情報取得に失敗しました。証券番号：12806345683", "エラーメッセージ");
            throw e;

        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo4, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khgengaku");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo4, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo4, "証券番号");
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
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161011), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo4, "証券番号");
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
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
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
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo4, "証券番号");
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
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        changeSystemDate();
        editDairitenTesuuryouTbl.setBatchSyoriYmd(BizDate.valueOf(20161010));

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo5, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khgengaku");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo5, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo5, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.valueOf(20161010), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161010), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo5, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(0).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
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
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo5, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        changeSystemDate();
        editDairitenTesuuryouTbl.setBatchSyoriYmd(BizDate.valueOf(20161010));

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo6, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khgengaku");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo6, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.valueOf(20161010), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), BizDateYM.valueOf(201603), "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 20, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 12, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(1231231231), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(1234561234), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), BizDateYM.valueOf(201604), "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), null, "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161010), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 3, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        exStringEquals(tesuuryouSyouhnList.get(1).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(1).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(1).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(1).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(1).getKyksyouhnrenno(), 2, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(1).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(1).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
        exDateEquals(tesuuryouSyouhnList.get(1).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnList.get(1).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnList.get(1).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnList.get(1).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnList.get(1).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnList.get(1).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnList.get(1).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnList.get(1).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnList.get(1).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnList.get(1).getRyouritusdno(), "002", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(1).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(1).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(1).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(1).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(1).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(1).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(1).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        exStringEquals(tesuuryouSyouhnList.get(2).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(2).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(2).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(2).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(2).getKyksyouhnrenno(), 3, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(2).getHenkousikibetukey(), "100000000000000001", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(2).getSyoumetuymd(), BizDate.valueOf(20160309), "消滅日");
        exDateEquals(tesuuryouSyouhnList.get(2).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnList.get(2).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnList.get(2).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnList.get(2).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnList.get(2).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnList.get(2).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnList.get(2).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnList.get(2).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnList.get(2).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnList.get(2).getRyouritusdno(), "003", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(2).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(2).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(2).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(2).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(2).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(2).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(2).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 3, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
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
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getKyksyouhnrenno(), 2, "契約商品連番");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getHenkousikibetukey(), "100000000000000002", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getSyoumetuymd(), BizDate.valueOf(20160607), "消滅日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(1).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getRyouritusdno(), "002", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(1).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(1).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(1).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(1).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getSyono(), syoNo6, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getKyksyouhnrenno(), 3, "契約商品連番");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getHenkousikibetukey(), "100000000000000003", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getSyoumetuymd(), BizDate.valueOf(20160607), "消滅日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getKouryokuhasseiymd(), BizDate.valueOf(20160308), "効力発生日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getKykymd(), BizDate.valueOf(20160309), "契約日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getSknnkaisiymd(), BizDate.valueOf(20160310), "責任開始日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getHknkkn(), 10, "保険期間");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getHrkkkn(), 20, "払込期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getKyknen(), 30, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getHhknseiymd(), BizDate.valueOf(20160312), "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getHaraimanymd(), BizDate.valueOf(20160313), "払満日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(2).getHknkknmanryouymd(), BizDate.valueOf(20160314), "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getKihons(), BizCurrency.valueOf(1236547891), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getHokenryou(), BizCurrency.valueOf(1236547894), "保険料");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getRyouritusdno(), "003", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.1), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.6), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(2).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(2).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(2).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(2).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201806);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20180606);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("11807111118", "123");

        editDairitenTesuuryouTbl.exec(khozenCommonParam, "11807111118", C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        exNumericEquals(tesuuryouList.size(), 0, "要素数");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(0);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.KAIYAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIYAKU, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.NONE, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.SEIRITUGOFSTPNYUUKIN, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SEIRITUGOFSTPNYUUKIN, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.PMEN, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.PMEN, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.SIBOU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SIBOU, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.KOUDOSYOUGAI, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KOUDOSYOUGAI, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.GENGAKU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.GENGAKU, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.CLGOFF, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.CLGOFF, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.KEIYAKUTORIKESI, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KEIYAKUTORIKESI, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.MUKOU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.MUKOU, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.KAIJO, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.KAIJO, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.ARI, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);

        khozenCommonParam.setSikibetuKey("100000000000000001");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo9, C_TsrysyoriKbn.BLNK, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, null);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.BLNK, "手数料処理区分");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.NONE, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_B1() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = null;
        int nyknKaisuuY = 0;
        int nyknKaisuuM = 0;
        BizCurrency mikeikaP = BizCurrency.valueOf(0);
        BizCurrency iktP = BizCurrency.valueOf(0);
        BizDate nyknYMD = null;
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo7, "123");

        khozenCommonParam.setSikibetuKey("");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo7, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(0);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo7, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 1, "連番");
        exDateEquals(tesuuryou.getSyoriYmd(), BizDate.getSysDate(), "処理年月日");
        exDateYMEquals(tesuuryou.getKouryokuhasseiym(), null, "効力発生年月");
        exNumericEquals(tesuuryou.getNyknkaisuuy(), 0, "入金回数（年）");
        exNumericEquals(tesuuryou.getNyknkaisuum(), 0, "入金回数（月）");
        exClassificationEquals(tesuuryou.getMikeikapariflg(), C_UmuKbn.NONE, "未経過Ｐ有フラグ");
        exClassificationEquals(tesuuryou.getMisyuupariflg(), C_UmuKbn.NONE, "未収Ｐ有フラグ");
        exBizCalcbleEquals(tesuuryou.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(tesuuryou.getIktp(),  BizCurrency.valueOf(0), "一括払保険料");
        exDateYMEquals(tesuuryou.getSeisekiym(), null, "成績計上年月");
        exClassificationEquals(tesuuryou.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(tesuuryou.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(0), "払込保険料");
        exDateYMEquals(tesuuryou.getJkipjytym(), null, "次回Ｐ充当年月");
        exDateYEquals(tesuuryou.getHaitounendo(), null, "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.BLNK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), null, "募集年月");
        exStringEquals(tesuuryou.getKyknmkj(), "", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), null, "入金日");
        exBizCalcbleEquals(tesuuryou.getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161011), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo7, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnList.get(0).getHenkousikibetukey(), "", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(tesuuryouSyouhnList.get(0).getSyoumetuymd(), null, "消滅日");
        exDateEquals(tesuuryouSyouhnList.get(0).getKouryokuhasseiymd(), null, "効力発生日");
        exDateEquals(tesuuryouSyouhnList.get(0).getKykymd(), null, "契約日");
        exDateEquals(tesuuryouSyouhnList.get(0).getSknnkaisiymd(), null, "責任開始日");
        exDateEquals(tesuuryouSyouhnList.get(0).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getHknkkn(), 0, "保険期間");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getHrkkkn(), 0, "払込期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getKyknen(), 0, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnList.get(0).getHhknnen(), 0, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnList.get(0).getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exDateEquals(tesuuryouSyouhnList.get(0).getHaraimanymd(), null, "払満日");
        exDateEquals(tesuuryouSyouhnList.get(0).getHknkknmanryouymd(), null, "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKatakbn(), C_KataKbn.BLNK, "型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.BLNK, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.BLNK, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnList.get(0).getRyouritusdno(), "", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(0).getYtirrthndmnskaisuu(), 0, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNenkinkkn(), 0, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNkgnshosyouritu(), 0, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(0), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo7, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getRenno(), 1, "連番");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getSyouhnsdno(), 11, "商品世代番号");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getHenkousikibetukey(), "", "変更識別キー");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getSyoumetuymd(), null, "消滅日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getKouryokuhasseiymd(), null, "効力発生日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getKykymd(), null, "契約日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getSknnkaisiymd(), null, "責任開始日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getGansknnkaisiymd(), null, "がん責任開始日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getHknkkn(), 0, "保険期間");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getHrkkkn(), 0, "払込期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getKyknen(), 0, "契約者年齢");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getHhknnen(), 0, "被保険者年齢");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getHaraimanymd(), null, "払満日");
        exDateEquals(tesuuryouSyouhnRirekiList.get(0).getHknkknmanryouymd(), null, "保険期間満了日");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKatakbn(), C_KataKbn.BLNK, "型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.BLNK, "基本給付金額倍率区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getRokudaildkbn(), C_6daiLdKbn.BLNK, "６大生活習慣病追加給付型区分");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getRyouritusdno(), "", "料率世代番号");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getYtirrthndmnskaisuu(), 0, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNenkinkkn(), 0, "年金期間");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyouritu(), 0, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(0), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(270)
    public void testExec_B2() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        BizDateYM kouryokuHasseiYM = BizDateYM.valueOf(201603);
        int nyknKaisuuY = 20;
        int nyknKaisuuM = 12;
        BizCurrency mikeikaP = BizCurrency.valueOf(1231231231);
        BizCurrency iktP = BizCurrency.valueOf(1234561234);
        BizDate nyknYMD = BizDate.valueOf(20160301);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syoNo8, "123");

        khozenCommonParam.setSikibetuKey("100000000000000001");
        khozenCommonParam.setFunctionId("khseinengappiseiteisei");
        userInfo.getUser().setUserId("khcommon");
        editDairitenTesuuryouTbl.exec(khozenCommonParam, syoNo8, C_TsrysyoriKbn.SINKEIYAKUSEIRITU, kouryokuHasseiYM,
            nyknKaisuuY, nyknKaisuuM, mikeikaP, iktP, nyknYMD, bakKykKihon);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);

        List<IT_Tesuuryou> tesuuryouList = kykKihon.getTesuuryous();
        IT_Tesuuryou tesuuryou = tesuuryouList.get(1);

        exStringEquals(tesuuryou.getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(tesuuryou.getSyono(), syoNo8, "証券番号");
        exClassificationEquals(tesuuryou.getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryou.getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryou.getHrkp(),BizCurrency.valueOf(1234561234), "払込保険料");
        exDateYEquals(tesuuryou.getHaitounendo(), BizDateY.valueOf(2016), "配当年度");
        exStringEquals(tesuuryou.getCifcd(), "100000000000001", "ＣＩＦコード");
        exStringEquals(tesuuryou.getSmbckanriid(), "10000000001", "ＳＭＢＣ受付管理ＩＤ");
        exClassificationEquals(tesuuryou.getBoskykjyoutai(), C_Boskykjyoutai.TUUJYOUKYK, "募集契約状態");
        exDateYMEquals(tesuuryou.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exDateYMEquals(tesuuryou.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exStringEquals(tesuuryou.getKyknmkj(), "契約者名漢字テストテスト００１", "契約者名（漢字）");
        exDateEquals(tesuuryou.getNyknymd(), BizDate.valueOf(20160301), "入金日");
        exDateEquals(tesuuryou.getYenkansantkykwsrateymd(), BizDate.valueOf(20161013), "円換算適用為替レート基準日");
        exClassificationEquals(tesuuryou.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exStringEquals(tesuuryou.getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryou.getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhn> tesuuryouSyouhnList = tesuuryou.getTesuuryouSyouhns();

        exNumericEquals(tesuuryouSyouhnList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnList.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(tesuuryouSyouhnList.get(0).getSyono(), syoNo8, "証券番号");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(1.2345), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.2345), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnList.get(0).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.2345), "契約時市場価格調整用利率");
        exClassificationEquals(tesuuryouSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNenkinkkn(), 22, "年金期間");
        exNumericEquals(tesuuryouSyouhnList.get(0).getNkgnshosyouritu(), 33, "年金原資最低保証率");
        exBizCalcbleEquals(tesuuryouSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1236547897), "年金原資最低保証額");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinKinou(), "khseinengappiseiteisei", "業務用更新機能ＩＤ");
        exStringEquals(tesuuryouSyouhnList.get(0).getGyoumuKousinsyaId(), "khcommon", "業務用更新者ＩＤ");

        List<IT_TesuuryouSyouhnRireki> tesuuryouSyouhnRirekiList = tesuuryou.getTesuuryouSyouhnRirekis();

        exNumericEquals(tesuuryouSyouhnRirekiList.size(), 1, "要素数");

        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(tesuuryouSyouhnRirekiList.get(0).getSyono(), syoNo8, "証券番号");
        exClassificationEquals(tesuuryouSyouhnRirekiList.get(0).getTsrysyorikbn(), C_TsrysyoriKbn.SINKEIYAKUSEIRITU, "手数料処理区分");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getRenno(), 12, "連番");
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
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(1.2345), "予定利率");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(2.2345), "予定利率変動時保証利率");
        exNumericEquals(tesuuryouSyouhnRirekiList.get(0).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(tesuuryouSyouhnRirekiList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.2345), "契約時市場価格調整用利率");
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

            testDataAndTblMap = testDataMaker.getInData(EditDairitenTesuuryouTblTest_exec_A1.class, fileName, sheetName);

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
        hozenDomManager.delete(hozenDomManager.getAllBAKKykKihon());
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo1, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo9, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo3, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo4, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo5, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo6, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo10, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo7, C_Nyktrksflg.BLNK));
        hozenDomManager.delete(hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg(syoNo8, C_Nyktrksflg.BLNK));

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    private void changeSystemDate() {
        changeSystemDate(BizDate.valueOf(2016, 10, 10));
    }
}
