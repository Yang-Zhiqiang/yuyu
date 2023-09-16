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
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.id.PKHT_Nyuukin;
import yuyu.def.db.meta.GenQHT_Nyuukin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.type.UserType_C_NyknsyubetuKbn;
import yuyu.def.db.type.UserType_C_NyuukinHenkinSyoriKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZenhnknKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 入金テーブル テーブルのマッピング情報クラスで、 {@link HT_Nyuukin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Nyuukin}</td><td colspan="3">入金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_Nyuukin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_Nyuukin ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSoukinymd soukinymd}</td><td>送金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyuukinsyoritime nyuukinsyoritime}</td><td>入金処理日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyknsyubetu nyknsyubetu}</td><td>入金種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknsyubetuKbn}</td></tr>
 *  <tr><td>{@link #getSoukincd soukincd}</td><td>送金コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsgaku rsgaku}</td><td>領収金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRssyouno rssyouno}</td><td>領収証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhnknkbn zenhnknkbn}</td><td>全額返金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZenhnknKbn}</td></tr>
 *  <tr><td>{@link #getSrgonyknumu srgonyknumu}</td><td>成立後入金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDenrenno2 denrenno2}</td><td>伝票データ連番２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDntcd dntcd}</td><td>団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinhenkinsyorikbn nyuukinhenkinsyorikbn}</td><td>入金返金処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuukinHenkinSyoriKbn}</td></tr>
 *  <tr><td>{@link #getZenhnknrenno zenhnknrenno}</td><td>全額返金連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Nyuukin
 * @see     PKHT_Nyuukin
 * @see     QHT_Nyuukin
 * @see     GenQHT_Nyuukin
 */
@MappedSuperclass
@Table(name=GenHT_Nyuukin.TABLE_NAME)
@IdClass(value=PKHT_Nyuukin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_NyknsyubetuKbn", typeClass=UserType_C_NyknsyubetuKbn.class),
    @TypeDef(name="UserType_C_NyuukinHenkinSyoriKbn", typeClass=UserType_C_NyuukinHenkinSyoriKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_ZenhnknKbn", typeClass=UserType_C_ZenhnknKbn.class)
})
public abstract class GenHT_Nyuukin extends AbstractExDBEntity<HT_Nyuukin, PKHT_Nyuukin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_Nyuukin";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String SOUKINYMD                = "soukinymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String NYUUKINSYORITIME         = "nyuukinsyoritime";
    public static final String NYKNSYUBETU              = "nyknsyubetu";
    public static final String SOUKINCD                 = "soukincd";
    public static final String RSGAKU                   = "rsgaku";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String RSSYOUNO                 = "rssyouno";
    public static final String ZENHNKNKBN               = "zenhnknkbn";
    public static final String SRGONYKNUMU              = "srgonyknumu";
    public static final String DENRENNO                 = "denrenno";
    public static final String DENRENNO2                = "denrenno2";
    public static final String EDANO                    = "edano";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String KRKNO                    = "krkno";
    public static final String DNTCD                    = "dntcd";
    public static final String NYUUKINHENKINSYORIKBN    = "nyuukinhenkinsyorikbn";
    public static final String ZENHNKNRENNO             = "zenhnknrenno";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_Nyuukin primaryKey;

    public GenHT_Nyuukin() {
        primaryKey = new PKHT_Nyuukin();
    }

    public GenHT_Nyuukin(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_Nyuukin(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_Nyuukin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_Nyuukin> getMetaClass() {
        return QHT_Nyuukin.class;
    }

    @Id
    @Column(name=GenHT_Nyuukin.MOSNO)
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
    @Column(name=GenHT_Nyuukin.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate soukinymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Nyuukin.SOUKINYMD)
    @ValidDate
    public BizDate getSoukinymd() {
        return soukinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSoukinymd(BizDate pSoukinymd) {
        soukinymd = pSoukinymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Nyuukin.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private BizDate nyksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Nyuukin.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }

    private String nyuukinsyoritime;

    @Column(name=GenHT_Nyuukin.NYUUKINSYORITIME)
    public String getNyuukinsyoritime() {
        return nyuukinsyoritime;
    }

    public void setNyuukinsyoritime(String pNyuukinsyoritime) {
        nyuukinsyoritime = pNyuukinsyoritime;
    }

    private C_NyknsyubetuKbn nyknsyubetu;

    @Type(type="UserType_C_NyknsyubetuKbn")
    @Column(name=GenHT_Nyuukin.NYKNSYUBETU)
    public C_NyknsyubetuKbn getNyknsyubetu() {
        return nyknsyubetu;
    }

    public void setNyknsyubetu(C_NyknsyubetuKbn pNyknsyubetu) {
        nyknsyubetu = pNyknsyubetu;
    }

    private String soukincd;

    @Column(name=GenHT_Nyuukin.SOUKINCD)
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

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_Nyuukin.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_Nyuukin.RYOSYUYMD)
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

    @Column(name=GenHT_Nyuukin.RSSYOUNO)
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
    @Column(name=GenHT_Nyuukin.ZENHNKNKBN)
    public C_ZenhnknKbn getZenhnknkbn() {
        return zenhnknkbn;
    }

    public void setZenhnknkbn(C_ZenhnknKbn pZenhnknkbn) {
        zenhnknkbn = pZenhnknkbn;
    }

    private C_UmuKbn srgonyknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_Nyuukin.SRGONYKNUMU)
    public C_UmuKbn getSrgonyknumu() {
        return srgonyknumu;
    }

    public void setSrgonyknumu(C_UmuKbn pSrgonyknumu) {
        srgonyknumu = pSrgonyknumu;
    }

    private String denrenno;

    @Column(name=GenHT_Nyuukin.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private String denrenno2;

    @Column(name=GenHT_Nyuukin.DENRENNO2)
    public String getDenrenno2() {
        return denrenno2;
    }

    public void setDenrenno2(String pDenrenno2) {
        denrenno2 = pDenrenno2;
    }

    private Integer edano;

    @Column(name=GenHT_Nyuukin.EDANO)
    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_Nyuukin.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer krkno;

    @Column(name=GenHT_Nyuukin.KRKNO)
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

    @Column(name=GenHT_Nyuukin.DNTCD)
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

    private C_NyuukinHenkinSyoriKbn nyuukinhenkinsyorikbn;

    @Type(type="UserType_C_NyuukinHenkinSyoriKbn")
    @Column(name=GenHT_Nyuukin.NYUUKINHENKINSYORIKBN)
    public C_NyuukinHenkinSyoriKbn getNyuukinhenkinsyorikbn() {
        return nyuukinhenkinsyorikbn;
    }

    public void setNyuukinhenkinsyorikbn(C_NyuukinHenkinSyoriKbn pNyuukinhenkinsyorikbn) {
        nyuukinhenkinsyorikbn = pNyuukinhenkinsyorikbn;
    }

    private Integer zenhnknrenno;

    @Column(name=GenHT_Nyuukin.ZENHNKNRENNO)
    public Integer getZenhnknrenno() {
        return zenhnknrenno;
    }

    public void setZenhnknrenno(Integer pZenhnknrenno) {
        zenhnknrenno = pZenhnknrenno;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_Nyuukin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_Nyuukin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}