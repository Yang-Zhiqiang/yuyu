package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyoukenTkListShTy;
import yuyu.def.db.mapping.GenZT_SyoukenTkListShTy;
import yuyu.def.db.meta.GenQZT_SyoukenTkListShTy;
import yuyu.def.db.meta.QZT_SyoukenTkListShTy;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoukenTkListShTy}</td><td colspan="3">証券特殊処理明細リスト（再発行）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakitantnm</td><td>（中継用）宛先担当室名(組織名)</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhozonkkn</td><td>（中継用）保存期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymdwa</td><td>（中継用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv26</td><td>（中継用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj</td><td>（中継用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorinm</td><td>（中継用）処理名(機能名)</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorisyouninsyacd</td><td>（中継用）処理承認者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorisyouninsyanm</td><td>（中継用）処理承認者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo1</td><td>（中継用）事後作業内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo2</td><td>（中継用）事後作業内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo3</td><td>（中継用）事後作業内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo4</td><td>（中継用）事後作業内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo5</td><td>（中継用）事後作業内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo6</td><td>（中継用）事後作業内容６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo7</td><td>（中継用）事後作業内容７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo8</td><td>（中継用）事後作業内容８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo9</td><td>（中継用）事後作業内容９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo10</td><td>（中継用）事後作業内容１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo11</td><td>（中継用）事後作業内容１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo12</td><td>（中継用）事後作業内容１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo13</td><td>（中継用）事後作業内容１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo14</td><td>（中継用）事後作業内容１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo15</td><td>（中継用）事後作業内容１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigosagyounaiyo16</td><td>（中継用）事後作業内容１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv31</td><td>（中継用）予備項目Ｖ３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoukenTkListShTy
 * @see     GenZT_SyoukenTkListShTy
 * @see     QZT_SyoukenTkListShTy
 * @see     GenQZT_SyoukenTkListShTy
 */
public class PKZT_SyoukenTkListShTy extends AbstractExDBPrimaryKey<ZT_SyoukenTkListShTy, PKZT_SyoukenTkListShTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyoukenTkListShTy() {
    }

    public PKZT_SyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SyoukenTkListShTy> getEntityClass() {
        return ZT_SyoukenTkListShTy.class;
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