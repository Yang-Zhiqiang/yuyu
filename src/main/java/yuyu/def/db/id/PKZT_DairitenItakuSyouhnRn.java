package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;
import yuyu.def.db.mapping.GenZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.GenQZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.QZT_DairitenItakuSyouhnRn;

/**
 * 代理店委託商品情報用連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenItakuSyouhnRn}</td><td colspan="3">代理店委託商品情報用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndrtsyouhinsikibetukbnstr zrndrtsyouhinsikibetukbnstr}</td><td>（連携用）代理店商品識別区分（文字列）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndrthrkhouhoukbn zrndrthrkhouhoukbn}</td><td>（連携用）代理店払込方法区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndrtplannmkbn zrndrtplannmkbn}</td><td>（連携用）代理店プラン名区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnitakuhknhnbkaisiymd zrnitakuhknhnbkaisiymd}</td><td>（連携用）委託保険販売開始年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakuhknhnbsyuuryouymd</td><td>（連携用）委託保険販売終了年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv22</td><td>（連携用）予備項目Ｖ２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenItakuSyouhnRn
 * @see     GenZT_DairitenItakuSyouhnRn
 * @see     QZT_DairitenItakuSyouhnRn
 * @see     GenQZT_DairitenItakuSyouhnRn
 */
public class PKZT_DairitenItakuSyouhnRn extends AbstractExDBPrimaryKey<ZT_DairitenItakuSyouhnRn, PKZT_DairitenItakuSyouhnRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DairitenItakuSyouhnRn() {
    }

    public PKZT_DairitenItakuSyouhnRn(
        String pZrndairitencd,
        String pZrndrtsyouhinsikibetukbnstr,
        String pZrndrthrkhouhoukbn,
        String pZrndrtplannmkbn,
        String pZrnitakuhknhnbkaisiymd
    ) {
        zrndairitencd = pZrndairitencd;
        zrndrtsyouhinsikibetukbnstr = pZrndrtsyouhinsikibetukbnstr;
        zrndrthrkhouhoukbn = pZrndrthrkhouhoukbn;
        zrndrtplannmkbn = pZrndrtplannmkbn;
        zrnitakuhknhnbkaisiymd = pZrnitakuhknhnbkaisiymd;
    }

    @Transient
    @Override
    public Class<ZT_DairitenItakuSyouhnRn> getEntityClass() {
        return ZT_DairitenItakuSyouhnRn.class;
    }

    private String zrndairitencd;

    public String getZrndairitencd() {
        return zrndairitencd;
    }

    public void setZrndairitencd(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }
    private String zrndrtsyouhinsikibetukbnstr;

    public String getZrndrtsyouhinsikibetukbnstr() {
        return zrndrtsyouhinsikibetukbnstr;
    }

    public void setZrndrtsyouhinsikibetukbnstr(String pZrndrtsyouhinsikibetukbnstr) {
        zrndrtsyouhinsikibetukbnstr = pZrndrtsyouhinsikibetukbnstr;
    }
    private String zrndrthrkhouhoukbn;

    public String getZrndrthrkhouhoukbn() {
        return zrndrthrkhouhoukbn;
    }

    public void setZrndrthrkhouhoukbn(String pZrndrthrkhouhoukbn) {
        zrndrthrkhouhoukbn = pZrndrthrkhouhoukbn;
    }
    private String zrndrtplannmkbn;

    public String getZrndrtplannmkbn() {
        return zrndrtplannmkbn;
    }

    public void setZrndrtplannmkbn(String pZrndrtplannmkbn) {
        zrndrtplannmkbn = pZrndrtplannmkbn;
    }
    private String zrnitakuhknhnbkaisiymd;

    public String getZrnitakuhknhnbkaisiymd() {
        return zrnitakuhknhnbkaisiymd;
    }

    public void setZrnitakuhknhnbkaisiymd(String pZrnitakuhknhnbkaisiymd) {
        zrnitakuhknhnbkaisiymd = pZrnitakuhknhnbkaisiymd;
    }

}