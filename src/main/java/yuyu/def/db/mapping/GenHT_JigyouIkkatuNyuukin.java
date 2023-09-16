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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import yuyu.def.db.id.PKHT_JigyouIkkatuNyuukin;
import yuyu.def.db.meta.GenQHT_JigyouIkkatuNyuukin;
import yuyu.def.db.meta.QHT_JigyouIkkatuNyuukin;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZenhnknKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 事業一括入金テーブル テーブルのマッピング情報クラスで、 {@link HT_JigyouIkkatuNyuukin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JigyouIkkatuNyuukin}</td><td colspan="3">事業一括入金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">{@link PKHT_JigyouIkkatuNyuukin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_JigyouIkkatuNyuukin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSoukinymd soukinymd}</td><td>送金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSoukincd soukincd}</td><td>送金コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRssyouno rssyouno}</td><td>領収証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhnknkbn zenhnknkbn}</td><td>全額返金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZenhnknKbn}</td></tr>
 *  <tr><td>{@link #getSrgonyknumu srgonyknumu}</td><td>成立後入金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDntcd dntcd}</td><td>団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JigyouIkkatuNyuukin
 * @see     PKHT_JigyouIkkatuNyuukin
 * @see     QHT_JigyouIkkatuNyuukin
 * @see     GenQHT_JigyouIkkatuNyuukin
 */
@MappedSuperclass
@Table(name=GenHT_JigyouIkkatuNyuukin.TABLE_NAME)
@IdClass(value=PKHT_JigyouIkkatuNyuukin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_ZenhnknKbn", typeClass=UserType_C_ZenhnknKbn.class)
})
public abstract class GenHT_JigyouIkkatuNyuukin extends AbstractExDBEntity<HT_JigyouIkkatuNyuukin, PKHT_JigyouIkkatuNyuukin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_JigyouIkkatuNyuukin";
    public static final String DAIMOSNO                 = "daimosno";
    public static final String RENNO                    = "renno";
    public static final String SOUKINYMD                = "soukinymd";
    public static final String SOUKINCD                 = "soukincd";
    public static final String RSGAKU                   = "rsgaku";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String RSSYOUNO                 = "rssyouno";
    public static final String ZENHNKNKBN               = "zenhnknkbn";
    public static final String SRGONYKNUMU              = "srgonyknumu";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String KRKNO                    = "krkno";
    public static final String DNTCD                    = "dntcd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_JigyouIkkatuNyuukin primaryKey;

    public GenHT_JigyouIkkatuNyuukin() {
        primaryKey = new PKHT_JigyouIkkatuNyuukin();
    }

    public GenHT_JigyouIkkatuNyuukin(String pDaimosno, Integer pRenno) {
        primaryKey = new PKHT_JigyouIkkatuNyuukin(pDaimosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_JigyouIkkatuNyuukin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_JigyouIkkatuNyuukin> getMetaClass() {
        return QHT_JigyouIkkatuNyuukin.class;
    }

    @Id
    @Column(name=GenHT_JigyouIkkatuNyuukin.DAIMOSNO)
    @MousikomiNo
    public String getDaimosno() {
        return getPrimaryKey().getDaimosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDaimosno(String pDaimosno) {
        getPrimaryKey().setDaimosno(pDaimosno);
    }

    @Id
    @Column(name=GenHT_JigyouIkkatuNyuukin.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate soukinymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_JigyouIkkatuNyuukin.SOUKINYMD)
    @ValidDate
    public BizDate getSoukinymd() {
        return soukinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSoukinymd(BizDate pSoukinymd) {
        soukinymd = pSoukinymd;
    }

    private String soukincd;

    @Column(name=GenHT_JigyouIkkatuNyuukin.SOUKINCD)
    @MaxLength(max=10)
    @AlphaDigit
    public String getSoukincd() {
        return soukincd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSoukincd(String pSoukincd) {
        soukincd = pSoukincd;
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

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_JigyouIkkatuNyuukin.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private String rssyouno;

    @Column(name=GenHT_JigyouIkkatuNyuukin.RSSYOUNO)
    @MaxLength(max=20)
    @AlphaDigit
    public String getRssyouno() {
        return rssyouno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRssyouno(String pRssyouno) {
        rssyouno = pRssyouno;
    }

    private C_ZenhnknKbn zenhnknkbn;

    @Type(type="UserType_C_ZenhnknKbn")
    @Column(name=GenHT_JigyouIkkatuNyuukin.ZENHNKNKBN)
    public C_ZenhnknKbn getZenhnknkbn() {
        return zenhnknkbn;
    }

    public void setZenhnknkbn(C_ZenhnknKbn pZenhnknkbn) {
        zenhnknkbn = pZenhnknkbn;
    }

    private C_UmuKbn srgonyknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_JigyouIkkatuNyuukin.SRGONYKNUMU)
    public C_UmuKbn getSrgonyknumu() {
        return srgonyknumu;
    }

    public void setSrgonyknumu(C_UmuKbn pSrgonyknumu) {
        srgonyknumu = pSrgonyknumu;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_JigyouIkkatuNyuukin.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer krkno;

    @Column(name=GenHT_JigyouIkkatuNyuukin.KRKNO)
    @Range(min="0", max="99999")
    public Integer getKrkno() {
        return krkno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKrkno(Integer pKrkno) {
        krkno = pKrkno;
    }

    private String dntcd;

    @Column(name=GenHT_JigyouIkkatuNyuukin.DNTCD)
    @MaxLength(max=8)
    @AlphaDigit
    public String getDntcd() {
        return dntcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDntcd(String pDntcd) {
        dntcd = pDntcd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_JigyouIkkatuNyuukin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_JigyouIkkatuNyuukin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}