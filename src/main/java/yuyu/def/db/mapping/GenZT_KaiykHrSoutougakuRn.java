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
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuRn;
import yuyu.def.db.id.PKZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.GenQZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuRn;

/**
 * 解約返戻金相当額Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KaiykHrSoutougakuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KaiykHrSoutougakuRn}</td><td colspan="3">解約返戻金相当額Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_KaiykHrSoutougakuRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisankijyunym zrnkeisankijyunym}</td><td>（連携用）計算基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkkbn zrnsyutkkbn}</td><td>（連携用）主契約特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuurisyuruicd zrnsuurisyuruicd}</td><td>（連携用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbn zrnharaikatakbn}</td><td>（連携用）払方区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanitijibaraikbn zrntenkanitijibaraikbn}</td><td>（連携用）転換一時払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuutohukahyouji zrntyuutohukahyouji}</td><td>（連携用）中途付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin6 zrnsuuriyouyobin6}</td><td>（連携用）数理用予備項目Ｎ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x2 zrnyobiv6x2}</td><td>（連携用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasikousinkbn zrnsotodasikousinkbn}</td><td>（連携用）外出更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi zrnhokensyuruikigouyobi}</td><td>（連携用）保険種類記号予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakugatakbn zrntokuyakugatakbn}</td><td>（連携用）特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkbthsyumnryuhyouji zrntkbthsyumnryuhyouji}</td><td>（連携用）特別保障満了表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjyoutai zrnkykjyoutai}</td><td>（連携用）契約状態</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaizumientyoujiage zrnharaizumientyoujiage}</td><td>（連携用）払済延長時年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnentyoukikan zrnentyoukikan}</td><td>（連携用）延長期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteimpbairitu zrnsiteimpbairitu}</td><td>（連携用）指定月Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim1 zrnpwarimasisiteim1}</td><td>（連携用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim2 zrnpwarimasisiteim2}</td><td>（連携用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisyuusiteiym zrnsaisyuusiteiym}</td><td>（連携用）最終指定年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonkyuuhukinshrmd zrnseizonkyuuhukinshrmd}</td><td>（連携用）生存給付支払月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuu zrnkeikanensuu}</td><td>（連携用）経過年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikatukisuu zrnkeikatukisuu}</td><td>（連携用）経過月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknhktgkujyarhyouji zrntnknhktgkujyarhyouji}</td><td>（連携用）転換引継控除有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukbn zrntokuyakukbn}</td><td>（連携用）特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuno zrntokuyakuno}</td><td>（連携用）特約番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2hknkknikoujihisyaage zrndi2hknkknikoujihisyaage}</td><td>（連携用）第２保険期間移行時被者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordno zrnrecordno}</td><td>（連携用）レコード番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmfkuriagekurisagekbn zrnmfkuriagekurisagekbn}</td><td>（連携用）ＭＦ繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmfannaihuyouriyuukbn zrnmfannaihuyouriyuukbn}</td><td>（連携用）ＭＦ案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrizmjhknsyukigousdkbn zrnhrizmjhknsyukigousdkbn}</td><td>（連携用）払済時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenhoutekiyouhyouji zrnhokenhoutekiyouhyouji}</td><td>（連携用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetuhosyoukikan zrntokubetuhosyoukikan}</td><td>（連携用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsintokujyouhyouji zrnsintokujyouhyouji}</td><td>（連携用）新特条表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkjykbn zrntkjykbn}</td><td>（連携用）特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryoumasihyouten zrnryoumasihyouten}</td><td>（連携用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2tokujyoukbn zrndai2tokujyoukbn}</td><td>（連携用）第２特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2ryoumasihyouten zrndai2ryoumasihyouten}</td><td>（連携用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnytirrthndsysnmnskaisuu zrnytirrthndsysnmnskaisuu}</td><td>（連携用）予定利率変動終身見直回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinmanryouage zrnkousinmanryouage}</td><td>（連携用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9 zrnsuuriyouyobin9}</td><td>（連携用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkrsgjhknsyukigousdkbn zrnkrsgjhknsyukigousdkbn}</td><td>（連携用）繰下げ時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15 zrnyobiv15}</td><td>（連携用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnerrtokuteikoumoku zrnerrtokuteikoumoku}</td><td>（連携用）エラー特定項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhenkougokihons zrnhenkougokihons}</td><td>（連携用）変更後基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhenkougosibous zrnhenkougosibous}</td><td>（連携用）変更後死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngyousekihyoujis zrngyousekihyoujis}</td><td>（連携用）業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkankakaku zrngoukeitenkankakaku}</td><td>（連携用）合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwnasigoukeitenkanteikis zrnwnasigoukeitenkanteikis}</td><td>（連携用）Ｗなし合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhr zrnkaiyakuhr}</td><td>（連携用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnryumsbbnkaiyakuhr zrnryumsbbnkaiyakuhr}</td><td>（連携用）料増部分解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinyoteiriritu zrnsaisinyoteiriritu}</td><td>（連携用）最新予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkaiyakusjkkktyouseirrt zrnsrkaiyakusjkkktyouseirrt}</td><td>（連携用）数理用解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkyksjkkktyouseiriritu zrnsrkyksjkkktyouseiriritu}</td><td>（連携用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnmvakeisankijyunymd zrnmvakeisankijyunymd}</td><td>（連携用）ＭＶＡ計算基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseikou zrnmvatyouseikou}</td><td>（連携用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8 zrnsuuriyouyobin8}</td><td>（連携用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x2 zrnsuuriyouyobin10x2}</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x9 zrnyobin11x9}</td><td>（連携用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv11 zrnyobiv11}</td><td>（連携用）予備項目Ｖ１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KaiykHrSoutougakuRn
 * @see     PKZT_KaiykHrSoutougakuRn
 * @see     QZT_KaiykHrSoutougakuRn
 * @see     GenQZT_KaiykHrSoutougakuRn
 */
@MappedSuperclass
@Table(name=GenZT_KaiykHrSoutougakuRn.TABLE_NAME)
@IdClass(value=PKZT_KaiykHrSoutougakuRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KaiykHrSoutougakuRn extends AbstractExDBEntityForZDB<ZT_KaiykHrSoutougakuRn, PKZT_KaiykHrSoutougakuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KaiykHrSoutougakuRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNKEISANKIJYUNYM        = "zrnkeisankijyunym";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNSYUTKKBN              = "zrnsyutkkbn";
    public static final String ZRNSUURISYURUICD         = "zrnsuurisyuruicd";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNHARAIKATAKBN          = "zrnharaikatakbn";
    public static final String ZRNTENKANITIJIBARAIKBN   = "zrntenkanitijibaraikbn";
    public static final String ZRNTYUUTOHUKAHYOUJI      = "zrntyuutohukahyouji";
    public static final String ZRNSUURIYOUYOBIN6        = "zrnsuuriyouyobin6";
    public static final String ZRNYOBIV6X2              = "zrnyobiv6x2";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSOTODASIKOUSINKBN     = "zrnsotodasikousinkbn";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNHOKENSYURUIKIGOUYOBI  = "zrnhokensyuruikigouyobi";
    public static final String ZRNTOKUYAKUGATAKBN       = "zrntokuyakugatakbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNTKBTHSYUMNRYUHYOUJI   = "zrntkbthsyumnryuhyouji";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNKYKJYOUTAI            = "zrnkykjyoutai";
    public static final String ZRNHARAIZUMIENTYOUJIAGE  = "zrnharaizumientyoujiage";
    public static final String ZRNENTYOUKIKAN           = "zrnentyoukikan";
    public static final String ZRNSITEIMPBAIRITU        = "zrnsiteimpbairitu";
    public static final String ZRNPWARIMASISITEIM1      = "zrnpwarimasisiteim1";
    public static final String ZRNPWARIMASISITEIM2      = "zrnpwarimasisiteim2";
    public static final String ZRNSAISYUUSITEIYM        = "zrnsaisyuusiteiym";
    public static final String ZRNSEIZONKYUUHUKINSHRMD  = "zrnseizonkyuuhukinshrmd";
    public static final String ZRNKEIKANENSUU           = "zrnkeikanensuu";
    public static final String ZRNKEIKATUKISUU          = "zrnkeikatukisuu";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNTNKNHKTGKUJYARHYOUJI  = "zrntnknhktgkujyarhyouji";
    public static final String ZRNTOKUYAKUKBN           = "zrntokuyakukbn";
    public static final String ZRNTOKUYAKUNO            = "zrntokuyakuno";
    public static final String ZRNDI2HKNKKNIKOUJIHISYAAGE = "zrndi2hknkknikoujihisyaage";
    public static final String ZRNRECORDNO              = "zrnrecordno";
    public static final String ZRNMFKURIAGEKURISAGEKBN  = "zrnmfkuriagekurisagekbn";
    public static final String ZRNMFANNAIHUYOURIYUUKBN  = "zrnmfannaihuyouriyuukbn";
    public static final String ZRNHRIZMJHKNSYUKIGOUSDKBN = "zrnhrizmjhknsyukigousdkbn";
    public static final String ZRNHOKENHOUTEKIYOUHYOUJI = "zrnhokenhoutekiyouhyouji";
    public static final String ZRNTOKUBETUHOSYOUKIKAN   = "zrntokubetuhosyoukikan";
    public static final String ZRNSINTOKUJYOUHYOUJI     = "zrnsintokujyouhyouji";
    public static final String ZRNTKJYKBN               = "zrntkjykbn";
    public static final String ZRNRYOUMASIHYOUTEN       = "zrnryoumasihyouten";
    public static final String ZRNDAI2TOKUJYOUKBN       = "zrndai2tokujyoukbn";
    public static final String ZRNDAI2RYOUMASIHYOUTEN   = "zrndai2ryoumasihyouten";
    public static final String ZRNYTIRRTHNDSYSNMNSKAISUU = "zrnytirrthndsysnmnskaisuu";
    public static final String ZRNKOUSINMANRYOUAGE      = "zrnkousinmanryouage";
    public static final String ZRNSUURIYOUYOBIN9        = "zrnsuuriyouyobin9";
    public static final String ZRNKRSGJHKNSYUKIGOUSDKBN = "zrnkrsgjhknsyukigousdkbn";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNYOBIV15               = "zrnyobiv15";
    public static final String ZRNERRTOKUTEIKOUMOKU     = "zrnerrtokuteikoumoku";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNHENKOUGOKIHONS        = "zrnhenkougokihons";
    public static final String ZRNHENKOUGOSIBOUS        = "zrnhenkougosibous";
    public static final String ZRNGYOUSEKIHYOUJIS       = "zrngyousekihyoujis";
    public static final String ZRNGOUKEITENKANKAKAKU    = "zrngoukeitenkankakaku";
    public static final String ZRNWNASIGOUKEITENKANTEIKIS = "zrnwnasigoukeitenkanteikis";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNKAIYAKUHR             = "zrnkaiyakuhr";
    public static final String ZRNRYUMSBBNKAIYAKUHR     = "zrnryumsbbnkaiyakuhr";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNSAISINYOTEIRIRITU     = "zrnsaisinyoteiriritu";
    public static final String ZRNSRKAIYAKUSJKKKTYOUSEIRRT = "zrnsrkaiyakusjkkktyouseirrt";
    public static final String ZRNSRKYKSJKKKTYOUSEIRIRITU = "zrnsrkyksjkkktyouseiriritu";
    public static final String ZRNMVAKEISANKIJYUNYMD    = "zrnmvakeisankijyunymd";
    public static final String ZRNMVATYOUSEIKOU         = "zrnmvatyouseikou";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN8        = "zrnsuuriyouyobin8";
    public static final String ZRNSUURIYOUYOBIN10X2     = "zrnsuuriyouyobin10x2";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIN11X9             = "zrnyobin11x9";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV11               = "zrnyobiv11";

    private final PKZT_KaiykHrSoutougakuRn primaryKey;

    public GenZT_KaiykHrSoutougakuRn() {
        primaryKey = new PKZT_KaiykHrSoutougakuRn();
    }

    public GenZT_KaiykHrSoutougakuRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_KaiykHrSoutougakuRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_KaiykHrSoutougakuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KaiykHrSoutougakuRn> getMetaClass() {
        return QZT_KaiykHrSoutougakuRn.class;
    }

    @Id
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnyobiv12;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private String zrnkeisankijyunym;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKEISANKIJYUNYM)
    public String getZrnkeisankijyunym() {
        return zrnkeisankijyunym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnkeisankijyunym(String pZrnkeisankijyunym) {
        zrnkeisankijyunym = pZrnkeisankijyunym;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnsyutkkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSYUTKKBN)
    public String getZrnsyutkkbn() {
        return zrnsyutkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyutkkbn(String pZrnsyutkkbn) {
        zrnsyutkkbn = pZrnsyutkkbn;
    }

    private String zrnsuurisyuruicd;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSUURISYURUICD)
    public String getZrnsuurisyuruicd() {
        return zrnsuurisyuruicd;
    }

    public void setZrnsuurisyuruicd(String pZrnsuurisyuruicd) {
        zrnsuurisyuruicd = pZrnsuurisyuruicd;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnharaikatakbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHARAIKATAKBN)
    public String getZrnharaikatakbn() {
        return zrnharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikatakbn(String pZrnharaikatakbn) {
        zrnharaikatakbn = pZrnharaikatakbn;
    }

    private String zrntenkanitijibaraikbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTENKANITIJIBARAIKBN)
    public String getZrntenkanitijibaraikbn() {
        return zrntenkanitijibaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanitijibaraikbn(String pZrntenkanitijibaraikbn) {
        zrntenkanitijibaraikbn = pZrntenkanitijibaraikbn;
    }

    private String zrntyuutohukahyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTYUUTOHUKAHYOUJI)
    public String getZrntyuutohukahyouji() {
        return zrntyuutohukahyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntyuutohukahyouji(String pZrntyuutohukahyouji) {
        zrntyuutohukahyouji = pZrntyuutohukahyouji;
    }

    private String zrnsuuriyouyobin6;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSUURIYOUYOBIN6)
    public String getZrnsuuriyouyobin6() {
        return zrnsuuriyouyobin6;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyouyobin6(String pZrnsuuriyouyobin6) {
        zrnsuuriyouyobin6 = pZrnsuuriyouyobin6;
    }

    private String zrnyobiv6x2;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIV6X2)
    public String getZrnyobiv6x2() {
        return zrnyobiv6x2;
    }

    public void setZrnyobiv6x2(String pZrnyobiv6x2) {
        zrnyobiv6x2 = pZrnyobiv6x2;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnsotodasikousinkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSOTODASIKOUSINKBN)
    public String getZrnsotodasikousinkbn() {
        return zrnsotodasikousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasikousinkbn(String pZrnsotodasikousinkbn) {
        zrnsotodasikousinkbn = pZrnsotodasikousinkbn;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnhokensyuruikigouyobi;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHOKENSYURUIKIGOUYOBI)
    public String getZrnhokensyuruikigouyobi() {
        return zrnhokensyuruikigouyobi;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnhokensyuruikigouyobi(String pZrnhokensyuruikigouyobi) {
        zrnhokensyuruikigouyobi = pZrnhokensyuruikigouyobi;
    }

    private String zrntokuyakugatakbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTOKUYAKUGATAKBN)
    public String getZrntokuyakugatakbn() {
        return zrntokuyakugatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakugatakbn(String pZrntokuyakugatakbn) {
        zrntokuyakugatakbn = pZrntokuyakugatakbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrntkbthsyumnryuhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTKBTHSYUMNRYUHYOUJI)
    public String getZrntkbthsyumnryuhyouji() {
        return zrntkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntkbthsyumnryuhyouji(String pZrntkbthsyumnryuhyouji) {
        zrntkbthsyumnryuhyouji = pZrntkbthsyumnryuhyouji;
    }

    private String zrnnknshry;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnkykjyoutai;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKYKJYOUTAI)
    public String getZrnkykjyoutai() {
        return zrnkykjyoutai;
    }

    public void setZrnkykjyoutai(String pZrnkykjyoutai) {
        zrnkykjyoutai = pZrnkykjyoutai;
    }

    private String zrnharaizumientyoujiage;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHARAIZUMIENTYOUJIAGE)
    public String getZrnharaizumientyoujiage() {
        return zrnharaizumientyoujiage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaizumientyoujiage(String pZrnharaizumientyoujiage) {
        zrnharaizumientyoujiage = pZrnharaizumientyoujiage;
    }

    private String zrnentyoukikan;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNENTYOUKIKAN)
    public String getZrnentyoukikan() {
        return zrnentyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnentyoukikan(String pZrnentyoukikan) {
        zrnentyoukikan = pZrnentyoukikan;
    }

    private String zrnsiteimpbairitu;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSITEIMPBAIRITU)
    public String getZrnsiteimpbairitu() {
        return zrnsiteimpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiteimpbairitu(String pZrnsiteimpbairitu) {
        zrnsiteimpbairitu = pZrnsiteimpbairitu;
    }

    private String zrnpwarimasisiteim1;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNPWARIMASISITEIM1)
    public String getZrnpwarimasisiteim1() {
        return zrnpwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim1(String pZrnpwarimasisiteim1) {
        zrnpwarimasisiteim1 = pZrnpwarimasisiteim1;
    }

    private String zrnpwarimasisiteim2;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNPWARIMASISITEIM2)
    public String getZrnpwarimasisiteim2() {
        return zrnpwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim2(String pZrnpwarimasisiteim2) {
        zrnpwarimasisiteim2 = pZrnpwarimasisiteim2;
    }

    private String zrnsaisyuusiteiym;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSAISYUUSITEIYM)
    public String getZrnsaisyuusiteiym() {
        return zrnsaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsaisyuusiteiym(String pZrnsaisyuusiteiym) {
        zrnsaisyuusiteiym = pZrnsaisyuusiteiym;
    }

    private String zrnseizonkyuuhukinshrmd;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSEIZONKYUUHUKINSHRMD)
    public String getZrnseizonkyuuhukinshrmd() {
        return zrnseizonkyuuhukinshrmd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnseizonkyuuhukinshrmd(String pZrnseizonkyuuhukinshrmd) {
        zrnseizonkyuuhukinshrmd = pZrnseizonkyuuhukinshrmd;
    }

    private String zrnkeikanensuu;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKEIKANENSUU)
    public String getZrnkeikanensuu() {
        return zrnkeikanensuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkeikanensuu(String pZrnkeikanensuu) {
        zrnkeikanensuu = pZrnkeikanensuu;
    }

    private String zrnkeikatukisuu;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKEIKATUKISUU)
    public String getZrnkeikatukisuu() {
        return zrnkeikatukisuu;
    }

    public void setZrnkeikatukisuu(String pZrnkeikatukisuu) {
        zrnkeikatukisuu = pZrnkeikatukisuu;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private String zrntnknhktgkujyarhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTNKNHKTGKUJYARHYOUJI)
    public String getZrntnknhktgkujyarhyouji() {
        return zrntnknhktgkujyarhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknhktgkujyarhyouji(String pZrntnknhktgkujyarhyouji) {
        zrntnknhktgkujyarhyouji = pZrntnknhktgkujyarhyouji;
    }

    private String zrntokuyakukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTOKUYAKUKBN)
    public String getZrntokuyakukbn() {
        return zrntokuyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukbn(String pZrntokuyakukbn) {
        zrntokuyakukbn = pZrntokuyakukbn;
    }

    private String zrntokuyakuno;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTOKUYAKUNO)
    public String getZrntokuyakuno() {
        return zrntokuyakuno;
    }

    public void setZrntokuyakuno(String pZrntokuyakuno) {
        zrntokuyakuno = pZrntokuyakuno;
    }

    private String zrndi2hknkknikoujihisyaage;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNDI2HKNKKNIKOUJIHISYAAGE)
    public String getZrndi2hknkknikoujihisyaage() {
        return zrndi2hknkknikoujihisyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2hknkknikoujihisyaage(String pZrndi2hknkknikoujihisyaage) {
        zrndi2hknkknikoujihisyaage = pZrndi2hknkknikoujihisyaage;
    }

    private String zrnrecordno;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNRECORDNO)
    public String getZrnrecordno() {
        return zrnrecordno;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnrecordno(String pZrnrecordno) {
        zrnrecordno = pZrnrecordno;
    }

    private String zrnmfkuriagekurisagekbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNMFKURIAGEKURISAGEKBN)
    public String getZrnmfkuriagekurisagekbn() {
        return zrnmfkuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmfkuriagekurisagekbn(String pZrnmfkuriagekurisagekbn) {
        zrnmfkuriagekurisagekbn = pZrnmfkuriagekurisagekbn;
    }

    private String zrnmfannaihuyouriyuukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNMFANNAIHUYOURIYUUKBN)
    public String getZrnmfannaihuyouriyuukbn() {
        return zrnmfannaihuyouriyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmfannaihuyouriyuukbn(String pZrnmfannaihuyouriyuukbn) {
        zrnmfannaihuyouriyuukbn = pZrnmfannaihuyouriyuukbn;
    }

    private String zrnhrizmjhknsyukigousdkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHRIZMJHKNSYUKIGOUSDKBN)
    public String getZrnhrizmjhknsyukigousdkbn() {
        return zrnhrizmjhknsyukigousdkbn;
    }

    public void setZrnhrizmjhknsyukigousdkbn(String pZrnhrizmjhknsyukigousdkbn) {
        zrnhrizmjhknsyukigousdkbn = pZrnhrizmjhknsyukigousdkbn;
    }

    private String zrnhokenhoutekiyouhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHOKENHOUTEKIYOUHYOUJI)
    public String getZrnhokenhoutekiyouhyouji() {
        return zrnhokenhoutekiyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhokenhoutekiyouhyouji(String pZrnhokenhoutekiyouhyouji) {
        zrnhokenhoutekiyouhyouji = pZrnhokenhoutekiyouhyouji;
    }

    private String zrntokubetuhosyoukikan;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTOKUBETUHOSYOUKIKAN)
    public String getZrntokubetuhosyoukikan() {
        return zrntokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokubetuhosyoukikan(String pZrntokubetuhosyoukikan) {
        zrntokubetuhosyoukikan = pZrntokubetuhosyoukikan;
    }

    private String zrnsintokujyouhyouji;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSINTOKUJYOUHYOUJI)
    public String getZrnsintokujyouhyouji() {
        return zrnsintokujyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsintokujyouhyouji(String pZrnsintokujyouhyouji) {
        zrnsintokujyouhyouji = pZrnsintokujyouhyouji;
    }

    private String zrntkjykbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTKJYKBN)
    public String getZrntkjykbn() {
        return zrntkjykbn;
    }

    public void setZrntkjykbn(String pZrntkjykbn) {
        zrntkjykbn = pZrntkjykbn;
    }

    private Integer zrnryoumasihyouten;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNRYOUMASIHYOUTEN)
    public Integer getZrnryoumasihyouten() {
        return zrnryoumasihyouten;
    }

    public void setZrnryoumasihyouten(Integer pZrnryoumasihyouten) {
        zrnryoumasihyouten = pZrnryoumasihyouten;
    }

    private String zrndai2tokujyoukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNDAI2TOKUJYOUKBN)
    public String getZrndai2tokujyoukbn() {
        return zrndai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tokujyoukbn(String pZrndai2tokujyoukbn) {
        zrndai2tokujyoukbn = pZrndai2tokujyoukbn;
    }

    private Integer zrndai2ryoumasihyouten;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNDAI2RYOUMASIHYOUTEN)
    public Integer getZrndai2ryoumasihyouten() {
        return zrndai2ryoumasihyouten;
    }

    public void setZrndai2ryoumasihyouten(Integer pZrndai2ryoumasihyouten) {
        zrndai2ryoumasihyouten = pZrndai2ryoumasihyouten;
    }

    private String zrnytirrthndsysnmnskaisuu;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYTIRRTHNDSYSNMNSKAISUU)
    public String getZrnytirrthndsysnmnskaisuu() {
        return zrnytirrthndsysnmnskaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnytirrthndsysnmnskaisuu(String pZrnytirrthndsysnmnskaisuu) {
        zrnytirrthndsysnmnskaisuu = pZrnytirrthndsysnmnskaisuu;
    }

    private String zrnkousinmanryouage;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKOUSINMANRYOUAGE)
    public String getZrnkousinmanryouage() {
        return zrnkousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkousinmanryouage(String pZrnkousinmanryouage) {
        zrnkousinmanryouage = pZrnkousinmanryouage;
    }

    private String zrnsuuriyouyobin9;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSUURIYOUYOBIN9)
    public String getZrnsuuriyouyobin9() {
        return zrnsuuriyouyobin9;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9(String pZrnsuuriyouyobin9) {
        zrnsuuriyouyobin9 = pZrnsuuriyouyobin9;
    }

    private String zrnkrsgjhknsyukigousdkbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKRSGJHKNSYUKIGOUSDKBN)
    public String getZrnkrsgjhknsyukigousdkbn() {
        return zrnkrsgjhknsyukigousdkbn;
    }

    public void setZrnkrsgjhknsyukigousdkbn(String pZrnkrsgjhknsyukigousdkbn) {
        zrnkrsgjhknsyukigousdkbn = pZrnkrsgjhknsyukigousdkbn;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnyobiv15;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIV15)
    public String getZrnyobiv15() {
        return zrnyobiv15;
    }

    public void setZrnyobiv15(String pZrnyobiv15) {
        zrnyobiv15 = pZrnyobiv15;
    }

    private String zrnerrtokuteikoumoku;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNERRTOKUTEIKOUMOKU)
    public String getZrnerrtokuteikoumoku() {
        return zrnerrtokuteikoumoku;
    }

    public void setZrnerrtokuteikoumoku(String pZrnerrtokuteikoumoku) {
        zrnerrtokuteikoumoku = pZrnerrtokuteikoumoku;
    }

    private Long zrnkihons;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrnhenkougokihons;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHENKOUGOKIHONS)
    public Long getZrnhenkougokihons() {
        return zrnhenkougokihons;
    }

    public void setZrnhenkougokihons(Long pZrnhenkougokihons) {
        zrnhenkougokihons = pZrnhenkougokihons;
    }

    private Long zrnhenkougosibous;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNHENKOUGOSIBOUS)
    public Long getZrnhenkougosibous() {
        return zrnhenkougosibous;
    }

    public void setZrnhenkougosibous(Long pZrnhenkougosibous) {
        zrnhenkougosibous = pZrnhenkougosibous;
    }

    private Long zrngyousekihyoujis;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNGYOUSEKIHYOUJIS)
    public Long getZrngyousekihyoujis() {
        return zrngyousekihyoujis;
    }

    public void setZrngyousekihyoujis(Long pZrngyousekihyoujis) {
        zrngyousekihyoujis = pZrngyousekihyoujis;
    }

    private Long zrngoukeitenkankakaku;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNGOUKEITENKANKAKAKU)
    public Long getZrngoukeitenkankakaku() {
        return zrngoukeitenkankakaku;
    }

    public void setZrngoukeitenkankakaku(Long pZrngoukeitenkankakaku) {
        zrngoukeitenkankakaku = pZrngoukeitenkankakaku;
    }

    private Long zrnwnasigoukeitenkanteikis;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNWNASIGOUKEITENKANTEIKIS)
    public Long getZrnwnasigoukeitenkanteikis() {
        return zrnwnasigoukeitenkanteikis;
    }

    public void setZrnwnasigoukeitenkanteikis(Long pZrnwnasigoukeitenkanteikis) {
        zrnwnasigoukeitenkanteikis = pZrnwnasigoukeitenkanteikis;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnkaiyakuhr;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKAIYAKUHR)
    public Long getZrnkaiyakuhr() {
        return zrnkaiyakuhr;
    }

    public void setZrnkaiyakuhr(Long pZrnkaiyakuhr) {
        zrnkaiyakuhr = pZrnkaiyakuhr;
    }

    private Long zrnryumsbbnkaiyakuhr;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNRYUMSBBNKAIYAKUHR)
    public Long getZrnryumsbbnkaiyakuhr() {
        return zrnryumsbbnkaiyakuhr;
    }

    public void setZrnryumsbbnkaiyakuhr(Long pZrnryumsbbnkaiyakuhr) {
        zrnryumsbbnkaiyakuhr = pZrnryumsbbnkaiyakuhr;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private BizNumber zrnsaisinyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSAISINYOTEIRIRITU)
    public BizNumber getZrnsaisinyoteiriritu() {
        return zrnsaisinyoteiriritu;
    }

    public void setZrnsaisinyoteiriritu(BizNumber pZrnsaisinyoteiriritu) {
        zrnsaisinyoteiriritu = pZrnsaisinyoteiriritu;
    }

    private BizNumber zrnsrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZrnsrkaiyakusjkkktyouseirrt() {
        return zrnsrkaiyakusjkkktyouseirrt;
    }

    public void setZrnsrkaiyakusjkkktyouseirrt(BizNumber pZrnsrkaiyakusjkkktyouseirrt) {
        zrnsrkaiyakusjkkktyouseirrt = pZrnsrkaiyakusjkkktyouseirrt;
    }

    private BizNumber zrnsrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZrnsrkyksjkkktyouseiriritu() {
        return zrnsrkyksjkkktyouseiriritu;
    }

    public void setZrnsrkyksjkkktyouseiriritu(BizNumber pZrnsrkyksjkkktyouseiriritu) {
        zrnsrkyksjkkktyouseiriritu = pZrnsrkyksjkkktyouseiriritu;
    }

    private String zrnmvakeisankijyunymd;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNMVAKEISANKIJYUNYMD)
    public String getZrnmvakeisankijyunymd() {
        return zrnmvakeisankijyunymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnmvakeisankijyunymd(String pZrnmvakeisankijyunymd) {
        zrnmvakeisankijyunymd = pZrnmvakeisankijyunymd;
    }

    private BizNumber zrnmvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNMVATYOUSEIKOU)
    public BizNumber getZrnmvatyouseikou() {
        return zrnmvatyouseikou;
    }

    public void setZrnmvatyouseikou(BizNumber pZrnmvatyouseikou) {
        zrnmvatyouseikou = pZrnmvatyouseikou;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin8;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSUURIYOUYOBIN8)
    public String getZrnsuuriyouyobin8() {
        return zrnsuuriyouyobin8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8(String pZrnsuuriyouyobin8) {
        zrnsuuriyouyobin8 = pZrnsuuriyouyobin8;
    }

    private String zrnsuuriyouyobin10x2;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNSUURIYOUYOBIN10X2)
    public String getZrnsuuriyouyobin10x2() {
        return zrnsuuriyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x2(String pZrnsuuriyouyobin10x2) {
        zrnsuuriyouyobin10x2 = pZrnsuuriyouyobin10x2;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private Long zrnyobin11x9;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIN11X9)
    public Long getZrnyobin11x9() {
        return zrnyobin11x9;
    }

    public void setZrnyobin11x9(Long pZrnyobin11x9) {
        zrnyobin11x9 = pZrnyobin11x9;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv11;

    @Column(name=GenZT_KaiykHrSoutougakuRn.ZRNYOBIV11)
    public String getZrnyobiv11() {
        return zrnyobiv11;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnyobiv11(String pZrnyobiv11) {
        zrnyobiv11 = pZrnyobiv11;
    }
}