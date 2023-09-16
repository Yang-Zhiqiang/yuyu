package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkToukeiKtyTy;
import yuyu.def.db.id.PKZT_NkToukeiKtyTy;
import yuyu.def.db.meta.GenQZT_NkToukeiKtyTy;
import yuyu.def.db.meta.QZT_NkToukeiKtyTy;

/**
 * 年金統計Ｆ期中報告用テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_NkToukeiKtyTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkToukeiKtyTy}</td><td colspan="3">年金統計Ｆ期中報告用テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_NkToukeiKtyTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysystemcd ztysystemcd}</td><td>（中継用）システムコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyulfkbn ztyulfkbn}</td><td>（中継用）ＵＬＦ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkihonkbn ztyrecordkihonkbn}</td><td>（中継用）レコード基本区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidouymd ztyidouymd}</td><td>（中継用）異動日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouin ztysyouin}</td><td>（中継用）消因</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn ztynksyuruikbn}</td><td>（中継用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkbn ztynenkinkbn}</td><td>（中継用）年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsyu ztynenkinsyu}</td><td>（中継用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisikbn ztynenkinkaisikbn}</td><td>（中継用）年金開始区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokainenkinsiharaiymd ztysyokainenkinsiharaiymd}</td><td>（中継用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinhosyoukikan ztynenkinhosyoukikan}</td><td>（中継用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhnnkgk ztykhnnkgk}</td><td>（中継用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisyuukousinymd ztysaisyuukousinymd}</td><td>（中継用）最終更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuukousinsyoricd ztysaisyuukousinsyoricd}</td><td>（中継用）最終更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkihonctr ztynenkinkihonctr}</td><td>（中継用）年金基本ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycurrentday ztycurrentday}</td><td>（中継用）現在日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycurrenttime ztycurrenttime}</td><td>（中継用）現在時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykessanjibikinkbn ztykessanjibikinkbn}</td><td>（中継用）決算時備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyoumetucd ztynksyoumetucd}</td><td>（中継用）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyoumetuymd ztynksyoumetuymd}</td><td>（中継用）年金消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouryokuhasseiymd ztykouryokuhasseiymd}</td><td>（中継用）効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingakuzoukanaiyoukbn ztykingakuzoukanaiyoukbn}</td><td>（中継用）金額増加内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymotokeiyakusyouhinkbn ztymotokeiyakusyouhinkbn}</td><td>（中継用）元契約商品区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkigousedaikbn ztynenkinkigousedaikbn}</td><td>（中継用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrrthendounkyoteirrt ztyrrthendounkyoteirrt}</td><td>（中継用）利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyrrthendounksitihsyurrt ztyrrthendounksitihsyurrt}</td><td>（中継用）利率変動年金最低保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyhenkoumaekihonnenkingaku ztyhenkoumaekihonnenkingaku}</td><td>（中継用）変更前基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokainenkingaku ztysyokainenkingaku}</td><td>（中継用）初回年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaisiharaijitokubetud ztysyokaisiharaijitokubetud}</td><td>（中継用）初回支払時特別Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaisiharaijikaimasis ztysyokaisiharaijikaimasis}</td><td>（中継用）初回支払時買増Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaisiharaijisonotad ztysyokaisiharaijisonotad}</td><td>（中継用）初回支払時その他Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaisiharaijimisyuup ztysyokaisiharaijimisyuup}</td><td>（中継用）初回支払時未収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyidounenkinnengaku ztyidounenkinnengaku}</td><td>（中継用）異動年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetteijikikinsougaku ztysetteijikikinsougaku}</td><td>（中継用）設定時基金総額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanitijibarainkgk ztytenkanitijibarainkgk}</td><td>（中継用）転換一時払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykasannkgk ztykasannkgk}</td><td>（中継用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyuwanosenenkingaku ztyuwanosenenkingaku}</td><td>（中継用）上乗せ年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakunenkingaku ztysyukeiyakunenkingaku}</td><td>（中継用）主契約年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokuyakuarihyouji ztytokuyakuarihyouji}</td><td>（中継用）特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsiharainaiyoukbn ztynenkinsiharainaiyoukbn}</td><td>（中継用）年金支払内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijikinsiharaiymd ztyitijikinsiharaiymd}</td><td>（中継用）一時金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykknsetymd ztykknsetymd}</td><td>（中継用）基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkaisigoyoteiriritukbn ztynkkaisigoyoteiriritukbn}</td><td>（中継用）年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksgoyoteisibouritukbn ztynksgoyoteisibouritukbn}</td><td>（中継用）年金開始後予定死亡率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinjimutesuuryoukbn ztynenkinjimutesuuryoukbn}</td><td>（中継用）年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteizouritu ztyteizouritu}</td><td>（中継用）逓増率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatukbn ztymaeatuatoatukbn}</td><td>（中継用）前厚後厚区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyunenkinnaiyoukbn ztytokusyunenkinnaiyoukbn}</td><td>（中継用）特殊年金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaikaisuukbn ztysiharaikaisuukbn}</td><td>（中継用）支払回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgyunkyusykishrtukisuu ztykgyunkyusykishrtukisuu}</td><td>（中継用）企業年金用初回支払月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteizounksiboujihknnendo ztyteizounksiboujihknnendo}</td><td>（中継用）逓増年金死亡時保険年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydkigetu ztydkigetu}</td><td>（中継用）Ｄ期月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytounendod ztytounendod}</td><td>（中継用）当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkinyousiharaid ztynenkinyousiharaid}</td><td>（中継用）年金用支払Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiharainenkingaku ztysiharainenkingaku}</td><td>（中継用）支払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiharaisyoruiuketukeymd ztysiharaisyoruiuketukeymd}</td><td>（中継用）支払書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaiuketukebasyo ztysiharaiuketukebasyo}</td><td>（中継用）支払受付場所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshiharaihasseiymd ztyshiharaihasseiymd}</td><td>（中継用）支払発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjihihokensyaage ztynksjihihokensyaage}</td><td>（中継用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyasibouymd ztyhihokensyasibouymd}</td><td>（中継用）被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyaseibetukbn ztydai2hihokensyaseibetukbn}</td><td>（中継用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjidai2hhknsyaage ztynksjidai2hhknsyaage}</td><td>（中継用）年金開始時第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyasibouymd ztydai2hihokensyasibouymd}</td><td>（中継用）第２被保険者死亡年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyaseiymd ztydai2hihokensyaseiymd}</td><td>（中継用）第２被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnentysihyj ztydai2hhknnentysihyj}</td><td>（中継用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkhknhoutekiyouhyj ztynkhknhoutekiyouhyj}</td><td>（中継用）年金保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x2 ztyyobiv1x2}</td><td>（中継用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusinsakiyuubinno ztytuusinsakiyuubinno}</td><td>（中継用）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusinsakitikucd ztytuusinsakitikucd}</td><td>（中継用）通信先地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x3 ztyyobiv1x3}</td><td>（中継用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x4 ztyyobiv1x4}</td><td>（中継用）予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x3 ztyyobiv8x3}</td><td>（中継用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x4 ztyyobiv8x4}</td><td>（中継用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv59 ztyyobiv59}</td><td>（中継用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x1 ztynksyuruikguyobi1x1}</td><td>（中継用）年金種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x2 ztynksyuruikguyobi1x2}</td><td>（中継用）年金種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x3 ztynksyuruikguyobi1x3}</td><td>（中継用）年金種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x4 ztynksyuruikguyobi1x4}</td><td>（中継用）年金種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x5 ztynksyuruikguyobi1x5}</td><td>（中継用）年金種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x6 ztynksyuruikguyobi1x6}</td><td>（中継用）年金種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x7 ztynksyuruikguyobi1x7}</td><td>（中継用）年金種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x8 ztynksyuruikguyobi1x8}</td><td>（中継用）年金種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x9 ztynksyuruikguyobi1x9}</td><td>（中継用）年金種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x10 ztynksyuruikguyobi1x10}</td><td>（中継用）年金種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x11 ztynksyuruikguyobi1x11}</td><td>（中継用）年金種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x12 ztynksyuruikguyobi1x12}</td><td>（中継用）年金種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x13 ztynksyuruikguyobi1x13}</td><td>（中継用）年金種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x14 ztynksyuruikguyobi1x14}</td><td>（中継用）年金種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi1x15 ztynksyuruikguyobi1x15}</td><td>（中継用）年金種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x1 ztynksyuruikguyobi2x1}</td><td>（中継用）年金種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x2 ztynksyuruikguyobi2x2}</td><td>（中継用）年金種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x3 ztynksyuruikguyobi2x3}</td><td>（中継用）年金種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x4 ztynksyuruikguyobi2x4}</td><td>（中継用）年金種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x5 ztynksyuruikguyobi2x5}</td><td>（中継用）年金種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x6 ztynksyuruikguyobi2x6}</td><td>（中継用）年金種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x7 ztynksyuruikguyobi2x7}</td><td>（中継用）年金種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x8 ztynksyuruikguyobi2x8}</td><td>（中継用）年金種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x9 ztynksyuruikguyobi2x9}</td><td>（中継用）年金種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi2x10 ztynksyuruikguyobi2x10}</td><td>（中継用）年金種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x1 ztynksyuruikguyobi3x1}</td><td>（中継用）年金種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x2 ztynksyuruikguyobi3x2}</td><td>（中継用）年金種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x3 ztynksyuruikguyobi3x3}</td><td>（中継用）年金種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x4 ztynksyuruikguyobi3x4}</td><td>（中継用）年金種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x5 ztynksyuruikguyobi3x5}</td><td>（中継用）年金種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x6 ztynksyuruikguyobi3x6}</td><td>（中継用）年金種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x7 ztynksyuruikguyobi3x7}</td><td>（中継用）年金種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x8 ztynksyuruikguyobi3x8}</td><td>（中継用）年金種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x9 ztynksyuruikguyobi3x9}</td><td>（中継用）年金種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikguyobi3x10 ztynksyuruikguyobi3x10}</td><td>（中継用）年金種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeisyuuseisyorikbn ztytoukeisyuuseisyorikbn}</td><td>（中継用）統計修正処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeimodkurykhssiymd ztytoukeimodkurykhssiymd}</td><td>（中継用）統計修正効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeimoddenpyouymd ztytoukeimoddenpyouymd}</td><td>（中継用）統計修正伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeimodbikinmodkbn ztytoukeimodbikinmodkbn}</td><td>（中継用）統計修正備金修正区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeimodbikinshrymd ztytoukeimodbikinshrymd}</td><td>（中継用）統計修正備金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeimodbikinkijyugk ztytoukeimodbikinkijyugk}</td><td>（中継用）統計修正備金計上額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybikinnaiyoukbn ztybikinnaiyoukbn}</td><td>（中継用）備金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikinkeiyakujyoukyoukbn ztybikinkeiyakujyoukyoukbn}</td><td>（中継用）備金契約状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinarihyouji ztykaimasinenkinarihyouji}</td><td>（中継用）買増年金有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatusegarihyj ztymaeatuatoatusegarihyj}</td><td>（中継用）前厚後厚ＳＥＧ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzaikeiyuatatkimsnkarihyj ztyzaikeiyuatatkimsnkarihyj}</td><td>（中継用）財形用後厚買増年金有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyousakuseitanikbn ztytyouhyousakuseitanikbn}</td><td>（中継用）帳票作成単位区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrnkgknaiyoukbn ztyshrnkgknaiyoukbn}</td><td>（中継用）支払年金額内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyutikaimasinenkingaku ztyutikaimasinenkingaku}</td><td>（中継用）内買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtypitijibaraikbn ztypitijibaraikbn}</td><td>（中継用）Ｐ一時払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoukigsyayotisbourtkbn ztyyoukigsyayotisbourtkbn}</td><td>（中継用）要介護者予定死亡率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyukigsyayoteihasseirtkbn ztyyukigsyayoteihasseirtkbn}</td><td>（中継用）要介護者予定発生率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyukigsyayoteisytgnrtkbn ztyyukigsyayoteisytgnrtkbn}</td><td>（中継用）要介護者予定出現率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkkouryokusymd ztykaimasinkkouryokusymd}</td><td>（中継用）買増年金効力開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinkbn ztykaimasinenkinkbn}</td><td>（中継用）買増年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinsyuruikigou ztykaimasinenkinsyuruikigou}</td><td>（中継用）買増年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkshrkkn ztykaimasinkshrkkn}</td><td>（中継用）買増年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinhosyoukikan ztykaimasinenkinhosyoukikan}</td><td>（中継用）買増年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkhhknsyaage ztykaimasinkhhknsyaage}</td><td>（中継用）買増年金被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykimsnkdai2hhknsyaage ztykimsnkdai2hhknsyaage}</td><td>（中継用）買増年金第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuunenkinkaimasiymd ztysaisyuunenkinkaimasiymd}</td><td>（中継用）最終年金買増日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkingaku ztykaimasinenkingaku}</td><td>（中継用）買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennendokaimasinkgk ztyzennendokaimasinkgk}</td><td>（中継用）前年度買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznznnndkaimasinkzougk ztyznznnndkaimasinkzougk}</td><td>（中継用）前々年度買増年金増額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznznznnndkaimasinkgk ztyznznznnndkaimasinkgk}</td><td>（中継用）前々々年度買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendokaimasinenkind ztytounendokaimasinenkind}</td><td>（中継用）当年度買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaimasityuusiymd ztykaimasityuusiymd}</td><td>（中継用）買増中止日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasihukkiymd ztykaimasihukkiymd}</td><td>（中継用）買増復帰日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkkigousdkbn ztykaimasinkkigousdkbn}</td><td>（中継用）買増年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatukouryokusymd ztymaeatuatoatukouryokusymd}</td><td>（中継用）前厚後厚効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatukikan ztymaeatuatoatukikan}</td><td>（中継用）前厚後厚期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatuhendougonkgk ztymaeatuatoatuhendougonkgk}</td><td>（中継用）前厚後厚変動後年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyatoatusaisyuukaimasiymd ztyatoatusaisyuukaimasiymd}</td><td>（中継用）後厚最終買増日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatoatukaimasinenkingaku ztyatoatukaimasinenkingaku}</td><td>（中継用）後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznnndatoatukaimasinkgk ztyznnndatoatukaimasinkgk}</td><td>（中継用）前年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznznnndatoatukaimasinkgk ztyznznnndatoatukaimasinkgk}</td><td>（中継用）前々年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznznznnndatatkimsnkgk ztyznznznnndatatkimsnkgk}</td><td>（中継用）前々々年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendatoatukaimasinkd ztytounendatoatukaimasinkd}</td><td>（中継用）当年度後厚買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyuwanoseatoatukaimasinkgk ztyuwanoseatoatukaimasinkgk}</td><td>（中継用）上乗せ後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_NkToukeiKtyTy
 * @see     PKZT_NkToukeiKtyTy
 * @see     QZT_NkToukeiKtyTy
 * @see     GenQZT_NkToukeiKtyTy
 */
@MappedSuperclass
@Table(name=GenZT_NkToukeiKtyTy.TABLE_NAME)
@IdClass(value=PKZT_NkToukeiKtyTy.class)
public abstract class GenZT_NkToukeiKtyTy extends AbstractExDBEntity<ZT_NkToukeiKtyTy, PKZT_NkToukeiKtyTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkToukeiKtyTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYSYSTEMCD              = "ztysystemcd";
    public static final String ZTYULFKBN                = "ztyulfkbn";
    public static final String ZTYRECORDKIHONKBN        = "ztyrecordkihonkbn";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYNKSYOUSYONO           = "ztynksyousyono";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYIDOUYMD               = "ztyidouymd";
    public static final String ZTYSYOUIN                = "ztysyouin";
    public static final String ZTYNKSYURUIKBN           = "ztynksyuruikbn";
    public static final String ZTYNENKINKBN             = "ztynenkinkbn";
    public static final String ZTYNENKINSYU             = "ztynenkinsyu";
    public static final String ZTYNENKINKAISIKBN        = "ztynenkinkaisikbn";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYSYOKAINENKINSIHARAIYMD = "ztysyokainenkinsiharaiymd";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYNENKINHOSYOUKIKAN     = "ztynenkinhosyoukikan";
    public static final String ZTYKHNNKGK               = "ztykhnnkgk";
    public static final String ZTYSAISYUUKOUSINYMD      = "ztysaisyuukousinymd";
    public static final String ZTYSAISYUUKOUSINSYORICD  = "ztysaisyuukousinsyoricd";
    public static final String ZTYNENKINKIHONCTR        = "ztynenkinkihonctr";
    public static final String ZTYCURRENTDAY            = "ztycurrentday";
    public static final String ZTYCURRENTTIME           = "ztycurrenttime";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYKESSANJIBIKINKBN      = "ztykessanjibikinkbn";
    public static final String ZTYNKSYOUMETUCD          = "ztynksyoumetucd";
    public static final String ZTYNKSYOUMETUYMD         = "ztynksyoumetuymd";
    public static final String ZTYKOURYOKUHASSEIYMD     = "ztykouryokuhasseiymd";
    public static final String ZTYKINGAKUZOUKANAIYOUKBN = "ztykingakuzoukanaiyoukbn";
    public static final String ZTYMOTOKEIYAKUSYOUHINKBN = "ztymotokeiyakusyouhinkbn";
    public static final String ZTYNENKINKIGOUSEDAIKBN   = "ztynenkinkigousedaikbn";
    public static final String ZTYRRTHENDOUNKYOTEIRRT   = "ztyrrthendounkyoteirrt";
    public static final String ZTYRRTHENDOUNKSITIHSYURRT = "ztyrrthendounksitihsyurrt";
    public static final String ZTYHENKOUMAEKIHONNENKINGAKU = "ztyhenkoumaekihonnenkingaku";
    public static final String ZTYSYOKAINENKINGAKU      = "ztysyokainenkingaku";
    public static final String ZTYSYOKAISIHARAIJITOKUBETUD = "ztysyokaisiharaijitokubetud";
    public static final String ZTYSYOKAISIHARAIJIKAIMASIS = "ztysyokaisiharaijikaimasis";
    public static final String ZTYSYOKAISIHARAIJISONOTAD = "ztysyokaisiharaijisonotad";
    public static final String ZTYSYOKAISIHARAIJIMISYUUP = "ztysyokaisiharaijimisyuup";
    public static final String ZTYIDOUNENKINNENGAKU     = "ztyidounenkinnengaku";
    public static final String ZTYSETTEIJIKIKINSOUGAKU  = "ztysetteijikikinsougaku";
    public static final String ZTYTENKANITIJIBARAINKGK  = "ztytenkanitijibarainkgk";
    public static final String ZTYKASANNKGK             = "ztykasannkgk";
    public static final String ZTYUWANOSENENKINGAKU     = "ztyuwanosenenkingaku";
    public static final String ZTYSYUKEIYAKUNENKINGAKU  = "ztysyukeiyakunenkingaku";
    public static final String ZTYTOKUYAKUARIHYOUJI     = "ztytokuyakuarihyouji";
    public static final String ZTYNENKINSIHARAINAIYOUKBN = "ztynenkinsiharainaiyoukbn";
    public static final String ZTYITIJIKINSIHARAIYMD    = "ztyitijikinsiharaiymd";
    public static final String ZTYKKNSETYMD             = "ztykknsetymd";
    public static final String ZTYNKKAISIGOYOTEIRIRITUKBN = "ztynkkaisigoyoteiriritukbn";
    public static final String ZTYNKSGOYOTEISIBOURITUKBN = "ztynksgoyoteisibouritukbn";
    public static final String ZTYNENKINJIMUTESUURYOUKBN = "ztynenkinjimutesuuryoukbn";
    public static final String ZTYTEIZOURITU            = "ztyteizouritu";
    public static final String ZTYMAEATUATOATUKBN       = "ztymaeatuatoatukbn";
    public static final String ZTYTOKUSYUNENKINNAIYOUKBN = "ztytokusyunenkinnaiyoukbn";
    public static final String ZTYSIHARAIKAISUUKBN      = "ztysiharaikaisuukbn";
    public static final String ZTYKGYUNKYUSYKISHRTUKISUU = "ztykgyunkyusykishrtukisuu";
    public static final String ZTYTEIZOUNKSIBOUJIHKNNENDO = "ztyteizounksiboujihknnendo";
    public static final String ZTYDKIGETU               = "ztydkigetu";
    public static final String ZTYTOUNENDOD             = "ztytounendod";
    public static final String ZTYNENKINYOUSIHARAID     = "ztynenkinyousiharaid";
    public static final String ZTYSIHARAINENKINGAKU     = "ztysiharainenkingaku";
    public static final String ZTYSIHARAISYORUIUKETUKEYMD = "ztysiharaisyoruiuketukeymd";
    public static final String ZTYSIHARAIUKETUKEBASYO   = "ztysiharaiuketukebasyo";
    public static final String ZTYSHIHARAIHASSEIYMD     = "ztyshiharaihasseiymd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYNKSJIHIHOKENSYAAGE    = "ztynksjihihokensyaage";
    public static final String ZTYHIHOKENSYASIBOUYMD    = "ztyhihokensyasibouymd";
    public static final String ZTYDAI2HIHOKENSYASEIBETUKBN = "ztydai2hihokensyaseibetukbn";
    public static final String ZTYNKSJIDAI2HHKNSYAAGE   = "ztynksjidai2hhknsyaage";
    public static final String ZTYDAI2HIHOKENSYASIBOUYMD = "ztydai2hihokensyasibouymd";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYDAI2HIHOKENSYASEIYMD  = "ztydai2hihokensyaseiymd";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYDAI2HHKNNENTYSIHYJ    = "ztydai2hhknnentysihyj";
    public static final String ZTYNKHKNHOUTEKIYOUHYJ    = "ztynkhknhoutekiyouhyj";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYYOBIV1X2              = "ztyyobiv1x2";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYTUUSINSAKIYUUBINNO    = "ztytuusinsakiyuubinno";
    public static final String ZTYTUUSINSAKITIKUCD      = "ztytuusinsakitikucd";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIV1X3              = "ztyyobiv1x3";
    public static final String ZTYYOBIV1X4              = "ztyyobiv1x4";
    public static final String ZTYYOBIV8X3              = "ztyyobiv8x3";
    public static final String ZTYYOBIV8X4              = "ztyyobiv8x4";
    public static final String ZTYYOBIV59               = "ztyyobiv59";
    public static final String ZTYNKSYURUIKGUYOBI1X1    = "ztynksyuruikguyobi1x1";
    public static final String ZTYNKSYURUIKGUYOBI1X2    = "ztynksyuruikguyobi1x2";
    public static final String ZTYNKSYURUIKGUYOBI1X3    = "ztynksyuruikguyobi1x3";
    public static final String ZTYNKSYURUIKGUYOBI1X4    = "ztynksyuruikguyobi1x4";
    public static final String ZTYNKSYURUIKGUYOBI1X5    = "ztynksyuruikguyobi1x5";
    public static final String ZTYNKSYURUIKGUYOBI1X6    = "ztynksyuruikguyobi1x6";
    public static final String ZTYNKSYURUIKGUYOBI1X7    = "ztynksyuruikguyobi1x7";
    public static final String ZTYNKSYURUIKGUYOBI1X8    = "ztynksyuruikguyobi1x8";
    public static final String ZTYNKSYURUIKGUYOBI1X9    = "ztynksyuruikguyobi1x9";
    public static final String ZTYNKSYURUIKGUYOBI1X10   = "ztynksyuruikguyobi1x10";
    public static final String ZTYNKSYURUIKGUYOBI1X11   = "ztynksyuruikguyobi1x11";
    public static final String ZTYNKSYURUIKGUYOBI1X12   = "ztynksyuruikguyobi1x12";
    public static final String ZTYNKSYURUIKGUYOBI1X13   = "ztynksyuruikguyobi1x13";
    public static final String ZTYNKSYURUIKGUYOBI1X14   = "ztynksyuruikguyobi1x14";
    public static final String ZTYNKSYURUIKGUYOBI1X15   = "ztynksyuruikguyobi1x15";
    public static final String ZTYNKSYURUIKGUYOBI2X1    = "ztynksyuruikguyobi2x1";
    public static final String ZTYNKSYURUIKGUYOBI2X2    = "ztynksyuruikguyobi2x2";
    public static final String ZTYNKSYURUIKGUYOBI2X3    = "ztynksyuruikguyobi2x3";
    public static final String ZTYNKSYURUIKGUYOBI2X4    = "ztynksyuruikguyobi2x4";
    public static final String ZTYNKSYURUIKGUYOBI2X5    = "ztynksyuruikguyobi2x5";
    public static final String ZTYNKSYURUIKGUYOBI2X6    = "ztynksyuruikguyobi2x6";
    public static final String ZTYNKSYURUIKGUYOBI2X7    = "ztynksyuruikguyobi2x7";
    public static final String ZTYNKSYURUIKGUYOBI2X8    = "ztynksyuruikguyobi2x8";
    public static final String ZTYNKSYURUIKGUYOBI2X9    = "ztynksyuruikguyobi2x9";
    public static final String ZTYNKSYURUIKGUYOBI2X10   = "ztynksyuruikguyobi2x10";
    public static final String ZTYNKSYURUIKGUYOBI3X1    = "ztynksyuruikguyobi3x1";
    public static final String ZTYNKSYURUIKGUYOBI3X2    = "ztynksyuruikguyobi3x2";
    public static final String ZTYNKSYURUIKGUYOBI3X3    = "ztynksyuruikguyobi3x3";
    public static final String ZTYNKSYURUIKGUYOBI3X4    = "ztynksyuruikguyobi3x4";
    public static final String ZTYNKSYURUIKGUYOBI3X5    = "ztynksyuruikguyobi3x5";
    public static final String ZTYNKSYURUIKGUYOBI3X6    = "ztynksyuruikguyobi3x6";
    public static final String ZTYNKSYURUIKGUYOBI3X7    = "ztynksyuruikguyobi3x7";
    public static final String ZTYNKSYURUIKGUYOBI3X8    = "ztynksyuruikguyobi3x8";
    public static final String ZTYNKSYURUIKGUYOBI3X9    = "ztynksyuruikguyobi3x9";
    public static final String ZTYNKSYURUIKGUYOBI3X10   = "ztynksyuruikguyobi3x10";
    public static final String ZTYTOUKEISYUUSEISYORIKBN = "ztytoukeisyuuseisyorikbn";
    public static final String ZTYTOUKEIMODKURYKHSSIYMD = "ztytoukeimodkurykhssiymd";
    public static final String ZTYTOUKEIMODDENPYOUYMD   = "ztytoukeimoddenpyouymd";
    public static final String ZTYTOUKEIMODBIKINMODKBN  = "ztytoukeimodbikinmodkbn";
    public static final String ZTYTOUKEIMODBIKINSHRYMD  = "ztytoukeimodbikinshrymd";
    public static final String ZTYTOUKEIMODBIKINKIJYUGK = "ztytoukeimodbikinkijyugk";
    public static final String ZTYBIKINNAIYOUKBN        = "ztybikinnaiyoukbn";
    public static final String ZTYBIKINKEIYAKUJYOUKYOUKBN = "ztybikinkeiyakujyoukyoukbn";
    public static final String ZTYKAIMASINENKINARIHYOUJI = "ztykaimasinenkinarihyouji";
    public static final String ZTYMAEATUATOATUSEGARIHYJ = "ztymaeatuatoatusegarihyj";
    public static final String ZTYZAIKEIYUATATKIMSNKARIHYJ = "ztyzaikeiyuatatkimsnkarihyj";
    public static final String ZTYTYOUHYOUSAKUSEITANIKBN = "ztytyouhyousakuseitanikbn";
    public static final String ZTYSHRNKGKNAIYOUKBN      = "ztyshrnkgknaiyoukbn";
    public static final String ZTYUTIKAIMASINENKINGAKU  = "ztyutikaimasinenkingaku";
    public static final String ZTYPITIJIBARAIKBN        = "ztypitijibaraikbn";
    public static final String ZTYYOUKIGSYAYOTISBOURTKBN = "ztyyoukigsyayotisbourtkbn";
    public static final String ZTYYUKIGSYAYOTEIHASSEIRTKBN = "ztyyukigsyayoteihasseirtkbn";
    public static final String ZTYYUKIGSYAYOTEISYTGNRTKBN = "ztyyukigsyayoteisytgnrtkbn";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYKAIMASINKKOURYOKUSYMD = "ztykaimasinkkouryokusymd";
    public static final String ZTYKAIMASINENKINKBN      = "ztykaimasinenkinkbn";
    public static final String ZTYKAIMASINENKINSYURUIKIGOU = "ztykaimasinenkinsyuruikigou";
    public static final String ZTYKAIMASINKSHRKKN       = "ztykaimasinkshrkkn";
    public static final String ZTYKAIMASINENKINHOSYOUKIKAN = "ztykaimasinenkinhosyoukikan";
    public static final String ZTYKAIMASINKHHKNSYAAGE   = "ztykaimasinkhhknsyaage";
    public static final String ZTYKIMSNKDAI2HHKNSYAAGE  = "ztykimsnkdai2hhknsyaage";
    public static final String ZTYSAISYUUNENKINKAIMASIYMD = "ztysaisyuunenkinkaimasiymd";
    public static final String ZTYKAIMASINENKINGAKU     = "ztykaimasinenkingaku";
    public static final String ZTYZENNENDOKAIMASINKGK   = "ztyzennendokaimasinkgk";
    public static final String ZTYZNZNNNDKAIMASINKZOUGK = "ztyznznnndkaimasinkzougk";
    public static final String ZTYZNZNZNNNDKAIMASINKGK  = "ztyznznznnndkaimasinkgk";
    public static final String ZTYTOUNENDOKAIMASINENKIND = "ztytounendokaimasinenkind";
    public static final String ZTYKAIMASITYUUSIYMD      = "ztykaimasityuusiymd";
    public static final String ZTYKAIMASIHUKKIYMD       = "ztykaimasihukkiymd";
    public static final String ZTYKAIMASINKKIGOUSDKBN   = "ztykaimasinkkigousdkbn";
    public static final String ZTYMAEATUATOATUKOURYOKUSYMD = "ztymaeatuatoatukouryokusymd";
    public static final String ZTYMAEATUATOATUKIKAN     = "ztymaeatuatoatukikan";
    public static final String ZTYMAEATUATOATUHENDOUGONKGK = "ztymaeatuatoatuhendougonkgk";
    public static final String ZTYATOATUSAISYUUKAIMASIYMD = "ztyatoatusaisyuukaimasiymd";
    public static final String ZTYATOATUKAIMASINENKINGAKU = "ztyatoatukaimasinenkingaku";
    public static final String ZTYZNNNDATOATUKAIMASINKGK = "ztyznnndatoatukaimasinkgk";
    public static final String ZTYZNZNNNDATOATUKAIMASINKGK = "ztyznznnndatoatukaimasinkgk";
    public static final String ZTYZNZNZNNNDATATKIMSNKGK = "ztyznznznnndatatkimsnkgk";
    public static final String ZTYTOUNENDATOATUKAIMASINKD = "ztytounendatoatukaimasinkd";
    public static final String ZTYUWANOSEATOATUKAIMASINKGK = "ztyuwanoseatoatukaimasinkgk";

    private final PKZT_NkToukeiKtyTy primaryKey;

    public GenZT_NkToukeiKtyTy() {
        primaryKey = new PKZT_NkToukeiKtyTy();
    }

    public GenZT_NkToukeiKtyTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_NkToukeiKtyTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_NkToukeiKtyTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkToukeiKtyTy> getMetaClass() {
        return QZT_NkToukeiKtyTy.class;
    }

    @Id
    @Column(name=GenZT_NkToukeiKtyTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztysystemcd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYSTEMCD)
    public String getZtysystemcd() {
        return ztysystemcd;
    }

    public void setZtysystemcd(String pZtysystemcd) {
        ztysystemcd = pZtysystemcd;
    }

    private String ztyulfkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYULFKBN)
    public String getZtyulfkbn() {
        return ztyulfkbn;
    }

    public void setZtyulfkbn(String pZtyulfkbn) {
        ztyulfkbn = pZtyulfkbn;
    }

    private String ztyrecordkihonkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYRECORDKIHONKBN)
    public String getZtyrecordkihonkbn() {
        return ztyrecordkihonkbn;
    }

    public void setZtyrecordkihonkbn(String pZtyrecordkihonkbn) {
        ztyrecordkihonkbn = pZtyrecordkihonkbn;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztynksyousyono;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYOUSYONO)
    public String getZtynksyousyono() {
        return ztynksyousyono;
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

    private String ztyrecordkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztyidouymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYIDOUYMD)
    public String getZtyidouymd() {
        return ztyidouymd;
    }

    public void setZtyidouymd(String pZtyidouymd) {
        ztyidouymd = pZtyidouymd;
    }

    private String ztysyouin;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOUIN)
    public String getZtysyouin() {
        return ztysyouin;
    }

    public void setZtysyouin(String pZtysyouin) {
        ztysyouin = pZtysyouin;
    }

    private String ztynksyuruikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKBN)
    public String getZtynksyuruikbn() {
        return ztynksyuruikbn;
    }

    public void setZtynksyuruikbn(String pZtynksyuruikbn) {
        ztynksyuruikbn = pZtynksyuruikbn;
    }

    private String ztynenkinkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINKBN)
    public String getZtynenkinkbn() {
        return ztynenkinkbn;
    }

    public void setZtynenkinkbn(String pZtynenkinkbn) {
        ztynenkinkbn = pZtynenkinkbn;
    }

    private String ztynenkinsyu;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINSYU)
    public String getZtynenkinsyu() {
        return ztynenkinsyu;
    }

    public void setZtynenkinsyu(String pZtynenkinsyu) {
        ztynenkinsyu = pZtynenkinsyu;
    }

    private String ztynenkinkaisikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINKAISIKBN)
    public String getZtynenkinkaisikbn() {
        return ztynenkinkaisikbn;
    }

    public void setZtynenkinkaisikbn(String pZtynenkinkaisikbn) {
        ztynenkinkaisikbn = pZtynenkinkaisikbn;
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztysyokainenkinsiharaiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOKAINENKINSIHARAIYMD)
    public String getZtysyokainenkinsiharaiymd() {
        return ztysyokainenkinsiharaiymd;
    }

    public void setZtysyokainenkinsiharaiymd(String pZtysyokainenkinsiharaiymd) {
        ztysyokainenkinsiharaiymd = pZtysyokainenkinsiharaiymd;
    }

    private String ztynknshry;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztynenkinhosyoukikan;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINHOSYOUKIKAN)
    public String getZtynenkinhosyoukikan() {
        return ztynenkinhosyoukikan;
    }

    public void setZtynenkinhosyoukikan(String pZtynenkinhosyoukikan) {
        ztynenkinhosyoukikan = pZtynenkinhosyoukikan;
    }

    private Long ztykhnnkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKHNNKGK)
    public Long getZtykhnnkgk() {
        return ztykhnnkgk;
    }

    public void setZtykhnnkgk(Long pZtykhnnkgk) {
        ztykhnnkgk = pZtykhnnkgk;
    }

    private String ztysaisyuukousinymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSAISYUUKOUSINYMD)
    public String getZtysaisyuukousinymd() {
        return ztysaisyuukousinymd;
    }

    public void setZtysaisyuukousinymd(String pZtysaisyuukousinymd) {
        ztysaisyuukousinymd = pZtysaisyuukousinymd;
    }

    private String ztysaisyuukousinsyoricd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSAISYUUKOUSINSYORICD)
    public String getZtysaisyuukousinsyoricd() {
        return ztysaisyuukousinsyoricd;
    }

    public void setZtysaisyuukousinsyoricd(String pZtysaisyuukousinsyoricd) {
        ztysaisyuukousinsyoricd = pZtysaisyuukousinsyoricd;
    }

    private Long ztynenkinkihonctr;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINKIHONCTR)
    public Long getZtynenkinkihonctr() {
        return ztynenkinkihonctr;
    }

    public void setZtynenkinkihonctr(Long pZtynenkinkihonctr) {
        ztynenkinkihonctr = pZtynenkinkihonctr;
    }

    private String ztycurrentday;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYCURRENTDAY)
    public String getZtycurrentday() {
        return ztycurrentday;
    }

    public void setZtycurrentday(String pZtycurrentday) {
        ztycurrentday = pZtycurrentday;
    }

    private String ztycurrenttime;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYCURRENTTIME)
    public String getZtycurrenttime() {
        return ztycurrenttime;
    }

    public void setZtycurrenttime(String pZtycurrenttime) {
        ztycurrenttime = pZtycurrenttime;
    }

    private String ztysyoricd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztykessanjibikinkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKESSANJIBIKINKBN)
    public String getZtykessanjibikinkbn() {
        return ztykessanjibikinkbn;
    }

    public void setZtykessanjibikinkbn(String pZtykessanjibikinkbn) {
        ztykessanjibikinkbn = pZtykessanjibikinkbn;
    }

    private String ztynksyoumetucd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYOUMETUCD)
    public String getZtynksyoumetucd() {
        return ztynksyoumetucd;
    }

    public void setZtynksyoumetucd(String pZtynksyoumetucd) {
        ztynksyoumetucd = pZtynksyoumetucd;
    }

    private String ztynksyoumetuymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYOUMETUYMD)
    public String getZtynksyoumetuymd() {
        return ztynksyoumetuymd;
    }

    public void setZtynksyoumetuymd(String pZtynksyoumetuymd) {
        ztynksyoumetuymd = pZtynksyoumetuymd;
    }

    private String ztykouryokuhasseiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKOURYOKUHASSEIYMD)
    public String getZtykouryokuhasseiymd() {
        return ztykouryokuhasseiymd;
    }

    public void setZtykouryokuhasseiymd(String pZtykouryokuhasseiymd) {
        ztykouryokuhasseiymd = pZtykouryokuhasseiymd;
    }

    private String ztykingakuzoukanaiyoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKINGAKUZOUKANAIYOUKBN)
    public String getZtykingakuzoukanaiyoukbn() {
        return ztykingakuzoukanaiyoukbn;
    }

    public void setZtykingakuzoukanaiyoukbn(String pZtykingakuzoukanaiyoukbn) {
        ztykingakuzoukanaiyoukbn = pZtykingakuzoukanaiyoukbn;
    }

    private String ztymotokeiyakusyouhinkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYMOTOKEIYAKUSYOUHINKBN)
    public String getZtymotokeiyakusyouhinkbn() {
        return ztymotokeiyakusyouhinkbn;
    }

    public void setZtymotokeiyakusyouhinkbn(String pZtymotokeiyakusyouhinkbn) {
        ztymotokeiyakusyouhinkbn = pZtymotokeiyakusyouhinkbn;
    }

    private String ztynenkinkigousedaikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINKIGOUSEDAIKBN)
    public String getZtynenkinkigousedaikbn() {
        return ztynenkinkigousedaikbn;
    }

    public void setZtynenkinkigousedaikbn(String pZtynenkinkigousedaikbn) {
        ztynenkinkigousedaikbn = pZtynenkinkigousedaikbn;
    }

    private Double ztyrrthendounkyoteirrt;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYRRTHENDOUNKYOTEIRRT)
    public Double getZtyrrthendounkyoteirrt() {
        return ztyrrthendounkyoteirrt;
    }

    public void setZtyrrthendounkyoteirrt(Double pZtyrrthendounkyoteirrt) {
        ztyrrthendounkyoteirrt = pZtyrrthendounkyoteirrt;
    }

    private Double ztyrrthendounksitihsyurrt;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYRRTHENDOUNKSITIHSYURRT)
    public Double getZtyrrthendounksitihsyurrt() {
        return ztyrrthendounksitihsyurrt;
    }

    public void setZtyrrthendounksitihsyurrt(Double pZtyrrthendounksitihsyurrt) {
        ztyrrthendounksitihsyurrt = pZtyrrthendounksitihsyurrt;
    }

    private Long ztyhenkoumaekihonnenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYHENKOUMAEKIHONNENKINGAKU)
    public Long getZtyhenkoumaekihonnenkingaku() {
        return ztyhenkoumaekihonnenkingaku;
    }

    public void setZtyhenkoumaekihonnenkingaku(Long pZtyhenkoumaekihonnenkingaku) {
        ztyhenkoumaekihonnenkingaku = pZtyhenkoumaekihonnenkingaku;
    }

    private Long ztysyokainenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOKAINENKINGAKU)
    public Long getZtysyokainenkingaku() {
        return ztysyokainenkingaku;
    }

    public void setZtysyokainenkingaku(Long pZtysyokainenkingaku) {
        ztysyokainenkingaku = pZtysyokainenkingaku;
    }

    private Long ztysyokaisiharaijitokubetud;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOKAISIHARAIJITOKUBETUD)
    public Long getZtysyokaisiharaijitokubetud() {
        return ztysyokaisiharaijitokubetud;
    }

    public void setZtysyokaisiharaijitokubetud(Long pZtysyokaisiharaijitokubetud) {
        ztysyokaisiharaijitokubetud = pZtysyokaisiharaijitokubetud;
    }

    private Long ztysyokaisiharaijikaimasis;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOKAISIHARAIJIKAIMASIS)
    public Long getZtysyokaisiharaijikaimasis() {
        return ztysyokaisiharaijikaimasis;
    }

    public void setZtysyokaisiharaijikaimasis(Long pZtysyokaisiharaijikaimasis) {
        ztysyokaisiharaijikaimasis = pZtysyokaisiharaijikaimasis;
    }

    private Long ztysyokaisiharaijisonotad;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOKAISIHARAIJISONOTAD)
    public Long getZtysyokaisiharaijisonotad() {
        return ztysyokaisiharaijisonotad;
    }

    public void setZtysyokaisiharaijisonotad(Long pZtysyokaisiharaijisonotad) {
        ztysyokaisiharaijisonotad = pZtysyokaisiharaijisonotad;
    }

    private Long ztysyokaisiharaijimisyuup;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYOKAISIHARAIJIMISYUUP)
    public Long getZtysyokaisiharaijimisyuup() {
        return ztysyokaisiharaijimisyuup;
    }

    public void setZtysyokaisiharaijimisyuup(Long pZtysyokaisiharaijimisyuup) {
        ztysyokaisiharaijimisyuup = pZtysyokaisiharaijimisyuup;
    }

    private Long ztyidounenkinnengaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYIDOUNENKINNENGAKU)
    public Long getZtyidounenkinnengaku() {
        return ztyidounenkinnengaku;
    }

    public void setZtyidounenkinnengaku(Long pZtyidounenkinnengaku) {
        ztyidounenkinnengaku = pZtyidounenkinnengaku;
    }

    private Long ztysetteijikikinsougaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSETTEIJIKIKINSOUGAKU)
    public Long getZtysetteijikikinsougaku() {
        return ztysetteijikikinsougaku;
    }

    public void setZtysetteijikikinsougaku(Long pZtysetteijikikinsougaku) {
        ztysetteijikikinsougaku = pZtysetteijikikinsougaku;
    }

    private Long ztytenkanitijibarainkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTENKANITIJIBARAINKGK)
    public Long getZtytenkanitijibarainkgk() {
        return ztytenkanitijibarainkgk;
    }

    public void setZtytenkanitijibarainkgk(Long pZtytenkanitijibarainkgk) {
        ztytenkanitijibarainkgk = pZtytenkanitijibarainkgk;
    }

    private Long ztykasannkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKASANNKGK)
    public Long getZtykasannkgk() {
        return ztykasannkgk;
    }

    public void setZtykasannkgk(Long pZtykasannkgk) {
        ztykasannkgk = pZtykasannkgk;
    }

    private Long ztyuwanosenenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYUWANOSENENKINGAKU)
    public Long getZtyuwanosenenkingaku() {
        return ztyuwanosenenkingaku;
    }

    public void setZtyuwanosenenkingaku(Long pZtyuwanosenenkingaku) {
        ztyuwanosenenkingaku = pZtyuwanosenenkingaku;
    }

    private Long ztysyukeiyakunenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSYUKEIYAKUNENKINGAKU)
    public Long getZtysyukeiyakunenkingaku() {
        return ztysyukeiyakunenkingaku;
    }

    public void setZtysyukeiyakunenkingaku(Long pZtysyukeiyakunenkingaku) {
        ztysyukeiyakunenkingaku = pZtysyukeiyakunenkingaku;
    }

    private String ztytokuyakuarihyouji;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOKUYAKUARIHYOUJI)
    public String getZtytokuyakuarihyouji() {
        return ztytokuyakuarihyouji;
    }

    public void setZtytokuyakuarihyouji(String pZtytokuyakuarihyouji) {
        ztytokuyakuarihyouji = pZtytokuyakuarihyouji;
    }

    private String ztynenkinsiharainaiyoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINSIHARAINAIYOUKBN)
    public String getZtynenkinsiharainaiyoukbn() {
        return ztynenkinsiharainaiyoukbn;
    }

    public void setZtynenkinsiharainaiyoukbn(String pZtynenkinsiharainaiyoukbn) {
        ztynenkinsiharainaiyoukbn = pZtynenkinsiharainaiyoukbn;
    }

    private String ztyitijikinsiharaiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYITIJIKINSIHARAIYMD)
    public String getZtyitijikinsiharaiymd() {
        return ztyitijikinsiharaiymd;
    }

    public void setZtyitijikinsiharaiymd(String pZtyitijikinsiharaiymd) {
        ztyitijikinsiharaiymd = pZtyitijikinsiharaiymd;
    }

    private String ztykknsetymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKKNSETYMD)
    public String getZtykknsetymd() {
        return ztykknsetymd;
    }

    public void setZtykknsetymd(String pZtykknsetymd) {
        ztykknsetymd = pZtykknsetymd;
    }

    private String ztynkkaisigoyoteiriritukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKKAISIGOYOTEIRIRITUKBN)
    public String getZtynkkaisigoyoteiriritukbn() {
        return ztynkkaisigoyoteiriritukbn;
    }

    public void setZtynkkaisigoyoteiriritukbn(String pZtynkkaisigoyoteiriritukbn) {
        ztynkkaisigoyoteiriritukbn = pZtynkkaisigoyoteiriritukbn;
    }

    private String ztynksgoyoteisibouritukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSGOYOTEISIBOURITUKBN)
    public String getZtynksgoyoteisibouritukbn() {
        return ztynksgoyoteisibouritukbn;
    }

    public void setZtynksgoyoteisibouritukbn(String pZtynksgoyoteisibouritukbn) {
        ztynksgoyoteisibouritukbn = pZtynksgoyoteisibouritukbn;
    }

    private String ztynenkinjimutesuuryoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINJIMUTESUURYOUKBN)
    public String getZtynenkinjimutesuuryoukbn() {
        return ztynenkinjimutesuuryoukbn;
    }

    public void setZtynenkinjimutesuuryoukbn(String pZtynenkinjimutesuuryoukbn) {
        ztynenkinjimutesuuryoukbn = pZtynenkinjimutesuuryoukbn;
    }

    private Double ztyteizouritu;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTEIZOURITU)
    public Double getZtyteizouritu() {
        return ztyteizouritu;
    }

    public void setZtyteizouritu(Double pZtyteizouritu) {
        ztyteizouritu = pZtyteizouritu;
    }

    private String ztymaeatuatoatukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYMAEATUATOATUKBN)
    public String getZtymaeatuatoatukbn() {
        return ztymaeatuatoatukbn;
    }

    public void setZtymaeatuatoatukbn(String pZtymaeatuatoatukbn) {
        ztymaeatuatoatukbn = pZtymaeatuatoatukbn;
    }

    private String ztytokusyunenkinnaiyoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOKUSYUNENKINNAIYOUKBN)
    public String getZtytokusyunenkinnaiyoukbn() {
        return ztytokusyunenkinnaiyoukbn;
    }

    public void setZtytokusyunenkinnaiyoukbn(String pZtytokusyunenkinnaiyoukbn) {
        ztytokusyunenkinnaiyoukbn = pZtytokusyunenkinnaiyoukbn;
    }

    private String ztysiharaikaisuukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSIHARAIKAISUUKBN)
    public String getZtysiharaikaisuukbn() {
        return ztysiharaikaisuukbn;
    }

    public void setZtysiharaikaisuukbn(String pZtysiharaikaisuukbn) {
        ztysiharaikaisuukbn = pZtysiharaikaisuukbn;
    }

    private String ztykgyunkyusykishrtukisuu;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKGYUNKYUSYKISHRTUKISUU)
    public String getZtykgyunkyusykishrtukisuu() {
        return ztykgyunkyusykishrtukisuu;
    }

    public void setZtykgyunkyusykishrtukisuu(String pZtykgyunkyusykishrtukisuu) {
        ztykgyunkyusykishrtukisuu = pZtykgyunkyusykishrtukisuu;
    }

    private String ztyteizounksiboujihknnendo;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTEIZOUNKSIBOUJIHKNNENDO)
    public String getZtyteizounksiboujihknnendo() {
        return ztyteizounksiboujihknnendo;
    }

    public void setZtyteizounksiboujihknnendo(String pZtyteizounksiboujihknnendo) {
        ztyteizounksiboujihknnendo = pZtyteizounksiboujihknnendo;
    }

    private String ztydkigetu;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYDKIGETU)
    public String getZtydkigetu() {
        return ztydkigetu;
    }

    public void setZtydkigetu(String pZtydkigetu) {
        ztydkigetu = pZtydkigetu;
    }

    private Long ztytounendod;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUNENDOD)
    public Long getZtytounendod() {
        return ztytounendod;
    }

    public void setZtytounendod(Long pZtytounendod) {
        ztytounendod = pZtytounendod;
    }

    private Long ztynenkinyousiharaid;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNENKINYOUSIHARAID)
    public Long getZtynenkinyousiharaid() {
        return ztynenkinyousiharaid;
    }

    public void setZtynenkinyousiharaid(Long pZtynenkinyousiharaid) {
        ztynenkinyousiharaid = pZtynenkinyousiharaid;
    }

    private Long ztysiharainenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSIHARAINENKINGAKU)
    public Long getZtysiharainenkingaku() {
        return ztysiharainenkingaku;
    }

    public void setZtysiharainenkingaku(Long pZtysiharainenkingaku) {
        ztysiharainenkingaku = pZtysiharainenkingaku;
    }

    private String ztysiharaisyoruiuketukeymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSIHARAISYORUIUKETUKEYMD)
    public String getZtysiharaisyoruiuketukeymd() {
        return ztysiharaisyoruiuketukeymd;
    }

    public void setZtysiharaisyoruiuketukeymd(String pZtysiharaisyoruiuketukeymd) {
        ztysiharaisyoruiuketukeymd = pZtysiharaisyoruiuketukeymd;
    }

    private String ztysiharaiuketukebasyo;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSIHARAIUKETUKEBASYO)
    public String getZtysiharaiuketukebasyo() {
        return ztysiharaiuketukebasyo;
    }

    public void setZtysiharaiuketukebasyo(String pZtysiharaiuketukebasyo) {
        ztysiharaiuketukebasyo = pZtysiharaiuketukebasyo;
    }

    private String ztyshiharaihasseiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSHIHARAIHASSEIYMD)
    public String getZtyshiharaihasseiymd() {
        return ztyshiharaihasseiymd;
    }

    public void setZtyshiharaihasseiymd(String pZtyshiharaihasseiymd) {
        ztyshiharaihasseiymd = pZtyshiharaihasseiymd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztynksjihihokensyaage;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSJIHIHOKENSYAAGE)
    public String getZtynksjihihokensyaage() {
        return ztynksjihihokensyaage;
    }

    public void setZtynksjihihokensyaage(String pZtynksjihihokensyaage) {
        ztynksjihihokensyaage = pZtynksjihihokensyaage;
    }

    private String ztyhihokensyasibouymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYHIHOKENSYASIBOUYMD)
    public String getZtyhihokensyasibouymd() {
        return ztyhihokensyasibouymd;
    }

    public void setZtyhihokensyasibouymd(String pZtyhihokensyasibouymd) {
        ztyhihokensyasibouymd = pZtyhihokensyasibouymd;
    }

    private String ztydai2hihokensyaseibetukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYDAI2HIHOKENSYASEIBETUKBN)
    public String getZtydai2hihokensyaseibetukbn() {
        return ztydai2hihokensyaseibetukbn;
    }

    public void setZtydai2hihokensyaseibetukbn(String pZtydai2hihokensyaseibetukbn) {
        ztydai2hihokensyaseibetukbn = pZtydai2hihokensyaseibetukbn;
    }

    private String ztynksjidai2hhknsyaage;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSJIDAI2HHKNSYAAGE)
    public String getZtynksjidai2hhknsyaage() {
        return ztynksjidai2hhknsyaage;
    }

    public void setZtynksjidai2hhknsyaage(String pZtynksjidai2hhknsyaage) {
        ztynksjidai2hhknsyaage = pZtynksjidai2hhknsyaage;
    }

    private String ztydai2hihokensyasibouymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYDAI2HIHOKENSYASIBOUYMD)
    public String getZtydai2hihokensyasibouymd() {
        return ztydai2hihokensyasibouymd;
    }

    public void setZtydai2hihokensyasibouymd(String pZtydai2hihokensyasibouymd) {
        ztydai2hihokensyasibouymd = pZtydai2hihokensyasibouymd;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztydai2hihokensyaseiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYDAI2HIHOKENSYASEIYMD)
    public String getZtydai2hihokensyaseiymd() {
        return ztydai2hihokensyaseiymd;
    }

    public void setZtydai2hihokensyaseiymd(String pZtydai2hihokensyaseiymd) {
        ztydai2hihokensyaseiymd = pZtydai2hihokensyaseiymd;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private String ztynkhknhoutekiyouhyj;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKHKNHOUTEKIYOUHYJ)
    public String getZtynkhknhoutekiyouhyj() {
        return ztynkhknhoutekiyouhyj;
    }

    public void setZtynkhknhoutekiyouhyj(String pZtynkhknhoutekiyouhyj) {
        ztynkhknhoutekiyouhyj = pZtynkhknhoutekiyouhyj;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztyyobiv1x2;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV1X2)
    public String getZtyyobiv1x2() {
        return ztyyobiv1x2;
    }

    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        ztyyobiv1x2 = pZtyyobiv1x2;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private String ztytuusinsakiyuubinno;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTUUSINSAKIYUUBINNO)
    public String getZtytuusinsakiyuubinno() {
        return ztytuusinsakiyuubinno;
    }

    public void setZtytuusinsakiyuubinno(String pZtytuusinsakiyuubinno) {
        ztytuusinsakiyuubinno = pZtytuusinsakiyuubinno;
    }

    private String ztytuusinsakitikucd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTUUSINSAKITIKUCD)
    public String getZtytuusinsakitikucd() {
        return ztytuusinsakitikucd;
    }

    public void setZtytuusinsakitikucd(String pZtytuusinsakitikucd) {
        ztytuusinsakitikucd = pZtytuusinsakitikucd;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private String ztyyobiv1x3;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV1X3)
    public String getZtyyobiv1x3() {
        return ztyyobiv1x3;
    }

    public void setZtyyobiv1x3(String pZtyyobiv1x3) {
        ztyyobiv1x3 = pZtyyobiv1x3;
    }

    private String ztyyobiv1x4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV1X4)
    public String getZtyyobiv1x4() {
        return ztyyobiv1x4;
    }

    public void setZtyyobiv1x4(String pZtyyobiv1x4) {
        ztyyobiv1x4 = pZtyyobiv1x4;
    }

    private String ztyyobiv8x3;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV8X3)
    public String getZtyyobiv8x3() {
        return ztyyobiv8x3;
    }

    public void setZtyyobiv8x3(String pZtyyobiv8x3) {
        ztyyobiv8x3 = pZtyyobiv8x3;
    }

    private String ztyyobiv8x4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV8X4)
    public String getZtyyobiv8x4() {
        return ztyyobiv8x4;
    }

    public void setZtyyobiv8x4(String pZtyyobiv8x4) {
        ztyyobiv8x4 = pZtyyobiv8x4;
    }

    private String ztyyobiv59;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV59)
    public String getZtyyobiv59() {
        return ztyyobiv59;
    }

    public void setZtyyobiv59(String pZtyyobiv59) {
        ztyyobiv59 = pZtyyobiv59;
    }

    private String ztynksyuruikguyobi1x1;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X1)
    public String getZtynksyuruikguyobi1x1() {
        return ztynksyuruikguyobi1x1;
    }

    public void setZtynksyuruikguyobi1x1(String pZtynksyuruikguyobi1x1) {
        ztynksyuruikguyobi1x1 = pZtynksyuruikguyobi1x1;
    }

    private String ztynksyuruikguyobi1x2;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X2)
    public String getZtynksyuruikguyobi1x2() {
        return ztynksyuruikguyobi1x2;
    }

    public void setZtynksyuruikguyobi1x2(String pZtynksyuruikguyobi1x2) {
        ztynksyuruikguyobi1x2 = pZtynksyuruikguyobi1x2;
    }

    private String ztynksyuruikguyobi1x3;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X3)
    public String getZtynksyuruikguyobi1x3() {
        return ztynksyuruikguyobi1x3;
    }

    public void setZtynksyuruikguyobi1x3(String pZtynksyuruikguyobi1x3) {
        ztynksyuruikguyobi1x3 = pZtynksyuruikguyobi1x3;
    }

    private String ztynksyuruikguyobi1x4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X4)
    public String getZtynksyuruikguyobi1x4() {
        return ztynksyuruikguyobi1x4;
    }

    public void setZtynksyuruikguyobi1x4(String pZtynksyuruikguyobi1x4) {
        ztynksyuruikguyobi1x4 = pZtynksyuruikguyobi1x4;
    }

    private String ztynksyuruikguyobi1x5;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X5)
    public String getZtynksyuruikguyobi1x5() {
        return ztynksyuruikguyobi1x5;
    }

    public void setZtynksyuruikguyobi1x5(String pZtynksyuruikguyobi1x5) {
        ztynksyuruikguyobi1x5 = pZtynksyuruikguyobi1x5;
    }

    private String ztynksyuruikguyobi1x6;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X6)
    public String getZtynksyuruikguyobi1x6() {
        return ztynksyuruikguyobi1x6;
    }

    public void setZtynksyuruikguyobi1x6(String pZtynksyuruikguyobi1x6) {
        ztynksyuruikguyobi1x6 = pZtynksyuruikguyobi1x6;
    }

    private String ztynksyuruikguyobi1x7;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X7)
    public String getZtynksyuruikguyobi1x7() {
        return ztynksyuruikguyobi1x7;
    }

    public void setZtynksyuruikguyobi1x7(String pZtynksyuruikguyobi1x7) {
        ztynksyuruikguyobi1x7 = pZtynksyuruikguyobi1x7;
    }

    private String ztynksyuruikguyobi1x8;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X8)
    public String getZtynksyuruikguyobi1x8() {
        return ztynksyuruikguyobi1x8;
    }

    public void setZtynksyuruikguyobi1x8(String pZtynksyuruikguyobi1x8) {
        ztynksyuruikguyobi1x8 = pZtynksyuruikguyobi1x8;
    }

    private String ztynksyuruikguyobi1x9;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X9)
    public String getZtynksyuruikguyobi1x9() {
        return ztynksyuruikguyobi1x9;
    }

    public void setZtynksyuruikguyobi1x9(String pZtynksyuruikguyobi1x9) {
        ztynksyuruikguyobi1x9 = pZtynksyuruikguyobi1x9;
    }

    private String ztynksyuruikguyobi1x10;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X10)
    public String getZtynksyuruikguyobi1x10() {
        return ztynksyuruikguyobi1x10;
    }

    public void setZtynksyuruikguyobi1x10(String pZtynksyuruikguyobi1x10) {
        ztynksyuruikguyobi1x10 = pZtynksyuruikguyobi1x10;
    }

    private String ztynksyuruikguyobi1x11;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X11)
    public String getZtynksyuruikguyobi1x11() {
        return ztynksyuruikguyobi1x11;
    }

    public void setZtynksyuruikguyobi1x11(String pZtynksyuruikguyobi1x11) {
        ztynksyuruikguyobi1x11 = pZtynksyuruikguyobi1x11;
    }

    private String ztynksyuruikguyobi1x12;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X12)
    public String getZtynksyuruikguyobi1x12() {
        return ztynksyuruikguyobi1x12;
    }

    public void setZtynksyuruikguyobi1x12(String pZtynksyuruikguyobi1x12) {
        ztynksyuruikguyobi1x12 = pZtynksyuruikguyobi1x12;
    }

    private String ztynksyuruikguyobi1x13;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X13)
    public String getZtynksyuruikguyobi1x13() {
        return ztynksyuruikguyobi1x13;
    }

    public void setZtynksyuruikguyobi1x13(String pZtynksyuruikguyobi1x13) {
        ztynksyuruikguyobi1x13 = pZtynksyuruikguyobi1x13;
    }

    private String ztynksyuruikguyobi1x14;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X14)
    public String getZtynksyuruikguyobi1x14() {
        return ztynksyuruikguyobi1x14;
    }

    public void setZtynksyuruikguyobi1x14(String pZtynksyuruikguyobi1x14) {
        ztynksyuruikguyobi1x14 = pZtynksyuruikguyobi1x14;
    }

    private String ztynksyuruikguyobi1x15;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI1X15)
    public String getZtynksyuruikguyobi1x15() {
        return ztynksyuruikguyobi1x15;
    }

    public void setZtynksyuruikguyobi1x15(String pZtynksyuruikguyobi1x15) {
        ztynksyuruikguyobi1x15 = pZtynksyuruikguyobi1x15;
    }

    private String ztynksyuruikguyobi2x1;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X1)
    public String getZtynksyuruikguyobi2x1() {
        return ztynksyuruikguyobi2x1;
    }

    public void setZtynksyuruikguyobi2x1(String pZtynksyuruikguyobi2x1) {
        ztynksyuruikguyobi2x1 = pZtynksyuruikguyobi2x1;
    }

    private String ztynksyuruikguyobi2x2;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X2)
    public String getZtynksyuruikguyobi2x2() {
        return ztynksyuruikguyobi2x2;
    }

    public void setZtynksyuruikguyobi2x2(String pZtynksyuruikguyobi2x2) {
        ztynksyuruikguyobi2x2 = pZtynksyuruikguyobi2x2;
    }

    private String ztynksyuruikguyobi2x3;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X3)
    public String getZtynksyuruikguyobi2x3() {
        return ztynksyuruikguyobi2x3;
    }

    public void setZtynksyuruikguyobi2x3(String pZtynksyuruikguyobi2x3) {
        ztynksyuruikguyobi2x3 = pZtynksyuruikguyobi2x3;
    }

    private String ztynksyuruikguyobi2x4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X4)
    public String getZtynksyuruikguyobi2x4() {
        return ztynksyuruikguyobi2x4;
    }

    public void setZtynksyuruikguyobi2x4(String pZtynksyuruikguyobi2x4) {
        ztynksyuruikguyobi2x4 = pZtynksyuruikguyobi2x4;
    }

    private String ztynksyuruikguyobi2x5;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X5)
    public String getZtynksyuruikguyobi2x5() {
        return ztynksyuruikguyobi2x5;
    }

    public void setZtynksyuruikguyobi2x5(String pZtynksyuruikguyobi2x5) {
        ztynksyuruikguyobi2x5 = pZtynksyuruikguyobi2x5;
    }

    private String ztynksyuruikguyobi2x6;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X6)
    public String getZtynksyuruikguyobi2x6() {
        return ztynksyuruikguyobi2x6;
    }

    public void setZtynksyuruikguyobi2x6(String pZtynksyuruikguyobi2x6) {
        ztynksyuruikguyobi2x6 = pZtynksyuruikguyobi2x6;
    }

    private String ztynksyuruikguyobi2x7;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X7)
    public String getZtynksyuruikguyobi2x7() {
        return ztynksyuruikguyobi2x7;
    }

    public void setZtynksyuruikguyobi2x7(String pZtynksyuruikguyobi2x7) {
        ztynksyuruikguyobi2x7 = pZtynksyuruikguyobi2x7;
    }

    private String ztynksyuruikguyobi2x8;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X8)
    public String getZtynksyuruikguyobi2x8() {
        return ztynksyuruikguyobi2x8;
    }

    public void setZtynksyuruikguyobi2x8(String pZtynksyuruikguyobi2x8) {
        ztynksyuruikguyobi2x8 = pZtynksyuruikguyobi2x8;
    }

    private String ztynksyuruikguyobi2x9;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X9)
    public String getZtynksyuruikguyobi2x9() {
        return ztynksyuruikguyobi2x9;
    }

    public void setZtynksyuruikguyobi2x9(String pZtynksyuruikguyobi2x9) {
        ztynksyuruikguyobi2x9 = pZtynksyuruikguyobi2x9;
    }

    private String ztynksyuruikguyobi2x10;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI2X10)
    public String getZtynksyuruikguyobi2x10() {
        return ztynksyuruikguyobi2x10;
    }

    public void setZtynksyuruikguyobi2x10(String pZtynksyuruikguyobi2x10) {
        ztynksyuruikguyobi2x10 = pZtynksyuruikguyobi2x10;
    }

    private String ztynksyuruikguyobi3x1;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X1)
    public String getZtynksyuruikguyobi3x1() {
        return ztynksyuruikguyobi3x1;
    }

    public void setZtynksyuruikguyobi3x1(String pZtynksyuruikguyobi3x1) {
        ztynksyuruikguyobi3x1 = pZtynksyuruikguyobi3x1;
    }

    private String ztynksyuruikguyobi3x2;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X2)
    public String getZtynksyuruikguyobi3x2() {
        return ztynksyuruikguyobi3x2;
    }

    public void setZtynksyuruikguyobi3x2(String pZtynksyuruikguyobi3x2) {
        ztynksyuruikguyobi3x2 = pZtynksyuruikguyobi3x2;
    }

    private String ztynksyuruikguyobi3x3;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X3)
    public String getZtynksyuruikguyobi3x3() {
        return ztynksyuruikguyobi3x3;
    }

    public void setZtynksyuruikguyobi3x3(String pZtynksyuruikguyobi3x3) {
        ztynksyuruikguyobi3x3 = pZtynksyuruikguyobi3x3;
    }

    private String ztynksyuruikguyobi3x4;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X4)
    public String getZtynksyuruikguyobi3x4() {
        return ztynksyuruikguyobi3x4;
    }

    public void setZtynksyuruikguyobi3x4(String pZtynksyuruikguyobi3x4) {
        ztynksyuruikguyobi3x4 = pZtynksyuruikguyobi3x4;
    }

    private String ztynksyuruikguyobi3x5;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X5)
    public String getZtynksyuruikguyobi3x5() {
        return ztynksyuruikguyobi3x5;
    }

    public void setZtynksyuruikguyobi3x5(String pZtynksyuruikguyobi3x5) {
        ztynksyuruikguyobi3x5 = pZtynksyuruikguyobi3x5;
    }

    private String ztynksyuruikguyobi3x6;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X6)
    public String getZtynksyuruikguyobi3x6() {
        return ztynksyuruikguyobi3x6;
    }

    public void setZtynksyuruikguyobi3x6(String pZtynksyuruikguyobi3x6) {
        ztynksyuruikguyobi3x6 = pZtynksyuruikguyobi3x6;
    }

    private String ztynksyuruikguyobi3x7;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X7)
    public String getZtynksyuruikguyobi3x7() {
        return ztynksyuruikguyobi3x7;
    }

    public void setZtynksyuruikguyobi3x7(String pZtynksyuruikguyobi3x7) {
        ztynksyuruikguyobi3x7 = pZtynksyuruikguyobi3x7;
    }

    private String ztynksyuruikguyobi3x8;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X8)
    public String getZtynksyuruikguyobi3x8() {
        return ztynksyuruikguyobi3x8;
    }

    public void setZtynksyuruikguyobi3x8(String pZtynksyuruikguyobi3x8) {
        ztynksyuruikguyobi3x8 = pZtynksyuruikguyobi3x8;
    }

    private String ztynksyuruikguyobi3x9;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X9)
    public String getZtynksyuruikguyobi3x9() {
        return ztynksyuruikguyobi3x9;
    }

    public void setZtynksyuruikguyobi3x9(String pZtynksyuruikguyobi3x9) {
        ztynksyuruikguyobi3x9 = pZtynksyuruikguyobi3x9;
    }

    private String ztynksyuruikguyobi3x10;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYNKSYURUIKGUYOBI3X10)
    public String getZtynksyuruikguyobi3x10() {
        return ztynksyuruikguyobi3x10;
    }

    public void setZtynksyuruikguyobi3x10(String pZtynksyuruikguyobi3x10) {
        ztynksyuruikguyobi3x10 = pZtynksyuruikguyobi3x10;
    }

    private String ztytoukeisyuuseisyorikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUKEISYUUSEISYORIKBN)
    public String getZtytoukeisyuuseisyorikbn() {
        return ztytoukeisyuuseisyorikbn;
    }

    public void setZtytoukeisyuuseisyorikbn(String pZtytoukeisyuuseisyorikbn) {
        ztytoukeisyuuseisyorikbn = pZtytoukeisyuuseisyorikbn;
    }

    private String ztytoukeimodkurykhssiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUKEIMODKURYKHSSIYMD)
    public String getZtytoukeimodkurykhssiymd() {
        return ztytoukeimodkurykhssiymd;
    }

    public void setZtytoukeimodkurykhssiymd(String pZtytoukeimodkurykhssiymd) {
        ztytoukeimodkurykhssiymd = pZtytoukeimodkurykhssiymd;
    }

    private String ztytoukeimoddenpyouymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUKEIMODDENPYOUYMD)
    public String getZtytoukeimoddenpyouymd() {
        return ztytoukeimoddenpyouymd;
    }

    public void setZtytoukeimoddenpyouymd(String pZtytoukeimoddenpyouymd) {
        ztytoukeimoddenpyouymd = pZtytoukeimoddenpyouymd;
    }

    private String ztytoukeimodbikinmodkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUKEIMODBIKINMODKBN)
    public String getZtytoukeimodbikinmodkbn() {
        return ztytoukeimodbikinmodkbn;
    }

    public void setZtytoukeimodbikinmodkbn(String pZtytoukeimodbikinmodkbn) {
        ztytoukeimodbikinmodkbn = pZtytoukeimodbikinmodkbn;
    }

    private String ztytoukeimodbikinshrymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUKEIMODBIKINSHRYMD)
    public String getZtytoukeimodbikinshrymd() {
        return ztytoukeimodbikinshrymd;
    }

    public void setZtytoukeimodbikinshrymd(String pZtytoukeimodbikinshrymd) {
        ztytoukeimodbikinshrymd = pZtytoukeimodbikinshrymd;
    }

    private Long ztytoukeimodbikinkijyugk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUKEIMODBIKINKIJYUGK)
    public Long getZtytoukeimodbikinkijyugk() {
        return ztytoukeimodbikinkijyugk;
    }

    public void setZtytoukeimodbikinkijyugk(Long pZtytoukeimodbikinkijyugk) {
        ztytoukeimodbikinkijyugk = pZtytoukeimodbikinkijyugk;
    }

    private String ztybikinnaiyoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYBIKINNAIYOUKBN)
    public String getZtybikinnaiyoukbn() {
        return ztybikinnaiyoukbn;
    }

    public void setZtybikinnaiyoukbn(String pZtybikinnaiyoukbn) {
        ztybikinnaiyoukbn = pZtybikinnaiyoukbn;
    }

    private String ztybikinkeiyakujyoukyoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYBIKINKEIYAKUJYOUKYOUKBN)
    public String getZtybikinkeiyakujyoukyoukbn() {
        return ztybikinkeiyakujyoukyoukbn;
    }

    public void setZtybikinkeiyakujyoukyoukbn(String pZtybikinkeiyakujyoukyoukbn) {
        ztybikinkeiyakujyoukyoukbn = pZtybikinkeiyakujyoukyoukbn;
    }

    private String ztykaimasinenkinarihyouji;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINENKINARIHYOUJI)
    public String getZtykaimasinenkinarihyouji() {
        return ztykaimasinenkinarihyouji;
    }

    public void setZtykaimasinenkinarihyouji(String pZtykaimasinenkinarihyouji) {
        ztykaimasinenkinarihyouji = pZtykaimasinenkinarihyouji;
    }

    private String ztymaeatuatoatusegarihyj;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYMAEATUATOATUSEGARIHYJ)
    public String getZtymaeatuatoatusegarihyj() {
        return ztymaeatuatoatusegarihyj;
    }

    public void setZtymaeatuatoatusegarihyj(String pZtymaeatuatoatusegarihyj) {
        ztymaeatuatoatusegarihyj = pZtymaeatuatoatusegarihyj;
    }

    private String ztyzaikeiyuatatkimsnkarihyj;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZAIKEIYUATATKIMSNKARIHYJ)
    public String getZtyzaikeiyuatatkimsnkarihyj() {
        return ztyzaikeiyuatatkimsnkarihyj;
    }

    public void setZtyzaikeiyuatatkimsnkarihyj(String pZtyzaikeiyuatatkimsnkarihyj) {
        ztyzaikeiyuatatkimsnkarihyj = pZtyzaikeiyuatatkimsnkarihyj;
    }

    private String ztytyouhyousakuseitanikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTYOUHYOUSAKUSEITANIKBN)
    public String getZtytyouhyousakuseitanikbn() {
        return ztytyouhyousakuseitanikbn;
    }

    public void setZtytyouhyousakuseitanikbn(String pZtytyouhyousakuseitanikbn) {
        ztytyouhyousakuseitanikbn = pZtytyouhyousakuseitanikbn;
    }

    private String ztyshrnkgknaiyoukbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSHRNKGKNAIYOUKBN)
    public String getZtyshrnkgknaiyoukbn() {
        return ztyshrnkgknaiyoukbn;
    }

    public void setZtyshrnkgknaiyoukbn(String pZtyshrnkgknaiyoukbn) {
        ztyshrnkgknaiyoukbn = pZtyshrnkgknaiyoukbn;
    }

    private Long ztyutikaimasinenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYUTIKAIMASINENKINGAKU)
    public Long getZtyutikaimasinenkingaku() {
        return ztyutikaimasinenkingaku;
    }

    public void setZtyutikaimasinenkingaku(Long pZtyutikaimasinenkingaku) {
        ztyutikaimasinenkingaku = pZtyutikaimasinenkingaku;
    }

    private String ztypitijibaraikbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYPITIJIBARAIKBN)
    public String getZtypitijibaraikbn() {
        return ztypitijibaraikbn;
    }

    public void setZtypitijibaraikbn(String pZtypitijibaraikbn) {
        ztypitijibaraikbn = pZtypitijibaraikbn;
    }

    private String ztyyoukigsyayotisbourtkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOUKIGSYAYOTISBOURTKBN)
    public String getZtyyoukigsyayotisbourtkbn() {
        return ztyyoukigsyayotisbourtkbn;
    }

    public void setZtyyoukigsyayotisbourtkbn(String pZtyyoukigsyayotisbourtkbn) {
        ztyyoukigsyayotisbourtkbn = pZtyyoukigsyayotisbourtkbn;
    }

    private String ztyyukigsyayoteihasseirtkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYUKIGSYAYOTEIHASSEIRTKBN)
    public String getZtyyukigsyayoteihasseirtkbn() {
        return ztyyukigsyayoteihasseirtkbn;
    }

    public void setZtyyukigsyayoteihasseirtkbn(String pZtyyukigsyayoteihasseirtkbn) {
        ztyyukigsyayoteihasseirtkbn = pZtyyukigsyayoteihasseirtkbn;
    }

    private String ztyyukigsyayoteisytgnrtkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYUKIGSYAYOTEISYTGNRTKBN)
    public String getZtyyukigsyayoteisytgnrtkbn() {
        return ztyyukigsyayoteisytgnrtkbn;
    }

    public void setZtyyukigsyayoteisytgnrtkbn(String pZtyyukigsyayoteisytgnrtkbn) {
        ztyyukigsyayoteisytgnrtkbn = pZtyyukigsyayoteisytgnrtkbn;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztykaimasinkkouryokusymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINKKOURYOKUSYMD)
    public String getZtykaimasinkkouryokusymd() {
        return ztykaimasinkkouryokusymd;
    }

    public void setZtykaimasinkkouryokusymd(String pZtykaimasinkkouryokusymd) {
        ztykaimasinkkouryokusymd = pZtykaimasinkkouryokusymd;
    }

    private String ztykaimasinenkinkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINENKINKBN)
    public String getZtykaimasinenkinkbn() {
        return ztykaimasinenkinkbn;
    }

    public void setZtykaimasinenkinkbn(String pZtykaimasinenkinkbn) {
        ztykaimasinenkinkbn = pZtykaimasinenkinkbn;
    }

    private String ztykaimasinenkinsyuruikigou;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINENKINSYURUIKIGOU)
    public String getZtykaimasinenkinsyuruikigou() {
        return ztykaimasinenkinsyuruikigou;
    }

    public void setZtykaimasinenkinsyuruikigou(String pZtykaimasinenkinsyuruikigou) {
        ztykaimasinenkinsyuruikigou = pZtykaimasinenkinsyuruikigou;
    }

    private String ztykaimasinkshrkkn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINKSHRKKN)
    public String getZtykaimasinkshrkkn() {
        return ztykaimasinkshrkkn;
    }

    public void setZtykaimasinkshrkkn(String pZtykaimasinkshrkkn) {
        ztykaimasinkshrkkn = pZtykaimasinkshrkkn;
    }

    private String ztykaimasinenkinhosyoukikan;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINENKINHOSYOUKIKAN)
    public String getZtykaimasinenkinhosyoukikan() {
        return ztykaimasinenkinhosyoukikan;
    }

    public void setZtykaimasinenkinhosyoukikan(String pZtykaimasinenkinhosyoukikan) {
        ztykaimasinenkinhosyoukikan = pZtykaimasinenkinhosyoukikan;
    }

    private String ztykaimasinkhhknsyaage;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINKHHKNSYAAGE)
    public String getZtykaimasinkhhknsyaage() {
        return ztykaimasinkhhknsyaage;
    }

    public void setZtykaimasinkhhknsyaage(String pZtykaimasinkhhknsyaage) {
        ztykaimasinkhhknsyaage = pZtykaimasinkhhknsyaage;
    }

    private String ztykimsnkdai2hhknsyaage;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKIMSNKDAI2HHKNSYAAGE)
    public String getZtykimsnkdai2hhknsyaage() {
        return ztykimsnkdai2hhknsyaage;
    }

    public void setZtykimsnkdai2hhknsyaage(String pZtykimsnkdai2hhknsyaage) {
        ztykimsnkdai2hhknsyaage = pZtykimsnkdai2hhknsyaage;
    }

    private String ztysaisyuunenkinkaimasiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYSAISYUUNENKINKAIMASIYMD)
    public String getZtysaisyuunenkinkaimasiymd() {
        return ztysaisyuunenkinkaimasiymd;
    }

    public void setZtysaisyuunenkinkaimasiymd(String pZtysaisyuunenkinkaimasiymd) {
        ztysaisyuunenkinkaimasiymd = pZtysaisyuunenkinkaimasiymd;
    }

    private Long ztykaimasinenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINENKINGAKU)
    public Long getZtykaimasinenkingaku() {
        return ztykaimasinenkingaku;
    }

    public void setZtykaimasinenkingaku(Long pZtykaimasinenkingaku) {
        ztykaimasinenkingaku = pZtykaimasinenkingaku;
    }

    private Long ztyzennendokaimasinkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZENNENDOKAIMASINKGK)
    public Long getZtyzennendokaimasinkgk() {
        return ztyzennendokaimasinkgk;
    }

    public void setZtyzennendokaimasinkgk(Long pZtyzennendokaimasinkgk) {
        ztyzennendokaimasinkgk = pZtyzennendokaimasinkgk;
    }

    private Long ztyznznnndkaimasinkzougk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZNZNNNDKAIMASINKZOUGK)
    public Long getZtyznznnndkaimasinkzougk() {
        return ztyznznnndkaimasinkzougk;
    }

    public void setZtyznznnndkaimasinkzougk(Long pZtyznznnndkaimasinkzougk) {
        ztyznznnndkaimasinkzougk = pZtyznznnndkaimasinkzougk;
    }

    private Long ztyznznznnndkaimasinkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZNZNZNNNDKAIMASINKGK)
    public Long getZtyznznznnndkaimasinkgk() {
        return ztyznznznnndkaimasinkgk;
    }

    public void setZtyznznznnndkaimasinkgk(Long pZtyznznznnndkaimasinkgk) {
        ztyznznznnndkaimasinkgk = pZtyznznznnndkaimasinkgk;
    }

    private Long ztytounendokaimasinenkind;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUNENDOKAIMASINENKIND)
    public Long getZtytounendokaimasinenkind() {
        return ztytounendokaimasinenkind;
    }

    public void setZtytounendokaimasinenkind(Long pZtytounendokaimasinenkind) {
        ztytounendokaimasinenkind = pZtytounendokaimasinenkind;
    }

    private String ztykaimasityuusiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASITYUUSIYMD)
    public String getZtykaimasityuusiymd() {
        return ztykaimasityuusiymd;
    }

    public void setZtykaimasityuusiymd(String pZtykaimasityuusiymd) {
        ztykaimasityuusiymd = pZtykaimasityuusiymd;
    }

    private String ztykaimasihukkiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASIHUKKIYMD)
    public String getZtykaimasihukkiymd() {
        return ztykaimasihukkiymd;
    }

    public void setZtykaimasihukkiymd(String pZtykaimasihukkiymd) {
        ztykaimasihukkiymd = pZtykaimasihukkiymd;
    }

    private String ztykaimasinkkigousdkbn;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYKAIMASINKKIGOUSDKBN)
    public String getZtykaimasinkkigousdkbn() {
        return ztykaimasinkkigousdkbn;
    }

    public void setZtykaimasinkkigousdkbn(String pZtykaimasinkkigousdkbn) {
        ztykaimasinkkigousdkbn = pZtykaimasinkkigousdkbn;
    }

    private String ztymaeatuatoatukouryokusymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYMAEATUATOATUKOURYOKUSYMD)
    public String getZtymaeatuatoatukouryokusymd() {
        return ztymaeatuatoatukouryokusymd;
    }

    public void setZtymaeatuatoatukouryokusymd(String pZtymaeatuatoatukouryokusymd) {
        ztymaeatuatoatukouryokusymd = pZtymaeatuatoatukouryokusymd;
    }

    private String ztymaeatuatoatukikan;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYMAEATUATOATUKIKAN)
    public String getZtymaeatuatoatukikan() {
        return ztymaeatuatoatukikan;
    }

    public void setZtymaeatuatoatukikan(String pZtymaeatuatoatukikan) {
        ztymaeatuatoatukikan = pZtymaeatuatoatukikan;
    }

    private Long ztymaeatuatoatuhendougonkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYMAEATUATOATUHENDOUGONKGK)
    public Long getZtymaeatuatoatuhendougonkgk() {
        return ztymaeatuatoatuhendougonkgk;
    }

    public void setZtymaeatuatoatuhendougonkgk(Long pZtymaeatuatoatuhendougonkgk) {
        ztymaeatuatoatuhendougonkgk = pZtymaeatuatoatuhendougonkgk;
    }

    private String ztyatoatusaisyuukaimasiymd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYATOATUSAISYUUKAIMASIYMD)
    public String getZtyatoatusaisyuukaimasiymd() {
        return ztyatoatusaisyuukaimasiymd;
    }

    public void setZtyatoatusaisyuukaimasiymd(String pZtyatoatusaisyuukaimasiymd) {
        ztyatoatusaisyuukaimasiymd = pZtyatoatusaisyuukaimasiymd;
    }

    private Long ztyatoatukaimasinenkingaku;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYATOATUKAIMASINENKINGAKU)
    public Long getZtyatoatukaimasinenkingaku() {
        return ztyatoatukaimasinenkingaku;
    }

    public void setZtyatoatukaimasinenkingaku(Long pZtyatoatukaimasinenkingaku) {
        ztyatoatukaimasinenkingaku = pZtyatoatukaimasinenkingaku;
    }

    private Long ztyznnndatoatukaimasinkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZNNNDATOATUKAIMASINKGK)
    public Long getZtyznnndatoatukaimasinkgk() {
        return ztyznnndatoatukaimasinkgk;
    }

    public void setZtyznnndatoatukaimasinkgk(Long pZtyznnndatoatukaimasinkgk) {
        ztyznnndatoatukaimasinkgk = pZtyznnndatoatukaimasinkgk;
    }

    private Long ztyznznnndatoatukaimasinkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZNZNNNDATOATUKAIMASINKGK)
    public Long getZtyznznnndatoatukaimasinkgk() {
        return ztyznznnndatoatukaimasinkgk;
    }

    public void setZtyznznnndatoatukaimasinkgk(Long pZtyznznnndatoatukaimasinkgk) {
        ztyznznnndatoatukaimasinkgk = pZtyznznnndatoatukaimasinkgk;
    }

    private Long ztyznznznnndatatkimsnkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYZNZNZNNNDATATKIMSNKGK)
    public Long getZtyznznznnndatatkimsnkgk() {
        return ztyznznznnndatatkimsnkgk;
    }

    public void setZtyznznznnndatatkimsnkgk(Long pZtyznznznnndatatkimsnkgk) {
        ztyznznznnndatatkimsnkgk = pZtyznznznnndatatkimsnkgk;
    }

    private Long ztytounendatoatukaimasinkd;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYTOUNENDATOATUKAIMASINKD)
    public Long getZtytounendatoatukaimasinkd() {
        return ztytounendatoatukaimasinkd;
    }

    public void setZtytounendatoatukaimasinkd(Long pZtytounendatoatukaimasinkd) {
        ztytounendatoatukaimasinkd = pZtytounendatoatukaimasinkd;
    }

    private Long ztyuwanoseatoatukaimasinkgk;

    @Column(name=GenZT_NkToukeiKtyTy.ZTYUWANOSEATOATUKAIMASINKGK)
    public Long getZtyuwanoseatoatukaimasinkgk() {
        return ztyuwanoseatoatukaimasinkgk;
    }

    public void setZtyuwanoseatoatukaimasinkgk(Long pZtyuwanoseatoatukaimasinkgk) {
        ztyuwanoseatoatukaimasinkgk = pZtyuwanoseatoatukaimasinkgk;
    }
}
