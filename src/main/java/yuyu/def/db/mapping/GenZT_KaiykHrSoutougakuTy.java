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
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuTy;
import yuyu.def.db.id.PKZT_KaiykHrSoutougakuTy;
import yuyu.def.db.meta.GenQZT_KaiykHrSoutougakuTy;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuTy;

/**
 * 解約返戻金相当額Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KaiykHrSoutougakuTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KaiykHrSoutougakuTy}</td><td colspan="3">解約返戻金相当額Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_KaiykHrSoutougakuTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisankijyunym ztykeisankijyunym}</td><td>（中継用）計算基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkkbn ztysyutkkbn}</td><td>（中継用）主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanitijibaraikbn ztytenkanitijibaraikbn}</td><td>（中継用）転換一時払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuutohukahyouji ztytyuutohukahyouji}</td><td>（中継用）中途付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin6 ztysuuriyouyobin6}</td><td>（中継用）数理用予備項目Ｎ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x2 ztyyobiv6x2}</td><td>（中継用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasikousinkbn ztysotodasikousinkbn}</td><td>（中継用）外出更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi ztyhokensyuruikigouyobi}</td><td>（中継用）保険種類記号予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakugatakbn ztytokuyakugatakbn}</td><td>（中継用）特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkbthsyumnryuhyouji ztytkbthsyumnryuhyouji}</td><td>（中継用）特別保障満了表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjyoutai ztykykjyoutai}</td><td>（中継用）契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaizumientyoujiage ztyharaizumientyoujiage}</td><td>（中継用）払済延長時年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyentyoukikan ztyentyoukikan}</td><td>（中継用）延長期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteimpbairitu ztysiteimpbairitu}</td><td>（中継用）指定月Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim1 ztypwarimasisiteim1}</td><td>（中継用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim2 ztypwarimasisiteim2}</td><td>（中継用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuusiteiym ztysaisyuusiteiym}</td><td>（中継用）最終指定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonkyuuhukinshrmd ztyseizonkyuuhukinshrmd}</td><td>（中継用）生存給付支払月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuu ztykeikanensuu}</td><td>（中継用）経過年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikatukisuu ztykeikatukisuu}</td><td>（中継用）経過月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknhktgkujyarhyouji ztytnknhktgkujyarhyouji}</td><td>（中継用）転換引継控除有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukbn ztytokuyakukbn}</td><td>（中継用）特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuno ztytokuyakuno}</td><td>（中継用）特約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2hknkknikoujihisyaage ztydi2hknkknikoujihisyaage}</td><td>（中継用）第２保険期間移行時被者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordno ztyrecordno}</td><td>（中継用）レコード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymfkuriagekurisagekbn ztymfkuriagekurisagekbn}</td><td>（中継用）ＭＦ繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymfannaihuyouriyuukbn ztymfannaihuyouriyuukbn}</td><td>（中継用）ＭＦ案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrizmjhknsyukigousdkbn ztyhrizmjhknsyukigousdkbn}</td><td>（中継用）払済時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenhoutekiyouhyouji ztyhokenhoutekiyouhyouji}</td><td>（中継用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetuhosyoukikan ztytokubetuhosyoukikan}</td><td>（中継用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysintokujyouhyouji ztysintokujyouhyouji}</td><td>（中継用）新特条表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkjykbn ztytkjykbn}</td><td>（中継用）特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryoumasihyouten ztyryoumasihyouten}</td><td>（中継用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2tokujyoukbn ztydai2tokujyoukbn}</td><td>（中継用）第２特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2ryoumasihyouten ztydai2ryoumasihyouten}</td><td>（中継用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyytirrthndsysnmnskaisuu ztyytirrthndsysnmnskaisuu}</td><td>（中継用）予定利率変動終身見直回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinmanryouage ztykousinmanryouage}</td><td>（中継用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9 ztysuuriyouyobin9}</td><td>（中継用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykrsgjhknsyukigousdkbn ztykrsgjhknsyukigousdkbn}</td><td>（中継用）繰下げ時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15 ztyyobiv15}</td><td>（中継用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyerrtokuteikoumoku ztyerrtokuteikoumoku}</td><td>（中継用）エラー特定項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhenkougokihons ztyhenkougokihons}</td><td>（中継用）変更後基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhenkougosibous ztyhenkougosibous}</td><td>（中継用）変更後死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygyousekihyoujis ztygyousekihyoujis}</td><td>（中継用）業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkankakaku ztygoukeitenkankakaku}</td><td>（中継用）合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywnasigoukeitenkanteikis ztywnasigoukeitenkanteikis}</td><td>（中継用）Ｗなし合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhr ztykaiyakuhr}</td><td>（中継用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyryumsbbnkaiyakuhr ztyryumsbbnkaiyakuhr}</td><td>（中継用）料増部分解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinyoteiriritu ztysaisinyoteiriritu}</td><td>（中継用）最新予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkaiyakusjkkktyouseirrt ztysrkaiyakusjkkktyouseirrt}</td><td>（中継用）数理用解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkyksjkkktyouseiriritu ztysrkyksjkkktyouseiriritu}</td><td>（中継用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtymvakeisankijyunymd ztymvakeisankijyunymd}</td><td>（中継用）ＭＶＡ計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvatyouseikou ztymvatyouseikou}</td><td>（中継用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8 ztysuuriyouyobin8}</td><td>（中継用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x2 ztysuuriyouyobin10x2}</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x9 ztyyobin11x9}</td><td>（中継用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv11 ztyyobiv11}</td><td>（中継用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KaiykHrSoutougakuTy
 * @see     PKZT_KaiykHrSoutougakuTy
 * @see     QZT_KaiykHrSoutougakuTy
 * @see     GenQZT_KaiykHrSoutougakuTy
 */
@MappedSuperclass
@Table(name=GenZT_KaiykHrSoutougakuTy.TABLE_NAME)
@IdClass(value=PKZT_KaiykHrSoutougakuTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KaiykHrSoutougakuTy extends AbstractExDBEntity<ZT_KaiykHrSoutougakuTy, PKZT_KaiykHrSoutougakuTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KaiykHrSoutougakuTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYKEISANKIJYUNYM        = "ztykeisankijyunym";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYSYUTKKBN              = "ztysyutkkbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYTENKANITIJIBARAIKBN   = "ztytenkanitijibaraikbn";
    public static final String ZTYTYUUTOHUKAHYOUJI      = "ztytyuutohukahyouji";
    public static final String ZTYSUURIYOUYOBIN6        = "ztysuuriyouyobin6";
    public static final String ZTYYOBIV6X2              = "ztyyobiv6x2";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSOTODASIKOUSINKBN     = "ztysotodasikousinkbn";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYHOKENSYURUIKIGOUYOBI  = "ztyhokensyuruikigouyobi";
    public static final String ZTYTOKUYAKUGATAKBN       = "ztytokuyakugatakbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYTKBTHSYUMNRYUHYOUJI   = "ztytkbthsyumnryuhyouji";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYKYKJYOUTAI            = "ztykykjyoutai";
    public static final String ZTYHARAIZUMIENTYOUJIAGE  = "ztyharaizumientyoujiage";
    public static final String ZTYENTYOUKIKAN           = "ztyentyoukikan";
    public static final String ZTYSITEIMPBAIRITU        = "ztysiteimpbairitu";
    public static final String ZTYPWARIMASISITEIM1      = "ztypwarimasisiteim1";
    public static final String ZTYPWARIMASISITEIM2      = "ztypwarimasisiteim2";
    public static final String ZTYSAISYUUSITEIYM        = "ztysaisyuusiteiym";
    public static final String ZTYSEIZONKYUUHUKINSHRMD  = "ztyseizonkyuuhukinshrmd";
    public static final String ZTYKEIKANENSUU           = "ztykeikanensuu";
    public static final String ZTYKEIKATUKISUU          = "ztykeikatukisuu";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYTNKNHKTGKUJYARHYOUJI  = "ztytnknhktgkujyarhyouji";
    public static final String ZTYTOKUYAKUKBN           = "ztytokuyakukbn";
    public static final String ZTYTOKUYAKUNO            = "ztytokuyakuno";
    public static final String ZTYDI2HKNKKNIKOUJIHISYAAGE = "ztydi2hknkknikoujihisyaage";
    public static final String ZTYRECORDNO              = "ztyrecordno";
    public static final String ZTYMFKURIAGEKURISAGEKBN  = "ztymfkuriagekurisagekbn";
    public static final String ZTYMFANNAIHUYOURIYUUKBN  = "ztymfannaihuyouriyuukbn";
    public static final String ZTYHRIZMJHKNSYUKIGOUSDKBN = "ztyhrizmjhknsyukigousdkbn";
    public static final String ZTYHOKENHOUTEKIYOUHYOUJI = "ztyhokenhoutekiyouhyouji";
    public static final String ZTYTOKUBETUHOSYOUKIKAN   = "ztytokubetuhosyoukikan";
    public static final String ZTYSINTOKUJYOUHYOUJI     = "ztysintokujyouhyouji";
    public static final String ZTYTKJYKBN               = "ztytkjykbn";
    public static final String ZTYRYOUMASIHYOUTEN       = "ztyryoumasihyouten";
    public static final String ZTYDAI2TOKUJYOUKBN       = "ztydai2tokujyoukbn";
    public static final String ZTYDAI2RYOUMASIHYOUTEN   = "ztydai2ryoumasihyouten";
    public static final String ZTYYTIRRTHNDSYSNMNSKAISUU = "ztyytirrthndsysnmnskaisuu";
    public static final String ZTYKOUSINMANRYOUAGE      = "ztykousinmanryouage";
    public static final String ZTYSUURIYOUYOBIN9        = "ztysuuriyouyobin9";
    public static final String ZTYKRSGJHKNSYUKIGOUSDKBN = "ztykrsgjhknsyukigousdkbn";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYYOBIV15               = "ztyyobiv15";
    public static final String ZTYERRTOKUTEIKOUMOKU     = "ztyerrtokuteikoumoku";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYHENKOUGOKIHONS        = "ztyhenkougokihons";
    public static final String ZTYHENKOUGOSIBOUS        = "ztyhenkougosibous";
    public static final String ZTYGYOUSEKIHYOUJIS       = "ztygyousekihyoujis";
    public static final String ZTYGOUKEITENKANKAKAKU    = "ztygoukeitenkankakaku";
    public static final String ZTYWNASIGOUKEITENKANTEIKIS = "ztywnasigoukeitenkanteikis";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYKAIYAKUHR             = "ztykaiyakuhr";
    public static final String ZTYRYUMSBBNKAIYAKUHR     = "ztyryumsbbnkaiyakuhr";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYSAISINYOTEIRIRITU     = "ztysaisinyoteiriritu";
    public static final String ZTYSRKAIYAKUSJKKKTYOUSEIRRT = "ztysrkaiyakusjkkktyouseirrt";
    public static final String ZTYSRKYKSJKKKTYOUSEIRIRITU = "ztysrkyksjkkktyouseiriritu";
    public static final String ZTYMVAKEISANKIJYUNYMD    = "ztymvakeisankijyunymd";
    public static final String ZTYMVATYOUSEIKOU         = "ztymvatyouseikou";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN8        = "ztysuuriyouyobin8";
    public static final String ZTYSUURIYOUYOBIN10X2     = "ztysuuriyouyobin10x2";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIN11X9             = "ztyyobin11x9";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV11               = "ztyyobiv11";

    private final PKZT_KaiykHrSoutougakuTy primaryKey;

    public GenZT_KaiykHrSoutougakuTy() {
        primaryKey = new PKZT_KaiykHrSoutougakuTy();
    }

    public GenZT_KaiykHrSoutougakuTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_KaiykHrSoutougakuTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_KaiykHrSoutougakuTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KaiykHrSoutougakuTy> getMetaClass() {
        return QZT_KaiykHrSoutougakuTy.class;
    }

    @Id
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztyyobiv12;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztykeisankijyunym;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKEISANKIJYUNYM)
    public String getZtykeisankijyunym() {
        return ztykeisankijyunym;
    }

    public void setZtykeisankijyunym(String pZtykeisankijyunym) {
        ztykeisankijyunym = pZtykeisankijyunym;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztysyutkkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSYUTKKBN)
    public String getZtysyutkkbn() {
        return ztysyutkkbn;
    }

    public void setZtysyutkkbn(String pZtysyutkkbn) {
        ztysyutkkbn = pZtysyutkkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztyharaikatakbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztytenkanitijibaraikbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTENKANITIJIBARAIKBN)
    public String getZtytenkanitijibaraikbn() {
        return ztytenkanitijibaraikbn;
    }

    public void setZtytenkanitijibaraikbn(String pZtytenkanitijibaraikbn) {
        ztytenkanitijibaraikbn = pZtytenkanitijibaraikbn;
    }

    private String ztytyuutohukahyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTYUUTOHUKAHYOUJI)
    public String getZtytyuutohukahyouji() {
        return ztytyuutohukahyouji;
    }

    public void setZtytyuutohukahyouji(String pZtytyuutohukahyouji) {
        ztytyuutohukahyouji = pZtytyuutohukahyouji;
    }

    private String ztysuuriyouyobin6;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSUURIYOUYOBIN6)
    public String getZtysuuriyouyobin6() {
        return ztysuuriyouyobin6;
    }

    public void setZtysuuriyouyobin6(String pZtysuuriyouyobin6) {
        ztysuuriyouyobin6 = pZtysuuriyouyobin6;
    }

    private String ztyyobiv6x2;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIV6X2)
    public String getZtyyobiv6x2() {
        return ztyyobiv6x2;
    }

    public void setZtyyobiv6x2(String pZtyyobiv6x2) {
        ztyyobiv6x2 = pZtyyobiv6x2;
    }

    private String ztykykymd;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztysotodasikousinkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSOTODASIKOUSINKBN)
    public String getZtysotodasikousinkbn() {
        return ztysotodasikousinkbn;
    }

    public void setZtysotodasikousinkbn(String pZtysotodasikousinkbn) {
        ztysotodasikousinkbn = pZtysotodasikousinkbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztyhokensyuruikigouyobi;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHOKENSYURUIKIGOUYOBI)
    public String getZtyhokensyuruikigouyobi() {
        return ztyhokensyuruikigouyobi;
    }

    public void setZtyhokensyuruikigouyobi(String pZtyhokensyuruikigouyobi) {
        ztyhokensyuruikigouyobi = pZtyhokensyuruikigouyobi;
    }

    private String ztytokuyakugatakbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTOKUYAKUGATAKBN)
    public String getZtytokuyakugatakbn() {
        return ztytokuyakugatakbn;
    }

    public void setZtytokuyakugatakbn(String pZtytokuyakugatakbn) {
        ztytokuyakugatakbn = pZtytokuyakugatakbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztytkbthsyumnryuhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTKBTHSYUMNRYUHYOUJI)
    public String getZtytkbthsyumnryuhyouji() {
        return ztytkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytkbthsyumnryuhyouji(String pZtytkbthsyumnryuhyouji) {
        ztytkbthsyumnryuhyouji = pZtytkbthsyumnryuhyouji;
    }

    private String ztynknshry;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztykykjyoutai;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKYKJYOUTAI)
    public String getZtykykjyoutai() {
        return ztykykjyoutai;
    }

    public void setZtykykjyoutai(String pZtykykjyoutai) {
        ztykykjyoutai = pZtykykjyoutai;
    }

    private String ztyharaizumientyoujiage;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHARAIZUMIENTYOUJIAGE)
    public String getZtyharaizumientyoujiage() {
        return ztyharaizumientyoujiage;
    }

    public void setZtyharaizumientyoujiage(String pZtyharaizumientyoujiage) {
        ztyharaizumientyoujiage = pZtyharaizumientyoujiage;
    }

    private String ztyentyoukikan;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYENTYOUKIKAN)
    public String getZtyentyoukikan() {
        return ztyentyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyentyoukikan(String pZtyentyoukikan) {
        ztyentyoukikan = pZtyentyoukikan;
    }

    private String ztysiteimpbairitu;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSITEIMPBAIRITU)
    public String getZtysiteimpbairitu() {
        return ztysiteimpbairitu;
    }

    public void setZtysiteimpbairitu(String pZtysiteimpbairitu) {
        ztysiteimpbairitu = pZtysiteimpbairitu;
    }

    private String ztypwarimasisiteim1;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYPWARIMASISITEIM1)
    public String getZtypwarimasisiteim1() {
        return ztypwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim1(String pZtypwarimasisiteim1) {
        ztypwarimasisiteim1 = pZtypwarimasisiteim1;
    }

    private String ztypwarimasisiteim2;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYPWARIMASISITEIM2)
    public String getZtypwarimasisiteim2() {
        return ztypwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim2(String pZtypwarimasisiteim2) {
        ztypwarimasisiteim2 = pZtypwarimasisiteim2;
    }

    private String ztysaisyuusiteiym;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSAISYUUSITEIYM)
    public String getZtysaisyuusiteiym() {
        return ztysaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtysaisyuusiteiym(String pZtysaisyuusiteiym) {
        ztysaisyuusiteiym = pZtysaisyuusiteiym;
    }

    private String ztyseizonkyuuhukinshrmd;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSEIZONKYUUHUKINSHRMD)
    public String getZtyseizonkyuuhukinshrmd() {
        return ztyseizonkyuuhukinshrmd;
    }

    public void setZtyseizonkyuuhukinshrmd(String pZtyseizonkyuuhukinshrmd) {
        ztyseizonkyuuhukinshrmd = pZtyseizonkyuuhukinshrmd;
    }

    private String ztykeikanensuu;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKEIKANENSUU)
    public String getZtykeikanensuu() {
        return ztykeikanensuu;
    }

    public void setZtykeikanensuu(String pZtykeikanensuu) {
        ztykeikanensuu = pZtykeikanensuu;
    }

    private String ztykeikatukisuu;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKEIKATUKISUU)
    public String getZtykeikatukisuu() {
        return ztykeikatukisuu;
    }

    public void setZtykeikatukisuu(String pZtykeikatukisuu) {
        ztykeikatukisuu = pZtykeikatukisuu;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztytnknhktgkujyarhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTNKNHKTGKUJYARHYOUJI)
    public String getZtytnknhktgkujyarhyouji() {
        return ztytnknhktgkujyarhyouji;
    }

    public void setZtytnknhktgkujyarhyouji(String pZtytnknhktgkujyarhyouji) {
        ztytnknhktgkujyarhyouji = pZtytnknhktgkujyarhyouji;
    }

    private String ztytokuyakukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTOKUYAKUKBN)
    public String getZtytokuyakukbn() {
        return ztytokuyakukbn;
    }

    public void setZtytokuyakukbn(String pZtytokuyakukbn) {
        ztytokuyakukbn = pZtytokuyakukbn;
    }

    private String ztytokuyakuno;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTOKUYAKUNO)
    public String getZtytokuyakuno() {
        return ztytokuyakuno;
    }

    public void setZtytokuyakuno(String pZtytokuyakuno) {
        ztytokuyakuno = pZtytokuyakuno;
    }

    private String ztydi2hknkknikoujihisyaage;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYDI2HKNKKNIKOUJIHISYAAGE)
    public String getZtydi2hknkknikoujihisyaage() {
        return ztydi2hknkknikoujihisyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydi2hknkknikoujihisyaage(String pZtydi2hknkknikoujihisyaage) {
        ztydi2hknkknikoujihisyaage = pZtydi2hknkknikoujihisyaage;
    }

    private String ztyrecordno;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYRECORDNO)
    public String getZtyrecordno() {
        return ztyrecordno;
    }

    public void setZtyrecordno(String pZtyrecordno) {
        ztyrecordno = pZtyrecordno;
    }

    private String ztymfkuriagekurisagekbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYMFKURIAGEKURISAGEKBN)
    public String getZtymfkuriagekurisagekbn() {
        return ztymfkuriagekurisagekbn;
    }

    public void setZtymfkuriagekurisagekbn(String pZtymfkuriagekurisagekbn) {
        ztymfkuriagekurisagekbn = pZtymfkuriagekurisagekbn;
    }

    private String ztymfannaihuyouriyuukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYMFANNAIHUYOURIYUUKBN)
    public String getZtymfannaihuyouriyuukbn() {
        return ztymfannaihuyouriyuukbn;
    }

    public void setZtymfannaihuyouriyuukbn(String pZtymfannaihuyouriyuukbn) {
        ztymfannaihuyouriyuukbn = pZtymfannaihuyouriyuukbn;
    }

    private String ztyhrizmjhknsyukigousdkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHRIZMJHKNSYUKIGOUSDKBN)
    public String getZtyhrizmjhknsyukigousdkbn() {
        return ztyhrizmjhknsyukigousdkbn;
    }

    public void setZtyhrizmjhknsyukigousdkbn(String pZtyhrizmjhknsyukigousdkbn) {
        ztyhrizmjhknsyukigousdkbn = pZtyhrizmjhknsyukigousdkbn;
    }

    private String ztyhokenhoutekiyouhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHOKENHOUTEKIYOUHYOUJI)
    public String getZtyhokenhoutekiyouhyouji() {
        return ztyhokenhoutekiyouhyouji;
    }

    public void setZtyhokenhoutekiyouhyouji(String pZtyhokenhoutekiyouhyouji) {
        ztyhokenhoutekiyouhyouji = pZtyhokenhoutekiyouhyouji;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private String ztysintokujyouhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSINTOKUJYOUHYOUJI)
    public String getZtysintokujyouhyouji() {
        return ztysintokujyouhyouji;
    }

    public void setZtysintokujyouhyouji(String pZtysintokujyouhyouji) {
        ztysintokujyouhyouji = pZtysintokujyouhyouji;
    }

    private String ztytkjykbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTKJYKBN)
    public String getZtytkjykbn() {
        return ztytkjykbn;
    }

    public void setZtytkjykbn(String pZtytkjykbn) {
        ztytkjykbn = pZtytkjykbn;
    }

    private Integer ztyryoumasihyouten;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYRYOUMASIHYOUTEN)
    public Integer getZtyryoumasihyouten() {
        return ztyryoumasihyouten;
    }

    public void setZtyryoumasihyouten(Integer pZtyryoumasihyouten) {
        ztyryoumasihyouten = pZtyryoumasihyouten;
    }

    private String ztydai2tokujyoukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYDAI2TOKUJYOUKBN)
    public String getZtydai2tokujyoukbn() {
        return ztydai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2tokujyoukbn(String pZtydai2tokujyoukbn) {
        ztydai2tokujyoukbn = pZtydai2tokujyoukbn;
    }

    private Integer ztydai2ryoumasihyouten;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYDAI2RYOUMASIHYOUTEN)
    public Integer getZtydai2ryoumasihyouten() {
        return ztydai2ryoumasihyouten;
    }

    public void setZtydai2ryoumasihyouten(Integer pZtydai2ryoumasihyouten) {
        ztydai2ryoumasihyouten = pZtydai2ryoumasihyouten;
    }

    private String ztyytirrthndsysnmnskaisuu;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYTIRRTHNDSYSNMNSKAISUU)
    public String getZtyytirrthndsysnmnskaisuu() {
        return ztyytirrthndsysnmnskaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyytirrthndsysnmnskaisuu(String pZtyytirrthndsysnmnskaisuu) {
        ztyytirrthndsysnmnskaisuu = pZtyytirrthndsysnmnskaisuu;
    }

    private String ztykousinmanryouage;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKOUSINMANRYOUAGE)
    public String getZtykousinmanryouage() {
        return ztykousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykousinmanryouage(String pZtykousinmanryouage) {
        ztykousinmanryouage = pZtykousinmanryouage;
    }

    private String ztysuuriyouyobin9;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSUURIYOUYOBIN9)
    public String getZtysuuriyouyobin9() {
        return ztysuuriyouyobin9;
    }

    public void setZtysuuriyouyobin9(String pZtysuuriyouyobin9) {
        ztysuuriyouyobin9 = pZtysuuriyouyobin9;
    }

    private String ztykrsgjhknsyukigousdkbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKRSGJHKNSYUKIGOUSDKBN)
    public String getZtykrsgjhknsyukigousdkbn() {
        return ztykrsgjhknsyukigousdkbn;
    }

    public void setZtykrsgjhknsyukigousdkbn(String pZtykrsgjhknsyukigousdkbn) {
        ztykrsgjhknsyukigousdkbn = pZtykrsgjhknsyukigousdkbn;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyyobiv15;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIV15)
    public String getZtyyobiv15() {
        return ztyyobiv15;
    }

    public void setZtyyobiv15(String pZtyyobiv15) {
        ztyyobiv15 = pZtyyobiv15;
    }

    private String ztyerrtokuteikoumoku;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYERRTOKUTEIKOUMOKU)
    public String getZtyerrtokuteikoumoku() {
        return ztyerrtokuteikoumoku;
    }

    public void setZtyerrtokuteikoumoku(String pZtyerrtokuteikoumoku) {
        ztyerrtokuteikoumoku = pZtyerrtokuteikoumoku;
    }

    private Long ztykihons;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztyhenkougokihons;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHENKOUGOKIHONS)
    public Long getZtyhenkougokihons() {
        return ztyhenkougokihons;
    }

    public void setZtyhenkougokihons(Long pZtyhenkougokihons) {
        ztyhenkougokihons = pZtyhenkougokihons;
    }

    private Long ztyhenkougosibous;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYHENKOUGOSIBOUS)
    public Long getZtyhenkougosibous() {
        return ztyhenkougosibous;
    }

    public void setZtyhenkougosibous(Long pZtyhenkougosibous) {
        ztyhenkougosibous = pZtyhenkougosibous;
    }

    private Long ztygyousekihyoujis;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYGYOUSEKIHYOUJIS)
    public Long getZtygyousekihyoujis() {
        return ztygyousekihyoujis;
    }

    public void setZtygyousekihyoujis(Long pZtygyousekihyoujis) {
        ztygyousekihyoujis = pZtygyousekihyoujis;
    }

    private Long ztygoukeitenkankakaku;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYGOUKEITENKANKAKAKU)
    public Long getZtygoukeitenkankakaku() {
        return ztygoukeitenkankakaku;
    }

    public void setZtygoukeitenkankakaku(Long pZtygoukeitenkankakaku) {
        ztygoukeitenkankakaku = pZtygoukeitenkankakaku;
    }

    private Long ztywnasigoukeitenkanteikis;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYWNASIGOUKEITENKANTEIKIS)
    public Long getZtywnasigoukeitenkanteikis() {
        return ztywnasigoukeitenkanteikis;
    }

    public void setZtywnasigoukeitenkanteikis(Long pZtywnasigoukeitenkanteikis) {
        ztywnasigoukeitenkanteikis = pZtywnasigoukeitenkanteikis;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztykaiyakuhr;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKAIYAKUHR)
    public Long getZtykaiyakuhr() {
        return ztykaiyakuhr;
    }

    public void setZtykaiyakuhr(Long pZtykaiyakuhr) {
        ztykaiyakuhr = pZtykaiyakuhr;
    }

    private Long ztyryumsbbnkaiyakuhr;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYRYUMSBBNKAIYAKUHR)
    public Long getZtyryumsbbnkaiyakuhr() {
        return ztyryumsbbnkaiyakuhr;
    }

    public void setZtyryumsbbnkaiyakuhr(Long pZtyryumsbbnkaiyakuhr) {
        ztyryumsbbnkaiyakuhr = pZtyryumsbbnkaiyakuhr;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private BizNumber ztysaisinyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSAISINYOTEIRIRITU)
    public BizNumber getZtysaisinyoteiriritu() {
        return ztysaisinyoteiriritu;
    }

    public void setZtysaisinyoteiriritu(BizNumber pZtysaisinyoteiriritu) {
        ztysaisinyoteiriritu = pZtysaisinyoteiriritu;
    }

    private BizNumber ztysrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZtysrkaiyakusjkkktyouseirrt() {
        return ztysrkaiyakusjkkktyouseirrt;
    }

    public void setZtysrkaiyakusjkkktyouseirrt(BizNumber pZtysrkaiyakusjkkktyouseirrt) {
        ztysrkaiyakusjkkktyouseirrt = pZtysrkaiyakusjkkktyouseirrt;
    }

    private BizNumber ztysrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZtysrkyksjkkktyouseiriritu() {
        return ztysrkyksjkkktyouseiriritu;
    }

    public void setZtysrkyksjkkktyouseiriritu(BizNumber pZtysrkyksjkkktyouseiriritu) {
        ztysrkyksjkkktyouseiriritu = pZtysrkyksjkkktyouseiriritu;
    }

    private String ztymvakeisankijyunymd;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYMVAKEISANKIJYUNYMD)
    public String getZtymvakeisankijyunymd() {
        return ztymvakeisankijyunymd;
    }

    public void setZtymvakeisankijyunymd(String pZtymvakeisankijyunymd) {
        ztymvakeisankijyunymd = pZtymvakeisankijyunymd;
    }

    private BizNumber ztymvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYMVATYOUSEIKOU)
    public BizNumber getZtymvatyouseikou() {
        return ztymvatyouseikou;
    }

    public void setZtymvatyouseikou(BizNumber pZtymvatyouseikou) {
        ztymvatyouseikou = pZtymvatyouseikou;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private String ztysuuriyouyobin10x2;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYSUURIYOUYOBIN10X2)
    public String getZtysuuriyouyobin10x2() {
        return ztysuuriyouyobin10x2;
    }

    public void setZtysuuriyouyobin10x2(String pZtysuuriyouyobin10x2) {
        ztysuuriyouyobin10x2 = pZtysuuriyouyobin10x2;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv11;

    @Column(name=GenZT_KaiykHrSoutougakuTy.ZTYYOBIV11)
    public String getZtyyobiv11() {
        return ztyyobiv11;
    }

    public void setZtyyobiv11(String pZtyyobiv11) {
        ztyyobiv11 = pZtyyobiv11;
    }
}