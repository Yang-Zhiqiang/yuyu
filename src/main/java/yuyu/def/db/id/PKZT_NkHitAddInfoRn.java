package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkHitAddInfoRn;
import yuyu.def.db.mapping.GenZT_NkHitAddInfoRn;
import yuyu.def.db.meta.GenQZT_NkHitAddInfoRn;
import yuyu.def.db.meta.QZT_NkHitAddInfoRn;

/**
 * 年金配当所要額追加情報反映テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitAddInfoRn}</td><td colspan="3">年金配当所要額追加情報反映テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnratekbn</td><td>（連携用）レート区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkariwariate4nenmae</td><td>（連携用）仮割当（４年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate3nenmae</td><td>（連携用）仮割当（３年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate2nenmae</td><td>（連携用）仮割当（２年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkariwariate1nenmae</td><td>（連携用）仮割当（１年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv40</td><td>（連携用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitAddInfoRn
 * @see     GenZT_NkHitAddInfoRn
 * @see     QZT_NkHitAddInfoRn
 * @see     GenQZT_NkHitAddInfoRn
 */
public class PKZT_NkHitAddInfoRn extends AbstractExDBPrimaryKey<ZT_NkHitAddInfoRn, PKZT_NkHitAddInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkHitAddInfoRn() {
    }

    public PKZT_NkHitAddInfoRn(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

    @Transient
    @Override
    public Class<ZT_NkHitAddInfoRn> getEntityClass() {
        return ZT_NkHitAddInfoRn.class;
    }

    private String zrnnksyousyono;

    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

}