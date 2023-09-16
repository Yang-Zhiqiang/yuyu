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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HrkeAnnaiJkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KzkpannaijiyuuKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_BAK_HrkeIraiInfo;
import yuyu.def.db.id.PKIT_BAK_HrkeIraiInfo;
import yuyu.def.db.meta.GenQIT_BAK_HrkeIraiInfo;
import yuyu.def.db.meta.QIT_BAK_HrkeIraiInfo;
import yuyu.def.db.type.UserType_C_HrkeAnnaiJkKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KzkpannaijiyuuKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 振替依頼情報バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_HrkeIraiInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_HrkeIraiInfo}</td><td colspan="3">振替依頼情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_HrkeIraiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_HrkeIraiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_HrkeIraiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_HrkeIraiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkeannaijkkbn hrkeannaijkkbn}</td><td>振替案内状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkeAnnaiJkKbn}</td></tr>
 *  <tr><td>{@link #getHrkeyousiymd hrkeyousiymd}</td><td>振替用紙作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTorikesiymd torikesiymd}</td><td>取消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getHrkkigen hrkkigen}</td><td>払込期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkiraikngk hrkiraikngk}</td><td>払込依頼金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKzkpannaijiyuukbn kzkpannaijiyuukbn}</td><td>継続Ｐ案内事由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkpannaijiyuuKbn}</td></tr>
 *  <tr><td>{@link #getComment124keta comment124keta}</td><td>コメント（１２４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_HrkeIraiInfo
 * @see     PKIT_BAK_HrkeIraiInfo
 * @see     QIT_BAK_HrkeIraiInfo
 * @see     GenQIT_BAK_HrkeIraiInfo
 */
@MappedSuperclass
@Table(name=GenIT_BAK_HrkeIraiInfo.TABLE_NAME)
@IdClass(value=PKIT_BAK_HrkeIraiInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_HrkeAnnaiJkKbn", typeClass=UserType_C_HrkeAnnaiJkKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_KzkpannaijiyuuKbn", typeClass=UserType_C_KzkpannaijiyuuKbn.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class)
})
public abstract class GenIT_BAK_HrkeIraiInfo extends AbstractExDBEntity<IT_BAK_HrkeIraiInfo, PKIT_BAK_HrkeIraiInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_HrkeIraiInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String HRKEANNAIJKKBN           = "hrkeannaijkkbn";
    public static final String HRKEYOUSIYMD             = "hrkeyousiymd";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String RSGAKU                   = "rsgaku";
    public static final String TORIKESIYMD              = "torikesiymd";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String HRKKIGEN                 = "hrkkigen";
    public static final String HRKIRAIKNGK              = "hrkiraikngk";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String KZKPANNAIJIYUUKBN        = "kzkpannaijiyuukbn";
    public static final String COMMENT124KETA           = "comment124keta";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKP                     = "hrkp";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_HrkeIraiInfo primaryKey;

    public GenIT_BAK_HrkeIraiInfo() {
        primaryKey = new PKIT_BAK_HrkeIraiInfo();
    }

    public GenIT_BAK_HrkeIraiInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_HrkeIraiInfo(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_HrkeIraiInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_HrkeIraiInfo> getMetaClass() {
        return QIT_BAK_HrkeIraiInfo.class;
    }

    @Id
    @Column(name=GenIT_BAK_HrkeIraiInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_HrkeIraiInfo.SYONO)
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
    @Column(name=GenIT_BAK_HrkeIraiInfo.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_HrkeIraiInfo.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private C_HrkeAnnaiJkKbn hrkeannaijkkbn;

    @Type(type="UserType_C_HrkeAnnaiJkKbn")
    @Column(name=GenIT_BAK_HrkeIraiInfo.HRKEANNAIJKKBN)
    public C_HrkeAnnaiJkKbn getHrkeannaijkkbn() {
        return hrkeannaijkkbn;
    }

    public void setHrkeannaijkkbn(C_HrkeAnnaiJkKbn pHrkeannaijkkbn) {
        hrkeannaijkkbn = pHrkeannaijkkbn;
    }

    private BizDate hrkeyousiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HrkeIraiInfo.HRKEYOUSIYMD)
    public BizDate getHrkeyousiymd() {
        return hrkeyousiymd;
    }

    public void setHrkeyousiymd(BizDate pHrkeyousiymd) {
        hrkeyousiymd = pHrkeyousiymd;
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HrkeIraiInfo.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HrkeIraiInfo.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private BizCurrency rsgaku;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
        rsgakuValue = null;
        rsgakuType  = null;
    }

    transient private BigDecimal rsgakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSGAKU, nullable=true)
    protected BigDecimal getRsgakuValue() {
        if (rsgakuValue == null && rsgaku != null) {
            if (rsgaku.isOptional()) return null;
            return rsgaku.absolute();
        }
        return rsgakuValue;
    }

    protected void setRsgakuValue(BigDecimal value) {
        rsgakuValue = value;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    transient private String rsgakuType = null;

    @Column(name=RSGAKU + "$", nullable=true)
    protected String getRsgakuType() {
        if (rsgakuType == null && rsgaku != null) return rsgaku.getType().toString();
        if (rsgakuType == null && getRsgakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsgaku$' should not be NULL."));
        }
        return rsgakuType;
    }

    protected void setRsgakuType(String type) {
        rsgakuType = type;
        rsgaku = Optional.fromNullable(toCurrencyType(rsgakuType))
            .transform(bizCurrencyTransformer(getRsgakuValue()))
            .orNull();
    }

    private BizDate torikesiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HrkeIraiInfo.TORIKESIYMD)
    public BizDate getTorikesiymd() {
        return torikesiymd;
    }

    @Trim("both")
    public void setTorikesiymd(BizDate pTorikesiymd) {
        torikesiymd = pTorikesiymd;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_BAK_HrkeIraiInfo.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private BizDate hrkkigen;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HrkeIraiInfo.HRKKIGEN)
    public BizDate getHrkkigen() {
        return hrkkigen;
    }

    @Trim("both")
    public void setHrkkigen(BizDate pHrkkigen) {
        hrkkigen = pHrkkigen;
    }

    private BizCurrency hrkiraikngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=9)
    @PositiveNumberBizCalcble
    public BizCurrency getHrkiraikngk() {
        return hrkiraikngk;
    }

    public void setHrkiraikngk(BizCurrency pHrkiraikngk) {
        hrkiraikngk = pHrkiraikngk;
        hrkiraikngkValue = null;
        hrkiraikngkType  = null;
    }

    transient private BigDecimal hrkiraikngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKIRAIKNGK, nullable=true)
    protected BigDecimal getHrkiraikngkValue() {
        if (hrkiraikngkValue == null && hrkiraikngk != null) {
            if (hrkiraikngk.isOptional()) return null;
            return hrkiraikngk.absolute();
        }
        return hrkiraikngkValue;
    }

    protected void setHrkiraikngkValue(BigDecimal value) {
        hrkiraikngkValue = value;
        hrkiraikngk = Optional.fromNullable(toCurrencyType(hrkiraikngkType))
            .transform(bizCurrencyTransformer(getHrkiraikngkValue()))
            .orNull();
    }

    transient private String hrkiraikngkType = null;

    @Column(name=HRKIRAIKNGK + "$", nullable=true)
    protected String getHrkiraikngkType() {
        if (hrkiraikngkType == null && hrkiraikngk != null) return hrkiraikngk.getType().toString();
        if (hrkiraikngkType == null && getHrkiraikngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkiraikngk$' should not be NULL."));
        }
        return hrkiraikngkType;
    }

    protected void setHrkiraikngkType(String type) {
        hrkiraikngkType = type;
        hrkiraikngk = Optional.fromNullable(toCurrencyType(hrkiraikngkType))
            .transform(bizCurrencyTransformer(getHrkiraikngkValue()))
            .orNull();
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_HrkeIraiInfo.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_BAK_HrkeIraiInfo.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_BAK_HrkeIraiInfo.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private C_KzkpannaijiyuuKbn kzkpannaijiyuukbn;

    @Type(type="UserType_C_KzkpannaijiyuuKbn")
    @Column(name=GenIT_BAK_HrkeIraiInfo.KZKPANNAIJIYUUKBN)
    public C_KzkpannaijiyuuKbn getKzkpannaijiyuukbn() {
        return kzkpannaijiyuukbn;
    }

    public void setKzkpannaijiyuukbn(C_KzkpannaijiyuuKbn pKzkpannaijiyuukbn) {
        kzkpannaijiyuukbn = pKzkpannaijiyuukbn;
    }

    private String comment124keta;

    @Column(name=GenIT_BAK_HrkeIraiInfo.COMMENT124KETA)
    public String getComment124keta() {
        return comment124keta;
    }

    @Trim("right")
    public void setComment124keta(String pComment124keta) {
        comment124keta = pComment124keta;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_BAK_HrkeIraiInfo.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private String syorisosikicd;

    @Column(name=GenIT_BAK_HrkeIraiInfo.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_HrkeIraiInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_HrkeIraiInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_HrkeIraiInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}