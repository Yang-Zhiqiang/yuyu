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
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_SinkokuyokokuTuuti;
import yuyu.def.db.id.PKIT_SinkokuyokokuTuuti;
import yuyu.def.db.meta.GenQIT_SinkokuyokokuTuuti;
import yuyu.def.db.meta.QIT_SinkokuyokokuTuuti;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 申告予告通知テーブル テーブルのマッピング情報クラスで、 {@link IT_SinkokuyokokuTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SinkokuyokokuTuuti}</td><td colspan="3">申告予告通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SinkokuyokokuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SinkokuyokokuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNendo nendo}</td><td>年度</td><td align="center">{@link PKIT_SinkokuyokokuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_SinkokuyokokuTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_SinkokuyokokuTuuti ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon32keta1 aisatumongon32keta1}</td><td>挨拶文言（３２桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon32keta2 aisatumongon32keta2}</td><td>挨拶文言（３２桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumongon32keta3 aisatumongon32keta3}</td><td>挨拶文言（３２桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinkokunen sinkokunen}</td><td>申告年</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi1 midasi1}</td><td>見出し１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi2 midasi2}</td><td>見出し２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi3 midasi3}</td><td>見出し３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi4 midasi4}</td><td>見出し４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi5 midasi5}</td><td>見出し５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi6 midasi6}</td><td>見出し６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMidasi7 midasi7}</td><td>見出し７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon1 kihonjouhoumongon1}</td><td>基本情報文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon2 kihonjouhoumongon2}</td><td>基本情報文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon3 kihonjouhoumongon3}</td><td>基本情報文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon4 kihonjouhoumongon4}</td><td>基本情報文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon5 kihonjouhoumongon5}</td><td>基本情報文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon6 kihonjouhoumongon6}</td><td>基本情報文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihonjouhoumongon7 kihonjouhoumongon7}</td><td>基本情報文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewippanykkp newippanykkp}</td><td>新制度一般予告保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippanykkhaitoukin newippanykkhaitoukin}</td><td>新制度一般予告配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewippanykksyoumeigk newippanykksyoumeigk}</td><td>新制度一般予告証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryouykkp newiryouykkp}</td><td>新制度介護医療予告保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryouykkhaitoukin newiryouykkhaitoukin}</td><td>新制度介護医療予告配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewiryouykksyoumeigk newiryouykksyoumeigk}</td><td>新制度介護医療予告証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnenkinykkp newnenkinykkp}</td><td>新制度年金予告保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnenkinykkhaitoukin newnenkinykkhaitoukin}</td><td>新制度年金予告配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewnenkinykksyoumeigk newnenkinykksyoumeigk}</td><td>新制度年金予告証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHknjyutoukikan hknjyutoukikan}</td><td>（帳票用）保険料充当期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getGoryuuinm goryuuinm}</td><td>ご留意メッセージ名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg1 goryuuimsg1}</td><td>ご留意メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg2 goryuuimsg2}</td><td>ご留意メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg3 goryuuimsg3}</td><td>ご留意メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg4 goryuuimsg4}</td><td>ご留意メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg5 goryuuimsg5}</td><td>ご留意メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg6 goryuuimsg6}</td><td>ご留意メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg7 goryuuimsg7}</td><td>ご留意メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg8 goryuuimsg8}</td><td>ご留意メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGoryuuimsg9 goryuuimsg9}</td><td>ご留意メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFreearea32keta1 freearea32keta1}</td><td>フリーエリア（３２桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFreearea32keta2 freearea32keta2}</td><td>フリーエリア（３２桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFreearea32keta3 freearea32keta3}</td><td>フリーエリア（３２桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFreearea32keta4 freearea32keta4}</td><td>フリーエリア（３２桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFreearea32keta5 freearea32keta5}</td><td>フリーエリア（３２桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsgnm kaiseimsgnm}</td><td>改正メッセージ名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg1 kaiseimsg1}</td><td>改正メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg2 kaiseimsg2}</td><td>改正メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg3 kaiseimsg3}</td><td>改正メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg4 kaiseimsg4}</td><td>改正メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg5 kaiseimsg5}</td><td>改正メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg6 kaiseimsg6}</td><td>改正メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiseimsg7 kaiseimsg7}</td><td>改正メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SinkokuyokokuTuuti
 * @see     PKIT_SinkokuyokokuTuuti
 * @see     QIT_SinkokuyokokuTuuti
 * @see     GenQIT_SinkokuyokokuTuuti
 */
@MappedSuperclass
@Table(name=GenIT_SinkokuyokokuTuuti.TABLE_NAME)
@IdClass(value=PKIT_SinkokuyokokuTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_SinkokuyokokuTuuti extends AbstractExDBEntity<IT_SinkokuyokokuTuuti, PKIT_SinkokuyokokuTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SinkokuyokokuTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String NENDO                    = "nendo";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String RENNO                    = "renno";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String AISATUMONGON32KETA1      = "aisatumongon32keta1";
    public static final String AISATUMONGON32KETA2      = "aisatumongon32keta2";
    public static final String AISATUMONGON32KETA3      = "aisatumongon32keta3";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String SINKOKUNEN               = "sinkokunen";
    public static final String MIDASI1                  = "midasi1";
    public static final String MIDASI2                  = "midasi2";
    public static final String MIDASI3                  = "midasi3";
    public static final String MIDASI4                  = "midasi4";
    public static final String MIDASI5                  = "midasi5";
    public static final String MIDASI6                  = "midasi6";
    public static final String MIDASI7                  = "midasi7";
    public static final String KIHONJOUHOUMONGON1       = "kihonjouhoumongon1";
    public static final String KIHONJOUHOUMONGON2       = "kihonjouhoumongon2";
    public static final String KIHONJOUHOUMONGON3       = "kihonjouhoumongon3";
    public static final String KIHONJOUHOUMONGON4       = "kihonjouhoumongon4";
    public static final String KIHONJOUHOUMONGON5       = "kihonjouhoumongon5";
    public static final String KIHONJOUHOUMONGON6       = "kihonjouhoumongon6";
    public static final String KIHONJOUHOUMONGON7       = "kihonjouhoumongon7";
    public static final String NEWIPPANYKKP             = "newippanykkp";
    public static final String NEWIPPANYKKHAITOUKIN     = "newippanykkhaitoukin";
    public static final String NEWIPPANYKKSYOUMEIGK     = "newippanykksyoumeigk";
    public static final String NEWIRYOUYKKP             = "newiryouykkp";
    public static final String NEWIRYOUYKKHAITOUKIN     = "newiryouykkhaitoukin";
    public static final String NEWIRYOUYKKSYOUMEIGK     = "newiryouykksyoumeigk";
    public static final String NEWNENKINYKKP            = "newnenkinykkp";
    public static final String NEWNENKINYKKHAITOUKIN    = "newnenkinykkhaitoukin";
    public static final String NEWNENKINYKKSYOUMEIGK    = "newnenkinykksyoumeigk";
    public static final String HKNJYUTOUKIKAN           = "hknjyutoukikan";
    public static final String KYKYMD                   = "kykymd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String GORYUUINM                = "goryuuinm";
    public static final String GORYUUIMSG1              = "goryuuimsg1";
    public static final String GORYUUIMSG2              = "goryuuimsg2";
    public static final String GORYUUIMSG3              = "goryuuimsg3";
    public static final String GORYUUIMSG4              = "goryuuimsg4";
    public static final String GORYUUIMSG5              = "goryuuimsg5";
    public static final String GORYUUIMSG6              = "goryuuimsg6";
    public static final String GORYUUIMSG7              = "goryuuimsg7";
    public static final String GORYUUIMSG8              = "goryuuimsg8";
    public static final String GORYUUIMSG9              = "goryuuimsg9";
    public static final String FREEAREA32KETA1          = "freearea32keta1";
    public static final String FREEAREA32KETA2          = "freearea32keta2";
    public static final String FREEAREA32KETA3          = "freearea32keta3";
    public static final String FREEAREA32KETA4          = "freearea32keta4";
    public static final String FREEAREA32KETA5          = "freearea32keta5";
    public static final String KAISEIMSGNM              = "kaiseimsgnm";
    public static final String KAISEIMSG1               = "kaiseimsg1";
    public static final String KAISEIMSG2               = "kaiseimsg2";
    public static final String KAISEIMSG3               = "kaiseimsg3";
    public static final String KAISEIMSG4               = "kaiseimsg4";
    public static final String KAISEIMSG5               = "kaiseimsg5";
    public static final String KAISEIMSG6               = "kaiseimsg6";
    public static final String KAISEIMSG7               = "kaiseimsg7";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SinkokuyokokuTuuti primaryKey;

    public GenIT_SinkokuyokokuTuuti() {
        primaryKey = new PKIT_SinkokuyokokuTuuti();
    }

    public GenIT_SinkokuyokokuTuuti(
        String pKbnkey,
        String pSyono,
        String pNendo,
        BizDate pTyouhyouymd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_SinkokuyokokuTuuti(
            pKbnkey,
            pSyono,
            pNendo,
            pTyouhyouymd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_SinkokuyokokuTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SinkokuyokokuTuuti> getMetaClass() {
        return QIT_SinkokuyokokuTuuti.class;
    }

    @Id
    @Column(name=GenIT_SinkokuyokokuTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SinkokuyokokuTuuti.SYONO)
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
    @Column(name=GenIT_SinkokuyokokuTuuti.NENDO)
    public String getNendo() {
        return getPrimaryKey().getNendo();
    }

    public void setNendo(String pNendo) {
        getPrimaryKey().setNendo(pNendo);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_SinkokuyokokuTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    @Id
    @Column(name=GenIT_SinkokuyokokuTuuti.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_SinkokuyokokuTuuti.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_SinkokuyokokuTuuti.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String tsinyno;

    @Column(name=GenIT_SinkokuyokokuTuuti.TSINYNO)
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

    @Column(name=GenIT_SinkokuyokokuTuuti.TSINADR1KJ)
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

    @Column(name=GenIT_SinkokuyokokuTuuti.TSINADR2KJ)
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

    @Column(name=GenIT_SinkokuyokokuTuuti.TSINADR3KJ)
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

    private String toiawasesosikinmkj;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASESOSIKINMKJ)
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

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASETELNO)
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

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_SinkokuyokokuTuuti.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private String aisatumongon32keta1;

    @Column(name=GenIT_SinkokuyokokuTuuti.AISATUMONGON32KETA1)
    public String getAisatumongon32keta1() {
        return aisatumongon32keta1;
    }

    public void setAisatumongon32keta1(String pAisatumongon32keta1) {
        aisatumongon32keta1 = pAisatumongon32keta1;
    }

    private String aisatumongon32keta2;

    @Column(name=GenIT_SinkokuyokokuTuuti.AISATUMONGON32KETA2)
    public String getAisatumongon32keta2() {
        return aisatumongon32keta2;
    }

    public void setAisatumongon32keta2(String pAisatumongon32keta2) {
        aisatumongon32keta2 = pAisatumongon32keta2;
    }

    private String aisatumongon32keta3;

    @Column(name=GenIT_SinkokuyokokuTuuti.AISATUMONGON32KETA3)
    public String getAisatumongon32keta3() {
        return aisatumongon32keta3;
    }

    public void setAisatumongon32keta3(String pAisatumongon32keta3) {
        aisatumongon32keta3 = pAisatumongon32keta3;
    }

    private String kyknmkj;

    @Column(name=GenIT_SinkokuyokokuTuuti.KYKNMKJ)
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

    private String sinkokunen;

    @Column(name=GenIT_SinkokuyokokuTuuti.SINKOKUNEN)
    public String getSinkokunen() {
        return sinkokunen;
    }

    public void setSinkokunen(String pSinkokunen) {
        sinkokunen = pSinkokunen;
    }

    private String midasi1;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI1)
    public String getMidasi1() {
        return midasi1;
    }

    public void setMidasi1(String pMidasi1) {
        midasi1 = pMidasi1;
    }

    private String midasi2;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI2)
    public String getMidasi2() {
        return midasi2;
    }

    public void setMidasi2(String pMidasi2) {
        midasi2 = pMidasi2;
    }

    private String midasi3;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI3)
    public String getMidasi3() {
        return midasi3;
    }

    public void setMidasi3(String pMidasi3) {
        midasi3 = pMidasi3;
    }

    private String midasi4;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI4)
    public String getMidasi4() {
        return midasi4;
    }

    public void setMidasi4(String pMidasi4) {
        midasi4 = pMidasi4;
    }

    private String midasi5;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI5)
    public String getMidasi5() {
        return midasi5;
    }

    public void setMidasi5(String pMidasi5) {
        midasi5 = pMidasi5;
    }

    private String midasi6;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI6)
    public String getMidasi6() {
        return midasi6;
    }

    public void setMidasi6(String pMidasi6) {
        midasi6 = pMidasi6;
    }

    private String midasi7;

    @Column(name=GenIT_SinkokuyokokuTuuti.MIDASI7)
    public String getMidasi7() {
        return midasi7;
    }

    public void setMidasi7(String pMidasi7) {
        midasi7 = pMidasi7;
    }

    private String kihonjouhoumongon1;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON1)
    public String getKihonjouhoumongon1() {
        return kihonjouhoumongon1;
    }

    public void setKihonjouhoumongon1(String pKihonjouhoumongon1) {
        kihonjouhoumongon1 = pKihonjouhoumongon1;
    }

    private String kihonjouhoumongon2;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON2)
    public String getKihonjouhoumongon2() {
        return kihonjouhoumongon2;
    }

    public void setKihonjouhoumongon2(String pKihonjouhoumongon2) {
        kihonjouhoumongon2 = pKihonjouhoumongon2;
    }

    private String kihonjouhoumongon3;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON3)
    public String getKihonjouhoumongon3() {
        return kihonjouhoumongon3;
    }

    public void setKihonjouhoumongon3(String pKihonjouhoumongon3) {
        kihonjouhoumongon3 = pKihonjouhoumongon3;
    }

    private String kihonjouhoumongon4;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON4)
    public String getKihonjouhoumongon4() {
        return kihonjouhoumongon4;
    }

    public void setKihonjouhoumongon4(String pKihonjouhoumongon4) {
        kihonjouhoumongon4 = pKihonjouhoumongon4;
    }

    private String kihonjouhoumongon5;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON5)
    public String getKihonjouhoumongon5() {
        return kihonjouhoumongon5;
    }

    public void setKihonjouhoumongon5(String pKihonjouhoumongon5) {
        kihonjouhoumongon5 = pKihonjouhoumongon5;
    }

    private String kihonjouhoumongon6;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON6)
    public String getKihonjouhoumongon6() {
        return kihonjouhoumongon6;
    }

    public void setKihonjouhoumongon6(String pKihonjouhoumongon6) {
        kihonjouhoumongon6 = pKihonjouhoumongon6;
    }

    private String kihonjouhoumongon7;

    @Column(name=GenIT_SinkokuyokokuTuuti.KIHONJOUHOUMONGON7)
    public String getKihonjouhoumongon7() {
        return kihonjouhoumongon7;
    }

    public void setKihonjouhoumongon7(String pKihonjouhoumongon7) {
        kihonjouhoumongon7 = pKihonjouhoumongon7;
    }

    private BizCurrency newippanykkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippanykkp() {
        return newippanykkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippanykkp(BizCurrency pNewippanykkp) {
        newippanykkp = pNewippanykkp;
        newippanykkpValue = null;
        newippanykkpType  = null;
    }

    transient private BigDecimal newippanykkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANYKKP, nullable=true)
    protected BigDecimal getNewippanykkpValue() {
        if (newippanykkpValue == null && newippanykkp != null) {
            if (newippanykkp.isOptional()) return null;
            return newippanykkp.absolute();
        }
        return newippanykkpValue;
    }

    protected void setNewippanykkpValue(BigDecimal value) {
        newippanykkpValue = value;
        newippanykkp = Optional.fromNullable(toCurrencyType(newippanykkpType))
            .transform(bizCurrencyTransformer(getNewippanykkpValue()))
            .orNull();
    }

    transient private String newippanykkpType = null;

    @Column(name=NEWIPPANYKKP + "$", nullable=true)
    protected String getNewippanykkpType() {
        if (newippanykkpType == null && newippanykkp != null) return newippanykkp.getType().toString();
        if (newippanykkpType == null && getNewippanykkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippanykkp$' should not be NULL."));
        }
        return newippanykkpType;
    }

    protected void setNewippanykkpType(String type) {
        newippanykkpType = type;
        newippanykkp = Optional.fromNullable(toCurrencyType(newippanykkpType))
            .transform(bizCurrencyTransformer(getNewippanykkpValue()))
            .orNull();
    }

    private BizCurrency newippanykkhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippanykkhaitoukin() {
        return newippanykkhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippanykkhaitoukin(BizCurrency pNewippanykkhaitoukin) {
        newippanykkhaitoukin = pNewippanykkhaitoukin;
        newippanykkhaitoukinValue = null;
        newippanykkhaitoukinType  = null;
    }

    transient private BigDecimal newippanykkhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANYKKHAITOUKIN, nullable=true)
    protected BigDecimal getNewippanykkhaitoukinValue() {
        if (newippanykkhaitoukinValue == null && newippanykkhaitoukin != null) {
            if (newippanykkhaitoukin.isOptional()) return null;
            return newippanykkhaitoukin.absolute();
        }
        return newippanykkhaitoukinValue;
    }

    protected void setNewippanykkhaitoukinValue(BigDecimal value) {
        newippanykkhaitoukinValue = value;
        newippanykkhaitoukin = Optional.fromNullable(toCurrencyType(newippanykkhaitoukinType))
            .transform(bizCurrencyTransformer(getNewippanykkhaitoukinValue()))
            .orNull();
    }

    transient private String newippanykkhaitoukinType = null;

    @Column(name=NEWIPPANYKKHAITOUKIN + "$", nullable=true)
    protected String getNewippanykkhaitoukinType() {
        if (newippanykkhaitoukinType == null && newippanykkhaitoukin != null) return newippanykkhaitoukin.getType().toString();
        if (newippanykkhaitoukinType == null && getNewippanykkhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippanykkhaitoukin$' should not be NULL."));
        }
        return newippanykkhaitoukinType;
    }

    protected void setNewippanykkhaitoukinType(String type) {
        newippanykkhaitoukinType = type;
        newippanykkhaitoukin = Optional.fromNullable(toCurrencyType(newippanykkhaitoukinType))
            .transform(bizCurrencyTransformer(getNewippanykkhaitoukinValue()))
            .orNull();
    }

    private BizCurrency newippanykksyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewippanykksyoumeigk() {
        return newippanykksyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewippanykksyoumeigk(BizCurrency pNewippanykksyoumeigk) {
        newippanykksyoumeigk = pNewippanykksyoumeigk;
        newippanykksyoumeigkValue = null;
        newippanykksyoumeigkType  = null;
    }

    transient private BigDecimal newippanykksyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIPPANYKKSYOUMEIGK, nullable=true)
    protected BigDecimal getNewippanykksyoumeigkValue() {
        if (newippanykksyoumeigkValue == null && newippanykksyoumeigk != null) {
            if (newippanykksyoumeigk.isOptional()) return null;
            return newippanykksyoumeigk.absolute();
        }
        return newippanykksyoumeigkValue;
    }

    protected void setNewippanykksyoumeigkValue(BigDecimal value) {
        newippanykksyoumeigkValue = value;
        newippanykksyoumeigk = Optional.fromNullable(toCurrencyType(newippanykksyoumeigkType))
            .transform(bizCurrencyTransformer(getNewippanykksyoumeigkValue()))
            .orNull();
    }

    transient private String newippanykksyoumeigkType = null;

    @Column(name=NEWIPPANYKKSYOUMEIGK + "$", nullable=true)
    protected String getNewippanykksyoumeigkType() {
        if (newippanykksyoumeigkType == null && newippanykksyoumeigk != null) return newippanykksyoumeigk.getType().toString();
        if (newippanykksyoumeigkType == null && getNewippanykksyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newippanykksyoumeigk$' should not be NULL."));
        }
        return newippanykksyoumeigkType;
    }

    protected void setNewippanykksyoumeigkType(String type) {
        newippanykksyoumeigkType = type;
        newippanykksyoumeigk = Optional.fromNullable(toCurrencyType(newippanykksyoumeigkType))
            .transform(bizCurrencyTransformer(getNewippanykksyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newiryouykkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryouykkp() {
        return newiryouykkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryouykkp(BizCurrency pNewiryouykkp) {
        newiryouykkp = pNewiryouykkp;
        newiryouykkpValue = null;
        newiryouykkpType  = null;
    }

    transient private BigDecimal newiryouykkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUYKKP, nullable=true)
    protected BigDecimal getNewiryouykkpValue() {
        if (newiryouykkpValue == null && newiryouykkp != null) {
            if (newiryouykkp.isOptional()) return null;
            return newiryouykkp.absolute();
        }
        return newiryouykkpValue;
    }

    protected void setNewiryouykkpValue(BigDecimal value) {
        newiryouykkpValue = value;
        newiryouykkp = Optional.fromNullable(toCurrencyType(newiryouykkpType))
            .transform(bizCurrencyTransformer(getNewiryouykkpValue()))
            .orNull();
    }

    transient private String newiryouykkpType = null;

    @Column(name=NEWIRYOUYKKP + "$", nullable=true)
    protected String getNewiryouykkpType() {
        if (newiryouykkpType == null && newiryouykkp != null) return newiryouykkp.getType().toString();
        if (newiryouykkpType == null && getNewiryouykkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryouykkp$' should not be NULL."));
        }
        return newiryouykkpType;
    }

    protected void setNewiryouykkpType(String type) {
        newiryouykkpType = type;
        newiryouykkp = Optional.fromNullable(toCurrencyType(newiryouykkpType))
            .transform(bizCurrencyTransformer(getNewiryouykkpValue()))
            .orNull();
    }

    private BizCurrency newiryouykkhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryouykkhaitoukin() {
        return newiryouykkhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryouykkhaitoukin(BizCurrency pNewiryouykkhaitoukin) {
        newiryouykkhaitoukin = pNewiryouykkhaitoukin;
        newiryouykkhaitoukinValue = null;
        newiryouykkhaitoukinType  = null;
    }

    transient private BigDecimal newiryouykkhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUYKKHAITOUKIN, nullable=true)
    protected BigDecimal getNewiryouykkhaitoukinValue() {
        if (newiryouykkhaitoukinValue == null && newiryouykkhaitoukin != null) {
            if (newiryouykkhaitoukin.isOptional()) return null;
            return newiryouykkhaitoukin.absolute();
        }
        return newiryouykkhaitoukinValue;
    }

    protected void setNewiryouykkhaitoukinValue(BigDecimal value) {
        newiryouykkhaitoukinValue = value;
        newiryouykkhaitoukin = Optional.fromNullable(toCurrencyType(newiryouykkhaitoukinType))
            .transform(bizCurrencyTransformer(getNewiryouykkhaitoukinValue()))
            .orNull();
    }

    transient private String newiryouykkhaitoukinType = null;

    @Column(name=NEWIRYOUYKKHAITOUKIN + "$", nullable=true)
    protected String getNewiryouykkhaitoukinType() {
        if (newiryouykkhaitoukinType == null && newiryouykkhaitoukin != null) return newiryouykkhaitoukin.getType().toString();
        if (newiryouykkhaitoukinType == null && getNewiryouykkhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryouykkhaitoukin$' should not be NULL."));
        }
        return newiryouykkhaitoukinType;
    }

    protected void setNewiryouykkhaitoukinType(String type) {
        newiryouykkhaitoukinType = type;
        newiryouykkhaitoukin = Optional.fromNullable(toCurrencyType(newiryouykkhaitoukinType))
            .transform(bizCurrencyTransformer(getNewiryouykkhaitoukinValue()))
            .orNull();
    }

    private BizCurrency newiryouykksyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewiryouykksyoumeigk() {
        return newiryouykksyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewiryouykksyoumeigk(BizCurrency pNewiryouykksyoumeigk) {
        newiryouykksyoumeigk = pNewiryouykksyoumeigk;
        newiryouykksyoumeigkValue = null;
        newiryouykksyoumeigkType  = null;
    }

    transient private BigDecimal newiryouykksyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWIRYOUYKKSYOUMEIGK, nullable=true)
    protected BigDecimal getNewiryouykksyoumeigkValue() {
        if (newiryouykksyoumeigkValue == null && newiryouykksyoumeigk != null) {
            if (newiryouykksyoumeigk.isOptional()) return null;
            return newiryouykksyoumeigk.absolute();
        }
        return newiryouykksyoumeigkValue;
    }

    protected void setNewiryouykksyoumeigkValue(BigDecimal value) {
        newiryouykksyoumeigkValue = value;
        newiryouykksyoumeigk = Optional.fromNullable(toCurrencyType(newiryouykksyoumeigkType))
            .transform(bizCurrencyTransformer(getNewiryouykksyoumeigkValue()))
            .orNull();
    }

    transient private String newiryouykksyoumeigkType = null;

    @Column(name=NEWIRYOUYKKSYOUMEIGK + "$", nullable=true)
    protected String getNewiryouykksyoumeigkType() {
        if (newiryouykksyoumeigkType == null && newiryouykksyoumeigk != null) return newiryouykksyoumeigk.getType().toString();
        if (newiryouykksyoumeigkType == null && getNewiryouykksyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newiryouykksyoumeigk$' should not be NULL."));
        }
        return newiryouykksyoumeigkType;
    }

    protected void setNewiryouykksyoumeigkType(String type) {
        newiryouykksyoumeigkType = type;
        newiryouykksyoumeigk = Optional.fromNullable(toCurrencyType(newiryouykksyoumeigkType))
            .transform(bizCurrencyTransformer(getNewiryouykksyoumeigkValue()))
            .orNull();
    }

    private BizCurrency newnenkinykkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnenkinykkp() {
        return newnenkinykkp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnenkinykkp(BizCurrency pNewnenkinykkp) {
        newnenkinykkp = pNewnenkinykkp;
        newnenkinykkpValue = null;
        newnenkinykkpType  = null;
    }

    transient private BigDecimal newnenkinykkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNENKINYKKP, nullable=true)
    protected BigDecimal getNewnenkinykkpValue() {
        if (newnenkinykkpValue == null && newnenkinykkp != null) {
            if (newnenkinykkp.isOptional()) return null;
            return newnenkinykkp.absolute();
        }
        return newnenkinykkpValue;
    }

    protected void setNewnenkinykkpValue(BigDecimal value) {
        newnenkinykkpValue = value;
        newnenkinykkp = Optional.fromNullable(toCurrencyType(newnenkinykkpType))
            .transform(bizCurrencyTransformer(getNewnenkinykkpValue()))
            .orNull();
    }

    transient private String newnenkinykkpType = null;

    @Column(name=NEWNENKINYKKP + "$", nullable=true)
    protected String getNewnenkinykkpType() {
        if (newnenkinykkpType == null && newnenkinykkp != null) return newnenkinykkp.getType().toString();
        if (newnenkinykkpType == null && getNewnenkinykkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnenkinykkp$' should not be NULL."));
        }
        return newnenkinykkpType;
    }

    protected void setNewnenkinykkpType(String type) {
        newnenkinykkpType = type;
        newnenkinykkp = Optional.fromNullable(toCurrencyType(newnenkinykkpType))
            .transform(bizCurrencyTransformer(getNewnenkinykkpValue()))
            .orNull();
    }

    private BizCurrency newnenkinykkhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnenkinykkhaitoukin() {
        return newnenkinykkhaitoukin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnenkinykkhaitoukin(BizCurrency pNewnenkinykkhaitoukin) {
        newnenkinykkhaitoukin = pNewnenkinykkhaitoukin;
        newnenkinykkhaitoukinValue = null;
        newnenkinykkhaitoukinType  = null;
    }

    transient private BigDecimal newnenkinykkhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNENKINYKKHAITOUKIN, nullable=true)
    protected BigDecimal getNewnenkinykkhaitoukinValue() {
        if (newnenkinykkhaitoukinValue == null && newnenkinykkhaitoukin != null) {
            if (newnenkinykkhaitoukin.isOptional()) return null;
            return newnenkinykkhaitoukin.absolute();
        }
        return newnenkinykkhaitoukinValue;
    }

    protected void setNewnenkinykkhaitoukinValue(BigDecimal value) {
        newnenkinykkhaitoukinValue = value;
        newnenkinykkhaitoukin = Optional.fromNullable(toCurrencyType(newnenkinykkhaitoukinType))
            .transform(bizCurrencyTransformer(getNewnenkinykkhaitoukinValue()))
            .orNull();
    }

    transient private String newnenkinykkhaitoukinType = null;

    @Column(name=NEWNENKINYKKHAITOUKIN + "$", nullable=true)
    protected String getNewnenkinykkhaitoukinType() {
        if (newnenkinykkhaitoukinType == null && newnenkinykkhaitoukin != null) return newnenkinykkhaitoukin.getType().toString();
        if (newnenkinykkhaitoukinType == null && getNewnenkinykkhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnenkinykkhaitoukin$' should not be NULL."));
        }
        return newnenkinykkhaitoukinType;
    }

    protected void setNewnenkinykkhaitoukinType(String type) {
        newnenkinykkhaitoukinType = type;
        newnenkinykkhaitoukin = Optional.fromNullable(toCurrencyType(newnenkinykkhaitoukinType))
            .transform(bizCurrencyTransformer(getNewnenkinykkhaitoukinValue()))
            .orNull();
    }

    private BizCurrency newnenkinykksyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewnenkinykksyoumeigk() {
        return newnenkinykksyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewnenkinykksyoumeigk(BizCurrency pNewnenkinykksyoumeigk) {
        newnenkinykksyoumeigk = pNewnenkinykksyoumeigk;
        newnenkinykksyoumeigkValue = null;
        newnenkinykksyoumeigkType  = null;
    }

    transient private BigDecimal newnenkinykksyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWNENKINYKKSYOUMEIGK, nullable=true)
    protected BigDecimal getNewnenkinykksyoumeigkValue() {
        if (newnenkinykksyoumeigkValue == null && newnenkinykksyoumeigk != null) {
            if (newnenkinykksyoumeigk.isOptional()) return null;
            return newnenkinykksyoumeigk.absolute();
        }
        return newnenkinykksyoumeigkValue;
    }

    protected void setNewnenkinykksyoumeigkValue(BigDecimal value) {
        newnenkinykksyoumeigkValue = value;
        newnenkinykksyoumeigk = Optional.fromNullable(toCurrencyType(newnenkinykksyoumeigkType))
            .transform(bizCurrencyTransformer(getNewnenkinykksyoumeigkValue()))
            .orNull();
    }

    transient private String newnenkinykksyoumeigkType = null;

    @Column(name=NEWNENKINYKKSYOUMEIGK + "$", nullable=true)
    protected String getNewnenkinykksyoumeigkType() {
        if (newnenkinykksyoumeigkType == null && newnenkinykksyoumeigk != null) return newnenkinykksyoumeigk.getType().toString();
        if (newnenkinykksyoumeigkType == null && getNewnenkinykksyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newnenkinykksyoumeigk$' should not be NULL."));
        }
        return newnenkinykksyoumeigkType;
    }

    protected void setNewnenkinykksyoumeigkType(String type) {
        newnenkinykksyoumeigkType = type;
        newnenkinykksyoumeigk = Optional.fromNullable(toCurrencyType(newnenkinykksyoumeigkType))
            .transform(bizCurrencyTransformer(getNewnenkinykksyoumeigkValue()))
            .orNull();
    }

    private String hknjyutoukikan;

    @Column(name=GenIT_SinkokuyokokuTuuti.HKNJYUTOUKIKAN)
    public String getHknjyutoukikan() {
        return hknjyutoukikan;
    }

    public void setHknjyutoukikan(String pHknjyutoukikan) {
        hknjyutoukikan = pHknjyutoukikan;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SinkokuyokokuTuuti.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_SinkokuyokokuTuuti.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String goryuuinm;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUINM)
    public String getGoryuuinm() {
        return goryuuinm;
    }

    public void setGoryuuinm(String pGoryuuinm) {
        goryuuinm = pGoryuuinm;
    }

    private String goryuuimsg1;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG1)
    public String getGoryuuimsg1() {
        return goryuuimsg1;
    }

    public void setGoryuuimsg1(String pGoryuuimsg1) {
        goryuuimsg1 = pGoryuuimsg1;
    }

    private String goryuuimsg2;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG2)
    public String getGoryuuimsg2() {
        return goryuuimsg2;
    }

    public void setGoryuuimsg2(String pGoryuuimsg2) {
        goryuuimsg2 = pGoryuuimsg2;
    }

    private String goryuuimsg3;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG3)
    public String getGoryuuimsg3() {
        return goryuuimsg3;
    }

    public void setGoryuuimsg3(String pGoryuuimsg3) {
        goryuuimsg3 = pGoryuuimsg3;
    }

    private String goryuuimsg4;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG4)
    public String getGoryuuimsg4() {
        return goryuuimsg4;
    }

    public void setGoryuuimsg4(String pGoryuuimsg4) {
        goryuuimsg4 = pGoryuuimsg4;
    }

    private String goryuuimsg5;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG5)
    public String getGoryuuimsg5() {
        return goryuuimsg5;
    }

    public void setGoryuuimsg5(String pGoryuuimsg5) {
        goryuuimsg5 = pGoryuuimsg5;
    }

    private String goryuuimsg6;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG6)
    public String getGoryuuimsg6() {
        return goryuuimsg6;
    }

    public void setGoryuuimsg6(String pGoryuuimsg6) {
        goryuuimsg6 = pGoryuuimsg6;
    }

    private String goryuuimsg7;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG7)
    public String getGoryuuimsg7() {
        return goryuuimsg7;
    }

    public void setGoryuuimsg7(String pGoryuuimsg7) {
        goryuuimsg7 = pGoryuuimsg7;
    }

    private String goryuuimsg8;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG8)
    public String getGoryuuimsg8() {
        return goryuuimsg8;
    }

    public void setGoryuuimsg8(String pGoryuuimsg8) {
        goryuuimsg8 = pGoryuuimsg8;
    }

    private String goryuuimsg9;

    @Column(name=GenIT_SinkokuyokokuTuuti.GORYUUIMSG9)
    public String getGoryuuimsg9() {
        return goryuuimsg9;
    }

    public void setGoryuuimsg9(String pGoryuuimsg9) {
        goryuuimsg9 = pGoryuuimsg9;
    }

    private String freearea32keta1;

    @Column(name=GenIT_SinkokuyokokuTuuti.FREEAREA32KETA1)
    public String getFreearea32keta1() {
        return freearea32keta1;
    }

    public void setFreearea32keta1(String pFreearea32keta1) {
        freearea32keta1 = pFreearea32keta1;
    }

    private String freearea32keta2;

    @Column(name=GenIT_SinkokuyokokuTuuti.FREEAREA32KETA2)
    public String getFreearea32keta2() {
        return freearea32keta2;
    }

    public void setFreearea32keta2(String pFreearea32keta2) {
        freearea32keta2 = pFreearea32keta2;
    }

    private String freearea32keta3;

    @Column(name=GenIT_SinkokuyokokuTuuti.FREEAREA32KETA3)
    public String getFreearea32keta3() {
        return freearea32keta3;
    }

    public void setFreearea32keta3(String pFreearea32keta3) {
        freearea32keta3 = pFreearea32keta3;
    }

    private String freearea32keta4;

    @Column(name=GenIT_SinkokuyokokuTuuti.FREEAREA32KETA4)
    public String getFreearea32keta4() {
        return freearea32keta4;
    }

    public void setFreearea32keta4(String pFreearea32keta4) {
        freearea32keta4 = pFreearea32keta4;
    }

    private String freearea32keta5;

    @Column(name=GenIT_SinkokuyokokuTuuti.FREEAREA32KETA5)
    public String getFreearea32keta5() {
        return freearea32keta5;
    }

    public void setFreearea32keta5(String pFreearea32keta5) {
        freearea32keta5 = pFreearea32keta5;
    }

    private String kaiseimsgnm;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSGNM)
    public String getKaiseimsgnm() {
        return kaiseimsgnm;
    }

    public void setKaiseimsgnm(String pKaiseimsgnm) {
        kaiseimsgnm = pKaiseimsgnm;
    }

    private String kaiseimsg1;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG1)
    public String getKaiseimsg1() {
        return kaiseimsg1;
    }

    public void setKaiseimsg1(String pKaiseimsg1) {
        kaiseimsg1 = pKaiseimsg1;
    }

    private String kaiseimsg2;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG2)
    public String getKaiseimsg2() {
        return kaiseimsg2;
    }

    public void setKaiseimsg2(String pKaiseimsg2) {
        kaiseimsg2 = pKaiseimsg2;
    }

    private String kaiseimsg3;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG3)
    public String getKaiseimsg3() {
        return kaiseimsg3;
    }

    public void setKaiseimsg3(String pKaiseimsg3) {
        kaiseimsg3 = pKaiseimsg3;
    }

    private String kaiseimsg4;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG4)
    public String getKaiseimsg4() {
        return kaiseimsg4;
    }

    public void setKaiseimsg4(String pKaiseimsg4) {
        kaiseimsg4 = pKaiseimsg4;
    }

    private String kaiseimsg5;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG5)
    public String getKaiseimsg5() {
        return kaiseimsg5;
    }

    public void setKaiseimsg5(String pKaiseimsg5) {
        kaiseimsg5 = pKaiseimsg5;
    }

    private String kaiseimsg6;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG6)
    public String getKaiseimsg6() {
        return kaiseimsg6;
    }

    public void setKaiseimsg6(String pKaiseimsg6) {
        kaiseimsg6 = pKaiseimsg6;
    }

    private String kaiseimsg7;

    @Column(name=GenIT_SinkokuyokokuTuuti.KAISEIMSG7)
    public String getKaiseimsg7() {
        return kaiseimsg7;
    }

    public void setKaiseimsg7(String pKaiseimsg7) {
        kaiseimsg7 = pKaiseimsg7;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SinkokuyokokuTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SinkokuyokokuTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SinkokuyokokuTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}