package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.mapping.GenZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.GenQZT_ZennouHoyuuIdouKykDtlRn;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlRn;

/**
 * 前納保有異動契約明細Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZennouHoyuuIdouKykDtlRn}</td><td colspan="3">前納保有異動契約明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9</td><td>（連携用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyouym</td><td>（連携用）計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhenkousyoriymd</td><td>（連携用）変更処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenymd</td><td>（連携用）伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoucalckijyunymd</td><td>（連携用）前納計算基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykmfksnctr zrnkykmfksnctr}</td><td>（連携用）契約ＭＦ更新ＣＴＲ</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnzennoubikinkbn</td><td>（連携用）前納備金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10</td><td>（連携用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakusyuruicdv2</td><td>（連携用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentcd</td><td>（連携用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoutoukeilistkbn</td><td>（連携用）前納統計リスト区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouwrbkrt</td><td>（連携用）前納割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntkyrt1</td><td>（連携用）適用利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntndzndkhikakukbn</td><td>（連携用）当年度残高比較区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv5</td><td>（連携用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukaisiymd</td><td>（連携用）前納開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukbn</td><td>（連携用）前納区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukikan</td><td>（連携用）前納期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennounyuukinymd</td><td>（連携用）前納入金年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennounyuukinkgk</td><td>（連携用）前納入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv5x2</td><td>（連携用）予備項目Ｖ５＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x2</td><td>（連携用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukimatuzennouzndk</td><td>（連携用）当期末前納残高金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukijyuutoup</td><td>（連携用）当期充当保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukizennouseisangk</td><td>（連携用）当期前納精算額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukizennounyuukinkgk</td><td>（連携用）当期前納入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyokukinenbaraip</td><td>（連携用）翌期年払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwrbkrttkyrttekiyouzndk</td><td>（連携用）割引利率適用残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngkdtznnhyj</td><td>（連携用）外貨建前納表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenkanyknhyj</td><td>（連携用）円貨入金表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknjikawaserate</td><td>（連携用）入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnyknjikawaseratetkyuymd</td><td>（連携用）入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnksnkisikawaserate</td><td>（連携用）決算期始為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnznncalckjynymdkwsrate</td><td>（連携用）前納計算基準日時点為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnksnkimatukawaserate</td><td>（連携用）決算期末時点為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzennounyuukinkgktkmatu</td><td>（連携用）前納入金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkmatuznnzndktkmatu</td><td>（連携用）当期末前納残高金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x8</td><td>（連携用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv23</td><td>（連携用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZennouHoyuuIdouKykDtlRn
 * @see     GenZT_ZennouHoyuuIdouKykDtlRn
 * @see     QZT_ZennouHoyuuIdouKykDtlRn
 * @see     GenQZT_ZennouHoyuuIdouKykDtlRn
 */
public class PKZT_ZennouHoyuuIdouKykDtlRn extends AbstractExDBPrimaryKey<ZT_ZennouHoyuuIdouKykDtlRn, PKZT_ZennouHoyuuIdouKykDtlRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_ZennouHoyuuIdouKykDtlRn() {
    }

    public PKZT_ZennouHoyuuIdouKykDtlRn(
        String pZrndatakanrino,
        String pZrnsyoricd,
        Integer pZrnkykmfksnctr
    ) {
        zrndatakanrino = pZrndatakanrino;
        zrnsyoricd = pZrnsyoricd;
        zrnkykmfksnctr = pZrnkykmfksnctr;
    }

    @Transient
    @Override
    public Class<ZT_ZennouHoyuuIdouKykDtlRn> getEntityClass() {
        return ZT_ZennouHoyuuIdouKykDtlRn.class;
    }

    private String zrndatakanrino;

    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }
    private String zrnsyoricd;

    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }
    private Integer zrnkykmfksnctr;

    public Integer getZrnkykmfksnctr() {
        return zrnkykmfksnctr;
    }

    public void setZrnkykmfksnctr(Integer pZrnkykmfksnctr) {
        zrnkykmfksnctr = pZrnkykmfksnctr;
    }

}