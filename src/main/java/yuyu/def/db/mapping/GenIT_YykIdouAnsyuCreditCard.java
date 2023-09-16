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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.classification.C_YuukoukakujkKbn;
import yuyu.def.db.entity.IT_YykIdouAnsyuCreditCard;
import yuyu.def.db.id.PKIT_YykIdouAnsyuCreditCard;
import yuyu.def.db.meta.GenQIT_YykIdouAnsyuCreditCard;
import yuyu.def.db.meta.QIT_YykIdouAnsyuCreditCard;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_AuthoritrkKbn;
import yuyu.def.db.type.UserType_C_YuukoukakujkKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 予約異動案内収納用クレジット払テーブル テーブルのマッピング情報クラスで、 {@link IT_YykIdouAnsyuCreditCard} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YykIdouAnsyuCreditCard}</td><td colspan="3">予約異動案内収納用クレジット払テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_YykIdouAnsyuCreditCard ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_YykIdouAnsyuCreditCard ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_YykIdouAnsyuCreditCard ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYukoukachkymd yukoukachkymd}</td><td>有効性確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYuukoukakujkkbn yuukoukakujkkbn}</td><td>有効性確認状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukoukakujkKbn}</td></tr>
 *  <tr><td>{@link #getAuthorijkkbn authorijkkbn}</td><td>オーソリ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthorijkKbn}</td></tr>
 *  <tr><td>{@link #getAuthoritrkkbn authoritrkkbn}</td><td>オーソリ登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthoritrkKbn}</td></tr>
 *  <tr><td>{@link #getAuthorigk authorigk}</td><td>オーソリ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAuthorikanryoymd authorikanryoymd}</td><td>オーソリ完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyouninno syouninno}</td><td>承認番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatusyorino tanmatusyorino}</td><td>端末処理通番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YykIdouAnsyuCreditCard
 * @see     PKIT_YykIdouAnsyuCreditCard
 * @see     QIT_YykIdouAnsyuCreditCard
 * @see     GenQIT_YykIdouAnsyuCreditCard
 */
@MappedSuperclass
@Table(name=GenIT_YykIdouAnsyuCreditCard.TABLE_NAME)
@IdClass(value=PKIT_YykIdouAnsyuCreditCard.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AuthorijkKbn", typeClass=UserType_C_AuthorijkKbn.class),
    @TypeDef(name="UserType_C_AuthoritrkKbn", typeClass=UserType_C_AuthoritrkKbn.class),
    @TypeDef(name="UserType_C_YuukoukakujkKbn", typeClass=UserType_C_YuukoukakujkKbn.class)
})
public abstract class GenIT_YykIdouAnsyuCreditCard extends AbstractExDBEntity<IT_YykIdouAnsyuCreditCard, PKIT_YykIdouAnsyuCreditCard> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_YykIdouAnsyuCreditCard";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String YUKOUKACHKYMD            = "yukoukachkymd";
    public static final String YUUKOUKAKUJKKBN          = "yuukoukakujkkbn";
    public static final String AUTHORIJKKBN             = "authorijkkbn";
    public static final String AUTHORITRKKBN            = "authoritrkkbn";
    public static final String AUTHORIGK                = "authorigk";
    public static final String AUTHORIKANRYOYMD         = "authorikanryoymd";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String SYOUNINNO                = "syouninno";
    public static final String TANMATUSYORINO           = "tanmatusyorino";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_YykIdouAnsyuCreditCard primaryKey;

    public GenIT_YykIdouAnsyuCreditCard() {
        primaryKey = new PKIT_YykIdouAnsyuCreditCard();
    }

    public GenIT_YykIdouAnsyuCreditCard(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_YykIdouAnsyuCreditCard(
            pKbnkey,
            pSyono,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_YykIdouAnsyuCreditCard getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_YykIdouAnsyuCreditCard> getMetaClass() {
        return QIT_YykIdouAnsyuCreditCard.class;
    }

    @Id
    @Column(name=GenIT_YykIdouAnsyuCreditCard.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_YykIdouAnsyuCreditCard.SYONO)
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
    @Column(name=GenIT_YykIdouAnsyuCreditCard.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate yukoukachkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_YykIdouAnsyuCreditCard.YUKOUKACHKYMD)
    public BizDate getYukoukachkymd() {
        return yukoukachkymd;
    }

    @Trim("both")
    public void setYukoukachkymd(BizDate pYukoukachkymd) {
        yukoukachkymd = pYukoukachkymd;
    }

    private C_YuukoukakujkKbn yuukoukakujkkbn;

    @Type(type="UserType_C_YuukoukakujkKbn")
    @Column(name=GenIT_YykIdouAnsyuCreditCard.YUUKOUKAKUJKKBN)
    public C_YuukoukakujkKbn getYuukoukakujkkbn() {
        return yuukoukakujkkbn;
    }

    public void setYuukoukakujkkbn(C_YuukoukakujkKbn pYuukoukakujkkbn) {
        yuukoukakujkkbn = pYuukoukakujkkbn;
    }

    private C_AuthorijkKbn authorijkkbn;

    @Type(type="UserType_C_AuthorijkKbn")
    @Column(name=GenIT_YykIdouAnsyuCreditCard.AUTHORIJKKBN)
    public C_AuthorijkKbn getAuthorijkkbn() {
        return authorijkkbn;
    }

    public void setAuthorijkkbn(C_AuthorijkKbn pAuthorijkkbn) {
        authorijkkbn = pAuthorijkkbn;
    }

    private C_AuthoritrkKbn authoritrkkbn;

    @Type(type="UserType_C_AuthoritrkKbn")
    @Column(name=GenIT_YykIdouAnsyuCreditCard.AUTHORITRKKBN)
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
    @Column(name=GenIT_YykIdouAnsyuCreditCard.AUTHORIKANRYOYMD)
    @ValidDate
    public BizDate getAuthorikanryoymd() {
        return authorikanryoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAuthorikanryoymd(BizDate pAuthorikanryoymd) {
        authorikanryoymd = pAuthorikanryoymd;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_YykIdouAnsyuCreditCard.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private String syouninno;

    @Column(name=GenIT_YykIdouAnsyuCreditCard.SYOUNINNO)
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

    @Column(name=GenIT_YykIdouAnsyuCreditCard.TANMATUSYORINO)
    public String getTanmatusyorino() {
        return tanmatusyorino;
    }

    public void setTanmatusyorino(String pTanmatusyorino) {
        tanmatusyorino = pTanmatusyorino;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_YykIdouAnsyuCreditCard.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_YykIdouAnsyuCreditCard.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_YykIdouAnsyuCreditCard.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}