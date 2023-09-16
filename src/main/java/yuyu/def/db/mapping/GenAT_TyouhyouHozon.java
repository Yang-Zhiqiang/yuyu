package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.id.PKAT_TyouhyouHozon;
import yuyu.def.db.meta.GenQAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouHozon;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * 帳票保存テーブル テーブルのマッピング情報クラスで、 {@link AT_TyouhyouHozon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_TyouhyouHozon}</td><td colspan="3">帳票保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getReportKey reportKey}</td><td>帳票キー</td><td align="center">{@link PKAT_TyouhyouHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPdfData pdfData}</td><td>ＰＤＦデータ</td><td align="center">&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 *  <tr><td>{@link #getTyouhyouJoinKey tyouhyouJoinKey}</td><td>帳票結合キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAngoukaKbn angoukaKbn}</td><td>暗号化区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getPdfHozonKbn pdfHozonKbn}</td><td>ＰＤＦ保存区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getZipHozonKbn zipHozonKbn}</td><td>ＺＩＰ保存区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 * </table>
 * @see     AT_TyouhyouHozon
 * @see     PKAT_TyouhyouHozon
 * @see     QAT_TyouhyouHozon
 * @see     GenQAT_TyouhyouHozon
 */
@MappedSuperclass
@Table(name=GenAT_TyouhyouHozon.TABLE_NAME)
@IdClass(value=PKAT_TyouhyouHozon.class)
@TypeDefs({
    @TypeDef(name="UserType_C_YesNoKbn", typeClass=UserType_C_YesNoKbn.class)
})
public abstract class GenAT_TyouhyouHozon extends AbstractExDBEntity<AT_TyouhyouHozon, PKAT_TyouhyouHozon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_TyouhyouHozon";
    public static final String REPORTKEY                = "reportKey";
    public static final String PDFDATA                  = "pdfData";
    public static final String TYOUHYOUJOINKEY          = "tyouhyouJoinKey";
    public static final String ANGOUKAKBN               = "angoukaKbn";
    public static final String PDFHOZONKBN              = "pdfHozonKbn";
    public static final String ZIPHOZONKBN              = "zipHozonKbn";

    private final PKAT_TyouhyouHozon primaryKey;

    public GenAT_TyouhyouHozon() {
        primaryKey = new PKAT_TyouhyouHozon();
    }

    public GenAT_TyouhyouHozon(String pReportKey) {
        primaryKey = new PKAT_TyouhyouHozon(pReportKey);
    }

    @Transient
    @Override
    public PKAT_TyouhyouHozon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_TyouhyouHozon> getMetaClass() {
        return QAT_TyouhyouHozon.class;
    }

    @Id
    @Column(name=GenAT_TyouhyouHozon.REPORTKEY)
    public String getReportKey() {
        return getPrimaryKey().getReportKey();
    }

    public void setReportKey(String pReportKey) {
        getPrimaryKey().setReportKey(pReportKey);
    }

    private byte[] pdfData;

    @Column(name=GenAT_TyouhyouHozon.PDFDATA)
    public byte[] getPdfData() {
        return pdfData;
    }

    public void setPdfData(byte[] pPdfData) {
        pdfData = pPdfData;
    }

    private String tyouhyouJoinKey;

    @Column(name=GenAT_TyouhyouHozon.TYOUHYOUJOINKEY)
    public String getTyouhyouJoinKey() {
        return tyouhyouJoinKey;
    }

    public void setTyouhyouJoinKey(String pTyouhyouJoinKey) {
        tyouhyouJoinKey = pTyouhyouJoinKey;
    }

    private C_YesNoKbn angoukaKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAT_TyouhyouHozon.ANGOUKAKBN)
    public C_YesNoKbn getAngoukaKbn() {
        return angoukaKbn;
    }

    public void setAngoukaKbn(C_YesNoKbn pAngoukaKbn) {
        angoukaKbn = pAngoukaKbn;
    }

    private C_YesNoKbn pdfHozonKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAT_TyouhyouHozon.PDFHOZONKBN)
    public C_YesNoKbn getPdfHozonKbn() {
        return pdfHozonKbn;
    }

    public void setPdfHozonKbn(C_YesNoKbn pPdfHozonKbn) {
        pdfHozonKbn = pPdfHozonKbn;
    }

    private C_YesNoKbn zipHozonKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAT_TyouhyouHozon.ZIPHOZONKBN)
    public C_YesNoKbn getZipHozonKbn() {
        return zipHozonKbn;
    }

    public void setZipHozonKbn(C_YesNoKbn pZipHozonKbn) {
        zipHozonKbn = pZipHozonKbn;
    }
}
