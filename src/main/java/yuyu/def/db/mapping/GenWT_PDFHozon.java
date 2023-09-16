package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.id.PKWT_PDFHozon;
import yuyu.def.db.meta.GenQWT_PDFHozon;
import yuyu.def.db.meta.QWT_PDFHozon;

/**
 * ＰＤＦ保存テーブル テーブルのマッピング情報クラスで、 {@link WT_PDFHozon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_PDFHozon}</td><td colspan="3">ＰＤＦ保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">{@link PKWT_PDFHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPageId pageId}</td><td>ページＩＤ</td><td align="center">{@link PKWT_PDFHozon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPdfData pdfData}</td><td>ＰＤＦデータ</td><td align="center">&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     WT_PDFHozon
 * @see     PKWT_PDFHozon
 * @see     QWT_PDFHozon
 * @see     GenQWT_PDFHozon
 */
@MappedSuperclass
@Table(name=GenWT_PDFHozon.TABLE_NAME)
@IdClass(value=PKWT_PDFHozon.class)
public abstract class GenWT_PDFHozon extends AbstractExDBEntity<WT_PDFHozon, PKWT_PDFHozon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_PDFHozon";
    public static final String IWFIMAGEID               = "iwfImageId";
    public static final String PAGEID                   = "pageId";
    public static final String PDFDATA                  = "pdfData";

    private final PKWT_PDFHozon primaryKey;

    public GenWT_PDFHozon() {
        primaryKey = new PKWT_PDFHozon();
    }

    public GenWT_PDFHozon(String pIwfImageId, String pPageId) {
        primaryKey = new PKWT_PDFHozon(pIwfImageId, pPageId);
    }

    @Transient
    @Override
    public PKWT_PDFHozon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_PDFHozon> getMetaClass() {
        return QWT_PDFHozon.class;
    }

    @Id
    @Column(name=GenWT_PDFHozon.IWFIMAGEID)
    public String getIwfImageId() {
        return getPrimaryKey().getIwfImageId();
    }

    public void setIwfImageId(String pIwfImageId) {
        getPrimaryKey().setIwfImageId(pIwfImageId);
    }

    @Id
    @Column(name=GenWT_PDFHozon.PAGEID)
    public String getPageId() {
        return getPrimaryKey().getPageId();
    }

    public void setPageId(String pPageId) {
        getPrimaryKey().setPageId(pPageId);
    }

    private byte[] pdfData;

    @Column(name=GenWT_PDFHozon.PDFDATA)
    public byte[] getPdfData() {
        return pdfData;
    }

    public void setPdfData(byte[] pPdfData) {
        pdfData = pPdfData;
    }
}
