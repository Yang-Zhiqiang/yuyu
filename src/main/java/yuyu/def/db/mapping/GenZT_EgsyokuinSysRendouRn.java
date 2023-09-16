package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouRn;
import yuyu.def.db.id.PKZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.GenQZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouRn;

/**
 * 営業職員システム連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_EgsyokuinSysRendouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_EgsyokuinSysRendouRn}</td><td colspan="3">営業職員システム連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_EgsyokuinSysRendouRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsdpdkbn zrnsdpdkbn}</td><td>（連携用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngyousekiyouhosyous zrngyousekiyouhosyous}</td><td>（連携用）業績用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbn zrnkydatkikbn}</td><td>（連携用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaisosikicd zrnatukaisosikicd}</td><td>（連携用）扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhensyuukeiyakusyamei zrnhensyuukeiyakusyamei}</td><td>（連携用）編集契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnsyuknjkyksynm zrnhnsyuknjkyksynm}</td><td>（連携用）編集漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkurikosihyj zrnkurikosihyj}</td><td>（連携用）繰越表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedstkykarihyj zrnlivingneedstkykarihyj}</td><td>（連携用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyhhknsydouituhyouji zrnkyksyhhknsydouituhyouji}</td><td>（連携用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitousiharaikbn zrnhaitousiharaikbn}</td><td>（連携用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenatkikeitaikbn zrndairitenatkikeitaikbn}</td><td>（連携用）代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtenegsyokuinatkiwari zrndrtenegsyokuinatkiwari}</td><td>（連携用）代理店営業職員扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkjsakisosikisetteihyj zrnkjsakisosikisetteihyj}</td><td>（連携用）計上先組織設定表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimetyokuzenbosyuuhyj zrnsimetyokuzenbosyuuhyj}</td><td>（連携用）〆切直前募集表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosnyuuryokuymd zrnmosnyuuryokuymd}</td><td>（連携用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsakuinmeino zrnhhknsakuinmeino}</td><td>（連携用）被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusyujimutoriatukaikbn zrntokusyujimutoriatukaikbn}</td><td>（連携用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnstkarihyj zrnnstkarihyj}</td><td>（連携用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkansanp zrnnenkansanp}</td><td>（連携用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkyksyaskinmeino zrnkyksyaskinmeino}</td><td>（連携用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjissyuup zrnjissyuup}</td><td>（連携用）実収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsekininkaisiymd zrnsekininkaisiymd}</td><td>（連携用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipryosyuymd zrnsyokaipryosyuymd}</td><td>（連携用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseirituymd zrnseirituymd}</td><td>（連携用）成立年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosdairitentsratkiwari zrnbosdairitentsratkiwari}</td><td>（連携用）募集代理店手数料扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtentsryhushrkykhyouji zrndrtentsryhushrkykhyouji}</td><td>（連携用）代理店手数料不支払契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeikbn zrnmdhnaisyoumeikbn}</td><td>（連携用）窓販用愛称名区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkykkanrino zrndairitenkykkanrino}</td><td>（連携用）代理店契約管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitsinkaiadr zrnkanjitsinkaiadr}</td><td>（連携用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhensyuuyoukyksyaseikbn zrnhensyuuyoukyksyaseikbn}</td><td>（連携用）編集用契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhensyuuyoukyksyaseiymd zrnhensyuuyoukyksyaseiymd}</td><td>（連携用）編集用契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknmei zrnhhknmei}</td><td>（連携用）被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn1 zrnnksyuruikbn1}</td><td>（連携用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyosakuseiymd zrnmossyosakuseiymd}</td><td>（連携用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibaraipkyktuuka zrnitijibaraipkyktuuka}</td><td>（連携用）一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseraten5 zrnkawaseraten5}</td><td>（連携用）為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhrktuukakbn zrnhrktuukakbn}</td><td>（連携用）払込通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakbn zrnsiteituukakbn}</td><td>（連携用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyksbsitihsyutkykarihyj zrnsyksbsitihsyutkykarihyj}</td><td>（連携用）初期死亡時最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskkaigomaehrtkykarihyj zrnskkaigomaehrtkykarihyj}</td><td>（連携用）（新契約）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonskyktuuka zrnkihonskyktuuka}</td><td>（連携用）基本Ｓ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzenkizennouhyouji zrnzenkizennouhyouji}</td><td>（連携用）全期前納表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssysyup zrnnnknsnpssysyup}</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnknsnpssyhrkkskbn zrnnknsnpssyhrkkskbn}</td><td>（連携用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkservicearihyj zrnkzktrkservicearihyj}</td><td>（連携用）ご家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x1 zrnyobiv250x1}</td><td>（連携用）予備項目Ｖ２５０＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x2 zrnyobiv250x2}</td><td>（連携用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x3 zrnyobiv250x3}</td><td>（連携用）予備項目Ｖ２５０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x4 zrnyobiv250x4}</td><td>（連携用）予備項目Ｖ２５０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x5 zrnyobiv250x5}</td><td>（連携用）予備項目Ｖ２５０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv118 zrnyobiv118}</td><td>（連携用）予備項目Ｖ１１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_EgsyokuinSysRendouRn
 * @see     PKZT_EgsyokuinSysRendouRn
 * @see     QZT_EgsyokuinSysRendouRn
 * @see     GenQZT_EgsyokuinSysRendouRn
 */
@MappedSuperclass
@Table(name=GenZT_EgsyokuinSysRendouRn.TABLE_NAME)
@IdClass(value=PKZT_EgsyokuinSysRendouRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_EgsyokuinSysRendouRn extends AbstractExDBEntityForZDB<ZT_EgsyokuinSysRendouRn, PKZT_EgsyokuinSysRendouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_EgsyokuinSysRendouRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNATUKAIKOJINCD         = "zrnatukaikojincd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNSDPDKBN               = "zrnsdpdkbn";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNGYOUSEKIYOUHOSYOUS    = "zrngyousekiyouhosyous";
    public static final String ZRNKYDATKIKBN            = "zrnkydatkikbn";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNATUKAISOSIKICD        = "zrnatukaisosikicd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHENSYUUKEIYAKUSYAMEI  = "zrnhensyuukeiyakusyamei";
    public static final String ZRNHNSYUKNJKYKSYNM       = "zrnhnsyuknjkyksynm";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNKURIKOSIHYJ           = "zrnkurikosihyj";
    public static final String ZRNLIVINGNEEDSTKYKARIHYJ = "zrnlivingneedstkykarihyj";
    public static final String ZRNKYKSYHHKNSYDOUITUHYOUJI = "zrnkyksyhhknsydouituhyouji";
    public static final String ZRNHAITOUSIHARAIKBN      = "zrnhaitousiharaikbn";
    public static final String ZRNDAIRITENATKIKEITAIKBN = "zrndairitenatkikeitaikbn";
    public static final String ZRNDRTENEGSYOKUINATKIWARI = "zrndrtenegsyokuinatkiwari";
    public static final String ZRNKJSAKISOSIKISETTEIHYJ = "zrnkjsakisosikisetteihyj";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNSIMETYOKUZENBOSYUUHYJ = "zrnsimetyokuzenbosyuuhyj";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNMOSNYUURYOKUYMD       = "zrnmosnyuuryokuymd";
    public static final String ZRNHHKNSAKUINMEINO       = "zrnhhknsakuinmeino";
    public static final String ZRNTOKUSYUJIMUTORIATUKAIKBN = "zrntokusyujimutoriatukaikbn";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNNSTKARIHYJ            = "zrnnstkarihyj";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNNENKANSANP            = "zrnnenkansanp";
    public static final String ZRNKYKSYASKINMEINO       = "zrnkyksyaskinmeino";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNJISSYUUP              = "zrnjissyuup";
    public static final String ZRNSEKININKAISIYMD       = "zrnsekininkaisiymd";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNSYOKAIPRYOSYUYMD      = "zrnsyokaipryosyuymd";
    public static final String ZRNSEIRITUYMD            = "zrnseirituymd";
    public static final String ZRNBOSDAIRITENTSRATKIWARI = "zrnbosdairitentsratkiwari";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNDRTENTSRYHUSHRKYKHYOUJI = "zrndrtentsryhushrkykhyouji";
    public static final String ZRNMDHNAISYOUMEIKBN      = "zrnmdhnaisyoumeikbn";
    public static final String ZRNDAIRITENKYKKANRINO    = "zrndairitenkykkanrino";
    public static final String ZRNKANJITSINKAIADR       = "zrnkanjitsinkaiadr";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNHENSYUUYOUKYKSYASEIKBN = "zrnhensyuuyoukyksyaseikbn";
    public static final String ZRNHENSYUUYOUKYKSYASEIYMD = "zrnhensyuuyoukyksyaseiymd";
    public static final String ZRNHHKNMEI               = "zrnhhknmei";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNNKSYURUIKBN1          = "zrnnksyuruikbn1";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNMOSSYOSAKUSEIYMD      = "zrnmossyosakuseiymd";
    public static final String ZRNITIJIBARAIPKYKTUUKA   = "zrnitijibaraipkyktuuka";
    public static final String ZRNKAWASERATEN5          = "zrnkawaseraten5";
    public static final String ZRNHRKTUUKAKBN           = "zrnhrktuukakbn";
    public static final String ZRNSITEITUUKAKBN         = "zrnsiteituukakbn";
    public static final String ZRNSYKSBSITIHSYUTKYKARIHYJ = "zrnsyksbsitihsyutkykarihyj";
    public static final String ZRNSKKAIGOMAEHRTKYKARIHYJ = "zrnskkaigomaehrtkykarihyj";
    public static final String ZRNKIHONSKYKTUUKA        = "zrnkihonskyktuuka";
    public static final String ZRNZENKIZENNOUHYOUJI     = "zrnzenkizennouhyouji";
    public static final String ZRNNNKNSNPSSYSYUP        = "zrnnnknsnpssysyup";
    public static final String ZRNNKNSNPSSYHRKKSKBN     = "zrnnknsnpssyhrkkskbn";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNKZKTRKSERVICEARIHYJ   = "zrnkzktrkservicearihyj";
    public static final String ZRNYOBIV250X1            = "zrnyobiv250x1";
    public static final String ZRNYOBIV250X2            = "zrnyobiv250x2";
    public static final String ZRNYOBIV250X3            = "zrnyobiv250x3";
    public static final String ZRNYOBIV250X4            = "zrnyobiv250x4";
    public static final String ZRNYOBIV250X5            = "zrnyobiv250x5";
    public static final String ZRNYOBIV118              = "zrnyobiv118";

    private final PKZT_EgsyokuinSysRendouRn primaryKey;

    public GenZT_EgsyokuinSysRendouRn() {
        primaryKey = new PKZT_EgsyokuinSysRendouRn();
    }

    public GenZT_EgsyokuinSysRendouRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_EgsyokuinSysRendouRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_EgsyokuinSysRendouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_EgsyokuinSysRendouRn> getMetaClass() {
        return QZT_EgsyokuinSysRendouRn.class;
    }

    @Id
    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnatukaikojincd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNATUKAIKOJINCD)
    public String getZrnatukaikojincd() {
        return zrnatukaikojincd;
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        zrnatukaikojincd = pZrnatukaikojincd;
    }

    private String zrnsyono;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnkykymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnsdpdkbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSDPDKBN)
    public String getZrnsdpdkbn() {
        return zrnsdpdkbn;
    }

    public void setZrnsdpdkbn(String pZrnsdpdkbn) {
        zrnsdpdkbn = pZrnsdpdkbn;
    }

    private Long zrnkihons;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrngyousekiyouhosyous;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNGYOUSEKIYOUHOSYOUS)
    public Long getZrngyousekiyouhosyous() {
        return zrngyousekiyouhosyous;
    }

    public void setZrngyousekiyouhosyous(Long pZrngyousekiyouhosyous) {
        zrngyousekiyouhosyous = pZrngyousekiyouhosyous;
    }

    private String zrnkydatkikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKYDATKIKBN)
    public String getZrnkydatkikbn() {
        return zrnkydatkikbn;
    }

    public void setZrnkydatkikbn(String pZrnkydatkikbn) {
        zrnkydatkikbn = pZrnkydatkikbn;
    }

    private String zrnbsyym;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnatukaisosikicd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNATUKAISOSIKICD)
    public String getZrnatukaisosikicd() {
        return zrnatukaisosikicd;
    }

    public void setZrnatukaisosikicd(String pZrnatukaisosikicd) {
        zrnatukaisosikicd = pZrnatukaisosikicd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhensyuukeiyakusyamei;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHENSYUUKEIYAKUSYAMEI)
    public String getZrnhensyuukeiyakusyamei() {
        return zrnhensyuukeiyakusyamei;
    }

    public void setZrnhensyuukeiyakusyamei(String pZrnhensyuukeiyakusyamei) {
        zrnhensyuukeiyakusyamei = pZrnhensyuukeiyakusyamei;
    }

    private String zrnhnsyuknjkyksynm;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHNSYUKNJKYKSYNM)
    public String getZrnhnsyuknjkyksynm() {
        return zrnhnsyuknjkyksynm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnsyuknjkyksynm(String pZrnhnsyuknjkyksynm) {
        zrnhnsyuknjkyksynm = pZrnhnsyuknjkyksynm;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnkurikosihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKURIKOSIHYJ)
    public String getZrnkurikosihyj() {
        return zrnkurikosihyj;
    }

    public void setZrnkurikosihyj(String pZrnkurikosihyj) {
        zrnkurikosihyj = pZrnkurikosihyj;
    }

    private String zrnlivingneedstkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNLIVINGNEEDSTKYKARIHYJ)
    public String getZrnlivingneedstkykarihyj() {
        return zrnlivingneedstkykarihyj;
    }

    public void setZrnlivingneedstkykarihyj(String pZrnlivingneedstkykarihyj) {
        zrnlivingneedstkykarihyj = pZrnlivingneedstkykarihyj;
    }

    private String zrnkyksyhhknsydouituhyouji;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKYKSYHHKNSYDOUITUHYOUJI)
    public String getZrnkyksyhhknsydouituhyouji() {
        return zrnkyksyhhknsydouituhyouji;
    }

    public void setZrnkyksyhhknsydouituhyouji(String pZrnkyksyhhknsydouituhyouji) {
        zrnkyksyhhknsydouituhyouji = pZrnkyksyhhknsydouituhyouji;
    }

    private String zrnhaitousiharaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHAITOUSIHARAIKBN)
    public String getZrnhaitousiharaikbn() {
        return zrnhaitousiharaikbn;
    }

    public void setZrnhaitousiharaikbn(String pZrnhaitousiharaikbn) {
        zrnhaitousiharaikbn = pZrnhaitousiharaikbn;
    }

    private String zrndairitenatkikeitaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNDAIRITENATKIKEITAIKBN)
    public String getZrndairitenatkikeitaikbn() {
        return zrndairitenatkikeitaikbn;
    }

    public void setZrndairitenatkikeitaikbn(String pZrndairitenatkikeitaikbn) {
        zrndairitenatkikeitaikbn = pZrndairitenatkikeitaikbn;
    }

    private Integer zrndrtenegsyokuinatkiwari;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNDRTENEGSYOKUINATKIWARI)
    public Integer getZrndrtenegsyokuinatkiwari() {
        return zrndrtenegsyokuinatkiwari;
    }

    public void setZrndrtenegsyokuinatkiwari(Integer pZrndrtenegsyokuinatkiwari) {
        zrndrtenegsyokuinatkiwari = pZrndrtenegsyokuinatkiwari;
    }

    private String zrnkjsakisosikisetteihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKJSAKISOSIKISETTEIHYJ)
    public String getZrnkjsakisosikisetteihyj() {
        return zrnkjsakisosikisetteihyj;
    }

    public void setZrnkjsakisosikisetteihyj(String pZrnkjsakisosikisetteihyj) {
        zrnkjsakisosikisetteihyj = pZrnkjsakisosikisetteihyj;
    }

    private String zrnbsydrtencd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }

    private String zrnsimetyokuzenbosyuuhyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSIMETYOKUZENBOSYUUHYJ)
    public String getZrnsimetyokuzenbosyuuhyj() {
        return zrnsimetyokuzenbosyuuhyj;
    }

    public void setZrnsimetyokuzenbosyuuhyj(String pZrnsimetyokuzenbosyuuhyj) {
        zrnsimetyokuzenbosyuuhyj = pZrnsimetyokuzenbosyuuhyj;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnmosnyuuryokuymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNMOSNYUURYOKUYMD)
    public String getZrnmosnyuuryokuymd() {
        return zrnmosnyuuryokuymd;
    }

    public void setZrnmosnyuuryokuymd(String pZrnmosnyuuryokuymd) {
        zrnmosnyuuryokuymd = pZrnmosnyuuryokuymd;
    }

    private String zrnhhknsakuinmeino;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHHKNSAKUINMEINO)
    public String getZrnhhknsakuinmeino() {
        return zrnhhknsakuinmeino;
    }

    public void setZrnhhknsakuinmeino(String pZrnhhknsakuinmeino) {
        zrnhhknsakuinmeino = pZrnhhknsakuinmeino;
    }

    private String zrntokusyujimutoriatukaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNTOKUSYUJIMUTORIATUKAIKBN)
    public String getZrntokusyujimutoriatukaikbn() {
        return zrntokusyujimutoriatukaikbn;
    }

    public void setZrntokusyujimutoriatukaikbn(String pZrntokusyujimutoriatukaikbn) {
        zrntokusyujimutoriatukaikbn = pZrntokusyujimutoriatukaikbn;
    }

    private String zrncifcd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrnnstkarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNNSTKARIHYJ)
    public String getZrnnstkarihyj() {
        return zrnnstkarihyj;
    }

    public void setZrnnstkarihyj(String pZrnnstkarihyj) {
        zrnnstkarihyj = pZrnnstkarihyj;
    }

    private String zrnmosno;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNMOSNO)
    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private Long zrnnenkansanp;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNNENKANSANP)
    public Long getZrnnenkansanp() {
        return zrnnenkansanp;
    }

    public void setZrnnenkansanp(Long pZrnnenkansanp) {
        zrnnenkansanp = pZrnnenkansanp;
    }

    private String zrnkyksyaskinmeino;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKYKSYASKINMEINO)
    public String getZrnkyksyaskinmeino() {
        return zrnkyksyaskinmeino;
    }

    public void setZrnkyksyaskinmeino(String pZrnkyksyaskinmeino) {
        zrnkyksyaskinmeino = pZrnkyksyaskinmeino;
    }

    private Long zrnsibous;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrnjissyuup;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNJISSYUUP)
    public Long getZrnjissyuup() {
        return zrnjissyuup;
    }

    public void setZrnjissyuup(Long pZrnjissyuup) {
        zrnjissyuup = pZrnjissyuup;
    }

    private String zrnsekininkaisiymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSEKININKAISIYMD)
    public String getZrnsekininkaisiymd() {
        return zrnsekininkaisiymd;
    }

    public void setZrnsekininkaisiymd(String pZrnsekininkaisiymd) {
        zrnsekininkaisiymd = pZrnsekininkaisiymd;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrnsyokaipryosyuymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSYOKAIPRYOSYUYMD)
    public String getZrnsyokaipryosyuymd() {
        return zrnsyokaipryosyuymd;
    }

    public void setZrnsyokaipryosyuymd(String pZrnsyokaipryosyuymd) {
        zrnsyokaipryosyuymd = pZrnsyokaipryosyuymd;
    }

    private String zrnseirituymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSEIRITUYMD)
    public String getZrnseirituymd() {
        return zrnseirituymd;
    }

    public void setZrnseirituymd(String pZrnseirituymd) {
        zrnseirituymd = pZrnseirituymd;
    }

    private Integer zrnbosdairitentsratkiwari;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNBOSDAIRITENTSRATKIWARI)
    public Integer getZrnbosdairitentsratkiwari() {
        return zrnbosdairitentsratkiwari;
    }

    public void setZrnbosdairitentsratkiwari(Integer pZrnbosdairitentsratkiwari) {
        zrnbosdairitentsratkiwari = pZrnbosdairitentsratkiwari;
    }

    private String zrnbosyuunincd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }

    private String zrndrtentsryhushrkykhyouji;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNDRTENTSRYHUSHRKYKHYOUJI)
    public String getZrndrtentsryhushrkykhyouji() {
        return zrndrtentsryhushrkykhyouji;
    }

    public void setZrndrtentsryhushrkykhyouji(String pZrndrtentsryhushrkykhyouji) {
        zrndrtentsryhushrkykhyouji = pZrndrtentsryhushrkykhyouji;
    }

    private String zrnmdhnaisyoumeikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNMDHNAISYOUMEIKBN)
    public String getZrnmdhnaisyoumeikbn() {
        return zrnmdhnaisyoumeikbn;
    }

    public void setZrnmdhnaisyoumeikbn(String pZrnmdhnaisyoumeikbn) {
        zrnmdhnaisyoumeikbn = pZrnmdhnaisyoumeikbn;
    }

    private String zrndairitenkykkanrino;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNDAIRITENKYKKANRINO)
    public String getZrndairitenkykkanrino() {
        return zrndairitenkykkanrino;
    }

    public void setZrndairitenkykkanrino(String pZrndairitenkykkanrino) {
        zrndairitenkykkanrino = pZrndairitenkykkanrino;
    }

    private String zrnkanjitsinkaiadr;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKANJITSINKAIADR)
    public String getZrnkanjitsinkaiadr() {
        return zrnkanjitsinkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitsinkaiadr(String pZrnkanjitsinkaiadr) {
        zrnkanjitsinkaiadr = pZrnkanjitsinkaiadr;
    }

    private String zrntsintelno;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrnhensyuuyoukyksyaseikbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHENSYUUYOUKYKSYASEIKBN)
    public String getZrnhensyuuyoukyksyaseikbn() {
        return zrnhensyuuyoukyksyaseikbn;
    }

    public void setZrnhensyuuyoukyksyaseikbn(String pZrnhensyuuyoukyksyaseikbn) {
        zrnhensyuuyoukyksyaseikbn = pZrnhensyuuyoukyksyaseikbn;
    }

    private String zrnhensyuuyoukyksyaseiymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHENSYUUYOUKYKSYASEIYMD)
    public String getZrnhensyuuyoukyksyaseiymd() {
        return zrnhensyuuyoukyksyaseiymd;
    }

    public void setZrnhensyuuyoukyksyaseiymd(String pZrnhensyuuyoukyksyaseiymd) {
        zrnhensyuuyoukyksyaseiymd = pZrnhensyuuyoukyksyaseiymd;
    }

    private String zrnhhknmei;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHHKNMEI)
    public String getZrnhhknmei() {
        return zrnhhknmei;
    }

    public void setZrnhhknmei(String pZrnhhknmei) {
        zrnhhknmei = pZrnhhknmei;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnnksyuruikbn1;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNNKSYURUIKBN1)
    public String getZrnnksyuruikbn1() {
        return zrnnksyuruikbn1;
    }

    public void setZrnnksyuruikbn1(String pZrnnksyuruikbn1) {
        zrnnksyuruikbn1 = pZrnnksyuruikbn1;
    }

    private String zrnmusymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnmossyosakuseiymd;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNMOSSYOSAKUSEIYMD)
    public String getZrnmossyosakuseiymd() {
        return zrnmossyosakuseiymd;
    }

    public void setZrnmossyosakuseiymd(String pZrnmossyosakuseiymd) {
        zrnmossyosakuseiymd = pZrnmossyosakuseiymd;
    }

    private BizNumber zrnitijibaraipkyktuuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNITIJIBARAIPKYKTUUKA)
    public BizNumber getZrnitijibaraipkyktuuka() {
        return zrnitijibaraipkyktuuka;
    }

    public void setZrnitijibaraipkyktuuka(BizNumber pZrnitijibaraipkyktuuka) {
        zrnitijibaraipkyktuuka = pZrnitijibaraipkyktuuka;
    }

    private BizNumber zrnkawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKAWASERATEN5)
    public BizNumber getZrnkawaseraten5() {
        return zrnkawaseraten5;
    }

    public void setZrnkawaseraten5(BizNumber pZrnkawaseraten5) {
        zrnkawaseraten5 = pZrnkawaseraten5;
    }

    private String zrnhrktuukakbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNHRKTUUKAKBN)
    public String getZrnhrktuukakbn() {
        return zrnhrktuukakbn;
    }

    public void setZrnhrktuukakbn(String pZrnhrktuukakbn) {
        zrnhrktuukakbn = pZrnhrktuukakbn;
    }

    private String zrnsiteituukakbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSITEITUUKAKBN)
    public String getZrnsiteituukakbn() {
        return zrnsiteituukakbn;
    }

    public void setZrnsiteituukakbn(String pZrnsiteituukakbn) {
        zrnsiteituukakbn = pZrnsiteituukakbn;
    }

    private String zrnsyksbsitihsyutkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSYKSBSITIHSYUTKYKARIHYJ)
    public String getZrnsyksbsitihsyutkykarihyj() {
        return zrnsyksbsitihsyutkykarihyj;
    }

    public void setZrnsyksbsitihsyutkykarihyj(String pZrnsyksbsitihsyutkykarihyj) {
        zrnsyksbsitihsyutkykarihyj = pZrnsyksbsitihsyutkykarihyj;
    }

    private String zrnskkaigomaehrtkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNSKKAIGOMAEHRTKYKARIHYJ)
    public String getZrnskkaigomaehrtkykarihyj() {
        return zrnskkaigomaehrtkykarihyj;
    }

    public void setZrnskkaigomaehrtkykarihyj(String pZrnskkaigomaehrtkykarihyj) {
        zrnskkaigomaehrtkykarihyj = pZrnskkaigomaehrtkykarihyj;
    }

    private Long zrnkihonskyktuuka;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKIHONSKYKTUUKA)
    public Long getZrnkihonskyktuuka() {
        return zrnkihonskyktuuka;
    }

    public void setZrnkihonskyktuuka(Long pZrnkihonskyktuuka) {
        zrnkihonskyktuuka = pZrnkihonskyktuuka;
    }

    private String zrnzenkizennouhyouji;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNZENKIZENNOUHYOUJI)
    public String getZrnzenkizennouhyouji() {
        return zrnzenkizennouhyouji;
    }

    public void setZrnzenkizennouhyouji(String pZrnzenkizennouhyouji) {
        zrnzenkizennouhyouji = pZrnzenkizennouhyouji;
    }

    private Long zrnnnknsnpssysyup;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNNNKNSNPSSYSYUP)
    public Long getZrnnnknsnpssysyup() {
        return zrnnnknsnpssysyup;
    }

    public void setZrnnnknsnpssysyup(Long pZrnnnknsnpssysyup) {
        zrnnnknsnpssysyup = pZrnnnknsnpssysyup;
    }

    private String zrnnknsnpssyhrkkskbn;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNNKNSNPSSYHRKKSKBN)
    public String getZrnnknsnpssyhrkkskbn() {
        return zrnnknsnpssyhrkkskbn;
    }

    public void setZrnnknsnpssyhrkkskbn(String pZrnnknsnpssyhrkkskbn) {
        zrnnknsnpssyhrkkskbn = pZrnnknsnpssyhrkkskbn;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnkzktrkservicearihyj;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNKZKTRKSERVICEARIHYJ)
    public String getZrnkzktrkservicearihyj() {
        return zrnkzktrkservicearihyj;
    }

    public void setZrnkzktrkservicearihyj(String pZrnkzktrkservicearihyj) {
        zrnkzktrkservicearihyj = pZrnkzktrkservicearihyj;
    }

    private String zrnyobiv250x1;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNYOBIV250X1)
    public String getZrnyobiv250x1() {
        return zrnyobiv250x1;
    }

    public void setZrnyobiv250x1(String pZrnyobiv250x1) {
        zrnyobiv250x1 = pZrnyobiv250x1;
    }

    private String zrnyobiv250x2;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNYOBIV250X2)
    public String getZrnyobiv250x2() {
        return zrnyobiv250x2;
    }

    public void setZrnyobiv250x2(String pZrnyobiv250x2) {
        zrnyobiv250x2 = pZrnyobiv250x2;
    }

    private String zrnyobiv250x3;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNYOBIV250X3)
    public String getZrnyobiv250x3() {
        return zrnyobiv250x3;
    }

    public void setZrnyobiv250x3(String pZrnyobiv250x3) {
        zrnyobiv250x3 = pZrnyobiv250x3;
    }

    private String zrnyobiv250x4;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNYOBIV250X4)
    public String getZrnyobiv250x4() {
        return zrnyobiv250x4;
    }

    public void setZrnyobiv250x4(String pZrnyobiv250x4) {
        zrnyobiv250x4 = pZrnyobiv250x4;
    }

    private String zrnyobiv250x5;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNYOBIV250X5)
    public String getZrnyobiv250x5() {
        return zrnyobiv250x5;
    }

    public void setZrnyobiv250x5(String pZrnyobiv250x5) {
        zrnyobiv250x5 = pZrnyobiv250x5;
    }

    private String zrnyobiv118;

    @Column(name=GenZT_EgsyokuinSysRendouRn.ZRNYOBIV118)
    public String getZrnyobiv118() {
        return zrnyobiv118;
    }

    public void setZrnyobiv118(String pZrnyobiv118) {
        zrnyobiv118 = pZrnyobiv118;
    }
}