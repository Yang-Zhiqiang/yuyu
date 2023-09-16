package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SiharaiTyousyoRn;
import yuyu.def.db.mapping.GenZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.GenQZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.QZT_SiharaiTyousyoRn;

/**
 * 支払調書テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiharaiTyousyoRn}</td><td colspan="3">支払調書テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsubsystemid</td><td>（連携用）サブシステムＩＤ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkacd</td><td>（連携用）課コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantocd</td><td>（連携用）担当コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorisosikicd</td><td>（連携用）処理組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrtysysyuruicd</td><td>（連携用）支払調書種類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoritaisyoukbn</td><td>（連携用）処理対象区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbaitaiskshunoriyuukbn1</td><td>（連携用）媒体作成不能理由区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbaitaiskshunoriyuukbn2</td><td>（連携用）媒体作成不能理由区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbaitaiskshunoriyuukbn3</td><td>（連携用）媒体作成不能理由区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbaitaiskshunoriyuukbn4</td><td>（連携用）媒体作成不能理由区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbaitaiskshunoriyuukbn5</td><td>（連携用）媒体作成不能理由区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrtysyjyuusyocd</td><td>（連携用）支払調書住所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrtysyjyuusyo</td><td>（連携用）支払調書住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktnmkj35</td><td>（連携用）受取人名（漢字）（３５桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndaihyouktkbn</td><td>（連携用）代表受取人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjdaihyouuktnm</td><td>（連携用）漢字代表受取人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktmnmeigibangou</td><td>（連携用）受取人ＭＮ名義番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24</td><td>（連携用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmfjyuusyocd</td><td>（連携用）ＭＦ住所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmfjyuusyo</td><td>（連携用）ＭＦ住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj35</td><td>（連携用）契約者名（漢字）（３５桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmnmeigibangou</td><td>（連携用）契約者ＭＮ名義番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjigyoukykmndantaicd</td><td>（連携用）事業契約用ＭＮ団体コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv3</td><td>（連携用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17x2</td><td>（連携用）予備項目Ｖ１７＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnoldkykkihontikucd</td><td>（連携用）旧契約者基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjoldkykkaiadr</td><td>（連携用）漢字旧契約者下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjoldkyknm</td><td>（連携用）漢字旧契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykhnkkaisuu</td><td>（連携用）契約者変更回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv3x2</td><td>（連携用）予備項目Ｖ３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv23</td><td>（連携用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrymd</td><td>（連携用）支払年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseiymd</td><td>（連携用）作成日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouryokuhasseiymd</td><td>（連携用）効力発生日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x3</td><td>（連携用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x4</td><td>（連携用）予備項目Ｖ８＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgk11</td><td>（連携用）支払金額Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwarimsishrgk</td><td>（連携用）割増支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnznnphr</td><td>（連携用）前納Ｐ等返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnttkekstkganri</td><td>（連携用）立替貸付元利金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsshkd</td><td>（連携用）差引Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsasihikisiharaigaku</td><td>（連携用）差引支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmihrkmp</td><td>（連携用）未払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnshrtienrsk11</td><td>（連携用）支払遅延利息Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntysyouhtykeihi</td><td>（連携用）調書用必要経費</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngenkykhtykeihiyouhyj</td><td>（連携用）現契約者必要経費要表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngenkykhtykeihi</td><td>（連携用）現契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngensenkbn</td><td>（連携用）源泉徴収区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngensentaisyoukkngai</td><td>（連携用）源泉徴収対象外期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngensentaisyoukkn</td><td>（連携用）源泉徴収対象期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnsaiannaihnskakbn</td><td>（連携用）ＭＮ再案内本社回送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrhousiteikbn</td><td>（連携用）支払方法指定区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrtysykurikosidisp</td><td>（連携用）支払調書繰越表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmfadrsiyouhyouji</td><td>（連携用）ＭＦ住所使用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrhkjksyuruikbn</td><td>（連携用）年金支払用保険事故種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkkn</td><td>（連携用）年金期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsynyhsjykykndisp</td><td>（連携用）収入保障年金受給権表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnonlinecentercutkbn</td><td>（連携用）オンラインセンターカット区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhuho2kykdisp</td><td>（連携用）普保Ⅱ契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrtysyhknsyukbn</td><td>（連携用）支払調書保険種類区分</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9x5</td><td>（連携用）予備項目Ｖ９＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyouranhensyuukbn1</td><td>（連携用）摘要欄編集区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyouranhensyuukbn2</td><td>（連携用）摘要欄編集区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyouranhensyuukbn3</td><td>（連携用）摘要欄編集区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyouranhensyuukbn4</td><td>（連携用）摘要欄編集区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyouranhensyuukbn5</td><td>（連携用）摘要欄編集区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv181</td><td>（連携用）予備項目Ｖ１８１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiharaiTyousyoRn
 * @see     GenZT_SiharaiTyousyoRn
 * @see     QZT_SiharaiTyousyoRn
 * @see     GenQZT_SiharaiTyousyoRn
 */
public class PKZT_SiharaiTyousyoRn extends AbstractExDBPrimaryKey<ZT_SiharaiTyousyoRn, PKZT_SiharaiTyousyoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SiharaiTyousyoRn() {
    }

    public PKZT_SiharaiTyousyoRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_SiharaiTyousyoRn> getEntityClass() {
        return ZT_SiharaiTyousyoRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}