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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.id.PKJT_SateiIppanHanteiInfo;
import yuyu.def.db.meta.GenQJT_SateiIppanHanteiInfo;
import yuyu.def.db.meta.QJT_SateiIppanHanteiInfo;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定一般判定情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SateiIppanHanteiInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiIppanHanteiInfo}</td><td colspan="3">査定一般判定情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SateiIppanHanteiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SateiIppanHanteiInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SateiIppanHanteiInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuu1 ippanhanteitensuu1}</td><td>一般判定点数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteicomment1 ippanhanteicomment1}</td><td>一般判定コメント１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuu2 ippanhanteitensuu2}</td><td>一般判定点数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteicomment2 ippanhanteicomment2}</td><td>一般判定コメント２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuu3 ippanhanteitensuu3}</td><td>一般判定点数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteicomment3 ippanhanteicomment3}</td><td>一般判定コメント３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuu4 ippanhanteitensuu4}</td><td>一般判定点数４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteicomment4 ippanhanteicomment4}</td><td>一般判定コメント４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuu5 ippanhanteitensuu5}</td><td>一般判定点数５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteicomment5 ippanhanteicomment5}</td><td>一般判定コメント５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuu6 ippanhanteitensuu6}</td><td>一般判定点数６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteicomment6 ippanhanteicomment6}</td><td>一般判定コメント６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteitensuugoukei ippanhanteitensuugoukei}</td><td>一般判定点数合計</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIppanhanteigoukeicomment ippanhanteigoukeicomment}</td><td>一般判定合計コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiIppanHanteiInfo
 * @see     PKJT_SateiIppanHanteiInfo
 * @see     QJT_SateiIppanHanteiInfo
 * @see     GenQJT_SateiIppanHanteiInfo
 */
@MappedSuperclass
@Table(name=GenJT_SateiIppanHanteiInfo.TABLE_NAME)
@IdClass(value=PKJT_SateiIppanHanteiInfo.class)
public abstract class GenJT_SateiIppanHanteiInfo extends AbstractExDBEntity<JT_SateiIppanHanteiInfo, PKJT_SateiIppanHanteiInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SateiIppanHanteiInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String IPPANHANTEITENSUU1       = "ippanhanteitensuu1";
    public static final String IPPANHANTEICOMMENT1      = "ippanhanteicomment1";
    public static final String IPPANHANTEITENSUU2       = "ippanhanteitensuu2";
    public static final String IPPANHANTEICOMMENT2      = "ippanhanteicomment2";
    public static final String IPPANHANTEITENSUU3       = "ippanhanteitensuu3";
    public static final String IPPANHANTEICOMMENT3      = "ippanhanteicomment3";
    public static final String IPPANHANTEITENSUU4       = "ippanhanteitensuu4";
    public static final String IPPANHANTEICOMMENT4      = "ippanhanteicomment4";
    public static final String IPPANHANTEITENSUU5       = "ippanhanteitensuu5";
    public static final String IPPANHANTEICOMMENT5      = "ippanhanteicomment5";
    public static final String IPPANHANTEITENSUU6       = "ippanhanteitensuu6";
    public static final String IPPANHANTEICOMMENT6      = "ippanhanteicomment6";
    public static final String IPPANHANTEITENSUUGOUKEI  = "ippanhanteitensuugoukei";
    public static final String IPPANHANTEIGOUKEICOMMENT = "ippanhanteigoukeicomment";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SateiIppanHanteiInfo primaryKey;

    public GenJT_SateiIppanHanteiInfo() {
        primaryKey = new PKJT_SateiIppanHanteiInfo();
    }

    public GenJT_SateiIppanHanteiInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SateiIppanHanteiInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SateiIppanHanteiInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SateiIppanHanteiInfo> getMetaClass() {
        return QJT_SateiIppanHanteiInfo.class;
    }

    @Id
    @Column(name=GenJT_SateiIppanHanteiInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SateiIppanHanteiInfo.SYONO)
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
    @Column(name=GenJT_SateiIppanHanteiInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private String ippanhanteitensuu1;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUU1)
    @Pattern(regex=("([0-5])"))
    @SingleByteStrings
    public String getIppanhanteitensuu1() {
        return ippanhanteitensuu1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu1(String pIppanhanteitensuu1) {
        ippanhanteitensuu1 = pIppanhanteitensuu1;
    }

    private String ippanhanteicomment1;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEICOMMENT1)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteicomment1() {
        return ippanhanteicomment1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment1(String pIppanhanteicomment1) {
        ippanhanteicomment1 = pIppanhanteicomment1;
    }

    private String ippanhanteitensuu2;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUU2)
    @Pattern(regex=("([0-5])"))
    @SingleByteStrings
    public String getIppanhanteitensuu2() {
        return ippanhanteitensuu2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu2(String pIppanhanteitensuu2) {
        ippanhanteitensuu2 = pIppanhanteitensuu2;
    }

    private String ippanhanteicomment2;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEICOMMENT2)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteicomment2() {
        return ippanhanteicomment2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment2(String pIppanhanteicomment2) {
        ippanhanteicomment2 = pIppanhanteicomment2;
    }

    private String ippanhanteitensuu3;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUU3)
    @Pattern(regex=("([013])"))
    @SingleByteStrings
    public String getIppanhanteitensuu3() {
        return ippanhanteitensuu3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu3(String pIppanhanteitensuu3) {
        ippanhanteitensuu3 = pIppanhanteitensuu3;
    }

    private String ippanhanteicomment3;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEICOMMENT3)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteicomment3() {
        return ippanhanteicomment3;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment3(String pIppanhanteicomment3) {
        ippanhanteicomment3 = pIppanhanteicomment3;
    }

    private String ippanhanteitensuu4;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUU4)
    @Pattern(regex=("([0-2])"))
    @SingleByteStrings
    public String getIppanhanteitensuu4() {
        return ippanhanteitensuu4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu4(String pIppanhanteitensuu4) {
        ippanhanteitensuu4 = pIppanhanteitensuu4;
    }

    private String ippanhanteicomment4;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEICOMMENT4)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteicomment4() {
        return ippanhanteicomment4;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment4(String pIppanhanteicomment4) {
        ippanhanteicomment4 = pIppanhanteicomment4;
    }

    private String ippanhanteitensuu5;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUU5)
    @Pattern(regex=("([0-2])"))
    @SingleByteStrings
    public String getIppanhanteitensuu5() {
        return ippanhanteitensuu5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu5(String pIppanhanteitensuu5) {
        ippanhanteitensuu5 = pIppanhanteitensuu5;
    }

    private String ippanhanteicomment5;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEICOMMENT5)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteicomment5() {
        return ippanhanteicomment5;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment5(String pIppanhanteicomment5) {
        ippanhanteicomment5 = pIppanhanteicomment5;
    }

    private String ippanhanteitensuu6;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUU6)
    @Pattern(regex=("([0-1])"))
    @SingleByteStrings
    public String getIppanhanteitensuu6() {
        return ippanhanteitensuu6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuu6(String pIppanhanteitensuu6) {
        ippanhanteitensuu6 = pIppanhanteitensuu6;
    }

    private String ippanhanteicomment6;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEICOMMENT6)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteicomment6() {
        return ippanhanteicomment6;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteicomment6(String pIppanhanteicomment6) {
        ippanhanteicomment6 = pIppanhanteicomment6;
    }

    private String ippanhanteitensuugoukei;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEITENSUUGOUKEI)
    @MaxLength(max=2)
    @Digit
    public String getIppanhanteitensuugoukei() {
        return ippanhanteitensuugoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIppanhanteitensuugoukei(String pIppanhanteitensuugoukei) {
        ippanhanteitensuugoukei = pIppanhanteitensuugoukei;
    }

    private String ippanhanteigoukeicomment;

    @Column(name=GenJT_SateiIppanHanteiInfo.IPPANHANTEIGOUKEICOMMENT)
    @MultiByteStrings
    @MaxLength(max=30)
    @InvalidCharacter
    public String getIppanhanteigoukeicomment() {
        return ippanhanteigoukeicomment;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setIppanhanteigoukeicomment(String pIppanhanteigoukeicomment) {
        ippanhanteigoukeicomment = pIppanhanteigoukeicomment;
    }

    private String kossyoricd;

    @Column(name=GenJT_SateiIppanHanteiInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SateiIppanHanteiInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SateiIppanHanteiInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SateiIppanHanteiInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}