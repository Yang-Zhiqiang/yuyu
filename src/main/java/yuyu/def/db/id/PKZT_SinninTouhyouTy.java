package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SinninTouhyouTy;
import yuyu.def.db.mapping.GenZT_SinninTouhyouTy;
import yuyu.def.db.meta.GenQZT_SinninTouhyouTy;
import yuyu.def.db.meta.QZT_SinninTouhyouTy;

/**
 * 信任投票データテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinninTouhyouTy}</td><td colspan="3">信任投票データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyhokenkbn</td><td>（中継用）保険区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknaiyoukbn</td><td>（中継用）契約内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokenkbnnys</td><td>（中継用）保険区分（名寄せ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuinmeinonys</td><td>（中継用）索引名番号（名寄せ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainnm</td><td>（中継用）社員名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjisyainnm</td><td>（中継用）漢字社員名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyainseiymd</td><td>（中継用）社員生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinkihontikucd</td><td>（中継用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjitsinkaiadr</td><td>（中継用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyuannaikykkbn</td><td>（中継用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysouhuhunoukbn</td><td>（中継用）送付不能区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaimitureigaihyj</td><td>（中継用）内密例外表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuukinsisya</td><td>（中継用）集金支社</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuukintntusycd</td><td>（中継用）集金担当者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyokyakusamano</td><td>（中継用）お客様番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaibukojincd</td><td>（中継用）内部個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokenkbnsyainno</td><td>（中継用）保険区分（社員ＮＯ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuinmeinosyainno</td><td>（中継用）索引名番号（社員ＮＯ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyprivacyhogoyouhyj</td><td>（中継用）プライバシー保護要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigaitokoukykhyj</td><td>（中継用）海外渡航契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaibukbn</td><td>（中継用）内部区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktsnatkitkyktrkjtkbn</td><td>（中継用）契約通算扱特約登録状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyalcardhkkbn</td><td>（中継用）ＡＬカード発行区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkbn</td><td>（中継用）募集代理店区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvitkaiinno</td><td>（中継用）Ｖｉｔ会員番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv60</td><td>（中継用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinninTouhyouTy
 * @see     GenZT_SinninTouhyouTy
 * @see     QZT_SinninTouhyouTy
 * @see     GenQZT_SinninTouhyouTy
 */
public class PKZT_SinninTouhyouTy extends AbstractExDBPrimaryKey<ZT_SinninTouhyouTy, PKZT_SinninTouhyouTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SinninTouhyouTy() {
    }

    public PKZT_SinninTouhyouTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SinninTouhyouTy> getEntityClass() {
        return ZT_SinninTouhyouTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}