package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.db.mapping.GenZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.GenQZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;

/**
 * 翻訳用行員Ｆ用連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HonyakuYouKouinRn}</td><td colspan="3">翻訳用行員Ｆ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkouincd zrnkouincd}</td><td>（連携用）行員コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunincd</td><td>（連携用）募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HonyakuYouKouinRn
 * @see     GenZT_HonyakuYouKouinRn
 * @see     QZT_HonyakuYouKouinRn
 * @see     GenQZT_HonyakuYouKouinRn
 */
public class PKZT_HonyakuYouKouinRn extends AbstractExDBPrimaryKey<ZT_HonyakuYouKouinRn, PKZT_HonyakuYouKouinRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_HonyakuYouKouinRn() {
    }

    public PKZT_HonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
        zrnkouincd = pZrnkouincd;
    }

    @Transient
    @Override
    public Class<ZT_HonyakuYouKouinRn> getEntityClass() {
        return ZT_HonyakuYouKouinRn.class;
    }

    private String zrnkinyuukikancd;

    public String getZrnkinyuukikancd() {
        return zrnkinyuukikancd;
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
    }
    private String zrnkouincd;

    public String getZrnkouincd() {
        return zrnkouincd;
    }

    public void setZrnkouincd(String pZrnkouincd) {
        zrnkouincd = pZrnkouincd;
    }

}