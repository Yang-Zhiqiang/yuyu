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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.def.db.id.PKBM_ChkItijibrTuusanP;
import yuyu.def.db.meta.GenQBM_ChkItijibrTuusanP;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanP;

/**
 * 一時払通算限度Ｐチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkItijibrTuusanP} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkItijibrTuusanP}</td><td colspan="3">一時払通算限度Ｐチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkItijibrTuusanP ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkItijibrTuusanP ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGnditijibaraip gnditijibaraip}</td><td>限度一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkItijibrTuusanP
 * @see     PKBM_ChkItijibrTuusanP
 * @see     QBM_ChkItijibrTuusanP
 * @see     GenQBM_ChkItijibrTuusanP
 */
@MappedSuperclass
@Table(name=GenBM_ChkItijibrTuusanP.TABLE_NAME)
@IdClass(value=PKBM_ChkItijibrTuusanP.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkItijibrTuusanP extends AbstractExDBEntity<BM_ChkItijibrTuusanP, PKBM_ChkItijibrTuusanP> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkItijibrTuusanP";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String GNDITIJIBARAIP           = "gnditijibaraip";

    private final PKBM_ChkItijibrTuusanP primaryKey;

    public GenBM_ChkItijibrTuusanP() {
        primaryKey = new PKBM_ChkItijibrTuusanP();
    }

    public GenBM_ChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        primaryKey = new PKBM_ChkItijibrTuusanP(pHhknfromnen, pHhkntonen);
    }

    @Transient
    @Override
    public PKBM_ChkItijibrTuusanP getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkItijibrTuusanP> getMetaClass() {
        return QBM_ChkItijibrTuusanP.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkItijibrTuusanP.HHKNFROMNEN)
    public BizNumber getHhknfromnen() {
        return getPrimaryKey().getHhknfromnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknfromnen(BizNumber pHhknfromnen) {
        getPrimaryKey().setHhknfromnen(pHhknfromnen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkItijibrTuusanP.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    private BizCurrency gnditijibaraip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGnditijibaraip() {
        return gnditijibaraip;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGnditijibaraip(BizCurrency pGnditijibaraip) {
        gnditijibaraip = pGnditijibaraip;
        gnditijibaraipValue = null;
        gnditijibaraipType  = null;
    }

    transient private BigDecimal gnditijibaraipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GNDITIJIBARAIP, nullable=true)
    protected BigDecimal getGnditijibaraipValue() {
        if (gnditijibaraipValue == null && gnditijibaraip != null) {
            if (gnditijibaraip.isOptional()) return null;
            return gnditijibaraip.absolute();
        }
        return gnditijibaraipValue;
    }

    protected void setGnditijibaraipValue(BigDecimal value) {
        gnditijibaraipValue = value;
        gnditijibaraip = Optional.fromNullable(toCurrencyType(gnditijibaraipType))
            .transform(bizCurrencyTransformer(getGnditijibaraipValue()))
            .orNull();
    }

    transient private String gnditijibaraipType = null;

    @Column(name=GNDITIJIBARAIP + "$", nullable=true)
    protected String getGnditijibaraipType() {
        if (gnditijibaraipType == null && gnditijibaraip != null) return gnditijibaraip.getType().toString();
        if (gnditijibaraipType == null && getGnditijibaraipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gnditijibaraip$' should not be NULL."));
        }
        return gnditijibaraipType;
    }

    protected void setGnditijibaraipType(String type) {
        gnditijibaraipType = type;
        gnditijibaraip = Optional.fromNullable(toCurrencyType(gnditijibaraipType))
            .transform(bizCurrencyTransformer(getGnditijibaraipValue()))
            .orNull();
    }
}
