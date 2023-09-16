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
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;
import yuyu.def.db.id.PKBM_ChkNenkinSaiteiS;
import yuyu.def.db.meta.GenQBM_ChkNenkinSaiteiS;
import yuyu.def.db.meta.QBM_ChkNenkinSaiteiS;

/**
 * 年金支払特約最低Ｓチェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkNenkinSaiteiS} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenkinSaiteiS}</td><td colspan="3">年金支払特約最低Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNenkinkkn nenkinkkn}</td><td>年金期間</td><td align="center">{@link PKBM_ChkNenkinSaiteiS ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNenkinsyu nenkinsyu}</td><td>年金種類</td><td align="center">{@link PKBM_ChkNenkinSaiteiS ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaiteis saiteis}</td><td>最低Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkNenkinSaiteiS
 * @see     PKBM_ChkNenkinSaiteiS
 * @see     QBM_ChkNenkinSaiteiS
 * @see     GenQBM_ChkNenkinSaiteiS
 */
@MappedSuperclass
@Table(name=GenBM_ChkNenkinSaiteiS.TABLE_NAME)
@IdClass(value=PKBM_ChkNenkinSaiteiS.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class)
})
public abstract class GenBM_ChkNenkinSaiteiS extends AbstractExDBEntity<BM_ChkNenkinSaiteiS, PKBM_ChkNenkinSaiteiS> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkNenkinSaiteiS";
    public static final String NENKINKKN                = "nenkinkkn";
    public static final String NENKINSYU                = "nenkinsyu";
    public static final String SAITEIS                  = "saiteis";

    private final PKBM_ChkNenkinSaiteiS primaryKey;

    public GenBM_ChkNenkinSaiteiS() {
        primaryKey = new PKBM_ChkNenkinSaiteiS();
    }

    public GenBM_ChkNenkinSaiteiS(Integer pNenkinkkn, String pNenkinsyu) {
        primaryKey = new PKBM_ChkNenkinSaiteiS(pNenkinkkn, pNenkinsyu);
    }

    @Transient
    @Override
    public PKBM_ChkNenkinSaiteiS getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkNenkinSaiteiS> getMetaClass() {
        return QBM_ChkNenkinSaiteiS.class;
    }

    @Id
    @Column(name=GenBM_ChkNenkinSaiteiS.NENKINKKN)
    public Integer getNenkinkkn() {
        return getPrimaryKey().getNenkinkkn();
    }

    public void setNenkinkkn(Integer pNenkinkkn) {
        getPrimaryKey().setNenkinkkn(pNenkinkkn);
    }

    @Id
    @Column(name=GenBM_ChkNenkinSaiteiS.NENKINSYU)
    public String getNenkinsyu() {
        return getPrimaryKey().getNenkinsyu();
    }

    public void setNenkinsyu(String pNenkinsyu) {
        getPrimaryKey().setNenkinsyu(pNenkinsyu);
    }

    private BizCurrency saiteis;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSaiteis() {
        return saiteis;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaiteis(BizCurrency pSaiteis) {
        saiteis = pSaiteis;
        saiteisValue = null;
        saiteisType  = null;
    }

    transient private BigDecimal saiteisValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SAITEIS, nullable=true)
    protected BigDecimal getSaiteisValue() {
        if (saiteisValue == null && saiteis != null) {
            if (saiteis.isOptional()) return null;
            return saiteis.absolute();
        }
        return saiteisValue;
    }

    protected void setSaiteisValue(BigDecimal value) {
        saiteisValue = value;
        saiteis = Optional.fromNullable(toCurrencyType(saiteisType))
            .transform(bizCurrencyTransformer(getSaiteisValue()))
            .orNull();
    }

    transient private String saiteisType = null;

    @Column(name=SAITEIS + "$", nullable=true)
    protected String getSaiteisType() {
        if (saiteisType == null && saiteis != null) return saiteis.getType().toString();
        if (saiteisType == null && getSaiteisValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'saiteis$' should not be NULL."));
        }
        return saiteisType;
    }

    protected void setSaiteisType(String type) {
        saiteisType = type;
        saiteis = Optional.fromNullable(toCurrencyType(saiteisType))
            .transform(bizCurrencyTransformer(getSaiteisValue()))
            .orNull();
    }
}
