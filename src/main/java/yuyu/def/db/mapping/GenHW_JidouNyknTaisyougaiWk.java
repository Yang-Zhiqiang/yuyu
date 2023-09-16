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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import yuyu.def.db.id.PKHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.GenQHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.QHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 自動入金対象外ワークテーブル テーブルのマッピング情報クラスで、 {@link HW_JidouNyknTaisyougaiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_JidouNyknTaisyougaiWk}</td><td colspan="3">自動入金対象外ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">{@link PKHW_JidouNyknTaisyougaiWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">{@link PKHW_JidouNyknTaisyougaiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrhkkgk trhkkgk}</td><td>取引金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyktyhyoutkbn nyktyhyoutkbn}</td><td>入金帳票出力先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_JidouNyknTaisyougaiWk
 * @see     PKHW_JidouNyknTaisyougaiWk
 * @see     QHW_JidouNyknTaisyougaiWk
 * @see     GenQHW_JidouNyknTaisyougaiWk
 */
@MappedSuperclass
@Table(name=GenHW_JidouNyknTaisyougaiWk.TABLE_NAME)
@IdClass(value=PKHW_JidouNyknTaisyougaiWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_NyktyhyoutKbn", typeClass=UserType_C_NyktyhyoutKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHW_JidouNyknTaisyougaiWk extends AbstractExDBEntity<HW_JidouNyknTaisyougaiWk, PKHW_JidouNyknTaisyougaiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_JidouNyknTaisyougaiWk";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String ITIRENNO                 = "itirenno";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String TRHKKGK                  = "trhkkgk";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String NYKTYHYOUTKBN            = "nyktyhyoutkbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHW_JidouNyknTaisyougaiWk primaryKey;

    public GenHW_JidouNyknTaisyougaiWk() {
        primaryKey = new PKHW_JidouNyknTaisyougaiWk();
    }

    public GenHW_JidouNyknTaisyougaiWk(BizDate pNyksyoriymd, String pItirenno) {
        primaryKey = new PKHW_JidouNyknTaisyougaiWk(pNyksyoriymd, pItirenno);
    }

    @Transient
    @Override
    public PKHW_JidouNyknTaisyougaiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_JidouNyknTaisyougaiWk> getMetaClass() {
        return QHW_JidouNyknTaisyougaiWk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHW_JidouNyknTaisyougaiWk.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return getPrimaryKey().getNyksyoriymd();
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        getPrimaryKey().setNyksyoriymd(pNyksyoriymd);
    }

    @Id
    @Column(name=GenHW_JidouNyknTaisyougaiWk.ITIRENNO)
    public String getItirenno() {
        return getPrimaryKey().getItirenno();
    }

    public void setItirenno(String pItirenno) {
        getPrimaryKey().setItirenno(pItirenno);
    }

    private String nykmosno;

    @Column(name=GenHW_JidouNyknTaisyougaiWk.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private String oyadrtencd;

    @Column(name=GenHW_JidouNyknTaisyougaiWk.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private BizCurrency trhkkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTrhkkgk() {
        return trhkkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrhkkgk(BizCurrency pTrhkkgk) {
        trhkkgk = pTrhkkgk;
        trhkkgkValue = null;
        trhkkgkType  = null;
    }

    transient private BigDecimal trhkkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TRHKKGK, nullable=true)
    protected BigDecimal getTrhkkgkValue() {
        if (trhkkgkValue == null && trhkkgk != null) {
            if (trhkkgk.isOptional()) return null;
            return trhkkgk.absolute();
        }
        return trhkkgkValue;
    }

    protected void setTrhkkgkValue(BigDecimal value) {
        trhkkgkValue = value;
        trhkkgk = Optional.fromNullable(toCurrencyType(trhkkgkType))
            .transform(bizCurrencyTransformer(getTrhkkgkValue()))
            .orNull();
    }

    transient private String trhkkgkType = null;

    @Column(name=TRHKKGK + "$", nullable=true)
    protected String getTrhkkgkType() {
        if (trhkkgkType == null && trhkkgk != null) return trhkkgk.getType().toString();
        if (trhkkgkType == null && getTrhkkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'trhkkgk$' should not be NULL."));
        }
        return trhkkgkType;
    }

    protected void setTrhkkgkType(String type) {
        trhkkgkType = type;
        trhkkgk = Optional.fromNullable(toCurrencyType(trhkkgkType))
            .transform(bizCurrencyTransformer(getTrhkkgkValue()))
            .orNull();
    }

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHW_JidouNyknTaisyougaiWk.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHW_JidouNyknTaisyougaiWk.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_NyktyhyoutKbn nyktyhyoutkbn;

    @Type(type="UserType_C_NyktyhyoutKbn")
    @Column(name=GenHW_JidouNyknTaisyougaiWk.NYKTYHYOUTKBN)
    public C_NyktyhyoutKbn getNyktyhyoutkbn() {
        return nyktyhyoutkbn;
    }

    public void setNyktyhyoutkbn(C_NyktyhyoutKbn pNyktyhyoutkbn) {
        nyktyhyoutkbn = pNyktyhyoutkbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHW_JidouNyknTaisyougaiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHW_JidouNyknTaisyougaiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}