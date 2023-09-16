package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SinninTouhyouRn;
import yuyu.def.db.mapping.GenZT_SinninTouhyouRn;
import yuyu.def.db.meta.GenQZT_SinninTouhyouRn;
import yuyu.def.db.meta.QZT_SinninTouhyouRn;

/**
 * 信任投票データテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinninTouhyouRn}</td><td colspan="3">信任投票データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnhokenkbn</td><td>（連携用）保険区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknaiyoukbn</td><td>（連携用）契約内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokenkbnnys</td><td>（連携用）保険区分（名寄せ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuinmeinonys</td><td>（連携用）索引名番号（名寄せ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyainnm</td><td>（連携用）社員名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjisyainnm</td><td>（連携用）漢字社員名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyainseiymd</td><td>（連携用）社員生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksyuannaikykkbn</td><td>（連携用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsouhuhunoukbn</td><td>（連携用）送付不能区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaimitureigaihyj</td><td>（連携用）内密例外表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuukinsisya</td><td>（連携用）集金支社</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuukintntusycd</td><td>（連携用）集金担当者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnokyakusamano</td><td>（連携用）お客様番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaibukojincd</td><td>（連携用）内部個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokenkbnsyainno</td><td>（連携用）保険区分（社員ＮＯ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuinmeinosyainno</td><td>（連携用）索引名番号（社員ＮＯ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnprivacyhogoyouhyj</td><td>（連携用）プライバシー保護要表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigaitokoukykhyj</td><td>（連携用）海外渡航契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaibukbn</td><td>（連携用）内部区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktsnatkitkyktrkjtkbn</td><td>（連携用）契約通算扱特約登録状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnalcardhkkbn</td><td>（連携用）ＡＬカード発行区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsydrtenkbn</td><td>（連携用）募集代理店区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvitkaiinno</td><td>（連携用）Ｖｉｔ会員番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv60</td><td>（連携用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinninTouhyouRn
 * @see     GenZT_SinninTouhyouRn
 * @see     QZT_SinninTouhyouRn
 * @see     GenQZT_SinninTouhyouRn
 */
public class PKZT_SinninTouhyouRn extends AbstractExDBPrimaryKey<ZT_SinninTouhyouRn, PKZT_SinninTouhyouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SinninTouhyouRn() {
    }

    public PKZT_SinninTouhyouRn(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SinninTouhyouRn> getEntityClass() {
        return ZT_SinninTouhyouRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}