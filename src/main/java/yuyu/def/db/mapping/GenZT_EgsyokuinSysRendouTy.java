package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import yuyu.def.db.id.PKZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.GenQZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouTy;

/**
 * 営業職員システム連動Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_EgsyokuinSysRendouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_EgsyokuinSysRendouTy}</td><td colspan="3">営業職員システム連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_EgsyokuinSysRendouTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygyousekiyouhosyous ztygyousekiyouhosyous}</td><td>（中継用）業績用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaisosikicd ztyatukaisosikicd}</td><td>（中継用）扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuukeiyakusyamei ztyhensyuukeiyakusyamei}</td><td>（中継用）編集契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnsyuknjkyksynm ztyhnsyuknjkyksynm}</td><td>（中継用）編集漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykurikosihyj ztykurikosihyj}</td><td>（中継用）繰越表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneedstkykarihyj ztylivingneedstkykarihyj}</td><td>（中継用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyhhknsydouituhyouji ztykyksyhhknsydouituhyouji}</td><td>（中継用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitousiharaikbn ztyhaitousiharaikbn}</td><td>（中継用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenatkikeitaikbn ztydairitenatkikeitaikbn}</td><td>（中継用）代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtenegsyokuinatkiwari ztydrtenegsyokuinatkiwari}</td><td>（中継用）代理店営業職員扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykjsakisosikisetteihyj ztykjsakisosikisetteihyj}</td><td>（中継用）計上先組織設定表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimetyokuzenbosyuuhyj ztysimetyokuzenbosyuuhyj}</td><td>（中継用）〆切直前募集表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosnyuuryokuymd ztymosnyuuryokuymd}</td><td>（中継用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsakuinmeino ztyhhknsakuinmeino}</td><td>（中継用）被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyujimutoriatukaikbn ztytokusyujimutoriatukaikbn}</td><td>（中継用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynstkarihyj ztynstkarihyj}</td><td>（中継用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkansanp ztynenkansanp}</td><td>（中継用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykyksyaskinmeino ztykyksyaskinmeino}</td><td>（中継用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjissyuup ztyjissyuup}</td><td>（中継用）実収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysekininkaisiymd ztysekininkaisiymd}</td><td>（中継用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipryosyuymd ztysyokaipryosyuymd}</td><td>（中継用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseirituymd ztyseirituymd}</td><td>（中継用）成立年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosdairitentsratkiwari ztybosdairitentsratkiwari}</td><td>（中継用）募集代理店手数料扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtentsryhushrkykhyouji ztydrtentsryhushrkykhyouji}</td><td>（中継用）代理店手数料不支払契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeikbn ztymdhnaisyoumeikbn}</td><td>（中継用）窓販用愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkykkanrino ztydairitenkykkanrino}</td><td>（中継用）代理店契約管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuuyoukyksyaseikbn ztyhensyuuyoukyksyaseikbn}</td><td>（中継用）編集用契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuuyoukyksyaseiymd ztyhensyuuyoukyksyaseiymd}</td><td>（中継用）編集用契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn1 ztynksyuruikbn1}</td><td>（中継用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyosakuseiymd ztymossyosakuseiymd}</td><td>（中継用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibaraipkyktuuka ztyitijibaraipkyktuuka}</td><td>（中継用）一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseraten5 ztykawaseraten5}</td><td>（中継用）為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhrktuukakbn ztyhrktuukakbn}</td><td>（中継用）払込通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukakbn ztysiteituukakbn}</td><td>（中継用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbsitihsyutkykarihyj ztysyksbsitihsyutkykarihyj}</td><td>（中継用）初期死亡時最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskkaigomaehrtkykarihyj ztyskkaigomaehrtkykarihyj}</td><td>（中継用）（新契約）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonskyktuuka ztykihonskyktuuka}</td><td>（中継用）基本Ｓ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzenkizennouhyouji ztyzenkizennouhyouji}</td><td>（中継用）全期前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssysyup ztynnknsnpssysyup}</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynknsnpssyhrkkskbn ztynknsnpssyhrkkskbn}</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkservicearihyj ztykzktrkservicearihyj}</td><td>（中継用）ご家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x1 ztyyobiv250x1}</td><td>（中継用）予備項目Ｖ２５０＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x2 ztyyobiv250x2}</td><td>（中継用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x3 ztyyobiv250x3}</td><td>（中継用）予備項目Ｖ２５０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x4 ztyyobiv250x4}</td><td>（中継用）予備項目Ｖ２５０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x5 ztyyobiv250x5}</td><td>（中継用）予備項目Ｖ２５０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv118 ztyyobiv118}</td><td>（中継用）予備項目Ｖ１１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_EgsyokuinSysRendouTy
 * @see     PKZT_EgsyokuinSysRendouTy
 * @see     QZT_EgsyokuinSysRendouTy
 * @see     GenQZT_EgsyokuinSysRendouTy
 */
@MappedSuperclass
@Table(name=GenZT_EgsyokuinSysRendouTy.TABLE_NAME)
@IdClass(value=PKZT_EgsyokuinSysRendouTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_EgsyokuinSysRendouTy extends AbstractExDBEntity<ZT_EgsyokuinSysRendouTy, PKZT_EgsyokuinSysRendouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_EgsyokuinSysRendouTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYATUKAIKOJINCD         = "ztyatukaikojincd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYGYOUSEKIYOUHOSYOUS    = "ztygyousekiyouhosyous";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYATUKAISOSIKICD        = "ztyatukaisosikicd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYHENSYUUKEIYAKUSYAMEI  = "ztyhensyuukeiyakusyamei";
    public static final String ZTYHNSYUKNJKYKSYNM       = "ztyhnsyuknjkyksynm";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYKURIKOSIHYJ           = "ztykurikosihyj";
    public static final String ZTYLIVINGNEEDSTKYKARIHYJ = "ztylivingneedstkykarihyj";
    public static final String ZTYKYKSYHHKNSYDOUITUHYOUJI = "ztykyksyhhknsydouituhyouji";
    public static final String ZTYHAITOUSIHARAIKBN      = "ztyhaitousiharaikbn";
    public static final String ZTYDAIRITENATKIKEITAIKBN = "ztydairitenatkikeitaikbn";
    public static final String ZTYDRTENEGSYOKUINATKIWARI = "ztydrtenegsyokuinatkiwari";
    public static final String ZTYKJSAKISOSIKISETTEIHYJ = "ztykjsakisosikisetteihyj";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYSIMETYOKUZENBOSYUUHYJ = "ztysimetyokuzenbosyuuhyj";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYMOSNYUURYOKUYMD       = "ztymosnyuuryokuymd";
    public static final String ZTYHHKNSAKUINMEINO       = "ztyhhknsakuinmeino";
    public static final String ZTYTOKUSYUJIMUTORIATUKAIKBN = "ztytokusyujimutoriatukaikbn";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYNSTKARIHYJ            = "ztynstkarihyj";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYNENKANSANP            = "ztynenkansanp";
    public static final String ZTYKYKSYASKINMEINO       = "ztykyksyaskinmeino";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYJISSYUUP              = "ztyjissyuup";
    public static final String ZTYSEKININKAISIYMD       = "ztysekininkaisiymd";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYSYOKAIPRYOSYUYMD      = "ztysyokaipryosyuymd";
    public static final String ZTYSEIRITUYMD            = "ztyseirituymd";
    public static final String ZTYBOSDAIRITENTSRATKIWARI = "ztybosdairitentsratkiwari";
    public static final String ZTYBOSYUUNINCD           = "ztybosyuunincd";
    public static final String ZTYDRTENTSRYHUSHRKYKHYOUJI = "ztydrtentsryhushrkykhyouji";
    public static final String ZTYMDHNAISYOUMEIKBN      = "ztymdhnaisyoumeikbn";
    public static final String ZTYDAIRITENKYKKANRINO    = "ztydairitenkykkanrino";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYHENSYUUYOUKYKSYASEIKBN = "ztyhensyuuyoukyksyaseikbn";
    public static final String ZTYHENSYUUYOUKYKSYASEIYMD = "ztyhensyuuyoukyksyaseiymd";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYNKSYURUIKBN1          = "ztynksyuruikbn1";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYMOSSYOSAKUSEIYMD      = "ztymossyosakuseiymd";
    public static final String ZTYITIJIBARAIPKYKTUUKA   = "ztyitijibaraipkyktuuka";
    public static final String ZTYKAWASERATEN5          = "ztykawaseraten5";
    public static final String ZTYHRKTUUKAKBN           = "ztyhrktuukakbn";
    public static final String ZTYSITEITUUKAKBN         = "ztysiteituukakbn";
    public static final String ZTYSYKSBSITIHSYUTKYKARIHYJ = "ztysyksbsitihsyutkykarihyj";
    public static final String ZTYSKKAIGOMAEHRTKYKARIHYJ = "ztyskkaigomaehrtkykarihyj";
    public static final String ZTYKIHONSKYKTUUKA        = "ztykihonskyktuuka";
    public static final String ZTYZENKIZENNOUHYOUJI     = "ztyzenkizennouhyouji";
    public static final String ZTYNNKNSNPSSYSYUP        = "ztynnknsnpssysyup";
    public static final String ZTYNKNSNPSSYHRKKSKBN     = "ztynknsnpssyhrkkskbn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYKZKTRKSERVICEARIHYJ   = "ztykzktrkservicearihyj";
    public static final String ZTYYOBIV250X1            = "ztyyobiv250x1";
    public static final String ZTYYOBIV250X2            = "ztyyobiv250x2";
    public static final String ZTYYOBIV250X3            = "ztyyobiv250x3";
    public static final String ZTYYOBIV250X4            = "ztyyobiv250x4";
    public static final String ZTYYOBIV250X5            = "ztyyobiv250x5";
    public static final String ZTYYOBIV118              = "ztyyobiv118";

    private final PKZT_EgsyokuinSysRendouTy primaryKey;

    public GenZT_EgsyokuinSysRendouTy() {
        primaryKey = new PKZT_EgsyokuinSysRendouTy();
    }

    public GenZT_EgsyokuinSysRendouTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_EgsyokuinSysRendouTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_EgsyokuinSysRendouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_EgsyokuinSysRendouTy> getMetaClass() {
        return QZT_EgsyokuinSysRendouTy.class;
    }

    @Id
    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztyatukaikojincd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYATUKAIKOJINCD)
    public String getZtyatukaikojincd() {
        return ztyatukaikojincd;
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        ztyatukaikojincd = pZtyatukaikojincd;
    }

    private String ztysyono;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztykykymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private Long ztykihons;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztyharaikomip;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztygyousekiyouhosyous;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYGYOUSEKIYOUHOSYOUS)
    public Long getZtygyousekiyouhosyous() {
        return ztygyousekiyouhosyous;
    }

    public void setZtygyousekiyouhosyous(Long pZtygyousekiyouhosyous) {
        ztygyousekiyouhosyous = pZtygyousekiyouhosyous;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztybsyym;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztyatukaisosikicd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYATUKAISOSIKICD)
    public String getZtyatukaisosikicd() {
        return ztyatukaisosikicd;
    }

    public void setZtyatukaisosikicd(String pZtyatukaisosikicd) {
        ztyatukaisosikicd = pZtyatukaisosikicd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztyhensyuukeiyakusyamei;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHENSYUUKEIYAKUSYAMEI)
    public String getZtyhensyuukeiyakusyamei() {
        return ztyhensyuukeiyakusyamei;
    }

    public void setZtyhensyuukeiyakusyamei(String pZtyhensyuukeiyakusyamei) {
        ztyhensyuukeiyakusyamei = pZtyhensyuukeiyakusyamei;
    }

    private String ztyhnsyuknjkyksynm;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHNSYUKNJKYKSYNM)
    public String getZtyhnsyuknjkyksynm() {
        return ztyhnsyuknjkyksynm;
    }

    public void setZtyhnsyuknjkyksynm(String pZtyhnsyuknjkyksynm) {
        ztyhnsyuknjkyksynm = pZtyhnsyuknjkyksynm;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztykurikosihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKURIKOSIHYJ)
    public String getZtykurikosihyj() {
        return ztykurikosihyj;
    }

    public void setZtykurikosihyj(String pZtykurikosihyj) {
        ztykurikosihyj = pZtykurikosihyj;
    }

    private String ztylivingneedstkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYLIVINGNEEDSTKYKARIHYJ)
    public String getZtylivingneedstkykarihyj() {
        return ztylivingneedstkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedstkykarihyj(String pZtylivingneedstkykarihyj) {
        ztylivingneedstkykarihyj = pZtylivingneedstkykarihyj;
    }

    private String ztykyksyhhknsydouituhyouji;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKYKSYHHKNSYDOUITUHYOUJI)
    public String getZtykyksyhhknsydouituhyouji() {
        return ztykyksyhhknsydouituhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyhhknsydouituhyouji(String pZtykyksyhhknsydouituhyouji) {
        ztykyksyhhknsydouituhyouji = pZtykyksyhhknsydouituhyouji;
    }

    private String ztyhaitousiharaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHAITOUSIHARAIKBN)
    public String getZtyhaitousiharaikbn() {
        return ztyhaitousiharaikbn;
    }

    public void setZtyhaitousiharaikbn(String pZtyhaitousiharaikbn) {
        ztyhaitousiharaikbn = pZtyhaitousiharaikbn;
    }

    private String ztydairitenatkikeitaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYDAIRITENATKIKEITAIKBN)
    public String getZtydairitenatkikeitaikbn() {
        return ztydairitenatkikeitaikbn;
    }

    public void setZtydairitenatkikeitaikbn(String pZtydairitenatkikeitaikbn) {
        ztydairitenatkikeitaikbn = pZtydairitenatkikeitaikbn;
    }

    private Integer ztydrtenegsyokuinatkiwari;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYDRTENEGSYOKUINATKIWARI)
    public Integer getZtydrtenegsyokuinatkiwari() {
        return ztydrtenegsyokuinatkiwari;
    }

    public void setZtydrtenegsyokuinatkiwari(Integer pZtydrtenegsyokuinatkiwari) {
        ztydrtenegsyokuinatkiwari = pZtydrtenegsyokuinatkiwari;
    }

    private String ztykjsakisosikisetteihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKJSAKISOSIKISETTEIHYJ)
    public String getZtykjsakisosikisetteihyj() {
        return ztykjsakisosikisetteihyj;
    }

    public void setZtykjsakisosikisetteihyj(String pZtykjsakisosikisetteihyj) {
        ztykjsakisosikisetteihyj = pZtykjsakisosikisetteihyj;
    }

    private String ztybsydrtencd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }

    private String ztysimetyokuzenbosyuuhyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSIMETYOKUZENBOSYUUHYJ)
    public String getZtysimetyokuzenbosyuuhyj() {
        return ztysimetyokuzenbosyuuhyj;
    }

    public void setZtysimetyokuzenbosyuuhyj(String pZtysimetyokuzenbosyuuhyj) {
        ztysimetyokuzenbosyuuhyj = pZtysimetyokuzenbosyuuhyj;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztymosnyuuryokuymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYMOSNYUURYOKUYMD)
    public String getZtymosnyuuryokuymd() {
        return ztymosnyuuryokuymd;
    }

    public void setZtymosnyuuryokuymd(String pZtymosnyuuryokuymd) {
        ztymosnyuuryokuymd = pZtymosnyuuryokuymd;
    }

    private String ztyhhknsakuinmeino;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHHKNSAKUINMEINO)
    public String getZtyhhknsakuinmeino() {
        return ztyhhknsakuinmeino;
    }

    public void setZtyhhknsakuinmeino(String pZtyhhknsakuinmeino) {
        ztyhhknsakuinmeino = pZtyhhknsakuinmeino;
    }

    private String ztytokusyujimutoriatukaikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYTOKUSYUJIMUTORIATUKAIKBN)
    public String getZtytokusyujimutoriatukaikbn() {
        return ztytokusyujimutoriatukaikbn;
    }

    public void setZtytokusyujimutoriatukaikbn(String pZtytokusyujimutoriatukaikbn) {
        ztytokusyujimutoriatukaikbn = pZtytokusyujimutoriatukaikbn;
    }

    private String ztycifcd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztynstkarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYNSTKARIHYJ)
    public String getZtynstkarihyj() {
        return ztynstkarihyj;
    }

    public void setZtynstkarihyj(String pZtynstkarihyj) {
        ztynstkarihyj = pZtynstkarihyj;
    }

    private String ztymosno;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYMOSNO)
    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private Long ztynenkansanp;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYNENKANSANP)
    public Long getZtynenkansanp() {
        return ztynenkansanp;
    }

    public void setZtynenkansanp(Long pZtynenkansanp) {
        ztynenkansanp = pZtynenkansanp;
    }

    private String ztykyksyaskinmeino;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKYKSYASKINMEINO)
    public String getZtykyksyaskinmeino() {
        return ztykyksyaskinmeino;
    }

    public void setZtykyksyaskinmeino(String pZtykyksyaskinmeino) {
        ztykyksyaskinmeino = pZtykyksyaskinmeino;
    }

    private Long ztysibous;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztyjissyuup;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYJISSYUUP)
    public Long getZtyjissyuup() {
        return ztyjissyuup;
    }

    public void setZtyjissyuup(Long pZtyjissyuup) {
        ztyjissyuup = pZtyjissyuup;
    }

    private String ztysekininkaisiymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSEKININKAISIYMD)
    public String getZtysekininkaisiymd() {
        return ztysekininkaisiymd;
    }

    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        ztysekininkaisiymd = pZtysekininkaisiymd;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztysyokaipryosyuymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSYOKAIPRYOSYUYMD)
    public String getZtysyokaipryosyuymd() {
        return ztysyokaipryosyuymd;
    }

    public void setZtysyokaipryosyuymd(String pZtysyokaipryosyuymd) {
        ztysyokaipryosyuymd = pZtysyokaipryosyuymd;
    }

    private String ztyseirituymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSEIRITUYMD)
    public String getZtyseirituymd() {
        return ztyseirituymd;
    }

    public void setZtyseirituymd(String pZtyseirituymd) {
        ztyseirituymd = pZtyseirituymd;
    }

    private Integer ztybosdairitentsratkiwari;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYBOSDAIRITENTSRATKIWARI)
    public Integer getZtybosdairitentsratkiwari() {
        return ztybosdairitentsratkiwari;
    }

    public void setZtybosdairitentsratkiwari(Integer pZtybosdairitentsratkiwari) {
        ztybosdairitentsratkiwari = pZtybosdairitentsratkiwari;
    }

    private String ztybosyuunincd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYBOSYUUNINCD)
    public String getZtybosyuunincd() {
        return ztybosyuunincd;
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        ztybosyuunincd = pZtybosyuunincd;
    }

    private String ztydrtentsryhushrkykhyouji;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYDRTENTSRYHUSHRKYKHYOUJI)
    public String getZtydrtentsryhushrkykhyouji() {
        return ztydrtentsryhushrkykhyouji;
    }

    public void setZtydrtentsryhushrkykhyouji(String pZtydrtentsryhushrkykhyouji) {
        ztydrtentsryhushrkykhyouji = pZtydrtentsryhushrkykhyouji;
    }

    private String ztymdhnaisyoumeikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYMDHNAISYOUMEIKBN)
    public String getZtymdhnaisyoumeikbn() {
        return ztymdhnaisyoumeikbn;
    }

    public void setZtymdhnaisyoumeikbn(String pZtymdhnaisyoumeikbn) {
        ztymdhnaisyoumeikbn = pZtymdhnaisyoumeikbn;
    }

    private String ztydairitenkykkanrino;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYDAIRITENKYKKANRINO)
    public String getZtydairitenkykkanrino() {
        return ztydairitenkykkanrino;
    }

    public void setZtydairitenkykkanrino(String pZtydairitenkykkanrino) {
        ztydairitenkykkanrino = pZtydairitenkykkanrino;
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    private String ztytsintelno;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztyhensyuuyoukyksyaseikbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHENSYUUYOUKYKSYASEIKBN)
    public String getZtyhensyuuyoukyksyaseikbn() {
        return ztyhensyuuyoukyksyaseikbn;
    }

    public void setZtyhensyuuyoukyksyaseikbn(String pZtyhensyuuyoukyksyaseikbn) {
        ztyhensyuuyoukyksyaseikbn = pZtyhensyuuyoukyksyaseikbn;
    }

    private String ztyhensyuuyoukyksyaseiymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHENSYUUYOUKYKSYASEIYMD)
    public String getZtyhensyuuyoukyksyaseiymd() {
        return ztyhensyuuyoukyksyaseiymd;
    }

    public void setZtyhensyuuyoukyksyaseiymd(String pZtyhensyuuyoukyksyaseiymd) {
        ztyhensyuuyoukyksyaseiymd = pZtyhensyuuyoukyksyaseiymd;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztynksyuruikbn1;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYNKSYURUIKBN1)
    public String getZtynksyuruikbn1() {
        return ztynksyuruikbn1;
    }

    public void setZtynksyuruikbn1(String pZtynksyuruikbn1) {
        ztynksyuruikbn1 = pZtynksyuruikbn1;
    }

    private String ztymusymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztymossyosakuseiymd;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYMOSSYOSAKUSEIYMD)
    public String getZtymossyosakuseiymd() {
        return ztymossyosakuseiymd;
    }

    public void setZtymossyosakuseiymd(String pZtymossyosakuseiymd) {
        ztymossyosakuseiymd = pZtymossyosakuseiymd;
    }

    private BizNumber ztyitijibaraipkyktuuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYITIJIBARAIPKYKTUUKA)
    public BizNumber getZtyitijibaraipkyktuuka() {
        return ztyitijibaraipkyktuuka;
    }

    public void setZtyitijibaraipkyktuuka(BizNumber pZtyitijibaraipkyktuuka) {
        ztyitijibaraipkyktuuka = pZtyitijibaraipkyktuuka;
    }

    private BizNumber ztykawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKAWASERATEN5)
    public BizNumber getZtykawaseraten5() {
        return ztykawaseraten5;
    }

    public void setZtykawaseraten5(BizNumber pZtykawaseraten5) {
        ztykawaseraten5 = pZtykawaseraten5;
    }

    private String ztyhrktuukakbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYHRKTUUKAKBN)
    public String getZtyhrktuukakbn() {
        return ztyhrktuukakbn;
    }

    public void setZtyhrktuukakbn(String pZtyhrktuukakbn) {
        ztyhrktuukakbn = pZtyhrktuukakbn;
    }

    private String ztysiteituukakbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSITEITUUKAKBN)
    public String getZtysiteituukakbn() {
        return ztysiteituukakbn;
    }

    public void setZtysiteituukakbn(String pZtysiteituukakbn) {
        ztysiteituukakbn = pZtysiteituukakbn;
    }

    private String ztysyksbsitihsyutkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSYKSBSITIHSYUTKYKARIHYJ)
    public String getZtysyksbsitihsyutkykarihyj() {
        return ztysyksbsitihsyutkykarihyj;
    }

    public void setZtysyksbsitihsyutkykarihyj(String pZtysyksbsitihsyutkykarihyj) {
        ztysyksbsitihsyutkykarihyj = pZtysyksbsitihsyutkykarihyj;
    }

    private String ztyskkaigomaehrtkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYSKKAIGOMAEHRTKYKARIHYJ)
    public String getZtyskkaigomaehrtkykarihyj() {
        return ztyskkaigomaehrtkykarihyj;
    }

    public void setZtyskkaigomaehrtkykarihyj(String pZtyskkaigomaehrtkykarihyj) {
        ztyskkaigomaehrtkykarihyj = pZtyskkaigomaehrtkykarihyj;
    }

    private Long ztykihonskyktuuka;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKIHONSKYKTUUKA)
    public Long getZtykihonskyktuuka() {
        return ztykihonskyktuuka;
    }

    public void setZtykihonskyktuuka(Long pZtykihonskyktuuka) {
        ztykihonskyktuuka = pZtykihonskyktuuka;
    }

    private String ztyzenkizennouhyouji;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYZENKIZENNOUHYOUJI)
    public String getZtyzenkizennouhyouji() {
        return ztyzenkizennouhyouji;
    }

    public void setZtyzenkizennouhyouji(String pZtyzenkizennouhyouji) {
        ztyzenkizennouhyouji = pZtyzenkizennouhyouji;
    }

    private Long ztynnknsnpssysyup;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYNNKNSNPSSYSYUP)
    public Long getZtynnknsnpssysyup() {
        return ztynnknsnpssysyup;
    }

    public void setZtynnknsnpssysyup(Long pZtynnknsnpssysyup) {
        ztynnknsnpssysyup = pZtynnknsnpssysyup;
    }

    private String ztynknsnpssyhrkkskbn;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYNKNSNPSSYHRKKSKBN)
    public String getZtynknsnpssyhrkkskbn() {
        return ztynknsnpssyhrkkskbn;
    }

    public void setZtynknsnpssyhrkkskbn(String pZtynknsnpssyhrkkskbn) {
        ztynknsnpssyhrkkskbn = pZtynknsnpssyhrkkskbn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztykzktrkservicearihyj;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYKZKTRKSERVICEARIHYJ)
    public String getZtykzktrkservicearihyj() {
        return ztykzktrkservicearihyj;
    }

    public void setZtykzktrkservicearihyj(String pZtykzktrkservicearihyj) {
        ztykzktrkservicearihyj = pZtykzktrkservicearihyj;
    }

    private String ztyyobiv250x1;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYYOBIV250X1)
    public String getZtyyobiv250x1() {
        return ztyyobiv250x1;
    }

    public void setZtyyobiv250x1(String pZtyyobiv250x1) {
        ztyyobiv250x1 = pZtyyobiv250x1;
    }

    private String ztyyobiv250x2;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYYOBIV250X2)
    public String getZtyyobiv250x2() {
        return ztyyobiv250x2;
    }

    public void setZtyyobiv250x2(String pZtyyobiv250x2) {
        ztyyobiv250x2 = pZtyyobiv250x2;
    }

    private String ztyyobiv250x3;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYYOBIV250X3)
    public String getZtyyobiv250x3() {
        return ztyyobiv250x3;
    }

    public void setZtyyobiv250x3(String pZtyyobiv250x3) {
        ztyyobiv250x3 = pZtyyobiv250x3;
    }

    private String ztyyobiv250x4;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYYOBIV250X4)
    public String getZtyyobiv250x4() {
        return ztyyobiv250x4;
    }

    public void setZtyyobiv250x4(String pZtyyobiv250x4) {
        ztyyobiv250x4 = pZtyyobiv250x4;
    }

    private String ztyyobiv250x5;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYYOBIV250X5)
    public String getZtyyobiv250x5() {
        return ztyyobiv250x5;
    }

    public void setZtyyobiv250x5(String pZtyyobiv250x5) {
        ztyyobiv250x5 = pZtyyobiv250x5;
    }

    private String ztyyobiv118;

    @Column(name=GenZT_EgsyokuinSysRendouTy.ZTYYOBIV118)
    public String getZtyyobiv118() {
        return ztyyobiv118;
    }

    public void setZtyyobiv118(String pZtyyobiv118) {
        ztyyobiv118 = pZtyyobiv118;
    }
}