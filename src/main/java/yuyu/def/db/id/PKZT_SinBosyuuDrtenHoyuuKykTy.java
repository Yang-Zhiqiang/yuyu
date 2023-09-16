package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.mapping.GenZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.GenQZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykTy;

/**
 * 代理店月次契約情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinBosyuuDrtenHoyuuKykTy}</td><td colspan="3">代理店月次契約情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnaisyoumeicd</td><td>（中継用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisyoumeidrtengetuji</td><td>（中継用）愛称名（代理店月次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikatakbndrtengetuji</td><td>（中継用）払方区分（代理店月次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyohnbnrikbndrtengetuji</td><td>（中継用）商品分類区分（代理店月次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikaiyakuhrkngatahyj</td><td>（中継用）低解約返戻金型表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsyaatkioydrtencd</td><td>（中継用）新契約募集時Ａ扱親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsybatkioydrtencd</td><td>（中継用）新契約募集時Ｂ扱親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsyaatkidrtencd</td><td>（中継用）新契約募集時Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsybatkidrtencd</td><td>（中継用）新契約募集時Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsyaatkibosyuucd</td><td>（中継用）新契約募集時Ａ扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsybatkibosyuucd</td><td>（中継用）新契約募集時Ｂ扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkknmanryouymd</td><td>（中継用）保険期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetucd</td><td>（中継用）消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd</td><td>（中継用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkpdrtengetuji</td><td>（中継用）払込保険料（代理店月次）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkansanpheijyun</td><td>（中継用）年換算保険料（平準払）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyknkyknm18</td><td>（中継用）カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmdrtengetuji</td><td>（中継用）契約者名（代理店月次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknenkykji</td><td>（中継用）契約者年齢（契約時）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknengenzai</td><td>（中継用）契約者年齢（現在）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseikbn</td><td>（中継用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkpjyuutouym</td><td>（中継用）払込保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmpjytym</td><td>（中継用）既払込保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrkmpmf</td><td>（中継用）既払込保険料（ＭＦ）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykihrkmpruikei</td><td>（中継用）既払込保険料（累計）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyksymtjiw</td><td>（中継用）解約消滅時解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyksymtjikihrkmp</td><td>（中継用）解約消滅時既払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyksymtjiunyousoneki</td><td>（中継用）解約消滅時運用損益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyksymtjiunyousonekirt</td><td>（中継用）解約消滅時運用損益率</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztywkeisanerrkbn</td><td>（中継用）解約返戻金計算エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnknksjihenreikingk</td><td>（中継用）満期年金開始時返戻金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymnknksjikihrkmp</td><td>（中継用）満期年金開始時既払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymnknksjiunyousoneki</td><td>（中継用）満期年金開始時運用損益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymnknksjiunyousonekirt</td><td>（中継用）満期年金開始時運用損益率</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymnknkskeisanerrkbn</td><td>（中継用）満期年金開始計算エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkansanpanp</td><td>（中継用）年換算保険料（ＡＮ保険料）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkansanpkeisanerrkbn</td><td>（中継用）年換算保険料計算エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkpgaika</td><td>（中継用）払込Ｐ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykaiyksymtjiwgaika</td><td>（中継用）解約消滅時解約返戻金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytuuka</td><td>（中継用）通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrpyendrtengetuji</td><td>（中継用）一時払保険料（円）（代理店月次）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitijibrpgaika</td><td>（中継用）一時払保険料（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykiuktrknyen</td><td>（中継用）既受取金（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykiuktrkngaika</td><td>（中継用）既受取金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytmttknyen</td><td>（中継用）積立金（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytmttkngaika</td><td>（中継用）積立金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykaiyakukjetcyen</td><td>（中継用）解約控除等（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakukjetcgaika</td><td>（中継用）解約控除等（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztywyendrtengetuji</td><td>（中継用）解約返戻金（円）（代理店月次）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakuhrkngaika</td><td>（中継用）解約返戻金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysonekiyen</td><td>（中継用）損益（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonekigaika</td><td>（中継用）損益（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysbsetcyen</td><td>（中継用）死亡保険金等（円）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysbsetcgaika</td><td>（中継用）死亡保険金等（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysonekicalchunouflg</td><td>（中継用）損益計算不能フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkjdrtengetuji</td><td>（中継用）被保険者名（漢字）（代理店月次）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytargettktoutatubi</td><td>（中継用）ターゲット到達日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymokuhyouti</td><td>（中継用）目標値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymokuhyoukngk</td><td>（中継用）目標金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykihrpruikeigk</td><td>（中継用）既払保険料累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytousyokykjikawaserate</td><td>（中継用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztywkeisanerrorhyj</td><td>（中継用）解約返戻金計算エラー表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygmeigyoubijikawaserate</td><td>（中継用）月末営業日時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyikueisikin</td><td>（中継用）育英資金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygakusiiwaikn</td><td>（中継用）学資祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukaseizonssueokikn</td><td>（中継用）増加生存Ｓ据置金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyknkuiwaikn</td><td>（中継用）健康祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykijyuiwaikn</td><td>（中継用）喜寿祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybeijyuiwaikn</td><td>（中継用）米寿祝金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysznkyhkn</td><td>（中継用）生存給付金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykyktsnatkitkykkyhkn</td><td>（中継用）契約通算扱特約給付金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzoukayourous</td><td>（中継用）増加養老保険金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytmtthaitoukin</td><td>（中継用）積立配当金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkbthaitoukin</td><td>（中継用）特別配当金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonotahaitoukin</td><td>（中継用）その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygensentyousyuuzeigaku</td><td>（中継用）源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyottkekinganrigoukei</td><td>（中継用）お立替金元利合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykstkknganrigoukei</td><td>（中継用）貸付金元利合計</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymikeikamisyuup</td><td>（中継用）未経過・未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonotaseisankin</td><td>（中継用）その他精算金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhuho2sjkkktyouseigkmva</td><td>（中継用）（普保Ⅱ）市場価格調整額（ＭＶＡ）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhuho2yendthnkhr</td><td>（中継用）（普保Ⅱ）円建変更時返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhuho2sjkkktyouseiriritu</td><td>（中継用）（普保Ⅱ）市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhuho2kaiyakukoujyoritu</td><td>（中継用）（普保Ⅱ）解約控除率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobiv66</td><td>（中継用）予備項目Ｖ６６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinBosyuuDrtenHoyuuKykTy
 * @see     GenZT_SinBosyuuDrtenHoyuuKykTy
 * @see     QZT_SinBosyuuDrtenHoyuuKykTy
 * @see     GenQZT_SinBosyuuDrtenHoyuuKykTy
 */
public class PKZT_SinBosyuuDrtenHoyuuKykTy extends AbstractExDBPrimaryKey<ZT_SinBosyuuDrtenHoyuuKykTy, PKZT_SinBosyuuDrtenHoyuuKykTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SinBosyuuDrtenHoyuuKykTy() {
    }

    public PKZT_SinBosyuuDrtenHoyuuKykTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SinBosyuuDrtenHoyuuKykTy> getEntityClass() {
        return ZT_SinBosyuuDrtenHoyuuKykTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}