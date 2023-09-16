package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DrtensyKbn;
import yuyu.def.classification.C_YuuseiKbn;
import yuyu.def.db.entity.HT_SouseirituDairiten;
import yuyu.def.db.id.PKHT_SouseirituDairiten;
import yuyu.def.db.meta.GenQHT_SouseirituDairiten;
import yuyu.def.db.meta.QHT_SouseirituDairiten;
import yuyu.def.db.type.UserType_C_DrtensyKbn;
import yuyu.def.db.type.UserType_C_YuuseiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.Modulus10w21;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 総成立代理店テーブル テーブルのマッピング情報クラスで、 {@link HT_SouseirituDairiten} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SouseirituDairiten}</td><td colspan="3">総成立代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKHT_SouseirituDairiten ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_SouseirituDairiten ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujoyadrtencd bsyujoyadrtencd}</td><td>募集時親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensykbn drtensykbn}</td><td>代理店種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtensyKbn}</td></tr>
 *  <tr><td>{@link #getKinyuucd kinyuucd}</td><td>金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuusitencd kinyuusitencd}</td><td>金融機関支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimusyocd jimusyocd}</td><td>事務所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuutrkno bosyuutrkno}</td><td>募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInputbosyuucd inputbosyuucd}</td><td>入力募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkikouinncd tratkikouinncd}</td><td>取扱行員コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuuseikbn yuuseikbn}</td><td>郵政区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuuseiKbn}</td></tr>
 *  <tr><td>{@link #getKyokusyocd kyokusyocd}</td><td>局所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuuseisyainno yuuseisyainno}</td><td>郵政社員番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyousekikeijyousakisosikicd gyousekikeijyousakisosikicd}</td><td>業績計上先組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari bunwari}</td><td>分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SouseirituDairiten
 * @see     PKHT_SouseirituDairiten
 * @see     QHT_SouseirituDairiten
 * @see     GenQHT_SouseirituDairiten
 */
@MappedSuperclass
@Table(name=GenHT_SouseirituDairiten.TABLE_NAME)
@IdClass(value=PKHT_SouseirituDairiten.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DrtensyKbn", typeClass=UserType_C_DrtensyKbn.class),
    @TypeDef(name="UserType_C_YuuseiKbn", typeClass=UserType_C_YuuseiKbn.class)
})
public abstract class GenHT_SouseirituDairiten extends AbstractExDBEntity<HT_SouseirituDairiten, PKHT_SouseirituDairiten> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SouseirituDairiten";
    public static final String SYONO                    = "syono";
    public static final String RENNO                    = "renno";
    public static final String MOSNO                    = "mosno";
    public static final String BSYUJOYADRTENCD          = "bsyujoyadrtencd";
    public static final String DRTENSYKBN               = "drtensykbn";
    public static final String KINYUUCD                 = "kinyuucd";
    public static final String KINYUUSITENCD            = "kinyuusitencd";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String JIMUSYOCD                = "jimusyocd";
    public static final String BOSYUUTRKNO              = "bosyuutrkno";
    public static final String CIFCD                    = "cifcd";
    public static final String DRTENCD                  = "drtencd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String INPUTBOSYUUCD            = "inputbosyuucd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String TRATKIKOUINNCD           = "tratkikouinncd";
    public static final String YUUSEIKBN                = "yuuseikbn";
    public static final String KYOKUSYOCD               = "kyokusyocd";
    public static final String YUUSEISYAINNO            = "yuuseisyainno";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String GYOUSEKIKEIJYOUSAKISOSIKICD = "gyousekikeijyousakisosikicd";
    public static final String BUNWARI                  = "bunwari";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SouseirituDairiten primaryKey;

    public GenHT_SouseirituDairiten() {
        primaryKey = new PKHT_SouseirituDairiten();
    }

    public GenHT_SouseirituDairiten(String pSyono, Integer pRenno) {
        primaryKey = new PKHT_SouseirituDairiten(pSyono, pRenno);
    }

    @Transient
    @Override
    public PKHT_SouseirituDairiten getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SouseirituDairiten> getMetaClass() {
        return QHT_SouseirituDairiten.class;
    }

    @Id
    @Column(name=GenHT_SouseirituDairiten.SYONO)
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
    @Column(name=GenHT_SouseirituDairiten.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String mosno;

    @Column(name=GenHT_SouseirituDairiten.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String bsyujoyadrtencd;

    @Column(name=GenHT_SouseirituDairiten.BSYUJOYADRTENCD)
    public String getBsyujoyadrtencd() {
        return bsyujoyadrtencd;
    }

    public void setBsyujoyadrtencd(String pBsyujoyadrtencd) {
        bsyujoyadrtencd = pBsyujoyadrtencd;
    }

    private C_DrtensyKbn drtensykbn;

    @Type(type="UserType_C_DrtensyKbn")
    @Column(name=GenHT_SouseirituDairiten.DRTENSYKBN)
    public C_DrtensyKbn getDrtensykbn() {
        return drtensykbn;
    }

    public void setDrtensykbn(C_DrtensyKbn pDrtensykbn) {
        drtensykbn = pDrtensykbn;
    }

    private String kinyuucd;

    @Column(name=GenHT_SouseirituDairiten.KINYUUCD)
    public String getKinyuucd() {
        return kinyuucd;
    }

    public void setKinyuucd(String pKinyuucd) {
        kinyuucd = pKinyuucd;
    }

    private String kinyuusitencd;

    @Column(name=GenHT_SouseirituDairiten.KINYUUSITENCD)
    public String getKinyuusitencd() {
        return kinyuusitencd;
    }

    public void setKinyuusitencd(String pKinyuusitencd) {
        kinyuusitencd = pKinyuusitencd;
    }

    private String tratkiagcd;

    @Column(name=GenHT_SouseirituDairiten.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private String oyadrtencd;

    @Column(name=GenHT_SouseirituDairiten.OYADRTENCD)
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

    private String jimusyocd;

    @Column(name=GenHT_SouseirituDairiten.JIMUSYOCD)
    @Length(length=4)
    @AlphaDigit
    public String getJimusyocd() {
        return jimusyocd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimusyocd(String pJimusyocd) {
        jimusyocd = pJimusyocd;
    }

    private String bosyuutrkno;

    @Column(name=GenHT_SouseirituDairiten.BOSYUUTRKNO)
    public String getBosyuutrkno() {
        return bosyuutrkno;
    }

    public void setBosyuutrkno(String pBosyuutrkno) {
        bosyuutrkno = pBosyuutrkno;
    }

    private String cifcd;

    @Column(name=GenHT_SouseirituDairiten.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String drtencd;

    @Column(name=GenHT_SouseirituDairiten.DRTENCD)
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

    private String bosyuucd;

    @Column(name=GenHT_SouseirituDairiten.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return bosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

    private String inputbosyuucd;

    @Column(name=GenHT_SouseirituDairiten.INPUTBOSYUUCD)
    @Length(length=7)
    @Digit
    @Modulus10w21
    public String getInputbosyuucd() {
        return inputbosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInputbosyuucd(String pInputbosyuucd) {
        inputbosyuucd = pInputbosyuucd;
    }

    private String daibosyuucd;

    @Column(name=GenHT_SouseirituDairiten.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String tratkikouinncd;

    @Column(name=GenHT_SouseirituDairiten.TRATKIKOUINNCD)
    public String getTratkikouinncd() {
        return tratkikouinncd;
    }

    public void setTratkikouinncd(String pTratkikouinncd) {
        tratkikouinncd = pTratkikouinncd;
    }

    private C_YuuseiKbn yuuseikbn;

    @Type(type="UserType_C_YuuseiKbn")
    @Column(name=GenHT_SouseirituDairiten.YUUSEIKBN)
    public C_YuuseiKbn getYuuseikbn() {
        return yuuseikbn;
    }

    public void setYuuseikbn(C_YuuseiKbn pYuuseikbn) {
        yuuseikbn = pYuuseikbn;
    }

    private String kyokusyocd;

    @Column(name=GenHT_SouseirituDairiten.KYOKUSYOCD)
    public String getKyokusyocd() {
        return kyokusyocd;
    }

    public void setKyokusyocd(String pKyokusyocd) {
        kyokusyocd = pKyokusyocd;
    }

    private String yuuseisyainno;

    @Column(name=GenHT_SouseirituDairiten.YUUSEISYAINNO)
    public String getYuuseisyainno() {
        return yuuseisyainno;
    }

    public void setYuuseisyainno(String pYuuseisyainno) {
        yuuseisyainno = pYuuseisyainno;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenHT_SouseirituDairiten.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String gyousekikeijyousakisosikicd;

    @Column(name=GenHT_SouseirituDairiten.GYOUSEKIKEIJYOUSAKISOSIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getGyousekikeijyousakisosikicd() {
        return gyousekikeijyousakisosikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGyousekikeijyousakisosikicd(String pGyousekikeijyousakisosikicd) {
        gyousekikeijyousakisosikicd = pGyousekikeijyousakisosikicd;
    }

    private BizNumber bunwari;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SouseirituDairiten.BUNWARI)
    @RangeBizCalcable(min="0", max="100")
    public BizNumber getBunwari() {
        return bunwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBunwari(BizNumber pBunwari) {
        bunwari = pBunwari;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SouseirituDairiten.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SouseirituDairiten.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}