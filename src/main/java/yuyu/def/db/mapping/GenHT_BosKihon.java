package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kykymdtkrumu;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_PmnjtkhukaKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.id.PKHT_BosKihon;
import yuyu.def.db.meta.GenQHT_BosKihon;
import yuyu.def.db.meta.QHT_BosKihon;
import yuyu.def.db.type.UserType_C_AeoisnsiKbn;
import yuyu.def.db.type.UserType_C_BikkjnssinfoKbn;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_DirectServiceMosKbn;
import yuyu.def.db.type.UserType_C_DsSyomenTtdkHyouji;
import yuyu.def.db.type.UserType_C_FatcasnsiKbn;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HjndaiykKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KoureiKzkSetumeiHouKbn;
import yuyu.def.db.type.UserType_C_KoureiMndnHukusuukaiKbn;
import yuyu.def.db.type.UserType_C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.db.type.UserType_C_KoureisyaTaiouKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Kykymdtkrumu;
import yuyu.def.db.type.UserType_C_KzktourokuserviceTourokuKbn;
import yuyu.def.db.type.UserType_C_Livhukaumu;
import yuyu.def.db.type.UserType_C_MobilebosyuuKbn;
import yuyu.def.db.type.UserType_C_MosTourokuJyoukyouKbn;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_NkgnsHosyourituKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_PmnjtkhukaKbn;
import yuyu.def.db.type.UserType_C_PplessrendoucreditkousouKbn;
import yuyu.def.db.type.UserType_C_PplessrendoukouhurikousouKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_TargetTkKbn;
import yuyu.def.db.type.UserType_C_TargetTkMokuhyoutiKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_TumitatekinHaibunWariKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;
import yuyu.def.db.type.UserType_C_YnkHrkmgkAnniTuutiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 募集基本テーブル テーブルのマッピング情報クラスで、 {@link HT_BosKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKihon}</td><td colspan="3">募集基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_BosKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAitemosno aitemosno}</td><td>相手申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDoujikaiyakusyono doujikaiyakusyono}</td><td>同時解約証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSekno sekno}</td><td>設計書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosuketukekbn mosuketukekbn}</td><td>申込受付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MosUketukeKbn}</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMossakuseiymd mossakuseiymd}</td><td>申込書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPplessmosukeymd pplessmosukeymd}</td><td>ペーパーレス申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPykkigenymd pykkigenymd}</td><td>保険料有効期限年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMoscalckijyunymd moscalckijyunymd}</td><td>申込書計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymdtkrumu kykymdtkrumu}</td><td>契約日特例有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykymdtkrumu}</td></tr>
 *  <tr><td>{@link #getSkykymd skykymd}</td><td>指定契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkjkhukakbn hhknnmkjkhukakbn}</td><td>被保険者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnensyuukbn hhknnensyuukbn}</td><td>被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getTsindousiteikbn tsindousiteikbn}</td><td>通信先同一指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 *  <tr><td>{@link #getHhknyno hhknyno}</td><td>被保険者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr1kj hhknadr1kj}</td><td>被保険者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr2kj hhknadr2kj}</td><td>被保険者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr3kj hhknadr3kj}</td><td>被保険者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntelno hhkntelno}</td><td>被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknkinmusakinm hhknkinmusakinm}</td><td>被保険者勤務先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkjkhukakbn kyknmkjkhukakbn}</td><td>契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getKyktdk kyktdk}</td><td>契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKyknensyuukbn kyknensyuukbn}</td><td>契約者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getKykkinmusakinm kykkinmusakinm}</td><td>契約者勤務先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndaiykkbn hjndaiykkbn}</td><td>法人代表者役職区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HjndaiykKbn}</td></tr>
 *  <tr><td>{@link #getHjndainmkn hjndainmkn}</td><td>法人代表者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndainmkj hjndainmkj}</td><td>法人代表者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakkanjyuryouhoukbn yakkanjyuryouhoukbn}</td><td>約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>{@link #getYakkanbunsyono yakkanbunsyono}</td><td>約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFatcasnsikbn fatcasnsikbn}</td><td>ＦＡＴＣＡ宣誓区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcasnsiKbn}</td></tr>
 *  <tr><td>{@link #getBikkjnssinfokbn bikkjnssinfokbn}</td><td>米国人示唆情報区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BikkjnssinfoKbn}</td></tr>
 *  <tr><td>{@link #getAeoisnsikbn aeoisnsikbn}</td><td>ＡＥＯＩ宣誓区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoisnsiKbn}</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getHknsyuruinosd hknsyuruinosd}</td><td>保険種類番号世代</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkgnshosyouritukbn nkgnshosyouritukbn}</td><td>年金原資最低保証率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkgnsHosyourituKbn}</td></tr>
 *  <tr><td>{@link #getLivhukaumu livhukaumu}</td><td>リビングニーズ付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Livhukaumu}</td></tr>
 *  <tr><td>{@link #getPmnjtkhukakbn pmnjtkhukakbn}</td><td>保険料免除特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkhukaKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getKzktourokuservicetourokukbn kzktourokuservicetourokukbn}</td><td>ご家族登録サービス登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzktourokuserviceTourokuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukakbn kykdrtkykhukakbn}</td><td>契約者代理特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkkbn stdrsktkyhkkbn}</td><td>被保険者代理特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getYennykntkhkkbn yennykntkhkkbn}</td><td>円入金特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getGaikanykntkhkkbn gaikanykntkhkkbn}</td><td>外貨入金特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getYenshrtkhkkbn yenshrtkhkkbn}</td><td>円支払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getMosheijyunp mosheijyunp}</td><td>申込平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIkkatubaraikbn ikkatubaraikbn}</td><td>一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatubaraikaisuu ikkatubaraikaisuu}</td><td>一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>{@link #getMosikkatup mosikkatup}</td><td>申込一括払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyutkpkei syutkpkei}</td><td>主契約・特約Ｐ合計金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getFsthrkpkei fsthrkpkei}</td><td>初回払込Ｐ合計金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getFstphrkkeirokbn fstphrkkeirokbn}</td><td>初回保険料払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>{@link #getZennoumousideumu zennoumousideumu}</td><td>前納申出有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZenkizennouumu zenkizennouumu}</td><td>全期前納有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getZnnkai znnkai}</td><td>前納回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMoszennoupsyokaiari moszennoupsyokaiari}</td><td>申込前納Ｐ（初回含）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTargettkhkkbn targettkhkkbn}</td><td>ターゲット特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getTargettkkbn targettkkbn}</td><td>ターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkKbn}</td></tr>
 *  <tr><td>{@link #getTargettkmkhtkbn targettkmkhtkbn}</td><td>ターゲット特約目標値区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkMokuhyoutiKbn}</td></tr>
 *  <tr><td>{@link #getNstkhkkbn nstkhkkbn}</td><td>年金支払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getNstkmnknsyu nstkmnknsyu}</td><td>年金支払特約満期年金種類</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNstkmnknkkn nstkmnknkkn}</td><td>年金支払特約満期年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNstksbnsyu nstksbnsyu}</td><td>年金支払特約死亡年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNstksbnkkn nstksbnkkn}</td><td>年金支払特約死亡年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyksbyensitihsyutkhkkbn syksbyensitihsyutkhkkbn}</td><td>初期死亡時円換算最低保証特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getJyudkaigomehrtkhkkbn jyudkaigomehrtkhkkbn}</td><td>重度介護前払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getKjnnkpzeitekitkhukakbn kjnnkpzeitekitkhukakbn}</td><td>個人年金保険料税制適格特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getTeikisiharaitkykhkkbn teikisiharaitkykhkkbn}</td><td>定期支払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykhonninkakninsyoruikbn kykhonninkakninsyoruikbn}</td><td>契約者本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getSkskknhonninkakninsyoruikbn skskknhonninkakninsyoruikbn}</td><td>親権者後見人本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getKoureikzksetumeihoukbn koureikzksetumeihoukbn}</td><td>高齢者ご家族等説明方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureiKzkSetumeiHouKbn}</td></tr>
 *  <tr><td>{@link #getKoureimndnhukusuukaikbn koureimndnhukusuukaikbn}</td><td>高齢者面談複数回実施区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureiMndnHukusuukaiKbn}</td></tr>
 *  <tr><td>{@link #getKoureitratkisyaigidskkbn koureitratkisyaigidskkbn}</td><td>高齢者取扱者以外同席区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureiTratkisyaIgiDskKbn}</td></tr>
 *  <tr><td>{@link #getDaihituumukbn daihituumukbn}</td><td>代筆有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getUktkid uktkid}</td><td>受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrctservicemoskbn drctservicemoskbn}</td><td>ダイレクトサービス申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DirectServiceMosKbn}</td></tr>
 *  <tr><td>{@link #getDsmailaddress dsmailaddress}</td><td>ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokuteitrhkansyono tokuteitrhkansyono}</td><td>特定取引用暗証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPplessrenjidssymenttdkhyj pplessrenjidssymenttdkhyj}</td><td>ペーパーレス連動時ＤＳ書面手続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSyomenTtdkHyouji}</td></tr>
 *  <tr><td>{@link #getPplsrendoukouhurikousoukbn pplsrendoukouhurikousoukbn}</td><td>ペーパーレス連動時口振申込書後送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PplessrendoukouhurikousouKbn}</td></tr>
 *  <tr><td>{@link #getPplessrendoucreditkousoukbn pplessrendoucreditkousoukbn}</td><td>ペーパーレス連動時クレカ申込書後送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PplessrendoucreditkousouKbn}</td></tr>
 *  <tr><td>{@link #getYnkhrkmgkannituutikbn ynkhrkmgkannituutikbn}</td><td>円貨払込額案内通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YnkHrkmgkAnniTuutiKbn}</td></tr>
 *  <tr><td>{@link #getHnsstjmmouumukbn hnsstjmmouumukbn}</td><td>本社集中事務申込有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKjmeigihkhunouumukbn kjmeigihkhunouumukbn}</td><td>漢字名義変換不能有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsryhshrkykumukbn tsryhshrkykumukbn}</td><td>手数料不支払契約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyosisyatodokeumukbn syosisyatodokeumukbn}</td><td>証券支社届有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKakukisyouryakukbumukbn kakukisyouryakukbumukbn}</td><td>カク基省略希望有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSeiymdmosseitouumukbn seiymdmosseitouumukbn}</td><td>生年月日申込書正当有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIkokakninsyotokkijkumu ikokakninsyotokkijkumu}</td><td>意向確認書特記事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTrtkhoukokusyotokkijkumu trtkhoukokusyotokkijkumu}</td><td>取扱報告書特記事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHnnkakninhskjikouumukbn hnnkakninhskjikouumukbn}</td><td>本人確認補足事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHnnkakninhsktkjikouumukbn hnnkakninhsktkjikouumukbn}</td><td>本人確認補足特定事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSkskakninhsktkjikouumukbn skskakninhsktkjikouumukbn}</td><td>親権者確認補足特定事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKhnchkcmnt khnchkcmnt}</td><td>基本チェックコメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMostourokujyoukyoukbn mostourokujyoukyoukbn}</td><td>申込情報登録状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MosTourokuJyoukyouKbn}</td></tr>
 *  <tr><td>{@link #getPplessdatasousinumukbn pplessdatasousinumukbn}</td><td>ペーパーレスデータ送信有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMobilebosyuukbn mobilebosyuukbn}</td><td>モバイル募集区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MobilebosyuuKbn}</td></tr>
 *  <tr><td>{@link #getTeirituhaibunwarikbn teirituhaibunwarikbn}</td><td>定率部分配分割合区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getSisuuhaibunwarikbn sisuuhaibunwarikbn}</td><td>指数部分配分割合区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>{@link #getTrhkjikakkbn trhkjikakkbn}</td><td>取引時確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>{@link #getKoureitaioukbn koureitaioukbn}</td><td>高齢者対応区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureisyaTaiouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKihon
 * @see     PKHT_BosKihon
 * @see     QHT_BosKihon
 * @see     GenQHT_BosKihon
 */
@MappedSuperclass
@Table(name=GenHT_BosKihon.TABLE_NAME)
@IdClass(value=PKHT_BosKihon.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AeoisnsiKbn", typeClass=UserType_C_AeoisnsiKbn.class),
    @TypeDef(name="UserType_C_BikkjnssinfoKbn", typeClass=UserType_C_BikkjnssinfoKbn.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_DirectServiceMosKbn", typeClass=UserType_C_DirectServiceMosKbn.class),
    @TypeDef(name="UserType_C_DsSyomenTtdkHyouji", typeClass=UserType_C_DsSyomenTtdkHyouji.class),
    @TypeDef(name="UserType_C_FatcasnsiKbn", typeClass=UserType_C_FatcasnsiKbn.class),
    @TypeDef(name="UserType_C_FstphrkkeiroKbn", typeClass=UserType_C_FstphrkkeiroKbn.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HjndaiykKbn", typeClass=UserType_C_HjndaiykKbn.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_HonninkakuninSyoruiKbn", typeClass=UserType_C_HonninkakuninSyoruiKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_IkkatubaraiKaisuuKbn", typeClass=UserType_C_IkkatubaraiKaisuuKbn.class),
    @TypeDef(name="UserType_C_IkkatubaraiKbn", typeClass=UserType_C_IkkatubaraiKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_KoureiKzkSetumeiHouKbn", typeClass=UserType_C_KoureiKzkSetumeiHouKbn.class),
    @TypeDef(name="UserType_C_KoureiMndnHukusuukaiKbn", typeClass=UserType_C_KoureiMndnHukusuukaiKbn.class),
    @TypeDef(name="UserType_C_KoureiTratkisyaIgiDskKbn", typeClass=UserType_C_KoureiTratkisyaIgiDskKbn.class),
    @TypeDef(name="UserType_C_KoureisyaTaiouKbn", typeClass=UserType_C_KoureisyaTaiouKbn.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_Kykymdtkrumu", typeClass=UserType_C_Kykymdtkrumu.class),
    @TypeDef(name="UserType_C_KzktourokuserviceTourokuKbn", typeClass=UserType_C_KzktourokuserviceTourokuKbn.class),
    @TypeDef(name="UserType_C_Livhukaumu", typeClass=UserType_C_Livhukaumu.class),
    @TypeDef(name="UserType_C_MobilebosyuuKbn", typeClass=UserType_C_MobilebosyuuKbn.class),
    @TypeDef(name="UserType_C_MosTourokuJyoukyouKbn", typeClass=UserType_C_MosTourokuJyoukyouKbn.class),
    @TypeDef(name="UserType_C_MosUketukeKbn", typeClass=UserType_C_MosUketukeKbn.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class),
    @TypeDef(name="UserType_C_NkgnsHosyourituKbn", typeClass=UserType_C_NkgnsHosyourituKbn.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_PmnjtkhukaKbn", typeClass=UserType_C_PmnjtkhukaKbn.class),
    @TypeDef(name="UserType_C_PplessrendoucreditkousouKbn", typeClass=UserType_C_PplessrendoucreditkousouKbn.class),
    @TypeDef(name="UserType_C_PplessrendoukouhurikousouKbn", typeClass=UserType_C_PplessrendoukouhurikousouKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_TargetTkKbn", typeClass=UserType_C_TargetTkKbn.class),
    @TypeDef(name="UserType_C_TargetTkMokuhyoutiKbn", typeClass=UserType_C_TargetTkMokuhyoutiKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_Tkhukaumu", typeClass=UserType_C_Tkhukaumu.class),
    @TypeDef(name="UserType_C_TrhkjiKakKbn", typeClass=UserType_C_TrhkjiKakKbn.class),
    @TypeDef(name="UserType_C_TsindousiteiKbn", typeClass=UserType_C_TsindousiteiKbn.class),
    @TypeDef(name="UserType_C_TumitatekinHaibunWariKbn", typeClass=UserType_C_TumitatekinHaibunWariKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YakkanJyuryouKbn", typeClass=UserType_C_YakkanJyuryouKbn.class),
    @TypeDef(name="UserType_C_YnkHrkmgkAnniTuutiKbn", typeClass=UserType_C_YnkHrkmgkAnniTuutiKbn.class)
})
public abstract class GenHT_BosKihon extends AbstractExDBEntity<HT_BosKihon, PKHT_BosKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_BosKihon";
    public static final String MOSNO                    = "mosno";
    public static final String AITEMOSNO                = "aitemosno";
    public static final String DOUJIKAIYAKUSYONO        = "doujikaiyakusyono";
    public static final String SEKNO                    = "sekno";
    public static final String MOSUKETUKEKBN            = "mosuketukekbn";
    public static final String MOSYMD                   = "mosymd";
    public static final String MOSSAKUSEIYMD            = "mossakuseiymd";
    public static final String PPLESSMOSUKEYMD          = "pplessmosukeymd";
    public static final String PYKKIGENYMD              = "pykkigenymd";
    public static final String KKTYMD                   = "kktymd";
    public static final String MOSCALCKIJYUNYMD         = "moscalckijyunymd";
    public static final String KYKYMDTKRUMU             = "kykymdtkrumu";
    public static final String SKYKYMD                  = "skykymd";
    public static final String KYKKBN                   = "kykkbn";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKJKHUKAKBN         = "hhknnmkjkhukakbn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String HHKNNENSYUUKBN           = "hhknnensyuukbn";
    public static final String TSINDOUSITEIKBN          = "tsindousiteikbn";
    public static final String HHKNYNO                  = "hhknyno";
    public static final String HHKNADR1KJ               = "hhknadr1kj";
    public static final String HHKNADR2KJ               = "hhknadr2kj";
    public static final String HHKNADR3KJ               = "hhknadr3kj";
    public static final String HHKNTELNO                = "hhkntelno";
    public static final String HHKNKINMUSAKINM          = "hhknkinmusakinm";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKJKHUKAKBN          = "kyknmkjkhukakbn";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKNEN                   = "kyknen";
    public static final String KYKSEI                   = "kyksei";
    public static final String KYKTDK                   = "kyktdk";
    public static final String KYKNENSYUUKBN            = "kyknensyuukbn";
    public static final String KYKKINMUSAKINM           = "kykkinmusakinm";
    public static final String HJNDAIYKKBN              = "hjndaiykkbn";
    public static final String HJNDAINMKN               = "hjndainmkn";
    public static final String HJNDAINMKJ               = "hjndainmkj";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String YAKKANJYURYOUHOUKBN      = "yakkanjyuryouhoukbn";
    public static final String YAKKANBUNSYONO           = "yakkanbunsyono";
    public static final String FATCASNSIKBN             = "fatcasnsikbn";
    public static final String BIKKJNSSINFOKBN          = "bikkjnssinfokbn";
    public static final String AEOISNSIKBN              = "aeoisnsikbn";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String HKNSYURUINOSD            = "hknsyuruinosd";
    public static final String NKGNSHOSYOURITUKBN       = "nkgnshosyouritukbn";
    public static final String LIVHUKAUMU               = "livhukaumu";
    public static final String PMNJTKHUKAKBN            = "pmnjtkhukakbn";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String KZKTOUROKUSERVICETOUROKUKBN = "kzktourokuservicetourokukbn";
    public static final String KYKDRTKYKHUKAKBN         = "kykdrtkykhukakbn";
    public static final String STDRSKTKYHKKBN           = "stdrsktkyhkkbn";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String YENNYKNTKHKKBN           = "yennykntkhkkbn";
    public static final String GAIKANYKNTKHKKBN         = "gaikanykntkhkkbn";
    public static final String YENSHRTKHKKBN            = "yenshrtkhkkbn";
    public static final String MOSHEIJYUNP              = "mosheijyunp";
    public static final String IKKATUBARAIKBN           = "ikkatubaraikbn";
    public static final String IKKATUBARAIKAISUU        = "ikkatubaraikaisuu";
    public static final String MOSIKKATUP               = "mosikkatup";
    public static final String SYUTKPKEI                = "syutkpkei";
    public static final String FSTHRKPKEI               = "fsthrkpkei";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String FSTPHRKKEIROKBN          = "fstphrkkeirokbn";
    public static final String ZENNOUMOUSIDEUMU         = "zennoumousideumu";
    public static final String ZENKIZENNOUUMU           = "zenkizennouumu";
    public static final String ZNNKAI                   = "znnkai";
    public static final String MOSZENNOUPSYOKAIARI      = "moszennoupsyokaiari";
    public static final String TARGETTKHKKBN            = "targettkhkkbn";
    public static final String TARGETTKKBN              = "targettkkbn";
    public static final String TARGETTKMKHTKBN          = "targettkmkhtkbn";
    public static final String NSTKHKKBN                = "nstkhkkbn";
    public static final String NSTKMNKNSYU              = "nstkmnknsyu";
    public static final String NSTKMNKNKKN              = "nstkmnknkkn";
    public static final String NSTKSBNSYU               = "nstksbnsyu";
    public static final String NSTKSBNKKN               = "nstksbnkkn";
    public static final String SYKSBYENSITIHSYUTKHKKBN  = "syksbyensitihsyutkhkkbn";
    public static final String JYUDKAIGOMEHRTKHKKBN     = "jyudkaigomehrtkhkkbn";
    public static final String KJNNKPZEITEKITKHUKAKBN   = "kjnnkpzeitekitkhukakbn";
    public static final String TEIKISIHARAITKYKHKKBN    = "teikisiharaitkykhkkbn";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String KYKHONNINKAKNINSYORUIKBN = "kykhonninkakninsyoruikbn";
    public static final String SKSKKNHONNINKAKNINSYORUIKBN = "skskknhonninkakninsyoruikbn";
    public static final String KOUREIKZKSETUMEIHOUKBN   = "koureikzksetumeihoukbn";
    public static final String KOUREIMNDNHUKUSUUKAIKBN  = "koureimndnhukusuukaikbn";
    public static final String KOUREITRATKISYAIGIDSKKBN = "koureitratkisyaigidskkbn";
    public static final String DAIHITUUMUKBN            = "daihituumukbn";
    public static final String UKTKID                   = "uktkid";
    public static final String DRCTSERVICEMOSKBN        = "drctservicemoskbn";
    public static final String DSMAILADDRESS            = "dsmailaddress";
    public static final String TOKUTEITRHKANSYONO       = "tokuteitrhkansyono";
    public static final String PPLESSRENJIDSSYMENTTDKHYJ = "pplessrenjidssymenttdkhyj";
    public static final String PPLSRENDOUKOUHURIKOUSOUKBN = "pplsrendoukouhurikousoukbn";
    public static final String PPLESSRENDOUCREDITKOUSOUKBN = "pplessrendoucreditkousoukbn";
    public static final String YNKHRKMGKANNITUUTIKBN    = "ynkhrkmgkannituutikbn";
    public static final String HNSSTJMMOUUMUKBN         = "hnsstjmmouumukbn";
    public static final String KJMEIGIHKHUNOUUMUKBN     = "kjmeigihkhunouumukbn";
    public static final String TSRYHSHRKYKUMUKBN        = "tsryhshrkykumukbn";
    public static final String SYOSISYATODOKEUMUKBN     = "syosisyatodokeumukbn";
    public static final String KAKUKISYOURYAKUKBUMUKBN  = "kakukisyouryakukbumukbn";
    public static final String SEIYMDMOSSEITOUUMUKBN    = "seiymdmosseitouumukbn";
    public static final String IKOKAKNINSYOTOKKIJKUMU   = "ikokakninsyotokkijkumu";
    public static final String TRTKHOUKOKUSYOTOKKIJKUMU = "trtkhoukokusyotokkijkumu";
    public static final String HNNKAKNINHSKJIKOUUMUKBN  = "hnnkakninhskjikouumukbn";
    public static final String HNNKAKNINHSKTKJIKOUUMUKBN = "hnnkakninhsktkjikouumukbn";
    public static final String SKSKAKNINHSKTKJIKOUUMUKBN = "skskakninhsktkjikouumukbn";
    public static final String KHNCHKCMNT               = "khnchkcmnt";
    public static final String MOSTOUROKUJYOUKYOUKBN    = "mostourokujyoukyoukbn";
    public static final String PPLESSDATASOUSINUMUKBN   = "pplessdatasousinumukbn";
    public static final String MOBILEBOSYUUKBN          = "mobilebosyuukbn";
    public static final String TEIRITUHAIBUNWARIKBN     = "teirituhaibunwarikbn";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String SISUUHAIBUNWARIKBN       = "sisuuhaibunwarikbn";
    public static final String TRHKJIKAKKBN             = "trhkjikakkbn";
    public static final String KOUREITAIOUKBN           = "koureitaioukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_BosKihon primaryKey;

    public GenHT_BosKihon() {
        primaryKey = new PKHT_BosKihon();
    }

    public GenHT_BosKihon(String pMosno) {
        primaryKey = new PKHT_BosKihon(pMosno);
    }

    @Transient
    @Override
    public PKHT_BosKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_BosKihon> getMetaClass() {
        return QHT_BosKihon.class;
    }

    @Id
    @Column(name=GenHT_BosKihon.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String aitemosno;

    @Column(name=GenHT_BosKihon.AITEMOSNO)
    @MousikomiNo
    public String getAitemosno() {
        return aitemosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitemosno(String pAitemosno) {
        aitemosno = pAitemosno;
    }

    private String doujikaiyakusyono;

    @Column(name=GenHT_BosKihon.DOUJIKAIYAKUSYONO)
    @SyoukenNo
    public String getDoujikaiyakusyono() {
        return doujikaiyakusyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDoujikaiyakusyono(String pDoujikaiyakusyono) {
        doujikaiyakusyono = pDoujikaiyakusyono;
    }

    private String sekno;

    @Column(name=GenHT_BosKihon.SEKNO)
    @MaxLength(max=20)
    @AlphaDigit
    public String getSekno() {
        return sekno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSekno(String pSekno) {
        sekno = pSekno;
    }

    private C_MosUketukeKbn mosuketukekbn;

    @Type(type="UserType_C_MosUketukeKbn")
    @Column(name=GenHT_BosKihon.MOSUKETUKEKBN)
    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate mossakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.MOSSAKUSEIYMD)
    @ValidDate
    public BizDate getMossakuseiymd() {
        return mossakuseiymd;
    }

    @Trim("both")
    public void setMossakuseiymd(BizDate pMossakuseiymd) {
        mossakuseiymd = pMossakuseiymd;
    }

    private BizDate pplessmosukeymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.PPLESSMOSUKEYMD)
    @ValidDate
    public BizDate getPplessmosukeymd() {
        return pplessmosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPplessmosukeymd(BizDate pPplessmosukeymd) {
        pplessmosukeymd = pPplessmosukeymd;
    }

    private BizDate pykkigenymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.PYKKIGENYMD)
    @ValidDate
    public BizDate getPykkigenymd() {
        return pykkigenymd;
    }

    public void setPykkigenymd(BizDate pPykkigenymd) {
        pykkigenymd = pPykkigenymd;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private BizDate moscalckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.MOSCALCKIJYUNYMD)
    @ValidDate
    public BizDate getMoscalckijyunymd() {
        return moscalckijyunymd;
    }

    public void setMoscalckijyunymd(BizDate pMoscalckijyunymd) {
        moscalckijyunymd = pMoscalckijyunymd;
    }

    private C_Kykymdtkrumu kykymdtkrumu;

    @Type(type="UserType_C_Kykymdtkrumu")
    @Column(name=GenHT_BosKihon.KYKYMDTKRUMU)
    public C_Kykymdtkrumu getKykymdtkrumu() {
        return kykymdtkrumu;
    }

    public void setKykymdtkrumu(C_Kykymdtkrumu pKykymdtkrumu) {
        kykymdtkrumu = pKykymdtkrumu;
    }

    private BizDate skykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.SKYKYMD)
    @ValidDate
    public BizDate getSkykymd() {
        return skykymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkykymd(BizDate pSkykymd) {
        skykymd = pSkykymd;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenHT_BosKihon.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private String hhknnmkn;

    @Column(name=GenHT_BosKihon.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenHT_BosKihon.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_KjkhukaKbn hhknnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenHT_BosKihon.HHKNNMKJKHUKAKBN)
    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private Integer hhknnen;

    @Column(name=GenHT_BosKihon.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenHT_BosKihon.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknsykgycd;

    @Column(name=GenHT_BosKihon.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenHT_BosKihon.HHKNNENSYUUKBN)
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private C_TsindousiteiKbn tsindousiteikbn;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenHT_BosKihon.TSINDOUSITEIKBN)
    public C_TsindousiteiKbn getTsindousiteikbn() {
        return tsindousiteikbn;
    }

    public void setTsindousiteikbn(C_TsindousiteiKbn pTsindousiteikbn) {
        tsindousiteikbn = pTsindousiteikbn;
    }

    private String hhknyno;

    @Column(name=GenHT_BosKihon.HHKNYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getHhknyno() {
        return hhknyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    private String hhknadr1kj;

    @Column(name=GenHT_BosKihon.HHKNADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    private String hhknadr2kj;

    @Column(name=GenHT_BosKihon.HHKNADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    private String hhknadr3kj;

    @Column(name=GenHT_BosKihon.HHKNADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    private String hhkntelno;

    @Column(name=GenHT_BosKihon.HHKNTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getHhkntelno() {
        return hhkntelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    private String hhknkinmusakinm;

    @Column(name=GenHT_BosKihon.HHKNKINMUSAKINM)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknkinmusakinm() {
        return hhknkinmusakinm;
    }

    public void setHhknkinmusakinm(String pHhknkinmusakinm) {
        hhknkinmusakinm = pHhknkinmusakinm;
    }

    private String kyknmkn;

    @Column(name=GenHT_BosKihon.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenHT_BosKihon.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private C_KjkhukaKbn kyknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenHT_BosKihon.KYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_BosKihon.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private Integer kyknen;

    @Column(name=GenHT_BosKihon.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenHT_BosKihon.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private C_Tdk kyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenHT_BosKihon.KYKTDK)
    public C_Tdk getKyktdk() {
        return kyktdk;
    }

    public void setKyktdk(C_Tdk pKyktdk) {
        kyktdk = pKyktdk;
    }

    private C_NensyuuKbn kyknensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenHT_BosKihon.KYKNENSYUUKBN)
    public C_NensyuuKbn getKyknensyuukbn() {
        return kyknensyuukbn;
    }

    public void setKyknensyuukbn(C_NensyuuKbn pKyknensyuukbn) {
        kyknensyuukbn = pKyknensyuukbn;
    }

    private String kykkinmusakinm;

    @Column(name=GenHT_BosKihon.KYKKINMUSAKINM)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykkinmusakinm() {
        return kykkinmusakinm;
    }

    public void setKykkinmusakinm(String pKykkinmusakinm) {
        kykkinmusakinm = pKykkinmusakinm;
    }

    private C_HjndaiykKbn hjndaiykkbn;

    @Type(type="UserType_C_HjndaiykKbn")
    @Column(name=GenHT_BosKihon.HJNDAIYKKBN)
    public C_HjndaiykKbn getHjndaiykkbn() {
        return hjndaiykkbn;
    }

    public void setHjndaiykkbn(C_HjndaiykKbn pHjndaiykkbn) {
        hjndaiykkbn = pHjndaiykkbn;
    }

    private String hjndainmkn;

    @Column(name=GenHT_BosKihon.HJNDAINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndainmkn() {
        return hjndainmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkn(String pHjndainmkn) {
        hjndainmkn = pHjndainmkn;
    }

    private String hjndainmkj;

    @Column(name=GenHT_BosKihon.HJNDAINMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndainmkj() {
        return hjndainmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkj(String pHjndainmkj) {
        hjndainmkj = pHjndainmkj;
    }

    private String tsinyno;

    @Column(name=GenHT_BosKihon.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenHT_BosKihon.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenHT_BosKihon.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenHT_BosKihon.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String tsintelno;

    @Column(name=GenHT_BosKihon.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String dai2tsintelno;

    @Column(name=GenHT_BosKihon.DAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;

    @Type(type="UserType_C_YakkanJyuryouKbn")
    @Column(name=GenHT_BosKihon.YAKKANJYURYOUHOUKBN)
    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn pYakkanjyuryouhoukbn) {
        yakkanjyuryouhoukbn = pYakkanjyuryouhoukbn;
    }

    private String yakkanbunsyono;

    @Column(name=GenHT_BosKihon.YAKKANBUNSYONO)
    public String getYakkanbunsyono() {
        return yakkanbunsyono;
    }

    public void setYakkanbunsyono(String pYakkanbunsyono) {
        yakkanbunsyono = pYakkanbunsyono;
    }

    private C_FatcasnsiKbn fatcasnsikbn;

    @Type(type="UserType_C_FatcasnsiKbn")
    @Column(name=GenHT_BosKihon.FATCASNSIKBN)
    public C_FatcasnsiKbn getFatcasnsikbn() {
        return fatcasnsikbn;
    }

    public void setFatcasnsikbn(C_FatcasnsiKbn pFatcasnsikbn) {
        fatcasnsikbn = pFatcasnsikbn;
    }

    private C_BikkjnssinfoKbn bikkjnssinfokbn;

    @Type(type="UserType_C_BikkjnssinfoKbn")
    @Column(name=GenHT_BosKihon.BIKKJNSSINFOKBN)
    public C_BikkjnssinfoKbn getBikkjnssinfokbn() {
        return bikkjnssinfokbn;
    }

    public void setBikkjnssinfokbn(C_BikkjnssinfoKbn pBikkjnssinfokbn) {
        bikkjnssinfokbn = pBikkjnssinfokbn;
    }

    private C_AeoisnsiKbn aeoisnsikbn;

    @Type(type="UserType_C_AeoisnsiKbn")
    @Column(name=GenHT_BosKihon.AEOISNSIKBN)
    public C_AeoisnsiKbn getAeoisnsikbn() {
        return aeoisnsikbn;
    }

    public void setAeoisnsikbn(C_AeoisnsiKbn pAeoisnsikbn) {
        aeoisnsikbn = pAeoisnsikbn;
    }

    private C_HknsyuruiNo hknsyuruino;

    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHT_BosKihon.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }

    private Integer hknsyuruinosd;

    @Column(name=GenHT_BosKihon.HKNSYURUINOSD)
    public Integer getHknsyuruinosd() {
        return hknsyuruinosd;
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        hknsyuruinosd = pHknsyuruinosd;
    }

    private C_NkgnsHosyourituKbn nkgnshosyouritukbn;

    @Type(type="UserType_C_NkgnsHosyourituKbn")
    @Column(name=GenHT_BosKihon.NKGNSHOSYOURITUKBN)
    public C_NkgnsHosyourituKbn getNkgnshosyouritukbn() {
        return nkgnshosyouritukbn;
    }

    public void setNkgnshosyouritukbn(C_NkgnsHosyourituKbn pNkgnshosyouritukbn) {
        nkgnshosyouritukbn = pNkgnshosyouritukbn;
    }

    private C_Livhukaumu livhukaumu;

    @Type(type="UserType_C_Livhukaumu")
    @Column(name=GenHT_BosKihon.LIVHUKAUMU)
    public C_Livhukaumu getLivhukaumu() {
        return livhukaumu;
    }

    public void setLivhukaumu(C_Livhukaumu pLivhukaumu) {
        livhukaumu = pLivhukaumu;
    }

    private C_PmnjtkhukaKbn pmnjtkhukakbn;

    @Type(type="UserType_C_PmnjtkhukaKbn")
    @Column(name=GenHT_BosKihon.PMNJTKHUKAKBN)
    public C_PmnjtkhukaKbn getPmnjtkhukakbn() {
        return pmnjtkhukakbn;
    }

    public void setPmnjtkhukakbn(C_PmnjtkhukaKbn pPmnjtkhukakbn) {
        pmnjtkhukakbn = pPmnjtkhukakbn;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenHT_BosKihon.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private C_KzktourokuserviceTourokuKbn kzktourokuservicetourokukbn;

    @Type(type="UserType_C_KzktourokuserviceTourokuKbn")
    @Column(name=GenHT_BosKihon.KZKTOUROKUSERVICETOUROKUKBN)
    public C_KzktourokuserviceTourokuKbn getKzktourokuservicetourokukbn() {
        return kzktourokuservicetourokukbn;
    }

    public void setKzktourokuservicetourokukbn(C_KzktourokuserviceTourokuKbn pKzktourokuservicetourokukbn) {
        kzktourokuservicetourokukbn = pKzktourokuservicetourokukbn;
    }

    private C_Tkhukaumu kykdrtkykhukakbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.KYKDRTKYKHUKAKBN)
    public C_Tkhukaumu getKykdrtkykhukakbn() {
        return kykdrtkykhukakbn;
    }

    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn) {
        kykdrtkykhukakbn = pKykdrtkykhukakbn;
    }

    private C_Tkhukaumu stdrsktkyhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.STDRSKTKYHKKBN)
    public C_Tkhukaumu getStdrsktkyhkkbn() {
        return stdrsktkyhkkbn;
    }

    public void setStdrsktkyhkkbn(C_Tkhukaumu pStdrsktkyhkkbn) {
        stdrsktkyhkkbn = pStdrsktkyhkkbn;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenHT_BosKihon.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenHT_BosKihon.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenHT_BosKihon.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenHT_BosKihon.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_BosKihon.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_BosKihon.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    private C_Tkhukaumu yennykntkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.YENNYKNTKHKKBN)
    public C_Tkhukaumu getYennykntkhkkbn() {
        return yennykntkhkkbn;
    }

    public void setYennykntkhkkbn(C_Tkhukaumu pYennykntkhkkbn) {
        yennykntkhkkbn = pYennykntkhkkbn;
    }

    private C_Tkhukaumu gaikanykntkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.GAIKANYKNTKHKKBN)
    public C_Tkhukaumu getGaikanykntkhkkbn() {
        return gaikanykntkhkkbn;
    }

    public void setGaikanykntkhkkbn(C_Tkhukaumu pGaikanykntkhkkbn) {
        gaikanykntkhkkbn = pGaikanykntkhkkbn;
    }

    private C_Tkhukaumu yenshrtkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.YENSHRTKHKKBN)
    public C_Tkhukaumu getYenshrtkhkkbn() {
        return yenshrtkhkkbn;
    }

    public void setYenshrtkhkkbn(C_Tkhukaumu pYenshrtkhkkbn) {
        yenshrtkhkkbn = pYenshrtkhkkbn;
    }

    private BizCurrency mosheijyunp;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosheijyunp() {
        return mosheijyunp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosheijyunp(BizCurrency pMosheijyunp) {
        mosheijyunp = pMosheijyunp;
        mosheijyunpValue = null;
        mosheijyunpType  = null;
    }

    transient private BigDecimal mosheijyunpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSHEIJYUNP, nullable=true)
    protected BigDecimal getMosheijyunpValue() {
        if (mosheijyunpValue == null && mosheijyunp != null) {
            if (mosheijyunp.isOptional()) return null;
            return mosheijyunp.absolute();
        }
        return mosheijyunpValue;
    }

    protected void setMosheijyunpValue(BigDecimal value) {
        mosheijyunpValue = value;
        mosheijyunp = Optional.fromNullable(toCurrencyType(mosheijyunpType))
            .transform(bizCurrencyTransformer(getMosheijyunpValue()))
            .orNull();
    }

    transient private String mosheijyunpType = null;

    @Column(name=MOSHEIJYUNP + "$", nullable=true)
    protected String getMosheijyunpType() {
        if (mosheijyunpType == null && mosheijyunp != null) return mosheijyunp.getType().toString();
        if (mosheijyunpType == null && getMosheijyunpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosheijyunp$' should not be NULL."));
        }
        return mosheijyunpType;
    }

    protected void setMosheijyunpType(String type) {
        mosheijyunpType = type;
        mosheijyunp = Optional.fromNullable(toCurrencyType(mosheijyunpType))
            .transform(bizCurrencyTransformer(getMosheijyunpValue()))
            .orNull();
    }

    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Type(type="UserType_C_IkkatubaraiKbn")
    @Column(name=GenHT_BosKihon.IKKATUBARAIKBN)
    public C_IkkatubaraiKbn getIkkatubaraikbn() {
        return ikkatubaraikbn;
    }

    public void setIkkatubaraikbn(C_IkkatubaraiKbn pIkkatubaraikbn) {
        ikkatubaraikbn = pIkkatubaraikbn;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Type(type="UserType_C_IkkatubaraiKaisuuKbn")
    @Column(name=GenHT_BosKihon.IKKATUBARAIKAISUU)
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private BizCurrency mosikkatup;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosikkatup() {
        return mosikkatup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosikkatup(BizCurrency pMosikkatup) {
        mosikkatup = pMosikkatup;
        mosikkatupValue = null;
        mosikkatupType  = null;
    }

    transient private BigDecimal mosikkatupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSIKKATUP, nullable=true)
    protected BigDecimal getMosikkatupValue() {
        if (mosikkatupValue == null && mosikkatup != null) {
            if (mosikkatup.isOptional()) return null;
            return mosikkatup.absolute();
        }
        return mosikkatupValue;
    }

    protected void setMosikkatupValue(BigDecimal value) {
        mosikkatupValue = value;
        mosikkatup = Optional.fromNullable(toCurrencyType(mosikkatupType))
            .transform(bizCurrencyTransformer(getMosikkatupValue()))
            .orNull();
    }

    transient private String mosikkatupType = null;

    @Column(name=MOSIKKATUP + "$", nullable=true)
    protected String getMosikkatupType() {
        if (mosikkatupType == null && mosikkatup != null) return mosikkatup.getType().toString();
        if (mosikkatupType == null && getMosikkatupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosikkatup$' should not be NULL."));
        }
        return mosikkatupType;
    }

    protected void setMosikkatupType(String type) {
        mosikkatupType = type;
        mosikkatup = Optional.fromNullable(toCurrencyType(mosikkatupType))
            .transform(bizCurrencyTransformer(getMosikkatupValue()))
            .orNull();
    }

    private BizCurrency syutkpkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyutkpkei() {
        return syutkpkei;
    }

    public void setSyutkpkei(BizCurrency pSyutkpkei) {
        syutkpkei = pSyutkpkei;
        syutkpkeiValue = null;
        syutkpkeiType  = null;
    }

    transient private BigDecimal syutkpkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUTKPKEI, nullable=true)
    protected BigDecimal getSyutkpkeiValue() {
        if (syutkpkeiValue == null && syutkpkei != null) {
            if (syutkpkei.isOptional()) return null;
            return syutkpkei.absolute();
        }
        return syutkpkeiValue;
    }

    protected void setSyutkpkeiValue(BigDecimal value) {
        syutkpkeiValue = value;
        syutkpkei = Optional.fromNullable(toCurrencyType(syutkpkeiType))
            .transform(bizCurrencyTransformer(getSyutkpkeiValue()))
            .orNull();
    }

    transient private String syutkpkeiType = null;

    @Column(name=SYUTKPKEI + "$", nullable=true)
    protected String getSyutkpkeiType() {
        if (syutkpkeiType == null && syutkpkei != null) return syutkpkei.getType().toString();
        if (syutkpkeiType == null && getSyutkpkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syutkpkei$' should not be NULL."));
        }
        return syutkpkeiType;
    }

    protected void setSyutkpkeiType(String type) {
        syutkpkeiType = type;
        syutkpkei = Optional.fromNullable(toCurrencyType(syutkpkeiType))
            .transform(bizCurrencyTransformer(getSyutkpkeiValue()))
            .orNull();
    }

    private BizCurrency fsthrkpkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getFsthrkpkei() {
        return fsthrkpkei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFsthrkpkei(BizCurrency pFsthrkpkei) {
        fsthrkpkei = pFsthrkpkei;
        fsthrkpkeiValue = null;
        fsthrkpkeiType  = null;
    }

    transient private BigDecimal fsthrkpkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=FSTHRKPKEI, nullable=true)
    protected BigDecimal getFsthrkpkeiValue() {
        if (fsthrkpkeiValue == null && fsthrkpkei != null) {
            if (fsthrkpkei.isOptional()) return null;
            return fsthrkpkei.absolute();
        }
        return fsthrkpkeiValue;
    }

    protected void setFsthrkpkeiValue(BigDecimal value) {
        fsthrkpkeiValue = value;
        fsthrkpkei = Optional.fromNullable(toCurrencyType(fsthrkpkeiType))
            .transform(bizCurrencyTransformer(getFsthrkpkeiValue()))
            .orNull();
    }

    transient private String fsthrkpkeiType = null;

    @Column(name=FSTHRKPKEI + "$", nullable=true)
    protected String getFsthrkpkeiType() {
        if (fsthrkpkeiType == null && fsthrkpkei != null) return fsthrkpkei.getType().toString();
        if (fsthrkpkeiType == null && getFsthrkpkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'fsthrkpkei$' should not be NULL."));
        }
        return fsthrkpkeiType;
    }

    protected void setFsthrkpkeiType(String type) {
        fsthrkpkeiType = type;
        fsthrkpkei = Optional.fromNullable(toCurrencyType(fsthrkpkeiType))
            .transform(bizCurrencyTransformer(getFsthrkpkeiValue()))
            .orNull();
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenHT_BosKihon.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenHT_BosKihon.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    @Type(type="UserType_C_FstphrkkeiroKbn")
    @Column(name=GenHT_BosKihon.FSTPHRKKEIROKBN)
    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private C_UmuKbn zennoumousideumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.ZENNOUMOUSIDEUMU)
    public C_UmuKbn getZennoumousideumu() {
        return zennoumousideumu;
    }

    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu) {
        zennoumousideumu = pZennoumousideumu;
    }

    private C_BlnktkumuKbn zenkizennouumu;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_BosKihon.ZENKIZENNOUUMU)
    public C_BlnktkumuKbn getZenkizennouumu() {
        return zenkizennouumu;
    }

    public void setZenkizennouumu(C_BlnktkumuKbn pZenkizennouumu) {
        zenkizennouumu = pZenkizennouumu;
    }

    private Integer znnkai;

    @Column(name=GenHT_BosKihon.ZNNKAI)
    @Range(min="0", max="999")
    public Integer getZnnkai() {
        return znnkai;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnkai(Integer pZnnkai) {
        znnkai = pZnnkai;
    }

    private BizCurrency moszennoupsyokaiari;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMoszennoupsyokaiari() {
        return moszennoupsyokaiari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari(BizCurrency pMoszennoupsyokaiari) {
        moszennoupsyokaiari = pMoszennoupsyokaiari;
        moszennoupsyokaiariValue = null;
        moszennoupsyokaiariType  = null;
    }

    transient private BigDecimal moszennoupsyokaiariValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSZENNOUPSYOKAIARI, nullable=true)
    protected BigDecimal getMoszennoupsyokaiariValue() {
        if (moszennoupsyokaiariValue == null && moszennoupsyokaiari != null) {
            if (moszennoupsyokaiari.isOptional()) return null;
            return moszennoupsyokaiari.absolute();
        }
        return moszennoupsyokaiariValue;
    }

    protected void setMoszennoupsyokaiariValue(BigDecimal value) {
        moszennoupsyokaiariValue = value;
        moszennoupsyokaiari = Optional.fromNullable(toCurrencyType(moszennoupsyokaiariType))
            .transform(bizCurrencyTransformer(getMoszennoupsyokaiariValue()))
            .orNull();
    }

    transient private String moszennoupsyokaiariType = null;

    @Column(name=MOSZENNOUPSYOKAIARI + "$", nullable=true)
    protected String getMoszennoupsyokaiariType() {
        if (moszennoupsyokaiariType == null && moszennoupsyokaiari != null) return moszennoupsyokaiari.getType().toString();
        if (moszennoupsyokaiariType == null && getMoszennoupsyokaiariValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'moszennoupsyokaiari$' should not be NULL."));
        }
        return moszennoupsyokaiariType;
    }

    protected void setMoszennoupsyokaiariType(String type) {
        moszennoupsyokaiariType = type;
        moszennoupsyokaiari = Optional.fromNullable(toCurrencyType(moszennoupsyokaiariType))
            .transform(bizCurrencyTransformer(getMoszennoupsyokaiariValue()))
            .orNull();
    }

    private C_Tkhukaumu targettkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.TARGETTKHKKBN)
    public C_Tkhukaumu getTargettkhkkbn() {
        return targettkhkkbn;
    }

    public void setTargettkhkkbn(C_Tkhukaumu pTargettkhkkbn) {
        targettkhkkbn = pTargettkhkkbn;
    }

    private C_TargetTkKbn targettkkbn;

    @Type(type="UserType_C_TargetTkKbn")
    @Column(name=GenHT_BosKihon.TARGETTKKBN)
    public C_TargetTkKbn getTargettkkbn() {
        return targettkkbn;
    }

    public void setTargettkkbn(C_TargetTkKbn pTargettkkbn) {
        targettkkbn = pTargettkkbn;
    }

    private C_TargetTkMokuhyoutiKbn targettkmkhtkbn;

    @Type(type="UserType_C_TargetTkMokuhyoutiKbn")
    @Column(name=GenHT_BosKihon.TARGETTKMKHTKBN)
    public C_TargetTkMokuhyoutiKbn getTargettkmkhtkbn() {
        return targettkmkhtkbn;
    }

    public void setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn pTargettkmkhtkbn) {
        targettkmkhtkbn = pTargettkmkhtkbn;
    }

    private C_Tkhukaumu nstkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.NSTKHKKBN)
    public C_Tkhukaumu getNstkhkkbn() {
        return nstkhkkbn;
    }

    public void setNstkhkkbn(C_Tkhukaumu pNstkhkkbn) {
        nstkhkkbn = pNstkhkkbn;
    }

    private Integer nstkmnknsyu;

    @Column(name=GenHT_BosKihon.NSTKMNKNSYU)
    public Integer getNstkmnknsyu() {
        return nstkmnknsyu;
    }

    public void setNstkmnknsyu(Integer pNstkmnknsyu) {
        nstkmnknsyu = pNstkmnknsyu;
    }

    private Integer nstkmnknkkn;

    @Column(name=GenHT_BosKihon.NSTKMNKNKKN)
    @Range(min="0", max="99")
    public Integer getNstkmnknkkn() {
        return nstkmnknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstkmnknkkn(Integer pNstkmnknkkn) {
        nstkmnknkkn = pNstkmnknkkn;
    }

    private C_Nstknsyu nstksbnsyu;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenHT_BosKihon.NSTKSBNSYU)
    public C_Nstknsyu getNstksbnsyu() {
        return nstksbnsyu;
    }

    public void setNstksbnsyu(C_Nstknsyu pNstksbnsyu) {
        nstksbnsyu = pNstksbnsyu;
    }

    private Integer nstksbnkkn;

    @Column(name=GenHT_BosKihon.NSTKSBNKKN)
    @Range(min="0", max="99")
    public Integer getNstksbnkkn() {
        return nstksbnkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstksbnkkn(Integer pNstksbnkkn) {
        nstksbnkkn = pNstksbnkkn;
    }

    private C_Tkhukaumu syksbyensitihsyutkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.SYKSBYENSITIHSYUTKHKKBN)
    public C_Tkhukaumu getSyksbyensitihsyutkhkkbn() {
        return syksbyensitihsyutkhkkbn;
    }

    public void setSyksbyensitihsyutkhkkbn(C_Tkhukaumu pSyksbyensitihsyutkhkkbn) {
        syksbyensitihsyutkhkkbn = pSyksbyensitihsyutkhkkbn;
    }

    private C_Tkhukaumu jyudkaigomehrtkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.JYUDKAIGOMEHRTKHKKBN)
    public C_Tkhukaumu getJyudkaigomehrtkhkkbn() {
        return jyudkaigomehrtkhkkbn;
    }

    public void setJyudkaigomehrtkhkkbn(C_Tkhukaumu pJyudkaigomehrtkhkkbn) {
        jyudkaigomehrtkhkkbn = pJyudkaigomehrtkhkkbn;
    }

    private C_Tkhukaumu kjnnkpzeitekitkhukakbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.KJNNKPZEITEKITKHUKAKBN)
    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn() {
        return kjnnkpzeitekitkhukakbn;
    }

    public void setKjnnkpzeitekitkhukakbn(C_Tkhukaumu pKjnnkpzeitekitkhukakbn) {
        kjnnkpzeitekitkhukakbn = pKjnnkpzeitekitkhukakbn;
    }

    private C_Tkhukaumu teikisiharaitkykhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_BosKihon.TEIKISIHARAITKYKHKKBN)
    public C_Tkhukaumu getTeikisiharaitkykhkkbn() {
        return teikisiharaitkykhkkbn;
    }

    public void setTeikisiharaitkykhkkbn(C_Tkhukaumu pTeikisiharaitkykhkkbn) {
        teikisiharaitkykhkkbn = pTeikisiharaitkykhkkbn;
    }

    private Integer sbuktnin;

    @Column(name=GenHT_BosKihon.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenHT_BosKihon.KYKHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenHT_BosKihon.SKSKKNHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn() {
        return skskknhonninkakninsyoruikbn;
    }

    public void setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pSkskknhonninkakninsyoruikbn) {
        skskknhonninkakninsyoruikbn = pSkskknhonninkakninsyoruikbn;
    }

    private C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn;

    @Type(type="UserType_C_KoureiKzkSetumeiHouKbn")
    @Column(name=GenHT_BosKihon.KOUREIKZKSETUMEIHOUKBN)
    public C_KoureiKzkSetumeiHouKbn getKoureikzksetumeihoukbn() {
        return koureikzksetumeihoukbn;
    }

    public void setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn pKoureikzksetumeihoukbn) {
        koureikzksetumeihoukbn = pKoureikzksetumeihoukbn;
    }

    private C_KoureiMndnHukusuukaiKbn koureimndnhukusuukaikbn;

    @Type(type="UserType_C_KoureiMndnHukusuukaiKbn")
    @Column(name=GenHT_BosKihon.KOUREIMNDNHUKUSUUKAIKBN)
    public C_KoureiMndnHukusuukaiKbn getKoureimndnhukusuukaikbn() {
        return koureimndnhukusuukaikbn;
    }

    public void setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn pKoureimndnhukusuukaikbn) {
        koureimndnhukusuukaikbn = pKoureimndnhukusuukaikbn;
    }

    private C_KoureiTratkisyaIgiDskKbn koureitratkisyaigidskkbn;

    @Type(type="UserType_C_KoureiTratkisyaIgiDskKbn")
    @Column(name=GenHT_BosKihon.KOUREITRATKISYAIGIDSKKBN)
    public C_KoureiTratkisyaIgiDskKbn getKoureitratkisyaigidskkbn() {
        return koureitratkisyaigidskkbn;
    }

    public void setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn pKoureitratkisyaigidskkbn) {
        koureitratkisyaigidskkbn = pKoureitratkisyaigidskkbn;
    }

    private C_UmuKbn daihituumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.DAIHITUUMUKBN)
    public C_UmuKbn getDaihituumukbn() {
        return daihituumukbn;
    }

    public void setDaihituumukbn(C_UmuKbn pDaihituumukbn) {
        daihituumukbn = pDaihituumukbn;
    }

    private String uktkid;

    @Column(name=GenHT_BosKihon.UKTKID)
    @Length(length=11)
    @AlphaDigit
    @HostInvalidCharacter
    public String getUktkid() {
        return uktkid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktkid(String pUktkid) {
        uktkid = pUktkid;
    }

    private C_DirectServiceMosKbn drctservicemoskbn;

    @Type(type="UserType_C_DirectServiceMosKbn")
    @Column(name=GenHT_BosKihon.DRCTSERVICEMOSKBN)
    public C_DirectServiceMosKbn getDrctservicemoskbn() {
        return drctservicemoskbn;
    }

    public void setDrctservicemoskbn(C_DirectServiceMosKbn pDrctservicemoskbn) {
        drctservicemoskbn = pDrctservicemoskbn;
    }

    private String dsmailaddress;

    @Column(name=GenHT_BosKihon.DSMAILADDRESS)
    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    public String getDsmailaddress() {
        return dsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailaddress(String pDsmailaddress) {
        dsmailaddress = pDsmailaddress;
    }

    private String tokuteitrhkansyono;

    @Column(name=GenHT_BosKihon.TOKUTEITRHKANSYONO)
    public String getTokuteitrhkansyono() {
        return tokuteitrhkansyono;
    }

    public void setTokuteitrhkansyono(String pTokuteitrhkansyono) {
        tokuteitrhkansyono = pTokuteitrhkansyono;
    }

    private C_DsSyomenTtdkHyouji pplessrenjidssymenttdkhyj;

    @Type(type="UserType_C_DsSyomenTtdkHyouji")
    @Column(name=GenHT_BosKihon.PPLESSRENJIDSSYMENTTDKHYJ)
    public C_DsSyomenTtdkHyouji getPplessrenjidssymenttdkhyj() {
        return pplessrenjidssymenttdkhyj;
    }

    public void setPplessrenjidssymenttdkhyj(C_DsSyomenTtdkHyouji pPplessrenjidssymenttdkhyj) {
        pplessrenjidssymenttdkhyj = pPplessrenjidssymenttdkhyj;
    }

    private C_PplessrendoukouhurikousouKbn pplsrendoukouhurikousoukbn;

    @Type(type="UserType_C_PplessrendoukouhurikousouKbn")
    @Column(name=GenHT_BosKihon.PPLSRENDOUKOUHURIKOUSOUKBN)
    public C_PplessrendoukouhurikousouKbn getPplsrendoukouhurikousoukbn() {
        return pplsrendoukouhurikousoukbn;
    }

    public void setPplsrendoukouhurikousoukbn(C_PplessrendoukouhurikousouKbn pPplsrendoukouhurikousoukbn) {
        pplsrendoukouhurikousoukbn = pPplsrendoukouhurikousoukbn;
    }

    private C_PplessrendoucreditkousouKbn pplessrendoucreditkousoukbn;

    @Type(type="UserType_C_PplessrendoucreditkousouKbn")
    @Column(name=GenHT_BosKihon.PPLESSRENDOUCREDITKOUSOUKBN)
    public C_PplessrendoucreditkousouKbn getPplessrendoucreditkousoukbn() {
        return pplessrendoucreditkousoukbn;
    }

    public void setPplessrendoucreditkousoukbn(C_PplessrendoucreditkousouKbn pPplessrendoucreditkousoukbn) {
        pplessrendoucreditkousoukbn = pPplessrendoucreditkousoukbn;
    }

    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;

    @Type(type="UserType_C_YnkHrkmgkAnniTuutiKbn")
    @Column(name=GenHT_BosKihon.YNKHRKMGKANNITUUTIKBN)
    public C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn() {
        return ynkhrkmgkannituutikbn;
    }

    public void setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn pYnkhrkmgkannituutikbn) {
        ynkhrkmgkannituutikbn = pYnkhrkmgkannituutikbn;
    }

    private C_UmuKbn hnsstjmmouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.HNSSTJMMOUUMUKBN)
    public C_UmuKbn getHnsstjmmouumukbn() {
        return hnsstjmmouumukbn;
    }

    public void setHnsstjmmouumukbn(C_UmuKbn pHnsstjmmouumukbn) {
        hnsstjmmouumukbn = pHnsstjmmouumukbn;
    }

    private C_UmuKbn kjmeigihkhunouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.KJMEIGIHKHUNOUUMUKBN)
    public C_UmuKbn getKjmeigihkhunouumukbn() {
        return kjmeigihkhunouumukbn;
    }

    public void setKjmeigihkhunouumukbn(C_UmuKbn pKjmeigihkhunouumukbn) {
        kjmeigihkhunouumukbn = pKjmeigihkhunouumukbn;
    }

    private C_UmuKbn tsryhshrkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.TSRYHSHRKYKUMUKBN)
    public C_UmuKbn getTsryhshrkykumukbn() {
        return tsryhshrkykumukbn;
    }

    public void setTsryhshrkykumukbn(C_UmuKbn pTsryhshrkykumukbn) {
        tsryhshrkykumukbn = pTsryhshrkykumukbn;
    }

    private C_UmuKbn syosisyatodokeumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.SYOSISYATODOKEUMUKBN)
    public C_UmuKbn getSyosisyatodokeumukbn() {
        return syosisyatodokeumukbn;
    }

    public void setSyosisyatodokeumukbn(C_UmuKbn pSyosisyatodokeumukbn) {
        syosisyatodokeumukbn = pSyosisyatodokeumukbn;
    }

    private C_UmuKbn kakukisyouryakukbumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.KAKUKISYOURYAKUKBUMUKBN)
    public C_UmuKbn getKakukisyouryakukbumukbn() {
        return kakukisyouryakukbumukbn;
    }

    public void setKakukisyouryakukbumukbn(C_UmuKbn pKakukisyouryakukbumukbn) {
        kakukisyouryakukbumukbn = pKakukisyouryakukbumukbn;
    }

    private C_UmuKbn seiymdmosseitouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.SEIYMDMOSSEITOUUMUKBN)
    public C_UmuKbn getSeiymdmosseitouumukbn() {
        return seiymdmosseitouumukbn;
    }

    public void setSeiymdmosseitouumukbn(C_UmuKbn pSeiymdmosseitouumukbn) {
        seiymdmosseitouumukbn = pSeiymdmosseitouumukbn;
    }

    private C_UmuKbn ikokakninsyotokkijkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.IKOKAKNINSYOTOKKIJKUMU)
    public C_UmuKbn getIkokakninsyotokkijkumu() {
        return ikokakninsyotokkijkumu;
    }

    public void setIkokakninsyotokkijkumu(C_UmuKbn pIkokakninsyotokkijkumu) {
        ikokakninsyotokkijkumu = pIkokakninsyotokkijkumu;
    }

    private C_UmuKbn trtkhoukokusyotokkijkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.TRTKHOUKOKUSYOTOKKIJKUMU)
    public C_UmuKbn getTrtkhoukokusyotokkijkumu() {
        return trtkhoukokusyotokkijkumu;
    }

    public void setTrtkhoukokusyotokkijkumu(C_UmuKbn pTrtkhoukokusyotokkijkumu) {
        trtkhoukokusyotokkijkumu = pTrtkhoukokusyotokkijkumu;
    }

    private C_UmuKbn hnnkakninhskjikouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.HNNKAKNINHSKJIKOUUMUKBN)
    public C_UmuKbn getHnnkakninhskjikouumukbn() {
        return hnnkakninhskjikouumukbn;
    }

    public void setHnnkakninhskjikouumukbn(C_UmuKbn pHnnkakninhskjikouumukbn) {
        hnnkakninhskjikouumukbn = pHnnkakninhskjikouumukbn;
    }

    private C_UmuKbn hnnkakninhsktkjikouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.HNNKAKNINHSKTKJIKOUUMUKBN)
    public C_UmuKbn getHnnkakninhsktkjikouumukbn() {
        return hnnkakninhsktkjikouumukbn;
    }

    public void setHnnkakninhsktkjikouumukbn(C_UmuKbn pHnnkakninhsktkjikouumukbn) {
        hnnkakninhsktkjikouumukbn = pHnnkakninhsktkjikouumukbn;
    }

    private C_UmuKbn skskakninhsktkjikouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.SKSKAKNINHSKTKJIKOUUMUKBN)
    public C_UmuKbn getSkskakninhsktkjikouumukbn() {
        return skskakninhsktkjikouumukbn;
    }

    public void setSkskakninhsktkjikouumukbn(C_UmuKbn pSkskakninhsktkjikouumukbn) {
        skskakninhsktkjikouumukbn = pSkskakninhsktkjikouumukbn;
    }

    private String khnchkcmnt;

    @Column(name=GenHT_BosKihon.KHNCHKCMNT)
    @MultiByteStringsReturnable
    @InvalidCharacter
    @ValidTextArea(length=40, rows=10)
    public String getKhnchkcmnt() {
        return khnchkcmnt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKhnchkcmnt(String pKhnchkcmnt) {
        khnchkcmnt = pKhnchkcmnt;
    }

    private C_MosTourokuJyoukyouKbn mostourokujyoukyoukbn;

    @Type(type="UserType_C_MosTourokuJyoukyouKbn")
    @Column(name=GenHT_BosKihon.MOSTOUROKUJYOUKYOUKBN)
    public C_MosTourokuJyoukyouKbn getMostourokujyoukyoukbn() {
        return mostourokujyoukyoukbn;
    }

    public void setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn pMostourokujyoukyoukbn) {
        mostourokujyoukyoukbn = pMostourokujyoukyoukbn;
    }

    private C_UmuKbn pplessdatasousinumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_BosKihon.PPLESSDATASOUSINUMUKBN)
    public C_UmuKbn getPplessdatasousinumukbn() {
        return pplessdatasousinumukbn;
    }

    public void setPplessdatasousinumukbn(C_UmuKbn pPplessdatasousinumukbn) {
        pplessdatasousinumukbn = pPplessdatasousinumukbn;
    }

    private C_MobilebosyuuKbn mobilebosyuukbn;

    @Type(type="UserType_C_MobilebosyuuKbn")
    @Column(name=GenHT_BosKihon.MOBILEBOSYUUKBN)
    public C_MobilebosyuuKbn getMobilebosyuukbn() {
        return mobilebosyuukbn;
    }

    public void setMobilebosyuukbn(C_MobilebosyuuKbn pMobilebosyuukbn) {
        mobilebosyuukbn = pMobilebosyuukbn;
    }

    private C_TumitatekinHaibunWariKbn teirituhaibunwarikbn;

    @Type(type="UserType_C_TumitatekinHaibunWariKbn")
    @Column(name=GenHT_BosKihon.TEIRITUHAIBUNWARIKBN)
    public C_TumitatekinHaibunWariKbn getTeirituhaibunwarikbn() {
        return teirituhaibunwarikbn;
    }

    public void setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn pTeirituhaibunwarikbn) {
        teirituhaibunwarikbn = pTeirituhaibunwarikbn;
    }

    private C_Sisuukbn sisuukbn;

    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenHT_BosKihon.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    @Type(type="UserType_C_TumitatekinHaibunWariKbn")
    @Column(name=GenHT_BosKihon.SISUUHAIBUNWARIKBN)
    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn) {
        sisuuhaibunwarikbn = pSisuuhaibunwarikbn;
    }

    private C_TrhkjiKakKbn trhkjikakkbn;

    @Type(type="UserType_C_TrhkjiKakKbn")
    @Column(name=GenHT_BosKihon.TRHKJIKAKKBN)
    public C_TrhkjiKakKbn getTrhkjikakkbn() {
        return trhkjikakkbn;
    }

    public void setTrhkjikakkbn(C_TrhkjiKakKbn pTrhkjikakkbn) {
        trhkjikakkbn = pTrhkjikakkbn;
    }

    private C_KoureisyaTaiouKbn koureitaioukbn;

    @Type(type="UserType_C_KoureisyaTaiouKbn")
    @Column(name=GenHT_BosKihon.KOUREITAIOUKBN)
    public C_KoureisyaTaiouKbn getKoureitaioukbn() {
        return koureitaioukbn;
    }

    public void setKoureitaioukbn(C_KoureisyaTaiouKbn pKoureitaioukbn) {
        koureitaioukbn = pKoureitaioukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_BosKihon.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_BosKihon.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}