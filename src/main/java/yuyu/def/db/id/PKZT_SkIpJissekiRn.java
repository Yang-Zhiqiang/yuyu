package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkIpJissekiRn;
import yuyu.def.db.mapping.GenZT_SkIpJissekiRn;
import yuyu.def.db.meta.GenQZT_SkIpJissekiRn;
import yuyu.def.db.meta.QZT_SkIpJissekiRn;

/**
 * 新契約インプット実績Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkIpJissekiRn}</td><td colspan="3">新契約インプット実績Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnmosym</td><td>（連携用）申込月度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatukaikojincd</td><td>（連携用）扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenatkikeitaikbn</td><td>（連携用）代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatkiwari3keta</td><td>（連携用）扱割合（３桁）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnkjsakininisetteihyj</td><td>（連携用）計上先任意設定表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosno</td><td>（連携用）申込番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkikbn</td><td>（連携用）共同扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyoumetukbn</td><td>（連携用）申込消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykktaikbn</td><td>（連携用）契約形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryouritukbn</td><td>（連携用）料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrendouyouharaikomip</td><td>（連携用）連動用払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakup</td><td>（連携用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnatukaisosikicd</td><td>（連携用）扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeiyousinsakbn</td><td>（連携用）統計用診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsdpdkbn</td><td>（連携用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyousekiyouhosyous</td><td>（連携用）業績用保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeikihons</td><td>（連携用）合計基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosnyuuryokuymd</td><td>（連携用）申込入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipryosyuymd</td><td>（連携用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstpnyknsyoriymd</td><td>（連携用）初回Ｐ入金処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyumtkktymd</td><td>（連携用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisyaketsyoriymd</td><td>（連携用）支社決定処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyosakuseiymd</td><td>（連携用）申込書作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsakuinmeino</td><td>（連携用）被保険者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaitousiharaikbn</td><td>（連携用）配当支払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhubikbn</td><td>（連携用）不備区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisekiym</td><td>（連携用）成績計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokusyujimutoriatukaikbn</td><td>（連携用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsydrtencd</td><td>（連携用）募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaskinmeino</td><td>（連携用）契約者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossakuseino</td><td>（連携用）申込書作成番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x1</td><td>（連携用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x2</td><td>（連携用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x3</td><td>（連携用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x4</td><td>（連携用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x5</td><td>（連携用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x6</td><td>（連携用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x7</td><td>（連携用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x8</td><td>（連携用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x9</td><td>（連携用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x10</td><td>（連携用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x11</td><td>（連携用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x12</td><td>（連携用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x13</td><td>（連携用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x14</td><td>（連携用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x15</td><td>（連携用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x1</td><td>（連携用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x2</td><td>（連携用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x3</td><td>（連携用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x4</td><td>（連携用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x5</td><td>（連携用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x6</td><td>（連携用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x7</td><td>（連携用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x8</td><td>（連携用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x9</td><td>（連携用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x10</td><td>（連携用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x1</td><td>（連携用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x2</td><td>（連携用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x3</td><td>（連携用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x4</td><td>（連携用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x5</td><td>（連携用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x6</td><td>（連携用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x7</td><td>（連携用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x8</td><td>（連携用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x9</td><td>（連携用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x10</td><td>（連携用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnstkarihyj</td><td>（連携用）年金支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai1kyktdkkbn</td><td>（連携用）第１契約者続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyouninymd</td><td>（連携用）申込承認入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkansanp</td><td>（連携用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsibous</td><td>（連携用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnksyuruikbn1</td><td>（連携用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhensyuukeiyakusyamei</td><td>（連携用）編集契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknmei</td><td>（連携用）被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhensyuuyoukyksyaseiymd</td><td>（連携用）編集用契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibaraipkyktuuka</td><td>（連携用）一時払Ｐ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkawaseraten5</td><td>（連携用）為替レートＮ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhrktuukakbn</td><td>（連携用）払込通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteituukakbn</td><td>（連携用）指定通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyksbsitihsyutkykarihyj</td><td>（連携用）初期死亡時最低保証特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskkaigomaehrtkykarihyj</td><td>（連携用）（新契約）介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihonskyktuuka</td><td>（連携用）基本Ｓ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzenkizennouhyouji</td><td>（連携用）全期前納表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssysyup</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnknsnpssyhrkkskbn</td><td>（連携用）年換算Ｐ算出用払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkservicearihyj</td><td>（連携用）ご家族登録サービス有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x1</td><td>（連携用）予備項目Ｖ２５０＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x2</td><td>（連携用）予備項目Ｖ２５０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x3</td><td>（連携用）予備項目Ｖ２５０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x4</td><td>（連携用）予備項目Ｖ２５０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x5</td><td>（連携用）予備項目Ｖ２５０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv213</td><td>（連携用）予備項目Ｖ２１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkIpJissekiRn
 * @see     GenZT_SkIpJissekiRn
 * @see     QZT_SkIpJissekiRn
 * @see     GenQZT_SkIpJissekiRn
 */
public class PKZT_SkIpJissekiRn extends AbstractExDBPrimaryKey<ZT_SkIpJissekiRn, PKZT_SkIpJissekiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkIpJissekiRn() {
    }

    public PKZT_SkIpJissekiRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_SkIpJissekiRn> getEntityClass() {
        return ZT_SkIpJissekiRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}