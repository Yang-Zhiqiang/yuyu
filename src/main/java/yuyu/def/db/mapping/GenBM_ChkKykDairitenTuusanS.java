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
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;
import yuyu.def.db.id.PKBM_ChkKykDairitenTuusanS;
import yuyu.def.db.meta.GenQBM_ChkKykDairitenTuusanS;
import yuyu.def.db.meta.QBM_ChkKykDairitenTuusanS;
import yuyu.def.db.type.UserType_C_KihonssyuruiKbn;

/**
 * 契約者同一代理店通算Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkKykDairitenTuusanS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKykDairitenTuusanS}</td><td colspan="3">契約者同一代理店通算Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKihonssyuruikbn kihonssyuruikbn}</td><td>基本Ｓ種類区分</td><td align="center">{@link PKBM_ChkKykDairitenTuusanS ○}</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getGnds gnds}</td><td>限度Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkKykDairitenTuusanS
 * @see     PKBM_ChkKykDairitenTuusanS
 * @see     QBM_ChkKykDairitenTuusanS
 * @see     GenQBM_ChkKykDairitenTuusanS
 */
@MappedSuperclass
@Table(name=GenBM_ChkKykDairitenTuusanS.TABLE_NAME)
@IdClass(value=PKBM_ChkKykDairitenTuusanS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_KihonssyuruiKbn", typeClass=UserType_C_KihonssyuruiKbn.class)
})
public abstract class GenBM_ChkKykDairitenTuusanS extends AbstractExDBEntity<BM_ChkKykDairitenTuusanS, PKBM_ChkKykDairitenTuusanS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkKykDairitenTuusanS";
    public static final String KIHONSSYURUIKBN          = "kihonssyuruikbn";
    public static final String GNDS                     = "gnds";

    private final PKBM_ChkKykDairitenTuusanS primaryKey;

    public GenBM_ChkKykDairitenTuusanS() {
        primaryKey = new PKBM_ChkKykDairitenTuusanS();
    }

    public GenBM_ChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn) {
        primaryKey = new PKBM_ChkKykDairitenTuusanS(pKihonssyuruikbn);
    }

    @Transient
    @Override
    public PKBM_ChkKykDairitenTuusanS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkKykDairitenTuusanS> getMetaClass() {
        return QBM_ChkKykDairitenTuusanS.class;
    }

    @Id
    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenBM_ChkKykDairitenTuusanS.KIHONSSYURUIKBN)
    public C_KihonssyuruiKbn getKihonssyuruikbn() {
        return getPrimaryKey().getKihonssyuruikbn();
    }

    public void setKihonssyuruikbn(C_KihonssyuruiKbn pKihonssyuruikbn) {
        getPrimaryKey().setKihonssyuruikbn(pKihonssyuruikbn);
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
