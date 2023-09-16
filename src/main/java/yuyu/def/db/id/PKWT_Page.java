package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.mapping.GenWT_Page;
import yuyu.def.db.meta.GenQWT_Page;
import yuyu.def.db.meta.QWT_Page;

/**
 * ページテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_Page}</td><td colspan="3">ページテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruittykymdtime syoruittykymdtime}</td><td>書類到着日時</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPageno pageno}</td><td>ページ番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>pageId</td><td>ページＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>torikomiSousasyaId</td><td>取込操作者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_Page
 * @see     GenWT_Page
 * @see     QWT_Page
 * @see     GenQWT_Page
 */
public class PKWT_Page extends AbstractExDBPrimaryKey<WT_Page, PKWT_Page> {

    private static final long serialVersionUID = 1L;

    public PKWT_Page() {
    }

    public PKWT_Page(
        String pIwfImageId,
        String pSyoruittykymdtime,
        Integer pPageno
    ) {
        iwfImageId = pIwfImageId;
        syoruittykymdtime = pSyoruittykymdtime;
        pageno = pPageno;
    }

    @Transient
    @Override
    public Class<WT_Page> getEntityClass() {
        return WT_Page.class;
    }

    private String iwfImageId;

    public String getIwfImageId() {
        return iwfImageId;
    }

    public void setIwfImageId(String pIwfImageId) {
        iwfImageId = pIwfImageId;
    }
    private String syoruittykymdtime;

    public String getSyoruittykymdtime() {
        return syoruittykymdtime;
    }

    public void setSyoruittykymdtime(String pSyoruittykymdtime) {
        syoruittykymdtime = pSyoruittykymdtime;
    }
    private Integer pageno;

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pPageno) {
        pageno = pPageno;
    }

}