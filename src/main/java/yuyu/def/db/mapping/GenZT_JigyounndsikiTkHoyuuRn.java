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
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.id.PKZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.meta.GenQZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuRn;

/**
 * 事業年度式特約保有Fテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_JigyounndsikiTkHoyuuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_JigyounndsikiTkHoyuuRn}</td><td colspan="3">事業年度式特約保有Fテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_JigyounndsikiTkHoyuuRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyoutokuyakukbn zrnsuuriyoutokuyakukbn}</td><td>（連携用）数理用特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakugatakbn zrntokuyakugatakbn}</td><td>（連携用）特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukisi zrntokuyakukisi}</td><td>（連携用）特約期始</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyacd zrnsisyacd}</td><td>（連携用）支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibucd zrnsibucd}</td><td>（連携用）支部コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknhnsktodouhukencd zrnhhknhnsktodouhukencd}</td><td>（連携用）被保険者本籍都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakus zrntokuyakus}</td><td>（連携用）特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsinkeityuutokbn zrnsinkeityuutokbn}</td><td>（連携用）新契中途区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusrank zrnsyukeiyakusrank}</td><td>（連携用）主契約Ｓランク</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakuprank zrnsyukeiyakuprank}</td><td>（連携用）主契約Ｐランク</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukykjigyouy zrnsyukeiyakukykjigyouy}</td><td>（連携用）主契約契約事業年</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteiskeijihukahyj zrnmaruteiskeijihukahyj}</td><td>（連携用）マル定新契約時付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankaisuu zrntenkankaisuu}</td><td>（連携用）転換回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakutokujyoukbn zrntokuyakutokujyoukbn}</td><td>（連携用）特約特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2maruhihyj zrndai2maruhihyj}</td><td>（連携用）第２マル被表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyuusitusetkbn zrntokuteijyuusitusetkbn}</td><td>（連携用）特定重疾セット区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndugktnknsntkhuhukbn zrndugktnknsntkhuhukbn}</td><td>（連携用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakutenkankykhyj zrngengakutenkankykhyj}</td><td>（連携用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitoukbn zrnhaitoukbn}</td><td>（連携用）配当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkusnmesyokaipjyuutouym zrnkusnmesyokaipjyuutouym}</td><td>（連携用）更新前初回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaitkyksyokusyucd zrnsaigaitkyksyokusyucd}</td><td>（連携用）災害特約職種コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngassansrank zrngassansrank}</td><td>（連携用）合算Ｓランク</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoliplhyj zrntoliplhyj}</td><td>（連携用）ＴＯＬＩＰＬ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhukakbn zrnpmenhukakbn}</td><td>（連携用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbnv2 zrnpmenkbnv2}</td><td>（連携用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketteikijyunkanwakbn zrnketteikijyunkanwakbn}</td><td>（連携用）決定基準緩和区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakusedaikbn zrntokuyakusedaikbn}</td><td>（連携用）特約世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharainissuukbn zrnsiharainissuukbn}</td><td>（連携用）支払日数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuseikatakbn zrnkakuseikatakbn}</td><td>（連携用）カク成型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeirokbn zrnbosyuukeirokbn}</td><td>（連携用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaicd zrndantaicd}</td><td>（連携用）団体コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpohyj zrnpmenhutanpohyj}</td><td>（連携用）Ｐ免不担保表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanhosyouminaosikbn zrntenkanhosyouminaosikbn}</td><td>（連携用）転換保障見直区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouminaosikaisuu zrnhosyouminaosikaisuu}</td><td>（連携用）保障見直回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnqpackhyj zrnqpackhyj}</td><td>（連携用）Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbunkatukbn zrnbunkatukbn}</td><td>（連携用）分割区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssnskbn zrnstdssnskbn}</td><td>（連携用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyoukikankbn zrnhosyoukikankbn}</td><td>（連携用）保障期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettisyacd zrndakuhikettisyacd}</td><td>（連携用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukikan zrntokuyakukikan}</td><td>（連携用）特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmannenreihyj zrnmannenreihyj}</td><td>（連携用）満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinkbn zrnkousinkbn}</td><td>（連携用）更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenhoutekiyouhyouji zrnhokenhoutekiyouhyouji}</td><td>（連携用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyoutaihushrhyj zrntokuteijyoutaihushrhyj}</td><td>（連携用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyousntkjyubbnhyj zrnrendouyousntkjyubbnhyj}</td><td>（連携用）連動用新特条部分表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusentakukeiyakukbn zrnmusentakukeiyakukbn}</td><td>（連携用）無選択契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluekeizokuhyouji zrnbluekeizokuhyouji}</td><td>（連携用）Ｂｌｕｅ継続表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx2 zrnzyrthntiyustatuskbnx2}</td><td>（連携用）乗率判定用ステータス区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx3 zrnzyrthntiyustatuskbnx3}</td><td>（連携用）乗率判定用ステータス区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx4 zrnzyrthntiyustatuskbnx4}</td><td>（連携用）乗率判定用ステータス区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbnx5 zrnzyrthntiyustatuskbnx5}</td><td>（連携用）乗率判定用ステータス区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtx2 zrnknkuzusnzyrtx2}</td><td>（連携用）健康増進乗率＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwrbksidhitekiyouhyj zrnpwrbksidhitekiyouhyj}</td><td>（連携用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino2 zrndatakanrino2}</td><td>（連携用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino3 zrndatakanrino3}</td><td>（連携用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujivithkhyouji zrnsinkeiyakujivithkhyouji}</td><td>（連携用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin4 zrnsuuriyouyobin4}</td><td>（連携用）数理用予備項目Ｎ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngaikadatetokuyakus zrngaikadatetokuyakus}</td><td>（連携用）外貨建特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakus zrngaikadatesyukeiyakus}</td><td>（連携用）外貨建主契約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakup zrngaikadatesyukeiyakup}</td><td>（連携用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x2 zrnsuuriyouyobin10x2}</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x3 zrnyobiv10x3}</td><td>（連携用）予備項目Ｖ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseigow zrnmvatyouseigow}</td><td>（連携用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmvakeisanjisknnjynbkn zrnmvakeisanjisknnjynbkn}</td><td>（連携用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     ZT_JigyounndsikiTkHoyuuRn
 * @see     PKZT_JigyounndsikiTkHoyuuRn
 * @see     QZT_JigyounndsikiTkHoyuuRn
 * @see     GenQZT_JigyounndsikiTkHoyuuRn
 */
@MappedSuperclass
@Table(name=GenZT_JigyounndsikiTkHoyuuRn.TABLE_NAME)
@IdClass(value=PKZT_JigyounndsikiTkHoyuuRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_JigyounndsikiTkHoyuuRn extends AbstractExDBEntityForZDB<ZT_JigyounndsikiTkHoyuuRn, PKZT_JigyounndsikiTkHoyuuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_JigyounndsikiTkHoyuuRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNSUURIYOUTOKUYAKUKBN   = "zrnsuuriyoutokuyakukbn";
    public static final String ZRNTOKUYAKUGATAKBN       = "zrntokuyakugatakbn";
    public static final String ZRNTOKUYAKUKISI          = "zrntokuyakukisi";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSISYACD               = "zrnsisyacd";
    public static final String ZRNSIBUCD                = "zrnsibucd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNHHKNHNSKTODOUHUKENCD  = "zrnhhknhnsktodouhukencd";
    public static final String ZRNTOKUYAKUS             = "zrntokuyakus";
    public static final String ZRNSINKEITYUUTOKBN       = "zrnsinkeityuutokbn";
    public static final String ZRNSYUKEIYAKUSRANK       = "zrnsyukeiyakusrank";
    public static final String ZRNSYUKEIYAKUPRANK       = "zrnsyukeiyakuprank";
    public static final String ZRNSYUKEIYAKUKYKJIGYOUY  = "zrnsyukeiyakukykjigyouy";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNMARUTEISKEIJIHUKAHYJ  = "zrnmaruteiskeijihukahyj";
    public static final String ZRNTENKANKAISUU          = "zrntenkankaisuu";
    public static final String ZRNTOKUYAKUTOKUJYOUKBN   = "zrntokuyakutokujyoukbn";
    public static final String ZRNDAI2MARUHIHYJ         = "zrndai2maruhihyj";
    public static final String ZRNTOKUTEIJYUUSITUSETKBN = "zrntokuteijyuusitusetkbn";
    public static final String ZRNDUGKTNKNSNTKHUHUKBN   = "zrndugktnknsntkhuhukbn";
    public static final String ZRNGENGAKUTENKANKYKHYJ   = "zrngengakutenkankykhyj";
    public static final String ZRNHAITOUKBN             = "zrnhaitoukbn";
    public static final String ZRNKUSNMESYOKAIPJYUUTOUYM = "zrnkusnmesyokaipjyuutouym";
    public static final String ZRNSAIGAITKYKSYOKUSYUCD  = "zrnsaigaitkyksyokusyucd";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNGASSANSRANK           = "zrngassansrank";
    public static final String ZRNTOLIPLHYJ             = "zrntoliplhyj";
    public static final String ZRNPMENHUKAKBN           = "zrnpmenhukakbn";
    public static final String ZRNPMENKBNV2             = "zrnpmenkbnv2";
    public static final String ZRNKETTEIKIJYUNKANWAKBN  = "zrnketteikijyunkanwakbn";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNTOKUYAKUSEDAIKBN      = "zrntokuyakusedaikbn";
    public static final String ZRNSIHARAINISSUUKBN      = "zrnsiharainissuukbn";
    public static final String ZRNKAKUSEIKATAKBN        = "zrnkakuseikatakbn";
    public static final String ZRNBOSYUUKEIROKBN        = "zrnbosyuukeirokbn";
    public static final String ZRNDANTAICD              = "zrndantaicd";
    public static final String ZRNPMENHUTANPOHYJ        = "zrnpmenhutanpohyj";
    public static final String ZRNTENKANHOSYOUMINAOSIKBN = "zrntenkanhosyouminaosikbn";
    public static final String ZRNHOSYOUMINAOSIKAISUU   = "zrnhosyouminaosikaisuu";
    public static final String ZRNQPACKHYJ              = "zrnqpackhyj";
    public static final String ZRNBUNKATUKBN            = "zrnbunkatukbn";
    public static final String ZRNSTDSSNSKBN            = "zrnstdssnskbn";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNHOSYOUKIKANKBN        = "zrnhosyoukikankbn";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNDAKUHIKETTISYACD      = "zrndakuhikettisyacd";
    public static final String ZRNTOKUYAKUKIKAN         = "zrntokuyakukikan";
    public static final String ZRNMANNENREIHYJ          = "zrnmannenreihyj";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNKOUSINKBN             = "zrnkousinkbn";
    public static final String ZRNHOKENHOUTEKIYOUHYOUJI = "zrnhokenhoutekiyouhyouji";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNTOKUTEIJYOUTAIHUSHRHYJ = "zrntokuteijyoutaihushrhyj";
    public static final String ZRNRENDOUYOUSNTKJYUBBNHYJ = "zrnrendouyousntkjyubbnhyj";
    public static final String ZRNMUSENTAKUKEIYAKUKBN   = "zrnmusentakukeiyakukbn";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNBLUEKEIZOKUHYOUJI     = "zrnbluekeizokuhyouji";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX2 = "zrnzyrthntiyustatuskbnx2";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX3 = "zrnzyrthntiyustatuskbnx3";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX4 = "zrnzyrthntiyustatuskbnx4";
    public static final String ZRNZYRTHNTIYUSTATUSKBNX5 = "zrnzyrthntiyustatuskbnx5";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNKNKUZUSNZYRTX2        = "zrnknkuzusnzyrtx2";
    public static final String ZRNPWRBKSIDHITEKIYOUHYJ  = "zrnpwrbksidhitekiyouhyj";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNDATAKANRINO2          = "zrndatakanrino2";
    public static final String ZRNDATAKANRINO3          = "zrndatakanrino3";
    public static final String ZRNSINKEIYAKUJIVITHKHYOUJI = "zrnsinkeiyakujivithkhyouji";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNSUURIYOUYOBIN4        = "zrnsuuriyouyobin4";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNGAIKADATETOKUYAKUS    = "zrngaikadatetokuyakus";
    public static final String ZRNGAIKADATESYUKEIYAKUS  = "zrngaikadatesyukeiyakus";
    public static final String ZRNGAIKADATESYUKEIYAKUP  = "zrngaikadatesyukeiyakup";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNSUURIYOUYOBIN10X2     = "zrnsuuriyouyobin10x2";
    public static final String ZRNYOBIV10X3             = "zrnyobiv10x3";
    public static final String ZRNMVATYOUSEIGOW         = "zrnmvatyouseigow";
    public static final String ZRNMVAKEISANJISKNNJYNBKN = "zrnmvakeisanjisknnjynbkn";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";

    private final PKZT_JigyounndsikiTkHoyuuRn primaryKey;

    public GenZT_JigyounndsikiTkHoyuuRn() {
        primaryKey = new PKZT_JigyounndsikiTkHoyuuRn();
    }

    public GenZT_JigyounndsikiTkHoyuuRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_JigyounndsikiTkHoyuuRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_JigyounndsikiTkHoyuuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_JigyounndsikiTkHoyuuRn> getMetaClass() {
        return QZT_JigyounndsikiTkHoyuuRn.class;
    }

    @Id
    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnyobiv12;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnsuuriyoutokuyakukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSUURIYOUTOKUYAKUKBN)
    public String getZrnsuuriyoutokuyakukbn() {
        return zrnsuuriyoutokuyakukbn;
    }

    public void setZrnsuuriyoutokuyakukbn(String pZrnsuuriyoutokuyakukbn) {
        zrnsuuriyoutokuyakukbn = pZrnsuuriyoutokuyakukbn;
    }

    private String zrntokuyakugatakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUYAKUGATAKBN)
    public String getZrntokuyakugatakbn() {
        return zrntokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakugatakbn(String pZrntokuyakugatakbn) {
        zrntokuyakugatakbn = pZrntokuyakugatakbn;
    }

    private String zrntokuyakukisi;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUYAKUKISI)
    public String getZrntokuyakukisi() {
        return zrntokuyakukisi;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntokuyakukisi(String pZrntokuyakukisi) {
        zrntokuyakukisi = pZrntokuyakukisi;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsisyacd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSISYACD)
    public String getZrnsisyacd() {
        return zrnsisyacd;
    }

    public void setZrnsisyacd(String pZrnsisyacd) {
        zrnsisyacd = pZrnsisyacd;
    }

    private String zrnsibucd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSIBUCD)
    public String getZrnsibucd() {
        return zrnsibucd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsibucd(String pZrnsibucd) {
        zrnsibucd = pZrnsibucd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnhhknhnsktodouhukencd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHHKNHNSKTODOUHUKENCD)
    public String getZrnhhknhnsktodouhukencd() {
        return zrnhhknhnsktodouhukencd;
    }

    public void setZrnhhknhnsktodouhukencd(String pZrnhhknhnsktodouhukencd) {
        zrnhhknhnsktodouhukencd = pZrnhhknhnsktodouhukencd;
    }

    private Integer zrntokuyakus;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUYAKUS)
    public Integer getZrntokuyakus() {
        return zrntokuyakus;
    }

    public void setZrntokuyakus(Integer pZrntokuyakus) {
        zrntokuyakus = pZrntokuyakus;
    }

    private String zrnsinkeityuutokbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSINKEITYUUTOKBN)
    public String getZrnsinkeityuutokbn() {
        return zrnsinkeityuutokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinkeityuutokbn(String pZrnsinkeityuutokbn) {
        zrnsinkeityuutokbn = pZrnsinkeityuutokbn;
    }

    private String zrnsyukeiyakusrank;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSYUKEIYAKUSRANK)
    public String getZrnsyukeiyakusrank() {
        return zrnsyukeiyakusrank;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyukeiyakusrank(String pZrnsyukeiyakusrank) {
        zrnsyukeiyakusrank = pZrnsyukeiyakusrank;
    }

    private String zrnsyukeiyakuprank;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSYUKEIYAKUPRANK)
    public String getZrnsyukeiyakuprank() {
        return zrnsyukeiyakuprank;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyukeiyakuprank(String pZrnsyukeiyakuprank) {
        zrnsyukeiyakuprank = pZrnsyukeiyakuprank;
    }

    private String zrnsyukeiyakukykjigyouy;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSYUKEIYAKUKYKJIGYOUY)
    public String getZrnsyukeiyakukykjigyouy() {
        return zrnsyukeiyakukykjigyouy;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsyukeiyakukykjigyouy(String pZrnsyukeiyakukykjigyouy) {
        zrnsyukeiyakukykjigyouy = pZrnsyukeiyakukykjigyouy;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnmaruteiskeijihukahyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNMARUTEISKEIJIHUKAHYJ)
    public String getZrnmaruteiskeijihukahyj() {
        return zrnmaruteiskeijihukahyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteiskeijihukahyj(String pZrnmaruteiskeijihukahyj) {
        zrnmaruteiskeijihukahyj = pZrnmaruteiskeijihukahyj;
    }

    private String zrntenkankaisuu;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTENKANKAISUU)
    public String getZrntenkankaisuu() {
        return zrntenkankaisuu;
    }

    public void setZrntenkankaisuu(String pZrntenkankaisuu) {
        zrntenkankaisuu = pZrntenkankaisuu;
    }

    private String zrntokuyakutokujyoukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUYAKUTOKUJYOUKBN)
    public String getZrntokuyakutokujyoukbn() {
        return zrntokuyakutokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakutokujyoukbn(String pZrntokuyakutokujyoukbn) {
        zrntokuyakutokujyoukbn = pZrntokuyakutokujyoukbn;
    }

    private String zrndai2maruhihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDAI2MARUHIHYJ)
    public String getZrndai2maruhihyj() {
        return zrndai2maruhihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2maruhihyj(String pZrndai2maruhihyj) {
        zrndai2maruhihyj = pZrndai2maruhihyj;
    }

    private String zrntokuteijyuusitusetkbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUTEIJYUUSITUSETKBN)
    public String getZrntokuteijyuusitusetkbn() {
        return zrntokuteijyuusitusetkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyuusitusetkbn(String pZrntokuteijyuusitusetkbn) {
        zrntokuteijyuusitusetkbn = pZrntokuteijyuusitusetkbn;
    }

    private String zrndugktnknsntkhuhukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDUGKTNKNSNTKHUHUKBN)
    public String getZrndugktnknsntkhuhukbn() {
        return zrndugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndugktnknsntkhuhukbn(String pZrndugktnknsntkhuhukbn) {
        zrndugktnknsntkhuhukbn = pZrndugktnknsntkhuhukbn;
    }

    private String zrngengakutenkankykhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNGENGAKUTENKANKYKHYJ)
    public String getZrngengakutenkankykhyj() {
        return zrngengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngengakutenkankykhyj(String pZrngengakutenkankykhyj) {
        zrngengakutenkankykhyj = pZrngengakutenkankykhyj;
    }

    private String zrnhaitoukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHAITOUKBN)
    public String getZrnhaitoukbn() {
        return zrnhaitoukbn;
    }

    public void setZrnhaitoukbn(String pZrnhaitoukbn) {
        zrnhaitoukbn = pZrnhaitoukbn;
    }

    private String zrnkusnmesyokaipjyuutouym;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKUSNMESYOKAIPJYUUTOUYM)
    public String getZrnkusnmesyokaipjyuutouym() {
        return zrnkusnmesyokaipjyuutouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnkusnmesyokaipjyuutouym(String pZrnkusnmesyokaipjyuutouym) {
        zrnkusnmesyokaipjyuutouym = pZrnkusnmesyokaipjyuutouym;
    }

    private String zrnsaigaitkyksyokusyucd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSAIGAITKYKSYOKUSYUCD)
    public String getZrnsaigaitkyksyokusyucd() {
        return zrnsaigaitkyksyokusyucd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsaigaitkyksyokusyucd(String pZrnsaigaitkyksyokusyucd) {
        zrnsaigaitkyksyokusyucd = pZrnsaigaitkyksyokusyucd;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrngassansrank;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNGASSANSRANK)
    public String getZrngassansrank() {
        return zrngassansrank;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrngassansrank(String pZrngassansrank) {
        zrngassansrank = pZrngassansrank;
    }

    private String zrntoliplhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOLIPLHYJ)
    public String getZrntoliplhyj() {
        return zrntoliplhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntoliplhyj(String pZrntoliplhyj) {
        zrntoliplhyj = pZrntoliplhyj;
    }

    private String zrnpmenhukakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNPMENHUKAKBN)
    public String getZrnpmenhukakbn() {
        return zrnpmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhukakbn(String pZrnpmenhukakbn) {
        zrnpmenhukakbn = pZrnpmenhukakbn;
    }

    private String zrnpmenkbnv2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNPMENKBNV2)
    public String getZrnpmenkbnv2() {
        return zrnpmenkbnv2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenkbnv2(String pZrnpmenkbnv2) {
        zrnpmenkbnv2 = pZrnpmenkbnv2;
    }

    private String zrnketteikijyunkanwakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKETTEIKIJYUNKANWAKBN)
    public String getZrnketteikijyunkanwakbn() {
        return zrnketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketteikijyunkanwakbn(String pZrnketteikijyunkanwakbn) {
        zrnketteikijyunkanwakbn = pZrnketteikijyunkanwakbn;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrntokuyakusedaikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUYAKUSEDAIKBN)
    public String getZrntokuyakusedaikbn() {
        return zrntokuyakusedaikbn;
    }

    public void setZrntokuyakusedaikbn(String pZrntokuyakusedaikbn) {
        zrntokuyakusedaikbn = pZrntokuyakusedaikbn;
    }

    private String zrnsiharainissuukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSIHARAINISSUUKBN)
    public String getZrnsiharainissuukbn() {
        return zrnsiharainissuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiharainissuukbn(String pZrnsiharainissuukbn) {
        zrnsiharainissuukbn = pZrnsiharainissuukbn;
    }

    private String zrnkakuseikatakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKAKUSEIKATAKBN)
    public String getZrnkakuseikatakbn() {
        return zrnkakuseikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkakuseikatakbn(String pZrnkakuseikatakbn) {
        zrnkakuseikatakbn = pZrnkakuseikatakbn;
    }

    private String zrnbosyuukeirokbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNBOSYUUKEIROKBN)
    public String getZrnbosyuukeirokbn() {
        return zrnbosyuukeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbosyuukeirokbn(String pZrnbosyuukeirokbn) {
        zrnbosyuukeirokbn = pZrnbosyuukeirokbn;
    }

    private String zrndantaicd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDANTAICD)
    public String getZrndantaicd() {
        return zrndantaicd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndantaicd(String pZrndantaicd) {
        zrndantaicd = pZrndantaicd;
    }

    private String zrnpmenhutanpohyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNPMENHUTANPOHYJ)
    public String getZrnpmenhutanpohyj() {
        return zrnpmenhutanpohyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhutanpohyj(String pZrnpmenhutanpohyj) {
        zrnpmenhutanpohyj = pZrnpmenhutanpohyj;
    }

    private String zrntenkanhosyouminaosikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTENKANHOSYOUMINAOSIKBN)
    public String getZrntenkanhosyouminaosikbn() {
        return zrntenkanhosyouminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanhosyouminaosikbn(String pZrntenkanhosyouminaosikbn) {
        zrntenkanhosyouminaosikbn = pZrntenkanhosyouminaosikbn;
    }

    private String zrnhosyouminaosikaisuu;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHOSYOUMINAOSIKAISUU)
    public String getZrnhosyouminaosikaisuu() {
        return zrnhosyouminaosikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyouminaosikaisuu(String pZrnhosyouminaosikaisuu) {
        zrnhosyouminaosikaisuu = pZrnhosyouminaosikaisuu;
    }

    private String zrnqpackhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNQPACKHYJ)
    public String getZrnqpackhyj() {
        return zrnqpackhyj;
    }

    public void setZrnqpackhyj(String pZrnqpackhyj) {
        zrnqpackhyj = pZrnqpackhyj;
    }

    private String zrnbunkatukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNBUNKATUKBN)
    public String getZrnbunkatukbn() {
        return zrnbunkatukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbunkatukbn(String pZrnbunkatukbn) {
        zrnbunkatukbn = pZrnbunkatukbn;
    }

    private String zrnstdssnskbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSTDSSNSKBN)
    public String getZrnstdssnskbn() {
        return zrnstdssnskbn;
    }

    public void setZrnstdssnskbn(String pZrnstdssnskbn) {
        zrnstdssnskbn = pZrnstdssnskbn;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnhosyoukikankbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHOSYOUKIKANKBN)
    public String getZrnhosyoukikankbn() {
        return zrnhosyoukikankbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyoukikankbn(String pZrnhosyoukikankbn) {
        zrnhosyoukikankbn = pZrnhosyoukikankbn;
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrndakuhikettisyacd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDAKUHIKETTISYACD)
    public String getZrndakuhikettisyacd() {
        return zrndakuhikettisyacd;
    }

    public void setZrndakuhikettisyacd(String pZrndakuhikettisyacd) {
        zrndakuhikettisyacd = pZrndakuhikettisyacd;
    }

    private String zrntokuyakukikan;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUYAKUKIKAN)
    public String getZrntokuyakukikan() {
        return zrntokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuyakukikan(String pZrntokuyakukikan) {
        zrntokuyakukikan = pZrntokuyakukikan;
    }

    private String zrnmannenreihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNMANNENREIHYJ)
    public String getZrnmannenreihyj() {
        return zrnmannenreihyj;
    }

    public void setZrnmannenreihyj(String pZrnmannenreihyj) {
        zrnmannenreihyj = pZrnmannenreihyj;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrnkousinkbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKOUSINKBN)
    public String getZrnkousinkbn() {
        return zrnkousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinkbn(String pZrnkousinkbn) {
        zrnkousinkbn = pZrnkousinkbn;
    }

    private String zrnhokenhoutekiyouhyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNHOKENHOUTEKIYOUHYOUJI)
    public String getZrnhokenhoutekiyouhyouji() {
        return zrnhokenhoutekiyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhokenhoutekiyouhyouji(String pZrnhokenhoutekiyouhyouji) {
        zrnhokenhoutekiyouhyouji = pZrnhokenhoutekiyouhyouji;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrntokuteijyoutaihushrhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZrntokuteijyoutaihushrhyj() {
        return zrntokuteijyoutaihushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyoutaihushrhyj(String pZrntokuteijyoutaihushrhyj) {
        zrntokuteijyoutaihushrhyj = pZrntokuteijyoutaihushrhyj;
    }

    private String zrnrendouyousntkjyubbnhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNRENDOUYOUSNTKJYUBBNHYJ)
    public String getZrnrendouyousntkjyubbnhyj() {
        return zrnrendouyousntkjyubbnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrendouyousntkjyubbnhyj(String pZrnrendouyousntkjyubbnhyj) {
        zrnrendouyousntkjyubbnhyj = pZrnrendouyousntkjyubbnhyj;
    }

    private String zrnmusentakukeiyakukbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNMUSENTAKUKEIYAKUKBN)
    public String getZrnmusentakukeiyakukbn() {
        return zrnmusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmusentakukeiyakukbn(String pZrnmusentakukeiyakukbn) {
        zrnmusentakukeiyakukbn = pZrnmusentakukeiyakukbn;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnbluekeizokuhyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNBLUEKEIZOKUHYOUJI)
    public String getZrnbluekeizokuhyouji() {
        return zrnbluekeizokuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbluekeizokuhyouji(String pZrnbluekeizokuhyouji) {
        zrnbluekeizokuhyouji = pZrnbluekeizokuhyouji;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnzyrthntiyustatuskbnx2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNZYRTHNTIYUSTATUSKBNX2)
    public String getZrnzyrthntiyustatuskbnx2() {
        return zrnzyrthntiyustatuskbnx2;
    }

    public void setZrnzyrthntiyustatuskbnx2(String pZrnzyrthntiyustatuskbnx2) {
        zrnzyrthntiyustatuskbnx2 = pZrnzyrthntiyustatuskbnx2;
    }

    private String zrnzyrthntiyustatuskbnx3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNZYRTHNTIYUSTATUSKBNX3)
    public String getZrnzyrthntiyustatuskbnx3() {
        return zrnzyrthntiyustatuskbnx3;
    }

    public void setZrnzyrthntiyustatuskbnx3(String pZrnzyrthntiyustatuskbnx3) {
        zrnzyrthntiyustatuskbnx3 = pZrnzyrthntiyustatuskbnx3;
    }

    private String zrnzyrthntiyustatuskbnx4;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNZYRTHNTIYUSTATUSKBNX4)
    public String getZrnzyrthntiyustatuskbnx4() {
        return zrnzyrthntiyustatuskbnx4;
    }

    public void setZrnzyrthntiyustatuskbnx4(String pZrnzyrthntiyustatuskbnx4) {
        zrnzyrthntiyustatuskbnx4 = pZrnzyrthntiyustatuskbnx4;
    }

    private String zrnzyrthntiyustatuskbnx5;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNZYRTHNTIYUSTATUSKBNX5)
    public String getZrnzyrthntiyustatuskbnx5() {
        return zrnzyrthntiyustatuskbnx5;
    }

    public void setZrnzyrthntiyustatuskbnx5(String pZrnzyrthntiyustatuskbnx5) {
        zrnzyrthntiyustatuskbnx5 = pZrnzyrthntiyustatuskbnx5;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnknkuzusnzyrtx2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKNKUZUSNZYRTX2)
    public String getZrnknkuzusnzyrtx2() {
        return zrnknkuzusnzyrtx2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrtx2(String pZrnknkuzusnzyrtx2) {
        zrnknkuzusnzyrtx2 = pZrnknkuzusnzyrtx2;
    }

    private String zrnpwrbksidhitekiyouhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNPWRBKSIDHITEKIYOUHYJ)
    public String getZrnpwrbksidhitekiyouhyj() {
        return zrnpwrbksidhitekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpwrbksidhitekiyouhyj(String pZrnpwrbksidhitekiyouhyj) {
        zrnpwrbksidhitekiyouhyj = pZrnpwrbksidhitekiyouhyj;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrndatakanrino2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDATAKANRINO2)
    public String getZrndatakanrino2() {
        return zrndatakanrino2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino2(String pZrndatakanrino2) {
        zrndatakanrino2 = pZrndatakanrino2;
    }

    private String zrndatakanrino3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNDATAKANRINO3)
    public String getZrndatakanrino3() {
        return zrndatakanrino3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino3(String pZrndatakanrino3) {
        zrndatakanrino3 = pZrndatakanrino3;
    }

    private String zrnsinkeiyakujivithkhyouji;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSINKEIYAKUJIVITHKHYOUJI)
    public String getZrnsinkeiyakujivithkhyouji() {
        return zrnsinkeiyakujivithkhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinkeiyakujivithkhyouji(String pZrnsinkeiyakujivithkhyouji) {
        zrnsinkeiyakujivithkhyouji = pZrnsinkeiyakujivithkhyouji;
    }

    private String zrnkykymd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnsuuriyouyobin4;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSUURIYOUYOBIN4)
    public String getZrnsuuriyouyobin4() {
        return zrnsuuriyouyobin4;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnsuuriyouyobin4(String pZrnsuuriyouyobin4) {
        zrnsuuriyouyobin4 = pZrnsuuriyouyobin4;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private Long zrngaikadatetokuyakus;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNGAIKADATETOKUYAKUS)
    public Long getZrngaikadatetokuyakus() {
        return zrngaikadatetokuyakus;
    }

    public void setZrngaikadatetokuyakus(Long pZrngaikadatetokuyakus) {
        zrngaikadatetokuyakus = pZrngaikadatetokuyakus;
    }

    private Long zrngaikadatesyukeiyakus;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNGAIKADATESYUKEIYAKUS)
    public Long getZrngaikadatesyukeiyakus() {
        return zrngaikadatesyukeiyakus;
    }

    public void setZrngaikadatesyukeiyakus(Long pZrngaikadatesyukeiyakus) {
        zrngaikadatesyukeiyakus = pZrngaikadatesyukeiyakus;
    }

    private Long zrngaikadatesyukeiyakup;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNGAIKADATESYUKEIYAKUP)
    public Long getZrngaikadatesyukeiyakup() {
        return zrngaikadatesyukeiyakup;
    }

    public void setZrngaikadatesyukeiyakup(Long pZrngaikadatesyukeiyakup) {
        zrngaikadatesyukeiyakup = pZrngaikadatesyukeiyakup;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnsuuriyouyobin10x2;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNSUURIYOUYOBIN10X2)
    public String getZrnsuuriyouyobin10x2() {
        return zrnsuuriyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x2(String pZrnsuuriyouyobin10x2) {
        zrnsuuriyouyobin10x2 = pZrnsuuriyouyobin10x2;
    }

    private String zrnyobiv10x3;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNYOBIV10X3)
    public String getZrnyobiv10x3() {
        return zrnyobiv10x3;
    }

    public void setZrnyobiv10x3(String pZrnyobiv10x3) {
        zrnyobiv10x3 = pZrnyobiv10x3;
    }

    private Long zrnmvatyouseigow;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNMVATYOUSEIGOW)
    public Long getZrnmvatyouseigow() {
        return zrnmvatyouseigow;
    }

    public void setZrnmvatyouseigow(Long pZrnmvatyouseigow) {
        zrnmvatyouseigow = pZrnmvatyouseigow;
    }

    private Long zrnmvakeisanjisknnjynbkn;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNMVAKEISANJISKNNJYNBKN)
    public Long getZrnmvakeisanjisknnjynbkn() {
        return zrnmvakeisanjisknnjynbkn;
    }

    public void setZrnmvakeisanjisknnjynbkn(Long pZrnmvakeisanjisknnjynbkn) {
        zrnmvakeisanjisknnjynbkn = pZrnmvakeisanjisknnjynbkn;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_JigyounndsikiTkHoyuuRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }
}