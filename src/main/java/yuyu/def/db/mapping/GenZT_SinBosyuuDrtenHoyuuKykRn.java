package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.id.PKZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.GenQZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykRn;

/**
 * 代理店月次契約情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SinBosyuuDrtenHoyuuKykRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinBosyuuDrtenHoyuuKykRn}</td><td colspan="3">代理店月次契約情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SinBosyuuDrtenHoyuuKykRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeicd zrnmdhnaisyoumeicd}</td><td>（連携用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisyoumeidrtengetuji zrnaisyoumeidrtengetuji}</td><td>（連携用）愛称名（代理店月次）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbndrtengetuji zrnharaikatakbndrtengetuji}</td><td>（連携用）払方区分（代理店月次）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyohnbnrikbndrtengetuji zrnsyohnbnrikbndrtengetuji}</td><td>（連携用）商品分類区分（代理店月次）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikaiyakuhrkngatahyj zrnteikaiyakuhrkngatahyj}</td><td>（連携用）低解約返戻金型表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsyaatkioydrtencd zrnskeibsyaatkioydrtencd}</td><td>（連携用）新契約募集時Ａ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsybatkioydrtencd zrnskeibsybatkioydrtencd}</td><td>（連携用）新契約募集時Ｂ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsyaatkidrtencd zrnskeibsyaatkidrtencd}</td><td>（連携用）新契約募集時Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsybatkidrtencd zrnskeibsybatkidrtencd}</td><td>（連携用）新契約募集時Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsyaatkibosyuucd zrnskeibsyaatkibosyuucd}</td><td>（連携用）新契約募集時Ａ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsybatkibosyuucd zrnskeibsybatkibosyuucd}</td><td>（連携用）新契約募集時Ｂ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkknmanryouymd zrnhknkknmanryouymd}</td><td>（連携用）保険期間満了日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkpdrtengetuji zrnhrkpdrtengetuji}</td><td>（連携用）払込保険料（代理店月次）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkansanpheijyun zrnnenkansanpheijyun}</td><td>（連携用）年換算保険料（平準払）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnknkyknm18 zrnknkyknm18}</td><td>（連携用）カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmdrtengetuji zrnkyknmdrtengetuji}</td><td>（連携用）契約者名（代理店月次）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknenkykji zrnkyknenkykji}</td><td>（連携用）契約者年齢（契約時）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknengenzai zrnkyknengenzai}</td><td>（連携用）契約者年齢（現在）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkpjyuutouym zrnhrkpjyuutouym}</td><td>（連携用）払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmpjytym zrnkihrkmpjytym}</td><td>（連携用）既払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrkmpmf zrnkihrkmpmf}</td><td>（連携用）既払込保険料（ＭＦ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihrkmpruikei zrnkihrkmpruikei}</td><td>（連携用）既払込保険料（累計）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyksymtjiw zrnkaiyksymtjiw}</td><td>（連携用）解約消滅時解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyksymtjikihrkmp zrnkaiyksymtjikihrkmp}</td><td>（連携用）解約消滅時既払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyksymtjiunyousoneki zrnkaiyksymtjiunyousoneki}</td><td>（連携用）解約消滅時運用損益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyksymtjiunyousonekirt zrnkaiyksymtjiunyousonekirt}</td><td>（連携用）解約消滅時運用損益率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwkeisanerrkbn zrnwkeisanerrkbn}</td><td>（連携用）解約返戻金計算エラー区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnknksjihenreikingk zrnmnknksjihenreikingk}</td><td>（連携用）満期年金開始時返戻金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmnknksjikihrkmp zrnmnknksjikihrkmp}</td><td>（連携用）満期年金開始時既払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmnknksjiunyousoneki zrnmnknksjiunyousoneki}</td><td>（連携用）満期年金開始時運用損益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmnknksjiunyousonekirt zrnmnknksjiunyousonekirt}</td><td>（連携用）満期年金開始時運用損益率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmnknkskeisanerrkbn zrnmnknkskeisanerrkbn}</td><td>（連携用）満期年金開始計算エラー区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkansanpanp zrnnenkansanpanp}</td><td>（連携用）年換算保険料（ＡＮ保険料）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkansanpkeisanerrkbn zrnnenkansanpkeisanerrkbn}</td><td>（連携用）年換算保険料計算エラー区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkpgaika zrnhrkpgaika}</td><td>（連携用）払込Ｐ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkaiyksymtjiwgaika zrnkaiyksymtjiwgaika}</td><td>（連携用）解約消滅時解約返戻金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntuuka zrntuuka}</td><td>（連携用）通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrpyendrtengetuji zrnitijibrpyendrtengetuji}</td><td>（連携用）一時払保険料（円）（代理店月次）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitijibrpgaika zrnitijibrpgaika}</td><td>（連携用）一時払保険料（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkiuktrknyen zrnkiuktrknyen}</td><td>（連携用）既受取金（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkiuktrkngaika zrnkiuktrkngaika}</td><td>（連携用）既受取金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntmttknyen zrntmttknyen}</td><td>（連携用）積立金（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntmttkngaika zrntmttkngaika}</td><td>（連携用）積立金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukjetcyen zrnkaiyakukjetcyen}</td><td>（連携用）解約控除等（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukjetcgaika zrnkaiyakukjetcgaika}</td><td>（連携用）解約控除等（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnwyendrtengetuji zrnwyendrtengetuji}</td><td>（連携用）解約返戻金（円）（代理店月次）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrkngaika zrnkaiyakuhrkngaika}</td><td>（連携用）解約返戻金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsonekiyen zrnsonekiyen}</td><td>（連携用）損益（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonekigaika zrnsonekigaika}</td><td>（連携用）損益（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsbsetcyen zrnsbsetcyen}</td><td>（連携用）死亡保険金等（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsbsetcgaika zrnsbsetcgaika}</td><td>（連携用）死亡保険金等（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsonekicalchunouflg zrnsonekicalchunouflg}</td><td>（連携用）損益計算不能フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkjdrtengetuji zrnhhknnmkjdrtengetuji}</td><td>（連携用）被保険者名（漢字）（代理店月次）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntargettktoutatubi zrntargettktoutatubi}</td><td>（連携用）ターゲット到達日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmokuhyouti zrnmokuhyouti}</td><td>（連携用）目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmokuhyoukngk zrnmokuhyoukngk}</td><td>（連携用）目標金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihrpruikeigk zrnkihrpruikeigk}</td><td>（連携用）既払保険料累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntousyokykjikawaserate zrntousyokykjikawaserate}</td><td>（連携用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnwkeisanerrorhyj zrnwkeisanerrorhyj}</td><td>（連携用）解約返戻金計算エラー表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngmeigyoubijikawaserate zrngmeigyoubijikawaserate}</td><td>（連携用）月末営業日時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnikueisikin zrnikueisikin}</td><td>（連携用）育英資金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngakusiiwaikn zrngakusiiwaikn}</td><td>（連携用）学資祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukaseizonssueokikn zrnzoukaseizonssueokikn}</td><td>（連携用）増加生存Ｓ据置金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnknkuiwaikn zrnknkuiwaikn}</td><td>（連携用）健康祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkijyuiwaikn zrnkijyuiwaikn}</td><td>（連携用）喜寿祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbeijyuiwaikn zrnbeijyuiwaikn}</td><td>（連携用）米寿祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsznkyhkn zrnsznkyhkn}</td><td>（連携用）生存給付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkyktsnatkitkykkyhkn zrnkyktsnatkitkykkyhkn}</td><td>（連携用）契約通算扱特約給付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzoukayourous zrnzoukayourous}</td><td>（連携用）増加養老保険金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntmtthaitoukin zrntmtthaitoukin}</td><td>（連携用）積立配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkbthaitoukin zrntkbthaitoukin}</td><td>（連携用）特別配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonotahaitoukin zrnsonotahaitoukin}</td><td>（連携用）その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngensentyousyuuzeigaku zrngensentyousyuuzeigaku}</td><td>（連携用）源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnottkekinganrigoukei zrnottkekinganrigoukei}</td><td>（連携用）お立替金元利合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkstkknganrigoukei zrnkstkknganrigoukei}</td><td>（連携用）貸付金元利合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmikeikamisyuup zrnmikeikamisyuup}</td><td>（連携用）未経過・未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonotaseisankin zrnsonotaseisankin}</td><td>（連携用）その他精算金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhuho2sjkkktyouseigkmva zrnhuho2sjkkktyouseigkmva}</td><td>（連携用）（普保Ⅱ）市場価格調整額（ＭＶＡ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhuho2yendthnkhr zrnhuho2yendthnkhr}</td><td>（連携用）（普保Ⅱ）円建変更時返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhuho2sjkkktyouseiriritu zrnhuho2sjkkktyouseiriritu}</td><td>（連携用）（普保Ⅱ）市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhuho2kaiyakukoujyoritu zrnhuho2kaiyakukoujyoritu}</td><td>（連携用）（普保Ⅱ）解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv66 zrnyobiv66}</td><td>（連携用）予備項目Ｖ６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinBosyuuDrtenHoyuuKykRn
 * @see     PKZT_SinBosyuuDrtenHoyuuKykRn
 * @see     QZT_SinBosyuuDrtenHoyuuKykRn
 * @see     GenQZT_SinBosyuuDrtenHoyuuKykRn
 */
@MappedSuperclass
@Table(name=GenZT_SinBosyuuDrtenHoyuuKykRn.TABLE_NAME)
@IdClass(value=PKZT_SinBosyuuDrtenHoyuuKykRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SinBosyuuDrtenHoyuuKykRn extends AbstractExDBEntityForZDB<ZT_SinBosyuuDrtenHoyuuKykRn, PKZT_SinBosyuuDrtenHoyuuKykRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinBosyuuDrtenHoyuuKykRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNMDHNAISYOUMEICD       = "zrnmdhnaisyoumeicd";
    public static final String ZRNAISYOUMEIDRTENGETUJI  = "zrnaisyoumeidrtengetuji";
    public static final String ZRNHARAIKATAKBNDRTENGETUJI = "zrnharaikatakbndrtengetuji";
    public static final String ZRNSYOHNBNRIKBNDRTENGETUJI = "zrnsyohnbnrikbndrtengetuji";
    public static final String ZRNTEIKAIYAKUHRKNGATAHYJ = "zrnteikaiyakuhrkngatahyj";
    public static final String ZRNSKEIBSYAATKIOYDRTENCD = "zrnskeibsyaatkioydrtencd";
    public static final String ZRNSKEIBSYBATKIOYDRTENCD = "zrnskeibsybatkioydrtencd";
    public static final String ZRNSKEIBSYAATKIDRTENCD   = "zrnskeibsyaatkidrtencd";
    public static final String ZRNSKEIBSYBATKIDRTENCD   = "zrnskeibsybatkidrtencd";
    public static final String ZRNSKEIBSYAATKIBOSYUUCD  = "zrnskeibsyaatkibosyuucd";
    public static final String ZRNSKEIBSYBATKIBOSYUUCD  = "zrnskeibsybatkibosyuucd";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNKKNMANRYOUYMD      = "zrnhknkknmanryouymd";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";
    public static final String ZRNHRKPDRTENGETUJI       = "zrnhrkpdrtengetuji";
    public static final String ZRNNENKANSANPHEIJYUN     = "zrnnenkansanpheijyun";
    public static final String ZRNKNKYKNM18             = "zrnknkyknm18";
    public static final String ZRNKYKNMDRTENGETUJI      = "zrnkyknmdrtengetuji";
    public static final String ZRNKYKNENKYKJI           = "zrnkyknenkykji";
    public static final String ZRNKYKNENGENZAI          = "zrnkyknengenzai";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNHRKPJYUUTOUYM         = "zrnhrkpjyuutouym";
    public static final String ZRNKIHRKMPJYTYM          = "zrnkihrkmpjytym";
    public static final String ZRNKIHRKMPMF             = "zrnkihrkmpmf";
    public static final String ZRNKIHRKMPRUIKEI         = "zrnkihrkmpruikei";
    public static final String ZRNKAIYKSYMTJIW          = "zrnkaiyksymtjiw";
    public static final String ZRNKAIYKSYMTJIKIHRKMP    = "zrnkaiyksymtjikihrkmp";
    public static final String ZRNKAIYKSYMTJIUNYOUSONEKI = "zrnkaiyksymtjiunyousoneki";
    public static final String ZRNKAIYKSYMTJIUNYOUSONEKIRT = "zrnkaiyksymtjiunyousonekirt";
    public static final String ZRNWKEISANERRKBN         = "zrnwkeisanerrkbn";
    public static final String ZRNMNKNKSJIHENREIKINGK   = "zrnmnknksjihenreikingk";
    public static final String ZRNMNKNKSJIKIHRKMP       = "zrnmnknksjikihrkmp";
    public static final String ZRNMNKNKSJIUNYOUSONEKI   = "zrnmnknksjiunyousoneki";
    public static final String ZRNMNKNKSJIUNYOUSONEKIRT = "zrnmnknksjiunyousonekirt";
    public static final String ZRNMNKNKSKEISANERRKBN    = "zrnmnknkskeisanerrkbn";
    public static final String ZRNNENKANSANPANP         = "zrnnenkansanpanp";
    public static final String ZRNNENKANSANPKEISANERRKBN = "zrnnenkansanpkeisanerrkbn";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNHRKPGAIKA             = "zrnhrkpgaika";
    public static final String ZRNKAIYKSYMTJIWGAIKA     = "zrnkaiyksymtjiwgaika";
    public static final String ZRNTUUKA                 = "zrntuuka";
    public static final String ZRNITIJIBRPYENDRTENGETUJI = "zrnitijibrpyendrtengetuji";
    public static final String ZRNITIJIBRPGAIKA         = "zrnitijibrpgaika";
    public static final String ZRNKIUKTRKNYEN           = "zrnkiuktrknyen";
    public static final String ZRNKIUKTRKNGAIKA         = "zrnkiuktrkngaika";
    public static final String ZRNTMTTKNYEN             = "zrntmttknyen";
    public static final String ZRNTMTTKNGAIKA           = "zrntmttkngaika";
    public static final String ZRNKAIYAKUKJETCYEN       = "zrnkaiyakukjetcyen";
    public static final String ZRNKAIYAKUKJETCGAIKA     = "zrnkaiyakukjetcgaika";
    public static final String ZRNWYENDRTENGETUJI       = "zrnwyendrtengetuji";
    public static final String ZRNKAIYAKUHRKNGAIKA      = "zrnkaiyakuhrkngaika";
    public static final String ZRNSONEKIYEN             = "zrnsonekiyen";
    public static final String ZRNSONEKIGAIKA           = "zrnsonekigaika";
    public static final String ZRNSBSETCYEN             = "zrnsbsetcyen";
    public static final String ZRNSBSETCGAIKA           = "zrnsbsetcgaika";
    public static final String ZRNSONEKICALCHUNOUFLG    = "zrnsonekicalchunouflg";
    public static final String ZRNHHKNNMKJDRTENGETUJI   = "zrnhhknnmkjdrtengetuji";
    public static final String ZRNTARGETTKTOUTATUBI     = "zrntargettktoutatubi";
    public static final String ZRNMOKUHYOUTI            = "zrnmokuhyouti";
    public static final String ZRNMOKUHYOUKNGK          = "zrnmokuhyoukngk";
    public static final String ZRNKIHRPRUIKEIGK         = "zrnkihrpruikeigk";
    public static final String ZRNTOUSYOKYKJIKAWASERATE = "zrntousyokykjikawaserate";
    public static final String ZRNWKEISANERRORHYJ       = "zrnwkeisanerrorhyj";
    public static final String ZRNGMEIGYOUBIJIKAWASERATE = "zrngmeigyoubijikawaserate";
    public static final String ZRNIKUEISIKIN            = "zrnikueisikin";
    public static final String ZRNGAKUSIIWAIKN          = "zrngakusiiwaikn";
    public static final String ZRNZOUKASEIZONSSUEOKIKN  = "zrnzoukaseizonssueokikn";
    public static final String ZRNKNKUIWAIKN            = "zrnknkuiwaikn";
    public static final String ZRNKIJYUIWAIKN           = "zrnkijyuiwaikn";
    public static final String ZRNBEIJYUIWAIKN          = "zrnbeijyuiwaikn";
    public static final String ZRNSZNKYHKN              = "zrnsznkyhkn";
    public static final String ZRNKYKTSNATKITKYKKYHKN   = "zrnkyktsnatkitkykkyhkn";
    public static final String ZRNZOUKAYOUROUS          = "zrnzoukayourous";
    public static final String ZRNTMTTHAITOUKIN         = "zrntmtthaitoukin";
    public static final String ZRNTKBTHAITOUKIN         = "zrntkbthaitoukin";
    public static final String ZRNSONOTAHAITOUKIN       = "zrnsonotahaitoukin";
    public static final String ZRNGENSENTYOUSYUUZEIGAKU = "zrngensentyousyuuzeigaku";
    public static final String ZRNOTTKEKINGANRIGOUKEI   = "zrnottkekinganrigoukei";
    public static final String ZRNKSTKKNGANRIGOUKEI     = "zrnkstkknganrigoukei";
    public static final String ZRNMIKEIKAMISYUUP        = "zrnmikeikamisyuup";
    public static final String ZRNSONOTASEISANKIN       = "zrnsonotaseisankin";
    public static final String ZRNHUHO2SJKKKTYOUSEIGKMVA = "zrnhuho2sjkkktyouseigkmva";
    public static final String ZRNHUHO2YENDTHNKHR       = "zrnhuho2yendthnkhr";
    public static final String ZRNHUHO2SJKKKTYOUSEIRIRITU = "zrnhuho2sjkkktyouseiriritu";
    public static final String ZRNHUHO2KAIYAKUKOUJYORITU = "zrnhuho2kaiyakukoujyoritu";
    public static final String ZRNYOBIV66               = "zrnyobiv66";

    private final PKZT_SinBosyuuDrtenHoyuuKykRn primaryKey;

    public GenZT_SinBosyuuDrtenHoyuuKykRn() {
        primaryKey = new PKZT_SinBosyuuDrtenHoyuuKykRn();
    }

    public GenZT_SinBosyuuDrtenHoyuuKykRn(String pZrnsyono) {
        primaryKey = new PKZT_SinBosyuuDrtenHoyuuKykRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SinBosyuuDrtenHoyuuKykRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinBosyuuDrtenHoyuuKykRn> getMetaClass() {
        return QZT_SinBosyuuDrtenHoyuuKykRn.class;
    }

    @Id
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnmdhnaisyoumeicd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMDHNAISYOUMEICD)
    public String getZrnmdhnaisyoumeicd() {
        return zrnmdhnaisyoumeicd;
    }

    public void setZrnmdhnaisyoumeicd(String pZrnmdhnaisyoumeicd) {
        zrnmdhnaisyoumeicd = pZrnmdhnaisyoumeicd;
    }

    private String zrnaisyoumeidrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNAISYOUMEIDRTENGETUJI)
    public String getZrnaisyoumeidrtengetuji() {
        return zrnaisyoumeidrtengetuji;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisyoumeidrtengetuji(String pZrnaisyoumeidrtengetuji) {
        zrnaisyoumeidrtengetuji = pZrnaisyoumeidrtengetuji;
    }

    private String zrnharaikatakbndrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHARAIKATAKBNDRTENGETUJI)
    public String getZrnharaikatakbndrtengetuji() {
        return zrnharaikatakbndrtengetuji;
    }

    public void setZrnharaikatakbndrtengetuji(String pZrnharaikatakbndrtengetuji) {
        zrnharaikatakbndrtengetuji = pZrnharaikatakbndrtengetuji;
    }

    private String zrnsyohnbnrikbndrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSYOHNBNRIKBNDRTENGETUJI)
    public String getZrnsyohnbnrikbndrtengetuji() {
        return zrnsyohnbnrikbndrtengetuji;
    }

    public void setZrnsyohnbnrikbndrtengetuji(String pZrnsyohnbnrikbndrtengetuji) {
        zrnsyohnbnrikbndrtengetuji = pZrnsyohnbnrikbndrtengetuji;
    }

    private String zrnteikaiyakuhrkngatahyj;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTEIKAIYAKUHRKNGATAHYJ)
    public String getZrnteikaiyakuhrkngatahyj() {
        return zrnteikaiyakuhrkngatahyj;
    }

    public void setZrnteikaiyakuhrkngatahyj(String pZrnteikaiyakuhrkngatahyj) {
        zrnteikaiyakuhrkngatahyj = pZrnteikaiyakuhrkngatahyj;
    }

    private String zrnskeibsyaatkioydrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSKEIBSYAATKIOYDRTENCD)
    public String getZrnskeibsyaatkioydrtencd() {
        return zrnskeibsyaatkioydrtencd;
    }

    public void setZrnskeibsyaatkioydrtencd(String pZrnskeibsyaatkioydrtencd) {
        zrnskeibsyaatkioydrtencd = pZrnskeibsyaatkioydrtencd;
    }

    private String zrnskeibsybatkioydrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSKEIBSYBATKIOYDRTENCD)
    public String getZrnskeibsybatkioydrtencd() {
        return zrnskeibsybatkioydrtencd;
    }

    public void setZrnskeibsybatkioydrtencd(String pZrnskeibsybatkioydrtencd) {
        zrnskeibsybatkioydrtencd = pZrnskeibsybatkioydrtencd;
    }

    private String zrnskeibsyaatkidrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSKEIBSYAATKIDRTENCD)
    public String getZrnskeibsyaatkidrtencd() {
        return zrnskeibsyaatkidrtencd;
    }

    public void setZrnskeibsyaatkidrtencd(String pZrnskeibsyaatkidrtencd) {
        zrnskeibsyaatkidrtencd = pZrnskeibsyaatkidrtencd;
    }

    private String zrnskeibsybatkidrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSKEIBSYBATKIDRTENCD)
    public String getZrnskeibsybatkidrtencd() {
        return zrnskeibsybatkidrtencd;
    }

    public void setZrnskeibsybatkidrtencd(String pZrnskeibsybatkidrtencd) {
        zrnskeibsybatkidrtencd = pZrnskeibsybatkidrtencd;
    }

    private String zrnskeibsyaatkibosyuucd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSKEIBSYAATKIBOSYUUCD)
    public String getZrnskeibsyaatkibosyuucd() {
        return zrnskeibsyaatkibosyuucd;
    }

    public void setZrnskeibsyaatkibosyuucd(String pZrnskeibsyaatkibosyuucd) {
        zrnskeibsyaatkibosyuucd = pZrnskeibsyaatkibosyuucd;
    }

    private String zrnskeibsybatkibosyuucd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSKEIBSYBATKIBOSYUUCD)
    public String getZrnskeibsybatkibosyuucd() {
        return zrnskeibsybatkibosyuucd;
    }

    public void setZrnskeibsybatkibosyuucd(String pZrnskeibsybatkibosyuucd) {
        zrnskeibsybatkibosyuucd = pZrnskeibsybatkibosyuucd;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnkykymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknkknmanryouymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHKNKKNMANRYOUYMD)
    public String getZrnhknkknmanryouymd() {
        return zrnhknkknmanryouymd;
    }

    public void setZrnhknkknmanryouymd(String pZrnhknkknmanryouymd) {
        zrnhknkknmanryouymd = pZrnhknkknmanryouymd;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }

    private Long zrnhrkpdrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHRKPDRTENGETUJI)
    public Long getZrnhrkpdrtengetuji() {
        return zrnhrkpdrtengetuji;
    }

    public void setZrnhrkpdrtengetuji(Long pZrnhrkpdrtengetuji) {
        zrnhrkpdrtengetuji = pZrnhrkpdrtengetuji;
    }

    private Long zrnnenkansanpheijyun;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNNENKANSANPHEIJYUN)
    public Long getZrnnenkansanpheijyun() {
        return zrnnenkansanpheijyun;
    }

    public void setZrnnenkansanpheijyun(Long pZrnnenkansanpheijyun) {
        zrnnenkansanpheijyun = pZrnnenkansanpheijyun;
    }

    private String zrnknkyknm18;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKNKYKNM18)
    public String getZrnknkyknm18() {
        return zrnknkyknm18;
    }

    public void setZrnknkyknm18(String pZrnknkyknm18) {
        zrnknkyknm18 = pZrnknkyknm18;
    }

    private String zrnkyknmdrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKNMDRTENGETUJI)
    public String getZrnkyknmdrtengetuji() {
        return zrnkyknmdrtengetuji;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmdrtengetuji(String pZrnkyknmdrtengetuji) {
        zrnkyknmdrtengetuji = pZrnkyknmdrtengetuji;
    }

    private String zrnkyknenkykji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKNENKYKJI)
    public String getZrnkyknenkykji() {
        return zrnkyknenkykji;
    }

    public void setZrnkyknenkykji(String pZrnkyknenkykji) {
        zrnkyknenkykji = pZrnkyknenkykji;
    }

    private String zrnkyknengenzai;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKNENGENZAI)
    public String getZrnkyknengenzai() {
        return zrnkyknengenzai;
    }

    public void setZrnkyknengenzai(String pZrnkyknengenzai) {
        zrnkyknengenzai = pZrnkyknengenzai;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnhrkpjyuutouym;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHRKPJYUUTOUYM)
    public String getZrnhrkpjyuutouym() {
        return zrnhrkpjyuutouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhrkpjyuutouym(String pZrnhrkpjyuutouym) {
        zrnhrkpjyuutouym = pZrnhrkpjyuutouym;
    }

    private String zrnkihrkmpjytym;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIHRKMPJYTYM)
    public String getZrnkihrkmpjytym() {
        return zrnkihrkmpjytym;
    }

    public void setZrnkihrkmpjytym(String pZrnkihrkmpjytym) {
        zrnkihrkmpjytym = pZrnkihrkmpjytym;
    }

    private Long zrnkihrkmpmf;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIHRKMPMF)
    public Long getZrnkihrkmpmf() {
        return zrnkihrkmpmf;
    }

    public void setZrnkihrkmpmf(Long pZrnkihrkmpmf) {
        zrnkihrkmpmf = pZrnkihrkmpmf;
    }

    private Long zrnkihrkmpruikei;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIHRKMPRUIKEI)
    public Long getZrnkihrkmpruikei() {
        return zrnkihrkmpruikei;
    }

    public void setZrnkihrkmpruikei(Long pZrnkihrkmpruikei) {
        zrnkihrkmpruikei = pZrnkihrkmpruikei;
    }

    private Long zrnkaiyksymtjiw;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYKSYMTJIW)
    public Long getZrnkaiyksymtjiw() {
        return zrnkaiyksymtjiw;
    }

    public void setZrnkaiyksymtjiw(Long pZrnkaiyksymtjiw) {
        zrnkaiyksymtjiw = pZrnkaiyksymtjiw;
    }

    private Long zrnkaiyksymtjikihrkmp;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYKSYMTJIKIHRKMP)
    public Long getZrnkaiyksymtjikihrkmp() {
        return zrnkaiyksymtjikihrkmp;
    }

    public void setZrnkaiyksymtjikihrkmp(Long pZrnkaiyksymtjikihrkmp) {
        zrnkaiyksymtjikihrkmp = pZrnkaiyksymtjikihrkmp;
    }

    private Long zrnkaiyksymtjiunyousoneki;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYKSYMTJIUNYOUSONEKI)
    public Long getZrnkaiyksymtjiunyousoneki() {
        return zrnkaiyksymtjiunyousoneki;
    }

    public void setZrnkaiyksymtjiunyousoneki(Long pZrnkaiyksymtjiunyousoneki) {
        zrnkaiyksymtjiunyousoneki = pZrnkaiyksymtjiunyousoneki;
    }

    private Long zrnkaiyksymtjiunyousonekirt;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYKSYMTJIUNYOUSONEKIRT)
    public Long getZrnkaiyksymtjiunyousonekirt() {
        return zrnkaiyksymtjiunyousonekirt;
    }

    public void setZrnkaiyksymtjiunyousonekirt(Long pZrnkaiyksymtjiunyousonekirt) {
        zrnkaiyksymtjiunyousonekirt = pZrnkaiyksymtjiunyousonekirt;
    }

    private String zrnwkeisanerrkbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNWKEISANERRKBN)
    public String getZrnwkeisanerrkbn() {
        return zrnwkeisanerrkbn;
    }

    public void setZrnwkeisanerrkbn(String pZrnwkeisanerrkbn) {
        zrnwkeisanerrkbn = pZrnwkeisanerrkbn;
    }

    private Long zrnmnknksjihenreikingk;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMNKNKSJIHENREIKINGK)
    public Long getZrnmnknksjihenreikingk() {
        return zrnmnknksjihenreikingk;
    }

    public void setZrnmnknksjihenreikingk(Long pZrnmnknksjihenreikingk) {
        zrnmnknksjihenreikingk = pZrnmnknksjihenreikingk;
    }

    private Long zrnmnknksjikihrkmp;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMNKNKSJIKIHRKMP)
    public Long getZrnmnknksjikihrkmp() {
        return zrnmnknksjikihrkmp;
    }

    public void setZrnmnknksjikihrkmp(Long pZrnmnknksjikihrkmp) {
        zrnmnknksjikihrkmp = pZrnmnknksjikihrkmp;
    }

    private Long zrnmnknksjiunyousoneki;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMNKNKSJIUNYOUSONEKI)
    public Long getZrnmnknksjiunyousoneki() {
        return zrnmnknksjiunyousoneki;
    }

    public void setZrnmnknksjiunyousoneki(Long pZrnmnknksjiunyousoneki) {
        zrnmnknksjiunyousoneki = pZrnmnknksjiunyousoneki;
    }

    private Long zrnmnknksjiunyousonekirt;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMNKNKSJIUNYOUSONEKIRT)
    public Long getZrnmnknksjiunyousonekirt() {
        return zrnmnknksjiunyousonekirt;
    }

    public void setZrnmnknksjiunyousonekirt(Long pZrnmnknksjiunyousonekirt) {
        zrnmnknksjiunyousonekirt = pZrnmnknksjiunyousonekirt;
    }

    private String zrnmnknkskeisanerrkbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMNKNKSKEISANERRKBN)
    public String getZrnmnknkskeisanerrkbn() {
        return zrnmnknkskeisanerrkbn;
    }

    public void setZrnmnknkskeisanerrkbn(String pZrnmnknkskeisanerrkbn) {
        zrnmnknkskeisanerrkbn = pZrnmnknkskeisanerrkbn;
    }

    private Long zrnnenkansanpanp;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNNENKANSANPANP)
    public Long getZrnnenkansanpanp() {
        return zrnnenkansanpanp;
    }

    public void setZrnnenkansanpanp(Long pZrnnenkansanpanp) {
        zrnnenkansanpanp = pZrnnenkansanpanp;
    }

    private String zrnnenkansanpkeisanerrkbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNNENKANSANPKEISANERRKBN)
    public String getZrnnenkansanpkeisanerrkbn() {
        return zrnnenkansanpkeisanerrkbn;
    }

    public void setZrnnenkansanpkeisanerrkbn(String pZrnnenkansanpkeisanerrkbn) {
        zrnnenkansanpkeisanerrkbn = pZrnnenkansanpkeisanerrkbn;
    }

    private String zrncifcd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private BizNumber zrnhrkpgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHRKPGAIKA)
    public BizNumber getZrnhrkpgaika() {
        return zrnhrkpgaika;
    }

    public void setZrnhrkpgaika(BizNumber pZrnhrkpgaika) {
        zrnhrkpgaika = pZrnhrkpgaika;
    }

    private BizNumber zrnkaiyksymtjiwgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYKSYMTJIWGAIKA)
    public BizNumber getZrnkaiyksymtjiwgaika() {
        return zrnkaiyksymtjiwgaika;
    }

    public void setZrnkaiyksymtjiwgaika(BizNumber pZrnkaiyksymtjiwgaika) {
        zrnkaiyksymtjiwgaika = pZrnkaiyksymtjiwgaika;
    }

    private String zrntuuka;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTUUKA)
    public String getZrntuuka() {
        return zrntuuka;
    }

    public void setZrntuuka(String pZrntuuka) {
        zrntuuka = pZrntuuka;
    }

    private Long zrnitijibrpyendrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNITIJIBRPYENDRTENGETUJI)
    public Long getZrnitijibrpyendrtengetuji() {
        return zrnitijibrpyendrtengetuji;
    }

    public void setZrnitijibrpyendrtengetuji(Long pZrnitijibrpyendrtengetuji) {
        zrnitijibrpyendrtengetuji = pZrnitijibrpyendrtengetuji;
    }

    private BizNumber zrnitijibrpgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNITIJIBRPGAIKA)
    public BizNumber getZrnitijibrpgaika() {
        return zrnitijibrpgaika;
    }

    public void setZrnitijibrpgaika(BizNumber pZrnitijibrpgaika) {
        zrnitijibrpgaika = pZrnitijibrpgaika;
    }

    private Long zrnkiuktrknyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIUKTRKNYEN)
    public Long getZrnkiuktrknyen() {
        return zrnkiuktrknyen;
    }

    public void setZrnkiuktrknyen(Long pZrnkiuktrknyen) {
        zrnkiuktrknyen = pZrnkiuktrknyen;
    }

    private BizNumber zrnkiuktrkngaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIUKTRKNGAIKA)
    public BizNumber getZrnkiuktrkngaika() {
        return zrnkiuktrkngaika;
    }

    public void setZrnkiuktrkngaika(BizNumber pZrnkiuktrkngaika) {
        zrnkiuktrkngaika = pZrnkiuktrkngaika;
    }

    private Long zrntmttknyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTMTTKNYEN)
    public Long getZrntmttknyen() {
        return zrntmttknyen;
    }

    public void setZrntmttknyen(Long pZrntmttknyen) {
        zrntmttknyen = pZrntmttknyen;
    }

    private BizNumber zrntmttkngaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTMTTKNGAIKA)
    public BizNumber getZrntmttkngaika() {
        return zrntmttkngaika;
    }

    public void setZrntmttkngaika(BizNumber pZrntmttkngaika) {
        zrntmttkngaika = pZrntmttkngaika;
    }

    private Long zrnkaiyakukjetcyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYAKUKJETCYEN)
    public Long getZrnkaiyakukjetcyen() {
        return zrnkaiyakukjetcyen;
    }

    public void setZrnkaiyakukjetcyen(Long pZrnkaiyakukjetcyen) {
        zrnkaiyakukjetcyen = pZrnkaiyakukjetcyen;
    }

    private BizNumber zrnkaiyakukjetcgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYAKUKJETCGAIKA)
    public BizNumber getZrnkaiyakukjetcgaika() {
        return zrnkaiyakukjetcgaika;
    }

    public void setZrnkaiyakukjetcgaika(BizNumber pZrnkaiyakukjetcgaika) {
        zrnkaiyakukjetcgaika = pZrnkaiyakukjetcgaika;
    }

    private Long zrnwyendrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNWYENDRTENGETUJI)
    public Long getZrnwyendrtengetuji() {
        return zrnwyendrtengetuji;
    }

    public void setZrnwyendrtengetuji(Long pZrnwyendrtengetuji) {
        zrnwyendrtengetuji = pZrnwyendrtengetuji;
    }

    private BizNumber zrnkaiyakuhrkngaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKAIYAKUHRKNGAIKA)
    public BizNumber getZrnkaiyakuhrkngaika() {
        return zrnkaiyakuhrkngaika;
    }

    public void setZrnkaiyakuhrkngaika(BizNumber pZrnkaiyakuhrkngaika) {
        zrnkaiyakuhrkngaika = pZrnkaiyakuhrkngaika;
    }

    private Long zrnsonekiyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSONEKIYEN)
    public Long getZrnsonekiyen() {
        return zrnsonekiyen;
    }

    public void setZrnsonekiyen(Long pZrnsonekiyen) {
        zrnsonekiyen = pZrnsonekiyen;
    }

    private BizNumber zrnsonekigaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSONEKIGAIKA)
    public BizNumber getZrnsonekigaika() {
        return zrnsonekigaika;
    }

    public void setZrnsonekigaika(BizNumber pZrnsonekigaika) {
        zrnsonekigaika = pZrnsonekigaika;
    }

    private Long zrnsbsetcyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSBSETCYEN)
    public Long getZrnsbsetcyen() {
        return zrnsbsetcyen;
    }

    public void setZrnsbsetcyen(Long pZrnsbsetcyen) {
        zrnsbsetcyen = pZrnsbsetcyen;
    }

    private BizNumber zrnsbsetcgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSBSETCGAIKA)
    public BizNumber getZrnsbsetcgaika() {
        return zrnsbsetcgaika;
    }

    public void setZrnsbsetcgaika(BizNumber pZrnsbsetcgaika) {
        zrnsbsetcgaika = pZrnsbsetcgaika;
    }

    private String zrnsonekicalchunouflg;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSONEKICALCHUNOUFLG)
    public String getZrnsonekicalchunouflg() {
        return zrnsonekicalchunouflg;
    }

    public void setZrnsonekicalchunouflg(String pZrnsonekicalchunouflg) {
        zrnsonekicalchunouflg = pZrnsonekicalchunouflg;
    }

    private String zrnhhknnmkjdrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHHKNNMKJDRTENGETUJI)
    public String getZrnhhknnmkjdrtengetuji() {
        return zrnhhknnmkjdrtengetuji;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkjdrtengetuji(String pZrnhhknnmkjdrtengetuji) {
        zrnhhknnmkjdrtengetuji = pZrnhhknnmkjdrtengetuji;
    }

    private String zrntargettktoutatubi;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTARGETTKTOUTATUBI)
    public String getZrntargettktoutatubi() {
        return zrntargettktoutatubi;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntargettktoutatubi(String pZrntargettktoutatubi) {
        zrntargettktoutatubi = pZrntargettktoutatubi;
    }

    private Long zrnmokuhyouti;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMOKUHYOUTI)
    public Long getZrnmokuhyouti() {
        return zrnmokuhyouti;
    }

    public void setZrnmokuhyouti(Long pZrnmokuhyouti) {
        zrnmokuhyouti = pZrnmokuhyouti;
    }

    private Long zrnmokuhyoukngk;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMOKUHYOUKNGK)
    public Long getZrnmokuhyoukngk() {
        return zrnmokuhyoukngk;
    }

    public void setZrnmokuhyoukngk(Long pZrnmokuhyoukngk) {
        zrnmokuhyoukngk = pZrnmokuhyoukngk;
    }

    private Long zrnkihrpruikeigk;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIHRPRUIKEIGK)
    public Long getZrnkihrpruikeigk() {
        return zrnkihrpruikeigk;
    }

    public void setZrnkihrpruikeigk(Long pZrnkihrpruikeigk) {
        zrnkihrpruikeigk = pZrnkihrpruikeigk;
    }

    private BizNumber zrntousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTOUSYOKYKJIKAWASERATE)
    public BizNumber getZrntousyokykjikawaserate() {
        return zrntousyokykjikawaserate;
    }

    public void setZrntousyokykjikawaserate(BizNumber pZrntousyokykjikawaserate) {
        zrntousyokykjikawaserate = pZrntousyokykjikawaserate;
    }

    private String zrnwkeisanerrorhyj;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNWKEISANERRORHYJ)
    public String getZrnwkeisanerrorhyj() {
        return zrnwkeisanerrorhyj;
    }

    public void setZrnwkeisanerrorhyj(String pZrnwkeisanerrorhyj) {
        zrnwkeisanerrorhyj = pZrnwkeisanerrorhyj;
    }

    private BizNumber zrngmeigyoubijikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNGMEIGYOUBIJIKAWASERATE)
    public BizNumber getZrngmeigyoubijikawaserate() {
        return zrngmeigyoubijikawaserate;
    }

    public void setZrngmeigyoubijikawaserate(BizNumber pZrngmeigyoubijikawaserate) {
        zrngmeigyoubijikawaserate = pZrngmeigyoubijikawaserate;
    }

    private Long zrnikueisikin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNIKUEISIKIN)
    public Long getZrnikueisikin() {
        return zrnikueisikin;
    }

    public void setZrnikueisikin(Long pZrnikueisikin) {
        zrnikueisikin = pZrnikueisikin;
    }

    private Long zrngakusiiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNGAKUSIIWAIKN)
    public Long getZrngakusiiwaikn() {
        return zrngakusiiwaikn;
    }

    public void setZrngakusiiwaikn(Long pZrngakusiiwaikn) {
        zrngakusiiwaikn = pZrngakusiiwaikn;
    }

    private Long zrnzoukaseizonssueokikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNZOUKASEIZONSSUEOKIKN)
    public Long getZrnzoukaseizonssueokikn() {
        return zrnzoukaseizonssueokikn;
    }

    public void setZrnzoukaseizonssueokikn(Long pZrnzoukaseizonssueokikn) {
        zrnzoukaseizonssueokikn = pZrnzoukaseizonssueokikn;
    }

    private Long zrnknkuiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKNKUIWAIKN)
    public Long getZrnknkuiwaikn() {
        return zrnknkuiwaikn;
    }

    public void setZrnknkuiwaikn(Long pZrnknkuiwaikn) {
        zrnknkuiwaikn = pZrnknkuiwaikn;
    }

    private Long zrnkijyuiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKIJYUIWAIKN)
    public Long getZrnkijyuiwaikn() {
        return zrnkijyuiwaikn;
    }

    public void setZrnkijyuiwaikn(Long pZrnkijyuiwaikn) {
        zrnkijyuiwaikn = pZrnkijyuiwaikn;
    }

    private Long zrnbeijyuiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNBEIJYUIWAIKN)
    public Long getZrnbeijyuiwaikn() {
        return zrnbeijyuiwaikn;
    }

    public void setZrnbeijyuiwaikn(Long pZrnbeijyuiwaikn) {
        zrnbeijyuiwaikn = pZrnbeijyuiwaikn;
    }

    private Long zrnsznkyhkn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSZNKYHKN)
    public Long getZrnsznkyhkn() {
        return zrnsznkyhkn;
    }

    public void setZrnsznkyhkn(Long pZrnsznkyhkn) {
        zrnsznkyhkn = pZrnsznkyhkn;
    }

    private Long zrnkyktsnatkitkykkyhkn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKYKTSNATKITKYKKYHKN)
    public Long getZrnkyktsnatkitkykkyhkn() {
        return zrnkyktsnatkitkykkyhkn;
    }

    public void setZrnkyktsnatkitkykkyhkn(Long pZrnkyktsnatkitkykkyhkn) {
        zrnkyktsnatkitkykkyhkn = pZrnkyktsnatkitkykkyhkn;
    }

    private Long zrnzoukayourous;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNZOUKAYOUROUS)
    public Long getZrnzoukayourous() {
        return zrnzoukayourous;
    }

    public void setZrnzoukayourous(Long pZrnzoukayourous) {
        zrnzoukayourous = pZrnzoukayourous;
    }

    private Long zrntmtthaitoukin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTMTTHAITOUKIN)
    public Long getZrntmtthaitoukin() {
        return zrntmtthaitoukin;
    }

    public void setZrntmtthaitoukin(Long pZrntmtthaitoukin) {
        zrntmtthaitoukin = pZrntmtthaitoukin;
    }

    private Long zrntkbthaitoukin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNTKBTHAITOUKIN)
    public Long getZrntkbthaitoukin() {
        return zrntkbthaitoukin;
    }

    public void setZrntkbthaitoukin(Long pZrntkbthaitoukin) {
        zrntkbthaitoukin = pZrntkbthaitoukin;
    }

    private Long zrnsonotahaitoukin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSONOTAHAITOUKIN)
    public Long getZrnsonotahaitoukin() {
        return zrnsonotahaitoukin;
    }

    public void setZrnsonotahaitoukin(Long pZrnsonotahaitoukin) {
        zrnsonotahaitoukin = pZrnsonotahaitoukin;
    }

    private Long zrngensentyousyuuzeigaku;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNGENSENTYOUSYUUZEIGAKU)
    public Long getZrngensentyousyuuzeigaku() {
        return zrngensentyousyuuzeigaku;
    }

    public void setZrngensentyousyuuzeigaku(Long pZrngensentyousyuuzeigaku) {
        zrngensentyousyuuzeigaku = pZrngensentyousyuuzeigaku;
    }

    private Long zrnottkekinganrigoukei;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNOTTKEKINGANRIGOUKEI)
    public Long getZrnottkekinganrigoukei() {
        return zrnottkekinganrigoukei;
    }

    public void setZrnottkekinganrigoukei(Long pZrnottkekinganrigoukei) {
        zrnottkekinganrigoukei = pZrnottkekinganrigoukei;
    }

    private Long zrnkstkknganrigoukei;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNKSTKKNGANRIGOUKEI)
    public Long getZrnkstkknganrigoukei() {
        return zrnkstkknganrigoukei;
    }

    public void setZrnkstkknganrigoukei(Long pZrnkstkknganrigoukei) {
        zrnkstkknganrigoukei = pZrnkstkknganrigoukei;
    }

    private Long zrnmikeikamisyuup;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNMIKEIKAMISYUUP)
    public Long getZrnmikeikamisyuup() {
        return zrnmikeikamisyuup;
    }

    public void setZrnmikeikamisyuup(Long pZrnmikeikamisyuup) {
        zrnmikeikamisyuup = pZrnmikeikamisyuup;
    }

    private Long zrnsonotaseisankin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNSONOTASEISANKIN)
    public Long getZrnsonotaseisankin() {
        return zrnsonotaseisankin;
    }

    public void setZrnsonotaseisankin(Long pZrnsonotaseisankin) {
        zrnsonotaseisankin = pZrnsonotaseisankin;
    }

    private BizNumber zrnhuho2sjkkktyouseigkmva;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHUHO2SJKKKTYOUSEIGKMVA)
    public BizNumber getZrnhuho2sjkkktyouseigkmva() {
        return zrnhuho2sjkkktyouseigkmva;
    }

    public void setZrnhuho2sjkkktyouseigkmva(BizNumber pZrnhuho2sjkkktyouseigkmva) {
        zrnhuho2sjkkktyouseigkmva = pZrnhuho2sjkkktyouseigkmva;
    }

    private Long zrnhuho2yendthnkhr;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHUHO2YENDTHNKHR)
    public Long getZrnhuho2yendthnkhr() {
        return zrnhuho2yendthnkhr;
    }

    public void setZrnhuho2yendthnkhr(Long pZrnhuho2yendthnkhr) {
        zrnhuho2yendthnkhr = pZrnhuho2yendthnkhr;
    }

    private BizNumber zrnhuho2sjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHUHO2SJKKKTYOUSEIRIRITU)
    public BizNumber getZrnhuho2sjkkktyouseiriritu() {
        return zrnhuho2sjkkktyouseiriritu;
    }

    public void setZrnhuho2sjkkktyouseiriritu(BizNumber pZrnhuho2sjkkktyouseiriritu) {
        zrnhuho2sjkkktyouseiriritu = pZrnhuho2sjkkktyouseiriritu;
    }

    private BizNumber zrnhuho2kaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNHUHO2KAIYAKUKOUJYORITU)
    public BizNumber getZrnhuho2kaiyakukoujyoritu() {
        return zrnhuho2kaiyakukoujyoritu;
    }

    public void setZrnhuho2kaiyakukoujyoritu(BizNumber pZrnhuho2kaiyakukoujyoritu) {
        zrnhuho2kaiyakukoujyoritu = pZrnhuho2kaiyakukoujyoritu;
    }

    private String zrnyobiv66;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykRn.ZRNYOBIV66)
    public String getZrnyobiv66() {
        return zrnyobiv66;
    }

    public void setZrnyobiv66(String pZrnyobiv66) {
        zrnyobiv66 = pZrnyobiv66;
    }
}