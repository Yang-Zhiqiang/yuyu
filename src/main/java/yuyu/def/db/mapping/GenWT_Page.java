package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.id.PKWT_Page;
import yuyu.def.db.meta.GenQWT_Page;
import yuyu.def.db.meta.QWT_Page;

/**
 * ページテーブル テーブルのマッピング情報クラスで、 {@link WT_Page} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_Page}</td><td colspan="3">ページテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">{@link PKWT_Page ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruittykymdtime syoruittykymdtime}</td><td>書類到着日時</td><td align="center">{@link PKWT_Page ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPageno pageno}</td><td>ページ番号</td><td align="center">{@link PKWT_Page ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPageId pageId}</td><td>ページＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorikomiSousasyaId torikomiSousasyaId}</td><td>取込操作者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_Page
 * @see     PKWT_Page
 * @see     QWT_Page
 * @see     GenQWT_Page
 */
@MappedSuperclass
@Table(name=GenWT_Page.TABLE_NAME)
@IdClass(value=PKWT_Page.class)
public abstract class GenWT_Page extends AbstractExDBEntity<WT_Page, PKWT_Page> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_Page";
    public static final String IWFIMAGEID               = "iwfImageId";
    public static final String SYORUITTYKYMDTIME        = "syoruittykymdtime";
    public static final String PAGENO                   = "pageno";
    public static final String PAGEID                   = "pageId";
    public static final String TORIKOMISOUSASYAID       = "torikomiSousasyaId";

    private final PKWT_Page primaryKey;

    public GenWT_Page() {
        primaryKey = new PKWT_Page();
    }

    public GenWT_Page(
        String pIwfImageId,
        String pSyoruittykymdtime,
        Integer pPageno
    ) {
        primaryKey = new PKWT_Page(
            pIwfImageId,
            pSyoruittykymdtime,
            pPageno
        );
    }

    @Transient
    @Override
    public PKWT_Page getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_Page> getMetaClass() {
        return QWT_Page.class;
    }

    @Id
    @Column(name=GenWT_Page.IWFIMAGEID)
    public String getIwfImageId() {
        return getPrimaryKey().getIwfImageId();
    }

    public void setIwfImageId(String pIwfImageId) {
        getPrimaryKey().setIwfImageId(pIwfImageId);
    }

    @Id
    @Column(name=GenWT_Page.SYORUITTYKYMDTIME)
    public String getSyoruittykymdtime() {
        return getPrimaryKey().getSyoruittykymdtime();
    }

    public void setSyoruittykymdtime(String pSyoruittykymdtime) {
        getPrimaryKey().setSyoruittykymdtime(pSyoruittykymdtime);
    }

    @Id
    @Column(name=GenWT_Page.PAGENO)
    public Integer getPageno() {
        return getPrimaryKey().getPageno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPageno(Integer pPageno) {
        getPrimaryKey().setPageno(pPageno);
    }

    private String pageId;

    @Column(name=GenWT_Page.PAGEID)
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pPageId) {
        pageId = pPageId;
    }

    private String torikomiSousasyaId;

    @Column(name=GenWT_Page.TORIKOMISOUSASYAID)
    public String getTorikomiSousasyaId() {
        return torikomiSousasyaId;
    }

    public void setTorikomiSousasyaId(String pTorikomiSousasyaId) {
        torikomiSousasyaId = pTorikomiSousasyaId;
    }
}
