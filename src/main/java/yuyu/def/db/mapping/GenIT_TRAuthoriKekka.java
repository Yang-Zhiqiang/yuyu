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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.db.entity.IT_TRAuthoriKekka;
import yuyu.def.db.id.PKIT_TRAuthoriKekka;
import yuyu.def.db.meta.GenQIT_TRAuthoriKekka;
import yuyu.def.db.meta.QIT_TRAuthoriKekka;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_AuthoritrkKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * オーソリ結果ＴＲテーブル テーブルのマッピング情報クラスで、 {@link IT_TRAuthoriKekka} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRAuthoriKekka}</td><td colspan="3">オーソリ結果ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_TRAuthoriKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_TRAuthoriKekka ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAuthorikktrrenno authorikktrrenno}</td><td>オーソリ結果TR連番</td><td align="center">{@link PKIT_TRAuthoriKekka ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorijkkbn authorijkkbn}</td><td>オーソリ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthorijkKbn}</td></tr>
 *  <tr><td>{@link #getAuthoritrkkbn authoritrkkbn}</td><td>オーソリ登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthoritrkKbn}</td></tr>
 *  <tr><td>{@link #getAuthorigk authorigk}</td><td>オーソリ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAuthorikanryoymd authorikanryoymd}</td><td>オーソリ完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyouninno syouninno}</td><td>承認番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatusyorino tanmatusyorino}</td><td>端末処理通番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRAuthoriKekka
 * @see     PKIT_TRAuthoriKekka
 * @see     QIT_TRAuthoriKekka
 * @see     GenQIT_TRAuthoriKekka
 */
@MappedSuperclass
@Table(name=GenIT_TRAuthoriKekka.TABLE_NAME)
@IdClass(value=PKIT_TRAuthoriKekka.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AuthorijkKbn", typeClass=UserType_C_AuthorijkKbn.class),
    @TypeDef(name="UserType_C_AuthoritrkKbn", typeClass=UserType_C_AuthoritrkKbn.class)
})
public abstract class GenIT_TRAuthoriKekka extends AbstractExDBEntity<IT_TRAuthoriKekka, PKIT_TRAuthoriKekka> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_TRAuthoriKekka";
    public static final String SYONO                    = "syono";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String AUTHORIKKTRRENNO         = "authorikktrrenno";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String AUTHORIJKKBN             = "authorijkkbn";
    public static final String AUTHORITRKKBN            = "authoritrkkbn";
    public static final String AUTHORIGK                = "authorigk";
    public static final String AUTHORIKANRYOYMD         = "authorikanryoymd";
    public static final String SYOUNINNO                = "syouninno";
    public static final String TANMATUSYORINO           = "tanmatusyorino";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_TRAuthoriKekka primaryKey;

    public GenIT_TRAuthoriKekka() {
        primaryKey = new PKIT_TRAuthoriKekka();
    }

    public GenIT_TRAuthoriKekka(
        String pSyono,
        BizDate pSyoriYmd,
        String pAuthorikktrrenno
    ) {
        primaryKey = new PKIT_TRAuthoriKekka(
            pSyono,
            pSyoriYmd,
            pAuthorikktrrenno
        );
    }

    @Transient
    @Override
    public PKIT_TRAuthoriKekka getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_TRAuthoriKekka> getMetaClass() {
        return QIT_TRAuthoriKekka.class;
    }

    @Id
    @Column(name=GenIT_TRAuthoriKekka.SYONO)
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
    @Column(name=GenIT_TRAuthoriKekka.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_TRAuthoriKekka.AUTHORIKKTRRENNO)
    public String getAuthorikktrrenno() {
        return getPrimaryKey().getAuthorikktrrenno();
    }

    public void setAuthorikktrrenno(String pAuthorikktrrenno) {
        getPrimaryKey().setAuthorikktrrenno(pAuthorikktrrenno);
    }

    private String creditcardno1;

    @Column(name=GenIT_TRAuthoriKekka.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_TRAuthoriKekka.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_TRAuthoriKekka.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_TRAuthoriKekka.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private C_AuthorijkKbn authorijkkbn;

    @Type(type="UserType_C_AuthorijkKbn")
    @Column(name=GenIT_TRAuthoriKekka.AUTHORIJKKBN)
    public C_AuthorijkKbn getAuthorijkkbn() {
        return authorijkkbn;
    }

    public void setAuthorijkkbn(C_AuthorijkKbn pAuthorijkkbn) {
        authorijkkbn = pAuthorijkkbn;
    }

    private C_AuthoritrkKbn authoritrkkbn;

    @Type(type="UserType_C_AuthoritrkKbn")
    @Column(name=GenIT_TRAuthoriKekka.AUTHORITRKKBN)
    public C_AuthoritrkKbn getAuthoritrkkbn() {
        return authoritrkkbn;
    }

    public void setAuthoritrkkbn(C_AuthoritrkKbn pAuthoritrkkbn) {
        authoritrkkbn = pAuthoritrkkbn;
    }

    private BizCurrency authorigk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getAuthorigk() {
        return authorigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorigk(BizCurrency pAuthorigk) {
        authorigk = pAuthorigk;
        authorigkValue = null;
        authorigkType  = null;
    }

    transient private BigDecimal authorigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AUTHORIGK, nullable=true)
    protected BigDecimal getAuthorigkValue() {
        if (authorigkValue == null && authorigk != null) {
            if (authorigk.isOptional()) return null;
            return authorigk.absolute();
        }
        return authorigkValue;
    }

    protected void setAuthorigkValue(BigDecimal value) {
        authorigkValue = value;
        authorigk = Optional.fromNullable(toCurrencyType(authorigkType))
            .transform(bizCurrencyTransformer(getAuthorigkValue()))
            .orNull();
    }

    transient private String authorigkType = null;

    @Column(name=AUTHORIGK + "$", nullable=true)
    protected String getAuthorigkType() {
        if (authorigkType == null && authorigk != null) return authorigk.getType().toString();
        if (authorigkType == null && getAuthorigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'authorigk$' should not be NULL."));
        }
        return authorigkType;
    }

    protected void setAuthorigkType(String type) {
        authorigkType = type;
        authorigk = Optional.fromNullable(toCurrencyType(authorigkType))
            .transform(bizCurrencyTransformer(getAuthorigkValue()))
            .orNull();
    }

    private BizDate authorikanryoymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TRAuthoriKekka.AUTHORIKANRYOYMD)
    @ValidDate
    public BizDate getAuthorikanryoymd() {
        return authorikanryoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikanryoymd(BizDate pAuthorikanryoymd) {
        authorikanryoymd = pAuthorikanryoymd;
    }

    private String syouninno;

    @Column(name=GenIT_TRAuthoriKekka.SYOUNINNO)
    @MaxLength(max=6)
    @Digit
    public String getSyouninno() {
        return syouninno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyouninno(String pSyouninno) {
        syouninno = pSyouninno;
    }

    private String tanmatusyorino;

    @Column(name=GenIT_TRAuthoriKekka.TANMATUSYORINO)
    public String getTanmatusyorino() {
        return tanmatusyorino;
    }

    public void setTanmatusyorino(String pTanmatusyorino) {
        tanmatusyorino = pTanmatusyorino;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_TRAuthoriKekka.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_TRAuthoriKekka.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_TRAuthoriKekka.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}