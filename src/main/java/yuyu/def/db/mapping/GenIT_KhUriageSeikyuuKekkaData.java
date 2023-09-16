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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.id.PKIT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.meta.GenQIT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.meta.QIT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上請求結果データテーブル テーブルのマッピング情報クラスで、 {@link IT_KhUriageSeikyuuKekkaData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhUriageSeikyuuKekkaData}</td><td colspan="3">売上請求結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhUriageSeikyuuKekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhUriageSeikyuuKekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_KhUriageSeikyuuKekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">{@link PKIT_KhUriageSeikyuuKekkaData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_KhUriageSeikyuuKekkaData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRecordno recordno}</td><td>レコード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAuthorikbn authorikbn}</td><td>オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthoriKbn}</td></tr>
 *  <tr><td>{@link #getUriageseikyuutorihikicd uriageseikyuutorihikicd}</td><td>売上請求取引コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCredityuukoukigen credityuukoukigen}</td><td>クレジット有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredituriagegk credituriagegk}</td><td>クレジットカード売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getCreditkaiinnokami6keta creditkaiinnokami6keta}</td><td>クレジット会員番号（上６桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkaiinnosimo4keta creditkaiinnosimo4keta}</td><td>クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriageseikyuuerrorcd uriageseikyuuerrorcd}</td><td>売上請求エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredituriagengjiyuu credituriagengjiyuu}</td><td>クレジットカード売上請求ＮＧ事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>{@link #getFukusuukameitennokey fukusuukameitennokey}</td><td>複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhUriageSeikyuuKekkaData
 * @see     PKIT_KhUriageSeikyuuKekkaData
 * @see     QIT_KhUriageSeikyuuKekkaData
 * @see     GenQIT_KhUriageSeikyuuKekkaData
 */
@MappedSuperclass
@Table(name=GenIT_KhUriageSeikyuuKekkaData.TABLE_NAME)
@IdClass(value=PKIT_KhUriageSeikyuuKekkaData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AuthoriKbn", typeClass=UserType_C_AuthoriKbn.class),
    @TypeDef(name="UserType_C_CreditUriageNgJiyuuKbn", typeClass=UserType_C_CreditUriageNgJiyuuKbn.class)
})
public abstract class GenIT_KhUriageSeikyuuKekkaData extends AbstractExDBEntity<IT_KhUriageSeikyuuKekkaData, PKIT_KhUriageSeikyuuKekkaData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhUriageSeikyuuKekkaData";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String URIAGENENGAPPI           = "uriagenengappi";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String RECORDNO                 = "recordno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String AUTHORIKBN               = "authorikbn";
    public static final String URIAGESEIKYUUTORIHIKICD  = "uriageseikyuutorihikicd";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String CREDITYUUKOUKIGEN        = "credityuukoukigen";
    public static final String CREDITURIAGEGK           = "credituriagegk";
    public static final String CREDITKAIINNOKAMI6KETA   = "creditkaiinnokami6keta";
    public static final String CREDITKAIINNOSIMO4KETA   = "creditkaiinnosimo4keta";
    public static final String URIAGESEIKYUUERRORCD     = "uriageseikyuuerrorcd";
    public static final String CREDITURIAGENGJIYUU      = "credituriagengjiyuu";
    public static final String FUKUSUUKAMEITENNOKEY     = "fukusuukameitennokey";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhUriageSeikyuuKekkaData primaryKey;

    public GenIT_KhUriageSeikyuuKekkaData() {
        primaryKey = new PKIT_KhUriageSeikyuuKekkaData();
    }

    public GenIT_KhUriageSeikyuuKekkaData(
        String pKbnkey,
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_KhUriageSeikyuuKekkaData(
            pKbnkey,
            pSyono,
            pCreditkessaiyouno,
            pUriagenengappi,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_KhUriageSeikyuuKekkaData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhUriageSeikyuuKekkaData> getMetaClass() {
        return QIT_KhUriageSeikyuuKekkaData.class;
    }

    @Id
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.SYONO)
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
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.URIAGENENGAPPI)
    public BizDate getUriagenengappi() {
        return getPrimaryKey().getUriagenengappi();
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        getPrimaryKey().setUriagenengappi(pUriagenengappi);
    }

    @Id
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String recordno;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.RECORDNO)
    public String getRecordno() {
        return recordno;
    }

    public void setRecordno(String pRecordno) {
        recordno = pRecordno;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_AuthoriKbn authorikbn;

    @Type(type="UserType_C_AuthoriKbn")
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.AUTHORIKBN)
    public C_AuthoriKbn getAuthorikbn() {
        return authorikbn;
    }

    public void setAuthorikbn(C_AuthoriKbn pAuthorikbn) {
        authorikbn = pAuthorikbn;
    }

    private String uriageseikyuutorihikicd;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.URIAGESEIKYUUTORIHIKICD)
    public String getUriageseikyuutorihikicd() {
        return uriageseikyuutorihikicd;
    }

    public void setUriageseikyuutorihikicd(String pUriageseikyuutorihikicd) {
        uriageseikyuutorihikicd = pUriageseikyuutorihikicd;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private String credityuukoukigen;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.CREDITYUUKOUKIGEN)
    public String getCredityuukoukigen() {
        return credityuukoukigen;
    }

    public void setCredityuukoukigen(String pCredityuukoukigen) {
        credityuukoukigen = pCredityuukoukigen;
    }

    private BizCurrency credituriagegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCredituriagegk() {
        return credituriagegk;
    }

    public void setCredituriagegk(BizCurrency pCredituriagegk) {
        credituriagegk = pCredituriagegk;
        credituriagegkValue = null;
        credituriagegkType  = null;
    }

    transient private BigDecimal credituriagegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CREDITURIAGEGK, nullable=true)
    protected BigDecimal getCredituriagegkValue() {
        if (credituriagegkValue == null && credituriagegk != null) {
            if (credituriagegk.isOptional()) return null;
            return credituriagegk.absolute();
        }
        return credituriagegkValue;
    }

    protected void setCredituriagegkValue(BigDecimal value) {
        credituriagegkValue = value;
        credituriagegk = Optional.fromNullable(toCurrencyType(credituriagegkType))
            .transform(bizCurrencyTransformer(getCredituriagegkValue()))
            .orNull();
    }

    transient private String credituriagegkType = null;

    @Column(name=CREDITURIAGEGK + "$", nullable=true)
    protected String getCredituriagegkType() {
        if (credituriagegkType == null && credituriagegk != null) return credituriagegk.getType().toString();
        if (credituriagegkType == null && getCredituriagegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'credituriagegk$' should not be NULL."));
        }
        return credituriagegkType;
    }

    protected void setCredituriagegkType(String type) {
        credituriagegkType = type;
        credituriagegk = Optional.fromNullable(toCurrencyType(credituriagegkType))
            .transform(bizCurrencyTransformer(getCredituriagegkValue()))
            .orNull();
    }

    private String creditkaiinnokami6keta;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.CREDITKAIINNOKAMI6KETA)
    public String getCreditkaiinnokami6keta() {
        return creditkaiinnokami6keta;
    }

    public void setCreditkaiinnokami6keta(String pCreditkaiinnokami6keta) {
        creditkaiinnokami6keta = pCreditkaiinnokami6keta;
    }

    private String creditkaiinnosimo4keta;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.CREDITKAIINNOSIMO4KETA)
    public String getCreditkaiinnosimo4keta() {
        return creditkaiinnosimo4keta;
    }

    public void setCreditkaiinnosimo4keta(String pCreditkaiinnosimo4keta) {
        creditkaiinnosimo4keta = pCreditkaiinnosimo4keta;
    }

    private String uriageseikyuuerrorcd;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.URIAGESEIKYUUERRORCD)
    public String getUriageseikyuuerrorcd() {
        return uriageseikyuuerrorcd;
    }

    public void setUriageseikyuuerrorcd(String pUriageseikyuuerrorcd) {
        uriageseikyuuerrorcd = pUriageseikyuuerrorcd;
    }

    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Type(type="UserType_C_CreditUriageNgJiyuuKbn")
    @Column(name=GenIT_KhUriageSeikyuuKekkaData.CREDITURIAGENGJIYUU)
    public C_CreditUriageNgJiyuuKbn getCredituriagengjiyuu() {
        return credituriagengjiyuu;
    }

    public void setCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn pCredituriagengjiyuu) {
        credituriagengjiyuu = pCredituriagengjiyuu;
    }

    private String fukusuukameitennokey;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.FUKUSUUKAMEITENNOKEY)
    public String getFukusuukameitennokey() {
        return fukusuukameitennokey;
    }

    public void setFukusuukameitennokey(String pFukusuukameitennokey) {
        fukusuukameitennokey = pFukusuukameitennokey;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhUriageSeikyuuKekkaData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}