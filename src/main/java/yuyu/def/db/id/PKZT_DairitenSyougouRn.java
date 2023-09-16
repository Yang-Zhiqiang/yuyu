package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.db.mapping.GenZT_DairitenSyougouRn;
import yuyu.def.db.meta.GenQZT_DairitenSyougouRn;
import yuyu.def.db.meta.QZT_DairitenSyougouRn;

/**
 * 代理店法人商号連動ＵＬＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenSyougouRn}</td><td colspan="3">代理店法人商号連動ＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjihoujinsyougou</td><td>（連携用）漢字法人商号</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv13</td><td>（連携用）予備項目Ｖ１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenSyougouRn
 * @see     GenZT_DairitenSyougouRn
 * @see     QZT_DairitenSyougouRn
 * @see     GenQZT_DairitenSyougouRn
 */
public class PKZT_DairitenSyougouRn extends AbstractExDBPrimaryKey<ZT_DairitenSyougouRn, PKZT_DairitenSyougouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DairitenSyougouRn() {
    }

    public PKZT_DairitenSyougouRn(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }

    @Transient
    @Override
    public Class<ZT_DairitenSyougouRn> getEntityClass() {
        return ZT_DairitenSyougouRn.class;
    }

    private String zrndairitencd;

    public String getZrndairitencd() {
        return zrndairitencd;
    }

    public void setZrndairitencd(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }

}