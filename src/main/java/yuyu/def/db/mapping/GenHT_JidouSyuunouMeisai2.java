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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;
import yuyu.def.db.id.PKHT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.GenQHT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai2;
import yuyu.def.db.type.UserType_C_KessanKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 自動収納照合明細テーブル２ テーブルのマッピング情報クラスで、 {@link HT_JidouSyuunouMeisai2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JidouSyuunouMeisai2}</td><td colspan="3">自動収納照合明細テーブル２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_JidouSyuunouMeisai2 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKessankbn kessankbn}</td><td>決算区分</td><td align="center">{@link PKHT_JidouSyuunouMeisai2 ○}</td><td align="center">V</td><td>{@link C_KessanKbn}</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">{@link PKHT_JidouSyuunouMeisai2 ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getNyktyhyoutkbn nyktyhyoutkbn}</td><td>入金帳票出力先区分</td><td align="center">{@link PKHT_JidouSyuunouMeisai2 ○}</td><td align="center">V</td><td>{@link C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>{@link #getSgittikensuu sgittikensuu}</td><td>照合一致件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSgittigk sgittigk}</td><td>照合一致金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSgittigkyen sgittigkyen}</td><td>照合一致金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSghuittikensuu sghuittikensuu}</td><td>照合不一致件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSghuittigk sghuittigk}</td><td>照合不一致金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMostrkskensuu mostrkskensuu}</td><td>申込取消件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMostrksgk mostrksgk}</td><td>申込取消金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYuukoukknkeikakensuu yuukoukknkeikakensuu}</td><td>有効期間経過件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYuukoukknkeikagk yuukoukknkeikagk}</td><td>有効期間経過金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYokukurikosikensuu yokukurikosikensuu}</td><td>翌日繰越件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYokukurikosigk yokukurikosigk}</td><td>翌日繰越金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYokukurikosigkyen yokukurikosigkyen}</td><td>翌日繰越金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJnykntsgkensuu jnykntsgkensuu}</td><td>自動入金対象外件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJnykntsggk jnykntsggk}</td><td>自動入金対象外金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTjkensuu tjkensuu}</td><td>当日件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTjgk tjgk}</td><td>当日金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTjgkyen tjgkyen}</td><td>当日金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZenjitukurikosikensuu zenjitukurikosikensuu}</td><td>前日繰越件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZenjitukurikosigk zenjitukurikosigk}</td><td>前日繰越金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkmtsrykensuu hrkmtsrykensuu}</td><td>振込手数料件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkmtsrykingk hrkmtsrykingk}</td><td>振込手数料金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JidouSyuunouMeisai2
 * @see     PKHT_JidouSyuunouMeisai2
 * @see     QHT_JidouSyuunouMeisai2
 * @see     GenQHT_JidouSyuunouMeisai2
 */
@MappedSuperclass
@Table(name=GenHT_JidouSyuunouMeisai2.TABLE_NAME)
@IdClass(value=PKHT_JidouSyuunouMeisai2.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KessanKbn", typeClass=UserType_C_KessanKbn.class),
    @TypeDef(name="UserType_C_NyktyhyoutKbn", typeClass=UserType_C_NyktyhyoutKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHT_JidouSyuunouMeisai2 extends AbstractExDBEntity<HT_JidouSyuunouMeisai2, PKHT_JidouSyuunouMeisai2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_JidouSyuunouMeisai2";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KESSANKBN                = "kessankbn";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String NYKTYHYOUTKBN            = "nyktyhyoutkbn";
    public static final String SGITTIKENSUU             = "sgittikensuu";
    public static final String SGITTIGK                 = "sgittigk";
    public static final String SGITTIGKYEN              = "sgittigkyen";
    public static final String SGHUITTIKENSUU           = "sghuittikensuu";
    public static final String SGHUITTIGK               = "sghuittigk";
    public static final String MOSTRKSKENSUU            = "mostrkskensuu";
    public static final String MOSTRKSGK                = "mostrksgk";
    public static final String YUUKOUKKNKEIKAKENSUU     = "yuukoukknkeikakensuu";
    public static final String YUUKOUKKNKEIKAGK         = "yuukoukknkeikagk";
    public static final String YOKUKURIKOSIKENSUU       = "yokukurikosikensuu";
    public static final String YOKUKURIKOSIGK           = "yokukurikosigk";
    public static final String YOKUKURIKOSIGKYEN        = "yokukurikosigkyen";
    public static final String JNYKNTSGKENSUU           = "jnykntsgkensuu";
    public static final String JNYKNTSGGK               = "jnykntsggk";
    public static final String TJKENSUU                 = "tjkensuu";
    public static final String TJGK                     = "tjgk";
    public static final String TJGKYEN                  = "tjgkyen";
    public static final String ZENJITUKURIKOSIKENSUU    = "zenjitukurikosikensuu";
    public static final String ZENJITUKURIKOSIGK        = "zenjitukurikosigk";
    public static final String HRKMTSRYKENSUU           = "hrkmtsrykensuu";
    public static final String HRKMTSRYKINGK            = "hrkmtsrykingk";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_JidouSyuunouMeisai2 primaryKey;

    public GenHT_JidouSyuunouMeisai2() {
        primaryKey = new PKHT_JidouSyuunouMeisai2();
    }

    public GenHT_JidouSyuunouMeisai2(
        BizDate pSyoriYmd,
        C_KessanKbn pKessankbn,
        C_Tuukasyu pRstuukasyu,
        C_NyktyhyoutKbn pNyktyhyoutkbn
    ) {
        primaryKey = new PKHT_JidouSyuunouMeisai2(
            pSyoriYmd,
            pKessankbn,
            pRstuukasyu,
            pNyktyhyoutkbn
        );
    }

    @Transient
    @Override
    public PKHT_JidouSyuunouMeisai2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_JidouSyuunouMeisai2> getMetaClass() {
        return QHT_JidouSyuunouMeisai2.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_JidouSyuunouMeisai2.SYORIYMD)
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
    @Type(type="UserType_C_KessanKbn")
    @Column(name=GenHT_JidouSyuunouMeisai2.KESSANKBN)
    public C_KessanKbn getKessankbn() {
        return getPrimaryKey().getKessankbn();
    }

    public void setKessankbn(C_KessanKbn pKessankbn) {
        getPrimaryKey().setKessankbn(pKessankbn);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_JidouSyuunouMeisai2.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return getPrimaryKey().getRstuukasyu();
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        getPrimaryKey().setRstuukasyu(pRstuukasyu);
    }

    @Id
    @Type(type="UserType_C_NyktyhyoutKbn")
    @Column(name=GenHT_JidouSyuunouMeisai2.NYKTYHYOUTKBN)
    public C_NyktyhyoutKbn getNyktyhyoutkbn() {
        return getPrimaryKey().getNyktyhyoutkbn();
    }

    public void setNyktyhyoutkbn(C_NyktyhyoutKbn pNyktyhyoutkbn) {
        getPrimaryKey().setNyktyhyoutkbn(pNyktyhyoutkbn);
    }

    private Integer sgittikensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.SGITTIKENSUU)
    public Integer getSgittikensuu() {
        return sgittikensuu;
    }

    public void setSgittikensuu(Integer pSgittikensuu) {
        sgittikensuu = pSgittikensuu;
    }

    private BizCurrency sgittigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSgittigk() {
        return sgittigk;
    }

    public void setSgittigk(BizCurrency pSgittigk) {
        sgittigk = pSgittigk;
        sgittigkValue = null;
        sgittigkType  = null;
    }

    transient private BigDecimal sgittigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGITTIGK, nullable=true)
    protected BigDecimal getSgittigkValue() {
        if (sgittigkValue == null && sgittigk != null) {
            if (sgittigk.isOptional()) return null;
            return sgittigk.absolute();
        }
        return sgittigkValue;
    }

    protected void setSgittigkValue(BigDecimal value) {
        sgittigkValue = value;
        sgittigk = Optional.fromNullable(toCurrencyType(sgittigkType))
            .transform(bizCurrencyTransformer(getSgittigkValue()))
            .orNull();
    }

    transient private String sgittigkType = null;

    @Column(name=SGITTIGK + "$", nullable=true)
    protected String getSgittigkType() {
        if (sgittigkType == null && sgittigk != null) return sgittigk.getType().toString();
        if (sgittigkType == null && getSgittigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sgittigk$' should not be NULL."));
        }
        return sgittigkType;
    }

    protected void setSgittigkType(String type) {
        sgittigkType = type;
        sgittigk = Optional.fromNullable(toCurrencyType(sgittigkType))
            .transform(bizCurrencyTransformer(getSgittigkValue()))
            .orNull();
    }

    private BizCurrency sgittigkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSgittigkyen() {
        return sgittigkyen;
    }

    public void setSgittigkyen(BizCurrency pSgittigkyen) {
        sgittigkyen = pSgittigkyen;
        sgittigkyenValue = null;
        sgittigkyenType  = null;
    }

    transient private BigDecimal sgittigkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGITTIGKYEN, nullable=true)
    protected BigDecimal getSgittigkyenValue() {
        if (sgittigkyenValue == null && sgittigkyen != null) {
            if (sgittigkyen.isOptional()) return null;
            return sgittigkyen.absolute();
        }
        return sgittigkyenValue;
    }

    protected void setSgittigkyenValue(BigDecimal value) {
        sgittigkyenValue = value;
        sgittigkyen = Optional.fromNullable(toCurrencyType(sgittigkyenType))
            .transform(bizCurrencyTransformer(getSgittigkyenValue()))
            .orNull();
    }

    transient private String sgittigkyenType = null;

    @Column(name=SGITTIGKYEN + "$", nullable=true)
    protected String getSgittigkyenType() {
        if (sgittigkyenType == null && sgittigkyen != null) return sgittigkyen.getType().toString();
        if (sgittigkyenType == null && getSgittigkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sgittigkyen$' should not be NULL."));
        }
        return sgittigkyenType;
    }

    protected void setSgittigkyenType(String type) {
        sgittigkyenType = type;
        sgittigkyen = Optional.fromNullable(toCurrencyType(sgittigkyenType))
            .transform(bizCurrencyTransformer(getSgittigkyenValue()))
            .orNull();
    }

    private Integer sghuittikensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.SGHUITTIKENSUU)
    public Integer getSghuittikensuu() {
        return sghuittikensuu;
    }

    public void setSghuittikensuu(Integer pSghuittikensuu) {
        sghuittikensuu = pSghuittikensuu;
    }

    private BizCurrency sghuittigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSghuittigk() {
        return sghuittigk;
    }

    public void setSghuittigk(BizCurrency pSghuittigk) {
        sghuittigk = pSghuittigk;
        sghuittigkValue = null;
        sghuittigkType  = null;
    }

    transient private BigDecimal sghuittigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SGHUITTIGK, nullable=true)
    protected BigDecimal getSghuittigkValue() {
        if (sghuittigkValue == null && sghuittigk != null) {
            if (sghuittigk.isOptional()) return null;
            return sghuittigk.absolute();
        }
        return sghuittigkValue;
    }

    protected void setSghuittigkValue(BigDecimal value) {
        sghuittigkValue = value;
        sghuittigk = Optional.fromNullable(toCurrencyType(sghuittigkType))
            .transform(bizCurrencyTransformer(getSghuittigkValue()))
            .orNull();
    }

    transient private String sghuittigkType = null;

    @Column(name=SGHUITTIGK + "$", nullable=true)
    protected String getSghuittigkType() {
        if (sghuittigkType == null && sghuittigk != null) return sghuittigk.getType().toString();
        if (sghuittigkType == null && getSghuittigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sghuittigk$' should not be NULL."));
        }
        return sghuittigkType;
    }

    protected void setSghuittigkType(String type) {
        sghuittigkType = type;
        sghuittigk = Optional.fromNullable(toCurrencyType(sghuittigkType))
            .transform(bizCurrencyTransformer(getSghuittigkValue()))
            .orNull();
    }

    private Integer mostrkskensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.MOSTRKSKENSUU)
    public Integer getMostrkskensuu() {
        return mostrkskensuu;
    }

    public void setMostrkskensuu(Integer pMostrkskensuu) {
        mostrkskensuu = pMostrkskensuu;
    }

    private BizCurrency mostrksgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMostrksgk() {
        return mostrksgk;
    }

    public void setMostrksgk(BizCurrency pMostrksgk) {
        mostrksgk = pMostrksgk;
        mostrksgkValue = null;
        mostrksgkType  = null;
    }

    transient private BigDecimal mostrksgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSTRKSGK, nullable=true)
    protected BigDecimal getMostrksgkValue() {
        if (mostrksgkValue == null && mostrksgk != null) {
            if (mostrksgk.isOptional()) return null;
            return mostrksgk.absolute();
        }
        return mostrksgkValue;
    }

    protected void setMostrksgkValue(BigDecimal value) {
        mostrksgkValue = value;
        mostrksgk = Optional.fromNullable(toCurrencyType(mostrksgkType))
            .transform(bizCurrencyTransformer(getMostrksgkValue()))
            .orNull();
    }

    transient private String mostrksgkType = null;

    @Column(name=MOSTRKSGK + "$", nullable=true)
    protected String getMostrksgkType() {
        if (mostrksgkType == null && mostrksgk != null) return mostrksgk.getType().toString();
        if (mostrksgkType == null && getMostrksgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mostrksgk$' should not be NULL."));
        }
        return mostrksgkType;
    }

    protected void setMostrksgkType(String type) {
        mostrksgkType = type;
        mostrksgk = Optional.fromNullable(toCurrencyType(mostrksgkType))
            .transform(bizCurrencyTransformer(getMostrksgkValue()))
            .orNull();
    }

    private Integer yuukoukknkeikakensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.YUUKOUKKNKEIKAKENSUU)
    public Integer getYuukoukknkeikakensuu() {
        return yuukoukknkeikakensuu;
    }

    public void setYuukoukknkeikakensuu(Integer pYuukoukknkeikakensuu) {
        yuukoukknkeikakensuu = pYuukoukknkeikakensuu;
    }

    private BizCurrency yuukoukknkeikagk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYuukoukknkeikagk() {
        return yuukoukknkeikagk;
    }

    public void setYuukoukknkeikagk(BizCurrency pYuukoukknkeikagk) {
        yuukoukknkeikagk = pYuukoukknkeikagk;
        yuukoukknkeikagkValue = null;
        yuukoukknkeikagkType  = null;
    }

    transient private BigDecimal yuukoukknkeikagkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YUUKOUKKNKEIKAGK, nullable=true)
    protected BigDecimal getYuukoukknkeikagkValue() {
        if (yuukoukknkeikagkValue == null && yuukoukknkeikagk != null) {
            if (yuukoukknkeikagk.isOptional()) return null;
            return yuukoukknkeikagk.absolute();
        }
        return yuukoukknkeikagkValue;
    }

    protected void setYuukoukknkeikagkValue(BigDecimal value) {
        yuukoukknkeikagkValue = value;
        yuukoukknkeikagk = Optional.fromNullable(toCurrencyType(yuukoukknkeikagkType))
            .transform(bizCurrencyTransformer(getYuukoukknkeikagkValue()))
            .orNull();
    }

    transient private String yuukoukknkeikagkType = null;

    @Column(name=YUUKOUKKNKEIKAGK + "$", nullable=true)
    protected String getYuukoukknkeikagkType() {
        if (yuukoukknkeikagkType == null && yuukoukknkeikagk != null) return yuukoukknkeikagk.getType().toString();
        if (yuukoukknkeikagkType == null && getYuukoukknkeikagkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yuukoukknkeikagk$' should not be NULL."));
        }
        return yuukoukknkeikagkType;
    }

    protected void setYuukoukknkeikagkType(String type) {
        yuukoukknkeikagkType = type;
        yuukoukknkeikagk = Optional.fromNullable(toCurrencyType(yuukoukknkeikagkType))
            .transform(bizCurrencyTransformer(getYuukoukknkeikagkValue()))
            .orNull();
    }

    private Integer yokukurikosikensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.YOKUKURIKOSIKENSUU)
    public Integer getYokukurikosikensuu() {
        return yokukurikosikensuu;
    }

    public void setYokukurikosikensuu(Integer pYokukurikosikensuu) {
        yokukurikosikensuu = pYokukurikosikensuu;
    }

    private BizCurrency yokukurikosigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYokukurikosigk() {
        return yokukurikosigk;
    }

    public void setYokukurikosigk(BizCurrency pYokukurikosigk) {
        yokukurikosigk = pYokukurikosigk;
        yokukurikosigkValue = null;
        yokukurikosigkType  = null;
    }

    transient private BigDecimal yokukurikosigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YOKUKURIKOSIGK, nullable=true)
    protected BigDecimal getYokukurikosigkValue() {
        if (yokukurikosigkValue == null && yokukurikosigk != null) {
            if (yokukurikosigk.isOptional()) return null;
            return yokukurikosigk.absolute();
        }
        return yokukurikosigkValue;
    }

    protected void setYokukurikosigkValue(BigDecimal value) {
        yokukurikosigkValue = value;
        yokukurikosigk = Optional.fromNullable(toCurrencyType(yokukurikosigkType))
            .transform(bizCurrencyTransformer(getYokukurikosigkValue()))
            .orNull();
    }

    transient private String yokukurikosigkType = null;

    @Column(name=YOKUKURIKOSIGK + "$", nullable=true)
    protected String getYokukurikosigkType() {
        if (yokukurikosigkType == null && yokukurikosigk != null) return yokukurikosigk.getType().toString();
        if (yokukurikosigkType == null && getYokukurikosigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yokukurikosigk$' should not be NULL."));
        }
        return yokukurikosigkType;
    }

    protected void setYokukurikosigkType(String type) {
        yokukurikosigkType = type;
        yokukurikosigk = Optional.fromNullable(toCurrencyType(yokukurikosigkType))
            .transform(bizCurrencyTransformer(getYokukurikosigkValue()))
            .orNull();
    }

    private BizCurrency yokukurikosigkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYokukurikosigkyen() {
        return yokukurikosigkyen;
    }

    public void setYokukurikosigkyen(BizCurrency pYokukurikosigkyen) {
        yokukurikosigkyen = pYokukurikosigkyen;
        yokukurikosigkyenValue = null;
        yokukurikosigkyenType  = null;
    }

    transient private BigDecimal yokukurikosigkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YOKUKURIKOSIGKYEN, nullable=true)
    protected BigDecimal getYokukurikosigkyenValue() {
        if (yokukurikosigkyenValue == null && yokukurikosigkyen != null) {
            if (yokukurikosigkyen.isOptional()) return null;
            return yokukurikosigkyen.absolute();
        }
        return yokukurikosigkyenValue;
    }

    protected void setYokukurikosigkyenValue(BigDecimal value) {
        yokukurikosigkyenValue = value;
        yokukurikosigkyen = Optional.fromNullable(toCurrencyType(yokukurikosigkyenType))
            .transform(bizCurrencyTransformer(getYokukurikosigkyenValue()))
            .orNull();
    }

    transient private String yokukurikosigkyenType = null;

    @Column(name=YOKUKURIKOSIGKYEN + "$", nullable=true)
    protected String getYokukurikosigkyenType() {
        if (yokukurikosigkyenType == null && yokukurikosigkyen != null) return yokukurikosigkyen.getType().toString();
        if (yokukurikosigkyenType == null && getYokukurikosigkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yokukurikosigkyen$' should not be NULL."));
        }
        return yokukurikosigkyenType;
    }

    protected void setYokukurikosigkyenType(String type) {
        yokukurikosigkyenType = type;
        yokukurikosigkyen = Optional.fromNullable(toCurrencyType(yokukurikosigkyenType))
            .transform(bizCurrencyTransformer(getYokukurikosigkyenValue()))
            .orNull();
    }

    private Integer jnykntsgkensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.JNYKNTSGKENSUU)
    public Integer getJnykntsgkensuu() {
        return jnykntsgkensuu;
    }

    public void setJnykntsgkensuu(Integer pJnykntsgkensuu) {
        jnykntsgkensuu = pJnykntsgkensuu;
    }

    private BizCurrency jnykntsggk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJnykntsggk() {
        return jnykntsggk;
    }

    public void setJnykntsggk(BizCurrency pJnykntsggk) {
        jnykntsggk = pJnykntsggk;
        jnykntsggkValue = null;
        jnykntsggkType  = null;
    }

    transient private BigDecimal jnykntsggkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JNYKNTSGGK, nullable=true)
    protected BigDecimal getJnykntsggkValue() {
        if (jnykntsggkValue == null && jnykntsggk != null) {
            if (jnykntsggk.isOptional()) return null;
            return jnykntsggk.absolute();
        }
        return jnykntsggkValue;
    }

    protected void setJnykntsggkValue(BigDecimal value) {
        jnykntsggkValue = value;
        jnykntsggk = Optional.fromNullable(toCurrencyType(jnykntsggkType))
            .transform(bizCurrencyTransformer(getJnykntsggkValue()))
            .orNull();
    }

    transient private String jnykntsggkType = null;

    @Column(name=JNYKNTSGGK + "$", nullable=true)
    protected String getJnykntsggkType() {
        if (jnykntsggkType == null && jnykntsggk != null) return jnykntsggk.getType().toString();
        if (jnykntsggkType == null && getJnykntsggkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jnykntsggk$' should not be NULL."));
        }
        return jnykntsggkType;
    }

    protected void setJnykntsggkType(String type) {
        jnykntsggkType = type;
        jnykntsggk = Optional.fromNullable(toCurrencyType(jnykntsggkType))
            .transform(bizCurrencyTransformer(getJnykntsggkValue()))
            .orNull();
    }

    private Integer tjkensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.TJKENSUU)
    public Integer getTjkensuu() {
        return tjkensuu;
    }

    public void setTjkensuu(Integer pTjkensuu) {
        tjkensuu = pTjkensuu;
    }

    private BizCurrency tjgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTjgk() {
        return tjgk;
    }

    public void setTjgk(BizCurrency pTjgk) {
        tjgk = pTjgk;
        tjgkValue = null;
        tjgkType  = null;
    }

    transient private BigDecimal tjgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TJGK, nullable=true)
    protected BigDecimal getTjgkValue() {
        if (tjgkValue == null && tjgk != null) {
            if (tjgk.isOptional()) return null;
            return tjgk.absolute();
        }
        return tjgkValue;
    }

    protected void setTjgkValue(BigDecimal value) {
        tjgkValue = value;
        tjgk = Optional.fromNullable(toCurrencyType(tjgkType))
            .transform(bizCurrencyTransformer(getTjgkValue()))
            .orNull();
    }

    transient private String tjgkType = null;

    @Column(name=TJGK + "$", nullable=true)
    protected String getTjgkType() {
        if (tjgkType == null && tjgk != null) return tjgk.getType().toString();
        if (tjgkType == null && getTjgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tjgk$' should not be NULL."));
        }
        return tjgkType;
    }

    protected void setTjgkType(String type) {
        tjgkType = type;
        tjgk = Optional.fromNullable(toCurrencyType(tjgkType))
            .transform(bizCurrencyTransformer(getTjgkValue()))
            .orNull();
    }

    private BizCurrency tjgkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTjgkyen() {
        return tjgkyen;
    }

    public void setTjgkyen(BizCurrency pTjgkyen) {
        tjgkyen = pTjgkyen;
        tjgkyenValue = null;
        tjgkyenType  = null;
    }

    transient private BigDecimal tjgkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TJGKYEN, nullable=true)
    protected BigDecimal getTjgkyenValue() {
        if (tjgkyenValue == null && tjgkyen != null) {
            if (tjgkyen.isOptional()) return null;
            return tjgkyen.absolute();
        }
        return tjgkyenValue;
    }

    protected void setTjgkyenValue(BigDecimal value) {
        tjgkyenValue = value;
        tjgkyen = Optional.fromNullable(toCurrencyType(tjgkyenType))
            .transform(bizCurrencyTransformer(getTjgkyenValue()))
            .orNull();
    }

    transient private String tjgkyenType = null;

    @Column(name=TJGKYEN + "$", nullable=true)
    protected String getTjgkyenType() {
        if (tjgkyenType == null && tjgkyen != null) return tjgkyen.getType().toString();
        if (tjgkyenType == null && getTjgkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tjgkyen$' should not be NULL."));
        }
        return tjgkyenType;
    }

    protected void setTjgkyenType(String type) {
        tjgkyenType = type;
        tjgkyen = Optional.fromNullable(toCurrencyType(tjgkyenType))
            .transform(bizCurrencyTransformer(getTjgkyenValue()))
            .orNull();
    }

    private Integer zenjitukurikosikensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.ZENJITUKURIKOSIKENSUU)
    public Integer getZenjitukurikosikensuu() {
        return zenjitukurikosikensuu;
    }

    public void setZenjitukurikosikensuu(Integer pZenjitukurikosikensuu) {
        zenjitukurikosikensuu = pZenjitukurikosikensuu;
    }

    private BizCurrency zenjitukurikosigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZenjitukurikosigk() {
        return zenjitukurikosigk;
    }

    public void setZenjitukurikosigk(BizCurrency pZenjitukurikosigk) {
        zenjitukurikosigk = pZenjitukurikosigk;
        zenjitukurikosigkValue = null;
        zenjitukurikosigkType  = null;
    }

    transient private BigDecimal zenjitukurikosigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENJITUKURIKOSIGK, nullable=true)
    protected BigDecimal getZenjitukurikosigkValue() {
        if (zenjitukurikosigkValue == null && zenjitukurikosigk != null) {
            if (zenjitukurikosigk.isOptional()) return null;
            return zenjitukurikosigk.absolute();
        }
        return zenjitukurikosigkValue;
    }

    protected void setZenjitukurikosigkValue(BigDecimal value) {
        zenjitukurikosigkValue = value;
        zenjitukurikosigk = Optional.fromNullable(toCurrencyType(zenjitukurikosigkType))
            .transform(bizCurrencyTransformer(getZenjitukurikosigkValue()))
            .orNull();
    }

    transient private String zenjitukurikosigkType = null;

    @Column(name=ZENJITUKURIKOSIGK + "$", nullable=true)
    protected String getZenjitukurikosigkType() {
        if (zenjitukurikosigkType == null && zenjitukurikosigk != null) return zenjitukurikosigk.getType().toString();
        if (zenjitukurikosigkType == null && getZenjitukurikosigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zenjitukurikosigk$' should not be NULL."));
        }
        return zenjitukurikosigkType;
    }

    protected void setZenjitukurikosigkType(String type) {
        zenjitukurikosigkType = type;
        zenjitukurikosigk = Optional.fromNullable(toCurrencyType(zenjitukurikosigkType))
            .transform(bizCurrencyTransformer(getZenjitukurikosigkValue()))
            .orNull();
    }

    private Integer hrkmtsrykensuu;

    @Column(name=GenHT_JidouSyuunouMeisai2.HRKMTSRYKENSUU)
    public Integer getHrkmtsrykensuu() {
        return hrkmtsrykensuu;
    }

    public void setHrkmtsrykensuu(Integer pHrkmtsrykensuu) {
        hrkmtsrykensuu = pHrkmtsrykensuu;
    }

    private BizCurrency hrkmtsrykingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkmtsrykingk() {
        return hrkmtsrykingk;
    }

    public void setHrkmtsrykingk(BizCurrency pHrkmtsrykingk) {
        hrkmtsrykingk = pHrkmtsrykingk;
        hrkmtsrykingkValue = null;
        hrkmtsrykingkType  = null;
    }

    transient private BigDecimal hrkmtsrykingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKMTSRYKINGK, nullable=true)
    protected BigDecimal getHrkmtsrykingkValue() {
        if (hrkmtsrykingkValue == null && hrkmtsrykingk != null) {
            if (hrkmtsrykingk.isOptional()) return null;
            return hrkmtsrykingk.absolute();
        }
        return hrkmtsrykingkValue;
    }

    protected void setHrkmtsrykingkValue(BigDecimal value) {
        hrkmtsrykingkValue = value;
        hrkmtsrykingk = Optional.fromNullable(toCurrencyType(hrkmtsrykingkType))
            .transform(bizCurrencyTransformer(getHrkmtsrykingkValue()))
            .orNull();
    }

    transient private String hrkmtsrykingkType = null;

    @Column(name=HRKMTSRYKINGK + "$", nullable=true)
    protected String getHrkmtsrykingkType() {
        if (hrkmtsrykingkType == null && hrkmtsrykingk != null) return hrkmtsrykingk.getType().toString();
        if (hrkmtsrykingkType == null && getHrkmtsrykingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkmtsrykingk$' should not be NULL."));
        }
        return hrkmtsrykingkType;
    }

    protected void setHrkmtsrykingkType(String type) {
        hrkmtsrykingkType = type;
        hrkmtsrykingk = Optional.fromNullable(toCurrencyType(hrkmtsrykingkType))
            .transform(bizCurrencyTransformer(getHrkmtsrykingkValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_JidouSyuunouMeisai2.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_JidouSyuunouMeisai2.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}