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
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjidrtflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_KykDairiten;
import yuyu.def.db.id.PKIT_BAK_KykDairiten;
import yuyu.def.db.meta.GenQIT_BAK_KykDairiten;
import yuyu.def.db.meta.QIT_BAK_KykDairiten;
import yuyu.def.db.type.UserType_C_Kanjidrtflg;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約代理店バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KykDairiten} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KykDairiten}</td><td colspan="3">契約代理店バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KykDairiten ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KykDairiten ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KykDairiten ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenrenno drtenrenno}</td><td>代理店連番</td><td align="center">{@link PKIT_BAK_KykDairiten ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyousekikeijyousakisosikicd gyousekikeijyousakisosikicd}</td><td>業績計上先組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenbunumu drtenbunumu}</td><td>代理店分担有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKanjidrtflg kanjidrtflg}</td><td>幹事代理店フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjidrtflg}</td></tr>
 *  <tr><td>{@link #getBunwari bunwari}</td><td>分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getIkanymd ikanymd}</td><td>移管日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBsyujoyadrtencd bsyujoyadrtencd}</td><td>募集時親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujdrtencd bsyujdrtencd}</td><td>募集時代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBsyujbosyuutrkno bsyujbosyuutrkno}</td><td>募集時募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KykDairiten
 * @see     PKIT_BAK_KykDairiten
 * @see     QIT_BAK_KykDairiten
 * @see     GenQIT_BAK_KykDairiten
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KykDairiten.TABLE_NAME)
@IdClass(value=PKIT_BAK_KykDairiten.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Kanjidrtflg", typeClass=UserType_C_Kanjidrtflg.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_BAK_KykDairiten extends AbstractExDBEntity<IT_BAK_KykDairiten, PKIT_BAK_KykDairiten> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KykDairiten";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DRTENRENNO               = "drtenrenno";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String GYOUSEKIKEIJYOUSAKISOSIKICD = "gyousekikeijyousakisosikicd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENBUNUMU              = "drtenbunumu";
    public static final String KANJIDRTFLG              = "kanjidrtflg";
    public static final String BUNWARI                  = "bunwari";
    public static final String IKANYMD                  = "ikanymd";
    public static final String BSYUJOYADRTENCD          = "bsyujoyadrtencd";
    public static final String BSYUJDRTENCD             = "bsyujdrtencd";
    public static final String BSYUJBOSYUUTRKNO         = "bsyujbosyuutrkno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KykDairiten primaryKey;

    public GenIT_BAK_KykDairiten() {
        primaryKey = new PKIT_BAK_KykDairiten();
    }

    public GenIT_BAK_KykDairiten(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pDrtenrenno
    ) {
        primaryKey = new PKIT_BAK_KykDairiten(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pDrtenrenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KykDairiten getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KykDairiten> getMetaClass() {
        return QIT_BAK_KykDairiten.class;
    }

    @Id
    @Column(name=GenIT_BAK_KykDairiten.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KykDairiten.SYONO)
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
    @Column(name=GenIT_BAK_KykDairiten.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KykDairiten.DRTENRENNO)
    public Integer getDrtenrenno() {
        return getPrimaryKey().getDrtenrenno();
    }

    @DataConvert("toSingleByte")
    public void setDrtenrenno(Integer pDrtenrenno) {
        getPrimaryKey().setDrtenrenno(pDrtenrenno);
    }

    private String drtencd;

    @Column(name=GenIT_BAK_KykDairiten.DRTENCD)
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

    @Column(name=GenIT_BAK_KykDairiten.DRTENKANRISOSIKICD)
    @HostInvalidCharacter
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private String gyousekikeijyousakisosikicd;

    @Column(name=GenIT_BAK_KykDairiten.GYOUSEKIKEIJYOUSAKISOSIKICD)
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

    private String oyadrtencd;

    @Column(name=GenIT_BAK_KykDairiten.OYADRTENCD)
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

    private String bosyuucd;

    @Column(name=GenIT_BAK_KykDairiten.BOSYUUCD)
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

    private String daibosyuucd;

    @Column(name=GenIT_BAK_KykDairiten.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private C_UmuKbn drtenbunumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KykDairiten.DRTENBUNUMU)
    public C_UmuKbn getDrtenbunumu() {
        return drtenbunumu;
    }

    public void setDrtenbunumu(C_UmuKbn pDrtenbunumu) {
        drtenbunumu = pDrtenbunumu;
    }

    private C_Kanjidrtflg kanjidrtflg;

    @Type(type="UserType_C_Kanjidrtflg")
    @Column(name=GenIT_BAK_KykDairiten.KANJIDRTFLG)
    public C_Kanjidrtflg getKanjidrtflg() {
        return kanjidrtflg;
    }

    public void setKanjidrtflg(C_Kanjidrtflg pKanjidrtflg) {
        kanjidrtflg = pKanjidrtflg;
    }

    private BizNumber bunwari;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KykDairiten.BUNWARI)
    @RangeBizCalcable(min="0", max="100")
    public BizNumber getBunwari() {
        return bunwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBunwari(BizNumber pBunwari) {
        bunwari = pBunwari;
    }

    private BizDate ikanymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykDairiten.IKANYMD)
    @ValidDate
    public BizDate getIkanymd() {
        return ikanymd;
    }

    @Trim("both")
    public void setIkanymd(BizDate pIkanymd) {
        ikanymd = pIkanymd;
    }

    private String bsyujoyadrtencd;

    @Column(name=GenIT_BAK_KykDairiten.BSYUJOYADRTENCD)
    public String getBsyujoyadrtencd() {
        return bsyujoyadrtencd;
    }

    public void setBsyujoyadrtencd(String pBsyujoyadrtencd) {
        bsyujoyadrtencd = pBsyujoyadrtencd;
    }

    private String bsyujdrtencd;

    @Column(name=GenIT_BAK_KykDairiten.BSYUJDRTENCD)
    public String getBsyujdrtencd() {
        return bsyujdrtencd;
    }

    public void setBsyujdrtencd(String pBsyujdrtencd) {
        bsyujdrtencd = pBsyujdrtencd;
    }

    private String bsyujbosyuutrkno;

    @Column(name=GenIT_BAK_KykDairiten.BSYUJBOSYUUTRKNO)
    public String getBsyujbosyuutrkno() {
        return bsyujbosyuutrkno;
    }

    public void setBsyujbosyuutrkno(String pBsyujbosyuutrkno) {
        bsyujbosyuutrkno = pBsyujbosyuutrkno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KykDairiten.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KykDairiten.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KykDairiten.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}