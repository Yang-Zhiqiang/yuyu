package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouRn;
import yuyu.def.db.mapping.GenZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.GenQZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouRn;

/**
 * 営業職員システム連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_EgsyokuinSysRendouRn}</td><td colspan="3">営業職員システム連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnatukaikojincd</td><td>（連携用）扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsdpdkbn</td><td>（連携用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihons</td><td>（連携用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnharaikomip</td><td>（連携用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakup</td><td>（連携用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngyousekiyouhosyous</td><td>（連携用）業績用保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkydatkikbn</td><td>（連携用）共同扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatukaisosikicd</td><td>（連携用）扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhensyuukeiyakusyamei</td><td>（連携用）編集契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhnsyuknjkyksynm</td><td>（連携用）編集漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkurikosihyj</td><td>（連携用）繰越表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivingneedstkykarihyj</td><td>（連携用）リビングニーズ特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyhhknsydouituhyouji</td><td>（連携用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaitousiharaikbn</td><td>（連携用）配当支払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenatkikeitaikbn</td><td>（連携用）代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtenegsyokuinatkiwari</td><td>（連携用）代理店営業職員扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnkjsakisosikisetteihyj</td><td>（連携用）計上先組織設定表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsydrtencd</td><td>（連携用）募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimetyokuzenbosyuuhyj</td><td>（連携用）〆切直前募集表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosnyuuryokuymd</td><td>（連携用）申込入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsakuinmeino</td><td>（連携用）被保険者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokusyujimutoriatukaikbn</td><td>（連携用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>zrnmosno</td><td>（連携用）申込番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkansanp</td><td>（連携用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkyksyaskinmeino</td><td>（連携用）契約者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibous</td><td>（連携用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnjissyuup</td><td>（連携用）実収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsekininkaisiymd</td><td>（連携用）責任開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipryosyuymd</td><td>（連携用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseirituymd</td><td>（連携用）成立年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosdairitentsratkiwari</td><td>（連携用）募集代理店手数料扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnbosyuunincd</td><td>（連携用）募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtentsryhushrkykhyouji</td><td>（連携用）代理店手数料不支払契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnaisyoumeikbn</td><td>（連携用）窓販用愛称名区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkykkanrino</td><td>（連携用）代理店契約管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhensyuuyoukyksyaseikbn</td><td>（連携用）編集用契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhensyuuyoukyksyaseiymd</td><td>（連携用）編集用契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknmei</td><td>（連携用）被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn1</td><td>（連携用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyosakuseiymd</td><td>（連携用）申込書作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>zrnyobiv118</td><td>（連携用）予備項目Ｖ１１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_EgsyokuinSysRendouRn
 * @see     GenZT_EgsyokuinSysRendouRn
 * @see     QZT_EgsyokuinSysRendouRn
 * @see     GenQZT_EgsyokuinSysRendouRn
 */
public class PKZT_EgsyokuinSysRendouRn extends AbstractExDBPrimaryKey<ZT_EgsyokuinSysRendouRn, PKZT_EgsyokuinSysRendouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_EgsyokuinSysRendouRn() {
    }

    public PKZT_EgsyokuinSysRendouRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_EgsyokuinSysRendouRn> getEntityClass() {
        return ZT_EgsyokuinSysRendouRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}