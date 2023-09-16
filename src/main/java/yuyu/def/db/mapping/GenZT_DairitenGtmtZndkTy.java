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
import yuyu.def.db.entity.ZT_DairitenGtmtZndkTy;
import yuyu.def.db.id.PKZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.GenQZT_DairitenGtmtZndkTy;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkTy;

/**
 * 代理店月末残高情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DairitenGtmtZndkTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DairitenGtmtZndkTy}</td><td colspan="3">代理店月末残高情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydatakijyunymd ztydatakijyunymd}</td><td>（中継用）データ基準年月日</td><td align="center">{@link PKZT_DairitenGtmtZndkTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DairitenGtmtZndkTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeicd ztymdhnaisyoumeicd}</td><td>（中継用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuka ztytuuka}</td><td>（中継用）通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkndrtengtmtzndk ztykyknmkndrtengtmtzndk}</td><td>（中継用）契約者名（カナ）（代理店月末残高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkjdrtengtmtzndk ztykyknmkjdrtengtmtzndk}</td><td>（中継用）契約者名（漢字）（代理店月末残高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkjdrtengtmtzndk ztyhhknnmkjdrtengtmtzndk}</td><td>（中継用）被保険者名（漢字）（代理店月末残高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrp ztyitijibrp}</td><td>（中継用）一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeip2 ztygoukeip2}</td><td>（中継用）合計保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennoup ztyzennoup}</td><td>（中継用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatekngk ztytumitatekngk}</td><td>（中継用）積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytargettktoutatubi ztytargettktoutatubi}</td><td>（中継用）ターゲット到達日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymokuhyouti ztymokuhyouti}</td><td>（中継用）目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymokuhyoukngk ztymokuhyoukngk}</td><td>（中継用）目標金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhr ztykaiyakuhr}</td><td>（中継用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihrkmpjytym ztykihrkmpjytym}</td><td>（中継用）既払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrpruikeigk ztykihrpruikeigk}</td><td>（中継用）既払保険料累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytousyokykjikawaserate ztytousyokykjikawaserate}</td><td>（中継用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankiymd ztymankiymd}</td><td>（中継用）満期年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykishrkinruikeigk ztykishrkinruikeigk}</td><td>（中継用）既支払金累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysjkkktyouseigk ztysjkkktyouseigk}</td><td>（中継用）市場価格調整額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakukjgk ztykaiyakukjgk}</td><td>（中継用）解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysoneki ztysoneki}</td><td>（中継用）損益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonekicalchunouflg ztysonekicalchunouflg}</td><td>（中継用）損益計算不能フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygmeigyoubijiyenshrrate ztygmeigyoubijiyenshrrate}</td><td>（中継用）月末営業日時円支払レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygmeigyoubijikawaserate ztygmeigyoubijikawaserate}</td><td>（中継用）月末営業日時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytousyokykjiyennyknrate ztytousyokykjiyennyknrate}</td><td>（中継用）当初契約時円入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytousyokykjigaikanyknrate ztytousyokykjigaikanyknrate}</td><td>（中継用）当初契約時外貨入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykanyuusyaknrno ztykanyuusyaknrno}</td><td>（中継用）加入者管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkstgktuuka ztyhrkstgktuuka}</td><td>（中継用）払込相当額通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymokuhyoukngktuuka ztymokuhyoukngktuuka}</td><td>（中継用）目標金額通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotaseisankin ztysonotaseisankin}</td><td>（中継用）その他精算金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyenkansansaiyousign ztyyenkansansaiyousign}</td><td>（中継用）円換算採用為替サイン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiyoteitmttriritu ztykykjiyoteitmttriritu}</td><td>（中継用）契約時予定利率・積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhukusuutuukaflg ztyhukusuutuukaflg}</td><td>（中継用）複数通貨フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkansanhunoflg ztyyenkansanhunoflg}</td><td>（中継用）円換算不能フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyusyaku20 ztytyusyaku20}</td><td>（中継用）注釈２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsyaatkioydrtencd ztyskeibsyaatkioydrtencd}</td><td>（中継用）新契約募集時Ａ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsybatkioydrtencd ztyskeibsybatkioydrtencd}</td><td>（中継用）新契約募集時Ｂ扱親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsyaatkidrtencd ztyskeibsyaatkidrtencd}</td><td>（中継用）新契約募集時Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsybatkidrtencd ztyskeibsybatkidrtencd}</td><td>（中継用）新契約募集時Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsyaatkibosyuucd ztyskeibsyaatkibosyuucd}</td><td>（中継用）新契約募集時Ａ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeibsybatkibosyuucd ztyskeibsybatkibosyuucd}</td><td>（中継用）新契約募集時Ｂ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrpkyktuukagtmtzndk ztyitijibrpkyktuukagtmtzndk}</td><td>（中継用）一時払保険料（契約通貨）（月末残高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeip2kyktuuka ztygoukeip2kyktuuka}</td><td>（中継用）合計保険料２（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennoupkyktuuka ztyzennoupkyktuuka}</td><td>（中継用）前納保険料（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytmttkngkkyktuuka ztytmttkngkkyktuuka}</td><td>（中継用）積立金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrkyktuuka ztykaiyakuhrkyktuuka}</td><td>（中継用）解約返戻金（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykishrkinruikeigkkyktuuka ztykishrkinruikeigkkyktuuka}</td><td>（中継用）既支払金累計額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysjkkktyouseigkkyktuuka ztysjkkktyouseigkkyktuuka}</td><td>（中継用）市場価格調整額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakukjgkkyktuuka ztykaiyakukjgkkyktuuka}</td><td>（中継用）解約控除額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonekikyktuuka ztysonekikyktuuka}</td><td>（中継用）損益（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonekicalchunouflgsmbc ztysonekicalchunouflgsmbc}</td><td>（中継用）損益計算不能フラグ（ＳＭＢＣ用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotaseisankinkyktuuka ztysonotaseisankinkyktuuka}</td><td>（中継用）その他精算金（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyusyakusmbc ztytyusyakusmbc}</td><td>（中継用）注釈（ＳＭＢＣ用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygmeigyoubijigaikashrrate ztygmeigyoubijigaikashrrate}</td><td>（中継用）月末営業日時外貨支払レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykihrpruikeigkkyktuuka ztykihrpruikeigkkyktuuka}</td><td>（中継用）既払保険料累計額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeip2smtb ztygoukeip2smtb}</td><td>（中継用）合計保険料２（ＳＭＴＢ用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonekismtb ztysonekismtb}</td><td>（中継用）損益（ＳＭＴＢ用）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysonekicalchunouflgsmtb ztysonekicalchunouflgsmtb}</td><td>（中継用）損益計算不能フラグ（ＳＭＴＢ用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x9 ztyyobin11x9}</td><td>（中継用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x10 ztyyobin11x10}</td><td>（中継用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv56 ztyyobiv56}</td><td>（中継用）予備項目Ｖ５６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DairitenGtmtZndkTy
 * @see     PKZT_DairitenGtmtZndkTy
 * @see     QZT_DairitenGtmtZndkTy
 * @see     GenQZT_DairitenGtmtZndkTy
 */
@MappedSuperclass
@Table(name=GenZT_DairitenGtmtZndkTy.TABLE_NAME)
@IdClass(value=PKZT_DairitenGtmtZndkTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DairitenGtmtZndkTy extends AbstractExDBEntity<ZT_DairitenGtmtZndkTy, PKZT_DairitenGtmtZndkTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DairitenGtmtZndkTy";
    public static final String ZTYDATAKIJYUNYMD         = "ztydatakijyunymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYMDHNAISYOUMEICD       = "ztymdhnaisyoumeicd";
    public static final String ZTYTUUKA                 = "ztytuuka";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYKYKNMKNDRTENGTMTZNDK  = "ztykyknmkndrtengtmtzndk";
    public static final String ZTYKYKNMKJDRTENGTMTZNDK  = "ztykyknmkjdrtengtmtzndk";
    public static final String ZTYHHKNNMKJDRTENGTMTZNDK = "ztyhhknnmkjdrtengtmtzndk";
    public static final String ZTYITIJIBRP              = "ztyitijibrp";
    public static final String ZTYGOUKEIP2              = "ztygoukeip2";
    public static final String ZTYZENNOUP               = "ztyzennoup";
    public static final String ZTYTUMITATEKNGK          = "ztytumitatekngk";
    public static final String ZTYTARGETTKTOUTATUBI     = "ztytargettktoutatubi";
    public static final String ZTYMOKUHYOUTI            = "ztymokuhyouti";
    public static final String ZTYMOKUHYOUKNGK          = "ztymokuhyoukngk";
    public static final String ZTYKAIYAKUHR             = "ztykaiyakuhr";
    public static final String ZTYKIHRKMPJYTYM          = "ztykihrkmpjytym";
    public static final String ZTYKIHRPRUIKEIGK         = "ztykihrpruikeigk";
    public static final String ZTYTOUSYOKYKJIKAWASERATE = "ztytousyokykjikawaserate";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYMANKIYMD              = "ztymankiymd";
    public static final String ZTYKISHRKINRUIKEIGK      = "ztykishrkinruikeigk";
    public static final String ZTYSJKKKTYOUSEIGK        = "ztysjkkktyouseigk";
    public static final String ZTYKAIYAKUKJGK           = "ztykaiyakukjgk";
    public static final String ZTYSONEKI                = "ztysoneki";
    public static final String ZTYSONEKICALCHUNOUFLG    = "ztysonekicalchunouflg";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYGMEIGYOUBIJIYENSHRRATE = "ztygmeigyoubijiyenshrrate";
    public static final String ZTYGMEIGYOUBIJIKAWASERATE = "ztygmeigyoubijikawaserate";
    public static final String ZTYTOUSYOKYKJIYENNYKNRATE = "ztytousyokykjiyennyknrate";
    public static final String ZTYTOUSYOKYKJIGAIKANYKNRATE = "ztytousyokykjigaikanyknrate";
    public static final String ZTYKANYUUSYAKNRNO        = "ztykanyuusyaknrno";
    public static final String ZTYHRKSTGKTUUKA          = "ztyhrkstgktuuka";
    public static final String ZTYMOKUHYOUKNGKTUUKA     = "ztymokuhyoukngktuuka";
    public static final String ZTYSONOTASEISANKIN       = "ztysonotaseisankin";
    public static final String ZTYYENKANSANSAIYOUSIGN   = "ztyyenkansansaiyousign";
    public static final String ZTYKYKJIYOTEITMTTRIRITU  = "ztykykjiyoteitmttriritu";
    public static final String ZTYHUKUSUUTUUKAFLG       = "ztyhukusuutuukaflg";
    public static final String ZTYYENKANSANHUNOFLG      = "ztyyenkansanhunoflg";
    public static final String ZTYTYUSYAKU20            = "ztytyusyaku20";
    public static final String ZTYSKEIBSYAATKIOYDRTENCD = "ztyskeibsyaatkioydrtencd";
    public static final String ZTYSKEIBSYBATKIOYDRTENCD = "ztyskeibsybatkioydrtencd";
    public static final String ZTYSKEIBSYAATKIDRTENCD   = "ztyskeibsyaatkidrtencd";
    public static final String ZTYSKEIBSYBATKIDRTENCD   = "ztyskeibsybatkidrtencd";
    public static final String ZTYSKEIBSYAATKIBOSYUUCD  = "ztyskeibsyaatkibosyuucd";
    public static final String ZTYSKEIBSYBATKIBOSYUUCD  = "ztyskeibsybatkibosyuucd";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYITIJIBRPKYKTUUKAGTMTZNDK = "ztyitijibrpkyktuukagtmtzndk";
    public static final String ZTYGOUKEIP2KYKTUUKA      = "ztygoukeip2kyktuuka";
    public static final String ZTYZENNOUPKYKTUUKA       = "ztyzennoupkyktuuka";
    public static final String ZTYTMTTKNGKKYKTUUKA      = "ztytmttkngkkyktuuka";
    public static final String ZTYKAIYAKUHRKYKTUUKA     = "ztykaiyakuhrkyktuuka";
    public static final String ZTYKISHRKINRUIKEIGKKYKTUUKA = "ztykishrkinruikeigkkyktuuka";
    public static final String ZTYSJKKKTYOUSEIGKKYKTUUKA = "ztysjkkktyouseigkkyktuuka";
    public static final String ZTYKAIYAKUKJGKKYKTUUKA   = "ztykaiyakukjgkkyktuuka";
    public static final String ZTYSONEKIKYKTUUKA        = "ztysonekikyktuuka";
    public static final String ZTYSONEKICALCHUNOUFLGSMBC = "ztysonekicalchunouflgsmbc";
    public static final String ZTYSONOTASEISANKINKYKTUUKA = "ztysonotaseisankinkyktuuka";
    public static final String ZTYTYUSYAKUSMBC          = "ztytyusyakusmbc";
    public static final String ZTYGMEIGYOUBIJIGAIKASHRRATE = "ztygmeigyoubijigaikashrrate";
    public static final String ZTYKIHRPRUIKEIGKKYKTUUKA = "ztykihrpruikeigkkyktuuka";
    public static final String ZTYGOUKEIP2SMTB          = "ztygoukeip2smtb";
    public static final String ZTYSONEKISMTB            = "ztysonekismtb";
    public static final String ZTYSONEKICALCHUNOUFLGSMTB = "ztysonekicalchunouflgsmtb";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIN11X9             = "ztyyobin11x9";
    public static final String ZTYYOBIN11X10            = "ztyyobin11x10";
    public static final String ZTYYOBIV20               = "ztyyobiv20";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYYOBIV56               = "ztyyobiv56";

    private final PKZT_DairitenGtmtZndkTy primaryKey;

    public GenZT_DairitenGtmtZndkTy() {
        primaryKey = new PKZT_DairitenGtmtZndkTy();
    }

    public GenZT_DairitenGtmtZndkTy(String pZtydatakijyunymd, String pZtysyono) {
        primaryKey = new PKZT_DairitenGtmtZndkTy(pZtydatakijyunymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_DairitenGtmtZndkTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DairitenGtmtZndkTy> getMetaClass() {
        return QZT_DairitenGtmtZndkTy.class;
    }

    @Id
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYDATAKIJYUNYMD)
    public String getZtydatakijyunymd() {
        return getPrimaryKey().getZtydatakijyunymd();
    }

    public void setZtydatakijyunymd(String pZtydatakijyunymd) {
        getPrimaryKey().setZtydatakijyunymd(pZtydatakijyunymd);
    }

    @Id
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztymdhnaisyoumeicd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYMDHNAISYOUMEICD)
    public String getZtymdhnaisyoumeicd() {
        return ztymdhnaisyoumeicd;
    }

    public void setZtymdhnaisyoumeicd(String pZtymdhnaisyoumeicd) {
        ztymdhnaisyoumeicd = pZtymdhnaisyoumeicd;
    }

    private String ztytuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTUUKA)
    public String getZtytuuka() {
        return ztytuuka;
    }

    public void setZtytuuka(String pZtytuuka) {
        ztytuuka = pZtytuuka;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztykyknmkndrtengtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKYKNMKNDRTENGTMTZNDK)
    public String getZtykyknmkndrtengtmtzndk() {
        return ztykyknmkndrtengtmtzndk;
    }

    public void setZtykyknmkndrtengtmtzndk(String pZtykyknmkndrtengtmtzndk) {
        ztykyknmkndrtengtmtzndk = pZtykyknmkndrtengtmtzndk;
    }

    private String ztykyknmkjdrtengtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKYKNMKJDRTENGTMTZNDK)
    public String getZtykyknmkjdrtengtmtzndk() {
        return ztykyknmkjdrtengtmtzndk;
    }

    public void setZtykyknmkjdrtengtmtzndk(String pZtykyknmkjdrtengtmtzndk) {
        ztykyknmkjdrtengtmtzndk = pZtykyknmkjdrtengtmtzndk;
    }

    private String ztyhhknnmkjdrtengtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHHKNNMKJDRTENGTMTZNDK)
    public String getZtyhhknnmkjdrtengtmtzndk() {
        return ztyhhknnmkjdrtengtmtzndk;
    }

    public void setZtyhhknnmkjdrtengtmtzndk(String pZtyhhknnmkjdrtengtmtzndk) {
        ztyhhknnmkjdrtengtmtzndk = pZtyhhknnmkjdrtengtmtzndk;
    }

    private Long ztyitijibrp;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYITIJIBRP)
    public Long getZtyitijibrp() {
        return ztyitijibrp;
    }

    public void setZtyitijibrp(Long pZtyitijibrp) {
        ztyitijibrp = pZtyitijibrp;
    }

    private Long ztygoukeip2;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYGOUKEIP2)
    public Long getZtygoukeip2() {
        return ztygoukeip2;
    }

    public void setZtygoukeip2(Long pZtygoukeip2) {
        ztygoukeip2 = pZtygoukeip2;
    }

    private Long ztyzennoup;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYZENNOUP)
    public Long getZtyzennoup() {
        return ztyzennoup;
    }

    public void setZtyzennoup(Long pZtyzennoup) {
        ztyzennoup = pZtyzennoup;
    }

    private Long ztytumitatekngk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTUMITATEKNGK)
    public Long getZtytumitatekngk() {
        return ztytumitatekngk;
    }

    public void setZtytumitatekngk(Long pZtytumitatekngk) {
        ztytumitatekngk = pZtytumitatekngk;
    }

    private String ztytargettktoutatubi;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTARGETTKTOUTATUBI)
    public String getZtytargettktoutatubi() {
        return ztytargettktoutatubi;
    }

    public void setZtytargettktoutatubi(String pZtytargettktoutatubi) {
        ztytargettktoutatubi = pZtytargettktoutatubi;
    }

    private Long ztymokuhyouti;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYMOKUHYOUTI)
    public Long getZtymokuhyouti() {
        return ztymokuhyouti;
    }

    public void setZtymokuhyouti(Long pZtymokuhyouti) {
        ztymokuhyouti = pZtymokuhyouti;
    }

    private Long ztymokuhyoukngk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYMOKUHYOUKNGK)
    public Long getZtymokuhyoukngk() {
        return ztymokuhyoukngk;
    }

    public void setZtymokuhyoukngk(Long pZtymokuhyoukngk) {
        ztymokuhyoukngk = pZtymokuhyoukngk;
    }

    private Long ztykaiyakuhr;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKAIYAKUHR)
    public Long getZtykaiyakuhr() {
        return ztykaiyakuhr;
    }

    public void setZtykaiyakuhr(Long pZtykaiyakuhr) {
        ztykaiyakuhr = pZtykaiyakuhr;
    }

    private String ztykihrkmpjytym;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKIHRKMPJYTYM)
    public String getZtykihrkmpjytym() {
        return ztykihrkmpjytym;
    }

    public void setZtykihrkmpjytym(String pZtykihrkmpjytym) {
        ztykihrkmpjytym = pZtykihrkmpjytym;
    }

    private Long ztykihrpruikeigk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKIHRPRUIKEIGK)
    public Long getZtykihrpruikeigk() {
        return ztykihrpruikeigk;
    }

    public void setZtykihrpruikeigk(Long pZtykihrpruikeigk) {
        ztykihrpruikeigk = pZtykihrpruikeigk;
    }

    private BizNumber ztytousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTOUSYOKYKJIKAWASERATE)
    public BizNumber getZtytousyokykjikawaserate() {
        return ztytousyokykjikawaserate;
    }

    public void setZtytousyokykjikawaserate(BizNumber pZtytousyokykjikawaserate) {
        ztytousyokykjikawaserate = pZtytousyokykjikawaserate;
    }

    private String ztykykymd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztymankiymd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYMANKIYMD)
    public String getZtymankiymd() {
        return ztymankiymd;
    }

    public void setZtymankiymd(String pZtymankiymd) {
        ztymankiymd = pZtymankiymd;
    }

    private Long ztykishrkinruikeigk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKISHRKINRUIKEIGK)
    public Long getZtykishrkinruikeigk() {
        return ztykishrkinruikeigk;
    }

    public void setZtykishrkinruikeigk(Long pZtykishrkinruikeigk) {
        ztykishrkinruikeigk = pZtykishrkinruikeigk;
    }

    private Long ztysjkkktyouseigk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSJKKKTYOUSEIGK)
    public Long getZtysjkkktyouseigk() {
        return ztysjkkktyouseigk;
    }

    public void setZtysjkkktyouseigk(Long pZtysjkkktyouseigk) {
        ztysjkkktyouseigk = pZtysjkkktyouseigk;
    }

    private Long ztykaiyakukjgk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKAIYAKUKJGK)
    public Long getZtykaiyakukjgk() {
        return ztykaiyakukjgk;
    }

    public void setZtykaiyakukjgk(Long pZtykaiyakukjgk) {
        ztykaiyakukjgk = pZtykaiyakukjgk;
    }

    private Long ztysoneki;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONEKI)
    public Long getZtysoneki() {
        return ztysoneki;
    }

    public void setZtysoneki(Long pZtysoneki) {
        ztysoneki = pZtysoneki;
    }

    private String ztysonekicalchunouflg;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONEKICALCHUNOUFLG)
    public String getZtysonekicalchunouflg() {
        return ztysonekicalchunouflg;
    }

    public void setZtysonekicalchunouflg(String pZtysonekicalchunouflg) {
        ztysonekicalchunouflg = pZtysonekicalchunouflg;
    }

    private Long ztysibous;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private BizNumber ztygmeigyoubijiyenshrrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYGMEIGYOUBIJIYENSHRRATE)
    public BizNumber getZtygmeigyoubijiyenshrrate() {
        return ztygmeigyoubijiyenshrrate;
    }

    public void setZtygmeigyoubijiyenshrrate(BizNumber pZtygmeigyoubijiyenshrrate) {
        ztygmeigyoubijiyenshrrate = pZtygmeigyoubijiyenshrrate;
    }

    private BizNumber ztygmeigyoubijikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYGMEIGYOUBIJIKAWASERATE)
    public BizNumber getZtygmeigyoubijikawaserate() {
        return ztygmeigyoubijikawaserate;
    }

    public void setZtygmeigyoubijikawaserate(BizNumber pZtygmeigyoubijikawaserate) {
        ztygmeigyoubijikawaserate = pZtygmeigyoubijikawaserate;
    }

    private BizNumber ztytousyokykjiyennyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTOUSYOKYKJIYENNYKNRATE)
    public BizNumber getZtytousyokykjiyennyknrate() {
        return ztytousyokykjiyennyknrate;
    }

    public void setZtytousyokykjiyennyknrate(BizNumber pZtytousyokykjiyennyknrate) {
        ztytousyokykjiyennyknrate = pZtytousyokykjiyennyknrate;
    }

    private BizNumber ztytousyokykjigaikanyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTOUSYOKYKJIGAIKANYKNRATE)
    public BizNumber getZtytousyokykjigaikanyknrate() {
        return ztytousyokykjigaikanyknrate;
    }

    public void setZtytousyokykjigaikanyknrate(BizNumber pZtytousyokykjigaikanyknrate) {
        ztytousyokykjigaikanyknrate = pZtytousyokykjigaikanyknrate;
    }

    private String ztykanyuusyaknrno;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKANYUUSYAKNRNO)
    public String getZtykanyuusyaknrno() {
        return ztykanyuusyaknrno;
    }

    public void setZtykanyuusyaknrno(String pZtykanyuusyaknrno) {
        ztykanyuusyaknrno = pZtykanyuusyaknrno;
    }

    private String ztyhrkstgktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHRKSTGKTUUKA)
    public String getZtyhrkstgktuuka() {
        return ztyhrkstgktuuka;
    }

    public void setZtyhrkstgktuuka(String pZtyhrkstgktuuka) {
        ztyhrkstgktuuka = pZtyhrkstgktuuka;
    }

    private String ztymokuhyoukngktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYMOKUHYOUKNGKTUUKA)
    public String getZtymokuhyoukngktuuka() {
        return ztymokuhyoukngktuuka;
    }

    public void setZtymokuhyoukngktuuka(String pZtymokuhyoukngktuuka) {
        ztymokuhyoukngktuuka = pZtymokuhyoukngktuuka;
    }

    private Long ztysonotaseisankin;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONOTASEISANKIN)
    public Long getZtysonotaseisankin() {
        return ztysonotaseisankin;
    }

    public void setZtysonotaseisankin(Long pZtysonotaseisankin) {
        ztysonotaseisankin = pZtysonotaseisankin;
    }

    private String ztyyenkansansaiyousign;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYENKANSANSAIYOUSIGN)
    public String getZtyyenkansansaiyousign() {
        return ztyyenkansansaiyousign;
    }

    public void setZtyyenkansansaiyousign(String pZtyyenkansansaiyousign) {
        ztyyenkansansaiyousign = pZtyyenkansansaiyousign;
    }

    private BizNumber ztykykjiyoteitmttriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKYKJIYOTEITMTTRIRITU)
    public BizNumber getZtykykjiyoteitmttriritu() {
        return ztykykjiyoteitmttriritu;
    }

    public void setZtykykjiyoteitmttriritu(BizNumber pZtykykjiyoteitmttriritu) {
        ztykykjiyoteitmttriritu = pZtykykjiyoteitmttriritu;
    }

    private String ztyhukusuutuukaflg;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHUKUSUUTUUKAFLG)
    public String getZtyhukusuutuukaflg() {
        return ztyhukusuutuukaflg;
    }

    public void setZtyhukusuutuukaflg(String pZtyhukusuutuukaflg) {
        ztyhukusuutuukaflg = pZtyhukusuutuukaflg;
    }

    private String ztyyenkansanhunoflg;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYENKANSANHUNOFLG)
    public String getZtyyenkansanhunoflg() {
        return ztyyenkansanhunoflg;
    }

    public void setZtyyenkansanhunoflg(String pZtyyenkansanhunoflg) {
        ztyyenkansanhunoflg = pZtyyenkansanhunoflg;
    }

    private String ztytyusyaku20;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTYUSYAKU20)
    public String getZtytyusyaku20() {
        return ztytyusyaku20;
    }

    public void setZtytyusyaku20(String pZtytyusyaku20) {
        ztytyusyaku20 = pZtytyusyaku20;
    }

    private String ztyskeibsyaatkioydrtencd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSKEIBSYAATKIOYDRTENCD)
    public String getZtyskeibsyaatkioydrtencd() {
        return ztyskeibsyaatkioydrtencd;
    }

    public void setZtyskeibsyaatkioydrtencd(String pZtyskeibsyaatkioydrtencd) {
        ztyskeibsyaatkioydrtencd = pZtyskeibsyaatkioydrtencd;
    }

    private String ztyskeibsybatkioydrtencd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSKEIBSYBATKIOYDRTENCD)
    public String getZtyskeibsybatkioydrtencd() {
        return ztyskeibsybatkioydrtencd;
    }

    public void setZtyskeibsybatkioydrtencd(String pZtyskeibsybatkioydrtencd) {
        ztyskeibsybatkioydrtencd = pZtyskeibsybatkioydrtencd;
    }

    private String ztyskeibsyaatkidrtencd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSKEIBSYAATKIDRTENCD)
    public String getZtyskeibsyaatkidrtencd() {
        return ztyskeibsyaatkidrtencd;
    }

    public void setZtyskeibsyaatkidrtencd(String pZtyskeibsyaatkidrtencd) {
        ztyskeibsyaatkidrtencd = pZtyskeibsyaatkidrtencd;
    }

    private String ztyskeibsybatkidrtencd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSKEIBSYBATKIDRTENCD)
    public String getZtyskeibsybatkidrtencd() {
        return ztyskeibsybatkidrtencd;
    }

    public void setZtyskeibsybatkidrtencd(String pZtyskeibsybatkidrtencd) {
        ztyskeibsybatkidrtencd = pZtyskeibsybatkidrtencd;
    }

    private String ztyskeibsyaatkibosyuucd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSKEIBSYAATKIBOSYUUCD)
    public String getZtyskeibsyaatkibosyuucd() {
        return ztyskeibsyaatkibosyuucd;
    }

    public void setZtyskeibsyaatkibosyuucd(String pZtyskeibsyaatkibosyuucd) {
        ztyskeibsyaatkibosyuucd = pZtyskeibsyaatkibosyuucd;
    }

    private String ztyskeibsybatkibosyuucd;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSKEIBSYBATKIBOSYUUCD)
    public String getZtyskeibsybatkibosyuucd() {
        return ztyskeibsybatkibosyuucd;
    }

    public void setZtyskeibsybatkibosyuucd(String pZtyskeibsybatkibosyuucd) {
        ztyskeibsybatkibosyuucd = pZtyskeibsybatkibosyuucd;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private Long ztyitijibrpkyktuukagtmtzndk;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYITIJIBRPKYKTUUKAGTMTZNDK)
    public Long getZtyitijibrpkyktuukagtmtzndk() {
        return ztyitijibrpkyktuukagtmtzndk;
    }

    public void setZtyitijibrpkyktuukagtmtzndk(Long pZtyitijibrpkyktuukagtmtzndk) {
        ztyitijibrpkyktuukagtmtzndk = pZtyitijibrpkyktuukagtmtzndk;
    }

    private Long ztygoukeip2kyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYGOUKEIP2KYKTUUKA)
    public Long getZtygoukeip2kyktuuka() {
        return ztygoukeip2kyktuuka;
    }

    public void setZtygoukeip2kyktuuka(Long pZtygoukeip2kyktuuka) {
        ztygoukeip2kyktuuka = pZtygoukeip2kyktuuka;
    }

    private Long ztyzennoupkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYZENNOUPKYKTUUKA)
    public Long getZtyzennoupkyktuuka() {
        return ztyzennoupkyktuuka;
    }

    public void setZtyzennoupkyktuuka(Long pZtyzennoupkyktuuka) {
        ztyzennoupkyktuuka = pZtyzennoupkyktuuka;
    }

    private Long ztytmttkngkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTMTTKNGKKYKTUUKA)
    public Long getZtytmttkngkkyktuuka() {
        return ztytmttkngkkyktuuka;
    }

    public void setZtytmttkngkkyktuuka(Long pZtytmttkngkkyktuuka) {
        ztytmttkngkkyktuuka = pZtytmttkngkkyktuuka;
    }

    private Long ztykaiyakuhrkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKAIYAKUHRKYKTUUKA)
    public Long getZtykaiyakuhrkyktuuka() {
        return ztykaiyakuhrkyktuuka;
    }

    public void setZtykaiyakuhrkyktuuka(Long pZtykaiyakuhrkyktuuka) {
        ztykaiyakuhrkyktuuka = pZtykaiyakuhrkyktuuka;
    }

    private Long ztykishrkinruikeigkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKISHRKINRUIKEIGKKYKTUUKA)
    public Long getZtykishrkinruikeigkkyktuuka() {
        return ztykishrkinruikeigkkyktuuka;
    }

    public void setZtykishrkinruikeigkkyktuuka(Long pZtykishrkinruikeigkkyktuuka) {
        ztykishrkinruikeigkkyktuuka = pZtykishrkinruikeigkkyktuuka;
    }

    private Long ztysjkkktyouseigkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSJKKKTYOUSEIGKKYKTUUKA)
    public Long getZtysjkkktyouseigkkyktuuka() {
        return ztysjkkktyouseigkkyktuuka;
    }

    public void setZtysjkkktyouseigkkyktuuka(Long pZtysjkkktyouseigkkyktuuka) {
        ztysjkkktyouseigkkyktuuka = pZtysjkkktyouseigkkyktuuka;
    }

    private Long ztykaiyakukjgkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKAIYAKUKJGKKYKTUUKA)
    public Long getZtykaiyakukjgkkyktuuka() {
        return ztykaiyakukjgkkyktuuka;
    }

    public void setZtykaiyakukjgkkyktuuka(Long pZtykaiyakukjgkkyktuuka) {
        ztykaiyakukjgkkyktuuka = pZtykaiyakukjgkkyktuuka;
    }

    private Long ztysonekikyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONEKIKYKTUUKA)
    public Long getZtysonekikyktuuka() {
        return ztysonekikyktuuka;
    }

    public void setZtysonekikyktuuka(Long pZtysonekikyktuuka) {
        ztysonekikyktuuka = pZtysonekikyktuuka;
    }

    private String ztysonekicalchunouflgsmbc;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONEKICALCHUNOUFLGSMBC)
    public String getZtysonekicalchunouflgsmbc() {
        return ztysonekicalchunouflgsmbc;
    }

    public void setZtysonekicalchunouflgsmbc(String pZtysonekicalchunouflgsmbc) {
        ztysonekicalchunouflgsmbc = pZtysonekicalchunouflgsmbc;
    }

    private Long ztysonotaseisankinkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONOTASEISANKINKYKTUUKA)
    public Long getZtysonotaseisankinkyktuuka() {
        return ztysonotaseisankinkyktuuka;
    }

    public void setZtysonotaseisankinkyktuuka(Long pZtysonotaseisankinkyktuuka) {
        ztysonotaseisankinkyktuuka = pZtysonotaseisankinkyktuuka;
    }

    private String ztytyusyakusmbc;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYTYUSYAKUSMBC)
    public String getZtytyusyakusmbc() {
        return ztytyusyakusmbc;
    }

    public void setZtytyusyakusmbc(String pZtytyusyakusmbc) {
        ztytyusyakusmbc = pZtytyusyakusmbc;
    }

    private BizNumber ztygmeigyoubijigaikashrrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYGMEIGYOUBIJIGAIKASHRRATE)
    public BizNumber getZtygmeigyoubijigaikashrrate() {
        return ztygmeigyoubijigaikashrrate;
    }

    public void setZtygmeigyoubijigaikashrrate(BizNumber pZtygmeigyoubijigaikashrrate) {
        ztygmeigyoubijigaikashrrate = pZtygmeigyoubijigaikashrrate;
    }

    private Long ztykihrpruikeigkkyktuuka;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYKIHRPRUIKEIGKKYKTUUKA)
    public Long getZtykihrpruikeigkkyktuuka() {
        return ztykihrpruikeigkkyktuuka;
    }

    public void setZtykihrpruikeigkkyktuuka(Long pZtykihrpruikeigkkyktuuka) {
        ztykihrpruikeigkkyktuuka = pZtykihrpruikeigkkyktuuka;
    }

    private Long ztygoukeip2smtb;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYGOUKEIP2SMTB)
    public Long getZtygoukeip2smtb() {
        return ztygoukeip2smtb;
    }

    public void setZtygoukeip2smtb(Long pZtygoukeip2smtb) {
        ztygoukeip2smtb = pZtygoukeip2smtb;
    }

    private Long ztysonekismtb;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONEKISMTB)
    public Long getZtysonekismtb() {
        return ztysonekismtb;
    }

    public void setZtysonekismtb(Long pZtysonekismtb) {
        ztysonekismtb = pZtysonekismtb;
    }

    private String ztysonekicalchunouflgsmtb;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYSONEKICALCHUNOUFLGSMTB)
    public String getZtysonekicalchunouflgsmtb() {
        return ztysonekicalchunouflgsmtb;
    }

    public void setZtysonekicalchunouflgsmtb(String pZtysonekicalchunouflgsmtb) {
        ztysonekicalchunouflgsmtb = pZtysonekicalchunouflgsmtb;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private Long ztyyobin11x10;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIN11X10)
    public Long getZtyyobin11x10() {
        return ztyyobin11x10;
    }

    public void setZtyyobin11x10(Long pZtyyobin11x10) {
        ztyyobin11x10 = pZtyyobin11x10;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztyyobiv56;

    @Column(name=GenZT_DairitenGtmtZndkTy.ZTYYOBIV56)
    public String getZtyyobiv56() {
        return ztyyobiv56;
    }

    public void setZtyyobiv56(String pZtyyobiv56) {
        ztyyobiv56 = pZtyyobiv56;
    }
}