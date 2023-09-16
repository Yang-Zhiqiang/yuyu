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
import yuyu.def.db.entity.ZT_DairitenGtmtZndkRn;
import yuyu.def.db.id.PKZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.GenQZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkRn;

/**
 * 代理店月末残高情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DairitenGtmtZndkRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenGtmtZndkRn}</td><td colspan="3">代理店月末残高情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatakijyunymd zrndatakijyunymd}</td><td>（連携用）データ基準年月日</td><td align="center">{@link PKZT_DairitenGtmtZndkRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DairitenGtmtZndkRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeicd zrnmdhnaisyoumeicd}</td><td>（連携用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuuka zrntuuka}</td><td>（連携用）通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkndrtengtmtzndk zrnkyknmkndrtengtmtzndk}</td><td>（連携用）契約者名（カナ）（代理店月末残高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkjdrtengtmtzndk zrnkyknmkjdrtengtmtzndk}</td><td>（連携用）契約者名（漢字）（代理店月末残高）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkjdrtengtmtzndk zrnhhknnmkjdrtengtmtzndk}</td><td>（連携用）被保険者名（漢字）（代理店月末残高）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrp zrnitijibrp}</td><td>（連携用）一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeip2 zrngoukeip2}</td><td>（連携用）合計保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennoup zrnzennoup}</td><td>（連携用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatekngk zrntumitatekngk}</td><td>（連携用）積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntargettktoutatubi zrntargettktoutatubi}</td><td>（連携用）ターゲット到達日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmokuhyouti zrnmokuhyouti}</td><td>（連携用）目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmokuhyoukngk zrnmokuhyoukngk}</td><td>（連携用）目標金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhr zrnkaiyakuhr}</td><td>（連携用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihrkmpjytym zrnkihrkmpjytym}</td><td>（連携用）既払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrpruikeigk zrnkihrpruikeigk}</td><td>（連携用）既払保険料累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntousyokykjikawaserate zrntousyokykjikawaserate}</td><td>（連携用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankiymd zrnmankiymd}</td><td>（連携用）満期年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkishrkinruikeigk zrnkishrkinruikeigk}</td><td>（連携用）既支払金累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsjkkktyouseigk zrnsjkkktyouseigk}</td><td>（連携用）市場価格調整額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukjgk zrnkaiyakukjgk}</td><td>（連携用）解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsoneki zrnsoneki}</td><td>（連携用）損益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonekicalchunouflg zrnsonekicalchunouflg}</td><td>（連携用）損益計算不能フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngmeigyoubijiyenshrrate zrngmeigyoubijiyenshrrate}</td><td>（連携用）月末営業日時円支払レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrngmeigyoubijikawaserate zrngmeigyoubijikawaserate}</td><td>（連携用）月末営業日時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntousyokykjiyennyknrate zrntousyokykjiyennyknrate}</td><td>（連携用）当初契約時円入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntousyokykjigaikanyknrate zrntousyokykjigaikanyknrate}</td><td>（連携用）当初契約時外貨入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkanyuusyaknrno zrnkanyuusyaknrno}</td><td>（連携用）加入者管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkstgktuuka zrnhrkstgktuuka}</td><td>（連携用）払込相当額通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmokuhyoukngktuuka zrnmokuhyoukngktuuka}</td><td>（連携用）目標金額通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotaseisankin zrnsonotaseisankin}</td><td>（連携用）その他精算金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyenkansansaiyousign zrnyenkansansaiyousign}</td><td>（連携用）円換算採用為替サイン</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiyoteitmttriritu zrnkykjiyoteitmttriritu}</td><td>（連携用）契約時予定利率・積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhukusuutuukaflg zrnhukusuutuukaflg}</td><td>（連携用）複数通貨フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkansanhunoflg zrnyenkansanhunoflg}</td><td>（連携用）円換算不能フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyusyaku20 zrntyusyaku20}</td><td>（連携用）注釈２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsyaatkioydrtencd zrnskeibsyaatkioydrtencd}</td><td>（連携用）新契約募集時Ａ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsybatkioydrtencd zrnskeibsybatkioydrtencd}</td><td>（連携用）新契約募集時Ｂ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsyaatkidrtencd zrnskeibsyaatkidrtencd}</td><td>（連携用）新契約募集時Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsybatkidrtencd zrnskeibsybatkidrtencd}</td><td>（連携用）新契約募集時Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsyaatkibosyuucd zrnskeibsyaatkibosyuucd}</td><td>（連携用）新契約募集時Ａ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeibsybatkibosyuucd zrnskeibsybatkibosyuucd}</td><td>（連携用）新契約募集時Ｂ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrpkyktuukagtmtzndk zrnitijibrpkyktuukagtmtzndk}</td><td>（連携用）一時払保険料（契約通貨）（月末残高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeip2kyktuuka zrngoukeip2kyktuuka}</td><td>（連携用）合計保険料２（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennoupkyktuuka zrnzennoupkyktuuka}</td><td>（連携用）前納保険料（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntmttkngkkyktuuka zrntmttkngkkyktuuka}</td><td>（連携用）積立金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrkyktuuka zrnkaiyakuhrkyktuuka}</td><td>（連携用）解約返戻金（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkishrkinruikeigkkyktuuka zrnkishrkinruikeigkkyktuuka}</td><td>（連携用）既支払金累計額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsjkkktyouseigkkyktuuka zrnsjkkktyouseigkkyktuuka}</td><td>（連携用）市場価格調整額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakukjgkkyktuuka zrnkaiyakukjgkkyktuuka}</td><td>（連携用）解約控除額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonekikyktuuka zrnsonekikyktuuka}</td><td>（連携用）損益（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonekicalchunouflgsmbc zrnsonekicalchunouflgsmbc}</td><td>（連携用）損益計算不能フラグ（ＳＭＢＣ用）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotaseisankinkyktuuka zrnsonotaseisankinkyktuuka}</td><td>（連携用）その他精算金（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntyusyakusmbc zrntyusyakusmbc}</td><td>（連携用）注釈（ＳＭＢＣ用）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngmeigyoubijigaikashrrate zrngmeigyoubijigaikashrrate}</td><td>（連携用）月末営業日時外貨支払レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkihrpruikeigkkyktuuka zrnkihrpruikeigkkyktuuka}</td><td>（連携用）既払保険料累計額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeip2smtb zrngoukeip2smtb}</td><td>（連携用）合計保険料２（ＳＭＴＢ用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonekismtb zrnsonekismtb}</td><td>（連携用）損益（ＳＭＴＢ用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsonekicalchunouflgsmtb zrnsonekicalchunouflgsmtb}</td><td>（連携用）損益計算不能フラグ（ＳＭＴＢ用）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x9 zrnyobin11x9}</td><td>（連携用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x10 zrnyobin11x10}</td><td>（連携用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv56 zrnyobiv56}</td><td>（連携用）予備項目Ｖ５６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenGtmtZndkRn
 * @see     PKZT_DairitenGtmtZndkRn
 * @see     QZT_DairitenGtmtZndkRn
 * @see     GenQZT_DairitenGtmtZndkRn
 */
@MappedSuperclass
@Table(name=GenZT_DairitenGtmtZndkRn.TABLE_NAME)
@IdClass(value=PKZT_DairitenGtmtZndkRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DairitenGtmtZndkRn extends AbstractExDBEntityForZDB<ZT_DairitenGtmtZndkRn, PKZT_DairitenGtmtZndkRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DairitenGtmtZndkRn";
    public static final String ZRNDATAKIJYUNYMD         = "zrndatakijyunymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNMDHNAISYOUMEICD       = "zrnmdhnaisyoumeicd";
    public static final String ZRNTUUKA                 = "zrntuuka";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNKYKNMKNDRTENGTMTZNDK  = "zrnkyknmkndrtengtmtzndk";
    public static final String ZRNKYKNMKJDRTENGTMTZNDK  = "zrnkyknmkjdrtengtmtzndk";
    public static final String ZRNHHKNNMKJDRTENGTMTZNDK = "zrnhhknnmkjdrtengtmtzndk";
    public static final String ZRNITIJIBRP              = "zrnitijibrp";
    public static final String ZRNGOUKEIP2              = "zrngoukeip2";
    public static final String ZRNZENNOUP               = "zrnzennoup";
    public static final String ZRNTUMITATEKNGK          = "zrntumitatekngk";
    public static final String ZRNTARGETTKTOUTATUBI     = "zrntargettktoutatubi";
    public static final String ZRNMOKUHYOUTI            = "zrnmokuhyouti";
    public static final String ZRNMOKUHYOUKNGK          = "zrnmokuhyoukngk";
    public static final String ZRNKAIYAKUHR             = "zrnkaiyakuhr";
    public static final String ZRNKIHRKMPJYTYM          = "zrnkihrkmpjytym";
    public static final String ZRNKIHRPRUIKEIGK         = "zrnkihrpruikeigk";
    public static final String ZRNTOUSYOKYKJIKAWASERATE = "zrntousyokykjikawaserate";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNMANKIYMD              = "zrnmankiymd";
    public static final String ZRNKISHRKINRUIKEIGK      = "zrnkishrkinruikeigk";
    public static final String ZRNSJKKKTYOUSEIGK        = "zrnsjkkktyouseigk";
    public static final String ZRNKAIYAKUKJGK           = "zrnkaiyakukjgk";
    public static final String ZRNSONEKI                = "zrnsoneki";
    public static final String ZRNSONEKICALCHUNOUFLG    = "zrnsonekicalchunouflg";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNGMEIGYOUBIJIYENSHRRATE = "zrngmeigyoubijiyenshrrate";
    public static final String ZRNGMEIGYOUBIJIKAWASERATE = "zrngmeigyoubijikawaserate";
    public static final String ZRNTOUSYOKYKJIYENNYKNRATE = "zrntousyokykjiyennyknrate";
    public static final String ZRNTOUSYOKYKJIGAIKANYKNRATE = "zrntousyokykjigaikanyknrate";
    public static final String ZRNKANYUUSYAKNRNO        = "zrnkanyuusyaknrno";
    public static final String ZRNHRKSTGKTUUKA          = "zrnhrkstgktuuka";
    public static final String ZRNMOKUHYOUKNGKTUUKA     = "zrnmokuhyoukngktuuka";
    public static final String ZRNSONOTASEISANKIN       = "zrnsonotaseisankin";
    public static final String ZRNYENKANSANSAIYOUSIGN   = "zrnyenkansansaiyousign";
    public static final String ZRNKYKJIYOTEITMTTRIRITU  = "zrnkykjiyoteitmttriritu";
    public static final String ZRNHUKUSUUTUUKAFLG       = "zrnhukusuutuukaflg";
    public static final String ZRNYENKANSANHUNOFLG      = "zrnyenkansanhunoflg";
    public static final String ZRNTYUSYAKU20            = "zrntyusyaku20";
    public static final String ZRNSKEIBSYAATKIOYDRTENCD = "zrnskeibsyaatkioydrtencd";
    public static final String ZRNSKEIBSYBATKIOYDRTENCD = "zrnskeibsybatkioydrtencd";
    public static final String ZRNSKEIBSYAATKIDRTENCD   = "zrnskeibsyaatkidrtencd";
    public static final String ZRNSKEIBSYBATKIDRTENCD   = "zrnskeibsybatkidrtencd";
    public static final String ZRNSKEIBSYAATKIBOSYUUCD  = "zrnskeibsyaatkibosyuucd";
    public static final String ZRNSKEIBSYBATKIBOSYUUCD  = "zrnskeibsybatkibosyuucd";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNITIJIBRPKYKTUUKAGTMTZNDK = "zrnitijibrpkyktuukagtmtzndk";
    public static final String ZRNGOUKEIP2KYKTUUKA      = "zrngoukeip2kyktuuka";
    public static final String ZRNZENNOUPKYKTUUKA       = "zrnzennoupkyktuuka";
    public static final String ZRNTMTTKNGKKYKTUUKA      = "zrntmttkngkkyktuuka";
    public static final String ZRNKAIYAKUHRKYKTUUKA     = "zrnkaiyakuhrkyktuuka";
    public static final String ZRNKISHRKINRUIKEIGKKYKTUUKA = "zrnkishrkinruikeigkkyktuuka";
    public static final String ZRNSJKKKTYOUSEIGKKYKTUUKA = "zrnsjkkktyouseigkkyktuuka";
    public static final String ZRNKAIYAKUKJGKKYKTUUKA   = "zrnkaiyakukjgkkyktuuka";
    public static final String ZRNSONEKIKYKTUUKA        = "zrnsonekikyktuuka";
    public static final String ZRNSONEKICALCHUNOUFLGSMBC = "zrnsonekicalchunouflgsmbc";
    public static final String ZRNSONOTASEISANKINKYKTUUKA = "zrnsonotaseisankinkyktuuka";
    public static final String ZRNTYUSYAKUSMBC          = "zrntyusyakusmbc";
    public static final String ZRNGMEIGYOUBIJIGAIKASHRRATE = "zrngmeigyoubijigaikashrrate";
    public static final String ZRNKIHRPRUIKEIGKKYKTUUKA = "zrnkihrpruikeigkkyktuuka";
    public static final String ZRNGOUKEIP2SMTB          = "zrngoukeip2smtb";
    public static final String ZRNSONEKISMTB            = "zrnsonekismtb";
    public static final String ZRNSONEKICALCHUNOUFLGSMTB = "zrnsonekicalchunouflgsmtb";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIN11X9             = "zrnyobin11x9";
    public static final String ZRNYOBIN11X10            = "zrnyobin11x10";
    public static final String ZRNYOBIV20               = "zrnyobiv20";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNYOBIV56               = "zrnyobiv56";

    private final PKZT_DairitenGtmtZndkRn primaryKey;

    public GenZT_DairitenGtmtZndkRn() {
        primaryKey = new PKZT_DairitenGtmtZndkRn();
    }

    public GenZT_DairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono) {
        primaryKey = new PKZT_DairitenGtmtZndkRn(pZrndatakijyunymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_DairitenGtmtZndkRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DairitenGtmtZndkRn> getMetaClass() {
        return QZT_DairitenGtmtZndkRn.class;
    }

    @Id
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNDATAKIJYUNYMD)
    public String getZrndatakijyunymd() {
        return getPrimaryKey().getZrndatakijyunymd();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndatakijyunymd(String pZrndatakijyunymd) {
        getPrimaryKey().setZrndatakijyunymd(pZrndatakijyunymd);
    }

    @Id
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnmdhnaisyoumeicd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNMDHNAISYOUMEICD)
    public String getZrnmdhnaisyoumeicd() {
        return zrnmdhnaisyoumeicd;
    }

    public void setZrnmdhnaisyoumeicd(String pZrnmdhnaisyoumeicd) {
        zrnmdhnaisyoumeicd = pZrnmdhnaisyoumeicd;
    }

    private String zrntuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTUUKA)
    public String getZrntuuka() {
        return zrntuuka;
    }

    public void setZrntuuka(String pZrntuuka) {
        zrntuuka = pZrntuuka;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnkyknmkndrtengtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKYKNMKNDRTENGTMTZNDK)
    public String getZrnkyknmkndrtengtmtzndk() {
        return zrnkyknmkndrtengtmtzndk;
    }

    public void setZrnkyknmkndrtengtmtzndk(String pZrnkyknmkndrtengtmtzndk) {
        zrnkyknmkndrtengtmtzndk = pZrnkyknmkndrtengtmtzndk;
    }

    private String zrnkyknmkjdrtengtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKYKNMKJDRTENGTMTZNDK)
    public String getZrnkyknmkjdrtengtmtzndk() {
        return zrnkyknmkjdrtengtmtzndk;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkjdrtengtmtzndk(String pZrnkyknmkjdrtengtmtzndk) {
        zrnkyknmkjdrtengtmtzndk = pZrnkyknmkjdrtengtmtzndk;
    }

    private String zrnhhknnmkjdrtengtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHHKNNMKJDRTENGTMTZNDK)
    public String getZrnhhknnmkjdrtengtmtzndk() {
        return zrnhhknnmkjdrtengtmtzndk;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkjdrtengtmtzndk(String pZrnhhknnmkjdrtengtmtzndk) {
        zrnhhknnmkjdrtengtmtzndk = pZrnhhknnmkjdrtengtmtzndk;
    }

    private Long zrnitijibrp;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNITIJIBRP)
    public Long getZrnitijibrp() {
        return zrnitijibrp;
    }

    public void setZrnitijibrp(Long pZrnitijibrp) {
        zrnitijibrp = pZrnitijibrp;
    }

    private Long zrngoukeip2;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNGOUKEIP2)
    public Long getZrngoukeip2() {
        return zrngoukeip2;
    }

    public void setZrngoukeip2(Long pZrngoukeip2) {
        zrngoukeip2 = pZrngoukeip2;
    }

    private Long zrnzennoup;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNZENNOUP)
    public Long getZrnzennoup() {
        return zrnzennoup;
    }

    public void setZrnzennoup(Long pZrnzennoup) {
        zrnzennoup = pZrnzennoup;
    }

    private Long zrntumitatekngk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTUMITATEKNGK)
    public Long getZrntumitatekngk() {
        return zrntumitatekngk;
    }

    public void setZrntumitatekngk(Long pZrntumitatekngk) {
        zrntumitatekngk = pZrntumitatekngk;
    }

    private String zrntargettktoutatubi;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTARGETTKTOUTATUBI)
    public String getZrntargettktoutatubi() {
        return zrntargettktoutatubi;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntargettktoutatubi(String pZrntargettktoutatubi) {
        zrntargettktoutatubi = pZrntargettktoutatubi;
    }

    private Long zrnmokuhyouti;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNMOKUHYOUTI)
    public Long getZrnmokuhyouti() {
        return zrnmokuhyouti;
    }

    public void setZrnmokuhyouti(Long pZrnmokuhyouti) {
        zrnmokuhyouti = pZrnmokuhyouti;
    }

    private Long zrnmokuhyoukngk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNMOKUHYOUKNGK)
    public Long getZrnmokuhyoukngk() {
        return zrnmokuhyoukngk;
    }

    public void setZrnmokuhyoukngk(Long pZrnmokuhyoukngk) {
        zrnmokuhyoukngk = pZrnmokuhyoukngk;
    }

    private Long zrnkaiyakuhr;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKAIYAKUHR)
    public Long getZrnkaiyakuhr() {
        return zrnkaiyakuhr;
    }

    public void setZrnkaiyakuhr(Long pZrnkaiyakuhr) {
        zrnkaiyakuhr = pZrnkaiyakuhr;
    }

    private String zrnkihrkmpjytym;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKIHRKMPJYTYM)
    public String getZrnkihrkmpjytym() {
        return zrnkihrkmpjytym;
    }

    public void setZrnkihrkmpjytym(String pZrnkihrkmpjytym) {
        zrnkihrkmpjytym = pZrnkihrkmpjytym;
    }

    private Long zrnkihrpruikeigk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKIHRPRUIKEIGK)
    public Long getZrnkihrpruikeigk() {
        return zrnkihrpruikeigk;
    }

    public void setZrnkihrpruikeigk(Long pZrnkihrpruikeigk) {
        zrnkihrpruikeigk = pZrnkihrpruikeigk;
    }

    private BizNumber zrntousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTOUSYOKYKJIKAWASERATE)
    public BizNumber getZrntousyokykjikawaserate() {
        return zrntousyokykjikawaserate;
    }

    public void setZrntousyokykjikawaserate(BizNumber pZrntousyokykjikawaserate) {
        zrntousyokykjikawaserate = pZrntousyokykjikawaserate;
    }

    private String zrnkykymd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnmankiymd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNMANKIYMD)
    public String getZrnmankiymd() {
        return zrnmankiymd;
    }

    public void setZrnmankiymd(String pZrnmankiymd) {
        zrnmankiymd = pZrnmankiymd;
    }

    private Long zrnkishrkinruikeigk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKISHRKINRUIKEIGK)
    public Long getZrnkishrkinruikeigk() {
        return zrnkishrkinruikeigk;
    }

    public void setZrnkishrkinruikeigk(Long pZrnkishrkinruikeigk) {
        zrnkishrkinruikeigk = pZrnkishrkinruikeigk;
    }

    private Long zrnsjkkktyouseigk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSJKKKTYOUSEIGK)
    public Long getZrnsjkkktyouseigk() {
        return zrnsjkkktyouseigk;
    }

    public void setZrnsjkkktyouseigk(Long pZrnsjkkktyouseigk) {
        zrnsjkkktyouseigk = pZrnsjkkktyouseigk;
    }

    private Long zrnkaiyakukjgk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKAIYAKUKJGK)
    public Long getZrnkaiyakukjgk() {
        return zrnkaiyakukjgk;
    }

    public void setZrnkaiyakukjgk(Long pZrnkaiyakukjgk) {
        zrnkaiyakukjgk = pZrnkaiyakukjgk;
    }

    private Long zrnsoneki;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONEKI)
    public Long getZrnsoneki() {
        return zrnsoneki;
    }

    public void setZrnsoneki(Long pZrnsoneki) {
        zrnsoneki = pZrnsoneki;
    }

    private String zrnsonekicalchunouflg;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONEKICALCHUNOUFLG)
    public String getZrnsonekicalchunouflg() {
        return zrnsonekicalchunouflg;
    }

    public void setZrnsonekicalchunouflg(String pZrnsonekicalchunouflg) {
        zrnsonekicalchunouflg = pZrnsonekicalchunouflg;
    }

    private Long zrnsibous;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private BizNumber zrngmeigyoubijiyenshrrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNGMEIGYOUBIJIYENSHRRATE)
    public BizNumber getZrngmeigyoubijiyenshrrate() {
        return zrngmeigyoubijiyenshrrate;
    }

    public void setZrngmeigyoubijiyenshrrate(BizNumber pZrngmeigyoubijiyenshrrate) {
        zrngmeigyoubijiyenshrrate = pZrngmeigyoubijiyenshrrate;
    }

    private BizNumber zrngmeigyoubijikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNGMEIGYOUBIJIKAWASERATE)
    public BizNumber getZrngmeigyoubijikawaserate() {
        return zrngmeigyoubijikawaserate;
    }

    public void setZrngmeigyoubijikawaserate(BizNumber pZrngmeigyoubijikawaserate) {
        zrngmeigyoubijikawaserate = pZrngmeigyoubijikawaserate;
    }

    private BizNumber zrntousyokykjiyennyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTOUSYOKYKJIYENNYKNRATE)
    public BizNumber getZrntousyokykjiyennyknrate() {
        return zrntousyokykjiyennyknrate;
    }

    public void setZrntousyokykjiyennyknrate(BizNumber pZrntousyokykjiyennyknrate) {
        zrntousyokykjiyennyknrate = pZrntousyokykjiyennyknrate;
    }

    private BizNumber zrntousyokykjigaikanyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTOUSYOKYKJIGAIKANYKNRATE)
    public BizNumber getZrntousyokykjigaikanyknrate() {
        return zrntousyokykjigaikanyknrate;
    }

    public void setZrntousyokykjigaikanyknrate(BizNumber pZrntousyokykjigaikanyknrate) {
        zrntousyokykjigaikanyknrate = pZrntousyokykjigaikanyknrate;
    }

    private String zrnkanyuusyaknrno;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKANYUUSYAKNRNO)
    public String getZrnkanyuusyaknrno() {
        return zrnkanyuusyaknrno;
    }

    public void setZrnkanyuusyaknrno(String pZrnkanyuusyaknrno) {
        zrnkanyuusyaknrno = pZrnkanyuusyaknrno;
    }

    private String zrnhrkstgktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHRKSTGKTUUKA)
    public String getZrnhrkstgktuuka() {
        return zrnhrkstgktuuka;
    }

    public void setZrnhrkstgktuuka(String pZrnhrkstgktuuka) {
        zrnhrkstgktuuka = pZrnhrkstgktuuka;
    }

    private String zrnmokuhyoukngktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNMOKUHYOUKNGKTUUKA)
    public String getZrnmokuhyoukngktuuka() {
        return zrnmokuhyoukngktuuka;
    }

    public void setZrnmokuhyoukngktuuka(String pZrnmokuhyoukngktuuka) {
        zrnmokuhyoukngktuuka = pZrnmokuhyoukngktuuka;
    }

    private Long zrnsonotaseisankin;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONOTASEISANKIN)
    public Long getZrnsonotaseisankin() {
        return zrnsonotaseisankin;
    }

    public void setZrnsonotaseisankin(Long pZrnsonotaseisankin) {
        zrnsonotaseisankin = pZrnsonotaseisankin;
    }

    private String zrnyenkansansaiyousign;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYENKANSANSAIYOUSIGN)
    public String getZrnyenkansansaiyousign() {
        return zrnyenkansansaiyousign;
    }

    public void setZrnyenkansansaiyousign(String pZrnyenkansansaiyousign) {
        zrnyenkansansaiyousign = pZrnyenkansansaiyousign;
    }

    private BizNumber zrnkykjiyoteitmttriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKYKJIYOTEITMTTRIRITU)
    public BizNumber getZrnkykjiyoteitmttriritu() {
        return zrnkykjiyoteitmttriritu;
    }

    public void setZrnkykjiyoteitmttriritu(BizNumber pZrnkykjiyoteitmttriritu) {
        zrnkykjiyoteitmttriritu = pZrnkykjiyoteitmttriritu;
    }

    private String zrnhukusuutuukaflg;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHUKUSUUTUUKAFLG)
    public String getZrnhukusuutuukaflg() {
        return zrnhukusuutuukaflg;
    }

    public void setZrnhukusuutuukaflg(String pZrnhukusuutuukaflg) {
        zrnhukusuutuukaflg = pZrnhukusuutuukaflg;
    }

    private String zrnyenkansanhunoflg;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYENKANSANHUNOFLG)
    public String getZrnyenkansanhunoflg() {
        return zrnyenkansanhunoflg;
    }

    public void setZrnyenkansanhunoflg(String pZrnyenkansanhunoflg) {
        zrnyenkansanhunoflg = pZrnyenkansanhunoflg;
    }

    private String zrntyusyaku20;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTYUSYAKU20)
    public String getZrntyusyaku20() {
        return zrntyusyaku20;
    }

    public void setZrntyusyaku20(String pZrntyusyaku20) {
        zrntyusyaku20 = pZrntyusyaku20;
    }

    private String zrnskeibsyaatkioydrtencd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSKEIBSYAATKIOYDRTENCD)
    public String getZrnskeibsyaatkioydrtencd() {
        return zrnskeibsyaatkioydrtencd;
    }

    public void setZrnskeibsyaatkioydrtencd(String pZrnskeibsyaatkioydrtencd) {
        zrnskeibsyaatkioydrtencd = pZrnskeibsyaatkioydrtencd;
    }

    private String zrnskeibsybatkioydrtencd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSKEIBSYBATKIOYDRTENCD)
    public String getZrnskeibsybatkioydrtencd() {
        return zrnskeibsybatkioydrtencd;
    }

    public void setZrnskeibsybatkioydrtencd(String pZrnskeibsybatkioydrtencd) {
        zrnskeibsybatkioydrtencd = pZrnskeibsybatkioydrtencd;
    }

    private String zrnskeibsyaatkidrtencd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSKEIBSYAATKIDRTENCD)
    public String getZrnskeibsyaatkidrtencd() {
        return zrnskeibsyaatkidrtencd;
    }

    public void setZrnskeibsyaatkidrtencd(String pZrnskeibsyaatkidrtencd) {
        zrnskeibsyaatkidrtencd = pZrnskeibsyaatkidrtencd;
    }

    private String zrnskeibsybatkidrtencd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSKEIBSYBATKIDRTENCD)
    public String getZrnskeibsybatkidrtencd() {
        return zrnskeibsybatkidrtencd;
    }

    public void setZrnskeibsybatkidrtencd(String pZrnskeibsybatkidrtencd) {
        zrnskeibsybatkidrtencd = pZrnskeibsybatkidrtencd;
    }

    private String zrnskeibsyaatkibosyuucd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSKEIBSYAATKIBOSYUUCD)
    public String getZrnskeibsyaatkibosyuucd() {
        return zrnskeibsyaatkibosyuucd;
    }

    public void setZrnskeibsyaatkibosyuucd(String pZrnskeibsyaatkibosyuucd) {
        zrnskeibsyaatkibosyuucd = pZrnskeibsyaatkibosyuucd;
    }

    private String zrnskeibsybatkibosyuucd;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSKEIBSYBATKIBOSYUUCD)
    public String getZrnskeibsybatkibosyuucd() {
        return zrnskeibsybatkibosyuucd;
    }

    public void setZrnskeibsybatkibosyuucd(String pZrnskeibsybatkibosyuucd) {
        zrnskeibsybatkibosyuucd = pZrnskeibsybatkibosyuucd;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private Long zrnitijibrpkyktuukagtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNITIJIBRPKYKTUUKAGTMTZNDK)
    public Long getZrnitijibrpkyktuukagtmtzndk() {
        return zrnitijibrpkyktuukagtmtzndk;
    }

    public void setZrnitijibrpkyktuukagtmtzndk(Long pZrnitijibrpkyktuukagtmtzndk) {
        zrnitijibrpkyktuukagtmtzndk = pZrnitijibrpkyktuukagtmtzndk;
    }

    private Long zrngoukeip2kyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNGOUKEIP2KYKTUUKA)
    public Long getZrngoukeip2kyktuuka() {
        return zrngoukeip2kyktuuka;
    }

    public void setZrngoukeip2kyktuuka(Long pZrngoukeip2kyktuuka) {
        zrngoukeip2kyktuuka = pZrngoukeip2kyktuuka;
    }

    private Long zrnzennoupkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNZENNOUPKYKTUUKA)
    public Long getZrnzennoupkyktuuka() {
        return zrnzennoupkyktuuka;
    }

    public void setZrnzennoupkyktuuka(Long pZrnzennoupkyktuuka) {
        zrnzennoupkyktuuka = pZrnzennoupkyktuuka;
    }

    private Long zrntmttkngkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTMTTKNGKKYKTUUKA)
    public Long getZrntmttkngkkyktuuka() {
        return zrntmttkngkkyktuuka;
    }

    public void setZrntmttkngkkyktuuka(Long pZrntmttkngkkyktuuka) {
        zrntmttkngkkyktuuka = pZrntmttkngkkyktuuka;
    }

    private Long zrnkaiyakuhrkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKAIYAKUHRKYKTUUKA)
    public Long getZrnkaiyakuhrkyktuuka() {
        return zrnkaiyakuhrkyktuuka;
    }

    public void setZrnkaiyakuhrkyktuuka(Long pZrnkaiyakuhrkyktuuka) {
        zrnkaiyakuhrkyktuuka = pZrnkaiyakuhrkyktuuka;
    }

    private Long zrnkishrkinruikeigkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKISHRKINRUIKEIGKKYKTUUKA)
    public Long getZrnkishrkinruikeigkkyktuuka() {
        return zrnkishrkinruikeigkkyktuuka;
    }

    public void setZrnkishrkinruikeigkkyktuuka(Long pZrnkishrkinruikeigkkyktuuka) {
        zrnkishrkinruikeigkkyktuuka = pZrnkishrkinruikeigkkyktuuka;
    }

    private Long zrnsjkkktyouseigkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSJKKKTYOUSEIGKKYKTUUKA)
    public Long getZrnsjkkktyouseigkkyktuuka() {
        return zrnsjkkktyouseigkkyktuuka;
    }

    public void setZrnsjkkktyouseigkkyktuuka(Long pZrnsjkkktyouseigkkyktuuka) {
        zrnsjkkktyouseigkkyktuuka = pZrnsjkkktyouseigkkyktuuka;
    }

    private Long zrnkaiyakukjgkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKAIYAKUKJGKKYKTUUKA)
    public Long getZrnkaiyakukjgkkyktuuka() {
        return zrnkaiyakukjgkkyktuuka;
    }

    public void setZrnkaiyakukjgkkyktuuka(Long pZrnkaiyakukjgkkyktuuka) {
        zrnkaiyakukjgkkyktuuka = pZrnkaiyakukjgkkyktuuka;
    }

    private Long zrnsonekikyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONEKIKYKTUUKA)
    public Long getZrnsonekikyktuuka() {
        return zrnsonekikyktuuka;
    }

    public void setZrnsonekikyktuuka(Long pZrnsonekikyktuuka) {
        zrnsonekikyktuuka = pZrnsonekikyktuuka;
    }

    private String zrnsonekicalchunouflgsmbc;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONEKICALCHUNOUFLGSMBC)
    public String getZrnsonekicalchunouflgsmbc() {
        return zrnsonekicalchunouflgsmbc;
    }

    public void setZrnsonekicalchunouflgsmbc(String pZrnsonekicalchunouflgsmbc) {
        zrnsonekicalchunouflgsmbc = pZrnsonekicalchunouflgsmbc;
    }

    private Long zrnsonotaseisankinkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONOTASEISANKINKYKTUUKA)
    public Long getZrnsonotaseisankinkyktuuka() {
        return zrnsonotaseisankinkyktuuka;
    }

    public void setZrnsonotaseisankinkyktuuka(Long pZrnsonotaseisankinkyktuuka) {
        zrnsonotaseisankinkyktuuka = pZrnsonotaseisankinkyktuuka;
    }

    private String zrntyusyakusmbc;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNTYUSYAKUSMBC)
    public String getZrntyusyakusmbc() {
        return zrntyusyakusmbc;
    }

    public void setZrntyusyakusmbc(String pZrntyusyakusmbc) {
        zrntyusyakusmbc = pZrntyusyakusmbc;
    }

    private BizNumber zrngmeigyoubijigaikashrrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNGMEIGYOUBIJIGAIKASHRRATE)
    public BizNumber getZrngmeigyoubijigaikashrrate() {
        return zrngmeigyoubijigaikashrrate;
    }

    public void setZrngmeigyoubijigaikashrrate(BizNumber pZrngmeigyoubijigaikashrrate) {
        zrngmeigyoubijigaikashrrate = pZrngmeigyoubijigaikashrrate;
    }

    private Long zrnkihrpruikeigkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNKIHRPRUIKEIGKKYKTUUKA)
    public Long getZrnkihrpruikeigkkyktuuka() {
        return zrnkihrpruikeigkkyktuuka;
    }

    public void setZrnkihrpruikeigkkyktuuka(Long pZrnkihrpruikeigkkyktuuka) {
        zrnkihrpruikeigkkyktuuka = pZrnkihrpruikeigkkyktuuka;
    }

    private Long zrngoukeip2smtb;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNGOUKEIP2SMTB)
    public Long getZrngoukeip2smtb() {
        return zrngoukeip2smtb;
    }

    public void setZrngoukeip2smtb(Long pZrngoukeip2smtb) {
        zrngoukeip2smtb = pZrngoukeip2smtb;
    }

    private Long zrnsonekismtb;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONEKISMTB)
    public Long getZrnsonekismtb() {
        return zrnsonekismtb;
    }

    public void setZrnsonekismtb(Long pZrnsonekismtb) {
        zrnsonekismtb = pZrnsonekismtb;
    }

    private String zrnsonekicalchunouflgsmtb;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNSONEKICALCHUNOUFLGSMTB)
    public String getZrnsonekicalchunouflgsmtb() {
        return zrnsonekicalchunouflgsmtb;
    }

    public void setZrnsonekicalchunouflgsmtb(String pZrnsonekicalchunouflgsmtb) {
        zrnsonekicalchunouflgsmtb = pZrnsonekicalchunouflgsmtb;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private Long zrnyobin11x9;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X9)
    public Long getZrnyobin11x9() {
        return zrnyobin11x9;
    }

    public void setZrnyobin11x9(Long pZrnyobin11x9) {
        zrnyobin11x9 = pZrnyobin11x9;
    }

    private Long zrnyobin11x10;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIN11X10)
    public Long getZrnyobin11x10() {
        return zrnyobin11x10;
    }

    public void setZrnyobin11x10(Long pZrnyobin11x10) {
        zrnyobin11x10 = pZrnyobin11x10;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnyobiv56;

    @Column(name=GenZT_DairitenGtmtZndkRn.ZRNYOBIV56)
    public String getZrnyobiv56() {
        return zrnyobiv56;
    }

    public void setZrnyobiv56(String pZrnyobiv56) {
        zrnyobiv56 = pZrnyobiv56;
    }
}