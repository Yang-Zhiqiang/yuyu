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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.id.PKHT_GrossNyknMeisai;
import yuyu.def.db.meta.GenQHT_GrossNyknMeisai;
import yuyu.def.db.meta.QHT_GrossNyknMeisai;

/**
 * グロス入金明細テーブル テーブルのマッピング情報クラスで、 {@link HT_GrossNyknMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GrossNyknMeisai}</td><td colspan="3">グロス入金明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">{@link PKHT_GrossNyknMeisai ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">{@link PKHT_GrossNyknMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_GrossNyknMeisai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMeisairenno meisairenno}</td><td>明細連番</td><td align="center">{@link PKHT_GrossNyknMeisai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDengk dengk}</td><td>伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GrossNyknMeisai
 * @see     PKHT_GrossNyknMeisai
 * @see     QHT_GrossNyknMeisai
 * @see     GenQHT_GrossNyknMeisai
 */
@MappedSuperclass
@Table(name=GenHT_GrossNyknMeisai.TABLE_NAME)
@IdClass(value=PKHT_GrossNyknMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenHT_GrossNyknMeisai extends AbstractExDBEntity<HT_GrossNyknMeisai, PKHT_GrossNyknMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_GrossNyknMeisai";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String RENNO                    = "renno";
    public static final String MEISAIRENNO              = "meisairenno";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String RSGAKU                   = "rsgaku";
    public static final String DENGK                    = "dengk";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_GrossNyknMeisai primaryKey;

    public GenHT_GrossNyknMeisai() {
        primaryKey = new PKHT_GrossNyknMeisai();
    }

    public GenHT_GrossNyknMeisai(
        BizDate pRyosyuymd,
        String pOyadrtencd,
        Integer pRenno,
        Integer pMeisairenno
    ) {
        primaryKey = new PKHT_GrossNyknMeisai(
            pRyosyuymd,
            pOyadrtencd,
            pRenno,
            pMeisairenno
        );
    }

    @Transient
    @Override
    public PKHT_GrossNyknMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_GrossNyknMeisai> getMetaClass() {
        return QHT_GrossNyknMeisai.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_GrossNyknMeisai.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return getPrimaryKey().getRyosyuymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        getPrimaryKey().setRyosyuymd(pRyosyuymd);
    }

    @Id
    @Column(name=GenHT_GrossNyknMeisai.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return getPrimaryKey().getOyadrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        getPrimaryKey().setOyadrtencd(pOyadrtencd);
    }

    @Id
    @Column(name=GenHT_GrossNyknMeisai.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    @Id
    @Column(name=GenHT_GrossNyknMeisai.MEISAIRENNO)
    public Integer getMeisairenno() {
        return getPrimaryKey().getMeisairenno();
    }

    public void setMeisairenno(Integer pMeisairenno) {
        getPrimaryKey().setMeisairenno(pMeisairenno);
    }

    private String nykmosno;

    @Column(name=GenHT_GrossNyknMeisai.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private BizCurrency rsgaku;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
        rsgakuValue = null;
        rsgakuType  = null;
    }

    transient private BigDecimal rsgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKU, nullable=true)
    protected BigDecimal getRsgakuValue() {
        if (rsgakuValue == null && rsgaku != null) {
            if (rsgaku.isOptional()) return null;
            return rsgaku.absolute();
        }
        return rsgakuValue;
    }

    protected void setRsgakuValue(BigDecimal value) {
        rsgakuValue = value;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    transient private String rsgakuType = null;

    @Column(name=RSGAKU + "$", nullable=true)
    protected String getRsgakuType() {
        if (rsgakuType == null && rsgaku != null) return rsgaku.getType().toString();
        if (rsgakuType == null && getRsgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgaku$' should not be NULL."));
        }
        return rsgakuType;
    }

    protected void setRsgakuType(String type) {
        rsgakuType = type;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    private BizCurrency dengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDengk() {
        return dengk;
    }

    public void setDengk(BizCurrency pDengk) {
        dengk = pDengk;
        dengkValue = null;
        dengkType  = null;
    }

    transient private BigDecimal dengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENGK, nullable=true)
    protected BigDecimal getDengkValue() {
        if (dengkValue == null && dengk != null) {
            if (dengk.isOptional()) return null;
            return dengk.absolute();
        }
        return dengkValue;
    }

    protected void setDengkValue(BigDecimal value) {
        dengkValue = value;
        dengk = Optional.fromNullable(toCurrencyType(dengkType))
            .transform(bizCurrencyTransformer(getDengkValue()))
            .orNull();
    }

    transient private String dengkType = null;

    @Column(name=DENGK + "$", nullable=true)
    protected String getDengkType() {
        if (dengkType == null && dengk != null) return dengk.getType().toString();
        if (dengkType == null && getDengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dengk$' should not be NULL."));
        }
        return dengkType;
    }

    protected void setDengkType(String type) {
        dengkType = type;
        dengk = Optional.fromNullable(toCurrencyType(dengkType))
            .transform(bizCurrencyTransformer(getDengkValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_GrossNyknMeisai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_GrossNyknMeisai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}