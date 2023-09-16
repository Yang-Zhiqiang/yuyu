package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkToukeiRigTy;
import yuyu.def.db.mapping.GenZT_NkToukeiRigTy;
import yuyu.def.db.meta.GenQZT_NkToukeiRigTy;
import yuyu.def.db.meta.QZT_NkToukeiRigTy;

/**
 * 年金統計Ｆ例月用テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkToukeiRigTy}</td><td colspan="3">年金統計Ｆ例月用テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysystemcd</td><td>（中継用）システムコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyulfkbn</td><td>（中継用）ＵＬＦ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkihonkbn</td><td>（中継用）レコード基本区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyousyono</td><td>（中継用）年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkbn</td><td>（中継用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyidouymd</td><td>（中継用）異動日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouin</td><td>（中継用）消因</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn</td><td>（中継用）年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkbn</td><td>（中継用）年金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsyu</td><td>（中継用）年金種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkaisikbn</td><td>（中継用）年金開始区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokainenkinsiharaiymd</td><td>（中継用）初回年金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshry</td><td>（中継用）年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinhosyoukikan</td><td>（中継用）年金保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhnnkgk</td><td>（中継用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysaisyuukousinymd</td><td>（中継用）最終更新日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaisyuukousinsyoricd</td><td>（中継用）最終更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkihonctr</td><td>（中継用）年金基本ＣＴＲ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztycurrentday</td><td>（中継用）現在日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycurrenttime</td><td>（中継用）現在時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykessanjibikinkbn</td><td>（中継用）決算時備金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyoumetucd</td><td>（中継用）年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyoumetuymd</td><td>（中継用）年金消滅日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouryokuhasseiymd</td><td>（中継用）効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykingakuzoukanaiyoukbn</td><td>（中継用）金額増加内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymotokeiyakusyouhinkbn</td><td>（中継用）元契約商品区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkigousedaikbn</td><td>（中継用）年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrrthendounkyoteirrt</td><td>（中継用）利率変動年金予定利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyrrthendounksitihsyurrt</td><td>（中継用）利率変動年金最低保証利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyhenkoumaekihonnenkingaku</td><td>（中継用）変更前基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyokainenkingaku</td><td>（中継用）初回年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyokaisiharaijitokubetud</td><td>（中継用）初回支払時特別Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyokaisiharaijikaimasis</td><td>（中継用）初回支払時買増Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyokaisiharaijisonotad</td><td>（中継用）初回支払時その他Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyokaisiharaijimisyuup</td><td>（中継用）初回支払時未収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyidounenkinnengaku</td><td>（中継用）異動年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysetteijikikinsougaku</td><td>（中継用）設定時基金総額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytenkanitijibarainkgk</td><td>（中継用）転換一時払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykasannkgk</td><td>（中継用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyuwanosenenkingaku</td><td>（中継用）上乗せ年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakunenkingaku</td><td>（中継用）主契約年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytokuyakuarihyouji</td><td>（中継用）特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsiharainaiyoukbn</td><td>（中継用）年金支払内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijikinsiharaiymd</td><td>（中継用）一時金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykknsetymd</td><td>（中継用）基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkaisigoyoteiriritukbn</td><td>（中継用）年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksgoyoteisibouritukbn</td><td>（中継用）年金開始後予定死亡率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinjimutesuuryoukbn</td><td>（中継用）年金事務手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteizouritu</td><td>（中継用）逓増率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztymaeatuatoatukbn</td><td>（中継用）前厚後厚区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokusyunenkinnaiyoukbn</td><td>（中継用）特殊年金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaikaisuukbn</td><td>（中継用）支払回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykgyunkyusykishrtukisuu</td><td>（中継用）企業年金用初回支払月数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteizounksiboujihknnendo</td><td>（中継用）逓増年金死亡時保険年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydkigetu</td><td>（中継用）Ｄ期月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytounendod</td><td>（中継用）当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkinyousiharaid</td><td>（中継用）年金用支払Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiharainenkingaku</td><td>（中継用）支払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiharaisyoruiuketukeymd</td><td>（中継用）支払書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaiuketukebasyo</td><td>（中継用）支払受付場所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshiharaihasseiymd</td><td>（中継用）支払発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksjihihokensyaage</td><td>（中継用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyasibouymd</td><td>（中継用）被保険者死亡日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyaseibetukbn</td><td>（中継用）第２被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksjidai2hhknsyaage</td><td>（中継用）年金開始時第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyasibouymd</td><td>（中継用）第２被保険者死亡年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyaseiymd</td><td>（中継用）第２被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnentysihyj</td><td>（中継用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkhknhoutekiyouhyj</td><td>（中継用）年金保険法適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1x2</td><td>（中継用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x2</td><td>（中継用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuusinsakiyuubinno</td><td>（中継用）通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuusinsakitikucd</td><td>（中継用）通信先地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x7</td><td>（中継用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv1x3</td><td>（中継用）予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1x4</td><td>（中継用）予備項目Ｖ１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x3</td><td>（中継用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x4</td><td>（中継用）予備項目Ｖ８＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv59</td><td>（中継用）予備項目Ｖ５９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x1</td><td>（中継用）年金種類記号予備１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x2</td><td>（中継用）年金種類記号予備１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x3</td><td>（中継用）年金種類記号予備１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x4</td><td>（中継用）年金種類記号予備１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x5</td><td>（中継用）年金種類記号予備１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x6</td><td>（中継用）年金種類記号予備１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x7</td><td>（中継用）年金種類記号予備１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x8</td><td>（中継用）年金種類記号予備１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x9</td><td>（中継用）年金種類記号予備１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x10</td><td>（中継用）年金種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x11</td><td>（中継用）年金種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x12</td><td>（中継用）年金種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x13</td><td>（中継用）年金種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x14</td><td>（中継用）年金種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi1x15</td><td>（中継用）年金種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x1</td><td>（中継用）年金種類記号予備２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x2</td><td>（中継用）年金種類記号予備２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x3</td><td>（中継用）年金種類記号予備２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x4</td><td>（中継用）年金種類記号予備２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x5</td><td>（中継用）年金種類記号予備２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x6</td><td>（中継用）年金種類記号予備２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x7</td><td>（中継用）年金種類記号予備２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x8</td><td>（中継用）年金種類記号予備２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x9</td><td>（中継用）年金種類記号予備２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi2x10</td><td>（中継用）年金種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x1</td><td>（中継用）年金種類記号予備３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x2</td><td>（中継用）年金種類記号予備３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x3</td><td>（中継用）年金種類記号予備３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x4</td><td>（中継用）年金種類記号予備３＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x5</td><td>（中継用）年金種類記号予備３＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x6</td><td>（中継用）年金種類記号予備３＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x7</td><td>（中継用）年金種類記号予備３＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x8</td><td>（中継用）年金種類記号予備３＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x9</td><td>（中継用）年金種類記号予備３＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikguyobi3x10</td><td>（中継用）年金種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeisyuuseisyorikbn</td><td>（中継用）統計修正処理区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeimodkurykhssiymd</td><td>（中継用）統計修正効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeimoddenpyouymd</td><td>（中継用）統計修正伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeimodbikinmodkbn</td><td>（中継用）統計修正備金修正区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeimodbikinshrymd</td><td>（中継用）統計修正備金支払日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeimodbikinkijyugk</td><td>（中継用）統計修正備金計上額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybikinnaiyoukbn</td><td>（中継用）備金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikinkeiyakujyoukyoukbn</td><td>（中継用）備金契約状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinarihyouji</td><td>（中継用）買増年金有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatusegarihyj</td><td>（中継用）前厚後厚ＳＥＧ有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzaikeiyuatatkimsnkarihyj</td><td>（中継用）財形用後厚買増年金有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyousakuseitanikbn</td><td>（中継用）帳票作成単位区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrnkgknaiyoukbn</td><td>（中継用）支払年金額内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyutikaimasinenkingaku</td><td>（中継用）内買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztypitijibaraikbn</td><td>（中継用）Ｐ一時払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoukigsyayotisbourtkbn</td><td>（中継用）要介護者予定死亡率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyukigsyayoteihasseirtkbn</td><td>（中継用）要介護者予定発生率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyukigsyayoteisytgnrtkbn</td><td>（中継用）要介護者予定出現率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv17</td><td>（中継用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkkouryokusymd</td><td>（中継用）買増年金効力開始日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinkbn</td><td>（中継用）買増年金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinsyuruikigou</td><td>（中継用）買増年金種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkshrkkn</td><td>（中継用）買増年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkinhosyoukikan</td><td>（中継用）買増年金保証期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkhhknsyaage</td><td>（中継用）買増年金被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykimsnkdai2hhknsyaage</td><td>（中継用）買増年金第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaisyuunenkinkaimasiymd</td><td>（中継用）最終年金買増日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinenkingaku</td><td>（中継用）買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennendokaimasinkgk</td><td>（中継用）前年度買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznznnndkaimasinkzougk</td><td>（中継用）前々年度買増年金増額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznznznnndkaimasinkgk</td><td>（中継用）前々々年度買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytounendokaimasinenkind</td><td>（中継用）当年度買増年金Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaimasityuusiymd</td><td>（中継用）買増中止日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasihukkiymd</td><td>（中継用）買増復帰日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaimasinkkigousdkbn</td><td>（中継用）買増年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatukouryokusymd</td><td>（中継用）前厚後厚効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatukikan</td><td>（中継用）前厚後厚期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaeatuatoatuhendougonkgk</td><td>（中継用）前厚後厚変動後年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyatoatusaisyuukaimasiymd</td><td>（中継用）後厚最終買増日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatoatukaimasinenkingaku</td><td>（中継用）後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznnndatoatukaimasinkgk</td><td>（中継用）前年度後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznznnndatoatukaimasinkgk</td><td>（中継用）前々年度後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyznznznnndatatkimsnkgk</td><td>（中継用）前々々年度後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytounendatoatukaimasinkd</td><td>（中継用）当年度後厚買増年金Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyuwanoseatoatukaimasinkgk</td><td>（中継用）上乗せ後厚買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_NkToukeiRigTy
 * @see     GenZT_NkToukeiRigTy
 * @see     QZT_NkToukeiRigTy
 * @see     GenQZT_NkToukeiRigTy
 */
public class PKZT_NkToukeiRigTy extends AbstractExDBPrimaryKey<ZT_NkToukeiRigTy, PKZT_NkToukeiRigTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkToukeiRigTy() {
    }

    public PKZT_NkToukeiRigTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_NkToukeiRigTy> getEntityClass() {
        return ZT_NkToukeiRigTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}