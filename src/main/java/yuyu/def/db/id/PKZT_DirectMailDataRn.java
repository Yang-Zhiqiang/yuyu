package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DirectMailDataRn;
import yuyu.def.db.mapping.GenZT_DirectMailDataRn;
import yuyu.def.db.meta.GenQZT_DirectMailDataRn;
import yuyu.def.db.meta.QZT_DirectMailDataRn;

/**
 * ダイレクトメールデータテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DirectMailDataRn}</td><td colspan="3">ダイレクトメールデータテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnhokenkbnnys</td><td>（連携用）保険区分（名寄せ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuinmeinonys</td><td>（連携用）索引名番号（名寄せ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyainnm</td><td>（連携用）社員名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyainseiymd</td><td>（連携用）社員生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjisyainnm</td><td>（連携用）漢字社員名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaimitureigaihyj</td><td>（連携用）内密例外表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtenhyj</td><td>（連携用）代理店表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsouhuhunoukbn</td><td>（連携用）送付不能区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknnm</td><td>（連携用）保険名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnenhousiki</td><td>（連携用）年齢方式</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkarihyj</td><td>（連携用）ご家族登録有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatkioybsydrtencd</td><td>（連携用）Ａ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatkioybsydrtencd</td><td>（連携用）Ｂ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x1</td><td>（連携用）予備項目Ｖ２５０＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x2</td><td>（連携用）予備項目Ｖ２５０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x3</td><td>（連携用）予備項目Ｖ２５０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x4</td><td>（連携用）予備項目Ｖ２５０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x5</td><td>（連携用）予備項目Ｖ２５０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x6</td><td>（連携用）予備項目Ｖ２５０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x7</td><td>（連携用）予備項目Ｖ２５０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x8</td><td>（連携用）予備項目Ｖ２５０＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x9</td><td>（連携用）予備項目Ｖ２５０＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x10</td><td>（連携用）予備項目Ｖ２５０＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x11</td><td>（連携用）予備項目Ｖ２５０＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x12</td><td>（連携用）予備項目Ｖ２５０＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x13</td><td>（連携用）予備項目Ｖ２５０＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x14</td><td>（連携用）予備項目Ｖ２５０＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv122</td><td>（連携用）予備項目Ｖ１２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DirectMailDataRn
 * @see     GenZT_DirectMailDataRn
 * @see     QZT_DirectMailDataRn
 * @see     GenQZT_DirectMailDataRn
 */
public class PKZT_DirectMailDataRn extends AbstractExDBPrimaryKey<ZT_DirectMailDataRn, PKZT_DirectMailDataRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DirectMailDataRn() {
    }

    public PKZT_DirectMailDataRn(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_DirectMailDataRn> getEntityClass() {
        return ZT_DirectMailDataRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}