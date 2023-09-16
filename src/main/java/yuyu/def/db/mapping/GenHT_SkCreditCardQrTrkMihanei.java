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
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.id.PKHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.GenQHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.QHT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.type.UserType_C_Syorizumiflg;

/**
 * 新契約クレジットカードＱＲ登録結果未反映テーブル テーブルのマッピング情報クラスで、 {@link HT_SkCreditCardQrTrkMihanei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkCreditCardQrTrkMihanei}</td><td colspan="3">新契約クレジットカードＱＲ登録結果未反映テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_SkCreditCardQrTrkMihanei ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSystemjyusinymd systemjyusinymd}</td><td>システム受信日</td><td align="center">{@link PKHT_SkCreditCardQrTrkMihanei ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSystemjyusintime systemjyusintime}</td><td>システム受信時刻</td><td align="center">{@link PKHT_SkCreditCardQrTrkMihanei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditqrtrkkbn creditqrtrkkbn}</td><td>クレジットカードＱＲ登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditqrsousinkbn creditqrsousinkbn}</td><td>クレジットカードＱＲ送信区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKHT_SkCreditCardQrTrkMihanei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getCreditauthorigk creditauthorigk}</td><td>クレジットカードオーソリ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTyuumonno tyuumonno}</td><td>注文番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBluegateshopid bluegateshopid}</td><td>ＢｌｕｅＧａｔｅショップＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKessaisyoriymd kessaisyoriymd}</td><td>決済処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCreditqrerrorcd creditqrerrorcd}</td><td>クレジットカードＱＲエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouninnoseven syouninnoseven}</td><td>承認番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBluegateerrorcd bluegateerrorcd}</td><td>ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHisimukekaisyacd hisimukekaisyacd}</td><td>被仕向会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBluegatejyusinymdtime bluegatejyusinymdtime}</td><td>ＢｌｕｅＧａｔｅ受付日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkCreditCardQrTrkMihanei
 * @see     PKHT_SkCreditCardQrTrkMihanei
 * @see     QHT_SkCreditCardQrTrkMihanei
 * @see     GenQHT_SkCreditCardQrTrkMihanei
 */
@MappedSuperclass
@Table(name=GenHT_SkCreditCardQrTrkMihanei.TABLE_NAME)
@IdClass(value=PKHT_SkCreditCardQrTrkMihanei.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class)
})
public abstract class GenHT_SkCreditCardQrTrkMihanei extends AbstractExDBEntity<HT_SkCreditCardQrTrkMihanei, PKHT_SkCreditCardQrTrkMihanei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkCreditCardQrTrkMihanei";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYSTEMJYUSINYMD          = "systemjyusinymd";
    public static final String SYSTEMJYUSINTIME         = "systemjyusintime";
    public static final String CREDITQRTRKKBN           = "creditqrtrkkbn";
    public static final String CREDITQRSOUSINKBN        = "creditqrsousinkbn";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String CREDITAUTHORIGK          = "creditauthorigk";
    public static final String TYUUMONNO                = "tyuumonno";
    public static final String BLUEGATESHOPID           = "bluegateshopid";
    public static final String KESSAISYORIYMD           = "kessaisyoriymd";
    public static final String CREDITQRERRORCD          = "creditqrerrorcd";
    public static final String SYOUNINNOSEVEN           = "syouninnoseven";
    public static final String BLUEGATEERRORCD          = "bluegateerrorcd";
    public static final String HISIMUKEKAISYACD         = "hisimukekaisyacd";
    public static final String BLUEGATEJYUSINYMDTIME    = "bluegatejyusinymdtime";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkCreditCardQrTrkMihanei primaryKey;

    public GenHT_SkCreditCardQrTrkMihanei() {
        primaryKey = new PKHT_SkCreditCardQrTrkMihanei();
    }

    public GenHT_SkCreditCardQrTrkMihanei(
        BizDate pSyoriYmd,
        BizDate pSystemjyusinymd,
        String pSystemjyusintime,
        String pCreditkessaiyouno
    ) {
        primaryKey = new PKHT_SkCreditCardQrTrkMihanei(
            pSyoriYmd,
            pSystemjyusinymd,
            pSystemjyusintime,
            pCreditkessaiyouno
        );
    }

    @Transient
    @Override
    public PKHT_SkCreditCardQrTrkMihanei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkCreditCardQrTrkMihanei> getMetaClass() {
        return QHT_SkCreditCardQrTrkMihanei.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkCreditCardQrTrkMihanei.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkCreditCardQrTrkMihanei.SYSTEMJYUSINYMD)
    public BizDate getSystemjyusinymd() {
        return getPrimaryKey().getSystemjyusinymd();
    }

    public void setSystemjyusinymd(BizDate pSystemjyusinymd) {
        getPrimaryKey().setSystemjyusinymd(pSystemjyusinymd);
    }

    @Id
    @Column(name=GenHT_SkCreditCardQrTrkMihanei.SYSTEMJYUSINTIME)
    public String getSystemjyusintime() {
        return getPrimaryKey().getSystemjyusintime();
    }

    public void setSystemjyusintime(String pSystemjyusintime) {
        getPrimaryKey().setSystemjyusintime(pSystemjyusintime);
    }

    private String creditqrtrkkbn;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.CREDITQRTRKKBN)
    public String getCreditqrtrkkbn() {
        return creditqrtrkkbn;
    }

    public void setCreditqrtrkkbn(String pCreditqrtrkkbn) {
        creditqrtrkkbn = pCreditqrtrkkbn;
    }

    private String creditqrsousinkbn;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.CREDITQRSOUSINKBN)
    public String getCreditqrsousinkbn() {
        return creditqrsousinkbn;
    }

    public void setCreditqrsousinkbn(String pCreditqrsousinkbn) {
        creditqrsousinkbn = pCreditqrsousinkbn;
    }

    @Id
    @Column(name=GenHT_SkCreditCardQrTrkMihanei.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    private String nykmosno;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenHT_SkCreditCardQrTrkMihanei.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private BizCurrency creditauthorigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getCreditauthorigk() {
        return creditauthorigk;
    }

    public void setCreditauthorigk(BizCurrency pCreditauthorigk) {
        creditauthorigk = pCreditauthorigk;
        creditauthorigkValue = null;
        creditauthorigkType  = null;
    }

    transient private BigDecimal creditauthorigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=CREDITAUTHORIGK, nullable=true)
    protected BigDecimal getCreditauthorigkValue() {
        if (creditauthorigkValue == null && creditauthorigk != null) {
            if (creditauthorigk.isOptional()) return null;
            return creditauthorigk.absolute();
        }
        return creditauthorigkValue;
    }

    protected void setCreditauthorigkValue(BigDecimal value) {
        creditauthorigkValue = value;
        creditauthorigk = Optional.fromNullable(toCurrencyType(creditauthorigkType))
            .transform(bizCurrencyTransformer(getCreditauthorigkValue()))
            .orNull();
    }

    transient private String creditauthorigkType = null;

    @Column(name=CREDITAUTHORIGK + "$", nullable=true)
    protected String getCreditauthorigkType() {
        if (creditauthorigkType == null && creditauthorigk != null) return creditauthorigk.getType().toString();
        if (creditauthorigkType == null && getCreditauthorigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'creditauthorigk$' should not be NULL."));
        }
        return creditauthorigkType;
    }

    protected void setCreditauthorigkType(String type) {
        creditauthorigkType = type;
        creditauthorigk = Optional.fromNullable(toCurrencyType(creditauthorigkType))
            .transform(bizCurrencyTransformer(getCreditauthorigkValue()))
            .orNull();
    }

    private String tyuumonno;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.TYUUMONNO)
    public String getTyuumonno() {
        return tyuumonno;
    }

    public void setTyuumonno(String pTyuumonno) {
        tyuumonno = pTyuumonno;
    }

    private String bluegateshopid;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.BLUEGATESHOPID)
    public String getBluegateshopid() {
        return bluegateshopid;
    }

    public void setBluegateshopid(String pBluegateshopid) {
        bluegateshopid = pBluegateshopid;
    }

    private BizDate kessaisyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkCreditCardQrTrkMihanei.KESSAISYORIYMD)
    public BizDate getKessaisyoriymd() {
        return kessaisyoriymd;
    }

    public void setKessaisyoriymd(BizDate pKessaisyoriymd) {
        kessaisyoriymd = pKessaisyoriymd;
    }

    private String creditqrerrorcd;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.CREDITQRERRORCD)
    public String getCreditqrerrorcd() {
        return creditqrerrorcd;
    }

    public void setCreditqrerrorcd(String pCreditqrerrorcd) {
        creditqrerrorcd = pCreditqrerrorcd;
    }

    private String syouninnoseven;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.SYOUNINNOSEVEN)
    public String getSyouninnoseven() {
        return syouninnoseven;
    }

    public void setSyouninnoseven(String pSyouninnoseven) {
        syouninnoseven = pSyouninnoseven;
    }

    private String bluegateerrorcd;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.BLUEGATEERRORCD)
    public String getBluegateerrorcd() {
        return bluegateerrorcd;
    }

    public void setBluegateerrorcd(String pBluegateerrorcd) {
        bluegateerrorcd = pBluegateerrorcd;
    }

    private String hisimukekaisyacd;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.HISIMUKEKAISYACD)
    public String getHisimukekaisyacd() {
        return hisimukekaisyacd;
    }

    public void setHisimukekaisyacd(String pHisimukekaisyacd) {
        hisimukekaisyacd = pHisimukekaisyacd;
    }

    private String bluegatejyusinymdtime;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.BLUEGATEJYUSINYMDTIME)
    public String getBluegatejyusinymdtime() {
        return bluegatejyusinymdtime;
    }

    public void setBluegatejyusinymdtime(String pBluegatejyusinymdtime) {
        bluegatejyusinymdtime = pBluegatejyusinymdtime;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkCreditCardQrTrkMihanei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}