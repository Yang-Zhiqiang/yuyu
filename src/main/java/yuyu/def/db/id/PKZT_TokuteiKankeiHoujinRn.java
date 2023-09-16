package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.mapping.GenZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.GenQZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.QZT_TokuteiKankeiHoujinRn;

/**
 * 特定関係法人マスタテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TokuteiKankeiHoujinRn}</td><td colspan="3">特定関係法人マスタテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnmeisaibangou zrnmeisaibangou}</td><td>（連携用）明細番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmarukinhyouji</td><td>（連携用）マル金表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkhjnkjdrtennm</td><td>（連携用）特定関係法人漢字代理店名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndairitenbetutuuban</td><td>（連携用）代理店別通番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitokuteikankeinm</td><td>（連携用）漢字特定関係法人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntokuteikankeihoujinnm</td><td>（連携用）特定関係法人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkousinymd</td><td>（連携用）更新年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv79</td><td>（連携用）予備項目Ｖ７９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TokuteiKankeiHoujinRn
 * @see     GenZT_TokuteiKankeiHoujinRn
 * @see     QZT_TokuteiKankeiHoujinRn
 * @see     GenQZT_TokuteiKankeiHoujinRn
 */
public class PKZT_TokuteiKankeiHoujinRn extends AbstractExDBPrimaryKey<ZT_TokuteiKankeiHoujinRn, PKZT_TokuteiKankeiHoujinRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TokuteiKankeiHoujinRn() {
    }

    public PKZT_TokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
        zrnmeisaibangou = pZrnmeisaibangou;
    }

    @Transient
    @Override
    public Class<ZT_TokuteiKankeiHoujinRn> getEntityClass() {
        return ZT_TokuteiKankeiHoujinRn.class;
    }

    private String zrnkinyuukikancd;

    public String getZrnkinyuukikancd() {
        return zrnkinyuukikancd;
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
    }
    private String zrnmeisaibangou;

    public String getZrnmeisaibangou() {
        return zrnmeisaibangou;
    }

    public void setZrnmeisaibangou(String pZrnmeisaibangou) {
        zrnmeisaibangou = pZrnmeisaibangou;
    }

}