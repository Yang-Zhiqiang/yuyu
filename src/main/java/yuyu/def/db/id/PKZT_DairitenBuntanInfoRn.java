package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.db.mapping.GenZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.GenQZT_DairitenBuntanInfoRn;
import yuyu.def.db.meta.QZT_DairitenBuntanInfoRn;

/**
 * 代理店手数料分担情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenBuntanInfoRn}</td><td colspan="3">代理店手数料分担情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndairitensyouhincd zrndairitensyouhincd}</td><td>（連携用）代理店商品コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntesuuryoubuntandrtencd zrntesuuryoubuntandrtencd}</td><td>（連携用）手数料分担相手代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntesuuryoubuntanstartym zrntesuuryoubuntanstartym}</td><td>（連携用）手数料分担開始年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntesuuryoubuntanendym</td><td>（連携用）手数料分担終了年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntesuuryoubuntanwariai</td><td>（連携用）手数料分担割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv67</td><td>（連携用）予備項目Ｖ６７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenBuntanInfoRn
 * @see     GenZT_DairitenBuntanInfoRn
 * @see     QZT_DairitenBuntanInfoRn
 * @see     GenQZT_DairitenBuntanInfoRn
 */
public class PKZT_DairitenBuntanInfoRn extends AbstractExDBPrimaryKey<ZT_DairitenBuntanInfoRn, PKZT_DairitenBuntanInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DairitenBuntanInfoRn() {
    }

    public PKZT_DairitenBuntanInfoRn(
        String pZrndairitencd,
        String pZrndairitensyouhincd,
        String pZrntesuuryoubuntandrtencd,
        String pZrntesuuryoubuntanstartym
    ) {
        zrndairitencd = pZrndairitencd;
        zrndairitensyouhincd = pZrndairitensyouhincd;
        zrntesuuryoubuntandrtencd = pZrntesuuryoubuntandrtencd;
        zrntesuuryoubuntanstartym = pZrntesuuryoubuntanstartym;
    }

    @Transient
    @Override
    public Class<ZT_DairitenBuntanInfoRn> getEntityClass() {
        return ZT_DairitenBuntanInfoRn.class;
    }

    private String zrndairitencd;

    public String getZrndairitencd() {
        return zrndairitencd;
    }

    public void setZrndairitencd(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }
    private String zrndairitensyouhincd;

    public String getZrndairitensyouhincd() {
        return zrndairitensyouhincd;
    }

    public void setZrndairitensyouhincd(String pZrndairitensyouhincd) {
        zrndairitensyouhincd = pZrndairitensyouhincd;
    }
    private String zrntesuuryoubuntandrtencd;

    public String getZrntesuuryoubuntandrtencd() {
        return zrntesuuryoubuntandrtencd;
    }

    public void setZrntesuuryoubuntandrtencd(String pZrntesuuryoubuntandrtencd) {
        zrntesuuryoubuntandrtencd = pZrntesuuryoubuntandrtencd;
    }
    private String zrntesuuryoubuntanstartym;

    public String getZrntesuuryoubuntanstartym() {
        return zrntesuuryoubuntanstartym;
    }

    public void setZrntesuuryoubuntanstartym(String pZrntesuuryoubuntanstartym) {
        zrntesuuryoubuntanstartym = pZrntesuuryoubuntanstartym;
    }

}