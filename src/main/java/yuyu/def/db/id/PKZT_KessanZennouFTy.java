package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KessanZennouFTy;
import yuyu.def.db.mapping.GenZT_KessanZennouFTy;
import yuyu.def.db.meta.GenQZT_KessanZennouFTy;
import yuyu.def.db.meta.QZT_KessanZennouFTy;

/**
 * 決算用前納Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanZennouFTy}</td><td colspan="3">決算用前納Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9</td><td>（中継用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykbnkeiriyousegmentcd ztykbnkeiriyousegmentcd}</td><td>（中継用）区分経理用セグメントコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyzennoutoukeilistkbn ztyzennoutoukeilistkbn}</td><td>（中継用）前納統計リスト区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyzennoukbn ztyzennoukbn}</td><td>（中継用）前納区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukaisiymd</td><td>（中継用）前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukaisijizndk</td><td>（中継用）前納開始時残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouwrbkrt</td><td>（中継用）前納割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrthndzndk1</td><td>（中継用）利率変動時残高１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkyrt1</td><td>（中継用）適用利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrthndymd1</td><td>（中継用）利率変動年月日１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrthndzndk2</td><td>（中継用）利率変動時残高２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkyrt2</td><td>（中継用）適用利率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrthndymd2</td><td>（中継用）利率変動年月日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrthndzndk3</td><td>（中継用）利率変動時残高３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkyrt3</td><td>（中継用）適用利率３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrthndymd3</td><td>（中継用）利率変動年月日３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrthndzndk4</td><td>（中継用）利率変動時残高４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkyrt4</td><td>（中継用）適用利率４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrthndymd4</td><td>（中継用）利率変動年月日４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytndmatuzndk</td><td>（中継用）当年度末残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytndmatutkyrt</td><td>（中継用）当年度末適用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzennounyuukinymd</td><td>（中継用）前納入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytndzndkhikakukbn</td><td>（中継用）当年度残高比較区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukikan</td><td>（中継用）前納期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobi01xv1</td><td>（中継用）予備０１＿Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobi02xv11</td><td>（中継用）予備０２＿Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygkdtznnhyj</td><td>（中継用）外貨建前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenkanyknhyj</td><td>（中継用）円貨入金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknjikawaserate</td><td>（中継用）入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynyknjikawaseratetkyuymd</td><td>（中継用）入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyksnkisikawaserate</td><td>（中継用）決算期始為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytndmatuzndkksnjkwsrate</td><td>（中継用）当年度末残高計算時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzennounyuukinkgkgaika</td><td>（中継用）前納入金額＿外貨</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennounyuukinkgktkmatu</td><td>（中継用）前納入金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennoukaisijizndktkmatu</td><td>（中継用）前納開始時残高＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrthndzndk1tkmatu</td><td>（中継用）利率変動時残高１＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrthndzndk2tkmatu</td><td>（中継用）利率変動時残高２＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrthndzndk3tkmatu</td><td>（中継用）利率変動時残高３＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrthndzndk4tkmatu</td><td>（中継用）利率変動時残高４＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytndmatuzndktkmatu</td><td>（中継用）当年度末残高＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv22</td><td>（中継用）予備項目Ｖ２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanZennouFTy
 * @see     GenZT_KessanZennouFTy
 * @see     QZT_KessanZennouFTy
 * @see     GenQZT_KessanZennouFTy
 */
public class PKZT_KessanZennouFTy extends AbstractExDBPrimaryKey<ZT_KessanZennouFTy, PKZT_KessanZennouFTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KessanZennouFTy() {
    }

    public PKZT_KessanZennouFTy(
        String pZtysyono,
        String pZtykbnkeiriyousegmentcd,
        String pZtyzennoutoukeilistkbn,
        String pZtyzennoukbn
    ) {
        ztysyono = pZtysyono;
        ztykbnkeiriyousegmentcd = pZtykbnkeiriyousegmentcd;
        ztyzennoutoukeilistkbn = pZtyzennoutoukeilistkbn;
        ztyzennoukbn = pZtyzennoukbn;
    }

    @Transient
    @Override
    public Class<ZT_KessanZennouFTy> getEntityClass() {
        return ZT_KessanZennouFTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztykbnkeiriyousegmentcd;

    public String getZtykbnkeiriyousegmentcd() {
        return ztykbnkeiriyousegmentcd;
    }

    public void setZtykbnkeiriyousegmentcd(String pZtykbnkeiriyousegmentcd) {
        ztykbnkeiriyousegmentcd = pZtykbnkeiriyousegmentcd;
    }
    private String ztyzennoutoukeilistkbn;

    public String getZtyzennoutoukeilistkbn() {
        return ztyzennoutoukeilistkbn;
    }

    public void setZtyzennoutoukeilistkbn(String pZtyzennoutoukeilistkbn) {
        ztyzennoutoukeilistkbn = pZtyzennoutoukeilistkbn;
    }
    private String ztyzennoukbn;

    public String getZtyzennoukbn() {
        return ztyzennoukbn;
    }

    public void setZtyzennoukbn(String pZtyzennoukbn) {
        ztyzennoukbn = pZtyzennoukbn;
    }

}