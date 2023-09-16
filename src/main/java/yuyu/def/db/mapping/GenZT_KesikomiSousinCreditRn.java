package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditRn;
import yuyu.def.db.id.PKZT_KesikomiSousinCreditRn;
import yuyu.def.db.meta.GenQZT_KesikomiSousinCreditRn;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditRn;

/**
 * 消込送信Ｆ（クレ払）テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KesikomiSousinCreditRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KesikomiSousinCreditRn}</td><td colspan="3">消込送信Ｆ（クレ払）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkskmsousinrenno zrnkskmsousinrenno}</td><td>（連携用）消込送信連番</td><td align="center">{@link PKZT_KesikomiSousinCreditRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmkamokucd zrnkskmkamokucd}</td><td>（連携用）消込科目コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitoukbn zrnsuitoukbn}</td><td>（連携用）出納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitousosikicd zrnsuitousosikicd}</td><td>（連携用）出納組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhasseidenymd zrnhasseidenymd}</td><td>（連携用）発生伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikanjyono zrnkarikanjyono}</td><td>（連携用）仮勘定番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkakusyounyuuryokuymd1 zrnnkkakusyounyuuryokuymd1}</td><td>（連携用）入金確証入力年月日１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrniktannaidantaizaikeikbn zrniktannaidantaizaikeikbn}</td><td>（連携用）一括案内団体財形区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfanniskcd zrnkskmfanniskcd}</td><td>（連携用）（消込Ｆ）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaiannaijyuutouym1 zrndantaiannaijyuutouym1}</td><td>（連携用）団体案内充当年月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaino1 zrnannaino1}</td><td>（連携用）案内番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbonusharaihyouji1 zrnbonusharaihyouji1}</td><td>（連携用）ボーナス払表示１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfkzhurikaebankcd zrnkskmfkzhurikaebankcd}</td><td>（連携用）（消込Ｆ）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfhurikaeymd zrnkskmfhurikaeymd}</td><td>（連携用）（消込Ｆ）振替年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenuketukeno1 zrndairitenuketukeno1}</td><td>（連携用）代理店受付番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzaikeihrkkaisuukbn1 zrnzaikeihrkkaisuukbn1}</td><td>（連携用）財形払込回数区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnoukinhyouno zrnnoukinhyouno}</td><td>（連携用）納金票番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfcreditkaisyacd zrnkskmfcreditkaisyacd}</td><td>（連携用）（消込Ｆ）クレジット会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukikankbn zrnkinyuukikankbn}</td><td>（連携用）金融機関区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv18 zrnyobiv18}</td><td>（連携用）予備項目Ｖ１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfsyoriymd zrnkskmfsyoriymd}</td><td>（連携用）（消込Ｆ）処理年月日</td><td align="center">{@link PKZT_KesikomiSousinCreditRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfdenymd zrnkskmfdenymd}</td><td>（連携用）（消込Ｆ）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenatesakicd zrndenatesakicd}</td><td>（連携用）伝票宛先部課コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmftaisyakukbn zrnkskmftaisyakukbn}</td><td>（連携用）（消込Ｆ）貸借区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutuuhokenkamokucd zrnhutuuhokenkamokucd}</td><td>（連携用）普通保険用科目コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndengk zrndengk}</td><td>（連携用）伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntabakariknjykskmdatakbn zrntabakariknjykskmdatakbn}</td><td>（連携用）束仮勘定消込項目データ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfryousyuuymd zrnkskmfryousyuuymd}</td><td>（連携用）（消込Ｆ）領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryousyuuhm zrnryousyuuhm}</td><td>（連携用）領収時分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkakusyounyuuryokuymd2 zrnnkkakusyounyuuryokuymd2}</td><td>（連携用）入金確証入力年月日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfsyono zrnkskmfsyono}</td><td>（連携用）（消込Ｆ）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkhoukokuhyoutantouka zrnnkhoukokuhyoutantouka}</td><td>（連携用）入金報告票担当課</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkhoukokuhyoukihyouymd zrnnkhoukokuhyoukihyouymd}</td><td>（連携用）入金報告票起票年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkhoukokuhyoubunkaino zrnnkhoukokuhyoubunkaino}</td><td>（連携用）入金報告票分解表番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkakusyounyuuryokuno zrnnkkakusyounyuuryokuno}</td><td>（連携用）入金確証入力番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfdantaicd zrnkskmfdantaicd}</td><td>（連携用）（消込Ｆ）団体コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaiannaijyuutouym2 zrndantaiannaijyuutouym2}</td><td>（連携用）団体案内充当年月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbonusharaihyouji2 zrnbonusharaihyouji2}</td><td>（連携用）ボーナス払表示２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaino2 zrnannaino2}</td><td>（連携用）案内番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantaipkbn zrndantaipkbn}</td><td>（連携用）団体保険料区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndantainyuukinymd zrndantainyuukinymd}</td><td>（連携用）団体入金年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfjyuutouym zrnkskmfjyuutouym}</td><td>（連携用）（消込Ｆ）充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitouymd zrnsuitouymd}</td><td>（連携用）出納年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyuuryokuhouhoukbn zrnnyuuryokuhouhoukbn}</td><td>（連携用）入力方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfnyknaiyoukbn zrnkskmfnyknaiyoukbn}</td><td>（連携用）（消込Ｆ）入金内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekykhndnkhyouji zrnkzhurikaekykhndnkhyouji}</td><td>（連携用）口座振替契約ハンド入金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfdairitencd zrnkskmfdairitencd}</td><td>（連携用）（消込Ｆ）代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenuketukeno2 zrndairitenuketukeno2}</td><td>（連携用）代理店受付番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatudantaicd zrnikkatudantaicd}</td><td>（連携用）一括団体コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatuannaihikisariym zrnikkatuannaihikisariym}</td><td>（連携用）一括案内引去年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatuannaino zrnikkatuannaino}</td><td>（連携用）一括案内番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzaikeihrkkaisuukbn2 zrnzaikeihrkkaisuukbn2}</td><td>（連携用）財形払込回数区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzaikeikyksyano zrnzaikeikyksyano}</td><td>（連携用）財形契約者番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhasseisosikicd zrnhasseisosikicd}</td><td>（連携用）発生組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikeisakikaisyacd zrnteikeisakikaisyacd}</td><td>（連携用）提携先会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmfbankcd zrnkskmfbankcd}</td><td>（連携用）（消込Ｆ）銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitousyorisosikicd zrnsuitousyorisosikicd}</td><td>（連携用）出納処理組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaitekanjyouyomikaekbn zrnaitekanjyouyomikaekbn}</td><td>（連携用）相手勘定読替区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditcardhrkskmkbn zrncreditcardhrkskmkbn}</td><td>（連携用）クレ払消込区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlastteiseiymd zrnlastteiseiymd}</td><td>（連携用）最終訂正年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmkanryouymd zrnkskmkanryouymd}</td><td>（連携用）消込完了年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmteiseino zrnkskmteiseino}</td><td>（連携用）消込訂正番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkskmkanryousijihyouji zrnkskmkanryousijihyouji}</td><td>（連携用）消込完了指示表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuketuketencd zrnuketuketencd}</td><td>（連携用）受付店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncvscd zrncvscd}</td><td>（連携用）ＣＶＳコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikomiyousinyuukinkbn zrnhurikomiyousinyuukinkbn}</td><td>（連携用）振込用紙入金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikomiyousiokyksmno zrnhurikomiyousiokyksmno}</td><td>（連携用）振込用紙お客さま番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikomiyousikakuninno zrnhurikomiyousikakuninno}</td><td>（連携用）振込用紙確認番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnegsyokuinhurikomiymd zrnegsyokuinhurikomiymd}</td><td>（連携用）営業職員振込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvitkaiinno zrnvitkaiinno}</td><td>（連携用）Ｖｉｔ会員番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv74 zrnyobiv74}</td><td>（連携用）予備項目Ｖ７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KesikomiSousinCreditRn
 * @see     PKZT_KesikomiSousinCreditRn
 * @see     QZT_KesikomiSousinCreditRn
 * @see     GenQZT_KesikomiSousinCreditRn
 */
@MappedSuperclass
@Table(name=GenZT_KesikomiSousinCreditRn.TABLE_NAME)
@IdClass(value=PKZT_KesikomiSousinCreditRn.class)
public abstract class GenZT_KesikomiSousinCreditRn extends AbstractExDBEntityForZDB<ZT_KesikomiSousinCreditRn, PKZT_KesikomiSousinCreditRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KesikomiSousinCreditRn";
    public static final String ZRNKSKMSOUSINRENNO       = "zrnkskmsousinrenno";
    public static final String ZRNKSKMKAMOKUCD          = "zrnkskmkamokucd";
    public static final String ZRNSUITOUKBN             = "zrnsuitoukbn";
    public static final String ZRNSUITOUSOSIKICD        = "zrnsuitousosikicd";
    public static final String ZRNHASSEIDENYMD          = "zrnhasseidenymd";
    public static final String ZRNKARIKANJYONO          = "zrnkarikanjyono";
    public static final String ZRNNKKAKUSYOUNYUURYOKUYMD1 = "zrnnkkakusyounyuuryokuymd1";
    public static final String ZRNIKTANNAIDANTAIZAIKEIKBN = "zrniktannaidantaizaikeikbn";
    public static final String ZRNKSKMFANNISKCD         = "zrnkskmfanniskcd";
    public static final String ZRNDANTAIANNAIJYUUTOUYM1 = "zrndantaiannaijyuutouym1";
    public static final String ZRNANNAINO1              = "zrnannaino1";
    public static final String ZRNBONUSHARAIHYOUJI1     = "zrnbonusharaihyouji1";
    public static final String ZRNKSKMFKZHURIKAEBANKCD  = "zrnkskmfkzhurikaebankcd";
    public static final String ZRNKSKMFHURIKAEYMD       = "zrnkskmfhurikaeymd";
    public static final String ZRNDAIRITENUKETUKENO1    = "zrndairitenuketukeno1";
    public static final String ZRNZAIKEIHRKKAISUUKBN1   = "zrnzaikeihrkkaisuukbn1";
    public static final String ZRNNOUKINHYOUNO          = "zrnnoukinhyouno";
    public static final String ZRNKSKMFCREDITKAISYACD   = "zrnkskmfcreditkaisyacd";
    public static final String ZRNKINYUUKIKANKBN        = "zrnkinyuukikankbn";
    public static final String ZRNYOBIV18               = "zrnyobiv18";
    public static final String ZRNKSKMFSYORIYMD         = "zrnkskmfsyoriymd";
    public static final String ZRNKSKMFDENYMD           = "zrnkskmfdenymd";
    public static final String ZRNDENATESAKICD          = "zrndenatesakicd";
    public static final String ZRNKSKMFTAISYAKUKBN      = "zrnkskmftaisyakukbn";
    public static final String ZRNHUTUUHOKENKAMOKUCD    = "zrnhutuuhokenkamokucd";
    public static final String ZRNDENGK                 = "zrndengk";
    public static final String ZRNTABAKARIKNJYKSKMDATAKBN = "zrntabakariknjykskmdatakbn";
    public static final String ZRNKSKMFRYOUSYUUYMD      = "zrnkskmfryousyuuymd";
    public static final String ZRNRYOUSYUUHM            = "zrnryousyuuhm";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNNKKAKUSYOUNYUURYOKUYMD2 = "zrnnkkakusyounyuuryokuymd2";
    public static final String ZRNKSKMFSYONO            = "zrnkskmfsyono";
    public static final String ZRNNKHOUKOKUHYOUTANTOUKA = "zrnnkhoukokuhyoutantouka";
    public static final String ZRNNKHOUKOKUHYOUKIHYOUYMD = "zrnnkhoukokuhyoukihyouymd";
    public static final String ZRNNKHOUKOKUHYOUBUNKAINO = "zrnnkhoukokuhyoubunkaino";
    public static final String ZRNNKKAKUSYOUNYUURYOKUNO = "zrnnkkakusyounyuuryokuno";
    public static final String ZRNKSKMFDANTAICD         = "zrnkskmfdantaicd";
    public static final String ZRNDANTAIANNAIJYUUTOUYM2 = "zrndantaiannaijyuutouym2";
    public static final String ZRNBONUSHARAIHYOUJI2     = "zrnbonusharaihyouji2";
    public static final String ZRNANNAINO2              = "zrnannaino2";
    public static final String ZRNDANTAIPKBN            = "zrndantaipkbn";
    public static final String ZRNDANTAINYUUKINYMD      = "zrndantainyuukinymd";
    public static final String ZRNKSKMFJYUUTOUYM        = "zrnkskmfjyuutouym";
    public static final String ZRNSUITOUYMD             = "zrnsuitouymd";
    public static final String ZRNNYUURYOKUHOUHOUKBN    = "zrnnyuuryokuhouhoukbn";
    public static final String ZRNKSKMFNYKNAIYOUKBN     = "zrnkskmfnyknaiyoukbn";
    public static final String ZRNKZHURIKAEKYKHNDNKHYOUJI = "zrnkzhurikaekykhndnkhyouji";
    public static final String ZRNKSKMFDAIRITENCD       = "zrnkskmfdairitencd";
    public static final String ZRNDAIRITENUKETUKENO2    = "zrndairitenuketukeno2";
    public static final String ZRNIKKATUDANTAICD        = "zrnikkatudantaicd";
    public static final String ZRNIKKATUANNAIHIKISARIYM = "zrnikkatuannaihikisariym";
    public static final String ZRNIKKATUANNAINO         = "zrnikkatuannaino";
    public static final String ZRNZAIKEIHRKKAISUUKBN2   = "zrnzaikeihrkkaisuukbn2";
    public static final String ZRNZAIKEIKYKSYANO        = "zrnzaikeikyksyano";
    public static final String ZRNHASSEISOSIKICD        = "zrnhasseisosikicd";
    public static final String ZRNTEIKEISAKIKAISYACD    = "zrnteikeisakikaisyacd";
    public static final String ZRNKSKMFBANKCD           = "zrnkskmfbankcd";
    public static final String ZRNSUITOUSYORISOSIKICD   = "zrnsuitousyorisosikicd";
    public static final String ZRNAITEKANJYOUYOMIKAEKBN = "zrnaitekanjyouyomikaekbn";
    public static final String ZRNCREDITCARDHRKSKMKBN   = "zrncreditcardhrkskmkbn";
    public static final String ZRNLASTTEISEIYMD         = "zrnlastteiseiymd";
    public static final String ZRNKSKMKANRYOUYMD        = "zrnkskmkanryouymd";
    public static final String ZRNKSKMTEISEINO          = "zrnkskmteiseino";
    public static final String ZRNKSKMKANRYOUSIJIHYOUJI = "zrnkskmkanryousijihyouji";
    public static final String ZRNUKETUKETENCD          = "zrnuketuketencd";
    public static final String ZRNCVSCD                 = "zrncvscd";
    public static final String ZRNHURIKOMIYOUSINYUUKINKBN = "zrnhurikomiyousinyuukinkbn";
    public static final String ZRNHURIKOMIYOUSIOKYKSMNO = "zrnhurikomiyousiokyksmno";
    public static final String ZRNHURIKOMIYOUSIKAKUNINNO = "zrnhurikomiyousikakuninno";
    public static final String ZRNEGSYOKUINHURIKOMIYMD  = "zrnegsyokuinhurikomiymd";
    public static final String ZRNVITKAIINNO            = "zrnvitkaiinno";
    public static final String ZRNYOBIV74               = "zrnyobiv74";

    private final PKZT_KesikomiSousinCreditRn primaryKey;

    public GenZT_KesikomiSousinCreditRn() {
        primaryKey = new PKZT_KesikomiSousinCreditRn();
    }

    public GenZT_KesikomiSousinCreditRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        primaryKey = new PKZT_KesikomiSousinCreditRn(pZrnkskmsousinrenno, pZrnkskmfsyoriymd);
    }

    @Transient
    @Override
    public PKZT_KesikomiSousinCreditRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KesikomiSousinCreditRn> getMetaClass() {
        return QZT_KesikomiSousinCreditRn.class;
    }

    @Id
    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMSOUSINRENNO)
    public String getZrnkskmsousinrenno() {
        return getPrimaryKey().getZrnkskmsousinrenno();
    }

    public void setZrnkskmsousinrenno(String pZrnkskmsousinrenno) {
        getPrimaryKey().setZrnkskmsousinrenno(pZrnkskmsousinrenno);
    }

    private String zrnkskmkamokucd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMKAMOKUCD)
    public String getZrnkskmkamokucd() {
        return zrnkskmkamokucd;
    }

    public void setZrnkskmkamokucd(String pZrnkskmkamokucd) {
        zrnkskmkamokucd = pZrnkskmkamokucd;
    }

    private String zrnsuitoukbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNSUITOUKBN)
    public String getZrnsuitoukbn() {
        return zrnsuitoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuitoukbn(String pZrnsuitoukbn) {
        zrnsuitoukbn = pZrnsuitoukbn;
    }

    private String zrnsuitousosikicd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNSUITOUSOSIKICD)
    public String getZrnsuitousosikicd() {
        return zrnsuitousosikicd;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnsuitousosikicd(String pZrnsuitousosikicd) {
        zrnsuitousosikicd = pZrnsuitousosikicd;
    }

    private String zrnhasseidenymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNHASSEIDENYMD)
    public String getZrnhasseidenymd() {
        return zrnhasseidenymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhasseidenymd(String pZrnhasseidenymd) {
        zrnhasseidenymd = pZrnhasseidenymd;
    }

    private String zrnkarikanjyono;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKARIKANJYONO)
    public String getZrnkarikanjyono() {
        return zrnkarikanjyono;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkarikanjyono(String pZrnkarikanjyono) {
        zrnkarikanjyono = pZrnkarikanjyono;
    }

    private String zrnnkkakusyounyuuryokuymd1;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNKKAKUSYOUNYUURYOKUYMD1)
    public String getZrnnkkakusyounyuuryokuymd1() {
        return zrnnkkakusyounyuuryokuymd1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnkkakusyounyuuryokuymd1(String pZrnnkkakusyounyuuryokuymd1) {
        zrnnkkakusyounyuuryokuymd1 = pZrnnkkakusyounyuuryokuymd1;
    }

    private String zrniktannaidantaizaikeikbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNIKTANNAIDANTAIZAIKEIKBN)
    public String getZrniktannaidantaizaikeikbn() {
        return zrniktannaidantaizaikeikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrniktannaidantaizaikeikbn(String pZrniktannaidantaizaikeikbn) {
        zrniktannaidantaizaikeikbn = pZrniktannaidantaizaikeikbn;
    }

    private String zrnkskmfanniskcd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFANNISKCD)
    public String getZrnkskmfanniskcd() {
        return zrnkskmfanniskcd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmfanniskcd(String pZrnkskmfanniskcd) {
        zrnkskmfanniskcd = pZrnkskmfanniskcd;
    }

    private String zrndantaiannaijyuutouym1;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDANTAIANNAIJYUUTOUYM1)
    public String getZrndantaiannaijyuutouym1() {
        return zrndantaiannaijyuutouym1;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndantaiannaijyuutouym1(String pZrndantaiannaijyuutouym1) {
        zrndantaiannaijyuutouym1 = pZrndantaiannaijyuutouym1;
    }

    private String zrnannaino1;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNANNAINO1)
    public String getZrnannaino1() {
        return zrnannaino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnannaino1(String pZrnannaino1) {
        zrnannaino1 = pZrnannaino1;
    }

    private String zrnbonusharaihyouji1;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNBONUSHARAIHYOUJI1)
    public String getZrnbonusharaihyouji1() {
        return zrnbonusharaihyouji1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbonusharaihyouji1(String pZrnbonusharaihyouji1) {
        zrnbonusharaihyouji1 = pZrnbonusharaihyouji1;
    }

    private String zrnkskmfkzhurikaebankcd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFKZHURIKAEBANKCD)
    public String getZrnkskmfkzhurikaebankcd() {
        return zrnkskmfkzhurikaebankcd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkskmfkzhurikaebankcd(String pZrnkskmfkzhurikaebankcd) {
        zrnkskmfkzhurikaebankcd = pZrnkskmfkzhurikaebankcd;
    }

    private String zrnkskmfhurikaeymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFHURIKAEYMD)
    public String getZrnkskmfhurikaeymd() {
        return zrnkskmfhurikaeymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmfhurikaeymd(String pZrnkskmfhurikaeymd) {
        zrnkskmfhurikaeymd = pZrnkskmfhurikaeymd;
    }

    private String zrndairitenuketukeno1;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDAIRITENUKETUKENO1)
    public String getZrndairitenuketukeno1() {
        return zrndairitenuketukeno1;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrndairitenuketukeno1(String pZrndairitenuketukeno1) {
        zrndairitenuketukeno1 = pZrndairitenuketukeno1;
    }

    private String zrnzaikeihrkkaisuukbn1;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNZAIKEIHRKKAISUUKBN1)
    public String getZrnzaikeihrkkaisuukbn1() {
        return zrnzaikeihrkkaisuukbn1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnzaikeihrkkaisuukbn1(String pZrnzaikeihrkkaisuukbn1) {
        zrnzaikeihrkkaisuukbn1 = pZrnzaikeihrkkaisuukbn1;
    }

    private String zrnnoukinhyouno;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNOUKINHYOUNO)
    public String getZrnnoukinhyouno() {
        return zrnnoukinhyouno;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnnoukinhyouno(String pZrnnoukinhyouno) {
        zrnnoukinhyouno = pZrnnoukinhyouno;
    }

    private String zrnkskmfcreditkaisyacd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFCREDITKAISYACD)
    public String getZrnkskmfcreditkaisyacd() {
        return zrnkskmfcreditkaisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnkskmfcreditkaisyacd(String pZrnkskmfcreditkaisyacd) {
        zrnkskmfcreditkaisyacd = pZrnkskmfcreditkaisyacd;
    }

    private String zrnkinyuukikankbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKINYUUKIKANKBN)
    public String getZrnkinyuukikankbn() {
        return zrnkinyuukikankbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkinyuukikankbn(String pZrnkinyuukikankbn) {
        zrnkinyuukikankbn = pZrnkinyuukikankbn;
    }

    private String zrnyobiv18;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNYOBIV18)
    public String getZrnyobiv18() {
        return zrnyobiv18;
    }

    public void setZrnyobiv18(String pZrnyobiv18) {
        zrnyobiv18 = pZrnyobiv18;
    }

    @Id
    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFSYORIYMD)
    public String getZrnkskmfsyoriymd() {
        return getPrimaryKey().getZrnkskmfsyoriymd();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmfsyoriymd(String pZrnkskmfsyoriymd) {
        getPrimaryKey().setZrnkskmfsyoriymd(pZrnkskmfsyoriymd);
    }

    private String zrnkskmfdenymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFDENYMD)
    public String getZrnkskmfdenymd() {
        return zrnkskmfdenymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmfdenymd(String pZrnkskmfdenymd) {
        zrnkskmfdenymd = pZrnkskmfdenymd;
    }

    private String zrndenatesakicd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDENATESAKICD)
    public String getZrndenatesakicd() {
        return zrndenatesakicd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrndenatesakicd(String pZrndenatesakicd) {
        zrndenatesakicd = pZrndenatesakicd;
    }

    private String zrnkskmftaisyakukbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFTAISYAKUKBN)
    public String getZrnkskmftaisyakukbn() {
        return zrnkskmftaisyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkskmftaisyakukbn(String pZrnkskmftaisyakukbn) {
        zrnkskmftaisyakukbn = pZrnkskmftaisyakukbn;
    }

    private String zrnhutuuhokenkamokucd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNHUTUUHOKENKAMOKUCD)
    public String getZrnhutuuhokenkamokucd() {
        return zrnhutuuhokenkamokucd;
    }

    public void setZrnhutuuhokenkamokucd(String pZrnhutuuhokenkamokucd) {
        zrnhutuuhokenkamokucd = pZrnhutuuhokenkamokucd;
    }

    private Long zrndengk;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDENGK)
    public Long getZrndengk() {
        return zrndengk;
    }

    public void setZrndengk(Long pZrndengk) {
        zrndengk = pZrndengk;
    }

    private String zrntabakariknjykskmdatakbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNTABAKARIKNJYKSKMDATAKBN)
    public String getZrntabakariknjykskmdatakbn() {
        return zrntabakariknjykskmdatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntabakariknjykskmdatakbn(String pZrntabakariknjykskmdatakbn) {
        zrntabakariknjykskmdatakbn = pZrntabakariknjykskmdatakbn;
    }

    private String zrnkskmfryousyuuymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFRYOUSYUUYMD)
    public String getZrnkskmfryousyuuymd() {
        return zrnkskmfryousyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmfryousyuuymd(String pZrnkskmfryousyuuymd) {
        zrnkskmfryousyuuymd = pZrnkskmfryousyuuymd;
    }

    private String zrnryousyuuhm;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNRYOUSYUUHM)
    public String getZrnryousyuuhm() {
        return zrnryousyuuhm;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnryousyuuhm(String pZrnryousyuuhm) {
        zrnryousyuuhm = pZrnryousyuuhm;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrnnkkakusyounyuuryokuymd2;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNKKAKUSYOUNYUURYOKUYMD2)
    public String getZrnnkkakusyounyuuryokuymd2() {
        return zrnnkkakusyounyuuryokuymd2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnkkakusyounyuuryokuymd2(String pZrnnkkakusyounyuuryokuymd2) {
        zrnnkkakusyounyuuryokuymd2 = pZrnnkkakusyounyuuryokuymd2;
    }

    private String zrnkskmfsyono;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFSYONO)
    public String getZrnkskmfsyono() {
        return zrnkskmfsyono;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnkskmfsyono(String pZrnkskmfsyono) {
        zrnkskmfsyono = pZrnkskmfsyono;
    }

    private String zrnnkhoukokuhyoutantouka;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNKHOUKOKUHYOUTANTOUKA)
    public String getZrnnkhoukokuhyoutantouka() {
        return zrnnkhoukokuhyoutantouka;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnnkhoukokuhyoutantouka(String pZrnnkhoukokuhyoutantouka) {
        zrnnkhoukokuhyoutantouka = pZrnnkhoukokuhyoutantouka;
    }

    private String zrnnkhoukokuhyoukihyouymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNKHOUKOKUHYOUKIHYOUYMD)
    public String getZrnnkhoukokuhyoukihyouymd() {
        return zrnnkhoukokuhyoukihyouymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnkhoukokuhyoukihyouymd(String pZrnnkhoukokuhyoukihyouymd) {
        zrnnkhoukokuhyoukihyouymd = pZrnnkhoukokuhyoukihyouymd;
    }

    private String zrnnkhoukokuhyoubunkaino;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNKHOUKOKUHYOUBUNKAINO)
    public String getZrnnkhoukokuhyoubunkaino() {
        return zrnnkhoukokuhyoubunkaino;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkhoukokuhyoubunkaino(String pZrnnkhoukokuhyoubunkaino) {
        zrnnkhoukokuhyoubunkaino = pZrnnkhoukokuhyoubunkaino;
    }

    private String zrnnkkakusyounyuuryokuno;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNKKAKUSYOUNYUURYOKUNO)
    public String getZrnnkkakusyounyuuryokuno() {
        return zrnnkkakusyounyuuryokuno;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnkkakusyounyuuryokuno(String pZrnnkkakusyounyuuryokuno) {
        zrnnkkakusyounyuuryokuno = pZrnnkkakusyounyuuryokuno;
    }

    private String zrnkskmfdantaicd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFDANTAICD)
    public String getZrnkskmfdantaicd() {
        return zrnkskmfdantaicd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmfdantaicd(String pZrnkskmfdantaicd) {
        zrnkskmfdantaicd = pZrnkskmfdantaicd;
    }

    private String zrndantaiannaijyuutouym2;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDANTAIANNAIJYUUTOUYM2)
    public String getZrndantaiannaijyuutouym2() {
        return zrndantaiannaijyuutouym2;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndantaiannaijyuutouym2(String pZrndantaiannaijyuutouym2) {
        zrndantaiannaijyuutouym2 = pZrndantaiannaijyuutouym2;
    }

    private String zrnbonusharaihyouji2;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNBONUSHARAIHYOUJI2)
    public String getZrnbonusharaihyouji2() {
        return zrnbonusharaihyouji2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbonusharaihyouji2(String pZrnbonusharaihyouji2) {
        zrnbonusharaihyouji2 = pZrnbonusharaihyouji2;
    }

    private String zrnannaino2;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNANNAINO2)
    public String getZrnannaino2() {
        return zrnannaino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnannaino2(String pZrnannaino2) {
        zrnannaino2 = pZrnannaino2;
    }

    private String zrndantaipkbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDANTAIPKBN)
    public String getZrndantaipkbn() {
        return zrndantaipkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndantaipkbn(String pZrndantaipkbn) {
        zrndantaipkbn = pZrndantaipkbn;
    }

    private String zrndantainyuukinymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDANTAINYUUKINYMD)
    public String getZrndantainyuukinymd() {
        return zrndantainyuukinymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndantainyuukinymd(String pZrndantainyuukinymd) {
        zrndantainyuukinymd = pZrndantainyuukinymd;
    }

    private String zrnkskmfjyuutouym;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFJYUUTOUYM)
    public String getZrnkskmfjyuutouym() {
        return zrnkskmfjyuutouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnkskmfjyuutouym(String pZrnkskmfjyuutouym) {
        zrnkskmfjyuutouym = pZrnkskmfjyuutouym;
    }

    private String zrnsuitouymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNSUITOUYMD)
    public String getZrnsuitouymd() {
        return zrnsuitouymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuitouymd(String pZrnsuitouymd) {
        zrnsuitouymd = pZrnsuitouymd;
    }

    private String zrnnyuuryokuhouhoukbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNNYUURYOKUHOUHOUKBN)
    public String getZrnnyuuryokuhouhoukbn() {
        return zrnnyuuryokuhouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuuryokuhouhoukbn(String pZrnnyuuryokuhouhoukbn) {
        zrnnyuuryokuhouhoukbn = pZrnnyuuryokuhouhoukbn;
    }

    private String zrnkskmfnyknaiyoukbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFNYKNAIYOUKBN)
    public String getZrnkskmfnyknaiyoukbn() {
        return zrnkskmfnyknaiyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkskmfnyknaiyoukbn(String pZrnkskmfnyknaiyoukbn) {
        zrnkskmfnyknaiyoukbn = pZrnkskmfnyknaiyoukbn;
    }

    private String zrnkzhurikaekykhndnkhyouji;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKZHURIKAEKYKHNDNKHYOUJI)
    public String getZrnkzhurikaekykhndnkhyouji() {
        return zrnkzhurikaekykhndnkhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzhurikaekykhndnkhyouji(String pZrnkzhurikaekykhndnkhyouji) {
        zrnkzhurikaekykhndnkhyouji = pZrnkzhurikaekykhndnkhyouji;
    }

    private String zrnkskmfdairitencd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFDAIRITENCD)
    public String getZrnkskmfdairitencd() {
        return zrnkskmfdairitencd;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnkskmfdairitencd(String pZrnkskmfdairitencd) {
        zrnkskmfdairitencd = pZrnkskmfdairitencd;
    }

    private String zrndairitenuketukeno2;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNDAIRITENUKETUKENO2)
    public String getZrndairitenuketukeno2() {
        return zrndairitenuketukeno2;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrndairitenuketukeno2(String pZrndairitenuketukeno2) {
        zrndairitenuketukeno2 = pZrndairitenuketukeno2;
    }

    private String zrnikkatudantaicd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNIKKATUDANTAICD)
    public String getZrnikkatudantaicd() {
        return zrnikkatudantaicd;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnikkatudantaicd(String pZrnikkatudantaicd) {
        zrnikkatudantaicd = pZrnikkatudantaicd;
    }

    private String zrnikkatuannaihikisariym;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNIKKATUANNAIHIKISARIYM)
    public String getZrnikkatuannaihikisariym() {
        return zrnikkatuannaihikisariym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnikkatuannaihikisariym(String pZrnikkatuannaihikisariym) {
        zrnikkatuannaihikisariym = pZrnikkatuannaihikisariym;
    }

    private String zrnikkatuannaino;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNIKKATUANNAINO)
    public String getZrnikkatuannaino() {
        return zrnikkatuannaino;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatuannaino(String pZrnikkatuannaino) {
        zrnikkatuannaino = pZrnikkatuannaino;
    }

    private String zrnzaikeihrkkaisuukbn2;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNZAIKEIHRKKAISUUKBN2)
    public String getZrnzaikeihrkkaisuukbn2() {
        return zrnzaikeihrkkaisuukbn2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnzaikeihrkkaisuukbn2(String pZrnzaikeihrkkaisuukbn2) {
        zrnzaikeihrkkaisuukbn2 = pZrnzaikeihrkkaisuukbn2;
    }

    private String zrnzaikeikyksyano;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNZAIKEIKYKSYANO)
    public String getZrnzaikeikyksyano() {
        return zrnzaikeikyksyano;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnzaikeikyksyano(String pZrnzaikeikyksyano) {
        zrnzaikeikyksyano = pZrnzaikeikyksyano;
    }

    private String zrnhasseisosikicd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNHASSEISOSIKICD)
    public String getZrnhasseisosikicd() {
        return zrnhasseisosikicd;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnhasseisosikicd(String pZrnhasseisosikicd) {
        zrnhasseisosikicd = pZrnhasseisosikicd;
    }

    private String zrnteikeisakikaisyacd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNTEIKEISAKIKAISYACD)
    public String getZrnteikeisakikaisyacd() {
        return zrnteikeisakikaisyacd;
    }

    public void setZrnteikeisakikaisyacd(String pZrnteikeisakikaisyacd) {
        zrnteikeisakikaisyacd = pZrnteikeisakikaisyacd;
    }

    private String zrnkskmfbankcd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMFBANKCD)
    public String getZrnkskmfbankcd() {
        return zrnkskmfbankcd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkskmfbankcd(String pZrnkskmfbankcd) {
        zrnkskmfbankcd = pZrnkskmfbankcd;
    }

    private String zrnsuitousyorisosikicd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNSUITOUSYORISOSIKICD)
    public String getZrnsuitousyorisosikicd() {
        return zrnsuitousyorisosikicd;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnsuitousyorisosikicd(String pZrnsuitousyorisosikicd) {
        zrnsuitousyorisosikicd = pZrnsuitousyorisosikicd;
    }

    private String zrnaitekanjyouyomikaekbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNAITEKANJYOUYOMIKAEKBN)
    public String getZrnaitekanjyouyomikaekbn() {
        return zrnaitekanjyouyomikaekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnaitekanjyouyomikaekbn(String pZrnaitekanjyouyomikaekbn) {
        zrnaitekanjyouyomikaekbn = pZrnaitekanjyouyomikaekbn;
    }

    private String zrncreditcardhrkskmkbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNCREDITCARDHRKSKMKBN)
    public String getZrncreditcardhrkskmkbn() {
        return zrncreditcardhrkskmkbn;
    }

    public void setZrncreditcardhrkskmkbn(String pZrncreditcardhrkskmkbn) {
        zrncreditcardhrkskmkbn = pZrncreditcardhrkskmkbn;
    }

    private String zrnlastteiseiymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNLASTTEISEIYMD)
    public String getZrnlastteiseiymd() {
        return zrnlastteiseiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnlastteiseiymd(String pZrnlastteiseiymd) {
        zrnlastteiseiymd = pZrnlastteiseiymd;
    }

    private String zrnkskmkanryouymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMKANRYOUYMD)
    public String getZrnkskmkanryouymd() {
        return zrnkskmkanryouymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkskmkanryouymd(String pZrnkskmkanryouymd) {
        zrnkskmkanryouymd = pZrnkskmkanryouymd;
    }

    private String zrnkskmteiseino;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMTEISEINO)
    public String getZrnkskmteiseino() {
        return zrnkskmteiseino;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnkskmteiseino(String pZrnkskmteiseino) {
        zrnkskmteiseino = pZrnkskmteiseino;
    }

    private String zrnkskmkanryousijihyouji;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNKSKMKANRYOUSIJIHYOUJI)
    public String getZrnkskmkanryousijihyouji() {
        return zrnkskmkanryousijihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkskmkanryousijihyouji(String pZrnkskmkanryousijihyouji) {
        zrnkskmkanryousijihyouji = pZrnkskmkanryousijihyouji;
    }

    private String zrnuketuketencd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNUKETUKETENCD)
    public String getZrnuketuketencd() {
        return zrnuketuketencd;
    }

    public void setZrnuketuketencd(String pZrnuketuketencd) {
        zrnuketuketencd = pZrnuketuketencd;
    }

    private String zrncvscd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNCVSCD)
    public String getZrncvscd() {
        return zrncvscd;
    }

    public void setZrncvscd(String pZrncvscd) {
        zrncvscd = pZrncvscd;
    }

    private String zrnhurikomiyousinyuukinkbn;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNHURIKOMIYOUSINYUUKINKBN)
    public String getZrnhurikomiyousinyuukinkbn() {
        return zrnhurikomiyousinyuukinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhurikomiyousinyuukinkbn(String pZrnhurikomiyousinyuukinkbn) {
        zrnhurikomiyousinyuukinkbn = pZrnhurikomiyousinyuukinkbn;
    }

    private String zrnhurikomiyousiokyksmno;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNHURIKOMIYOUSIOKYKSMNO)
    public String getZrnhurikomiyousiokyksmno() {
        return zrnhurikomiyousiokyksmno;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnhurikomiyousiokyksmno(String pZrnhurikomiyousiokyksmno) {
        zrnhurikomiyousiokyksmno = pZrnhurikomiyousiokyksmno;
    }

    private String zrnhurikomiyousikakuninno;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNHURIKOMIYOUSIKAKUNINNO)
    public String getZrnhurikomiyousikakuninno() {
        return zrnhurikomiyousikakuninno;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnhurikomiyousikakuninno(String pZrnhurikomiyousikakuninno) {
        zrnhurikomiyousikakuninno = pZrnhurikomiyousikakuninno;
    }

    private String zrnegsyokuinhurikomiymd;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNEGSYOKUINHURIKOMIYMD)
    public String getZrnegsyokuinhurikomiymd() {
        return zrnegsyokuinhurikomiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnegsyokuinhurikomiymd(String pZrnegsyokuinhurikomiymd) {
        zrnegsyokuinhurikomiymd = pZrnegsyokuinhurikomiymd;
    }

    private String zrnvitkaiinno;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNVITKAIINNO)
    public String getZrnvitkaiinno() {
        return zrnvitkaiinno;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnvitkaiinno(String pZrnvitkaiinno) {
        zrnvitkaiinno = pZrnvitkaiinno;
    }

    private String zrnyobiv74;

    @Column(name=GenZT_KesikomiSousinCreditRn.ZRNYOBIV74)
    public String getZrnyobiv74() {
        return zrnyobiv74;
    }

    public void setZrnyobiv74(String pZrnyobiv74) {
        zrnyobiv74 = pZrnyobiv74;
    }
}