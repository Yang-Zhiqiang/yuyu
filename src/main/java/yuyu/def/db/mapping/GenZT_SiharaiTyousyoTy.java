package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;
import yuyu.def.db.id.PKZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.GenQZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.QZT_SiharaiTyousyoTy;

/**
 * 支払調書テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SiharaiTyousyoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiharaiTyousyoTy}</td><td colspan="3">支払調書テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysubsystemid ztysubsystemid}</td><td>（中継用）サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_SiharaiTyousyoTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykacd ztykacd}</td><td>（中継用）課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantocd ztytantocd}</td><td>（中継用）担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorisosikicd ztysyorisosikicd}</td><td>（中継用）処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysysyuruicd ztyshrtysysyuruicd}</td><td>（中継用）支払調書種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoritaisyoukbn ztysyoritaisyoukbn}</td><td>（中継用）処理対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn1 ztybaitaiskshunoriyuukbn1}</td><td>（中継用）媒体作成不能理由区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn2 ztybaitaiskshunoriyuukbn2}</td><td>（中継用）媒体作成不能理由区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn3 ztybaitaiskshunoriyuukbn3}</td><td>（中継用）媒体作成不能理由区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn4 ztybaitaiskshunoriyuukbn4}</td><td>（中継用）媒体作成不能理由区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybaitaiskshunoriyuukbn5 ztybaitaiskshunoriyuukbn5}</td><td>（中継用）媒体作成不能理由区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysyjyuusyocd ztyshrtysyjyuusyocd}</td><td>（中継用）支払調書住所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysyjyuusyo ztyshrtysyjyuusyo}</td><td>（中継用）支払調書住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnmkj35 ztyuktnmkj35}</td><td>（中継用）受取人名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyouktkbn ztydaihyouktkbn}</td><td>（中継用）代表受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjdaihyouuktnm ztykjdaihyouuktnm}</td><td>（中継用）漢字代表受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmnmeigibangou ztyuktmnmeigibangou}</td><td>（中継用）受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymfjyuusyocd ztymfjyuusyocd}</td><td>（中継用）ＭＦ住所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymfjyuusyo ztymfjyuusyo}</td><td>（中継用）ＭＦ住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj35 ztykyknmkj35}</td><td>（中継用）契約者名（漢字）（３５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmnmeigibangou ztykykmnmeigibangou}</td><td>（中継用）契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigyoukykmndantaicd ztyjigyoukykmndantaicd}</td><td>（中継用）事業契約用ＭＮ団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17x2 ztyyobiv17x2}</td><td>（中継用）予備項目Ｖ１７＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoldkykkihontikucd ztyoldkykkihontikucd}</td><td>（中継用）旧契約者基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjoldkykkaiadr ztykjoldkykkaiadr}</td><td>（中継用）漢字旧契約者下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjoldkyknm ztykjoldkyknm}</td><td>（中継用）漢字旧契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykhnkkaisuu ztykykhnkkaisuu}</td><td>（中継用）契約者変更回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x2 ztyyobiv3x2}</td><td>（中継用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv23 ztyyobiv23}</td><td>（中継用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrymd ztyshrymd}</td><td>（中継用）支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiymd ztysakuseiymd}</td><td>（中継用）作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouryokuhasseiymd ztykouryokuhasseiymd}</td><td>（中継用）効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x3 ztyyobiv8x3}</td><td>（中継用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x4 ztyyobiv8x4}</td><td>（中継用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgk11 ztyshrgk11}</td><td>（中継用）支払金額Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywarimsishrgk ztywarimsishrgk}</td><td>（中継用）割増支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznnphr ztyznnphr}</td><td>（中継用）前納Ｐ等返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyttkekstkganri ztyttkekstkganri}</td><td>（中継用）立替貸付元利金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysshkd ztysshkd}</td><td>（中継用）差引Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysasihikisiharaigaku ztysasihikisiharaigaku}</td><td>（中継用）差引支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymihrkmp ztymihrkmp}</td><td>（中継用）未払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyshrtienrsk11 ztyshrtienrsk11}</td><td>（中継用）支払遅延利息Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytysyouhtykeihi ztytysyouhtykeihi}</td><td>（中継用）調書用必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygenkykhtykeihiyouhyj ztygenkykhtykeihiyouhyj}</td><td>（中継用）現契約者必要経費要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygenkykhtykeihi ztygenkykhtykeihi}</td><td>（中継用）現契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygensenkbn ztygensenkbn}</td><td>（中継用）源泉徴収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygensentaisyoukkngai ztygensentaisyoukkngai}</td><td>（中継用）源泉徴収対象外期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygensentaisyoukkn ztygensentaisyoukkn}</td><td>（中継用）源泉徴収対象期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsaiannaihnskakbn ztymnsaiannaihnskakbn}</td><td>（中継用）ＭＮ再案内本社回送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrhousiteikbn ztyshrhousiteikbn}</td><td>（中継用）支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysykurikosidisp ztyshrtysykurikosidisp}</td><td>（中継用）支払調書繰越表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymfadrsiyouhyouji ztymfadrsiyouhyouji}</td><td>（中継用）ＭＦ住所使用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrhkjksyuruikbn ztynkshrhkjksyuruikbn}</td><td>（中継用）年金支払用保険事故種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkkn ztynenkinkkn}</td><td>（中継用）年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynyhsjykykndisp ztysynyhsjykykndisp}</td><td>（中継用）収入保障年金受給権表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyonlinecentercutkbn ztyonlinecentercutkbn}</td><td>（中継用）オンラインセンターカット区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhuho2kykdisp ztyhuho2kykdisp}</td><td>（中継用）普保Ⅱ契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtysyhknsyukbn ztyshrtysyhknsyukbn}</td><td>（中継用）支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x5 ztyyobiv9x5}</td><td>（中継用）予備項目Ｖ９＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn1 ztytekiyouranhensyuukbn1}</td><td>（中継用）摘要欄編集区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn2 ztytekiyouranhensyuukbn2}</td><td>（中継用）摘要欄編集区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn3 ztytekiyouranhensyuukbn3}</td><td>（中継用）摘要欄編集区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn4 ztytekiyouranhensyuukbn4}</td><td>（中継用）摘要欄編集区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyouranhensyuukbn5 ztytekiyouranhensyuukbn5}</td><td>（中継用）摘要欄編集区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv181 ztyyobiv181}</td><td>（中継用）予備項目Ｖ１８１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiharaiTyousyoTy
 * @see     PKZT_SiharaiTyousyoTy
 * @see     QZT_SiharaiTyousyoTy
 * @see     GenQZT_SiharaiTyousyoTy
 */
@MappedSuperclass
@Table(name=GenZT_SiharaiTyousyoTy.TABLE_NAME)
@IdClass(value=PKZT_SiharaiTyousyoTy.class)
public abstract class GenZT_SiharaiTyousyoTy extends AbstractExDBEntity<ZT_SiharaiTyousyoTy, PKZT_SiharaiTyousyoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SiharaiTyousyoTy";
    public static final String ZTYSUBSYSTEMID           = "ztysubsystemid";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYKACD                  = "ztykacd";
    public static final String ZTYTANTOCD               = "ztytantocd";
    public static final String ZTYSYORISOSIKICD         = "ztysyorisosikicd";
    public static final String ZTYSHRTYSYSYURUICD       = "ztyshrtysysyuruicd";
    public static final String ZTYSYORITAISYOUKBN       = "ztysyoritaisyoukbn";
    public static final String ZTYBAITAISKSHUNORIYUUKBN1 = "ztybaitaiskshunoriyuukbn1";
    public static final String ZTYBAITAISKSHUNORIYUUKBN2 = "ztybaitaiskshunoriyuukbn2";
    public static final String ZTYBAITAISKSHUNORIYUUKBN3 = "ztybaitaiskshunoriyuukbn3";
    public static final String ZTYBAITAISKSHUNORIYUUKBN4 = "ztybaitaiskshunoriyuukbn4";
    public static final String ZTYBAITAISKSHUNORIYUUKBN5 = "ztybaitaiskshunoriyuukbn5";
    public static final String ZTYSHRTYSYJYUUSYOCD      = "ztyshrtysyjyuusyocd";
    public static final String ZTYSHRTYSYJYUUSYO        = "ztyshrtysyjyuusyo";
    public static final String ZTYUKTNMKJ35             = "ztyuktnmkj35";
    public static final String ZTYDAIHYOUKTKBN          = "ztydaihyouktkbn";
    public static final String ZTYKJDAIHYOUUKTNM        = "ztykjdaihyouuktnm";
    public static final String ZTYUKTMNMEIGIBANGOU      = "ztyuktmnmeigibangou";
    public static final String ZTYYOBIV24               = "ztyyobiv24";
    public static final String ZTYMFJYUUSYOCD           = "ztymfjyuusyocd";
    public static final String ZTYMFJYUUSYO             = "ztymfjyuusyo";
    public static final String ZTYKYKNMKJ35             = "ztykyknmkj35";
    public static final String ZTYKYKMNMEIGIBANGOU      = "ztykykmnmeigibangou";
    public static final String ZTYJIGYOUKYKMNDANTAICD   = "ztyjigyoukykmndantaicd";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYYOBIV17X2             = "ztyyobiv17x2";
    public static final String ZTYOLDKYKKIHONTIKUCD     = "ztyoldkykkihontikucd";
    public static final String ZTYKJOLDKYKKAIADR        = "ztykjoldkykkaiadr";
    public static final String ZTYKJOLDKYKNM            = "ztykjoldkyknm";
    public static final String ZTYKYKHNKKAISUU          = "ztykykhnkkaisuu";
    public static final String ZTYYOBIV3X2              = "ztyyobiv3x2";
    public static final String ZTYYOBIV23               = "ztyyobiv23";
    public static final String ZTYSHRYMD                = "ztyshrymd";
    public static final String ZTYSAKUSEIYMD            = "ztysakuseiymd";
    public static final String ZTYKOURYOKUHASSEIYMD     = "ztykouryokuhasseiymd";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYYOBIV8X3              = "ztyyobiv8x3";
    public static final String ZTYYOBIV8X4              = "ztyyobiv8x4";
    public static final String ZTYSHRGK11               = "ztyshrgk11";
    public static final String ZTYWARIMSISHRGK          = "ztywarimsishrgk";
    public static final String ZTYZNNPHR                = "ztyznnphr";
    public static final String ZTYTTKEKSTKGANRI         = "ztyttkekstkganri";
    public static final String ZTYSSHKD                 = "ztysshkd";
    public static final String ZTYSASIHIKISIHARAIGAKU   = "ztysasihikisiharaigaku";
    public static final String ZTYMIHRKMP               = "ztymihrkmp";
    public static final String ZTYSHRTIENRSK11          = "ztyshrtienrsk11";
    public static final String ZTYTYSYOUHTYKEIHI        = "ztytysyouhtykeihi";
    public static final String ZTYGENKYKHTYKEIHIYOUHYJ  = "ztygenkykhtykeihiyouhyj";
    public static final String ZTYGENKYKHTYKEIHI        = "ztygenkykhtykeihi";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYGENSENKBN             = "ztygensenkbn";
    public static final String ZTYGENSENTAISYOUKKNGAI   = "ztygensentaisyoukkngai";
    public static final String ZTYGENSENTAISYOUKKN      = "ztygensentaisyoukkn";
    public static final String ZTYMNSAIANNAIHNSKAKBN    = "ztymnsaiannaihnskakbn";
    public static final String ZTYSHRHOUSITEIKBN        = "ztyshrhousiteikbn";
    public static final String ZTYSHRTYSYKURIKOSIDISP   = "ztyshrtysykurikosidisp";
    public static final String ZTYMFADRSIYOUHYOUJI      = "ztymfadrsiyouhyouji";
    public static final String ZTYNKSHRHKJKSYURUIKBN    = "ztynkshrhkjksyuruikbn";
    public static final String ZTYNENKINKKN             = "ztynenkinkkn";
    public static final String ZTYSYNYHSJYKYKNDISP      = "ztysynyhsjykykndisp";
    public static final String ZTYONLINECENTERCUTKBN    = "ztyonlinecentercutkbn";
    public static final String ZTYHUHO2KYKDISP          = "ztyhuho2kykdisp";
    public static final String ZTYSHRTYSYHKNSYUKBN      = "ztyshrtysyhknsyukbn";
    public static final String ZTYYOBIV9X5              = "ztyyobiv9x5";
    public static final String ZTYTEKIYOURANHENSYUUKBN1 = "ztytekiyouranhensyuukbn1";
    public static final String ZTYTEKIYOURANHENSYUUKBN2 = "ztytekiyouranhensyuukbn2";
    public static final String ZTYTEKIYOURANHENSYUUKBN3 = "ztytekiyouranhensyuukbn3";
    public static final String ZTYTEKIYOURANHENSYUUKBN4 = "ztytekiyouranhensyuukbn4";
    public static final String ZTYTEKIYOURANHENSYUUKBN5 = "ztytekiyouranhensyuukbn5";
    public static final String ZTYYOBIV181              = "ztyyobiv181";

    private final PKZT_SiharaiTyousyoTy primaryKey;

    public GenZT_SiharaiTyousyoTy() {
        primaryKey = new PKZT_SiharaiTyousyoTy();
    }

    public GenZT_SiharaiTyousyoTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_SiharaiTyousyoTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_SiharaiTyousyoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SiharaiTyousyoTy> getMetaClass() {
        return QZT_SiharaiTyousyoTy.class;
    }

    private String ztysubsystemid;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSUBSYSTEMID)
    public String getZtysubsystemid() {
        return ztysubsystemid;
    }

    public void setZtysubsystemid(String pZtysubsystemid) {
        ztysubsystemid = pZtysubsystemid;
    }

    @Id
    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztysyono;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztykacd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKACD)
    public String getZtykacd() {
        return ztykacd;
    }

    public void setZtykacd(String pZtykacd) {
        ztykacd = pZtykacd;
    }

    private String ztytantocd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTANTOCD)
    public String getZtytantocd() {
        return ztytantocd;
    }

    public void setZtytantocd(String pZtytantocd) {
        ztytantocd = pZtytantocd;
    }

    private String ztysyorisosikicd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSYORISOSIKICD)
    public String getZtysyorisosikicd() {
        return ztysyorisosikicd;
    }

    public void setZtysyorisosikicd(String pZtysyorisosikicd) {
        ztysyorisosikicd = pZtysyorisosikicd;
    }

    private String ztyshrtysysyuruicd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRTYSYSYURUICD)
    public String getZtyshrtysysyuruicd() {
        return ztyshrtysysyuruicd;
    }

    public void setZtyshrtysysyuruicd(String pZtyshrtysysyuruicd) {
        ztyshrtysysyuruicd = pZtyshrtysysyuruicd;
    }

    private String ztysyoritaisyoukbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSYORITAISYOUKBN)
    public String getZtysyoritaisyoukbn() {
        return ztysyoritaisyoukbn;
    }

    public void setZtysyoritaisyoukbn(String pZtysyoritaisyoukbn) {
        ztysyoritaisyoukbn = pZtysyoritaisyoukbn;
    }

    private String ztybaitaiskshunoriyuukbn1;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN1)
    public String getZtybaitaiskshunoriyuukbn1() {
        return ztybaitaiskshunoriyuukbn1;
    }

    public void setZtybaitaiskshunoriyuukbn1(String pZtybaitaiskshunoriyuukbn1) {
        ztybaitaiskshunoriyuukbn1 = pZtybaitaiskshunoriyuukbn1;
    }

    private String ztybaitaiskshunoriyuukbn2;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN2)
    public String getZtybaitaiskshunoriyuukbn2() {
        return ztybaitaiskshunoriyuukbn2;
    }

    public void setZtybaitaiskshunoriyuukbn2(String pZtybaitaiskshunoriyuukbn2) {
        ztybaitaiskshunoriyuukbn2 = pZtybaitaiskshunoriyuukbn2;
    }

    private String ztybaitaiskshunoriyuukbn3;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN3)
    public String getZtybaitaiskshunoriyuukbn3() {
        return ztybaitaiskshunoriyuukbn3;
    }

    public void setZtybaitaiskshunoriyuukbn3(String pZtybaitaiskshunoriyuukbn3) {
        ztybaitaiskshunoriyuukbn3 = pZtybaitaiskshunoriyuukbn3;
    }

    private String ztybaitaiskshunoriyuukbn4;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN4)
    public String getZtybaitaiskshunoriyuukbn4() {
        return ztybaitaiskshunoriyuukbn4;
    }

    public void setZtybaitaiskshunoriyuukbn4(String pZtybaitaiskshunoriyuukbn4) {
        ztybaitaiskshunoriyuukbn4 = pZtybaitaiskshunoriyuukbn4;
    }

    private String ztybaitaiskshunoriyuukbn5;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYBAITAISKSHUNORIYUUKBN5)
    public String getZtybaitaiskshunoriyuukbn5() {
        return ztybaitaiskshunoriyuukbn5;
    }

    public void setZtybaitaiskshunoriyuukbn5(String pZtybaitaiskshunoriyuukbn5) {
        ztybaitaiskshunoriyuukbn5 = pZtybaitaiskshunoriyuukbn5;
    }

    private String ztyshrtysyjyuusyocd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRTYSYJYUUSYOCD)
    public String getZtyshrtysyjyuusyocd() {
        return ztyshrtysyjyuusyocd;
    }

    public void setZtyshrtysyjyuusyocd(String pZtyshrtysyjyuusyocd) {
        ztyshrtysyjyuusyocd = pZtyshrtysyjyuusyocd;
    }

    private String ztyshrtysyjyuusyo;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRTYSYJYUUSYO)
    public String getZtyshrtysyjyuusyo() {
        return ztyshrtysyjyuusyo;
    }

    public void setZtyshrtysyjyuusyo(String pZtyshrtysyjyuusyo) {
        ztyshrtysyjyuusyo = pZtyshrtysyjyuusyo;
    }

    private String ztyuktnmkj35;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYUKTNMKJ35)
    public String getZtyuktnmkj35() {
        return ztyuktnmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZtyuktnmkj35(String pZtyuktnmkj35) {
        ztyuktnmkj35 = pZtyuktnmkj35;
    }

    private String ztydaihyouktkbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYDAIHYOUKTKBN)
    public String getZtydaihyouktkbn() {
        return ztydaihyouktkbn;
    }

    public void setZtydaihyouktkbn(String pZtydaihyouktkbn) {
        ztydaihyouktkbn = pZtydaihyouktkbn;
    }

    private String ztykjdaihyouuktnm;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKJDAIHYOUUKTNM)
    public String getZtykjdaihyouuktnm() {
        return ztykjdaihyouuktnm;
    }

    public void setZtykjdaihyouuktnm(String pZtykjdaihyouuktnm) {
        ztykjdaihyouuktnm = pZtykjdaihyouuktnm;
    }

    private String ztyuktmnmeigibangou;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYUKTMNMEIGIBANGOU)
    public String getZtyuktmnmeigibangou() {
        return ztyuktmnmeigibangou;
    }

    public void setZtyuktmnmeigibangou(String pZtyuktmnmeigibangou) {
        ztyuktmnmeigibangou = pZtyuktmnmeigibangou;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }

    private String ztymfjyuusyocd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYMFJYUUSYOCD)
    public String getZtymfjyuusyocd() {
        return ztymfjyuusyocd;
    }

    public void setZtymfjyuusyocd(String pZtymfjyuusyocd) {
        ztymfjyuusyocd = pZtymfjyuusyocd;
    }

    private String ztymfjyuusyo;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYMFJYUUSYO)
    public String getZtymfjyuusyo() {
        return ztymfjyuusyo;
    }

    public void setZtymfjyuusyo(String pZtymfjyuusyo) {
        ztymfjyuusyo = pZtymfjyuusyo;
    }

    private String ztykyknmkj35;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKYKNMKJ35)
    public String getZtykyknmkj35() {
        return ztykyknmkj35;
    }

    @DataConvert("toMultiByte")
    public void setZtykyknmkj35(String pZtykyknmkj35) {
        ztykyknmkj35 = pZtykyknmkj35;
    }

    private String ztykykmnmeigibangou;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKYKMNMEIGIBANGOU)
    public String getZtykykmnmeigibangou() {
        return ztykykmnmeigibangou;
    }

    public void setZtykykmnmeigibangou(String pZtykykmnmeigibangou) {
        ztykykmnmeigibangou = pZtykykmnmeigibangou;
    }

    private String ztyjigyoukykmndantaicd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYJIGYOUKYKMNDANTAICD)
    public String getZtyjigyoukykmndantaicd() {
        return ztyjigyoukykmndantaicd;
    }

    public void setZtyjigyoukykmndantaicd(String pZtyjigyoukykmndantaicd) {
        ztyjigyoukykmndantaicd = pZtyjigyoukykmndantaicd;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztyyobiv17x2;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV17X2)
    public String getZtyyobiv17x2() {
        return ztyyobiv17x2;
    }

    public void setZtyyobiv17x2(String pZtyyobiv17x2) {
        ztyyobiv17x2 = pZtyyobiv17x2;
    }

    private String ztyoldkykkihontikucd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYOLDKYKKIHONTIKUCD)
    public String getZtyoldkykkihontikucd() {
        return ztyoldkykkihontikucd;
    }

    public void setZtyoldkykkihontikucd(String pZtyoldkykkihontikucd) {
        ztyoldkykkihontikucd = pZtyoldkykkihontikucd;
    }

    private String ztykjoldkykkaiadr;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKJOLDKYKKAIADR)
    public String getZtykjoldkykkaiadr() {
        return ztykjoldkykkaiadr;
    }

    public void setZtykjoldkykkaiadr(String pZtykjoldkykkaiadr) {
        ztykjoldkykkaiadr = pZtykjoldkykkaiadr;
    }

    private String ztykjoldkyknm;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKJOLDKYKNM)
    public String getZtykjoldkyknm() {
        return ztykjoldkyknm;
    }

    public void setZtykjoldkyknm(String pZtykjoldkyknm) {
        ztykjoldkyknm = pZtykjoldkyknm;
    }

    private String ztykykhnkkaisuu;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKYKHNKKAISUU)
    public String getZtykykhnkkaisuu() {
        return ztykykhnkkaisuu;
    }

    public void setZtykykhnkkaisuu(String pZtykykhnkkaisuu) {
        ztykykhnkkaisuu = pZtykykhnkkaisuu;
    }

    private String ztyyobiv3x2;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV3X2)
    public String getZtyyobiv3x2() {
        return ztyyobiv3x2;
    }

    public void setZtyyobiv3x2(String pZtyyobiv3x2) {
        ztyyobiv3x2 = pZtyyobiv3x2;
    }

    private String ztyyobiv23;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV23)
    public String getZtyyobiv23() {
        return ztyyobiv23;
    }

    public void setZtyyobiv23(String pZtyyobiv23) {
        ztyyobiv23 = pZtyyobiv23;
    }

    private String ztyshrymd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRYMD)
    public String getZtyshrymd() {
        return ztyshrymd;
    }

    public void setZtyshrymd(String pZtyshrymd) {
        ztyshrymd = pZtyshrymd;
    }

    private String ztysakuseiymd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSAKUSEIYMD)
    public String getZtysakuseiymd() {
        return ztysakuseiymd;
    }

    public void setZtysakuseiymd(String pZtysakuseiymd) {
        ztysakuseiymd = pZtysakuseiymd;
    }

    private String ztykouryokuhasseiymd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYKOURYOKUHASSEIYMD)
    public String getZtykouryokuhasseiymd() {
        return ztykouryokuhasseiymd;
    }

    public void setZtykouryokuhasseiymd(String pZtykouryokuhasseiymd) {
        ztykouryokuhasseiymd = pZtykouryokuhasseiymd;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztyyobiv8x3;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV8X3)
    public String getZtyyobiv8x3() {
        return ztyyobiv8x3;
    }

    public void setZtyyobiv8x3(String pZtyyobiv8x3) {
        ztyyobiv8x3 = pZtyyobiv8x3;
    }

    private String ztyyobiv8x4;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV8X4)
    public String getZtyyobiv8x4() {
        return ztyyobiv8x4;
    }

    public void setZtyyobiv8x4(String pZtyyobiv8x4) {
        ztyyobiv8x4 = pZtyyobiv8x4;
    }

    private Long ztyshrgk11;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRGK11)
    public Long getZtyshrgk11() {
        return ztyshrgk11;
    }

    public void setZtyshrgk11(Long pZtyshrgk11) {
        ztyshrgk11 = pZtyshrgk11;
    }

    private Long ztywarimsishrgk;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYWARIMSISHRGK)
    public Long getZtywarimsishrgk() {
        return ztywarimsishrgk;
    }

    public void setZtywarimsishrgk(Long pZtywarimsishrgk) {
        ztywarimsishrgk = pZtywarimsishrgk;
    }

    private Long ztyznnphr;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYZNNPHR)
    public Long getZtyznnphr() {
        return ztyznnphr;
    }

    public void setZtyznnphr(Long pZtyznnphr) {
        ztyznnphr = pZtyznnphr;
    }

    private Long ztyttkekstkganri;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTTKEKSTKGANRI)
    public Long getZtyttkekstkganri() {
        return ztyttkekstkganri;
    }

    public void setZtyttkekstkganri(Long pZtyttkekstkganri) {
        ztyttkekstkganri = pZtyttkekstkganri;
    }

    private Long ztysshkd;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSSHKD)
    public Long getZtysshkd() {
        return ztysshkd;
    }

    public void setZtysshkd(Long pZtysshkd) {
        ztysshkd = pZtysshkd;
    }

    private Long ztysasihikisiharaigaku;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSASIHIKISIHARAIGAKU)
    public Long getZtysasihikisiharaigaku() {
        return ztysasihikisiharaigaku;
    }

    public void setZtysasihikisiharaigaku(Long pZtysasihikisiharaigaku) {
        ztysasihikisiharaigaku = pZtysasihikisiharaigaku;
    }

    private Long ztymihrkmp;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYMIHRKMP)
    public Long getZtymihrkmp() {
        return ztymihrkmp;
    }

    public void setZtymihrkmp(Long pZtymihrkmp) {
        ztymihrkmp = pZtymihrkmp;
    }

    private Long ztyshrtienrsk11;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRTIENRSK11)
    public Long getZtyshrtienrsk11() {
        return ztyshrtienrsk11;
    }

    public void setZtyshrtienrsk11(Long pZtyshrtienrsk11) {
        ztyshrtienrsk11 = pZtyshrtienrsk11;
    }

    private Long ztytysyouhtykeihi;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTYSYOUHTYKEIHI)
    public Long getZtytysyouhtykeihi() {
        return ztytysyouhtykeihi;
    }

    public void setZtytysyouhtykeihi(Long pZtytysyouhtykeihi) {
        ztytysyouhtykeihi = pZtytysyouhtykeihi;
    }

    private String ztygenkykhtykeihiyouhyj;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYGENKYKHTYKEIHIYOUHYJ)
    public String getZtygenkykhtykeihiyouhyj() {
        return ztygenkykhtykeihiyouhyj;
    }

    public void setZtygenkykhtykeihiyouhyj(String pZtygenkykhtykeihiyouhyj) {
        ztygenkykhtykeihiyouhyj = pZtygenkykhtykeihiyouhyj;
    }

    private Long ztygenkykhtykeihi;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYGENKYKHTYKEIHI)
    public Long getZtygenkykhtykeihi() {
        return ztygenkykhtykeihi;
    }

    public void setZtygenkykhtykeihi(Long pZtygenkykhtykeihi) {
        ztygenkykhtykeihi = pZtygenkykhtykeihi;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztygensenkbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYGENSENKBN)
    public String getZtygensenkbn() {
        return ztygensenkbn;
    }

    public void setZtygensenkbn(String pZtygensenkbn) {
        ztygensenkbn = pZtygensenkbn;
    }

    private String ztygensentaisyoukkngai;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYGENSENTAISYOUKKNGAI)
    public String getZtygensentaisyoukkngai() {
        return ztygensentaisyoukkngai;
    }

    public void setZtygensentaisyoukkngai(String pZtygensentaisyoukkngai) {
        ztygensentaisyoukkngai = pZtygensentaisyoukkngai;
    }

    private String ztygensentaisyoukkn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYGENSENTAISYOUKKN)
    public String getZtygensentaisyoukkn() {
        return ztygensentaisyoukkn;
    }

    public void setZtygensentaisyoukkn(String pZtygensentaisyoukkn) {
        ztygensentaisyoukkn = pZtygensentaisyoukkn;
    }

    private String ztymnsaiannaihnskakbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYMNSAIANNAIHNSKAKBN)
    public String getZtymnsaiannaihnskakbn() {
        return ztymnsaiannaihnskakbn;
    }

    public void setZtymnsaiannaihnskakbn(String pZtymnsaiannaihnskakbn) {
        ztymnsaiannaihnskakbn = pZtymnsaiannaihnskakbn;
    }

    private String ztyshrhousiteikbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRHOUSITEIKBN)
    public String getZtyshrhousiteikbn() {
        return ztyshrhousiteikbn;
    }

    public void setZtyshrhousiteikbn(String pZtyshrhousiteikbn) {
        ztyshrhousiteikbn = pZtyshrhousiteikbn;
    }

    private String ztyshrtysykurikosidisp;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRTYSYKURIKOSIDISP)
    public String getZtyshrtysykurikosidisp() {
        return ztyshrtysykurikosidisp;
    }

    public void setZtyshrtysykurikosidisp(String pZtyshrtysykurikosidisp) {
        ztyshrtysykurikosidisp = pZtyshrtysykurikosidisp;
    }

    private String ztymfadrsiyouhyouji;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYMFADRSIYOUHYOUJI)
    public String getZtymfadrsiyouhyouji() {
        return ztymfadrsiyouhyouji;
    }

    public void setZtymfadrsiyouhyouji(String pZtymfadrsiyouhyouji) {
        ztymfadrsiyouhyouji = pZtymfadrsiyouhyouji;
    }

    private String ztynkshrhkjksyuruikbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYNKSHRHKJKSYURUIKBN)
    public String getZtynkshrhkjksyuruikbn() {
        return ztynkshrhkjksyuruikbn;
    }

    public void setZtynkshrhkjksyuruikbn(String pZtynkshrhkjksyuruikbn) {
        ztynkshrhkjksyuruikbn = pZtynkshrhkjksyuruikbn;
    }

    private String ztynenkinkkn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYNENKINKKN)
    public String getZtynenkinkkn() {
        return ztynenkinkkn;
    }

    public void setZtynenkinkkn(String pZtynenkinkkn) {
        ztynenkinkkn = pZtynenkinkkn;
    }

    private String ztysynyhsjykykndisp;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSYNYHSJYKYKNDISP)
    public String getZtysynyhsjykykndisp() {
        return ztysynyhsjykykndisp;
    }

    public void setZtysynyhsjykykndisp(String pZtysynyhsjykykndisp) {
        ztysynyhsjykykndisp = pZtysynyhsjykykndisp;
    }

    private String ztyonlinecentercutkbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYONLINECENTERCUTKBN)
    public String getZtyonlinecentercutkbn() {
        return ztyonlinecentercutkbn;
    }

    public void setZtyonlinecentercutkbn(String pZtyonlinecentercutkbn) {
        ztyonlinecentercutkbn = pZtyonlinecentercutkbn;
    }

    private String ztyhuho2kykdisp;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYHUHO2KYKDISP)
    public String getZtyhuho2kykdisp() {
        return ztyhuho2kykdisp;
    }

    public void setZtyhuho2kykdisp(String pZtyhuho2kykdisp) {
        ztyhuho2kykdisp = pZtyhuho2kykdisp;
    }

    private String ztyshrtysyhknsyukbn;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYSHRTYSYHKNSYUKBN)
    public String getZtyshrtysyhknsyukbn() {
        return ztyshrtysyhknsyukbn;
    }

    public void setZtyshrtysyhknsyukbn(String pZtyshrtysyhknsyukbn) {
        ztyshrtysyhknsyukbn = pZtyshrtysyhknsyukbn;
    }

    private String ztyyobiv9x5;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV9X5)
    public String getZtyyobiv9x5() {
        return ztyyobiv9x5;
    }

    public void setZtyyobiv9x5(String pZtyyobiv9x5) {
        ztyyobiv9x5 = pZtyyobiv9x5;
    }

    private String ztytekiyouranhensyuukbn1;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTEKIYOURANHENSYUUKBN1)
    public String getZtytekiyouranhensyuukbn1() {
        return ztytekiyouranhensyuukbn1;
    }

    public void setZtytekiyouranhensyuukbn1(String pZtytekiyouranhensyuukbn1) {
        ztytekiyouranhensyuukbn1 = pZtytekiyouranhensyuukbn1;
    }

    private String ztytekiyouranhensyuukbn2;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTEKIYOURANHENSYUUKBN2)
    public String getZtytekiyouranhensyuukbn2() {
        return ztytekiyouranhensyuukbn2;
    }

    public void setZtytekiyouranhensyuukbn2(String pZtytekiyouranhensyuukbn2) {
        ztytekiyouranhensyuukbn2 = pZtytekiyouranhensyuukbn2;
    }

    private String ztytekiyouranhensyuukbn3;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTEKIYOURANHENSYUUKBN3)
    public String getZtytekiyouranhensyuukbn3() {
        return ztytekiyouranhensyuukbn3;
    }

    public void setZtytekiyouranhensyuukbn3(String pZtytekiyouranhensyuukbn3) {
        ztytekiyouranhensyuukbn3 = pZtytekiyouranhensyuukbn3;
    }

    private String ztytekiyouranhensyuukbn4;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTEKIYOURANHENSYUUKBN4)
    public String getZtytekiyouranhensyuukbn4() {
        return ztytekiyouranhensyuukbn4;
    }

    public void setZtytekiyouranhensyuukbn4(String pZtytekiyouranhensyuukbn4) {
        ztytekiyouranhensyuukbn4 = pZtytekiyouranhensyuukbn4;
    }

    private String ztytekiyouranhensyuukbn5;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYTEKIYOURANHENSYUUKBN5)
    public String getZtytekiyouranhensyuukbn5() {
        return ztytekiyouranhensyuukbn5;
    }

    public void setZtytekiyouranhensyuukbn5(String pZtytekiyouranhensyuukbn5) {
        ztytekiyouranhensyuukbn5 = pZtytekiyouranhensyuukbn5;
    }

    private String ztyyobiv181;

    @Column(name=GenZT_SiharaiTyousyoTy.ZTYYOBIV181)
    public String getZtyyobiv181() {
        return ztyyobiv181;
    }

    public void setZtyyobiv181(String pZtyyobiv181) {
        ztyyobiv181 = pZtyyobiv181;
    }
}