package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkToukeiRigRn;
import yuyu.def.db.id.PKZT_NkToukeiRigRn;
import yuyu.def.db.meta.GenQZT_NkToukeiRigRn;
import yuyu.def.db.meta.QZT_NkToukeiRigRn;

/**
 * 年金統計Ｆ例月用テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NkToukeiRigRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkToukeiRigRn}</td><td colspan="3">年金統計Ｆ例月用テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_NkToukeiRigRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsystemcd zrnsystemcd}</td><td>（連携用）システムコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnulfkbn zrnulfkbn}</td><td>（連携用）ＵＬＦ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkihonkbn zrnrecordkihonkbn}</td><td>（連携用）レコード基本区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidouymd zrnidouymd}</td><td>（連携用）異動日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouin zrnsyouin}</td><td>（連携用）消因</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn zrnnksyuruikbn}</td><td>（連携用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisikbn zrnnenkinkaisikbn}</td><td>（連携用）年金開始区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokainenkinsiharaiymd zrnsyokainenkinsiharaiymd}</td><td>（連携用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinhosyoukikan zrnnenkinhosyoukikan}</td><td>（連携用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhnnkgk zrnkhnnkgk}</td><td>（連携用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisyuukousinymd zrnsaisyuukousinymd}</td><td>（連携用）最終更新日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuukousinsyoricd zrnsaisyuukousinsyoricd}</td><td>（連携用）最終更新処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkihonctr zrnnenkinkihonctr}</td><td>（連携用）年金基本ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncurrentday zrncurrentday}</td><td>（連携用）現在日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncurrenttime zrncurrenttime}</td><td>（連携用）現在時刻</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessanjibikinkbn zrnkessanjibikinkbn}</td><td>（連携用）決算時備金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyoumetucd zrnnksyoumetucd}</td><td>（連携用）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyoumetuymd zrnnksyoumetuymd}</td><td>（連携用）年金消滅日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokuhasseiymd zrnkouryokuhasseiymd}</td><td>（連携用）効力発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingakuzoukanaiyoukbn zrnkingakuzoukanaiyoukbn}</td><td>（連携用）金額増加内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmotokeiyakusyouhinkbn zrnmotokeiyakusyouhinkbn}</td><td>（連携用）元契約商品区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrrthendounkyoteirrt zrnrrthendounkyoteirrt}</td><td>（連携用）利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrrthendounksitihsyurrt zrnrrthendounksitihsyurrt}</td><td>（連携用）利率変動年金最低保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhenkoumaekihonnenkingaku zrnhenkoumaekihonnenkingaku}</td><td>（連携用）変更前基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokainenkingaku zrnsyokainenkingaku}</td><td>（連携用）初回年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaisiharaijitokubetud zrnsyokaisiharaijitokubetud}</td><td>（連携用）初回支払時特別Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaisiharaijikaimasis zrnsyokaisiharaijikaimasis}</td><td>（連携用）初回支払時買増Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaisiharaijisonotad zrnsyokaisiharaijisonotad}</td><td>（連携用）初回支払時その他Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaisiharaijimisyuup zrnsyokaisiharaijimisyuup}</td><td>（連携用）初回支払時未収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnidounenkinnengaku zrnidounenkinnengaku}</td><td>（連携用）異動年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetteijikikinsougaku zrnsetteijikikinsougaku}</td><td>（連携用）設定時基金総額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanitijibarainkgk zrntenkanitijibarainkgk}</td><td>（連携用）転換一時払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkasannkgk zrnkasannkgk}</td><td>（連携用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnuwanosenenkingaku zrnuwanosenenkingaku}</td><td>（連携用）上乗せ年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakunenkingaku zrnsyukeiyakunenkingaku}</td><td>（連携用）主契約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokuyakuarihyouji zrntokuyakuarihyouji}</td><td>（連携用）特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsiharainaiyoukbn zrnnenkinsiharainaiyoukbn}</td><td>（連携用）年金支払内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijikinsiharaiymd zrnitijikinsiharaiymd}</td><td>（連携用）一時金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkknsetymd zrnkknsetymd}</td><td>（連携用）基金設定日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksgoyoteisibouritukbn zrnnksgoyoteisibouritukbn}</td><td>（連携用）年金開始後予定死亡率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinjimutesuuryoukbn zrnnenkinjimutesuuryoukbn}</td><td>（連携用）年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteizouritu zrnteizouritu}</td><td>（連携用）逓増率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatukbn zrnmaeatuatoatukbn}</td><td>（連携用）前厚後厚区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusyunenkinnaiyoukbn zrntokusyunenkinnaiyoukbn}</td><td>（連携用）特殊年金内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaikaisuukbn zrnsiharaikaisuukbn}</td><td>（連携用）支払回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgyunkyusykishrtukisuu zrnkgyunkyusykishrtukisuu}</td><td>（連携用）企業年金用初回支払月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteizounksiboujihknnendo zrnteizounksiboujihknnendo}</td><td>（連携用）逓増年金死亡時保険年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndkigetu zrndkigetu}</td><td>（連携用）Ｄ期月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntounendod zrntounendod}</td><td>（連携用）当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkinyousiharaid zrnnenkinyousiharaid}</td><td>（連携用）年金用支払Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiharainenkingaku zrnsiharainenkingaku}</td><td>（連携用）支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiharaisyoruiuketukeymd zrnsiharaisyoruiuketukeymd}</td><td>（連携用）支払書類受付日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaiuketukebasyo zrnsiharaiuketukebasyo}</td><td>（連携用）支払受付場所</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshiharaihasseiymd zrnshiharaihasseiymd}</td><td>（連携用）支払発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjihihokensyaage zrnnksjihihokensyaage}</td><td>（連携用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyasibouymd zrnhihokensyasibouymd}</td><td>（連携用）被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyaseibetukbn zrndai2hihokensyaseibetukbn}</td><td>（連携用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjidai2hhknsyaage zrnnksjidai2hhknsyaage}</td><td>（連携用）年金開始時第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyasibouymd zrndai2hihokensyasibouymd}</td><td>（連携用）第２被保険者死亡年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyaseiymd zrndai2hihokensyaseiymd}</td><td>（連携用）第２被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkhknhoutekiyouhyj zrnnkhknhoutekiyouhyj}</td><td>（連携用）年金保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusinsakiyuubinno zrntuusinsakiyuubinno}</td><td>（連携用）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusinsakitikucd zrntuusinsakitikucd}</td><td>（連携用）通信先地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x3 zrnyobiv1x3}</td><td>（連携用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x4 zrnyobiv1x4}</td><td>（連携用）予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x3 zrnyobiv8x3}</td><td>（連携用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x4 zrnyobiv8x4}</td><td>（連携用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv59 zrnyobiv59}</td><td>（連携用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x1 zrnnksyuruikguyobi1x1}</td><td>（連携用）年金種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x2 zrnnksyuruikguyobi1x2}</td><td>（連携用）年金種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x3 zrnnksyuruikguyobi1x3}</td><td>（連携用）年金種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x4 zrnnksyuruikguyobi1x4}</td><td>（連携用）年金種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x5 zrnnksyuruikguyobi1x5}</td><td>（連携用）年金種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x6 zrnnksyuruikguyobi1x6}</td><td>（連携用）年金種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x7 zrnnksyuruikguyobi1x7}</td><td>（連携用）年金種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x8 zrnnksyuruikguyobi1x8}</td><td>（連携用）年金種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x9 zrnnksyuruikguyobi1x9}</td><td>（連携用）年金種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x10 zrnnksyuruikguyobi1x10}</td><td>（連携用）年金種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x11 zrnnksyuruikguyobi1x11}</td><td>（連携用）年金種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x12 zrnnksyuruikguyobi1x12}</td><td>（連携用）年金種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x13 zrnnksyuruikguyobi1x13}</td><td>（連携用）年金種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x14 zrnnksyuruikguyobi1x14}</td><td>（連携用）年金種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi1x15 zrnnksyuruikguyobi1x15}</td><td>（連携用）年金種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x1 zrnnksyuruikguyobi2x1}</td><td>（連携用）年金種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x2 zrnnksyuruikguyobi2x2}</td><td>（連携用）年金種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x3 zrnnksyuruikguyobi2x3}</td><td>（連携用）年金種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x4 zrnnksyuruikguyobi2x4}</td><td>（連携用）年金種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x5 zrnnksyuruikguyobi2x5}</td><td>（連携用）年金種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x6 zrnnksyuruikguyobi2x6}</td><td>（連携用）年金種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x7 zrnnksyuruikguyobi2x7}</td><td>（連携用）年金種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x8 zrnnksyuruikguyobi2x8}</td><td>（連携用）年金種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x9 zrnnksyuruikguyobi2x9}</td><td>（連携用）年金種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi2x10 zrnnksyuruikguyobi2x10}</td><td>（連携用）年金種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x1 zrnnksyuruikguyobi3x1}</td><td>（連携用）年金種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x2 zrnnksyuruikguyobi3x2}</td><td>（連携用）年金種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x3 zrnnksyuruikguyobi3x3}</td><td>（連携用）年金種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x4 zrnnksyuruikguyobi3x4}</td><td>（連携用）年金種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x5 zrnnksyuruikguyobi3x5}</td><td>（連携用）年金種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x6 zrnnksyuruikguyobi3x6}</td><td>（連携用）年金種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x7 zrnnksyuruikguyobi3x7}</td><td>（連携用）年金種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x8 zrnnksyuruikguyobi3x8}</td><td>（連携用）年金種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x9 zrnnksyuruikguyobi3x9}</td><td>（連携用）年金種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikguyobi3x10 zrnnksyuruikguyobi3x10}</td><td>（連携用）年金種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeisyuuseisyorikbn zrntoukeisyuuseisyorikbn}</td><td>（連携用）統計修正処理区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeimodkurykhssiymd zrntoukeimodkurykhssiymd}</td><td>（連携用）統計修正効力発生日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeimoddenpyouymd zrntoukeimoddenpyouymd}</td><td>（連携用）統計修正伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeimodbikinmodkbn zrntoukeimodbikinmodkbn}</td><td>（連携用）統計修正備金修正区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeimodbikinshrymd zrntoukeimodbikinshrymd}</td><td>（連携用）統計修正備金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeimodbikinkijyugk zrntoukeimodbikinkijyugk}</td><td>（連携用）統計修正備金計上額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbikinnaiyoukbn zrnbikinnaiyoukbn}</td><td>（連携用）備金内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikinkeiyakujyoukyoukbn zrnbikinkeiyakujyoukyoukbn}</td><td>（連携用）備金契約状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinarihyouji zrnkaimasinenkinarihyouji}</td><td>（連携用）買増年金有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatusegarihyj zrnmaeatuatoatusegarihyj}</td><td>（連携用）前厚後厚ＳＥＧ有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzaikeiyuatatkimsnkarihyj zrnzaikeiyuatatkimsnkarihyj}</td><td>（連携用）財形用後厚買増年金有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyousakuseitanikbn zrntyouhyousakuseitanikbn}</td><td>（連携用）帳票作成単位区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrnkgknaiyoukbn zrnshrnkgknaiyoukbn}</td><td>（連携用）支払年金額内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnutikaimasinenkingaku zrnutikaimasinenkingaku}</td><td>（連携用）内買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnpitijibaraikbn zrnpitijibaraikbn}</td><td>（連携用）Ｐ一時払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukigsyayotisbourtkbn zrnyoukigsyayotisbourtkbn}</td><td>（連携用）要介護者予定死亡率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyukigsyayoteihasseirtkbn zrnyukigsyayoteihasseirtkbn}</td><td>（連携用）要介護者予定発生率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyukigsyayoteisytgnrtkbn zrnyukigsyayoteisytgnrtkbn}</td><td>（連携用）要介護者予定出現率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkkouryokusymd zrnkaimasinkkouryokusymd}</td><td>（連携用）買増年金効力開始日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinkbn zrnkaimasinenkinkbn}</td><td>（連携用）買増年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinsyuruikigou zrnkaimasinenkinsyuruikigou}</td><td>（連携用）買増年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkshrkkn zrnkaimasinkshrkkn}</td><td>（連携用）買増年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinhosyoukikan zrnkaimasinenkinhosyoukikan}</td><td>（連携用）買増年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkhhknsyaage zrnkaimasinkhhknsyaage}</td><td>（連携用）買増年金被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkimsnkdai2hhknsyaage zrnkimsnkdai2hhknsyaage}</td><td>（連携用）買増年金第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuunenkinkaimasiymd zrnsaisyuunenkinkaimasiymd}</td><td>（連携用）最終年金買増日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkingaku zrnkaimasinenkingaku}</td><td>（連携用）買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennendokaimasinkgk zrnzennendokaimasinkgk}</td><td>（連携用）前年度買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznznnndkaimasinkzougk zrnznznnndkaimasinkzougk}</td><td>（連携用）前々年度買増年金増額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznznznnndkaimasinkgk zrnznznznnndkaimasinkgk}</td><td>（連携用）前々々年度買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendokaimasinenkind zrntounendokaimasinenkind}</td><td>（連携用）当年度買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaimasityuusiymd zrnkaimasityuusiymd}</td><td>（連携用）買増中止日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasihukkiymd zrnkaimasihukkiymd}</td><td>（連携用）買増復帰日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkkigousdkbn zrnkaimasinkkigousdkbn}</td><td>（連携用）買増年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatukouryokusymd zrnmaeatuatoatukouryokusymd}</td><td>（連携用）前厚後厚効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatukikan zrnmaeatuatoatukikan}</td><td>（連携用）前厚後厚期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatuhendougonkgk zrnmaeatuatoatuhendougonkgk}</td><td>（連携用）前厚後厚変動後年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnatoatusaisyuukaimasiymd zrnatoatusaisyuukaimasiymd}</td><td>（連携用）後厚最終買増日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatoatukaimasinenkingaku zrnatoatukaimasinenkingaku}</td><td>（連携用）後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznnndatoatukaimasinkgk zrnznnndatoatukaimasinkgk}</td><td>（連携用）前年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznznnndatoatukaimasinkgk zrnznznnndatoatukaimasinkgk}</td><td>（連携用）前々年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznznznnndatatkimsnkgk zrnznznznnndatatkimsnkgk}</td><td>（連携用）前々々年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendatoatukaimasinkd zrntounendatoatukaimasinkd}</td><td>（連携用）当年度後厚買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnuwanoseatoatukaimasinkgk zrnuwanoseatoatukaimasinkgk}</td><td>（連携用）上乗せ後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_NkToukeiRigRn
 * @see     PKZT_NkToukeiRigRn
 * @see     QZT_NkToukeiRigRn
 * @see     GenQZT_NkToukeiRigRn
 */
@MappedSuperclass
@Table(name=GenZT_NkToukeiRigRn.TABLE_NAME)
@IdClass(value=PKZT_NkToukeiRigRn.class)
public abstract class GenZT_NkToukeiRigRn extends AbstractExDBEntityForZDB<ZT_NkToukeiRigRn, PKZT_NkToukeiRigRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkToukeiRigRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNSYSTEMCD              = "zrnsystemcd";
    public static final String ZRNULFKBN                = "zrnulfkbn";
    public static final String ZRNRECORDKIHONKBN        = "zrnrecordkihonkbn";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNNKSYOUSYONO           = "zrnnksyousyono";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNIDOUYMD               = "zrnidouymd";
    public static final String ZRNSYOUIN                = "zrnsyouin";
    public static final String ZRNNKSYURUIKBN           = "zrnnksyuruikbn";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNNENKINKAISIKBN        = "zrnnenkinkaisikbn";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNSYOKAINENKINSIHARAIYMD = "zrnsyokainenkinsiharaiymd";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNENKINHOSYOUKIKAN     = "zrnnenkinhosyoukikan";
    public static final String ZRNKHNNKGK               = "zrnkhnnkgk";
    public static final String ZRNSAISYUUKOUSINYMD      = "zrnsaisyuukousinymd";
    public static final String ZRNSAISYUUKOUSINSYORICD  = "zrnsaisyuukousinsyoricd";
    public static final String ZRNNENKINKIHONCTR        = "zrnnenkinkihonctr";
    public static final String ZRNCURRENTDAY            = "zrncurrentday";
    public static final String ZRNCURRENTTIME           = "zrncurrenttime";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNKESSANJIBIKINKBN      = "zrnkessanjibikinkbn";
    public static final String ZRNNKSYOUMETUCD          = "zrnnksyoumetucd";
    public static final String ZRNNKSYOUMETUYMD         = "zrnnksyoumetuymd";
    public static final String ZRNKOURYOKUHASSEIYMD     = "zrnkouryokuhasseiymd";
    public static final String ZRNKINGAKUZOUKANAIYOUKBN = "zrnkingakuzoukanaiyoukbn";
    public static final String ZRNMOTOKEIYAKUSYOUHINKBN = "zrnmotokeiyakusyouhinkbn";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNRRTHENDOUNKYOTEIRRT   = "zrnrrthendounkyoteirrt";
    public static final String ZRNRRTHENDOUNKSITIHSYURRT = "zrnrrthendounksitihsyurrt";
    public static final String ZRNHENKOUMAEKIHONNENKINGAKU = "zrnhenkoumaekihonnenkingaku";
    public static final String ZRNSYOKAINENKINGAKU      = "zrnsyokainenkingaku";
    public static final String ZRNSYOKAISIHARAIJITOKUBETUD = "zrnsyokaisiharaijitokubetud";
    public static final String ZRNSYOKAISIHARAIJIKAIMASIS = "zrnsyokaisiharaijikaimasis";
    public static final String ZRNSYOKAISIHARAIJISONOTAD = "zrnsyokaisiharaijisonotad";
    public static final String ZRNSYOKAISIHARAIJIMISYUUP = "zrnsyokaisiharaijimisyuup";
    public static final String ZRNIDOUNENKINNENGAKU     = "zrnidounenkinnengaku";
    public static final String ZRNSETTEIJIKIKINSOUGAKU  = "zrnsetteijikikinsougaku";
    public static final String ZRNTENKANITIJIBARAINKGK  = "zrntenkanitijibarainkgk";
    public static final String ZRNKASANNKGK             = "zrnkasannkgk";
    public static final String ZRNUWANOSENENKINGAKU     = "zrnuwanosenenkingaku";
    public static final String ZRNSYUKEIYAKUNENKINGAKU  = "zrnsyukeiyakunenkingaku";
    public static final String ZRNTOKUYAKUARIHYOUJI     = "zrntokuyakuarihyouji";
    public static final String ZRNNENKINSIHARAINAIYOUKBN = "zrnnenkinsiharainaiyoukbn";
    public static final String ZRNITIJIKINSIHARAIYMD    = "zrnitijikinsiharaiymd";
    public static final String ZRNKKNSETYMD             = "zrnkknsetymd";
    public static final String ZRNNKKAISIGOYOTEIRIRITUKBN = "zrnnkkaisigoyoteiriritukbn";
    public static final String ZRNNKSGOYOTEISIBOURITUKBN = "zrnnksgoyoteisibouritukbn";
    public static final String ZRNNENKINJIMUTESUURYOUKBN = "zrnnenkinjimutesuuryoukbn";
    public static final String ZRNTEIZOURITU            = "zrnteizouritu";
    public static final String ZRNMAEATUATOATUKBN       = "zrnmaeatuatoatukbn";
    public static final String ZRNTOKUSYUNENKINNAIYOUKBN = "zrntokusyunenkinnaiyoukbn";
    public static final String ZRNSIHARAIKAISUUKBN      = "zrnsiharaikaisuukbn";
    public static final String ZRNKGYUNKYUSYKISHRTUKISUU = "zrnkgyunkyusykishrtukisuu";
    public static final String ZRNTEIZOUNKSIBOUJIHKNNENDO = "zrnteizounksiboujihknnendo";
    public static final String ZRNDKIGETU               = "zrndkigetu";
    public static final String ZRNTOUNENDOD             = "zrntounendod";
    public static final String ZRNNENKINYOUSIHARAID     = "zrnnenkinyousiharaid";
    public static final String ZRNSIHARAINENKINGAKU     = "zrnsiharainenkingaku";
    public static final String ZRNSIHARAISYORUIUKETUKEYMD = "zrnsiharaisyoruiuketukeymd";
    public static final String ZRNSIHARAIUKETUKEBASYO   = "zrnsiharaiuketukebasyo";
    public static final String ZRNSHIHARAIHASSEIYMD     = "zrnshiharaihasseiymd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNNKSJIHIHOKENSYAAGE    = "zrnnksjihihokensyaage";
    public static final String ZRNHIHOKENSYASIBOUYMD    = "zrnhihokensyasibouymd";
    public static final String ZRNDAI2HIHOKENSYASEIBETUKBN = "zrndai2hihokensyaseibetukbn";
    public static final String ZRNNKSJIDAI2HHKNSYAAGE   = "zrnnksjidai2hhknsyaage";
    public static final String ZRNDAI2HIHOKENSYASIBOUYMD = "zrndai2hihokensyasibouymd";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNDAI2HIHOKENSYASEIYMD  = "zrndai2hihokensyaseiymd";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNNKHKNHOUTEKIYOUHYJ    = "zrnnkhknhoutekiyouhyj";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNTUUSINSAKIYUUBINNO    = "zrntuusinsakiyuubinno";
    public static final String ZRNTUUSINSAKITIKUCD      = "zrntuusinsakitikucd";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIV1X3              = "zrnyobiv1x3";
    public static final String ZRNYOBIV1X4              = "zrnyobiv1x4";
    public static final String ZRNYOBIV8X3              = "zrnyobiv8x3";
    public static final String ZRNYOBIV8X4              = "zrnyobiv8x4";
    public static final String ZRNYOBIV59               = "zrnyobiv59";
    public static final String ZRNNKSYURUIKGUYOBI1X1    = "zrnnksyuruikguyobi1x1";
    public static final String ZRNNKSYURUIKGUYOBI1X2    = "zrnnksyuruikguyobi1x2";
    public static final String ZRNNKSYURUIKGUYOBI1X3    = "zrnnksyuruikguyobi1x3";
    public static final String ZRNNKSYURUIKGUYOBI1X4    = "zrnnksyuruikguyobi1x4";
    public static final String ZRNNKSYURUIKGUYOBI1X5    = "zrnnksyuruikguyobi1x5";
    public static final String ZRNNKSYURUIKGUYOBI1X6    = "zrnnksyuruikguyobi1x6";
    public static final String ZRNNKSYURUIKGUYOBI1X7    = "zrnnksyuruikguyobi1x7";
    public static final String ZRNNKSYURUIKGUYOBI1X8    = "zrnnksyuruikguyobi1x8";
    public static final String ZRNNKSYURUIKGUYOBI1X9    = "zrnnksyuruikguyobi1x9";
    public static final String ZRNNKSYURUIKGUYOBI1X10   = "zrnnksyuruikguyobi1x10";
    public static final String ZRNNKSYURUIKGUYOBI1X11   = "zrnnksyuruikguyobi1x11";
    public static final String ZRNNKSYURUIKGUYOBI1X12   = "zrnnksyuruikguyobi1x12";
    public static final String ZRNNKSYURUIKGUYOBI1X13   = "zrnnksyuruikguyobi1x13";
    public static final String ZRNNKSYURUIKGUYOBI1X14   = "zrnnksyuruikguyobi1x14";
    public static final String ZRNNKSYURUIKGUYOBI1X15   = "zrnnksyuruikguyobi1x15";
    public static final String ZRNNKSYURUIKGUYOBI2X1    = "zrnnksyuruikguyobi2x1";
    public static final String ZRNNKSYURUIKGUYOBI2X2    = "zrnnksyuruikguyobi2x2";
    public static final String ZRNNKSYURUIKGUYOBI2X3    = "zrnnksyuruikguyobi2x3";
    public static final String ZRNNKSYURUIKGUYOBI2X4    = "zrnnksyuruikguyobi2x4";
    public static final String ZRNNKSYURUIKGUYOBI2X5    = "zrnnksyuruikguyobi2x5";
    public static final String ZRNNKSYURUIKGUYOBI2X6    = "zrnnksyuruikguyobi2x6";
    public static final String ZRNNKSYURUIKGUYOBI2X7    = "zrnnksyuruikguyobi2x7";
    public static final String ZRNNKSYURUIKGUYOBI2X8    = "zrnnksyuruikguyobi2x8";
    public static final String ZRNNKSYURUIKGUYOBI2X9    = "zrnnksyuruikguyobi2x9";
    public static final String ZRNNKSYURUIKGUYOBI2X10   = "zrnnksyuruikguyobi2x10";
    public static final String ZRNNKSYURUIKGUYOBI3X1    = "zrnnksyuruikguyobi3x1";
    public static final String ZRNNKSYURUIKGUYOBI3X2    = "zrnnksyuruikguyobi3x2";
    public static final String ZRNNKSYURUIKGUYOBI3X3    = "zrnnksyuruikguyobi3x3";
    public static final String ZRNNKSYURUIKGUYOBI3X4    = "zrnnksyuruikguyobi3x4";
    public static final String ZRNNKSYURUIKGUYOBI3X5    = "zrnnksyuruikguyobi3x5";
    public static final String ZRNNKSYURUIKGUYOBI3X6    = "zrnnksyuruikguyobi3x6";
    public static final String ZRNNKSYURUIKGUYOBI3X7    = "zrnnksyuruikguyobi3x7";
    public static final String ZRNNKSYURUIKGUYOBI3X8    = "zrnnksyuruikguyobi3x8";
    public static final String ZRNNKSYURUIKGUYOBI3X9    = "zrnnksyuruikguyobi3x9";
    public static final String ZRNNKSYURUIKGUYOBI3X10   = "zrnnksyuruikguyobi3x10";
    public static final String ZRNTOUKEISYUUSEISYORIKBN = "zrntoukeisyuuseisyorikbn";
    public static final String ZRNTOUKEIMODKURYKHSSIYMD = "zrntoukeimodkurykhssiymd";
    public static final String ZRNTOUKEIMODDENPYOUYMD   = "zrntoukeimoddenpyouymd";
    public static final String ZRNTOUKEIMODBIKINMODKBN  = "zrntoukeimodbikinmodkbn";
    public static final String ZRNTOUKEIMODBIKINSHRYMD  = "zrntoukeimodbikinshrymd";
    public static final String ZRNTOUKEIMODBIKINKIJYUGK = "zrntoukeimodbikinkijyugk";
    public static final String ZRNBIKINNAIYOUKBN        = "zrnbikinnaiyoukbn";
    public static final String ZRNBIKINKEIYAKUJYOUKYOUKBN = "zrnbikinkeiyakujyoukyoukbn";
    public static final String ZRNKAIMASINENKINARIHYOUJI = "zrnkaimasinenkinarihyouji";
    public static final String ZRNMAEATUATOATUSEGARIHYJ = "zrnmaeatuatoatusegarihyj";
    public static final String ZRNZAIKEIYUATATKIMSNKARIHYJ = "zrnzaikeiyuatatkimsnkarihyj";
    public static final String ZRNTYOUHYOUSAKUSEITANIKBN = "zrntyouhyousakuseitanikbn";
    public static final String ZRNSHRNKGKNAIYOUKBN      = "zrnshrnkgknaiyoukbn";
    public static final String ZRNUTIKAIMASINENKINGAKU  = "zrnutikaimasinenkingaku";
    public static final String ZRNPITIJIBARAIKBN        = "zrnpitijibaraikbn";
    public static final String ZRNYOUKIGSYAYOTISBOURTKBN = "zrnyoukigsyayotisbourtkbn";
    public static final String ZRNYUKIGSYAYOTEIHASSEIRTKBN = "zrnyukigsyayoteihasseirtkbn";
    public static final String ZRNYUKIGSYAYOTEISYTGNRTKBN = "zrnyukigsyayoteisytgnrtkbn";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNKAIMASINKKOURYOKUSYMD = "zrnkaimasinkkouryokusymd";
    public static final String ZRNKAIMASINENKINKBN      = "zrnkaimasinenkinkbn";
    public static final String ZRNKAIMASINENKINSYURUIKIGOU = "zrnkaimasinenkinsyuruikigou";
    public static final String ZRNKAIMASINKSHRKKN       = "zrnkaimasinkshrkkn";
    public static final String ZRNKAIMASINENKINHOSYOUKIKAN = "zrnkaimasinenkinhosyoukikan";
    public static final String ZRNKAIMASINKHHKNSYAAGE   = "zrnkaimasinkhhknsyaage";
    public static final String ZRNKIMSNKDAI2HHKNSYAAGE  = "zrnkimsnkdai2hhknsyaage";
    public static final String ZRNSAISYUUNENKINKAIMASIYMD = "zrnsaisyuunenkinkaimasiymd";
    public static final String ZRNKAIMASINENKINGAKU     = "zrnkaimasinenkingaku";
    public static final String ZRNZENNENDOKAIMASINKGK   = "zrnzennendokaimasinkgk";
    public static final String ZRNZNZNNNDKAIMASINKZOUGK = "zrnznznnndkaimasinkzougk";
    public static final String ZRNZNZNZNNNDKAIMASINKGK  = "zrnznznznnndkaimasinkgk";
    public static final String ZRNTOUNENDOKAIMASINENKIND = "zrntounendokaimasinenkind";
    public static final String ZRNKAIMASITYUUSIYMD      = "zrnkaimasityuusiymd";
    public static final String ZRNKAIMASIHUKKIYMD       = "zrnkaimasihukkiymd";
    public static final String ZRNKAIMASINKKIGOUSDKBN   = "zrnkaimasinkkigousdkbn";
    public static final String ZRNMAEATUATOATUKOURYOKUSYMD = "zrnmaeatuatoatukouryokusymd";
    public static final String ZRNMAEATUATOATUKIKAN     = "zrnmaeatuatoatukikan";
    public static final String ZRNMAEATUATOATUHENDOUGONKGK = "zrnmaeatuatoatuhendougonkgk";
    public static final String ZRNATOATUSAISYUUKAIMASIYMD = "zrnatoatusaisyuukaimasiymd";
    public static final String ZRNATOATUKAIMASINENKINGAKU = "zrnatoatukaimasinenkingaku";
    public static final String ZRNZNNNDATOATUKAIMASINKGK = "zrnznnndatoatukaimasinkgk";
    public static final String ZRNZNZNNNDATOATUKAIMASINKGK = "zrnznznnndatoatukaimasinkgk";
    public static final String ZRNZNZNZNNNDATATKIMSNKGK = "zrnznznznnndatatkimsnkgk";
    public static final String ZRNTOUNENDATOATUKAIMASINKD = "zrntounendatoatukaimasinkd";
    public static final String ZRNUWANOSEATOATUKAIMASINKGK = "zrnuwanoseatoatukaimasinkgk";

    private final PKZT_NkToukeiRigRn primaryKey;

    public GenZT_NkToukeiRigRn() {
        primaryKey = new PKZT_NkToukeiRigRn();
    }

    public GenZT_NkToukeiRigRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_NkToukeiRigRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_NkToukeiRigRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkToukeiRigRn> getMetaClass() {
        return QZT_NkToukeiRigRn.class;
    }

    @Id
    @Column(name=GenZT_NkToukeiRigRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnsystemcd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYSTEMCD)
    public String getZrnsystemcd() {
        return zrnsystemcd;
    }

    public void setZrnsystemcd(String pZrnsystemcd) {
        zrnsystemcd = pZrnsystemcd;
    }

    private String zrnulfkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNULFKBN)
    public String getZrnulfkbn() {
        return zrnulfkbn;
    }

    public void setZrnulfkbn(String pZrnulfkbn) {
        zrnulfkbn = pZrnulfkbn;
    }

    private String zrnrecordkihonkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNRECORDKIHONKBN)
    public String getZrnrecordkihonkbn() {
        return zrnrecordkihonkbn;
    }

    public void setZrnrecordkihonkbn(String pZrnrecordkihonkbn) {
        zrnrecordkihonkbn = pZrnrecordkihonkbn;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnnksyousyono;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYOUSYONO)
    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrnidouymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNIDOUYMD)
    public String getZrnidouymd() {
        return zrnidouymd;
    }

    public void setZrnidouymd(String pZrnidouymd) {
        zrnidouymd = pZrnidouymd;
    }

    private String zrnsyouin;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOUIN)
    public String getZrnsyouin() {
        return zrnsyouin;
    }

    public void setZrnsyouin(String pZrnsyouin) {
        zrnsyouin = pZrnsyouin;
    }

    private String zrnnksyuruikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKBN)
    public String getZrnnksyuruikbn() {
        return zrnnksyuruikbn;
    }

    public void setZrnnksyuruikbn(String pZrnnksyuruikbn) {
        zrnnksyuruikbn = pZrnnksyuruikbn;
    }

    private String zrnnenkinkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return zrnnenkinkbn;
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        zrnnenkinkbn = pZrnnenkinkbn;
    }

    private String zrnnenkinsyu;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return zrnnenkinsyu;
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        zrnnenkinsyu = pZrnnenkinsyu;
    }

    private String zrnnenkinkaisikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINKAISIKBN)
    public String getZrnnenkinkaisikbn() {
        return zrnnenkinkaisikbn;
    }

    public void setZrnnenkinkaisikbn(String pZrnnenkinkaisikbn) {
        zrnnenkinkaisikbn = pZrnnenkinkaisikbn;
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnsyokainenkinsiharaiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOKAINENKINSIHARAIYMD)
    public String getZrnsyokainenkinsiharaiymd() {
        return zrnsyokainenkinsiharaiymd;
    }

    public void setZrnsyokainenkinsiharaiymd(String pZrnsyokainenkinsiharaiymd) {
        zrnsyokainenkinsiharaiymd = pZrnsyokainenkinsiharaiymd;
    }

    private String zrnnknshry;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnnenkinhosyoukikan;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINHOSYOUKIKAN)
    public String getZrnnenkinhosyoukikan() {
        return zrnnenkinhosyoukikan;
    }

    public void setZrnnenkinhosyoukikan(String pZrnnenkinhosyoukikan) {
        zrnnenkinhosyoukikan = pZrnnenkinhosyoukikan;
    }

    private Long zrnkhnnkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKHNNKGK)
    public Long getZrnkhnnkgk() {
        return zrnkhnnkgk;
    }

    public void setZrnkhnnkgk(Long pZrnkhnnkgk) {
        zrnkhnnkgk = pZrnkhnnkgk;
    }

    private String zrnsaisyuukousinymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSAISYUUKOUSINYMD)
    public String getZrnsaisyuukousinymd() {
        return zrnsaisyuukousinymd;
    }

    public void setZrnsaisyuukousinymd(String pZrnsaisyuukousinymd) {
        zrnsaisyuukousinymd = pZrnsaisyuukousinymd;
    }

    private String zrnsaisyuukousinsyoricd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSAISYUUKOUSINSYORICD)
    public String getZrnsaisyuukousinsyoricd() {
        return zrnsaisyuukousinsyoricd;
    }

    public void setZrnsaisyuukousinsyoricd(String pZrnsaisyuukousinsyoricd) {
        zrnsaisyuukousinsyoricd = pZrnsaisyuukousinsyoricd;
    }

    private Long zrnnenkinkihonctr;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINKIHONCTR)
    public Long getZrnnenkinkihonctr() {
        return zrnnenkinkihonctr;
    }

    public void setZrnnenkinkihonctr(Long pZrnnenkinkihonctr) {
        zrnnenkinkihonctr = pZrnnenkinkihonctr;
    }

    private String zrncurrentday;

    @Column(name=GenZT_NkToukeiRigRn.ZRNCURRENTDAY)
    public String getZrncurrentday() {
        return zrncurrentday;
    }

    public void setZrncurrentday(String pZrncurrentday) {
        zrncurrentday = pZrncurrentday;
    }

    private String zrncurrenttime;

    @Column(name=GenZT_NkToukeiRigRn.ZRNCURRENTTIME)
    public String getZrncurrenttime() {
        return zrncurrenttime;
    }

    public void setZrncurrenttime(String pZrncurrenttime) {
        zrncurrenttime = pZrncurrenttime;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnkessanjibikinkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKESSANJIBIKINKBN)
    public String getZrnkessanjibikinkbn() {
        return zrnkessanjibikinkbn;
    }

    public void setZrnkessanjibikinkbn(String pZrnkessanjibikinkbn) {
        zrnkessanjibikinkbn = pZrnkessanjibikinkbn;
    }

    private String zrnnksyoumetucd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYOUMETUCD)
    public String getZrnnksyoumetucd() {
        return zrnnksyoumetucd;
    }

    public void setZrnnksyoumetucd(String pZrnnksyoumetucd) {
        zrnnksyoumetucd = pZrnnksyoumetucd;
    }

    private String zrnnksyoumetuymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYOUMETUYMD)
    public String getZrnnksyoumetuymd() {
        return zrnnksyoumetuymd;
    }

    public void setZrnnksyoumetuymd(String pZrnnksyoumetuymd) {
        zrnnksyoumetuymd = pZrnnksyoumetuymd;
    }

    private String zrnkouryokuhasseiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKOURYOKUHASSEIYMD)
    public String getZrnkouryokuhasseiymd() {
        return zrnkouryokuhasseiymd;
    }

    public void setZrnkouryokuhasseiymd(String pZrnkouryokuhasseiymd) {
        zrnkouryokuhasseiymd = pZrnkouryokuhasseiymd;
    }

    private String zrnkingakuzoukanaiyoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKINGAKUZOUKANAIYOUKBN)
    public String getZrnkingakuzoukanaiyoukbn() {
        return zrnkingakuzoukanaiyoukbn;
    }

    public void setZrnkingakuzoukanaiyoukbn(String pZrnkingakuzoukanaiyoukbn) {
        zrnkingakuzoukanaiyoukbn = pZrnkingakuzoukanaiyoukbn;
    }

    private String zrnmotokeiyakusyouhinkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNMOTOKEIYAKUSYOUHINKBN)
    public String getZrnmotokeiyakusyouhinkbn() {
        return zrnmotokeiyakusyouhinkbn;
    }

    public void setZrnmotokeiyakusyouhinkbn(String pZrnmotokeiyakusyouhinkbn) {
        zrnmotokeiyakusyouhinkbn = pZrnmotokeiyakusyouhinkbn;
    }

    private String zrnnenkinkigousedaikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return zrnnenkinkigousedaikbn;
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
    }

    private Double zrnrrthendounkyoteirrt;

    @Column(name=GenZT_NkToukeiRigRn.ZRNRRTHENDOUNKYOTEIRRT)
    public Double getZrnrrthendounkyoteirrt() {
        return zrnrrthendounkyoteirrt;
    }

    public void setZrnrrthendounkyoteirrt(Double pZrnrrthendounkyoteirrt) {
        zrnrrthendounkyoteirrt = pZrnrrthendounkyoteirrt;
    }

    private Double zrnrrthendounksitihsyurrt;

    @Column(name=GenZT_NkToukeiRigRn.ZRNRRTHENDOUNKSITIHSYURRT)
    public Double getZrnrrthendounksitihsyurrt() {
        return zrnrrthendounksitihsyurrt;
    }

    public void setZrnrrthendounksitihsyurrt(Double pZrnrrthendounksitihsyurrt) {
        zrnrrthendounksitihsyurrt = pZrnrrthendounksitihsyurrt;
    }

    private Long zrnhenkoumaekihonnenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNHENKOUMAEKIHONNENKINGAKU)
    public Long getZrnhenkoumaekihonnenkingaku() {
        return zrnhenkoumaekihonnenkingaku;
    }

    public void setZrnhenkoumaekihonnenkingaku(Long pZrnhenkoumaekihonnenkingaku) {
        zrnhenkoumaekihonnenkingaku = pZrnhenkoumaekihonnenkingaku;
    }

    private Long zrnsyokainenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOKAINENKINGAKU)
    public Long getZrnsyokainenkingaku() {
        return zrnsyokainenkingaku;
    }

    public void setZrnsyokainenkingaku(Long pZrnsyokainenkingaku) {
        zrnsyokainenkingaku = pZrnsyokainenkingaku;
    }

    private Long zrnsyokaisiharaijitokubetud;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOKAISIHARAIJITOKUBETUD)
    public Long getZrnsyokaisiharaijitokubetud() {
        return zrnsyokaisiharaijitokubetud;
    }

    public void setZrnsyokaisiharaijitokubetud(Long pZrnsyokaisiharaijitokubetud) {
        zrnsyokaisiharaijitokubetud = pZrnsyokaisiharaijitokubetud;
    }

    private Long zrnsyokaisiharaijikaimasis;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOKAISIHARAIJIKAIMASIS)
    public Long getZrnsyokaisiharaijikaimasis() {
        return zrnsyokaisiharaijikaimasis;
    }

    public void setZrnsyokaisiharaijikaimasis(Long pZrnsyokaisiharaijikaimasis) {
        zrnsyokaisiharaijikaimasis = pZrnsyokaisiharaijikaimasis;
    }

    private Long zrnsyokaisiharaijisonotad;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOKAISIHARAIJISONOTAD)
    public Long getZrnsyokaisiharaijisonotad() {
        return zrnsyokaisiharaijisonotad;
    }

    public void setZrnsyokaisiharaijisonotad(Long pZrnsyokaisiharaijisonotad) {
        zrnsyokaisiharaijisonotad = pZrnsyokaisiharaijisonotad;
    }

    private Long zrnsyokaisiharaijimisyuup;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYOKAISIHARAIJIMISYUUP)
    public Long getZrnsyokaisiharaijimisyuup() {
        return zrnsyokaisiharaijimisyuup;
    }

    public void setZrnsyokaisiharaijimisyuup(Long pZrnsyokaisiharaijimisyuup) {
        zrnsyokaisiharaijimisyuup = pZrnsyokaisiharaijimisyuup;
    }

    private Long zrnidounenkinnengaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNIDOUNENKINNENGAKU)
    public Long getZrnidounenkinnengaku() {
        return zrnidounenkinnengaku;
    }

    public void setZrnidounenkinnengaku(Long pZrnidounenkinnengaku) {
        zrnidounenkinnengaku = pZrnidounenkinnengaku;
    }

    private Long zrnsetteijikikinsougaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSETTEIJIKIKINSOUGAKU)
    public Long getZrnsetteijikikinsougaku() {
        return zrnsetteijikikinsougaku;
    }

    public void setZrnsetteijikikinsougaku(Long pZrnsetteijikikinsougaku) {
        zrnsetteijikikinsougaku = pZrnsetteijikikinsougaku;
    }

    private Long zrntenkanitijibarainkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTENKANITIJIBARAINKGK)
    public Long getZrntenkanitijibarainkgk() {
        return zrntenkanitijibarainkgk;
    }

    public void setZrntenkanitijibarainkgk(Long pZrntenkanitijibarainkgk) {
        zrntenkanitijibarainkgk = pZrntenkanitijibarainkgk;
    }

    private Long zrnkasannkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKASANNKGK)
    public Long getZrnkasannkgk() {
        return zrnkasannkgk;
    }

    public void setZrnkasannkgk(Long pZrnkasannkgk) {
        zrnkasannkgk = pZrnkasannkgk;
    }

    private Long zrnuwanosenenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNUWANOSENENKINGAKU)
    public Long getZrnuwanosenenkingaku() {
        return zrnuwanosenenkingaku;
    }

    public void setZrnuwanosenenkingaku(Long pZrnuwanosenenkingaku) {
        zrnuwanosenenkingaku = pZrnuwanosenenkingaku;
    }

    private Long zrnsyukeiyakunenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSYUKEIYAKUNENKINGAKU)
    public Long getZrnsyukeiyakunenkingaku() {
        return zrnsyukeiyakunenkingaku;
    }

    public void setZrnsyukeiyakunenkingaku(Long pZrnsyukeiyakunenkingaku) {
        zrnsyukeiyakunenkingaku = pZrnsyukeiyakunenkingaku;
    }

    private String zrntokuyakuarihyouji;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOKUYAKUARIHYOUJI)
    public String getZrntokuyakuarihyouji() {
        return zrntokuyakuarihyouji;
    }

    public void setZrntokuyakuarihyouji(String pZrntokuyakuarihyouji) {
        zrntokuyakuarihyouji = pZrntokuyakuarihyouji;
    }

    private String zrnnenkinsiharainaiyoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINSIHARAINAIYOUKBN)
    public String getZrnnenkinsiharainaiyoukbn() {
        return zrnnenkinsiharainaiyoukbn;
    }

    public void setZrnnenkinsiharainaiyoukbn(String pZrnnenkinsiharainaiyoukbn) {
        zrnnenkinsiharainaiyoukbn = pZrnnenkinsiharainaiyoukbn;
    }

    private String zrnitijikinsiharaiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNITIJIKINSIHARAIYMD)
    public String getZrnitijikinsiharaiymd() {
        return zrnitijikinsiharaiymd;
    }

    public void setZrnitijikinsiharaiymd(String pZrnitijikinsiharaiymd) {
        zrnitijikinsiharaiymd = pZrnitijikinsiharaiymd;
    }

    private String zrnkknsetymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKKNSETYMD)
    public String getZrnkknsetymd() {
        return zrnkknsetymd;
    }

    public void setZrnkknsetymd(String pZrnkknsetymd) {
        zrnkknsetymd = pZrnkknsetymd;
    }

    private String zrnnkkaisigoyoteiriritukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKKAISIGOYOTEIRIRITUKBN)
    public String getZrnnkkaisigoyoteiriritukbn() {
        return zrnnkkaisigoyoteiriritukbn;
    }

    public void setZrnnkkaisigoyoteiriritukbn(String pZrnnkkaisigoyoteiriritukbn) {
        zrnnkkaisigoyoteiriritukbn = pZrnnkkaisigoyoteiriritukbn;
    }

    private String zrnnksgoyoteisibouritukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSGOYOTEISIBOURITUKBN)
    public String getZrnnksgoyoteisibouritukbn() {
        return zrnnksgoyoteisibouritukbn;
    }

    public void setZrnnksgoyoteisibouritukbn(String pZrnnksgoyoteisibouritukbn) {
        zrnnksgoyoteisibouritukbn = pZrnnksgoyoteisibouritukbn;
    }

    private String zrnnenkinjimutesuuryoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINJIMUTESUURYOUKBN)
    public String getZrnnenkinjimutesuuryoukbn() {
        return zrnnenkinjimutesuuryoukbn;
    }

    public void setZrnnenkinjimutesuuryoukbn(String pZrnnenkinjimutesuuryoukbn) {
        zrnnenkinjimutesuuryoukbn = pZrnnenkinjimutesuuryoukbn;
    }

    private Double zrnteizouritu;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTEIZOURITU)
    public Double getZrnteizouritu() {
        return zrnteizouritu;
    }

    public void setZrnteizouritu(Double pZrnteizouritu) {
        zrnteizouritu = pZrnteizouritu;
    }

    private String zrnmaeatuatoatukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNMAEATUATOATUKBN)
    public String getZrnmaeatuatoatukbn() {
        return zrnmaeatuatoatukbn;
    }

    public void setZrnmaeatuatoatukbn(String pZrnmaeatuatoatukbn) {
        zrnmaeatuatoatukbn = pZrnmaeatuatoatukbn;
    }

    private String zrntokusyunenkinnaiyoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOKUSYUNENKINNAIYOUKBN)
    public String getZrntokusyunenkinnaiyoukbn() {
        return zrntokusyunenkinnaiyoukbn;
    }

    public void setZrntokusyunenkinnaiyoukbn(String pZrntokusyunenkinnaiyoukbn) {
        zrntokusyunenkinnaiyoukbn = pZrntokusyunenkinnaiyoukbn;
    }

    private String zrnsiharaikaisuukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSIHARAIKAISUUKBN)
    public String getZrnsiharaikaisuukbn() {
        return zrnsiharaikaisuukbn;
    }

    public void setZrnsiharaikaisuukbn(String pZrnsiharaikaisuukbn) {
        zrnsiharaikaisuukbn = pZrnsiharaikaisuukbn;
    }

    private String zrnkgyunkyusykishrtukisuu;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKGYUNKYUSYKISHRTUKISUU)
    public String getZrnkgyunkyusykishrtukisuu() {
        return zrnkgyunkyusykishrtukisuu;
    }

    public void setZrnkgyunkyusykishrtukisuu(String pZrnkgyunkyusykishrtukisuu) {
        zrnkgyunkyusykishrtukisuu = pZrnkgyunkyusykishrtukisuu;
    }

    private String zrnteizounksiboujihknnendo;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTEIZOUNKSIBOUJIHKNNENDO)
    public String getZrnteizounksiboujihknnendo() {
        return zrnteizounksiboujihknnendo;
    }

    public void setZrnteizounksiboujihknnendo(String pZrnteizounksiboujihknnendo) {
        zrnteizounksiboujihknnendo = pZrnteizounksiboujihknnendo;
    }

    private String zrndkigetu;

    @Column(name=GenZT_NkToukeiRigRn.ZRNDKIGETU)
    public String getZrndkigetu() {
        return zrndkigetu;
    }

    public void setZrndkigetu(String pZrndkigetu) {
        zrndkigetu = pZrndkigetu;
    }

    private Long zrntounendod;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUNENDOD)
    public Long getZrntounendod() {
        return zrntounendod;
    }

    public void setZrntounendod(Long pZrntounendod) {
        zrntounendod = pZrntounendod;
    }

    private Long zrnnenkinyousiharaid;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNENKINYOUSIHARAID)
    public Long getZrnnenkinyousiharaid() {
        return zrnnenkinyousiharaid;
    }

    public void setZrnnenkinyousiharaid(Long pZrnnenkinyousiharaid) {
        zrnnenkinyousiharaid = pZrnnenkinyousiharaid;
    }

    private Long zrnsiharainenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSIHARAINENKINGAKU)
    public Long getZrnsiharainenkingaku() {
        return zrnsiharainenkingaku;
    }

    public void setZrnsiharainenkingaku(Long pZrnsiharainenkingaku) {
        zrnsiharainenkingaku = pZrnsiharainenkingaku;
    }

    private String zrnsiharaisyoruiuketukeymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSIHARAISYORUIUKETUKEYMD)
    public String getZrnsiharaisyoruiuketukeymd() {
        return zrnsiharaisyoruiuketukeymd;
    }

    public void setZrnsiharaisyoruiuketukeymd(String pZrnsiharaisyoruiuketukeymd) {
        zrnsiharaisyoruiuketukeymd = pZrnsiharaisyoruiuketukeymd;
    }

    private String zrnsiharaiuketukebasyo;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSIHARAIUKETUKEBASYO)
    public String getZrnsiharaiuketukebasyo() {
        return zrnsiharaiuketukebasyo;
    }

    public void setZrnsiharaiuketukebasyo(String pZrnsiharaiuketukebasyo) {
        zrnsiharaiuketukebasyo = pZrnsiharaiuketukebasyo;
    }

    private String zrnshiharaihasseiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSHIHARAIHASSEIYMD)
    public String getZrnshiharaihasseiymd() {
        return zrnshiharaihasseiymd;
    }

    public void setZrnshiharaihasseiymd(String pZrnshiharaihasseiymd) {
        zrnshiharaihasseiymd = pZrnshiharaihasseiymd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnnksjihihokensyaage;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSJIHIHOKENSYAAGE)
    public String getZrnnksjihihokensyaage() {
        return zrnnksjihihokensyaage;
    }

    public void setZrnnksjihihokensyaage(String pZrnnksjihihokensyaage) {
        zrnnksjihihokensyaage = pZrnnksjihihokensyaage;
    }

    private String zrnhihokensyasibouymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNHIHOKENSYASIBOUYMD)
    public String getZrnhihokensyasibouymd() {
        return zrnhihokensyasibouymd;
    }

    public void setZrnhihokensyasibouymd(String pZrnhihokensyasibouymd) {
        zrnhihokensyasibouymd = pZrnhihokensyasibouymd;
    }

    private String zrndai2hihokensyaseibetukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNDAI2HIHOKENSYASEIBETUKBN)
    public String getZrndai2hihokensyaseibetukbn() {
        return zrndai2hihokensyaseibetukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyaseibetukbn(String pZrndai2hihokensyaseibetukbn) {
        zrndai2hihokensyaseibetukbn = pZrndai2hihokensyaseibetukbn;
    }

    private String zrnnksjidai2hhknsyaage;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSJIDAI2HHKNSYAAGE)
    public String getZrnnksjidai2hhknsyaage() {
        return zrnnksjidai2hhknsyaage;
    }

    public void setZrnnksjidai2hhknsyaage(String pZrnnksjidai2hhknsyaage) {
        zrnnksjidai2hhknsyaage = pZrnnksjidai2hhknsyaage;
    }

    private String zrndai2hihokensyasibouymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNDAI2HIHOKENSYASIBOUYMD)
    public String getZrndai2hihokensyasibouymd() {
        return zrndai2hihokensyasibouymd;
    }

    public void setZrndai2hihokensyasibouymd(String pZrndai2hihokensyasibouymd) {
        zrndai2hihokensyasibouymd = pZrndai2hihokensyasibouymd;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrndai2hihokensyaseiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNDAI2HIHOKENSYASEIYMD)
    public String getZrndai2hihokensyaseiymd() {
        return zrndai2hihokensyaseiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndai2hihokensyaseiymd(String pZrndai2hihokensyaseiymd) {
        zrndai2hihokensyaseiymd = pZrndai2hihokensyaseiymd;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_NkToukeiRigRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_NkToukeiRigRn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private String zrnnkhknhoutekiyouhyj;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKHKNHOUTEKIYOUHYJ)
    public String getZrnnkhknhoutekiyouhyj() {
        return zrnnkhknhoutekiyouhyj;
    }

    public void setZrnnkhknhoutekiyouhyj(String pZrnnkhknhoutekiyouhyj) {
        zrnnkhknhoutekiyouhyj = pZrnnkhknhoutekiyouhyj;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    private String zrntuusinsakiyuubinno;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTUUSINSAKIYUUBINNO)
    public String getZrntuusinsakiyuubinno() {
        return zrntuusinsakiyuubinno;
    }

    public void setZrntuusinsakiyuubinno(String pZrntuusinsakiyuubinno) {
        zrntuusinsakiyuubinno = pZrntuusinsakiyuubinno;
    }

    private String zrntuusinsakitikucd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTUUSINSAKITIKUCD)
    public String getZrntuusinsakitikucd() {
        return zrntuusinsakitikucd;
    }

    public void setZrntuusinsakitikucd(String pZrntuusinsakitikucd) {
        zrntuusinsakitikucd = pZrntuusinsakitikucd;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private String zrnyobiv1x3;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV1X3)
    public String getZrnyobiv1x3() {
        return zrnyobiv1x3;
    }

    public void setZrnyobiv1x3(String pZrnyobiv1x3) {
        zrnyobiv1x3 = pZrnyobiv1x3;
    }

    private String zrnyobiv1x4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV1X4)
    public String getZrnyobiv1x4() {
        return zrnyobiv1x4;
    }

    public void setZrnyobiv1x4(String pZrnyobiv1x4) {
        zrnyobiv1x4 = pZrnyobiv1x4;
    }

    private String zrnyobiv8x3;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV8X3)
    public String getZrnyobiv8x3() {
        return zrnyobiv8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x3(String pZrnyobiv8x3) {
        zrnyobiv8x3 = pZrnyobiv8x3;
    }

    private String zrnyobiv8x4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV8X4)
    public String getZrnyobiv8x4() {
        return zrnyobiv8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x4(String pZrnyobiv8x4) {
        zrnyobiv8x4 = pZrnyobiv8x4;
    }

    private String zrnyobiv59;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV59)
    public String getZrnyobiv59() {
        return zrnyobiv59;
    }

    public void setZrnyobiv59(String pZrnyobiv59) {
        zrnyobiv59 = pZrnyobiv59;
    }

    private String zrnnksyuruikguyobi1x1;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X1)
    public String getZrnnksyuruikguyobi1x1() {
        return zrnnksyuruikguyobi1x1;
    }

    public void setZrnnksyuruikguyobi1x1(String pZrnnksyuruikguyobi1x1) {
        zrnnksyuruikguyobi1x1 = pZrnnksyuruikguyobi1x1;
    }

    private String zrnnksyuruikguyobi1x2;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X2)
    public String getZrnnksyuruikguyobi1x2() {
        return zrnnksyuruikguyobi1x2;
    }

    public void setZrnnksyuruikguyobi1x2(String pZrnnksyuruikguyobi1x2) {
        zrnnksyuruikguyobi1x2 = pZrnnksyuruikguyobi1x2;
    }

    private String zrnnksyuruikguyobi1x3;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X3)
    public String getZrnnksyuruikguyobi1x3() {
        return zrnnksyuruikguyobi1x3;
    }

    public void setZrnnksyuruikguyobi1x3(String pZrnnksyuruikguyobi1x3) {
        zrnnksyuruikguyobi1x3 = pZrnnksyuruikguyobi1x3;
    }

    private String zrnnksyuruikguyobi1x4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X4)
    public String getZrnnksyuruikguyobi1x4() {
        return zrnnksyuruikguyobi1x4;
    }

    public void setZrnnksyuruikguyobi1x4(String pZrnnksyuruikguyobi1x4) {
        zrnnksyuruikguyobi1x4 = pZrnnksyuruikguyobi1x4;
    }

    private String zrnnksyuruikguyobi1x5;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X5)
    public String getZrnnksyuruikguyobi1x5() {
        return zrnnksyuruikguyobi1x5;
    }

    public void setZrnnksyuruikguyobi1x5(String pZrnnksyuruikguyobi1x5) {
        zrnnksyuruikguyobi1x5 = pZrnnksyuruikguyobi1x5;
    }

    private String zrnnksyuruikguyobi1x6;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X6)
    public String getZrnnksyuruikguyobi1x6() {
        return zrnnksyuruikguyobi1x6;
    }

    public void setZrnnksyuruikguyobi1x6(String pZrnnksyuruikguyobi1x6) {
        zrnnksyuruikguyobi1x6 = pZrnnksyuruikguyobi1x6;
    }

    private String zrnnksyuruikguyobi1x7;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X7)
    public String getZrnnksyuruikguyobi1x7() {
        return zrnnksyuruikguyobi1x7;
    }

    public void setZrnnksyuruikguyobi1x7(String pZrnnksyuruikguyobi1x7) {
        zrnnksyuruikguyobi1x7 = pZrnnksyuruikguyobi1x7;
    }

    private String zrnnksyuruikguyobi1x8;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X8)
    public String getZrnnksyuruikguyobi1x8() {
        return zrnnksyuruikguyobi1x8;
    }

    public void setZrnnksyuruikguyobi1x8(String pZrnnksyuruikguyobi1x8) {
        zrnnksyuruikguyobi1x8 = pZrnnksyuruikguyobi1x8;
    }

    private String zrnnksyuruikguyobi1x9;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X9)
    public String getZrnnksyuruikguyobi1x9() {
        return zrnnksyuruikguyobi1x9;
    }

    public void setZrnnksyuruikguyobi1x9(String pZrnnksyuruikguyobi1x9) {
        zrnnksyuruikguyobi1x9 = pZrnnksyuruikguyobi1x9;
    }

    private String zrnnksyuruikguyobi1x10;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X10)
    public String getZrnnksyuruikguyobi1x10() {
        return zrnnksyuruikguyobi1x10;
    }

    public void setZrnnksyuruikguyobi1x10(String pZrnnksyuruikguyobi1x10) {
        zrnnksyuruikguyobi1x10 = pZrnnksyuruikguyobi1x10;
    }

    private String zrnnksyuruikguyobi1x11;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X11)
    public String getZrnnksyuruikguyobi1x11() {
        return zrnnksyuruikguyobi1x11;
    }

    public void setZrnnksyuruikguyobi1x11(String pZrnnksyuruikguyobi1x11) {
        zrnnksyuruikguyobi1x11 = pZrnnksyuruikguyobi1x11;
    }

    private String zrnnksyuruikguyobi1x12;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X12)
    public String getZrnnksyuruikguyobi1x12() {
        return zrnnksyuruikguyobi1x12;
    }

    public void setZrnnksyuruikguyobi1x12(String pZrnnksyuruikguyobi1x12) {
        zrnnksyuruikguyobi1x12 = pZrnnksyuruikguyobi1x12;
    }

    private String zrnnksyuruikguyobi1x13;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X13)
    public String getZrnnksyuruikguyobi1x13() {
        return zrnnksyuruikguyobi1x13;
    }

    public void setZrnnksyuruikguyobi1x13(String pZrnnksyuruikguyobi1x13) {
        zrnnksyuruikguyobi1x13 = pZrnnksyuruikguyobi1x13;
    }

    private String zrnnksyuruikguyobi1x14;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X14)
    public String getZrnnksyuruikguyobi1x14() {
        return zrnnksyuruikguyobi1x14;
    }

    public void setZrnnksyuruikguyobi1x14(String pZrnnksyuruikguyobi1x14) {
        zrnnksyuruikguyobi1x14 = pZrnnksyuruikguyobi1x14;
    }

    private String zrnnksyuruikguyobi1x15;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI1X15)
    public String getZrnnksyuruikguyobi1x15() {
        return zrnnksyuruikguyobi1x15;
    }

    public void setZrnnksyuruikguyobi1x15(String pZrnnksyuruikguyobi1x15) {
        zrnnksyuruikguyobi1x15 = pZrnnksyuruikguyobi1x15;
    }

    private String zrnnksyuruikguyobi2x1;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X1)
    public String getZrnnksyuruikguyobi2x1() {
        return zrnnksyuruikguyobi2x1;
    }

    public void setZrnnksyuruikguyobi2x1(String pZrnnksyuruikguyobi2x1) {
        zrnnksyuruikguyobi2x1 = pZrnnksyuruikguyobi2x1;
    }

    private String zrnnksyuruikguyobi2x2;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X2)
    public String getZrnnksyuruikguyobi2x2() {
        return zrnnksyuruikguyobi2x2;
    }

    public void setZrnnksyuruikguyobi2x2(String pZrnnksyuruikguyobi2x2) {
        zrnnksyuruikguyobi2x2 = pZrnnksyuruikguyobi2x2;
    }

    private String zrnnksyuruikguyobi2x3;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X3)
    public String getZrnnksyuruikguyobi2x3() {
        return zrnnksyuruikguyobi2x3;
    }

    public void setZrnnksyuruikguyobi2x3(String pZrnnksyuruikguyobi2x3) {
        zrnnksyuruikguyobi2x3 = pZrnnksyuruikguyobi2x3;
    }

    private String zrnnksyuruikguyobi2x4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X4)
    public String getZrnnksyuruikguyobi2x4() {
        return zrnnksyuruikguyobi2x4;
    }

    public void setZrnnksyuruikguyobi2x4(String pZrnnksyuruikguyobi2x4) {
        zrnnksyuruikguyobi2x4 = pZrnnksyuruikguyobi2x4;
    }

    private String zrnnksyuruikguyobi2x5;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X5)
    public String getZrnnksyuruikguyobi2x5() {
        return zrnnksyuruikguyobi2x5;
    }

    public void setZrnnksyuruikguyobi2x5(String pZrnnksyuruikguyobi2x5) {
        zrnnksyuruikguyobi2x5 = pZrnnksyuruikguyobi2x5;
    }

    private String zrnnksyuruikguyobi2x6;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X6)
    public String getZrnnksyuruikguyobi2x6() {
        return zrnnksyuruikguyobi2x6;
    }

    public void setZrnnksyuruikguyobi2x6(String pZrnnksyuruikguyobi2x6) {
        zrnnksyuruikguyobi2x6 = pZrnnksyuruikguyobi2x6;
    }

    private String zrnnksyuruikguyobi2x7;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X7)
    public String getZrnnksyuruikguyobi2x7() {
        return zrnnksyuruikguyobi2x7;
    }

    public void setZrnnksyuruikguyobi2x7(String pZrnnksyuruikguyobi2x7) {
        zrnnksyuruikguyobi2x7 = pZrnnksyuruikguyobi2x7;
    }

    private String zrnnksyuruikguyobi2x8;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X8)
    public String getZrnnksyuruikguyobi2x8() {
        return zrnnksyuruikguyobi2x8;
    }

    public void setZrnnksyuruikguyobi2x8(String pZrnnksyuruikguyobi2x8) {
        zrnnksyuruikguyobi2x8 = pZrnnksyuruikguyobi2x8;
    }

    private String zrnnksyuruikguyobi2x9;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X9)
    public String getZrnnksyuruikguyobi2x9() {
        return zrnnksyuruikguyobi2x9;
    }

    public void setZrnnksyuruikguyobi2x9(String pZrnnksyuruikguyobi2x9) {
        zrnnksyuruikguyobi2x9 = pZrnnksyuruikguyobi2x9;
    }

    private String zrnnksyuruikguyobi2x10;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI2X10)
    public String getZrnnksyuruikguyobi2x10() {
        return zrnnksyuruikguyobi2x10;
    }

    public void setZrnnksyuruikguyobi2x10(String pZrnnksyuruikguyobi2x10) {
        zrnnksyuruikguyobi2x10 = pZrnnksyuruikguyobi2x10;
    }

    private String zrnnksyuruikguyobi3x1;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X1)
    public String getZrnnksyuruikguyobi3x1() {
        return zrnnksyuruikguyobi3x1;
    }

    public void setZrnnksyuruikguyobi3x1(String pZrnnksyuruikguyobi3x1) {
        zrnnksyuruikguyobi3x1 = pZrnnksyuruikguyobi3x1;
    }

    private String zrnnksyuruikguyobi3x2;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X2)
    public String getZrnnksyuruikguyobi3x2() {
        return zrnnksyuruikguyobi3x2;
    }

    public void setZrnnksyuruikguyobi3x2(String pZrnnksyuruikguyobi3x2) {
        zrnnksyuruikguyobi3x2 = pZrnnksyuruikguyobi3x2;
    }

    private String zrnnksyuruikguyobi3x3;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X3)
    public String getZrnnksyuruikguyobi3x3() {
        return zrnnksyuruikguyobi3x3;
    }

    public void setZrnnksyuruikguyobi3x3(String pZrnnksyuruikguyobi3x3) {
        zrnnksyuruikguyobi3x3 = pZrnnksyuruikguyobi3x3;
    }

    private String zrnnksyuruikguyobi3x4;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X4)
    public String getZrnnksyuruikguyobi3x4() {
        return zrnnksyuruikguyobi3x4;
    }

    public void setZrnnksyuruikguyobi3x4(String pZrnnksyuruikguyobi3x4) {
        zrnnksyuruikguyobi3x4 = pZrnnksyuruikguyobi3x4;
    }

    private String zrnnksyuruikguyobi3x5;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X5)
    public String getZrnnksyuruikguyobi3x5() {
        return zrnnksyuruikguyobi3x5;
    }

    public void setZrnnksyuruikguyobi3x5(String pZrnnksyuruikguyobi3x5) {
        zrnnksyuruikguyobi3x5 = pZrnnksyuruikguyobi3x5;
    }

    private String zrnnksyuruikguyobi3x6;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X6)
    public String getZrnnksyuruikguyobi3x6() {
        return zrnnksyuruikguyobi3x6;
    }

    public void setZrnnksyuruikguyobi3x6(String pZrnnksyuruikguyobi3x6) {
        zrnnksyuruikguyobi3x6 = pZrnnksyuruikguyobi3x6;
    }

    private String zrnnksyuruikguyobi3x7;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X7)
    public String getZrnnksyuruikguyobi3x7() {
        return zrnnksyuruikguyobi3x7;
    }

    public void setZrnnksyuruikguyobi3x7(String pZrnnksyuruikguyobi3x7) {
        zrnnksyuruikguyobi3x7 = pZrnnksyuruikguyobi3x7;
    }

    private String zrnnksyuruikguyobi3x8;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X8)
    public String getZrnnksyuruikguyobi3x8() {
        return zrnnksyuruikguyobi3x8;
    }

    public void setZrnnksyuruikguyobi3x8(String pZrnnksyuruikguyobi3x8) {
        zrnnksyuruikguyobi3x8 = pZrnnksyuruikguyobi3x8;
    }

    private String zrnnksyuruikguyobi3x9;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X9)
    public String getZrnnksyuruikguyobi3x9() {
        return zrnnksyuruikguyobi3x9;
    }

    public void setZrnnksyuruikguyobi3x9(String pZrnnksyuruikguyobi3x9) {
        zrnnksyuruikguyobi3x9 = pZrnnksyuruikguyobi3x9;
    }

    private String zrnnksyuruikguyobi3x10;

    @Column(name=GenZT_NkToukeiRigRn.ZRNNKSYURUIKGUYOBI3X10)
    public String getZrnnksyuruikguyobi3x10() {
        return zrnnksyuruikguyobi3x10;
    }

    public void setZrnnksyuruikguyobi3x10(String pZrnnksyuruikguyobi3x10) {
        zrnnksyuruikguyobi3x10 = pZrnnksyuruikguyobi3x10;
    }

    private String zrntoukeisyuuseisyorikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUKEISYUUSEISYORIKBN)
    public String getZrntoukeisyuuseisyorikbn() {
        return zrntoukeisyuuseisyorikbn;
    }

    public void setZrntoukeisyuuseisyorikbn(String pZrntoukeisyuuseisyorikbn) {
        zrntoukeisyuuseisyorikbn = pZrntoukeisyuuseisyorikbn;
    }

    private String zrntoukeimodkurykhssiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUKEIMODKURYKHSSIYMD)
    public String getZrntoukeimodkurykhssiymd() {
        return zrntoukeimodkurykhssiymd;
    }

    public void setZrntoukeimodkurykhssiymd(String pZrntoukeimodkurykhssiymd) {
        zrntoukeimodkurykhssiymd = pZrntoukeimodkurykhssiymd;
    }

    private String zrntoukeimoddenpyouymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUKEIMODDENPYOUYMD)
    public String getZrntoukeimoddenpyouymd() {
        return zrntoukeimoddenpyouymd;
    }

    public void setZrntoukeimoddenpyouymd(String pZrntoukeimoddenpyouymd) {
        zrntoukeimoddenpyouymd = pZrntoukeimoddenpyouymd;
    }

    private String zrntoukeimodbikinmodkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUKEIMODBIKINMODKBN)
    public String getZrntoukeimodbikinmodkbn() {
        return zrntoukeimodbikinmodkbn;
    }

    public void setZrntoukeimodbikinmodkbn(String pZrntoukeimodbikinmodkbn) {
        zrntoukeimodbikinmodkbn = pZrntoukeimodbikinmodkbn;
    }

    private String zrntoukeimodbikinshrymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUKEIMODBIKINSHRYMD)
    public String getZrntoukeimodbikinshrymd() {
        return zrntoukeimodbikinshrymd;
    }

    public void setZrntoukeimodbikinshrymd(String pZrntoukeimodbikinshrymd) {
        zrntoukeimodbikinshrymd = pZrntoukeimodbikinshrymd;
    }

    private Long zrntoukeimodbikinkijyugk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUKEIMODBIKINKIJYUGK)
    public Long getZrntoukeimodbikinkijyugk() {
        return zrntoukeimodbikinkijyugk;
    }

    public void setZrntoukeimodbikinkijyugk(Long pZrntoukeimodbikinkijyugk) {
        zrntoukeimodbikinkijyugk = pZrntoukeimodbikinkijyugk;
    }

    private String zrnbikinnaiyoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNBIKINNAIYOUKBN)
    public String getZrnbikinnaiyoukbn() {
        return zrnbikinnaiyoukbn;
    }

    public void setZrnbikinnaiyoukbn(String pZrnbikinnaiyoukbn) {
        zrnbikinnaiyoukbn = pZrnbikinnaiyoukbn;
    }

    private String zrnbikinkeiyakujyoukyoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNBIKINKEIYAKUJYOUKYOUKBN)
    public String getZrnbikinkeiyakujyoukyoukbn() {
        return zrnbikinkeiyakujyoukyoukbn;
    }

    public void setZrnbikinkeiyakujyoukyoukbn(String pZrnbikinkeiyakujyoukyoukbn) {
        zrnbikinkeiyakujyoukyoukbn = pZrnbikinkeiyakujyoukyoukbn;
    }

    private String zrnkaimasinenkinarihyouji;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINENKINARIHYOUJI)
    public String getZrnkaimasinenkinarihyouji() {
        return zrnkaimasinenkinarihyouji;
    }

    public void setZrnkaimasinenkinarihyouji(String pZrnkaimasinenkinarihyouji) {
        zrnkaimasinenkinarihyouji = pZrnkaimasinenkinarihyouji;
    }

    private String zrnmaeatuatoatusegarihyj;

    @Column(name=GenZT_NkToukeiRigRn.ZRNMAEATUATOATUSEGARIHYJ)
    public String getZrnmaeatuatoatusegarihyj() {
        return zrnmaeatuatoatusegarihyj;
    }

    public void setZrnmaeatuatoatusegarihyj(String pZrnmaeatuatoatusegarihyj) {
        zrnmaeatuatoatusegarihyj = pZrnmaeatuatoatusegarihyj;
    }

    private String zrnzaikeiyuatatkimsnkarihyj;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZAIKEIYUATATKIMSNKARIHYJ)
    public String getZrnzaikeiyuatatkimsnkarihyj() {
        return zrnzaikeiyuatatkimsnkarihyj;
    }

    public void setZrnzaikeiyuatatkimsnkarihyj(String pZrnzaikeiyuatatkimsnkarihyj) {
        zrnzaikeiyuatatkimsnkarihyj = pZrnzaikeiyuatatkimsnkarihyj;
    }

    private String zrntyouhyousakuseitanikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTYOUHYOUSAKUSEITANIKBN)
    public String getZrntyouhyousakuseitanikbn() {
        return zrntyouhyousakuseitanikbn;
    }

    public void setZrntyouhyousakuseitanikbn(String pZrntyouhyousakuseitanikbn) {
        zrntyouhyousakuseitanikbn = pZrntyouhyousakuseitanikbn;
    }

    private String zrnshrnkgknaiyoukbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSHRNKGKNAIYOUKBN)
    public String getZrnshrnkgknaiyoukbn() {
        return zrnshrnkgknaiyoukbn;
    }

    public void setZrnshrnkgknaiyoukbn(String pZrnshrnkgknaiyoukbn) {
        zrnshrnkgknaiyoukbn = pZrnshrnkgknaiyoukbn;
    }

    private Long zrnutikaimasinenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNUTIKAIMASINENKINGAKU)
    public Long getZrnutikaimasinenkingaku() {
        return zrnutikaimasinenkingaku;
    }

    public void setZrnutikaimasinenkingaku(Long pZrnutikaimasinenkingaku) {
        zrnutikaimasinenkingaku = pZrnutikaimasinenkingaku;
    }

    private String zrnpitijibaraikbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNPITIJIBARAIKBN)
    public String getZrnpitijibaraikbn() {
        return zrnpitijibaraikbn;
    }

    public void setZrnpitijibaraikbn(String pZrnpitijibaraikbn) {
        zrnpitijibaraikbn = pZrnpitijibaraikbn;
    }

    private String zrnyoukigsyayotisbourtkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOUKIGSYAYOTISBOURTKBN)
    public String getZrnyoukigsyayotisbourtkbn() {
        return zrnyoukigsyayotisbourtkbn;
    }

    public void setZrnyoukigsyayotisbourtkbn(String pZrnyoukigsyayotisbourtkbn) {
        zrnyoukigsyayotisbourtkbn = pZrnyoukigsyayotisbourtkbn;
    }

    private String zrnyukigsyayoteihasseirtkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYUKIGSYAYOTEIHASSEIRTKBN)
    public String getZrnyukigsyayoteihasseirtkbn() {
        return zrnyukigsyayoteihasseirtkbn;
    }

    public void setZrnyukigsyayoteihasseirtkbn(String pZrnyukigsyayoteihasseirtkbn) {
        zrnyukigsyayoteihasseirtkbn = pZrnyukigsyayoteihasseirtkbn;
    }

    private String zrnyukigsyayoteisytgnrtkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYUKIGSYAYOTEISYTGNRTKBN)
    public String getZrnyukigsyayoteisytgnrtkbn() {
        return zrnyukigsyayoteisytgnrtkbn;
    }

    public void setZrnyukigsyayoteisytgnrtkbn(String pZrnyukigsyayoteisytgnrtkbn) {
        zrnyukigsyayoteisytgnrtkbn = pZrnyukigsyayoteisytgnrtkbn;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_NkToukeiRigRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnkaimasinkkouryokusymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINKKOURYOKUSYMD)
    public String getZrnkaimasinkkouryokusymd() {
        return zrnkaimasinkkouryokusymd;
    }

    public void setZrnkaimasinkkouryokusymd(String pZrnkaimasinkkouryokusymd) {
        zrnkaimasinkkouryokusymd = pZrnkaimasinkkouryokusymd;
    }

    private String zrnkaimasinenkinkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINENKINKBN)
    public String getZrnkaimasinenkinkbn() {
        return zrnkaimasinenkinkbn;
    }

    public void setZrnkaimasinenkinkbn(String pZrnkaimasinenkinkbn) {
        zrnkaimasinenkinkbn = pZrnkaimasinenkinkbn;
    }

    private String zrnkaimasinenkinsyuruikigou;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINENKINSYURUIKIGOU)
    public String getZrnkaimasinenkinsyuruikigou() {
        return zrnkaimasinenkinsyuruikigou;
    }

    public void setZrnkaimasinenkinsyuruikigou(String pZrnkaimasinenkinsyuruikigou) {
        zrnkaimasinenkinsyuruikigou = pZrnkaimasinenkinsyuruikigou;
    }

    private String zrnkaimasinkshrkkn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINKSHRKKN)
    public String getZrnkaimasinkshrkkn() {
        return zrnkaimasinkshrkkn;
    }

    public void setZrnkaimasinkshrkkn(String pZrnkaimasinkshrkkn) {
        zrnkaimasinkshrkkn = pZrnkaimasinkshrkkn;
    }

    private String zrnkaimasinenkinhosyoukikan;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINENKINHOSYOUKIKAN)
    public String getZrnkaimasinenkinhosyoukikan() {
        return zrnkaimasinenkinhosyoukikan;
    }

    public void setZrnkaimasinenkinhosyoukikan(String pZrnkaimasinenkinhosyoukikan) {
        zrnkaimasinenkinhosyoukikan = pZrnkaimasinenkinhosyoukikan;
    }

    private String zrnkaimasinkhhknsyaage;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINKHHKNSYAAGE)
    public String getZrnkaimasinkhhknsyaage() {
        return zrnkaimasinkhhknsyaage;
    }

    public void setZrnkaimasinkhhknsyaage(String pZrnkaimasinkhhknsyaage) {
        zrnkaimasinkhhknsyaage = pZrnkaimasinkhhknsyaage;
    }

    private String zrnkimsnkdai2hhknsyaage;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKIMSNKDAI2HHKNSYAAGE)
    public String getZrnkimsnkdai2hhknsyaage() {
        return zrnkimsnkdai2hhknsyaage;
    }

    public void setZrnkimsnkdai2hhknsyaage(String pZrnkimsnkdai2hhknsyaage) {
        zrnkimsnkdai2hhknsyaage = pZrnkimsnkdai2hhknsyaage;
    }

    private String zrnsaisyuunenkinkaimasiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNSAISYUUNENKINKAIMASIYMD)
    public String getZrnsaisyuunenkinkaimasiymd() {
        return zrnsaisyuunenkinkaimasiymd;
    }

    public void setZrnsaisyuunenkinkaimasiymd(String pZrnsaisyuunenkinkaimasiymd) {
        zrnsaisyuunenkinkaimasiymd = pZrnsaisyuunenkinkaimasiymd;
    }

    private Long zrnkaimasinenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINENKINGAKU)
    public Long getZrnkaimasinenkingaku() {
        return zrnkaimasinenkingaku;
    }

    public void setZrnkaimasinenkingaku(Long pZrnkaimasinenkingaku) {
        zrnkaimasinenkingaku = pZrnkaimasinenkingaku;
    }

    private Long zrnzennendokaimasinkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZENNENDOKAIMASINKGK)
    public Long getZrnzennendokaimasinkgk() {
        return zrnzennendokaimasinkgk;
    }

    public void setZrnzennendokaimasinkgk(Long pZrnzennendokaimasinkgk) {
        zrnzennendokaimasinkgk = pZrnzennendokaimasinkgk;
    }

    private Long zrnznznnndkaimasinkzougk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZNZNNNDKAIMASINKZOUGK)
    public Long getZrnznznnndkaimasinkzougk() {
        return zrnznznnndkaimasinkzougk;
    }

    public void setZrnznznnndkaimasinkzougk(Long pZrnznznnndkaimasinkzougk) {
        zrnznznnndkaimasinkzougk = pZrnznznnndkaimasinkzougk;
    }

    private Long zrnznznznnndkaimasinkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZNZNZNNNDKAIMASINKGK)
    public Long getZrnznznznnndkaimasinkgk() {
        return zrnznznznnndkaimasinkgk;
    }

    public void setZrnznznznnndkaimasinkgk(Long pZrnznznznnndkaimasinkgk) {
        zrnznznznnndkaimasinkgk = pZrnznznznnndkaimasinkgk;
    }

    private Long zrntounendokaimasinenkind;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUNENDOKAIMASINENKIND)
    public Long getZrntounendokaimasinenkind() {
        return zrntounendokaimasinenkind;
    }

    public void setZrntounendokaimasinenkind(Long pZrntounendokaimasinenkind) {
        zrntounendokaimasinenkind = pZrntounendokaimasinenkind;
    }

    private String zrnkaimasityuusiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASITYUUSIYMD)
    public String getZrnkaimasityuusiymd() {
        return zrnkaimasityuusiymd;
    }

    public void setZrnkaimasityuusiymd(String pZrnkaimasityuusiymd) {
        zrnkaimasityuusiymd = pZrnkaimasityuusiymd;
    }

    private String zrnkaimasihukkiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASIHUKKIYMD)
    public String getZrnkaimasihukkiymd() {
        return zrnkaimasihukkiymd;
    }

    public void setZrnkaimasihukkiymd(String pZrnkaimasihukkiymd) {
        zrnkaimasihukkiymd = pZrnkaimasihukkiymd;
    }

    private String zrnkaimasinkkigousdkbn;

    @Column(name=GenZT_NkToukeiRigRn.ZRNKAIMASINKKIGOUSDKBN)
    public String getZrnkaimasinkkigousdkbn() {
        return zrnkaimasinkkigousdkbn;
    }

    public void setZrnkaimasinkkigousdkbn(String pZrnkaimasinkkigousdkbn) {
        zrnkaimasinkkigousdkbn = pZrnkaimasinkkigousdkbn;
    }

    private String zrnmaeatuatoatukouryokusymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNMAEATUATOATUKOURYOKUSYMD)
    public String getZrnmaeatuatoatukouryokusymd() {
        return zrnmaeatuatoatukouryokusymd;
    }

    public void setZrnmaeatuatoatukouryokusymd(String pZrnmaeatuatoatukouryokusymd) {
        zrnmaeatuatoatukouryokusymd = pZrnmaeatuatoatukouryokusymd;
    }

    private String zrnmaeatuatoatukikan;

    @Column(name=GenZT_NkToukeiRigRn.ZRNMAEATUATOATUKIKAN)
    public String getZrnmaeatuatoatukikan() {
        return zrnmaeatuatoatukikan;
    }

    public void setZrnmaeatuatoatukikan(String pZrnmaeatuatoatukikan) {
        zrnmaeatuatoatukikan = pZrnmaeatuatoatukikan;
    }

    private Long zrnmaeatuatoatuhendougonkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNMAEATUATOATUHENDOUGONKGK)
    public Long getZrnmaeatuatoatuhendougonkgk() {
        return zrnmaeatuatoatuhendougonkgk;
    }

    public void setZrnmaeatuatoatuhendougonkgk(Long pZrnmaeatuatoatuhendougonkgk) {
        zrnmaeatuatoatuhendougonkgk = pZrnmaeatuatoatuhendougonkgk;
    }

    private String zrnatoatusaisyuukaimasiymd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNATOATUSAISYUUKAIMASIYMD)
    public String getZrnatoatusaisyuukaimasiymd() {
        return zrnatoatusaisyuukaimasiymd;
    }

    public void setZrnatoatusaisyuukaimasiymd(String pZrnatoatusaisyuukaimasiymd) {
        zrnatoatusaisyuukaimasiymd = pZrnatoatusaisyuukaimasiymd;
    }

    private Long zrnatoatukaimasinenkingaku;

    @Column(name=GenZT_NkToukeiRigRn.ZRNATOATUKAIMASINENKINGAKU)
    public Long getZrnatoatukaimasinenkingaku() {
        return zrnatoatukaimasinenkingaku;
    }

    public void setZrnatoatukaimasinenkingaku(Long pZrnatoatukaimasinenkingaku) {
        zrnatoatukaimasinenkingaku = pZrnatoatukaimasinenkingaku;
    }

    private Long zrnznnndatoatukaimasinkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZNNNDATOATUKAIMASINKGK)
    public Long getZrnznnndatoatukaimasinkgk() {
        return zrnznnndatoatukaimasinkgk;
    }

    public void setZrnznnndatoatukaimasinkgk(Long pZrnznnndatoatukaimasinkgk) {
        zrnznnndatoatukaimasinkgk = pZrnznnndatoatukaimasinkgk;
    }

    private Long zrnznznnndatoatukaimasinkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZNZNNNDATOATUKAIMASINKGK)
    public Long getZrnznznnndatoatukaimasinkgk() {
        return zrnznznnndatoatukaimasinkgk;
    }

    public void setZrnznznnndatoatukaimasinkgk(Long pZrnznznnndatoatukaimasinkgk) {
        zrnznznnndatoatukaimasinkgk = pZrnznznnndatoatukaimasinkgk;
    }

    private Long zrnznznznnndatatkimsnkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNZNZNZNNNDATATKIMSNKGK)
    public Long getZrnznznznnndatatkimsnkgk() {
        return zrnznznznnndatatkimsnkgk;
    }

    public void setZrnznznznnndatatkimsnkgk(Long pZrnznznznnndatatkimsnkgk) {
        zrnznznznnndatatkimsnkgk = pZrnznznznnndatatkimsnkgk;
    }

    private Long zrntounendatoatukaimasinkd;

    @Column(name=GenZT_NkToukeiRigRn.ZRNTOUNENDATOATUKAIMASINKD)
    public Long getZrntounendatoatukaimasinkd() {
        return zrntounendatoatukaimasinkd;
    }

    public void setZrntounendatoatukaimasinkd(Long pZrntounendatoatukaimasinkd) {
        zrntounendatoatukaimasinkd = pZrntounendatoatukaimasinkd;
    }

    private Long zrnuwanoseatoatukaimasinkgk;

    @Column(name=GenZT_NkToukeiRigRn.ZRNUWANOSEATOATUKAIMASINKGK)
    public Long getZrnuwanoseatoatukaimasinkgk() {
        return zrnuwanoseatoatukaimasinkgk;
    }

    public void setZrnuwanoseatoatukaimasinkgk(Long pZrnuwanoseatoatukaimasinkgk) {
        zrnuwanoseatoatukaimasinkgk = pZrnuwanoseatoatukaimasinkgk;
    }
}