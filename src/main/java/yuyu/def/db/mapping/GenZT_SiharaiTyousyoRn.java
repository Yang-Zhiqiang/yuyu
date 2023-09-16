package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SiharaiTyousyoRn;
import yuyu.def.db.id.PKZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.GenQZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.QZT_SiharaiTyousyoRn;

/**
 * 支払調書テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SiharaiTyousyoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiharaiTyousyoRn}</td><td colspan="3">支払調書テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsubsystemid zrnsubsystemid}</td><td>（連携用）サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_SiharaiTyousyoRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkacd zrnkacd}</td><td>（連携用）課コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantocd zrntantocd}</td><td>（連携用）担当コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorisosikicd zrnsyorisosikicd}</td><td>（連携用）処理組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysysyuruicd zrnshrtysysyuruicd}</td><td>（連携用）支払調書種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoritaisyoukbn zrnsyoritaisyoukbn}</td><td>（連携用）処理対象区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn1 zrnbaitaiskshunoriyuukbn1}</td><td>（連携用）媒体作成不能理由区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn2 zrnbaitaiskshunoriyuukbn2}</td><td>（連携用）媒体作成不能理由区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn3 zrnbaitaiskshunoriyuukbn3}</td><td>（連携用）媒体作成不能理由区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn4 zrnbaitaiskshunoriyuukbn4}</td><td>（連携用）媒体作成不能理由区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbaitaiskshunoriyuukbn5 zrnbaitaiskshunoriyuukbn5}</td><td>（連携用）媒体作成不能理由区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysyjyuusyocd zrnshrtysyjyuusyocd}</td><td>（連携用）支払調書住所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysyjyuusyo zrnshrtysyjyuusyo}</td><td>（連携用）支払調書住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnmkj35 zrnuktnmkj35}</td><td>（連携用）受取人名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyouktkbn zrndaihyouktkbn}</td><td>（連携用）代表受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjdaihyouuktnm zrnkjdaihyouuktnm}</td><td>（連携用）漢字代表受取人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmnmeigibangou zrnuktmnmeigibangou}</td><td>（連携用）受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmfjyuusyocd zrnmfjyuusyocd}</td><td>（連携用）ＭＦ住所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmfjyuusyo zrnmfjyuusyo}</td><td>（連携用）ＭＦ住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj35 zrnkyknmkj35}</td><td>（連携用）契約者名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmnmeigibangou zrnkykmnmeigibangou}</td><td>（連携用）契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigyoukykmndantaicd zrnjigyoukykmndantaicd}</td><td>（連携用）事業契約用ＭＮ団体コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17x2 zrnyobiv17x2}</td><td>（連携用）予備項目Ｖ１７＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoldkykkihontikucd zrnoldkykkihontikucd}</td><td>（連携用）旧契約者基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjoldkykkaiadr zrnkjoldkykkaiadr}</td><td>（連携用）漢字旧契約者下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjoldkyknm zrnkjoldkyknm}</td><td>（連携用）漢字旧契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykhnkkaisuu zrnkykhnkkaisuu}</td><td>（連携用）契約者変更回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x2 zrnyobiv3x2}</td><td>（連携用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv23 zrnyobiv23}</td><td>（連携用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrymd zrnshrymd}</td><td>（連携用）支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokuhasseiymd zrnkouryokuhasseiymd}</td><td>（連携用）効力発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x3 zrnyobiv8x3}</td><td>（連携用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x4 zrnyobiv8x4}</td><td>（連携用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgk11 zrnshrgk11}</td><td>（連携用）支払金額Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwarimsishrgk zrnwarimsishrgk}</td><td>（連携用）割増支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznnphr zrnznnphr}</td><td>（連携用）前納Ｐ等返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnttkekstkganri zrnttkekstkganri}</td><td>（連携用）立替貸付元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsshkd zrnsshkd}</td><td>（連携用）差引Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsasihikisiharaigaku zrnsasihikisiharaigaku}</td><td>（連携用）差引支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmihrkmp zrnmihrkmp}</td><td>（連携用）未払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnshrtienrsk11 zrnshrtienrsk11}</td><td>（連携用）支払遅延利息Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntysyouhtykeihi zrntysyouhtykeihi}</td><td>（連携用）調書用必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngenkykhtykeihiyouhyj zrngenkykhtykeihiyouhyj}</td><td>（連携用）現契約者必要経費要表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngenkykhtykeihi zrngenkykhtykeihi}</td><td>（連携用）現契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngensenkbn zrngensenkbn}</td><td>（連携用）源泉徴収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngensentaisyoukkngai zrngensentaisyoukkngai}</td><td>（連携用）源泉徴収対象外期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngensentaisyoukkn zrngensentaisyoukkn}</td><td>（連携用）源泉徴収対象期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsaiannaihnskakbn zrnmnsaiannaihnskakbn}</td><td>（連携用）ＭＮ再案内本社回送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrhousiteikbn zrnshrhousiteikbn}</td><td>（連携用）支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysykurikosidisp zrnshrtysykurikosidisp}</td><td>（連携用）支払調書繰越表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmfadrsiyouhyouji zrnmfadrsiyouhyouji}</td><td>（連携用）ＭＦ住所使用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrhkjksyuruikbn zrnnkshrhkjksyuruikbn}</td><td>（連携用）年金支払用保険事故種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkkn zrnnenkinkkn}</td><td>（連携用）年金期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynyhsjykykndisp zrnsynyhsjykykndisp}</td><td>（連携用）収入保障年金受給権表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnonlinecentercutkbn zrnonlinecentercutkbn}</td><td>（連携用）オンラインセンターカット区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kykdisp zrnhuho2kykdisp}</td><td>（連携用）普保Ⅱ契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtysyhknsyukbn zrnshrtysyhknsyukbn}</td><td>（連携用）支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x5 zrnyobiv9x5}</td><td>（連携用）予備項目Ｖ９＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn1 zrntekiyouranhensyuukbn1}</td><td>（連携用）摘要欄編集区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn2 zrntekiyouranhensyuukbn2}</td><td>（連携用）摘要欄編集区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn3 zrntekiyouranhensyuukbn3}</td><td>（連携用）摘要欄編集区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn4 zrntekiyouranhensyuukbn4}</td><td>（連携用）摘要欄編集区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyouranhensyuukbn5 zrntekiyouranhensyuukbn5}</td><td>（連携用）摘要欄編集区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv181 zrnyobiv181}</td><td>（連携用）予備項目Ｖ１８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiharaiTyousyoRn
 * @see     PKZT_SiharaiTyousyoRn
 * @see     QZT_SiharaiTyousyoRn
 * @see     GenQZT_SiharaiTyousyoRn
 */
@MappedSuperclass
@Table(name=GenZT_SiharaiTyousyoRn.TABLE_NAME)
@IdClass(value=PKZT_SiharaiTyousyoRn.class)
public abstract class GenZT_SiharaiTyousyoRn extends AbstractExDBEntityForZDB<ZT_SiharaiTyousyoRn, PKZT_SiharaiTyousyoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SiharaiTyousyoRn";
    public static final String ZRNSUBSYSTEMID           = "zrnsubsystemid";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNKACD                  = "zrnkacd";
    public static final String ZRNTANTOCD               = "zrntantocd";
    public static final String ZRNSYORISOSIKICD         = "zrnsyorisosikicd";
    public static final String ZRNSHRTYSYSYURUICD       = "zrnshrtysysyuruicd";
    public static final String ZRNSYORITAISYOUKBN       = "zrnsyoritaisyoukbn";
    public static final String ZRNBAITAISKSHUNORIYUUKBN1 = "zrnbaitaiskshunoriyuukbn1";
    public static final String ZRNBAITAISKSHUNORIYUUKBN2 = "zrnbaitaiskshunoriyuukbn2";
    public static final String ZRNBAITAISKSHUNORIYUUKBN3 = "zrnbaitaiskshunoriyuukbn3";
    public static final String ZRNBAITAISKSHUNORIYUUKBN4 = "zrnbaitaiskshunoriyuukbn4";
    public static final String ZRNBAITAISKSHUNORIYUUKBN5 = "zrnbaitaiskshunoriyuukbn5";
    public static final String ZRNSHRTYSYJYUUSYOCD      = "zrnshrtysyjyuusyocd";
    public static final String ZRNSHRTYSYJYUUSYO        = "zrnshrtysyjyuusyo";
    public static final String ZRNUKTNMKJ35             = "zrnuktnmkj35";
    public static final String ZRNDAIHYOUKTKBN          = "zrndaihyouktkbn";
    public static final String ZRNKJDAIHYOUUKTNM        = "zrnkjdaihyouuktnm";
    public static final String ZRNUKTMNMEIGIBANGOU      = "zrnuktmnmeigibangou";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNMFJYUUSYOCD           = "zrnmfjyuusyocd";
    public static final String ZRNMFJYUUSYO             = "zrnmfjyuusyo";
    public static final String ZRNKYKNMKJ35             = "zrnkyknmkj35";
    public static final String ZRNKYKMNMEIGIBANGOU      = "zrnkykmnmeigibangou";
    public static final String ZRNJIGYOUKYKMNDANTAICD   = "zrnjigyoukykmndantaicd";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNYOBIV17X2             = "zrnyobiv17x2";
    public static final String ZRNOLDKYKKIHONTIKUCD     = "zrnoldkykkihontikucd";
    public static final String ZRNKJOLDKYKKAIADR        = "zrnkjoldkykkaiadr";
    public static final String ZRNKJOLDKYKNM            = "zrnkjoldkyknm";
    public static final String ZRNKYKHNKKAISUU          = "zrnkykhnkkaisuu";
    public static final String ZRNYOBIV3X2              = "zrnyobiv3x2";
    public static final String ZRNYOBIV23               = "zrnyobiv23";
    public static final String ZRNSHRYMD                = "zrnshrymd";
    public static final String ZRNSAKUSEIYMD            = "zrnsakuseiymd";
    public static final String ZRNKOURYOKUHASSEIYMD     = "zrnkouryokuhasseiymd";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNYOBIV8X3              = "zrnyobiv8x3";
    public static final String ZRNYOBIV8X4              = "zrnyobiv8x4";
    public static final String ZRNSHRGK11               = "zrnshrgk11";
    public static final String ZRNWARIMSISHRGK          = "zrnwarimsishrgk";
    public static final String ZRNZNNPHR                = "zrnznnphr";
    public static final String ZRNTTKEKSTKGANRI         = "zrnttkekstkganri";
    public static final String ZRNSSHKD                 = "zrnsshkd";
    public static final String ZRNSASIHIKISIHARAIGAKU   = "zrnsasihikisiharaigaku";
    public static final String ZRNMIHRKMP               = "zrnmihrkmp";
    public static final String ZRNSHRTIENRSK11          = "zrnshrtienrsk11";
    public static final String ZRNTYSYOUHTYKEIHI        = "zrntysyouhtykeihi";
    public static final String ZRNGENKYKHTYKEIHIYOUHYJ  = "zrngenkykhtykeihiyouhyj";
    public static final String ZRNGENKYKHTYKEIHI        = "zrngenkykhtykeihi";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNGENSENKBN             = "zrngensenkbn";
    public static final String ZRNGENSENTAISYOUKKNGAI   = "zrngensentaisyoukkngai";
    public static final String ZRNGENSENTAISYOUKKN      = "zrngensentaisyoukkn";
    public static final String ZRNMNSAIANNAIHNSKAKBN    = "zrnmnsaiannaihnskakbn";
    public static final String ZRNSHRHOUSITEIKBN        = "zrnshrhousiteikbn";
    public static final String ZRNSHRTYSYKURIKOSIDISP   = "zrnshrtysykurikosidisp";
    public static final String ZRNMFADRSIYOUHYOUJI      = "zrnmfadrsiyouhyouji";
    public static final String ZRNNKSHRHKJKSYURUIKBN    = "zrnnkshrhkjksyuruikbn";
    public static final String ZRNNENKINKKN             = "zrnnenkinkkn";
    public static final String ZRNSYNYHSJYKYKNDISP      = "zrnsynyhsjykykndisp";
    public static final String ZRNONLINECENTERCUTKBN    = "zrnonlinecentercutkbn";
    public static final String ZRNHUHO2KYKDISP          = "zrnhuho2kykdisp";
    public static final String ZRNSHRTYSYHKNSYUKBN      = "zrnshrtysyhknsyukbn";
    public static final String ZRNYOBIV9X5              = "zrnyobiv9x5";
    public static final String ZRNTEKIYOURANHENSYUUKBN1 = "zrntekiyouranhensyuukbn1";
    public static final String ZRNTEKIYOURANHENSYUUKBN2 = "zrntekiyouranhensyuukbn2";
    public static final String ZRNTEKIYOURANHENSYUUKBN3 = "zrntekiyouranhensyuukbn3";
    public static final String ZRNTEKIYOURANHENSYUUKBN4 = "zrntekiyouranhensyuukbn4";
    public static final String ZRNTEKIYOURANHENSYUUKBN5 = "zrntekiyouranhensyuukbn5";
    public static final String ZRNYOBIV181              = "zrnyobiv181";

    private final PKZT_SiharaiTyousyoRn primaryKey;

    public GenZT_SiharaiTyousyoRn() {
        primaryKey = new PKZT_SiharaiTyousyoRn();
    }

    public GenZT_SiharaiTyousyoRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_SiharaiTyousyoRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_SiharaiTyousyoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SiharaiTyousyoRn> getMetaClass() {
        return QZT_SiharaiTyousyoRn.class;
    }

    private String zrnsubsystemid;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSUBSYSTEMID)
    public String getZrnsubsystemid() {
        return zrnsubsystemid;
    }

    public void setZrnsubsystemid(String pZrnsubsystemid) {
        zrnsubsystemid = pZrnsubsystemid;
    }

    @Id
    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnsyono;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnkacd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKACD)
    public String getZrnkacd() {
        return zrnkacd;
    }

    public void setZrnkacd(String pZrnkacd) {
        zrnkacd = pZrnkacd;
    }

    private String zrntantocd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTANTOCD)
    public String getZrntantocd() {
        return zrntantocd;
    }

    public void setZrntantocd(String pZrntantocd) {
        zrntantocd = pZrntantocd;
    }

    private String zrnsyorisosikicd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSYORISOSIKICD)
    public String getZrnsyorisosikicd() {
        return zrnsyorisosikicd;
    }

    public void setZrnsyorisosikicd(String pZrnsyorisosikicd) {
        zrnsyorisosikicd = pZrnsyorisosikicd;
    }

    private String zrnshrtysysyuruicd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRTYSYSYURUICD)
    public String getZrnshrtysysyuruicd() {
        return zrnshrtysysyuruicd;
    }

    public void setZrnshrtysysyuruicd(String pZrnshrtysysyuruicd) {
        zrnshrtysysyuruicd = pZrnshrtysysyuruicd;
    }

    private String zrnsyoritaisyoukbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSYORITAISYOUKBN)
    public String getZrnsyoritaisyoukbn() {
        return zrnsyoritaisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyoritaisyoukbn(String pZrnsyoritaisyoukbn) {
        zrnsyoritaisyoukbn = pZrnsyoritaisyoukbn;
    }

    private String zrnbaitaiskshunoriyuukbn1;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN1)
    public String getZrnbaitaiskshunoriyuukbn1() {
        return zrnbaitaiskshunoriyuukbn1;
    }

    public void setZrnbaitaiskshunoriyuukbn1(String pZrnbaitaiskshunoriyuukbn1) {
        zrnbaitaiskshunoriyuukbn1 = pZrnbaitaiskshunoriyuukbn1;
    }

    private String zrnbaitaiskshunoriyuukbn2;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN2)
    public String getZrnbaitaiskshunoriyuukbn2() {
        return zrnbaitaiskshunoriyuukbn2;
    }

    public void setZrnbaitaiskshunoriyuukbn2(String pZrnbaitaiskshunoriyuukbn2) {
        zrnbaitaiskshunoriyuukbn2 = pZrnbaitaiskshunoriyuukbn2;
    }

    private String zrnbaitaiskshunoriyuukbn3;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN3)
    public String getZrnbaitaiskshunoriyuukbn3() {
        return zrnbaitaiskshunoriyuukbn3;
    }

    public void setZrnbaitaiskshunoriyuukbn3(String pZrnbaitaiskshunoriyuukbn3) {
        zrnbaitaiskshunoriyuukbn3 = pZrnbaitaiskshunoriyuukbn3;
    }

    private String zrnbaitaiskshunoriyuukbn4;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN4)
    public String getZrnbaitaiskshunoriyuukbn4() {
        return zrnbaitaiskshunoriyuukbn4;
    }

    public void setZrnbaitaiskshunoriyuukbn4(String pZrnbaitaiskshunoriyuukbn4) {
        zrnbaitaiskshunoriyuukbn4 = pZrnbaitaiskshunoriyuukbn4;
    }

    private String zrnbaitaiskshunoriyuukbn5;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNBAITAISKSHUNORIYUUKBN5)
    public String getZrnbaitaiskshunoriyuukbn5() {
        return zrnbaitaiskshunoriyuukbn5;
    }

    public void setZrnbaitaiskshunoriyuukbn5(String pZrnbaitaiskshunoriyuukbn5) {
        zrnbaitaiskshunoriyuukbn5 = pZrnbaitaiskshunoriyuukbn5;
    }

    private String zrnshrtysyjyuusyocd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRTYSYJYUUSYOCD)
    public String getZrnshrtysyjyuusyocd() {
        return zrnshrtysyjyuusyocd;
    }

    public void setZrnshrtysyjyuusyocd(String pZrnshrtysyjyuusyocd) {
        zrnshrtysyjyuusyocd = pZrnshrtysyjyuusyocd;
    }

    private String zrnshrtysyjyuusyo;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRTYSYJYUUSYO)
    public String getZrnshrtysyjyuusyo() {
        return zrnshrtysyjyuusyo;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrtysyjyuusyo(String pZrnshrtysyjyuusyo) {
        zrnshrtysyjyuusyo = pZrnshrtysyjyuusyo;
    }

    private String zrnuktnmkj35;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNUKTNMKJ35)
    public String getZrnuktnmkj35() {
        return zrnuktnmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnmkj35(String pZrnuktnmkj35) {
        zrnuktnmkj35 = pZrnuktnmkj35;
    }

    private String zrndaihyouktkbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNDAIHYOUKTKBN)
    public String getZrndaihyouktkbn() {
        return zrndaihyouktkbn;
    }

    public void setZrndaihyouktkbn(String pZrndaihyouktkbn) {
        zrndaihyouktkbn = pZrndaihyouktkbn;
    }

    private String zrnkjdaihyouuktnm;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKJDAIHYOUUKTNM)
    public String getZrnkjdaihyouuktnm() {
        return zrnkjdaihyouuktnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjdaihyouuktnm(String pZrnkjdaihyouuktnm) {
        zrnkjdaihyouuktnm = pZrnkjdaihyouuktnm;
    }

    private String zrnuktmnmeigibangou;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNUKTMNMEIGIBANGOU)
    public String getZrnuktmnmeigibangou() {
        return zrnuktmnmeigibangou;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnuktmnmeigibangou(String pZrnuktmnmeigibangou) {
        zrnuktmnmeigibangou = pZrnuktmnmeigibangou;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private String zrnmfjyuusyocd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNMFJYUUSYOCD)
    public String getZrnmfjyuusyocd() {
        return zrnmfjyuusyocd;
    }

    public void setZrnmfjyuusyocd(String pZrnmfjyuusyocd) {
        zrnmfjyuusyocd = pZrnmfjyuusyocd;
    }

    private String zrnmfjyuusyo;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNMFJYUUSYO)
    public String getZrnmfjyuusyo() {
        return zrnmfjyuusyo;
    }

    @DataConvert("toMultiByte")
    public void setZrnmfjyuusyo(String pZrnmfjyuusyo) {
        zrnmfjyuusyo = pZrnmfjyuusyo;
    }

    private String zrnkyknmkj35;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKYKNMKJ35)
    public String getZrnkyknmkj35() {
        return zrnkyknmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj35(String pZrnkyknmkj35) {
        zrnkyknmkj35 = pZrnkyknmkj35;
    }

    private String zrnkykmnmeigibangou;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKYKMNMEIGIBANGOU)
    public String getZrnkykmnmeigibangou() {
        return zrnkykmnmeigibangou;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnkykmnmeigibangou(String pZrnkykmnmeigibangou) {
        zrnkykmnmeigibangou = pZrnkykmnmeigibangou;
    }

    private String zrnjigyoukykmndantaicd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNJIGYOUKYKMNDANTAICD)
    public String getZrnjigyoukykmndantaicd() {
        return zrnjigyoukykmndantaicd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnjigyoukykmndantaicd(String pZrnjigyoukykmndantaicd) {
        zrnjigyoukykmndantaicd = pZrnjigyoukykmndantaicd;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrnyobiv17x2;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV17X2)
    public String getZrnyobiv17x2() {
        return zrnyobiv17x2;
    }

    public void setZrnyobiv17x2(String pZrnyobiv17x2) {
        zrnyobiv17x2 = pZrnyobiv17x2;
    }

    private String zrnoldkykkihontikucd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNOLDKYKKIHONTIKUCD)
    public String getZrnoldkykkihontikucd() {
        return zrnoldkykkihontikucd;
    }

    public void setZrnoldkykkihontikucd(String pZrnoldkykkihontikucd) {
        zrnoldkykkihontikucd = pZrnoldkykkihontikucd;
    }

    private String zrnkjoldkykkaiadr;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKJOLDKYKKAIADR)
    public String getZrnkjoldkykkaiadr() {
        return zrnkjoldkykkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjoldkykkaiadr(String pZrnkjoldkykkaiadr) {
        zrnkjoldkykkaiadr = pZrnkjoldkykkaiadr;
    }

    private String zrnkjoldkyknm;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKJOLDKYKNM)
    public String getZrnkjoldkyknm() {
        return zrnkjoldkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjoldkyknm(String pZrnkjoldkyknm) {
        zrnkjoldkyknm = pZrnkjoldkyknm;
    }

    private String zrnkykhnkkaisuu;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKYKHNKKAISUU)
    public String getZrnkykhnkkaisuu() {
        return zrnkykhnkkaisuu;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnkykhnkkaisuu(String pZrnkykhnkkaisuu) {
        zrnkykhnkkaisuu = pZrnkykhnkkaisuu;
    }

    private String zrnyobiv3x2;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV3X2)
    public String getZrnyobiv3x2() {
        return zrnyobiv3x2;
    }

    public void setZrnyobiv3x2(String pZrnyobiv3x2) {
        zrnyobiv3x2 = pZrnyobiv3x2;
    }

    private String zrnyobiv23;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV23)
    public String getZrnyobiv23() {
        return zrnyobiv23;
    }

    public void setZrnyobiv23(String pZrnyobiv23) {
        zrnyobiv23 = pZrnyobiv23;
    }

    private String zrnshrymd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRYMD)
    public String getZrnshrymd() {
        return zrnshrymd;
    }

    public void setZrnshrymd(String pZrnshrymd) {
        zrnshrymd = pZrnshrymd;
    }

    private String zrnsakuseiymd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSAKUSEIYMD)
    public String getZrnsakuseiymd() {
        return zrnsakuseiymd;
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        zrnsakuseiymd = pZrnsakuseiymd;
    }

    private String zrnkouryokuhasseiymd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNKOURYOKUHASSEIYMD)
    public String getZrnkouryokuhasseiymd() {
        return zrnkouryokuhasseiymd;
    }

    public void setZrnkouryokuhasseiymd(String pZrnkouryokuhasseiymd) {
        zrnkouryokuhasseiymd = pZrnkouryokuhasseiymd;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnyobiv8x3;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV8X3)
    public String getZrnyobiv8x3() {
        return zrnyobiv8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x3(String pZrnyobiv8x3) {
        zrnyobiv8x3 = pZrnyobiv8x3;
    }

    private String zrnyobiv8x4;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV8X4)
    public String getZrnyobiv8x4() {
        return zrnyobiv8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x4(String pZrnyobiv8x4) {
        zrnyobiv8x4 = pZrnyobiv8x4;
    }

    private Long zrnshrgk11;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRGK11)
    public Long getZrnshrgk11() {
        return zrnshrgk11;
    }

    public void setZrnshrgk11(Long pZrnshrgk11) {
        zrnshrgk11 = pZrnshrgk11;
    }

    private Long zrnwarimsishrgk;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNWARIMSISHRGK)
    public Long getZrnwarimsishrgk() {
        return zrnwarimsishrgk;
    }

    public void setZrnwarimsishrgk(Long pZrnwarimsishrgk) {
        zrnwarimsishrgk = pZrnwarimsishrgk;
    }

    private Long zrnznnphr;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNZNNPHR)
    public Long getZrnznnphr() {
        return zrnznnphr;
    }

    public void setZrnznnphr(Long pZrnznnphr) {
        zrnznnphr = pZrnznnphr;
    }

    private Long zrnttkekstkganri;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTTKEKSTKGANRI)
    public Long getZrnttkekstkganri() {
        return zrnttkekstkganri;
    }

    public void setZrnttkekstkganri(Long pZrnttkekstkganri) {
        zrnttkekstkganri = pZrnttkekstkganri;
    }

    private Long zrnsshkd;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSSHKD)
    public Long getZrnsshkd() {
        return zrnsshkd;
    }

    public void setZrnsshkd(Long pZrnsshkd) {
        zrnsshkd = pZrnsshkd;
    }

    private Long zrnsasihikisiharaigaku;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSASIHIKISIHARAIGAKU)
    public Long getZrnsasihikisiharaigaku() {
        return zrnsasihikisiharaigaku;
    }

    public void setZrnsasihikisiharaigaku(Long pZrnsasihikisiharaigaku) {
        zrnsasihikisiharaigaku = pZrnsasihikisiharaigaku;
    }

    private Long zrnmihrkmp;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNMIHRKMP)
    public Long getZrnmihrkmp() {
        return zrnmihrkmp;
    }

    public void setZrnmihrkmp(Long pZrnmihrkmp) {
        zrnmihrkmp = pZrnmihrkmp;
    }

    private Long zrnshrtienrsk11;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRTIENRSK11)
    public Long getZrnshrtienrsk11() {
        return zrnshrtienrsk11;
    }

    public void setZrnshrtienrsk11(Long pZrnshrtienrsk11) {
        zrnshrtienrsk11 = pZrnshrtienrsk11;
    }

    private Long zrntysyouhtykeihi;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTYSYOUHTYKEIHI)
    public Long getZrntysyouhtykeihi() {
        return zrntysyouhtykeihi;
    }

    public void setZrntysyouhtykeihi(Long pZrntysyouhtykeihi) {
        zrntysyouhtykeihi = pZrntysyouhtykeihi;
    }

    private String zrngenkykhtykeihiyouhyj;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNGENKYKHTYKEIHIYOUHYJ)
    public String getZrngenkykhtykeihiyouhyj() {
        return zrngenkykhtykeihiyouhyj;
    }

    public void setZrngenkykhtykeihiyouhyj(String pZrngenkykhtykeihiyouhyj) {
        zrngenkykhtykeihiyouhyj = pZrngenkykhtykeihiyouhyj;
    }

    private Long zrngenkykhtykeihi;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNGENKYKHTYKEIHI)
    public Long getZrngenkykhtykeihi() {
        return zrngenkykhtykeihi;
    }

    public void setZrngenkykhtykeihi(Long pZrngenkykhtykeihi) {
        zrngenkykhtykeihi = pZrngenkykhtykeihi;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrngensenkbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNGENSENKBN)
    public String getZrngensenkbn() {
        return zrngensenkbn;
    }

    public void setZrngensenkbn(String pZrngensenkbn) {
        zrngensenkbn = pZrngensenkbn;
    }

    private String zrngensentaisyoukkngai;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNGENSENTAISYOUKKNGAI)
    public String getZrngensentaisyoukkngai() {
        return zrngensentaisyoukkngai;
    }

    public void setZrngensentaisyoukkngai(String pZrngensentaisyoukkngai) {
        zrngensentaisyoukkngai = pZrngensentaisyoukkngai;
    }

    private String zrngensentaisyoukkn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNGENSENTAISYOUKKN)
    public String getZrngensentaisyoukkn() {
        return zrngensentaisyoukkn;
    }

    public void setZrngensentaisyoukkn(String pZrngensentaisyoukkn) {
        zrngensentaisyoukkn = pZrngensentaisyoukkn;
    }

    private String zrnmnsaiannaihnskakbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNMNSAIANNAIHNSKAKBN)
    public String getZrnmnsaiannaihnskakbn() {
        return zrnmnsaiannaihnskakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmnsaiannaihnskakbn(String pZrnmnsaiannaihnskakbn) {
        zrnmnsaiannaihnskakbn = pZrnmnsaiannaihnskakbn;
    }

    private String zrnshrhousiteikbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRHOUSITEIKBN)
    public String getZrnshrhousiteikbn() {
        return zrnshrhousiteikbn;
    }

    public void setZrnshrhousiteikbn(String pZrnshrhousiteikbn) {
        zrnshrhousiteikbn = pZrnshrhousiteikbn;
    }

    private String zrnshrtysykurikosidisp;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRTYSYKURIKOSIDISP)
    public String getZrnshrtysykurikosidisp() {
        return zrnshrtysykurikosidisp;
    }

    public void setZrnshrtysykurikosidisp(String pZrnshrtysykurikosidisp) {
        zrnshrtysykurikosidisp = pZrnshrtysykurikosidisp;
    }

    private String zrnmfadrsiyouhyouji;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNMFADRSIYOUHYOUJI)
    public String getZrnmfadrsiyouhyouji() {
        return zrnmfadrsiyouhyouji;
    }

    public void setZrnmfadrsiyouhyouji(String pZrnmfadrsiyouhyouji) {
        zrnmfadrsiyouhyouji = pZrnmfadrsiyouhyouji;
    }

    private String zrnnkshrhkjksyuruikbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNNKSHRHKJKSYURUIKBN)
    public String getZrnnkshrhkjksyuruikbn() {
        return zrnnkshrhkjksyuruikbn;
    }

    public void setZrnnkshrhkjksyuruikbn(String pZrnnkshrhkjksyuruikbn) {
        zrnnkshrhkjksyuruikbn = pZrnnkshrhkjksyuruikbn;
    }

    private String zrnnenkinkkn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNNENKINKKN)
    public String getZrnnenkinkkn() {
        return zrnnenkinkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnenkinkkn(String pZrnnenkinkkn) {
        zrnnenkinkkn = pZrnnenkinkkn;
    }

    private String zrnsynyhsjykykndisp;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSYNYHSJYKYKNDISP)
    public String getZrnsynyhsjykykndisp() {
        return zrnsynyhsjykykndisp;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsynyhsjykykndisp(String pZrnsynyhsjykykndisp) {
        zrnsynyhsjykykndisp = pZrnsynyhsjykykndisp;
    }

    private String zrnonlinecentercutkbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNONLINECENTERCUTKBN)
    public String getZrnonlinecentercutkbn() {
        return zrnonlinecentercutkbn;
    }

    public void setZrnonlinecentercutkbn(String pZrnonlinecentercutkbn) {
        zrnonlinecentercutkbn = pZrnonlinecentercutkbn;
    }

    private String zrnhuho2kykdisp;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNHUHO2KYKDISP)
    public String getZrnhuho2kykdisp() {
        return zrnhuho2kykdisp;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhuho2kykdisp(String pZrnhuho2kykdisp) {
        zrnhuho2kykdisp = pZrnhuho2kykdisp;
    }

    private String zrnshrtysyhknsyukbn;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNSHRTYSYHKNSYUKBN)
    public String getZrnshrtysyhknsyukbn() {
        return zrnshrtysyhknsyukbn;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrtysyhknsyukbn(String pZrnshrtysyhknsyukbn) {
        zrnshrtysyhknsyukbn = pZrnshrtysyhknsyukbn;
    }

    private String zrnyobiv9x5;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV9X5)
    public String getZrnyobiv9x5() {
        return zrnyobiv9x5;
    }

    public void setZrnyobiv9x5(String pZrnyobiv9x5) {
        zrnyobiv9x5 = pZrnyobiv9x5;
    }

    private String zrntekiyouranhensyuukbn1;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTEKIYOURANHENSYUUKBN1)
    public String getZrntekiyouranhensyuukbn1() {
        return zrntekiyouranhensyuukbn1;
    }

    public void setZrntekiyouranhensyuukbn1(String pZrntekiyouranhensyuukbn1) {
        zrntekiyouranhensyuukbn1 = pZrntekiyouranhensyuukbn1;
    }

    private String zrntekiyouranhensyuukbn2;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTEKIYOURANHENSYUUKBN2)
    public String getZrntekiyouranhensyuukbn2() {
        return zrntekiyouranhensyuukbn2;
    }

    public void setZrntekiyouranhensyuukbn2(String pZrntekiyouranhensyuukbn2) {
        zrntekiyouranhensyuukbn2 = pZrntekiyouranhensyuukbn2;
    }

    private String zrntekiyouranhensyuukbn3;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTEKIYOURANHENSYUUKBN3)
    public String getZrntekiyouranhensyuukbn3() {
        return zrntekiyouranhensyuukbn3;
    }

    public void setZrntekiyouranhensyuukbn3(String pZrntekiyouranhensyuukbn3) {
        zrntekiyouranhensyuukbn3 = pZrntekiyouranhensyuukbn3;
    }

    private String zrntekiyouranhensyuukbn4;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTEKIYOURANHENSYUUKBN4)
    public String getZrntekiyouranhensyuukbn4() {
        return zrntekiyouranhensyuukbn4;
    }

    public void setZrntekiyouranhensyuukbn4(String pZrntekiyouranhensyuukbn4) {
        zrntekiyouranhensyuukbn4 = pZrntekiyouranhensyuukbn4;
    }

    private String zrntekiyouranhensyuukbn5;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNTEKIYOURANHENSYUUKBN5)
    public String getZrntekiyouranhensyuukbn5() {
        return zrntekiyouranhensyuukbn5;
    }

    public void setZrntekiyouranhensyuukbn5(String pZrntekiyouranhensyuukbn5) {
        zrntekiyouranhensyuukbn5 = pZrntekiyouranhensyuukbn5;
    }

    private String zrnyobiv181;

    @Column(name=GenZT_SiharaiTyousyoRn.ZRNYOBIV181)
    public String getZrnyobiv181() {
        return zrnyobiv181;
    }

    public void setZrnyobiv181(String pZrnyobiv181) {
        zrnyobiv181 = pZrnyobiv181;
    }
}