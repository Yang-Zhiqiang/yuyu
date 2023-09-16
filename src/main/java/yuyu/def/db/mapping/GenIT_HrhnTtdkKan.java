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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.id.PKIT_HrhnTtdkKan;
import yuyu.def.db.meta.GenQIT_HrhnTtdkKan;
import yuyu.def.db.meta.QIT_HrhnTtdkKan;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手続完了（払方変更）テーブル テーブルのマッピング情報クラスで、 {@link IT_HrhnTtdkKan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HrhnTtdkKan}</td><td colspan="3">手続完了（払方変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HrhnTtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HrhnTtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_HrhnTtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasekaisyanmkj toiawasekaisyanmkj}</td><td>問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzamaskingmsg kouzamaskingmsg}</td><td>口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuutkiktbrisyu hrkkaisuutkiktbrisyu}</td><td>払込回数・定期一括払種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiym kouryokuhasseiym}</td><td>効力発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMsgarea34keta1 msgarea34keta1}</td><td>メッセージエリア（３４桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsgarea34keta2 msgarea34keta2}</td><td>メッセージエリア（３４桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsgarea34keta3 msgarea34keta3}</td><td>メッセージエリア（３４桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsgarea34keta4 msgarea34keta4}</td><td>メッセージエリア（３４桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsgarea34keta5 msgarea34keta5}</td><td>メッセージエリア（３４桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsgarea34keta6 msgarea34keta6}</td><td>メッセージエリア（３４桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsgarea34keta7 msgarea34keta7}</td><td>メッセージエリア（３４桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta1 hrkykkmsg34keta1}</td><td>振替予告メッセージ（３４桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta2 hrkykkmsg34keta2}</td><td>振替予告メッセージ（３４桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta3 hrkykkmsg34keta3}</td><td>振替予告メッセージ（３４桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta4 hrkykkmsg34keta4}</td><td>振替予告メッセージ（３４桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta5 hrkykkmsg34keta5}</td><td>振替予告メッセージ（３４桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta6 hrkykkmsg34keta6}</td><td>振替予告メッセージ（３４桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta7 hrkykkmsg34keta7}</td><td>振替予告メッセージ（３４桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta8 hrkykkmsg34keta8}</td><td>振替予告メッセージ（３４桁）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta9 hrkykkmsg34keta9}</td><td>振替予告メッセージ（３４桁）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta10 hrkykkmsg34keta10}</td><td>振替予告メッセージ（３４桁）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta11 hrkykkmsg34keta11}</td><td>振替予告メッセージ（３４桁）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta12 hrkykkmsg34keta12}</td><td>振替予告メッセージ（３４桁）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta13 hrkykkmsg34keta13}</td><td>振替予告メッセージ（３４桁）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta14 hrkykkmsg34keta14}</td><td>振替予告メッセージ（３４桁）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta15 hrkykkmsg34keta15}</td><td>振替予告メッセージ（３４桁）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta16 hrkykkmsg34keta16}</td><td>振替予告メッセージ（３４桁）１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta17 hrkykkmsg34keta17}</td><td>振替予告メッセージ（３４桁）１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta18 hrkykkmsg34keta18}</td><td>振替予告メッセージ（３４桁）１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta19 hrkykkmsg34keta19}</td><td>振替予告メッセージ（３４桁）１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta20 hrkykkmsg34keta20}</td><td>振替予告メッセージ（３４桁）２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta21 hrkykkmsg34keta21}</td><td>振替予告メッセージ（３４桁）２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta22 hrkykkmsg34keta22}</td><td>振替予告メッセージ（３４桁）２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta23 hrkykkmsg34keta23}</td><td>振替予告メッセージ（３４桁）２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta24 hrkykkmsg34keta24}</td><td>振替予告メッセージ（３４桁）２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta25 hrkykkmsg34keta25}</td><td>振替予告メッセージ（３４桁）２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta26 hrkykkmsg34keta26}</td><td>振替予告メッセージ（３４桁）２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta27 hrkykkmsg34keta27}</td><td>振替予告メッセージ（３４桁）２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkykkmsg34keta28 hrkykkmsg34keta28}</td><td>振替予告メッセージ（３４桁）２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonsyakaisouriyuu honsyakaisouriyuu}</td><td>本社回送理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HrhnTtdkKan
 * @see     PKIT_HrhnTtdkKan
 * @see     QIT_HrhnTtdkKan
 * @see     GenQIT_HrhnTtdkKan
 */
@MappedSuperclass
@Table(name=GenIT_HrhnTtdkKan.TABLE_NAME)
@IdClass(value=PKIT_HrhnTtdkKan.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_HrhnTtdkKan extends AbstractExDBEntity<IT_HrhnTtdkKan, PKIT_HrhnTtdkKan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HrhnTtdkKan";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASEKAISYANMKJ       = "toiawasekaisyanmkj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String KOUZAMASKINGMSG          = "kouzamaskingmsg";
    public static final String HRKKAISUUTKIKTBRISYU     = "hrkkaisuutkiktbrisyu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HRKP                     = "hrkp";
    public static final String KOURYOKUHASSEIYM         = "kouryokuhasseiym";
    public static final String MSGAREA34KETA1           = "msgarea34keta1";
    public static final String MSGAREA34KETA2           = "msgarea34keta2";
    public static final String MSGAREA34KETA3           = "msgarea34keta3";
    public static final String MSGAREA34KETA4           = "msgarea34keta4";
    public static final String MSGAREA34KETA5           = "msgarea34keta5";
    public static final String MSGAREA34KETA6           = "msgarea34keta6";
    public static final String MSGAREA34KETA7           = "msgarea34keta7";
    public static final String HRKYKKMSG34KETA1         = "hrkykkmsg34keta1";
    public static final String HRKYKKMSG34KETA2         = "hrkykkmsg34keta2";
    public static final String HRKYKKMSG34KETA3         = "hrkykkmsg34keta3";
    public static final String HRKYKKMSG34KETA4         = "hrkykkmsg34keta4";
    public static final String HRKYKKMSG34KETA5         = "hrkykkmsg34keta5";
    public static final String HRKYKKMSG34KETA6         = "hrkykkmsg34keta6";
    public static final String HRKYKKMSG34KETA7         = "hrkykkmsg34keta7";
    public static final String HRKYKKMSG34KETA8         = "hrkykkmsg34keta8";
    public static final String HRKYKKMSG34KETA9         = "hrkykkmsg34keta9";
    public static final String HRKYKKMSG34KETA10        = "hrkykkmsg34keta10";
    public static final String HRKYKKMSG34KETA11        = "hrkykkmsg34keta11";
    public static final String HRKYKKMSG34KETA12        = "hrkykkmsg34keta12";
    public static final String HRKYKKMSG34KETA13        = "hrkykkmsg34keta13";
    public static final String HRKYKKMSG34KETA14        = "hrkykkmsg34keta14";
    public static final String HRKYKKMSG34KETA15        = "hrkykkmsg34keta15";
    public static final String HRKYKKMSG34KETA16        = "hrkykkmsg34keta16";
    public static final String HRKYKKMSG34KETA17        = "hrkykkmsg34keta17";
    public static final String HRKYKKMSG34KETA18        = "hrkykkmsg34keta18";
    public static final String HRKYKKMSG34KETA19        = "hrkykkmsg34keta19";
    public static final String HRKYKKMSG34KETA20        = "hrkykkmsg34keta20";
    public static final String HRKYKKMSG34KETA21        = "hrkykkmsg34keta21";
    public static final String HRKYKKMSG34KETA22        = "hrkykkmsg34keta22";
    public static final String HRKYKKMSG34KETA23        = "hrkykkmsg34keta23";
    public static final String HRKYKKMSG34KETA24        = "hrkykkmsg34keta24";
    public static final String HRKYKKMSG34KETA25        = "hrkykkmsg34keta25";
    public static final String HRKYKKMSG34KETA26        = "hrkykkmsg34keta26";
    public static final String HRKYKKMSG34KETA27        = "hrkykkmsg34keta27";
    public static final String HRKYKKMSG34KETA28        = "hrkykkmsg34keta28";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String HONSYAKAISOURIYUU        = "honsyakaisouriyuu";

    private final PKIT_HrhnTtdkKan primaryKey;

    public GenIT_HrhnTtdkKan() {
        primaryKey = new PKIT_HrhnTtdkKan();
    }

    public GenIT_HrhnTtdkKan(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_HrhnTtdkKan(
            pKbnkey,
            pSyono,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_HrhnTtdkKan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HrhnTtdkKan> getMetaClass() {
        return QIT_HrhnTtdkKan.class;
    }

    @Id
    @Column(name=GenIT_HrhnTtdkKan.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HrhnTtdkKan.SYONO)
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
    @Column(name=GenIT_HrhnTtdkKan.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_HrhnTtdkKan.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private BizDate tyouhyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrhnTtdkKan.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

    private String shskyno;

    @Column(name=GenIT_HrhnTtdkKan.SHSKYNO)
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

    @Column(name=GenIT_HrhnTtdkKan.SHSADR1KJ)
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

    @Column(name=GenIT_HrhnTtdkKan.SHSADR2KJ)
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

    @Column(name=GenIT_HrhnTtdkKan.SHSADR3KJ)
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

    @Column(name=GenIT_HrhnTtdkKan.SHSNMKJ)
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

    private String toiawasesosikinmkj;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASESOSIKINMKJ)
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

    private String toiawaseyno;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasekaisyanmkj;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASEKAISYANMKJ)
    public String getToiawasekaisyanmkj() {
        return toiawasekaisyanmkj;
    }

    public void setToiawasekaisyanmkj(String pToiawasekaisyanmkj) {
        toiawasekaisyanmkj = pToiawasekaisyanmkj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASETELNO)
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

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_HrhnTtdkKan.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private String kyknmkj;

    @Column(name=GenIT_HrhnTtdkKan.KYKNMKJ)
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

    @Column(name=GenIT_HrhnTtdkKan.HHKNNMKJ)
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

    private String kouzamaskingmsg;

    @Column(name=GenIT_HrhnTtdkKan.KOUZAMASKINGMSG)
    public String getKouzamaskingmsg() {
        return kouzamaskingmsg;
    }

    public void setKouzamaskingmsg(String pKouzamaskingmsg) {
        kouzamaskingmsg = pKouzamaskingmsg;
    }

    private String hrkkaisuutkiktbrisyu;

    @Column(name=GenIT_HrhnTtdkKan.HRKKAISUUTKIKTBRISYU)
    public String getHrkkaisuutkiktbrisyu() {
        return hrkkaisuutkiktbrisyu;
    }

    public void setHrkkaisuutkiktbrisyu(String pHrkkaisuutkiktbrisyu) {
        hrkkaisuutkiktbrisyu = pHrkkaisuutkiktbrisyu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_HrhnTtdkKan.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizDateYM kouryokuhasseiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_HrhnTtdkKan.KOURYOKUHASSEIYM)
    public BizDateYM getKouryokuhasseiym() {
        return kouryokuhasseiym;
    }

    public void setKouryokuhasseiym(BizDateYM pKouryokuhasseiym) {
        kouryokuhasseiym = pKouryokuhasseiym;
    }

    private String msgarea34keta1;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA1)
    public String getMsgarea34keta1() {
        return msgarea34keta1;
    }

    public void setMsgarea34keta1(String pMsgarea34keta1) {
        msgarea34keta1 = pMsgarea34keta1;
    }

    private String msgarea34keta2;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA2)
    public String getMsgarea34keta2() {
        return msgarea34keta2;
    }

    public void setMsgarea34keta2(String pMsgarea34keta2) {
        msgarea34keta2 = pMsgarea34keta2;
    }

    private String msgarea34keta3;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA3)
    public String getMsgarea34keta3() {
        return msgarea34keta3;
    }

    public void setMsgarea34keta3(String pMsgarea34keta3) {
        msgarea34keta3 = pMsgarea34keta3;
    }

    private String msgarea34keta4;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA4)
    public String getMsgarea34keta4() {
        return msgarea34keta4;
    }

    public void setMsgarea34keta4(String pMsgarea34keta4) {
        msgarea34keta4 = pMsgarea34keta4;
    }

    private String msgarea34keta5;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA5)
    public String getMsgarea34keta5() {
        return msgarea34keta5;
    }

    public void setMsgarea34keta5(String pMsgarea34keta5) {
        msgarea34keta5 = pMsgarea34keta5;
    }

    private String msgarea34keta6;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA6)
    public String getMsgarea34keta6() {
        return msgarea34keta6;
    }

    public void setMsgarea34keta6(String pMsgarea34keta6) {
        msgarea34keta6 = pMsgarea34keta6;
    }

    private String msgarea34keta7;

    @Column(name=GenIT_HrhnTtdkKan.MSGAREA34KETA7)
    public String getMsgarea34keta7() {
        return msgarea34keta7;
    }

    public void setMsgarea34keta7(String pMsgarea34keta7) {
        msgarea34keta7 = pMsgarea34keta7;
    }

    private String hrkykkmsg34keta1;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA1)
    public String getHrkykkmsg34keta1() {
        return hrkykkmsg34keta1;
    }

    public void setHrkykkmsg34keta1(String pHrkykkmsg34keta1) {
        hrkykkmsg34keta1 = pHrkykkmsg34keta1;
    }

    private String hrkykkmsg34keta2;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA2)
    public String getHrkykkmsg34keta2() {
        return hrkykkmsg34keta2;
    }

    public void setHrkykkmsg34keta2(String pHrkykkmsg34keta2) {
        hrkykkmsg34keta2 = pHrkykkmsg34keta2;
    }

    private String hrkykkmsg34keta3;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA3)
    public String getHrkykkmsg34keta3() {
        return hrkykkmsg34keta3;
    }

    public void setHrkykkmsg34keta3(String pHrkykkmsg34keta3) {
        hrkykkmsg34keta3 = pHrkykkmsg34keta3;
    }

    private String hrkykkmsg34keta4;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA4)
    public String getHrkykkmsg34keta4() {
        return hrkykkmsg34keta4;
    }

    public void setHrkykkmsg34keta4(String pHrkykkmsg34keta4) {
        hrkykkmsg34keta4 = pHrkykkmsg34keta4;
    }

    private String hrkykkmsg34keta5;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA5)
    public String getHrkykkmsg34keta5() {
        return hrkykkmsg34keta5;
    }

    public void setHrkykkmsg34keta5(String pHrkykkmsg34keta5) {
        hrkykkmsg34keta5 = pHrkykkmsg34keta5;
    }

    private String hrkykkmsg34keta6;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA6)
    public String getHrkykkmsg34keta6() {
        return hrkykkmsg34keta6;
    }

    public void setHrkykkmsg34keta6(String pHrkykkmsg34keta6) {
        hrkykkmsg34keta6 = pHrkykkmsg34keta6;
    }

    private String hrkykkmsg34keta7;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA7)
    public String getHrkykkmsg34keta7() {
        return hrkykkmsg34keta7;
    }

    public void setHrkykkmsg34keta7(String pHrkykkmsg34keta7) {
        hrkykkmsg34keta7 = pHrkykkmsg34keta7;
    }

    private String hrkykkmsg34keta8;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA8)
    public String getHrkykkmsg34keta8() {
        return hrkykkmsg34keta8;
    }

    public void setHrkykkmsg34keta8(String pHrkykkmsg34keta8) {
        hrkykkmsg34keta8 = pHrkykkmsg34keta8;
    }

    private String hrkykkmsg34keta9;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA9)
    public String getHrkykkmsg34keta9() {
        return hrkykkmsg34keta9;
    }

    public void setHrkykkmsg34keta9(String pHrkykkmsg34keta9) {
        hrkykkmsg34keta9 = pHrkykkmsg34keta9;
    }

    private String hrkykkmsg34keta10;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA10)
    public String getHrkykkmsg34keta10() {
        return hrkykkmsg34keta10;
    }

    public void setHrkykkmsg34keta10(String pHrkykkmsg34keta10) {
        hrkykkmsg34keta10 = pHrkykkmsg34keta10;
    }

    private String hrkykkmsg34keta11;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA11)
    public String getHrkykkmsg34keta11() {
        return hrkykkmsg34keta11;
    }

    public void setHrkykkmsg34keta11(String pHrkykkmsg34keta11) {
        hrkykkmsg34keta11 = pHrkykkmsg34keta11;
    }

    private String hrkykkmsg34keta12;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA12)
    public String getHrkykkmsg34keta12() {
        return hrkykkmsg34keta12;
    }

    public void setHrkykkmsg34keta12(String pHrkykkmsg34keta12) {
        hrkykkmsg34keta12 = pHrkykkmsg34keta12;
    }

    private String hrkykkmsg34keta13;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA13)
    public String getHrkykkmsg34keta13() {
        return hrkykkmsg34keta13;
    }

    public void setHrkykkmsg34keta13(String pHrkykkmsg34keta13) {
        hrkykkmsg34keta13 = pHrkykkmsg34keta13;
    }

    private String hrkykkmsg34keta14;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA14)
    public String getHrkykkmsg34keta14() {
        return hrkykkmsg34keta14;
    }

    public void setHrkykkmsg34keta14(String pHrkykkmsg34keta14) {
        hrkykkmsg34keta14 = pHrkykkmsg34keta14;
    }

    private String hrkykkmsg34keta15;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA15)
    public String getHrkykkmsg34keta15() {
        return hrkykkmsg34keta15;
    }

    public void setHrkykkmsg34keta15(String pHrkykkmsg34keta15) {
        hrkykkmsg34keta15 = pHrkykkmsg34keta15;
    }

    private String hrkykkmsg34keta16;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA16)
    public String getHrkykkmsg34keta16() {
        return hrkykkmsg34keta16;
    }

    public void setHrkykkmsg34keta16(String pHrkykkmsg34keta16) {
        hrkykkmsg34keta16 = pHrkykkmsg34keta16;
    }

    private String hrkykkmsg34keta17;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA17)
    public String getHrkykkmsg34keta17() {
        return hrkykkmsg34keta17;
    }

    public void setHrkykkmsg34keta17(String pHrkykkmsg34keta17) {
        hrkykkmsg34keta17 = pHrkykkmsg34keta17;
    }

    private String hrkykkmsg34keta18;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA18)
    public String getHrkykkmsg34keta18() {
        return hrkykkmsg34keta18;
    }

    public void setHrkykkmsg34keta18(String pHrkykkmsg34keta18) {
        hrkykkmsg34keta18 = pHrkykkmsg34keta18;
    }

    private String hrkykkmsg34keta19;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA19)
    public String getHrkykkmsg34keta19() {
        return hrkykkmsg34keta19;
    }

    public void setHrkykkmsg34keta19(String pHrkykkmsg34keta19) {
        hrkykkmsg34keta19 = pHrkykkmsg34keta19;
    }

    private String hrkykkmsg34keta20;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA20)
    public String getHrkykkmsg34keta20() {
        return hrkykkmsg34keta20;
    }

    public void setHrkykkmsg34keta20(String pHrkykkmsg34keta20) {
        hrkykkmsg34keta20 = pHrkykkmsg34keta20;
    }

    private String hrkykkmsg34keta21;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA21)
    public String getHrkykkmsg34keta21() {
        return hrkykkmsg34keta21;
    }

    public void setHrkykkmsg34keta21(String pHrkykkmsg34keta21) {
        hrkykkmsg34keta21 = pHrkykkmsg34keta21;
    }

    private String hrkykkmsg34keta22;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA22)
    public String getHrkykkmsg34keta22() {
        return hrkykkmsg34keta22;
    }

    public void setHrkykkmsg34keta22(String pHrkykkmsg34keta22) {
        hrkykkmsg34keta22 = pHrkykkmsg34keta22;
    }

    private String hrkykkmsg34keta23;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA23)
    public String getHrkykkmsg34keta23() {
        return hrkykkmsg34keta23;
    }

    public void setHrkykkmsg34keta23(String pHrkykkmsg34keta23) {
        hrkykkmsg34keta23 = pHrkykkmsg34keta23;
    }

    private String hrkykkmsg34keta24;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA24)
    public String getHrkykkmsg34keta24() {
        return hrkykkmsg34keta24;
    }

    public void setHrkykkmsg34keta24(String pHrkykkmsg34keta24) {
        hrkykkmsg34keta24 = pHrkykkmsg34keta24;
    }

    private String hrkykkmsg34keta25;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA25)
    public String getHrkykkmsg34keta25() {
        return hrkykkmsg34keta25;
    }

    public void setHrkykkmsg34keta25(String pHrkykkmsg34keta25) {
        hrkykkmsg34keta25 = pHrkykkmsg34keta25;
    }

    private String hrkykkmsg34keta26;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA26)
    public String getHrkykkmsg34keta26() {
        return hrkykkmsg34keta26;
    }

    public void setHrkykkmsg34keta26(String pHrkykkmsg34keta26) {
        hrkykkmsg34keta26 = pHrkykkmsg34keta26;
    }

    private String hrkykkmsg34keta27;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA27)
    public String getHrkykkmsg34keta27() {
        return hrkykkmsg34keta27;
    }

    public void setHrkykkmsg34keta27(String pHrkykkmsg34keta27) {
        hrkykkmsg34keta27 = pHrkykkmsg34keta27;
    }

    private String hrkykkmsg34keta28;

    @Column(name=GenIT_HrhnTtdkKan.HRKYKKMSG34KETA28)
    public String getHrkykkmsg34keta28() {
        return hrkykkmsg34keta28;
    }

    public void setHrkykkmsg34keta28(String pHrkykkmsg34keta28) {
        hrkykkmsg34keta28 = pHrkykkmsg34keta28;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_HrhnTtdkKan.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HrhnTtdkKan.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HrhnTtdkKan.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HrhnTtdkKan.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String honsyakaisouriyuu;

    @Column(name=GenIT_HrhnTtdkKan.HONSYAKAISOURIYUU)
    public String getHonsyakaisouriyuu() {
        return honsyakaisouriyuu;
    }

    public void setHonsyakaisouriyuu(String pHonsyakaisouriyuu) {
        honsyakaisouriyuu = pHonsyakaisouriyuu;
    }
}