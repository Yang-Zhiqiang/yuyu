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
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import yuyu.def.db.id.PKHM_ChkTesuuryou;
import yuyu.def.db.meta.GenQHM_ChkTesuuryou;
import yuyu.def.db.meta.QHM_ChkTesuuryou;

/**
 * 手数料チェックマスタ テーブルのマッピング情報クラスで、 {@link HM_ChkTesuuryou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_ChkTesuuryou}</td><td colspan="3">手数料チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKHM_ChkTesuuryou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkmtsry hrkmtsry}</td><td>振込手数料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     HM_ChkTesuuryou
 * @see     PKHM_ChkTesuuryou
 * @see     QHM_ChkTesuuryou
 * @see     GenQHM_ChkTesuuryou
 */
@MappedSuperclass
@Table(name=GenHM_ChkTesuuryou.TABLE_NAME)
@IdClass(value=PKHM_ChkTesuuryou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class)
})
public abstract class GenHM_ChkTesuuryou extends AbstractExDBEntity<HM_ChkTesuuryou, PKHM_ChkTesuuryou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_ChkTesuuryou";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String HRKMTSRY                 = "hrkmtsry";

    private final PKHM_ChkTesuuryou primaryKey;

    public GenHM_ChkTesuuryou() {
        primaryKey = new PKHM_ChkTesuuryou();
    }

    public GenHM_ChkTesuuryou(Integer pRenno3keta) {
        primaryKey = new PKHM_ChkTesuuryou(pRenno3keta);
    }

    @Transient
    @Override
    public PKHM_ChkTesuuryou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_ChkTesuuryou> getMetaClass() {
        return QHM_ChkTesuuryou.class;
    }

    @Id
    @Column(name=GenHM_ChkTesuuryou.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
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
}
