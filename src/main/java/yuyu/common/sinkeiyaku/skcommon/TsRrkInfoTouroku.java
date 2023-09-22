package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyosaiKbn;
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
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 訂正履歴情報登録
 */
public class TsRrkInfoTouroku {

    private static final String AITEMOSNO = "aitemosno";

    private static final String DOUJIKAIYAKUSYONO = "doujikaiyakusyono";

    private static final String MOSYMD = "mosymd";

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

    private static final String TSINADR1KJ = "tsinadr1kj";

    private static final String TSINADR2KJ = "tsinadr2kj";

    private static final String TSINADR3KJ = "tsinadr3kj";

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

    private static final String NENKINUKTKBN = "nenkinuktkbn";

    private static final String SBUKTNIN = "sbuktnin";

    private static final String DISPSBUKTKBN = "dispsbuktkbn";

    private static final String DISPSBUKTNMKN = "dispsbuktnmkn";

    private static final String DISPSBUKTNMKJ = "dispsbuktnmkj";

    private static final String DISPSBUKTNMKJHUKAKBN = "dispsbuktnmkjhukakbn";

    private static final String DISPSBUKTSEIYMD = "dispsbuktseiymd";

    private static final String DISPSBUKTTDK = "dispsbukttdk";

    private static final String DISPSBUKTBNWARI = "dispsbuktbnwari";

    private static final String SYUDAI1HKNKKNMOSINPUT = "syudai1hknkknmosinput";

    private static final String SDPDKBN = "sdpdkbn";

    private static final String KYKTUUKASYU = "kyktuukasyu";

    private static final String HRKTUUKASYU = "hrktuukasyu";

    private static final String SYUKIHONS = "syukihons";

    private static final String SYUHKNKKN = "syuhknkkn";

    private static final String SYUHKNKKNSMNKBN = "syuhknkknsmnkbn";

    private static final String SYUHRKKKN = "syuhrkkkn";

    private static final String SYUHRKKKNSMNKBN = "syuhrkkknsmnkbn";

    private static final String HRKTUUKASYUKYKP = "hrktuukasyukykp";

    private static final String MOSIKKATUP = "mosikkatup";

    private static final String MOSSYUKYKP = "mossyukykp";

    private static final String MOSZENNOUPSYOKAIARI = "moszennoupsyokaiari";

    private static final String TEIRITUHAIBUNWARIKBN = "teirituhaibunwarikbn";

    private static final String SISUUHAIBUNWARIKBN = "sisuuhaibunwarikbn";

    private static final String SUEOKIKKNMOSINPUT = "sueokikknmosinput";

    private static final String SKNENKINSYU = "sknenkinsyu";

    private static final String HRKKAISUU = "hrkkaisuu";

    private static final String HRKKEIRO = "hrkkeiro";

    private static final String FSTPHRKKEIROKBN = "fstphrkkeirokbn";

    private static final String ZENKIZENNOU = "zenkizennou";

    private static final String ZENNOUKKN = "zennoukkn";

    private static final String IKKATUBARAIKAISUU = "ikkatubaraikaisuu";

    private static final String NKGNSHOSYOURITUKBN = "nkgnshosyouritukbn";

    private static final String KJNNKPZEITEKITKHUKAKBN = "kjnnkpzeitekitkhukakbn";

    //  2016/03/08 S社導入：コメントアウト
    //    private static final String DISPTKSYOUHNCD = "disptksyouhncd";
    //
    //    private static final String DISPTKKATAKBN = "disptkkatakbn";
    //
    //    private static final String DISPTKKYHKATAKBN = "disptkkyhkatakbn";
    //
    //    private static final String DISPTKKIHONS = "disptkkihons";
    //
    //    private static final String DISPTKHKNKKN = "disptkhknkkn";
    //
    //    private static final String DISPTKHKNKKNSMNKBN = "disptkhknkknsmnkbn";
    //
    //    private static final String DISPTKHRKKKN = "disptkhrkkkn";
    //
    //    private static final String DISPTKHRKKKNSMNKBN = "disptkhrkkknsmnkbn";

    private static final String TEIKISIHARAITKYKHKKBN = "teikisiharaitkykhkkbn";

    private static final String KZSYURUIKBN = "kzsyuruikbn";

    private static final String BANKCD = "bankcd";

    private static final String SITENCD = "sitencd";

    private static final String YOKINKBN = "yokinkbn";

    private static final String KOUZANO = "kouzano";

    private static final String KZKYKDOUKBN = "kzkykdoukbn";

    private static final String KZMEIGINMKN = "kzmeiginmkn";

    private static final String TARGETTKMKHTKBN = "targettkmkhtkbn";

    private static final String SYKSBYENSITIHSYUTKHKKBN = "syksbyensitihsyutkhkkbn";

    private static final String JYUDKAIGOMEHRTKHKKBN = "jyudkaigomehrtkhkkbn";

    private static final String NSTKHKKBN = "nstkhkkbn";

    private static final String NSTKSBNKKN = "nstksbnkkn";

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

    private static final String TRKKZKNMKN2 = "trkkzknmkn2";

    private static final String TRKKZKNMKJ2 = "trkkzknmkj2";

    private static final String TRKKZKNMKJKHUKAKBN2 = "trkkzknmkjkhukakbn2";

    private static final String TRKKZKSEIYMD2 = "trkkzkseiymd2";

    private static final String TRKKZKSEI2 = "trkkzksei2";

    private static final String TRKKZKTDK2 = "trkkzktdk2";

    private static final String TRKKZKTSINDOUSITEIKBN2 = "trkkzktsindousiteikbn2";

    private static final String TRKKZKYNO2 = "trkkzkyno2";

    private static final String TRKKZKADR1KJ2 = "trkkzkadr1kj2";

    private static final String TRKKZKADR2KJ2 = "trkkzkadr2kj2";

    private static final String TRKKZKADR3KJ2 = "trkkzkadr3kj2";

    private static final String TRKKZKTELNO2 = "trkkzktelno2";

    private static final String KYKDRTKYKHUKAKBN = "kykdrtkykhukakbn";

    private static final String KYKDRKBN = "kykdrkbn";

    private static final String STDRSKTKYHKKBN = "stdrsktkyhkkbn";

    private static final String STDRUKTKBN = "stdruktkbn";

    private static final String SITEIDRUKTNMKN = "siteidruktnmkn";

    private static final String SITEIDRUKTNMKJ = "siteidruktnmkj";

    private static final String STDRSKNMKJHUKAKBN = "stdrsknmkjhukakbn";

    private static final String STDRSKSEIYMD = "stdrskseiymd";

    private static final String SITEIUKTTDK = "siteiukttdk";

    private static final String KZHURITOUROKUHOUKBN = "kzhuritourokuhoukbn";

    private static final String KOUHURIKZINFOBANKCD = "kouhurikzinfobankcd";

    private static final String KOUHURIKZINFOSITENCD = "kouhurikzinfositencd";

    private static final String KOUHURIKZINFOYOKINKBN = "kouhurikzinfoyokinkbn";

    private static final String KOUHURIKZINFOKOUZANO = "kouhurikzinfokouzano";

    private static final String KOUHURIKZINFOKZKYKDOUKBN = "kouhurikzinfokzkykdoukbn";

    private static final String KOUHURIKZINFOKZMEIGINM = "kouhurikzinfokzmeiginm";

    private static final String CSSKAKUNINIRAIKBN = "csskakuniniraikbn";

    private static final String KYKHONNINKAKNINSYORUIKBN = "kykhonninkakninsyoruikbn";

    private static final String SKSKKNHONNINKAKNINSYORUIKBN = "skskknhonninkakninsyoruikbn";

    private static final String KOUREIKZKSETUMEIHOUKBN = "koureikzksetumeihoukbn";

    private static final String KOUREIMNDNHUKUSUUKAIKBN = "koureimndnhukusuukaikbn";

    private static final String KOUREITRATKISYAIGIDSKKBN = "koureitratkisyaigidskkbn";

    private static final String DISPDRTENJIMCD = "dispdrtenjimcd";

    private static final String DISPDAIRITENKINYUUKIKANCD = "dispdairitenkinyuukikancd";

    private static final String DISPDAIRITENKINYUUKIKANSITENCD = "dispdairitenkinyuukikansitencd";

    private static final String DISPDAIRITENTORIATUKAIKOUINCD = "dispdairitentoriatukaikouincd";

    private static final String DISPINPUTBOSYUUCD = "dispinputbosyuucd";

    private static final String DISPBOSYUUTRKNO = "dispbosyuutrkno";

    private static final String DISPGYSKKJSAKISOSIKICD = "dispgyskkjsakisosikicd";

    private static final String DISPDAIRITENBUNTANWARIAI = "dispdairitenbuntanwariai";

    private static final String CIFCD = "cifcd";

    private static final String UKTKID = "uktkid";

    private static final String TSRYHSHRKYKUMUKBN = "tsryhshrkykumukbn";

    private static final String SYOSISYATODOKEUMUKBN = "syosisyatodokeumukbn";

    private static final String KAKUKISYOURYAKUKBUMUKBN = "kakukisyouryakukbumukbn";

    private static final String SEIYMDMOSSEITOUUMUKBN = "seiymdmosseitouumukbn";

    private static final String DRCTSERVICEMOSKBN = "drctservicemoskbn";

    private static final String YNKHRKMGKANNITUUTIKBN = "ynkhrkmgkannituutikbn";

    private static final String TKHSYOURYAKUUMUKBN = "tkhsyouryakuumukbn";

    private static final String KHNCHKCMNT = "khnchkcmnt";

    private static final String SINTYOU = "sintyou";

    private static final String TAIJYUU = "taijyuu";

    private static final String KIJIKBN = "kijikbn";

    private static final String HBCMNT = "hbcmnt";

    private static final String SINSAKBN = "sinsakbn";

    private static final String SINSAYMD = "sinsaymd";

    private static final String SYOMEIYMD = "syomeiymd";

    private static final String DISP_AITEMOSNO = "相手申込番号";

    private static final String DISP_DOUJIKAIYAKUSYONO = "同時解約証券番号";

    private static final String DISP_MOSYMD = "申込日";

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

    private static final String DISP_TSINDOUSITEIKBN = "通信先同一指定";

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

    private static final String DISP_PHRKMNRYNEN = "保険料払込満了年齢";

    private static final String DISP_NKSHRSTARTNEN = "年金支払開始年齢";

    private static final String DISP_SYUDAI1HKNKKNMOSINPUT = "第１保険期間";

    private static final String DISP_SDPDKBN = "Ｓ建Ｐ建";

    private static final String DISP_KYKTUUKASYU = "指定通貨／選択通貨";

    private static final String DISP_HRKTUUKASYU = "払込通貨";

    private static final String DISP_SYUKIHONS = "保険金額／給付金額";

    private static final String DISP_SYUHKNKKN = "保険期間";

    private static final String DISP_SYUHKNKKNSMNKBN = "保険期間歳満期区分";

    private static final String DISP_SYUHRKKKN = "払込期間";

    private static final String DISP_SYUHRKKKNSMNKBN = "払込期間歳満期区分";

    private static final String DISP_HRKTUUKASYUKYKP = "払込金額";

    private static final String DISP_MOSIKKATUP = "定期一括払保険料";

    private static final String DISP_MOSSYUKYKP = "保険料";

    private static final String DISP_MOSZENNOUPSYOKAIARI = "前納保険料";

    private static final String DISP_SISUUHAIBUNWARIKBN = "指数連動";

    private static final String DISP_TEIRITUHAIBUNWARIKBN = "定率積立";

    private static final String DISP_SUEOKIKKNMOSINPUT = "据置期間";

    private static final String DISP_SKNENKINSYU = "年金種類";

    private static final String DISP_NKGNSHOSYOURITUKBN = "最低保証水準";

    private static final String DISP_HRKKAISUU = "払込回数";

    private static final String DISP_HRKKEIRO = "払込経路";

    private static final String DISP_FSTPHRKKEIROKBN = "初回保険料払込経路";

    private static final String DISP_ZENKIZENNOU = "全期前納";

    private static final String DISP_ZENNOUKKN = "前納期間";

    private static final String DISP_IKKATUBARAIKAISUU = "定期一括払回数";

    private static final String DISP_KJNNKPZEITEKITKHUKAKBN = "個人年金保険料税制適格特約";

    //  2016/03/08 S社導入：コメントアウト
    //    private static final String DISP_DISPTKSYOUHNCD = "特約商品名";
    //
    //    private static final String DISP_DISPTKKATAKBN = "特約型";
    //
    //    private static final String DISP_DISPTKKYHKATAKBN = "特約給付型";
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

    private static final String DISP_TRKKZKNMKN1 = "登録家族氏名（カナ）１";

    private static final String DISP_TRKKZKNMKJ1 = "登録家族氏名（漢字）１";

    private static final String DISP_TRKKZKNMKJKHUKAKBN1 = "登録家族名漢字化不可１";

    private static final String DISP_TRKKZKSEIYMD1 = "登録家族生年月日１";

    private static final String DISP_TRKKZKSEI1 = "登録家族性別１";

    private static final String DISP_TRKKZKTDK1 = "登録家族続柄１";

    private static final String DISP_TRKKZKTSINDOUSITEIKBN1 = "登録家族通信先同一指定１";

    private static final String DISP_TRKKZKYNO1 = "登録家族郵便番号１";

    private static final String DISP_TRKKZKADR1KJ1 = "登録家族住所１（漢字）１";

    private static final String DISP_TRKKZKADR2KJ1 = "登録家族住所２（漢字）１";

    private static final String DISP_TRKKZKADR3KJ1 = "登録家族住所３（漢字）１";

    private static final String DISP_TRKKZKTELNO1 = "登録家族通信先電話番号１";

    private static final String DISP_TRKKZKNMKN2 = "登録家族氏名（カナ）２";

    private static final String DISP_TRKKZKNMKJ2 = "登録家族氏名（漢字）２";

    private static final String DISP_TRKKZKNMKJKHUKAKBN2 = "登録家族名漢字化不可２";

    private static final String DISP_TRKKZKSEIYMD2 = "登録家族生年月日２";

    private static final String DISP_TRKKZKSEI2 = "登録家族性別２";

    private static final String DISP_TRKKZKTDK2 = "登録家族続柄２";

    private static final String DISP_TRKKZKTSINDOUSITEIKBN2 = "登録家族通信先同一指定２";

    private static final String DISP_TRKKZKYNO2 = "登録家族郵便番号２";

    private static final String DISP_TRKKZKADR1KJ2 = "登録家族住所１（漢字）２";

    private static final String DISP_TRKKZKADR2KJ2 = "登録家族住所２（漢字）２";

    private static final String DISP_TRKKZKADR3KJ2 = "登録家族住所３（漢字）２";

    private static final String DISP_TRKKZKTELNO2 = "登録家族通信先電話番号２";

    private static final String DISP_KYKDRTKYKHUKAKBN = "保険契約者代理特約";

    private static final String DISP_KYKDRKBN = "契約者代理人区分";

    private static final String DISP_STDRSKTKYHKKBN = "被保険者代理特約";

    private static final String DISP_STDRUKTKBN = "被保険者代理人区分";

    private static final String DISP_SITEIDRUKTNMKN = "被保険者代理人氏名（カナ）";

    private static final String DISP_SITEIDRUKTNMKJ = "被保険者代理人氏名（漢字）";

    private static final String DISP_STDRSKNMKJHUKAKBN = "被保険者代理人名漢字化不可区分";

    private static final String DISP_STDRSKSEIYMD = "被保険者代理人生年月日";

    private static final String DISP_SITEIUKTTDK = "被保険者代理人続柄";

    private static final String DISP_KZHURITOUROKUHOUKBN = "口振口座情報口座振替登録方法区分";

    private static final String DISP_KOUHURIKZINFOBANKCD = "口振口座情報銀行コード";

    private static final String DISP_KOUHURIKZINFOSITENCD = "口振口座情報支店コード";

    private static final String DISP_KOUHURIKZINFOYOKINKBN = "口振口座情報預金種目";

    private static final String DISP_KOUHURIKZINFOKOUZANO = "口振口座情報口座番号";

    private static final String DISP_KOUHURIKZINFOKZKYKDOUKBN = "口振口座情報口座名義人同一区分";

    private static final String DISP_KOUHURIKZINFOKZMEIGINM = "口振口座情報口座名義人";

    private static final String DISP_CSSKAKUNINIRAIKBN = "ＣＳＳ確認依頼区分";

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

    private static final String DISP_KHNCHKCMNT = "基本チェックコメント";

    private static final String DISP_SINTYOU = "身長";

    private static final String DISP_TAIJYUU = "体重";

    private static final String DISP_KIJIKBN = "詳細記事有無";

    private static final String DISP_HBCMNT = "不備コメント";

    private static final String DISP_SINSAKBN = "診査区分";

    private static final String DISP_SINSAYMD = "診査日";

    private static String[] dateItems;

    private static String[] warekiHenkanItems;

    //  2016/03/08 S社導入：コメントアウト
    //    @Inject
    //    private SyouhinUtil syouhinUtil;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public TsRrkInfoTouroku() {
        super();

        dateItems = new String[]{
            MOSYMD,
            SYOMEIYMD,
            KKTYMD,
            SINSAYMD,
        };
        warekiHenkanItems = new String[]{
            KYKSEIYMD,
            HHKNSEIYMD,
            DISPSBUKTSEIYMD,
            TRKKZKSEIYMD1,
            TRKKZKSEIYMD2,
            STDRSKSEIYMD
        };
    }

    public void rgstrMousikomisyo(TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam pUiBean,
        String pSysTime,
        String pKinouId,
        String pKinouModeId,
        String pUserId) {

        int dairitenRenNo = 0;
        int hyoujiJyunRenNo = 0;

        //  2016/03/08 S社導入：コメントアウト
        //        int tkRenNo = 0;

        int uketoriRenNo = 0;
        String teiseiMaeNaiyou = "";
        String teiseiGoNaiyou = "";

        //  2016/03/08 S社導入：コメントアウト
        //        TreeMap<Integer, HashMap<String, String>> sortedGmInfoMp = new TreeMap<>();

        String mosNo = pUiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        List<HT_MosSyouhn> mosSyouhnSyuLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnSyuLst.size() == 0) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        HT_MosSyouhn mosSyouhn = mosSyouhnSyuLst.get(0);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        if (syouhnZokusei == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        //  2016/03/08 S社導入：コメントアウト
        //        List<Object[]> mosSyouhnTkLst = sinkeiyakuDomManager
        //                .getMosSyouhnBySyonoSyutkkbnOrderBySyohnsortno(mosNo, C_SyutkKbn.TK);

        List<HT_Uketorinin> uketorininNenkinLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.NKUKT);
        List<HT_Uketorinin> uketorininSibouLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();
        HT_MosTrkKzk mosTrkKzk1 = null;
        HT_MosTrkKzk mosTrkKzk2 = null;
        for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {
            if(C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())){
                mosTrkKzk1 = mosTrkKzk;
            }
            else if(C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())){
                mosTrkKzk2 = mosTrkKzk;
            }
        }
        List<HT_Uketorinin> uketorininKykdrnLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        List<HT_Uketorinin> uketorininSiteiDrSkLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);

        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou =
            syoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        HT_MosDairiten mosDairiten1 = syoriCTL.getMosDairitenByRenno(1);

        HT_MosDairiten mosDairiten2 = syoriCTL.getMosDairitenByRenno(2);

        String[] mosKihon1Gms = new String[]{
            pUiBean.getAitemosno(),
            pUiBean.getDoujikaiyakusyono(),
            editYmd(pUiBean.getMosymd()),
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
            mosKihon.getAitemosno(),
            mosKihon.getDoujikaiyakusyono(),
            editYmd(mosKihon.getMosymd()),
            mosKihon.getHknsyuruino().getContent(C_HknsyuruiNo.PATTERN_SYANAIDISP),
            mosKihon.getKykkbn().getContent(),
            mosKihon.getYakkanjyuryouhoukbn().getContent(C_YakkanJyuryouKbn.PATTERN_SELECT),
            mosKihon.getFatcasnsikbn().getContent(),
            mosKihon.getBikkjnssinfokbn().getContent(),
            mosKihon.getBikknzsyno(),
            mosKihon.getAeoisnsikbn().getContent(),
            mosKihon.getKyknmkn(),
            mosKihon.getKyknmkj(),
            mosKihon.getKyknmkjkhukakbn().getContent(),
            editYmd(mosKihon.getKykseiymd()),
            mosKihon.getKyksei().getContent(),
            mosKihon.getKyktdk().getContent(),
            mosKihon.getTsinyno(),
            mosKihon.getTsinadr1kj(),
            mosKihon.getTsinadr2kj(),
            mosKihon.getTsinadr3kj(),
            mosKihon.getTsintelno(),
            mosKihon.getDai2tsintelno(),
            mosKihon.getHhknnmkn(),
            mosKihon.getHhknnmkj(),
            mosKihon.getHhknnmkjkhukakbn().getContent(),
            editYmd(mosKihon.getHhknseiymd()),
            mosKihon.getHhknsei().getContent(),
            mosKihon.getTsindousiteikbn().getContent(),
            mosKihon.getHhknyno(),
            mosKihon.getHhknadr1kj(),
            mosKihon.getHhknadr2kj(),
            mosKihon.getHhknadr3kj(),
            mosKihon.getHhkntelno(),
            editYmd(mosKihon.getKktymd()),
            mosKihon.getHhknsykgycd(),
            mosKihon.getHhknnensyuukbn().getContent()
        };

        String[] mosKihon1Disps = new String[]{
            DISP_AITEMOSNO,
            DISP_DOUJIKAIYAKUSYONO,
            DISP_MOSYMD,
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
            DISP_HHKNNENSYUUKBN
        };

        String[] mosKihon1Keys = new String[]{
            AITEMOSNO,
            DOUJIKAIYAKUSYONO,
            MOSYMD,
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
            HHKNNENSYUUKBN
        };

        for (int index = 0; index < mosKihon1Gms.length; index++) {
            String[] hkMosKihon11Rslts = hntmDtHnkSyr(mosKihon1Keys[index], mosKihon1Dbs[index], mosKihon1Gms[index]);
            teiseiMaeNaiyou = hkMosKihon11Rslts[0];
            teiseiGoNaiyou = hkMosKihon11Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon12Rslts = tsNyHnknSyr(mosKihon1Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon12Rslts[0];
                teiseiGoNaiyou = hkMosKihon12Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon1Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] uktNenkinGms = new String[]{
            pUiBean.getNenkinuktkbn().getContent(C_UktKbn.PATTERN_NKUKT)
        };

        String[] uktNenkinDisps = new String[]{
            DISP_NENKINUKTKBN
        };

        String[] uktNenkinKeys = new String[]{
            NENKINUKTKBN
        };

        if (uketorininNenkinLst.size() != 0) {
            HT_Uketorinin uketorininNenkin = uketorininNenkinLst.get(0);

            String[] uktNenkinDbs = new String[]{
                uketorininNenkin.getUktkbn().getContent(C_UktKbn.PATTERN_NKUKT)
            };

            for (int index = 0; index < uktNenkinGms.length; index++) {
                String[] hkUktNenkin1Rslts = hntmDtHnkSyr(uktNenkinKeys[index], uktNenkinDbs[index], uktNenkinGms[index]);
                teiseiMaeNaiyou = hkUktNenkin1Rslts[0];
                teiseiGoNaiyou = hkUktNenkin1Rslts[1];

                if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                    hyoujiJyunRenNo++;

                    String[] hkUktNenkin2Rslts = tsNyHnknSyr(uktNenkinKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                    teiseiMaeNaiyou = hkUktNenkin2Rslts[0];
                    teiseiGoNaiyou = hkUktNenkin2Rslts[1];

                    tsNyTrkSyr(syoriCTL,
                        mosNo,
                        pSysTime,
                        hyoujiJyunRenNo,
                        pKinouId,
                        pKinouModeId,
                        uktNenkinDisps[index],
                        teiseiMaeNaiyou,
                        teiseiGoNaiyou,
                        pUserId);
                }
            }
        }
        else if (!C_UktKbn.BLNK.eq(pUiBean.getNenkinuktkbn())) {
            for (int index = 0; index < uktNenkinGms.length; index++) {

                String[] hkUktNenkin1Rslts = hntmDtHnkSyr(uktNenkinKeys[index], "", uktNenkinGms[index]);
                teiseiMaeNaiyou = hkUktNenkin1Rslts[0];
                teiseiGoNaiyou = hkUktNenkin1Rslts[1];

                if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                    hyoujiJyunRenNo++;

                    String[] hkUktNenkin2Rslts = tsNyHnknSyr(uktNenkinKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                    teiseiMaeNaiyou = hkUktNenkin2Rslts[0];
                    teiseiGoNaiyou = hkUktNenkin2Rslts[1];

                    tsNyTrkSyr(syoriCTL,
                        mosNo,
                        pSysTime,
                        hyoujiJyunRenNo,
                        pKinouId,
                        pKinouModeId,
                        uktNenkinDisps[index],
                        teiseiMaeNaiyou,
                        teiseiGoNaiyou,
                        pUserId);
                }
            }
        }

        String[] mosKihon2Gms = new String[]{
            zero2Blank(pUiBean.getSbuktnin())
        };

        String[] mosKihon2Dbs = new String[]{
            zero2Blank(mosKihon.getSbuktnin())
        };

        String[] mosKihon2Disps = new String[]{
            DISP_SBUKTNIN
        };

        String[] mosKihon2Keys = new String[]{
            SBUKTNIN
        };

        for (int index = 0; index < mosKihon2Gms.length; index++) {
            String[] hkMosKihon21Rslts = hntmDtHnkSyr(mosKihon2Keys[index], mosKihon2Dbs[index], mosKihon2Gms[index]);
            teiseiMaeNaiyou = hkMosKihon21Rslts[0];
            teiseiGoNaiyou = hkMosKihon21Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon22Rslts = tsNyHnknSyr(mosKihon2Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon22Rslts[0];
                teiseiGoNaiyou = hkMosKihon22Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon2Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] uktSibouGms = new String[]{
            DISPSBUKTKBN,
            DISPSBUKTNMKN,
            DISPSBUKTNMKJ,
            DISPSBUKTNMKJHUKAKBN,
            DISPSBUKTSEIYMD,
            DISPSBUKTTDK,
            DISPSBUKTBNWARI
        };

        String[] uktSibouDbs = null;

        String[] uktSibouDisps = new String[]{
            DISP_DISPSBUKTKBN,
            DISP_DISPSBUKTNMKN,
            DISP_DISPSBUKTNMKJ,
            DISP_DISPSBUKTNMKJHUKAKBN,
            DISP_DISPSBUKTSEIYMD,
            DISP_DISPSBUKTTDK,
            DISP_DISPSBUKTBNWARI
        };

        Map<String, String[]> infoMap = getMousikomisyoSbUkt(pUiBean);
        String[] sbUktKbns = infoMap.get(DISPSBUKTKBN);

        for (int index = 0; index < sbUktKbns.length; index++) {
            uketoriRenNo++;

            if (index < uketorininSibouLst.size()) {
                HT_Uketorinin uketorininSibou = uketorininSibouLst.get(index);

                uktSibouDbs = new String[]{
                    uketorininSibou.getUktkbn().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
                    uketorininSibou.getUktnmkn(),
                    uketorininSibou.getUktnmkj(),
                    uketorininSibou.getUktnmkjkhukakbn().getContent(),
                    editYmd(uketorininSibou.getUktseiymd()),
                    uketorininSibou.getUkttdk().getContent(C_Tdk.PATTERN_SBUKT),
                    zero2Blank(uketorininSibou.getUktbnwari())
                };

                for (int loopCount = 0; loopCount < uktSibouGms.length; loopCount++) {
                    String[] hkUktSibou1Rslts = hntmDtHnkSyr(uktSibouGms[loopCount],
                        uktSibouDbs[loopCount],
                        infoMap.get(uktSibouGms[loopCount])[index]);

                    teiseiMaeNaiyou = hkUktSibou1Rslts[0];
                    teiseiGoNaiyou = hkUktSibou1Rslts[1];

                    if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                        hyoujiJyunRenNo++;

                        String[] hkUktSibou2Rslts = tsNyHnknSyr(uktSibouGms[loopCount],
                            teiseiMaeNaiyou,
                            teiseiGoNaiyou);

                        teiseiMaeNaiyou = hkUktSibou2Rslts[0];
                        teiseiGoNaiyou = hkUktSibou2Rslts[1];

                        tsNyTrkSyr(syoriCTL,
                            mosNo,
                            pSysTime,
                            hyoujiJyunRenNo,
                            pKinouId,
                            pKinouModeId,
                            uktSibouDisps[loopCount] + String.valueOf(uketoriRenNo),
                            teiseiMaeNaiyou,
                            teiseiGoNaiyou,
                            pUserId);
                    }
                }
            }
            else {
                if (infoMap.get(DISPSBUKTKBN)[index].equals(C_UktKbn.BLNK.getContent())) {
                    continue;
                }

                for (int loopCount = 0; loopCount < uktSibouGms.length; loopCount++) {
                    String valueGm = infoMap.get(uktSibouGms[loopCount])[index];

                    if (uktSibouGms[loopCount].equals(DISPSBUKTTDK)) {
                        if (valueGm.equals(C_Tdk.BLNK.getContent())) {
                            valueGm = "";
                        }
                    }

                    String[] hkUktSibou1Rslts = hntmDtHnkSyr(uktSibouGms[loopCount], "", valueGm);
                    teiseiMaeNaiyou = hkUktSibou1Rslts[0];
                    teiseiGoNaiyou = hkUktSibou1Rslts[1];

                    if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                        hyoujiJyunRenNo++;

                        String[] hkUktSibou2Rslts = tsNyHnknSyr(uktSibouGms[loopCount], teiseiMaeNaiyou, teiseiGoNaiyou);
                        teiseiMaeNaiyou = hkUktSibou2Rslts[0];
                        teiseiGoNaiyou = hkUktSibou2Rslts[1];

                        tsNyTrkSyr(syoriCTL,
                            mosNo,
                            pSysTime,
                            hyoujiJyunRenNo,
                            pKinouId,
                            pKinouModeId,
                            uktSibouDisps[loopCount] + String.valueOf(uketoriRenNo),
                            teiseiMaeNaiyou,
                            teiseiGoNaiyou,
                            pUserId);
                    }
                }
            }
        }

        HT_MosSyouhn mosSyouhnSyu = mosSyouhnSyuLst.get(0);

        String dai1HknkknGm = "0";
        String kihonsGm = editTuuka(pUiBean.getSyukihons());
        String hrkTuukaSyukykpGm = editTuuka(pUiBean.getHrktuukasyukykp());
        String mosikkatupGm = editTuuka(pUiBean.getMosikkatup());
        String mossyukykpGm = editTuuka(pUiBean.getMossyukykp());
        String moszennoupsyokaiariGm = editTuuka(pUiBean.getMoszennoupsyokaiari());

        String kihonsDb = editTuuka(mosSyouhnSyu.getKihons());
        String hrkTuukaSyukykpDb = "";
        if (!C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            hrkTuukaSyukykpDb = editTuuka(mosSyouhnSyu.getHrktuukasyutkp());
        }
        String mosikkatupDb = editTuuka(mosKihon.getMosikkatup());
        String mossyukykpDb = "";
        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
            mossyukykpDb = editTuuka(mosSyouhnSyu.getHrktuukasyutkp());
        }
        String moszennoupsyokaiariDb = editTuuka(mosKihon.getMoszennoupsyokaiari());
        String kykTuukasyuDb = null;
        String hrkTuukasyuDb = null;
        String hknkknDb = "0";
        String hrkkknDb = "0";
        String sueokiKknDb = "0";
        int zennouKaisuuDb = 0;

        String dispHrkkkn = DISP_SYUHRKKKN;
        String dispHknkkn = DISP_SYUHKNKKN;

        if (!BizUtil.isBlank(pUiBean.getSyudai1hknkknmosinput())) {
            dai1HknkknGm = pUiBean.getSyudai1hknkknmosinput();
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getGaikatatkiumu())) {
            kykTuukasyuDb = mosKihon.getKyktuukasyu().getContent();
            hrkTuukasyuDb = mosKihon.getHrktuukasyu().getContent();
        }
        else {
            kykTuukasyuDb = C_Tuukasyu.BLNK.getContent();
            hrkTuukasyuDb= C_Tuukasyu.BLNK.getContent();
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());
        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {
            sueokiKknDb = mosSyouhn.getHknkkn().toString();
        }
        else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
            hknkknDb = mosSyouhnSyu.getHknkkn().toString();
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
            hrkkknDb = mosSyouhnSyu.getHrkkkn().toString();
            hknkknDb = mosSyouhnSyu.getHknkkn().toString();
            dispHrkkkn = DISP_PHRKMNRYNEN;
            dispHknkkn = DISP_NKSHRSTARTNEN;
        }
        else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
            hrkkknDb = mosSyouhnSyu.getHrkkkn().toString();
            hknkknDb = mosSyouhnSyu.getHknkkn().toString();
        }

        if (mosKihon.getZnnkai() > 0) {
            if (!C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                zennouKaisuuDb = mosKihon.getZnnkai() + 1;
            }
        }

        String[] syuKeiyakuHosyouJouhouGm = new String[] {
            String.valueOf(pUiBean.getSyuhrkkkn()),
            pUiBean.getSyuhrkkknsmnkbn().getContent(C_HrkkknsmnKbn.PATTERN_SELECT),
            String.valueOf(pUiBean.getSyuhknkkn()),
            pUiBean.getSyuhknkknsmnkbn().getContent(C_HknkknsmnKbn.PATTERN_SELECT),
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
            pUiBean.getKjnnkpzeitekitkhukakbn().getContent()
        };

        String[] syuKeiyakuHosyouJouhouDb = new String[] {
            hrkkknDb,
            mosSyouhnSyu.getHrkkknsmnkbn().getContent(C_HrkkknsmnKbn.PATTERN_SELECT),
            hknkknDb,
            mosSyouhnSyu.getHknkknsmnkbn().getContent(C_HknkknsmnKbn.PATTERN_SELECT),
            String.valueOf(mosSyouhnSyu.getDai1hknkkn()),
            mosKihon.getSdpdkbn().getContent(),
            mosSyouhnSyu.getSknenkinsyu().getContent(),
            mosKihon.getZenkizennouumu().getContent(),
            zero2Blank(zennouKaisuuDb),
            mosKihon.getHrkkaisuu().getContent(),
            mosKihon.getHrkkeiro().getContent(C_Hrkkeiro.PATTERN_SINKEIYAKU),
            mosKihon.getFstphrkkeirokbn().getContent(C_FstphrkkeiroKbn.PATTERN_SKSELECT),
            mosKihon.getIkkatubaraikaisuu().getContent(C_IkkatubaraiKaisuuKbn.PATTERN_TEIKI),
            kykTuukasyuDb,
            hrkTuukasyuDb,
            kihonsDb,
            hrkTuukaSyukykpDb,
            mosikkatupDb,
            mossyukykpDb,
            moszennoupsyokaiariDb,
            mosKihon.getSisuuhaibunwarikbn().getContent(),
            mosKihon.getTeirituhaibunwarikbn().getContent(),
            sueokiKknDb,
            mosKihon.getNkgnshosyouritukbn().getContent(),
            mosKihon.getKjnnkpzeitekitkhukakbn().getContent()
        };

        String[] syuKeiyakuHosyouJouhouDisps = new String[] {
            dispHrkkkn,
            DISP_SYUHRKKKNSMNKBN,
            dispHknkkn,
            DISP_SYUHKNKKNSMNKBN,
            DISP_SYUDAI1HKNKKNMOSINPUT,
            DISP_SDPDKBN,
            DISP_SKNENKINSYU,
            DISP_ZENKIZENNOU,
            DISP_ZENNOUKKN,
            DISP_HRKKAISUU,
            DISP_HRKKEIRO,
            DISP_FSTPHRKKEIROKBN,
            DISP_IKKATUBARAIKAISUU,
            DISP_KYKTUUKASYU,
            DISP_HRKTUUKASYU,
            DISP_SYUKIHONS,
            DISP_HRKTUUKASYUKYKP,
            DISP_MOSIKKATUP,
            DISP_MOSSYUKYKP,
            DISP_MOSZENNOUPSYOKAIARI,
            DISP_SISUUHAIBUNWARIKBN,
            DISP_TEIRITUHAIBUNWARIKBN,
            DISP_SUEOKIKKNMOSINPUT,
            DISP_NKGNSHOSYOURITUKBN,
            DISP_KJNNKPZEITEKITKHUKAKBN
        };

        String[] syuKeiyakuHosyouJouhouKeys = new String[] {
            SYUHRKKKN,
            SYUHRKKKNSMNKBN,
            SYUHKNKKN,
            SYUHKNKKNSMNKBN,
            SYUDAI1HKNKKNMOSINPUT,
            SDPDKBN,
            SKNENKINSYU,
            ZENKIZENNOU,
            ZENNOUKKN,
            HRKKAISUU,
            HRKKEIRO,
            FSTPHRKKEIROKBN,
            IKKATUBARAIKAISUU,
            KYKTUUKASYU,
            HRKTUUKASYU,
            SYUKIHONS,
            HRKTUUKASYUKYKP,
            MOSIKKATUP,
            MOSSYUKYKP,
            MOSZENNOUPSYOKAIARI,
            SISUUHAIBUNWARIKBN,
            TEIRITUHAIBUNWARIKBN,
            SUEOKIKKNMOSINPUT,
            NKGNSHOSYOURITUKBN,
            KJNNKPZEITEKITKHUKAKBN
        };

        for (int index = 0; index < syuKeiyakuHosyouJouhouGm.length; index++) {
            String valueGm = syuKeiyakuHosyouJouhouGm[index];
            String valueDb = syuKeiyakuHosyouJouhouDb[index];

            String[] syuKeiyakuHosyouJouhou1Rslts = hntmDtHnkSyr(syuKeiyakuHosyouJouhouKeys[index], valueDb, valueGm);
            teiseiMaeNaiyou = syuKeiyakuHosyouJouhou1Rslts[0];
            teiseiGoNaiyou = syuKeiyakuHosyouJouhou1Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] syuKeiyakuHosyouJouhou2Rslts = tsNyHnknSyr(syuKeiyakuHosyouJouhouKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = syuKeiyakuHosyouJouhou2Rslts[0];
                teiseiGoNaiyou = syuKeiyakuHosyouJouhou2Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    syuKeiyakuHosyouJouhouDisps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        //  2016/03/08 S社導入：コメントアウト
        //        sortedGmInfoMp = sortMousikomisyo(pUiBean);
        //
        //        String[] mosSyouhinTkGms = new String[]{
        //                DISPTKSYOUHNCD,
        //                DISPTKKATAKBN,
        //                DISPTKKYHKATAKBN,
        //                DISPTKKIHONS,
        //                DISPTKHKNKKN,
        //                DISPTKHKNKKNSMNKBN,
        //                DISPTKHRKKKN,
        //                DISPTKHRKKKNSMNKBN
        //        };
        //
        //        String[] mosSyouhinTkDbs = null;
        //
        //        String[] mosSyouhinTkDisps = new String[]{
        //                DISP_DISPTKSYOUHNCD,
        //                DISP_DISPTKKATAKBN,
        //                DISP_DISPTKKYHKATAKBN,
        //                DISP_DISPTKKIHONS,
        //                DISP_DISPTKHKNKKN,
        //                DISP_DISPTKHKNKKNSMNKBN,
        //                DISP_DISPTKHRKKKN,
        //                DISP_DISPTKHRKKKNSMNKBN
        //        };
        //
        //        int dbTkExistFlag = 0;
        //        if (mosSyouhnTkLst.size() != 0) {
        //            dbTkExistFlag = 1;
        //        }
        //
        //        Iterator<Integer> tkIterator = sortedGmInfoMp.keySet().iterator();
        //        int tkSyouhnKey = 0;
        //        if (tkIterator.hasNext()) {
        //            tkSyouhnKey = tkIterator.next();
        //        }
        //
        //        int mosTkLstCount = 0;
        //        Object[] mosSyouhnTks = null;
        //
        //        while (dbTkExistFlag != 0 || tkSyouhnKey != 0) {
        //            tkRenNo++;
        //
        //            if ((dbTkExistFlag != 0 && tkSyouhnKey != 0) &&
        //                    (((Integer) mosSyouhnTkLst.get(mosTkLstCount)[8]) == tkSyouhnKey)) {
        //
        //                mosSyouhnTks = mosSyouhnTkLst.get(mosTkLstCount);
        //
        //                mosSyouhinTkDbs = new String[]{
        //                        (String) mosSyouhnTks[0],
        //                        ((C_KataKbn) mosSyouhnTks[1]).getContent(),
        //                        ((C_KyhgndkataKbn) mosSyouhnTks[2]).getContent(),
        //                        zero2Blank(mosSyouhnTks[3]),
        //                        zero2Blank(mosSyouhnTks[4]),
        //                        ((C_HknkknsmnKbn) mosSyouhnTks[5]).getContent(C_HknkknsmnKbn.PATTERN_MOS),
        //                        zero2Blank(mosSyouhnTks[6]),
        //                        ((C_HrkkknsmnKbn) mosSyouhnTks[7]).getContent(C_HrkkknsmnKbn.PATTERN_MOS)
        //                };
        //
        //                for (int index = 0; index < mosSyouhinTkGms.length; index++) {
        //                    String valueGm = sortedGmInfoMp.get(tkSyouhnKey).get(mosSyouhinTkGms[index]);
        //
        //                    if (mosSyouhinTkGms[index].equals(DISPTKKATAKBN)) {
        //                        if (valueGm.equals(C_KataKbn.BLNK.getContent())) {
        //                            valueGm = C_KataKbn.HONNIN.getContent();
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKKIHONS)) {
        //                        boolean result = SyouhinUtil.isSensinIryoTk((String)mosSyouhnTks[0]);
        //                        if (result) {
        //                            continue;
        //                        }
        //                    }
        //
        //                    String[] hk31Rslts = hntmDtHnkSyr(mosSyouhinTkGms[index], mosSyouhinTkDbs[index], valueGm);
        //                    teiseiMaeNaiyou = hk31Rslts[0];
        //                    teiseiGoNaiyou = hk31Rslts[1];
        //
        //                    if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
        //
        //                        hyoujiJyunRenNo++;
        //
        //                        if (mosSyouhinTkGms[index].equals(DISPTKSYOUHNCD)) {
        //                            teiseiMaeNaiyou = syouhinUtil.getSyouhnNm(
        //                                    mosSyouhinTkDbs[index], BizDate.valueOf(pSysTime.substring(0, 8)));
        //                            teiseiGoNaiyou = syouhinUtil.getSyouhnNm(
        //                                    valueGm, BizDate.valueOf(pSysTime.substring(0, 8)));
        //                        }
        //                        else {
        //                            String[] hnkn32Rslts = tsNyHnknSyr(mosSyouhinTkGms[index], teiseiMaeNaiyou, teiseiGoNaiyou);
        //                            teiseiMaeNaiyou = hnkn32Rslts[0];
        //                            teiseiGoNaiyou = hnkn32Rslts[1];
        //                        }
        //
        //                        tsNyTrkSyr(syoriCTL,
        //                                mosNo,
        //                                pSysTime,
        //                                hyoujiJyunRenNo,
        //                                pKinouId,
        //                                pKinouModeId,
        //                                mosSyouhinTkDisps[index] + String.valueOf(tkRenNo),
        //                                teiseiMaeNaiyou,
        //                                teiseiGoNaiyou,
        //                                pUserId);
        //                    }
        //                }
        //
        //                mosTkLstCount++;
        //                if (mosTkLstCount < mosSyouhnTkLst.size()) {
        //                    dbTkExistFlag = 1;
        //                }
        //                else {
        //                    dbTkExistFlag = 0;
        //                }
        //
        //                if (tkIterator.hasNext()) {
        //                    tkSyouhnKey = tkIterator.next();
        //                }
        //                else {
        //                    tkSyouhnKey = 0;
        //                }
        //            }
        //            else if (tkSyouhnKey != 0 &&
        //                    (dbTkExistFlag == 0 || (((Integer) mosSyouhnTkLst.get(mosTkLstCount)[8]) > tkSyouhnKey))) {
        //
        //                for (int index = 0; index < mosSyouhinTkGms.length; index++) {
        //                    String valueGm = sortedGmInfoMp.get(tkSyouhnKey).get(mosSyouhinTkGms[index]);
        //
        //                    if (mosSyouhinTkGms[index].equals(DISPTKKATAKBN)) {
        //                        if (valueGm.equals(C_KataKbn.BLNK.getContent())) {
        //                            valueGm = "";
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKKYHKATAKBN)) {
        //                        if (valueGm.equals(C_KyhgndkataKbn.BLNK.getContent())) {
        //                            valueGm = "";
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKHRKKKNSMNKBN)) {
        //                        if (valueGm.equals(C_HrkkknsmnKbn.BLNK.getContent())) {
        //                            valueGm = "";
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKKIHONS)) {
        //                        boolean result = SyouhinUtil.isSensinIryoTk(sortedGmInfoMp.get(tkSyouhnKey).get(DISPTKSYOUHNCD));
        //                        if (result) {
        //                            continue;
        //                        }
        //                    }
        //
        //                    String[] hk31Rslts = hntmDtHnkSyr(mosSyouhinTkGms[index], "", valueGm);
        //                    teiseiMaeNaiyou = hk31Rslts[0];
        //                    teiseiGoNaiyou = hk31Rslts[1];
        //
        //                    if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
        //                        hyoujiJyunRenNo++;
        //
        //                        if (mosSyouhinTkGms[index].equals(DISPTKSYOUHNCD)) {
        //                            teiseiGoNaiyou = syouhinUtil.getSyouhnNm(valueGm, BizDate.valueOf(pSysTime.substring(0, 8)));
        //                        }
        //                        else {
        //                            String[] sHnkn32Rslts = tsNyHnknSyr(mosSyouhinTkGms[index], teiseiMaeNaiyou, teiseiGoNaiyou);
        //                            teiseiMaeNaiyou = sHnkn32Rslts[0];
        //                            teiseiGoNaiyou = sHnkn32Rslts[1];
        //                        }
        //
        //                        tsNyTrkSyr(syoriCTL,
        //                                mosNo,
        //                                pSysTime,
        //                                hyoujiJyunRenNo,
        //                                pKinouId,
        //                                pKinouModeId,
        //                                mosSyouhinTkDisps[index] + String.valueOf(tkRenNo),
        //                                teiseiMaeNaiyou,
        //                                teiseiGoNaiyou,
        //                                pUserId);
        //                    }
        //                }
        //
        //                if (tkIterator.hasNext()) {
        //                    tkSyouhnKey = tkIterator.next();
        //                }
        //                else {
        //                    tkSyouhnKey = 0;
        //                }
        //            }
        //            else {
        //
        //                mosSyouhnTks = mosSyouhnTkLst.get(mosTkLstCount);
        //
        //                mosSyouhinTkDbs = new String[]{
        //                        (String) mosSyouhnTks[0],
        //                        ((C_KataKbn) mosSyouhnTks[1]).getContent(),
        //                        ((C_KyhgndkataKbn) mosSyouhnTks[2]).getContent(),
        //                        zero2Blank(mosSyouhnTks[3]),
        //                        zero2Blank(mosSyouhnTks[4]),
        //                        ((C_HknkknsmnKbn) mosSyouhnTks[5]).getContent(C_HknkknsmnKbn.PATTERN_MOS),
        //                        zero2Blank(mosSyouhnTks[6]),
        //                        ((C_HrkkknsmnKbn) mosSyouhnTks[7]).getContent(C_HrkkknsmnKbn.PATTERN_MOS)
        //                };
        //
        //                for (int index = 0; index < mosSyouhinTkGms.length; index++) {
        //
        //                    String valueDb = mosSyouhinTkDbs[index];
        //
        //                    if (mosSyouhinTkGms[index].equals(DISPTKKATAKBN)) {
        //                        if (valueDb.equals(C_KataKbn.HONNIN.getContent())) {
        //                            valueDb = "";
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKKYHKATAKBN)) {
        //                        if (valueDb.equals(C_KyhgndkataKbn.BLNK.getContent())) {
        //                            valueDb = "";
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKHRKKKNSMNKBN)) {
        //                        if (valueDb.equals(C_HrkkknsmnKbn.BLNK.getContent())) {
        //                            valueDb = "";
        //                        }
        //                    }
        //                    else if (mosSyouhinTkGms[index].equals(DISPTKKIHONS)) {
        //                        boolean result = SyouhinUtil.isSensinIryoTk((String) mosSyouhnTks[0]);
        //                        if (result) {
        //                            continue;
        //                        }
        //                    }
        //
        //                    String[] hk31Rslts = hntmDtHnkSyr(mosSyouhinTkGms[index], valueDb, "");
        //                    teiseiMaeNaiyou = hk31Rslts[0];
        //                    teiseiGoNaiyou = hk31Rslts[1];
        //
        //                    if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
        //                        hyoujiJyunRenNo++;
        //
        //                        if (mosSyouhinTkGms[index].equals(DISPTKSYOUHNCD)) {
        //                            teiseiMaeNaiyou = syouhinUtil.getSyouhnNm(valueDb, BizDate.valueOf(pSysTime.substring(0, 8)));
        //                        }
        //                        else {
        //                            String[] hnkn32Rslts = tsNyHnknSyr(mosSyouhinTkGms[index], teiseiMaeNaiyou, teiseiGoNaiyou);
        //                            teiseiMaeNaiyou = hnkn32Rslts[0];
        //                            teiseiGoNaiyou = hnkn32Rslts[1];
        //                        }
        //
        //                        tsNyTrkSyr(syoriCTL,
        //                                mosNo,
        //                                pSysTime,
        //                                hyoujiJyunRenNo,
        //                                pKinouId,
        //                                pKinouModeId,
        //                                mosSyouhinTkDisps[index] + String.valueOf(tkRenNo),
        //                                teiseiMaeNaiyou,
        //                                teiseiGoNaiyou,
        //                                pUserId);
        //                    }
        //                }
        //
        //                mosTkLstCount++;
        //                if (mosTkLstCount < mosSyouhnTkLst.size()) {
        //                    dbTkExistFlag = 1;
        //                }
        //                else {
        //                    dbTkExistFlag = 0;
        //                }
        //            }
        //        }

        C_KouzasyuruiKbn kzsyuruikbn = C_KouzasyuruiKbn.BLNK;
        String bankcd = "";
        String sitencd = "";
        C_YokinKbn yokinkbn = C_YokinKbn.BLNK;
        String kouzano = "";
        C_KzkykdouKbn kzkykdoukbn = C_KzkykdouKbn.BLNK;
        String kzmeiginmkn = "";
        String kzmeiginmknGm = pUiBean.getKzmeiginmkn();

        if (uketoriKouzaJyouhou != null) {
            kzsyuruikbn = uketoriKouzaJyouhou.getKzsyuruikbn();
            bankcd = uketoriKouzaJyouhou.getBankcd();
            sitencd = uketoriKouzaJyouhou.getSitencd();
            yokinkbn = uketoriKouzaJyouhou.getYokinkbn();
            kouzano = uketoriKouzaJyouhou.getKouzano();
            kzkykdoukbn = uketoriKouzaJyouhou.getKzkykdoukbn();
            kzmeiginmkn = uketoriKouzaJyouhou.getKzmeiginmkn();
        }

        if (C_KzkykdouKbn.DOUITU.eq(pUiBean.getKzkykdoukbn())) {
            kzmeiginmknGm = "";
        }

        String[] mosKihon5Gms = new String[]{
            pUiBean.getTeikisiharaitkykhkkbn().getContent(),
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
            mosKihon.getTeikisiharaitkykhkkbn().getContent(),
            kzsyuruikbn.getContent(C_KouzasyuruiKbn.PATTERN_SHKSTKZ),
            bankcd,
            sitencd,
            yokinkbn.getContent(),
            kouzano,
            kzkykdoukbn.getContent(),
            kzmeiginmkn,
            mosKihon.getTargettkmkhtkbn().getContent(),
            mosKihon.getSyksbyensitihsyutkhkkbn().getContent(),
            mosKihon.getJyudkaigomehrtkhkkbn().getContent(),
            mosKihon.getNstkhkkbn().getContent(),
            zero2Blank(mosKihon.getNstksbnkkn())
        };

        String[] mosKihon5Disps = new String[]{
            DISP_TEIKISIHARAITKYKHKKBN,
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

        String[] mosKihon5Keys = new String[]{
            TEIKISIHARAITKYKHKKBN,
            KZSYURUIKBN,
            BANKCD,
            SITENCD,
            YOKINKBN,
            KOUZANO,
            KZKYKDOUKBN,
            KZMEIGINMKN,
            TARGETTKMKHTKBN,
            SYKSBYENSITIHSYUTKHKKBN,
            JYUDKAIGOMEHRTKHKKBN,
            NSTKHKKBN,
            NSTKSBNKKN
        };

        for (int index = 0; index < mosKihon5Gms.length; index++) {
            String[] hkMosKihon51Rslts = hntmDtHnkSyr(mosKihon5Keys[index], mosKihon5Dbs[index], mosKihon5Gms[index]);
            teiseiMaeNaiyou = hkMosKihon51Rslts[0];
            teiseiGoNaiyou = hkMosKihon51Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon52Rslts = tsNyHnknSyr(mosKihon5Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon52Rslts[0];
                teiseiGoNaiyou = hkMosKihon52Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon5Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] kzkDairinDsHtinfoGms = new String[]{
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
            pUiBean.getTrkkzknmkn2(),
            pUiBean.getTrkkzknmkj2(),
            pUiBean.getTrkkzknmkjkhukakbn2().getContent(),
            editYmd(pUiBean.getTrkkzkseiymd2()),
            pUiBean.getTrkkzksei2().getContent(C_Seibetu.PATTERN_SELECT),
            pUiBean.getTrkkzktdk2().getContent(C_Tdk.PATTERN_TRKKZK),
            pUiBean.getTrkkzktsindousiteikbn2().getContent(),
            pUiBean.getTrkkzkyno2(),
            pUiBean.getTrkkzkadr1kj2(),
            pUiBean.getTrkkzkadr2kj2(),
            pUiBean.getTrkkzkadr3kj2(),
            pUiBean.getTrkkzktelno2(),
            pUiBean.getKykdrtkykhukakbn().getContent(),
            pUiBean.getKykdrkbn().getContent(C_UktKbn.PATTERN_SKKYKDR),
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

        String[] kzkDairinDsHtinfoDisps = new String[]{
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
            DISP_TRKKZKNMKN2,
            DISP_TRKKZKNMKJ2,
            DISP_TRKKZKNMKJKHUKAKBN2,
            DISP_TRKKZKSEIYMD2,
            DISP_TRKKZKSEI2,
            DISP_TRKKZKTDK2,
            DISP_TRKKZKTSINDOUSITEIKBN2,
            DISP_TRKKZKYNO2,
            DISP_TRKKZKADR1KJ2,
            DISP_TRKKZKADR2KJ2,
            DISP_TRKKZKADR3KJ2,
            DISP_TRKKZKTELNO2,
            DISP_KYKDRTKYKHUKAKBN,
            DISP_KYKDRKBN,
            DISP_STDRSKTKYHKKBN,
            DISP_STDRUKTKBN,
            DISP_SITEIDRUKTNMKN,
            DISP_SITEIDRUKTNMKJ,
            DISP_STDRSKNMKJHUKAKBN,
            DISP_STDRSKSEIYMD,
            DISP_SITEIUKTTDK,
            DISP_DRCTSERVICEMOSKBN,
            DISP_YNKHRKMGKANNITUUTIKBN
        };

        String[] kzkDairinDsHtinfoKeys = new String[]{
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
            TRKKZKNMKN2,
            TRKKZKNMKJ2,
            TRKKZKNMKJKHUKAKBN2,
            TRKKZKSEIYMD2,
            TRKKZKSEI2,
            TRKKZKTDK2,
            TRKKZKTSINDOUSITEIKBN2,
            TRKKZKYNO2,
            TRKKZKADR1KJ2,
            TRKKZKADR2KJ2,
            TRKKZKADR3KJ2,
            TRKKZKTELNO2,
            KYKDRTKYKHUKAKBN,
            KYKDRKBN,
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

        String kzktourokuservicetourokukbn = mosKihon.getKzktourokuservicetourokukbn().getContent();
        String trkkzknmkn1 = "";
        String trkkzknmkj1 = "";
        String trkkzknmkjkhukakbn1 = C_KjkhukaKbn.BLNK.getContent();
        String trkkzkseiymd1 = "";
        String trkkzksei1 = C_Seibetu.BLNK.getContent(C_Seibetu.PATTERN_SELECT);
        String trkkzktdk1 = C_Tdk.BLNK.getContent(C_Tdk.PATTERN_TRKKZK);
        String trkkzktsindousiteikbn1 = C_TsindousiteiKbn.BLNK.getContent();
        String trkkzkyno1 = "";
        String trkkzkadr1kj1 = "";
        String trkkzkadr2kj1 = "";
        String trkkzkadr3kj1 = "";
        String trkkzktelno1 = "";
        String trkkzknmkn2 = "";
        String trkkzknmkj2 = "";
        String trkkzknmkjkhukakbn2 = C_KjkhukaKbn.BLNK.getContent();
        String trkkzkseiymd2 = "";
        String trkkzksei2 = C_Seibetu.BLNK.getContent(C_Seibetu.PATTERN_SELECT);
        String trkkzktdk2 = C_Tdk.BLNK.getContent(C_Tdk.PATTERN_TRKKZK);
        String trkkzktsindousiteikbn2 = C_TsindousiteiKbn.BLNK.getContent();
        String trkkzkyno2 = "";
        String trkkzkadr1kj2 = "";
        String trkkzkadr2kj2 = "";
        String trkkzkadr3kj2 = "";
        String trkkzktelno2 = "";
        String kykdrtkykhukakbn = mosKihon.getKykdrtkykhukakbn().getContent();
        String kykdrkbn = C_UktKbn.BLNK.getContent(C_UktKbn.PATTERN_SKKYKDR);
        String stdrsktkyhkkbn = mosKihon.getStdrsktkyhkkbn().getContent();
        String stdruktkbn = C_UktKbn.BLNK.getContent(C_UktKbn.PATTERN_SKSTDR);
        String siteidruktnmkn = "";
        String siteidruktnmkj = "";
        String stdrsknmkjhukakbn = C_KjkhukaKbn.BLNK.getContent();
        String siteidrseiymd = "";
        String siteiukttdk = C_Tdk.BLNK.getContent(C_Tdk.PATTERN_STDR);
        String drctservicemoskbn = mosKihon.getDrctservicemoskbn().getContent(C_DirectServiceMosKbn.PATTERN_MOS);
        String ynkhrkmgkannituutikbn = mosKihon.getYnkhrkmgkannituutikbn().getContent();

        if (mosTrkKzk1 != null) {
            trkkzknmkn1 = mosTrkKzk1.getTrkkzknmkn();
            trkkzknmkj1 = mosTrkKzk1.getTrkkzknmkj();
            trkkzknmkjkhukakbn1 = mosTrkKzk1.getTrkkzknmkjkhukakbn().getContent();
            trkkzkseiymd1 = editYmd(mosTrkKzk1.getTrkkzkseiymd());
            trkkzksei1 = mosTrkKzk1.getTrkkzksei().getContent(C_Seibetu.PATTERN_SELECT);
            trkkzktdk1 = mosTrkKzk1.getTrkkzktdk().getContent(C_Tdk.PATTERN_TRKKZK);
            trkkzktsindousiteikbn1 = mosTrkKzk1.getTrkkzktsindousiteikbn().getContent();
            trkkzkyno1 = mosTrkKzk1.getTrkkzkyno();
            trkkzkadr1kj1 = mosTrkKzk1.getTrkkzkadr1kj();
            trkkzkadr2kj1 = mosTrkKzk1.getTrkkzkadr2kj();
            trkkzkadr3kj1 = mosTrkKzk1.getTrkkzkadr3kj();
            trkkzktelno1 = mosTrkKzk1.getTrkkzktelno();
        }

        if (mosTrkKzk2 != null) {
            trkkzknmkn2 = mosTrkKzk2.getTrkkzknmkn();
            trkkzknmkj2 = mosTrkKzk2.getTrkkzknmkj();
            trkkzknmkjkhukakbn2 = mosTrkKzk2.getTrkkzknmkjkhukakbn().getContent();
            trkkzkseiymd2 = editYmd(mosTrkKzk2.getTrkkzkseiymd());
            trkkzksei2 = mosTrkKzk2.getTrkkzksei().getContent(C_Seibetu.PATTERN_SELECT);
            trkkzktdk2 = mosTrkKzk2.getTrkkzktdk().getContent(C_Tdk.PATTERN_TRKKZK);
            trkkzktsindousiteikbn2 = mosTrkKzk2.getTrkkzktsindousiteikbn().getContent();
            trkkzkyno2 = mosTrkKzk2.getTrkkzkyno();
            trkkzkadr1kj2 = mosTrkKzk2.getTrkkzkadr1kj();
            trkkzkadr2kj2 = mosTrkKzk2.getTrkkzkadr2kj();
            trkkzkadr3kj2 = mosTrkKzk2.getTrkkzkadr3kj();
            trkkzktelno2 = mosTrkKzk2.getTrkkzktelno();
        }

        if (uketorininKykdrnLst.size() != 0) {
            HT_Uketorinin uketorinin = uketorininKykdrnLst.get(0);
            kykdrkbn = uketorinin.getUktkbn().getContent(C_UktKbn.PATTERN_SKKYKDR);
        }

        if (uketorininSiteiDrSkLst.size() != 0) {
            HT_Uketorinin uketorininSiteiDrSk = uketorininSiteiDrSkLst.get(0);

            stdruktkbn = uketorininSiteiDrSk.getUktkbn().getContent(C_UktKbn.PATTERN_SKSTDR);
            siteidruktnmkn = uketorininSiteiDrSk.getUktnmkn();
            siteidruktnmkj = uketorininSiteiDrSk.getUktnmkj();
            stdrsknmkjhukakbn=  uketorininSiteiDrSk.getUktnmkjkhukakbn().getContent();
            siteidrseiymd = editYmd(uketorininSiteiDrSk.getUktseiymd());
            siteiukttdk = uketorininSiteiDrSk.getUkttdk().getContent(C_Tdk.PATTERN_STDR);
        }

        String[] kzkDairinDsHtinfoDbs = new String[]{
            kzktourokuservicetourokukbn,
            trkkzknmkn1,
            trkkzknmkj1,
            trkkzknmkjkhukakbn1,
            trkkzkseiymd1,
            trkkzksei1,
            trkkzktdk1,
            trkkzktsindousiteikbn1,
            trkkzkyno1,
            trkkzkadr1kj1,
            trkkzkadr2kj1,
            trkkzkadr3kj1,
            trkkzktelno1,
            trkkzknmkn2,
            trkkzknmkj2,
            trkkzknmkjkhukakbn2,
            trkkzkseiymd2,
            trkkzksei2,
            trkkzktdk2,
            trkkzktsindousiteikbn2,
            trkkzkyno2,
            trkkzkadr1kj2,
            trkkzkadr2kj2,
            trkkzkadr3kj2,
            trkkzktelno2,
            kykdrtkykhukakbn,
            kykdrkbn,
            stdrsktkyhkkbn,
            stdruktkbn,
            siteidruktnmkn,
            siteidruktnmkj,
            stdrsknmkjhukakbn,
            siteidrseiymd,
            siteiukttdk,
            drctservicemoskbn,
            ynkhrkmgkannituutikbn
        };

        for (int index = 0; index < kzkDairinDsHtinfoGms.length; index++) {
            String[] hkUktSiteiDrSk1Rslts = hntmDtHnkSyr(kzkDairinDsHtinfoKeys[index], kzkDairinDsHtinfoDbs[index],
                kzkDairinDsHtinfoGms[index]);
            teiseiMaeNaiyou = hkUktSiteiDrSk1Rslts[0];
            teiseiGoNaiyou = hkUktSiteiDrSk1Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkUktSiteiDrSk2Rslts = tsNyHnknSyr(kzkDairinDsHtinfoKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkUktSiteiDrSk2Rslts[0];
                teiseiGoNaiyou = hkUktSiteiDrSk2Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    kzkDairinDsHtinfoDisps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        teiseiMaeNaiyou = "";
        teiseiGoNaiyou = "";
        mosNo = pUiBean.getMosno();
        C_KzhuritourokuhouKbn kzhuritourokuhoukbn = C_KzhuritourokuhouKbn.BLNK;
        String kouhurikzinfobankcd = "";
        String kouhurikzinfositencd = "";
        C_YokinKbn kouhurikzinfoyokin = C_YokinKbn.BLNK;
        String kouhurikzinfokouzano = "";
        C_KzkykdouKbn kouhurikzinfokzkykdoukbn = C_KzkykdouKbn.BLNK;
        String kouhurikzinfokzmeiginm = "";
        C_YouhiblnkKbn csskakuniniraikbn = C_YouhiblnkKbn.BLNK;
        String kouhurikzinfokzmeiginmGm = pUiBean.getKouhurikouzainfokzmeiginmkn();

        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        if (kouzaJyouhou == null) {
        }
        else {
            kzhuritourokuhoukbn = kouzaJyouhou.getKzhuritourokuhoukbn();
            kouhurikzinfobankcd = kouzaJyouhou.getBankcd();
            kouhurikzinfositencd = kouzaJyouhou.getSitencd();
            kouhurikzinfoyokin = kouzaJyouhou.getYokinkbn();
            kouhurikzinfokouzano = kouzaJyouhou.getKouzano();
            kouhurikzinfokzkykdoukbn = kouzaJyouhou.getKzkykdoukbn();
            kouhurikzinfokzmeiginm = kouzaJyouhou.getKzmeiginmkn();
            csskakuniniraikbn = kouzaJyouhou.getKouzakakuniniraikbn();
        }

        if (C_KzkykdouKbn.DOUITU.eq(pUiBean.getKouhurikouzainfokzdoukbn())) {
            kouhurikzinfokzmeiginmGm = "";
        }

        String[] KouzaJyouhouGms = new String[]{
            pUiBean.getKzhuritourokuhoukbn().getContent(),
            pUiBean.getKouhurikouzainfobankcd(),
            pUiBean.getKouhurikouzainfositencd(),
            pUiBean.getKouhurikouzainfoyokinkbn().getContent(),
            pUiBean.getKouhurikouzainfokouzano(),
            pUiBean.getKouhurikouzainfokzdoukbn().getContent(),
            kouhurikzinfokzmeiginmGm,
            pUiBean.getKouzakakuniniraikbn().getContent()
        };
        String[] KouzaJyouhouDbs = new String[]{
            kzhuritourokuhoukbn.getContent(),
            kouhurikzinfobankcd,
            kouhurikzinfositencd,
            kouhurikzinfoyokin.getContent(),
            kouhurikzinfokouzano,
            kouhurikzinfokzkykdoukbn.getContent(),
            kouhurikzinfokzmeiginm,
            csskakuniniraikbn.getContent()
        };

        String[] KouzaJyouhouDisps = new String[]{
            DISP_KZHURITOUROKUHOUKBN,
            DISP_KOUHURIKZINFOBANKCD,
            DISP_KOUHURIKZINFOSITENCD,
            DISP_KOUHURIKZINFOYOKINKBN,
            DISP_KOUHURIKZINFOKOUZANO,
            DISP_KOUHURIKZINFOKZKYKDOUKBN,
            DISP_KOUHURIKZINFOKZMEIGINM,
            DISP_CSSKAKUNINIRAIKBN
        };

        String[] KouzaJyouhouKeys = new String[]{
            KZHURITOUROKUHOUKBN,
            KOUHURIKZINFOBANKCD,
            KOUHURIKZINFOSITENCD,
            KOUHURIKZINFOYOKINKBN,
            KOUHURIKZINFOKOUZANO,
            KOUHURIKZINFOKZKYKDOUKBN,
            KOUHURIKZINFOKZMEIGINM,
            CSSKAKUNINIRAIKBN
        };

        for (int index = 0; index < KouzaJyouhouGms.length; index++) {
            String[] hkKouzaJyouhou1Rslts = hntmDtHnkSyr(KouzaJyouhouKeys[index], KouzaJyouhouDbs[index], KouzaJyouhouGms[index]);
            teiseiMaeNaiyou = hkKouzaJyouhou1Rslts[0];
            teiseiGoNaiyou = hkKouzaJyouhou1Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkKouzaJyouhou2Rslts = tsNyHnknSyr(KouzaJyouhouKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkKouzaJyouhou2Rslts[0];
                teiseiGoNaiyou = hkKouzaJyouhou2Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    KouzaJyouhouDisps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
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
            mosKihon.getKykhonninkakninsyoruikbn().getContent(kykhonninKakninsyoruiKbnPtn),
            mosKihon.getSkskknhonninkakninsyoruikbn().getContent(skskknhonninKakninsyoruiKbnPtn),
            mosKihon.getKoureikzksetumeihoukbn().getContent(),
            mosKihon.getKoureimndnhukusuukaikbn().getContent(),
            mosKihon.getKoureitratkisyaigidskkbn().getContent()
        };

        String[] mosKihon6Disps = new String[]{
            DISP_KYKHONNINKAKNINSYORUIKBN,
            DISP_SKSKKNHONNINKAKNINSYORUIKBN,
            DISP_KOUREIKZKSETUMEIHOUKBN,
            DISP_KOUREIMNDNHUKUSUUKAIKBN,
            DISP_KOUREITRATKISYAIGIDSKKBN
        };

        String[] mosKihon6Keys = new String[]{
            KYKHONNINKAKNINSYORUIKBN,
            SKSKKNHONNINKAKNINSYORUIKBN,
            KOUREIKZKSETUMEIHOUKBN,
            KOUREIMNDNHUKUSUUKAIKBN,
            KOUREITRATKISYAIGIDSKKBN
        };

        for (int index = 0; index < mosKihon6Gms.length; index++) {
            String[] hkMosKihon61Rslts = hntmDtHnkSyr(mosKihon6Keys[index], mosKihon6Dbs[index], mosKihon6Gms[index]);
            teiseiMaeNaiyou = hkMosKihon61Rslts[0];
            teiseiGoNaiyou = hkMosKihon61Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon62Rslts = tsNyHnknSyr(mosKihon6Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon62Rslts[0];
                teiseiGoNaiyou = hkMosKihon62Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon6Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] dairiten1Dbs = null;

        String[] dairiten1Gms = new String[]{
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

        String[] dairiten1Disps = new String[]{
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

        String[] dairiten1Keys = new String[]{
            DISPDRTENJIMCD,
            DISPDAIRITENKINYUUKIKANCD,
            DISPDAIRITENKINYUUKIKANSITENCD,
            DISPDAIRITENTORIATUKAIKOUINCD,
            DISPINPUTBOSYUUCD,
            DISPBOSYUUTRKNO,
            DISPGYSKKJSAKISOSIKICD,
            DISPDAIRITENBUNTANWARIAI,
            CIFCD
        };

        dairitenRenNo++;

        if (mosDairiten1 != null) {
            dairiten1Dbs = new String[]{
                mosDairiten1.getJimusyocd(),
                mosDairiten1.getKinyuucd(),
                mosDairiten1.getKinyuusitencd(),
                mosDairiten1.getTratkikouinncd(),
                mosDairiten1.getInputbosyuucd(),
                mosDairiten1.getBosyuutrkno(),
                mosDairiten1.getGyousekikeijyousakisosikicd(),
                zero2Blank(mosDairiten1.getBunwari()),
                mosDairiten1.getCifcd()
            };

            for (int loopCount = 0; loopCount < dairiten1Gms.length; loopCount++) {
                String[] hkDairiten11Rslts = hntmDtHnkSyr(dairiten1Keys[loopCount], dairiten1Dbs[loopCount], dairiten1Gms[loopCount]);

                teiseiMaeNaiyou = hkDairiten11Rslts[0];
                teiseiGoNaiyou = hkDairiten11Rslts[1];

                if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                    hyoujiJyunRenNo++;

                    String[] hkDairiten12Rslts = tsNyHnknSyr(dairiten1Keys[loopCount], teiseiMaeNaiyou, teiseiGoNaiyou);
                    teiseiMaeNaiyou = hkDairiten12Rslts[0];
                    teiseiGoNaiyou = hkDairiten12Rslts[1];

                    tsNyTrkSyr(syoriCTL,
                        mosNo  ,
                        pSysTime,
                        hyoujiJyunRenNo,
                        pKinouId,
                        pKinouModeId,
                        dairiten1Disps[loopCount].concat(String.valueOf(dairitenRenNo)),
                        teiseiMaeNaiyou,
                        teiseiGoNaiyou,
                        pUserId);
                }
            }
        }
        else {
            for (int loopCount = 0; loopCount < dairiten1Gms.length; loopCount++) {
                String[] hkDairiten11Rslts = hntmDtHnkSyr(dairiten1Keys[loopCount], "", dairiten1Gms[loopCount]);
                teiseiMaeNaiyou = hkDairiten11Rslts[0];
                teiseiGoNaiyou = hkDairiten11Rslts[1];

                if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                    hyoujiJyunRenNo++;

                    String[] hkDairiten12Rslts = tsNyHnknSyr(dairiten1Keys[loopCount], teiseiMaeNaiyou, teiseiGoNaiyou);
                    teiseiMaeNaiyou = hkDairiten12Rslts[0];
                    teiseiGoNaiyou = hkDairiten12Rslts[1];

                    tsNyTrkSyr(syoriCTL,
                        mosNo,
                        pSysTime,
                        hyoujiJyunRenNo,
                        pKinouId,
                        pKinouModeId,
                        dairiten1Disps[loopCount].concat(String.valueOf(dairitenRenNo)),
                        teiseiMaeNaiyou,
                        teiseiGoNaiyou,
                        pUserId);
                }
            }
        }

        String[] mosKihon7Gms = new String[]{
            pUiBean.getUktkid()
        };

        String[] mosKihon7Dbs = new String[]{
            mosKihon.getUktkid()
        };

        String[] mosKihon7Disps = new String[]{
            DISP_UKTKID
        };

        String[] mosKihon7Keys = new String[]{
            UKTKID
        };

        for (int index = 0; index < mosKihon7Gms.length; index++) {
            String[] hkMosKihon71Rslts = hntmDtHnkSyr(mosKihon7Keys[index], mosKihon7Dbs[index], mosKihon7Gms[index]);
            teiseiMaeNaiyou = hkMosKihon71Rslts[0];
            teiseiGoNaiyou = hkMosKihon71Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon72Rslts = tsNyHnknSyr(mosKihon7Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon72Rslts[0];
                teiseiGoNaiyou = hkMosKihon72Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon7Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] dairiten2Dbs = null;

        String[] dairiten2Gms = new String[]{
            pUiBean.getDrtenjimcd2(),
            pUiBean.getDairitenkinyuukikancd2(),
            pUiBean.getDairitenkinyuukikansitencd2(),
            pUiBean.getDairitentoriatukaikouincd2(),
            pUiBean.getInputbosyuucd2(),
            pUiBean.getBosyuunintourokuno2(),
            pUiBean.getGyousekikeijyousakisosikicd2()
        };

        String[] dairiten2Disps = new String[]{
            DISP_DISPDRTENJIMCD,
            DISP_DISPDAIRITENKINYUUKIKANCD,
            DISP_DISPDAIRITENKINYUUKIKANSITENCD,
            DISP_DISPDAIRITENTORIATUKAIKOUINCD,
            DISP_DISPINPUTBOSYUUCD,
            DISP_DISPBOSYUUTRKNO,
            DISP_DISPGYSKKJSAKISOSIKICD
        };

        String[] dairiten2Keys = new String[]{
            DISPDRTENJIMCD,
            DISPDAIRITENKINYUUKIKANCD,
            DISPDAIRITENKINYUUKIKANSITENCD,
            DISPDAIRITENTORIATUKAIKOUINCD,
            DISPINPUTBOSYUUCD,
            DISPBOSYUUTRKNO,
            DISPGYSKKJSAKISOSIKICD
        };

        dairitenRenNo++;

        if (mosDairiten2 != null) {
            dairiten2Dbs = new String[]{
                mosDairiten2.getJimusyocd(),
                mosDairiten2.getKinyuucd(),
                mosDairiten2.getKinyuusitencd(),
                mosDairiten2.getTratkikouinncd(),
                mosDairiten2.getInputbosyuucd(),
                mosDairiten2.getBosyuutrkno(),
                mosDairiten2.getGyousekikeijyousakisosikicd()
            };

            for (int loopCount = 0; loopCount < dairiten2Gms.length; loopCount++) {
                String[] hkDairiten21Rslts = hntmDtHnkSyr(dairiten2Keys[loopCount], dairiten2Dbs[loopCount], dairiten2Gms[loopCount]);

                teiseiMaeNaiyou = hkDairiten21Rslts[0];
                teiseiGoNaiyou = hkDairiten21Rslts[1];

                if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                    hyoujiJyunRenNo++;

                    String[] hkDairiten22Rslts = tsNyHnknSyr(dairiten2Keys[loopCount], teiseiMaeNaiyou, teiseiGoNaiyou);
                    teiseiMaeNaiyou = hkDairiten22Rslts[0];
                    teiseiGoNaiyou = hkDairiten22Rslts[1];

                    tsNyTrkSyr(syoriCTL,
                        mosNo  ,
                        pSysTime,
                        hyoujiJyunRenNo,
                        pKinouId,
                        pKinouModeId,
                        dairiten2Disps[loopCount].concat(String.valueOf(dairitenRenNo)),
                        teiseiMaeNaiyou,
                        teiseiGoNaiyou,
                        pUserId);
                }
            }
        }
        else {
            for (int loopCount = 0; loopCount < dairiten2Gms.length; loopCount++) {
                String[] hkDairiten21Rslts = hntmDtHnkSyr(dairiten2Keys[loopCount], "", dairiten2Gms[loopCount]);
                teiseiMaeNaiyou = hkDairiten21Rslts[0];
                teiseiGoNaiyou = hkDairiten21Rslts[1];

                if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                    hyoujiJyunRenNo++;

                    String[] hkDairiten22Rslts = tsNyHnknSyr(dairiten2Keys[loopCount], teiseiMaeNaiyou, teiseiGoNaiyou);
                    teiseiMaeNaiyou = hkDairiten22Rslts[0];
                    teiseiGoNaiyou = hkDairiten22Rslts[1];

                    tsNyTrkSyr(syoriCTL,
                        mosNo,
                        pSysTime,
                        hyoujiJyunRenNo,
                        pKinouId,
                        pKinouModeId,
                        dairiten2Disps[loopCount].concat(String.valueOf(dairitenRenNo)),
                        teiseiMaeNaiyou,
                        teiseiGoNaiyou,
                        pUserId);
                }
            }
        }

        String[] mosKihon8Gms = new String[]{
            pUiBean.getTsryhshrkykumukbn().getContent(),
            pUiBean.getSyosisyatodokeumukbn().getContent(),
            pUiBean.getKakukisyouryakukbumukbn().getContent(),
            pUiBean.getSeiymdmosseitouumukbn().getContent()
        };

        String[] mosKihon8Dbs = new String[]{
            mosKihon.getTsryhshrkykumukbn().getContent(),
            mosKihon.getSyosisyatodokeumukbn().getContent(),
            mosKihon.getKakukisyouryakukbumukbn().getContent(),
            mosKihon.getSeiymdmosseitouumukbn().getContent()
        };

        String[] mosKihon8Disps = new String[]{
            DISP_TSRYHSHRKYKUMUKBN,
            DISP_SYOSISYATODOKEUMUKBN,
            DISP_KAKUKISYOURYAKUKBUMUKBN,
            DISP_SEIYMDMOSSEITOUUMUKBN
        };

        String[] mosKihon8Keys = new String[]{
            TSRYHSHRKYKUMUKBN,
            SYOSISYATODOKEUMUKBN,
            KAKUKISYOURYAKUKBUMUKBN,
            SEIYMDMOSSEITOUUMUKBN
        };

        for (int index = 0; index < mosKihon8Gms.length; index++) {
            String[] hkMosKihon81Rslts = hntmDtHnkSyr(mosKihon8Keys[index], mosKihon8Dbs[index], mosKihon8Gms[index]);
            teiseiMaeNaiyou = hkMosKihon81Rslts[0];
            teiseiGoNaiyou = hkMosKihon81Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon82Rslts = tsNyHnknSyr(mosKihon8Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon82Rslts[0];
                teiseiGoNaiyou = hkMosKihon82Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon8Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] syoriCTLGms = new String[]{
            pUiBean.getTkhsyouryakuumukbn().getContent()
        };

        String[] syoriCTLDbs = new String[]{
            syoriCTL.getTkhsyouryakuumukbn().getContent()
        };

        String[] syoriCTLDisps = new String[]{
            DISP_TKHSYOURYAKUUMUKBN
        };

        String[] syoriCTLKeys = new String[]{
            TKHSYOURYAKUUMUKBN
        };

        for (int index = 0; index < syoriCTLGms.length; index++) {
            String[] hkSyoriCTL1Rslts = hntmDtHnkSyr(syoriCTLKeys[index], syoriCTLDbs[index], syoriCTLGms[index]);
            teiseiMaeNaiyou = hkSyoriCTL1Rslts[0];
            teiseiGoNaiyou = hkSyoriCTL1Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkSyoriCTL2Rslts = tsNyHnknSyr(syoriCTLKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkSyoriCTL2Rslts[0];
                teiseiGoNaiyou = hkSyoriCTL2Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    syoriCTLDisps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }

        String[] mosKihon9Gms = new String[]{
            pUiBean.getKhnchkcmnt()
        };

        String[] mosKihon9Dbs = new String[]{
            mosKihon.getKhnchkcmnt()
        };

        String[] mosKihon9Disps = new String[]{
            DISP_KHNCHKCMNT
        };

        String[] mosKihon9Keys = new String[]{
            KHNCHKCMNT
        };

        for (int index = 0; index < mosKihon9Gms.length; index++) {
            String[] hkMosKihon91Rslts = hntmDtHnkSyr(mosKihon9Keys[index], mosKihon9Dbs[index], mosKihon9Gms[index]);
            teiseiMaeNaiyou = hkMosKihon91Rslts[0];
            teiseiGoNaiyou = hkMosKihon91Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkMosKihon92Rslts = tsNyHnknSyr(mosKihon9Keys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkMosKihon92Rslts[0];
                teiseiGoNaiyou = hkMosKihon92Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    mosKihon9Disps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }
    }

    public void rgstrKokutisyo(TsRrkInfoTourokuRgstrKokutisyoUiBeanParam pUiBean,
        String pSysTime,
        String pKinouId,
        String pKinouModeId,
        String pUserId) {

        int hyoujiJyunRenNo = 0;
        String teiseiMaeNaiyou = "";
        String teiseiGoNaiyou = "";

        String mosNo = pUiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        HT_Kokutisyo kokutisyo = syoriCTL.getKokutisyo();
        if (kokutisyo == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        String[] kokutisyoGms = new String[]{
            editYmd(pUiBean.getKktymd()),
            zero2Blank(pUiBean.getSintyou()),
            zero2Blank(pUiBean.getTaijyuu()),
            pUiBean.getKijikbn().getContent(C_KijiKbn.PATTERN_RADIO),
            pUiBean.getHbcmnt()
        };

        String[] kokutisyoDbs = new String[]{
            editYmd(kokutisyo.getKktymd()),
            zero2Blank(kokutisyo.getSintyou()),
            zero2Blank(kokutisyo.getTaijyuu()),
            kokutisyo.getKijikbn().getContent(C_KijiKbn.PATTERN_RADIO),
            kokutisyo.getHbcmnt()
        };

        String[] kokutisyoDisps = new String[]{
            DISP_KKTYMD,
            DISP_SINTYOU,
            DISP_TAIJYUU,
            DISP_KIJIKBN,
            DISP_HBCMNT
        };
        String[] kokutisyoKeys = new String[]{
            KKTYMD,
            SINTYOU,
            TAIJYUU,
            KIJIKBN,
            HBCMNT
        };

        for (int index = 0; index < kokutisyoGms.length; index++) {
            String[] hkKokutisyo1Rslts = hntmDtHnkSyr(kokutisyoKeys[index], kokutisyoDbs[index], kokutisyoGms[index]);
            teiseiMaeNaiyou = hkKokutisyo1Rslts[0];
            teiseiGoNaiyou = hkKokutisyo1Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkKokutisyo2Rslts = tsNyHnknSyr(kokutisyoKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkKokutisyo2Rslts[0];
                teiseiGoNaiyou = hkKokutisyo2Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    kokutisyoDisps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }
    }

    public void rgstrHoujyou(TsRrkInfoTourokuRgstrHoujyouUiBeanParam pUiBean,
        String pSysTime,
        String pKinouId,
        String pKinouModeId,
        String pUserId) {

        int hyoujiJyunRenNo = 0;
        String teiseiMaeNaiyou = "";
        String teiseiGoNaiyou = "";

        String mosNo = pUiBean.getMosno();
        C_SyosaiKbn syoSaiKbn = pUiBean.getSyosaikbn();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        HT_Houjyou houjyou = syoriCTL.getHoujyouBySyosaikbn(syoSaiKbn);
        if (houjyou == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        String[] houjouSyoGms = new String[]{
            editYmd(pUiBean.getKktymd()),
            zero2Blank(pUiBean.getSintyou()),
            zero2Blank(pUiBean.getTaijyuu()),
            pUiBean.getSinsakbn().getContent(),
            editYmd(pUiBean.getSinsaymd()),
            pUiBean.getHbcmnt()
        };

        String[] houjouSyoDbs = new String[]{
            editYmd(houjyou.getKktymd()),
            zero2Blank(houjyou.getSintyou()),
            zero2Blank(houjyou.getTaijyuu()),
            houjyou.getSinsakbn().getContent(),
            editYmd(houjyou.getSinsaymd()),
            houjyou.getHbcmnt()
        };

        String[] houjouSyoDisps = new String[]{
            DISP_KKTYMD,
            DISP_SINTYOU,
            DISP_TAIJYUU,
            DISP_SINSAKBN,
            DISP_SINSAYMD,
            DISP_HBCMNT
        };

        String[] houjouSyoKeys = new String[]{
            KKTYMD,
            SINTYOU,
            TAIJYUU,
            SINSAKBN,
            SINSAYMD,
            HBCMNT
        };

        String[] houjouSaiGms = new String[]{
            pUiBean.getSinsakbn().getContent(),
            editYmd(pUiBean.getSinsaymd()),
            pUiBean.getHbcmnt()
        };

        String[] houjouSaiDbs = new String[]{
            houjyou.getSinsakbn().getContent(),
            editYmd(houjyou.getSinsaymd()),
            houjyou.getHbcmnt()
        };

        String[] houjouSaiDisps = new String[]{
            DISP_SINSAKBN,
            DISP_SINSAYMD,
            DISP_HBCMNT
        };

        String[] houjouSaiKeys = new String[]{
            SINSAKBN,
            SINSAYMD,
            HBCMNT
        };

        String[] houjouGms = null;
        String[] houjouDbs = null;
        String[] houjouDisps = null;
        String[] houjouKeys = null;

        if (C_SyosaiKbn.SOYSIN.eq(syoSaiKbn)) {
            houjouGms = houjouSyoGms;
            houjouDbs = houjouSyoDbs;
            houjouDisps = houjouSyoDisps;
            houjouKeys = houjouSyoKeys;
        }
        else {
            houjouGms = houjouSaiGms;
            houjouDbs = houjouSaiDbs;
            houjouDisps = houjouSaiDisps;
            houjouKeys = houjouSaiKeys;
        }

        for (int index = 0; index < houjouGms.length; index++) {
            String[] hkHoujou1Rslts = hntmDtHnkSyr(houjouKeys[index], houjouDbs[index], houjouGms[index]);
            teiseiMaeNaiyou = hkHoujou1Rslts[0];
            teiseiGoNaiyou = hkHoujou1Rslts[1];

            if (!teiseiMaeNaiyou.equals(teiseiGoNaiyou)) {
                hyoujiJyunRenNo++;

                String[] hkHoujou2Rslts = tsNyHnknSyr(houjouKeys[index], teiseiMaeNaiyou, teiseiGoNaiyou);
                teiseiMaeNaiyou = hkHoujou2Rslts[0];
                teiseiGoNaiyou = hkHoujou2Rslts[1];

                tsNyTrkSyr(syoriCTL,
                    mosNo,
                    pSysTime,
                    hyoujiJyunRenNo,
                    pKinouId,
                    pKinouModeId,
                    houjouDisps[index],
                    teiseiMaeNaiyou,
                    teiseiGoNaiyou,
                    pUserId);
            }
        }
    }

    private String[] hntmDtHnkSyr(String pItem,
        String pDBValue,
        String pInput) {

        String[] results = new String[]{ "", "" };

        if (pItem.equals(HBCMNT) || pItem.equals(KHNCHKCMNT)) {
            if (BizUtil.isBlank(pDBValue)) {
                results[0] = "入力なし";
            }
            else {
                results[0] = "入力あり";
            }

            if (BizUtil.isBlank(pInput)) {
                results[1] = "入力なし";
            }
            else {
                results[1] = "入力あり";
            }
            return results;
        }

        results[0] = pDBValue;
        results[1] = pInput;

        return results;
    }

    private String[] tsNyHnknSyr(String pItem,
        String pTeiseiMaeNy,
        String pTeiseiGoNy) {
        String[] results = new String[]{ "", "" };

        for (int count = 0; count < dateItems.length; count++) {
            if (pItem.equals(dateItems[count])) {
                results[0] = DateFormatUtil.dateDOTNoEx(pTeiseiMaeNy);
                results[1] = DateFormatUtil.dateDOTNoEx(pTeiseiGoNy);
                return results;
            }
        }

        for (int count = 0; count < warekiHenkanItems.length; count++) {
            if (pItem.equals(warekiHenkanItems[count])) {
                results[0] = DateFormatUtil.dateDOTWarekiNoEx(pTeiseiMaeNy);
                results[1] = DateFormatUtil.dateDOTWarekiNoEx(pTeiseiGoNy);
                return results;
            }
        }


        results[0] = pTeiseiMaeNy;
        results[1] = pTeiseiGoNy;
        return results;
    }

    private void tsNyTrkSyr(HT_SyoriCTL syoriCTL,
        String pMosNo,
        String pSysTime,
        int pHyjJynRen,
        String pKinouId,
        String pKinouModeId,
        String pItem,
        String pTsMaeNaiyo,
        String pTsGoNaiyo,
        String pUserId) {

        if (BizUtil.isBlank(pTsMaeNaiyo) && BizUtil.isBlank(pTsGoNaiyo)) {
            return;
        }

        HT_KmTsRireki kmTsRireki = syoriCTL.createKmTsRireki();

        kmTsRireki.setSyoriTime(pSysTime);
        kmTsRireki.setRenno3keta(pHyjJynRen);
        kmTsRireki.setKinouId(pKinouId);
        kmTsRireki.setKinouModeId(pKinouModeId);
        kmTsRireki.setTskmnm(pItem);
        kmTsRireki.setTsmaenaiyou(pTsMaeNaiyo);
        kmTsRireki.setTsgonaiyou(pTsGoNaiyo);
        kmTsRireki.setTantid(pUserId);
        kmTsRireki.setGyoumuKousinsyaId(pUserId);
        kmTsRireki.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(kmTsRireki);
    }

    //  2016/03/08 S社導入：コメントアウト
    //    private TreeMap<Integer, HashMap<String, String>> sortMousikomisyo(TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam pUiBean) {
    //
    //        TreeMap<Integer, HashMap<String, String>> sortedMap = new TreeMap<>();
    //
    //        String[] tkSyouhnCds = new String[] {
    //                pUiBean.getTksyouhncd1(),
    //                pUiBean.getTksyouhncd2(),
    //                pUiBean.getTksyouhncd3(),
    //                pUiBean.getTksyouhncd4(),
    //                pUiBean.getTksyouhncd5(),
    //                pUiBean.getTksyouhncd6(),
    //                pUiBean.getTksyouhncd7(),
    //                pUiBean.getTksyouhncd8(),
    //                pUiBean.getTksyouhncd9(),
    //                pUiBean.getTksyouhncd10()
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
    //        for (int index = 0; index < tkSyouhnCds.length; index++) {
    //            if (!BizUtil.isBlank(tkSyouhnCds[index])) {
    //                HashMap<String, String> gmInfoMp = new HashMap<>();
    //                gmInfoMp.put(DISPTKSYOUHNCD, tkSyouhnCds[index]);
    //                gmInfoMp.put(DISPTKKATAKBN, tkKataKbns[index]);
    //                gmInfoMp.put(DISPTKKYHKATAKBN, tkKyhkataKbns[index]);
    //                gmInfoMp.put(DISPTKKIHONS, tkKihonSs[index]);
    //                gmInfoMp.put(DISPTKHKNKKN, tkHknkkns[index]);
    //                gmInfoMp.put(DISPTKHKNKKNSMNKBN, tkHknkknSmnKbns[index]);
    //                gmInfoMp.put(DISPTKHRKKKN, tkHrkkkns[index]);
    //                gmInfoMp.put(DISPTKHRKKKNSMNKBN, tKHrkkknSmnKbns[index]);
    //
    //                List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd(tkSyouhnCds[index]);
    //                Integer syouhnSortNo = syouhnZokuseiLst.get(0).getSyohnsortno();
    //
    //                sortedMap.put(syouhnSortNo, gmInfoMp);
    //            }
    //        }
    //
    //        return sortedMap;
    //    }

    private Map<String, String[]> getMousikomisyoSbUkt(TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam pUiBean) {

        String[] sbUktKbns = new String[] {
            pUiBean.getSibouuktkbn1().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
            pUiBean.getSibouuktkbn2().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
            pUiBean.getSibouuktkbn3().getContent(C_UktKbn.PATTERN_SKSIBOUUKT),
            pUiBean.getSibouuktkbn4().getContent(C_UktKbn.PATTERN_SKSIBOUUKT)
        };

        String[] sbUktNmKns = new String[] {
            pUiBean.getSibouuktnmkana1(),
            pUiBean.getSibouuktnmkana2(),
            pUiBean.getSibouuktnmkana3(),
            pUiBean.getSibouuktnmkana4()
        };

        String[] sbUktNmKjs = new String[] {
            pUiBean.getSibouuktnmkanji1(),
            pUiBean.getSibouuktnmkanji2(),
            pUiBean.getSibouuktnmkanji3(),
            pUiBean.getSibouuktnmkanji4()
        };

        String[] sbUktNmKanjikahukaKbns = new String[] {
            pUiBean.getSibouuktnmkanjikahukakbn1().getContent(),
            pUiBean.getSibouuktnmkanjikahukakbn2().getContent(),
            pUiBean.getSibouuktnmkanjikahukakbn3().getContent(),
            pUiBean.getSibouuktnmkanjikahukakbn4().getContent()
        };

        String[] sbUktSeiYmds = new String[] {
            editYmd(pUiBean.getSibouuktseiymd1()),
            editYmd(pUiBean.getSibouuktseiymd2()),
            editYmd(pUiBean.getSibouuktseiymd3()),
            editYmd(pUiBean.getSibouuktseiymd4())
        };

        String[] sbUktTdks = new String[] {
            pUiBean.getSibouukttdk1().getContent(C_Tdk.PATTERN_SBUKT),
            pUiBean.getSibouukttdk2().getContent(C_Tdk.PATTERN_SBUKT),
            pUiBean.getSibouukttdk3().getContent(C_Tdk.PATTERN_SBUKT),
            pUiBean.getSibouukttdk4().getContent(C_Tdk.PATTERN_SBUKT)
        };

        String[] sbUktSeiBnwaris = new String[] {
            zero2Blank(pUiBean.getSibouuktbnwari1()),
            zero2Blank(pUiBean.getSibouuktbnwari2()),
            zero2Blank(pUiBean.getSibouuktbnwari3()),
            zero2Blank(pUiBean.getSibouuktbnwari4())
        };

        Map<String, String[]> resultMp = new HashMap<>();
        resultMp.put(DISPSBUKTKBN, sbUktKbns);
        resultMp.put(DISPSBUKTNMKN, sbUktNmKns);
        resultMp.put(DISPSBUKTNMKJ, sbUktNmKjs);
        resultMp.put(DISPSBUKTNMKJHUKAKBN, sbUktNmKanjikahukaKbns);
        resultMp.put(DISPSBUKTSEIYMD, sbUktSeiYmds);
        resultMp.put(DISPSBUKTTDK, sbUktTdks);
        resultMp.put(DISPSBUKTBNWARI, sbUktSeiBnwaris);

        return resultMp;
    }

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
}