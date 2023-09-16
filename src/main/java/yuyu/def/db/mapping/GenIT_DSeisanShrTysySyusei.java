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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;
import yuyu.def.db.id.PKIT_DSeisanShrTysySyusei;
import yuyu.def.db.meta.GenQIT_DSeisanShrTysySyusei;
import yuyu.def.db.meta.QIT_DSeisanShrTysySyusei;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * Ｄ精算支払調書修正テーブル テーブルのマッピング情報クラスで、 {@link IT_DSeisanShrTysySyusei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DSeisanShrTysySyusei}</td><td colspan="3">Ｄ精算支払調書修正テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_DSeisanShrTysySyusei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_DSeisanShrTysySyusei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_DSeisanShrTysySyusei ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisandshrymd seisandshrymd}</td><td>精算Ｄ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisand seisand}</td><td>精算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTyouseid tyouseid}</td><td>調整Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DSeisanShrTysySyusei
 * @see     PKIT_DSeisanShrTysySyusei
 * @see     QIT_DSeisanShrTysySyusei
 * @see     GenQIT_DSeisanShrTysySyusei
 */
@MappedSuperclass
@Table(name=GenIT_DSeisanShrTysySyusei.TABLE_NAME)
@IdClass(value=PKIT_DSeisanShrTysySyusei.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenIT_DSeisanShrTysySyusei extends AbstractExDBEntity<IT_DSeisanShrTysySyusei, PKIT_DSeisanShrTysySyusei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_DSeisanShrTysySyusei";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SEISANDSHRYMD            = "seisandshrymd";
    public static final String SEISAND                  = "seisand";
    public static final String TYOUSEID                 = "tyouseid";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_DSeisanShrTysySyusei primaryKey;

    public GenIT_DSeisanShrTysySyusei() {
        primaryKey = new PKIT_DSeisanShrTysySyusei();
    }

    public GenIT_DSeisanShrTysySyusei(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd
    ) {
        primaryKey = new PKIT_DSeisanShrTysySyusei(
            pKbnkey,
            pSyono,
            pSyoriYmd
        );
    }

    @Transient
    @Override
    public PKIT_DSeisanShrTysySyusei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_DSeisanShrTysySyusei> getMetaClass() {
        return QIT_DSeisanShrTysySyusei.class;
    }

    @Id
    @Column(name=GenIT_DSeisanShrTysySyusei.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_DSeisanShrTysySyusei.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanShrTysySyusei.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    private BizDate seisandshrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanShrTysySyusei.SEISANDSHRYMD)
    public BizDate getSeisandshrymd() {
        return seisandshrymd;
    }

    public void setSeisandshrymd(BizDate pSeisandshrymd) {
        seisandshrymd = pSeisandshrymd;
    }

    private BizCurrency seisand;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeisand() {
        return seisand;
    }

    public void setSeisand(BizCurrency pSeisand) {
        seisand = pSeisand;
        seisandValue = null;
        seisandType  = null;
    }

    transient private BigDecimal seisandValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEISAND, nullable=true)
    protected BigDecimal getSeisandValue() {
        if (seisandValue == null && seisand != null) {
            if (seisand.isOptional()) return null;
            return seisand.absolute();
        }
        return seisandValue;
    }

    protected void setSeisandValue(BigDecimal value) {
        seisandValue = value;
        seisand = Optional.fromNullable(toCurrencyType(seisandType))
            .transform(bizCurrencyTransformer(getSeisandValue()))
            .orNull();
    }

    transient private String seisandType = null;

    @Column(name=SEISAND + "$", nullable=true)
    protected String getSeisandType() {
        if (seisandType == null && seisand != null) return seisand.getType().toString();
        if (seisandType == null && getSeisandValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seisand$' should not be NULL."));
        }
        return seisandType;
    }

    protected void setSeisandType(String type) {
        seisandType = type;
        seisand = Optional.fromNullable(toCurrencyType(seisandType))
            .transform(bizCurrencyTransformer(getSeisandValue()))
            .orNull();
    }

    private BizCurrency tyouseid;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTyouseid() {
        return tyouseid;
    }

    public void setTyouseid(BizCurrency pTyouseid) {
        tyouseid = pTyouseid;
        tyouseidValue = null;
        tyouseidType  = null;
    }

    transient private BigDecimal tyouseidValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TYOUSEID, nullable=true)
    protected BigDecimal getTyouseidValue() {
        if (tyouseidValue == null && tyouseid != null) {
            if (tyouseid.isOptional()) return null;
            return tyouseid.absolute();
        }
        return tyouseidValue;
    }

    protected void setTyouseidValue(BigDecimal value) {
        tyouseidValue = value;
        tyouseid = Optional.fromNullable(toCurrencyType(tyouseidType))
            .transform(bizCurrencyTransformer(getTyouseidValue()))
            .orNull();
    }

    transient private String tyouseidType = null;

    @Column(name=TYOUSEID + "$", nullable=true)
    protected String getTyouseidType() {
        if (tyouseidType == null && tyouseid != null) return tyouseid.getType().toString();
        if (tyouseidType == null && getTyouseidValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tyouseid$' should not be NULL."));
        }
        return tyouseidType;
    }

    protected void setTyouseidType(String type) {
        tyouseidType = type;
        tyouseid = Optional.fromNullable(toCurrencyType(tyouseidType))
            .transform(bizCurrencyTransformer(getTyouseidValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_DSeisanShrTysySyusei.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_DSeisanShrTysySyusei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_DSeisanShrTysySyusei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}