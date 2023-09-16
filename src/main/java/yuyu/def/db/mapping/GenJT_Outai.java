package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.id.PKJT_Outai;
import yuyu.def.db.meta.GenQJT_Outai;
import yuyu.def.db.meta.QJT_Outai;
import yuyu.def.db.type.UserType_C_MousideninKbn;
import yuyu.def.db.type.UserType_C_NayoseYouhi;
import yuyu.def.db.type.UserType_C_SouhusakiKbn;
import yuyu.def.db.type.UserType_C_SyuhiYouhi;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 応対テーブル テーブルのマッピング情報クラスで、 {@link JT_Outai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Outai}</td><td colspan="3">応対テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_Outai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKJT_Outai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNayoseyouhi nayoseyouhi}</td><td>名寄せ要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NayoseYouhi}</td></tr>
 *  <tr><td>{@link #getMousideninkbn mousideninkbn}</td><td>申出人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MousideninKbn}</td></tr>
 *  <tr><td>{@link #getSyuhiyouhi syuhiyouhi}</td><td>守秘要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuhiYouhi}</td></tr>
 *  <tr><td>{@link #getMousideninnmkj mousideninnmkj}</td><td>申出人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSouhusakikbn souhusakikbn}</td><td>送付先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SouhusakiKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBetukyksuu betukyksuu}</td><td>別契約数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Outai
 * @see     PKJT_Outai
 * @see     QJT_Outai
 * @see     GenQJT_Outai
 */
@MappedSuperclass
@Table(name=GenJT_Outai.TABLE_NAME)
@IdClass(value=PKJT_Outai.class)
@TypeDefs({
    @TypeDef(name="UserType_C_MousideninKbn", typeClass=UserType_C_MousideninKbn.class),
    @TypeDef(name="UserType_C_NayoseYouhi", typeClass=UserType_C_NayoseYouhi.class),
    @TypeDef(name="UserType_C_SouhusakiKbn", typeClass=UserType_C_SouhusakiKbn.class),
    @TypeDef(name="UserType_C_SyuhiYouhi", typeClass=UserType_C_SyuhiYouhi.class)
})
public abstract class GenJT_Outai extends AbstractExDBEntity<JT_Outai, PKJT_Outai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_Outai";
    public static final String SYONO                    = "syono";
    public static final String RENNO                    = "renno";
    public static final String NAYOSEYOUHI              = "nayoseyouhi";
    public static final String MOUSIDENINKBN            = "mousideninkbn";
    public static final String SYUHIYOUHI               = "syuhiyouhi";
    public static final String MOUSIDENINNMKJ           = "mousideninnmkj";
    public static final String SOUHUSAKIKBN             = "souhusakikbn";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String BETUKYKSUU               = "betukyksuu";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_Outai primaryKey;

    public GenJT_Outai() {
        primaryKey = new PKJT_Outai();
    }

    public GenJT_Outai(String pSyono, Integer pRenno) {
        primaryKey = new PKJT_Outai(pSyono, pRenno);
    }

    @Transient
    @Override
    public PKJT_Outai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_Outai> getMetaClass() {
        return QJT_Outai.class;
    }

    @Id
    @Column(name=GenJT_Outai.SYONO)
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
    @Column(name=GenJT_Outai.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_NayoseYouhi nayoseyouhi;

    @Type(type="UserType_C_NayoseYouhi")
    @Column(name=GenJT_Outai.NAYOSEYOUHI)
    public C_NayoseYouhi getNayoseyouhi() {
        return nayoseyouhi;
    }

    public void setNayoseyouhi(C_NayoseYouhi pNayoseyouhi) {
        nayoseyouhi = pNayoseyouhi;
    }

    private C_MousideninKbn mousideninkbn;

    @Type(type="UserType_C_MousideninKbn")
    @Column(name=GenJT_Outai.MOUSIDENINKBN)
    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninkbn = pMousideninkbn;
    }

    private C_SyuhiYouhi syuhiyouhi;

    @Type(type="UserType_C_SyuhiYouhi")
    @Column(name=GenJT_Outai.SYUHIYOUHI)
    public C_SyuhiYouhi getSyuhiyouhi() {
        return syuhiyouhi;
    }

    public void setSyuhiyouhi(C_SyuhiYouhi pSyuhiyouhi) {
        syuhiyouhi = pSyuhiyouhi;
    }

    private String mousideninnmkj;

    @Column(name=GenJT_Outai.MOUSIDENINNMKJ)
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

    private C_SouhusakiKbn souhusakikbn;

    @Type(type="UserType_C_SouhusakiKbn")
    @Column(name=GenJT_Outai.SOUHUSAKIKBN)
    public C_SouhusakiKbn getSouhusakikbn() {
        return souhusakikbn;
    }

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn) {
        souhusakikbn = pSouhusakikbn;
    }

    private String tsinyno;

    @Column(name=GenJT_Outai.TSINYNO)
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

    @Column(name=GenJT_Outai.TSINADR1KJ)
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

    @Column(name=GenJT_Outai.TSINADR2KJ)
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

    @Column(name=GenJT_Outai.TSINADR3KJ)
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

    @Column(name=GenJT_Outai.TSINTELNO)
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

    private Integer betukyksuu;

    @Column(name=GenJT_Outai.BETUKYKSUU)
    public Integer getBetukyksuu() {
        return betukyksuu;
    }

    public void setBetukyksuu(Integer pBetukyksuu) {
        betukyksuu = pBetukyksuu;
    }

    private String kossyoricd;

    @Column(name=GenJT_Outai.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_Outai.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_Outai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_Outai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}