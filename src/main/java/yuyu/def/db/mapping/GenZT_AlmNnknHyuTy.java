package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_AlmNnknHyuTy;
import yuyu.def.db.id.PKZT_AlmNnknHyuTy;
import yuyu.def.db.meta.GenQZT_AlmNnknHyuTy;
import yuyu.def.db.meta.QZT_AlmNnknHyuTy;

/**
 * ＡＬＭ用年金保有明細テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_AlmNnknHyuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AlmNnknHyuTy}</td><td colspan="3">ＡＬＭ用年金保有明細テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">{@link PKZT_AlmNnknHyuTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn ztynksyuruikbn}</td><td>（中継用）年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkbn ztynenkinkbn}</td><td>（中継用）年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsyu ztynenkinsyu}</td><td>（中継用）年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykknsetymd ztykknsetymd}</td><td>（中継用）基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokainenkinsiharaiymd ztysyokainenkinsiharaiymd}</td><td>（中継用）初回年金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinhosyoukikan ztynenkinhosyoukikan}</td><td>（中継用）年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhnnkgk ztykhnnkgk}</td><td>（中継用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakujikihonnenkingaku ztykeiyakujikihonnenkingaku}</td><td>（中継用）契約時基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykasannkgk ztykasannkgk}</td><td>（中継用）加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynewmoneynenkingaku ztynewmoneynenkingaku}</td><td>（中継用）ニューマネー年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanitijibarainkgk ztytenkanitijibarainkgk}</td><td>（中継用）転換一時払年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbratamakinnkgk ztyitibitjbratamakinnkgk}</td><td>（中継用）一部一時払頭金年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrtyuutohknkgk ztyitibitjbrtyuutohknkgk}</td><td>（中継用）一部一時払中途付加年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisijigensi ztynenkinkaisijigensi}</td><td>（中継用）年金開始時原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynewmoneygaku ztynewmoneygaku}</td><td>（中継用）ニューマネー額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynewmoneybubunnenkingensi ztynewmoneybubunnenkingensi}</td><td>（中継用）ニューマネー部分年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhitenkankeiyakukykymd ztyhitenkankeiyakukykymd}</td><td>（中継用）被転換契約契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrtyuutohkymd ztyitibitjbrtyuutohkymd}</td><td>（中継用）一部一時払中途付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypitijibaraihyouji ztypitijibaraihyouji}</td><td>（中継用）Ｐ一時払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuarihyouji ztytokuyakuarihyouji}</td><td>（中継用）特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkaisigoyoteiriritukbn ztynkkaisigoyoteiriritukbn}</td><td>（中継用）年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksgoyoteisibouritukbn ztynksgoyoteisibouritukbn}</td><td>（中継用）年金開始後予定死亡率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinjimutesuuryoukbn ztynenkinjimutesuuryoukbn}</td><td>（中継用）年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatukbn ztymaeatuatoatukbn}</td><td>（中継用）前厚後厚区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteizounksiboujihknnendo ztyteizounksiboujihknnendo}</td><td>（中継用）逓増年金死亡時保険年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjihihokensyaage ztynksjihihokensyaage}</td><td>（中継用）年金開始時被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyaseibetukbn ztydai2hihokensyaseibetukbn}</td><td>（中継用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksjidai2hhknsyaage ztynksjidai2hhknsyaage}</td><td>（中継用）年金開始時第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjgyunendosikitoutatuage ztyjgyunendosikitoutatuage}</td><td>（中継用）事業年度式到達年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijikinsiharaiymd ztyitijikinsiharaiymd}</td><td>（中継用）一時金支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyasibouymd ztyhihokensyasibouymd}</td><td>（中継用）被保険者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyasibouymd ztydai2hihokensyasibouymd}</td><td>（中継用）第２被保険者死亡年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteii ztyyoteii}</td><td>（中継用）予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibouhyoukbn ztysibouhyoukbn}</td><td>（中継用）死亡表区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydnendo ztydnendo}</td><td>（中継用）Ｄ年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytounendod ztytounendod}</td><td>（中継用）当年度Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynktouduketorihouhoukbn ztynktouduketorihouhoukbn}</td><td>（中継用）年金当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitated ztytumitated}</td><td>（中継用）積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyouikunenkinarihyouji ztyyouikunenkinarihyouji}</td><td>（中継用）養育年金有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalmnenkinsyoumetucd ztyalmnenkinsyoumetucd}</td><td>（中継用）ＡＬＭ年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinarihyouji ztykaimasinenkinarihyouji}</td><td>（中継用）買増年金有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkkouryokusymd ztykaimasinkkouryokusymd}</td><td>（中継用）買増年金効力開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinkbn ztykaimasinenkinkbn}</td><td>（中継用）買増年金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinsyuruikigou ztykaimasinenkinsyuruikigou}</td><td>（中継用）買増年金種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkshrkkn ztykaimasinkshrkkn}</td><td>（中継用）買増年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinhosyoukikan ztykaimasinenkinhosyoukikan}</td><td>（中継用）買増年金保証期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkhhknsyaage ztykaimasinkhhknsyaage}</td><td>（中継用）買増年金被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykimsnkdai2hhknsyaage ztykimsnkdai2hhknsyaage}</td><td>（中継用）買増年金第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuukousinymd ztysaisyuukousinymd}</td><td>（中継用）最終更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkingaku ztykaimasinenkingaku}</td><td>（中継用）買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennendokaimasinkgk ztyzennendokaimasinkgk}</td><td>（中継用）前年度買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendokaimasinenkind ztytounendokaimasinenkind}</td><td>（中継用）当年度買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatukouryokusymd ztymaeatuatoatukouryokusymd}</td><td>（中継用）前厚後厚効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatukikan ztymaeatuatoatukikan}</td><td>（中継用）前厚後厚期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaeatuatoatuhendougonkgk ztymaeatuatoatuhendougonkgk}</td><td>（中継用）前厚後厚変動後年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyatoatusaisyuukaimasiymd ztyatoatusaisyuukaimasiymd}</td><td>（中継用）後厚最終買増日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatoatukaimasinenkingaku ztyatoatukaimasinenkingaku}</td><td>（中継用）後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyznnndatoatukaimasinkgk ztyznnndatoatukaimasinkgk}</td><td>（中継用）前年度後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendatoatukaimasinkd ztytounendatoatukaimasinkd}</td><td>（中継用）当年度後厚買増年金Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyuwanoseatoatukaimasinkgk ztyuwanoseatoatukaimasinkgk}</td><td>（中継用）上乗せ後厚買増年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkuktorininhhknsyadouhyj ztynkuktorininhhknsyadouhyj}</td><td>（中継用）年金受取人被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkuktrnndi2hhknsyadouhyj ztynkuktrnndi2hhknsyadouhyj}</td><td>（中継用）年金受取人第２被保険者同表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkuketorininsakuinnmno ztynkuketorininsakuinnmno}</td><td>（中継用）年金受取人索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtenkanritodoufukencd ztydrtenkanritodoufukencd}</td><td>（中継用）代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairiten1sosikicd ztydairiten1sosikicd}</td><td>（中継用）代理店１組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin1cd ztybosyuunin1cd}</td><td>（中継用）募集人１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin1keisyousisyacd ztybosyuunin1keisyousisyacd}</td><td>（中継用）募集人１継承支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin1zaisekihyouji ztybosyuunin1zaisekihyouji}</td><td>（中継用）募集人１在籍表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin1bosyuujiage ztybosyuunin1bosyuujiage}</td><td>（中継用）募集人１募集時年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyunin1bosyujisikakucd ztybosyunin1bosyujisikakucd}</td><td>（中継用）募集人１募集時資格コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunin1sikakucd ztybosyuunin1sikakucd}</td><td>（中継用）募集人１資格コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkknmanryouymd ztynkkknmanryouymd}</td><td>（中継用）年金期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkigousedaikbn ztynenkinkigousedaikbn}</td><td>（中継用）年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasinkkigousdkbn ztykaimasinkkigousdkbn}</td><td>（中継用）買増年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalmrrthendounkyoteirrt ztyalmrrthendounkyoteirrt}</td><td>（中継用）ＡＬＭ利率変動年金予定利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalmrrthendounksitihsyrrt ztyalmrrthendounksitihsyrrt}</td><td>（中継用）ＡＬＭ利率変動年金最低保証利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkansanp ztynenkansanp}</td><td>（中継用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnentysihyj ztydai2hhknnentysihyj}</td><td>（中継用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv30 ztyyobiv30}</td><td>（中継用）予備項目Ｖ３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x3 ztyyobiv8x3}</td><td>（中継用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x4 ztyyobiv8x4}</td><td>（中継用）予備項目Ｖ８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_AlmNnknHyuTy
 * @see     PKZT_AlmNnknHyuTy
 * @see     QZT_AlmNnknHyuTy
 * @see     GenQZT_AlmNnknHyuTy
 */
@MappedSuperclass
@Table(name=GenZT_AlmNnknHyuTy.TABLE_NAME)
@IdClass(value=PKZT_AlmNnknHyuTy.class)
public abstract class GenZT_AlmNnknHyuTy extends AbstractExDBEntity<ZT_AlmNnknHyuTy, PKZT_AlmNnknHyuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_AlmNnknHyuTy";
    public static final String ZTYNKSYOUSYONO           = "ztynksyousyono";
    public static final String ZTYNKSYURUIKBN           = "ztynksyuruikbn";
    public static final String ZTYNENKINKBN             = "ztynenkinkbn";
    public static final String ZTYNENKINSYU             = "ztynenkinsyu";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYKEIYAKUYMD            = "ztykeiyakuymd";
    public static final String ZTYKKNSETYMD             = "ztykknsetymd";
    public static final String ZTYSYOKAINENKINSIHARAIYMD = "ztysyokainenkinsiharaiymd";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYNENKINHOSYOUKIKAN     = "ztynenkinhosyoukikan";
    public static final String ZTYKHNNKGK               = "ztykhnnkgk";
    public static final String ZTYKEIYAKUJIKIHONNENKINGAKU = "ztykeiyakujikihonnenkingaku";
    public static final String ZTYKASANNKGK             = "ztykasannkgk";
    public static final String ZTYNEWMONEYNENKINGAKU    = "ztynewmoneynenkingaku";
    public static final String ZTYTENKANITIJIBARAINKGK  = "ztytenkanitijibarainkgk";
    public static final String ZTYITIBITJBRATAMAKINNKGK = "ztyitibitjbratamakinnkgk";
    public static final String ZTYITIBITJBRTYUUTOHKNKGK = "ztyitibitjbrtyuutohknkgk";
    public static final String ZTYNENKINKAISIJIGENSI    = "ztynenkinkaisijigensi";
    public static final String ZTYNEWMONEYGAKU          = "ztynewmoneygaku";
    public static final String ZTYNEWMONEYBUBUNNENKINGENSI = "ztynewmoneybubunnenkingensi";
    public static final String ZTYHITENKANKEIYAKUKYKYMD = "ztyhitenkankeiyakukykymd";
    public static final String ZTYITIBITJBRTYUUTOHKYMD  = "ztyitibitjbrtyuutohkymd";
    public static final String ZTYPITIJIBARAIHYOUJI     = "ztypitijibaraihyouji";
    public static final String ZTYTOKUYAKUARIHYOUJI     = "ztytokuyakuarihyouji";
    public static final String ZTYNKKAISIGOYOTEIRIRITUKBN = "ztynkkaisigoyoteiriritukbn";
    public static final String ZTYNKSGOYOTEISIBOURITUKBN = "ztynksgoyoteisibouritukbn";
    public static final String ZTYNENKINJIMUTESUURYOUKBN = "ztynenkinjimutesuuryoukbn";
    public static final String ZTYMAEATUATOATUKBN       = "ztymaeatuatoatukbn";
    public static final String ZTYTEIZOUNKSIBOUJIHKNNENDO = "ztyteizounksiboujihknnendo";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYNKSJIHIHOKENSYAAGE    = "ztynksjihihokensyaage";
    public static final String ZTYDAI2HIHOKENSYASEIBETUKBN = "ztydai2hihokensyaseibetukbn";
    public static final String ZTYNKSJIDAI2HHKNSYAAGE   = "ztynksjidai2hhknsyaage";
    public static final String ZTYJGYUNENDOSIKITOUTATUAGE = "ztyjgyunendosikitoutatuage";
    public static final String ZTYITIJIKINSIHARAIYMD    = "ztyitijikinsiharaiymd";
    public static final String ZTYHIHOKENSYASIBOUYMD    = "ztyhihokensyasibouymd";
    public static final String ZTYDAI2HIHOKENSYASIBOUYMD = "ztydai2hihokensyasibouymd";
    public static final String ZTYYOTEII                = "ztyyoteii";
    public static final String ZTYSIBOUHYOUKBN          = "ztysibouhyoukbn";
    public static final String ZTYDNENDO                = "ztydnendo";
    public static final String ZTYTOUNENDOD             = "ztytounendod";
    public static final String ZTYNKTOUDUKETORIHOUHOUKBN = "ztynktouduketorihouhoukbn";
    public static final String ZTYTUMITATED             = "ztytumitated";
    public static final String ZTYYOUIKUNENKINARIHYOUJI = "ztyyouikunenkinarihyouji";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYALMNENKINSYOUMETUCD   = "ztyalmnenkinsyoumetucd";
    public static final String ZTYKAIMASINENKINARIHYOUJI = "ztykaimasinenkinarihyouji";
    public static final String ZTYKAIMASINKKOURYOKUSYMD = "ztykaimasinkkouryokusymd";
    public static final String ZTYKAIMASINENKINKBN      = "ztykaimasinenkinkbn";
    public static final String ZTYKAIMASINENKINSYURUIKIGOU = "ztykaimasinenkinsyuruikigou";
    public static final String ZTYKAIMASINKSHRKKN       = "ztykaimasinkshrkkn";
    public static final String ZTYKAIMASINENKINHOSYOUKIKAN = "ztykaimasinenkinhosyoukikan";
    public static final String ZTYKAIMASINKHHKNSYAAGE   = "ztykaimasinkhhknsyaage";
    public static final String ZTYKIMSNKDAI2HHKNSYAAGE  = "ztykimsnkdai2hhknsyaage";
    public static final String ZTYSAISYUUKOUSINYMD      = "ztysaisyuukousinymd";
    public static final String ZTYKAIMASINENKINGAKU     = "ztykaimasinenkingaku";
    public static final String ZTYZENNENDOKAIMASINKGK   = "ztyzennendokaimasinkgk";
    public static final String ZTYTOUNENDOKAIMASINENKIND = "ztytounendokaimasinenkind";
    public static final String ZTYMAEATUATOATUKOURYOKUSYMD = "ztymaeatuatoatukouryokusymd";
    public static final String ZTYMAEATUATOATUKIKAN     = "ztymaeatuatoatukikan";
    public static final String ZTYMAEATUATOATUHENDOUGONKGK = "ztymaeatuatoatuhendougonkgk";
    public static final String ZTYATOATUSAISYUUKAIMASIYMD = "ztyatoatusaisyuukaimasiymd";
    public static final String ZTYATOATUKAIMASINENKINGAKU = "ztyatoatukaimasinenkingaku";
    public static final String ZTYZNNNDATOATUKAIMASINKGK = "ztyznnndatoatukaimasinkgk";
    public static final String ZTYTOUNENDATOATUKAIMASINKD = "ztytounendatoatukaimasinkd";
    public static final String ZTYUWANOSEATOATUKAIMASINKGK = "ztyuwanoseatoatukaimasinkgk";
    public static final String ZTYNKUKTORININHHKNSYADOUHYJ = "ztynkuktorininhhknsyadouhyj";
    public static final String ZTYNKUKTRNNDI2HHKNSYADOUHYJ = "ztynkuktrnndi2hhknsyadouhyj";
    public static final String ZTYNKUKETORININSAKUINNMNO = "ztynkuketorininsakuinnmno";
    public static final String ZTYDRTENKANRITODOUFUKENCD = "ztydrtenkanritodoufukencd";
    public static final String ZTYDAIRITEN1SOSIKICD     = "ztydairiten1sosikicd";
    public static final String ZTYBOSYUUNIN1CD          = "ztybosyuunin1cd";
    public static final String ZTYBOSYUUNIN1KEISYOUSISYACD = "ztybosyuunin1keisyousisyacd";
    public static final String ZTYBOSYUUNIN1ZAISEKIHYOUJI = "ztybosyuunin1zaisekihyouji";
    public static final String ZTYBOSYUUNIN1BOSYUUJIAGE = "ztybosyuunin1bosyuujiage";
    public static final String ZTYBOSYUNIN1BOSYUJISIKAKUCD = "ztybosyunin1bosyujisikakucd";
    public static final String ZTYBOSYUUNIN1SIKAKUCD    = "ztybosyuunin1sikakucd";
    public static final String ZTYNKKKNMANRYOUYMD       = "ztynkkknmanryouymd";
    public static final String ZTYKIJYUNYM              = "ztykijyunym";
    public static final String ZTYNENKINKIGOUSEDAIKBN   = "ztynenkinkigousedaikbn";
    public static final String ZTYKAIMASINKKIGOUSDKBN   = "ztykaimasinkkigousdkbn";
    public static final String ZTYALMRRTHENDOUNKYOTEIRRT = "ztyalmrrthendounkyoteirrt";
    public static final String ZTYALMRRTHENDOUNKSITIHSYRRT = "ztyalmrrthendounksitihsyrrt";
    public static final String ZTYNENKANSANP            = "ztynenkansanp";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYDAI2HHKNNENTYSIHYJ    = "ztydai2hhknnentysihyj";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYYOBIV30               = "ztyyobiv30";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYYOBIV8X3              = "ztyyobiv8x3";
    public static final String ZTYYOBIV8X4              = "ztyyobiv8x4";

    private final PKZT_AlmNnknHyuTy primaryKey;

    public GenZT_AlmNnknHyuTy() {
        primaryKey = new PKZT_AlmNnknHyuTy();
    }

    public GenZT_AlmNnknHyuTy(String pZtynksyousyono) {
        primaryKey = new PKZT_AlmNnknHyuTy(pZtynksyousyono);
    }

    @Transient
    @Override
    public PKZT_AlmNnknHyuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_AlmNnknHyuTy> getMetaClass() {
        return QZT_AlmNnknHyuTy.class;
    }

    @Id
    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKSYOUSYONO)
    public String getZtynksyousyono() {
        return getPrimaryKey().getZtynksyousyono();
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        getPrimaryKey().setZtynksyousyono(pZtynksyousyono);
    }

    private String ztynksyuruikbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKSYURUIKBN)
    public String getZtynksyuruikbn() {
        return ztynksyuruikbn;
    }

    public void setZtynksyuruikbn(String pZtynksyuruikbn) {
        ztynksyuruikbn = pZtynksyuruikbn;
    }

    private String ztynenkinkbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKINKBN)
    public String getZtynenkinkbn() {
        return ztynenkinkbn;
    }

    public void setZtynenkinkbn(String pZtynenkinkbn) {
        ztynenkinkbn = pZtynenkinkbn;
    }

    private String ztynenkinsyu;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKINSYU)
    public String getZtynenkinsyu() {
        return ztynenkinsyu;
    }

    public void setZtynenkinsyu(String pZtynenkinsyu) {
        ztynenkinsyu = pZtynenkinsyu;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztykeiyakuymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKEIYAKUYMD)
    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }

    private String ztykknsetymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKKNSETYMD)
    public String getZtykknsetymd() {
        return ztykknsetymd;
    }

    public void setZtykknsetymd(String pZtykknsetymd) {
        ztykknsetymd = pZtykknsetymd;
    }

    private String ztysyokainenkinsiharaiymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYSYOKAINENKINSIHARAIYMD)
    public String getZtysyokainenkinsiharaiymd() {
        return ztysyokainenkinsiharaiymd;
    }

    public void setZtysyokainenkinsiharaiymd(String pZtysyokainenkinsiharaiymd) {
        ztysyokainenkinsiharaiymd = pZtysyokainenkinsiharaiymd;
    }

    private String ztynknshry;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztynenkinhosyoukikan;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKINHOSYOUKIKAN)
    public String getZtynenkinhosyoukikan() {
        return ztynenkinhosyoukikan;
    }

    public void setZtynenkinhosyoukikan(String pZtynenkinhosyoukikan) {
        ztynenkinhosyoukikan = pZtynenkinhosyoukikan;
    }

    private Long ztykhnnkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKHNNKGK)
    public Long getZtykhnnkgk() {
        return ztykhnnkgk;
    }

    public void setZtykhnnkgk(Long pZtykhnnkgk) {
        ztykhnnkgk = pZtykhnnkgk;
    }

    private Long ztykeiyakujikihonnenkingaku;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKEIYAKUJIKIHONNENKINGAKU)
    public Long getZtykeiyakujikihonnenkingaku() {
        return ztykeiyakujikihonnenkingaku;
    }

    public void setZtykeiyakujikihonnenkingaku(Long pZtykeiyakujikihonnenkingaku) {
        ztykeiyakujikihonnenkingaku = pZtykeiyakujikihonnenkingaku;
    }

    private Long ztykasannkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKASANNKGK)
    public Long getZtykasannkgk() {
        return ztykasannkgk;
    }

    public void setZtykasannkgk(Long pZtykasannkgk) {
        ztykasannkgk = pZtykasannkgk;
    }

    private Long ztynewmoneynenkingaku;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNEWMONEYNENKINGAKU)
    public Long getZtynewmoneynenkingaku() {
        return ztynewmoneynenkingaku;
    }

    public void setZtynewmoneynenkingaku(Long pZtynewmoneynenkingaku) {
        ztynewmoneynenkingaku = pZtynewmoneynenkingaku;
    }

    private Long ztytenkanitijibarainkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTENKANITIJIBARAINKGK)
    public Long getZtytenkanitijibarainkgk() {
        return ztytenkanitijibarainkgk;
    }

    public void setZtytenkanitijibarainkgk(Long pZtytenkanitijibarainkgk) {
        ztytenkanitijibarainkgk = pZtytenkanitijibarainkgk;
    }

    private Long ztyitibitjbratamakinnkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYITIBITJBRATAMAKINNKGK)
    public Long getZtyitibitjbratamakinnkgk() {
        return ztyitibitjbratamakinnkgk;
    }

    public void setZtyitibitjbratamakinnkgk(Long pZtyitibitjbratamakinnkgk) {
        ztyitibitjbratamakinnkgk = pZtyitibitjbratamakinnkgk;
    }

    private Long ztyitibitjbrtyuutohknkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYITIBITJBRTYUUTOHKNKGK)
    public Long getZtyitibitjbrtyuutohknkgk() {
        return ztyitibitjbrtyuutohknkgk;
    }

    public void setZtyitibitjbrtyuutohknkgk(Long pZtyitibitjbrtyuutohknkgk) {
        ztyitibitjbrtyuutohknkgk = pZtyitibitjbrtyuutohknkgk;
    }

    private Long ztynenkinkaisijigensi;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKINKAISIJIGENSI)
    public Long getZtynenkinkaisijigensi() {
        return ztynenkinkaisijigensi;
    }

    public void setZtynenkinkaisijigensi(Long pZtynenkinkaisijigensi) {
        ztynenkinkaisijigensi = pZtynenkinkaisijigensi;
    }

    private Long ztynewmoneygaku;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNEWMONEYGAKU)
    public Long getZtynewmoneygaku() {
        return ztynewmoneygaku;
    }

    public void setZtynewmoneygaku(Long pZtynewmoneygaku) {
        ztynewmoneygaku = pZtynewmoneygaku;
    }

    private Long ztynewmoneybubunnenkingensi;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNEWMONEYBUBUNNENKINGENSI)
    public Long getZtynewmoneybubunnenkingensi() {
        return ztynewmoneybubunnenkingensi;
    }

    public void setZtynewmoneybubunnenkingensi(Long pZtynewmoneybubunnenkingensi) {
        ztynewmoneybubunnenkingensi = pZtynewmoneybubunnenkingensi;
    }

    private String ztyhitenkankeiyakukykymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYHITENKANKEIYAKUKYKYMD)
    public String getZtyhitenkankeiyakukykymd() {
        return ztyhitenkankeiyakukykymd;
    }

    public void setZtyhitenkankeiyakukykymd(String pZtyhitenkankeiyakukykymd) {
        ztyhitenkankeiyakukykymd = pZtyhitenkankeiyakukykymd;
    }

    private String ztyitibitjbrtyuutohkymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYITIBITJBRTYUUTOHKYMD)
    public String getZtyitibitjbrtyuutohkymd() {
        return ztyitibitjbrtyuutohkymd;
    }

    public void setZtyitibitjbrtyuutohkymd(String pZtyitibitjbrtyuutohkymd) {
        ztyitibitjbrtyuutohkymd = pZtyitibitjbrtyuutohkymd;
    }

    private String ztypitijibaraihyouji;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYPITIJIBARAIHYOUJI)
    public String getZtypitijibaraihyouji() {
        return ztypitijibaraihyouji;
    }

    public void setZtypitijibaraihyouji(String pZtypitijibaraihyouji) {
        ztypitijibaraihyouji = pZtypitijibaraihyouji;
    }

    private String ztytokuyakuarihyouji;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTOKUYAKUARIHYOUJI)
    public String getZtytokuyakuarihyouji() {
        return ztytokuyakuarihyouji;
    }

    public void setZtytokuyakuarihyouji(String pZtytokuyakuarihyouji) {
        ztytokuyakuarihyouji = pZtytokuyakuarihyouji;
    }

    private String ztynkkaisigoyoteiriritukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKKAISIGOYOTEIRIRITUKBN)
    public String getZtynkkaisigoyoteiriritukbn() {
        return ztynkkaisigoyoteiriritukbn;
    }

    public void setZtynkkaisigoyoteiriritukbn(String pZtynkkaisigoyoteiriritukbn) {
        ztynkkaisigoyoteiriritukbn = pZtynkkaisigoyoteiriritukbn;
    }

    private String ztynksgoyoteisibouritukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKSGOYOTEISIBOURITUKBN)
    public String getZtynksgoyoteisibouritukbn() {
        return ztynksgoyoteisibouritukbn;
    }

    public void setZtynksgoyoteisibouritukbn(String pZtynksgoyoteisibouritukbn) {
        ztynksgoyoteisibouritukbn = pZtynksgoyoteisibouritukbn;
    }

    private String ztynenkinjimutesuuryoukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKINJIMUTESUURYOUKBN)
    public String getZtynenkinjimutesuuryoukbn() {
        return ztynenkinjimutesuuryoukbn;
    }

    public void setZtynenkinjimutesuuryoukbn(String pZtynenkinjimutesuuryoukbn) {
        ztynenkinjimutesuuryoukbn = pZtynenkinjimutesuuryoukbn;
    }

    private String ztymaeatuatoatukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYMAEATUATOATUKBN)
    public String getZtymaeatuatoatukbn() {
        return ztymaeatuatoatukbn;
    }

    public void setZtymaeatuatoatukbn(String pZtymaeatuatoatukbn) {
        ztymaeatuatoatukbn = pZtymaeatuatoatukbn;
    }

    private String ztyteizounksiboujihknnendo;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTEIZOUNKSIBOUJIHKNNENDO)
    public String getZtyteizounksiboujihknnendo() {
        return ztyteizounksiboujihknnendo;
    }

    public void setZtyteizounksiboujihknnendo(String pZtyteizounksiboujihknnendo) {
        ztyteizounksiboujihknnendo = pZtyteizounksiboujihknnendo;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztynksjihihokensyaage;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKSJIHIHOKENSYAAGE)
    public String getZtynksjihihokensyaage() {
        return ztynksjihihokensyaage;
    }

    public void setZtynksjihihokensyaage(String pZtynksjihihokensyaage) {
        ztynksjihihokensyaage = pZtynksjihihokensyaage;
    }

    private String ztydai2hihokensyaseibetukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYDAI2HIHOKENSYASEIBETUKBN)
    public String getZtydai2hihokensyaseibetukbn() {
        return ztydai2hihokensyaseibetukbn;
    }

    public void setZtydai2hihokensyaseibetukbn(String pZtydai2hihokensyaseibetukbn) {
        ztydai2hihokensyaseibetukbn = pZtydai2hihokensyaseibetukbn;
    }

    private String ztynksjidai2hhknsyaage;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKSJIDAI2HHKNSYAAGE)
    public String getZtynksjidai2hhknsyaage() {
        return ztynksjidai2hhknsyaage;
    }

    public void setZtynksjidai2hhknsyaage(String pZtynksjidai2hhknsyaage) {
        ztynksjidai2hhknsyaage = pZtynksjidai2hhknsyaage;
    }

    private String ztyjgyunendosikitoutatuage;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYJGYUNENDOSIKITOUTATUAGE)
    public String getZtyjgyunendosikitoutatuage() {
        return ztyjgyunendosikitoutatuage;
    }

    public void setZtyjgyunendosikitoutatuage(String pZtyjgyunendosikitoutatuage) {
        ztyjgyunendosikitoutatuage = pZtyjgyunendosikitoutatuage;
    }

    private String ztyitijikinsiharaiymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYITIJIKINSIHARAIYMD)
    public String getZtyitijikinsiharaiymd() {
        return ztyitijikinsiharaiymd;
    }

    public void setZtyitijikinsiharaiymd(String pZtyitijikinsiharaiymd) {
        ztyitijikinsiharaiymd = pZtyitijikinsiharaiymd;
    }

    private String ztyhihokensyasibouymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYHIHOKENSYASIBOUYMD)
    public String getZtyhihokensyasibouymd() {
        return ztyhihokensyasibouymd;
    }

    public void setZtyhihokensyasibouymd(String pZtyhihokensyasibouymd) {
        ztyhihokensyasibouymd = pZtyhihokensyasibouymd;
    }

    private String ztydai2hihokensyasibouymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYDAI2HIHOKENSYASIBOUYMD)
    public String getZtydai2hihokensyasibouymd() {
        return ztydai2hihokensyasibouymd;
    }

    public void setZtydai2hihokensyasibouymd(String pZtydai2hihokensyasibouymd) {
        ztydai2hihokensyasibouymd = pZtydai2hihokensyasibouymd;
    }

    private String ztyyoteii;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOTEII)
    public String getZtyyoteii() {
        return ztyyoteii;
    }

    public void setZtyyoteii(String pZtyyoteii) {
        ztyyoteii = pZtyyoteii;
    }

    private String ztysibouhyoukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYSIBOUHYOUKBN)
    public String getZtysibouhyoukbn() {
        return ztysibouhyoukbn;
    }

    public void setZtysibouhyoukbn(String pZtysibouhyoukbn) {
        ztysibouhyoukbn = pZtysibouhyoukbn;
    }

    private String ztydnendo;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYDNENDO)
    public String getZtydnendo() {
        return ztydnendo;
    }

    public void setZtydnendo(String pZtydnendo) {
        ztydnendo = pZtydnendo;
    }

    private Long ztytounendod;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTOUNENDOD)
    public Long getZtytounendod() {
        return ztytounendod;
    }

    public void setZtytounendod(Long pZtytounendod) {
        ztytounendod = pZtytounendod;
    }

    private String ztynktouduketorihouhoukbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKTOUDUKETORIHOUHOUKBN)
    public String getZtynktouduketorihouhoukbn() {
        return ztynktouduketorihouhoukbn;
    }

    public void setZtynktouduketorihouhoukbn(String pZtynktouduketorihouhoukbn) {
        ztynktouduketorihouhoukbn = pZtynktouduketorihouhoukbn;
    }

    private Long ztytumitated;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTUMITATED)
    public Long getZtytumitated() {
        return ztytumitated;
    }

    public void setZtytumitated(Long pZtytumitated) {
        ztytumitated = pZtytumitated;
    }

    private String ztyyouikunenkinarihyouji;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOUIKUNENKINARIHYOUJI)
    public String getZtyyouikunenkinarihyouji() {
        return ztyyouikunenkinarihyouji;
    }

    public void setZtyyouikunenkinarihyouji(String pZtyyouikunenkinarihyouji) {
        ztyyouikunenkinarihyouji = pZtyyouikunenkinarihyouji;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyalmnenkinsyoumetucd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYALMNENKINSYOUMETUCD)
    public String getZtyalmnenkinsyoumetucd() {
        return ztyalmnenkinsyoumetucd;
    }

    public void setZtyalmnenkinsyoumetucd(String pZtyalmnenkinsyoumetucd) {
        ztyalmnenkinsyoumetucd = pZtyalmnenkinsyoumetucd;
    }

    private String ztykaimasinenkinarihyouji;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINENKINARIHYOUJI)
    public String getZtykaimasinenkinarihyouji() {
        return ztykaimasinenkinarihyouji;
    }

    public void setZtykaimasinenkinarihyouji(String pZtykaimasinenkinarihyouji) {
        ztykaimasinenkinarihyouji = pZtykaimasinenkinarihyouji;
    }

    private String ztykaimasinkkouryokusymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINKKOURYOKUSYMD)
    public String getZtykaimasinkkouryokusymd() {
        return ztykaimasinkkouryokusymd;
    }

    public void setZtykaimasinkkouryokusymd(String pZtykaimasinkkouryokusymd) {
        ztykaimasinkkouryokusymd = pZtykaimasinkkouryokusymd;
    }

    private String ztykaimasinenkinkbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINENKINKBN)
    public String getZtykaimasinenkinkbn() {
        return ztykaimasinenkinkbn;
    }

    public void setZtykaimasinenkinkbn(String pZtykaimasinenkinkbn) {
        ztykaimasinenkinkbn = pZtykaimasinenkinkbn;
    }

    private String ztykaimasinenkinsyuruikigou;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINENKINSYURUIKIGOU)
    public String getZtykaimasinenkinsyuruikigou() {
        return ztykaimasinenkinsyuruikigou;
    }

    public void setZtykaimasinenkinsyuruikigou(String pZtykaimasinenkinsyuruikigou) {
        ztykaimasinenkinsyuruikigou = pZtykaimasinenkinsyuruikigou;
    }

    private String ztykaimasinkshrkkn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINKSHRKKN)
    public String getZtykaimasinkshrkkn() {
        return ztykaimasinkshrkkn;
    }

    public void setZtykaimasinkshrkkn(String pZtykaimasinkshrkkn) {
        ztykaimasinkshrkkn = pZtykaimasinkshrkkn;
    }

    private String ztykaimasinenkinhosyoukikan;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINENKINHOSYOUKIKAN)
    public String getZtykaimasinenkinhosyoukikan() {
        return ztykaimasinenkinhosyoukikan;
    }

    public void setZtykaimasinenkinhosyoukikan(String pZtykaimasinenkinhosyoukikan) {
        ztykaimasinenkinhosyoukikan = pZtykaimasinenkinhosyoukikan;
    }

    private String ztykaimasinkhhknsyaage;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINKHHKNSYAAGE)
    public String getZtykaimasinkhhknsyaage() {
        return ztykaimasinkhhknsyaage;
    }

    public void setZtykaimasinkhhknsyaage(String pZtykaimasinkhhknsyaage) {
        ztykaimasinkhhknsyaage = pZtykaimasinkhhknsyaage;
    }

    private String ztykimsnkdai2hhknsyaage;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKIMSNKDAI2HHKNSYAAGE)
    public String getZtykimsnkdai2hhknsyaage() {
        return ztykimsnkdai2hhknsyaage;
    }

    public void setZtykimsnkdai2hhknsyaage(String pZtykimsnkdai2hhknsyaage) {
        ztykimsnkdai2hhknsyaage = pZtykimsnkdai2hhknsyaage;
    }

    private String ztysaisyuukousinymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYSAISYUUKOUSINYMD)
    public String getZtysaisyuukousinymd() {
        return ztysaisyuukousinymd;
    }

    public void setZtysaisyuukousinymd(String pZtysaisyuukousinymd) {
        ztysaisyuukousinymd = pZtysaisyuukousinymd;
    }

    private Long ztykaimasinenkingaku;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINENKINGAKU)
    public Long getZtykaimasinenkingaku() {
        return ztykaimasinenkingaku;
    }

    public void setZtykaimasinenkingaku(Long pZtykaimasinenkingaku) {
        ztykaimasinenkingaku = pZtykaimasinenkingaku;
    }

    private Long ztyzennendokaimasinkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYZENNENDOKAIMASINKGK)
    public Long getZtyzennendokaimasinkgk() {
        return ztyzennendokaimasinkgk;
    }

    public void setZtyzennendokaimasinkgk(Long pZtyzennendokaimasinkgk) {
        ztyzennendokaimasinkgk = pZtyzennendokaimasinkgk;
    }

    private Long ztytounendokaimasinenkind;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTOUNENDOKAIMASINENKIND)
    public Long getZtytounendokaimasinenkind() {
        return ztytounendokaimasinenkind;
    }

    public void setZtytounendokaimasinenkind(Long pZtytounendokaimasinenkind) {
        ztytounendokaimasinenkind = pZtytounendokaimasinenkind;
    }

    private String ztymaeatuatoatukouryokusymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYMAEATUATOATUKOURYOKUSYMD)
    public String getZtymaeatuatoatukouryokusymd() {
        return ztymaeatuatoatukouryokusymd;
    }

    public void setZtymaeatuatoatukouryokusymd(String pZtymaeatuatoatukouryokusymd) {
        ztymaeatuatoatukouryokusymd = pZtymaeatuatoatukouryokusymd;
    }

    private String ztymaeatuatoatukikan;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYMAEATUATOATUKIKAN)
    public String getZtymaeatuatoatukikan() {
        return ztymaeatuatoatukikan;
    }

    public void setZtymaeatuatoatukikan(String pZtymaeatuatoatukikan) {
        ztymaeatuatoatukikan = pZtymaeatuatoatukikan;
    }

    private Long ztymaeatuatoatuhendougonkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYMAEATUATOATUHENDOUGONKGK)
    public Long getZtymaeatuatoatuhendougonkgk() {
        return ztymaeatuatoatuhendougonkgk;
    }

    public void setZtymaeatuatoatuhendougonkgk(Long pZtymaeatuatoatuhendougonkgk) {
        ztymaeatuatoatuhendougonkgk = pZtymaeatuatoatuhendougonkgk;
    }

    private String ztyatoatusaisyuukaimasiymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYATOATUSAISYUUKAIMASIYMD)
    public String getZtyatoatusaisyuukaimasiymd() {
        return ztyatoatusaisyuukaimasiymd;
    }

    public void setZtyatoatusaisyuukaimasiymd(String pZtyatoatusaisyuukaimasiymd) {
        ztyatoatusaisyuukaimasiymd = pZtyatoatusaisyuukaimasiymd;
    }

    private Long ztyatoatukaimasinenkingaku;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYATOATUKAIMASINENKINGAKU)
    public Long getZtyatoatukaimasinenkingaku() {
        return ztyatoatukaimasinenkingaku;
    }

    public void setZtyatoatukaimasinenkingaku(Long pZtyatoatukaimasinenkingaku) {
        ztyatoatukaimasinenkingaku = pZtyatoatukaimasinenkingaku;
    }

    private Long ztyznnndatoatukaimasinkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYZNNNDATOATUKAIMASINKGK)
    public Long getZtyznnndatoatukaimasinkgk() {
        return ztyznnndatoatukaimasinkgk;
    }

    public void setZtyznnndatoatukaimasinkgk(Long pZtyznnndatoatukaimasinkgk) {
        ztyznnndatoatukaimasinkgk = pZtyznnndatoatukaimasinkgk;
    }

    private Long ztytounendatoatukaimasinkd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYTOUNENDATOATUKAIMASINKD)
    public Long getZtytounendatoatukaimasinkd() {
        return ztytounendatoatukaimasinkd;
    }

    public void setZtytounendatoatukaimasinkd(Long pZtytounendatoatukaimasinkd) {
        ztytounendatoatukaimasinkd = pZtytounendatoatukaimasinkd;
    }

    private Long ztyuwanoseatoatukaimasinkgk;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYUWANOSEATOATUKAIMASINKGK)
    public Long getZtyuwanoseatoatukaimasinkgk() {
        return ztyuwanoseatoatukaimasinkgk;
    }

    public void setZtyuwanoseatoatukaimasinkgk(Long pZtyuwanoseatoatukaimasinkgk) {
        ztyuwanoseatoatukaimasinkgk = pZtyuwanoseatoatukaimasinkgk;
    }

    private String ztynkuktorininhhknsyadouhyj;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKUKTORININHHKNSYADOUHYJ)
    public String getZtynkuktorininhhknsyadouhyj() {
        return ztynkuktorininhhknsyadouhyj;
    }

    public void setZtynkuktorininhhknsyadouhyj(String pZtynkuktorininhhknsyadouhyj) {
        ztynkuktorininhhknsyadouhyj = pZtynkuktorininhhknsyadouhyj;
    }

    private String ztynkuktrnndi2hhknsyadouhyj;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKUKTRNNDI2HHKNSYADOUHYJ)
    public String getZtynkuktrnndi2hhknsyadouhyj() {
        return ztynkuktrnndi2hhknsyadouhyj;
    }

    public void setZtynkuktrnndi2hhknsyadouhyj(String pZtynkuktrnndi2hhknsyadouhyj) {
        ztynkuktrnndi2hhknsyadouhyj = pZtynkuktrnndi2hhknsyadouhyj;
    }

    private String ztynkuketorininsakuinnmno;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKUKETORININSAKUINNMNO)
    public String getZtynkuketorininsakuinnmno() {
        return ztynkuketorininsakuinnmno;
    }

    public void setZtynkuketorininsakuinnmno(String pZtynkuketorininsakuinnmno) {
        ztynkuketorininsakuinnmno = pZtynkuketorininsakuinnmno;
    }

    private String ztydrtenkanritodoufukencd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYDRTENKANRITODOUFUKENCD)
    public String getZtydrtenkanritodoufukencd() {
        return ztydrtenkanritodoufukencd;
    }

    public void setZtydrtenkanritodoufukencd(String pZtydrtenkanritodoufukencd) {
        ztydrtenkanritodoufukencd = pZtydrtenkanritodoufukencd;
    }

    private String ztydairiten1sosikicd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYDAIRITEN1SOSIKICD)
    public String getZtydairiten1sosikicd() {
        return ztydairiten1sosikicd;
    }

    public void setZtydairiten1sosikicd(String pZtydairiten1sosikicd) {
        ztydairiten1sosikicd = pZtydairiten1sosikicd;
    }

    private String ztybosyuunin1cd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUUNIN1CD)
    public String getZtybosyuunin1cd() {
        return ztybosyuunin1cd;
    }

    public void setZtybosyuunin1cd(String pZtybosyuunin1cd) {
        ztybosyuunin1cd = pZtybosyuunin1cd;
    }

    private String ztybosyuunin1keisyousisyacd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUUNIN1KEISYOUSISYACD)
    public String getZtybosyuunin1keisyousisyacd() {
        return ztybosyuunin1keisyousisyacd;
    }

    public void setZtybosyuunin1keisyousisyacd(String pZtybosyuunin1keisyousisyacd) {
        ztybosyuunin1keisyousisyacd = pZtybosyuunin1keisyousisyacd;
    }

    private String ztybosyuunin1zaisekihyouji;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUUNIN1ZAISEKIHYOUJI)
    public String getZtybosyuunin1zaisekihyouji() {
        return ztybosyuunin1zaisekihyouji;
    }

    public void setZtybosyuunin1zaisekihyouji(String pZtybosyuunin1zaisekihyouji) {
        ztybosyuunin1zaisekihyouji = pZtybosyuunin1zaisekihyouji;
    }

    private String ztybosyuunin1bosyuujiage;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUUNIN1BOSYUUJIAGE)
    public String getZtybosyuunin1bosyuujiage() {
        return ztybosyuunin1bosyuujiage;
    }

    public void setZtybosyuunin1bosyuujiage(String pZtybosyuunin1bosyuujiage) {
        ztybosyuunin1bosyuujiage = pZtybosyuunin1bosyuujiage;
    }

    private String ztybosyunin1bosyujisikakucd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUNIN1BOSYUJISIKAKUCD)
    public String getZtybosyunin1bosyujisikakucd() {
        return ztybosyunin1bosyujisikakucd;
    }

    public void setZtybosyunin1bosyujisikakucd(String pZtybosyunin1bosyujisikakucd) {
        ztybosyunin1bosyujisikakucd = pZtybosyunin1bosyujisikakucd;
    }

    private String ztybosyuunin1sikakucd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUUNIN1SIKAKUCD)
    public String getZtybosyuunin1sikakucd() {
        return ztybosyuunin1sikakucd;
    }

    public void setZtybosyuunin1sikakucd(String pZtybosyuunin1sikakucd) {
        ztybosyuunin1sikakucd = pZtybosyuunin1sikakucd;
    }

    private String ztynkkknmanryouymd;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNKKKNMANRYOUYMD)
    public String getZtynkkknmanryouymd() {
        return ztynkkknmanryouymd;
    }

    public void setZtynkkknmanryouymd(String pZtynkkknmanryouymd) {
        ztynkkknmanryouymd = pZtynkkknmanryouymd;
    }

    private String ztykijyunym;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKIJYUNYM)
    public String getZtykijyunym() {
        return ztykijyunym;
    }

    public void setZtykijyunym(String pZtykijyunym) {
        ztykijyunym = pZtykijyunym;
    }

    private String ztynenkinkigousedaikbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKINKIGOUSEDAIKBN)
    public String getZtynenkinkigousedaikbn() {
        return ztynenkinkigousedaikbn;
    }

    public void setZtynenkinkigousedaikbn(String pZtynenkinkigousedaikbn) {
        ztynenkinkigousedaikbn = pZtynenkinkigousedaikbn;
    }

    private String ztykaimasinkkigousdkbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYKAIMASINKKIGOUSDKBN)
    public String getZtykaimasinkkigousdkbn() {
        return ztykaimasinkkigousdkbn;
    }

    public void setZtykaimasinkkigousdkbn(String pZtykaimasinkkigousdkbn) {
        ztykaimasinkkigousdkbn = pZtykaimasinkkigousdkbn;
    }

    private String ztyalmrrthendounkyoteirrt;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYALMRRTHENDOUNKYOTEIRRT)
    public String getZtyalmrrthendounkyoteirrt() {
        return ztyalmrrthendounkyoteirrt;
    }

    public void setZtyalmrrthendounkyoteirrt(String pZtyalmrrthendounkyoteirrt) {
        ztyalmrrthendounkyoteirrt = pZtyalmrrthendounkyoteirrt;
    }

    private String ztyalmrrthendounksitihsyrrt;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYALMRRTHENDOUNKSITIHSYRRT)
    public String getZtyalmrrthendounksitihsyrrt() {
        return ztyalmrrthendounksitihsyrrt;
    }

    public void setZtyalmrrthendounksitihsyrrt(String pZtyalmrrthendounksitihsyrrt) {
        ztyalmrrthendounksitihsyrrt = pZtyalmrrthendounksitihsyrrt;
    }

    private Long ztynenkansanp;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYNENKANSANP)
    public Long getZtynenkansanp() {
        return ztynenkansanp;
    }

    public void setZtynenkansanp(Long pZtynenkansanp) {
        ztynenkansanp = pZtynenkansanp;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyyobiv30;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIV30)
    public String getZtyyobiv30() {
        return ztyyobiv30;
    }

    public void setZtyyobiv30(String pZtyyobiv30) {
        ztyyobiv30 = pZtyyobiv30;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztyyobiv8x3;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIV8X3)
    public String getZtyyobiv8x3() {
        return ztyyobiv8x3;
    }

    public void setZtyyobiv8x3(String pZtyyobiv8x3) {
        ztyyobiv8x3 = pZtyyobiv8x3;
    }

    private String ztyyobiv8x4;

    @Column(name=GenZT_AlmNnknHyuTy.ZTYYOBIV8X4)
    public String getZtyyobiv8x4() {
        return ztyyobiv8x4;
    }

    public void setZtyyobiv8x4(String pZtyyobiv8x4) {
        ztyyobiv8x4 = pZtyyobiv8x4;
    }
}
