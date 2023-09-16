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
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.id.PKZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.GenQZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuTy;

/**
 * 事業年度式特約保有Fテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_JigyounndsikiTkHoyuuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JigyounndsikiTkHoyuuTy}</td><td colspan="3">事業年度式特約保有Fテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_JigyounndsikiTkHoyuuTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyoutokuyakukbn ztysuuriyoutokuyakukbn}</td><td>（中継用）数理用特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakugatakbn ztytokuyakugatakbn}</td><td>（中継用）特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukisi ztytokuyakukisi}</td><td>（中継用）特約期始</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyacd ztysisyacd}</td><td>（中継用）支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibucd ztysibucd}</td><td>（中継用）支部コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknhnsktodouhukencd ztyhhknhnsktodouhukencd}</td><td>（中継用）被保険者本籍都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakus ztytokuyakus}</td><td>（中継用）特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysinkeityuutokbn ztysinkeityuutokbn}</td><td>（中継用）新契中途区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusrank ztysyukeiyakusrank}</td><td>（中継用）主契約Ｓランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakuprank ztysyukeiyakuprank}</td><td>（中継用）主契約Ｐランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukykjigyouy ztysyukeiyakukykjigyouy}</td><td>（中継用）主契約契約事業年</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteiskeijihukahyj ztymaruteiskeijihukahyj}</td><td>（中継用）マル定新契約時付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankaisuu ztytenkankaisuu}</td><td>（中継用）転換回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakutokujyoukbn ztytokuyakutokujyoukbn}</td><td>（中継用）特約特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2maruhihyj ztydai2maruhihyj}</td><td>（中継用）第２マル被表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyuusitusetkbn ztytokuteijyuusitusetkbn}</td><td>（中継用）特定重疾セット区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydugktnknsntkhuhukbn ztydugktnknsntkhuhukbn}</td><td>（中継用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakutenkankykhyj ztygengakutenkankykhyj}</td><td>（中継用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitoukbn ztyhaitoukbn}</td><td>（中継用）配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykusnmesyokaipjyuutouym ztykusnmesyokaipjyuutouym}</td><td>（中継用）更新前初回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaitkyksyokusyucd ztysaigaitkyksyokusyucd}</td><td>（中継用）災害特約職種コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygassansrank ztygassansrank}</td><td>（中継用）合算Ｓランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoliplhyj ztytoliplhyj}</td><td>（中継用）ＴＯＬＩＰＬ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhukakbn ztypmenhukakbn}</td><td>（中継用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenkbnv2 ztypmenkbnv2}</td><td>（中継用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketteikijyunkanwakbn ztyketteikijyunkanwakbn}</td><td>（中継用）決定基準緩和区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakusedaikbn ztytokuyakusedaikbn}</td><td>（中継用）特約世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharainissuukbn ztysiharainissuukbn}</td><td>（中継用）支払日数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuseikatakbn ztykakuseikatakbn}</td><td>（中継用）カク成型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeirokbn ztybosyuukeirokbn}</td><td>（中継用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaicd ztydantaicd}</td><td>（中継用）団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpohyj ztypmenhutanpohyj}</td><td>（中継用）Ｐ免不担保表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanhosyouminaosikbn ztytenkanhosyouminaosikbn}</td><td>（中継用）転換保障見直区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouminaosikaisuu ztyhosyouminaosikaisuu}</td><td>（中継用）保障見直回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyqpackhyj ztyqpackhyj}</td><td>（中継用）Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybunkatukbn ztybunkatukbn}</td><td>（中継用）分割区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssnskbn ztystdssnskbn}</td><td>（中継用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssytikbn ztystdssytikbn}</td><td>（中継用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyoukikankbn ztyhosyoukikankbn}</td><td>（中継用）保障期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettisyacd ztydakuhikettisyacd}</td><td>（中継用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukikan ztytokuyakukikan}</td><td>（中継用）特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymannenreihyj ztymannenreihyj}</td><td>（中継用）満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinkbn ztykousinkbn}</td><td>（中継用）更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenhoutekiyouhyouji ztyhokenhoutekiyouhyouji}</td><td>（中継用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyoutaihushrhyj ztytokuteijyoutaihushrhyj}</td><td>（中継用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyousntkjyubbnhyj ztyrendouyousntkjyubbnhyj}</td><td>（中継用）連動用新特条部分表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusentakukeiyakukbn ztymusentakukeiyakukbn}</td><td>（中継用）無選択契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybluekeizokuhyouji ztybluekeizokuhyouji}</td><td>（中継用）Ｂｌｕｅ継続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx2 ztyzyrthntiyustatuskbnx2}</td><td>（中継用）乗率判定用ステータス区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx3 ztyzyrthntiyustatuskbnx3}</td><td>（中継用）乗率判定用ステータス区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx4 ztyzyrthntiyustatuskbnx4}</td><td>（中継用）乗率判定用ステータス区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx5 ztyzyrthntiyustatuskbnx5}</td><td>（中継用）乗率判定用ステータス区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtx2 ztyknkuzusnzyrtx2}</td><td>（中継用）健康増進乗率＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwrbksidhitekiyouhyj ztypwrbksidhitekiyouhyj}</td><td>（中継用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino2 ztydatakanrino2}</td><td>（中継用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino3 ztydatakanrino3}</td><td>（中継用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujivithkhyouji ztysinkeiyakujivithkhyouji}</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin4 ztysuuriyouyobin4}</td><td>（中継用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygaikadatetokuyakus ztygaikadatetokuyakus}</td><td>（中継用）外貨建特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakus ztygaikadatesyukeiyakus}</td><td>（中継用）外貨建主契約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakup ztygaikadatesyukeiyakup}</td><td>（中継用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x2 ztysuuriyouyobin10x2}</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x3 ztyyobiv10x3}</td><td>（中継用）予備項目Ｖ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvatyouseigow ztymvatyouseigow}</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymvakeisanjisknnjynbkn ztymvakeisanjisknnjynbkn}</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_JigyounndsikiTkHoyuuTy
 * @see     PKZT_JigyounndsikiTkHoyuuTy
 * @see     QZT_JigyounndsikiTkHoyuuTy
 * @see     GenQZT_JigyounndsikiTkHoyuuTy
 */
@MappedSuperclass
@Table(name=GenZT_JigyounndsikiTkHoyuuTy.TABLE_NAME)
@IdClass(value=PKZT_JigyounndsikiTkHoyuuTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_JigyounndsikiTkHoyuuTy extends AbstractExDBEntity<ZT_JigyounndsikiTkHoyuuTy, PKZT_JigyounndsikiTkHoyuuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_JigyounndsikiTkHoyuuTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYSUURIYOUTOKUYAKUKBN   = "ztysuuriyoutokuyakukbn";
    public static final String ZTYTOKUYAKUGATAKBN       = "ztytokuyakugatakbn";
    public static final String ZTYTOKUYAKUKISI          = "ztytokuyakukisi";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSISYACD               = "ztysisyacd";
    public static final String ZTYSIBUCD                = "ztysibucd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYHHKNHNSKTODOUHUKENCD  = "ztyhhknhnsktodouhukencd";
    public static final String ZTYTOKUYAKUS             = "ztytokuyakus";
    public static final String ZTYSINKEITYUUTOKBN       = "ztysinkeityuutokbn";
    public static final String ZTYSYUKEIYAKUSRANK       = "ztysyukeiyakusrank";
    public static final String ZTYSYUKEIYAKUPRANK       = "ztysyukeiyakuprank";
    public static final String ZTYSYUKEIYAKUKYKJIGYOUY  = "ztysyukeiyakukykjigyouy";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYMARUTEISKEIJIHUKAHYJ  = "ztymaruteiskeijihukahyj";
    public static final String ZTYTENKANKAISUU          = "ztytenkankaisuu";
    public static final String ZTYTOKUYAKUTOKUJYOUKBN   = "ztytokuyakutokujyoukbn";
    public static final String ZTYDAI2MARUHIHYJ         = "ztydai2maruhihyj";
    public static final String ZTYTOKUTEIJYUUSITUSETKBN = "ztytokuteijyuusitusetkbn";
    public static final String ZTYDUGKTNKNSNTKHUHUKBN   = "ztydugktnknsntkhuhukbn";
    public static final String ZTYGENGAKUTENKANKYKHYJ   = "ztygengakutenkankykhyj";
    public static final String ZTYHAITOUKBN             = "ztyhaitoukbn";
    public static final String ZTYKUSNMESYOKAIPJYUUTOUYM = "ztykusnmesyokaipjyuutouym";
    public static final String ZTYSAIGAITKYKSYOKUSYUCD  = "ztysaigaitkyksyokusyucd";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYGASSANSRANK           = "ztygassansrank";
    public static final String ZTYTOLIPLHYJ             = "ztytoliplhyj";
    public static final String ZTYPMENHUKAKBN           = "ztypmenhukakbn";
    public static final String ZTYPMENKBNV2             = "ztypmenkbnv2";
    public static final String ZTYKETTEIKIJYUNKANWAKBN  = "ztyketteikijyunkanwakbn";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYTOKUYAKUSEDAIKBN      = "ztytokuyakusedaikbn";
    public static final String ZTYSIHARAINISSUUKBN      = "ztysiharainissuukbn";
    public static final String ZTYKAKUSEIKATAKBN        = "ztykakuseikatakbn";
    public static final String ZTYBOSYUUKEIROKBN        = "ztybosyuukeirokbn";
    public static final String ZTYDANTAICD              = "ztydantaicd";
    public static final String ZTYPMENHUTANPOHYJ        = "ztypmenhutanpohyj";
    public static final String ZTYTENKANHOSYOUMINAOSIKBN = "ztytenkanhosyouminaosikbn";
    public static final String ZTYHOSYOUMINAOSIKAISUU   = "ztyhosyouminaosikaisuu";
    public static final String ZTYQPACKHYJ              = "ztyqpackhyj";
    public static final String ZTYBUNKATUKBN            = "ztybunkatukbn";
    public static final String ZTYSTDSSNSKBN            = "ztystdssnskbn";
    public static final String ZTYSTDSSYTIKBN           = "ztystdssytikbn";
    public static final String ZTYHOSYOUKIKANKBN        = "ztyhosyoukikankbn";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYDAKUHIKETTISYACD      = "ztydakuhikettisyacd";
    public static final String ZTYTOKUYAKUKIKAN         = "ztytokuyakukikan";
    public static final String ZTYMANNENREIHYJ          = "ztymannenreihyj";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYKOUSINKBN             = "ztykousinkbn";
    public static final String ZTYHOKENHOUTEKIYOUHYOUJI = "ztyhokenhoutekiyouhyouji";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYTOKUTEIJYOUTAIHUSHRHYJ = "ztytokuteijyoutaihushrhyj";
    public static final String ZTYRENDOUYOUSNTKJYUBBNHYJ = "ztyrendouyousntkjyubbnhyj";
    public static final String ZTYMUSENTAKUKEIYAKUKBN   = "ztymusentakukeiyakukbn";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYBLUEKEIZOKUHYOUJI     = "ztybluekeizokuhyouji";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX2 = "ztyzyrthntiyustatuskbnx2";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX3 = "ztyzyrthntiyustatuskbnx3";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX4 = "ztyzyrthntiyustatuskbnx4";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX5 = "ztyzyrthntiyustatuskbnx5";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYKNKUZUSNZYRTX2        = "ztyknkuzusnzyrtx2";
    public static final String ZTYPWRBKSIDHITEKIYOUHYJ  = "ztypwrbksidhitekiyouhyj";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYDATAKANRINO2          = "ztydatakanrino2";
    public static final String ZTYDATAKANRINO3          = "ztydatakanrino3";
    public static final String ZTYSINKEIYAKUJIVITHKHYOUJI = "ztysinkeiyakujivithkhyouji";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYSUURIYOUYOBIN4        = "ztysuuriyouyobin4";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYGAIKADATETOKUYAKUS    = "ztygaikadatetokuyakus";
    public static final String ZTYGAIKADATESYUKEIYAKUS  = "ztygaikadatesyukeiyakus";
    public static final String ZTYGAIKADATESYUKEIYAKUP  = "ztygaikadatesyukeiyakup";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYSUURIYOUYOBIN10X2     = "ztysuuriyouyobin10x2";
    public static final String ZTYYOBIV10X3             = "ztyyobiv10x3";
    public static final String ZTYMVATYOUSEIGOW         = "ztymvatyouseigow";
    public static final String ZTYMVAKEISANJISKNNJYNBKN = "ztymvakeisanjisknnjynbkn";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";

    private final PKZT_JigyounndsikiTkHoyuuTy primaryKey;

    public GenZT_JigyounndsikiTkHoyuuTy() {
        primaryKey = new PKZT_JigyounndsikiTkHoyuuTy();
    }

    public GenZT_JigyounndsikiTkHoyuuTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_JigyounndsikiTkHoyuuTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_JigyounndsikiTkHoyuuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_JigyounndsikiTkHoyuuTy> getMetaClass() {
        return QZT_JigyounndsikiTkHoyuuTy.class;
    }

    @Id
    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztyyobiv12;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztysuuriyoutokuyakukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSUURIYOUTOKUYAKUKBN)
    public String getZtysuuriyoutokuyakukbn() {
        return ztysuuriyoutokuyakukbn;
    }

    public void setZtysuuriyoutokuyakukbn(String pZtysuuriyoutokuyakukbn) {
        ztysuuriyoutokuyakukbn = pZtysuuriyoutokuyakukbn;
    }

    private String ztytokuyakugatakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUYAKUGATAKBN)
    public String getZtytokuyakugatakbn() {
        return ztytokuyakugatakbn;
    }

    public void setZtytokuyakugatakbn(String pZtytokuyakugatakbn) {
        ztytokuyakugatakbn = pZtytokuyakugatakbn;
    }

    private String ztytokuyakukisi;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUYAKUKISI)
    public String getZtytokuyakukisi() {
        return ztytokuyakukisi;
    }

    public void setZtytokuyakukisi(String pZtytokuyakukisi) {
        ztytokuyakukisi = pZtytokuyakukisi;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysisyacd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSISYACD)
    public String getZtysisyacd() {
        return ztysisyacd;
    }

    public void setZtysisyacd(String pZtysisyacd) {
        ztysisyacd = pZtysisyacd;
    }

    private String ztysibucd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSIBUCD)
    public String getZtysibucd() {
        return ztysibucd;
    }

    public void setZtysibucd(String pZtysibucd) {
        ztysibucd = pZtysibucd;
    }

    private String ztybsyym;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyhhknhnsktodouhukencd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHHKNHNSKTODOUHUKENCD)
    public String getZtyhhknhnsktodouhukencd() {
        return ztyhhknhnsktodouhukencd;
    }

    public void setZtyhhknhnsktodouhukencd(String pZtyhhknhnsktodouhukencd) {
        ztyhhknhnsktodouhukencd = pZtyhhknhnsktodouhukencd;
    }

    private Integer ztytokuyakus;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUYAKUS)
    public Integer getZtytokuyakus() {
        return ztytokuyakus;
    }

    public void setZtytokuyakus(Integer pZtytokuyakus) {
        ztytokuyakus = pZtytokuyakus;
    }

    private String ztysinkeityuutokbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSINKEITYUUTOKBN)
    public String getZtysinkeityuutokbn() {
        return ztysinkeityuutokbn;
    }

    public void setZtysinkeityuutokbn(String pZtysinkeityuutokbn) {
        ztysinkeityuutokbn = pZtysinkeityuutokbn;
    }

    private String ztysyukeiyakusrank;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSYUKEIYAKUSRANK)
    public String getZtysyukeiyakusrank() {
        return ztysyukeiyakusrank;
    }

    public void setZtysyukeiyakusrank(String pZtysyukeiyakusrank) {
        ztysyukeiyakusrank = pZtysyukeiyakusrank;
    }

    private String ztysyukeiyakuprank;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSYUKEIYAKUPRANK)
    public String getZtysyukeiyakuprank() {
        return ztysyukeiyakuprank;
    }

    public void setZtysyukeiyakuprank(String pZtysyukeiyakuprank) {
        ztysyukeiyakuprank = pZtysyukeiyakuprank;
    }

    private String ztysyukeiyakukykjigyouy;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSYUKEIYAKUKYKJIGYOUY)
    public String getZtysyukeiyakukykjigyouy() {
        return ztysyukeiyakukykjigyouy;
    }

    public void setZtysyukeiyakukykjigyouy(String pZtysyukeiyakukykjigyouy) {
        ztysyukeiyakukykjigyouy = pZtysyukeiyakukykjigyouy;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztymaruteiskeijihukahyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYMARUTEISKEIJIHUKAHYJ)
    public String getZtymaruteiskeijihukahyj() {
        return ztymaruteiskeijihukahyj;
    }

    public void setZtymaruteiskeijihukahyj(String pZtymaruteiskeijihukahyj) {
        ztymaruteiskeijihukahyj = pZtymaruteiskeijihukahyj;
    }

    private String ztytenkankaisuu;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private String ztytokuyakutokujyoukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUYAKUTOKUJYOUKBN)
    public String getZtytokuyakutokujyoukbn() {
        return ztytokuyakutokujyoukbn;
    }

    public void setZtytokuyakutokujyoukbn(String pZtytokuyakutokujyoukbn) {
        ztytokuyakutokujyoukbn = pZtytokuyakutokujyoukbn;
    }

    private String ztydai2maruhihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDAI2MARUHIHYJ)
    public String getZtydai2maruhihyj() {
        return ztydai2maruhihyj;
    }

    public void setZtydai2maruhihyj(String pZtydai2maruhihyj) {
        ztydai2maruhihyj = pZtydai2maruhihyj;
    }

    private String ztytokuteijyuusitusetkbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUTEIJYUUSITUSETKBN)
    public String getZtytokuteijyuusitusetkbn() {
        return ztytokuteijyuusitusetkbn;
    }

    public void setZtytokuteijyuusitusetkbn(String pZtytokuteijyuusitusetkbn) {
        ztytokuteijyuusitusetkbn = pZtytokuteijyuusitusetkbn;
    }

    private String ztydugktnknsntkhuhukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDUGKTNKNSNTKHUHUKBN)
    public String getZtydugktnknsntkhuhukbn() {
        return ztydugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydugktnknsntkhuhukbn(String pZtydugktnknsntkhuhukbn) {
        ztydugktnknsntkhuhukbn = pZtydugktnknsntkhuhukbn;
    }

    private String ztygengakutenkankykhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYGENGAKUTENKANKYKHYJ)
    public String getZtygengakutenkankykhyj() {
        return ztygengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygengakutenkankykhyj(String pZtygengakutenkankykhyj) {
        ztygengakutenkankykhyj = pZtygengakutenkankykhyj;
    }

    private String ztyhaitoukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztykusnmesyokaipjyuutouym;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKUSNMESYOKAIPJYUUTOUYM)
    public String getZtykusnmesyokaipjyuutouym() {
        return ztykusnmesyokaipjyuutouym;
    }

    public void setZtykusnmesyokaipjyuutouym(String pZtykusnmesyokaipjyuutouym) {
        ztykusnmesyokaipjyuutouym = pZtykusnmesyokaipjyuutouym;
    }

    private String ztysaigaitkyksyokusyucd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSAIGAITKYKSYOKUSYUCD)
    public String getZtysaigaitkyksyokusyucd() {
        return ztysaigaitkyksyokusyucd;
    }

    public void setZtysaigaitkyksyokusyucd(String pZtysaigaitkyksyokusyucd) {
        ztysaigaitkyksyokusyucd = pZtysaigaitkyksyokusyucd;
    }

    private String ztysykgycd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztygassansrank;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYGASSANSRANK)
    public String getZtygassansrank() {
        return ztygassansrank;
    }

    public void setZtygassansrank(String pZtygassansrank) {
        ztygassansrank = pZtygassansrank;
    }

    private String ztytoliplhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOLIPLHYJ)
    public String getZtytoliplhyj() {
        return ztytoliplhyj;
    }

    public void setZtytoliplhyj(String pZtytoliplhyj) {
        ztytoliplhyj = pZtytoliplhyj;
    }

    private String ztypmenhukakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYPMENHUKAKBN)
    public String getZtypmenhukakbn() {
        return ztypmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtypmenhukakbn(String pZtypmenhukakbn) {
        ztypmenhukakbn = pZtypmenhukakbn;
    }

    private String ztypmenkbnv2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYPMENKBNV2)
    public String getZtypmenkbnv2() {
        return ztypmenkbnv2;
    }

    public void setZtypmenkbnv2(String pZtypmenkbnv2) {
        ztypmenkbnv2 = pZtypmenkbnv2;
    }

    private String ztyketteikijyunkanwakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKETTEIKIJYUNKANWAKBN)
    public String getZtyketteikijyunkanwakbn() {
        return ztyketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyketteikijyunkanwakbn(String pZtyketteikijyunkanwakbn) {
        ztyketteikijyunkanwakbn = pZtyketteikijyunkanwakbn;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztytokuyakusedaikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUYAKUSEDAIKBN)
    public String getZtytokuyakusedaikbn() {
        return ztytokuyakusedaikbn;
    }

    public void setZtytokuyakusedaikbn(String pZtytokuyakusedaikbn) {
        ztytokuyakusedaikbn = pZtytokuyakusedaikbn;
    }

    private String ztysiharainissuukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSIHARAINISSUUKBN)
    public String getZtysiharainissuukbn() {
        return ztysiharainissuukbn;
    }

    public void setZtysiharainissuukbn(String pZtysiharainissuukbn) {
        ztysiharainissuukbn = pZtysiharainissuukbn;
    }

    private String ztykakuseikatakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKAKUSEIKATAKBN)
    public String getZtykakuseikatakbn() {
        return ztykakuseikatakbn;
    }

    public void setZtykakuseikatakbn(String pZtykakuseikatakbn) {
        ztykakuseikatakbn = pZtykakuseikatakbn;
    }

    private String ztybosyuukeirokbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYBOSYUUKEIROKBN)
    public String getZtybosyuukeirokbn() {
        return ztybosyuukeirokbn;
    }

    public void setZtybosyuukeirokbn(String pZtybosyuukeirokbn) {
        ztybosyuukeirokbn = pZtybosyuukeirokbn;
    }

    private String ztydantaicd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDANTAICD)
    public String getZtydantaicd() {
        return ztydantaicd;
    }

    public void setZtydantaicd(String pZtydantaicd) {
        ztydantaicd = pZtydantaicd;
    }

    private String ztypmenhutanpohyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYPMENHUTANPOHYJ)
    public String getZtypmenhutanpohyj() {
        return ztypmenhutanpohyj;
    }

    public void setZtypmenhutanpohyj(String pZtypmenhutanpohyj) {
        ztypmenhutanpohyj = pZtypmenhutanpohyj;
    }

    private String ztytenkanhosyouminaosikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTENKANHOSYOUMINAOSIKBN)
    public String getZtytenkanhosyouminaosikbn() {
        return ztytenkanhosyouminaosikbn;
    }

    public void setZtytenkanhosyouminaosikbn(String pZtytenkanhosyouminaosikbn) {
        ztytenkanhosyouminaosikbn = pZtytenkanhosyouminaosikbn;
    }

    private String ztyhosyouminaosikaisuu;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHOSYOUMINAOSIKAISUU)
    public String getZtyhosyouminaosikaisuu() {
        return ztyhosyouminaosikaisuu;
    }

    public void setZtyhosyouminaosikaisuu(String pZtyhosyouminaosikaisuu) {
        ztyhosyouminaosikaisuu = pZtyhosyouminaosikaisuu;
    }

    private String ztyqpackhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYQPACKHYJ)
    public String getZtyqpackhyj() {
        return ztyqpackhyj;
    }

    public void setZtyqpackhyj(String pZtyqpackhyj) {
        ztyqpackhyj = pZtyqpackhyj;
    }

    private String ztybunkatukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYBUNKATUKBN)
    public String getZtybunkatukbn() {
        return ztybunkatukbn;
    }

    public void setZtybunkatukbn(String pZtybunkatukbn) {
        ztybunkatukbn = pZtybunkatukbn;
    }

    private String ztystdssnskbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSTDSSNSKBN)
    public String getZtystdssnskbn() {
        return ztystdssnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssnskbn(String pZtystdssnskbn) {
        ztystdssnskbn = pZtystdssnskbn;
    }

    private String ztystdssytikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztyhosyoukikankbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHOSYOUKIKANKBN)
    public String getZtyhosyoukikankbn() {
        return ztyhosyoukikankbn;
    }

    public void setZtyhosyoukikankbn(String pZtyhosyoukikankbn) {
        ztyhosyoukikankbn = pZtyhosyoukikankbn;
    }

    private String ztykeijyouym;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztydakuhikettisyacd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDAKUHIKETTISYACD)
    public String getZtydakuhikettisyacd() {
        return ztydakuhikettisyacd;
    }

    public void setZtydakuhikettisyacd(String pZtydakuhikettisyacd) {
        ztydakuhikettisyacd = pZtydakuhikettisyacd;
    }

    private String ztytokuyakukikan;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUYAKUKIKAN)
    public String getZtytokuyakukikan() {
        return ztytokuyakukikan;
    }

    public void setZtytokuyakukikan(String pZtytokuyakukikan) {
        ztytokuyakukikan = pZtytokuyakukikan;
    }

    private String ztymannenreihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYMANNENREIHYJ)
    public String getZtymannenreihyj() {
        return ztymannenreihyj;
    }

    public void setZtymannenreihyj(String pZtymannenreihyj) {
        ztymannenreihyj = pZtymannenreihyj;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztykousinkbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKOUSINKBN)
    public String getZtykousinkbn() {
        return ztykousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinkbn(String pZtykousinkbn) {
        ztykousinkbn = pZtykousinkbn;
    }

    private String ztyhokenhoutekiyouhyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYHOKENHOUTEKIYOUHYOUJI)
    public String getZtyhokenhoutekiyouhyouji() {
        return ztyhokenhoutekiyouhyouji;
    }

    public void setZtyhokenhoutekiyouhyouji(String pZtyhokenhoutekiyouhyouji) {
        ztyhokenhoutekiyouhyouji = pZtyhokenhoutekiyouhyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private String ztyrendouyousntkjyubbnhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYRENDOUYOUSNTKJYUBBNHYJ)
    public String getZtyrendouyousntkjyubbnhyj() {
        return ztyrendouyousntkjyubbnhyj;
    }

    public void setZtyrendouyousntkjyubbnhyj(String pZtyrendouyousntkjyubbnhyj) {
        ztyrendouyousntkjyubbnhyj = pZtyrendouyousntkjyubbnhyj;
    }

    private String ztymusentakukeiyakukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYMUSENTAKUKEIYAKUKBN)
    public String getZtymusentakukeiyakukbn() {
        return ztymusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymusentakukeiyakukbn(String pZtymusentakukeiyakukbn) {
        ztymusentakukeiyakukbn = pZtymusentakukeiyakukbn;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztybluekeizokuhyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYBLUEKEIZOKUHYOUJI)
    public String getZtybluekeizokuhyouji() {
        return ztybluekeizokuhyouji;
    }

    public void setZtybluekeizokuhyouji(String pZtybluekeizokuhyouji) {
        ztybluekeizokuhyouji = pZtybluekeizokuhyouji;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyzyrthntiyustatuskbnx2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYZYRTHNTIYUSTATUSKBNX2)
    public String getZtyzyrthntiyustatuskbnx2() {
        return ztyzyrthntiyustatuskbnx2;
    }

    public void setZtyzyrthntiyustatuskbnx2(String pZtyzyrthntiyustatuskbnx2) {
        ztyzyrthntiyustatuskbnx2 = pZtyzyrthntiyustatuskbnx2;
    }

    private String ztyzyrthntiyustatuskbnx3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYZYRTHNTIYUSTATUSKBNX3)
    public String getZtyzyrthntiyustatuskbnx3() {
        return ztyzyrthntiyustatuskbnx3;
    }

    public void setZtyzyrthntiyustatuskbnx3(String pZtyzyrthntiyustatuskbnx3) {
        ztyzyrthntiyustatuskbnx3 = pZtyzyrthntiyustatuskbnx3;
    }

    private String ztyzyrthntiyustatuskbnx4;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYZYRTHNTIYUSTATUSKBNX4)
    public String getZtyzyrthntiyustatuskbnx4() {
        return ztyzyrthntiyustatuskbnx4;
    }

    public void setZtyzyrthntiyustatuskbnx4(String pZtyzyrthntiyustatuskbnx4) {
        ztyzyrthntiyustatuskbnx4 = pZtyzyrthntiyustatuskbnx4;
    }

    private String ztyzyrthntiyustatuskbnx5;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYZYRTHNTIYUSTATUSKBNX5)
    public String getZtyzyrthntiyustatuskbnx5() {
        return ztyzyrthntiyustatuskbnx5;
    }

    public void setZtyzyrthntiyustatuskbnx5(String pZtyzyrthntiyustatuskbnx5) {
        ztyzyrthntiyustatuskbnx5 = pZtyzyrthntiyustatuskbnx5;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyknkuzusnzyrtx2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKNKUZUSNZYRTX2)
    public String getZtyknkuzusnzyrtx2() {
        return ztyknkuzusnzyrtx2;
    }

    public void setZtyknkuzusnzyrtx2(String pZtyknkuzusnzyrtx2) {
        ztyknkuzusnzyrtx2 = pZtyknkuzusnzyrtx2;
    }

    private String ztypwrbksidhitekiyouhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYPWRBKSIDHITEKIYOUHYJ)
    public String getZtypwrbksidhitekiyouhyj() {
        return ztypwrbksidhitekiyouhyj;
    }

    public void setZtypwrbksidhitekiyouhyj(String pZtypwrbksidhitekiyouhyj) {
        ztypwrbksidhitekiyouhyj = pZtypwrbksidhitekiyouhyj;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztydatakanrino2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDATAKANRINO2)
    public String getZtydatakanrino2() {
        return ztydatakanrino2;
    }

    public void setZtydatakanrino2(String pZtydatakanrino2) {
        ztydatakanrino2 = pZtydatakanrino2;
    }

    private String ztydatakanrino3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYDATAKANRINO3)
    public String getZtydatakanrino3() {
        return ztydatakanrino3;
    }

    public void setZtydatakanrino3(String pZtydatakanrino3) {
        ztydatakanrino3 = pZtydatakanrino3;
    }

    private String ztysinkeiyakujivithkhyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSINKEIYAKUJIVITHKHYOUJI)
    public String getZtysinkeiyakujivithkhyouji() {
        return ztysinkeiyakujivithkhyouji;
    }

    public void setZtysinkeiyakujivithkhyouji(String pZtysinkeiyakujivithkhyouji) {
        ztysinkeiyakujivithkhyouji = pZtysinkeiyakujivithkhyouji;
    }

    private String ztykykymd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztysuuriyouyobin4;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSUURIYOUYOBIN4)
    public String getZtysuuriyouyobin4() {
        return ztysuuriyouyobin4;
    }

    public void setZtysuuriyouyobin4(String pZtysuuriyouyobin4) {
        ztysuuriyouyobin4 = pZtysuuriyouyobin4;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private Long ztygaikadatetokuyakus;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYGAIKADATETOKUYAKUS)
    public Long getZtygaikadatetokuyakus() {
        return ztygaikadatetokuyakus;
    }

    public void setZtygaikadatetokuyakus(Long pZtygaikadatetokuyakus) {
        ztygaikadatetokuyakus = pZtygaikadatetokuyakus;
    }

    private Long ztygaikadatesyukeiyakus;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYGAIKADATESYUKEIYAKUS)
    public Long getZtygaikadatesyukeiyakus() {
        return ztygaikadatesyukeiyakus;
    }

    public void setZtygaikadatesyukeiyakus(Long pZtygaikadatesyukeiyakus) {
        ztygaikadatesyukeiyakus = pZtygaikadatesyukeiyakus;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztysuuriyouyobin10x2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYSUURIYOUYOBIN10X2)
    public String getZtysuuriyouyobin10x2() {
        return ztysuuriyouyobin10x2;
    }

    public void setZtysuuriyouyobin10x2(String pZtysuuriyouyobin10x2) {
        ztysuuriyouyobin10x2 = pZtysuuriyouyobin10x2;
    }

    private String ztyyobiv10x3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYYOBIV10X3)
    public String getZtyyobiv10x3() {
        return ztyyobiv10x3;
    }

    public void setZtyyobiv10x3(String pZtyyobiv10x3) {
        ztyyobiv10x3 = pZtyyobiv10x3;
    }

    private Long ztymvatyouseigow;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYMVATYOUSEIGOW)
    public Long getZtymvatyouseigow() {
        return ztymvatyouseigow;
    }

    public void setZtymvatyouseigow(Long pZtymvatyouseigow) {
        ztymvatyouseigow = pZtymvatyouseigow;
    }

    private Long ztymvakeisanjisknnjynbkn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYMVAKEISANJISKNNJYNBKN)
    public Long getZtymvakeisanjisknnjynbkn() {
        return ztymvakeisanjisknnjynbkn;
    }

    public void setZtymvakeisanjisknnjynbkn(Long pZtymvakeisanjisknnjynbkn) {
        ztymvakeisanjisknnjynbkn = pZtymvakeisanjisknnjynbkn;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_JigyounndsikiTkHoyuuTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }
}