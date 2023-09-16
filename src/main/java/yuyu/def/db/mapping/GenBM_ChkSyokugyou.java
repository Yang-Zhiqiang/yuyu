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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkSyokugyou;
import yuyu.def.db.id.PKBM_ChkSyokugyou;
import yuyu.def.db.meta.GenQBM_ChkSyokugyou;
import yuyu.def.db.meta.QBM_ChkSyokugyou;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 職業制限チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSyokugyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSyokugyou}</td><td colspan="3">職業制限チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyokugyoucd syokugyoucd}</td><td>職業コード</td><td align="center">{@link PKBM_ChkSyokugyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGndntgk gndntgk}</td><td>限度日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds gnds}</td><td>限度Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkSyokugyou
 * @see     PKBM_ChkSyokugyou
 * @see     QBM_ChkSyokugyou
 * @see     GenQBM_ChkSyokugyou
 */
@MappedSuperclass
@Table(name=GenBM_ChkSyokugyou.TABLE_NAME)
@IdClass(value=PKBM_ChkSyokugyou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class)
})
public abstract class GenBM_ChkSyokugyou extends AbstractExDBEntity<BM_ChkSyokugyou, PKBM_ChkSyokugyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSyokugyou";
    public static final String SYOKUGYOUCD              = "syokugyoucd";
    public static final String GNDNTGK                  = "gndntgk";
    public static final String GNDS                     = "gnds";

    private final PKBM_ChkSyokugyou primaryKey;

    public GenBM_ChkSyokugyou() {
        primaryKey = new PKBM_ChkSyokugyou();
    }

    public GenBM_ChkSyokugyou(String pSyokugyoucd) {
        primaryKey = new PKBM_ChkSyokugyou(pSyokugyoucd);
    }

    @Transient
    @Override
    public PKBM_ChkSyokugyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSyokugyou> getMetaClass() {
        return QBM_ChkSyokugyou.class;
    }

    @Id
    @Column(name=GenBM_ChkSyokugyou.SYOKUGYOUCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyokugyoucd() {
        return getPrimaryKey().getSyokugyoucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyokugyoucd(String pSyokugyoucd) {
        getPrimaryKey().setSyokugyoucd(pSyokugyoucd);
    }

    private BizCurrency gndntgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGndntgk() {
        return gndntgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGndntgk(BizCurrency pGndntgk) {
        gndntgk = pGndntgk;
        gndntgkValue = null;
        gndntgkType  = null;
    }

    transient private BigDecimal gndntgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDNTGK, nullable=true)
    protected BigDecimal getGndntgkValue() {
        if (gndntgkValue == null && gndntgk != null) {
            if (gndntgk.isOptional()) return null;
            return gndntgk.absolute();
        }
        return gndntgkValue;
    }

    protected void setGndntgkValue(BigDecimal value) {
        gndntgkValue = value;
        gndntgk = Optional.fromNullable(toCurrencyType(gndntgkType))
            .transform(bizCurrencyTransformer(getGndntgkValue()))
            .orNull();
    }

    transient private String gndntgkType = null;

    @Column(name=GNDNTGK + "$", nullable=true)
    protected String getGndntgkType() {
        if (gndntgkType == null && gndntgk != null) return gndntgk.getType().toString();
        if (gndntgkType == null && getGndntgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gndntgk$' should not be NULL."));
        }
        return gndntgkType;
    }

    protected void setGndntgkType(String type) {
        gndntgkType = type;
        gndntgk = Optional.fromNullable(toCurrencyType(gndntgkType))
            .transform(bizCurrencyTransformer(getGndntgkValue()))
            .orNull();
    }

    private BizCurrency gnds;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnds() {
        return gnds;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnds(BizCurrency pGnds) {
        gnds = pGnds;
        gndsValue = null;
        gndsType  = null;
    }

    transient private BigDecimal gndsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDS, nullable=true)
    protected BigDecimal getGndsValue() {
        if (gndsValue == null && gnds != null) {
            if (gnds.isOptional()) return null;
            return gnds.absolute();
        }
        return gndsValue;
    }

    protected void setGndsValue(BigDecimal value) {
        gndsValue = value;
        gnds = Optional.fromNullable(toCurrencyType(gndsType))
            .transform(bizCurrencyTransformer(getGndsValue()))
            .orNull();
    }

    transient private String gndsType = null;

    @Column(name=GNDS + "$", nullable=true)
    protected String getGndsType() {
        if (gndsType == null && gnds != null) return gnds.getType().toString();
        if (gndsType == null && getGndsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnds$' should not be NULL."));
        }
        return gndsType;
    }

    protected void setGndsType(String type) {
        gndsType = type;
        gnds = Optional.fromNullable(toCurrencyType(gndsType))
            .transform(bizCurrencyTransformer(getGndsValue()))
            .orNull();
    }
}