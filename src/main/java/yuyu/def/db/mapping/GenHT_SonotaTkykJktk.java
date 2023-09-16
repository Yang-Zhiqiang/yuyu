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
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_TknzkKbn;
import yuyu.def.db.entity.HT_SonotaTkykJktk;
import yuyu.def.db.id.PKHT_SonotaTkykJktk;
import yuyu.def.db.meta.GenQHT_SonotaTkykJktk;
import yuyu.def.db.meta.QHT_SonotaTkykJktk;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_TknzkKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * その他特約条件付テーブル テーブルのマッピング情報クラスで、 {@link HT_SonotaTkykJktk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SonotaTkykJktk}</td><td colspan="3">その他特約条件付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SonotaTkykJktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">{@link PKHT_SonotaTkykJktk ○}</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getTknzkkbn tknzkkbn}</td><td>特約除き区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TknzkKbn}</td></tr>
 *  <tr><td>{@link #getSeigens seigens}</td><td>制限Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SonotaTkykJktk
 * @see     PKHT_SonotaTkykJktk
 * @see     QHT_SonotaTkykJktk
 * @see     GenQHT_SonotaTkykJktk
 */
@MappedSuperclass
@Table(name=GenHT_SonotaTkykJktk.TABLE_NAME)
@IdClass(value=PKHT_SonotaTkykJktk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_TknzkKbn", typeClass=UserType_C_TknzkKbn.class)
})
public abstract class GenHT_SonotaTkykJktk extends AbstractExDBEntity<HT_SonotaTkykJktk, PKHT_SonotaTkykJktk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SonotaTkykJktk";
    public static final String MOSNO                    = "mosno";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String TKNZKKBN                 = "tknzkkbn";
    public static final String SEIGENS                  = "seigens";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SonotaTkykJktk primaryKey;

    public GenHT_SonotaTkykJktk() {
        primaryKey = new PKHT_SonotaTkykJktk();
    }

    public GenHT_SonotaTkykJktk(String pMosno, C_PmnjtkKbn pPmnjtkkbn) {
        primaryKey = new PKHT_SonotaTkykJktk(pMosno, pPmnjtkkbn);
    }

    @Transient
    @Override
    public PKHT_SonotaTkykJktk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SonotaTkykJktk> getMetaClass() {
        return QHT_SonotaTkykJktk.class;
    }

    @Id
    @Column(name=GenHT_SonotaTkykJktk.MOSNO)
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
    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenHT_SonotaTkykJktk.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return getPrimaryKey().getPmnjtkkbn();
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        getPrimaryKey().setPmnjtkkbn(pPmnjtkkbn);
    }

    private C_TknzkKbn tknzkkbn;

    @Type(type="UserType_C_TknzkKbn")
    @Column(name=GenHT_SonotaTkykJktk.TKNZKKBN)
    public C_TknzkKbn getTknzkkbn() {
        return tknzkkbn;
    }

    public void setTknzkkbn(C_TknzkKbn pTknzkkbn) {
        tknzkkbn = pTknzkkbn;
    }

    private BizCurrency seigens;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeigens() {
        return seigens;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeigens(BizCurrency pSeigens) {
        seigens = pSeigens;
        seigensValue = null;
        seigensType  = null;
    }

    transient private BigDecimal seigensValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEIGENS, nullable=true)
    protected BigDecimal getSeigensValue() {
        if (seigensValue == null && seigens != null) {
            if (seigens.isOptional()) return null;
            return seigens.absolute();
        }
        return seigensValue;
    }

    protected void setSeigensValue(BigDecimal value) {
        seigensValue = value;
        seigens = Optional.fromNullable(toCurrencyType(seigensType))
            .transform(bizCurrencyTransformer(getSeigensValue()))
            .orNull();
    }

    transient private String seigensType = null;

    @Column(name=SEIGENS + "$", nullable=true)
    protected String getSeigensType() {
        if (seigensType == null && seigens != null) return seigens.getType().toString();
        if (seigensType == null && getSeigensValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seigens$' should not be NULL."));
        }
        return seigensType;
    }

    protected void setSeigensType(String type) {
        seigensType = type;
        seigens = Optional.fromNullable(toCurrencyType(seigensType))
            .transform(bizCurrencyTransformer(getSeigensValue()))
            .orNull();
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SonotaTkykJktk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SonotaTkykJktk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}