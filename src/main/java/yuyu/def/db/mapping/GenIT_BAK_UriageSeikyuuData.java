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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.IT_BAK_UriageSeikyuuData;
import yuyu.def.db.id.PKIT_BAK_UriageSeikyuuData;
import yuyu.def.db.meta.GenQIT_BAK_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_BAK_UriageSeikyuuData;
import yuyu.def.db.type.UserType_C_AuthoriKbn;
import yuyu.def.db.type.UserType_C_CreditUriageSeikyuuKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上請求データバックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_UriageSeikyuuData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_UriageSeikyuuData}</td><td colspan="3">売上請求データバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_UriageSeikyuuData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_UriageSeikyuuData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_UriageSeikyuuData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_BAK_UriageSeikyuuData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">{@link PKIT_BAK_UriageSeikyuuData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_BAK_UriageSeikyuuData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRecordno recordno}</td><td>レコード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCredituriageseikyuukbn credituriageseikyuukbn}</td><td>クレジットカード売上請求区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditUriageSeikyuuKbn}</td></tr>
 *  <tr><td>{@link #getAuthorikbn authorikbn}</td><td>オーソリ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthoriKbn}</td></tr>
 *  <tr><td>{@link #getCredituriagegk credituriagegk}</td><td>クレジットカード売上金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getFukusuukameitennokey fukusuukameitennokey}</td><td>複数加盟店番号設定キー情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyuutouym jyuutouym}</td><td>充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getAnnaino annaino}</td><td>案内番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_UriageSeikyuuData
 * @see     PKIT_BAK_UriageSeikyuuData
 * @see     QIT_BAK_UriageSeikyuuData
 * @see     GenQIT_BAK_UriageSeikyuuData
 */
@MappedSuperclass
@Table(name=GenIT_BAK_UriageSeikyuuData.TABLE_NAME)
@IdClass(value=PKIT_BAK_UriageSeikyuuData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AuthoriKbn", typeClass=UserType_C_AuthoriKbn.class),
    @TypeDef(name="UserType_C_CreditUriageSeikyuuKbn", typeClass=UserType_C_CreditUriageSeikyuuKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class)
})
public abstract class GenIT_BAK_UriageSeikyuuData extends AbstractExDBEntity<IT_BAK_UriageSeikyuuData, PKIT_BAK_UriageSeikyuuData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_UriageSeikyuuData";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String URIAGENENGAPPI           = "uriagenengappi";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String RECORDNO                 = "recordno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String CREDITURIAGESEIKYUUKBN   = "credituriageseikyuukbn";
    public static final String AUTHORIKBN               = "authorikbn";
    public static final String CREDITURIAGEGK           = "credituriagegk";
    public static final String FUKUSUUKAMEITENNOKEY     = "fukusuukameitennokey";
    public static final String JYUUTOUYM                = "jyuutouym";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String ANNAINO                  = "annaino";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_UriageSeikyuuData primaryKey;

    public GenIT_BAK_UriageSeikyuuData() {
        primaryKey = new PKIT_BAK_UriageSeikyuuData();
    }

    public GenIT_BAK_UriageSeikyuuData(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_BAK_UriageSeikyuuData(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pCreditkessaiyouno,
            pUriagenengappi,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_BAK_UriageSeikyuuData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_UriageSeikyuuData> getMetaClass() {
        return QIT_BAK_UriageSeikyuuData.class;
    }

    @Id
    @Column(name=GenIT_BAK_UriageSeikyuuData.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_UriageSeikyuuData.SYONO)
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
    @Column(name=GenIT_BAK_UriageSeikyuuData.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_UriageSeikyuuData.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_UriageSeikyuuData.URIAGENENGAPPI)
    public BizDate getUriagenengappi() {
        return getPrimaryKey().getUriagenengappi();
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        getPrimaryKey().setUriagenengappi(pUriagenengappi);
    }

    @Id
    @Column(name=GenIT_BAK_UriageSeikyuuData.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String recordno;

    @Column(name=GenIT_BAK_UriageSeikyuuData.RECORDNO)
    public String getRecordno() {
        return recordno;
    }

    public void setRecordno(String pRecordno) {
        recordno = pRecordno;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_UriageSeikyuuData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    @Type(type="UserType_C_CreditUriageSeikyuuKbn")
    @Column(name=GenIT_BAK_UriageSeikyuuData.CREDITURIAGESEIKYUUKBN)
    public C_CreditUriageSeikyuuKbn getCredituriageseikyuukbn() {
        return credituriageseikyuukbn;
    }

    public void setCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn pCredituriageseikyuukbn) {
        credituriageseikyuukbn = pCredituriageseikyuukbn;
    }

    private C_AuthoriKbn authorikbn;

    @Type(type="UserType_C_AuthoriKbn")
    @Column(name=GenIT_BAK_UriageSeikyuuData.AUTHORIKBN)
    public C_AuthoriKbn getAuthorikbn() {
        return authorikbn;
    }

    public void setAuthorikbn(C_AuthoriKbn pAuthorikbn) {
        authorikbn = pAuthorikbn;
    }

    private BizCurrency credituriagegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCredituriagegk() {
        return credituriagegk;
    }

    public void setCredituriagegk(BizCurrency pCredituriagegk) {
        credituriagegk = pCredituriagegk;
        credituriagegkValue = null;
        credituriagegkType  = null;
    }

    transient private BigDecimal credituriagegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CREDITURIAGEGK, nullable=true)
    protected BigDecimal getCredituriagegkValue() {
        if (credituriagegkValue == null && credituriagegk != null) {
            if (credituriagegk.isOptional()) return null;
            return credituriagegk.absolute();
        }
        return credituriagegkValue;
    }

    protected void setCredituriagegkValue(BigDecimal value) {
        credituriagegkValue = value;
        credituriagegk = Optional.fromNullable(toCurrencyType(credituriagegkType))
            .transform(bizCurrencyTransformer(getCredituriagegkValue()))
            .orNull();
    }

    transient private String credituriagegkType = null;

    @Column(name=CREDITURIAGEGK + "$", nullable=true)
    protected String getCredituriagegkType() {
        if (credituriagegkType == null && credituriagegk != null) return credituriagegk.getType().toString();
        if (credituriagegkType == null && getCredituriagegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'credituriagegk$' should not be NULL."));
        }
        return credituriagegkType;
    }

    protected void setCredituriagegkType(String type) {
        credituriagegkType = type;
        credituriagegk = Optional.fromNullable(toCurrencyType(credituriagegkType))
            .transform(bizCurrencyTransformer(getCredituriagegkValue()))
            .orNull();
    }

    private String fukusuukameitennokey;

    @Column(name=GenIT_BAK_UriageSeikyuuData.FUKUSUUKAMEITENNOKEY)
    public String getFukusuukameitennokey() {
        return fukusuukameitennokey;
    }

    public void setFukusuukameitennokey(String pFukusuukameitennokey) {
        fukusuukameitennokey = pFukusuukameitennokey;
    }

    private BizDateYM jyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_UriageSeikyuuData.JYUUTOUYM)
    @ValidDateYm
    public BizDateYM getJyuutouym() {
        return jyuutouym;
    }

    @Trim("both")
    public void setJyuutouym(BizDateYM pJyuutouym) {
        jyuutouym = pJyuutouym;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_BAK_UriageSeikyuuData.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_BAK_UriageSeikyuuData.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_BAK_UriageSeikyuuData.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_BAK_UriageSeikyuuData.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_BAK_UriageSeikyuuData.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private Integer annaino;

    @Column(name=GenIT_BAK_UriageSeikyuuData.ANNAINO)
    public Integer getAnnaino() {
        return annaino;
    }

    public void setAnnaino(Integer pAnnaino) {
        annaino = pAnnaino;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_UriageSeikyuuData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_UriageSeikyuuData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_UriageSeikyuuData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}