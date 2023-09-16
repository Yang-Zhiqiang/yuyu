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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.id.PKHT_GaikaHrkmNyknData;
import yuyu.def.db.meta.GenQHT_GaikaHrkmNyknData;
import yuyu.def.db.meta.QHT_GaikaHrkmNyknData;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 外貨振込入金データテーブル テーブルのマッピング情報クラスで、 {@link HT_GaikaHrkmNyknData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GaikaHrkmNyknData}</td><td colspan="3">外貨振込入金データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">{@link PKHT_GaikaHrkmNyknData ○}</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_GaikaHrkmNyknData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">{@link PKHT_GaikaHrkmNyknData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnno syouhnno}</td><td>商品番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getTrhkmaezndk trhkmaezndk}</td><td>取引前残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTrhksakisyoukaino trhksakisyoukaino}</td><td>取引先照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKnjyymd knjyymd}</td><td>勘定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKsnymd ksnymd}</td><td>起算日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIribaraikbn iribaraikbn}</td><td>入払区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrhkkbn trhkkbn}</td><td>取引区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrhkkgk trhkkgk}</td><td>取引金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDengk dengk}</td><td>伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrkmirninnm hrkmirninnm}</td><td>振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirninnm140 hrkmirninnm140}</td><td>振込依頼人名（１４０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimukebanknmeiji simukebanknmeiji}</td><td>仕向銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimuketennmeiji simuketennmeiji}</td><td>仕向店名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyounaiyoueiji tekiyounaiyoueiji}</td><td>摘要内容（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtensyoritarget oyadrtensyoritarget}</td><td>親代理店処理対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyouKbn}</td></tr>
 *  <tr><td>{@link #getJidonykntargethyouji jidonykntargethyouji}</td><td>自動入金対象表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyouKbn}</td></tr>
 *  <tr><td>{@link #getMostokusokuumu mostokusokuumu}</td><td>申込書類督促有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getHrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn}</td><td>振込入金データ連携元区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>{@link #getNyuukinoyadrtennm nyuukinoyadrtennm}</td><td>入金用親代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiteituuka siteituuka}</td><td>指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHonkouzacd honkouzacd}</td><td>本口座コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GaikaHrkmNyknData
 * @see     PKHT_GaikaHrkmNyknData
 * @see     QHT_GaikaHrkmNyknData
 * @see     GenQHT_GaikaHrkmNyknData
 */
@MappedSuperclass
@Table(name=GenHT_GaikaHrkmNyknData.TABLE_NAME)
@IdClass(value=PKHT_GaikaHrkmNyknData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_HrkmnykndatarenmotoKbn", typeClass=UserType_C_HrkmnykndatarenmotoKbn.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class),
    @TypeDef(name="UserType_C_TaisyouKbn", typeClass=UserType_C_TaisyouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHT_GaikaHrkmNyknData extends AbstractExDBEntity<HT_GaikaHrkmNyknData, PKHT_GaikaHrkmNyknData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_GaikaHrkmNyknData";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String ITIRENNO                 = "itirenno";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String SYOUHNNO                 = "syouhnno";
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
    public static final String TRHKMAEZNDK              = "trhkmaezndk";
    public static final String TRHKSAKISYOUKAINO        = "trhksakisyoukaino";
    public static final String KNJYYMD                  = "knjyymd";
    public static final String KSNYMD                   = "ksnymd";
    public static final String IRIBARAIKBN              = "iribaraikbn";
    public static final String TRHKKBN                  = "trhkkbn";
    public static final String TRHKKGK                  = "trhkkgk";
    public static final String DENGK                    = "dengk";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String HRKMIRNINNM              = "hrkmirninnm";
    public static final String HRKMIRNINNM140           = "hrkmirninnm140";
    public static final String SIMUKEBANKNMEIJI         = "simukebanknmeiji";
    public static final String SIMUKETENNMEIJI          = "simuketennmeiji";
    public static final String TEKIYOUNAIYOUEIJI        = "tekiyounaiyoueiji";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String OYADRTENSYORITARGET      = "oyadrtensyoritarget";
    public static final String JIDONYKNTARGETHYOUJI     = "jidonykntargethyouji";
    public static final String MOSTOKUSOKUUMU           = "mostokusokuumu";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String HRKMNYKNDATARENMOTOKBN   = "hrkmnykndatarenmotoKbn";
    public static final String NYUUKINOYADRTENNM        = "nyuukinoyadrtennm";
    public static final String SITEITUUKA               = "siteituuka";
    public static final String HONKOUZACD               = "honkouzacd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_GaikaHrkmNyknData primaryKey;

    public GenHT_GaikaHrkmNyknData() {
        primaryKey = new PKHT_GaikaHrkmNyknData();
    }

    public GenHT_GaikaHrkmNyknData(
        C_DensysKbn pDensyskbn,
        BizDate pSyoriYmd,
        String pItirenno
    ) {
        primaryKey = new PKHT_GaikaHrkmNyknData(
            pDensyskbn,
            pSyoriYmd,
            pItirenno
        );
    }

    @Transient
    @Override
    public PKHT_GaikaHrkmNyknData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_GaikaHrkmNyknData> getMetaClass() {
        return QHT_GaikaHrkmNyknData.class;
    }

    @Id
    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenHT_GaikaHrkmNyknData.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return getPrimaryKey().getDensyskbn();
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        getPrimaryKey().setDensyskbn(pDensyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_GaikaHrkmNyknData.SYORIYMD)
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
    @Column(name=GenHT_GaikaHrkmNyknData.ITIRENNO)
    public String getItirenno() {
        return getPrimaryKey().getItirenno();
    }

    public void setItirenno(String pItirenno) {
        getPrimaryKey().setItirenno(pItirenno);
    }

    private String nykmosno;

    @Column(name=GenHT_GaikaHrkmNyknData.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private String syouhnno;

    @Column(name=GenHT_GaikaHrkmNyknData.SYOUHNNO)
    public String getSyouhnno() {
        return syouhnno;
    }

    public void setSyouhnno(String pSyouhnno) {
        syouhnno = pSyouhnno;
    }

    private Integer syubetucd;

    @Column(name=GenHT_GaikaHrkmNyknData.SYUBETUCD)
    public Integer getSyubetucd() {
        return syubetucd;
    }

    public void setSyubetucd(Integer pSyubetucd) {
        syubetucd = pSyubetucd;
    }

    private Integer cdkbn;

    @Column(name=GenHT_GaikaHrkmNyknData.CDKBN)
    public Integer getCdkbn() {
        return cdkbn;
    }

    public void setCdkbn(Integer pCdkbn) {
        cdkbn = pCdkbn;
    }

    private BizDate sakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_GaikaHrkmNyknData.SAKUSEIYMD)
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
    @Column(name=GenHT_GaikaHrkmNyknData.KNJYYMDFROM)
    public BizDate getKnjyymdfrom() {
        return knjyymdfrom;
    }

    public void setKnjyymdfrom(BizDate pKnjyymdfrom) {
        knjyymdfrom = pKnjyymdfrom;
    }

    private BizDate knjyymdto;

    @Type(type="BizDateType")
    @Column(name=GenHT_GaikaHrkmNyknData.KNJYYMDTO)
    public BizDate getKnjyymdto() {
        return knjyymdto;
    }

    public void setKnjyymdto(BizDate pKnjyymdto) {
        knjyymdto = pKnjyymdto;
    }

    private String bankcd;

    @Column(name=GenHT_GaikaHrkmNyknData.BANKCD)
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

    @Column(name=GenHT_GaikaHrkmNyknData.BANKNMKN)
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

    @Column(name=GenHT_GaikaHrkmNyknData.SITENCD)
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

    @Column(name=GenHT_GaikaHrkmNyknData.SITENNMKN)
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
    @Column(name=GenHT_GaikaHrkmNyknData.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenHT_GaikaHrkmNyknData.KOUZANO)
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

    @Column(name=GenHT_GaikaHrkmNyknData.KZNMKN)
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

    @Column(name=GenHT_GaikaHrkmNyknData.KASIKOSIKBN)
    public Integer getKasikosikbn() {
        return kasikosikbn;
    }

    public void setKasikosikbn(Integer pKasikosikbn) {
        kasikosikbn = pKasikosikbn;
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

    private String trhksakisyoukaino;

    @Column(name=GenHT_GaikaHrkmNyknData.TRHKSAKISYOUKAINO)
    public String getTrhksakisyoukaino() {
        return trhksakisyoukaino;
    }

    public void setTrhksakisyoukaino(String pTrhksakisyoukaino) {
        trhksakisyoukaino = pTrhksakisyoukaino;
    }

    private BizDate knjyymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_GaikaHrkmNyknData.KNJYYMD)
    public BizDate getKnjyymd() {
        return knjyymd;
    }

    public void setKnjyymd(BizDate pKnjyymd) {
        knjyymd = pKnjyymd;
    }

    private BizDate ksnymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_GaikaHrkmNyknData.KSNYMD)
    public BizDate getKsnymd() {
        return ksnymd;
    }

    public void setKsnymd(BizDate pKsnymd) {
        ksnymd = pKsnymd;
    }

    private Integer iribaraikbn;

    @Column(name=GenHT_GaikaHrkmNyknData.IRIBARAIKBN)
    public Integer getIribaraikbn() {
        return iribaraikbn;
    }

    public void setIribaraikbn(Integer pIribaraikbn) {
        iribaraikbn = pIribaraikbn;
    }

    private Integer trhkkbn;

    @Column(name=GenHT_GaikaHrkmNyknData.TRHKKBN)
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

    private BizCurrency dengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDengk() {
        return dengk;
    }

    public void setDengk(BizCurrency pDengk) {
        dengk = pDengk;
        dengkValue = null;
        dengkType  = null;
    }

    transient private BigDecimal dengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENGK, nullable=true)
    protected BigDecimal getDengkValue() {
        if (dengkValue == null && dengk != null) {
            if (dengk.isOptional()) return null;
            return dengk.absolute();
        }
        return dengkValue;
    }

    protected void setDengkValue(BigDecimal value) {
        dengkValue = value;
        dengk = Optional.fromNullable(toCurrencyType(dengkType))
            .transform(bizCurrencyTransformer(getDengkValue()))
            .orNull();
    }

    transient private String dengkType = null;

    @Column(name=DENGK + "$", nullable=true)
    protected String getDengkType() {
        if (dengkType == null && dengk != null) return dengk.getType().toString();
        if (dengkType == null && getDengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dengk$' should not be NULL."));
        }
        return dengkType;
    }

    protected void setDengkType(String type) {
        dengkType = type;
        dengk = Optional.fromNullable(toCurrencyType(dengkType))
            .transform(bizCurrencyTransformer(getDengkValue()))
            .orNull();
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_GaikaHrkmNyknData.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private String hrkmirninnm;

    @Column(name=GenHT_GaikaHrkmNyknData.HRKMIRNINNM)
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

    private String hrkmirninnm140;

    @Column(name=GenHT_GaikaHrkmNyknData.HRKMIRNINNM140)
    @MaxLength(max=140)
    @MultiByteStrings
    @InvalidCharacter
    public String getHrkmirninnm140() {
        return hrkmirninnm140;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHrkmirninnm140(String pHrkmirninnm140) {
        hrkmirninnm140 = pHrkmirninnm140;
    }

    private String simukebanknmeiji;

    @Column(name=GenHT_GaikaHrkmNyknData.SIMUKEBANKNMEIJI)
    public String getSimukebanknmeiji() {
        return simukebanknmeiji;
    }

    public void setSimukebanknmeiji(String pSimukebanknmeiji) {
        simukebanknmeiji = pSimukebanknmeiji;
    }

    private String simuketennmeiji;

    @Column(name=GenHT_GaikaHrkmNyknData.SIMUKETENNMEIJI)
    public String getSimuketennmeiji() {
        return simuketennmeiji;
    }

    public void setSimuketennmeiji(String pSimuketennmeiji) {
        simuketennmeiji = pSimuketennmeiji;
    }

    private String tekiyounaiyoueiji;

    @Column(name=GenHT_GaikaHrkmNyknData.TEKIYOUNAIYOUEIJI)
    public String getTekiyounaiyoueiji() {
        return tekiyounaiyoueiji;
    }

    public void setTekiyounaiyoueiji(String pTekiyounaiyoueiji) {
        tekiyounaiyoueiji = pTekiyounaiyoueiji;
    }

    private String oyadrtencd;

    @Column(name=GenHT_GaikaHrkmNyknData.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private C_TaisyouKbn oyadrtensyoritarget;

    @Type(type="UserType_C_TaisyouKbn")
    @Column(name=GenHT_GaikaHrkmNyknData.OYADRTENSYORITARGET)
    public C_TaisyouKbn getOyadrtensyoritarget() {
        return oyadrtensyoritarget;
    }

    public void setOyadrtensyoritarget(C_TaisyouKbn pOyadrtensyoritarget) {
        oyadrtensyoritarget = pOyadrtensyoritarget;
    }

    private C_TaisyouKbn jidonykntargethyouji;

    @Type(type="UserType_C_TaisyouKbn")
    @Column(name=GenHT_GaikaHrkmNyknData.JIDONYKNTARGETHYOUJI)
    public C_TaisyouKbn getJidonykntargethyouji() {
        return jidonykntargethyouji;
    }

    public void setJidonykntargethyouji(C_TaisyouKbn pJidonykntargethyouji) {
        jidonykntargethyouji = pJidonykntargethyouji;
    }

    private C_UmuKbn mostokusokuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_GaikaHrkmNyknData.MOSTOKUSOKUUMU)
    public C_UmuKbn getMostokusokuumu() {
        return mostokusokuumu;
    }

    public void setMostokusokuumu(C_UmuKbn pMostokusokuumu) {
        mostokusokuumu = pMostokusokuumu;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenHT_GaikaHrkmNyknData.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private C_HrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn;

    @Type(type="UserType_C_HrkmnykndatarenmotoKbn")
    @Column(name=GenHT_GaikaHrkmNyknData.HRKMNYKNDATARENMOTOKBN)
    public C_HrkmnykndatarenmotoKbn getHrkmnykndatarenmotoKbn() {
        return hrkmnykndatarenmotoKbn;
    }

    public void setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn pHrkmnykndatarenmotoKbn) {
        hrkmnykndatarenmotoKbn = pHrkmnykndatarenmotoKbn;
    }

    private String nyuukinoyadrtennm;

    @Column(name=GenHT_GaikaHrkmNyknData.NYUUKINOYADRTENNM)
    public String getNyuukinoyadrtennm() {
        return nyuukinoyadrtennm;
    }

    public void setNyuukinoyadrtennm(String pNyuukinoyadrtennm) {
        nyuukinoyadrtennm = pNyuukinoyadrtennm;
    }

    private C_Tuukasyu siteituuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_GaikaHrkmNyknData.SITEITUUKA)
    public C_Tuukasyu getSiteituuka() {
        return siteituuka;
    }

    public void setSiteituuka(C_Tuukasyu pSiteituuka) {
        siteituuka = pSiteituuka;
    }

    private String honkouzacd;

    @Column(name=GenHT_GaikaHrkmNyknData.HONKOUZACD)
    public String getHonkouzacd() {
        return honkouzacd;
    }

    public void setHonkouzacd(String pHonkouzacd) {
        honkouzacd = pHonkouzacd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_GaikaHrkmNyknData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_GaikaHrkmNyknData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_GaikaHrkmNyknData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}