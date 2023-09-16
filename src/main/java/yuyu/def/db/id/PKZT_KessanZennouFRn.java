package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KessanZennouFRn;
import yuyu.def.db.mapping.GenZT_KessanZennouFRn;
import yuyu.def.db.meta.GenQZT_KessanZennouFRn;
import yuyu.def.db.meta.QZT_KessanZennouFRn;

/**
 * 決算用前納Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KessanZennouFRn}</td><td colspan="3">決算用前納Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9</td><td>（連携用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkbnkeiriyousegmentcd zrnkbnkeiriyousegmentcd}</td><td>（連携用）区分経理用セグメントコード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnzennoutoukeilistkbn zrnzennoutoukeilistkbn}</td><td>（連携用）前納統計リスト区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnzennoukbn zrnzennoukbn}</td><td>（連携用）前納区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukaisiymd</td><td>（連携用）前納開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukaisijizndk</td><td>（連携用）前納開始時残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouwrbkrt</td><td>（連携用）前納割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrthndzndk1</td><td>（連携用）利率変動時残高１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkyrt1</td><td>（連携用）適用利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrthndymd1</td><td>（連携用）利率変動年月日１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrthndzndk2</td><td>（連携用）利率変動時残高２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkyrt2</td><td>（連携用）適用利率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrthndymd2</td><td>（連携用）利率変動年月日２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrthndzndk3</td><td>（連携用）利率変動時残高３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkyrt3</td><td>（連携用）適用利率３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrthndymd3</td><td>（連携用）利率変動年月日３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrthndzndk4</td><td>（連携用）利率変動時残高４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkyrt4</td><td>（連携用）適用利率４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrthndymd4</td><td>（連携用）利率変動年月日４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntndmatuzndk</td><td>（連携用）当年度末残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntndmatutkyrt</td><td>（連携用）当年度末適用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzennounyuukinymd</td><td>（連携用）前納入金年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntndzndkhikakukbn</td><td>（連携用）当年度残高比較区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukikan</td><td>（連携用）前納期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobi01xv1</td><td>（連携用）予備０１＿Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukeitaikbn</td><td>（連携用）募集形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobi02xv11</td><td>（連携用）予備０２＿Ｖ１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngkdtznnhyj</td><td>（連携用）外貨建前納表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenkanyknhyj</td><td>（連携用）円貨入金表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknjikawaserate</td><td>（連携用）入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnyknjikawaseratetkyuymd</td><td>（連携用）入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnksnkisikawaserate</td><td>（連携用）決算期始為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntndmatuzndkksnjkwsrate</td><td>（連携用）当年度末残高計算時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzennounyuukinkgkgaika</td><td>（連携用）前納入金額＿外貨</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennounyuukinkgktkmatu</td><td>（連携用）前納入金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennoukaisijizndktkmatu</td><td>（連携用）前納開始時残高＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnrthndzndk1tkmatu</td><td>（連携用）利率変動時残高１＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnrthndzndk2tkmatu</td><td>（連携用）利率変動時残高２＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnrthndzndk3tkmatu</td><td>（連携用）利率変動時残高３＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnrthndzndk4tkmatu</td><td>（連携用）利率変動時残高４＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntndmatuzndktkmatu</td><td>（連携用）当年度末残高＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv22</td><td>（連携用）予備項目Ｖ２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KessanZennouFRn
 * @see     GenZT_KessanZennouFRn
 * @see     QZT_KessanZennouFRn
 * @see     GenQZT_KessanZennouFRn
 */
public class PKZT_KessanZennouFRn extends AbstractExDBPrimaryKey<ZT_KessanZennouFRn, PKZT_KessanZennouFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KessanZennouFRn() {
    }

    public PKZT_KessanZennouFRn(
        String pZrnsyono,
        String pZrnkbnkeiriyousegmentcd,
        String pZrnzennoutoukeilistkbn,
        String pZrnzennoukbn
    ) {
        zrnsyono = pZrnsyono;
        zrnkbnkeiriyousegmentcd = pZrnkbnkeiriyousegmentcd;
        zrnzennoutoukeilistkbn = pZrnzennoutoukeilistkbn;
        zrnzennoukbn = pZrnzennoukbn;
    }

    @Transient
    @Override
    public Class<ZT_KessanZennouFRn> getEntityClass() {
        return ZT_KessanZennouFRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnkbnkeiriyousegmentcd;

    public String getZrnkbnkeiriyousegmentcd() {
        return zrnkbnkeiriyousegmentcd;
    }

    public void setZrnkbnkeiriyousegmentcd(String pZrnkbnkeiriyousegmentcd) {
        zrnkbnkeiriyousegmentcd = pZrnkbnkeiriyousegmentcd;
    }
    private String zrnzennoutoukeilistkbn;

    public String getZrnzennoutoukeilistkbn() {
        return zrnzennoutoukeilistkbn;
    }

    public void setZrnzennoutoukeilistkbn(String pZrnzennoutoukeilistkbn) {
        zrnzennoutoukeilistkbn = pZrnzennoutoukeilistkbn;
    }
    private String zrnzennoukbn;

    public String getZrnzennoukbn() {
        return zrnzennoukbn;
    }

    public void setZrnzennoukbn(String pZrnzennoukbn) {
        zrnzennoukbn = pZrnzennoukbn;
    }

}