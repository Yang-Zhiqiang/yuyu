package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.id.PKZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.GenQZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykTy;

/**
 * 代理店月次契約情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SinBosyuuDrtenHoyuuKykTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinBosyuuDrtenHoyuuKykTy}</td><td colspan="3">代理店月次契約情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SinBosyuuDrtenHoyuuKykTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeicd ztymdhnaisyoumeicd}</td><td>（中継用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisyoumeidrtengetuji ztyaisyoumeidrtengetuji}</td><td>（中継用）愛称名（代理店月次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbndrtengetuji ztyharaikatakbndrtengetuji}</td><td>（中継用）払方区分（代理店月次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyohnbnrikbndrtengetuji ztysyohnbnrikbndrtengetuji}</td><td>（中継用）商品分類区分（代理店月次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikaiyakuhrkngatahyj ztyteikaiyakuhrkngatahyj}</td><td>（中継用）低解約返戻金型表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsyaatkioydrtencd ztyskeibsyaatkioydrtencd}</td><td>（中継用）新契約募集時Ａ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsybatkioydrtencd ztyskeibsybatkioydrtencd}</td><td>（中継用）新契約募集時Ｂ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsyaatkidrtencd ztyskeibsyaatkidrtencd}</td><td>（中継用）新契約募集時Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsybatkidrtencd ztyskeibsybatkidrtencd}</td><td>（中継用）新契約募集時Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsyaatkibosyuucd ztyskeibsyaatkibosyuucd}</td><td>（中継用）新契約募集時Ａ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsybatkibosyuucd ztyskeibsybatkibosyuucd}</td><td>（中継用）新契約募集時Ｂ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkknmanryouymd ztyhknkknmanryouymd}</td><td>（中継用）保険期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd ztysymtymd}</td><td>（中継用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkpdrtengetuji ztyhrkpdrtengetuji}</td><td>（中継用）払込保険料（代理店月次）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkansanpheijyun ztynenkansanpheijyun}</td><td>（中継用）年換算保険料（平準払）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyknkyknm18 ztyknkyknm18}</td><td>（中継用）カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmdrtengetuji ztykyknmdrtengetuji}</td><td>（中継用）契約者名（代理店月次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknenkykji ztykyknenkykji}</td><td>（中継用）契約者年齢（契約時）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknengenzai ztykyknengenzai}</td><td>（中継用）契約者年齢（現在）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkpjyuutouym ztyhrkpjyuutouym}</td><td>（中継用）払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmpjytym ztykihrkmpjytym}</td><td>（中継用）既払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrkmpmf ztykihrkmpmf}</td><td>（中継用）既払込保険料（ＭＦ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihrkmpruikei ztykihrkmpruikei}</td><td>（中継用）既払込保険料（累計）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyksymtjiw ztykaiyksymtjiw}</td><td>（中継用）解約消滅時解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyksymtjikihrkmp ztykaiyksymtjikihrkmp}</td><td>（中継用）解約消滅時既払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyksymtjiunyousoneki ztykaiyksymtjiunyousoneki}</td><td>（中継用）解約消滅時運用損益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyksymtjiunyousonekirt ztykaiyksymtjiunyousonekirt}</td><td>（中継用）解約消滅時運用損益率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywkeisanerrkbn ztywkeisanerrkbn}</td><td>（中継用）解約返戻金計算エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnknksjihenreikingk ztymnknksjihenreikingk}</td><td>（中継用）満期年金開始時返戻金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymnknksjikihrkmp ztymnknksjikihrkmp}</td><td>（中継用）満期年金開始時既払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymnknksjiunyousoneki ztymnknksjiunyousoneki}</td><td>（中継用）満期年金開始時運用損益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymnknksjiunyousonekirt ztymnknksjiunyousonekirt}</td><td>（中継用）満期年金開始時運用損益率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymnknkskeisanerrkbn ztymnknkskeisanerrkbn}</td><td>（中継用）満期年金開始計算エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkansanpanp ztynenkansanpanp}</td><td>（中継用）年換算保険料（ＡＮ保険料）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkansanpkeisanerrkbn ztynenkansanpkeisanerrkbn}</td><td>（中継用）年換算保険料計算エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkpgaika ztyhrkpgaika}</td><td>（中継用）払込Ｐ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykaiyksymtjiwgaika ztykaiyksymtjiwgaika}</td><td>（中継用）解約消滅時解約返戻金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytuuka ztytuuka}</td><td>（中継用）通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrpyendrtengetuji ztyitijibrpyendrtengetuji}</td><td>（中継用）一時払保険料（円）（代理店月次）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitijibrpgaika ztyitijibrpgaika}</td><td>（中継用）一時払保険料（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykiuktrknyen ztykiuktrknyen}</td><td>（中継用）既受取金（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykiuktrkngaika ztykiuktrkngaika}</td><td>（中継用）既受取金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytmttknyen ztytmttknyen}</td><td>（中継用）積立金（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytmttkngaika ztytmttkngaika}</td><td>（中継用）積立金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykaiyakukjetcyen ztykaiyakukjetcyen}</td><td>（中継用）解約控除等（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakukjetcgaika ztykaiyakukjetcgaika}</td><td>（中継用）解約控除等（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtywyendrtengetuji ztywyendrtengetuji}</td><td>（中継用）解約返戻金（円）（代理店月次）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrkngaika ztykaiyakuhrkngaika}</td><td>（中継用）解約返戻金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysonekiyen ztysonekiyen}</td><td>（中継用）損益（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonekigaika ztysonekigaika}</td><td>（中継用）損益（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysbsetcyen ztysbsetcyen}</td><td>（中継用）死亡保険金等（円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysbsetcgaika ztysbsetcgaika}</td><td>（中継用）死亡保険金等（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysonekicalchunouflg ztysonekicalchunouflg}</td><td>（中継用）損益計算不能フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkjdrtengetuji ztyhhknnmkjdrtengetuji}</td><td>（中継用）被保険者名（漢字）（代理店月次）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytargettktoutatubi ztytargettktoutatubi}</td><td>（中継用）ターゲット到達日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymokuhyouti ztymokuhyouti}</td><td>（中継用）目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymokuhyoukngk ztymokuhyoukngk}</td><td>（中継用）目標金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihrpruikeigk ztykihrpruikeigk}</td><td>（中継用）既払保険料累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytousyokykjikawaserate ztytousyokykjikawaserate}</td><td>（中継用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtywkeisanerrorhyj ztywkeisanerrorhyj}</td><td>（中継用）解約返戻金計算エラー表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygmeigyoubijikawaserate ztygmeigyoubijikawaserate}</td><td>（中継用）月末営業日時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyikueisikin ztyikueisikin}</td><td>（中継用）育英資金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygakusiiwaikn ztygakusiiwaikn}</td><td>（中継用）学資祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukaseizonssueokikn ztyzoukaseizonssueokikn}</td><td>（中継用）増加生存Ｓ据置金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyknkuiwaikn ztyknkuiwaikn}</td><td>（中継用）健康祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykijyuiwaikn ztykijyuiwaikn}</td><td>（中継用）喜寿祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybeijyuiwaikn ztybeijyuiwaikn}</td><td>（中継用）米寿祝金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysznkyhkn ztysznkyhkn}</td><td>（中継用）生存給付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykyktsnatkitkykkyhkn ztykyktsnatkitkykkyhkn}</td><td>（中継用）契約通算扱特約給付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzoukayourous ztyzoukayourous}</td><td>（中継用）増加養老保険金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytmtthaitoukin ztytmtthaitoukin}</td><td>（中継用）積立配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkbthaitoukin ztytkbthaitoukin}</td><td>（中継用）特別配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonotahaitoukin ztysonotahaitoukin}</td><td>（中継用）その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygensentyousyuuzeigaku ztygensentyousyuuzeigaku}</td><td>（中継用）源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyottkekinganrigoukei ztyottkekinganrigoukei}</td><td>（中継用）お立替金元利合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykstkknganrigoukei ztykstkknganrigoukei}</td><td>（中継用）貸付金元利合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymikeikamisyuup ztymikeikamisyuup}</td><td>（中継用）未経過・未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonotaseisankin ztysonotaseisankin}</td><td>（中継用）その他精算金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhuho2sjkkktyouseigkmva ztyhuho2sjkkktyouseigkmva}</td><td>（中継用）（普保Ⅱ）市場価格調整額（ＭＶＡ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhuho2yendthnkhr ztyhuho2yendthnkhr}</td><td>（中継用）（普保Ⅱ）円建変更時返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhuho2sjkkktyouseiriritu ztyhuho2sjkkktyouseiriritu}</td><td>（中継用）（普保Ⅱ）市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhuho2kaiyakukoujyoritu ztyhuho2kaiyakukoujyoritu}</td><td>（中継用）（普保Ⅱ）解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv66 ztyyobiv66}</td><td>（中継用）予備項目Ｖ６６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinBosyuuDrtenHoyuuKykTy
 * @see     PKZT_SinBosyuuDrtenHoyuuKykTy
 * @see     QZT_SinBosyuuDrtenHoyuuKykTy
 * @see     GenQZT_SinBosyuuDrtenHoyuuKykTy
 */
@MappedSuperclass
@Table(name=GenZT_SinBosyuuDrtenHoyuuKykTy.TABLE_NAME)
@IdClass(value=PKZT_SinBosyuuDrtenHoyuuKykTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SinBosyuuDrtenHoyuuKykTy extends AbstractExDBEntity<ZT_SinBosyuuDrtenHoyuuKykTy, PKZT_SinBosyuuDrtenHoyuuKykTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinBosyuuDrtenHoyuuKykTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYMDHNAISYOUMEICD       = "ztymdhnaisyoumeicd";
    public static final String ZTYAISYOUMEIDRTENGETUJI  = "ztyaisyoumeidrtengetuji";
    public static final String ZTYHARAIKATAKBNDRTENGETUJI = "ztyharaikatakbndrtengetuji";
    public static final String ZTYSYOHNBNRIKBNDRTENGETUJI = "ztysyohnbnrikbndrtengetuji";
    public static final String ZTYTEIKAIYAKUHRKNGATAHYJ = "ztyteikaiyakuhrkngatahyj";
    public static final String ZTYSKEIBSYAATKIOYDRTENCD = "ztyskeibsyaatkioydrtencd";
    public static final String ZTYSKEIBSYBATKIOYDRTENCD = "ztyskeibsybatkioydrtencd";
    public static final String ZTYSKEIBSYAATKIDRTENCD   = "ztyskeibsyaatkidrtencd";
    public static final String ZTYSKEIBSYBATKIDRTENCD   = "ztyskeibsybatkidrtencd";
    public static final String ZTYSKEIBSYAATKIBOSYUUCD  = "ztyskeibsyaatkibosyuucd";
    public static final String ZTYSKEIBSYBATKIBOSYUUCD  = "ztyskeibsybatkibosyuucd";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNKKNMANRYOUYMD      = "ztyhknkknmanryouymd";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYSYMTYMD               = "ztysymtymd";
    public static final String ZTYHRKPDRTENGETUJI       = "ztyhrkpdrtengetuji";
    public static final String ZTYNENKANSANPHEIJYUN     = "ztynenkansanpheijyun";
    public static final String ZTYKNKYKNM18             = "ztyknkyknm18";
    public static final String ZTYKYKNMDRTENGETUJI      = "ztykyknmdrtengetuji";
    public static final String ZTYKYKNENKYKJI           = "ztykyknenkykji";
    public static final String ZTYKYKNENGENZAI          = "ztykyknengenzai";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYHRKPJYUUTOUYM         = "ztyhrkpjyuutouym";
    public static final String ZTYKIHRKMPJYTYM          = "ztykihrkmpjytym";
    public static final String ZTYKIHRKMPMF             = "ztykihrkmpmf";
    public static final String ZTYKIHRKMPRUIKEI         = "ztykihrkmpruikei";
    public static final String ZTYKAIYKSYMTJIW          = "ztykaiyksymtjiw";
    public static final String ZTYKAIYKSYMTJIKIHRKMP    = "ztykaiyksymtjikihrkmp";
    public static final String ZTYKAIYKSYMTJIUNYOUSONEKI = "ztykaiyksymtjiunyousoneki";
    public static final String ZTYKAIYKSYMTJIUNYOUSONEKIRT = "ztykaiyksymtjiunyousonekirt";
    public static final String ZTYWKEISANERRKBN         = "ztywkeisanerrkbn";
    public static final String ZTYMNKNKSJIHENREIKINGK   = "ztymnknksjihenreikingk";
    public static final String ZTYMNKNKSJIKIHRKMP       = "ztymnknksjikihrkmp";
    public static final String ZTYMNKNKSJIUNYOUSONEKI   = "ztymnknksjiunyousoneki";
    public static final String ZTYMNKNKSJIUNYOUSONEKIRT = "ztymnknksjiunyousonekirt";
    public static final String ZTYMNKNKSKEISANERRKBN    = "ztymnknkskeisanerrkbn";
    public static final String ZTYNENKANSANPANP         = "ztynenkansanpanp";
    public static final String ZTYNENKANSANPKEISANERRKBN = "ztynenkansanpkeisanerrkbn";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYHRKPGAIKA             = "ztyhrkpgaika";
    public static final String ZTYKAIYKSYMTJIWGAIKA     = "ztykaiyksymtjiwgaika";
    public static final String ZTYTUUKA                 = "ztytuuka";
    public static final String ZTYITIJIBRPYENDRTENGETUJI = "ztyitijibrpyendrtengetuji";
    public static final String ZTYITIJIBRPGAIKA         = "ztyitijibrpgaika";
    public static final String ZTYKIUKTRKNYEN           = "ztykiuktrknyen";
    public static final String ZTYKIUKTRKNGAIKA         = "ztykiuktrkngaika";
    public static final String ZTYTMTTKNYEN             = "ztytmttknyen";
    public static final String ZTYTMTTKNGAIKA           = "ztytmttkngaika";
    public static final String ZTYKAIYAKUKJETCYEN       = "ztykaiyakukjetcyen";
    public static final String ZTYKAIYAKUKJETCGAIKA     = "ztykaiyakukjetcgaika";
    public static final String ZTYWYENDRTENGETUJI       = "ztywyendrtengetuji";
    public static final String ZTYKAIYAKUHRKNGAIKA      = "ztykaiyakuhrkngaika";
    public static final String ZTYSONEKIYEN             = "ztysonekiyen";
    public static final String ZTYSONEKIGAIKA           = "ztysonekigaika";
    public static final String ZTYSBSETCYEN             = "ztysbsetcyen";
    public static final String ZTYSBSETCGAIKA           = "ztysbsetcgaika";
    public static final String ZTYSONEKICALCHUNOUFLG    = "ztysonekicalchunouflg";
    public static final String ZTYHHKNNMKJDRTENGETUJI   = "ztyhhknnmkjdrtengetuji";
    public static final String ZTYTARGETTKTOUTATUBI     = "ztytargettktoutatubi";
    public static final String ZTYMOKUHYOUTI            = "ztymokuhyouti";
    public static final String ZTYMOKUHYOUKNGK          = "ztymokuhyoukngk";
    public static final String ZTYKIHRPRUIKEIGK         = "ztykihrpruikeigk";
    public static final String ZTYTOUSYOKYKJIKAWASERATE = "ztytousyokykjikawaserate";
    public static final String ZTYWKEISANERRORHYJ       = "ztywkeisanerrorhyj";
    public static final String ZTYGMEIGYOUBIJIKAWASERATE = "ztygmeigyoubijikawaserate";
    public static final String ZTYIKUEISIKIN            = "ztyikueisikin";
    public static final String ZTYGAKUSIIWAIKN          = "ztygakusiiwaikn";
    public static final String ZTYZOUKASEIZONSSUEOKIKN  = "ztyzoukaseizonssueokikn";
    public static final String ZTYKNKUIWAIKN            = "ztyknkuiwaikn";
    public static final String ZTYKIJYUIWAIKN           = "ztykijyuiwaikn";
    public static final String ZTYBEIJYUIWAIKN          = "ztybeijyuiwaikn";
    public static final String ZTYSZNKYHKN              = "ztysznkyhkn";
    public static final String ZTYKYKTSNATKITKYKKYHKN   = "ztykyktsnatkitkykkyhkn";
    public static final String ZTYZOUKAYOUROUS          = "ztyzoukayourous";
    public static final String ZTYTMTTHAITOUKIN         = "ztytmtthaitoukin";
    public static final String ZTYTKBTHAITOUKIN         = "ztytkbthaitoukin";
    public static final String ZTYSONOTAHAITOUKIN       = "ztysonotahaitoukin";
    public static final String ZTYGENSENTYOUSYUUZEIGAKU = "ztygensentyousyuuzeigaku";
    public static final String ZTYOTTKEKINGANRIGOUKEI   = "ztyottkekinganrigoukei";
    public static final String ZTYKSTKKNGANRIGOUKEI     = "ztykstkknganrigoukei";
    public static final String ZTYMIKEIKAMISYUUP        = "ztymikeikamisyuup";
    public static final String ZTYSONOTASEISANKIN       = "ztysonotaseisankin";
    public static final String ZTYHUHO2SJKKKTYOUSEIGKMVA = "ztyhuho2sjkkktyouseigkmva";
    public static final String ZTYHUHO2YENDTHNKHR       = "ztyhuho2yendthnkhr";
    public static final String ZTYHUHO2SJKKKTYOUSEIRIRITU = "ztyhuho2sjkkktyouseiriritu";
    public static final String ZTYHUHO2KAIYAKUKOUJYORITU = "ztyhuho2kaiyakukoujyoritu";
    public static final String ZTYYOBIV66               = "ztyyobiv66";

    private final PKZT_SinBosyuuDrtenHoyuuKykTy primaryKey;

    public GenZT_SinBosyuuDrtenHoyuuKykTy() {
        primaryKey = new PKZT_SinBosyuuDrtenHoyuuKykTy();
    }

    public GenZT_SinBosyuuDrtenHoyuuKykTy(String pZtysyono) {
        primaryKey = new PKZT_SinBosyuuDrtenHoyuuKykTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SinBosyuuDrtenHoyuuKykTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinBosyuuDrtenHoyuuKykTy> getMetaClass() {
        return QZT_SinBosyuuDrtenHoyuuKykTy.class;
    }

    @Id
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztymdhnaisyoumeicd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMDHNAISYOUMEICD)
    public String getZtymdhnaisyoumeicd() {
        return ztymdhnaisyoumeicd;
    }

    public void setZtymdhnaisyoumeicd(String pZtymdhnaisyoumeicd) {
        ztymdhnaisyoumeicd = pZtymdhnaisyoumeicd;
    }

    private String ztyaisyoumeidrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYAISYOUMEIDRTENGETUJI)
    public String getZtyaisyoumeidrtengetuji() {
        return ztyaisyoumeidrtengetuji;
    }

    public void setZtyaisyoumeidrtengetuji(String pZtyaisyoumeidrtengetuji) {
        ztyaisyoumeidrtengetuji = pZtyaisyoumeidrtengetuji;
    }

    private String ztyharaikatakbndrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHARAIKATAKBNDRTENGETUJI)
    public String getZtyharaikatakbndrtengetuji() {
        return ztyharaikatakbndrtengetuji;
    }

    public void setZtyharaikatakbndrtengetuji(String pZtyharaikatakbndrtengetuji) {
        ztyharaikatakbndrtengetuji = pZtyharaikatakbndrtengetuji;
    }

    private String ztysyohnbnrikbndrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSYOHNBNRIKBNDRTENGETUJI)
    public String getZtysyohnbnrikbndrtengetuji() {
        return ztysyohnbnrikbndrtengetuji;
    }

    public void setZtysyohnbnrikbndrtengetuji(String pZtysyohnbnrikbndrtengetuji) {
        ztysyohnbnrikbndrtengetuji = pZtysyohnbnrikbndrtengetuji;
    }

    private String ztyteikaiyakuhrkngatahyj;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTEIKAIYAKUHRKNGATAHYJ)
    public String getZtyteikaiyakuhrkngatahyj() {
        return ztyteikaiyakuhrkngatahyj;
    }

    public void setZtyteikaiyakuhrkngatahyj(String pZtyteikaiyakuhrkngatahyj) {
        ztyteikaiyakuhrkngatahyj = pZtyteikaiyakuhrkngatahyj;
    }

    private String ztyskeibsyaatkioydrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSKEIBSYAATKIOYDRTENCD)
    public String getZtyskeibsyaatkioydrtencd() {
        return ztyskeibsyaatkioydrtencd;
    }

    public void setZtyskeibsyaatkioydrtencd(String pZtyskeibsyaatkioydrtencd) {
        ztyskeibsyaatkioydrtencd = pZtyskeibsyaatkioydrtencd;
    }

    private String ztyskeibsybatkioydrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSKEIBSYBATKIOYDRTENCD)
    public String getZtyskeibsybatkioydrtencd() {
        return ztyskeibsybatkioydrtencd;
    }

    public void setZtyskeibsybatkioydrtencd(String pZtyskeibsybatkioydrtencd) {
        ztyskeibsybatkioydrtencd = pZtyskeibsybatkioydrtencd;
    }

    private String ztyskeibsyaatkidrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSKEIBSYAATKIDRTENCD)
    public String getZtyskeibsyaatkidrtencd() {
        return ztyskeibsyaatkidrtencd;
    }

    public void setZtyskeibsyaatkidrtencd(String pZtyskeibsyaatkidrtencd) {
        ztyskeibsyaatkidrtencd = pZtyskeibsyaatkidrtencd;
    }

    private String ztyskeibsybatkidrtencd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSKEIBSYBATKIDRTENCD)
    public String getZtyskeibsybatkidrtencd() {
        return ztyskeibsybatkidrtencd;
    }

    public void setZtyskeibsybatkidrtencd(String pZtyskeibsybatkidrtencd) {
        ztyskeibsybatkidrtencd = pZtyskeibsybatkidrtencd;
    }

    private String ztyskeibsyaatkibosyuucd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSKEIBSYAATKIBOSYUUCD)
    public String getZtyskeibsyaatkibosyuucd() {
        return ztyskeibsyaatkibosyuucd;
    }

    public void setZtyskeibsyaatkibosyuucd(String pZtyskeibsyaatkibosyuucd) {
        ztyskeibsyaatkibosyuucd = pZtyskeibsyaatkibosyuucd;
    }

    private String ztyskeibsybatkibosyuucd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSKEIBSYBATKIBOSYUUCD)
    public String getZtyskeibsybatkibosyuucd() {
        return ztyskeibsybatkibosyuucd;
    }

    public void setZtyskeibsybatkibosyuucd(String pZtyskeibsybatkibosyuucd) {
        ztyskeibsybatkibosyuucd = pZtyskeibsybatkibosyuucd;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkknmanryouymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHKNKKNMANRYOUYMD)
    public String getZtyhknkknmanryouymd() {
        return ztyhknkknmanryouymd;
    }

    public void setZtyhknkknmanryouymd(String pZtyhknkknmanryouymd) {
        ztyhknkknmanryouymd = pZtyhknkknmanryouymd;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private String ztysymtymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSYMTYMD)
    public String getZtysymtymd() {
        return ztysymtymd;
    }

    public void setZtysymtymd(String pZtysymtymd) {
        ztysymtymd = pZtysymtymd;
    }

    private Long ztyhrkpdrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHRKPDRTENGETUJI)
    public Long getZtyhrkpdrtengetuji() {
        return ztyhrkpdrtengetuji;
    }

    public void setZtyhrkpdrtengetuji(Long pZtyhrkpdrtengetuji) {
        ztyhrkpdrtengetuji = pZtyhrkpdrtengetuji;
    }

    private Long ztynenkansanpheijyun;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYNENKANSANPHEIJYUN)
    public Long getZtynenkansanpheijyun() {
        return ztynenkansanpheijyun;
    }

    public void setZtynenkansanpheijyun(Long pZtynenkansanpheijyun) {
        ztynenkansanpheijyun = pZtynenkansanpheijyun;
    }

    private String ztyknkyknm18;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKNKYKNM18)
    public String getZtyknkyknm18() {
        return ztyknkyknm18;
    }

    public void setZtyknkyknm18(String pZtyknkyknm18) {
        ztyknkyknm18 = pZtyknkyknm18;
    }

    private String ztykyknmdrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKNMDRTENGETUJI)
    public String getZtykyknmdrtengetuji() {
        return ztykyknmdrtengetuji;
    }

    public void setZtykyknmdrtengetuji(String pZtykyknmdrtengetuji) {
        ztykyknmdrtengetuji = pZtykyknmdrtengetuji;
    }

    private String ztykyknenkykji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKNENKYKJI)
    public String getZtykyknenkykji() {
        return ztykyknenkykji;
    }

    public void setZtykyknenkykji(String pZtykyknenkykji) {
        ztykyknenkykji = pZtykyknenkykji;
    }

    private String ztykyknengenzai;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKNENGENZAI)
    public String getZtykyknengenzai() {
        return ztykyknengenzai;
    }

    public void setZtykyknengenzai(String pZtykyknengenzai) {
        ztykyknengenzai = pZtykyknengenzai;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztyhrkpjyuutouym;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHRKPJYUUTOUYM)
    public String getZtyhrkpjyuutouym() {
        return ztyhrkpjyuutouym;
    }

    public void setZtyhrkpjyuutouym(String pZtyhrkpjyuutouym) {
        ztyhrkpjyuutouym = pZtyhrkpjyuutouym;
    }

    private String ztykihrkmpjytym;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIHRKMPJYTYM)
    public String getZtykihrkmpjytym() {
        return ztykihrkmpjytym;
    }

    public void setZtykihrkmpjytym(String pZtykihrkmpjytym) {
        ztykihrkmpjytym = pZtykihrkmpjytym;
    }

    private Long ztykihrkmpmf;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIHRKMPMF)
    public Long getZtykihrkmpmf() {
        return ztykihrkmpmf;
    }

    public void setZtykihrkmpmf(Long pZtykihrkmpmf) {
        ztykihrkmpmf = pZtykihrkmpmf;
    }

    private Long ztykihrkmpruikei;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIHRKMPRUIKEI)
    public Long getZtykihrkmpruikei() {
        return ztykihrkmpruikei;
    }

    public void setZtykihrkmpruikei(Long pZtykihrkmpruikei) {
        ztykihrkmpruikei = pZtykihrkmpruikei;
    }

    private Long ztykaiyksymtjiw;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYKSYMTJIW)
    public Long getZtykaiyksymtjiw() {
        return ztykaiyksymtjiw;
    }

    public void setZtykaiyksymtjiw(Long pZtykaiyksymtjiw) {
        ztykaiyksymtjiw = pZtykaiyksymtjiw;
    }

    private Long ztykaiyksymtjikihrkmp;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYKSYMTJIKIHRKMP)
    public Long getZtykaiyksymtjikihrkmp() {
        return ztykaiyksymtjikihrkmp;
    }

    public void setZtykaiyksymtjikihrkmp(Long pZtykaiyksymtjikihrkmp) {
        ztykaiyksymtjikihrkmp = pZtykaiyksymtjikihrkmp;
    }

    private Long ztykaiyksymtjiunyousoneki;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYKSYMTJIUNYOUSONEKI)
    public Long getZtykaiyksymtjiunyousoneki() {
        return ztykaiyksymtjiunyousoneki;
    }

    public void setZtykaiyksymtjiunyousoneki(Long pZtykaiyksymtjiunyousoneki) {
        ztykaiyksymtjiunyousoneki = pZtykaiyksymtjiunyousoneki;
    }

    private Long ztykaiyksymtjiunyousonekirt;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYKSYMTJIUNYOUSONEKIRT)
    public Long getZtykaiyksymtjiunyousonekirt() {
        return ztykaiyksymtjiunyousonekirt;
    }

    public void setZtykaiyksymtjiunyousonekirt(Long pZtykaiyksymtjiunyousonekirt) {
        ztykaiyksymtjiunyousonekirt = pZtykaiyksymtjiunyousonekirt;
    }

    private String ztywkeisanerrkbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYWKEISANERRKBN)
    public String getZtywkeisanerrkbn() {
        return ztywkeisanerrkbn;
    }

    public void setZtywkeisanerrkbn(String pZtywkeisanerrkbn) {
        ztywkeisanerrkbn = pZtywkeisanerrkbn;
    }

    private Long ztymnknksjihenreikingk;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMNKNKSJIHENREIKINGK)
    public Long getZtymnknksjihenreikingk() {
        return ztymnknksjihenreikingk;
    }

    public void setZtymnknksjihenreikingk(Long pZtymnknksjihenreikingk) {
        ztymnknksjihenreikingk = pZtymnknksjihenreikingk;
    }

    private Long ztymnknksjikihrkmp;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMNKNKSJIKIHRKMP)
    public Long getZtymnknksjikihrkmp() {
        return ztymnknksjikihrkmp;
    }

    public void setZtymnknksjikihrkmp(Long pZtymnknksjikihrkmp) {
        ztymnknksjikihrkmp = pZtymnknksjikihrkmp;
    }

    private Long ztymnknksjiunyousoneki;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMNKNKSJIUNYOUSONEKI)
    public Long getZtymnknksjiunyousoneki() {
        return ztymnknksjiunyousoneki;
    }

    public void setZtymnknksjiunyousoneki(Long pZtymnknksjiunyousoneki) {
        ztymnknksjiunyousoneki = pZtymnknksjiunyousoneki;
    }

    private Long ztymnknksjiunyousonekirt;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMNKNKSJIUNYOUSONEKIRT)
    public Long getZtymnknksjiunyousonekirt() {
        return ztymnknksjiunyousonekirt;
    }

    public void setZtymnknksjiunyousonekirt(Long pZtymnknksjiunyousonekirt) {
        ztymnknksjiunyousonekirt = pZtymnknksjiunyousonekirt;
    }

    private String ztymnknkskeisanerrkbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMNKNKSKEISANERRKBN)
    public String getZtymnknkskeisanerrkbn() {
        return ztymnknkskeisanerrkbn;
    }

    public void setZtymnknkskeisanerrkbn(String pZtymnknkskeisanerrkbn) {
        ztymnknkskeisanerrkbn = pZtymnknkskeisanerrkbn;
    }

    private Long ztynenkansanpanp;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYNENKANSANPANP)
    public Long getZtynenkansanpanp() {
        return ztynenkansanpanp;
    }

    public void setZtynenkansanpanp(Long pZtynenkansanpanp) {
        ztynenkansanpanp = pZtynenkansanpanp;
    }

    private String ztynenkansanpkeisanerrkbn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYNENKANSANPKEISANERRKBN)
    public String getZtynenkansanpkeisanerrkbn() {
        return ztynenkansanpkeisanerrkbn;
    }

    public void setZtynenkansanpkeisanerrkbn(String pZtynenkansanpkeisanerrkbn) {
        ztynenkansanpkeisanerrkbn = pZtynenkansanpkeisanerrkbn;
    }

    private String ztycifcd;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private BizNumber ztyhrkpgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHRKPGAIKA)
    public BizNumber getZtyhrkpgaika() {
        return ztyhrkpgaika;
    }

    public void setZtyhrkpgaika(BizNumber pZtyhrkpgaika) {
        ztyhrkpgaika = pZtyhrkpgaika;
    }

    private BizNumber ztykaiyksymtjiwgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYKSYMTJIWGAIKA)
    public BizNumber getZtykaiyksymtjiwgaika() {
        return ztykaiyksymtjiwgaika;
    }

    public void setZtykaiyksymtjiwgaika(BizNumber pZtykaiyksymtjiwgaika) {
        ztykaiyksymtjiwgaika = pZtykaiyksymtjiwgaika;
    }

    private String ztytuuka;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTUUKA)
    public String getZtytuuka() {
        return ztytuuka;
    }

    public void setZtytuuka(String pZtytuuka) {
        ztytuuka = pZtytuuka;
    }

    private Long ztyitijibrpyendrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYITIJIBRPYENDRTENGETUJI)
    public Long getZtyitijibrpyendrtengetuji() {
        return ztyitijibrpyendrtengetuji;
    }

    public void setZtyitijibrpyendrtengetuji(Long pZtyitijibrpyendrtengetuji) {
        ztyitijibrpyendrtengetuji = pZtyitijibrpyendrtengetuji;
    }

    private BizNumber ztyitijibrpgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYITIJIBRPGAIKA)
    public BizNumber getZtyitijibrpgaika() {
        return ztyitijibrpgaika;
    }

    public void setZtyitijibrpgaika(BizNumber pZtyitijibrpgaika) {
        ztyitijibrpgaika = pZtyitijibrpgaika;
    }

    private Long ztykiuktrknyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIUKTRKNYEN)
    public Long getZtykiuktrknyen() {
        return ztykiuktrknyen;
    }

    public void setZtykiuktrknyen(Long pZtykiuktrknyen) {
        ztykiuktrknyen = pZtykiuktrknyen;
    }

    private BizNumber ztykiuktrkngaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIUKTRKNGAIKA)
    public BizNumber getZtykiuktrkngaika() {
        return ztykiuktrkngaika;
    }

    public void setZtykiuktrkngaika(BizNumber pZtykiuktrkngaika) {
        ztykiuktrkngaika = pZtykiuktrkngaika;
    }

    private Long ztytmttknyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTMTTKNYEN)
    public Long getZtytmttknyen() {
        return ztytmttknyen;
    }

    public void setZtytmttknyen(Long pZtytmttknyen) {
        ztytmttknyen = pZtytmttknyen;
    }

    private BizNumber ztytmttkngaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTMTTKNGAIKA)
    public BizNumber getZtytmttkngaika() {
        return ztytmttkngaika;
    }

    public void setZtytmttkngaika(BizNumber pZtytmttkngaika) {
        ztytmttkngaika = pZtytmttkngaika;
    }

    private Long ztykaiyakukjetcyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYAKUKJETCYEN)
    public Long getZtykaiyakukjetcyen() {
        return ztykaiyakukjetcyen;
    }

    public void setZtykaiyakukjetcyen(Long pZtykaiyakukjetcyen) {
        ztykaiyakukjetcyen = pZtykaiyakukjetcyen;
    }

    private BizNumber ztykaiyakukjetcgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYAKUKJETCGAIKA)
    public BizNumber getZtykaiyakukjetcgaika() {
        return ztykaiyakukjetcgaika;
    }

    public void setZtykaiyakukjetcgaika(BizNumber pZtykaiyakukjetcgaika) {
        ztykaiyakukjetcgaika = pZtykaiyakukjetcgaika;
    }

    private Long ztywyendrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYWYENDRTENGETUJI)
    public Long getZtywyendrtengetuji() {
        return ztywyendrtengetuji;
    }

    public void setZtywyendrtengetuji(Long pZtywyendrtengetuji) {
        ztywyendrtengetuji = pZtywyendrtengetuji;
    }

    private BizNumber ztykaiyakuhrkngaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKAIYAKUHRKNGAIKA)
    public BizNumber getZtykaiyakuhrkngaika() {
        return ztykaiyakuhrkngaika;
    }

    public void setZtykaiyakuhrkngaika(BizNumber pZtykaiyakuhrkngaika) {
        ztykaiyakuhrkngaika = pZtykaiyakuhrkngaika;
    }

    private Long ztysonekiyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSONEKIYEN)
    public Long getZtysonekiyen() {
        return ztysonekiyen;
    }

    public void setZtysonekiyen(Long pZtysonekiyen) {
        ztysonekiyen = pZtysonekiyen;
    }

    private BizNumber ztysonekigaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSONEKIGAIKA)
    public BizNumber getZtysonekigaika() {
        return ztysonekigaika;
    }

    public void setZtysonekigaika(BizNumber pZtysonekigaika) {
        ztysonekigaika = pZtysonekigaika;
    }

    private Long ztysbsetcyen;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSBSETCYEN)
    public Long getZtysbsetcyen() {
        return ztysbsetcyen;
    }

    public void setZtysbsetcyen(Long pZtysbsetcyen) {
        ztysbsetcyen = pZtysbsetcyen;
    }

    private BizNumber ztysbsetcgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSBSETCGAIKA)
    public BizNumber getZtysbsetcgaika() {
        return ztysbsetcgaika;
    }

    public void setZtysbsetcgaika(BizNumber pZtysbsetcgaika) {
        ztysbsetcgaika = pZtysbsetcgaika;
    }

    private String ztysonekicalchunouflg;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSONEKICALCHUNOUFLG)
    public String getZtysonekicalchunouflg() {
        return ztysonekicalchunouflg;
    }

    public void setZtysonekicalchunouflg(String pZtysonekicalchunouflg) {
        ztysonekicalchunouflg = pZtysonekicalchunouflg;
    }

    private String ztyhhknnmkjdrtengetuji;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHHKNNMKJDRTENGETUJI)
    public String getZtyhhknnmkjdrtengetuji() {
        return ztyhhknnmkjdrtengetuji;
    }

    public void setZtyhhknnmkjdrtengetuji(String pZtyhhknnmkjdrtengetuji) {
        ztyhhknnmkjdrtengetuji = pZtyhhknnmkjdrtengetuji;
    }

    private String ztytargettktoutatubi;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTARGETTKTOUTATUBI)
    public String getZtytargettktoutatubi() {
        return ztytargettktoutatubi;
    }

    public void setZtytargettktoutatubi(String pZtytargettktoutatubi) {
        ztytargettktoutatubi = pZtytargettktoutatubi;
    }

    private Long ztymokuhyouti;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMOKUHYOUTI)
    public Long getZtymokuhyouti() {
        return ztymokuhyouti;
    }

    public void setZtymokuhyouti(Long pZtymokuhyouti) {
        ztymokuhyouti = pZtymokuhyouti;
    }

    private Long ztymokuhyoukngk;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMOKUHYOUKNGK)
    public Long getZtymokuhyoukngk() {
        return ztymokuhyoukngk;
    }

    public void setZtymokuhyoukngk(Long pZtymokuhyoukngk) {
        ztymokuhyoukngk = pZtymokuhyoukngk;
    }

    private Long ztykihrpruikeigk;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIHRPRUIKEIGK)
    public Long getZtykihrpruikeigk() {
        return ztykihrpruikeigk;
    }

    public void setZtykihrpruikeigk(Long pZtykihrpruikeigk) {
        ztykihrpruikeigk = pZtykihrpruikeigk;
    }

    private BizNumber ztytousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTOUSYOKYKJIKAWASERATE)
    public BizNumber getZtytousyokykjikawaserate() {
        return ztytousyokykjikawaserate;
    }

    public void setZtytousyokykjikawaserate(BizNumber pZtytousyokykjikawaserate) {
        ztytousyokykjikawaserate = pZtytousyokykjikawaserate;
    }

    private String ztywkeisanerrorhyj;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYWKEISANERRORHYJ)
    public String getZtywkeisanerrorhyj() {
        return ztywkeisanerrorhyj;
    }

    public void setZtywkeisanerrorhyj(String pZtywkeisanerrorhyj) {
        ztywkeisanerrorhyj = pZtywkeisanerrorhyj;
    }

    private BizNumber ztygmeigyoubijikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYGMEIGYOUBIJIKAWASERATE)
    public BizNumber getZtygmeigyoubijikawaserate() {
        return ztygmeigyoubijikawaserate;
    }

    public void setZtygmeigyoubijikawaserate(BizNumber pZtygmeigyoubijikawaserate) {
        ztygmeigyoubijikawaserate = pZtygmeigyoubijikawaserate;
    }

    private Long ztyikueisikin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYIKUEISIKIN)
    public Long getZtyikueisikin() {
        return ztyikueisikin;
    }

    public void setZtyikueisikin(Long pZtyikueisikin) {
        ztyikueisikin = pZtyikueisikin;
    }

    private Long ztygakusiiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYGAKUSIIWAIKN)
    public Long getZtygakusiiwaikn() {
        return ztygakusiiwaikn;
    }

    public void setZtygakusiiwaikn(Long pZtygakusiiwaikn) {
        ztygakusiiwaikn = pZtygakusiiwaikn;
    }

    private Long ztyzoukaseizonssueokikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYZOUKASEIZONSSUEOKIKN)
    public Long getZtyzoukaseizonssueokikn() {
        return ztyzoukaseizonssueokikn;
    }

    public void setZtyzoukaseizonssueokikn(Long pZtyzoukaseizonssueokikn) {
        ztyzoukaseizonssueokikn = pZtyzoukaseizonssueokikn;
    }

    private Long ztyknkuiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKNKUIWAIKN)
    public Long getZtyknkuiwaikn() {
        return ztyknkuiwaikn;
    }

    public void setZtyknkuiwaikn(Long pZtyknkuiwaikn) {
        ztyknkuiwaikn = pZtyknkuiwaikn;
    }

    private Long ztykijyuiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKIJYUIWAIKN)
    public Long getZtykijyuiwaikn() {
        return ztykijyuiwaikn;
    }

    public void setZtykijyuiwaikn(Long pZtykijyuiwaikn) {
        ztykijyuiwaikn = pZtykijyuiwaikn;
    }

    private Long ztybeijyuiwaikn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYBEIJYUIWAIKN)
    public Long getZtybeijyuiwaikn() {
        return ztybeijyuiwaikn;
    }

    public void setZtybeijyuiwaikn(Long pZtybeijyuiwaikn) {
        ztybeijyuiwaikn = pZtybeijyuiwaikn;
    }

    private Long ztysznkyhkn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSZNKYHKN)
    public Long getZtysznkyhkn() {
        return ztysznkyhkn;
    }

    public void setZtysznkyhkn(Long pZtysznkyhkn) {
        ztysznkyhkn = pZtysznkyhkn;
    }

    private Long ztykyktsnatkitkykkyhkn;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKYKTSNATKITKYKKYHKN)
    public Long getZtykyktsnatkitkykkyhkn() {
        return ztykyktsnatkitkykkyhkn;
    }

    public void setZtykyktsnatkitkykkyhkn(Long pZtykyktsnatkitkykkyhkn) {
        ztykyktsnatkitkykkyhkn = pZtykyktsnatkitkykkyhkn;
    }

    private Long ztyzoukayourous;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYZOUKAYOUROUS)
    public Long getZtyzoukayourous() {
        return ztyzoukayourous;
    }

    public void setZtyzoukayourous(Long pZtyzoukayourous) {
        ztyzoukayourous = pZtyzoukayourous;
    }

    private Long ztytmtthaitoukin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTMTTHAITOUKIN)
    public Long getZtytmtthaitoukin() {
        return ztytmtthaitoukin;
    }

    public void setZtytmtthaitoukin(Long pZtytmtthaitoukin) {
        ztytmtthaitoukin = pZtytmtthaitoukin;
    }

    private Long ztytkbthaitoukin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYTKBTHAITOUKIN)
    public Long getZtytkbthaitoukin() {
        return ztytkbthaitoukin;
    }

    public void setZtytkbthaitoukin(Long pZtytkbthaitoukin) {
        ztytkbthaitoukin = pZtytkbthaitoukin;
    }

    private Long ztysonotahaitoukin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSONOTAHAITOUKIN)
    public Long getZtysonotahaitoukin() {
        return ztysonotahaitoukin;
    }

    public void setZtysonotahaitoukin(Long pZtysonotahaitoukin) {
        ztysonotahaitoukin = pZtysonotahaitoukin;
    }

    private Long ztygensentyousyuuzeigaku;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYGENSENTYOUSYUUZEIGAKU)
    public Long getZtygensentyousyuuzeigaku() {
        return ztygensentyousyuuzeigaku;
    }

    public void setZtygensentyousyuuzeigaku(Long pZtygensentyousyuuzeigaku) {
        ztygensentyousyuuzeigaku = pZtygensentyousyuuzeigaku;
    }

    private Long ztyottkekinganrigoukei;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYOTTKEKINGANRIGOUKEI)
    public Long getZtyottkekinganrigoukei() {
        return ztyottkekinganrigoukei;
    }

    public void setZtyottkekinganrigoukei(Long pZtyottkekinganrigoukei) {
        ztyottkekinganrigoukei = pZtyottkekinganrigoukei;
    }

    private Long ztykstkknganrigoukei;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYKSTKKNGANRIGOUKEI)
    public Long getZtykstkknganrigoukei() {
        return ztykstkknganrigoukei;
    }

    public void setZtykstkknganrigoukei(Long pZtykstkknganrigoukei) {
        ztykstkknganrigoukei = pZtykstkknganrigoukei;
    }

    private Long ztymikeikamisyuup;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYMIKEIKAMISYUUP)
    public Long getZtymikeikamisyuup() {
        return ztymikeikamisyuup;
    }

    public void setZtymikeikamisyuup(Long pZtymikeikamisyuup) {
        ztymikeikamisyuup = pZtymikeikamisyuup;
    }

    private Long ztysonotaseisankin;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYSONOTASEISANKIN)
    public Long getZtysonotaseisankin() {
        return ztysonotaseisankin;
    }

    public void setZtysonotaseisankin(Long pZtysonotaseisankin) {
        ztysonotaseisankin = pZtysonotaseisankin;
    }

    private BizNumber ztyhuho2sjkkktyouseigkmva;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHUHO2SJKKKTYOUSEIGKMVA)
    public BizNumber getZtyhuho2sjkkktyouseigkmva() {
        return ztyhuho2sjkkktyouseigkmva;
    }

    public void setZtyhuho2sjkkktyouseigkmva(BizNumber pZtyhuho2sjkkktyouseigkmva) {
        ztyhuho2sjkkktyouseigkmva = pZtyhuho2sjkkktyouseigkmva;
    }

    private Long ztyhuho2yendthnkhr;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHUHO2YENDTHNKHR)
    public Long getZtyhuho2yendthnkhr() {
        return ztyhuho2yendthnkhr;
    }

    public void setZtyhuho2yendthnkhr(Long pZtyhuho2yendthnkhr) {
        ztyhuho2yendthnkhr = pZtyhuho2yendthnkhr;
    }

    private BizNumber ztyhuho2sjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHUHO2SJKKKTYOUSEIRIRITU)
    public BizNumber getZtyhuho2sjkkktyouseiriritu() {
        return ztyhuho2sjkkktyouseiriritu;
    }

    public void setZtyhuho2sjkkktyouseiriritu(BizNumber pZtyhuho2sjkkktyouseiriritu) {
        ztyhuho2sjkkktyouseiriritu = pZtyhuho2sjkkktyouseiriritu;
    }

    private BizNumber ztyhuho2kaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYHUHO2KAIYAKUKOUJYORITU)
    public BizNumber getZtyhuho2kaiyakukoujyoritu() {
        return ztyhuho2kaiyakukoujyoritu;
    }

    public void setZtyhuho2kaiyakukoujyoritu(BizNumber pZtyhuho2kaiyakukoujyoritu) {
        ztyhuho2kaiyakukoujyoritu = pZtyhuho2kaiyakukoujyoritu;
    }

    private String ztyyobiv66;

    @Column(name=GenZT_SinBosyuuDrtenHoyuuKykTy.ZTYYOBIV66)
    public String getZtyyobiv66() {
        return ztyyobiv66;
    }

    public void setZtyyobiv66(String pZtyyobiv66) {
        ztyyobiv66 = pZtyyobiv66;
    }
}