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
import yuyu.def.db.entity.BM_FundIndexCfGaku;
import yuyu.def.db.id.PKBM_FundIndexCfGaku;
import yuyu.def.db.meta.GenQBM_FundIndexCfGaku;
import yuyu.def.db.meta.QBM_FundIndexCfGaku;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックスＣＦ額マスタ テーブルのマッピング情報クラスで、 {@link BM_FundIndexCfGaku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_FundIndexCfGaku}</td><td colspan="3">ファンドインデックスＣＦ額マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKBM_FundIndexCfGaku ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getFundhyoukaymd fundhyoukaymd}</td><td>ファンド評価年月日　　　　</td><td align="center">{@link PKBM_FundIndexCfGaku ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSegkey segkey}</td><td>ＳＥＧＫＥＹ　　　　　　　　</td><td align="center">{@link PKBM_FundIndexCfGaku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCfgaku cfgaku}</td><td>ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGkcfgaku gkcfgaku}</td><td>（外貨）ＣＦ額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_FundIndexCfGaku
 * @see     PKBM_FundIndexCfGaku
 * @see     QBM_FundIndexCfGaku
 * @see     GenQBM_FundIndexCfGaku
 */
@MappedSuperclass
@Table(name=GenBM_FundIndexCfGaku.TABLE_NAME)
@IdClass(value=PKBM_FundIndexCfGaku.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBM_FundIndexCfGaku extends AbstractExDBEntity<BM_FundIndexCfGaku, PKBM_FundIndexCfGaku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_FundIndexCfGaku";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String FUNDHYOUKAYMD            = "fundhyoukaymd";
    public static final String SEGKEY                   = "segkey";
    public static final String CFGAKU                   = "cfgaku";
    public static final String GKCFGAKU                 = "gkcfgaku";

    private final PKBM_FundIndexCfGaku primaryKey;

    public GenBM_FundIndexCfGaku() {
        primaryKey = new PKBM_FundIndexCfGaku();
    }

    public GenBM_FundIndexCfGaku(
        C_UnitFundKbn pUnitfundkbn,
        BizDate pFundhyoukaymd,
        String pSegkey
    ) {
        primaryKey = new PKBM_FundIndexCfGaku(
            pUnitfundkbn,
            pFundhyoukaymd,
            pSegkey
        );
    }

    @Transient
    @Override
    public PKBM_FundIndexCfGaku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_FundIndexCfGaku> getMetaClass() {
        return QBM_FundIndexCfGaku.class;
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBM_FundIndexCfGaku.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_FundIndexCfGaku.FUNDHYOUKAYMD)
    public BizDate getFundhyoukaymd() {
        return getPrimaryKey().getFundhyoukaymd();
    }

    public void setFundhyoukaymd(BizDate pFundhyoukaymd) {
        getPrimaryKey().setFundhyoukaymd(pFundhyoukaymd);
    }

    @Id
    @Column(name=GenBM_FundIndexCfGaku.SEGKEY)
    public String getSegkey() {
        return getPrimaryKey().getSegkey();
    }

    public void setSegkey(String pSegkey) {
        getPrimaryKey().setSegkey(pSegkey);
    }

    private BizCurrency cfgaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCfgaku() {
        return cfgaku;
    }

    public void setCfgaku(BizCurrency pCfgaku) {
        cfgaku = pCfgaku;
        cfgakuValue = null;
        cfgakuType  = null;
    }

    transient private BigDecimal cfgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CFGAKU, nullable=true)
    protected BigDecimal getCfgakuValue() {
        if (cfgakuValue == null && cfgaku != null) {
            if (cfgaku.isOptional()) return null;
            return cfgaku.absolute();
        }
        return cfgakuValue;
    }

    protected void setCfgakuValue(BigDecimal value) {
        cfgakuValue = value;
        cfgaku = Optional.fromNullable(toCurrencyType(cfgakuType))
            .transform(bizCurrencyTransformer(getCfgakuValue()))
            .orNull();
    }

    transient private String cfgakuType = null;

    @Column(name=CFGAKU + "$", nullable=true)
    protected String getCfgakuType() {
        if (cfgakuType == null && cfgaku != null) return cfgaku.getType().toString();
        if (cfgakuType == null && getCfgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'cfgaku$' should not be NULL."));
        }
        return cfgakuType;
    }

    protected void setCfgakuType(String type) {
        cfgakuType = type;
        cfgaku = Optional.fromNullable(toCurrencyType(cfgakuType))
            .transform(bizCurrencyTransformer(getCfgakuValue()))
            .orNull();
    }

    private BizCurrency gkcfgaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGkcfgaku() {
        return gkcfgaku;
    }

    public void setGkcfgaku(BizCurrency pGkcfgaku) {
        gkcfgaku = pGkcfgaku;
        gkcfgakuValue = null;
        gkcfgakuType  = null;
    }

    transient private BigDecimal gkcfgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GKCFGAKU, nullable=true)
    protected BigDecimal getGkcfgakuValue() {
        if (gkcfgakuValue == null && gkcfgaku != null) {
            if (gkcfgaku.isOptional()) return null;
            return gkcfgaku.absolute();
        }
        return gkcfgakuValue;
    }

    protected void setGkcfgakuValue(BigDecimal value) {
        gkcfgakuValue = value;
        gkcfgaku = Optional.fromNullable(toCurrencyType(gkcfgakuType))
            .transform(bizCurrencyTransformer(getGkcfgakuValue()))
            .orNull();
    }

    transient private String gkcfgakuType = null;

    @Column(name=GKCFGAKU + "$", nullable=true)
    protected String getGkcfgakuType() {
        if (gkcfgakuType == null && gkcfgaku != null) return gkcfgaku.getType().toString();
        if (gkcfgakuType == null && getGkcfgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gkcfgaku$' should not be NULL."));
        }
        return gkcfgakuType;
    }

    protected void setGkcfgakuType(String type) {
        gkcfgakuType = type;
        gkcfgaku = Optional.fromNullable(toCurrencyType(gkcfgakuType))
            .transform(bizCurrencyTransformer(getGkcfgakuValue()))
            .orNull();
    }
}
