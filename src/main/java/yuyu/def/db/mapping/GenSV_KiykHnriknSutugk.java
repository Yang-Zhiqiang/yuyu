package yuyu.def.db.mapping;

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
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.id.PKSV_KiykHnriknSutugk;
import yuyu.def.db.meta.GenQSV_KiykHnriknSutugk;
import yuyu.def.db.meta.QSV_KiykHnriknSutugk;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 解約返戻金相当額情報ビュー テーブルのマッピング情報クラスで、 {@link SV_KiykHnriknSutugk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_KiykHnriknSutugk}</td><td colspan="3">解約返戻金相当額情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKSV_KiykHnriknSutugk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getFstpnyknymd fstpnyknymd}</td><td>初回保険料入金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTeikishrtkykhukaumu teikishrtkykhukaumu}</td><td>定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     SV_KiykHnriknSutugk
 * @see     PKSV_KiykHnriknSutugk
 * @see     QSV_KiykHnriknSutugk
 * @see     GenQSV_KiykHnriknSutugk
 */
@MappedSuperclass
@Table(name=GenSV_KiykHnriknSutugk.TABLE_NAME)
@IdClass(value=PKSV_KiykHnriknSutugk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_KiykHnriknSutugk extends AbstractExDBEntity<SV_KiykHnriknSutugk, PKSV_KiykHnriknSutugk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_KiykHnriknSutugk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String FSTPNYKNYMD              = "fstpnyknymd";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKSEI                   = "kyksei";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String TEIKISHRTKYKHUKAUMU      = "teikishrtkykhukaumu";

    private final PKSV_KiykHnriknSutugk primaryKey;

    public GenSV_KiykHnriknSutugk() {
        primaryKey = new PKSV_KiykHnriknSutugk();
    }

    public GenSV_KiykHnriknSutugk(String pSyono) {
        primaryKey = new PKSV_KiykHnriknSutugk(pSyono);
    }

    @Transient
    @Override
    public PKSV_KiykHnriknSutugk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_KiykHnriknSutugk> getMetaClass() {
        return QSV_KiykHnriknSutugk.class;
    }

    private String kbnkey;

    @Column(name=GenSV_KiykHnriknSutugk.KBNKEY)
    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }

    @Id
    @Column(name=GenSV_KiykHnriknSutugk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_KiykHnriknSutugk.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_KiykHnriknSutugk.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizDate fstpnyknymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_KiykHnriknSutugk.FSTPNYKNYMD)
    public BizDate getFstpnyknymd() {
        return fstpnyknymd;
    }

    public void setFstpnyknymd(BizDate pFstpnyknymd) {
        fstpnyknymd = pFstpnyknymd;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_KiykHnriknSutugk.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_KiykHnriknSutugk.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenSV_KiykHnriknSutugk.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_KiykHnriknSutugk.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_KiykHnriknSutugk.TEIKISHRTKYKHUKAUMU)
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }
}