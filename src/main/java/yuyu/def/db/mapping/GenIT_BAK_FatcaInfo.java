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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.IT_BAK_FatcaInfo;
import yuyu.def.db.id.PKIT_BAK_FatcaInfo;
import yuyu.def.db.meta.GenQIT_BAK_FatcaInfo;
import yuyu.def.db.meta.QIT_BAK_FatcaInfo;
import yuyu.def.db.type.UserType_C_BikkjnssinfoKbn;
import yuyu.def.db.type.UserType_C_FatcahankeiiKbn;
import yuyu.def.db.type.UserType_C_FatcakekKbn;
import yuyu.def.db.type.UserType_C_FatcasnsiKbn;
import yuyu.def.db.type.UserType_C_FatcatgKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＦＡＴＣＡ情報バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_FatcaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_FatcaInfo}</td><td colspan="3">ＦＡＴＣＡ情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_FatcaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_FatcaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_FatcaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_FatcaInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFatcasnsikbn fatcasnsikbn}</td><td>ＦＡＴＣＡ宣誓区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcasnsiKbn}</td></tr>
 *  <tr><td>{@link #getBikkjnssinfokbn bikkjnssinfokbn}</td><td>米国人示唆情報区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BikkjnssinfoKbn}</td></tr>
 *  <tr><td>{@link #getFatcakekkbn fatcakekkbn}</td><td>ＦＡＴＣＡ結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcakekKbn}</td></tr>
 *  <tr><td>{@link #getFatcahankeiikbn fatcahankeiikbn}</td><td>ＦＡＴＣＡ判明経緯区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcahankeiiKbn}</td></tr>
 *  <tr><td>{@link #getBikknzsyno bikknzsyno}</td><td>米国納税者番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyomeiymd syomeiymd}</td><td>署名日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKokno kokno}</td><td>顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFatcatgkbn fatcatgkbn}</td><td>ＦＡＴＣＡ対象者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcatgKbn}</td></tr>
 *  <tr><td>{@link #getSeionnmkn seionnmkn}</td><td>清音氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNmkn nmkn}</td><td>氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNmkj nmkj}</td><td>氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeiymd seiymd}</td><td>生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getKouryokuendymd kouryokuendymd}</td><td>効力終了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkymd trkymd}</td><td>登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_FatcaInfo
 * @see     PKIT_BAK_FatcaInfo
 * @see     QIT_BAK_FatcaInfo
 * @see     GenQIT_BAK_FatcaInfo
 */
@MappedSuperclass
@Table(name=GenIT_BAK_FatcaInfo.TABLE_NAME)
@IdClass(value=PKIT_BAK_FatcaInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BikkjnssinfoKbn", typeClass=UserType_C_BikkjnssinfoKbn.class),
    @TypeDef(name="UserType_C_FatcahankeiiKbn", typeClass=UserType_C_FatcahankeiiKbn.class),
    @TypeDef(name="UserType_C_FatcakekKbn", typeClass=UserType_C_FatcakekKbn.class),
    @TypeDef(name="UserType_C_FatcasnsiKbn", typeClass=UserType_C_FatcasnsiKbn.class),
    @TypeDef(name="UserType_C_FatcatgKbn", typeClass=UserType_C_FatcatgKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class)
})
public abstract class GenIT_BAK_FatcaInfo extends AbstractExDBEntity<IT_BAK_FatcaInfo, PKIT_BAK_FatcaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_FatcaInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String RENNO                    = "renno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String FATCASNSIKBN             = "fatcasnsikbn";
    public static final String BIKKJNSSINFOKBN          = "bikkjnssinfokbn";
    public static final String FATCAKEKKBN              = "fatcakekkbn";
    public static final String FATCAHANKEIIKBN          = "fatcahankeiikbn";
    public static final String BIKKNZSYNO               = "bikknzsyno";
    public static final String SYOMEIYMD                = "syomeiymd";
    public static final String KOKNO                    = "kokno";
    public static final String FATCATGKBN               = "fatcatgkbn";
    public static final String SEIONNMKN                = "seionnmkn";
    public static final String NMKN                     = "nmkn";
    public static final String NMKJ                     = "nmkj";
    public static final String SEIYMD                   = "seiymd";
    public static final String SEIBETU                  = "seibetu";
    public static final String KOURYOKUENDYMD           = "kouryokuendymd";
    public static final String TRKYMD                   = "trkymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_FatcaInfo primaryKey;

    public GenIT_BAK_FatcaInfo() {
        primaryKey = new PKIT_BAK_FatcaInfo();
    }

    public GenIT_BAK_FatcaInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_FatcaInfo(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_FatcaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_FatcaInfo> getMetaClass() {
        return QIT_BAK_FatcaInfo.class;
    }

    @Id
    @Column(name=GenIT_BAK_FatcaInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_FatcaInfo.SYONO)
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
    @Column(name=GenIT_BAK_FatcaInfo.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_FatcaInfo.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_FatcaInfo.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syorisosikicd;

    @Column(name=GenIT_BAK_FatcaInfo.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_FatcasnsiKbn fatcasnsikbn;

    @Type(type="UserType_C_FatcasnsiKbn")
    @Column(name=GenIT_BAK_FatcaInfo.FATCASNSIKBN)
    public C_FatcasnsiKbn getFatcasnsikbn() {
        return fatcasnsikbn;
    }

    public void setFatcasnsikbn(C_FatcasnsiKbn pFatcasnsikbn) {
        fatcasnsikbn = pFatcasnsikbn;
    }

    private C_BikkjnssinfoKbn bikkjnssinfokbn;

    @Type(type="UserType_C_BikkjnssinfoKbn")
    @Column(name=GenIT_BAK_FatcaInfo.BIKKJNSSINFOKBN)
    public C_BikkjnssinfoKbn getBikkjnssinfokbn() {
        return bikkjnssinfokbn;
    }

    public void setBikkjnssinfokbn(C_BikkjnssinfoKbn pBikkjnssinfokbn) {
        bikkjnssinfokbn = pBikkjnssinfokbn;
    }

    private C_FatcakekKbn fatcakekkbn;

    @Type(type="UserType_C_FatcakekKbn")
    @Column(name=GenIT_BAK_FatcaInfo.FATCAKEKKBN)
    public C_FatcakekKbn getFatcakekkbn() {
        return fatcakekkbn;
    }

    public void setFatcakekkbn(C_FatcakekKbn pFatcakekkbn) {
        fatcakekkbn = pFatcakekkbn;
    }

    private C_FatcahankeiiKbn fatcahankeiikbn;

    @Type(type="UserType_C_FatcahankeiiKbn")
    @Column(name=GenIT_BAK_FatcaInfo.FATCAHANKEIIKBN)
    public C_FatcahankeiiKbn getFatcahankeiikbn() {
        return fatcahankeiikbn;
    }

    public void setFatcahankeiikbn(C_FatcahankeiiKbn pFatcahankeiikbn) {
        fatcahankeiikbn = pFatcahankeiikbn;
    }

    private String bikknzsyno;

    @Column(name=GenIT_BAK_FatcaInfo.BIKKNZSYNO)
    @MaxLength(max=9)
    @SingleByteStrings
    @AlphaDigit
    public String getBikknzsyno() {
        return bikknzsyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBikknzsyno(String pBikknzsyno) {
        bikknzsyno = pBikknzsyno;
    }

    private BizDate syomeiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_FatcaInfo.SYOMEIYMD)
    @ValidDate
    public BizDate getSyomeiymd() {
        return syomeiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyomeiymd(BizDate pSyomeiymd) {
        syomeiymd = pSyomeiymd;
    }

    private String kokno;

    @Column(name=GenIT_BAK_FatcaInfo.KOKNO)
    public String getKokno() {
        return kokno;
    }

    public void setKokno(String pKokno) {
        kokno = pKokno;
    }

    private C_FatcatgKbn fatcatgkbn;

    @Type(type="UserType_C_FatcatgKbn")
    @Column(name=GenIT_BAK_FatcaInfo.FATCATGKBN)
    public C_FatcatgKbn getFatcatgkbn() {
        return fatcatgkbn;
    }

    public void setFatcatgkbn(C_FatcatgKbn pFatcatgkbn) {
        fatcatgkbn = pFatcatgkbn;
    }

    private String seionnmkn;

    @Column(name=GenIT_BAK_FatcaInfo.SEIONNMKN)
    public String getSeionnmkn() {
        return seionnmkn;
    }

    public void setSeionnmkn(String pSeionnmkn) {
        seionnmkn = pSeionnmkn;
    }

    private String nmkn;

    @Column(name=GenIT_BAK_FatcaInfo.NMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getNmkn() {
        return nmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNmkn(String pNmkn) {
        nmkn = pNmkn;
    }

    private String nmkj;

    @Column(name=GenIT_BAK_FatcaInfo.NMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getNmkj() {
        return nmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNmkj(String pNmkj) {
        nmkj = pNmkj;
    }

    private BizDate seiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_FatcaInfo.SEIYMD)
    @ValidDate
    public BizDate getSeiymd() {
        return seiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeiymd(BizDate pSeiymd) {
        seiymd = pSeiymd;
    }

    private C_Seibetu seibetu;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_BAK_FatcaInfo.SEIBETU)
    public C_Seibetu getSeibetu() {
        return seibetu;
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        seibetu = pSeibetu;
    }

    private BizDate kouryokuendymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_FatcaInfo.KOURYOKUENDYMD)
    public BizDate getKouryokuendymd() {
        return kouryokuendymd;
    }

    public void setKouryokuendymd(BizDate pKouryokuendymd) {
        kouryokuendymd = pKouryokuendymd;
    }

    private BizDate trkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_FatcaInfo.TRKYMD)
    @ValidDate
    public BizDate getTrkymd() {
        return trkymd;
    }

    @Trim("both")
    public void setTrkymd(BizDate pTrkymd) {
        trkymd = pTrkymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_FatcaInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_FatcaInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_FatcaInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}