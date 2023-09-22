package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_KokutisyoVrf;
import yuyu.def.db.entity.HT_KouzaJyouhouVrf;
import yuyu.def.db.entity.HT_MosDairitenVrf;
import yuyu.def.db.entity.HT_MosKihonVrf;
import yuyu.def.db.entity.HT_MosSyouhnVrf;
import yuyu.def.db.entity.HT_MosTrkKzkVrf;
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.entity.HT_UketorininVrf;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 差異データ登録
 */
public class SaiDataTouroku {

    public static final int NRKSAIARI = -1;

    public static final int NRKSAINASI = 0;

    private static final String AITEMOSNO = "aitemosno";

    private static final String DOUJIKAIYAKUSYONO = "doujikaiyakusyono";

    private static final String MOSYMD = "mosymd";

    private static final String JIMUYOUCD = "jimuyoucd";

    private static final String HKNSYURUINO = "hknsyuruino";

    private static final String KYKKBN = "kykkbn";

    private static final String YAKKANJYURYOUHOUKBN = "yakkanjyuryouhoukbn";

    private static final String FATCASNSIKBN = "fatcasnsikbn";

    private static final String BIKKJNSSINFOKBN = "bikkjnssinfokbn";

    private static final String BIKKNZSYNO = "bikknzsyno";

    private static final String AEOISNSIKBN = "aeoisnsikbn";

    private static final String KYKNMKN = "kyknmkn";

    private static final String KYKNMKJ = "kyknmkj";

    private static final String KYKNMKJKHUKAKBN = "kyknmkjkhukakbn";

    private static final String KYKSEIYMD = "kykseiymd";

    private static final String KYKSEI = "kyksei";

    private static final String KYKTDK = "kyktdk";

    private static final String TSINYNO = "tsinyno";

    private static final String TSINADR1KJ= "tsinadr1kj";

    private static final String TSINADR2KJ= "tsinadr2kj";

    private static final String TSINADR3KJ= "tsinadr3kj";

    private static final String TSINTELNO = "tsintelno";

    private static final String DAI2TSINTELNO = "dai2tsintelno";

    private static final String HHKNNMKN = "hhknnmkn";

    private static final String HHKNNMKJ = "hhknnmkj";

    private static final String HHKNNMKJKHUKAKBN = "hhknnmkjkhukakbn";

    private static final String HHKNSEIYMD = "hhknseiymd";

    private static final String HHKNSEI = "hhknsei";

    private static final String TSINDOUSITEIKBN = "tsindousiteikbn";

    private static final String HHKNYNO = "hhknyno";

    private static final String HHKNADR1KJ = "hhknadr1kj";

    private static final String HHKNADR2KJ = "hhknadr2kj";

    private static final String HHKNADR3KJ = "hhknadr3kj";

    private static final String HHKNTELNO = "hhkntelno";

    private static final String KKTYMD = "kktymd";

    private static final String HHKNSYKGYCD = "hhknsykgycd";

    private static final String HHKNNENSYUUKBN = "hhknnensyuukbn";

    private static final String DISPSBUKTKBN = "dispsbuktkbn";

    private static final String DISPSBUKTNMKN = "dispsbuktnmkn";

    private static final String DISPSBUKTNMKJ = "dispsbuktnmkj";

    private static final String DISPSBUKTNMKJHUKAKBN = "dispsbuktnmkjhukakbn";

    private static final String DISPSBUKTSEIYMD = "dispsbuktseiymd";

    private static final String DISPSBUKTTDK = "dispsbukttdk";

    private static final String DISPSBUKTBNWARI = "dispsbuktbnwari";

    private static final String UKTKBN = "uktkbn";

    private static final String UKTNMKN = "uktnmkn";

    private static final String UKTNMKJ = "uktnmkj";

    private static final String UKTNMKJKHUKAKBN = "uktnmkjkhukakbn";

    private static final String UKTSEIYMD = "uktseiymd";

    private static final String UKTTDK = "ukttdk";

    private static final String UKTBNWARI = "uktbnwari";

    private static final String KZKTOUROKUSERVICETOUROKUKBN = "kzktourokuservicetourokukbn";

    private static final String TRKKZKNMKN1 = "trkkzknmkn1";

    private static final String TRKKZKNMKJ1 = "trkkzknmkj1";

    private static final String TRKKZKNMKJKHUKAKBN1 = "trkkzknmkjkhukakbn1";

    private static final String TRKKZKSEIYMD1 = "trkkzkseiymd1";

    private static final String TRKKZKSEI1 = "trkkzksei1";

    private static final String TRKKZKTDK1 = "trkkzktdk1";

    private static final String TRKKZKTSINDOUSITEIKBN1 = "trkkzktsindousiteikbn1";

    private static final String TRKKZKYNO1 = "trkkzkyno1";

    private static final String TRKKZKADR1KJ1 = "trkkzkadr1kj1";

    private static final String TRKKZKADR2KJ1 = "trkkzkadr2kj1";

    private static final String TRKKZKADR3KJ1 = "trkkzkadr3kj1";

    private static final String TRKKZKTELNO1 = "trkkzktelno1";

    private static final String STDRSKTKYHKKBN = "stdrsktkyhkkbn";

    private static final String STDRUKTKBN = "stdruktkbn";

    private static final String SITEIDRUKTNMKN = "siteidruktnmkn";

    private static final String SITEIDRUKTNMKJ = "siteidruktnmkj";

    private static final String STDRSKNMKJHUKAKBN = "stdrsknmkjhukakbn";

    private static final String STDRSKSEIYMD = "stdrskseiymd";

    private static final String SITEIUKTTDK = "siteiukttdk";

    private static final String DRCTSERVICEMOSKBN = "drctservicemoskbn";

    private static final String YNKHRKMGKANNITUUTIKBN = "ynkhrkmgkannituutikbn";

    // 2016/03/03 S社導入：コメントアウト
    //    private static final String DISPTKKIHONS = "disptkkihons";
    //
    //    private static final String DISPTKHKNKKN = "disptkhknkkn";
    //
    //    private static final String DISPTKHRKKKN = "disptkhrkkkn";
    //
    //    private static final String DISPTKSYOUHNCD = "disptksyouhncd";
    //
    //    private static final String DISPTKKATAKBNKAHI = "disptkkatakbnkahi";
    //
    //    private static final String DISPTKKYHKATAKBN = "disptkkyhkatakbn";
    //
    //    private static final String DISPTKHKNKKNSMNKBN = "disptkhknkknsmnkbn";
    //
    //    private static final String DISPTKHRKKKNSMNKBN = "disptkhrkkknsmnkbn";

    private static final String SINTYOU = "sintyou";

    private static final String TAIJYUU = "taijyuu";

    private static final String KIJIKBN = "kijikbn";

    private static final String DISP_AITEMOSNO = "相手申込番号";

    private static final String DISP_DOUJIKAIYAKUSYONO = "同時解約証券番号";

    private static final String DISP_MOSYMD = "申込日";

    private static final String DISP_JIMUYOUCD = "事務用コード";

    private static final String DISP_HKNSYURUINO = "保険種類";

    private static final String DISP_KYKKBN = "契約者区分";

    private static final String DISP_YAKKANJYURYOUHOUKBN = "約款受領方法";

    private static final String DISP_FATCASNSIKBN = "ＦＡＴＣＡ宣誓";

    private static final String DISP_BIKKJNSSINFOKBN = "米国人示唆情報";

    private static final String DISP_BIKKNZSYNO = "米国納税者番号";

    private static final String DISP_AEOISNSIKBN = "ＡＥＯＩ宣誓";

    private static final String DISP_KYKNMKN = "契約者名（カナ）";

    private static final String DISP_KYKNMKJ = "契約者名（漢字）";

    private static final String DISP_KYKNMKJKHUKAKBN = "契約者名漢字化不可区分";

    private static final String DISP_KYKSEIYMD = "契約者生年月日";

    private static final String DISP_KYKSEI = "契約者性別";

    private static final String DISP_KYKTDK = "契約者続柄";

    private static final String DISP_TSINYNO = "通信先郵便番号";

    private static final String DISP_TSINADR1KJ = "通信先住所１（漢字）";

    private static final String DISP_TSINADR2KJ = "通信先住所２（漢字）";

    private static final String DISP_TSINADR3KJ = "通信先住所３（漢字）";

    private static final String DISP_TSINTELNO = "通信先電話番号";

    private static final String DISP_DAI2TSINTELNO = "第２通信先電話番号";

    private static final String DISP_HHKNNMKN = "被保険者名（カナ）";

    private static final String DISP_HHKNNMKJ = "被保険者名（漢字）";

    private static final String DISP_HHKNNMKJKHUKAKBN = "被保険者名漢字化不可区分";

    private static final String DISP_HHKNSEIYMD = "被保険者生年月日";

    private static final String DISP_HHKNSEI = "被保険者性別";

    private static final String DISP_TSINDOUSITEIKBN = "通信先同一指定区分";

    private static final String DISP_HHKNYNO = "被保険者郵便番号";

    private static final String DISP_HHKNADR1KJ = "被保険者住所１（漢字）";

    private static final String DISP_HHKNADR2KJ = "被保険者住所２（漢字）";

    private static final String DISP_HHKNADR3KJ = "被保険者住所３（漢字）";

    private static final String DISP_HHKNTELNO = "被保険者電話番号";

    private static final String DISP_KKTYMD = "告知日";

    private static final String DISP_HHKNSYKGYCD = "被保険者職業コード";

    private static final String DISP_HHKNNENSYUUKBN = "被保険者年収";

    private static final String DISP_NENKINUKTKBN = "年金受取人区分";

    private static final String DISP_SBUKTNIN = "死亡受取人人数";

    private static final String DISP_DISPSBUKTKBN = "死亡受取人区分";

    private static final String DISP_DISPSBUKTNMKN = "死亡受取人氏名（カナ）";

    private static final String DISP_DISPSBUKTNMKJ = "死亡受取人氏名（漢字）";

    private static final String DISP_DISPSBUKTNMKJHUKAKBN = "死亡受取人名漢字化不可";

    private static final String DISP_DISPSBUKTSEIYMD = "死亡受取人生年月日";

    private static final String DISP_DISPSBUKTTDK = "死亡受取人続柄";

    private static final String DISP_DISPSBUKTBNWARI = "死亡受取人分割割合";

    private static final String DISP_SYUDAI1HKNKKNMOSINPUT = "第１保険期間";

    private static final String DISP_SDPDKBN = "Ｓ建Ｐ建";

    private static final String DISP_KYKTUUKASYU = "指定通貨／選択通貨";

    private static final String DISP_HRKTUUKASYU = "払込通貨";

    private static final String DISP_KIHONS = "保険金額／給付金額";

    private static final String DISP_SYUHKNKKNMOSINPUT = "保険期間";

    private static final String DISP_SYUHRKKKNMOSINPUT = "払込期間";

    private static final String DISP_PHRKMNRYNEN  = "保険料払込満了年齢";

    private static final String DISP_NKSHRSTARTNEN = "年金支払開始年齢";

    private static final String DISP_SISUUHAIBUNWARIKBN = "指数連動";

    private static final String DISP_TEIRITUHAIBUNWARIKBN = "定率積立";

    private static final String DISP_SUEOKIKKNMOSINPUT = "据置期間";

    private static final String DISP_HRKTUUKASYUP = "払込金額";

    private static final String DISP_MOSIKKATUP = "定期一括払保険料";

    private static final String DISP_MOSSYUKYKP = "保険料";

    private static final String DISP_MOSZENNOUPSYOKAIARI = "前納保険料";

    private static final String DISP_SKNENKINSYU = "年金種類";

    private static final String DISP_NKGNSHOSYOURITUKBN = "最低保証水準";

    private static final String DISP_KYKTUUKASYU_USD = "主契約保障情報（米ドル）　指定通貨／選択通貨";

    private static final String DISP_HRKTUUKASYU_USD = "主契約保障情報（米ドル）　払込通貨";

    private static final String DISP_KIHONS_USD = "主契約保障情報（米ドル）　保険金額／給付金額";

    private static final String DISP_HRKTUUKASYUP_USD = "主契約保障情報（米ドル）　払込金額";

    private static final String DISP_MOSIKKATUP_USD = "主契約保障情報（米ドル）　定期一括払保険料";

    private static final String DISP_MOSZENNOUPSYOKAIARI_USD = "主契約保障情報（米ドル）　前納保険料";

    private static final String DISP_KJNNKPZEITEKITKHUKAKBN_USD = "主契約保障情報（米ドル）　個人年金保険料税制適格特約";

    private static final String DISP_KYKTUUKASYU_AUD = "主契約保障情報（豪ドル）　指定通貨／選択通貨";

    private static final String DISP_HRKTUUKASYU_AUD = "主契約保障情報（豪ドル）　払込通貨";

    private static final String DISP_KIHONS_AUD = "主契約保障情報（豪ドル）　保険金額／給付金額";

    private static final String DISP_HRKTUUKASYUP_AUD = "主契約保障情報（豪ドル）　払込金額";

    private static final String DISP_MOSIKKATUP_AUD = "主契約保障情報（豪ドル）　定期一括払保険料";

    private static final String DISP_MOSZENNOUPSYOKAIARI_AUD = "主契約保障情報（豪ドル）　前納保険料";

    private static final String DISP_KJNNKPZEITEKITKHUKAKBN_AUD = "主契約保障情報（豪ドル）　個人年金保険料税制適格特約";

    private static final String DISP_HRKKAISUU  = "払込回数";

    private static final String DISP_HRKKEIRO = "払込経路";

    private static final String DISP_FSTPHRKKEIROKBN = "初回保険料払込経路";

    private static final String DISP_ZENKIZENNOUUMU   = "全期前納";

    private static final String DISP_ZENNOUKIKAN = "前納期間";

    private static final String DISP_IKKATUBARAIKAISUU = "定期一括払回数";

    private static final String DISP_KJNNKPZEITEKITKHUKAKBN = "個人年金保険料税制適格特約";

    // 2016/03/03 S社導入：コメントアウト
    //    private static final String DISP_DISPTKSYOUHNCD = "特約商品名";
    //
    //    private static final String DISP_DISPTKKATAKBNKAHI = "特約型区分";
    //
    //    private static final String DISP_DISPTKKYHKATAKBN = "特約給付型区分";
    //
    //    private static final String DISP_DISPTKKIHONS = "特約保険金額";
    //
    //    private static final String DISP_DISPTKHKNKKN = "特約保険期間";
    //
    //    private static final String DISP_DISPTKHKNKKNSMNKBN = "特約保険期間歳満期区分";
    //
    //    private static final String DISP_DISPTKHRKKKN = "特約払込期間";
    //
    //    private static final String DISP_DISPTKHRKKKNSMNKBN = "特約払込期間歳満期区分";

    private static final String DISP_TEIKISIHARAITKYKHKKBN = "指定通貨建年金保険定期支払特約";

    private static final String DISP_SHKSTKZINFKZINFOINPUTHRYKBN = "支払金指定口座情報入力保留";

    private static final String DISP_KZSYURUIKBN = "定期支払金支払通貨";

    private static final String DISP_BANKCD = "支払金指定口座情報銀行コード";

    private static final String DISP_SITENCD = "支払金指定口座情報支店コード";

    private static final String DISP_YOKINKBN = "支払金指定口座情報預金種目";

    private static final String DISP_KOUZANO = "支払金指定口座情報口座番号";

    private static final String DISP_KZKYKDOUKBN = "支払金指定口座情報口座名義人同一区分";

    private static final String DISP_KZMEIGINMKN = "支払金指定口座情報口座名義人";

    private static final String DISP_TARGETTKMKHTKBN = "目標額割合";

    private static final String DISP_SYKSBYENSITIHSYUTKHKKBN = "初期死亡時円換算支払額最低保証特約";

    private static final String DISP_JYUDKAIGOMEHRTKHKKBN = "重度介護前払特約";

    private static final String DISP_NSTKHKKBN = "年金支払特約";

    private static final String DISP_NSTKSBNKKN = "年金支払特約期間";

    private static final String DISP_KZKTOUROKUSERVICETOUROKUKBN = "ご家族登録サービス";

    private static final String DISP_TRKKZKNMKN1 = "登録家族名（カナ）";

    private static final String DISP_TRKKZKNMKJ1 = "登録家族名（漢字）";

    private static final String DISP_TRKKZKNMKJKHUKAKBN1 = "登録家族名漢字化不可";

    private static final String DISP_TRKKZKSEIYMD1 = "登録家族生年月日";

    private static final String DISP_TRKKZKSEI1 = "登録家族性別";

    private static final String DISP_TRKKZKTDK1 = "登録家族続柄";

    private static final String DISP_TRKKZKTSINDOUSITEIKBN1 = "登録家族通信先同一指定区分";

    private static final String DISP_TRKKZKYNO1 = "登録家族郵便番号";

    private static final String DISP_TRKKZKADR1KJ1 = "登録家族住所１（漢字）";

    private static final String DISP_TRKKZKADR2KJ1 = "登録家族住所２（漢字）";

    private static final String DISP_TRKKZKADR3KJ1 = "登録家族住所３（漢字）";

    private static final String DISP_TRKKZKTELNO1 = "登録家族電話番号";

    private static final String DISP_HHKSDRSKTKYHKKBN = "被保険者代理特約";

    private static final String DISP_STDRUKTKBN = "被保険者代理人区分";

    private static final String DISP_SITEIDRUKTNMKN = "被保険者代理人氏名（カナ）";

    private static final String DISP_SITEIDRUKTNMKJ = "被保険者代理人氏名（漢字）";

    private static final String DISP_STDRSKNMKJHUKAKBN = "被保険者代理人名漢字化不可区分";

    private static final String DISP_SITEIDRSEIYMD = "被保険者代理人生年月日";

    private static final String DISP_STDRSKTDK = "被保険者代理人続柄";

    private static final String DISP_KOUZAINFOINPUTHORYUU = "口振口座情報入力保留";

    private static final String DISP_KOUHURIKOUZAINFOBANKCD = "口振口座情報銀行コード";

    private static final String DISP_KOUHURIKOUZAINFOSITENCD = "口振口座情報支店コード";

    private static final String DISP_KOUHURIKOUZAINFOYOKIN = "口振口座情報預金種目";

    private static final String DISP_KOUHURIKOUZAINFOKOUZANO = "口振口座情報口座番号";

    private static final String DISP_KOUHURIKOUZAINFOKZDOUKBN = "口振口座情報口座名義人同一区分";

    private static final String DISP_KOUHURIKOUZAINFOKZMEIGINMKN = "口振口座情報口座名義人";

    private static final String DISP_KOUZAKAKUNINIRAIKBN = "ＣＳＳ確認依頼区分";

    private static final String DISP_KYKHONNINKAKNINSYORUIKBN = "契約者";

    private static final String DISP_SKSKKNHONNINKAKNINSYORUIKBN = "親権者・後見人";

    private static final String DISP_KOUREIKZKSETUMEIHOUKBN = "ご家族等への説明方法";

    private static final String DISP_KOUREIMNDNHUKUSUUKAIKBN = "面談回数（２回以上）";

    private static final String DISP_KOUREITRATKISYAIGIDSKKBN = "取扱者以外の同席";

    private static final String DISP_DISPDRTENJIMCD = "代理店事務所コード";

    private static final String DISP_DISPDAIRITENKINYUUKIKANCD = "代理店金融機関コード";

    private static final String DISP_DISPDAIRITENKINYUUKIKANSITENCD = "代理店金融機関支店コード";

    private static final String DISP_DISPDAIRITENTORIATUKAIKOUINCD = "代理店取扱行員コード";

    private static final String DISP_DISPINPUTBOSYUUCD = "入力募集人コード";

    private static final String DISP_DISPBOSYUUTRKNO = "募集人登録番号";

    private static final String DISP_DISPGYSKKJSAKISOSIKICD = "業績計上先組織コード";

    private static final String DISP_DISPDAIRITENBUNTANWARIAI = "代理店分担割合";

    private static final String DISP_CIFCD = "ＣＩＦコード";

    private static final String DISP_UKTKID = "受付管理ＩＤ";

    private static final String DISP_TSRYHSHRKYKUMUKBN = "手数料不支払契約";

    private static final String DISP_SYOSISYATODOKEUMUKBN = "証券支社届";

    private static final String DISP_KAKUKISYOURYAKUKBUMUKBN = "カク基省略希望";

    private static final String DISP_SEIYMDMOSSEITOUUMUKBN = "生年月日申込書正当";

    private static final String DISP_DRCTSERVICEMOSKBN = "ダイレクトサービス";

    private static final String DISP_YNKHRKMGKANNITUUTIKBN = "円貨払込額のご案内通知";

    private static final String DISP_TKHSYOURYAKUUMUKBN = "通計保留省略有無区分";

    private static final String DISP_SINTYOU = "身長";

    private static final String DISP_TAIJYUU = "体重";

    private static final String DISP_KIJIKBN = "詳細記事区分";

    private final List<String> ymdLst = new ArrayList<>();

    private final List<String> ymdLst2 = new ArrayList<>();

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    // 2016/03/03 S社導入：コメントアウト
    //    @Inject
    //    private SyouhinUtil syouhinUtil;

    @Inject
    private BizDomManager bizDomManager;

    public SaiDataTouroku() {
        ymdLst.add(MOSYMD);
        ymdLst.add(KKTYMD);

        ymdLst2.add(KYKSEIYMD);
        ymdLst2.add(HHKNSEIYMD);
        ymdLst2.add(UKTSEIYMD);
        ymdLst2.add(DISPSBUKTSEIYMD);
        ymdLst2.add(TRKKZKSEIYMD1);
        ymdLst2.add(STDRSKSEIYMD);
    }

    public int registerSaiDataMousikomisyo(SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam pUiBean,
        String pSousasyaCd,
        String pSysDate) {

        int hyoujiJyunRen = 0;
        int saiUmu = NRKSAINASI;


        int dairitenRenno = 0;
        int uketoriRenno = 0;

        String mosNo = pUiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        HT_MosKihonVrf mosKihonVrf = syoriCTL.getMosKihonVrf();
        if (mosKihonVrf == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        List<HT_MosSyouhnVrf> mosSyouhnVrfSyuLst = syoriCTL.getMosSyouhnVrfsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnVrfSyuLst == null || mosSyouhnVrfSyuLst.size() == 0) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        HT_MosSyouhnVrf mosSyouhnVrf = mosSyouhnVrfSyuLst.get(0);

        BM_SyouhnZokusei syouhnZokusei  =
            bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd(mosSyouhnVrf.getSyouhncd(), BizDate.getSysDate());

        if (syouhnZokusei == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        // 2016/03/03 S社導入：コメントアウト
        //        List<HT_MosSyouhnVrf> mosSyouhnVrfTkLst = sinkeiyakuDomManager.
        //                getMosSyouhnVrfsBySyonoSyutkkbnSyouhncdMaxSyouhnsdno(mosNo, C_SyutkKbn.TK);

        List<HT_UketorininVrf> uketorininVrfNkUktLst = syoriCTL.getUketorininVrfsByUktsyukbn(C_UktsyuKbn.NKUKT);

        List<HT_UketorininVrf> uketorininVrfSbUktLst = syoriCTL.getUketorininVrfsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<HT_MosTrkKzkVrf> mosTrkKzkVrfLst = syoriCTL.getMosTrkKzkVrfs();

        HT_MosTrkKzkVrf mosTrkKzkVrEnt = null;
        for (HT_MosTrkKzkVrf mosTrkKzkVr : mosTrkKzkVrfLst) {

            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzkVr.getTrkkzkkbn())) {

                mosTrkKzkVrEnt = mosTrkKzkVr;
            }
        }

        List<HT_UketorininVrf> hhknSyaDairininUketorininVrfLst = syoriCTL.getUketorininVrfsByUktsyukbn(C_UktsyuKbn.STDRSK);

        HT_UketoriKouzaJyouhouVrf uketoriKouzaJyouhouVrf =
            syoriCTL.getUketoriKouzaJyouhouVrfByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        HT_MosDairitenVrf mosDairitenVrf1 = syoriCTL.getMosDairitenVrfByRenno(1);

        HT_MosDairitenVrf mosDairitenVrf2 = syoriCTL.getMosDairitenVrfByRenno(2);

        String[] mosKihon1Gms = new String[]{
            pUiBean.getAitemosno(),
            pUiBean.getDoujikaiyakusyono(),
            editYmd(pUiBean.getMosymd()),
            pUiBean.getJimuyoucd(),
            pUiBean.getHknsyuruino().getContent(C_HknsyuruiNo.PATTERN_SYANAIDISP),
            pUiBean.getKykkbn().getContent(),
            pUiBean.getYakkanjyuryouhoukbn().getContent(C_YakkanJyuryouKbn.PATTERN_SELECT),
            pUiBean.getFatcasnsikbn().getContent(),
            pUiBean.getBikkjnssinfokbn().getContent(),
            pUiBean.getBikknzsyno(),
            pUiBean.getAeoisnsikbn().getContent(),
            pUiBean.getKyknmkn(),
            pUiBean.getKyknmkj(),
            pUiBean.getKyknmkjkhukakbn().getContent(),
            editYmd(pUiBean.getKykseiymd()),
            pUiBean.getKyksei().getContent(),
            pUiBean.getKyktdk().getContent(),
            pUiBean.getTsinyno(),
            pUiBean.getTsinadr1kj(),
            pUiBean.getTsinadr2kj(),
            pUiBean.getTsinadr3kj(),
            pUiBean.getTsintelno(),
            pUiBean.getDai2tsintelno(),
            pUiBean.getHhknnmkn(),
            pUiBean.getHhknnmkj(),
            pUiBean.getHhknnmkjkhukakbn().getContent(),
            editYmd(pUiBean.getHhknseiymd()),
            pUiBean.getHhknsei().getContent(),
            pUiBean.getTsindousiteikbn().getContent(),
            pUiBean.getHhknyno(),
            pUiBean.getHhknadr1kj(),
            pUiBean.getHhknadr2kj(),
            pUiBean.getHhknadr3kj(),
            pUiBean.getHhkntelno(),
            editYmd(pUiBean.getKktymd()),
            pUiBean.getHhknsykgycd(),
            pUiBean.getHhknnensyuukbn().getContent()
        };

        String[] mosKihon1Dbs = new String[]{
            mosKihonVrf.getAitemosno(),
            mosKihonVrf.getDoujikaiyakusyono(),
            editYmd(mosKihonVrf.getMosymd()),
            mosKihonVrf.getJimuyoucd(),
            mosKihonVrf.getHknsyuruino().getContent(C_HknsyuruiNo.PATTERN_SYANAIDISP),
            mosKihonVrf.getKykkbn().getContent(),
            mosKihonVrf.getYakkanjyuryouhoukbn().getContent(C_YakkanJyuryouKbn.PATTERN_SELECT),
            mosKihonVrf.getFatcasnsikbn().getContent(),
            mosKihonVrf.getBikkjnssinfokbn().getContent(),
            mosKihonVrf.getBikknzsyno(),
            mosKihonVrf.getAeoisnsikbn().getContent(),
            mosKihonVrf.getKyknmkn(),
            mosKihonVrf.getKyknmkj(),
            mosKihonVrf.getKyknmkjkhukakbn().getContent(),
            editYmd(mosKihonVrf.getKykseiymd()),
            mosKihonVrf.getKyksei().getContent(),
            mosKihonVrf.getKyktdk().getContent(),
            mosKihonVrf.getTsinyno(),
            mosKihonVrf.getTsinadr1kj(),
            mosKihonVrf.getTsinadr2kj(),
            mosKihonVrf.getTsinadr3kj(),
            mosKihonVrf.getTsintelno(),
            mosKihonVrf.getDai2tsintelno(),
            mosKihonVrf.getHhknnmkn(),
            mosKihonVrf.getHhknnmkj(),
            mosKihonVrf.getHhknnmkjkhukakbn().getContent(),
            editYmd(mosKihonVrf.getHhknseiymd()),
            mosKihonVrf.getHhknsei().getContent(),
            mosKihonVrf.getTsindousiteikbn().getContent(),
            mosKihonVrf.getHhknyno(),
            mosKihonVrf.getHhknadr1kj(),
            mosKihonVrf.getHhknadr2kj(),
            mosKihonVrf.getHhknadr3kj(),
            mosKihonVrf.getHhkntelno(),
            editYmd(mosKihonVrf.getKktymd()),
            mosKihonVrf.getHhknsykgycd(),
            mosKihonVrf.getHhknnensyuukbn().getContent()
        };

        String[] mosKihon1Disps = new String[]{
            DISP_AITEMOSNO,
            DISP_DOUJIKAIYAKUSYONO,
            DISP_MOSYMD,
            DISP_JIMUYOUCD,
            DISP_HKNSYURUINO,
            DISP_KYKKBN,
            DISP_YAKKANJYURYOUHOUKBN,
            DISP_FATCASNSIKBN,
            DISP_BIKKJNSSINFOKBN,
            DISP_BIKKNZSYNO,
            DISP_AEOISNSIKBN,
            DISP_KYKNMKN,
            DISP_KYKNMKJ,
            DISP_KYKNMKJKHUKAKBN,
            DISP_KYKSEIYMD,
            DISP_KYKSEI,
            DISP_KYKTDK,
            DISP_TSINYNO,
            DISP_TSINADR1KJ,
            DISP_TSINADR2KJ,
            DISP_TSINADR3KJ,
            DISP_TSINTELNO,
            DISP_DAI2TSINTELNO,
            DISP_HHKNNMKN,
            DISP_HHKNNMKJ,
            DISP_HHKNNMKJKHUKAKBN,
            DISP_HHKNSEIYMD,
            DISP_HHKNSEI,
            DISP_TSINDOUSITEIKBN,
            DISP_HHKNYNO,
            DISP_HHKNADR1KJ,
            DISP_HHKNADR2KJ,
            DISP_HHKNADR3KJ,
            DISP_HHKNTELNO,
            DISP_KKTYMD,
            DISP_HHKNSYKGYCD,
            DISP_HHKNNENSYUUKBN,
        };

        String[] mosKihon1Keys = new String[] {
            AITEMOSNO,
            DOUJIKAIYAKUSYONO,
            MOSYMD,
            JIMUYOUCD,
            HKNSYURUINO,
            KYKKBN,
            YAKKANJYURYOUHOUKBN,
            FATCASNSIKBN,
            BIKKJNSSINFOKBN,
            BIKKNZSYNO,
            AEOISNSIKBN,
            KYKNMKN,
            KYKNMKJ,
            KYKNMKJKHUKAKBN,
            KYKSEIYMD,
            KYKSEI,
            KYKTDK,
            TSINYNO,
            TSINADR1KJ,
            TSINADR2KJ,
            TSINADR3KJ,
            TSINTELNO,
            DAI2TSINTELNO,
            HHKNNMKN,
            HHKNNMKJ,
            HHKNNMKJKHUKAKBN,
            HHKNSEIYMD,
            HHKNSEI,
            TSINDOUSITEIKBN,
            HHKNYNO,
            HHKNADR1KJ,
            HHKNADR2KJ,
            HHKNADR3KJ,
            HHKNTELNO,
            KKTYMD,
            HHKNSYKGYCD,
            HHKNNENSYUUKBN,
        };

        for (int index = 0; index < mosKihon1Gms.length; index++) {
            if (!(mosKihon1Gms[index].equals(mosKihon1Dbs[index]))) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    mosKihon1Disps[index],
                    convertWarekiseireki(mosKihon1Keys[index], mosKihon1Dbs[index]),
                    convertWarekiseireki(mosKihon1Keys[index], mosKihon1Gms[index]),
                    pSousasyaCd,
                    pSysDate);
            }
        }

        String nenkinuktKbnGm = pUiBean.getNenkinuktkbn().getContent(C_UktKbn.PATTERN_NKUKT);

        if (uketorininVrfNkUktLst != null && uketorininVrfNkUktLst.size() != 0) {
            HT_UketorininVrf uketorininVrfNkUkt = uketorininVrfNkUktLst.get(0);

            String nenkinuktKbnDb = uketorininVrfNkUkt.getUktkbn().getContent(C_UktKbn.PATTERN_NKUKT);

            if (!nenkinuktKbnGm.equals(nenkinuktKbnDb)) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    DISP_NENKINUKTKBN,
                    nenkinuktKbnDb,
                    nenkinuktKbnGm,
                    pSousasyaCd,
                    pSysDate);
            }
        }
        else if (!(C_UktKbn.BLNK.getContent().equals(nenkinuktKbnGm))) {
            saiUmu = NRKSAIARI;
            hyoujiJyunRen++;

            insertNrkDif(syoriCTL,
                ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                hyoujiJyunRen,
                DISP_NENKINUKTKBN,
                "",
                nenkinuktKbnGm,
                pSousasyaCd,
                pSysDate);
        }

        String sbuktNinDb = zero2Blank(mosKihonVrf.getSbuktnin());
        String sbuktNinGm = zero2Blank(pUiBean.getSbuktnin());

        if (!sbuktNinGm.equals(sbuktNinDb)) {
            saiUmu = NRKSAIARI;
            hyoujiJyunRen++;

            insertNrkDif(syoriCTL,
                ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                hyoujiJyunRen,
                DISP_SBUKTNIN,
                sbuktNinDb,
                sbuktNinGm,
                pSousasyaCd,
                pSysDate);
        }

        StringBuffer koumokuNm = null;

        String[] sbUktGms = new String[]{
            DISPSBUKTKBN,
            DISPSBUKTNMKN,
            DISPSBUKTNMKJ,
            DISPSBUKTNMKJHUKAKBN,
            DISPSBUKTSEIYMD,
            DISPSBUKTTDK,
            DISPSBUKTBNWARI
        };

        String[] sbUktDbs = null;

        String[] sbUktDisps = new String[]{
            DISP_DISPSBUKTKBN,
            DISP_DISPSBUKTNMKN,
            DISP_DISPSBUKTNMKJ,
            DISP_DISPSBUKTNMKJHUKAKBN,
            DISP_DISPSBUKTSEIYMD,
            DISP_DISPSBUKTTDK,
            DISP_DISPSBUKTBNWARI
        };

        int kaiSuu = 4;
        HT_UketorininVrf uketorininVrf = null;
        Map<String, String[]> sbUktMap = getMousikomisyoSbUkt(pUiBean);
        int sbUktCount = sbUktGms.length;

        for (int index = 0; index < kaiSuu; index++) {
            uketoriRenno++;

            if (index < uketorininVrfSbUktLst.size()) {

                uketorininVrf = uketorininVrfSbUktLst.get(index);

                sbUktDbs = new String[]{
                    uketorininVrf.getUktkbn().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
                    uketorininVrf.getUktnmkn(),
                    uketorininVrf.getUktnmkj(),
                    uketorininVrf.getUktnmkjkhukakbn().getContent(),
                    editYmd(uketorininVrf.getUktseiymd()),
                    uketorininVrf.getUkttdk().getContent(C_Tdk.PATTERN_SBUKT),
                    zero2Blank(uketorininVrf.getUktbnwari())
                };

                String[] sbUktDbKeys = new String[]{
                    UKTKBN,
                    UKTNMKN,
                    UKTNMKJ,
                    UKTNMKJKHUKAKBN,
                    UKTSEIYMD,
                    UKTTDK,
                    UKTBNWARI
                };

                for (int loopCount = 0; loopCount < sbUktCount; loopCount++) {

                    String valueDb = sbUktDbs[loopCount];
                    String valueGm = sbUktMap.get(sbUktGms[loopCount])[index];

                    if (!(valueDb.equals(valueGm))) {
                        saiUmu = NRKSAIARI;
                        hyoujiJyunRen++;

                        koumokuNm = new StringBuffer();
                        koumokuNm.append(sbUktDisps[loopCount]);
                        koumokuNm.append(uketoriRenno);

                        insertNrkDif(syoriCTL,
                            ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                            hyoujiJyunRen,
                            koumokuNm.toString(),
                            convertWarekiseireki(sbUktDbKeys[loopCount], valueDb),
                            convertWarekiseireki(sbUktGms[loopCount], valueGm),
                            pSousasyaCd,
                            pSysDate);
                    }
                }
            }
            else {

                for (int loopCount = 0; loopCount < sbUktCount; loopCount++) {

                    if (BizUtil.isBlank(sbUktMap.get(sbUktGms[loopCount])[index]) ||
                        "0".equals(sbUktMap.get(sbUktGms[loopCount])[index])) {
                        continue;
                    }

                    saiUmu = NRKSAIARI;
                    hyoujiJyunRen++;

                    koumokuNm = new StringBuffer();
                    koumokuNm.append(sbUktDisps[loopCount]);
                    koumokuNm.append(uketoriRenno);

                    insertNrkDif(syoriCTL,
                        ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                        hyoujiJyunRen,
                        koumokuNm.toString(),
                        "",
                        convertWarekiseireki(sbUktGms[loopCount], sbUktMap.get(sbUktGms[loopCount])[index]),
                        pSousasyaCd,
                        pSysDate);
                }
            }
        }

        HT_MosSyouhnVrf mosSyouhnVrfSyu = mosSyouhnVrfSyuLst.get(0);

        String dai1HknkknGm = "0";
        String kihonsGm = editTuuka(pUiBean.getKihons());
        String hrkTuukaSyukykpGm = editTuuka(pUiBean.getHrktuukasyukykp());
        String mosikkatupGm = editTuuka(pUiBean.getMosikkatup());
        String mossyukykpGm = editTuuka(pUiBean.getMossyukykp());
        String moszennoupsyokaiariGm = editTuuka(pUiBean.getMoszennoupsyokaiari());
        String hrktuukasyutkp2Gm = editTuuka(pUiBean.getHrktuukasyukykp2());
        String mosikkatup2Gm = editTuuka(pUiBean.getMosikkatup2());
        String moszennoupsyokaiari2Gm = editTuuka(pUiBean.getMoszennoupsyokaiari2());
        String kihons2Gm = editTuuka(pUiBean.getKihons2());

        String kihonsDb = editTuuka(mosSyouhnVrfSyu.getKihons());
        String hrktuukasyukykpDb = "";
        if (!C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            hrktuukasyukykpDb = editTuuka(mosSyouhnVrfSyu.getHrktuukasyutkp());
        }
        String mosikkatupDb = editTuuka(mosKihonVrf.getMosikkatup());
        String mossyukykpDb = "";
        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            mossyukykpDb = editTuuka(mosSyouhnVrfSyu.getHrktuukasyutkp());
        }
        String moszennoupsyokaiariDb = editTuuka(mosKihonVrf.getMoszennoupsyokaiari());
        String hrktuukasyutkp2Db = editTuuka(mosSyouhnVrfSyu.getHrktuukasyutkp2());
        String mosikkatup2Db = editTuuka(mosKihonVrf.getMosikkatup2());
        String moszennoupsyokaiari2Db = editTuuka(mosKihonVrf.getMoszennoupsyokaiari2());
        String kihons2Db = editTuuka(mosSyouhnVrfSyu.getKihons2());

        String kykTuukasyuDb = null;
        String hrkTuukasyuDb = null;
        String kykTuukasyuDb2 = null;
        String hrkTuukasyuDb2 = null;
        String hknKknDb = "0";
        String hrkKknDb = "0";
        String sueokiKknDb = "0";
        int znnkaiDb = 0;

        String dispHknkkn = DISP_SYUHKNKKNMOSINPUT;
        String dispHrkkkn = DISP_SYUHRKKKNMOSINPUT;
        String dispKyktuukasyu = DISP_KYKTUUKASYU;
        String dispHrktuukasyu = DISP_HRKTUUKASYU;
        String dispKihons = DISP_KIHONS;
        String dispHrktuukasyup = DISP_HRKTUUKASYUP;
        String dispMosikkatup = DISP_MOSIKKATUP;
        String dispMossyukykp = DISP_MOSSYUKYKP;
        String dispMoszennoupsyokaiari = DISP_MOSZENNOUPSYOKAIARI;
        String dispKjnnkpzeitekitkhukakbn = DISP_KJNNKPZEITEKITKHUKAKBN;

        if (!BizUtil.isBlank(pUiBean.getSyudai1hknkknmosinput())) {
            dai1HknkknGm = pUiBean.getSyudai1hknkknmosinput();
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {
            kykTuukasyuDb = mosKihonVrf.getKyktuukasyu().getContent();
            hrkTuukasyuDb = mosKihonVrf.getHrktuukasyu().getContent();
            kykTuukasyuDb2 = mosKihonVrf.getKyktuukasyu2().getContent(C_Tuukasyu.PATTERN_GAIKA);
            hrkTuukasyuDb2 = mosKihonVrf.getHrktuukasyu2().getContent();
        }
        else {
            kykTuukasyuDb = C_Tuukasyu.BLNK.getContent();
            hrkTuukasyuDb= C_Tuukasyu.BLNK.getContent();
            kykTuukasyuDb2 = C_Tuukasyu.BLNK.getContent();
            hrkTuukasyuDb2 = C_Tuukasyu.BLNK.getContent();
        }

        int syouhnHanteikbn = SyouhinUtil.hantei(mosSyouhnVrfSyu.getSyouhncd());

        if (syouhnHanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syouhnHanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            sueokiKknDb = mosSyouhnVrfSyu.getHknkkn().toString();
        }

        if (syouhnHanteikbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
            syouhnHanteikbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            hknKknDb = mosSyouhnVrfSyu.getHknkkn().toString();
        }

        if (syouhnHanteikbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            hrkKknDb = mosSyouhnVrfSyu.getHrkkkn().toString();

            hknKknDb = mosSyouhnVrfSyu.getHknkkn().toString();

            dispHrkkkn = DISP_PHRKMNRYNEN;
            dispHknkkn = DISP_NKSHRSTARTNEN;

            if (!BizUtil.isBlank(mosKihonVrf.getAitemosno())) {

                dispKyktuukasyu = DISP_KYKTUUKASYU_USD;
                dispHrktuukasyu = DISP_HRKTUUKASYU_USD;
                dispKihons = DISP_KIHONS_USD;
                dispHrktuukasyup = DISP_HRKTUUKASYUP_USD;
                dispMosikkatup = DISP_MOSIKKATUP_USD;
                dispMoszennoupsyokaiari = DISP_MOSZENNOUPSYOKAIARI_USD;
                dispKjnnkpzeitekitkhukakbn = DISP_KJNNKPZEITEKITKHUKAKBN_USD;
            }

        }

        if (syouhnHanteikbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            hrkKknDb = mosSyouhnVrfSyu.getHrkkkn().toString();

            hknKknDb = mosSyouhnVrfSyu.getHknkkn().toString();
        }

        if (mosKihonVrf.getZnnkai() > 0) {

            znnkaiDb = mosKihonVrf.getZnnkai() + 1;
        }

        String[] syuKeiyakuHosyouJouhouGm = new String[] {
            pUiBean.getSyuhrkkkn().toString(),
            pUiBean.getSyuhknkkn().toString(),
            dai1HknkknGm,
            pUiBean.getSdpdkbn().getContent(),
            pUiBean.getSknenkinsyu().getContent(),
            pUiBean.getZenkizennouumu().getContent(),
            zero2Blank(pUiBean.getZnnkai()),
            pUiBean.getHrkkaisuu().getContent(),
            pUiBean.getHrkkeiro().getContent(C_Hrkkeiro.PATTERN_SINKEIYAKU),
            pUiBean.getFstphrkkeirokbn().getContent(C_FstphrkkeiroKbn.PATTERN_SKSELECT),
            pUiBean.getIkkatubaraikaisuu().getContent(C_IkkatubaraiKaisuuKbn.PATTERN_TEIKI),
            pUiBean.getKyktuukasyu().getContent(),
            pUiBean.getHrktuukasyu().getContent(),
            kihonsGm,
            hrkTuukaSyukykpGm,
            mosikkatupGm,
            mossyukykpGm,
            moszennoupsyokaiariGm,
            pUiBean.getSisuuhaibunwarikbn().getContent(),
            pUiBean.getTeirituhaibunwarikbn().getContent(),
            pUiBean.getSueokikknmosinput(),
            pUiBean.getNkgnshosyouritukbn().getContent(),
            pUiBean.getKjnnkpzeitekitkhukakbn().getContent(),
            pUiBean.getKyktuukasyu2().getContent(),
            pUiBean.getHrktuukasyu2().getContent(),
            kihons2Gm,
            hrktuukasyutkp2Gm,
            mosikkatup2Gm,
            moszennoupsyokaiari2Gm,
            pUiBean.getKjnnkpzeitekitkhukakbn2().getContent()
        };

        String[] syuKeiyakuHosyouJouhouDb = new String[] {
            hrkKknDb,
            hknKknDb,
            mosSyouhnVrfSyu.getDai1hknkkn().toString(),
            mosKihonVrf.getSdpdkbn().getContent(),
            mosSyouhnVrfSyu.getSknenkinsyu().getContent(),
            mosKihonVrf.getZenkizennouumu().getContent(),
            zero2Blank(znnkaiDb),
            mosKihonVrf.getHrkkaisuu().getContent(),
            mosKihonVrf.getHrkkeiro().getContent(C_Hrkkeiro.PATTERN_SINKEIYAKU),
            mosKihonVrf.getFstphrkkeirokbn().getContent(C_FstphrkkeiroKbn.PATTERN_SKSELECT),
            mosKihonVrf.getIkkatubaraikaisuu().getContent(C_IkkatubaraiKaisuuKbn.PATTERN_TEIKI),
            kykTuukasyuDb,
            hrkTuukasyuDb,
            kihonsDb,
            hrktuukasyukykpDb,
            mosikkatupDb,
            mossyukykpDb,
            moszennoupsyokaiariDb,
            mosKihonVrf.getSisuuhaibunwarikbn().getContent(),
            mosKihonVrf.getTeirituhaibunwarikbn().getContent(),
            sueokiKknDb,
            mosKihonVrf.getNkgnshosyouritukbn().getContent(),
            mosKihonVrf.getKjnnkpzeitekitkhukakbn().getContent(),
            kykTuukasyuDb2,
            hrkTuukasyuDb2,
            kihons2Db,
            hrktuukasyutkp2Db,
            mosikkatup2Db,
            moszennoupsyokaiari2Db,
            mosKihonVrf.getKjnnkpzeitekitkhukakbn2().getContent()
        };

        String[] syuKeiyakuHosyouJouhouDisps = new String[] {
            dispHrkkkn,
            dispHknkkn,
            DISP_SYUDAI1HKNKKNMOSINPUT,
            DISP_SDPDKBN,
            DISP_SKNENKINSYU,
            DISP_ZENKIZENNOUUMU,
            DISP_ZENNOUKIKAN,
            DISP_HRKKAISUU,
            DISP_HRKKEIRO,
            DISP_FSTPHRKKEIROKBN,
            DISP_IKKATUBARAIKAISUU,
            dispKyktuukasyu,
            dispHrktuukasyu,
            dispKihons,
            dispHrktuukasyup,
            dispMosikkatup,
            dispMossyukykp,
            dispMoszennoupsyokaiari,
            DISP_SISUUHAIBUNWARIKBN,
            DISP_TEIRITUHAIBUNWARIKBN,
            DISP_SUEOKIKKNMOSINPUT,
            DISP_NKGNSHOSYOURITUKBN,
            dispKjnnkpzeitekitkhukakbn,
            DISP_KYKTUUKASYU_AUD,
            DISP_HRKTUUKASYU_AUD,
            DISP_KIHONS_AUD,
            DISP_HRKTUUKASYUP_AUD,
            DISP_MOSIKKATUP_AUD,
            DISP_MOSZENNOUPSYOKAIARI_AUD,
            DISP_KJNNKPZEITEKITKHUKAKBN_AUD

        };

        for (int index = 0; index < syuKeiyakuHosyouJouhouGm.length; index++) {
            String valueDb = syuKeiyakuHosyouJouhouDb[index];
            String valueGm = syuKeiyakuHosyouJouhouGm[index];

            if (!valueDb.equals(valueGm)) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    syuKeiyakuHosyouJouhouDisps[index],
                    valueDb,
                    valueGm,
                    pSousasyaCd,
                    pSysDate);
            }
        }

        // 2016/03/03 S社導入：コメントアウト
        //        String[] mousikomisyoTkGms = new String[]{
        //                DISPTKKATAKBNKAHI,
        //                DISPTKKYHKATAKBN,
        //                DISPTKKIHONS,
        //                DISPTKHKNKKN,
        //                DISPTKHKNKKNSMNKBN,
        //                DISPTKHRKKKN,
        //                DISPTKHRKKKNSMNKBN
        //        };
        //
        //        String[] mousikomisyoTkDbs = null;
        //
        //        String[] mousikomisyoTkDisps = new String[]{
        //                DISP_DISPTKKATAKBNKAHI,
        //                DISP_DISPTKKYHKATAKBN,
        //                DISP_DISPTKKIHONS,
        //                DISP_DISPTKHKNKKN,
        //                DISP_DISPTKHKNKKNSMNKBN,
        //                DISP_DISPTKHRKKKN,
        //                DISP_DISPTKHRKKKNSMNKBN
        //        };
        //
        //        Map<String, String[]> sortedMap = sortMousikomisyo(pUiBean, mosNo);
        //        int kaiSuu = 10;
        //        int mousikomisyoTkCount = mousikomisyoTkGms.length;
        //
        //        StringBuffer koumokuNm = null;
        //        HT_MosSyouhnVrf mosSyouhnVrf = null;
        //
        //        for (int index = 0; index < kaiSuu; index++) {
        //
        //            tkRenno++;
        //
        //            if (index < mosSyouhnVrfTkLst.size()) {
        //
        //                mosSyouhnVrf = mosSyouhnVrfTkLst.get(index);
        //
        //                mousikomisyoTkDbs = new String[]{
        //                        mosSyouhnVrf.getKatakbn().getContent(),
        //                        mosSyouhnVrf.getKyhkatakbn().getContent(),
        //                        zero2Blank(mosSyouhnVrf.getKihons()),
        //                        zero2Blank(mosSyouhnVrf.getHknkkn()),
        //                        mosSyouhnVrf.getHknkknsmnkbn().getContent(C_HknkknsmnKbn.PATTERN_MOS),
        //                        zero2Blank(mosSyouhnVrf.getHrkkkn()),
        //                        mosSyouhnVrf.getHrkkknsmnkbn().getContent(C_HrkkknsmnKbn.PATTERN_MOS)
        //                };
        //
        //                if (!(mosSyouhnVrf.getSyouhncd().equals(sortedMap.get(DISPTKSYOUHNCD)[index]))) {
        //                    saiUmu = NRKSAIARI;
        //                    hyoujiJyunRen++;
        //
        //                    String tkSyouhnCdDb = mosSyouhnVrf.getSyouhncd();
        //                    String tkSyouhnCdGm = sortedMap.get(DISPTKSYOUHNCD)[index];
        //
        //                    String itijiNrkSyouhnNm = "";
        //                    String nijiNrkSyouhnNm = "";
        //
        //                    if (!BizUtil.isBlank(tkSyouhnCdDb)) {
        //                        itijiNrkSyouhnNm = syouhinUtil.getSyouhnNm(tkSyouhnCdDb, BizDate.getSysDate());
        //                    }
        //
        //                    if (!BizUtil.isBlank(tkSyouhnCdGm)) {
        //                        nijiNrkSyouhnNm = syouhinUtil.getSyouhnNm(tkSyouhnCdGm, BizDate.getSysDate());
        //                    }
        //
        //                    if (tkRenno < kaiSuu) {
        //                        koumokuNm = new StringBuffer();
        //                        koumokuNm.append(DISP_DISPTKSYOUHNCD);
        //                        koumokuNm.append("0");
        //                        koumokuNm.append(tkRenno);
        //                    }
        //                    else {
        //                        koumokuNm = new StringBuffer();
        //                        koumokuNm.append(DISP_DISPTKSYOUHNCD);
        //                        koumokuNm.append(tkRenno);
        //                    }
        //
        //                    insertNrkDif(syoriCTL,
        //                            ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
        //                            hyoujiJyunRen,
        //                            koumokuNm.toString(),
        //                            itijiNrkSyouhnNm,
        //                            nijiNrkSyouhnNm,
        //                            pSousasyaCd,
        //                            pSysDate);
        //                }
        //
        //                for (int loopCount = 0; loopCount < mousikomisyoTkCount; loopCount++) {
        //
        //                    String valueGm = sortedMap.get(mousikomisyoTkGms[loopCount])[index];
        //                    String valueDb = mousikomisyoTkDbs[loopCount];
        //
        //                    if (!(valueDb.equals(valueGm))) {
        //                        saiUmu = NRKSAIARI;
        //                        hyoujiJyunRen++;
        //
        //                        if (tkRenno < kaiSuu) {
        //                            koumokuNm = new StringBuffer();
        //                            koumokuNm.append(mousikomisyoTkDisps[loopCount]);
        //                            koumokuNm.append("0");
        //                            koumokuNm.append(tkRenno);
        //                        }
        //                        else {
        //                            koumokuNm = new StringBuffer();
        //                            koumokuNm.append(mousikomisyoTkDisps[loopCount]);
        //                            koumokuNm.append(tkRenno);
        //                        }
        //
        //                        insertNrkDif(syoriCTL,
        //                                ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
        //                                hyoujiJyunRen,
        //                                koumokuNm.toString(),
        //                                valueDb,
        //                                valueGm,
        //                                pSousasyaCd,
        //                                pSysDate);
        //                    }
        //                }
        //            }
        //            else if (!BizUtil.isBlank(sortedMap.get(DISPTKSYOUHNCD)[index])) {
        //                saiUmu = NRKSAIARI;
        //                hyoujiJyunRen++;
        //
        //                String tkSyouhnCdGm = sortedMap.get(DISPTKSYOUHNCD)[index];
        //                String nijiNrkSyouhnNm = "";
        //
        //                if (!BizUtil.isBlank(tkSyouhnCdGm)) {
        //                    nijiNrkSyouhnNm = syouhinUtil.getSyouhnNm(tkSyouhnCdGm, BizDate.getSysDate());
        //                }
        //
        //                if (tkRenno < kaiSuu) {
        //                    koumokuNm = new StringBuffer();
        //                    koumokuNm.append(DISP_DISPTKSYOUHNCD);
        //                    koumokuNm.append("0");
        //                    koumokuNm.append(tkRenno);
        //                }
        //                else {
        //                    koumokuNm = new StringBuffer();
        //                    koumokuNm.append(DISP_DISPTKSYOUHNCD);
        //                    koumokuNm.append(tkRenno);
        //                }
        //
        //                insertNrkDif(syoriCTL,
        //                        ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
        //                        hyoujiJyunRen,
        //                        koumokuNm.toString(),
        //                        "",
        //                        nijiNrkSyouhnNm,
        //                        pSousasyaCd,
        //                        pSysDate);
        //
        //                for (int loopCount = 0; loopCount < mousikomisyoTkCount; loopCount++) {
        //                    if (isBlankTokuyakuJohou(sortedMap.get(mousikomisyoTkGms[loopCount])[index],
        //                            mousikomisyoTkGms[loopCount])) {
        //                        continue;
        //                    }
        //
        //                    saiUmu = NRKSAIARI;
        //                    hyoujiJyunRen++;
        //
        //                    if (tkRenno < kaiSuu) {
        //                        koumokuNm = new StringBuffer();
        //                        koumokuNm.append(mousikomisyoTkDisps[loopCount]);
        //                        koumokuNm.append("0");
        //                        koumokuNm.append(tkRenno);
        //                    }
        //                    else {
        //                        koumokuNm = new StringBuffer();
        //                        koumokuNm.append(mousikomisyoTkDisps[loopCount]);
        //                        koumokuNm.append(tkRenno);
        //                    }
        //
        //                    insertNrkDif(syoriCTL,
        //                            ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
        //                            hyoujiJyunRen,
        //                            koumokuNm.toString(),
        //                            "",
        //                            sortedMap.get(mousikomisyoTkGms[loopCount])[index],
        //                            pSousasyaCd,
        //                            pSysDate);
        //                }
        //            }
        //        }

        C_KouzaInfoInputHoryuuKbn shkstkzinfkzinfoinputhrykbn = C_KouzaInfoInputHoryuuKbn.BLNK;
        C_KouzasyuruiKbn kzsyuruikbn = C_KouzasyuruiKbn.BLNK;
        String bankCd = "";
        String sitenCd = "";
        C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
        String kouzaNo = "";
        C_KzkykdouKbn kzkykdouKbn = C_KzkykdouKbn.BLNK;
        String kzmeiginmkn = "";
        String kzmeiginmknGm = pUiBean.getKzmeiginmkn();

        if (uketoriKouzaJyouhouVrf == null) {

        }
        else {
            shkstkzinfkzinfoinputhrykbn = uketoriKouzaJyouhouVrf.getKouzainfoinputhoryuukbn();
            kzsyuruikbn = uketoriKouzaJyouhouVrf.getKzsyuruikbn();
            bankCd = uketoriKouzaJyouhouVrf.getBankcd();
            sitenCd = uketoriKouzaJyouhouVrf.getSitencd();
            yokinKbn = uketoriKouzaJyouhouVrf.getYokinkbn();
            kouzaNo = uketoriKouzaJyouhouVrf.getKouzano();
            kzkykdouKbn = uketoriKouzaJyouhouVrf.getKzkykdoukbn();
            kzmeiginmkn = uketoriKouzaJyouhouVrf.getKzmeiginmkn();
        }

        if (C_KzkykdouKbn.DOUITU.eq(pUiBean.getKzkykdoukbn())) {

            kzmeiginmknGm = "";
        }

        String[] mosKihon5Gms = new String[]{
            pUiBean.getTeikisiharaitkykhkkbn().getContent(),
            pUiBean.getShkstkzinfkzinfoinputhrykbn().getContent(),
            pUiBean.getKzsyuruikbn().getContent(C_KouzasyuruiKbn.PATTERN_SHKSTKZ),
            pUiBean.getBankcd(),
            pUiBean.getSitencd(),
            pUiBean.getYokinkbn().getContent(),
            pUiBean.getKouzano(),
            pUiBean.getKzkykdoukbn().getContent(),
            kzmeiginmknGm,
            pUiBean.getTargettkmkhtkbn().getContent(),
            pUiBean.getSyksbyensitihsyutkhkkbn().getContent(),
            pUiBean.getJyudkaigomehrtkhkkbn().getContent(),
            pUiBean.getNstkhkkbn().getContent(),
            zero2Blank(pUiBean.getNstksbnkkn())
        };

        String[] mosKihon5Dbs = new String[]{
            mosKihonVrf.getTeikisiharaitkykhkkbn().getContent(),
            shkstkzinfkzinfoinputhrykbn.getContent(),
            kzsyuruikbn.getContent(C_KouzasyuruiKbn.PATTERN_SHKSTKZ),
            bankCd,
            sitenCd,
            yokinKbn.getContent(),
            kouzaNo,
            kzkykdouKbn.getContent(),
            kzmeiginmkn,
            mosKihonVrf.getTargettkmkhtkbn().getContent(),
            mosKihonVrf.getSyksbyensitihsyutkhkkbn().getContent(),
            mosKihonVrf.getJyudkaigomehrtkhkkbn().getContent(),
            mosKihonVrf.getNstkhkkbn().getContent(),
            zero2Blank(mosKihonVrf.getNstksbnkkn())
        };

        String[] mosKihon5Disps = new String[]{
            DISP_TEIKISIHARAITKYKHKKBN,
            DISP_SHKSTKZINFKZINFOINPUTHRYKBN,
            DISP_KZSYURUIKBN,
            DISP_BANKCD,
            DISP_SITENCD,
            DISP_YOKINKBN,
            DISP_KOUZANO,
            DISP_KZKYKDOUKBN,
            DISP_KZMEIGINMKN,
            DISP_TARGETTKMKHTKBN,
            DISP_SYKSBYENSITIHSYUTKHKKBN,
            DISP_JYUDKAIGOMEHRTKHKKBN,
            DISP_NSTKHKKBN,
            DISP_NSTKSBNKKN
        };

        for (int index = 0; index < mosKihon5Gms.length; index++) {
            if (!(mosKihon5Gms[index].equals(mosKihon5Dbs[index]))) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    mosKihon5Disps[index],
                    mosKihon5Dbs[index],
                    mosKihon5Gms[index],
                    pSousasyaCd,
                    pSysDate);
            }
        }

        String[] kzkDrDsHtInfoGms = new String[]{
            pUiBean.getKzktourokuservicetourokukbn().getContent(),
            pUiBean.getTrkkzknmkn1(),
            pUiBean.getTrkkzknmkj1(),
            pUiBean.getTrkkzknmkjkhukakbn1().getContent(),
            editYmd(pUiBean.getTrkkzkseiymd1()),
            pUiBean.getTrkkzksei1().getContent(C_Seibetu.PATTERN_SELECT),
            pUiBean.getTrkkzktdk1().getContent(C_Tdk.PATTERN_TRKKZK),
            pUiBean.getTrkkzktsindousiteikbn1().getContent(),
            pUiBean.getTrkkzkyno1(),
            pUiBean.getTrkkzkadr1kj1(),
            pUiBean.getTrkkzkadr2kj1(),
            pUiBean.getTrkkzkadr3kj1(),
            pUiBean.getTrkkzktelno1(),
            pUiBean.getStdrsktkyhkkbn().getContent(),
            pUiBean.getStdruktkbn().getContent(C_UktKbn.PATTERN_SKSTDR),
            pUiBean.getSiteidruktnmkn(),
            pUiBean.getSiteidruktnmkj(),
            pUiBean.getStdrsknmkjhukakbn().getContent(),
            editYmd(pUiBean.getStdrskseiymd()),
            pUiBean.getStdrsktdk().getContent(C_Tdk.PATTERN_STDR),
            pUiBean.getDrctservicemoskbn().getContent(C_DirectServiceMosKbn.PATTERN_MOS),
            pUiBean.getYnkhrkmgkannituutikbn().getContent()
        };

        String[] kzkDrDsHtInfoDisps = new String[]{
            DISP_KZKTOUROKUSERVICETOUROKUKBN,
            DISP_TRKKZKNMKN1,
            DISP_TRKKZKNMKJ1,
            DISP_TRKKZKNMKJKHUKAKBN1,
            DISP_TRKKZKSEIYMD1,
            DISP_TRKKZKSEI1,
            DISP_TRKKZKTDK1,
            DISP_TRKKZKTSINDOUSITEIKBN1,
            DISP_TRKKZKYNO1,
            DISP_TRKKZKADR1KJ1,
            DISP_TRKKZKADR2KJ1,
            DISP_TRKKZKADR3KJ1,
            DISP_TRKKZKTELNO1,
            DISP_HHKSDRSKTKYHKKBN,
            DISP_STDRUKTKBN,
            DISP_SITEIDRUKTNMKN,
            DISP_SITEIDRUKTNMKJ,
            DISP_STDRSKNMKJHUKAKBN,
            DISP_SITEIDRSEIYMD,
            DISP_STDRSKTDK,
            DISP_DRCTSERVICEMOSKBN,
            DISP_YNKHRKMGKANNITUUTIKBN
        };

        int kzkDrDsHtInfoCount = kzkDrDsHtInfoGms.length;

        String mosKihonInfoDBkzktourokuservicetourokukbn = mosKihonVrf.getKzktourokuservicetourokukbn().getContent();
        String trkkzknmkn = "";
        String trkkzknmkj = "";
        String trkkzknmkjkhukakbn = C_KjkhukaKbn.BLNK.getContent();
        String trkkzkseiymd = "";
        String trkkzksei = C_Seibetu.BLNK.getContent(C_Seibetu.PATTERN_SELECT);
        String trkkzktdk = C_Tdk.BLNK.getContent(C_Tdk.PATTERN_TRKKZK);
        String trkkzktsindousiteikbn = C_TsindousiteiKbn.BLNK.getContent();
        String trkkzkyno = "";
        String trkkzkadr1kj = "";
        String trkkzkadr2kj = "";
        String trkkzkadr3kj = "";
        String trkkzktelno = "";
        String mosKihonInfoDBStdrsktkyhkkbn = mosKihonVrf.getStdrsktkyhkkbn().getContent();
        String hhknDairiSkDBUktkbn = C_UktKbn.BLNK.getContent(C_UktKbn.PATTERN_SKSTDR);
        String hhknDairiSkDBUktnmkn = "";
        String hhknDairiSkDBUktnmkj = "";
        String hhknDairiSkDBUktnmkjkhukakbn = C_KjkhukaKbn.BLNK.getContent();
        String hhknDairiSkDBUktseiymd = "";
        String hhknDairiSkDBUkttdk = C_Tdk.BLNK.getContent(C_Tdk.PATTERN_STDR);
        String mosKihonInfoDBDrctservicemoskbn = mosKihonVrf.getDrctservicemoskbn().getContent(
            C_DirectServiceMosKbn.PATTERN_MOS);
        String mosKihonInfoDBYnkhrkmgkannituutikbn = mosKihonVrf.getYnkhrkmgkannituutikbn().getContent();

        if (mosTrkKzkVrEnt != null) {

            trkkzknmkn = mosTrkKzkVrEnt.getTrkkzknmkn();
            trkkzknmkj = mosTrkKzkVrEnt.getTrkkzknmkj();
            trkkzknmkjkhukakbn = mosTrkKzkVrEnt.getTrkkzknmkjkhukakbn().getContent();
            trkkzkseiymd = editYmd(mosTrkKzkVrEnt.getTrkkzkseiymd());
            trkkzksei = mosTrkKzkVrEnt.getTrkkzksei().getContent(C_Seibetu.PATTERN_SELECT);
            trkkzktdk = mosTrkKzkVrEnt.getTrkkzktdk().getContent(C_Tdk.PATTERN_TRKKZK);
            trkkzktsindousiteikbn = mosTrkKzkVrEnt.getTrkkzktsindousiteikbn().getContent();
            trkkzkyno = mosTrkKzkVrEnt.getTrkkzkyno();
            trkkzkadr1kj = mosTrkKzkVrEnt.getTrkkzkadr1kj();
            trkkzkadr2kj = mosTrkKzkVrEnt.getTrkkzkadr2kj();
            trkkzkadr3kj = mosTrkKzkVrEnt.getTrkkzkadr3kj();
            trkkzktelno = mosTrkKzkVrEnt.getTrkkzktelno();
        }

        if (hhknSyaDairininUketorininVrfLst != null && hhknSyaDairininUketorininVrfLst.size() != 0) {

            uketorininVrf = hhknSyaDairininUketorininVrfLst.get(0);

            hhknDairiSkDBUktkbn = uketorininVrf.getUktkbn().getContent(C_UktKbn.PATTERN_SKSTDR);
            hhknDairiSkDBUktnmkn = uketorininVrf.getUktnmkn();
            hhknDairiSkDBUktnmkj = uketorininVrf.getUktnmkj();
            hhknDairiSkDBUktnmkjkhukakbn = uketorininVrf.getUktnmkjkhukakbn().getContent();
            hhknDairiSkDBUktseiymd = editYmd(uketorininVrf.getUktseiymd());
            hhknDairiSkDBUkttdk = uketorininVrf.getUkttdk().getContent(C_Tdk.PATTERN_STDR);
        }

        String[] kzkDrDsHtInfoDbs = new String[]{
            mosKihonInfoDBkzktourokuservicetourokukbn,
            trkkzknmkn,
            trkkzknmkj,
            trkkzknmkjkhukakbn,
            trkkzkseiymd,
            trkkzksei,
            trkkzktdk,
            trkkzktsindousiteikbn,
            trkkzkyno,
            trkkzkadr1kj,
            trkkzkadr2kj,
            trkkzkadr3kj,
            trkkzktelno,
            mosKihonInfoDBStdrsktkyhkkbn,
            hhknDairiSkDBUktkbn,
            hhknDairiSkDBUktnmkn,
            hhknDairiSkDBUktnmkj,
            hhknDairiSkDBUktnmkjkhukakbn,
            hhknDairiSkDBUktseiymd,
            hhknDairiSkDBUkttdk,
            mosKihonInfoDBDrctservicemoskbn,
            mosKihonInfoDBYnkhrkmgkannituutikbn
        };

        String[] kzkDrDsHtInfoKeys = new String[]{
            KZKTOUROKUSERVICETOUROKUKBN,
            TRKKZKNMKN1,
            TRKKZKNMKJ1,
            TRKKZKNMKJKHUKAKBN1,
            TRKKZKSEIYMD1,
            TRKKZKSEI1,
            TRKKZKTDK1,
            TRKKZKTSINDOUSITEIKBN1,
            TRKKZKYNO1,
            TRKKZKADR1KJ1,
            TRKKZKADR2KJ1,
            TRKKZKADR3KJ1,
            TRKKZKTELNO1,
            STDRSKTKYHKKBN,
            STDRUKTKBN,
            SITEIDRUKTNMKN,
            SITEIDRUKTNMKJ,
            STDRSKNMKJHUKAKBN,
            STDRSKSEIYMD,
            SITEIUKTTDK,
            DRCTSERVICEMOSKBN,
            YNKHRKMGKANNITUUTIKBN
        };

        for (int index = 0; index < kzkDrDsHtInfoCount; index++) {

            if (!kzkDrDsHtInfoDbs[index].equals(kzkDrDsHtInfoGms[index])) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    kzkDrDsHtInfoDisps[index],
                    convertWarekiseireki(kzkDrDsHtInfoKeys[index],kzkDrDsHtInfoDbs[index]),
                    convertWarekiseireki(kzkDrDsHtInfoKeys[index],kzkDrDsHtInfoGms[index]),
                    pSousasyaCd,
                    pSysDate);
            }
        }

        C_KouzaInfoInputHoryuuKbn kouzaInfoInputHoryuuKbn = C_KouzaInfoInputHoryuuKbn.BLNK;
        String koufurikouzainfobankcd = "";
        String koufurikouzainfositencd = "";
        C_YokinKbn koufurikouzainfoyokinkbn = C_YokinKbn.BLNK;
        String koufurikouzainfokouzano = "";
        C_KzkykdouKbn koufurikouzainfokzkykdoukbn = C_KzkykdouKbn.BLNK;
        String koufurikouzainfokzmeiginmkn = "";
        C_YouhiblnkKbn kouzakakuniniraikbn = C_YouhiblnkKbn.BLNK;
        String koufurikouzainfokzmeiginmknPlant = pUiBean.getKouhurikouzainfokzmeiginmkn();

        mosNo = pUiBean.getMosno();

        HT_KouzaJyouhouVrf kouzaJyouhouVrf = syoriCTL.getKouzaJyouhouVrf();

        if (kouzaJyouhouVrf != null) {

            koufurikouzainfobankcd = kouzaJyouhouVrf.getBankcd();
            koufurikouzainfositencd = kouzaJyouhouVrf.getSitencd();
            koufurikouzainfoyokinkbn = kouzaJyouhouVrf.getYokinkbn();
            koufurikouzainfokouzano = kouzaJyouhouVrf.getKouzano();
            koufurikouzainfokzkykdoukbn = kouzaJyouhouVrf.getKzkykdoukbn();
            koufurikouzainfokzmeiginmkn = kouzaJyouhouVrf.getKzmeiginmkn();
            kouzakakuniniraikbn = kouzaJyouhouVrf.getKouzakakuniniraikbn();
        }

        if (C_UmuKbn.ARI.eq(syoriCTL.getKznrkhbumu())) {

            kouzaInfoInputHoryuuKbn = C_KouzaInfoInputHoryuuKbn.HORYUU;
        }

        if (C_KzkykdouKbn.DOUITU.eq(pUiBean.getKouhurikouzainfokzdoukbn())) {

            koufurikouzainfokzmeiginmknPlant = "";
        }

        String[]  kzinfoGms = new String[]{
            pUiBean.getKouzainfoinputhoryuukbn().getContent(),
            pUiBean.getKouhurikouzainfobankcd(),
            pUiBean.getKouhurikouzainfositencd(),
            pUiBean.getKouhurikouzainfoyokinkbn().getContent(),
            pUiBean.getKouhurikouzainfokouzano(),
            pUiBean.getKouhurikouzainfokzdoukbn().getContent(),
            koufurikouzainfokzmeiginmknPlant,
            pUiBean.getKouzakakuniniraikbn().getContent()
        };

        String[]  kzinfoDbs = new String[]{
            kouzaInfoInputHoryuuKbn.getContent(),
            koufurikouzainfobankcd,
            koufurikouzainfositencd,
            koufurikouzainfoyokinkbn.getContent(),
            koufurikouzainfokouzano,
            koufurikouzainfokzkykdoukbn.getContent(),
            koufurikouzainfokzmeiginmkn,
            kouzakakuniniraikbn.getContent()
        };

        String[]  kzinfoDisps = new String[]{
            DISP_KOUZAINFOINPUTHORYUU,
            DISP_KOUHURIKOUZAINFOBANKCD,
            DISP_KOUHURIKOUZAINFOSITENCD,
            DISP_KOUHURIKOUZAINFOYOKIN,
            DISP_KOUHURIKOUZAINFOKOUZANO,
            DISP_KOUHURIKOUZAINFOKZDOUKBN,
            DISP_KOUHURIKOUZAINFOKZMEIGINMKN,
            DISP_KOUZAKAKUNINIRAIKBN,
        };

        for (int index = 0; index < kzinfoGms.length; index++ ) {

            if (!(kzinfoDbs[index].equals(kzinfoGms[index]))) {

                saiUmu = NRKSAIARI;

                hyoujiJyunRen = hyoujiJyunRen + 1;

                insertNrkDif(syoriCTL, ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO, hyoujiJyunRen, kzinfoDisps[index],
                    kzinfoDbs[index], kzinfoGms[index], pSousasyaCd, pSysDate);
            }
        }

        String kykhonninKakninsyoruiKbnPtn;
        String skskknhonninKakninsyoruiKbnPtn;

        if (C_SkeijimuKbn.SMBC.eq(syoriCTL.getSkeijimukbn())) {
            kykhonninKakninsyoruiKbnPtn = C_HonninkakuninSyoruiKbn.PATTERN_SMBCMOS;
            skskknhonninKakninsyoruiKbnPtn = C_HonninkakuninSyoruiKbn.PATTERN_SMBCMOS;
        }
        else {
            kykhonninKakninsyoruiKbnPtn = C_HonninkakuninSyoruiKbn.PATTERN_MOS;
            skskknhonninKakninsyoruiKbnPtn = C_HonninkakuninSyoruiKbn.PATTERN_MOS;
        }

        String[] mosKihon6Gms = new String[]{
            pUiBean.getKykhonninkakninsyoruikbn().getContent(kykhonninKakninsyoruiKbnPtn),
            pUiBean.getSkskknhonninkakninsyoruikbn().getContent(skskknhonninKakninsyoruiKbnPtn),
            pUiBean.getKoureikzksetumeihoukbn().getContent(),
            pUiBean.getKoureimndnhukusuukaikbn().getContent(),
            pUiBean.getKoureitratkisyaigidskkbn().getContent()
        };

        String[] mosKihon6Dbs = new String[]{
            mosKihonVrf.getKykhonninkakninsyoruikbn().getContent(kykhonninKakninsyoruiKbnPtn),
            mosKihonVrf.getSkskknhonninkakninsyoruikbn().getContent(skskknhonninKakninsyoruiKbnPtn),
            mosKihonVrf.getKoureikzksetumeihoukbn().getContent(),
            mosKihonVrf.getKoureimndnhukusuukaikbn().getContent(),
            mosKihonVrf.getKoureitratkisyaigidskkbn().getContent()
        };

        String[] mosKihon6Disps = new String[]{
            DISP_KYKHONNINKAKNINSYORUIKBN,
            DISP_SKSKKNHONNINKAKNINSYORUIKBN,
            DISP_KOUREIKZKSETUMEIHOUKBN,
            DISP_KOUREIMNDNHUKUSUUKAIKBN,
            DISP_KOUREITRATKISYAIGIDSKKBN
        };

        for (int index = 0; index < mosKihon6Gms.length; index++) {
            if (!(mosKihon6Gms[index].equals(mosKihon6Dbs[index]))) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    mosKihon6Disps[index],
                    mosKihon6Dbs[index],
                    mosKihon6Gms[index],
                    pSousasyaCd,
                    pSysDate);
            }
        }

        String[] dairitenInfo1Gms = new String[]{
            pUiBean.getDrtenjimcd1(),
            pUiBean.getDairitenkinyuukikancd1(),
            pUiBean.getDairitenkinyuukikansitencd1(),
            pUiBean.getDairitentoriatukaikouincd1(),
            pUiBean.getInputbosyuucd1(),
            pUiBean.getBosyuunintourokuno1(),
            pUiBean.getGyousekikeijyousakisosikicd1(),
            zero2Blank(pUiBean.getDairitenbuntanwariai1()),
            pUiBean.getCifcd()
        };

        String[] dairitenInfo1Dbs = null;

        String[] dairitenInfo1Disps = new String[]{
            DISP_DISPDRTENJIMCD,
            DISP_DISPDAIRITENKINYUUKIKANCD,
            DISP_DISPDAIRITENKINYUUKIKANSITENCD,
            DISP_DISPDAIRITENTORIATUKAIKOUINCD,
            DISP_DISPINPUTBOSYUUCD,
            DISP_DISPBOSYUUTRKNO,
            DISP_DISPGYSKKJSAKISOSIKICD,
            DISP_DISPDAIRITENBUNTANWARIAI,
            DISP_CIFCD
        };

        dairitenRenno++;

        if (mosDairitenVrf1 != null) {
            dairitenInfo1Dbs = new String[]{
                mosDairitenVrf1.getJimusyocd(),
                mosDairitenVrf1.getKinyuucd(),
                mosDairitenVrf1.getKinyuusitencd(),
                mosDairitenVrf1.getTratkikouinncd(),
                mosDairitenVrf1.getInputbosyuucd(),
                mosDairitenVrf1.getBosyuutrkno(),
                mosDairitenVrf1.getGyousekikeijyousakisosikicd(),
                zero2Blank(mosDairitenVrf1.getBunwari()),
                mosDairitenVrf1.getCifcd()
            };

            for (int loopCount = 0; loopCount < dairitenInfo1Gms.length; loopCount++) {
                if (!(dairitenInfo1Dbs[loopCount].equals(dairitenInfo1Gms[loopCount]))) {
                    saiUmu = NRKSAIARI;
                    hyoujiJyunRen++;

                    insertNrkDif(syoriCTL,
                        ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                        hyoujiJyunRen,
                        dairitenInfo1Disps[loopCount].concat(String.valueOf(dairitenRenno)),
                        dairitenInfo1Dbs[loopCount],
                        dairitenInfo1Gms[loopCount],
                        pSousasyaCd,
                        pSysDate);
                }
            }
        }
        else {
            for (int loopCount = 0; loopCount < dairitenInfo1Gms.length; loopCount++) {
                if (BizUtil.isBlank(dairitenInfo1Gms[loopCount])) {
                    continue;
                }

                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    dairitenInfo1Disps[loopCount].concat(String.valueOf(dairitenRenno)),
                    "",
                    dairitenInfo1Gms[loopCount],
                    pSousasyaCd,
                    pSysDate);
            }
        }

        String uktkIdDb = mosKihonVrf.getUktkid();
        String uktkIdGm = pUiBean.getUktkid();

        if (!uktkIdGm.equals(uktkIdDb)) {
            saiUmu = NRKSAIARI;
            hyoujiJyunRen++;

            insertNrkDif(syoriCTL,
                ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                hyoujiJyunRen,
                DISP_UKTKID,
                uktkIdDb,
                uktkIdGm,
                pSousasyaCd,
                pSysDate);
        }

        String[] dairitenInfo2Gms = new String[]{
            pUiBean.getDrtenjimcd2(),
            pUiBean.getDairitenkinyuukikancd2(),
            pUiBean.getDairitenkinyuukikansitencd2(),
            pUiBean.getDairitentoriatukaikouincd2(),
            pUiBean.getInputbosyuucd2(),
            pUiBean.getBosyuunintourokuno2(),
            pUiBean.getGyousekikeijyousakisosikicd2()
        };

        String[] dairitenInfo2Dbs = null;

        String[] dairitenInfo2Disps = new String[]{
            DISP_DISPDRTENJIMCD,
            DISP_DISPDAIRITENKINYUUKIKANCD,
            DISP_DISPDAIRITENKINYUUKIKANSITENCD,
            DISP_DISPDAIRITENTORIATUKAIKOUINCD,
            DISP_DISPINPUTBOSYUUCD,
            DISP_DISPBOSYUUTRKNO,
            DISP_DISPGYSKKJSAKISOSIKICD
        };

        dairitenRenno++;

        if (mosDairitenVrf2 != null) {
            dairitenInfo2Dbs = new String[]{
                mosDairitenVrf2.getJimusyocd(),
                mosDairitenVrf2.getKinyuucd(),
                mosDairitenVrf2.getKinyuusitencd(),
                mosDairitenVrf2.getTratkikouinncd(),
                mosDairitenVrf2.getInputbosyuucd(),
                mosDairitenVrf2.getBosyuutrkno(),
                mosDairitenVrf2.getGyousekikeijyousakisosikicd()
            };

            for (int loopCount = 0; loopCount < dairitenInfo2Gms.length; loopCount++) {
                if (!(dairitenInfo2Dbs[loopCount].equals(dairitenInfo2Gms[loopCount]))) {
                    saiUmu = NRKSAIARI;
                    hyoujiJyunRen++;

                    insertNrkDif(syoriCTL,
                        ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                        hyoujiJyunRen,
                        dairitenInfo2Disps[loopCount].concat(String.valueOf(dairitenRenno)),
                        dairitenInfo2Dbs[loopCount],
                        dairitenInfo2Gms[loopCount],
                        pSousasyaCd,
                        pSysDate);
                }
            }
        }
        else {
            for (int loopCount = 0; loopCount < dairitenInfo2Gms.length; loopCount++) {
                if (BizUtil.isBlank(dairitenInfo2Gms[loopCount])) {
                    continue;
                }

                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    dairitenInfo2Disps[loopCount].concat(String.valueOf(dairitenRenno)),
                    "",
                    dairitenInfo2Gms[loopCount],
                    pSousasyaCd,
                    pSysDate);
            }
        }

        String[] mosKihon8Gms = new String[]{
            pUiBean.getTsryhshrkykumukbn().getContent(),
            pUiBean.getSyosisyatodokeumukbn().getContent(),
            pUiBean.getKakukisyouryakukbumukbn().getContent(),
            pUiBean.getSeiymdmosseitouumukbn().getContent()
        };

        String[] mosKihon8Dbs = new String[]{
            mosKihonVrf.getTsryhshrkykumukbn().getContent(),
            mosKihonVrf.getSyosisyatodokeumukbn().getContent(),
            mosKihonVrf.getKakukisyouryakukbumukbn().getContent(),
            mosKihonVrf.getSeiymdmosseitouumukbn().getContent()
        };

        String[] mosKihon8Disps = new String[]{
            DISP_TSRYHSHRKYKUMUKBN,
            DISP_SYOSISYATODOKEUMUKBN,
            DISP_KAKUKISYOURYAKUKBUMUKBN,
            DISP_SEIYMDMOSSEITOUUMUKBN
        };

        for (int index = 0; index < mosKihon8Gms.length; index++) {

            if (!(mosKihon8Gms[index].equals(mosKihon8Dbs[index]))) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                    hyoujiJyunRen,
                    mosKihon8Disps[index],
                    mosKihon8Dbs[index],
                    mosKihon8Gms[index],
                    pSousasyaCd,
                    pSysDate);
            }
        }

        String tkhSyouryakuUmuKbnDb = syoriCTL.getTkhsyouryakuumukbn().getContent();
        String tkhSyouryakuUmuKbnGm = pUiBean.getTkhsyouryakuumukbn().getContent();

        if (!tkhSyouryakuUmuKbnGm.equals(tkhSyouryakuUmuKbnDb)) {
            saiUmu = NRKSAIARI;
            hyoujiJyunRen++;

            insertNrkDif(syoriCTL,
                ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO,
                hyoujiJyunRen,
                DISP_TKHSYOURYAKUUMUKBN,
                tkhSyouryakuUmuKbnDb,
                tkhSyouryakuUmuKbnGm,
                pSousasyaCd,
                pSysDate);
        }

        return saiUmu;
    }

    public int registerSaiDataKokutisyo(SaiDataTourokuRegisterSaiDataKokutisyoUiBeanParam pUiBean,
        String pSousasyaCd,
        String pSysDate) {

        int hyoujiJyunRen = 0;
        int saiUmu = NRKSAINASI;

        String mosNo = pUiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        HT_KokutisyoVrf kokutisyoVrf = syoriCTL.getKokutisyoVrf();
        if (kokutisyoVrf == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        String[] kokutisyoGms = new String[]{
            editYmd(pUiBean.getKktymd()),
            zero2Blank(pUiBean.getSintyou()),
            zero2Blank(pUiBean.getTaijyuu()),
            pUiBean.getKijikbn().getContent(C_KijiKbn.PATTERN_RADIO)
        };

        String[] kokutisyoDbs = new String[]{
            editYmd(kokutisyoVrf.getKktymd()),
            zero2Blank(kokutisyoVrf.getSintyou()),
            zero2Blank(kokutisyoVrf.getTaijyuu()),
            kokutisyoVrf.getKijikbn().getContent(C_KijiKbn.PATTERN_RADIO)
        };

        String[] kokutisyoDisps = new String[]{
            DISP_KKTYMD,
            DISP_SINTYOU,
            DISP_TAIJYUU,
            DISP_KIJIKBN
        };

        String[] kokutisyoKeys = new String[] {
            KKTYMD,
            SINTYOU,
            TAIJYUU,
            KIJIKBN
        };

        for (int index = 0; index < kokutisyoGms.length; index++) {

            if (!(kokutisyoDbs[index].equals(kokutisyoGms[index]))) {
                saiUmu = NRKSAIARI;
                hyoujiJyunRen++;

                insertNrkDif(syoriCTL,
                    ISkCommonKoumoku.VRFKINOUKBN_KOKUTISYO,
                    hyoujiJyunRen,
                    kokutisyoDisps[index],
                    convertWarekiseireki(kokutisyoKeys[index], kokutisyoDbs[index]),
                    convertWarekiseireki(kokutisyoKeys[index], kokutisyoGms[index]),
                    pSousasyaCd,
                    pSysDate);
            }
        }

        return saiUmu;
    }

    // 2016/03/03 S社導入：コメントアウト
    //    private Map<String, String[]> sortMousikomisyo(
    //            SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam pUiBean, String pSyoNo) {
    //
    //        SortedMap<Integer, Map<String, String>> sortedMap = new TreeMap<>();
    //
    //        String[] tkSyouhnCds = new String[] {
    //                pUiBean.getTokuyakusyouhincd1(),
    //                pUiBean.getTokuyakusyouhincd2(),
    //                pUiBean.getTokuyakusyouhincd3(),
    //                pUiBean.getTokuyakusyouhincd4(),
    //                pUiBean.getTokuyakusyouhincd5(),
    //                pUiBean.getTokuyakusyouhincd6(),
    //                pUiBean.getTokuyakusyouhincd7(),
    //                pUiBean.getTokuyakusyouhincd8(),
    //                pUiBean.getTokuyakusyouhincd9(),
    //                pUiBean.getTokuyakusyouhincd10()
    //        };
    //
    //        String[] tkKataKbns = new String[] {
    //                pUiBean.getTokuyakukatakbn1().getContent(),
    //                pUiBean.getTokuyakukatakbn2().getContent(),
    //                pUiBean.getTokuyakukatakbn3().getContent(),
    //                pUiBean.getTokuyakukatakbn4().getContent(),
    //                pUiBean.getTokuyakukatakbn5().getContent(),
    //                pUiBean.getTokuyakukatakbn6().getContent(),
    //                pUiBean.getTokuyakukatakbn7().getContent(),
    //                pUiBean.getTokuyakukatakbn8().getContent(),
    //                pUiBean.getTokuyakukatakbn9().getContent(),
    //                pUiBean.getTokuyakukatakbn10().getContent()
    //        };
    //
    //        String[] tkKyhkataKbns = new String[] {
    //                pUiBean.getTokuyakukyuhutukikatakbn1().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn2().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn3().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn4().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn5().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn6().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn7().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn8().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn9().getContent(),
    //                pUiBean.getTokuyakukyuhutukikatakbn10().getContent()
    //        };
    //
    //        String[] tkHknkknSmnKbns = new String[] {
    //                pUiBean.getTokuyakuhknkknsmnkbn1().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn2().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn3().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn4().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn5().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn6().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn7().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn8().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn9().getContent(C_HknkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhknkknsmnkbn10().getContent(C_HknkknsmnKbn.PATTERN_MOS)
    //        };
    //
    //        String[] tKHrkkknSmnKbns = new String[] {
    //                pUiBean.getTokuyakuhrkkknsmnkbn1().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn2().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn3().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn4().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn5().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn6().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn7().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn8().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn9().getContent(C_HrkkknsmnKbn.PATTERN_MOS),
    //                pUiBean.getTokuyakuhrkkknsmnkbn10().getContent(C_HrkkknsmnKbn.PATTERN_MOS)
    //        };
    //
    //        String[] tkKihonSs = new String[] {
    //                zero2Blank(pUiBean.getTokuyakukihons1()),
    //                zero2Blank(pUiBean.getTokuyakukihons2()),
    //                zero2Blank(pUiBean.getTokuyakukihons3()),
    //                zero2Blank(pUiBean.getTokuyakukihons4()),
    //                zero2Blank(pUiBean.getTokuyakukihons5()),
    //                zero2Blank(pUiBean.getTokuyakukihons6()),
    //                zero2Blank(pUiBean.getTokuyakukihons7()),
    //                zero2Blank(pUiBean.getTokuyakukihons8()),
    //                zero2Blank(pUiBean.getTokuyakukihons9()),
    //                zero2Blank(pUiBean.getTokuyakukihons10())
    //        };
    //
    //        String[] tkHknkkns = new String[] {
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan1()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan2()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan3()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan4()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan5()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan6()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan7()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan8()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan9()),
    //                zero2Blank(pUiBean.getTokuyakuhokenkikan10())
    //        };
    //
    //        String[] tkHrkkkns = new String[] {
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan1()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan2()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan3()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan4()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan5()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan6()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan7()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan8()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan9()),
    //                zero2Blank(pUiBean.getTokuyakuharaikomikikan10())
    //        };
    //
    //        BM_SyouhnZokusei syouhnZokusei = null;
    //        Map<String, String> tempSyouhnMp = null;
    //
    //        for (int index = 0; index < tkSyouhnCds.length; index++) {
    //
    //            if (!BizUtil.isBlank(tkSyouhnCds[index])) {
    //
    //                syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(tkSyouhnCds[index]);
    //                if (syouhnZokusei == null) {
    //                    throw new CommonBizAppException("申込番号=" + pSyoNo);
    //                }
    //
    //                int syohnSortNo = syouhnZokusei.getSyohnsortno();
    //
    //                tempSyouhnMp = new HashMap<>();
    //
    //                tempSyouhnMp.put(DISPTKSYOUHNCD, tkSyouhnCds[index]);
    //                tempSyouhnMp.put(DISPTKKATAKBNKAHI, tkKataKbns[index]);
    //                tempSyouhnMp.put(DISPTKKYHKATAKBN, tkKyhkataKbns[index]);
    //                tempSyouhnMp.put(DISPTKHKNKKNSMNKBN, tkHknkknSmnKbns[index]);
    //                tempSyouhnMp.put(DISPTKHRKKKNSMNKBN, tKHrkkknSmnKbns[index]);
    //                tempSyouhnMp.put(DISPTKKIHONS, tkKihonSs[index]);
    //                tempSyouhnMp.put(DISPTKHKNKKN, tkHknkkns[index]);
    //                tempSyouhnMp.put(DISPTKHRKKKN, tkHrkkkns[index]);
    //
    //                sortedMap.put(syohnSortNo, tempSyouhnMp);
    //            }
    //        }
    //
    //        List<String> tkSyouhnCdLst = new ArrayList<>();
    //        List<String> tkKataKbnLst = new ArrayList<>();
    //        List<String> tkKyhkataKbnLst = new ArrayList<>();
    //        List<String> tkHknkknSmnkbnLst = new ArrayList<>();
    //        List<String> tKHrkkknSmnKbnLst = new ArrayList<>();
    //        List<String> tkKihonSLst = new ArrayList<>();
    //        List<String> tkHknkknLst = new ArrayList<>();
    //        List<String> tkHrkkknLst = new ArrayList<>();
    //
    //        Iterator<Integer> ite = sortedMap.keySet().iterator();
    //
    //        while (ite.hasNext()) {
    //            Integer key = ite.next();
    //            tkSyouhnCdLst.add(sortedMap.get(key).get(DISPTKSYOUHNCD));
    //            tkKataKbnLst.add(sortedMap.get(key).get(DISPTKKATAKBNKAHI));
    //            tkKyhkataKbnLst.add(sortedMap.get(key).get(DISPTKKYHKATAKBN));
    //            tkHknkknSmnkbnLst.add(sortedMap.get(key).get(DISPTKHKNKKNSMNKBN));
    //            tKHrkkknSmnKbnLst.add(sortedMap.get(key).get(DISPTKHRKKKNSMNKBN));
    //            tkKihonSLst.add(sortedMap.get(key).get(DISPTKKIHONS));
    //            tkHknkknLst.add(sortedMap.get(key).get(DISPTKHKNKKN));
    //            tkHrkkknLst.add(sortedMap.get(key).get(DISPTKHRKKKN));
    //        }
    //
    //        int tkSize = tkSyouhnCdLst.size();
    //
    //        Map<String, String[]> resultMap = new HashMap<>();
    //
    //        resultMap.put(DISPTKSYOUHNCD, addBlank(tkSyouhnCdLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKKATAKBNKAHI, addBlank(tkKataKbnLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKKYHKATAKBN, addBlank(tkKyhkataKbnLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKHKNKKNSMNKBN, addBlank(tkHknkknSmnkbnLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKHRKKKNSMNKBN, addBlank(tKHrkkknSmnKbnLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKKIHONS, addBlank(tkKihonSLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKHKNKKN, addBlank(tkHknkknLst).toArray(new String[tkSize]));
    //        resultMap.put(DISPTKHRKKKN, addBlank(tkHrkkknLst).toArray(new String[tkSize]));
    //
    //        return resultMap;
    //    }

    private Map<String, String[]> getMousikomisyoSbUkt(SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam pUiBean) {
        String[] sbUktKbns = new String[] {
            pUiBean.getSibouuktkbn1().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
            pUiBean.getSibouuktkbn2().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
            pUiBean.getSibouuktkbn3().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
            pUiBean.getSibouuktkbn4().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
        };

        String[] sbUktNmKns = new String[] {
            pUiBean.getSibouuktnmkana1(),
            pUiBean.getSibouuktnmkana2(),
            pUiBean.getSibouuktnmkana3(),
            pUiBean.getSibouuktnmkana4(),
        };

        String[] sbUktNmKjs = new String[] {
            pUiBean.getSibouuktnmkanji1(),
            pUiBean.getSibouuktnmkanji2(),
            pUiBean.getSibouuktnmkanji3(),
            pUiBean.getSibouuktnmkanji4(),
        };

        String[] sbUktNmKjhukaKbns = new String[] {
            pUiBean.getSibouuktnmkanjikahukakbn1().getContent(),
            pUiBean.getSibouuktnmkanjikahukakbn2().getContent(),
            pUiBean.getSibouuktnmkanjikahukakbn3().getContent(),
            pUiBean.getSibouuktnmkanjikahukakbn4().getContent(),
        };

        String[] sbUktSeiYmds = new String[] {
            editYmd(pUiBean.getSibouuktseiymd1()),
            editYmd(pUiBean.getSibouuktseiymd2()),
            editYmd(pUiBean.getSibouuktseiymd3()),
            editYmd(pUiBean.getSibouuktseiymd4()),
        };

        String[] sbUktTdks = new String[] {
            pUiBean.getSibouukttdk1().getContent(C_Tdk.PATTERN_SBUKT),
            pUiBean.getSibouukttdk2().getContent(C_Tdk.PATTERN_SBUKT),
            pUiBean.getSibouukttdk3().getContent(C_Tdk.PATTERN_SBUKT),
            pUiBean.getSibouukttdk4().getContent(C_Tdk.PATTERN_SBUKT),
        };

        String[] sbUktBnwaris = new String[] {
            zero2Blank(pUiBean.getSibouuktbnwari1()),
            zero2Blank(pUiBean.getSibouuktbnwari2()),
            zero2Blank(pUiBean.getSibouuktbnwari3()),
            zero2Blank(pUiBean.getSibouuktbnwari4()),
        };

        Map<String, String[]> resultMp = new HashMap<>();
        resultMp.put(DISPSBUKTKBN, sbUktKbns);
        resultMp.put(DISPSBUKTNMKN, sbUktNmKns);
        resultMp.put(DISPSBUKTNMKJ, sbUktNmKjs);
        resultMp.put(DISPSBUKTNMKJHUKAKBN, sbUktNmKjhukaKbns);
        resultMp.put(DISPSBUKTSEIYMD, sbUktSeiYmds);
        resultMp.put(DISPSBUKTTDK, sbUktTdks);
        resultMp.put(DISPSBUKTBNWARI, sbUktBnwaris);

        return resultMp;
    }

    private String convertWarekiseireki(String pKey, String pValue) {

        if (BizUtil.isBlank(pValue)) {
            return pValue;
        }

        if (ymdLst.contains(pKey)) {
            return DateFormatUtil.dateDOT(pValue);
        }
        else if (ymdLst2.contains(pKey)) {
            return DateFormatUtil.dateDOTWareki(pValue);
        }

        return pValue;
    }

    // 2016/03/03 S社導入：コメントアウト
    //    private boolean isBlankTokuyakuJohou(String pValue, String pName) {
    //
    //        if (DISPTKKYHKATAKBN.equals(pName)) {
    //
    //            boolean flag = C_KyhgndkataKbn.BLNK.getContent().equals(pValue);
    //            if (flag) {
    //                return true;
    //            }
    //
    //            return false;
    //        }
    //
    //        if (DISPTKKIHONS.equals(pName)) {
    //
    //            boolean flag = BizUtil.isBlank(BizUtil.zero2blank(pValue));
    //            if (flag) {
    //                return true;
    //            }
    //
    //            return false;
    //        }
    //
    //        return false;
    //    }

    private String editYmd(BizDate pDate) {

        if (pDate == null) {
            return "";
        }
        return pDate.toString();
    }

    private String zero2Blank(Object pObject) {

        if (pObject == null) {
            return "";
        }

        if (pObject instanceof BizCurrency && ((BizCurrency)pObject).isZeroOrOptional()) {
            return "";
        }

        if (pObject instanceof BizNumber && ((BizNumber)pObject).isZeroOrOptional()) {
            return "";
        }

        if (pObject instanceof Integer && (Integer)pObject == 0) {
            return "";
        }

        return pObject.toString();
    }

    private String editTuuka(BizCurrency pHenkanTaishou) {

        String henkangoMojiretu = zero2Blank(pHenkanTaishou);

        if (!BizUtil.isBlank(henkangoMojiretu)) {

            return ViewReport.editCommaTuuka(pHenkanTaishou, BizUtil.ZERO_FILL);
        }
        return henkangoMojiretu;
    }
    private void insertNrkDif(HT_SyoriCTL pSyoriCtl, String pVrfkinouid,
        int pRenno, String pNrksouikm, String pItijinyuuroku,
        String pNijinyuuroku, String pSousasyaCd, String pSysDate) {

        HT_NrkDif nrkDif = pSyoriCtl.createNrkDif();

        nrkDif.setVrfkinouid(pVrfkinouid);
        nrkDif.setRenno3keta(pRenno);
        nrkDif.setNrksouikm(pNrksouikm);
        nrkDif.setItijinyuuroku(pItijinyuuroku);
        nrkDif.setNijinyrk(pNijinyuuroku);
        nrkDif.setGyoumuKousinsyaId(pSousasyaCd);
        nrkDif.setGyoumuKousinTime(pSysDate);

        BizPropertyInitializer.initialize(nrkDif);
    }

    // 2016/03/03 S社導入：コメントアウト
    //    private List<String> addBlank(List<String> pTargetList){
    //
    //        int size = 10 - pTargetList.size();
    //
    //        for (int i = 0 ; i < size; i++) {
    //            pTargetList.add("");
    //        }
    //
    //        return pTargetList;
    //    }

}