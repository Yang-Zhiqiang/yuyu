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
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.def.db.id.PKBM_ChkItijibrTuusanS;
import yuyu.def.db.meta.GenQBM_ChkItijibrTuusanS;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanS;

/**
 * 一時払通算限度Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkItijibrTuusanS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkItijibrTuusanS}</td><td colspan="3">一時払通算限度Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkItijibrTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkItijibrTuusanS ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGnds gnds}</td><td>限度Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkItijibrTuusanS
 * @see     PKBM_ChkItijibrTuusanS
 * @see     QBM_ChkItijibrTuusanS
 * @see     GenQBM_ChkItijibrTuusanS
 */
@MappedSuperclass
@Table(name=GenBM_ChkItijibrTuusanS.TABLE_NAME)
@IdClass(value=PKBM_ChkItijibrTuusanS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkItijibrTuusanS extends AbstractExDBEntity<BM_ChkItijibrTuusanS, PKBM_ChkItijibrTuusanS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkItijibrTuusanS";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String GNDS                     = "gnds";

    private final PKBM_ChkItijibrTuusanS primaryKey;

    public GenBM_ChkItijibrTuusanS() {
        primaryKey = new PKBM_ChkItijibrTuusanS();
    }

    public GenBM_ChkItijibrTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        primaryKey = new PKBM_ChkItijibrTuusanS(pHhknfromnen, pHhkntonen);
    }

    @Transient
    @Override
    public PKBM_ChkItijibrTuusanS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkItijibrTuusanS> getMetaClass() {
        return QBM_ChkItijibrTuusanS.class;
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkItijibrTuusanS.HHKNFROMNEN)
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
    @Column(name=GenBM_ChkItijibrTuusanS.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
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
