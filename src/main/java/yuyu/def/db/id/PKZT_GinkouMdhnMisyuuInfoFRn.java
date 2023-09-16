package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.mapping.GenZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.GenQZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFRn;

/**
 * 銀行窓販未収情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GinkouMdhnMisyuuInfoFRn}</td><td colspan="3">銀行窓販未収情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv63</td><td>（連携用）予備項目Ｖ６３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn</td><td>（連携用）データ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatasakuseiymd zrndatasakuseiymd}</td><td>（連携用）データ作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkaisyacd</td><td>（連携用）保険会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruicd</td><td>（連携用）保険種類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyonosyuban zrnsyonosyuban}</td><td>（連携用）証券番号主番</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyonoedaban</td><td>（連携用）証券番号枝番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmisyuutatekaekbn</td><td>（連携用）未収立替区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmisyuutatekaeym</td><td>（連携用）未収立替発生年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmisyuukg</td><td>（連携用）未収金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkaisuu</td><td>（連携用）分割回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmisyuujiyuu</td><td>（連携用）未収事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikaidatakousinymd</td><td>（連携用）次回データ更新日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv28</td><td>（連携用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkosyaareav40</td><td>（連携用）個社領域Ｖ４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GinkouMdhnMisyuuInfoFRn
 * @see     GenZT_GinkouMdhnMisyuuInfoFRn
 * @see     QZT_GinkouMdhnMisyuuInfoFRn
 * @see     GenQZT_GinkouMdhnMisyuuInfoFRn
 */
public class PKZT_GinkouMdhnMisyuuInfoFRn extends AbstractExDBPrimaryKey<ZT_GinkouMdhnMisyuuInfoFRn, PKZT_GinkouMdhnMisyuuInfoFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_GinkouMdhnMisyuuInfoFRn() {
    }

    public PKZT_GinkouMdhnMisyuuInfoFRn(
        String pZrnbsydrtencd,
        String pZrndatasakuseiymd,
        String pZrnsyonosyuban
    ) {
        zrnbsydrtencd = pZrnbsydrtencd;
        zrndatasakuseiymd = pZrndatasakuseiymd;
        zrnsyonosyuban = pZrnsyonosyuban;
    }

    @Transient
    @Override
    public Class<ZT_GinkouMdhnMisyuuInfoFRn> getEntityClass() {
        return ZT_GinkouMdhnMisyuuInfoFRn.class;
    }

    private String zrnbsydrtencd;

    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }
    private String zrndatasakuseiymd;

    public String getZrndatasakuseiymd() {
        return zrndatasakuseiymd;
    }

    public void setZrndatasakuseiymd(String pZrndatasakuseiymd) {
        zrndatasakuseiymd = pZrndatasakuseiymd;
    }
    private String zrnsyonosyuban;

    public String getZrnsyonosyuban() {
        return zrnsyonosyuban;
    }

    public void setZrnsyonosyuban(String pZrnsyonosyuban) {
        zrnsyonosyuban = pZrnsyonosyuban;
    }

}