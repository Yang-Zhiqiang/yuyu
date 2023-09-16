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
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.id.PKJM_Byoumei;
import yuyu.def.db.meta.GenQJM_Byoumei;
import yuyu.def.db.meta.QJM_Byoumei;
import yuyu.def.db.type.UserType_C_ByoumeiGaitouKbn2;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 病名マスタ テーブルのマッピング情報クラスで、 {@link JM_Byoumei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_Byoumei}</td><td colspan="3">病名マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getByoumeitourokuno byoumeitourokuno}</td><td>病名登録番号</td><td align="center">{@link PKJM_Byoumei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeikj byoumeikj}</td><td>病名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeizenkaku byoumeizenkaku}</td><td>病名全角</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeikn byoumeikn}</td><td>病名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeiknkensaku byoumeiknkensaku}</td><td>病名（カナ）検索用</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getByoumeicd byoumeicd}</td><td>病名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaitoukbn1 gaitoukbn1}</td><td>該当区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaitoukbn2 gaitoukbn2}</td><td>該当区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ByoumeiGaitouKbn2}</td></tr>
 *  <tr><td>{@link #getGaitoukbn3 gaitoukbn3}</td><td>該当区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaitoukbn4 gaitoukbn4}</td><td>該当区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaitoukbn5 gaitoukbn5}</td><td>該当区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyuuimongon tyuuimongon}</td><td>注意文言</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_Byoumei
 * @see     PKJM_Byoumei
 * @see     QJM_Byoumei
 * @see     GenQJM_Byoumei
 */
@MappedSuperclass
@Table(name=GenJM_Byoumei.TABLE_NAME)
@IdClass(value=PKJM_Byoumei.class)
@TypeDefs({
    @TypeDef(name="UserType_C_ByoumeiGaitouKbn2", typeClass=UserType_C_ByoumeiGaitouKbn2.class)
})
public abstract class GenJM_Byoumei extends AbstractExDBEntity<JM_Byoumei, PKJM_Byoumei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_Byoumei";
    public static final String BYOUMEITOUROKUNO         = "byoumeitourokuno";
    public static final String BYOUMEIKJ                = "byoumeikj";
    public static final String BYOUMEIZENKAKU           = "byoumeizenkaku";
    public static final String BYOUMEIKN                = "byoumeikn";
    public static final String BYOUMEIKNKENSAKU         = "byoumeiknkensaku";
    public static final String BYOUMEICD                = "byoumeicd";
    public static final String GAITOUKBN1               = "gaitoukbn1";
    public static final String GAITOUKBN2               = "gaitoukbn2";
    public static final String GAITOUKBN3               = "gaitoukbn3";
    public static final String GAITOUKBN4               = "gaitoukbn4";
    public static final String GAITOUKBN5               = "gaitoukbn5";
    public static final String TYUUIMONGON              = "tyuuimongon";

    private final PKJM_Byoumei primaryKey;

    public GenJM_Byoumei() {
        primaryKey = new PKJM_Byoumei();
    }

    public GenJM_Byoumei(String pByoumeitourokuno) {
        primaryKey = new PKJM_Byoumei(pByoumeitourokuno);
    }

    @Transient
    @Override
    public PKJM_Byoumei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_Byoumei> getMetaClass() {
        return QJM_Byoumei.class;
    }

    @Id
    @Column(name=GenJM_Byoumei.BYOUMEITOUROKUNO)
    public String getByoumeitourokuno() {
        return getPrimaryKey().getByoumeitourokuno();
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        getPrimaryKey().setByoumeitourokuno(pByoumeitourokuno);
    }

    private String byoumeikj;

    @Column(name=GenJM_Byoumei.BYOUMEIKJ)
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

    private String byoumeizenkaku;

    @Column(name=GenJM_Byoumei.BYOUMEIZENKAKU)
    @MaxLength(max=100)
    @MultiByteStrings
    @InvalidCharacter
    public String getByoumeizenkaku() {
        return byoumeizenkaku;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeizenkaku(String pByoumeizenkaku) {
        byoumeizenkaku = pByoumeizenkaku;
    }

    private String byoumeikn;

    @Column(name=GenJM_Byoumei.BYOUMEIKN)
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

    private String byoumeiknkensaku;

    @Column(name=GenJM_Byoumei.BYOUMEIKNKENSAKU)
    @MaxLength(max=60)
    @MultiByteStrings
    @InvalidCharacter
    public String getByoumeiknkensaku() {
        return byoumeiknkensaku;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setByoumeiknkensaku(String pByoumeiknkensaku) {
        byoumeiknkensaku = pByoumeiknkensaku;
    }

    private String byoumeicd;

    @Column(name=GenJM_Byoumei.BYOUMEICD)
    @Length(length=4)
    @AlphaDigit
    public String getByoumeicd() {
        return byoumeicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setByoumeicd(String pByoumeicd) {
        byoumeicd = pByoumeicd;
    }

    private String gaitoukbn1;

    @Column(name=GenJM_Byoumei.GAITOUKBN1)
    public String getGaitoukbn1() {
        return gaitoukbn1;
    }

    public void setGaitoukbn1(String pGaitoukbn1) {
        gaitoukbn1 = pGaitoukbn1;
    }

    private C_ByoumeiGaitouKbn2 gaitoukbn2;

    @Type(type="UserType_C_ByoumeiGaitouKbn2")
    @Column(name=GenJM_Byoumei.GAITOUKBN2)
    public C_ByoumeiGaitouKbn2 getGaitoukbn2() {
        return gaitoukbn2;
    }

    public void setGaitoukbn2(C_ByoumeiGaitouKbn2 pGaitoukbn2) {
        gaitoukbn2 = pGaitoukbn2;
    }

    private String gaitoukbn3;

    @Column(name=GenJM_Byoumei.GAITOUKBN3)
    public String getGaitoukbn3() {
        return gaitoukbn3;
    }

    public void setGaitoukbn3(String pGaitoukbn3) {
        gaitoukbn3 = pGaitoukbn3;
    }

    private String gaitoukbn4;

    @Column(name=GenJM_Byoumei.GAITOUKBN4)
    public String getGaitoukbn4() {
        return gaitoukbn4;
    }

    public void setGaitoukbn4(String pGaitoukbn4) {
        gaitoukbn4 = pGaitoukbn4;
    }

    private String gaitoukbn5;

    @Column(name=GenJM_Byoumei.GAITOUKBN5)
    public String getGaitoukbn5() {
        return gaitoukbn5;
    }

    public void setGaitoukbn5(String pGaitoukbn5) {
        gaitoukbn5 = pGaitoukbn5;
    }

    private String tyuuimongon;

    @Column(name=GenJM_Byoumei.TYUUIMONGON)
    @MaxLength(max=35)
    @MultiByteStrings
    @InvalidCharacter
    public String getTyuuimongon() {
        return tyuuimongon;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTyuuimongon(String pTyuuimongon) {
        tyuuimongon = pTyuuimongon;
    }
}
