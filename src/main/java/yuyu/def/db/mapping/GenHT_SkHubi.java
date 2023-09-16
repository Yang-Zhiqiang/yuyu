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
import yuyu.def.classification.C_RnrkskhaneiKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.id.PKHT_SkHubi;
import yuyu.def.db.meta.GenQHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.db.type.UserType_C_RnrkskhaneiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約不備テーブル テーブルのマッピング情報クラスで、 {@link HT_SkHubi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkHubi}</td><td colspan="3">新契約不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkHubi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisikibetukey hubisikibetukey}</td><td>不備識別キー</td><td align="center">{@link PKHT_SkHubi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukinm jimutetuzukinm}</td><td>事務手続名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRnrkskhaneikbn rnrkskhaneikbn}</td><td>連絡先反映区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_RnrkskhaneiKbn}</td></tr>
 *  <tr><td>{@link #getUtdskknnm1kj utdskknnm1kj}</td><td>打出機関名１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUtdskknnm2kj utdskknnm2kj}</td><td>打出機関名２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutisakitantounmkj tuutisakitantounmkj}</td><td>通知先担当者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutikyokasyanmkj tuutikyokasyanmkj}</td><td>通知許可者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCommentarea commentarea}</td><td>コメント欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkHubi
 * @see     PKHT_SkHubi
 * @see     QHT_SkHubi
 * @see     GenQHT_SkHubi
 */
@MappedSuperclass
@Table(name=GenHT_SkHubi.TABLE_NAME)
@IdClass(value=PKHT_SkHubi.class)
@TypeDefs({
    @TypeDef(name="UserType_C_RnrkskhaneiKbn", typeClass=UserType_C_RnrkskhaneiKbn.class)
})
public abstract class GenHT_SkHubi extends AbstractExDBEntity<HT_SkHubi, PKHT_SkHubi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkHubi";
    public static final String MOSNO                    = "mosno";
    public static final String HUBISIKIBETUKEY          = "hubisikibetukey";
    public static final String JIMUTETUZUKINM           = "jimutetuzukinm";
    public static final String RNRKSKHANEIKBN           = "rnrkskhaneikbn";
    public static final String UTDSKKNNM1KJ             = "utdskknnm1kj";
    public static final String UTDSKKNNM2KJ             = "utdskknnm2kj";
    public static final String TUUTISAKITANTOUNMKJ      = "tuutisakitantounmkj";
    public static final String TUUTIKYOKASYANMKJ        = "tuutikyokasyanmkj";
    public static final String COMMENTAREA              = "commentarea";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKHT_SkHubi primaryKey;

    public GenHT_SkHubi() {
        primaryKey = new PKHT_SkHubi();
    }

    public GenHT_SkHubi(String pMosno, String pHubisikibetukey) {
        primaryKey = new PKHT_SkHubi(pMosno, pHubisikibetukey);
    }

    @Transient
    @Override
    public PKHT_SkHubi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkHubi> getMetaClass() {
        return QHT_SkHubi.class;
    }

    @Id
    @Column(name=GenHT_SkHubi.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_SkHubi.HUBISIKIBETUKEY)
    public String getHubisikibetukey() {
        return getPrimaryKey().getHubisikibetukey();
    }

    public void setHubisikibetukey(String pHubisikibetukey) {
        getPrimaryKey().setHubisikibetukey(pHubisikibetukey);
    }

    private String jimutetuzukinm;

    @Column(name=GenHT_SkHubi.JIMUTETUZUKINM)
    @InvalidCharacter
    @MaxLength(max=20)
    @MultiByteStrings
    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    @DataConvert("toMultiByte")
    public void setJimutetuzukinm(String pJimutetuzukinm) {
        jimutetuzukinm = pJimutetuzukinm;
    }

    private C_RnrkskhaneiKbn rnrkskhaneikbn;

    @Type(type="UserType_C_RnrkskhaneiKbn")
    @Column(name=GenHT_SkHubi.RNRKSKHANEIKBN)
    public C_RnrkskhaneiKbn getRnrkskhaneikbn() {
        return rnrkskhaneikbn;
    }

    public void setRnrkskhaneikbn(C_RnrkskhaneiKbn pRnrkskhaneikbn) {
        rnrkskhaneikbn = pRnrkskhaneikbn;
    }

    private String utdskknnm1kj;

    @Column(name=GenHT_SkHubi.UTDSKKNNM1KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUtdskknnm1kj() {
        return utdskknnm1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm1kj(String pUtdskknnm1kj) {
        utdskknnm1kj = pUtdskknnm1kj;
    }

    private String utdskknnm2kj;

    @Column(name=GenHT_SkHubi.UTDSKKNNM2KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUtdskknnm2kj() {
        return utdskknnm2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm2kj(String pUtdskknnm2kj) {
        utdskknnm2kj = pUtdskknnm2kj;
    }

    private String tuutisakitantounmkj;

    @Column(name=GenHT_SkHubi.TUUTISAKITANTOUNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTuutisakitantounmkj() {
        return tuutisakitantounmkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTuutisakitantounmkj(String pTuutisakitantounmkj) {
        tuutisakitantounmkj = pTuutisakitantounmkj;
    }

    private String tuutikyokasyanmkj;

    @Column(name=GenHT_SkHubi.TUUTIKYOKASYANMKJ)
    public String getTuutikyokasyanmkj() {
        return tuutikyokasyanmkj;
    }

    public void setTuutikyokasyanmkj(String pTuutikyokasyanmkj) {
        tuutikyokasyanmkj = pTuutikyokasyanmkj;
    }

    private String commentarea;

    @Column(name=GenHT_SkHubi.COMMENTAREA)
    public String getCommentarea() {
        return commentarea;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCommentarea(String pCommentarea) {
        commentarea = pCommentarea;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkHubi.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}