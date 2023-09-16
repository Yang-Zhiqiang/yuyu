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
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.id.PKJT_SateiJyuukasituChkInfo;
import yuyu.def.db.meta.GenQJT_SateiJyuukasituChkInfo;
import yuyu.def.db.meta.QJT_SateiJyuukasituChkInfo;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定重過失チェック情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SateiJyuukasituChkInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiJyuukasituChkInfo}</td><td colspan="3">査定重過失チェック情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SateiJyuukasituChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SateiJyuukasituChkInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SateiJyuukasituChkInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJuukasitucheckkbn1 juukasitucheckkbn1}</td><td>重過失チェック区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJuukasitucheckcomment1 juukasitucheckcomment1}</td><td>重過失チェックコメント１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJuukasitucheckkbn2 juukasitucheckkbn2}</td><td>重過失チェック区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJuukasitucheckcomment2 juukasitucheckcomment2}</td><td>重過失チェックコメント２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJuukasitucheckkbn3 juukasitucheckkbn3}</td><td>重過失チェック区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJuukasitucheckcomment3 juukasitucheckcomment3}</td><td>重過失チェックコメント３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJuukasitucheckkbn4 juukasitucheckkbn4}</td><td>重過失チェック区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJuukasitucheckcomment4 juukasitucheckcomment4}</td><td>重過失チェックコメント４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiJyuukasituChkInfo
 * @see     PKJT_SateiJyuukasituChkInfo
 * @see     QJT_SateiJyuukasituChkInfo
 * @see     GenQJT_SateiJyuukasituChkInfo
 */
@MappedSuperclass
@Table(name=GenJT_SateiJyuukasituChkInfo.TABLE_NAME)
@IdClass(value=PKJT_SateiJyuukasituChkInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SateiJyuukasituChkInfo extends AbstractExDBEntity<JT_SateiJyuukasituChkInfo, PKJT_SateiJyuukasituChkInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SateiJyuukasituChkInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String JUUKASITUCHECKKBN1       = "juukasitucheckkbn1";
    public static final String JUUKASITUCHECKCOMMENT1   = "juukasitucheckcomment1";
    public static final String JUUKASITUCHECKKBN2       = "juukasitucheckkbn2";
    public static final String JUUKASITUCHECKCOMMENT2   = "juukasitucheckcomment2";
    public static final String JUUKASITUCHECKKBN3       = "juukasitucheckkbn3";
    public static final String JUUKASITUCHECKCOMMENT3   = "juukasitucheckcomment3";
    public static final String JUUKASITUCHECKKBN4       = "juukasitucheckkbn4";
    public static final String JUUKASITUCHECKCOMMENT4   = "juukasitucheckcomment4";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SateiJyuukasituChkInfo primaryKey;

    public GenJT_SateiJyuukasituChkInfo() {
        primaryKey = new PKJT_SateiJyuukasituChkInfo();
    }

    public GenJT_SateiJyuukasituChkInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SateiJyuukasituChkInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SateiJyuukasituChkInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SateiJyuukasituChkInfo> getMetaClass() {
        return QJT_SateiJyuukasituChkInfo.class;
    }

    @Id
    @Column(name=GenJT_SateiJyuukasituChkInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SateiJyuukasituChkInfo.SYONO)
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
    @Column(name=GenJT_SateiJyuukasituChkInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_UmuKbn juukasitucheckkbn1;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKKBN1)
    public C_UmuKbn getJuukasitucheckkbn1() {
        return juukasitucheckkbn1;
    }

    public void setJuukasitucheckkbn1(C_UmuKbn pJuukasitucheckkbn1) {
        juukasitucheckkbn1 = pJuukasitucheckkbn1;
    }

    private String juukasitucheckcomment1;

    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKCOMMENT1)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getJuukasitucheckcomment1() {
        return juukasitucheckcomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment1(String pJuukasitucheckcomment1) {
        juukasitucheckcomment1 = pJuukasitucheckcomment1;
    }

    private C_UmuKbn juukasitucheckkbn2;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKKBN2)
    public C_UmuKbn getJuukasitucheckkbn2() {
        return juukasitucheckkbn2;
    }

    public void setJuukasitucheckkbn2(C_UmuKbn pJuukasitucheckkbn2) {
        juukasitucheckkbn2 = pJuukasitucheckkbn2;
    }

    private String juukasitucheckcomment2;

    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKCOMMENT2)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getJuukasitucheckcomment2() {
        return juukasitucheckcomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment2(String pJuukasitucheckcomment2) {
        juukasitucheckcomment2 = pJuukasitucheckcomment2;
    }

    private C_UmuKbn juukasitucheckkbn3;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKKBN3)
    public C_UmuKbn getJuukasitucheckkbn3() {
        return juukasitucheckkbn3;
    }

    public void setJuukasitucheckkbn3(C_UmuKbn pJuukasitucheckkbn3) {
        juukasitucheckkbn3 = pJuukasitucheckkbn3;
    }

    private String juukasitucheckcomment3;

    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKCOMMENT3)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getJuukasitucheckcomment3() {
        return juukasitucheckcomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment3(String pJuukasitucheckcomment3) {
        juukasitucheckcomment3 = pJuukasitucheckcomment3;
    }

    private C_UmuKbn juukasitucheckkbn4;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKKBN4)
    public C_UmuKbn getJuukasitucheckkbn4() {
        return juukasitucheckkbn4;
    }

    public void setJuukasitucheckkbn4(C_UmuKbn pJuukasitucheckkbn4) {
        juukasitucheckkbn4 = pJuukasitucheckkbn4;
    }

    private String juukasitucheckcomment4;

    @Column(name=GenJT_SateiJyuukasituChkInfo.JUUKASITUCHECKCOMMENT4)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getJuukasitucheckcomment4() {
        return juukasitucheckcomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setJuukasitucheckcomment4(String pJuukasitucheckcomment4) {
        juukasitucheckcomment4 = pJuukasitucheckcomment4;
    }

    private String kossyoricd;

    @Column(name=GenJT_SateiJyuukasituChkInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SateiJyuukasituChkInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SateiJyuukasituChkInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SateiJyuukasituChkInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}