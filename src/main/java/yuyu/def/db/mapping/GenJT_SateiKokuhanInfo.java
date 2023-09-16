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
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.id.PKJT_SateiKokuhanInfo;
import yuyu.def.db.meta.GenQJT_SateiKokuhanInfo;
import yuyu.def.db.meta.QJT_SateiKokuhanInfo;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定告反情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SateiKokuhanInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiKokuhanInfo}</td><td colspan="3">査定告反情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SateiKokuhanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SateiKokuhanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SateiKokuhanInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn1 kokuhancheckkbn1}</td><td>告反チェック区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment1 kokuhanchecomment1}</td><td>告反チェックコメント１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn2 kokuhancheckkbn2}</td><td>告反チェック区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment2 kokuhanchecomment2}</td><td>告反チェックコメント２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn3 kokuhancheckkbn3}</td><td>告反チェック区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment3 kokuhanchecomment3}</td><td>告反チェックコメント３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn4 kokuhancheckkbn4}</td><td>告反チェック区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment4 kokuhanchecomment4}</td><td>告反チェックコメント４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn5 kokuhancheckkbn5}</td><td>告反チェック区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment5 kokuhanchecomment5}</td><td>告反チェックコメント５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn6 kokuhancheckkbn6}</td><td>告反チェック区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment6 kokuhanchecomment6}</td><td>告反チェックコメント６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn7 kokuhancheckkbn7}</td><td>告反チェック区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment7 kokuhanchecomment7}</td><td>告反チェックコメント７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokuhancheckkbn8 kokuhancheckkbn8}</td><td>告反チェック区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokuhanchecomment8 kokuhanchecomment8}</td><td>告反チェックコメント８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiKokuhanInfo
 * @see     PKJT_SateiKokuhanInfo
 * @see     QJT_SateiKokuhanInfo
 * @see     GenQJT_SateiKokuhanInfo
 */
@MappedSuperclass
@Table(name=GenJT_SateiKokuhanInfo.TABLE_NAME)
@IdClass(value=PKJT_SateiKokuhanInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SateiKokuhanInfo extends AbstractExDBEntity<JT_SateiKokuhanInfo, PKJT_SateiKokuhanInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SateiKokuhanInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String KOKUHANCHECKKBN1         = "kokuhancheckkbn1";
    public static final String KOKUHANCHECOMMENT1       = "kokuhanchecomment1";
    public static final String KOKUHANCHECKKBN2         = "kokuhancheckkbn2";
    public static final String KOKUHANCHECOMMENT2       = "kokuhanchecomment2";
    public static final String KOKUHANCHECKKBN3         = "kokuhancheckkbn3";
    public static final String KOKUHANCHECOMMENT3       = "kokuhanchecomment3";
    public static final String KOKUHANCHECKKBN4         = "kokuhancheckkbn4";
    public static final String KOKUHANCHECOMMENT4       = "kokuhanchecomment4";
    public static final String KOKUHANCHECKKBN5         = "kokuhancheckkbn5";
    public static final String KOKUHANCHECOMMENT5       = "kokuhanchecomment5";
    public static final String KOKUHANCHECKKBN6         = "kokuhancheckkbn6";
    public static final String KOKUHANCHECOMMENT6       = "kokuhanchecomment6";
    public static final String KOKUHANCHECKKBN7         = "kokuhancheckkbn7";
    public static final String KOKUHANCHECOMMENT7       = "kokuhanchecomment7";
    public static final String KOKUHANCHECKKBN8         = "kokuhancheckkbn8";
    public static final String KOKUHANCHECOMMENT8       = "kokuhanchecomment8";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SateiKokuhanInfo primaryKey;

    public GenJT_SateiKokuhanInfo() {
        primaryKey = new PKJT_SateiKokuhanInfo();
    }

    public GenJT_SateiKokuhanInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SateiKokuhanInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SateiKokuhanInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SateiKokuhanInfo> getMetaClass() {
        return QJT_SateiKokuhanInfo.class;
    }

    @Id
    @Column(name=GenJT_SateiKokuhanInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SateiKokuhanInfo.SYONO)
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
    @Column(name=GenJT_SateiKokuhanInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_UmuKbn kokuhancheckkbn1;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN1)
    public C_UmuKbn getKokuhancheckkbn1() {
        return kokuhancheckkbn1;
    }

    public void setKokuhancheckkbn1(C_UmuKbn pKokuhancheckkbn1) {
        kokuhancheckkbn1 = pKokuhancheckkbn1;
    }

    private String kokuhanchecomment1;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT1)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment1() {
        return kokuhanchecomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment1(String pKokuhanchecomment1) {
        kokuhanchecomment1 = pKokuhanchecomment1;
    }

    private C_UmuKbn kokuhancheckkbn2;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN2)
    public C_UmuKbn getKokuhancheckkbn2() {
        return kokuhancheckkbn2;
    }

    public void setKokuhancheckkbn2(C_UmuKbn pKokuhancheckkbn2) {
        kokuhancheckkbn2 = pKokuhancheckkbn2;
    }

    private String kokuhanchecomment2;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT2)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment2() {
        return kokuhanchecomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment2(String pKokuhanchecomment2) {
        kokuhanchecomment2 = pKokuhanchecomment2;
    }

    private C_UmuKbn kokuhancheckkbn3;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN3)
    public C_UmuKbn getKokuhancheckkbn3() {
        return kokuhancheckkbn3;
    }

    public void setKokuhancheckkbn3(C_UmuKbn pKokuhancheckkbn3) {
        kokuhancheckkbn3 = pKokuhancheckkbn3;
    }

    private String kokuhanchecomment3;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT3)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment3() {
        return kokuhanchecomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment3(String pKokuhanchecomment3) {
        kokuhanchecomment3 = pKokuhanchecomment3;
    }

    private C_UmuKbn kokuhancheckkbn4;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN4)
    public C_UmuKbn getKokuhancheckkbn4() {
        return kokuhancheckkbn4;
    }

    public void setKokuhancheckkbn4(C_UmuKbn pKokuhancheckkbn4) {
        kokuhancheckkbn4 = pKokuhancheckkbn4;
    }

    private String kokuhanchecomment4;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT4)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment4() {
        return kokuhanchecomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment4(String pKokuhanchecomment4) {
        kokuhanchecomment4 = pKokuhanchecomment4;
    }

    private C_UmuKbn kokuhancheckkbn5;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN5)
    public C_UmuKbn getKokuhancheckkbn5() {
        return kokuhancheckkbn5;
    }

    public void setKokuhancheckkbn5(C_UmuKbn pKokuhancheckkbn5) {
        kokuhancheckkbn5 = pKokuhancheckkbn5;
    }

    private String kokuhanchecomment5;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT5)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment5() {
        return kokuhanchecomment5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment5(String pKokuhanchecomment5) {
        kokuhanchecomment5 = pKokuhanchecomment5;
    }

    private C_UmuKbn kokuhancheckkbn6;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN6)
    public C_UmuKbn getKokuhancheckkbn6() {
        return kokuhancheckkbn6;
    }

    public void setKokuhancheckkbn6(C_UmuKbn pKokuhancheckkbn6) {
        kokuhancheckkbn6 = pKokuhancheckkbn6;
    }

    private String kokuhanchecomment6;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT6)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment6() {
        return kokuhanchecomment6;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment6(String pKokuhanchecomment6) {
        kokuhanchecomment6 = pKokuhanchecomment6;
    }

    private C_UmuKbn kokuhancheckkbn7;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN7)
    public C_UmuKbn getKokuhancheckkbn7() {
        return kokuhancheckkbn7;
    }

    public void setKokuhancheckkbn7(C_UmuKbn pKokuhancheckkbn7) {
        kokuhancheckkbn7 = pKokuhancheckkbn7;
    }

    private String kokuhanchecomment7;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT7)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment7() {
        return kokuhanchecomment7;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment7(String pKokuhanchecomment7) {
        kokuhanchecomment7 = pKokuhanchecomment7;
    }

    private C_UmuKbn kokuhancheckkbn8;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECKKBN8)
    public C_UmuKbn getKokuhancheckkbn8() {
        return kokuhancheckkbn8;
    }

    public void setKokuhancheckkbn8(C_UmuKbn pKokuhancheckkbn8) {
        kokuhancheckkbn8 = pKokuhancheckkbn8;
    }

    private String kokuhanchecomment8;

    @Column(name=GenJT_SateiKokuhanInfo.KOKUHANCHECOMMENT8)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKokuhanchecomment8() {
        return kokuhanchecomment8;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKokuhanchecomment8(String pKokuhanchecomment8) {
        kokuhanchecomment8 = pKokuhanchecomment8;
    }

    private String kossyoricd;

    @Column(name=GenJT_SateiKokuhanInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SateiKokuhanInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SateiKokuhanInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SateiKokuhanInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}