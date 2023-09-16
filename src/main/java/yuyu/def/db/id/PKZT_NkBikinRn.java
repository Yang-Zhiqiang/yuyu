package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkBikinRn;
import yuyu.def.db.mapping.GenZT_NkBikinRn;
import yuyu.def.db.meta.GenQZT_NkBikinRn;
import yuyu.def.db.meta.QZT_NkBikinRn;

/**
 * 年金備金テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkBikinRn}</td><td colspan="3">年金備金テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnidouymd</td><td>（連携用）異動日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouin</td><td>（連携用）消因</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn</td><td>（連携用）年金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkbn</td><td>（連携用）年金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsyu</td><td>（連携用）年金種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisikbn</td><td>（連携用）年金開始区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuymd</td><td>（連携用）契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokainenkinsiharaiymd</td><td>（連携用）初回年金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknshry</td><td>（連携用）年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinhosyoukikan</td><td>（連携用）年金保証期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhnnkgk</td><td>（連携用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsaisyuukousinymd</td><td>（連携用）最終更新日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisyuukousinsyoricd</td><td>（連携用）最終更新処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkihonctr</td><td>（連携用）年金基本ＣＴＲ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrncurrentday</td><td>（連携用）現在日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncurrenttime</td><td>（連携用）現在時刻</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkessanjibikinkbn</td><td>（連携用）決算時備金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyoumetucd</td><td>（連携用）年金消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyoumetuymd</td><td>（連携用）年金消滅日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouryokuhasseiymd</td><td>（連携用）効力発生日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkingakuzoukanaiyoukbn</td><td>（連携用）金額増加内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmotokeiyakusyouhinkbn</td><td>（連携用）元契約商品区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkigousedaikbn</td><td>（連携用）年金記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrrthendounkyoteirrt</td><td>（連携用）利率変動年金予定利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrrthendounksitihsyurrt</td><td>（連携用）利率変動年金最低保証利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhenkoumaekihonnenkingaku</td><td>（連携用）変更前基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyokainenkingaku</td><td>（連携用）初回年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyokaisiharaijitokubetud</td><td>（連携用）初回支払時特別Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyokaisiharaijikaimasis</td><td>（連携用）初回支払時買増Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyokaisiharaijisonotad</td><td>（連携用）初回支払時その他Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyokaisiharaijimisyuup</td><td>（連携用）初回支払時未収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnidounenkinnengaku</td><td>（連携用）異動年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsetteijikikinsougaku</td><td>（連携用）設定時基金総額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntenkanitijibarainkgk</td><td>（連携用）転換一時払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkasannkgk</td><td>（連携用）加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnuwanosenenkingaku</td><td>（連携用）上乗せ年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakunenkingaku</td><td>（連携用）主契約年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntokuyakuarihyouji</td><td>（連携用）特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsiharainaiyoukbn</td><td>（連携用）年金支払内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijikinsiharaiymd</td><td>（連携用）一時金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkknsetymd</td><td>（連携用）基金設定日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigoyoteiriritukbn</td><td>（連携用）年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksgoyoteisibouritukbn</td><td>（連携用）年金開始後予定死亡率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinjimutesuuryoukbn</td><td>（連携用）年金事務手数料区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteizouritu</td><td>（連携用）逓増率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnmaeatuatoatukbn</td><td>（連携用）前厚後厚区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokusyunenkinnaiyoukbn</td><td>（連携用）特殊年金内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiharaikaisuukbn</td><td>（連携用）支払回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkgyunkyusykishrtukisuu</td><td>（連携用）企業年金用初回支払月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteizounksiboujihknnendo</td><td>（連携用）逓増年金死亡時保険年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndkigetu</td><td>（連携用）Ｄ期月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntounendod</td><td>（連携用）当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkinyousiharaid</td><td>（連携用）年金用支払Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiharainenkingaku</td><td>（連携用）支払年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiharaisyoruiuketukeymd</td><td>（連携用）支払書類受付日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiharaiuketukebasyo</td><td>（連携用）支払受付場所</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnshiharaihasseiymd zrnshiharaihasseiymd}</td><td>（連携用）支払発生日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjihihokensyaage</td><td>（連携用）年金開始時被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyasibouymd</td><td>（連携用）被保険者死亡日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyaseibetukbn</td><td>（連携用）第２被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksjidai2hhknsyaage</td><td>（連携用）年金開始時第２被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyasibouymd</td><td>（連携用）第２被保険者死亡年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hihokensyaseiymd</td><td>（連携用）第２被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhhknnentysihyj</td><td>（連携用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnentysihyj</td><td>（連携用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkhknhoutekiyouhyj</td><td>（連携用）年金保険法適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x2</td><td>（連携用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukeitaikbn</td><td>（連携用）募集形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv4</td><td>（連携用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuusinsakiyuubinno</td><td>（連携用）通信先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuusinsakitikucd</td><td>（連携用）通信先地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv1x3</td><td>（連携用）予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x4</td><td>（連携用）予備項目Ｖ１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x3</td><td>（連携用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x4</td><td>（連携用）予備項目Ｖ８＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv59</td><td>（連携用）予備項目Ｖ５９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x1</td><td>（連携用）年金種類記号予備１＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x2</td><td>（連携用）年金種類記号予備１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x3</td><td>（連携用）年金種類記号予備１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x4</td><td>（連携用）年金種類記号予備１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x5</td><td>（連携用）年金種類記号予備１＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x6</td><td>（連携用）年金種類記号予備１＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x7</td><td>（連携用）年金種類記号予備１＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x8</td><td>（連携用）年金種類記号予備１＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x9</td><td>（連携用）年金種類記号予備１＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x10</td><td>（連携用）年金種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x11</td><td>（連携用）年金種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x12</td><td>（連携用）年金種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x13</td><td>（連携用）年金種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x14</td><td>（連携用）年金種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi1x15</td><td>（連携用）年金種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x1</td><td>（連携用）年金種類記号予備２＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x2</td><td>（連携用）年金種類記号予備２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x3</td><td>（連携用）年金種類記号予備２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x4</td><td>（連携用）年金種類記号予備２＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x5</td><td>（連携用）年金種類記号予備２＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x6</td><td>（連携用）年金種類記号予備２＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x7</td><td>（連携用）年金種類記号予備２＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x8</td><td>（連携用）年金種類記号予備２＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x9</td><td>（連携用）年金種類記号予備２＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi2x10</td><td>（連携用）年金種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x1</td><td>（連携用）年金種類記号予備３＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x2</td><td>（連携用）年金種類記号予備３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x3</td><td>（連携用）年金種類記号予備３＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x4</td><td>（連携用）年金種類記号予備３＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x5</td><td>（連携用）年金種類記号予備３＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x6</td><td>（連携用）年金種類記号予備３＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x7</td><td>（連携用）年金種類記号予備３＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x8</td><td>（連携用）年金種類記号予備３＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x9</td><td>（連携用）年金種類記号予備３＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikguyobi3x10</td><td>（連携用）年金種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeisyuuseisyorikbn</td><td>（連携用）統計修正処理区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeimodkurykhssiymd</td><td>（連携用）統計修正効力発生日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeimoddenpyouymd</td><td>（連携用）統計修正伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeimodbikinmodkbn</td><td>（連携用）統計修正備金修正区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeimodbikinshrymd</td><td>（連携用）統計修正備金支払日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeimodbikinkijyugk</td><td>（連携用）統計修正備金計上額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbikinnaiyoukbn</td><td>（連携用）備金内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikinkeiyakujyoukyoukbn</td><td>（連携用）備金契約状況区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaimasinenkinarihyouji</td><td>（連携用）買増年金有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmaeatuatoatusegarihyj</td><td>（連携用）前厚後厚ＳＥＧ有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzaikeiyuatatkimsnkarihyj</td><td>（連携用）財形用後厚買増年金有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouhyousakuseitanikbn</td><td>（連携用）帳票作成単位区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrnkgknaiyoukbn</td><td>（連携用）支払年金額内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnutikaimasinenkingaku</td><td>（連携用）内買増年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnpitijibaraikbn</td><td>（連携用）Ｐ一時払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoukigsyayotisbourtkbn</td><td>（連携用）要介護者予定死亡率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyukigsyayoteihasseirtkbn</td><td>（連携用）要介護者予定発生率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyukigsyayoteisytgnrtkbn</td><td>（連携用）要介護者予定出現率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkBikinRn
 * @see     GenZT_NkBikinRn
 * @see     QZT_NkBikinRn
 * @see     GenQZT_NkBikinRn
 */
public class PKZT_NkBikinRn extends AbstractExDBPrimaryKey<ZT_NkBikinRn, PKZT_NkBikinRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkBikinRn() {
    }

    public PKZT_NkBikinRn(String pZrnnksyousyono, String pZrnshiharaihasseiymd) {
        zrnnksyousyono = pZrnnksyousyono;
        zrnshiharaihasseiymd = pZrnshiharaihasseiymd;
    }

    @Transient
    @Override
    public Class<ZT_NkBikinRn> getEntityClass() {
        return ZT_NkBikinRn.class;
    }

    private String zrnnksyousyono;

    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }
    private String zrnshiharaihasseiymd;

    public String getZrnshiharaihasseiymd() {
        return zrnshiharaihasseiymd;
    }

    public void setZrnshiharaihasseiymd(String pZrnshiharaihasseiymd) {
        zrnshiharaihasseiymd = pZrnshiharaihasseiymd;
    }

}