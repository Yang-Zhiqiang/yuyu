package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.mapping.GenWT_PDFHozon;
import yuyu.def.db.meta.GenQWT_PDFHozon;
import yuyu.def.db.meta.QWT_PDFHozon;

/**
 * ＰＤＦ保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_PDFHozon}</td><td colspan="3">ＰＤＦ保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPageId pageId}</td><td>ページＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pdfData</td><td>ＰＤＦデータ</td><td>&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     WT_PDFHozon
 * @see     GenWT_PDFHozon
 * @see     QWT_PDFHozon
 * @see     GenQWT_PDFHozon
 */
public class PKWT_PDFHozon extends AbstractExDBPrimaryKey<WT_PDFHozon, PKWT_PDFHozon> {

    private static final long serialVersionUID = 1L;

    public PKWT_PDFHozon() {
    }

    public PKWT_PDFHozon(String pIwfImageId, String pPageId) {
        iwfImageId = pIwfImageId;
        pageId = pPageId;
    }

    @Transient
    @Override
    public Class<WT_PDFHozon> getEntityClass() {
        return WT_PDFHozon.class;
    }

    private String iwfImageId;

    public String getIwfImageId() {
        return iwfImageId;
    }

    public void setIwfImageId(String pIwfImageId) {
        iwfImageId = pIwfImageId;
    }
    private String pageId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pPageId) {
        pageId = pPageId;
    }

}