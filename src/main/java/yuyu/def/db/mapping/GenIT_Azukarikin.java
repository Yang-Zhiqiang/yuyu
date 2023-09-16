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
import yuyu.def.classification.C_AzukarikinsyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.id.PKIT_Azukarikin;
import yuyu.def.db.meta.GenQIT_Azukarikin;
import yuyu.def.db.meta.QIT_Azukarikin;
import yuyu.def.db.type.UserType_C_AzukarikinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 預り金テーブル テーブルのマッピング情報クラスで、 {@link IT_Azukarikin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_Azukarikin}</td><td colspan="3">預り金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_Azukarikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_Azukarikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_Azukarikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKIT_Azukarikin ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getAzukarikinsyuruikbn azukarikinsyuruikbn}</td><td>預り金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AzukarikinsyuruiKbn}</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAzukarikinhsiymd azukarikinhsiymd}</td><td>預り金発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAzukarikingk azukarikingk}</td><td>預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_Azukarikin
 * @see     PKIT_Azukarikin
 * @see     QIT_Azukarikin
 * @see     GenQIT_Azukarikin
 */
@MappedSuperclass
@Table(name=GenIT_Azukarikin.TABLE_NAME)
@IdClass(value=PKIT_Azukarikin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AzukarikinsyuruiKbn", typeClass=UserType_C_AzukarikinsyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIT_Azukarikin extends AbstractExDBEntity<IT_Azukarikin, PKIT_Azukarikin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_Azukarikin";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String AZUKARIKINSYURUIKBN      = "azukarikinsyuruikbn";
    public static final String SHRYMD                   = "shrymd";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String AZUKARIKINHSIYMD         = "azukarikinhsiymd";
    public static final String AZUKARIKINGK             = "azukarikingk";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_Azukarikin primaryKey;

    public GenIT_Azukarikin() {
        primaryKey = new PKIT_Azukarikin();
    }

    public GenIT_Azukarikin(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        C_Tuukasyu pTuukasyu
    ) {
        primaryKey = new PKIT_Azukarikin(
            pKbnkey,
            pSyono,
            pHenkousikibetukey,
            pTuukasyu
        );
    }

    @Transient
    @Override
    public PKIT_Azukarikin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_Azukarikin> getMetaClass() {
        return QIT_Azukarikin.class;
    }

    @Id
    @Column(name=GenIT_Azukarikin.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_Azukarikin.SYONO)
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
    @Column(name=GenIT_Azukarikin.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_Azukarikin.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    private C_AzukarikinsyuruiKbn azukarikinsyuruikbn;

    @Type(type="UserType_C_AzukarikinsyuruiKbn")
    @Column(name=GenIT_Azukarikin.AZUKARIKINSYURUIKBN)
    public C_AzukarikinsyuruiKbn getAzukarikinsyuruikbn() {
        return azukarikinsyuruikbn;
    }

    public void setAzukarikinsyuruikbn(C_AzukarikinsyuruiKbn pAzukarikinsyuruikbn) {
        azukarikinsyuruikbn = pAzukarikinsyuruikbn;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Azukarikin.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Azukarikin.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate azukarikinhsiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Azukarikin.AZUKARIKINHSIYMD)
    public BizDate getAzukarikinhsiymd() {
        return azukarikinhsiymd;
    }

    public void setAzukarikinhsiymd(BizDate pAzukarikinhsiymd) {
        azukarikinhsiymd = pAzukarikinhsiymd;
    }

    private BizCurrency azukarikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
        azukarikingkValue = null;
        azukarikingkType  = null;
    }

    transient private BigDecimal azukarikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINGK, nullable=true)
    protected BigDecimal getAzukarikingkValue() {
        if (azukarikingkValue == null && azukarikingk != null) {
            if (azukarikingk.isOptional()) return null;
            return azukarikingk.absolute();
        }
        return azukarikingkValue;
    }

    protected void setAzukarikingkValue(BigDecimal value) {
        azukarikingkValue = value;
        azukarikingk = Optional.fromNullable(toCurrencyType(azukarikingkType))
            .transform(bizCurrencyTransformer(getAzukarikingkValue()))
            .orNull();
    }

    transient private String azukarikingkType = null;

    @Column(name=AZUKARIKINGK + "$", nullable=true)
    protected String getAzukarikingkType() {
        if (azukarikingkType == null && azukarikingk != null) return azukarikingk.getType().toString();
        if (azukarikingkType == null && getAzukarikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikingk$' should not be NULL."));
        }
        return azukarikingkType;
    }

    protected void setAzukarikingkType(String type) {
        azukarikingkType = type;
        azukarikingk = Optional.fromNullable(toCurrencyType(azukarikingkType))
            .transform(bizCurrencyTransformer(getAzukarikingkValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_Azukarikin.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_Azukarikin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_Azukarikin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}