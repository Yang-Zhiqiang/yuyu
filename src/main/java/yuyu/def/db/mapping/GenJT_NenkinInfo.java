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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.id.PKJT_NenkinInfo;
import yuyu.def.db.meta.GenQJT_NenkinInfo;
import yuyu.def.db.meta.QJT_NenkinInfo;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_NkHaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 年金情報テーブル テーブルのマッピング情報クラスで、 {@link JT_NenkinInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_NenkinInfo}</td><td colspan="3">年金情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_NenkinInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_NenkinInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_NenkinInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkkknsetymd nkkknsetymd}</td><td>年金基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukbn nkshrtkyknksyukbn}</td><td>年金支払特約年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukkn nkshrtkyknksyukkn}</td><td>年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBnshrkaisuu bnshrkaisuu}</td><td>分割支払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Bnshrkaisuu}</td></tr>
 *  <tr><td>{@link #getNkhaitoukinuketorihoukbn nkhaitoukinuketorihoukbn}</td><td>年金配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkHaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getTeinkkikingkgaika teinkkikingkgaika}</td><td>定額年金年金基金額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeinkkikingken teinkkikingken}</td><td>定額年金年金基金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHtykeihi htykeihi}</td><td>必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhtykeihi yenhtykeihi}</td><td>円換算必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNknengk nknengk}</td><td>年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBnktnkgk bnktnkgk}</td><td>分割年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_NenkinInfo
 * @see     PKJT_NenkinInfo
 * @see     QJT_NenkinInfo
 * @see     GenQJT_NenkinInfo
 */
@MappedSuperclass
@Table(name=GenJT_NenkinInfo.TABLE_NAME)
@IdClass(value=PKJT_NenkinInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Bnshrkaisuu", typeClass=UserType_C_Bnshrkaisuu.class),
    @TypeDef(name="UserType_C_NkHaitoukinuketorihouKbn", typeClass=UserType_C_NkHaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class)
})
public abstract class GenJT_NenkinInfo extends AbstractExDBEntity<JT_NenkinInfo, PKJT_NenkinInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_NenkinInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String NKKKNSETYMD              = "nkkknsetymd";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String NKSHRTKYKNKSYUKBN        = "nkshrtkyknksyukbn";
    public static final String NKSHRTKYKNKSYUKKN        = "nkshrtkyknksyukkn";
    public static final String BNSHRKAISUU              = "bnshrkaisuu";
    public static final String NKHAITOUKINUKETORIHOUKBN = "nkhaitoukinuketorihoukbn";
    public static final String TEINKKIKINGKGAIKA        = "teinkkikingkgaika";
    public static final String TEINKKIKINGKEN           = "teinkkikingken";
    public static final String HTYKEIHI                 = "htykeihi";
    public static final String YENHTYKEIHI              = "yenhtykeihi";
    public static final String NKNENGK                  = "nknengk";
    public static final String BNKTNKGK                 = "bnktnkgk";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_NenkinInfo primaryKey;

    public GenJT_NenkinInfo() {
        primaryKey = new PKJT_NenkinInfo();
    }

    public GenJT_NenkinInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_NenkinInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_NenkinInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_NenkinInfo> getMetaClass() {
        return QJT_NenkinInfo.class;
    }

    @Id
    @Column(name=GenJT_NenkinInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_NenkinInfo.SYONO)
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
    @Column(name=GenJT_NenkinInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private BizDate nkkknsetymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_NenkinInfo.NKKKNSETYMD)
    @ValidDate
    public BizDate getNkkknsetymd() {
        return nkkknsetymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkkknsetymd(BizDate pNkkknsetymd) {
        nkkknsetymd = pNkkknsetymd;
    }

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_NenkinInfo.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private C_Nstknsyu nkshrtkyknksyukbn;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenJT_NenkinInfo.NKSHRTKYKNKSYUKBN)
    public C_Nstknsyu getNkshrtkyknksyukbn() {
        return nkshrtkyknksyukbn;
    }

    public void setNkshrtkyknksyukbn(C_Nstknsyu pNkshrtkyknksyukbn) {
        nkshrtkyknksyukbn = pNkshrtkyknksyukbn;
    }

    private Integer nkshrtkyknksyukkn;

    @Column(name=GenJT_NenkinInfo.NKSHRTKYKNKSYUKKN)
    @Range(min="0", max="99")
    public Integer getNkshrtkyknksyukkn() {
        return nkshrtkyknksyukkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkshrtkyknksyukkn(Integer pNkshrtkyknksyukkn) {
        nkshrtkyknksyukkn = pNkshrtkyknksyukkn;
    }

    private C_Bnshrkaisuu bnshrkaisuu;

    @Type(type="UserType_C_Bnshrkaisuu")
    @Column(name=GenJT_NenkinInfo.BNSHRKAISUU)
    public C_Bnshrkaisuu getBnshrkaisuu() {
        return bnshrkaisuu;
    }

    public void setBnshrkaisuu(C_Bnshrkaisuu pBnshrkaisuu) {
        bnshrkaisuu = pBnshrkaisuu;
    }

    private C_NkHaitoukinuketorihouKbn nkhaitoukinuketorihoukbn;

    @Type(type="UserType_C_NkHaitoukinuketorihouKbn")
    @Column(name=GenJT_NenkinInfo.NKHAITOUKINUKETORIHOUKBN)
    public C_NkHaitoukinuketorihouKbn getNkhaitoukinuketorihoukbn() {
        return nkhaitoukinuketorihoukbn;
    }

    public void setNkhaitoukinuketorihoukbn(C_NkHaitoukinuketorihouKbn pNkhaitoukinuketorihoukbn) {
        nkhaitoukinuketorihoukbn = pNkhaitoukinuketorihoukbn;
    }

    private BizCurrency teinkkikingkgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeinkkikingkgaika() {
        return teinkkikingkgaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeinkkikingkgaika(BizCurrency pTeinkkikingkgaika) {
        teinkkikingkgaika = pTeinkkikingkgaika;
        teinkkikingkgaikaValue = null;
        teinkkikingkgaikaType  = null;
    }

    transient private BigDecimal teinkkikingkgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEINKKIKINGKGAIKA, nullable=true)
    protected BigDecimal getTeinkkikingkgaikaValue() {
        if (teinkkikingkgaikaValue == null && teinkkikingkgaika != null) {
            if (teinkkikingkgaika.isOptional()) return null;
            return teinkkikingkgaika.absolute();
        }
        return teinkkikingkgaikaValue;
    }

    protected void setTeinkkikingkgaikaValue(BigDecimal value) {
        teinkkikingkgaikaValue = value;
        teinkkikingkgaika = Optional.fromNullable(toCurrencyType(teinkkikingkgaikaType))
            .transform(bizCurrencyTransformer(getTeinkkikingkgaikaValue()))
            .orNull();
    }

    transient private String teinkkikingkgaikaType = null;

    @Column(name=TEINKKIKINGKGAIKA + "$", nullable=true)
    protected String getTeinkkikingkgaikaType() {
        if (teinkkikingkgaikaType == null && teinkkikingkgaika != null) return teinkkikingkgaika.getType().toString();
        if (teinkkikingkgaikaType == null && getTeinkkikingkgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teinkkikingkgaika$' should not be NULL."));
        }
        return teinkkikingkgaikaType;
    }

    protected void setTeinkkikingkgaikaType(String type) {
        teinkkikingkgaikaType = type;
        teinkkikingkgaika = Optional.fromNullable(toCurrencyType(teinkkikingkgaikaType))
            .transform(bizCurrencyTransformer(getTeinkkikingkgaikaValue()))
            .orNull();
    }

    private BizCurrency teinkkikingken;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeinkkikingken() {
        return teinkkikingken;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeinkkikingken(BizCurrency pTeinkkikingken) {
        teinkkikingken = pTeinkkikingken;
        teinkkikingkenValue = null;
        teinkkikingkenType  = null;
    }

    transient private BigDecimal teinkkikingkenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEINKKIKINGKEN, nullable=true)
    protected BigDecimal getTeinkkikingkenValue() {
        if (teinkkikingkenValue == null && teinkkikingken != null) {
            if (teinkkikingken.isOptional()) return null;
            return teinkkikingken.absolute();
        }
        return teinkkikingkenValue;
    }

    protected void setTeinkkikingkenValue(BigDecimal value) {
        teinkkikingkenValue = value;
        teinkkikingken = Optional.fromNullable(toCurrencyType(teinkkikingkenType))
            .transform(bizCurrencyTransformer(getTeinkkikingkenValue()))
            .orNull();
    }

    transient private String teinkkikingkenType = null;

    @Column(name=TEINKKIKINGKEN + "$", nullable=true)
    protected String getTeinkkikingkenType() {
        if (teinkkikingkenType == null && teinkkikingken != null) return teinkkikingken.getType().toString();
        if (teinkkikingkenType == null && getTeinkkikingkenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teinkkikingken$' should not be NULL."));
        }
        return teinkkikingkenType;
    }

    protected void setTeinkkikingkenType(String type) {
        teinkkikingkenType = type;
        teinkkikingken = Optional.fromNullable(toCurrencyType(teinkkikingkenType))
            .transform(bizCurrencyTransformer(getTeinkkikingkenValue()))
            .orNull();
    }

    private BizCurrency htykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
        htykeihiValue = null;
        htykeihiType  = null;
    }

    transient private BigDecimal htykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HTYKEIHI, nullable=true)
    protected BigDecimal getHtykeihiValue() {
        if (htykeihiValue == null && htykeihi != null) {
            if (htykeihi.isOptional()) return null;
            return htykeihi.absolute();
        }
        return htykeihiValue;
    }

    protected void setHtykeihiValue(BigDecimal value) {
        htykeihiValue = value;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    transient private String htykeihiType = null;

    @Column(name=HTYKEIHI + "$", nullable=true)
    protected String getHtykeihiType() {
        if (htykeihiType == null && htykeihi != null) return htykeihi.getType().toString();
        if (htykeihiType == null && getHtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'htykeihi$' should not be NULL."));
        }
        return htykeihiType;
    }

    protected void setHtykeihiType(String type) {
        htykeihiType = type;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    private BizCurrency yenhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenhtykeihi() {
        return yenhtykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhtykeihi(BizCurrency pYenhtykeihi) {
        yenhtykeihi = pYenhtykeihi;
        yenhtykeihiValue = null;
        yenhtykeihiType  = null;
    }

    transient private BigDecimal yenhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENHTYKEIHI, nullable=true)
    protected BigDecimal getYenhtykeihiValue() {
        if (yenhtykeihiValue == null && yenhtykeihi != null) {
            if (yenhtykeihi.isOptional()) return null;
            return yenhtykeihi.absolute();
        }
        return yenhtykeihiValue;
    }

    protected void setYenhtykeihiValue(BigDecimal value) {
        yenhtykeihiValue = value;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    transient private String yenhtykeihiType = null;

    @Column(name=YENHTYKEIHI + "$", nullable=true)
    protected String getYenhtykeihiType() {
        if (yenhtykeihiType == null && yenhtykeihi != null) return yenhtykeihi.getType().toString();
        if (yenhtykeihiType == null && getYenhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenhtykeihi$' should not be NULL."));
        }
        return yenhtykeihiType;
    }

    protected void setYenhtykeihiType(String type) {
        yenhtykeihiType = type;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    private BizCurrency nknengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNknengk() {
        return nknengk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNknengk(BizCurrency pNknengk) {
        nknengk = pNknengk;
        nknengkValue = null;
        nknengkType  = null;
    }

    transient private BigDecimal nknengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NKNENGK, nullable=true)
    protected BigDecimal getNknengkValue() {
        if (nknengkValue == null && nknengk != null) {
            if (nknengk.isOptional()) return null;
            return nknengk.absolute();
        }
        return nknengkValue;
    }

    protected void setNknengkValue(BigDecimal value) {
        nknengkValue = value;
        nknengk = Optional.fromNullable(toCurrencyType(nknengkType))
            .transform(bizCurrencyTransformer(getNknengkValue()))
            .orNull();
    }

    transient private String nknengkType = null;

    @Column(name=NKNENGK + "$", nullable=true)
    protected String getNknengkType() {
        if (nknengkType == null && nknengk != null) return nknengk.getType().toString();
        if (nknengkType == null && getNknengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nknengk$' should not be NULL."));
        }
        return nknengkType;
    }

    protected void setNknengkType(String type) {
        nknengkType = type;
        nknengk = Optional.fromNullable(toCurrencyType(nknengkType))
            .transform(bizCurrencyTransformer(getNknengkValue()))
            .orNull();
    }

    private BizCurrency bnktnkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getBnktnkgk() {
        return bnktnkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBnktnkgk(BizCurrency pBnktnkgk) {
        bnktnkgk = pBnktnkgk;
        bnktnkgkValue = null;
        bnktnkgkType  = null;
    }

    transient private BigDecimal bnktnkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=BNKTNKGK, nullable=true)
    protected BigDecimal getBnktnkgkValue() {
        if (bnktnkgkValue == null && bnktnkgk != null) {
            if (bnktnkgk.isOptional()) return null;
            return bnktnkgk.absolute();
        }
        return bnktnkgkValue;
    }

    protected void setBnktnkgkValue(BigDecimal value) {
        bnktnkgkValue = value;
        bnktnkgk = Optional.fromNullable(toCurrencyType(bnktnkgkType))
            .transform(bizCurrencyTransformer(getBnktnkgkValue()))
            .orNull();
    }

    transient private String bnktnkgkType = null;

    @Column(name=BNKTNKGK + "$", nullable=true)
    protected String getBnktnkgkType() {
        if (bnktnkgkType == null && bnktnkgk != null) return bnktnkgk.getType().toString();
        if (bnktnkgkType == null && getBnktnkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'bnktnkgk$' should not be NULL."));
        }
        return bnktnkgkType;
    }

    protected void setBnktnkgkType(String type) {
        bnktnkgkType = type;
        bnktnkgk = Optional.fromNullable(toCurrencyType(bnktnkgkType))
            .transform(bizCurrencyTransformer(getBnktnkgkValue()))
            .orNull();
    }

    private String kossyoricd;

    @Column(name=GenJT_NenkinInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_NenkinInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_NenkinInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_NenkinInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}