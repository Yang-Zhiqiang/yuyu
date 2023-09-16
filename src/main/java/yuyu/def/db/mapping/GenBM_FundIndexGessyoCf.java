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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGessyoCf;
import yuyu.def.db.id.PKBM_FundIndexGessyoCf;
import yuyu.def.db.meta.GenQBM_FundIndexGessyoCf;
import yuyu.def.db.meta.QBM_FundIndexGessyoCf;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス月初ＣＦマスタ テーブルのマッピング情報クラスで、 {@link BM_FundIndexGessyoCf} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexGessyoCf}</td><td colspan="3">ファンドインデックス月初ＣＦマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKBM_FundIndexGessyoCf ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">{@link PKBM_FundIndexGessyoCf ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">{@link PKBM_FundIndexGessyoCf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGscfhkkkgahurikaegaku gscfhkkkgahurikaegaku}</td><td>月初ＣＦ保険関係ＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgscfhkkkgahurikaegaku gkgscfhkkkgahurikaegaku}</td><td>（外貨）月初ＣＦ保険関係ＧＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGscfhkkksahurikaegaku gscfhkkksahurikaegaku}</td><td>月初ＣＦ保険関係ＳＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkgscfhkkksahurikaegaku gkgscfhkkksahurikaegaku}</td><td>（外貨）月初ＣＦ保険関係ＳＡ振替額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_FundIndexGessyoCf
 * @see     PKBM_FundIndexGessyoCf
 * @see     QBM_FundIndexGessyoCf
 * @see     GenQBM_FundIndexGessyoCf
 */
@MappedSuperclass
@Table(name=GenBM_FundIndexGessyoCf.TABLE_NAME)
@IdClass(value=PKBM_FundIndexGessyoCf.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBM_FundIndexGessyoCf extends AbstractExDBEntity<BM_FundIndexGessyoCf, PKBM_FundIndexGessyoCf> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_FundIndexGessyoCf";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String FUNDHYOUKAYMD            = "fundhyoukaymd";
    public static final String SEGKEY                   = "segkey";
    public static final String GSCFHKKKGAHURIKAEGAKU    = "gscfhkkkgahurikaegaku";
    public static final String GKGSCFHKKKGAHURIKAEGAKU  = "gkgscfhkkkgahurikaegaku";
    public static final String GSCFHKKKSAHURIKAEGAKU    = "gscfhkkksahurikaegaku";
    public static final String GKGSCFHKKKSAHURIKAEGAKU  = "gkgscfhkkksahurikaegaku";

    private final PKBM_FundIndexGessyoCf primaryKey;

    public GenBM_FundIndexGessyoCf() {
        primaryKey = new PKBM_FundIndexGessyoCf();
    }

    public GenBM_FundIndexGessyoCf(
        C_UnitFundKbn pUnitfundkbn,
        BizDate pFundhyoukaymd,
        String pSegkey
    ) {
        primaryKey = new PKBM_FundIndexGessyoCf(
            pUnitfundkbn,
            pFundhyoukaymd,
            pSegkey
        );
    }

    @Transient
    @Override
    public PKBM_FundIndexGessyoCf getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_FundIndexGessyoCf> getMetaClass() {
        return QBM_FundIndexGessyoCf.class;
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBM_FundIndexGessyoCf.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexGessyoCf.FUNDHYOUKAYMD)
    public BizDate getFundhyoukaymd() {
        return getPrimaryKey().getFundhyoukaymd();
    }

    public void setFundhyoukaymd(BizDate pFundhyoukaymd) {
        getPrimaryKey().setFundhyoukaymd(pFundhyoukaymd);
    }

    @Id
    @Column(name=GenBM_FundIndexGessyoCf.SEGKEY)
    public String getSegkey() {
        return getPrimaryKey().getSegkey();
    }

    public void setSegkey(String pSegkey) {
        getPrimaryKey().setSegkey(pSegkey);
    }

    private BizCurrency gscfhkkkgahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGscfhkkkgahurikaegaku() {
        return gscfhkkkgahurikaegaku;
    }

    public void setGscfhkkkgahurikaegaku(BizCurrency pGscfhkkkgahurikaegaku) {
        gscfhkkkgahurikaegaku = pGscfhkkkgahurikaegaku;
        gscfhkkkgahurikaegakuValue = null;
        gscfhkkkgahurikaegakuType  = null;
    }

    transient private BigDecimal gscfhkkkgahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GSCFHKKKGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGscfhkkkgahurikaegakuValue() {
        if (gscfhkkkgahurikaegakuValue == null && gscfhkkkgahurikaegaku != null) {
            if (gscfhkkkgahurikaegaku.isOptional()) return null;
            return gscfhkkkgahurikaegaku.absolute();
        }
        return gscfhkkkgahurikaegakuValue;
    }

    protected void setGscfhkkkgahurikaegakuValue(BigDecimal value) {
        gscfhkkkgahurikaegakuValue = value;
        gscfhkkkgahurikaegaku = Optional.fromNullable(toCurrencyType(gscfhkkkgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGscfhkkkgahurikaegakuValue()))
            .orNull();
    }

    transient private String gscfhkkkgahurikaegakuType = null;

    @Column(name=GSCFHKKKGAHURIKAEGAKU + "$", nullable=true)
    protected String getGscfhkkkgahurikaegakuType() {
        if (gscfhkkkgahurikaegakuType == null && gscfhkkkgahurikaegaku != null) return gscfhkkkgahurikaegaku.getType().toString();
        if (gscfhkkkgahurikaegakuType == null && getGscfhkkkgahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gscfhkkkgahurikaegaku$' should not be NULL."));
        }
        return gscfhkkkgahurikaegakuType;
    }

    protected void setGscfhkkkgahurikaegakuType(String type) {
        gscfhkkkgahurikaegakuType = type;
        gscfhkkkgahurikaegaku = Optional.fromNullable(toCurrencyType(gscfhkkkgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGscfhkkkgahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gkgscfhkkkgahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgscfhkkkgahurikaegaku() {
        return gkgscfhkkkgahurikaegaku;
    }

    public void setGkgscfhkkkgahurikaegaku(BizCurrency pGkgscfhkkkgahurikaegaku) {
        gkgscfhkkkgahurikaegaku = pGkgscfhkkkgahurikaegaku;
        gkgscfhkkkgahurikaegakuValue = null;
        gkgscfhkkkgahurikaegakuType  = null;
    }

    transient private BigDecimal gkgscfhkkkgahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGSCFHKKKGAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGkgscfhkkkgahurikaegakuValue() {
        if (gkgscfhkkkgahurikaegakuValue == null && gkgscfhkkkgahurikaegaku != null) {
            if (gkgscfhkkkgahurikaegaku.isOptional()) return null;
            return gkgscfhkkkgahurikaegaku.absolute();
        }
        return gkgscfhkkkgahurikaegakuValue;
    }

    protected void setGkgscfhkkkgahurikaegakuValue(BigDecimal value) {
        gkgscfhkkkgahurikaegakuValue = value;
        gkgscfhkkkgahurikaegaku = Optional.fromNullable(toCurrencyType(gkgscfhkkkgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgscfhkkkgahurikaegakuValue()))
            .orNull();
    }

    transient private String gkgscfhkkkgahurikaegakuType = null;

    @Column(name=GKGSCFHKKKGAHURIKAEGAKU + "$", nullable=true)
    protected String getGkgscfhkkkgahurikaegakuType() {
        if (gkgscfhkkkgahurikaegakuType == null && gkgscfhkkkgahurikaegaku != null) return gkgscfhkkkgahurikaegaku.getType().toString();
        if (gkgscfhkkkgahurikaegakuType == null && getGkgscfhkkkgahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgscfhkkkgahurikaegaku$' should not be NULL."));
        }
        return gkgscfhkkkgahurikaegakuType;
    }

    protected void setGkgscfhkkkgahurikaegakuType(String type) {
        gkgscfhkkkgahurikaegakuType = type;
        gkgscfhkkkgahurikaegaku = Optional.fromNullable(toCurrencyType(gkgscfhkkkgahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgscfhkkkgahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gscfhkkksahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGscfhkkksahurikaegaku() {
        return gscfhkkksahurikaegaku;
    }

    public void setGscfhkkksahurikaegaku(BizCurrency pGscfhkkksahurikaegaku) {
        gscfhkkksahurikaegaku = pGscfhkkksahurikaegaku;
        gscfhkkksahurikaegakuValue = null;
        gscfhkkksahurikaegakuType  = null;
    }

    transient private BigDecimal gscfhkkksahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GSCFHKKKSAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGscfhkkksahurikaegakuValue() {
        if (gscfhkkksahurikaegakuValue == null && gscfhkkksahurikaegaku != null) {
            if (gscfhkkksahurikaegaku.isOptional()) return null;
            return gscfhkkksahurikaegaku.absolute();
        }
        return gscfhkkksahurikaegakuValue;
    }

    protected void setGscfhkkksahurikaegakuValue(BigDecimal value) {
        gscfhkkksahurikaegakuValue = value;
        gscfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gscfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGscfhkkksahurikaegakuValue()))
            .orNull();
    }

    transient private String gscfhkkksahurikaegakuType = null;

    @Column(name=GSCFHKKKSAHURIKAEGAKU + "$", nullable=true)
    protected String getGscfhkkksahurikaegakuType() {
        if (gscfhkkksahurikaegakuType == null && gscfhkkksahurikaegaku != null) return gscfhkkksahurikaegaku.getType().toString();
        if (gscfhkkksahurikaegakuType == null && getGscfhkkksahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gscfhkkksahurikaegaku$' should not be NULL."));
        }
        return gscfhkkksahurikaegakuType;
    }

    protected void setGscfhkkksahurikaegakuType(String type) {
        gscfhkkksahurikaegakuType = type;
        gscfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gscfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGscfhkkksahurikaegakuValue()))
            .orNull();
    }

    private BizCurrency gkgscfhkkksahurikaegaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkgscfhkkksahurikaegaku() {
        return gkgscfhkkksahurikaegaku;
    }

    public void setGkgscfhkkksahurikaegaku(BizCurrency pGkgscfhkkksahurikaegaku) {
        gkgscfhkkksahurikaegaku = pGkgscfhkkksahurikaegaku;
        gkgscfhkkksahurikaegakuValue = null;
        gkgscfhkkksahurikaegakuType  = null;
    }

    transient private BigDecimal gkgscfhkkksahurikaegakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKGSCFHKKKSAHURIKAEGAKU, nullable=true)
    protected BigDecimal getGkgscfhkkksahurikaegakuValue() {
        if (gkgscfhkkksahurikaegakuValue == null && gkgscfhkkksahurikaegaku != null) {
            if (gkgscfhkkksahurikaegaku.isOptional()) return null;
            return gkgscfhkkksahurikaegaku.absolute();
        }
        return gkgscfhkkksahurikaegakuValue;
    }

    protected void setGkgscfhkkksahurikaegakuValue(BigDecimal value) {
        gkgscfhkkksahurikaegakuValue = value;
        gkgscfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gkgscfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgscfhkkksahurikaegakuValue()))
            .orNull();
    }

    transient private String gkgscfhkkksahurikaegakuType = null;

    @Column(name=GKGSCFHKKKSAHURIKAEGAKU + "$", nullable=true)
    protected String getGkgscfhkkksahurikaegakuType() {
        if (gkgscfhkkksahurikaegakuType == null && gkgscfhkkksahurikaegaku != null) return gkgscfhkkksahurikaegaku.getType().toString();
        if (gkgscfhkkksahurikaegakuType == null && getGkgscfhkkksahurikaegakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkgscfhkkksahurikaegaku$' should not be NULL."));
        }
        return gkgscfhkkksahurikaegakuType;
    }

    protected void setGkgscfhkkksahurikaegakuType(String type) {
        gkgscfhkkksahurikaegakuType = type;
        gkgscfhkkksahurikaegaku = Optional.fromNullable(toCurrencyType(gkgscfhkkksahurikaegakuType))
            .transform(bizCurrencyTransformer(getGkgscfhkkksahurikaegakuValue()))
            .orNull();
    }
}
