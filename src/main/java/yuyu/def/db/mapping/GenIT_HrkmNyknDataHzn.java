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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_HrkmNyknDataHzn;
import yuyu.def.db.id.PKIT_HrkmNyknDataHzn;
import yuyu.def.db.meta.GenQIT_HrkmNyknDataHzn;
import yuyu.def.db.meta.QIT_HrkmNyknDataHzn;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 振込入金データ（保全用）テーブル テーブルのマッピング情報クラスで、 {@link IT_HrkmNyknDataHzn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HrkmNyknDataHzn}</td><td colspan="3">振込入金データ（保全用）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">{@link PKIT_HrkmNyknDataHzn ○}</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_HrkmNyknDataHzn ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">{@link PKIT_HrkmNyknDataHzn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyubetucd syubetucd}</td><td>種別コード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCdkbn cdkbn}</td><td>コード区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKnjyymdfrom knjyymdfrom}</td><td>勘定日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKnjyymdto knjyymdto}</td><td>勘定日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmkn banknmkn}</td><td>銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkn sitennmkn}</td><td>支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKznmkn kznmkn}</td><td>口座名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKasikosikbn kasikosikbn}</td><td>貸越区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuutyousysykbn tuutyousysykbn}</td><td>通帳証書区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrhkmaezndk trhkmaezndk}</td><td>取引前残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyoukaino syoukaino}</td><td>照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKnjyymd knjyymd}</td><td>勘定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAzkrhrdsymd azkrhrdsymd}</td><td>預入払出日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIribaraikbn iribaraikbn}</td><td>入払区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrhkkbn trhkkbn}</td><td>取引区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrhkkgk trhkkgk}</td><td>取引金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTatenkengk tatenkengk}</td><td>うち他店券金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKknteijiymd kknteijiymd}</td><td>交換呈示日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHwtrhnknymd hwtrhnknymd}</td><td>不渡返還日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTgtkgtkbn tgtkgtkbn}</td><td>手形小切手区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTgtkgtno tgtkgtno}</td><td>手形小切手番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyoutenno ryoutenno}</td><td>僚店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirnincd hrkmirnincd}</td><td>振込依頼人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirninnm hrkmirninnm}</td><td>振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimukebanknmkn simukebanknmkn}</td><td>仕向銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimuketennmkn simuketennmkn}</td><td>仕向店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyounaiyou tekiyounaiyou}</td><td>摘要内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getEdiinfo ediinfo}</td><td>ＥＤＩ情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HrkmNyknDataHzn
 * @see     PKIT_HrkmNyknDataHzn
 * @see     QIT_HrkmNyknDataHzn
 * @see     GenQIT_HrkmNyknDataHzn
 */
@MappedSuperclass
@Table(name=GenIT_HrkmNyknDataHzn.TABLE_NAME)
@IdClass(value=PKIT_HrkmNyknDataHzn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_HrkmNyknDataHzn extends AbstractExDBEntity<IT_HrkmNyknDataHzn, PKIT_HrkmNyknDataHzn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HrkmNyknDataHzn";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String ITIRENNO                 = "itirenno";
    public static final String SYONO                    = "syono";
    public static final String SYUBETUCD                = "syubetucd";
    public static final String CDKBN                    = "cdkbn";
    public static final String SAKUSEIYMD               = "sakuseiymd";
    public static final String KNJYYMDFROM              = "knjyymdfrom";
    public static final String KNJYYMDTO                = "knjyymdto";
    public static final String BANKCD                   = "bankcd";
    public static final String BANKNMKN                 = "banknmkn";
    public static final String SITENCD                  = "sitencd";
    public static final String SITENNMKN                = "sitennmkn";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZNMKN                   = "kznmkn";
    public static final String KASIKOSIKBN              = "kasikosikbn";
    public static final String TUUTYOUSYSYKBN           = "tuutyousysykbn";
    public static final String TRHKMAEZNDK              = "trhkmaezndk";
    public static final String SYOUKAINO                = "syoukaino";
    public static final String KNJYYMD                  = "knjyymd";
    public static final String AZKRHRDSYMD              = "azkrhrdsymd";
    public static final String IRIBARAIKBN              = "iribaraikbn";
    public static final String TRHKKBN                  = "trhkkbn";
    public static final String TRHKKGK                  = "trhkkgk";
    public static final String TATENKENGK               = "tatenkengk";
    public static final String KKNTEIJIYMD              = "kknteijiymd";
    public static final String HWTRHNKNYMD              = "hwtrhnknymd";
    public static final String TGTKGTKBN                = "tgtkgtkbn";
    public static final String TGTKGTNO                 = "tgtkgtno";
    public static final String RYOUTENNO                = "ryoutenno";
    public static final String HRKMIRNINCD              = "hrkmirnincd";
    public static final String HRKMIRNINNM              = "hrkmirninnm";
    public static final String SIMUKEBANKNMKN           = "simukebanknmkn";
    public static final String SIMUKETENNMKN            = "simuketennmkn";
    public static final String TEKIYOUNAIYOU            = "tekiyounaiyou";
    public static final String EDIINFO                  = "ediinfo";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HrkmNyknDataHzn primaryKey;

    public GenIT_HrkmNyknDataHzn() {
        primaryKey = new PKIT_HrkmNyknDataHzn();
    }

    public GenIT_HrkmNyknDataHzn(
        C_DensysKbn pDensyskbn,
        BizDate pSyoriYmd,
        String pItirenno
    ) {
        primaryKey = new PKIT_HrkmNyknDataHzn(
            pDensyskbn,
            pSyoriYmd,
            pItirenno
        );
    }

    @Transient
    @Override
    public PKIT_HrkmNyknDataHzn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HrkmNyknDataHzn> getMetaClass() {
        return QIT_HrkmNyknDataHzn.class;
    }

    @Id
    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenIT_HrkmNyknDataHzn.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return getPrimaryKey().getDensyskbn();
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        getPrimaryKey().setDensyskbn(pDensyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.SYORIYMD)
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
    @Column(name=GenIT_HrkmNyknDataHzn.ITIRENNO)
    public String getItirenno() {
        return getPrimaryKey().getItirenno();
    }

    public void setItirenno(String pItirenno) {
        getPrimaryKey().setItirenno(pItirenno);
    }

    private String syono;

    @Column(name=GenIT_HrkmNyknDataHzn.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private Integer syubetucd;

    @Column(name=GenIT_HrkmNyknDataHzn.SYUBETUCD)
    public Integer getSyubetucd() {
        return syubetucd;
    }

    public void setSyubetucd(Integer pSyubetucd) {
        syubetucd = pSyubetucd;
    }

    private Integer cdkbn;

    @Column(name=GenIT_HrkmNyknDataHzn.CDKBN)
    public Integer getCdkbn() {
        return cdkbn;
    }

    public void setCdkbn(Integer pCdkbn) {
        cdkbn = pCdkbn;
    }

    private BizDate sakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.SAKUSEIYMD)
    @ValidDate
    public BizDate getSakuseiymd() {
        return sakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseiymd(BizDate pSakuseiymd) {
        sakuseiymd = pSakuseiymd;
    }

    private BizDate knjyymdfrom;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.KNJYYMDFROM)
    public BizDate getKnjyymdfrom() {
        return knjyymdfrom;
    }

    public void setKnjyymdfrom(BizDate pKnjyymdfrom) {
        knjyymdfrom = pKnjyymdfrom;
    }

    private BizDate knjyymdto;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.KNJYYMDTO)
    public BizDate getKnjyymdto() {
        return knjyymdto;
    }

    public void setKnjyymdto(BizDate pKnjyymdto) {
        knjyymdto = pKnjyymdto;
    }

    private String bankcd;

    @Column(name=GenIT_HrkmNyknDataHzn.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String banknmkn;

    @Column(name=GenIT_HrkmNyknDataHzn.BANKNMKN)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getBanknmkn() {
        return banknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkn(String pBanknmkn) {
        banknmkn = pBanknmkn;
    }

    private String sitencd;

    @Column(name=GenIT_HrkmNyknDataHzn.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private String sitennmkn;

    @Column(name=GenIT_HrkmNyknDataHzn.SITENNMKN)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSitennmkn() {
        return sitennmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkn(String pSitennmkn) {
        sitennmkn = pSitennmkn;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_HrkmNyknDataHzn.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_HrkmNyknDataHzn.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private String kznmkn;

    @Column(name=GenIT_HrkmNyknDataHzn.KZNMKN)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getKznmkn() {
        return kznmkn;
    }

    public void setKznmkn(String pKznmkn) {
        kznmkn = pKznmkn;
    }

    private Integer kasikosikbn;

    @Column(name=GenIT_HrkmNyknDataHzn.KASIKOSIKBN)
    public Integer getKasikosikbn() {
        return kasikosikbn;
    }

    public void setKasikosikbn(Integer pKasikosikbn) {
        kasikosikbn = pKasikosikbn;
    }

    private Integer tuutyousysykbn;

    @Column(name=GenIT_HrkmNyknDataHzn.TUUTYOUSYSYKBN)
    public Integer getTuutyousysykbn() {
        return tuutyousysykbn;
    }

    public void setTuutyousysykbn(Integer pTuutyousysykbn) {
        tuutyousysykbn = pTuutyousysykbn;
    }

    private BizCurrency trhkmaezndk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTrhkmaezndk() {
        return trhkmaezndk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrhkmaezndk(BizCurrency pTrhkmaezndk) {
        trhkmaezndk = pTrhkmaezndk;
        trhkmaezndkValue = null;
        trhkmaezndkType  = null;
    }

    transient private BigDecimal trhkmaezndkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TRHKMAEZNDK, nullable=true)
    protected BigDecimal getTrhkmaezndkValue() {
        if (trhkmaezndkValue == null && trhkmaezndk != null) {
            if (trhkmaezndk.isOptional()) return null;
            return trhkmaezndk.absolute();
        }
        return trhkmaezndkValue;
    }

    protected void setTrhkmaezndkValue(BigDecimal value) {
        trhkmaezndkValue = value;
        trhkmaezndk = Optional.fromNullable(toCurrencyType(trhkmaezndkType))
            .transform(bizCurrencyTransformer(getTrhkmaezndkValue()))
            .orNull();
    }

    transient private String trhkmaezndkType = null;

    @Column(name=TRHKMAEZNDK + "$", nullable=true)
    protected String getTrhkmaezndkType() {
        if (trhkmaezndkType == null && trhkmaezndk != null) return trhkmaezndk.getType().toString();
        if (trhkmaezndkType == null && getTrhkmaezndkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'trhkmaezndk$' should not be NULL."));
        }
        return trhkmaezndkType;
    }

    protected void setTrhkmaezndkType(String type) {
        trhkmaezndkType = type;
        trhkmaezndk = Optional.fromNullable(toCurrencyType(trhkmaezndkType))
            .transform(bizCurrencyTransformer(getTrhkmaezndkValue()))
            .orNull();
    }

    private String syoukaino;

    @Column(name=GenIT_HrkmNyknDataHzn.SYOUKAINO)
    public String getSyoukaino() {
        return syoukaino;
    }

    public void setSyoukaino(String pSyoukaino) {
        syoukaino = pSyoukaino;
    }

    private BizDate knjyymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.KNJYYMD)
    public BizDate getKnjyymd() {
        return knjyymd;
    }

    public void setKnjyymd(BizDate pKnjyymd) {
        knjyymd = pKnjyymd;
    }

    private BizDate azkrhrdsymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.AZKRHRDSYMD)
    public BizDate getAzkrhrdsymd() {
        return azkrhrdsymd;
    }

    public void setAzkrhrdsymd(BizDate pAzkrhrdsymd) {
        azkrhrdsymd = pAzkrhrdsymd;
    }

    private Integer iribaraikbn;

    @Column(name=GenIT_HrkmNyknDataHzn.IRIBARAIKBN)
    public Integer getIribaraikbn() {
        return iribaraikbn;
    }

    public void setIribaraikbn(Integer pIribaraikbn) {
        iribaraikbn = pIribaraikbn;
    }

    private Integer trhkkbn;

    @Column(name=GenIT_HrkmNyknDataHzn.TRHKKBN)
    public Integer getTrhkkbn() {
        return trhkkbn;
    }

    public void setTrhkkbn(Integer pTrhkkbn) {
        trhkkbn = pTrhkkbn;
    }

    private BizCurrency trhkkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTrhkkgk() {
        return trhkkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrhkkgk(BizCurrency pTrhkkgk) {
        trhkkgk = pTrhkkgk;
        trhkkgkValue = null;
        trhkkgkType  = null;
    }

    transient private BigDecimal trhkkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TRHKKGK, nullable=true)
    protected BigDecimal getTrhkkgkValue() {
        if (trhkkgkValue == null && trhkkgk != null) {
            if (trhkkgk.isOptional()) return null;
            return trhkkgk.absolute();
        }
        return trhkkgkValue;
    }

    protected void setTrhkkgkValue(BigDecimal value) {
        trhkkgkValue = value;
        trhkkgk = Optional.fromNullable(toCurrencyType(trhkkgkType))
            .transform(bizCurrencyTransformer(getTrhkkgkValue()))
            .orNull();
    }

    transient private String trhkkgkType = null;

    @Column(name=TRHKKGK + "$", nullable=true)
    protected String getTrhkkgkType() {
        if (trhkkgkType == null && trhkkgk != null) return trhkkgk.getType().toString();
        if (trhkkgkType == null && getTrhkkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'trhkkgk$' should not be NULL."));
        }
        return trhkkgkType;
    }

    protected void setTrhkkgkType(String type) {
        trhkkgkType = type;
        trhkkgk = Optional.fromNullable(toCurrencyType(trhkkgkType))
            .transform(bizCurrencyTransformer(getTrhkkgkValue()))
            .orNull();
    }

    private BizCurrency tatenkengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTatenkengk() {
        return tatenkengk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTatenkengk(BizCurrency pTatenkengk) {
        tatenkengk = pTatenkengk;
        tatenkengkValue = null;
        tatenkengkType  = null;
    }

    transient private BigDecimal tatenkengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TATENKENGK, nullable=true)
    protected BigDecimal getTatenkengkValue() {
        if (tatenkengkValue == null && tatenkengk != null) {
            if (tatenkengk.isOptional()) return null;
            return tatenkengk.absolute();
        }
        return tatenkengkValue;
    }

    protected void setTatenkengkValue(BigDecimal value) {
        tatenkengkValue = value;
        tatenkengk = Optional.fromNullable(toCurrencyType(tatenkengkType))
            .transform(bizCurrencyTransformer(getTatenkengkValue()))
            .orNull();
    }

    transient private String tatenkengkType = null;

    @Column(name=TATENKENGK + "$", nullable=true)
    protected String getTatenkengkType() {
        if (tatenkengkType == null && tatenkengk != null) return tatenkengk.getType().toString();
        if (tatenkengkType == null && getTatenkengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tatenkengk$' should not be NULL."));
        }
        return tatenkengkType;
    }

    protected void setTatenkengkType(String type) {
        tatenkengkType = type;
        tatenkengk = Optional.fromNullable(toCurrencyType(tatenkengkType))
            .transform(bizCurrencyTransformer(getTatenkengkValue()))
            .orNull();
    }

    private BizDate kknteijiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.KKNTEIJIYMD)
    public BizDate getKknteijiymd() {
        return kknteijiymd;
    }

    public void setKknteijiymd(BizDate pKknteijiymd) {
        kknteijiymd = pKknteijiymd;
    }

    private BizDate hwtrhnknymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HrkmNyknDataHzn.HWTRHNKNYMD)
    public BizDate getHwtrhnknymd() {
        return hwtrhnknymd;
    }

    public void setHwtrhnknymd(BizDate pHwtrhnknymd) {
        hwtrhnknymd = pHwtrhnknymd;
    }

    private String tgtkgtkbn;

    @Column(name=GenIT_HrkmNyknDataHzn.TGTKGTKBN)
    public String getTgtkgtkbn() {
        return tgtkgtkbn;
    }

    public void setTgtkgtkbn(String pTgtkgtkbn) {
        tgtkgtkbn = pTgtkgtkbn;
    }

    private String tgtkgtno;

    @Column(name=GenIT_HrkmNyknDataHzn.TGTKGTNO)
    public String getTgtkgtno() {
        return tgtkgtno;
    }

    public void setTgtkgtno(String pTgtkgtno) {
        tgtkgtno = pTgtkgtno;
    }

    private String ryoutenno;

    @Column(name=GenIT_HrkmNyknDataHzn.RYOUTENNO)
    public String getRyoutenno() {
        return ryoutenno;
    }

    public void setRyoutenno(String pRyoutenno) {
        ryoutenno = pRyoutenno;
    }

    private String hrkmirnincd;

    @Column(name=GenIT_HrkmNyknDataHzn.HRKMIRNINCD)
    public String getHrkmirnincd() {
        return hrkmirnincd;
    }

    public void setHrkmirnincd(String pHrkmirnincd) {
        hrkmirnincd = pHrkmirnincd;
    }

    private String hrkmirninnm;

    @Column(name=GenIT_HrkmNyknDataHzn.HRKMIRNINNM)
    @MaxLength(max=96)
    @MultiByteStrings
    @InvalidCharacter
    public String getHrkmirninnm() {
        return hrkmirninnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHrkmirninnm(String pHrkmirninnm) {
        hrkmirninnm = pHrkmirninnm;
    }

    private String simukebanknmkn;

    @Column(name=GenIT_HrkmNyknDataHzn.SIMUKEBANKNMKN)
    public String getSimukebanknmkn() {
        return simukebanknmkn;
    }

    public void setSimukebanknmkn(String pSimukebanknmkn) {
        simukebanknmkn = pSimukebanknmkn;
    }

    private String simuketennmkn;

    @Column(name=GenIT_HrkmNyknDataHzn.SIMUKETENNMKN)
    public String getSimuketennmkn() {
        return simuketennmkn;
    }

    public void setSimuketennmkn(String pSimuketennmkn) {
        simuketennmkn = pSimuketennmkn;
    }

    private String tekiyounaiyou;

    @Column(name=GenIT_HrkmNyknDataHzn.TEKIYOUNAIYOU)
    public String getTekiyounaiyou() {
        return tekiyounaiyou;
    }

    public void setTekiyounaiyou(String pTekiyounaiyou) {
        tekiyounaiyou = pTekiyounaiyou;
    }

    private String ediinfo;

    @Column(name=GenIT_HrkmNyknDataHzn.EDIINFO)
    public String getEdiinfo() {
        return ediinfo;
    }

    public void setEdiinfo(String pEdiinfo) {
        ediinfo = pEdiinfo;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenIT_HrkmNyknDataHzn.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HrkmNyknDataHzn.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HrkmNyknDataHzn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HrkmNyknDataHzn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}