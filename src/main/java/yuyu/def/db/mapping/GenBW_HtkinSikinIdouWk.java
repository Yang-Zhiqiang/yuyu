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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BW_HtkinSikinIdouWk;
import yuyu.def.db.id.PKBW_HtkinSikinIdouWk;
import yuyu.def.db.meta.GenQBW_HtkinSikinIdouWk;
import yuyu.def.db.meta.QBW_HtkinSikinIdouWk;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当金資金移動ワークテーブル テーブルのマッピング情報クラスで、 {@link BW_HtkinSikinIdouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_HtkinSikinIdouWk}</td><td colspan="3">配当金資金移動ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBW_HtkinSikinIdouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKijyunymd kijyunymd}</td><td>基準年月日</td><td align="center">{@link PKBW_HtkinSikinIdouWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSeisikiwariategaku seisikiwariategaku}</td><td>正式割当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSikinidoukawaserate sikinidoukawaserate}</td><td>資金移動用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BW_HtkinSikinIdouWk
 * @see     PKBW_HtkinSikinIdouWk
 * @see     QBW_HtkinSikinIdouWk
 * @see     GenQBW_HtkinSikinIdouWk
 */
@MappedSuperclass
@Table(name=GenBW_HtkinSikinIdouWk.TABLE_NAME)
@IdClass(value=PKBW_HtkinSikinIdouWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBW_HtkinSikinIdouWk extends AbstractExDBEntity<BW_HtkinSikinIdouWk, PKBW_HtkinSikinIdouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BW_HtkinSikinIdouWk";
    public static final String SYONO                    = "syono";
    public static final String KIJYUNYMD                = "kijyunymd";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SEISIKIWARIATEGAKU       = "seisikiwariategaku";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SIKINIDOUKAWASERATE      = "sikinidoukawaserate";

    private final PKBW_HtkinSikinIdouWk primaryKey;

    public GenBW_HtkinSikinIdouWk() {
        primaryKey = new PKBW_HtkinSikinIdouWk();
    }

    public GenBW_HtkinSikinIdouWk(String pSyono, BizDate pKijyunymd) {
        primaryKey = new PKBW_HtkinSikinIdouWk(pSyono, pKijyunymd);
    }

    @Transient
    @Override
    public PKBW_HtkinSikinIdouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBW_HtkinSikinIdouWk> getMetaClass() {
        return QBW_HtkinSikinIdouWk.class;
    }

    @Id
    @Column(name=GenBW_HtkinSikinIdouWk.SYONO)
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
    @Column(name=GenBW_HtkinSikinIdouWk.KIJYUNYMD)
    public BizDate getKijyunymd() {
        return getPrimaryKey().getKijyunymd();
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        getPrimaryKey().setKijyunymd(pKijyunymd);
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenBW_HtkinSikinIdouWk.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBW_HtkinSikinIdouWk.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency seisikiwariategaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeisikiwariategaku() {
        return seisikiwariategaku;
    }

    public void setSeisikiwariategaku(BizCurrency pSeisikiwariategaku) {
        seisikiwariategaku = pSeisikiwariategaku;
        seisikiwariategakuValue = null;
        seisikiwariategakuType  = null;
    }

    transient private BigDecimal seisikiwariategakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEISIKIWARIATEGAKU, nullable=true)
    protected BigDecimal getSeisikiwariategakuValue() {
        if (seisikiwariategakuValue == null && seisikiwariategaku != null) {
            if (seisikiwariategaku.isOptional()) return null;
            return seisikiwariategaku.absolute();
        }
        return seisikiwariategakuValue;
    }

    protected void setSeisikiwariategakuValue(BigDecimal value) {
        seisikiwariategakuValue = value;
        seisikiwariategaku = Optional.fromNullable(toCurrencyType(seisikiwariategakuType))
            .transform(bizCurrencyTransformer(getSeisikiwariategakuValue()))
            .orNull();
    }

    transient private String seisikiwariategakuType = null;

    @Column(name=SEISIKIWARIATEGAKU + "$", nullable=true)
    protected String getSeisikiwariategakuType() {
        if (seisikiwariategakuType == null && seisikiwariategaku != null) return seisikiwariategaku.getType().toString();
        if (seisikiwariategakuType == null && getSeisikiwariategakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seisikiwariategaku$' should not be NULL."));
        }
        return seisikiwariategakuType;
    }

    protected void setSeisikiwariategakuType(String type) {
        seisikiwariategakuType = type;
        seisikiwariategaku = Optional.fromNullable(toCurrencyType(seisikiwariategakuType))
            .transform(bizCurrencyTransformer(getSeisikiwariategakuValue()))
            .orNull();
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBW_HtkinSikinIdouWk.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private BizNumber sikinidoukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenBW_HtkinSikinIdouWk.SIKINIDOUKAWASERATE)
    public BizNumber getSikinidoukawaserate() {
        return sikinidoukawaserate;
    }

    public void setSikinidoukawaserate(BizNumber pSikinidoukawaserate) {
        sikinidoukawaserate = pSikinidoukawaserate;
    }
}