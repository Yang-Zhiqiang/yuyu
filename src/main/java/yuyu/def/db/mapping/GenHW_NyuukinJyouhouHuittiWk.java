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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_NyuukinHuittiriyuuKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.id.PKHW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.meta.GenQHW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.meta.QHW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_NyuukinHuittiriyuuKbn;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 入金情報不一致ワークテーブル テーブルのマッピング情報クラスで、 {@link HW_NyuukinJyouhouHuittiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_NyuukinJyouhouHuittiWk}</td><td colspan="3">入金情報不一致ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">{@link PKHW_NyuukinJyouhouHuittiWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">{@link PKHW_NyuukinJyouhouHuittiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirnincd hrkmirnincd}</td><td>振込依頼人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirninnm hrkmirninnm}</td><td>振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirninnm140 hrkmirninnm140}</td><td>振込依頼人名（１４０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrhkkgk trhkkgk}</td><td>取引金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getBanknmkn banknmkn}</td><td>銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkn sitennmkn}</td><td>支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimukebanknm simukebanknm}</td><td>仕向銀行名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSimuketennm simuketennm}</td><td>仕向店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikeijizenkizennouumu seikeijizenkizennouumu}</td><td>成契時全期前納有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNyuukinhuittiriyuukbn nyuukinhuittiriyuukbn}</td><td>入金不一致理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyuukinHuittiriyuuKbn}</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKnjyymd knjyymd}</td><td>勘定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn}</td><td>振込入金データ連携元区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>{@link #getOyadrtensyoritarget oyadrtensyoritarget}</td><td>親代理店処理対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyouKbn}</td></tr>
 *  <tr><td>{@link #getNyktyhyoutkbn nyktyhyoutkbn}</td><td>入金帳票出力先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_NyuukinJyouhouHuittiWk
 * @see     PKHW_NyuukinJyouhouHuittiWk
 * @see     QHW_NyuukinJyouhouHuittiWk
 * @see     GenQHW_NyuukinJyouhouHuittiWk
 */
@MappedSuperclass
@Table(name=GenHW_NyuukinJyouhouHuittiWk.TABLE_NAME)
@IdClass(value=PKHW_NyuukinJyouhouHuittiWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HrkmnykndatarenmotoKbn", typeClass=UserType_C_HrkmnykndatarenmotoKbn.class),
    @TypeDef(name="UserType_C_NyktyhyoutKbn", typeClass=UserType_C_NyktyhyoutKbn.class),
    @TypeDef(name="UserType_C_NyuukinHuittiriyuuKbn", typeClass=UserType_C_NyuukinHuittiriyuuKbn.class),
    @TypeDef(name="UserType_C_TaisyouKbn", typeClass=UserType_C_TaisyouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHW_NyuukinJyouhouHuittiWk extends AbstractExDBEntity<HW_NyuukinJyouhouHuittiWk, PKHW_NyuukinJyouhouHuittiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_NyuukinJyouhouHuittiWk";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String ITIRENNO                 = "itirenno";
    public static final String KOUZANO                  = "kouzano";
    public static final String HRKMIRNINCD              = "hrkmirnincd";
    public static final String HRKMIRNINNM              = "hrkmirninnm";
    public static final String HRKMIRNINNM140           = "hrkmirninnm140";
    public static final String TRHKKGK                  = "trhkkgk";
    public static final String RSTUUKASYU               = "rstuukasyu";
    public static final String BANKNMKN                 = "banknmkn";
    public static final String SITENNMKN                = "sitennmkn";
    public static final String SIMUKEBANKNM             = "simukebanknm";
    public static final String SIMUKETENNM              = "simuketennm";
    public static final String SEIKEIJIZENKIZENNOUUMU   = "seikeijizenkizennouumu";
    public static final String NYUUKINHUITTIRIYUUKBN    = "nyuukinhuittiriyuukbn";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String KNJYYMD                  = "knjyymd";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String HRKMNYKNDATARENMOTOKBN   = "hrkmnykndatarenmotoKbn";
    public static final String OYADRTENSYORITARGET      = "oyadrtensyoritarget";
    public static final String NYKTYHYOUTKBN            = "nyktyhyoutkbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHW_NyuukinJyouhouHuittiWk primaryKey;

    public GenHW_NyuukinJyouhouHuittiWk() {
        primaryKey = new PKHW_NyuukinJyouhouHuittiWk();
    }

    public GenHW_NyuukinJyouhouHuittiWk(BizDate pNyksyoriymd, String pItirenno) {
        primaryKey = new PKHW_NyuukinJyouhouHuittiWk(pNyksyoriymd, pItirenno);
    }

    @Transient
    @Override
    public PKHW_NyuukinJyouhouHuittiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_NyuukinJyouhouHuittiWk> getMetaClass() {
        return QHW_NyuukinJyouhouHuittiWk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return getPrimaryKey().getNyksyoriymd();
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        getPrimaryKey().setNyksyoriymd(pNyksyoriymd);
    }

    @Id
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.ITIRENNO)
    public String getItirenno() {
        return getPrimaryKey().getItirenno();
    }

    public void setItirenno(String pItirenno) {
        getPrimaryKey().setItirenno(pItirenno);
    }

    private String kouzano;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.KOUZANO)
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

    private String hrkmirnincd;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.HRKMIRNINCD)
    public String getHrkmirnincd() {
        return hrkmirnincd;
    }

    public void setHrkmirnincd(String pHrkmirnincd) {
        hrkmirnincd = pHrkmirnincd;
    }

    private String hrkmirninnm;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.HRKMIRNINNM)
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

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.HRKMIRNINNM140)
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

    private C_Tuukasyu rstuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.RSTUUKASYU)
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    private String banknmkn;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.BANKNMKN)
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

    private String sitennmkn;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.SITENNMKN)
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

    private String simukebanknm;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.SIMUKEBANKNM)
    public String getSimukebanknm() {
        return simukebanknm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSimukebanknm(String pSimukebanknm) {
        simukebanknm = pSimukebanknm;
    }

    private String simuketennm;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.SIMUKETENNM)
    public String getSimuketennm() {
        return simuketennm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSimuketennm(String pSimuketennm) {
        simuketennm = pSimuketennm;
    }

    private C_UmuKbn seikeijizenkizennouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.SEIKEIJIZENKIZENNOUUMU)
    public C_UmuKbn getSeikeijizenkizennouumu() {
        return seikeijizenkizennouumu;
    }

    public void setSeikeijizenkizennouumu(C_UmuKbn pSeikeijizenkizennouumu) {
        seikeijizenkizennouumu = pSeikeijizenkizennouumu;
    }

    private C_NyuukinHuittiriyuuKbn nyuukinhuittiriyuukbn;

    @Type(type="UserType_C_NyuukinHuittiriyuuKbn")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.NYUUKINHUITTIRIYUUKBN)
    public C_NyuukinHuittiriyuuKbn getNyuukinhuittiriyuukbn() {
        return nyuukinhuittiriyuukbn;
    }

    public void setNyuukinhuittiriyuukbn(C_NyuukinHuittiriyuuKbn pNyuukinhuittiriyuukbn) {
        nyuukinhuittiriyuukbn = pNyuukinhuittiriyuukbn;
    }

    private String oyadrtencd;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.OYADRTENCD)
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

    private BizDate knjyymd;

    @Type(type="BizDateType")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.KNJYYMD)
    public BizDate getKnjyymd() {
        return knjyymd;
    }

    public void setKnjyymd(BizDate pKnjyymd) {
        knjyymd = pKnjyymd;
    }

    private String nykmosno;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_HrkmnykndatarenmotoKbn hrkmnykndatarenmotoKbn;

    @Type(type="UserType_C_HrkmnykndatarenmotoKbn")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.HRKMNYKNDATARENMOTOKBN)
    public C_HrkmnykndatarenmotoKbn getHrkmnykndatarenmotoKbn() {
        return hrkmnykndatarenmotoKbn;
    }

    public void setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn pHrkmnykndatarenmotoKbn) {
        hrkmnykndatarenmotoKbn = pHrkmnykndatarenmotoKbn;
    }

    private C_TaisyouKbn oyadrtensyoritarget;

    @Type(type="UserType_C_TaisyouKbn")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.OYADRTENSYORITARGET)
    public C_TaisyouKbn getOyadrtensyoritarget() {
        return oyadrtensyoritarget;
    }

    public void setOyadrtensyoritarget(C_TaisyouKbn pOyadrtensyoritarget) {
        oyadrtensyoritarget = pOyadrtensyoritarget;
    }

    private C_NyktyhyoutKbn nyktyhyoutkbn;

    @Type(type="UserType_C_NyktyhyoutKbn")
    @Column(name=GenHW_NyuukinJyouhouHuittiWk.NYKTYHYOUTKBN)
    public C_NyktyhyoutKbn getNyktyhyoutkbn() {
        return nyktyhyoutkbn;
    }

    public void setNyktyhyoutkbn(C_NyktyhyoutKbn pNyktyhyoutkbn) {
        nyktyhyoutkbn = pNyktyhyoutkbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHW_NyuukinJyouhouHuittiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}