package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_3daiSippeiKbn;
import yuyu.def.classification.C_7daiSippeiKbn;
import yuyu.def.classification.C_GanKbn;
import yuyu.def.classification.C_KansensyouKbn;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.id.PKJT_SkByoumei;
import yuyu.def.db.meta.GenQJT_SkByoumei;
import yuyu.def.db.meta.QJT_SkByoumei;
import yuyu.def.db.type.UserType_C_3daiSippeiKbn;
import yuyu.def.db.type.UserType_C_7daiSippeiKbn;
import yuyu.def.db.type.UserType_C_GanKbn;
import yuyu.def.db.type.UserType_C_KansensyouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求病名テーブル テーブルのマッピング情報クラスで、 {@link JT_SkByoumei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkByoumei}</td><td colspan="3">請求病名テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SkByoumei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SkByoumei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SkByoumei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">{@link PKJT_SkByoumei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKJT_SkByoumei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getByoumeitourokuno byoumeitourokuno}</td><td>病名登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeikn byoumeikn}</td><td>病名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeikj byoumeikj}</td><td>病名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGankbn gankbn}</td><td>がん区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GanKbn}</td></tr>
 *  <tr><td>{@link #getSandaisippeikbn sandaisippeikbn}</td><td>３大疾病区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_3daiSippeiKbn}</td></tr>
 *  <tr><td>{@link #getNanadaisippeikbn nanadaisippeikbn}</td><td>７大疾病区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_7daiSippeiKbn}</td></tr>
 *  <tr><td>{@link #getKansensyoukbn kansensyoukbn}</td><td>感染症区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KansensyouKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkByoumei
 * @see     PKJT_SkByoumei
 * @see     QJT_SkByoumei
 * @see     GenQJT_SkByoumei
 */
@MappedSuperclass
@Table(name=GenJT_SkByoumei.TABLE_NAME)
@IdClass(value=PKJT_SkByoumei.class)
@TypeDefs({
    @TypeDef(name="UserType_C_3daiSippeiKbn", typeClass=UserType_C_3daiSippeiKbn.class),
    @TypeDef(name="UserType_C_7daiSippeiKbn", typeClass=UserType_C_7daiSippeiKbn.class),
    @TypeDef(name="UserType_C_GanKbn", typeClass=UserType_C_GanKbn.class),
    @TypeDef(name="UserType_C_KansensyouKbn", typeClass=UserType_C_KansensyouKbn.class)
})
public abstract class GenJT_SkByoumei extends AbstractExDBEntity<JT_SkByoumei, PKJT_SkByoumei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SkByoumei";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String UKETUKENO                = "uketukeno";
    public static final String RENNO                    = "renno";
    public static final String BYOUMEITOUROKUNO         = "byoumeitourokuno";
    public static final String BYOUMEIKN                = "byoumeikn";
    public static final String BYOUMEIKJ                = "byoumeikj";
    public static final String GANKBN                   = "gankbn";
    public static final String SANDAISIPPEIKBN          = "sandaisippeikbn";
    public static final String NANADAISIPPEIKBN         = "nanadaisippeikbn";
    public static final String KANSENSYOUKBN            = "kansensyoukbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SkByoumei primaryKey;

    public GenJT_SkByoumei() {
        primaryKey = new PKJT_SkByoumei();
    }

    public GenJT_SkByoumei(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        Integer pRenno
    ) {
        primaryKey = new PKJT_SkByoumei(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pUketukeno,
            pRenno
        );
    }

    @Transient
    @Override
    public PKJT_SkByoumei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SkByoumei> getMetaClass() {
        return QJT_SkByoumei.class;
    }

    @Id
    @Column(name=GenJT_SkByoumei.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SkByoumei.SYONO)
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
    @Column(name=GenJT_SkByoumei.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_SkByoumei.UKETUKENO)
    public Integer getUketukeno() {
        return getPrimaryKey().getUketukeno();
    }

    public void setUketukeno(Integer pUketukeno) {
        getPrimaryKey().setUketukeno(pUketukeno);
    }

    @Id
    @Column(name=GenJT_SkByoumei.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String byoumeitourokuno;

    @Column(name=GenJT_SkByoumei.BYOUMEITOUROKUNO)
    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

    private String byoumeikn;

    @Column(name=GenJT_SkByoumei.BYOUMEIKN)
    @MaxLength(max=60)
    @MultiByteStrings
    @InvalidCharacter
    public String getByoumeikn() {
        return byoumeikn;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeikn(String pByoumeikn) {
        byoumeikn = pByoumeikn;
    }

    private String byoumeikj;

    @Column(name=GenJT_SkByoumei.BYOUMEIKJ)
    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    public String getByoumeikj() {
        return byoumeikj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeikj(String pByoumeikj) {
        byoumeikj = pByoumeikj;
    }

    private C_GanKbn gankbn;

    @Type(type="UserType_C_GanKbn")
    @Column(name=GenJT_SkByoumei.GANKBN)
    public C_GanKbn getGankbn() {
        return gankbn;
    }

    public void setGankbn(C_GanKbn pGankbn) {
        gankbn = pGankbn;
    }

    private C_3daiSippeiKbn sandaisippeikbn;

    @Type(type="UserType_C_3daiSippeiKbn")
    @Column(name=GenJT_SkByoumei.SANDAISIPPEIKBN)
    public C_3daiSippeiKbn getSandaisippeikbn() {
        return sandaisippeikbn;
    }

    public void setSandaisippeikbn(C_3daiSippeiKbn pSandaisippeikbn) {
        sandaisippeikbn = pSandaisippeikbn;
    }

    private C_7daiSippeiKbn nanadaisippeikbn;

    @Type(type="UserType_C_7daiSippeiKbn")
    @Column(name=GenJT_SkByoumei.NANADAISIPPEIKBN)
    public C_7daiSippeiKbn getNanadaisippeikbn() {
        return nanadaisippeikbn;
    }

    public void setNanadaisippeikbn(C_7daiSippeiKbn pNanadaisippeikbn) {
        nanadaisippeikbn = pNanadaisippeikbn;
    }

    private C_KansensyouKbn kansensyoukbn;

    @Type(type="UserType_C_KansensyouKbn")
    @Column(name=GenJT_SkByoumei.KANSENSYOUKBN)
    public C_KansensyouKbn getKansensyoukbn() {
        return kansensyoukbn;
    }

    public void setKansensyoukbn(C_KansensyouKbn pKansensyoukbn) {
        kansensyoukbn = pKansensyoukbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_SkByoumei.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SkByoumei.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SkByoumei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SkByoumei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}