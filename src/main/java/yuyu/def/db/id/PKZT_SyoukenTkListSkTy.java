package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyoukenTkListSkTy;
import yuyu.def.db.mapping.GenZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.GenQZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.QZT_SyoukenTkListSkTy;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListSkTy}</td><td colspan="3">証券特殊処理明細リスト（新契約）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakitantnm</td><td>（中継用）宛先担当室名(組織名)</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhozonkkn</td><td>（中継用）保存期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymdwa</td><td>（中継用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysagyoukbn</td><td>（中継用）作業区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv25</td><td>（中継用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou1</td><td>（中継用）特殊処理内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou2</td><td>（中継用）特殊処理内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou3</td><td>（中継用）特殊処理内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou4</td><td>（中継用）特殊処理内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou5</td><td>（中継用）特殊処理内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou6</td><td>（中継用）特殊処理内容６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou7</td><td>（中継用）特殊処理内容７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou8</td><td>（中継用）特殊処理内容８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou9</td><td>（中継用）特殊処理内容９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou10</td><td>（中継用）特殊処理内容１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou11</td><td>（中継用）特殊処理内容１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou12</td><td>（中継用）特殊処理内容１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou13</td><td>（中継用）特殊処理内容１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksysyorinaiyou14</td><td>（中継用）特殊処理内容１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikouupside</td><td>（中継用）備考上段</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikoudownside</td><td>（中継用）備考下段</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanbunsyono</td><td>（中継用）約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv21</td><td>（中継用）予備項目Ｖ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListSkTy
 * @see     GenZT_SyoukenTkListSkTy
 * @see     QZT_SyoukenTkListSkTy
 * @see     GenQZT_SyoukenTkListSkTy
 */
public class PKZT_SyoukenTkListSkTy extends AbstractExDBPrimaryKey<ZT_SyoukenTkListSkTy, PKZT_SyoukenTkListSkTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyoukenTkListSkTy() {
    }

    public PKZT_SyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SyoukenTkListSkTy> getEntityClass() {
        return ZT_SyoukenTkListSkTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}