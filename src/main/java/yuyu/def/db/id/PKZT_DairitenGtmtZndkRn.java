package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkRn;
import yuyu.def.db.mapping.GenZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.GenQZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkRn;

/**
 * 代理店月末残高情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenGtmtZndkRn}</td><td colspan="3">代理店月末残高情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakijyunymd zrndatakijyunymd}</td><td>（連携用）データ基準年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnaisyoumeicd</td><td>（連携用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuuka</td><td>（連携用）通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkndrtengtmtzndk</td><td>（連携用）契約者名（カナ）（代理店月末残高）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkjdrtengtmtzndk</td><td>（連携用）契約者名（漢字）（代理店月末残高）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkjdrtengtmtzndk</td><td>（連携用）被保険者名（漢字）（代理店月末残高）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnitijibrp</td><td>（連携用）一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeip2</td><td>（連携用）合計保険料２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennoup</td><td>（連携用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntumitatekngk</td><td>（連携用）積立金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntargettktoutatubi</td><td>（連携用）ターゲット到達日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmokuhyouti</td><td>（連携用）目標値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmokuhyoukngk</td><td>（連携用）目標金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakuhr</td><td>（連携用）解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkihrkmpjytym</td><td>（連携用）既払込保険料充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrpruikeigk</td><td>（連携用）既払保険料累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntousyokykjikawaserate</td><td>（連携用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmankiymd</td><td>（連携用）満期年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkishrkinruikeigk</td><td>（連携用）既支払金累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsjkkktyouseigk</td><td>（連携用）市場価格調整額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakukjgk</td><td>（連携用）解約控除額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsoneki</td><td>（連携用）損益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonekicalchunouflg</td><td>（連携用）損益計算不能フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibous</td><td>（連携用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngmeigyoubijiyenshrrate</td><td>（連携用）月末営業日時円支払レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrngmeigyoubijikawaserate</td><td>（連携用）月末営業日時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntousyokykjiyennyknrate</td><td>（連携用）当初契約時円入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntousyokykjigaikanyknrate</td><td>（連携用）当初契約時外貨入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkanyuusyaknrno</td><td>（連携用）加入者管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkstgktuuka</td><td>（連携用）払込相当額通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmokuhyoukngktuuka</td><td>（連携用）目標金額通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsonotaseisankin</td><td>（連携用）その他精算金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyenkansansaiyousign</td><td>（連携用）円換算採用為替サイン</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjiyoteitmttriritu</td><td>（連携用）契約時予定利率・積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhukusuutuukaflg</td><td>（連携用）複数通貨フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenkansanhunoflg</td><td>（連携用）円換算不能フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyusyaku20</td><td>（連携用）注釈２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsyaatkioydrtencd</td><td>（連携用）新契約募集時Ａ扱親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsybatkioydrtencd</td><td>（連携用）新契約募集時Ｂ扱親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsyaatkidrtencd</td><td>（連携用）新契約募集時Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsybatkidrtencd</td><td>（連携用）新契約募集時Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsyaatkibosyuucd</td><td>（連携用）新契約募集時Ａ扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeibsybatkibosyuucd</td><td>（連携用）新契約募集時Ｂ扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibrpkyktuukagtmtzndk</td><td>（連携用）一時払保険料（契約通貨）（月末残高）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeip2kyktuuka</td><td>（連携用）合計保険料２（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennoupkyktuuka</td><td>（連携用）前納保険料（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntmttkngkkyktuuka</td><td>（連携用）積立金額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakuhrkyktuuka</td><td>（連携用）解約返戻金（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkishrkinruikeigkkyktuuka</td><td>（連携用）既支払金累計額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsjkkktyouseigkkyktuuka</td><td>（連携用）市場価格調整額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakukjgkkyktuuka</td><td>（連携用）解約控除額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonekikyktuuka</td><td>（連携用）損益（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonekicalchunouflgsmbc</td><td>（連携用）損益計算不能フラグ（ＳＭＢＣ用）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsonotaseisankinkyktuuka</td><td>（連携用）その他精算金（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntyusyakusmbc</td><td>（連携用）注釈（ＳＭＢＣ用）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngmeigyoubijigaikashrrate</td><td>（連携用）月末営業日時外貨支払レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkihrpruikeigkkyktuuka</td><td>（連携用）既払保険料累計額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeip2smtb</td><td>（連携用）合計保険料２（ＳＭＴＢ用）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonekismtb</td><td>（連携用）損益（ＳＭＴＢ用）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsonekicalchunouflgsmtb</td><td>（連携用）損益計算不能フラグ（ＳＭＴＢ用）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x8</td><td>（連携用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x9</td><td>（連携用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x10</td><td>（連携用）予備項目Ｎ１１＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6</td><td>（連携用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv56</td><td>（連携用）予備項目Ｖ５６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenGtmtZndkRn
 * @see     GenZT_DairitenGtmtZndkRn
 * @see     QZT_DairitenGtmtZndkRn
 * @see     GenQZT_DairitenGtmtZndkRn
 */
public class PKZT_DairitenGtmtZndkRn extends AbstractExDBPrimaryKey<ZT_DairitenGtmtZndkRn, PKZT_DairitenGtmtZndkRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DairitenGtmtZndkRn() {
    }

    public PKZT_DairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono) {
        zrndatakijyunymd = pZrndatakijyunymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_DairitenGtmtZndkRn> getEntityClass() {
        return ZT_DairitenGtmtZndkRn.class;
    }

    private String zrndatakijyunymd;

    public String getZrndatakijyunymd() {
        return zrndatakijyunymd;
    }

    public void setZrndatakijyunymd(String pZrndatakijyunymd) {
        zrndatakijyunymd = pZrndatakijyunymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}