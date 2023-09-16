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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.id.PKHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.GenQHW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 振込入金対象ワークテーブル テーブルのマッピング情報クラスで、 {@link HW_HrkmNyknTaisyouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_HrkmNyknTaisyouWk}</td><td colspan="3">振込入金対象ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHW_HrkmNyknTaisyouWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHW_HrkmNyknTaisyouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHW_HrkmNyknTaisyouWk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkmirninnm hrkmirninnm}</td><td>振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRsgakuen rsgakuen}</td><td>領収金額（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkmtsry hrkmtsry}</td><td>振込手数料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn}</td><td>振込入金データ連携元区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>{@link #getNyktyhyoutkbn nyktyhyoutkbn}</td><td>入金帳票出力先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_HrkmNyknTaisyouWk
 * @see     PKHW_HrkmNyknTaisyouWk
 * @see     QHW_HrkmNyknTaisyouWk
 * @see     GenQHW_HrkmNyknTaisyouWk
 */
@MappedSuperclass
@Table(name=GenHW_HrkmNyknTaisyouWk.TABLE_NAME)
@IdClass(value=PKHW_HrkmNyknTaisyouWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HrkmnykndatarenmotoKbn", typeClass=UserType_C_HrkmnykndatarenmotoKbn.class),
    @TypeDef(name="UserType_C_NyktyhyoutKbn", typeClass=UserType_C_NyktyhyoutKbn.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHW_HrkmNyknTaisyouWk extends AbstractExDBEntity<HW_HrkmNyknTaisyouWk, PKHW_HrkmNyknTaisyouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_HrkmNyknTaisyouWk";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String HRKMIRNINNM              = "hrkmirninnm";
    public static final String RSGAKU                   = "rsgaku";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String RSGAKUEN                 = "rsgakuen";
    public static final String HRKMTSRY                 = "hrkmtsry";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String HRKMNYKNDATARENMOTOKBN   = "hrkmnykndatarenmotoKbn";
    public static final String NYKTYHYOUTKBN            = "nyktyhyoutkbn";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHW_HrkmNyknTaisyouWk primaryKey;

    public GenHW_HrkmNyknTaisyouWk() {
        primaryKey = new PKHW_HrkmNyknTaisyouWk();
    }

    public GenHW_HrkmNyknTaisyouWk(
        BizDate pSyoriYmd,
        String pMosno,
        Integer pRenno
    ) {
        primaryKey = new PKHW_HrkmNyknTaisyouWk(
            pSyoriYmd,
            pMosno,
            pRenno
        );
    }

    @Transient
    @Override
    public PKHW_HrkmNyknTaisyouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_HrkmNyknTaisyouWk> getMetaClass() {
        return QHW_HrkmNyknTaisyouWk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHW_HrkmNyknTaisyouWk.SYORIYMD)
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
    @Column(name=GenHW_HrkmNyknTaisyouWk.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHW_HrkmNyknTaisyouWk.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String oyadrtencd;

    @Column(name=GenHW_HrkmNyknTaisyouWk.OYADRTENCD)
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

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenHW_HrkmNyknTaisyouWk.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private String hrkmirninnm;

    @Column(name=GenHW_HrkmNyknTaisyouWk.HRKMIRNINNM)
    @MaxLength(max=96)
    @MultiByteStrings
    @InvalidCharacter
    public String getHrkmirninnm() {
        return hrkmirninnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHrkmirninnm(String pHrkmirninnm) {
        hrkmirninnm = pHrkmirninnm;
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

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHW_HrkmNyknTaisyouWk.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizCurrency rsgakuen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRsgakuen() {
        return rsgakuen;
    }

    public void setRsgakuen(BizCurrency pRsgakuen) {
        rsgakuen = pRsgakuen;
        rsgakuenValue = null;
        rsgakuenType  = null;
    }

    transient private BigDecimal rsgakuenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKUEN, nullable=true)
    protected BigDecimal getRsgakuenValue() {
        if (rsgakuenValue == null && rsgakuen != null) {
            if (rsgakuen.isOptional()) return null;
            return rsgakuen.absolute();
        }
        return rsgakuenValue;
    }

    protected void setRsgakuenValue(BigDecimal value) {
        rsgakuenValue = value;
        rsgakuen = Optional.fromNullable(toCurrencyType(rsgakuenType))
            .transform(bizCurrencyTransformer(getRsgakuenValue()))
            .orNull();
    }

    transient private String rsgakuenType = null;

    @Column(name=RSGAKUEN + "$", nullable=true)
    protected String getRsgakuenType() {
        if (rsgakuenType == null && rsgakuen != null) return rsgakuen.getType().toString();
        if (rsgakuenType == null && getRsgakuenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgakuen$' should not be NULL."));
        }
        return rsgakuenType;
    }

    protected void setRsgakuenType(String type) {
        rsgakuenType = type;
        rsgakuen = Optional.fromNullable(toCurrencyType(rsgakuenType))
            .transform(bizCurrencyTransformer(getRsgakuenValue()))
            .orNull();
    }

    private BizCurrency hrkmtsry;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getHrkmtsry() {
        return hrkmtsry;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkmtsry(BizCurrency pHrkmtsry) {
        hrkmtsry = pHrkmtsry;
        hrkmtsryValue = null;
        hrkmtsryType  = null;
    }

    transient private BigDecimal hrkmtsryValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKMTSRY, nullable=true)
    protected BigDecimal getHrkmtsryValue() {
        if (hrkmtsryValue == null && hrkmtsry != null) {
            if (hrkmtsry.isOptional()) return null;
            return hrkmtsry.absolute();
        }
        return hrkmtsryValue;
    }

    protected void setHrkmtsryValue(BigDecimal value) {
        hrkmtsryValue = value;
        hrkmtsry = Optional.fromNullable(toCurrencyType(hrkmtsryType))
            .transform(bizCurrencyTransformer(getHrkmtsryValue()))
            .orNull();
    }

    transient private String hrkmtsryType = null;

    @Column(name=HRKMTSRY + "$", nullable=true)
    protected String getHrkmtsryType() {
        if (hrkmtsryType == null && hrkmtsry != null) return hrkmtsry.getType().toString();
        if (hrkmtsryType == null && getHrkmtsryValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkmtsry$' should not be NULL."));
        }
        return hrkmtsryType;
    }

    protected void setHrkmtsryType(String type) {
        hrkmtsryType = type;
        hrkmtsry = Optional.fromNullable(toCurrencyType(hrkmtsryType))
            .transform(bizCurrencyTransformer(getHrkmtsryValue()))
            .orNull();
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHW_HrkmNyknTaisyouWk.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private C_HrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn;

    @Type(type="UserType_C_HrkmnykndatarenmotoKbn")
    @Column(name=GenHW_HrkmNyknTaisyouWk.HRKMNYKNDATARENMOTOKBN)
    public C_HrkmnykndatarenmotoKbn getHrkmnykndatarenmotoKbn() {
        return hrkmnykndatarenmotoKbn;
    }

    public void setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn pHrkmnykndatarenmotoKbn) {
        hrkmnykndatarenmotoKbn = pHrkmnykndatarenmotoKbn;
    }

    private C_NyktyhyoutKbn nyktyhyoutkbn;

    @Type(type="UserType_C_NyktyhyoutKbn")
    @Column(name=GenHW_HrkmNyknTaisyouWk.NYKTYHYOUTKBN)
    public C_NyktyhyoutKbn getNyktyhyoutkbn() {
        return nyktyhyoutkbn;
    }

    public void setNyktyhyoutkbn(C_NyktyhyoutKbn pNyktyhyoutkbn) {
        nyktyhyoutkbn = pNyktyhyoutkbn;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenHW_HrkmNyknTaisyouWk.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHW_HrkmNyknTaisyouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHW_HrkmNyknTaisyouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}