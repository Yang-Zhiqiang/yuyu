package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_AlmNnknHyuRn;
import yuyu.def.db.id.PKZT_AlmNnknHyuRn;
import yuyu.def.db.meta.GenQZT_AlmNnknHyuRn;
import yuyu.def.db.meta.QZT_AlmNnknHyuRn;

/**
 * ＡＬＭ用年金保有明細テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_AlmNnknHyuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AlmNnknHyuRn}</td><td colspan="3">ＡＬＭ用年金保有明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">{@link PKZT_AlmNnknHyuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn zrnnksyuruikbn}</td><td>（連携用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkknsetymd zrnkknsetymd}</td><td>（連携用）基金設定日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokainenkinsiharaiymd zrnsyokainenkinsiharaiymd}</td><td>（連携用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinhosyoukikan zrnnenkinhosyoukikan}</td><td>（連携用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhnnkgk zrnkhnnkgk}</td><td>（連携用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujikihonnenkingaku zrnkeiyakujikihonnenkingaku}</td><td>（連携用）契約時基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkasannkgk zrnkasannkgk}</td><td>（連携用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnewmoneynenkingaku zrnnewmoneynenkingaku}</td><td>（連携用）ニューマネー年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntenkanitijibarainkgk zrntenkanitijibarainkgk}</td><td>（連携用）転換一時払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbratamakinnkgk zrnitibitjbratamakinnkgk}</td><td>（連携用）一部一時払頭金年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrtyuutohknkgk zrnitibitjbrtyuutohknkgk}</td><td>（連携用）一部一時払中途付加年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisijigensi zrnnenkinkaisijigensi}</td><td>（連携用）年金開始時原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnewmoneygaku zrnnewmoneygaku}</td><td>（連携用）ニューマネー額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnewmoneybubunnenkingensi zrnnewmoneybubunnenkingensi}</td><td>（連携用）ニューマネー部分年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhitenkankeiyakukykymd zrnhitenkankeiyakukykymd}</td><td>（連携用）被転換契約契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrtyuutohkymd zrnitibitjbrtyuutohkymd}</td><td>（連携用）一部一時払中途付加日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpitijibaraihyouji zrnpitijibaraihyouji}</td><td>（連携用）Ｐ一時払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuarihyouji zrntokuyakuarihyouji}</td><td>（連携用）特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksgoyoteisibouritukbn zrnnksgoyoteisibouritukbn}</td><td>（連携用）年金開始後予定死亡率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinjimutesuuryoukbn zrnnenkinjimutesuuryoukbn}</td><td>（連携用）年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatukbn zrnmaeatuatoatukbn}</td><td>（連携用）前厚後厚区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteizounksiboujihknnendo zrnteizounksiboujihknnendo}</td><td>（連携用）逓増年金死亡時保険年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjihihokensyaage zrnnksjihihokensyaage}</td><td>（連携用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyaseibetukbn zrndai2hihokensyaseibetukbn}</td><td>（連携用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksjidai2hhknsyaage zrnnksjidai2hhknsyaage}</td><td>（連携用）年金開始時第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjgyunendosikitoutatuage zrnjgyunendosikitoutatuage}</td><td>（連携用）事業年度式到達年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijikinsiharaiymd zrnitijikinsiharaiymd}</td><td>（連携用）一時金支払日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyasibouymd zrnhihokensyasibouymd}</td><td>（連携用）被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyasibouymd zrndai2hihokensyasibouymd}</td><td>（連携用）第２被保険者死亡年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteii zrnyoteii}</td><td>（連携用）予定ｉ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibouhyoukbn zrnsibouhyoukbn}</td><td>（連携用）死亡表区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndnendo zrndnendo}</td><td>（連携用）Ｄ年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntounendod zrntounendod}</td><td>（連携用）当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnktouduketorihouhoukbn zrnnktouduketorihouhoukbn}</td><td>（連携用）年金当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitated zrntumitated}</td><td>（連携用）積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyouikunenkinarihyouji zrnyouikunenkinarihyouji}</td><td>（連携用）養育年金有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalmnenkinsyoumetucd zrnalmnenkinsyoumetucd}</td><td>（連携用）ＡＬＭ年金消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinarihyouji zrnkaimasinenkinarihyouji}</td><td>（連携用）買増年金有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkkouryokusymd zrnkaimasinkkouryokusymd}</td><td>（連携用）買増年金効力開始日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinkbn zrnkaimasinenkinkbn}</td><td>（連携用）買増年金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinsyuruikigou zrnkaimasinenkinsyuruikigou}</td><td>（連携用）買増年金種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkshrkkn zrnkaimasinkshrkkn}</td><td>（連携用）買増年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinhosyoukikan zrnkaimasinenkinhosyoukikan}</td><td>（連携用）買増年金保証期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkhhknsyaage zrnkaimasinkhhknsyaage}</td><td>（連携用）買増年金被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkimsnkdai2hhknsyaage zrnkimsnkdai2hhknsyaage}</td><td>（連携用）買増年金第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuukousinymd zrnsaisyuukousinymd}</td><td>（連携用）最終更新日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkingaku zrnkaimasinenkingaku}</td><td>（連携用）買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennendokaimasinkgk zrnzennendokaimasinkgk}</td><td>（連携用）前年度買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendokaimasinenkind zrntounendokaimasinenkind}</td><td>（連携用）当年度買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatukouryokusymd zrnmaeatuatoatukouryokusymd}</td><td>（連携用）前厚後厚効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatukikan zrnmaeatuatoatukikan}</td><td>（連携用）前厚後厚期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaeatuatoatuhendougonkgk zrnmaeatuatoatuhendougonkgk}</td><td>（連携用）前厚後厚変動後年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnatoatusaisyuukaimasiymd zrnatoatusaisyuukaimasiymd}</td><td>（連携用）後厚最終買増日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatoatukaimasinenkingaku zrnatoatukaimasinenkingaku}</td><td>（連携用）後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnznnndatoatukaimasinkgk zrnznnndatoatukaimasinkgk}</td><td>（連携用）前年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendatoatukaimasinkd zrntounendatoatukaimasinkd}</td><td>（連携用）当年度後厚買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnuwanoseatoatukaimasinkgk zrnuwanoseatoatukaimasinkgk}</td><td>（連携用）上乗せ後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkuktorininhhknsyadouhyj zrnnkuktorininhhknsyadouhyj}</td><td>（連携用）年金受取人被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuktrnndi2hhknsyadouhyj zrnnkuktrnndi2hhknsyadouhyj}</td><td>（連携用）年金受取人第２被保険者同表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuketorininsakuinnmno zrnnkuketorininsakuinnmno}</td><td>（連携用）年金受取人索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtenkanritodoufukencd zrndrtenkanritodoufukencd}</td><td>（連携用）代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairiten1sosikicd zrndairiten1sosikicd}</td><td>（連携用）代理店１組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin1cd zrnbosyuunin1cd}</td><td>（連携用）募集人１コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin1keisyousisyacd zrnbosyuunin1keisyousisyacd}</td><td>（連携用）募集人１継承支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin1zaisekihyouji zrnbosyuunin1zaisekihyouji}</td><td>（連携用）募集人１在籍表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin1bosyuujiage zrnbosyuunin1bosyuujiage}</td><td>（連携用）募集人１募集時年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyunin1bosyujisikakucd zrnbosyunin1bosyujisikakucd}</td><td>（連携用）募集人１募集時資格コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunin1sikakucd zrnbosyuunin1sikakucd}</td><td>（連携用）募集人１資格コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkknmanryouymd zrnnkkknmanryouymd}</td><td>（連携用）年金期間満了日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaimasinkkigousdkbn zrnkaimasinkkigousdkbn}</td><td>（連携用）買増年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalmrrthendounkyoteirrt zrnalmrrthendounkyoteirrt}</td><td>（連携用）ＡＬＭ利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnalmrrthendounksitihsyrrt zrnalmrrthendounksitihsyrrt}</td><td>（連携用）ＡＬＭ利率変動年金最低保証利率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkansanp zrnnenkansanp}</td><td>（連携用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv30 zrnyobiv30}</td><td>（連携用）予備項目Ｖ３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x3 zrnyobiv8x3}</td><td>（連携用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x4 zrnyobiv8x4}</td><td>（連携用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_AlmNnknHyuRn
 * @see     PKZT_AlmNnknHyuRn
 * @see     QZT_AlmNnknHyuRn
 * @see     GenQZT_AlmNnknHyuRn
 */
@MappedSuperclass
@Table(name=GenZT_AlmNnknHyuRn.TABLE_NAME)
@IdClass(value=PKZT_AlmNnknHyuRn.class)
public abstract class GenZT_AlmNnknHyuRn extends AbstractExDBEntityForZDB<ZT_AlmNnknHyuRn, PKZT_AlmNnknHyuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_AlmNnknHyuRn";
    public static final String ZRNNKSYOUSYONO           = "zrnnksyousyono";
    public static final String ZRNNKSYURUIKBN           = "zrnnksyuruikbn";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNKKNSETYMD             = "zrnkknsetymd";
    public static final String ZRNSYOKAINENKINSIHARAIYMD = "zrnsyokainenkinsiharaiymd";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNENKINHOSYOUKIKAN     = "zrnnenkinhosyoukikan";
    public static final String ZRNKHNNKGK               = "zrnkhnnkgk";
    public static final String ZRNKEIYAKUJIKIHONNENKINGAKU = "zrnkeiyakujikihonnenkingaku";
    public static final String ZRNKASANNKGK             = "zrnkasannkgk";
    public static final String ZRNNEWMONEYNENKINGAKU    = "zrnnewmoneynenkingaku";
    public static final String ZRNTENKANITIJIBARAINKGK  = "zrntenkanitijibarainkgk";
    public static final String ZRNITIBITJBRATAMAKINNKGK = "zrnitibitjbratamakinnkgk";
    public static final String ZRNITIBITJBRTYUUTOHKNKGK = "zrnitibitjbrtyuutohknkgk";
    public static final String ZRNNENKINKAISIJIGENSI    = "zrnnenkinkaisijigensi";
    public static final String ZRNNEWMONEYGAKU          = "zrnnewmoneygaku";
    public static final String ZRNNEWMONEYBUBUNNENKINGENSI = "zrnnewmoneybubunnenkingensi";
    public static final String ZRNHITENKANKEIYAKUKYKYMD = "zrnhitenkankeiyakukykymd";
    public static final String ZRNITIBITJBRTYUUTOHKYMD  = "zrnitibitjbrtyuutohkymd";
    public static final String ZRNPITIJIBARAIHYOUJI     = "zrnpitijibaraihyouji";
    public static final String ZRNTOKUYAKUARIHYOUJI     = "zrntokuyakuarihyouji";
    public static final String ZRNNKKAISIGOYOTEIRIRITUKBN = "zrnnkkaisigoyoteiriritukbn";
    public static final String ZRNNKSGOYOTEISIBOURITUKBN = "zrnnksgoyoteisibouritukbn";
    public static final String ZRNNENKINJIMUTESUURYOUKBN = "zrnnenkinjimutesuuryoukbn";
    public static final String ZRNMAEATUATOATUKBN       = "zrnmaeatuatoatukbn";
    public static final String ZRNTEIZOUNKSIBOUJIHKNNENDO = "zrnteizounksiboujihknnendo";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNNKSJIHIHOKENSYAAGE    = "zrnnksjihihokensyaage";
    public static final String ZRNDAI2HIHOKENSYASEIBETUKBN = "zrndai2hihokensyaseibetukbn";
    public static final String ZRNNKSJIDAI2HHKNSYAAGE   = "zrnnksjidai2hhknsyaage";
    public static final String ZRNJGYUNENDOSIKITOUTATUAGE = "zrnjgyunendosikitoutatuage";
    public static final String ZRNITIJIKINSIHARAIYMD    = "zrnitijikinsiharaiymd";
    public static final String ZRNHIHOKENSYASIBOUYMD    = "zrnhihokensyasibouymd";
    public static final String ZRNDAI2HIHOKENSYASIBOUYMD = "zrndai2hihokensyasibouymd";
    public static final String ZRNYOTEII                = "zrnyoteii";
    public static final String ZRNSIBOUHYOUKBN          = "zrnsibouhyoukbn";
    public static final String ZRNDNENDO                = "zrndnendo";
    public static final String ZRNTOUNENDOD             = "zrntounendod";
    public static final String ZRNNKTOUDUKETORIHOUHOUKBN = "zrnnktouduketorihouhoukbn";
    public static final String ZRNTUMITATED             = "zrntumitated";
    public static final String ZRNYOUIKUNENKINARIHYOUJI = "zrnyouikunenkinarihyouji";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNALMNENKINSYOUMETUCD   = "zrnalmnenkinsyoumetucd";
    public static final String ZRNKAIMASINENKINARIHYOUJI = "zrnkaimasinenkinarihyouji";
    public static final String ZRNKAIMASINKKOURYOKUSYMD = "zrnkaimasinkkouryokusymd";
    public static final String ZRNKAIMASINENKINKBN      = "zrnkaimasinenkinkbn";
    public static final String ZRNKAIMASINENKINSYURUIKIGOU = "zrnkaimasinenkinsyuruikigou";
    public static final String ZRNKAIMASINKSHRKKN       = "zrnkaimasinkshrkkn";
    public static final String ZRNKAIMASINENKINHOSYOUKIKAN = "zrnkaimasinenkinhosyoukikan";
    public static final String ZRNKAIMASINKHHKNSYAAGE   = "zrnkaimasinkhhknsyaage";
    public static final String ZRNKIMSNKDAI2HHKNSYAAGE  = "zrnkimsnkdai2hhknsyaage";
    public static final String ZRNSAISYUUKOUSINYMD      = "zrnsaisyuukousinymd";
    public static final String ZRNKAIMASINENKINGAKU     = "zrnkaimasinenkingaku";
    public static final String ZRNZENNENDOKAIMASINKGK   = "zrnzennendokaimasinkgk";
    public static final String ZRNTOUNENDOKAIMASINENKIND = "zrntounendokaimasinenkind";
    public static final String ZRNMAEATUATOATUKOURYOKUSYMD = "zrnmaeatuatoatukouryokusymd";
    public static final String ZRNMAEATUATOATUKIKAN     = "zrnmaeatuatoatukikan";
    public static final String ZRNMAEATUATOATUHENDOUGONKGK = "zrnmaeatuatoatuhendougonkgk";
    public static final String ZRNATOATUSAISYUUKAIMASIYMD = "zrnatoatusaisyuukaimasiymd";
    public static final String ZRNATOATUKAIMASINENKINGAKU = "zrnatoatukaimasinenkingaku";
    public static final String ZRNZNNNDATOATUKAIMASINKGK = "zrnznnndatoatukaimasinkgk";
    public static final String ZRNTOUNENDATOATUKAIMASINKD = "zrntounendatoatukaimasinkd";
    public static final String ZRNUWANOSEATOATUKAIMASINKGK = "zrnuwanoseatoatukaimasinkgk";
    public static final String ZRNNKUKTORININHHKNSYADOUHYJ = "zrnnkuktorininhhknsyadouhyj";
    public static final String ZRNNKUKTRNNDI2HHKNSYADOUHYJ = "zrnnkuktrnndi2hhknsyadouhyj";
    public static final String ZRNNKUKETORININSAKUINNMNO = "zrnnkuketorininsakuinnmno";
    public static final String ZRNDRTENKANRITODOUFUKENCD = "zrndrtenkanritodoufukencd";
    public static final String ZRNDAIRITEN1SOSIKICD     = "zrndairiten1sosikicd";
    public static final String ZRNBOSYUUNIN1CD          = "zrnbosyuunin1cd";
    public static final String ZRNBOSYUUNIN1KEISYOUSISYACD = "zrnbosyuunin1keisyousisyacd";
    public static final String ZRNBOSYUUNIN1ZAISEKIHYOUJI = "zrnbosyuunin1zaisekihyouji";
    public static final String ZRNBOSYUUNIN1BOSYUUJIAGE = "zrnbosyuunin1bosyuujiage";
    public static final String ZRNBOSYUNIN1BOSYUJISIKAKUCD = "zrnbosyunin1bosyujisikakucd";
    public static final String ZRNBOSYUUNIN1SIKAKUCD    = "zrnbosyuunin1sikakucd";
    public static final String ZRNNKKKNMANRYOUYMD       = "zrnnkkknmanryouymd";
    public static final String ZRNKIJYUNYM              = "zrnkijyunym";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNKAIMASINKKIGOUSDKBN   = "zrnkaimasinkkigousdkbn";
    public static final String ZRNALMRRTHENDOUNKYOTEIRRT = "zrnalmrrthendounkyoteirrt";
    public static final String ZRNALMRRTHENDOUNKSITIHSYRRT = "zrnalmrrthendounksitihsyrrt";
    public static final String ZRNNENKANSANP            = "zrnnenkansanp";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNYOBIV30               = "zrnyobiv30";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNYOBIV8X3              = "zrnyobiv8x3";
    public static final String ZRNYOBIV8X4              = "zrnyobiv8x4";

    private final PKZT_AlmNnknHyuRn primaryKey;

    public GenZT_AlmNnknHyuRn() {
        primaryKey = new PKZT_AlmNnknHyuRn();
    }

    public GenZT_AlmNnknHyuRn(String pZrnnksyousyono) {
        primaryKey = new PKZT_AlmNnknHyuRn(pZrnnksyousyono);
    }

    @Transient
    @Override
    public PKZT_AlmNnknHyuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_AlmNnknHyuRn> getMetaClass() {
        return QZT_AlmNnknHyuRn.class;
    }

    @Id
    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKSYOUSYONO)
    public String getZrnnksyousyono() {
        return getPrimaryKey().getZrnnksyousyono();
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        getPrimaryKey().setZrnnksyousyono(pZrnnksyousyono);
    }

    private String zrnnksyuruikbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKSYURUIKBN)
    public String getZrnnksyuruikbn() {
        return zrnnksyuruikbn;
    }

    public void setZrnnksyuruikbn(String pZrnnksyuruikbn) {
        zrnnksyuruikbn = pZrnnksyuruikbn;
    }

    private String zrnnenkinkbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return zrnnenkinkbn;
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        zrnnenkinkbn = pZrnnenkinkbn;
    }

    private String zrnnenkinsyu;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return zrnnenkinsyu;
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        zrnnenkinsyu = pZrnnenkinsyu;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnkknsetymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKKNSETYMD)
    public String getZrnkknsetymd() {
        return zrnkknsetymd;
    }

    public void setZrnkknsetymd(String pZrnkknsetymd) {
        zrnkknsetymd = pZrnkknsetymd;
    }

    private String zrnsyokainenkinsiharaiymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNSYOKAINENKINSIHARAIYMD)
    public String getZrnsyokainenkinsiharaiymd() {
        return zrnsyokainenkinsiharaiymd;
    }

    public void setZrnsyokainenkinsiharaiymd(String pZrnsyokainenkinsiharaiymd) {
        zrnsyokainenkinsiharaiymd = pZrnsyokainenkinsiharaiymd;
    }

    private String zrnnknshry;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnnenkinhosyoukikan;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKINHOSYOUKIKAN)
    public String getZrnnenkinhosyoukikan() {
        return zrnnenkinhosyoukikan;
    }

    public void setZrnnenkinhosyoukikan(String pZrnnenkinhosyoukikan) {
        zrnnenkinhosyoukikan = pZrnnenkinhosyoukikan;
    }

    private Long zrnkhnnkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKHNNKGK)
    public Long getZrnkhnnkgk() {
        return zrnkhnnkgk;
    }

    public void setZrnkhnnkgk(Long pZrnkhnnkgk) {
        zrnkhnnkgk = pZrnkhnnkgk;
    }

    private Long zrnkeiyakujikihonnenkingaku;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKEIYAKUJIKIHONNENKINGAKU)
    public Long getZrnkeiyakujikihonnenkingaku() {
        return zrnkeiyakujikihonnenkingaku;
    }

    public void setZrnkeiyakujikihonnenkingaku(Long pZrnkeiyakujikihonnenkingaku) {
        zrnkeiyakujikihonnenkingaku = pZrnkeiyakujikihonnenkingaku;
    }

    private Long zrnkasannkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKASANNKGK)
    public Long getZrnkasannkgk() {
        return zrnkasannkgk;
    }

    public void setZrnkasannkgk(Long pZrnkasannkgk) {
        zrnkasannkgk = pZrnkasannkgk;
    }

    private Long zrnnewmoneynenkingaku;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNEWMONEYNENKINGAKU)
    public Long getZrnnewmoneynenkingaku() {
        return zrnnewmoneynenkingaku;
    }

    public void setZrnnewmoneynenkingaku(Long pZrnnewmoneynenkingaku) {
        zrnnewmoneynenkingaku = pZrnnewmoneynenkingaku;
    }

    private Long zrntenkanitijibarainkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTENKANITIJIBARAINKGK)
    public Long getZrntenkanitijibarainkgk() {
        return zrntenkanitijibarainkgk;
    }

    public void setZrntenkanitijibarainkgk(Long pZrntenkanitijibarainkgk) {
        zrntenkanitijibarainkgk = pZrntenkanitijibarainkgk;
    }

    private Long zrnitibitjbratamakinnkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNITIBITJBRATAMAKINNKGK)
    public Long getZrnitibitjbratamakinnkgk() {
        return zrnitibitjbratamakinnkgk;
    }

    public void setZrnitibitjbratamakinnkgk(Long pZrnitibitjbratamakinnkgk) {
        zrnitibitjbratamakinnkgk = pZrnitibitjbratamakinnkgk;
    }

    private Long zrnitibitjbrtyuutohknkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNITIBITJBRTYUUTOHKNKGK)
    public Long getZrnitibitjbrtyuutohknkgk() {
        return zrnitibitjbrtyuutohknkgk;
    }

    public void setZrnitibitjbrtyuutohknkgk(Long pZrnitibitjbrtyuutohknkgk) {
        zrnitibitjbrtyuutohknkgk = pZrnitibitjbrtyuutohknkgk;
    }

    private Long zrnnenkinkaisijigensi;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKINKAISIJIGENSI)
    public Long getZrnnenkinkaisijigensi() {
        return zrnnenkinkaisijigensi;
    }

    public void setZrnnenkinkaisijigensi(Long pZrnnenkinkaisijigensi) {
        zrnnenkinkaisijigensi = pZrnnenkinkaisijigensi;
    }

    private Long zrnnewmoneygaku;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNEWMONEYGAKU)
    public Long getZrnnewmoneygaku() {
        return zrnnewmoneygaku;
    }

    public void setZrnnewmoneygaku(Long pZrnnewmoneygaku) {
        zrnnewmoneygaku = pZrnnewmoneygaku;
    }

    private Long zrnnewmoneybubunnenkingensi;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNEWMONEYBUBUNNENKINGENSI)
    public Long getZrnnewmoneybubunnenkingensi() {
        return zrnnewmoneybubunnenkingensi;
    }

    public void setZrnnewmoneybubunnenkingensi(Long pZrnnewmoneybubunnenkingensi) {
        zrnnewmoneybubunnenkingensi = pZrnnewmoneybubunnenkingensi;
    }

    private String zrnhitenkankeiyakukykymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNHITENKANKEIYAKUKYKYMD)
    public String getZrnhitenkankeiyakukykymd() {
        return zrnhitenkankeiyakukykymd;
    }

    public void setZrnhitenkankeiyakukykymd(String pZrnhitenkankeiyakukykymd) {
        zrnhitenkankeiyakukykymd = pZrnhitenkankeiyakukykymd;
    }

    private String zrnitibitjbrtyuutohkymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNITIBITJBRTYUUTOHKYMD)
    public String getZrnitibitjbrtyuutohkymd() {
        return zrnitibitjbrtyuutohkymd;
    }

    public void setZrnitibitjbrtyuutohkymd(String pZrnitibitjbrtyuutohkymd) {
        zrnitibitjbrtyuutohkymd = pZrnitibitjbrtyuutohkymd;
    }

    private String zrnpitijibaraihyouji;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNPITIJIBARAIHYOUJI)
    public String getZrnpitijibaraihyouji() {
        return zrnpitijibaraihyouji;
    }

    public void setZrnpitijibaraihyouji(String pZrnpitijibaraihyouji) {
        zrnpitijibaraihyouji = pZrnpitijibaraihyouji;
    }

    private String zrntokuyakuarihyouji;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTOKUYAKUARIHYOUJI)
    public String getZrntokuyakuarihyouji() {
        return zrntokuyakuarihyouji;
    }

    public void setZrntokuyakuarihyouji(String pZrntokuyakuarihyouji) {
        zrntokuyakuarihyouji = pZrntokuyakuarihyouji;
    }

    private String zrnnkkaisigoyoteiriritukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKKAISIGOYOTEIRIRITUKBN)
    public String getZrnnkkaisigoyoteiriritukbn() {
        return zrnnkkaisigoyoteiriritukbn;
    }

    public void setZrnnkkaisigoyoteiriritukbn(String pZrnnkkaisigoyoteiriritukbn) {
        zrnnkkaisigoyoteiriritukbn = pZrnnkkaisigoyoteiriritukbn;
    }

    private String zrnnksgoyoteisibouritukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKSGOYOTEISIBOURITUKBN)
    public String getZrnnksgoyoteisibouritukbn() {
        return zrnnksgoyoteisibouritukbn;
    }

    public void setZrnnksgoyoteisibouritukbn(String pZrnnksgoyoteisibouritukbn) {
        zrnnksgoyoteisibouritukbn = pZrnnksgoyoteisibouritukbn;
    }

    private String zrnnenkinjimutesuuryoukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKINJIMUTESUURYOUKBN)
    public String getZrnnenkinjimutesuuryoukbn() {
        return zrnnenkinjimutesuuryoukbn;
    }

    public void setZrnnenkinjimutesuuryoukbn(String pZrnnenkinjimutesuuryoukbn) {
        zrnnenkinjimutesuuryoukbn = pZrnnenkinjimutesuuryoukbn;
    }

    private String zrnmaeatuatoatukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNMAEATUATOATUKBN)
    public String getZrnmaeatuatoatukbn() {
        return zrnmaeatuatoatukbn;
    }

    public void setZrnmaeatuatoatukbn(String pZrnmaeatuatoatukbn) {
        zrnmaeatuatoatukbn = pZrnmaeatuatoatukbn;
    }

    private String zrnteizounksiboujihknnendo;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTEIZOUNKSIBOUJIHKNNENDO)
    public String getZrnteizounksiboujihknnendo() {
        return zrnteizounksiboujihknnendo;
    }

    public void setZrnteizounksiboujihknnendo(String pZrnteizounksiboujihknnendo) {
        zrnteizounksiboujihknnendo = pZrnteizounksiboujihknnendo;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnnksjihihokensyaage;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKSJIHIHOKENSYAAGE)
    public String getZrnnksjihihokensyaage() {
        return zrnnksjihihokensyaage;
    }

    public void setZrnnksjihihokensyaage(String pZrnnksjihihokensyaage) {
        zrnnksjihihokensyaage = pZrnnksjihihokensyaage;
    }

    private String zrndai2hihokensyaseibetukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNDAI2HIHOKENSYASEIBETUKBN)
    public String getZrndai2hihokensyaseibetukbn() {
        return zrndai2hihokensyaseibetukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyaseibetukbn(String pZrndai2hihokensyaseibetukbn) {
        zrndai2hihokensyaseibetukbn = pZrndai2hihokensyaseibetukbn;
    }

    private String zrnnksjidai2hhknsyaage;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKSJIDAI2HHKNSYAAGE)
    public String getZrnnksjidai2hhknsyaage() {
        return zrnnksjidai2hhknsyaage;
    }

    public void setZrnnksjidai2hhknsyaage(String pZrnnksjidai2hhknsyaage) {
        zrnnksjidai2hhknsyaage = pZrnnksjidai2hhknsyaage;
    }

    private String zrnjgyunendosikitoutatuage;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNJGYUNENDOSIKITOUTATUAGE)
    public String getZrnjgyunendosikitoutatuage() {
        return zrnjgyunendosikitoutatuage;
    }

    public void setZrnjgyunendosikitoutatuage(String pZrnjgyunendosikitoutatuage) {
        zrnjgyunendosikitoutatuage = pZrnjgyunendosikitoutatuage;
    }

    private String zrnitijikinsiharaiymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNITIJIKINSIHARAIYMD)
    public String getZrnitijikinsiharaiymd() {
        return zrnitijikinsiharaiymd;
    }

    public void setZrnitijikinsiharaiymd(String pZrnitijikinsiharaiymd) {
        zrnitijikinsiharaiymd = pZrnitijikinsiharaiymd;
    }

    private String zrnhihokensyasibouymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNHIHOKENSYASIBOUYMD)
    public String getZrnhihokensyasibouymd() {
        return zrnhihokensyasibouymd;
    }

    public void setZrnhihokensyasibouymd(String pZrnhihokensyasibouymd) {
        zrnhihokensyasibouymd = pZrnhihokensyasibouymd;
    }

    private String zrndai2hihokensyasibouymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNDAI2HIHOKENSYASIBOUYMD)
    public String getZrndai2hihokensyasibouymd() {
        return zrndai2hihokensyasibouymd;
    }

    public void setZrndai2hihokensyasibouymd(String pZrndai2hihokensyasibouymd) {
        zrndai2hihokensyasibouymd = pZrndai2hihokensyasibouymd;
    }

    private String zrnyoteii;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOTEII)
    public String getZrnyoteii() {
        return zrnyoteii;
    }

    public void setZrnyoteii(String pZrnyoteii) {
        zrnyoteii = pZrnyoteii;
    }

    private String zrnsibouhyoukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNSIBOUHYOUKBN)
    public String getZrnsibouhyoukbn() {
        return zrnsibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsibouhyoukbn(String pZrnsibouhyoukbn) {
        zrnsibouhyoukbn = pZrnsibouhyoukbn;
    }

    private String zrndnendo;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNDNENDO)
    public String getZrndnendo() {
        return zrndnendo;
    }

    public void setZrndnendo(String pZrndnendo) {
        zrndnendo = pZrndnendo;
    }

    private Long zrntounendod;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTOUNENDOD)
    public Long getZrntounendod() {
        return zrntounendod;
    }

    public void setZrntounendod(Long pZrntounendod) {
        zrntounendod = pZrntounendod;
    }

    private String zrnnktouduketorihouhoukbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKTOUDUKETORIHOUHOUKBN)
    public String getZrnnktouduketorihouhoukbn() {
        return zrnnktouduketorihouhoukbn;
    }

    public void setZrnnktouduketorihouhoukbn(String pZrnnktouduketorihouhoukbn) {
        zrnnktouduketorihouhoukbn = pZrnnktouduketorihouhoukbn;
    }

    private Long zrntumitated;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTUMITATED)
    public Long getZrntumitated() {
        return zrntumitated;
    }

    public void setZrntumitated(Long pZrntumitated) {
        zrntumitated = pZrntumitated;
    }

    private String zrnyouikunenkinarihyouji;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOUIKUNENKINARIHYOUJI)
    public String getZrnyouikunenkinarihyouji() {
        return zrnyouikunenkinarihyouji;
    }

    public void setZrnyouikunenkinarihyouji(String pZrnyouikunenkinarihyouji) {
        zrnyouikunenkinarihyouji = pZrnyouikunenkinarihyouji;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnalmnenkinsyoumetucd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNALMNENKINSYOUMETUCD)
    public String getZrnalmnenkinsyoumetucd() {
        return zrnalmnenkinsyoumetucd;
    }

    public void setZrnalmnenkinsyoumetucd(String pZrnalmnenkinsyoumetucd) {
        zrnalmnenkinsyoumetucd = pZrnalmnenkinsyoumetucd;
    }

    private String zrnkaimasinenkinarihyouji;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINENKINARIHYOUJI)
    public String getZrnkaimasinenkinarihyouji() {
        return zrnkaimasinenkinarihyouji;
    }

    public void setZrnkaimasinenkinarihyouji(String pZrnkaimasinenkinarihyouji) {
        zrnkaimasinenkinarihyouji = pZrnkaimasinenkinarihyouji;
    }

    private String zrnkaimasinkkouryokusymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINKKOURYOKUSYMD)
    public String getZrnkaimasinkkouryokusymd() {
        return zrnkaimasinkkouryokusymd;
    }

    public void setZrnkaimasinkkouryokusymd(String pZrnkaimasinkkouryokusymd) {
        zrnkaimasinkkouryokusymd = pZrnkaimasinkkouryokusymd;
    }

    private String zrnkaimasinenkinkbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINENKINKBN)
    public String getZrnkaimasinenkinkbn() {
        return zrnkaimasinenkinkbn;
    }

    public void setZrnkaimasinenkinkbn(String pZrnkaimasinenkinkbn) {
        zrnkaimasinenkinkbn = pZrnkaimasinenkinkbn;
    }

    private String zrnkaimasinenkinsyuruikigou;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINENKINSYURUIKIGOU)
    public String getZrnkaimasinenkinsyuruikigou() {
        return zrnkaimasinenkinsyuruikigou;
    }

    public void setZrnkaimasinenkinsyuruikigou(String pZrnkaimasinenkinsyuruikigou) {
        zrnkaimasinenkinsyuruikigou = pZrnkaimasinenkinsyuruikigou;
    }

    private String zrnkaimasinkshrkkn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINKSHRKKN)
    public String getZrnkaimasinkshrkkn() {
        return zrnkaimasinkshrkkn;
    }

    public void setZrnkaimasinkshrkkn(String pZrnkaimasinkshrkkn) {
        zrnkaimasinkshrkkn = pZrnkaimasinkshrkkn;
    }

    private String zrnkaimasinenkinhosyoukikan;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINENKINHOSYOUKIKAN)
    public String getZrnkaimasinenkinhosyoukikan() {
        return zrnkaimasinenkinhosyoukikan;
    }

    public void setZrnkaimasinenkinhosyoukikan(String pZrnkaimasinenkinhosyoukikan) {
        zrnkaimasinenkinhosyoukikan = pZrnkaimasinenkinhosyoukikan;
    }

    private String zrnkaimasinkhhknsyaage;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINKHHKNSYAAGE)
    public String getZrnkaimasinkhhknsyaage() {
        return zrnkaimasinkhhknsyaage;
    }

    public void setZrnkaimasinkhhknsyaage(String pZrnkaimasinkhhknsyaage) {
        zrnkaimasinkhhknsyaage = pZrnkaimasinkhhknsyaage;
    }

    private String zrnkimsnkdai2hhknsyaage;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKIMSNKDAI2HHKNSYAAGE)
    public String getZrnkimsnkdai2hhknsyaage() {
        return zrnkimsnkdai2hhknsyaage;
    }

    public void setZrnkimsnkdai2hhknsyaage(String pZrnkimsnkdai2hhknsyaage) {
        zrnkimsnkdai2hhknsyaage = pZrnkimsnkdai2hhknsyaage;
    }

    private String zrnsaisyuukousinymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNSAISYUUKOUSINYMD)
    public String getZrnsaisyuukousinymd() {
        return zrnsaisyuukousinymd;
    }

    public void setZrnsaisyuukousinymd(String pZrnsaisyuukousinymd) {
        zrnsaisyuukousinymd = pZrnsaisyuukousinymd;
    }

    private Long zrnkaimasinenkingaku;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINENKINGAKU)
    public Long getZrnkaimasinenkingaku() {
        return zrnkaimasinenkingaku;
    }

    public void setZrnkaimasinenkingaku(Long pZrnkaimasinenkingaku) {
        zrnkaimasinenkingaku = pZrnkaimasinenkingaku;
    }

    private Long zrnzennendokaimasinkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNZENNENDOKAIMASINKGK)
    public Long getZrnzennendokaimasinkgk() {
        return zrnzennendokaimasinkgk;
    }

    public void setZrnzennendokaimasinkgk(Long pZrnzennendokaimasinkgk) {
        zrnzennendokaimasinkgk = pZrnzennendokaimasinkgk;
    }

    private Long zrntounendokaimasinenkind;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTOUNENDOKAIMASINENKIND)
    public Long getZrntounendokaimasinenkind() {
        return zrntounendokaimasinenkind;
    }

    public void setZrntounendokaimasinenkind(Long pZrntounendokaimasinenkind) {
        zrntounendokaimasinenkind = pZrntounendokaimasinenkind;
    }

    private String zrnmaeatuatoatukouryokusymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNMAEATUATOATUKOURYOKUSYMD)
    public String getZrnmaeatuatoatukouryokusymd() {
        return zrnmaeatuatoatukouryokusymd;
    }

    public void setZrnmaeatuatoatukouryokusymd(String pZrnmaeatuatoatukouryokusymd) {
        zrnmaeatuatoatukouryokusymd = pZrnmaeatuatoatukouryokusymd;
    }

    private String zrnmaeatuatoatukikan;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNMAEATUATOATUKIKAN)
    public String getZrnmaeatuatoatukikan() {
        return zrnmaeatuatoatukikan;
    }

    public void setZrnmaeatuatoatukikan(String pZrnmaeatuatoatukikan) {
        zrnmaeatuatoatukikan = pZrnmaeatuatoatukikan;
    }

    private Long zrnmaeatuatoatuhendougonkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNMAEATUATOATUHENDOUGONKGK)
    public Long getZrnmaeatuatoatuhendougonkgk() {
        return zrnmaeatuatoatuhendougonkgk;
    }

    public void setZrnmaeatuatoatuhendougonkgk(Long pZrnmaeatuatoatuhendougonkgk) {
        zrnmaeatuatoatuhendougonkgk = pZrnmaeatuatoatuhendougonkgk;
    }

    private String zrnatoatusaisyuukaimasiymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNATOATUSAISYUUKAIMASIYMD)
    public String getZrnatoatusaisyuukaimasiymd() {
        return zrnatoatusaisyuukaimasiymd;
    }

    public void setZrnatoatusaisyuukaimasiymd(String pZrnatoatusaisyuukaimasiymd) {
        zrnatoatusaisyuukaimasiymd = pZrnatoatusaisyuukaimasiymd;
    }

    private Long zrnatoatukaimasinenkingaku;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNATOATUKAIMASINENKINGAKU)
    public Long getZrnatoatukaimasinenkingaku() {
        return zrnatoatukaimasinenkingaku;
    }

    public void setZrnatoatukaimasinenkingaku(Long pZrnatoatukaimasinenkingaku) {
        zrnatoatukaimasinenkingaku = pZrnatoatukaimasinenkingaku;
    }

    private Long zrnznnndatoatukaimasinkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNZNNNDATOATUKAIMASINKGK)
    public Long getZrnznnndatoatukaimasinkgk() {
        return zrnznnndatoatukaimasinkgk;
    }

    public void setZrnznnndatoatukaimasinkgk(Long pZrnznnndatoatukaimasinkgk) {
        zrnznnndatoatukaimasinkgk = pZrnznnndatoatukaimasinkgk;
    }

    private Long zrntounendatoatukaimasinkd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNTOUNENDATOATUKAIMASINKD)
    public Long getZrntounendatoatukaimasinkd() {
        return zrntounendatoatukaimasinkd;
    }

    public void setZrntounendatoatukaimasinkd(Long pZrntounendatoatukaimasinkd) {
        zrntounendatoatukaimasinkd = pZrntounendatoatukaimasinkd;
    }

    private Long zrnuwanoseatoatukaimasinkgk;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNUWANOSEATOATUKAIMASINKGK)
    public Long getZrnuwanoseatoatukaimasinkgk() {
        return zrnuwanoseatoatukaimasinkgk;
    }

    public void setZrnuwanoseatoatukaimasinkgk(Long pZrnuwanoseatoatukaimasinkgk) {
        zrnuwanoseatoatukaimasinkgk = pZrnuwanoseatoatukaimasinkgk;
    }

    private String zrnnkuktorininhhknsyadouhyj;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKUKTORININHHKNSYADOUHYJ)
    public String getZrnnkuktorininhhknsyadouhyj() {
        return zrnnkuktorininhhknsyadouhyj;
    }

    public void setZrnnkuktorininhhknsyadouhyj(String pZrnnkuktorininhhknsyadouhyj) {
        zrnnkuktorininhhknsyadouhyj = pZrnnkuktorininhhknsyadouhyj;
    }

    private String zrnnkuktrnndi2hhknsyadouhyj;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKUKTRNNDI2HHKNSYADOUHYJ)
    public String getZrnnkuktrnndi2hhknsyadouhyj() {
        return zrnnkuktrnndi2hhknsyadouhyj;
    }

    public void setZrnnkuktrnndi2hhknsyadouhyj(String pZrnnkuktrnndi2hhknsyadouhyj) {
        zrnnkuktrnndi2hhknsyadouhyj = pZrnnkuktrnndi2hhknsyadouhyj;
    }

    private String zrnnkuketorininsakuinnmno;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKUKETORININSAKUINNMNO)
    public String getZrnnkuketorininsakuinnmno() {
        return zrnnkuketorininsakuinnmno;
    }

    public void setZrnnkuketorininsakuinnmno(String pZrnnkuketorininsakuinnmno) {
        zrnnkuketorininsakuinnmno = pZrnnkuketorininsakuinnmno;
    }

    private String zrndrtenkanritodoufukencd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNDRTENKANRITODOUFUKENCD)
    public String getZrndrtenkanritodoufukencd() {
        return zrndrtenkanritodoufukencd;
    }

    public void setZrndrtenkanritodoufukencd(String pZrndrtenkanritodoufukencd) {
        zrndrtenkanritodoufukencd = pZrndrtenkanritodoufukencd;
    }

    private String zrndairiten1sosikicd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNDAIRITEN1SOSIKICD)
    public String getZrndairiten1sosikicd() {
        return zrndairiten1sosikicd;
    }

    public void setZrndairiten1sosikicd(String pZrndairiten1sosikicd) {
        zrndairiten1sosikicd = pZrndairiten1sosikicd;
    }

    private String zrnbosyuunin1cd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUUNIN1CD)
    public String getZrnbosyuunin1cd() {
        return zrnbosyuunin1cd;
    }

    public void setZrnbosyuunin1cd(String pZrnbosyuunin1cd) {
        zrnbosyuunin1cd = pZrnbosyuunin1cd;
    }

    private String zrnbosyuunin1keisyousisyacd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUUNIN1KEISYOUSISYACD)
    public String getZrnbosyuunin1keisyousisyacd() {
        return zrnbosyuunin1keisyousisyacd;
    }

    public void setZrnbosyuunin1keisyousisyacd(String pZrnbosyuunin1keisyousisyacd) {
        zrnbosyuunin1keisyousisyacd = pZrnbosyuunin1keisyousisyacd;
    }

    private String zrnbosyuunin1zaisekihyouji;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUUNIN1ZAISEKIHYOUJI)
    public String getZrnbosyuunin1zaisekihyouji() {
        return zrnbosyuunin1zaisekihyouji;
    }

    public void setZrnbosyuunin1zaisekihyouji(String pZrnbosyuunin1zaisekihyouji) {
        zrnbosyuunin1zaisekihyouji = pZrnbosyuunin1zaisekihyouji;
    }

    private String zrnbosyuunin1bosyuujiage;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUUNIN1BOSYUUJIAGE)
    public String getZrnbosyuunin1bosyuujiage() {
        return zrnbosyuunin1bosyuujiage;
    }

    public void setZrnbosyuunin1bosyuujiage(String pZrnbosyuunin1bosyuujiage) {
        zrnbosyuunin1bosyuujiage = pZrnbosyuunin1bosyuujiage;
    }

    private String zrnbosyunin1bosyujisikakucd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUNIN1BOSYUJISIKAKUCD)
    public String getZrnbosyunin1bosyujisikakucd() {
        return zrnbosyunin1bosyujisikakucd;
    }

    public void setZrnbosyunin1bosyujisikakucd(String pZrnbosyunin1bosyujisikakucd) {
        zrnbosyunin1bosyujisikakucd = pZrnbosyunin1bosyujisikakucd;
    }

    private String zrnbosyuunin1sikakucd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUUNIN1SIKAKUCD)
    public String getZrnbosyuunin1sikakucd() {
        return zrnbosyuunin1sikakucd;
    }

    public void setZrnbosyuunin1sikakucd(String pZrnbosyuunin1sikakucd) {
        zrnbosyuunin1sikakucd = pZrnbosyuunin1sikakucd;
    }

    private String zrnnkkknmanryouymd;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNKKKNMANRYOUYMD)
    public String getZrnnkkknmanryouymd() {
        return zrnnkkknmanryouymd;
    }

    public void setZrnnkkknmanryouymd(String pZrnnkkknmanryouymd) {
        zrnnkkknmanryouymd = pZrnnkkknmanryouymd;
    }

    private String zrnkijyunym;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKIJYUNYM)
    public String getZrnkijyunym() {
        return zrnkijyunym;
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        zrnkijyunym = pZrnkijyunym;
    }

    private String zrnnenkinkigousedaikbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return zrnnenkinkigousedaikbn;
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
    }

    private String zrnkaimasinkkigousdkbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNKAIMASINKKIGOUSDKBN)
    public String getZrnkaimasinkkigousdkbn() {
        return zrnkaimasinkkigousdkbn;
    }

    public void setZrnkaimasinkkigousdkbn(String pZrnkaimasinkkigousdkbn) {
        zrnkaimasinkkigousdkbn = pZrnkaimasinkkigousdkbn;
    }

    private String zrnalmrrthendounkyoteirrt;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNALMRRTHENDOUNKYOTEIRRT)
    public String getZrnalmrrthendounkyoteirrt() {
        return zrnalmrrthendounkyoteirrt;
    }

    public void setZrnalmrrthendounkyoteirrt(String pZrnalmrrthendounkyoteirrt) {
        zrnalmrrthendounkyoteirrt = pZrnalmrrthendounkyoteirrt;
    }

    private String zrnalmrrthendounksitihsyrrt;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNALMRRTHENDOUNKSITIHSYRRT)
    public String getZrnalmrrthendounksitihsyrrt() {
        return zrnalmrrthendounksitihsyrrt;
    }

    public void setZrnalmrrthendounksitihsyrrt(String pZrnalmrrthendounksitihsyrrt) {
        zrnalmrrthendounksitihsyrrt = pZrnalmrrthendounksitihsyrrt;
    }

    private Long zrnnenkansanp;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNNENKANSANP)
    public Long getZrnnenkansanp() {
        return zrnnenkansanp;
    }

    public void setZrnnenkansanp(Long pZrnnenkansanp) {
        zrnnenkansanp = pZrnnenkansanp;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnyobiv30;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIV30)
    public String getZrnyobiv30() {
        return zrnyobiv30;
    }

    public void setZrnyobiv30(String pZrnyobiv30) {
        zrnyobiv30 = pZrnyobiv30;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnyobiv8x3;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIV8X3)
    public String getZrnyobiv8x3() {
        return zrnyobiv8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x3(String pZrnyobiv8x3) {
        zrnyobiv8x3 = pZrnyobiv8x3;
    }

    private String zrnyobiv8x4;

    @Column(name=GenZT_AlmNnknHyuRn.ZRNYOBIV8X4)
    public String getZrnyobiv8x4() {
        return zrnyobiv8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x4(String pZrnyobiv8x4) {
        zrnyobiv8x4 = pZrnyobiv8x4;
    }
}