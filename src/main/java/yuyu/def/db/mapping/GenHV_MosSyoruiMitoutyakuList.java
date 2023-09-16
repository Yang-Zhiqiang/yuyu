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
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.db.id.PKHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.GenQHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.QHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 申込書類未到着リスト情報ビュー テーブルのマッピング情報クラスで、 {@link HV_MosSyoruiMitoutyakuList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HV_MosSyoruiMitoutyakuList}</td><td colspan="3">申込書類未到着リスト情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHV_MosSyoruiMitoutyakuList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">{@link PKHV_MosSyoruiMitoutyakuList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimukebanknmkn simukebanknmkn}</td><td>仕向銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimukebanknmeiji simukebanknmeiji}</td><td>仕向銀行名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimuketennmkn simuketennmkn}</td><td>仕向店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimuketennmeiji simuketennmeiji}</td><td>仕向店名（英字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKnjyymd knjyymd}</td><td>勘定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrhkkgk trhkkgk}</td><td>取引金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDengk dengk}</td><td>伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrkmirninnm hrkmirninnm}</td><td>振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinoyadrtennm nyuukinoyadrtennm}</td><td>入金用親代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMostokusokuumu mostokusokuumu}</td><td>申込書類督促有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSiteituuka siteituuka}</td><td>指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn}</td><td>振込入金データ連携元区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnno syouhnno}</td><td>商品番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyktyhyoutkbn nyktyhyoutkbn}</td><td>入金帳票出力先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyktyhyoutKbn}</td></tr>
 * </table>
 * @see     HV_MosSyoruiMitoutyakuList
 * @see     PKHV_MosSyoruiMitoutyakuList
 * @see     QHV_MosSyoruiMitoutyakuList
 * @see     GenQHV_MosSyoruiMitoutyakuList
 */
@MappedSuperclass
@Table(name=GenHV_MosSyoruiMitoutyakuList.TABLE_NAME)
@IdClass(value=PKHV_MosSyoruiMitoutyakuList.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HrkmnykndatarenmotoKbn", typeClass=UserType_C_HrkmnykndatarenmotoKbn.class),
    @TypeDef(name="UserType_C_NyktyhyoutKbn", typeClass=UserType_C_NyktyhyoutKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHV_MosSyoruiMitoutyakuList extends AbstractExDBEntity<HV_MosSyoruiMitoutyakuList, PKHV_MosSyoruiMitoutyakuList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HV_MosSyoruiMitoutyakuList";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String ITIRENNO                 = "itirenno";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String SIMUKEBANKNMKN           = "simukebanknmkn";
    public static final String SIMUKEBANKNMEIJI         = "simukebanknmeiji";
    public static final String SIMUKETENNMKN            = "simuketennmkn";
    public static final String SIMUKETENNMEIJI          = "simuketennmeiji";
    public static final String KNJYYMD                  = "knjyymd";
    public static final String TRHKKGK                  = "trhkkgk";
    public static final String DENGK                    = "dengk";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String HRKMIRNINNM              = "hrkmirninnm";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String NYUUKINOYADRTENNM        = "nyuukinoyadrtennm";
    public static final String MOSTOKUSOKUUMU           = "mostokusokuumu";
    public static final String SITEITUUKA               = "siteituuka";
    public static final String HRKMNYKNDATARENMOTOKBN   = "hrkmnykndatarenmotoKbn";
    public static final String SYOUHNNO                 = "syouhnno";
    public static final String NYKTYHYOUTKBN            = "nyktyhyoutkbn";

    private final PKHV_MosSyoruiMitoutyakuList primaryKey;

    public GenHV_MosSyoruiMitoutyakuList() {
        primaryKey = new PKHV_MosSyoruiMitoutyakuList();
    }

    public GenHV_MosSyoruiMitoutyakuList(BizDate pSyoriYmd, String pItirenno) {
        primaryKey = new PKHV_MosSyoruiMitoutyakuList(pSyoriYmd, pItirenno);
    }

    @Transient
    @Override
    public PKHV_MosSyoruiMitoutyakuList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHV_MosSyoruiMitoutyakuList> getMetaClass() {
        return QHV_MosSyoruiMitoutyakuList.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHV_MosSyoruiMitoutyakuList.SYORIYMD)
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
    @Column(name=GenHV_MosSyoruiMitoutyakuList.ITIRENNO)
    public String getItirenno() {
        return getPrimaryKey().getItirenno();
    }

    public void setItirenno(String pItirenno) {
        getPrimaryKey().setItirenno(pItirenno);
    }

    private String nykmosno;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private String bankcd;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.BANKCD)
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

    private String sitencd;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.SITENCD)
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

    private String simukebanknmkn;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.SIMUKEBANKNMKN)
    public String getSimukebanknmkn() {
        return simukebanknmkn;
    }

    public void setSimukebanknmkn(String pSimukebanknmkn) {
        simukebanknmkn = pSimukebanknmkn;
    }

    private String simukebanknmeiji;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.SIMUKEBANKNMEIJI)
    public String getSimukebanknmeiji() {
        return simukebanknmeiji;
    }

    public void setSimukebanknmeiji(String pSimukebanknmeiji) {
        simukebanknmeiji = pSimukebanknmeiji;
    }

    private String simuketennmkn;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.SIMUKETENNMKN)
    public String getSimuketennmkn() {
        return simuketennmkn;
    }

    public void setSimuketennmkn(String pSimuketennmkn) {
        simuketennmkn = pSimuketennmkn;
    }

    private String simuketennmeiji;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.SIMUKETENNMEIJI)
    public String getSimuketennmeiji() {
        return simuketennmeiji;
    }

    public void setSimuketennmeiji(String pSimuketennmeiji) {
        simuketennmeiji = pSimuketennmeiji;
    }

    private BizDate knjyymd;

    @Type(type="BizDateType")
    @Column(name=GenHV_MosSyoruiMitoutyakuList.KNJYYMD)
    public BizDate getKnjyymd() {
        return knjyymd;
    }

    public void setKnjyymd(BizDate pKnjyymd) {
        knjyymd = pKnjyymd;
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
    @Column(name=GenHV_MosSyoruiMitoutyakuList.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private String hrkmirninnm;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.HRKMIRNINNM)
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

    private String oyadrtencd;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.OYADRTENCD)
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

    private String nyuukinoyadrtennm;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.NYUUKINOYADRTENNM)
    public String getNyuukinoyadrtennm() {
        return nyuukinoyadrtennm;
    }

    public void setNyuukinoyadrtennm(String pNyuukinoyadrtennm) {
        nyuukinoyadrtennm = pNyuukinoyadrtennm;
    }

    private C_UmuKbn mostokusokuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHV_MosSyoruiMitoutyakuList.MOSTOKUSOKUUMU)
    public C_UmuKbn getMostokusokuumu() {
        return mostokusokuumu;
    }

    public void setMostokusokuumu(C_UmuKbn pMostokusokuumu) {
        mostokusokuumu = pMostokusokuumu;
    }

    private C_Tuukasyu siteituuka;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHV_MosSyoruiMitoutyakuList.SITEITUUKA)
    public C_Tuukasyu getSiteituuka() {
        return siteituuka;
    }

    public void setSiteituuka(C_Tuukasyu pSiteituuka) {
        siteituuka = pSiteituuka;
    }

    private C_HrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn;

    @Type(type="UserType_C_HrkmnykndatarenmotoKbn")
    @Column(name=GenHV_MosSyoruiMitoutyakuList.HRKMNYKNDATARENMOTOKBN)
    public C_HrkmnykndatarenmotoKbn getHrkmnykndatarenmotoKbn() {
        return hrkmnykndatarenmotoKbn;
    }

    public void setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn pHrkmnykndatarenmotoKbn) {
        hrkmnykndatarenmotoKbn = pHrkmnykndatarenmotoKbn;
    }

    private String syouhnno;

    @Column(name=GenHV_MosSyoruiMitoutyakuList.SYOUHNNO)
    public String getSyouhnno() {
        return syouhnno;
    }

    public void setSyouhnno(String pSyouhnno) {
        syouhnno = pSyouhnno;
    }

    private C_NyktyhyoutKbn nyktyhyoutkbn;

    @Type(type="UserType_C_NyktyhyoutKbn")
    @Column(name=GenHV_MosSyoruiMitoutyakuList.NYKTYHYOUTKBN)
    public C_NyktyhyoutKbn getNyktyhyoutkbn() {
        return nyktyhyoutkbn;
    }

    public void setNyktyhyoutkbn(C_NyktyhyoutKbn pNyktyhyoutkbn) {
        nyktyhyoutkbn = pNyktyhyoutkbn;
    }
}