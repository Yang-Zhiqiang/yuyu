package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DairitenRn;
import yuyu.def.db.mapping.GenZT_DairitenRn;
import yuyu.def.db.meta.GenQZT_DairitenRn;
import yuyu.def.db.meta.QZT_DairitenRn;

/**
 * 代理店ＰＲＴ用連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenRn}</td><td colspan="3">代理店ＰＲＴ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitennm</td><td>（連携用）代理店名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjidairitennm</td><td>（連携用）漢字代理店名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnitakukeiyakuymd</td><td>（連携用）委託契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitakukeiyakukaiyakuymd</td><td>（連携用）委託契約解約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitentourokuymd</td><td>（連携用）代理店登録年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaisinhidaisinkbn</td><td>（連携用）代申非代申区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanrisosikicd1</td><td>（連携用）管理組織コード（１）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanrisosikicd2</td><td>（連携用）管理組織コード（２）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanrisosikicd3</td><td>（連携用）管理組織コード（３）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeisyousakidairitencd</td><td>（連携用）継承先代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeisyoumotodairitencd</td><td>（連携用）継承元代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x1</td><td>（連携用）代理店商品コード上３桁＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux1</td><td>（連携用）手数料支払区分（当月）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux1</td><td>（連携用）手数料支払区分（翌月）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx1</td><td>（連携用）分担パターン区分＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x2</td><td>（連携用）代理店商品コード上３桁＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux2</td><td>（連携用）手数料支払区分（当月）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux2</td><td>（連携用）手数料支払区分（翌月）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx2</td><td>（連携用）分担パターン区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x3</td><td>（連携用）代理店商品コード上３桁＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux3</td><td>（連携用）手数料支払区分（当月）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux3</td><td>（連携用）手数料支払区分（翌月）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx3</td><td>（連携用）分担パターン区分＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x4</td><td>（連携用）代理店商品コード上３桁＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux4</td><td>（連携用）手数料支払区分（当月）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux4</td><td>（連携用）手数料支払区分（翌月）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx4</td><td>（連携用）分担パターン区分＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x5</td><td>（連携用）代理店商品コード上３桁＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux5</td><td>（連携用）手数料支払区分（当月）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux5</td><td>（連携用）手数料支払区分（翌月）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx5</td><td>（連携用）分担パターン区分＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x6</td><td>（連携用）代理店商品コード上３桁＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux6</td><td>（連携用）手数料支払区分（当月）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux6</td><td>（連携用）手数料支払区分（翌月）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx6</td><td>（連携用）分担パターン区分＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x7</td><td>（連携用）代理店商品コード上３桁＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux7</td><td>（連携用）手数料支払区分（当月）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux7</td><td>（連携用）手数料支払区分（翌月）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx7</td><td>（連携用）分担パターン区分＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x8</td><td>（連携用）代理店商品コード上３桁＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux8</td><td>（連携用）手数料支払区分（当月）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux8</td><td>（連携用）手数料支払区分（翌月）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx8</td><td>（連携用）分担パターン区分＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x9</td><td>（連携用）代理店商品コード上３桁＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux9</td><td>（連携用）手数料支払区分（当月）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux9</td><td>（連携用）手数料支払区分（翌月）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx9</td><td>（連携用）分担パターン区分＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x10</td><td>（連携用）代理店商品コード上３桁＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux10</td><td>（連携用）手数料支払区分（当月）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux10</td><td>（連携用）手数料支払区分（翌月）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx10</td><td>（連携用）分担パターン区分＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x11</td><td>（連携用）代理店商品コード上３桁＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux11</td><td>（連携用）手数料支払区分（当月）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux11</td><td>（連携用）手数料支払区分（翌月）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx11</td><td>（連携用）分担パターン区分＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x12</td><td>（連携用）代理店商品コード上３桁＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux12</td><td>（連携用）手数料支払区分（当月）＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux12</td><td>（連携用）手数料支払区分（翌月）＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx12</td><td>（連携用）分担パターン区分＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x13</td><td>（連携用）代理店商品コード上３桁＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux13</td><td>（連携用）手数料支払区分（当月）＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux13</td><td>（連携用）手数料支払区分（翌月）＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx13</td><td>（連携用）分担パターン区分＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x14</td><td>（連携用）代理店商品コード上３桁＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux14</td><td>（連携用）手数料支払区分（当月）＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux14</td><td>（連携用）手数料支払区分（翌月）＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx14</td><td>（連携用）分担パターン区分＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtensyouhncdkami3x15</td><td>（連携用）代理店商品コード上３桁＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbntougetux15</td><td>（連携用）手数料支払区分（当月）＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsryshrkbnyokugetux15</td><td>（連携用）手数料支払区分（翌月）＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbntnptnkbnx15</td><td>（連携用）分担パターン区分＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrybntnaitedrtencdx1</td><td>（連携用）手数料分担相手代理店コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrybntnwarix1</td><td>（連携用）手数料分担割合＿１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntsrybntnaitedrtencdx2</td><td>（連携用）手数料分担相手代理店コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrybntnwarix2</td><td>（連携用）手数料分担割合＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntsrybntnaitedrtencdx3</td><td>（連携用）手数料分担相手代理店コード＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrybntnwarix3</td><td>（連携用）手数料分担割合＿３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntsrybntnaitedrtencdx4</td><td>（連携用）手数料分担相手代理店コード＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrybntnwarix4</td><td>（連携用）手数料分担割合＿４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhnsituhykranktougetu</td><td>（連携用）品質評価ランク（当月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnhnsituhykrankyokugetu</td><td>（連携用）品質評価ランク（翌月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobiv2x6</td><td>（連携用）予備項目Ｖ２＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitentelno</td><td>（連携用）代理店電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenfaxno</td><td>（連携用）代理店ＦＡＸ番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2</td><td>（連携用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2x2</td><td>（連携用）予備項目Ｖ２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2x3</td><td>（連携用）予備項目Ｖ２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2x4</td><td>（連携用）予備項目Ｖ２＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv2x5</td><td>（連携用）予備項目Ｖ２＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnoyadairitencd</td><td>（連携用）親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkouryokustartymd</td><td>（連携用）代理店効力開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkouryokuendymd</td><td>（連携用）代理店効力終了年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuukikancd</td><td>（連携用）金融機関コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuukikansitencd</td><td>（連携用）金融機関支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenjimusyocd</td><td>（連携用）代理店事務所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaihyoubosyuunincd</td><td>（連携用）代表募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbuntanaitedairitencd</td><td>（連携用）分担相手代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbuntanwariai</td><td>（連携用）分担割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntokureitiikihyouji</td><td>（連携用）特例地域金融機関表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyoudousosikhyouji</td><td>（連携用）協同組織金融機関表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyoudoubosyuhyouji</td><td>（連携用）共同募集代理店表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyuuseijimusyocd</td><td>（連携用）郵政事務所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukatudairitencd</td><td>（連携用）統括代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnschemedrtenhyouji</td><td>（連携用）窓販スキーム代理店表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntykatukaiyoudrtenhyouji</td><td>（連携用）直扱用代理店表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtentrkno</td><td>（連携用）代理店登録番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv21</td><td>（連携用）予備項目Ｖ２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenRn
 * @see     GenZT_DairitenRn
 * @see     QZT_DairitenRn
 * @see     GenQZT_DairitenRn
 */
public class PKZT_DairitenRn extends AbstractExDBPrimaryKey<ZT_DairitenRn, PKZT_DairitenRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DairitenRn() {
    }

    public PKZT_DairitenRn(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }

    @Transient
    @Override
    public Class<ZT_DairitenRn> getEntityClass() {
        return ZT_DairitenRn.class;
    }

    private String zrndairitencd;

    public String getZrndairitencd() {
        return zrndairitencd;
    }

    public void setZrndairitencd(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }

}