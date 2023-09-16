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
import yuyu.def.db.entity.JT_KoudosgKeizenChkInfo;
import yuyu.def.db.id.PKJT_KoudosgKeizenChkInfo;
import yuyu.def.db.meta.GenQJT_KoudosgKeizenChkInfo;
import yuyu.def.db.meta.QJT_KoudosgKeizenChkInfo;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 高度障害契前チェック情報テーブル テーブルのマッピング情報クラスで、 {@link JT_KoudosgKeizenChkInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_KoudosgKeizenChkInfo}</td><td colspan="3">高度障害契前チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_KoudosgKeizenChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_KoudosgKeizenChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_KoudosgKeizenChkInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKeizencheckkbn1 keizencheckkbn1}</td><td>契前チェック区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizenchecomment1 keizenchecomment1}</td><td>契前チェックコメント１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizencheckkbn2 keizencheckkbn2}</td><td>契前チェック区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizenchecomment2 keizenchecomment2}</td><td>契前チェックコメント２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizencheckkbn3 keizencheckkbn3}</td><td>契前チェック区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizenchecomment3 keizenchecomment3}</td><td>契前チェックコメント３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizencheckkbn4 keizencheckkbn4}</td><td>契前チェック区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizenchecomment4 keizenchecomment4}</td><td>契前チェックコメント４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizencheckkbn5 keizencheckkbn5}</td><td>契前チェック区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizenchecomment5 keizenchecomment5}</td><td>契前チェックコメント５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizencheckkbn6 keizencheckkbn6}</td><td>契前チェック区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizenchecomment6 keizenchecomment6}</td><td>契前チェックコメント６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_KoudosgKeizenChkInfo
 * @see     PKJT_KoudosgKeizenChkInfo
 * @see     QJT_KoudosgKeizenChkInfo
 * @see     GenQJT_KoudosgKeizenChkInfo
 */
@MappedSuperclass
@Table(name=GenJT_KoudosgKeizenChkInfo.TABLE_NAME)
@IdClass(value=PKJT_KoudosgKeizenChkInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_KoudosgKeizenChkInfo extends AbstractExDBEntity<JT_KoudosgKeizenChkInfo, PKJT_KoudosgKeizenChkInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_KoudosgKeizenChkInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String KEIZENCHECKKBN1          = "keizencheckkbn1";
    public static final String KEIZENCHECOMMENT1        = "keizenchecomment1";
    public static final String KEIZENCHECKKBN2          = "keizencheckkbn2";
    public static final String KEIZENCHECOMMENT2        = "keizenchecomment2";
    public static final String KEIZENCHECKKBN3          = "keizencheckkbn3";
    public static final String KEIZENCHECOMMENT3        = "keizenchecomment3";
    public static final String KEIZENCHECKKBN4          = "keizencheckkbn4";
    public static final String KEIZENCHECOMMENT4        = "keizenchecomment4";
    public static final String KEIZENCHECKKBN5          = "keizencheckkbn5";
    public static final String KEIZENCHECOMMENT5        = "keizenchecomment5";
    public static final String KEIZENCHECKKBN6          = "keizencheckkbn6";
    public static final String KEIZENCHECOMMENT6        = "keizenchecomment6";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_KoudosgKeizenChkInfo primaryKey;

    public GenJT_KoudosgKeizenChkInfo() {
        primaryKey = new PKJT_KoudosgKeizenChkInfo();
    }

    public GenJT_KoudosgKeizenChkInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_KoudosgKeizenChkInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_KoudosgKeizenChkInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_KoudosgKeizenChkInfo> getMetaClass() {
        return QJT_KoudosgKeizenChkInfo.class;
    }

    @Id
    @Column(name=GenJT_KoudosgKeizenChkInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_KoudosgKeizenChkInfo.SYONO)
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
    @Column(name=GenJT_KoudosgKeizenChkInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_UmuKbn keizencheckkbn1;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECKKBN1)
    public C_UmuKbn getKeizencheckkbn1() {
        return keizencheckkbn1;
    }

    public void setKeizencheckkbn1(C_UmuKbn pKeizencheckkbn1) {
        keizencheckkbn1 = pKeizencheckkbn1;
    }

    private String keizenchecomment1;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECOMMENT1)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKeizenchecomment1() {
        return keizenchecomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKeizenchecomment1(String pKeizenchecomment1) {
        keizenchecomment1 = pKeizenchecomment1;
    }

    private C_UmuKbn keizencheckkbn2;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECKKBN2)
    public C_UmuKbn getKeizencheckkbn2() {
        return keizencheckkbn2;
    }

    public void setKeizencheckkbn2(C_UmuKbn pKeizencheckkbn2) {
        keizencheckkbn2 = pKeizencheckkbn2;
    }

    private String keizenchecomment2;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECOMMENT2)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKeizenchecomment2() {
        return keizenchecomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKeizenchecomment2(String pKeizenchecomment2) {
        keizenchecomment2 = pKeizenchecomment2;
    }

    private C_UmuKbn keizencheckkbn3;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECKKBN3)
    public C_UmuKbn getKeizencheckkbn3() {
        return keizencheckkbn3;
    }

    public void setKeizencheckkbn3(C_UmuKbn pKeizencheckkbn3) {
        keizencheckkbn3 = pKeizencheckkbn3;
    }

    private String keizenchecomment3;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECOMMENT3)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKeizenchecomment3() {
        return keizenchecomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKeizenchecomment3(String pKeizenchecomment3) {
        keizenchecomment3 = pKeizenchecomment3;
    }

    private C_UmuKbn keizencheckkbn4;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECKKBN4)
    public C_UmuKbn getKeizencheckkbn4() {
        return keizencheckkbn4;
    }

    public void setKeizencheckkbn4(C_UmuKbn pKeizencheckkbn4) {
        keizencheckkbn4 = pKeizencheckkbn4;
    }

    private String keizenchecomment4;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECOMMENT4)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKeizenchecomment4() {
        return keizenchecomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKeizenchecomment4(String pKeizenchecomment4) {
        keizenchecomment4 = pKeizenchecomment4;
    }

    private C_UmuKbn keizencheckkbn5;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECKKBN5)
    public C_UmuKbn getKeizencheckkbn5() {
        return keizencheckkbn5;
    }

    public void setKeizencheckkbn5(C_UmuKbn pKeizencheckkbn5) {
        keizencheckkbn5 = pKeizencheckkbn5;
    }

    private String keizenchecomment5;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECOMMENT5)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKeizenchecomment5() {
        return keizenchecomment5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKeizenchecomment5(String pKeizenchecomment5) {
        keizenchecomment5 = pKeizenchecomment5;
    }

    private C_UmuKbn keizencheckkbn6;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECKKBN6)
    public C_UmuKbn getKeizencheckkbn6() {
        return keizencheckkbn6;
    }

    public void setKeizencheckkbn6(C_UmuKbn pKeizencheckkbn6) {
        keizencheckkbn6 = pKeizencheckkbn6;
    }

    private String keizenchecomment6;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KEIZENCHECOMMENT6)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getKeizenchecomment6() {
        return keizenchecomment6;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKeizenchecomment6(String pKeizenchecomment6) {
        keizenchecomment6 = pKeizenchecomment6;
    }

    private String kossyoricd;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_KoudosgKeizenChkInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_KoudosgKeizenChkInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_KoudosgKeizenChkInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}