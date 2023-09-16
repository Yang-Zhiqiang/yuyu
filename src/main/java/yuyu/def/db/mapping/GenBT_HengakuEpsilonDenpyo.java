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
import yuyu.def.classification.C_CfKbn;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_HasseiKbn;
import yuyu.def.classification.C_HasseiRiyuuKbn;
import yuyu.def.classification.C_HengakuDenpyourecdKbn;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BT_HengakuEpsilonDenpyo;
import yuyu.def.db.id.PKBT_HengakuEpsilonDenpyo;
import yuyu.def.db.meta.GenQBT_HengakuEpsilonDenpyo;
import yuyu.def.db.meta.QBT_HengakuEpsilonDenpyo;
import yuyu.def.db.type.UserType_C_CfKbn;
import yuyu.def.db.type.UserType_C_DenpyouKbn;
import yuyu.def.db.type.UserType_C_HasseiKbn;
import yuyu.def.db.type.UserType_C_HasseiRiyuuKbn;
import yuyu.def.db.type.UserType_C_HengakuDenpyourecdKbn;
import yuyu.def.db.type.UserType_C_HengakuSyuruiKbn;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TkbtKanjyouUnitFundKbn;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * 変額イプシロン伝票テーブル テーブルのマッピング情報クラスで、 {@link BT_HengakuEpsilonDenpyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HengakuEpsilonDenpyo}</td><td colspan="3">変額イプシロン伝票テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHengakudenpyourecdkbn hengakudenpyourecdkbn}</td><td>変額伝票レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HengakuDenpyourecdKbn}</td></tr>
 *  <tr><td>{@link #getHengakusyuruikbn hengakusyuruikbn}</td><td>変額種類区分</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>{@link C_HengakuSyuruiKbn}</td></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getTkbtkanjyouunitfundkbn tkbtkanjyouunitfundkbn}</td><td>特別勘定ユニットファンド区分</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>{@link C_TkbtKanjyouUnitFundKbn}</td></tr>
 *  <tr><td>{@link #getKacd kacd}</td><td>課コード</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDenpyoukbn denpyoukbn}</td><td>伝票区分</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>{@link C_DenpyouKbn}</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getKamokucd kamokucd}</td><td>科目コード</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_HengakuEpsilonDenpyo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFundsyoricd fundsyoricd}</td><td>ファンド処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCfkbn cfkbn}</td><td>ＣＦ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CfKbn}</td></tr>
 *  <tr><td>{@link #getHasseiriyuukbn hasseiriyuukbn}</td><td>発生理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasseiRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getHasseikbn hasseikbn}</td><td>発生区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasseiKbn}</td></tr>
 *  <tr><td>{@link #getFundkingaku fundkingaku}</td><td>ファンド金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_HengakuEpsilonDenpyo
 * @see     PKBT_HengakuEpsilonDenpyo
 * @see     QBT_HengakuEpsilonDenpyo
 * @see     GenQBT_HengakuEpsilonDenpyo
 */
@MappedSuperclass
@Table(name=GenBT_HengakuEpsilonDenpyo.TABLE_NAME)
@IdClass(value=PKBT_HengakuEpsilonDenpyo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_CfKbn", typeClass=UserType_C_CfKbn.class),
    @TypeDef(name="UserType_C_DenpyouKbn", typeClass=UserType_C_DenpyouKbn.class),
    @TypeDef(name="UserType_C_HasseiKbn", typeClass=UserType_C_HasseiKbn.class),
    @TypeDef(name="UserType_C_HasseiRiyuuKbn", typeClass=UserType_C_HasseiRiyuuKbn.class),
    @TypeDef(name="UserType_C_HengakuDenpyourecdKbn", typeClass=UserType_C_HengakuDenpyourecdKbn.class),
    @TypeDef(name="UserType_C_HengakuSyuruiKbn", typeClass=UserType_C_HengakuSyuruiKbn.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class),
    @TypeDef(name="UserType_C_TkbtKanjyouUnitFundKbn", typeClass=UserType_C_TkbtKanjyouUnitFundKbn.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBT_HengakuEpsilonDenpyo extends AbstractExDBEntity<BT_HengakuEpsilonDenpyo, PKBT_HengakuEpsilonDenpyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_HengakuEpsilonDenpyo";
    public static final String HENGAKUDENPYOURECDKBN    = "hengakudenpyourecdkbn";
    public static final String HENGAKUSYURUIKBN         = "hengakusyuruikbn";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String TKBTKANJYOUUNITFUNDKBN   = "tkbtkanjyouunitfundkbn";
    public static final String KACD                     = "kacd";
    public static final String DENYMD                   = "denymd";
    public static final String DENPYOUKBN               = "denpyoukbn";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String KAMOKUCD                 = "kamokucd";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String FUNDSYORICD              = "fundsyoricd";
    public static final String CFKBN                    = "cfkbn";
    public static final String HASSEIRIYUUKBN           = "hasseiriyuukbn";
    public static final String HASSEIKBN                = "hasseikbn";
    public static final String FUNDKINGAKU              = "fundkingaku";

    private final PKBT_HengakuEpsilonDenpyo primaryKey;

    public GenBT_HengakuEpsilonDenpyo() {
        primaryKey = new PKBT_HengakuEpsilonDenpyo();
    }

    public GenBT_HengakuEpsilonDenpyo(
        C_HengakuSyuruiKbn pHengakusyuruikbn,
        C_UnitFundKbn pUnitfundkbn,
        C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn,
        String pKacd,
        BizDate pDenymd,
        C_DenpyouKbn pDenpyoukbn,
        C_TaisyakuKbn pTaisyakukbn,
        String pKamokucd,
        BizDate pSyoriYmd
    ) {
        primaryKey = new PKBT_HengakuEpsilonDenpyo(
            pHengakusyuruikbn,
            pUnitfundkbn,
            pTkbtkanjyouunitfundkbn,
            pKacd,
            pDenymd,
            pDenpyoukbn,
            pTaisyakukbn,
            pKamokucd,
            pSyoriYmd
        );
    }

    @Transient
    @Override
    public PKBT_HengakuEpsilonDenpyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_HengakuEpsilonDenpyo> getMetaClass() {
        return QBT_HengakuEpsilonDenpyo.class;
    }

    private C_HengakuDenpyourecdKbn hengakudenpyourecdkbn;

    @Type(type="UserType_C_HengakuDenpyourecdKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.HENGAKUDENPYOURECDKBN)
    public C_HengakuDenpyourecdKbn getHengakudenpyourecdkbn() {
        return hengakudenpyourecdkbn;
    }

    public void setHengakudenpyourecdkbn(C_HengakuDenpyourecdKbn pHengakudenpyourecdkbn) {
        hengakudenpyourecdkbn = pHengakudenpyourecdkbn;
    }

    @Id
    @Type(type="UserType_C_HengakuSyuruiKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.HENGAKUSYURUIKBN)
    public C_HengakuSyuruiKbn getHengakusyuruikbn() {
        return getPrimaryKey().getHengakusyuruikbn();
    }

    public void setHengakusyuruikbn(C_HengakuSyuruiKbn pHengakusyuruikbn) {
        getPrimaryKey().setHengakusyuruikbn(pHengakusyuruikbn);
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="UserType_C_TkbtKanjyouUnitFundKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.TKBTKANJYOUUNITFUNDKBN)
    public C_TkbtKanjyouUnitFundKbn getTkbtkanjyouunitfundkbn() {
        return getPrimaryKey().getTkbtkanjyouunitfundkbn();
    }

    public void setTkbtkanjyouunitfundkbn(C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn) {
        getPrimaryKey().setTkbtkanjyouunitfundkbn(pTkbtkanjyouunitfundkbn);
    }

    @Id
    @Column(name=GenBT_HengakuEpsilonDenpyo.KACD)
    public String getKacd() {
        return getPrimaryKey().getKacd();
    }

    public void setKacd(String pKacd) {
        getPrimaryKey().setKacd(pKacd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_HengakuEpsilonDenpyo.DENYMD)
    public BizDate getDenymd() {
        return getPrimaryKey().getDenymd();
    }

    public void setDenymd(BizDate pDenymd) {
        getPrimaryKey().setDenymd(pDenymd);
    }

    @Id
    @Type(type="UserType_C_DenpyouKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.DENPYOUKBN)
    public C_DenpyouKbn getDenpyoukbn() {
        return getPrimaryKey().getDenpyoukbn();
    }

    public void setDenpyoukbn(C_DenpyouKbn pDenpyoukbn) {
        getPrimaryKey().setDenpyoukbn(pDenpyoukbn);
    }

    @Id
    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return getPrimaryKey().getTaisyakukbn();
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        getPrimaryKey().setTaisyakukbn(pTaisyakukbn);
    }

    @Id
    @Column(name=GenBT_HengakuEpsilonDenpyo.KAMOKUCD)
    public String getKamokucd() {
        return getPrimaryKey().getKamokucd();
    }

    public void setKamokucd(String pKamokucd) {
        getPrimaryKey().setKamokucd(pKamokucd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_HengakuEpsilonDenpyo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    private String fundsyoricd;

    @Column(name=GenBT_HengakuEpsilonDenpyo.FUNDSYORICD)
    public String getFundsyoricd() {
        return fundsyoricd;
    }

    public void setFundsyoricd(String pFundsyoricd) {
        fundsyoricd = pFundsyoricd;
    }

    private C_CfKbn cfkbn;

    @Type(type="UserType_C_CfKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.CFKBN)
    public C_CfKbn getCfkbn() {
        return cfkbn;
    }

    public void setCfkbn(C_CfKbn pCfkbn) {
        cfkbn = pCfkbn;
    }

    private C_HasseiRiyuuKbn hasseiriyuukbn;

    @Type(type="UserType_C_HasseiRiyuuKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.HASSEIRIYUUKBN)
    public C_HasseiRiyuuKbn getHasseiriyuukbn() {
        return hasseiriyuukbn;
    }

    public void setHasseiriyuukbn(C_HasseiRiyuuKbn pHasseiriyuukbn) {
        hasseiriyuukbn = pHasseiriyuukbn;
    }

    private C_HasseiKbn hasseikbn;

    @Type(type="UserType_C_HasseiKbn")
    @Column(name=GenBT_HengakuEpsilonDenpyo.HASSEIKBN)
    public C_HasseiKbn getHasseikbn() {
        return hasseikbn;
    }

    public void setHasseikbn(C_HasseiKbn pHasseikbn) {
        hasseikbn = pHasseikbn;
    }

    private BizCurrency fundkingaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getFundkingaku() {
        return fundkingaku;
    }

    public void setFundkingaku(BizCurrency pFundkingaku) {
        fundkingaku = pFundkingaku;
        fundkingakuValue = null;
        fundkingakuType  = null;
    }

    transient private BigDecimal fundkingakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=FUNDKINGAKU, nullable=true)
    protected BigDecimal getFundkingakuValue() {
        if (fundkingakuValue == null && fundkingaku != null) {
            if (fundkingaku.isOptional()) return null;
            return fundkingaku.absolute();
        }
        return fundkingakuValue;
    }

    protected void setFundkingakuValue(BigDecimal value) {
        fundkingakuValue = value;
        fundkingaku = Optional.fromNullable(toCurrencyType(fundkingakuType))
            .transform(bizCurrencyTransformer(getFundkingakuValue()))
            .orNull();
    }

    transient private String fundkingakuType = null;

    @Column(name=FUNDKINGAKU + "$", nullable=true)
    protected String getFundkingakuType() {
        if (fundkingakuType == null && fundkingaku != null) return fundkingaku.getType().toString();
        if (fundkingakuType == null && getFundkingakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'fundkingaku$' should not be NULL."));
        }
        return fundkingakuType;
    }

    protected void setFundkingakuType(String type) {
        fundkingakuType = type;
        fundkingaku = Optional.fromNullable(toCurrencyType(fundkingakuType))
            .transform(bizCurrencyTransformer(getFundkingakuValue()))
            .orNull();
    }
}
