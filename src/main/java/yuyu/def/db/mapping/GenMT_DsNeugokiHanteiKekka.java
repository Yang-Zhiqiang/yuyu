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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import yuyu.def.db.id.PKMT_DsNeugokiHanteiKekka;
import yuyu.def.db.meta.GenQMT_DsNeugokiHanteiKekka;
import yuyu.def.db.meta.QMT_DsNeugokiHanteiKekka;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ値動き判定結果テーブル テーブルのマッピング情報クラスで、 {@link MT_DsNeugokiHanteiKekka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsNeugokiHanteiKekka}</td><td colspan="3">ＤＳ値動き判定結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsNeugokiHanteiKekka ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_DsNeugokiHanteiKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuujiaatukaidrtencd bosyuujiaatukaidrtencd}</td><td>募集時Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuujibatukaidrtencd bosyuujibatukaidrtencd}</td><td>募集時Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKaiyakuhryen kaiyakuhryen}</td><td>解約返戻金（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getItijibrp itijibrp}</td><td>一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNeugokihanteikjnkngk neugokihanteikjnkngk}</td><td>値動き判定基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNeugokiwari neugokiwari}</td><td>値動き割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNeugokitoutatulinefile neugokitoutatulinefile}</td><td>値動き到達ライン（ファイル）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNeugokitoutatulinemail neugokitoutatulinemail}</td><td>値動き到達ライン（メール）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNeugokihanteiumukbn neugokihanteiumukbn}</td><td>値動き判定有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMailsousinyhkbn mailsousinyhkbn}</td><td>メール送信要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getMailaddresstourokuumukbn mailaddresstourokuumukbn}</td><td>メールアドレス登録有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsNeugokiHanteiKekka
 * @see     PKMT_DsNeugokiHanteiKekka
 * @see     QMT_DsNeugokiHanteiKekka
 * @see     GenQMT_DsNeugokiHanteiKekka
 */
@MappedSuperclass
@Table(name=GenMT_DsNeugokiHanteiKekka.TABLE_NAME)
@IdClass(value=PKMT_DsNeugokiHanteiKekka.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenMT_DsNeugokiHanteiKekka extends AbstractExDBEntity<MT_DsNeugokiHanteiKekka, PKMT_DsNeugokiHanteiKekka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsNeugokiHanteiKekka";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String SYONO                    = "syono";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESSRENBAN      = "dsmailaddressrenban";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKYMD                   = "kykymd";
    public static final String BOSYUUJIAATUKAIDRTENCD   = "bosyuujiaatukaidrtencd";
    public static final String BOSYUUJIBATUKAIDRTENCD   = "bosyuujibatukaidrtencd";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KAIYAKUHRYEN             = "kaiyakuhryen";
    public static final String ITIJIBRP                 = "itijibrp";
    public static final String NEUGOKIHANTEIKJNKNGK     = "neugokihanteikjnkngk";
    public static final String NEUGOKIWARI              = "neugokiwari";
    public static final String NEUGOKITOUTATULINEFILE   = "neugokitoutatulinefile";
    public static final String NEUGOKITOUTATULINEMAIL   = "neugokitoutatulinemail";
    public static final String NEUGOKIHANTEIUMUKBN      = "neugokihanteiumukbn";
    public static final String MAILSOUSINYHKBN          = "mailsousinyhkbn";
    public static final String MAILADDRESSTOUROKUUMUKBN = "mailaddresstourokuumukbn";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKMT_DsNeugokiHanteiKekka primaryKey;

    public GenMT_DsNeugokiHanteiKekka() {
        primaryKey = new PKMT_DsNeugokiHanteiKekka();
    }

    public GenMT_DsNeugokiHanteiKekka(BizDate pDsdatasakuseiymd, String pSyono) {
        primaryKey = new PKMT_DsNeugokiHanteiKekka(pDsdatasakuseiymd, pSyono);
    }

    @Transient
    @Override
    public PKMT_DsNeugokiHanteiKekka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsNeugokiHanteiKekka> getMetaClass() {
        return QMT_DsNeugokiHanteiKekka.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsNeugokiHanteiKekka.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsNeugokiHanteiKekka.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String dskokno;

    @Column(name=GenMT_DsNeugokiHanteiKekka.DSKOKNO)
    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private Integer dsmailaddressrenban;

    @Column(name=GenMT_DsNeugokiHanteiKekka.DSMAILADDRESSRENBAN)
    public Integer getDsmailaddressrenban() {
        return dsmailaddressrenban;
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    private String kyknmkn;

    @Column(name=GenMT_DsNeugokiHanteiKekka.KYKNMKN)
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

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsNeugokiHanteiKekka.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String bosyuujiaatukaidrtencd;

    @Column(name=GenMT_DsNeugokiHanteiKekka.BOSYUUJIAATUKAIDRTENCD)
    public String getBosyuujiaatukaidrtencd() {
        return bosyuujiaatukaidrtencd;
    }

    public void setBosyuujiaatukaidrtencd(String pBosyuujiaatukaidrtencd) {
        bosyuujiaatukaidrtencd = pBosyuujiaatukaidrtencd;
    }

    private String bosyuujibatukaidrtencd;

    @Column(name=GenMT_DsNeugokiHanteiKekka.BOSYUUJIBATUKAIDRTENCD)
    public String getBosyuujibatukaidrtencd() {
        return bosyuujibatukaidrtencd;
    }

    public void setBosyuujibatukaidrtencd(String pBosyuujibatukaidrtencd) {
        bosyuujibatukaidrtencd = pBosyuujibatukaidrtencd;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenMT_DsNeugokiHanteiKekka.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenMT_DsNeugokiHanteiKekka.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency kaiyakuhryen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhryen() {
        return kaiyakuhryen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakuhryen(BizCurrency pKaiyakuhryen) {
        kaiyakuhryen = pKaiyakuhryen;
        kaiyakuhryenValue = null;
        kaiyakuhryenType  = null;
    }

    transient private BigDecimal kaiyakuhryenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRYEN, nullable=true)
    protected BigDecimal getKaiyakuhryenValue() {
        if (kaiyakuhryenValue == null && kaiyakuhryen != null) {
            if (kaiyakuhryen.isOptional()) return null;
            return kaiyakuhryen.absolute();
        }
        return kaiyakuhryenValue;
    }

    protected void setKaiyakuhryenValue(BigDecimal value) {
        kaiyakuhryenValue = value;
        kaiyakuhryen = Optional.fromNullable(toCurrencyType(kaiyakuhryenType))
            .transform(bizCurrencyTransformer(getKaiyakuhryenValue()))
            .orNull();
    }

    transient private String kaiyakuhryenType = null;

    @Column(name=KAIYAKUHRYEN + "$", nullable=true)
    protected String getKaiyakuhryenType() {
        if (kaiyakuhryenType == null && kaiyakuhryen != null) return kaiyakuhryen.getType().toString();
        if (kaiyakuhryenType == null && getKaiyakuhryenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhryen$' should not be NULL."));
        }
        return kaiyakuhryenType;
    }

    protected void setKaiyakuhryenType(String type) {
        kaiyakuhryenType = type;
        kaiyakuhryen = Optional.fromNullable(toCurrencyType(kaiyakuhryenType))
            .transform(bizCurrencyTransformer(getKaiyakuhryenValue()))
            .orNull();
    }

    private BizCurrency itijibrp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getItijibrp() {
        return itijibrp;
    }

    public void setItijibrp(BizCurrency pItijibrp) {
        itijibrp = pItijibrp;
        itijibrpValue = null;
        itijibrpType  = null;
    }

    transient private BigDecimal itijibrpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ITIJIBRP, nullable=true)
    protected BigDecimal getItijibrpValue() {
        if (itijibrpValue == null && itijibrp != null) {
            if (itijibrp.isOptional()) return null;
            return itijibrp.absolute();
        }
        return itijibrpValue;
    }

    protected void setItijibrpValue(BigDecimal value) {
        itijibrpValue = value;
        itijibrp = Optional.fromNullable(toCurrencyType(itijibrpType))
            .transform(bizCurrencyTransformer(getItijibrpValue()))
            .orNull();
    }

    transient private String itijibrpType = null;

    @Column(name=ITIJIBRP + "$", nullable=true)
    protected String getItijibrpType() {
        if (itijibrpType == null && itijibrp != null) return itijibrp.getType().toString();
        if (itijibrpType == null && getItijibrpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'itijibrp$' should not be NULL."));
        }
        return itijibrpType;
    }

    protected void setItijibrpType(String type) {
        itijibrpType = type;
        itijibrp = Optional.fromNullable(toCurrencyType(itijibrpType))
            .transform(bizCurrencyTransformer(getItijibrpValue()))
            .orNull();
    }

    private BizCurrency neugokihanteikjnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNeugokihanteikjnkngk() {
        return neugokihanteikjnkngk;
    }

    public void setNeugokihanteikjnkngk(BizCurrency pNeugokihanteikjnkngk) {
        neugokihanteikjnkngk = pNeugokihanteikjnkngk;
        neugokihanteikjnkngkValue = null;
        neugokihanteikjnkngkType  = null;
    }

    transient private BigDecimal neugokihanteikjnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEUGOKIHANTEIKJNKNGK, nullable=true)
    protected BigDecimal getNeugokihanteikjnkngkValue() {
        if (neugokihanteikjnkngkValue == null && neugokihanteikjnkngk != null) {
            if (neugokihanteikjnkngk.isOptional()) return null;
            return neugokihanteikjnkngk.absolute();
        }
        return neugokihanteikjnkngkValue;
    }

    protected void setNeugokihanteikjnkngkValue(BigDecimal value) {
        neugokihanteikjnkngkValue = value;
        neugokihanteikjnkngk = Optional.fromNullable(toCurrencyType(neugokihanteikjnkngkType))
            .transform(bizCurrencyTransformer(getNeugokihanteikjnkngkValue()))
            .orNull();
    }

    transient private String neugokihanteikjnkngkType = null;

    @Column(name=NEUGOKIHANTEIKJNKNGK + "$", nullable=true)
    protected String getNeugokihanteikjnkngkType() {
        if (neugokihanteikjnkngkType == null && neugokihanteikjnkngk != null) return neugokihanteikjnkngk.getType().toString();
        if (neugokihanteikjnkngkType == null && getNeugokihanteikjnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'neugokihanteikjnkngk$' should not be NULL."));
        }
        return neugokihanteikjnkngkType;
    }

    protected void setNeugokihanteikjnkngkType(String type) {
        neugokihanteikjnkngkType = type;
        neugokihanteikjnkngk = Optional.fromNullable(toCurrencyType(neugokihanteikjnkngkType))
            .transform(bizCurrencyTransformer(getNeugokihanteikjnkngkValue()))
            .orNull();
    }

    private BizNumber neugokiwari;

    @Type(type="BizNumberType")
    @Column(name=GenMT_DsNeugokiHanteiKekka.NEUGOKIWARI)
    public BizNumber getNeugokiwari() {
        return neugokiwari;
    }

    public void setNeugokiwari(BizNumber pNeugokiwari) {
        neugokiwari = pNeugokiwari;
    }

    private BizNumber neugokitoutatulinefile;

    @Type(type="BizNumberType")
    @Column(name=GenMT_DsNeugokiHanteiKekka.NEUGOKITOUTATULINEFILE)
    public BizNumber getNeugokitoutatulinefile() {
        return neugokitoutatulinefile;
    }

    public void setNeugokitoutatulinefile(BizNumber pNeugokitoutatulinefile) {
        neugokitoutatulinefile = pNeugokitoutatulinefile;
    }

    private BizNumber neugokitoutatulinemail;

    @Type(type="BizNumberType")
    @Column(name=GenMT_DsNeugokiHanteiKekka.NEUGOKITOUTATULINEMAIL)
    public BizNumber getNeugokitoutatulinemail() {
        return neugokitoutatulinemail;
    }

    public void setNeugokitoutatulinemail(BizNumber pNeugokitoutatulinemail) {
        neugokitoutatulinemail = pNeugokitoutatulinemail;
    }

    private C_UmuKbn neugokihanteiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_DsNeugokiHanteiKekka.NEUGOKIHANTEIUMUKBN)
    public C_UmuKbn getNeugokihanteiumukbn() {
        return neugokihanteiumukbn;
    }

    public void setNeugokihanteiumukbn(C_UmuKbn pNeugokihanteiumukbn) {
        neugokihanteiumukbn = pNeugokihanteiumukbn;
    }

    private C_YouhiKbn mailsousinyhkbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenMT_DsNeugokiHanteiKekka.MAILSOUSINYHKBN)
    public C_YouhiKbn getMailsousinyhkbn() {
        return mailsousinyhkbn;
    }

    public void setMailsousinyhkbn(C_YouhiKbn pMailsousinyhkbn) {
        mailsousinyhkbn = pMailsousinyhkbn;
    }

    private C_UmuKbn mailaddresstourokuumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_DsNeugokiHanteiKekka.MAILADDRESSTOUROKUUMUKBN)
    public C_UmuKbn getMailaddresstourokuumukbn() {
        return mailaddresstourokuumukbn;
    }

    public void setMailaddresstourokuumukbn(C_UmuKbn pMailaddresstourokuumukbn) {
        mailaddresstourokuumukbn = pMailaddresstourokuumukbn;
    }

    private String dssousinno;

    @Column(name=GenMT_DsNeugokiHanteiKekka.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsNeugokiHanteiKekka.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsNeugokiHanteiKekka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsNeugokiHanteiKekka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}