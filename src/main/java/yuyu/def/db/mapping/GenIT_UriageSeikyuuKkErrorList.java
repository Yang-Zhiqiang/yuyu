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
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.db.id.PKIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.GenQIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.QIT_UriageSeikyuuKkErrorList;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上請求結果エラーリストテーブル テーブルのマッピング情報クラスで、 {@link IT_UriageSeikyuuKkErrorList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_UriageSeikyuuKkErrorList}</td><td colspan="3">売上請求結果エラーリストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_UriageSeikyuuKkErrorList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_UriageSeikyuuKkErrorList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">{@link PKIT_UriageSeikyuuKkErrorList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_UriageSeikyuuKkErrorList ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCredituriagegk credituriagegk}</td><td>クレジットカード売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getUriageseikyuuerrorcd uriageseikyuuerrorcd}</td><td>売上請求エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredituriagengjiyuu credituriagengjiyuu}</td><td>クレジットカード売上請求ＮＧ事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageNgJiyuuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorikbn authorikbn}</td><td>オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthoriKbn}</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredituriageseikyuukbn credituriageseikyuukbn}</td><td>クレジットカード売上請求区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageSeikyuuKbn}</td></tr>
 * </table>
 * @see     IT_UriageSeikyuuKkErrorList
 * @see     PKIT_UriageSeikyuuKkErrorList
 * @see     QIT_UriageSeikyuuKkErrorList
 * @see     GenQIT_UriageSeikyuuKkErrorList
 */
@MappedSuperclass
@Table(name=GenIT_UriageSeikyuuKkErrorList.TABLE_NAME)
@IdClass(value=PKIT_UriageSeikyuuKkErrorList.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AuthoriKbn", typeClass=UserType_C_AuthoriKbn.class),
    @TypeDef(name="UserType_C_CreditUriageNgJiyuuKbn", typeClass=UserType_C_CreditUriageNgJiyuuKbn.class),
    @TypeDef(name="UserType_C_CreditUriageSeikyuuKbn", typeClass=UserType_C_CreditUriageSeikyuuKbn.class)
})
public abstract class GenIT_UriageSeikyuuKkErrorList extends AbstractExDBEntity<IT_UriageSeikyuuKkErrorList, PKIT_UriageSeikyuuKkErrorList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_UriageSeikyuuKkErrorList";
    public static final String SYONO                    = "syono";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String URIAGENENGAPPI           = "uriagenengappi";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String CREDITURIAGEGK           = "credituriagegk";
    public static final String URIAGESEIKYUUERRORCD     = "uriageseikyuuerrorcd";
    public static final String CREDITURIAGENGJIYUU      = "credituriagengjiyuu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String AUTHORIKBN               = "authorikbn";
    public static final String KINOUID                  = "kinouId";
    public static final String CREDITURIAGESEIKYUUKBN   = "credituriageseikyuukbn";

    private final PKIT_UriageSeikyuuKkErrorList primaryKey;

    public GenIT_UriageSeikyuuKkErrorList() {
        primaryKey = new PKIT_UriageSeikyuuKkErrorList();
    }

    public GenIT_UriageSeikyuuKkErrorList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_UriageSeikyuuKkErrorList(
            pSyono,
            pCreditkessaiyouno,
            pUriagenengappi,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_UriageSeikyuuKkErrorList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_UriageSeikyuuKkErrorList> getMetaClass() {
        return QIT_UriageSeikyuuKkErrorList.class;
    }

    @Id
    @Column(name=GenIT_UriageSeikyuuKkErrorList.SYONO)
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
    @Column(name=GenIT_UriageSeikyuuKkErrorList.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_UriageSeikyuuKkErrorList.URIAGENENGAPPI)
    public BizDate getUriagenengappi() {
        return getPrimaryKey().getUriagenengappi();
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        getPrimaryKey().setUriagenengappi(pUriagenengappi);
    }

    @Id
    @Column(name=GenIT_UriageSeikyuuKkErrorList.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_UriageSeikyuuKkErrorList.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_UriageSeikyuuKkErrorList.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
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

    private String uriageseikyuuerrorcd;

    @Column(name=GenIT_UriageSeikyuuKkErrorList.URIAGESEIKYUUERRORCD)
    public String getUriageseikyuuerrorcd() {
        return uriageseikyuuerrorcd;
    }

    public void setUriageseikyuuerrorcd(String pUriageseikyuuerrorcd) {
        uriageseikyuuerrorcd = pUriageseikyuuerrorcd;
    }

    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Type(type="UserType_C_CreditUriageNgJiyuuKbn")
    @Column(name=GenIT_UriageSeikyuuKkErrorList.CREDITURIAGENGJIYUU)
    public C_CreditUriageNgJiyuuKbn getCredituriagengjiyuu() {
        return credituriagengjiyuu;
    }

    public void setCredituriagengjiyuu(C_CreditUriageNgJiyuuKbn pCredituriagengjiyuu) {
        credituriagengjiyuu = pCredituriagengjiyuu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_UriageSeikyuuKkErrorList.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_UriageSeikyuuKkErrorList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_UriageSeikyuuKkErrorList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_AuthoriKbn authorikbn;

    @Type(type="UserType_C_AuthoriKbn")
    @Column(name=GenIT_UriageSeikyuuKkErrorList.AUTHORIKBN)
    public C_AuthoriKbn getAuthorikbn() {
        return authorikbn;
    }

    public void setAuthorikbn(C_AuthoriKbn pAuthorikbn) {
        authorikbn = pAuthorikbn;
    }

    private String kinouId;

    @Column(name=GenIT_UriageSeikyuuKkErrorList.KINOUID)
    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    @Type(type="UserType_C_CreditUriageSeikyuuKbn")
    @Column(name=GenIT_UriageSeikyuuKkErrorList.CREDITURIAGESEIKYUUKBN)
    public C_CreditUriageSeikyuuKbn getCredituriageseikyuukbn() {
        return credituriageseikyuukbn;
    }

    public void setCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn pCredituriageseikyuukbn) {
        credituriageseikyuukbn = pCredituriageseikyuukbn;
    }
}