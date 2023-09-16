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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;
import yuyu.def.db.id.PKBM_ChkNensyuuBairitu;
import yuyu.def.db.meta.GenQBM_ChkNensyuuBairitu;
import yuyu.def.db.meta.QBM_ChkNensyuuBairitu;
import yuyu.def.db.type.UserType_C_NensyuuKbn;

/**
 * 年収倍率チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkNensyuuBairitu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNensyuuBairitu}</td><td colspan="3">年収倍率チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNensyuukbn nensyuukbn}</td><td>年収区分</td><td align="center">{@link PKBM_ChkNensyuuBairitu ○}</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getGndntgk gndntgk}</td><td>限度日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGnds gnds}</td><td>限度Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkNensyuuBairitu
 * @see     PKBM_ChkNensyuuBairitu
 * @see     QBM_ChkNensyuuBairitu
 * @see     GenQBM_ChkNensyuuBairitu
 */
@MappedSuperclass
@Table(name=GenBM_ChkNensyuuBairitu.TABLE_NAME)
@IdClass(value=PKBM_ChkNensyuuBairitu.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class)
})
public abstract class GenBM_ChkNensyuuBairitu extends AbstractExDBEntity<BM_ChkNensyuuBairitu, PKBM_ChkNensyuuBairitu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkNensyuuBairitu";
    public static final String NENSYUUKBN               = "nensyuukbn";
    public static final String GNDNTGK                  = "gndntgk";
    public static final String GNDS                     = "gnds";

    private final PKBM_ChkNensyuuBairitu primaryKey;

    public GenBM_ChkNensyuuBairitu() {
        primaryKey = new PKBM_ChkNensyuuBairitu();
    }

    public GenBM_ChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn) {
        primaryKey = new PKBM_ChkNensyuuBairitu(pNensyuukbn);
    }

    @Transient
    @Override
    public PKBM_ChkNensyuuBairitu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkNensyuuBairitu> getMetaClass() {
        return QBM_ChkNensyuuBairitu.class;
    }

    @Id
    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenBM_ChkNensyuuBairitu.NENSYUUKBN)
    public C_NensyuuKbn getNensyuukbn() {
        return getPrimaryKey().getNensyuukbn();
    }

    public void setNensyuukbn(C_NensyuuKbn pNensyuukbn) {
        getPrimaryKey().setNensyuukbn(pNensyuukbn);
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
