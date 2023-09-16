package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.mapping.GenZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.GenQZT_ZennouHoyuuIdouKykDtlTy;
import yuyu.def.db.meta.QZT_ZennouHoyuuIdouKykDtlTy;

/**
 * 前納保有異動契約明細Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_ZennouHoyuuIdouKykDtlTy}</td><td colspan="3">前納保有異動契約明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9</td><td>（中継用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkbn</td><td>（中継用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhenkousyoriymd</td><td>（中継用）変更処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenymd</td><td>（中継用）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoucalckijyunymd</td><td>（中継用）前納計算基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykykmfksnctr ztykykmfksnctr}</td><td>（中継用）契約ＭＦ更新ＣＴＲ</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyzennoubikinkbn</td><td>（中継用）前納備金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10</td><td>（中継用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakusyuruicdv2</td><td>（中継用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentcd</td><td>（中継用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoutoukeilistkbn</td><td>（中継用）前納統計リスト区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouwrbkrt</td><td>（中継用）前納割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytkyrt1</td><td>（中継用）適用利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytndzndkhikakukbn</td><td>（中継用）当年度残高比較区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv5</td><td>（中継用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukaisiymd</td><td>（中継用）前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukbn</td><td>（中継用）前納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukikan</td><td>（中継用）前納期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennounyuukinymd</td><td>（中継用）前納入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennounyuukinkgk</td><td>（中継用）前納入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv5x2</td><td>（中継用）予備項目Ｖ５＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x2</td><td>（中継用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukimatuzennouzndk</td><td>（中継用）当期末前納残高金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukijyuutoup</td><td>（中継用）当期充当保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukizennouseisangk</td><td>（中継用）当期前納精算額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukizennounyuukinkgk</td><td>（中継用）当期前納入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyokukinenbaraip</td><td>（中継用）翌期年払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztywrbkrttkyrttekiyouzndk</td><td>（中継用）割引利率適用残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygkdtznnhyj</td><td>（中継用）外貨建前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenkanyknhyj</td><td>（中継用）円貨入金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknjikawaserate</td><td>（中継用）入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynyknjikawaseratetkyuymd</td><td>（中継用）入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyksnkisikawaserate</td><td>（中継用）決算期始為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyznncalckjynymdkwsrate</td><td>（中継用）前納計算基準日時点為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyksnkimatukawaserate</td><td>（中継用）決算期末時点為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzennounyuukinkgktkmatu</td><td>（中継用）前納入金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkmatuznnzndktkmatu</td><td>（中継用）当期末前納残高金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x7</td><td>（中継用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x8</td><td>（中継用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv23</td><td>（中継用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_ZennouHoyuuIdouKykDtlTy
 * @see     GenZT_ZennouHoyuuIdouKykDtlTy
 * @see     QZT_ZennouHoyuuIdouKykDtlTy
 * @see     GenQZT_ZennouHoyuuIdouKykDtlTy
 */
public class PKZT_ZennouHoyuuIdouKykDtlTy extends AbstractExDBPrimaryKey<ZT_ZennouHoyuuIdouKykDtlTy, PKZT_ZennouHoyuuIdouKykDtlTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_ZennouHoyuuIdouKykDtlTy() {
    }

    public PKZT_ZennouHoyuuIdouKykDtlTy(
        String pZtydatakanrino,
        String pZtysyoricd,
        Integer pZtykykmfksnctr
    ) {
        ztydatakanrino = pZtydatakanrino;
        ztysyoricd = pZtysyoricd;
        ztykykmfksnctr = pZtykykmfksnctr;
    }

    @Transient
    @Override
    public Class<ZT_ZennouHoyuuIdouKykDtlTy> getEntityClass() {
        return ZT_ZennouHoyuuIdouKykDtlTy.class;
    }

    private String ztydatakanrino;

    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }
    private String ztysyoricd;

    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }
    private Integer ztykykmfksnctr;

    public Integer getZtykykmfksnctr() {
        return ztykykmfksnctr;
    }

    public void setZtykykmfksnctr(Integer pZtykykmfksnctr) {
        ztykykmfksnctr = pZtykykmfksnctr;
    }

}