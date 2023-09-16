package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyoukenTkListSkRn;
import yuyu.def.db.mapping.GenZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.GenQZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.QZT_SyoukenTkListSkRn;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListSkRn}</td><td colspan="3">証券特殊処理明細リスト（新契約）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakitantnm</td><td>（連携用）宛先担当室名(組織名)</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhozonkkn</td><td>（連携用）保存期間</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymdwa</td><td>（連携用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsagyoukbn</td><td>（連携用）作業区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv25</td><td>（連携用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou1</td><td>（連携用）特殊処理内容１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou2</td><td>（連携用）特殊処理内容２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou3</td><td>（連携用）特殊処理内容３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou4</td><td>（連携用）特殊処理内容４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou5</td><td>（連携用）特殊処理内容５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou6</td><td>（連携用）特殊処理内容６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou7</td><td>（連携用）特殊処理内容７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou8</td><td>（連携用）特殊処理内容８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou9</td><td>（連携用）特殊処理内容９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou10</td><td>（連携用）特殊処理内容１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou11</td><td>（連携用）特殊処理内容１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou12</td><td>（連携用）特殊処理内容１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou13</td><td>（連携用）特殊処理内容１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntksysyorinaiyou14</td><td>（連携用）特殊処理内容１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbikouupside</td><td>（連携用）備考上段</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbikoudownside</td><td>（連携用）備考下段</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyakkanbunsyono</td><td>（連携用）約款文書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv21</td><td>（連携用）予備項目Ｖ２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListSkRn
 * @see     GenZT_SyoukenTkListSkRn
 * @see     QZT_SyoukenTkListSkRn
 * @see     GenQZT_SyoukenTkListSkRn
 */
public class PKZT_SyoukenTkListSkRn extends AbstractExDBPrimaryKey<ZT_SyoukenTkListSkRn, PKZT_SyoukenTkListSkRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyoukenTkListSkRn() {
    }

    public PKZT_SyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SyoukenTkListSkRn> getEntityClass() {
        return ZT_SyoukenTkListSkRn.class;
    }

    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}