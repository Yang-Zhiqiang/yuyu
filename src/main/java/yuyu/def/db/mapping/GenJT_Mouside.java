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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_PmenKbn;
import yuyu.def.classification.C_SaigaiGeninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SensinKbn;
import yuyu.def.classification.C_SindansyoSksMaisuuKbn;
import yuyu.def.classification.C_SindansyoSksSiteiKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_TiryousakiKbn;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.db.entity.JT_Mouside;
import yuyu.def.db.id.PKJT_Mouside;
import yuyu.def.db.meta.GenQJT_Mouside;
import yuyu.def.db.meta.QJT_Mouside;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_KyksyaSibouUmuKbn;
import yuyu.def.db.type.UserType_C_MousideninKbn;
import yuyu.def.db.type.UserType_C_NayoseYouhi;
import yuyu.def.db.type.UserType_C_PmenKbn;
import yuyu.def.db.type.UserType_C_SaigaiGeninKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SensinKbn;
import yuyu.def.db.type.UserType_C_SindansyoSksMaisuuKbn;
import yuyu.def.db.type.UserType_C_SindansyoSksSiteiKbn;
import yuyu.def.db.type.UserType_C_SouhusakiKbn;
import yuyu.def.db.type.UserType_C_SyuhiYouhi;
import yuyu.def.db.type.UserType_C_TiryousakiKbn;
import yuyu.def.db.type.UserType_C_UketorininSibouUmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 申出テーブル テーブルのマッピング情報クラスで、 {@link JT_Mouside} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Mouside}</td><td colspan="3">申出テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_Mouside ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_Mouside ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getNayoseyouhi nayoseyouhi}</td><td>名寄せ要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NayoseYouhi}</td></tr>
 *  <tr><td>{@link #getMousideninkbn mousideninkbn}</td><td>申出人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MousideninKbn}</td></tr>
 *  <tr><td>{@link #getSyuhiyouhi syuhiyouhi}</td><td>守秘要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuhiYouhi}</td></tr>
 *  <tr><td>{@link #getMousideninnmkj mousideninnmkj}</td><td>申出人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUketorininsibouumukbn uketorininsibouumukbn}</td><td>受取人死亡有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UketorininSibouUmuKbn}</td></tr>
 *  <tr><td>{@link #getKyksyasibouumukbn kyksyasibouumukbn}</td><td>契約者死亡有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyksyaSibouUmuKbn}</td></tr>
 *  <tr><td>{@link #getSouhusakikbn souhusakikbn}</td><td>送付先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SouhusakiKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmenkbn pmenkbn}</td><td>Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmenKbn}</td></tr>
 *  <tr><td>{@link #getGeninkbn geninkbn}</td><td>原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getJikosyosinymd jikosyosinymd}</td><td>事故（初診）日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSaigaigeninkbn saigaigeninkbn}</td><td>災害原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaigaiGeninKbn}</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyougaikoteiymd syougaikoteiymd}</td><td>障害固定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getByoumeitourokuno byoumeitourokuno}</td><td>病名登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTiryousakikbn tiryousakikbn}</td><td>治療先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TiryousakiKbn}</td></tr>
 *  <tr><td>{@link #getNyuuinymd nyuuinymd}</td><td>入院日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaiinymd taiinymd}</td><td>退院日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyujyutuymd syujyutuymd}</td><td>手術日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyujyututourokuno syujyututourokuno}</td><td>手術登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSensinkbn sensinkbn}</td><td>先進医療区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SensinKbn}</td></tr>
 *  <tr><td>{@link #getSindansyosksmaisuukbn sindansyosksmaisuukbn}</td><td>診断書作成枚数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SindansyoSksMaisuuKbn}</td></tr>
 *  <tr><td>{@link #getSindansyoskssiteikbn sindansyoskssiteikbn}</td><td>診断書作成指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SindansyoSksSiteiKbn}</td></tr>
 *  <tr><td>{@link #getBetukyksuu betukyksuu}</td><td>別契約数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Mouside
 * @see     PKJT_Mouside
 * @see     QJT_Mouside
 * @see     GenQJT_Mouside
 */
@MappedSuperclass
@Table(name=GenJT_Mouside.TABLE_NAME)
@IdClass(value=PKJT_Mouside.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_KyksyaSibouUmuKbn", typeClass=UserType_C_KyksyaSibouUmuKbn.class),
    @TypeDef(name="UserType_C_MousideninKbn", typeClass=UserType_C_MousideninKbn.class),
    @TypeDef(name="UserType_C_NayoseYouhi", typeClass=UserType_C_NayoseYouhi.class),
    @TypeDef(name="UserType_C_PmenKbn", typeClass=UserType_C_PmenKbn.class),
    @TypeDef(name="UserType_C_SaigaiGeninKbn", typeClass=UserType_C_SaigaiGeninKbn.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_SensinKbn", typeClass=UserType_C_SensinKbn.class),
    @TypeDef(name="UserType_C_SindansyoSksMaisuuKbn", typeClass=UserType_C_SindansyoSksMaisuuKbn.class),
    @TypeDef(name="UserType_C_SindansyoSksSiteiKbn", typeClass=UserType_C_SindansyoSksSiteiKbn.class),
    @TypeDef(name="UserType_C_SouhusakiKbn", typeClass=UserType_C_SouhusakiKbn.class),
    @TypeDef(name="UserType_C_SyuhiYouhi", typeClass=UserType_C_SyuhiYouhi.class),
    @TypeDef(name="UserType_C_TiryousakiKbn", typeClass=UserType_C_TiryousakiKbn.class),
    @TypeDef(name="UserType_C_UketorininSibouUmuKbn", typeClass=UserType_C_UketorininSibouUmuKbn.class)
})
public abstract class GenJT_Mouside extends AbstractExDBEntity<JT_Mouside, PKJT_Mouside> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_Mouside";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String NAYOSEYOUHI              = "nayoseyouhi";
    public static final String MOUSIDENINKBN            = "mousideninkbn";
    public static final String SYUHIYOUHI               = "syuhiyouhi";
    public static final String MOUSIDENINNMKJ           = "mousideninnmkj";
    public static final String UKETORININSIBOUUMUKBN    = "uketorininsibouumukbn";
    public static final String KYKSYASIBOUUMUKBN        = "kyksyasibouumukbn";
    public static final String SOUHUSAKIKBN             = "souhusakikbn";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String PMENKBN                  = "pmenkbn";
    public static final String GENINKBN                 = "geninkbn";
    public static final String JIKOSYOSINYMD            = "jikosyosinymd";
    public static final String SAIGAIGENINKBN           = "saigaigeninkbn";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String SYOUGAIKOTEIYMD          = "syougaikoteiymd";
    public static final String BYOUMEITOUROKUNO         = "byoumeitourokuno";
    public static final String TIRYOUSAKIKBN            = "tiryousakikbn";
    public static final String NYUUINYMD                = "nyuuinymd";
    public static final String TAIINYMD                 = "taiinymd";
    public static final String SYUJYUTUYMD              = "syujyutuymd";
    public static final String SYUJYUTUTOUROKUNO        = "syujyututourokuno";
    public static final String SENSINKBN                = "sensinkbn";
    public static final String SINDANSYOSKSMAISUUKBN    = "sindansyosksmaisuukbn";
    public static final String SINDANSYOSKSSITEIKBN     = "sindansyoskssiteikbn";
    public static final String BETUKYKSUU               = "betukyksuu";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_Mouside primaryKey;

    public GenJT_Mouside() {
        primaryKey = new PKJT_Mouside();
    }

    public GenJT_Mouside(String pSkno, String pSyono) {
        primaryKey = new PKJT_Mouside(pSkno, pSyono);
    }

    @Transient
    @Override
    public PKJT_Mouside getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_Mouside> getMetaClass() {
        return QJT_Mouside.class;
    }

    @Id
    @Column(name=GenJT_Mouside.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_Mouside.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJT_Mouside.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_NayoseYouhi nayoseyouhi;

    @Type(type="UserType_C_NayoseYouhi")
    @Column(name=GenJT_Mouside.NAYOSEYOUHI)
    public C_NayoseYouhi getNayoseyouhi() {
        return nayoseyouhi;
    }

    public void setNayoseyouhi(C_NayoseYouhi pNayoseyouhi) {
        nayoseyouhi = pNayoseyouhi;
    }

    private C_MousideninKbn mousideninkbn;

    @Type(type="UserType_C_MousideninKbn")
    @Column(name=GenJT_Mouside.MOUSIDENINKBN)
    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninkbn = pMousideninkbn;
    }

    private C_SyuhiYouhi syuhiyouhi;

    @Type(type="UserType_C_SyuhiYouhi")
    @Column(name=GenJT_Mouside.SYUHIYOUHI)
    public C_SyuhiYouhi getSyuhiyouhi() {
        return syuhiyouhi;
    }

    public void setSyuhiyouhi(C_SyuhiYouhi pSyuhiyouhi) {
        syuhiyouhi = pSyuhiyouhi;
    }

    private String mousideninnmkj;

    @Column(name=GenJT_Mouside.MOUSIDENINNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getMousideninnmkj() {
        return mousideninnmkj;
    }

    @Trim("right")
    public void setMousideninnmkj(String pMousideninnmkj) {
        mousideninnmkj = pMousideninnmkj;
    }

    private C_UketorininSibouUmuKbn uketorininsibouumukbn;

    @Type(type="UserType_C_UketorininSibouUmuKbn")
    @Column(name=GenJT_Mouside.UKETORININSIBOUUMUKBN)
    public C_UketorininSibouUmuKbn getUketorininsibouumukbn() {
        return uketorininsibouumukbn;
    }

    public void setUketorininsibouumukbn(C_UketorininSibouUmuKbn pUketorininsibouumukbn) {
        uketorininsibouumukbn = pUketorininsibouumukbn;
    }

    private C_KyksyaSibouUmuKbn kyksyasibouumukbn;

    @Type(type="UserType_C_KyksyaSibouUmuKbn")
    @Column(name=GenJT_Mouside.KYKSYASIBOUUMUKBN)
    public C_KyksyaSibouUmuKbn getKyksyasibouumukbn() {
        return kyksyasibouumukbn;
    }

    public void setKyksyasibouumukbn(C_KyksyaSibouUmuKbn pKyksyasibouumukbn) {
        kyksyasibouumukbn = pKyksyasibouumukbn;
    }

    private C_SouhusakiKbn souhusakikbn;

    @Type(type="UserType_C_SouhusakiKbn")
    @Column(name=GenJT_Mouside.SOUHUSAKIKBN)
    public C_SouhusakiKbn getSouhusakikbn() {
        return souhusakikbn;
    }

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn) {
        souhusakikbn = pSouhusakikbn;
    }

    private String tsinyno;

    @Column(name=GenJT_Mouside.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenJT_Mouside.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenJT_Mouside.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenJT_Mouside.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String tsintelno;

    @Column(name=GenJT_Mouside.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private C_PmenKbn pmenkbn;

    @Type(type="UserType_C_PmenKbn")
    @Column(name=GenJT_Mouside.PMENKBN)
    public C_PmenKbn getPmenkbn() {
        return pmenkbn;
    }

    public void setPmenkbn(C_PmenKbn pPmenkbn) {
        pmenkbn = pPmenkbn;
    }

    private C_GeninKbn geninkbn;

    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJT_Mouside.GENINKBN)
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private BizDate jikosyosinymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Mouside.JIKOSYOSINYMD)
    @ValidDate
    public BizDate getJikosyosinymd() {
        return jikosyosinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJikosyosinymd(BizDate pJikosyosinymd) {
        jikosyosinymd = pJikosyosinymd;
    }

    private C_SaigaiGeninKbn saigaigeninkbn;

    @Type(type="UserType_C_SaigaiGeninKbn")
    @Column(name=GenJT_Mouside.SAIGAIGENINKBN)
    public C_SaigaiGeninKbn getSaigaigeninkbn() {
        return saigaigeninkbn;
    }

    public void setSaigaigeninkbn(C_SaigaiGeninKbn pSaigaigeninkbn) {
        saigaigeninkbn = pSaigaigeninkbn;
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Mouside.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private BizDate syougaikoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Mouside.SYOUGAIKOTEIYMD)
    @ValidDate
    public BizDate getSyougaikoteiymd() {
        return syougaikoteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyougaikoteiymd(BizDate pSyougaikoteiymd) {
        syougaikoteiymd = pSyougaikoteiymd;
    }

    private String byoumeitourokuno;

    @Column(name=GenJT_Mouside.BYOUMEITOUROKUNO)
    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

    private C_TiryousakiKbn tiryousakikbn;

    @Type(type="UserType_C_TiryousakiKbn")
    @Column(name=GenJT_Mouside.TIRYOUSAKIKBN)
    public C_TiryousakiKbn getTiryousakikbn() {
        return tiryousakikbn;
    }

    public void setTiryousakikbn(C_TiryousakiKbn pTiryousakikbn) {
        tiryousakikbn = pTiryousakikbn;
    }

    private BizDate nyuuinymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Mouside.NYUUINYMD)
    @ValidDate
    public BizDate getNyuuinymd() {
        return nyuuinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNyuuinymd(BizDate pNyuuinymd) {
        nyuuinymd = pNyuuinymd;
    }

    private BizDate taiinymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Mouside.TAIINYMD)
    @ValidDate
    public BizDate getTaiinymd() {
        return taiinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaiinymd(BizDate pTaiinymd) {
        taiinymd = pTaiinymd;
    }

    private BizDate syujyutuymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Mouside.SYUJYUTUYMD)
    @ValidDate
    public BizDate getSyujyutuymd() {
        return syujyutuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyujyutuymd(BizDate pSyujyutuymd) {
        syujyutuymd = pSyujyutuymd;
    }

    private String syujyututourokuno;

    @Column(name=GenJT_Mouside.SYUJYUTUTOUROKUNO)
    public String getSyujyututourokuno() {
        return syujyututourokuno;
    }

    public void setSyujyututourokuno(String pSyujyututourokuno) {
        syujyututourokuno = pSyujyututourokuno;
    }

    private C_SensinKbn sensinkbn;

    @Type(type="UserType_C_SensinKbn")
    @Column(name=GenJT_Mouside.SENSINKBN)
    public C_SensinKbn getSensinkbn() {
        return sensinkbn;
    }

    public void setSensinkbn(C_SensinKbn pSensinkbn) {
        sensinkbn = pSensinkbn;
    }

    private C_SindansyoSksMaisuuKbn sindansyosksmaisuukbn;

    @Type(type="UserType_C_SindansyoSksMaisuuKbn")
    @Column(name=GenJT_Mouside.SINDANSYOSKSMAISUUKBN)
    public C_SindansyoSksMaisuuKbn getSindansyosksmaisuukbn() {
        return sindansyosksmaisuukbn;
    }

    public void setSindansyosksmaisuukbn(C_SindansyoSksMaisuuKbn pSindansyosksmaisuukbn) {
        sindansyosksmaisuukbn = pSindansyosksmaisuukbn;
    }

    private C_SindansyoSksSiteiKbn sindansyoskssiteikbn;

    @Type(type="UserType_C_SindansyoSksSiteiKbn")
    @Column(name=GenJT_Mouside.SINDANSYOSKSSITEIKBN)
    public C_SindansyoSksSiteiKbn getSindansyoskssiteikbn() {
        return sindansyoskssiteikbn;
    }

    public void setSindansyoskssiteikbn(C_SindansyoSksSiteiKbn pSindansyoskssiteikbn) {
        sindansyoskssiteikbn = pSindansyoskssiteikbn;
    }

    private Integer betukyksuu;

    @Column(name=GenJT_Mouside.BETUKYKSUU)
    public Integer getBetukyksuu() {
        return betukyksuu;
    }

    public void setBetukyksuu(Integer pBetukyksuu) {
        betukyksuu = pBetukyksuu;
    }

    private String kossyoricd;

    @Column(name=GenJT_Mouside.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_Mouside.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_Mouside.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_Mouside.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}