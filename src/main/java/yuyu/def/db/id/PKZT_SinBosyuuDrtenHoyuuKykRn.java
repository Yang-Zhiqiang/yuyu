package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.mapping.GenZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.GenQZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykRn;

/**
 * 代理店月次契約情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinBosyuuDrtenHoyuuKykRn}</td><td colspan="3">代理店月次契約情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnaisyoumeicd</td><td>（連携用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisyoumeidrtengetuji</td><td>（連携用）愛称名（代理店月次）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnharaikatakbndrtengetuji</td><td>（連携用）払方区分（代理店月次）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyohnbnrikbndrtengetuji</td><td>（連携用）商品分類区分（代理店月次）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikaiyakuhrkngatahyj</td><td>（連携用）低解約返戻金型表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsyaatkioydrtencd</td><td>（連携用）新契約募集時Ａ扱親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsybatkioydrtencd</td><td>（連携用）新契約募集時Ｂ扱親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsyaatkidrtencd</td><td>（連携用）新契約募集時Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsybatkidrtencd</td><td>（連携用）新契約募集時Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsyaatkibosyuucd</td><td>（連携用）新契約募集時Ａ扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsybatkibosyuucd</td><td>（連携用）新契約募集時Ｂ扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkknmanryouymd</td><td>（連携用）保険期間満了日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetucd</td><td>（連携用）消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd</td><td>（連携用）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkpdrtengetuji</td><td>（連携用）払込保険料（代理店月次）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkansanpheijyun</td><td>（連携用）年換算保険料（平準払）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnknkyknm18</td><td>（連携用）カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmdrtengetuji</td><td>（連携用）契約者名（代理店月次）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknenkykji</td><td>（連携用）契約者年齢（契約時）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknengenzai</td><td>（連携用）契約者年齢（現在）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseikbn</td><td>（連携用）契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkpjyuutouym</td><td>（連携用）払込保険料充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmpjytym</td><td>（連携用）既払込保険料充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrkmpmf</td><td>（連携用）既払込保険料（ＭＦ）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkihrkmpruikei</td><td>（連携用）既払込保険料（累計）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyksymtjiw</td><td>（連携用）解約消滅時解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyksymtjikihrkmp</td><td>（連携用）解約消滅時既払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyksymtjiunyousoneki</td><td>（連携用）解約消滅時運用損益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyksymtjiunyousonekirt</td><td>（連携用）解約消滅時運用損益率</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwkeisanerrkbn</td><td>（連携用）解約返戻金計算エラー区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnknksjihenreikingk</td><td>（連携用）満期年金開始時返戻金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmnknksjikihrkmp</td><td>（連携用）満期年金開始時既払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmnknksjiunyousoneki</td><td>（連携用）満期年金開始時運用損益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmnknksjiunyousonekirt</td><td>（連携用）満期年金開始時運用損益率</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmnknkskeisanerrkbn</td><td>（連携用）満期年金開始計算エラー区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkansanpanp</td><td>（連携用）年換算保険料（ＡＮ保険料）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkansanpkeisanerrkbn</td><td>（連携用）年換算保険料計算エラー区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkpgaika</td><td>（連携用）払込Ｐ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkaiyksymtjiwgaika</td><td>（連携用）解約消滅時解約返戻金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntuuka</td><td>（連携用）通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibrpyendrtengetuji</td><td>（連携用）一時払保険料（円）（代理店月次）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitijibrpgaika</td><td>（連携用）一時払保険料（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkiuktrknyen</td><td>（連携用）既受取金（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkiuktrkngaika</td><td>（連携用）既受取金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntmttknyen</td><td>（連携用）積立金（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntmttkngaika</td><td>（連携用）積立金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkaiyakukjetcyen</td><td>（連携用）解約控除等（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakukjetcgaika</td><td>（連携用）解約控除等（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnwyendrtengetuji</td><td>（連携用）解約返戻金（円）（代理店月次）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakuhrkngaika</td><td>（連携用）解約返戻金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsonekiyen</td><td>（連携用）損益（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonekigaika</td><td>（連携用）損益（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsbsetcyen</td><td>（連携用）死亡保険金等（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsbsetcgaika</td><td>（連携用）死亡保険金等（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsonekicalchunouflg</td><td>（連携用）損益計算不能フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkjdrtengetuji</td><td>（連携用）被保険者名（漢字）（代理店月次）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntargettktoutatubi</td><td>（連携用）ターゲット到達日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmokuhyouti</td><td>（連携用）目標値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmokuhyoukngk</td><td>（連携用）目標金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkihrpruikeigk</td><td>（連携用）既払保険料累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntousyokykjikawaserate</td><td>（連携用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnwkeisanerrorhyj</td><td>（連携用）解約返戻金計算エラー表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngmeigyoubijikawaserate</td><td>（連携用）月末営業日時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnikueisikin</td><td>（連携用）育英資金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngakusiiwaikn</td><td>（連携用）学資祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukaseizonssueokikn</td><td>（連携用）増加生存Ｓ据置金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnknkuiwaikn</td><td>（連携用）健康祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkijyuiwaikn</td><td>（連携用）喜寿祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbeijyuiwaikn</td><td>（連携用）米寿祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsznkyhkn</td><td>（連携用）生存給付金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkyktsnatkitkykkyhkn</td><td>（連携用）契約通算扱特約給付金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzoukayourous</td><td>（連携用）増加養老保険金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntmtthaitoukin</td><td>（連携用）積立配当金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntkbthaitoukin</td><td>（連携用）特別配当金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonotahaitoukin</td><td>（連携用）その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngensentyousyuuzeigaku</td><td>（連携用）源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnottkekinganrigoukei</td><td>（連携用）お立替金元利合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkstkknganrigoukei</td><td>（連携用）貸付金元利合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmikeikamisyuup</td><td>（連携用）未経過・未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonotaseisankin</td><td>（連携用）その他精算金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhuho2sjkkktyouseigkmva</td><td>（連携用）（普保Ⅱ）市場価格調整額（ＭＶＡ）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhuho2yendthnkhr</td><td>（連携用）（普保Ⅱ）円建変更時返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhuho2sjkkktyouseiriritu</td><td>（連携用）（普保Ⅱ）市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhuho2kaiyakukoujyoritu</td><td>（連携用）（普保Ⅱ）解約控除率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobiv66</td><td>（連携用）予備項目Ｖ６６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinBosyuuDrtenHoyuuKykRn
 * @see     GenZT_SinBosyuuDrtenHoyuuKykRn
 * @see     QZT_SinBosyuuDrtenHoyuuKykRn
 * @see     GenQZT_SinBosyuuDrtenHoyuuKykRn
 */
public class PKZT_SinBosyuuDrtenHoyuuKykRn extends AbstractExDBPrimaryKey<ZT_SinBosyuuDrtenHoyuuKykRn, PKZT_SinBosyuuDrtenHoyuuKykRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SinBosyuuDrtenHoyuuKykRn() {
    }

    public PKZT_SinBosyuuDrtenHoyuuKykRn(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SinBosyuuDrtenHoyuuKykRn> getEntityClass() {
        return ZT_SinBosyuuDrtenHoyuuKykRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}