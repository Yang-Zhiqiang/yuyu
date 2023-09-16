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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_SyoumetuTuuti;
import yuyu.def.db.id.PKIT_SyoumetuTuuti;
import yuyu.def.db.meta.GenQIT_SyoumetuTuuti;
import yuyu.def.db.meta.QIT_SyoumetuTuuti;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KykMsnKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 消滅通知テーブル テーブルのマッピング情報クラスで、 {@link IT_SyoumetuTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SyoumetuTuuti}</td><td colspan="3">消滅通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SyoumetuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SyoumetuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_SyoumetuTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getSksdoufuukbn sksdoufuukbn}</td><td>請求書同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMynosinkokuiraidoufuukbn mynosinkokuiraidoufuukbn}</td><td>マイナンバー申告依頼同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasekaisyanmkj toiawasekaisyanmkj}</td><td>問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeiyakuymd keiyakuymd}</td><td>契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtuukakaiyakuhrkngkkei shrtuukakaiyakuhrkngkkei}</td><td>支払通貨解約返戻金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhrkngkkeisiteituuka kaiyakuhrkngkkeisiteituuka}</td><td>解約返戻金額合計（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotaseisan sonotaseisan}</td><td>その他精算金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansanhaitoukin yenkansanhaitoukin}</td><td>円換算配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYensonotahaitoukin yensonotahaitoukin}</td><td>円換算その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukagstszeigk shrtuukagstszeigk}</td><td>支払通貨源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingksiteituuka zitkazukarikingksiteituuka}</td><td>税適預り金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrgkkei shrgkkei}</td><td>支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmkj banknmkj}</td><td>銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkj sitennmkj}</td><td>支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtsiryosyukbn htsiryosyukbn}</td><td>法定資料種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HtsiryosyuKbn}</td></tr>
 *  <tr><td>{@link #getSynykngk synykngk}</td><td>収入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHtykeihi htykeihi}</td><td>必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkykhtykeihi shrkykhtykeihi}</td><td>支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeimunaiyouhensyuctrlkbn zeimunaiyouhensyuctrlkbn}</td><td>税務内容編集制御区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeimuNaiyouHnsyuCtrlKbn}</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykmsnkbn kykmsnkbn}</td><td>契約者未成年区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykMsnKbn}</td></tr>
 *  <tr><td>{@link #getLastsyosaihkymd lastsyosaihkymd}</td><td>最終証券再発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToritugisyasyozokunm toritugisyasyozokunm}</td><td>取次者所属名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToritugisyakjncd toritugisyakjncd}</td><td>取次者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToritugisyanm toritugisyanm}</td><td>取次者氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SyoumetuTuuti
 * @see     PKIT_SyoumetuTuuti
 * @see     QIT_SyoumetuTuuti
 * @see     GenQIT_SyoumetuTuuti
 */
@MappedSuperclass
@Table(name=GenIT_SyoumetuTuuti.TABLE_NAME)
@IdClass(value=PKIT_SyoumetuTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HtsiryosyuKbn", typeClass=UserType_C_HtsiryosyuKbn.class),
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_KykMsnKbn", typeClass=UserType_C_KykMsnKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_ZeimuNaiyouHnsyuCtrlKbn", typeClass=UserType_C_ZeimuNaiyouHnsyuCtrlKbn.class)
})
public abstract class GenIT_SyoumetuTuuti extends AbstractExDBEntity<IT_SyoumetuTuuti, PKIT_SyoumetuTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SyoumetuTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String SKSDOUFUUKBN             = "sksdoufuukbn";
    public static final String MYNOSINKOKUIRAIDOUFUUKBN = "mynosinkokuiraidoufuukbn";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASEKAISYANMKJ       = "toiawasekaisyanmkj";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String SHRYMD                   = "shrymd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String KEIYAKUYMD               = "keiyakuymd";
    public static final String SHRTUUKAKAIYAKUHRKNGKKEI = "shrtuukakaiyakuhrkngkkei";
    public static final String KAIYAKUHRKNGKKEISITEITUUKA = "kaiyakuhrkngkkeisiteituuka";
    public static final String SONOTASEISAN             = "sonotaseisan";
    public static final String YENKANSANHAITOUKIN       = "yenkansanhaitoukin";
    public static final String YENSONOTAHAITOUKIN       = "yensonotahaitoukin";
    public static final String SHRTUUKAGSTSZEIGK        = "shrtuukagstszeigk";
    public static final String ZITKAZUKARIKINGKSITEITUUKA = "zitkazukarikingksiteituuka";
    public static final String SHRGKKEI                 = "shrgkkei";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String BANKNMKJ                 = "banknmkj";
    public static final String SITENNMKJ                = "sitennmkj";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String HTSIRYOSYUKBN            = "htsiryosyukbn";
    public static final String SYNYKNGK                 = "synykngk";
    public static final String HTYKEIHI                 = "htykeihi";
    public static final String SHRKYKHTYKEIHI           = "shrkykhtykeihi";
    public static final String ZEIMUNAIYOUHENSYUCTRLKBN = "zeimunaiyouhensyuctrlkbn";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String KYKMSNKBN                = "kykmsnkbn";
    public static final String LASTSYOSAIHKYMD          = "lastsyosaihkymd";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINTELNO                = "tsintelno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TORITUGISYASYOZOKUNM     = "toritugisyasyozokunm";
    public static final String TORITUGISYAKJNCD         = "toritugisyakjncd";
    public static final String TORITUGISYANM            = "toritugisyanm";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SyoumetuTuuti primaryKey;

    public GenIT_SyoumetuTuuti() {
        primaryKey = new PKIT_SyoumetuTuuti();
    }

    public GenIT_SyoumetuTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_SyoumetuTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_SyoumetuTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SyoumetuTuuti> getMetaClass() {
        return QIT_SyoumetuTuuti.class;
    }

    @Id
    @Column(name=GenIT_SyoumetuTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SyoumetuTuuti.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_SyoumetuTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_SyoumetuTuuti.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_SyoumetuTuuti.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_SyoumetuTuuti.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_UmuKbn sksdoufuukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_SyoumetuTuuti.SKSDOUFUUKBN)
    public C_UmuKbn getSksdoufuukbn() {
        return sksdoufuukbn;
    }

    public void setSksdoufuukbn(C_UmuKbn pSksdoufuukbn) {
        sksdoufuukbn = pSksdoufuukbn;
    }

    private C_UmuKbn mynosinkokuiraidoufuukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_SyoumetuTuuti.MYNOSINKOKUIRAIDOUFUUKBN)
    public C_UmuKbn getMynosinkokuiraidoufuukbn() {
        return mynosinkokuiraidoufuukbn;
    }

    public void setMynosinkokuiraidoufuukbn(C_UmuKbn pMynosinkokuiraidoufuukbn) {
        mynosinkokuiraidoufuukbn = pMynosinkokuiraidoufuukbn;
    }

    private String shskyno;

    @Column(name=GenIT_SyoumetuTuuti.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIT_SyoumetuTuuti.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIT_SyoumetuTuuti.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIT_SyoumetuTuuti.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIT_SyoumetuTuuti.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String toiawaseyno;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasekaisyanmkj;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASEKAISYANMKJ)
    public String getToiawasekaisyanmkj() {
        return toiawasekaisyanmkj;
    }

    public void setToiawasekaisyanmkj(String pToiawasekaisyanmkj) {
        toiawasekaisyanmkj = pToiawasekaisyanmkj;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASESOSIKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String toiawaseteluktkkanou1;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_SyoumetuTuuti.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SyoumetuTuuti.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SyoumetuTuuti.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private String kyknmkj;

    @Column(name=GenIT_SyoumetuTuuti.KYKNMKJ)
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

    private String hhknnmkj;

    @Column(name=GenIT_SyoumetuTuuti.HHKNNMKJ)
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

    private BizDate keiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SyoumetuTuuti.KEIYAKUYMD)
    public BizDate getKeiyakuymd() {
        return keiyakuymd;
    }

    public void setKeiyakuymd(BizDate pKeiyakuymd) {
        keiyakuymd = pKeiyakuymd;
    }

    private BizCurrency shrtuukakaiyakuhrkngkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukakaiyakuhrkngkkei() {
        return shrtuukakaiyakuhrkngkkei;
    }

    public void setShrtuukakaiyakuhrkngkkei(BizCurrency pShrtuukakaiyakuhrkngkkei) {
        shrtuukakaiyakuhrkngkkei = pShrtuukakaiyakuhrkngkkei;
        shrtuukakaiyakuhrkngkkeiValue = null;
        shrtuukakaiyakuhrkngkkeiType  = null;
    }

    transient private BigDecimal shrtuukakaiyakuhrkngkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAKAIYAKUHRKNGKKEI, nullable=true)
    protected BigDecimal getShrtuukakaiyakuhrkngkkeiValue() {
        if (shrtuukakaiyakuhrkngkkeiValue == null && shrtuukakaiyakuhrkngkkei != null) {
            if (shrtuukakaiyakuhrkngkkei.isOptional()) return null;
            return shrtuukakaiyakuhrkngkkei.absolute();
        }
        return shrtuukakaiyakuhrkngkkeiValue;
    }

    protected void setShrtuukakaiyakuhrkngkkeiValue(BigDecimal value) {
        shrtuukakaiyakuhrkngkkeiValue = value;
        shrtuukakaiyakuhrkngkkei = Optional.fromNullable(toCurrencyType(shrtuukakaiyakuhrkngkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukakaiyakuhrkngkkeiValue()))
            .orNull();
    }

    transient private String shrtuukakaiyakuhrkngkkeiType = null;

    @Column(name=SHRTUUKAKAIYAKUHRKNGKKEI + "$", nullable=true)
    protected String getShrtuukakaiyakuhrkngkkeiType() {
        if (shrtuukakaiyakuhrkngkkeiType == null && shrtuukakaiyakuhrkngkkei != null) return shrtuukakaiyakuhrkngkkei.getType().toString();
        if (shrtuukakaiyakuhrkngkkeiType == null && getShrtuukakaiyakuhrkngkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukakaiyakuhrkngkkei$' should not be NULL."));
        }
        return shrtuukakaiyakuhrkngkkeiType;
    }

    protected void setShrtuukakaiyakuhrkngkkeiType(String type) {
        shrtuukakaiyakuhrkngkkeiType = type;
        shrtuukakaiyakuhrkngkkei = Optional.fromNullable(toCurrencyType(shrtuukakaiyakuhrkngkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukakaiyakuhrkngkkeiValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhrkngkkeisiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrkngkkeisiteituuka() {
        return kaiyakuhrkngkkeisiteituuka;
    }

    public void setKaiyakuhrkngkkeisiteituuka(BizCurrency pKaiyakuhrkngkkeisiteituuka) {
        kaiyakuhrkngkkeisiteituuka = pKaiyakuhrkngkkeisiteituuka;
        kaiyakuhrkngkkeisiteituukaValue = null;
        kaiyakuhrkngkkeisiteituukaType  = null;
    }

    transient private BigDecimal kaiyakuhrkngkkeisiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRKNGKKEISITEITUUKA, nullable=true)
    protected BigDecimal getKaiyakuhrkngkkeisiteituukaValue() {
        if (kaiyakuhrkngkkeisiteituukaValue == null && kaiyakuhrkngkkeisiteituuka != null) {
            if (kaiyakuhrkngkkeisiteituuka.isOptional()) return null;
            return kaiyakuhrkngkkeisiteituuka.absolute();
        }
        return kaiyakuhrkngkkeisiteituukaValue;
    }

    protected void setKaiyakuhrkngkkeisiteituukaValue(BigDecimal value) {
        kaiyakuhrkngkkeisiteituukaValue = value;
        kaiyakuhrkngkkeisiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeisiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeisiteituukaValue()))
            .orNull();
    }

    transient private String kaiyakuhrkngkkeisiteituukaType = null;

    @Column(name=KAIYAKUHRKNGKKEISITEITUUKA + "$", nullable=true)
    protected String getKaiyakuhrkngkkeisiteituukaType() {
        if (kaiyakuhrkngkkeisiteituukaType == null && kaiyakuhrkngkkeisiteituuka != null) return kaiyakuhrkngkkeisiteituuka.getType().toString();
        if (kaiyakuhrkngkkeisiteituukaType == null && getKaiyakuhrkngkkeisiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrkngkkeisiteituuka$' should not be NULL."));
        }
        return kaiyakuhrkngkkeisiteituukaType;
    }

    protected void setKaiyakuhrkngkkeisiteituukaType(String type) {
        kaiyakuhrkngkkeisiteituukaType = type;
        kaiyakuhrkngkkeisiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeisiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeisiteituukaValue()))
            .orNull();
    }

    private BizCurrency sonotaseisan;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotaseisan() {
        return sonotaseisan;
    }

    public void setSonotaseisan(BizCurrency pSonotaseisan) {
        sonotaseisan = pSonotaseisan;
        sonotaseisanValue = null;
        sonotaseisanType  = null;
    }

    transient private BigDecimal sonotaseisanValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTASEISAN, nullable=true)
    protected BigDecimal getSonotaseisanValue() {
        if (sonotaseisanValue == null && sonotaseisan != null) {
            if (sonotaseisan.isOptional()) return null;
            return sonotaseisan.absolute();
        }
        return sonotaseisanValue;
    }

    protected void setSonotaseisanValue(BigDecimal value) {
        sonotaseisanValue = value;
        sonotaseisan = Optional.fromNullable(toCurrencyType(sonotaseisanType))
            .transform(bizCurrencyTransformer(getSonotaseisanValue()))
            .orNull();
    }

    transient private String sonotaseisanType = null;

    @Column(name=SONOTASEISAN + "$", nullable=true)
    protected String getSonotaseisanType() {
        if (sonotaseisanType == null && sonotaseisan != null) return sonotaseisan.getType().toString();
        if (sonotaseisanType == null && getSonotaseisanValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotaseisan$' should not be NULL."));
        }
        return sonotaseisanType;
    }

    protected void setSonotaseisanType(String type) {
        sonotaseisanType = type;
        sonotaseisan = Optional.fromNullable(toCurrencyType(sonotaseisanType))
            .transform(bizCurrencyTransformer(getSonotaseisanValue()))
            .orNull();
    }

    private BizCurrency yenkansanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansanhaitoukin() {
        return yenkansanhaitoukin;
    }

    public void setYenkansanhaitoukin(BizCurrency pYenkansanhaitoukin) {
        yenkansanhaitoukin = pYenkansanhaitoukin;
        yenkansanhaitoukinValue = null;
        yenkansanhaitoukinType  = null;
    }

    transient private BigDecimal yenkansanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANHAITOUKIN, nullable=true)
    protected BigDecimal getYenkansanhaitoukinValue() {
        if (yenkansanhaitoukinValue == null && yenkansanhaitoukin != null) {
            if (yenkansanhaitoukin.isOptional()) return null;
            return yenkansanhaitoukin.absolute();
        }
        return yenkansanhaitoukinValue;
    }

    protected void setYenkansanhaitoukinValue(BigDecimal value) {
        yenkansanhaitoukinValue = value;
        yenkansanhaitoukin = Optional.fromNullable(toCurrencyType(yenkansanhaitoukinType))
            .transform(bizCurrencyTransformer(getYenkansanhaitoukinValue()))
            .orNull();
    }

    transient private String yenkansanhaitoukinType = null;

    @Column(name=YENKANSANHAITOUKIN + "$", nullable=true)
    protected String getYenkansanhaitoukinType() {
        if (yenkansanhaitoukinType == null && yenkansanhaitoukin != null) return yenkansanhaitoukin.getType().toString();
        if (yenkansanhaitoukinType == null && getYenkansanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansanhaitoukin$' should not be NULL."));
        }
        return yenkansanhaitoukinType;
    }

    protected void setYenkansanhaitoukinType(String type) {
        yenkansanhaitoukinType = type;
        yenkansanhaitoukin = Optional.fromNullable(toCurrencyType(yenkansanhaitoukinType))
            .transform(bizCurrencyTransformer(getYenkansanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency yensonotahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYensonotahaitoukin() {
        return yensonotahaitoukin;
    }

    public void setYensonotahaitoukin(BizCurrency pYensonotahaitoukin) {
        yensonotahaitoukin = pYensonotahaitoukin;
        yensonotahaitoukinValue = null;
        yensonotahaitoukinType  = null;
    }

    transient private BigDecimal yensonotahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSONOTAHAITOUKIN, nullable=true)
    protected BigDecimal getYensonotahaitoukinValue() {
        if (yensonotahaitoukinValue == null && yensonotahaitoukin != null) {
            if (yensonotahaitoukin.isOptional()) return null;
            return yensonotahaitoukin.absolute();
        }
        return yensonotahaitoukinValue;
    }

    protected void setYensonotahaitoukinValue(BigDecimal value) {
        yensonotahaitoukinValue = value;
        yensonotahaitoukin = Optional.fromNullable(toCurrencyType(yensonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYensonotahaitoukinValue()))
            .orNull();
    }

    transient private String yensonotahaitoukinType = null;

    @Column(name=YENSONOTAHAITOUKIN + "$", nullable=true)
    protected String getYensonotahaitoukinType() {
        if (yensonotahaitoukinType == null && yensonotahaitoukin != null) return yensonotahaitoukin.getType().toString();
        if (yensonotahaitoukinType == null && getYensonotahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yensonotahaitoukin$' should not be NULL."));
        }
        return yensonotahaitoukinType;
    }

    protected void setYensonotahaitoukinType(String type) {
        yensonotahaitoukinType = type;
        yensonotahaitoukin = Optional.fromNullable(toCurrencyType(yensonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYensonotahaitoukinValue()))
            .orNull();
    }

    private BizCurrency shrtuukagstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukagstszeigk() {
        return shrtuukagstszeigk;
    }

    public void setShrtuukagstszeigk(BizCurrency pShrtuukagstszeigk) {
        shrtuukagstszeigk = pShrtuukagstszeigk;
        shrtuukagstszeigkValue = null;
        shrtuukagstszeigkType  = null;
    }

    transient private BigDecimal shrtuukagstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAGSTSZEIGK, nullable=true)
    protected BigDecimal getShrtuukagstszeigkValue() {
        if (shrtuukagstszeigkValue == null && shrtuukagstszeigk != null) {
            if (shrtuukagstszeigk.isOptional()) return null;
            return shrtuukagstszeigk.absolute();
        }
        return shrtuukagstszeigkValue;
    }

    protected void setShrtuukagstszeigkValue(BigDecimal value) {
        shrtuukagstszeigkValue = value;
        shrtuukagstszeigk = Optional.fromNullable(toCurrencyType(shrtuukagstszeigkType))
            .transform(bizCurrencyTransformer(getShrtuukagstszeigkValue()))
            .orNull();
    }

    transient private String shrtuukagstszeigkType = null;

    @Column(name=SHRTUUKAGSTSZEIGK + "$", nullable=true)
    protected String getShrtuukagstszeigkType() {
        if (shrtuukagstszeigkType == null && shrtuukagstszeigk != null) return shrtuukagstszeigk.getType().toString();
        if (shrtuukagstszeigkType == null && getShrtuukagstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukagstszeigk$' should not be NULL."));
        }
        return shrtuukagstszeigkType;
    }

    protected void setShrtuukagstszeigkType(String type) {
        shrtuukagstszeigkType = type;
        shrtuukagstszeigk = Optional.fromNullable(toCurrencyType(shrtuukagstszeigkType))
            .transform(bizCurrencyTransformer(getShrtuukagstszeigkValue()))
            .orNull();
    }

    private BizCurrency zitkazukarikingksiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency pZitkazukarikingksiteituuka) {
        zitkazukarikingksiteituuka = pZitkazukarikingksiteituuka;
        zitkazukarikingksiteituukaValue = null;
        zitkazukarikingksiteituukaType  = null;
    }

    transient private BigDecimal zitkazukarikingksiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKSITEITUUKA, nullable=true)
    protected BigDecimal getZitkazukarikingksiteituukaValue() {
        if (zitkazukarikingksiteituukaValue == null && zitkazukarikingksiteituuka != null) {
            if (zitkazukarikingksiteituuka.isOptional()) return null;
            return zitkazukarikingksiteituuka.absolute();
        }
        return zitkazukarikingksiteituukaValue;
    }

    protected void setZitkazukarikingksiteituukaValue(BigDecimal value) {
        zitkazukarikingksiteituukaValue = value;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    transient private String zitkazukarikingksiteituukaType = null;

    @Column(name=ZITKAZUKARIKINGKSITEITUUKA + "$", nullable=true)
    protected String getZitkazukarikingksiteituukaType() {
        if (zitkazukarikingksiteituukaType == null && zitkazukarikingksiteituuka != null) return zitkazukarikingksiteituuka.getType().toString();
        if (zitkazukarikingksiteituukaType == null && getZitkazukarikingksiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingksiteituuka$' should not be NULL."));
        }
        return zitkazukarikingksiteituukaType;
    }

    protected void setZitkazukarikingksiteituukaType(String type) {
        zitkazukarikingksiteituukaType = type;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    private BizCurrency shrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
        shrgkkeiValue = null;
        shrgkkeiType  = null;
    }

    transient private BigDecimal shrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGKKEI, nullable=true)
    protected BigDecimal getShrgkkeiValue() {
        if (shrgkkeiValue == null && shrgkkei != null) {
            if (shrgkkei.isOptional()) return null;
            return shrgkkei.absolute();
        }
        return shrgkkeiValue;
    }

    protected void setShrgkkeiValue(BigDecimal value) {
        shrgkkeiValue = value;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    transient private String shrgkkeiType = null;

    @Column(name=SHRGKKEI + "$", nullable=true)
    protected String getShrgkkeiType() {
        if (shrgkkeiType == null && shrgkkei != null) return shrgkkei.getType().toString();
        if (shrgkkeiType == null && getShrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgkkei$' should not be NULL."));
        }
        return shrgkkeiType;
    }

    protected void setShrgkkeiType(String type) {
        shrgkkeiType = type;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_SyoumetuTuuti.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SyoumetuTuuti.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private String bankcd;

    @Column(name=GenIT_SyoumetuTuuti.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_SyoumetuTuuti.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private String banknmkj;

    @Column(name=GenIT_SyoumetuTuuti.BANKNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getBanknmkj() {
        return banknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    private String sitennmkj;

    @Column(name=GenIT_SyoumetuTuuti.SITENNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_SyoumetuTuuti.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_SyoumetuTuuti.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenIT_SyoumetuTuuti.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIT_SyoumetuTuuti.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_HtsiryosyuKbn htsiryosyukbn;

    @Type(type="UserType_C_HtsiryosyuKbn")
    @Column(name=GenIT_SyoumetuTuuti.HTSIRYOSYUKBN)
    public C_HtsiryosyuKbn getHtsiryosyukbn() {
        return htsiryosyukbn;
    }

    public void setHtsiryosyukbn(C_HtsiryosyuKbn pHtsiryosyukbn) {
        htsiryosyukbn = pHtsiryosyukbn;
    }

    private BizCurrency synykngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        synykngk = pSynykngk;
        synykngkValue = null;
        synykngkType  = null;
    }

    transient private BigDecimal synykngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYNYKNGK, nullable=true)
    protected BigDecimal getSynykngkValue() {
        if (synykngkValue == null && synykngk != null) {
            if (synykngk.isOptional()) return null;
            return synykngk.absolute();
        }
        return synykngkValue;
    }

    protected void setSynykngkValue(BigDecimal value) {
        synykngkValue = value;
        synykngk = Optional.fromNullable(toCurrencyType(synykngkType))
            .transform(bizCurrencyTransformer(getSynykngkValue()))
            .orNull();
    }

    transient private String synykngkType = null;

    @Column(name=SYNYKNGK + "$", nullable=true)
    protected String getSynykngkType() {
        if (synykngkType == null && synykngk != null) return synykngk.getType().toString();
        if (synykngkType == null && getSynykngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'synykngk$' should not be NULL."));
        }
        return synykngkType;
    }

    protected void setSynykngkType(String type) {
        synykngkType = type;
        synykngk = Optional.fromNullable(toCurrencyType(synykngkType))
            .transform(bizCurrencyTransformer(getSynykngkValue()))
            .orNull();
    }

    private BizCurrency htykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
        htykeihiValue = null;
        htykeihiType  = null;
    }

    transient private BigDecimal htykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HTYKEIHI, nullable=true)
    protected BigDecimal getHtykeihiValue() {
        if (htykeihiValue == null && htykeihi != null) {
            if (htykeihi.isOptional()) return null;
            return htykeihi.absolute();
        }
        return htykeihiValue;
    }

    protected void setHtykeihiValue(BigDecimal value) {
        htykeihiValue = value;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    transient private String htykeihiType = null;

    @Column(name=HTYKEIHI + "$", nullable=true)
    protected String getHtykeihiType() {
        if (htykeihiType == null && htykeihi != null) return htykeihi.getType().toString();
        if (htykeihiType == null && getHtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'htykeihi$' should not be NULL."));
        }
        return htykeihiType;
    }

    protected void setHtykeihiType(String type) {
        htykeihiType = type;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    private BizCurrency shrkykhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
        shrkykhtykeihiValue = null;
        shrkykhtykeihiType  = null;
    }

    transient private BigDecimal shrkykhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRKYKHTYKEIHI, nullable=true)
    protected BigDecimal getShrkykhtykeihiValue() {
        if (shrkykhtykeihiValue == null && shrkykhtykeihi != null) {
            if (shrkykhtykeihi.isOptional()) return null;
            return shrkykhtykeihi.absolute();
        }
        return shrkykhtykeihiValue;
    }

    protected void setShrkykhtykeihiValue(BigDecimal value) {
        shrkykhtykeihiValue = value;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    transient private String shrkykhtykeihiType = null;

    @Column(name=SHRKYKHTYKEIHI + "$", nullable=true)
    protected String getShrkykhtykeihiType() {
        if (shrkykhtykeihiType == null && shrkykhtykeihi != null) return shrkykhtykeihi.getType().toString();
        if (shrkykhtykeihiType == null && getShrkykhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrkykhtykeihi$' should not be NULL."));
        }
        return shrkykhtykeihiType;
    }

    protected void setShrkykhtykeihiType(String type) {
        shrkykhtykeihiType = type;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    private C_ZeimuNaiyouHnsyuCtrlKbn zeimunaiyouhensyuctrlkbn;

    @Type(type="UserType_C_ZeimuNaiyouHnsyuCtrlKbn")
    @Column(name=GenIT_SyoumetuTuuti.ZEIMUNAIYOUHENSYUCTRLKBN)
    public C_ZeimuNaiyouHnsyuCtrlKbn getZeimunaiyouhensyuctrlkbn() {
        return zeimunaiyouhensyuctrlkbn;
    }

    public void setZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn pZeimunaiyouhensyuctrlkbn) {
        zeimunaiyouhensyuctrlkbn = pZeimunaiyouhensyuctrlkbn;
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenIT_SyoumetuTuuti.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private C_KykMsnKbn kykmsnkbn;

    @Type(type="UserType_C_KykMsnKbn")
    @Column(name=GenIT_SyoumetuTuuti.KYKMSNKBN)
    public C_KykMsnKbn getKykmsnkbn() {
        return kykmsnkbn;
    }

    public void setKykmsnkbn(C_KykMsnKbn pKykmsnkbn) {
        kykmsnkbn = pKykmsnkbn;
    }

    private BizDate lastsyosaihkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SyoumetuTuuti.LASTSYOSAIHKYMD)
    public BizDate getLastsyosaihkymd() {
        return lastsyosaihkymd;
    }

    @Trim("both")
    public void setLastsyosaihkymd(BizDate pLastsyosaihkymd) {
        lastsyosaihkymd = pLastsyosaihkymd;
    }

    private String tsinyno;

    @Column(name=GenIT_SyoumetuTuuti.TSINYNO)
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

    private String tsintelno;

    @Column(name=GenIT_SyoumetuTuuti.TSINTELNO)
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

    private String tsinadr1kj;

    @Column(name=GenIT_SyoumetuTuuti.TSINADR1KJ)
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

    @Column(name=GenIT_SyoumetuTuuti.TSINADR2KJ)
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

    @Column(name=GenIT_SyoumetuTuuti.TSINADR3KJ)
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

    private String toritugisyasyozokunm;

    @Column(name=GenIT_SyoumetuTuuti.TORITUGISYASYOZOKUNM)
    public String getToritugisyasyozokunm() {
        return toritugisyasyozokunm;
    }

    public void setToritugisyasyozokunm(String pToritugisyasyozokunm) {
        toritugisyasyozokunm = pToritugisyasyozokunm;
    }

    private String toritugisyakjncd;

    @Column(name=GenIT_SyoumetuTuuti.TORITUGISYAKJNCD)
    public String getToritugisyakjncd() {
        return toritugisyakjncd;
    }

    public void setToritugisyakjncd(String pToritugisyakjncd) {
        toritugisyakjncd = pToritugisyakjncd;
    }

    private String toritugisyanm;

    @Column(name=GenIT_SyoumetuTuuti.TORITUGISYANM)
    public String getToritugisyanm() {
        return toritugisyanm;
    }

    public void setToritugisyanm(String pToritugisyanm) {
        toritugisyanm = pToritugisyanm;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SyoumetuTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SyoumetuTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SyoumetuTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}