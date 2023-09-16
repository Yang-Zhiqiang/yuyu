package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import yuyu.def.db.mapping.GenZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.GenQZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouTy;

/**
 * 営業職員システム連動Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_EgsyokuinSysRendouTy}</td><td colspan="3">営業職員システム連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyatukaikojincd</td><td>（中継用）扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysdpdkbn</td><td>（中継用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihons</td><td>（中継用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyharaikomip</td><td>（中継用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygyousekiyouhosyous</td><td>（中継用）業績用保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykydatkikbn</td><td>（中継用）共同扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinkihontikucd</td><td>（中継用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatukaisosikicd</td><td>（中継用）扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhensyuukeiyakusyamei</td><td>（中継用）編集契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnsyuknjkyksynm</td><td>（中継用）編集漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykurikosihyj</td><td>（中継用）繰越表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivingneedstkykarihyj</td><td>（中継用）リビングニーズ特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyhhknsydouituhyouji</td><td>（中継用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitousiharaikbn</td><td>（中継用）配当支払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenatkikeitaikbn</td><td>（中継用）代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtenegsyokuinatkiwari</td><td>（中継用）代理店営業職員扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykjsakisosikisetteihyj</td><td>（中継用）計上先組織設定表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtencd</td><td>（中継用）募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysimetyokuzenbosyuuhyj</td><td>（中継用）〆切直前募集表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosnyuuryokuymd</td><td>（中継用）申込入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsakuinmeino</td><td>（中継用）被保険者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokusyujimutoriatukaikbn</td><td>（中継用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x1</td><td>（中継用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x2</td><td>（中継用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x3</td><td>（中継用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x4</td><td>（中継用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x5</td><td>（中継用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x6</td><td>（中継用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x7</td><td>（中継用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x8</td><td>（中継用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x9</td><td>（中継用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x10</td><td>（中継用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x11</td><td>（中継用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x12</td><td>（中継用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x13</td><td>（中継用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x14</td><td>（中継用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x15</td><td>（中継用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x1</td><td>（中継用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x2</td><td>（中継用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x3</td><td>（中継用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x4</td><td>（中継用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x5</td><td>（中継用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x6</td><td>（中継用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x7</td><td>（中継用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x8</td><td>（中継用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x9</td><td>（中継用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x10</td><td>（中継用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x1</td><td>（中継用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x2</td><td>（中継用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x3</td><td>（中継用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x4</td><td>（中継用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x5</td><td>（中継用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x6</td><td>（中継用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x7</td><td>（中継用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x8</td><td>（中継用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x9</td><td>（中継用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x10</td><td>（中継用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynstkarihyj</td><td>（中継用）年金支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosno</td><td>（中継用）申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdairiseikyuutkykarihyj</td><td>（中継用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkansanp</td><td>（中継用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykyksyaskinmeino</td><td>（中継用）契約者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibous</td><td>（中継用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyjissyuup</td><td>（中継用）実収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysekininkaisiymd</td><td>（中継用）責任開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykokutiymd</td><td>（中継用）告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipryosyuymd</td><td>（中継用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseirituymd</td><td>（中継用）成立年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosdairitentsratkiwari</td><td>（中継用）募集代理店手数料扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztybosyuunincd</td><td>（中継用）募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtentsryhushrkykhyouji</td><td>（中継用）代理店手数料不支払契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnaisyoumeikbn</td><td>（中継用）窓販用愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkykkanrino</td><td>（中継用）代理店契約管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjitsinkaiadr</td><td>（中継用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhensyuuyoukyksyaseikbn</td><td>（中継用）編集用契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhensyuuyoukyksyaseiymd</td><td>（中継用）編集用契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknmei</td><td>（中継用）被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn1</td><td>（中継用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyosakuseiymd</td><td>（中継用）申込書作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibaraipkyktuuka</td><td>（中継用）一時払Ｐ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseraten5</td><td>（中継用）為替レートＮ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhrktuukakbn</td><td>（中継用）払込通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteituukakbn</td><td>（中継用）指定通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyksbsitihsyutkykarihyj</td><td>（中継用）初期死亡時最低保証特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskkaigomaehrtkykarihyj</td><td>（中継用）（新契約）介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonskyktuuka</td><td>（中継用）基本Ｓ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzenkizennouhyouji</td><td>（中継用）全期前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssysyup</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynknsnpssyhrkkskbn</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtkykarihyj</td><td>（中継用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkservicearihyj</td><td>（中継用）ご家族登録サービス有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x1</td><td>（中継用）予備項目Ｖ２５０＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x2</td><td>（中継用）予備項目Ｖ２５０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x3</td><td>（中継用）予備項目Ｖ２５０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x4</td><td>（中継用）予備項目Ｖ２５０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x5</td><td>（中継用）予備項目Ｖ２５０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv118</td><td>（中継用）予備項目Ｖ１１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_EgsyokuinSysRendouTy
 * @see     GenZT_EgsyokuinSysRendouTy
 * @see     QZT_EgsyokuinSysRendouTy
 * @see     GenQZT_EgsyokuinSysRendouTy
 */
public class PKZT_EgsyokuinSysRendouTy extends AbstractExDBPrimaryKey<ZT_EgsyokuinSysRendouTy, PKZT_EgsyokuinSysRendouTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_EgsyokuinSysRendouTy() {
    }

    public PKZT_EgsyokuinSysRendouTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_EgsyokuinSysRendouTy> getEntityClass() {
        return ZT_EgsyokuinSysRendouTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}