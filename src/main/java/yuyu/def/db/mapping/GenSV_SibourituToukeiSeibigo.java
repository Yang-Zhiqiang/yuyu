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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.id.PKSV_SibourituToukeiSeibigo;
import yuyu.def.db.meta.GenQSV_SibourituToukeiSeibigo;
import yuyu.def.db.meta.QSV_SibourituToukeiSeibigo;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡率統計整備後情報ビュー テーブルのマッピング情報クラスで、 {@link SV_SibourituToukeiSeibigo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SibourituToukeiSeibigo}</td><td colspan="3">死亡率統計整備後情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKSV_SibourituToukeiSeibigo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenbunumu drtenbunumu}</td><td>代理店分担有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">{@link PKSV_SibourituToukeiSeibigo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">{@link PKSV_SibourituToukeiSeibigo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorikbn syorikbn}</td><td>処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoriKbn}</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     SV_SibourituToukeiSeibigo
 * @see     PKSV_SibourituToukeiSeibigo
 * @see     QSV_SibourituToukeiSeibigo
 * @see     GenQSV_SibourituToukeiSeibigo
 */
@MappedSuperclass
@Table(name=GenSV_SibourituToukeiSeibigo.TABLE_NAME)
@IdClass(value=PKSV_SibourituToukeiSeibigo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_SyoriKbn", typeClass=UserType_C_SyoriKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_SibourituToukeiSeibigo extends AbstractExDBEntity<SV_SibourituToukeiSeibigo, PKSV_SibourituToukeiSeibigo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_SibourituToukeiSeibigo";
    public static final String SYONO                    = "syono";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String HRKP                     = "hrkp";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String YENDTHNKYMD              = "yendthnkymd";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENBUNUMU              = "drtenbunumu";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SYORIKBN                 = "syorikbn";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";

    private final PKSV_SibourituToukeiSeibigo primaryKey;

    public GenSV_SibourituToukeiSeibigo() {
        primaryKey = new PKSV_SibourituToukeiSeibigo();
    }

    public GenSV_SibourituToukeiSeibigo(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        primaryKey = new PKSV_SibourituToukeiSeibigo(
            pSyono,
            pGyoumuKousinKinou,
            pGyoumuKousinTime
        );
    }

    @Transient
    @Override
    public PKSV_SibourituToukeiSeibigo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_SibourituToukeiSeibigo> getMetaClass() {
        return QSV_SibourituToukeiSeibigo.class;
    }

    @Id
    @Column(name=GenSV_SibourituToukeiSeibigo.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenSV_SibourituToukeiSeibigo.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private String syouhncd;

    @Column(name=GenSV_SibourituToukeiSeibigo.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private Integer syouhnsdno;

    @Column(name=GenSV_SibourituToukeiSeibigo.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private Integer kyksyouhnrenno;

    @Column(name=GenSV_SibourituToukeiSeibigo.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_SibourituToukeiSeibigo.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_SibourituToukeiSeibigo.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
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

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SibourituToukeiSeibigo.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private String hhknsykgycd;

    @Column(name=GenSV_SibourituToukeiSeibigo.HHKNSYKGYCD)
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

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenSV_SibourituToukeiSeibigo.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SibourituToukeiSeibigo.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private String drtencd;

    @Column(name=GenSV_SibourituToukeiSeibigo.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenSV_SibourituToukeiSeibigo.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_SibourituToukeiSeibigo.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private C_UmuKbn drtenbunumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SibourituToukeiSeibigo.DRTENBUNUMU)
    public C_UmuKbn getDrtenbunumu() {
        return drtenbunumu;
    }

    public void setDrtenbunumu(C_UmuKbn pDrtenbunumu) {
        drtenbunumu = pDrtenbunumu;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SibourituToukeiSeibigo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String henkousikibetukey;

    @Column(name=GenSV_SibourituToukeiSeibigo.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    @Id
    @Column(name=GenSV_SibourituToukeiSeibigo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return getPrimaryKey().getGyoumuKousinKinou();
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        getPrimaryKey().setGyoumuKousinKinou(pGyoumuKousinKinou);
    }

    @Id
    @Column(name=GenSV_SibourituToukeiSeibigo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return getPrimaryKey().getGyoumuKousinTime();
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        getPrimaryKey().setGyoumuKousinTime(pGyoumuKousinTime);
    }

    private C_SyoriKbn syorikbn;

    @Type(type="UserType_C_SyoriKbn")
    @Column(name=GenSV_SibourituToukeiSeibigo.SYORIKBN)
    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        syorikbn = pSyorikbn;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenSV_SibourituToukeiSeibigo.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SibourituToukeiSeibigo.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenSV_SibourituToukeiSeibigo.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SibourituToukeiSeibigo.INITSBJIYENSITIHSYTKHUKAUMU)
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