package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;
import yuyu.def.db.mapping.GenZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.GenQZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.QZT_SiharaiTyousyoTy;

/**
 * 支払調書テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiharaiTyousyoTy}</td><td colspan="3">支払調書テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysubsystemid</td><td>（中継用）サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykacd</td><td>（中継用）課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantocd</td><td>（中継用）担当コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorisosikicd</td><td>（中継用）処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtysysyuruicd</td><td>（中継用）支払調書種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoritaisyoukbn</td><td>（中継用）処理対象区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybaitaiskshunoriyuukbn1</td><td>（中継用）媒体作成不能理由区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybaitaiskshunoriyuukbn2</td><td>（中継用）媒体作成不能理由区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybaitaiskshunoriyuukbn3</td><td>（中継用）媒体作成不能理由区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybaitaiskshunoriyuukbn4</td><td>（中継用）媒体作成不能理由区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybaitaiskshunoriyuukbn5</td><td>（中継用）媒体作成不能理由区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtysyjyuusyocd</td><td>（中継用）支払調書住所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtysyjyuusyo</td><td>（中継用）支払調書住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnmkj35</td><td>（中継用）受取人名（漢字）（３５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaihyouktkbn</td><td>（中継用）代表受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjdaihyouuktnm</td><td>（中継用）漢字代表受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmnmeigibangou</td><td>（中継用）受取人ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv24</td><td>（中継用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymfjyuusyocd</td><td>（中継用）ＭＦ住所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymfjyuusyo</td><td>（中継用）ＭＦ住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj35</td><td>（中継用）契約者名（漢字）（３５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmnmeigibangou</td><td>（中継用）契約者ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjigyoukykmndantaicd</td><td>（中継用）事業契約用ＭＮ団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv17</td><td>（中継用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv3</td><td>（中継用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv17x2</td><td>（中継用）予備項目Ｖ１７＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyoldkykkihontikucd</td><td>（中継用）旧契約者基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjoldkykkaiadr</td><td>（中継用）漢字旧契約者下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjoldkyknm</td><td>（中継用）漢字旧契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykhnkkaisuu</td><td>（中継用）契約者変更回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv3x2</td><td>（中継用）予備項目Ｖ３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv23</td><td>（中継用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrymd</td><td>（中継用）支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseiymd</td><td>（中継用）作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouryokuhasseiymd</td><td>（中継用）効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x2</td><td>（中継用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x3</td><td>（中継用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x4</td><td>（中継用）予備項目Ｖ８＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgk11</td><td>（中継用）支払金額Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztywarimsishrgk</td><td>（中継用）割増支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznnphr</td><td>（中継用）前納Ｐ等返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyttkekstkganri</td><td>（中継用）立替貸付元利金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysshkd</td><td>（中継用）差引Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysasihikisiharaigaku</td><td>（中継用）差引支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymihrkmp</td><td>（中継用）未払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyshrtienrsk11</td><td>（中継用）支払遅延利息Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytysyouhtykeihi</td><td>（中継用）調書用必要経費</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygenkykhtykeihiyouhyj</td><td>（中継用）現契約者必要経費要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygenkykhtykeihi</td><td>（中継用）現契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygensenkbn</td><td>（中継用）源泉徴収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygensentaisyoukkngai</td><td>（中継用）源泉徴収対象外期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygensentaisyoukkn</td><td>（中継用）源泉徴収対象期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnsaiannaihnskakbn</td><td>（中継用）ＭＮ再案内本社回送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrhousiteikbn</td><td>（中継用）支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtysykurikosidisp</td><td>（中継用）支払調書繰越表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymfadrsiyouhyouji</td><td>（中継用）ＭＦ住所使用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrhkjksyuruikbn</td><td>（中継用）年金支払用保険事故種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkkn</td><td>（中継用）年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysynyhsjykykndisp</td><td>（中継用）収入保障年金受給権表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyonlinecentercutkbn</td><td>（中継用）オンラインセンターカット区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhuho2kykdisp</td><td>（中継用）普保Ⅱ契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtysyhknsyukbn</td><td>（中継用）支払調書保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9x5</td><td>（中継用）予備項目Ｖ９＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyouranhensyuukbn1</td><td>（中継用）摘要欄編集区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyouranhensyuukbn2</td><td>（中継用）摘要欄編集区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyouranhensyuukbn3</td><td>（中継用）摘要欄編集区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyouranhensyuukbn4</td><td>（中継用）摘要欄編集区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyouranhensyuukbn5</td><td>（中継用）摘要欄編集区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv181</td><td>（中継用）予備項目Ｖ１８１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiharaiTyousyoTy
 * @see     GenZT_SiharaiTyousyoTy
 * @see     QZT_SiharaiTyousyoTy
 * @see     GenQZT_SiharaiTyousyoTy
 */
public class PKZT_SiharaiTyousyoTy extends AbstractExDBPrimaryKey<ZT_SiharaiTyousyoTy, PKZT_SiharaiTyousyoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SiharaiTyousyoTy() {
    }

    public PKZT_SiharaiTyousyoTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_SiharaiTyousyoTy> getEntityClass() {
        return ZT_SiharaiTyousyoTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}