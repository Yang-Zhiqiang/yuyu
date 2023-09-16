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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.id.PKBM_ChkHrkPTani;
import yuyu.def.db.meta.GenQBM_ChkHrkPTani;
import yuyu.def.db.meta.QBM_ChkHrkPTani;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 払込Ｐ単位チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkHrkPTani} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkHrkPTani}</td><td colspan="3">払込Ｐ単位チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkHrkPTani ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">{@link PKBM_ChkHrkPTani ○}</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkHrkPTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkHrkPTani ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_ChkHrkPTani ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">{@link PKBM_ChkHrkPTani ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrkptani hrkptani}</td><td>払込Ｐ単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkHrkPTani
 * @see     PKBM_ChkHrkPTani
 * @see     QBM_ChkHrkPTani
 * @see     GenQBM_ChkHrkPTani
 */
@MappedSuperclass
@Table(name=GenBM_ChkHrkPTani.TABLE_NAME)
@IdClass(value=PKBM_ChkHrkPTani.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_ChkHrkPTani extends AbstractExDBEntity<BM_ChkHrkPTani, PKBM_ChkHrkPTani> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkHrkPTani";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String CHANNELCD                = "channelcd";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String HRKPTANI                 = "hrkptani";

    private final PKBM_ChkHrkPTani primaryKey;

    public GenBM_ChkHrkPTani() {
        primaryKey = new PKBM_ChkHrkPTani();
    }

    public GenBM_ChkHrkPTani(
        String pSyouhncd,
        C_Hrkkaisuu pHrkkaisuu,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        C_Tuukasyu pHrktuukasyu
    ) {
        primaryKey = new PKBM_ChkHrkPTani(
            pSyouhncd,
            pHrkkaisuu,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pHrktuukasyu
        );
    }

    @Transient
    @Override
    public PKBM_ChkHrkPTani getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkHrkPTani> getMetaClass() {
        return QBM_ChkHrkPTani.class;
    }

    @Id
    @Column(name=GenBM_ChkHrkPTani.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenBM_ChkHrkPTani.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return getPrimaryKey().getHrkkaisuu();
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        getPrimaryKey().setHrkkaisuu(pHrkkaisuu);
    }

    @Id
    @Column(name=GenBM_ChkHrkPTani.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkHrkPTani.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_ChkHrkPTani.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_ChkHrkPTani.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return getPrimaryKey().getHrktuukasyu();
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        getPrimaryKey().setHrktuukasyu(pHrktuukasyu);
    }

    private BizCurrency hrkptani;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkptani() {
        return hrkptani;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkptani(BizCurrency pHrkptani) {
        hrkptani = pHrkptani;
        hrkptaniValue = null;
        hrkptaniType  = null;
    }

    transient private BigDecimal hrkptaniValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKPTANI, nullable=true)
    protected BigDecimal getHrkptaniValue() {
        if (hrkptaniValue == null && hrkptani != null) {
            if (hrkptani.isOptional()) return null;
            return hrkptani.absolute();
        }
        return hrkptaniValue;
    }

    protected void setHrkptaniValue(BigDecimal value) {
        hrkptaniValue = value;
        hrkptani = Optional.fromNullable(toCurrencyType(hrkptaniType))
            .transform(bizCurrencyTransformer(getHrkptaniValue()))
            .orNull();
    }

    transient private String hrkptaniType = null;

    @Column(name=HRKPTANI + "$", nullable=true)
    protected String getHrkptaniType() {
        if (hrkptaniType == null && hrkptani != null) return hrkptani.getType().toString();
        if (hrkptaniType == null && getHrkptaniValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkptani$' should not be NULL."));
        }
        return hrkptaniType;
    }

    protected void setHrkptaniType(String type) {
        hrkptaniType = type;
        hrkptani = Optional.fromNullable(toCurrencyType(hrkptaniType))
            .transform(bizCurrencyTransformer(getHrkptaniValue()))
            .orNull();
    }
}
