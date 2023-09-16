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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.id.PKSV_SibourituRendou;
import yuyu.def.db.meta.GenQSV_SibourituRendou;
import yuyu.def.db.meta.QSV_SibourituRendou;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡率用連動情報ビュー テーブルのマッピング情報クラスで、 {@link SV_SibourituRendou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SibourituRendou}</td><td colspan="3">死亡率用連動情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKSV_SibourituRendou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnensyuukbn hhknnensyuukbn}</td><td>被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getPharaikomisougaku pharaikomisougaku}</td><td>保険料払込総額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSintyou sintyou}</td><td>身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaijyuu taijyuu}</td><td>体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari bunwari}</td><td>分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKykkaksyrui kykkaksyrui}</td><td>契約確認種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykkaksyrui}</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd1 ketriyuucd1}</td><td>決定理由コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd2 ketriyuucd2}</td><td>決定理由コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd3 ketriyuucd3}</td><td>決定理由コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd4 ketriyuucd4}</td><td>決定理由コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntodouhukencd hhkntodouhukencd}</td><td>被保険者都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     SV_SibourituRendou
 * @see     PKSV_SibourituRendou
 * @see     QSV_SibourituRendou
 * @see     GenQSV_SibourituRendou
 */
@MappedSuperclass
@Table(name=GenSV_SibourituRendou.TABLE_NAME)
@IdClass(value=PKSV_SibourituRendou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Ketriyuucd", typeClass=UserType_C_Ketriyuucd.class),
    @TypeDef(name="UserType_C_Kykkaksyrui", typeClass=UserType_C_Kykkaksyrui.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_SibourituRendou extends AbstractExDBEntity<SV_SibourituRendou, PKSV_SibourituRendou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_SibourituRendou";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String HHKNNENSYUUKBN           = "hhknnensyuukbn";
    public static final String PHARAIKOMISOUGAKU        = "pharaikomisougaku";
    public static final String SINTYOU                  = "sintyou";
    public static final String TAIJYUU                  = "taijyuu";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String BUNWARI                  = "bunwari";
    public static final String KYKKAKSYRUI              = "kykkaksyrui";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String KETRIYUUCD1              = "ketriyuucd1";
    public static final String KETRIYUUCD2              = "ketriyuucd2";
    public static final String KETRIYUUCD3              = "ketriyuucd3";
    public static final String KETRIYUUCD4              = "ketriyuucd4";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String HHKNTODOUHUKENCD         = "hhkntodouhukencd";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";

    private final PKSV_SibourituRendou primaryKey;

    public GenSV_SibourituRendou() {
        primaryKey = new PKSV_SibourituRendou();
    }

    public GenSV_SibourituRendou(String pMosno) {
        primaryKey = new PKSV_SibourituRendou(pMosno);
    }

    @Transient
    @Override
    public PKSV_SibourituRendou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_SibourituRendou> getMetaClass() {
        return QSV_SibourituRendou.class;
    }

    @Id
    @Column(name=GenSV_SibourituRendou.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String syono;

    @Column(name=GenSV_SibourituRendou.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenSV_SibourituRendou.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SibourituRendou.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SibourituRendou.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SibourituRendou.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenSV_SibourituRendou.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenSV_SibourituRendou.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_SibourituRendou.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_SibourituRendou.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_SibourituRendou.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SibourituRendou.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private Integer hhknnen;

    @Column(name=GenSV_SibourituRendou.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenSV_SibourituRendou.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknsykgycd;

    @Column(name=GenSV_SibourituRendou.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenSV_SibourituRendou.HHKNNENSYUUKBN)
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private BizCurrency pharaikomisougaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPharaikomisougaku() {
        return pharaikomisougaku;
    }

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku) {
        pharaikomisougaku = pPharaikomisougaku;
        pharaikomisougakuValue = null;
        pharaikomisougakuType  = null;
    }

    transient private BigDecimal pharaikomisougakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PHARAIKOMISOUGAKU, nullable=true)
    protected BigDecimal getPharaikomisougakuValue() {
        if (pharaikomisougakuValue == null && pharaikomisougaku != null) {
            if (pharaikomisougaku.isOptional()) return null;
            return pharaikomisougaku.absolute();
        }
        return pharaikomisougakuValue;
    }

    protected void setPharaikomisougakuValue(BigDecimal value) {
        pharaikomisougakuValue = value;
        pharaikomisougaku = Optional.fromNullable(toCurrencyType(pharaikomisougakuType))
            .transform(bizCurrencyTransformer(getPharaikomisougakuValue()))
            .orNull();
    }

    transient private String pharaikomisougakuType = null;

    @Column(name=PHARAIKOMISOUGAKU + "$", nullable=true)
    protected String getPharaikomisougakuType() {
        if (pharaikomisougakuType == null && pharaikomisougaku != null) return pharaikomisougaku.getType().toString();
        if (pharaikomisougakuType == null && getPharaikomisougakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'pharaikomisougaku$' should not be NULL."));
        }
        return pharaikomisougakuType;
    }

    protected void setPharaikomisougakuType(String type) {
        pharaikomisougakuType = type;
        pharaikomisougaku = Optional.fromNullable(toCurrencyType(pharaikomisougakuType))
            .transform(bizCurrencyTransformer(getPharaikomisougakuValue()))
            .orNull();
    }

    private Integer sintyou;

    @Column(name=GenSV_SibourituRendou.SINTYOU)
    @Range(min="0", max="999")
    public Integer getSintyou() {
        return sintyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSintyou(Integer pSintyou) {
        sintyou = pSintyou;
    }

    private Integer taijyuu;

    @Column(name=GenSV_SibourituRendou.TAIJYUU)
    @Range(min="0", max="999")
    public Integer getTaijyuu() {
        return taijyuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaijyuu(Integer pTaijyuu) {
        taijyuu = pTaijyuu;
    }

    private String oyadrtencd;

    @Column(name=GenSV_SibourituRendou.OYADRTENCD)
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

    private String tratkiagcd;

    @Column(name=GenSV_SibourituRendou.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_SibourituRendou.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenSV_SibourituRendou.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private BizNumber bunwari;

    @Type(type="BizNumberType")
    @Column(name=GenSV_SibourituRendou.BUNWARI)
    @RangeBizCalcable(min="0", max="100")
    public BizNumber getBunwari() {
        return bunwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBunwari(BizNumber pBunwari) {
        bunwari = pBunwari;
    }

    private C_Kykkaksyrui kykkaksyrui;

    @Type(type="UserType_C_Kykkaksyrui")
    @Column(name=GenSV_SibourituRendou.KYKKAKSYRUI)
    public C_Kykkaksyrui getKykkaksyrui() {
        return kykkaksyrui;
    }

    public void setKykkaksyrui(C_Kykkaksyrui pKykkaksyrui) {
        kykkaksyrui = pKykkaksyrui;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenSV_SibourituRendou.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private C_Ketriyuucd ketriyuucd1;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenSV_SibourituRendou.KETRIYUUCD1)
    public C_Ketriyuucd getKetriyuucd1() {
        return ketriyuucd1;
    }

    public void setKetriyuucd1(C_Ketriyuucd pKetriyuucd1) {
        ketriyuucd1 = pKetriyuucd1;
    }

    private C_Ketriyuucd ketriyuucd2;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenSV_SibourituRendou.KETRIYUUCD2)
    public C_Ketriyuucd getKetriyuucd2() {
        return ketriyuucd2;
    }

    public void setKetriyuucd2(C_Ketriyuucd pKetriyuucd2) {
        ketriyuucd2 = pKetriyuucd2;
    }

    private C_Ketriyuucd ketriyuucd3;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenSV_SibourituRendou.KETRIYUUCD3)
    public C_Ketriyuucd getKetriyuucd3() {
        return ketriyuucd3;
    }

    public void setKetriyuucd3(C_Ketriyuucd pKetriyuucd3) {
        ketriyuucd3 = pKetriyuucd3;
    }

    private C_Ketriyuucd ketriyuucd4;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenSV_SibourituRendou.KETRIYUUCD4)
    public C_Ketriyuucd getKetriyuucd4() {
        return ketriyuucd4;
    }

    public void setKetriyuucd4(C_Ketriyuucd pKetriyuucd4) {
        ketriyuucd4 = pKetriyuucd4;
    }

    private String palketsyacd;

    @Column(name=GenSV_SibourituRendou.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private String hhkntodouhukencd;

    @Column(name=GenSV_SibourituRendou.HHKNTODOUHUKENCD)
    public String getHhkntodouhukencd() {
        return hhkntodouhukencd;
    }

    public void setHhkntodouhukencd(String pHhkntodouhukencd) {
        hhkntodouhukencd = pHhkntodouhukencd;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SibourituRendou.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }
}