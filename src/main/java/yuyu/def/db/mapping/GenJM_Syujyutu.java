package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.JM_Syujyutu;
import yuyu.def.db.id.PKJM_Syujyutu;
import yuyu.def.db.meta.GenQJM_Syujyutu;
import yuyu.def.db.meta.QJM_Syujyutu;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 手術マスタ テーブルのマッピング情報クラスで、 {@link JM_Syujyutu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_Syujyutu}</td><td colspan="3">手術マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyujyututourokuno syujyututourokuno}</td><td>手術登録番号</td><td align="center">{@link PKJM_Syujyutu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd1 kjcd1}</td><td>Ｋ・Ｊコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd2 kjcd2}</td><td>Ｋ・Ｊコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd3 kjcd3}</td><td>Ｋ・Ｊコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutunmkn syujyutunmkn}</td><td>手術名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutunmkj syujyutunmkj}</td><td>手術名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyouken jyouken}</td><td>条件</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutubunruicd syujyutubunruicd}</td><td>手術分類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_Syujyutu
 * @see     PKJM_Syujyutu
 * @see     QJM_Syujyutu
 * @see     GenQJM_Syujyutu
 */
@MappedSuperclass
@Table(name=GenJM_Syujyutu.TABLE_NAME)
@IdClass(value=PKJM_Syujyutu.class)
public abstract class GenJM_Syujyutu extends AbstractExDBEntity<JM_Syujyutu, PKJM_Syujyutu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_Syujyutu";
    public static final String SYUJYUTUTOUROKUNO        = "syujyututourokuno";
    public static final String KJCD1                    = "kjcd1";
    public static final String KJCD2                    = "kjcd2";
    public static final String KJCD3                    = "kjcd3";
    public static final String SYUJYUTUNMKN             = "syujyutunmkn";
    public static final String SYUJYUTUNMKJ             = "syujyutunmkj";
    public static final String JYOUKEN                  = "jyouken";
    public static final String SYUJYUTUBUNRUICD         = "syujyutubunruicd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJM_Syujyutu primaryKey;

    public GenJM_Syujyutu() {
        primaryKey = new PKJM_Syujyutu();
    }

    public GenJM_Syujyutu(String pSyujyututourokuno) {
        primaryKey = new PKJM_Syujyutu(pSyujyututourokuno);
    }

    @Transient
    @Override
    public PKJM_Syujyutu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_Syujyutu> getMetaClass() {
        return QJM_Syujyutu.class;
    }

    @Id
    @Column(name=GenJM_Syujyutu.SYUJYUTUTOUROKUNO)
    public String getSyujyututourokuno() {
        return getPrimaryKey().getSyujyututourokuno();
    }

    public void setSyujyututourokuno(String pSyujyututourokuno) {
        getPrimaryKey().setSyujyututourokuno(pSyujyututourokuno);
    }

    private String kjcd1;

    @Column(name=GenJM_Syujyutu.KJCD1)
    public String getKjcd1() {
        return kjcd1;
    }

    public void setKjcd1(String pKjcd1) {
        kjcd1 = pKjcd1;
    }

    private String kjcd2;

    @Column(name=GenJM_Syujyutu.KJCD2)
    public String getKjcd2() {
        return kjcd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKjcd2(String pKjcd2) {
        kjcd2 = pKjcd2;
    }

    private String kjcd3;

    @Column(name=GenJM_Syujyutu.KJCD3)
    public String getKjcd3() {
        return kjcd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKjcd3(String pKjcd3) {
        kjcd3 = pKjcd3;
    }

    private String syujyutunmkn;

    @Column(name=GenJM_Syujyutu.SYUJYUTUNMKN)
    public String getSyujyutunmkn() {
        return syujyutunmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyujyutunmkn(String pSyujyutunmkn) {
        syujyutunmkn = pSyujyutunmkn;
    }

    private String syujyutunmkj;

    @Column(name=GenJM_Syujyutu.SYUJYUTUNMKJ)
    public String getSyujyutunmkj() {
        return syujyutunmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyujyutunmkj(String pSyujyutunmkj) {
        syujyutunmkj = pSyujyutunmkj;
    }

    private String jyouken;

    @Column(name=GenJM_Syujyutu.JYOUKEN)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getJyouken() {
        return jyouken;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setJyouken(String pJyouken) {
        jyouken = pJyouken;
    }

    private String syujyutubunruicd;

    @Column(name=GenJM_Syujyutu.SYUJYUTUBUNRUICD)
    @MaxLength(max=3)
    @AlphaDigit
    @SingleByteStrings
    public String getSyujyutubunruicd() {
        return syujyutubunruicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyujyutubunruicd(String pSyujyutubunruicd) {
        syujyutubunruicd = pSyujyutubunruicd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJM_Syujyutu.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJM_Syujyutu.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
