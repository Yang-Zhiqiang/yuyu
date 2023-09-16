package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkTy;
import yuyu.def.db.mapping.GenZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.GenQZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkTy;

/**
 * 代理店月末残高情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenGtmtZndkTy}</td><td colspan="3">代理店月末残高情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatakijyunymd ztydatakijyunymd}</td><td>（中継用）データ基準年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnaisyoumeicd</td><td>（中継用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuuka</td><td>（中継用）通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkndrtengtmtzndk</td><td>（中継用）契約者名（カナ）（代理店月末残高）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkjdrtengtmtzndk</td><td>（中継用）契約者名（漢字）（代理店月末残高）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkjdrtengtmtzndk</td><td>（中継用）被保険者名（漢字）（代理店月末残高）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrp</td><td>（中継用）一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeip2</td><td>（中継用）合計保険料２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennoup</td><td>（中継用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytumitatekngk</td><td>（中継用）積立金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytargettktoutatubi</td><td>（中継用）ターゲット到達日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymokuhyouti</td><td>（中継用）目標値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymokuhyoukngk</td><td>（中継用）目標金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakuhr</td><td>（中継用）解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykihrkmpjytym</td><td>（中継用）既払込保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrpruikeigk</td><td>（中継用）既払保険料累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytousyokykjikawaserate</td><td>（中継用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymankiymd</td><td>（中継用）満期年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykishrkinruikeigk</td><td>（中継用）既支払金累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysjkkktyouseigk</td><td>（中継用）市場価格調整額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakukjgk</td><td>（中継用）解約控除額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysoneki</td><td>（中継用）損益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonekicalchunouflg</td><td>（中継用）損益計算不能フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibous</td><td>（中継用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygmeigyoubijiyenshrrate</td><td>（中継用）月末営業日時円支払レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygmeigyoubijikawaserate</td><td>（中継用）月末営業日時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytousyokykjiyennyknrate</td><td>（中継用）当初契約時円入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytousyokykjigaikanyknrate</td><td>（中継用）当初契約時外貨入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykanyuusyaknrno</td><td>（中継用）加入者管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkstgktuuka</td><td>（中継用）払込相当額通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymokuhyoukngktuuka</td><td>（中継用）目標金額通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysonotaseisankin</td><td>（中継用）その他精算金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyenkansansaiyousign</td><td>（中継用）円換算採用為替サイン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjiyoteitmttriritu</td><td>（中継用）契約時予定利率・積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhukusuutuukaflg</td><td>（中継用）複数通貨フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenkansanhunoflg</td><td>（中継用）円換算不能フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyusyaku20</td><td>（中継用）注釈２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsyaatkioydrtencd</td><td>（中継用）新契約募集時Ａ扱親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsybatkioydrtencd</td><td>（中継用）新契約募集時Ｂ扱親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsyaatkidrtencd</td><td>（中継用）新契約募集時Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsybatkidrtencd</td><td>（中継用）新契約募集時Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsyaatkibosyuucd</td><td>（中継用）新契約募集時Ａ扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeibsybatkibosyuucd</td><td>（中継用）新契約募集時Ｂ扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrpkyktuukagtmtzndk</td><td>（中継用）一時払保険料（契約通貨）（月末残高）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeip2kyktuuka</td><td>（中継用）合計保険料２（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennoupkyktuuka</td><td>（中継用）前納保険料（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytmttkngkkyktuuka</td><td>（中継用）積立金額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakuhrkyktuuka</td><td>（中継用）解約返戻金（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykishrkinruikeigkkyktuuka</td><td>（中継用）既支払金累計額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysjkkktyouseigkkyktuuka</td><td>（中継用）市場価格調整額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakukjgkkyktuuka</td><td>（中継用）解約控除額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonekikyktuuka</td><td>（中継用）損益（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonekicalchunouflgsmbc</td><td>（中継用）損益計算不能フラグ（ＳＭＢＣ用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysonotaseisankinkyktuuka</td><td>（中継用）その他精算金（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytyusyakusmbc</td><td>（中継用）注釈（ＳＭＢＣ用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygmeigyoubijigaikashrrate</td><td>（中継用）月末営業日時外貨支払レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykihrpruikeigkkyktuuka</td><td>（中継用）既払保険料累計額（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeip2smtb</td><td>（中継用）合計保険料２（ＳＭＴＢ用）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonekismtb</td><td>（中継用）損益（ＳＭＴＢ用）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysonekicalchunouflgsmtb</td><td>（中継用）損益計算不能フラグ（ＳＭＴＢ用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x7</td><td>（中継用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x8</td><td>（中継用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x9</td><td>（中継用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x10</td><td>（中継用）予備項目Ｎ１１＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv56</td><td>（中継用）予備項目Ｖ５６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenGtmtZndkTy
 * @see     GenZT_DairitenGtmtZndkTy
 * @see     QZT_DairitenGtmtZndkTy
 * @see     GenQZT_DairitenGtmtZndkTy
 */
public class PKZT_DairitenGtmtZndkTy extends AbstractExDBPrimaryKey<ZT_DairitenGtmtZndkTy, PKZT_DairitenGtmtZndkTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DairitenGtmtZndkTy() {
    }

    public PKZT_DairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono) {
        ztydatakijyunymd = pZtydatakijyunymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_DairitenGtmtZndkTy> getEntityClass() {
        return ZT_DairitenGtmtZndkTy.class;
    }

    private String ztydatakijyunymd;

    public String getZtydatakijyunymd() {
        return ztydatakijyunymd;
    }

    public void setZtydatakijyunymd(String pZtydatakijyunymd) {
        ztydatakijyunymd = pZtydatakijyunymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}