package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;
import yuyu.def.db.id.PKZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.GenQZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditTy;

/**
 * 消込送信Ｆ（クレ払）テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KesikomiSousinCreditTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KesikomiSousinCreditTy}</td><td colspan="3">消込送信Ｆ（クレ払）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykskmsousinrenno ztykskmsousinrenno}</td><td>（中継用）消込送信連番</td><td align="center">{@link PKZT_KesikomiSousinCreditTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmkamokucd ztykskmkamokucd}</td><td>（中継用）消込科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitoukbn ztysuitoukbn}</td><td>（中継用）出納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitousosikicd ztysuitousosikicd}</td><td>（中継用）出納組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhasseidenymd ztyhasseidenymd}</td><td>（中継用）発生伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikanjyono ztykarikanjyono}</td><td>（中継用）仮勘定番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkakusyounyuuryokuymd1 ztynkkakusyounyuuryokuymd1}</td><td>（中継用）入金確証入力年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyiktannaidantaizaikeikbn ztyiktannaidantaizaikeikbn}</td><td>（中継用）一括案内団体財形区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfanniskcd ztykskmfanniskcd}</td><td>（中継用）（消込Ｆ）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaiannaijyuutouym1 ztydantaiannaijyuutouym1}</td><td>（中継用）団体案内充当年月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaino1 ztyannaino1}</td><td>（中継用）案内番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybonusharaihyouji1 ztybonusharaihyouji1}</td><td>（中継用）ボーナス払表示１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfkzhurikaebankcd ztykskmfkzhurikaebankcd}</td><td>（中継用）（消込Ｆ）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfhurikaeymd ztykskmfhurikaeymd}</td><td>（中継用）（消込Ｆ）振替年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenuketukeno1 ztydairitenuketukeno1}</td><td>（中継用）代理店受付番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzaikeihrkkaisuukbn1 ztyzaikeihrkkaisuukbn1}</td><td>（中継用）財形払込回数区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynoukinhyouno ztynoukinhyouno}</td><td>（中継用）納金票番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfcreditkaisyacd ztykskmfcreditkaisyacd}</td><td>（中継用）（消込Ｆ）クレジット会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykinyuukikankbn ztykinyuukikankbn}</td><td>（中継用）金融機関区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv18 ztyyobiv18}</td><td>（中継用）予備項目Ｖ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfsyoriymd ztykskmfsyoriymd}</td><td>（中継用）（消込Ｆ）処理年月日</td><td align="center">{@link PKZT_KesikomiSousinCreditTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfdenymd ztykskmfdenymd}</td><td>（中継用）（消込Ｆ）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenatesakicd ztydenatesakicd}</td><td>（中継用）伝票宛先部課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmftaisyakukbn ztykskmftaisyakukbn}</td><td>（中継用）（消込Ｆ）貸借区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutuuhokenkamokucd ztyhutuuhokenkamokucd}</td><td>（中継用）普通保険用科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydengk ztydengk}</td><td>（中継用）伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytabakariknjykskmdatakbn ztytabakariknjykskmdatakbn}</td><td>（中継用）束仮勘定消込項目データ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfryousyuuymd ztykskmfryousyuuymd}</td><td>（中継用）（消込Ｆ）領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryousyuuhm ztyryousyuuhm}</td><td>（中継用）領収時分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkakusyounyuuryokuymd2 ztynkkakusyounyuuryokuymd2}</td><td>（中継用）入金確証入力年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfsyono ztykskmfsyono}</td><td>（中継用）（消込Ｆ）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkhoukokuhyoutantouka ztynkhoukokuhyoutantouka}</td><td>（中継用）入金報告票担当課</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkhoukokuhyoukihyouymd ztynkhoukokuhyoukihyouymd}</td><td>（中継用）入金報告票起票年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkhoukokuhyoubunkaino ztynkhoukokuhyoubunkaino}</td><td>（中継用）入金報告票分解表番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkakusyounyuuryokuno ztynkkakusyounyuuryokuno}</td><td>（中継用）入金確証入力番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfdantaicd ztykskmfdantaicd}</td><td>（中継用）（消込Ｆ）団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaiannaijyuutouym2 ztydantaiannaijyuutouym2}</td><td>（中継用）団体案内充当年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybonusharaihyouji2 ztybonusharaihyouji2}</td><td>（中継用）ボーナス払表示２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaino2 ztyannaino2}</td><td>（中継用）案内番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantaipkbn ztydantaipkbn}</td><td>（中継用）団体保険料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydantainyuukinymd ztydantainyuukinymd}</td><td>（中継用）団体入金年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfjyuutouym ztykskmfjyuutouym}</td><td>（中継用）（消込Ｆ）充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitouymd ztysuitouymd}</td><td>（中継用）出納年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuuryokuhouhoukbn ztynyuuryokuhouhoukbn}</td><td>（中継用）入力方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfnyknaiyoukbn ztykskmfnyknaiyoukbn}</td><td>（中継用）（消込Ｆ）入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekykhndnkhyouji ztykzhurikaekykhndnkhyouji}</td><td>（中継用）口座振替契約ハンド入金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfdairitencd ztykskmfdairitencd}</td><td>（中継用）（消込Ｆ）代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenuketukeno2 ztydairitenuketukeno2}</td><td>（中継用）代理店受付番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatudantaicd ztyikkatudantaicd}</td><td>（中継用）一括団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatuannaihikisariym ztyikkatuannaihikisariym}</td><td>（中継用）一括案内引去年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatuannaino ztyikkatuannaino}</td><td>（中継用）一括案内番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzaikeihrkkaisuukbn2 ztyzaikeihrkkaisuukbn2}</td><td>（中継用）財形払込回数区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzaikeikyksyano ztyzaikeikyksyano}</td><td>（中継用）財形契約者番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhasseisosikicd ztyhasseisosikicd}</td><td>（中継用）発生組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikeisakikaisyacd ztyteikeisakikaisyacd}</td><td>（中継用）提携先会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmfbankcd ztykskmfbankcd}</td><td>（中継用）（消込Ｆ）銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitousyorisosikicd ztysuitousyorisosikicd}</td><td>（中継用）出納処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaitekanjyouyomikaekbn ztyaitekanjyouyomikaekbn}</td><td>（中継用）相手勘定読替区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditcardhrkskmkbn ztycreditcardhrkskmkbn}</td><td>（中継用）クレ払消込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylastteiseiymd ztylastteiseiymd}</td><td>（中継用）最終訂正年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmkanryouymd ztykskmkanryouymd}</td><td>（中継用）消込完了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmteiseino ztykskmteiseino}</td><td>（中継用）消込訂正番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykskmkanryousijihyouji ztykskmkanryousijihyouji}</td><td>（中継用）消込完了指示表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuketuketencd ztyuketuketencd}</td><td>（中継用）受付店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycvscd ztycvscd}</td><td>（中継用）ＣＶＳコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikomiyousinyuukinkbn ztyhurikomiyousinyuukinkbn}</td><td>（中継用）振込用紙入金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikomiyousiokyksmno ztyhurikomiyousiokyksmno}</td><td>（中継用）振込用紙お客さま番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikomiyousikakuninno ztyhurikomiyousikakuninno}</td><td>（中継用）振込用紙確認番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyegsyokuinhurikomiymd ztyegsyokuinhurikomiymd}</td><td>（中継用）営業職員振込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitkaiinno ztyvitkaiinno}</td><td>（中継用）Ｖｉｔ会員番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv74 ztyyobiv74}</td><td>（中継用）予備項目Ｖ７４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KesikomiSousinCreditTy
 * @see     PKZT_KesikomiSousinCreditTy
 * @see     QZT_KesikomiSousinCreditTy
 * @see     GenQZT_KesikomiSousinCreditTy
 */
@MappedSuperclass
@Table(name=GenZT_KesikomiSousinCreditTy.TABLE_NAME)
@IdClass(value=PKZT_KesikomiSousinCreditTy.class)
public abstract class GenZT_KesikomiSousinCreditTy extends AbstractExDBEntity<ZT_KesikomiSousinCreditTy, PKZT_KesikomiSousinCreditTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KesikomiSousinCreditTy";
    public static final String ZTYKSKMSOUSINRENNO       = "ztykskmsousinrenno";
    public static final String ZTYKSKMKAMOKUCD          = "ztykskmkamokucd";
    public static final String ZTYSUITOUKBN             = "ztysuitoukbn";
    public static final String ZTYSUITOUSOSIKICD        = "ztysuitousosikicd";
    public static final String ZTYHASSEIDENYMD          = "ztyhasseidenymd";
    public static final String ZTYKARIKANJYONO          = "ztykarikanjyono";
    public static final String ZTYNKKAKUSYOUNYUURYOKUYMD1 = "ztynkkakusyounyuuryokuymd1";
    public static final String ZTYIKTANNAIDANTAIZAIKEIKBN = "ztyiktannaidantaizaikeikbn";
    public static final String ZTYKSKMFANNISKCD         = "ztykskmfanniskcd";
    public static final String ZTYDANTAIANNAIJYUUTOUYM1 = "ztydantaiannaijyuutouym1";
    public static final String ZTYANNAINO1              = "ztyannaino1";
    public static final String ZTYBONUSHARAIHYOUJI1     = "ztybonusharaihyouji1";
    public static final String ZTYKSKMFKZHURIKAEBANKCD  = "ztykskmfkzhurikaebankcd";
    public static final String ZTYKSKMFHURIKAEYMD       = "ztykskmfhurikaeymd";
    public static final String ZTYDAIRITENUKETUKENO1    = "ztydairitenuketukeno1";
    public static final String ZTYZAIKEIHRKKAISUUKBN1   = "ztyzaikeihrkkaisuukbn1";
    public static final String ZTYNOUKINHYOUNO          = "ztynoukinhyouno";
    public static final String ZTYKSKMFCREDITKAISYACD   = "ztykskmfcreditkaisyacd";
    public static final String ZTYKINYUUKIKANKBN        = "ztykinyuukikankbn";
    public static final String ZTYYOBIV18               = "ztyyobiv18";
    public static final String ZTYKSKMFSYORIYMD         = "ztykskmfsyoriymd";
    public static final String ZTYKSKMFDENYMD           = "ztykskmfdenymd";
    public static final String ZTYDENATESAKICD          = "ztydenatesakicd";
    public static final String ZTYKSKMFTAISYAKUKBN      = "ztykskmftaisyakukbn";
    public static final String ZTYHUTUUHOKENKAMOKUCD    = "ztyhutuuhokenkamokucd";
    public static final String ZTYDENGK                 = "ztydengk";
    public static final String ZTYTABAKARIKNJYKSKMDATAKBN = "ztytabakariknjykskmdatakbn";
    public static final String ZTYKSKMFRYOUSYUUYMD      = "ztykskmfryousyuuymd";
    public static final String ZTYRYOUSYUUHM            = "ztyryousyuuhm";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYNKKAKUSYOUNYUURYOKUYMD2 = "ztynkkakusyounyuuryokuymd2";
    public static final String ZTYKSKMFSYONO            = "ztykskmfsyono";
    public static final String ZTYNKHOUKOKUHYOUTANTOUKA = "ztynkhoukokuhyoutantouka";
    public static final String ZTYNKHOUKOKUHYOUKIHYOUYMD = "ztynkhoukokuhyoukihyouymd";
    public static final String ZTYNKHOUKOKUHYOUBUNKAINO = "ztynkhoukokuhyoubunkaino";
    public static final String ZTYNKKAKUSYOUNYUURYOKUNO = "ztynkkakusyounyuuryokuno";
    public static final String ZTYKSKMFDANTAICD         = "ztykskmfdantaicd";
    public static final String ZTYDANTAIANNAIJYUUTOUYM2 = "ztydantaiannaijyuutouym2";
    public static final String ZTYBONUSHARAIHYOUJI2     = "ztybonusharaihyouji2";
    public static final String ZTYANNAINO2              = "ztyannaino2";
    public static final String ZTYDANTAIPKBN            = "ztydantaipkbn";
    public static final String ZTYDANTAINYUUKINYMD      = "ztydantainyuukinymd";
    public static final String ZTYKSKMFJYUUTOUYM        = "ztykskmfjyuutouym";
    public static final String ZTYSUITOUYMD             = "ztysuitouymd";
    public static final String ZTYNYUURYOKUHOUHOUKBN    = "ztynyuuryokuhouhoukbn";
    public static final String ZTYKSKMFNYKNAIYOUKBN     = "ztykskmfnyknaiyoukbn";
    public static final String ZTYKZHURIKAEKYKHNDNKHYOUJI = "ztykzhurikaekykhndnkhyouji";
    public static final String ZTYKSKMFDAIRITENCD       = "ztykskmfdairitencd";
    public static final String ZTYDAIRITENUKETUKENO2    = "ztydairitenuketukeno2";
    public static final String ZTYIKKATUDANTAICD        = "ztyikkatudantaicd";
    public static final String ZTYIKKATUANNAIHIKISARIYM = "ztyikkatuannaihikisariym";
    public static final String ZTYIKKATUANNAINO         = "ztyikkatuannaino";
    public static final String ZTYZAIKEIHRKKAISUUKBN2   = "ztyzaikeihrkkaisuukbn2";
    public static final String ZTYZAIKEIKYKSYANO        = "ztyzaikeikyksyano";
    public static final String ZTYHASSEISOSIKICD        = "ztyhasseisosikicd";
    public static final String ZTYTEIKEISAKIKAISYACD    = "ztyteikeisakikaisyacd";
    public static final String ZTYKSKMFBANKCD           = "ztykskmfbankcd";
    public static final String ZTYSUITOUSYORISOSIKICD   = "ztysuitousyorisosikicd";
    public static final String ZTYAITEKANJYOUYOMIKAEKBN = "ztyaitekanjyouyomikaekbn";
    public static final String ZTYCREDITCARDHRKSKMKBN   = "ztycreditcardhrkskmkbn";
    public static final String ZTYLASTTEISEIYMD         = "ztylastteiseiymd";
    public static final String ZTYKSKMKANRYOUYMD        = "ztykskmkanryouymd";
    public static final String ZTYKSKMTEISEINO          = "ztykskmteiseino";
    public static final String ZTYKSKMKANRYOUSIJIHYOUJI = "ztykskmkanryousijihyouji";
    public static final String ZTYUKETUKETENCD          = "ztyuketuketencd";
    public static final String ZTYCVSCD                 = "ztycvscd";
    public static final String ZTYHURIKOMIYOUSINYUUKINKBN = "ztyhurikomiyousinyuukinkbn";
    public static final String ZTYHURIKOMIYOUSIOKYKSMNO = "ztyhurikomiyousiokyksmno";
    public static final String ZTYHURIKOMIYOUSIKAKUNINNO = "ztyhurikomiyousikakuninno";
    public static final String ZTYEGSYOKUINHURIKOMIYMD  = "ztyegsyokuinhurikomiymd";
    public static final String ZTYVITKAIINNO            = "ztyvitkaiinno";
    public static final String ZTYYOBIV74               = "ztyyobiv74";

    private final PKZT_KesikomiSousinCreditTy primaryKey;

    public GenZT_KesikomiSousinCreditTy() {
        primaryKey = new PKZT_KesikomiSousinCreditTy();
    }

    public GenZT_KesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        primaryKey = new PKZT_KesikomiSousinCreditTy(pZtykskmsousinrenno, pZtykskmfsyoriymd);
    }

    @Transient
    @Override
    public PKZT_KesikomiSousinCreditTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KesikomiSousinCreditTy> getMetaClass() {
        return QZT_KesikomiSousinCreditTy.class;
    }

    @Id
    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMSOUSINRENNO)
    public String getZtykskmsousinrenno() {
        return getPrimaryKey().getZtykskmsousinrenno();
    }

    public void setZtykskmsousinrenno(String pZtykskmsousinrenno) {
        getPrimaryKey().setZtykskmsousinrenno(pZtykskmsousinrenno);
    }

    private String ztykskmkamokucd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMKAMOKUCD)
    public String getZtykskmkamokucd() {
        return ztykskmkamokucd;
    }

    public void setZtykskmkamokucd(String pZtykskmkamokucd) {
        ztykskmkamokucd = pZtykskmkamokucd;
    }

    private String ztysuitoukbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYSUITOUKBN)
    public String getZtysuitoukbn() {
        return ztysuitoukbn;
    }

    public void setZtysuitoukbn(String pZtysuitoukbn) {
        ztysuitoukbn = pZtysuitoukbn;
    }

    private String ztysuitousosikicd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYSUITOUSOSIKICD)
    public String getZtysuitousosikicd() {
        return ztysuitousosikicd;
    }

    public void setZtysuitousosikicd(String pZtysuitousosikicd) {
        ztysuitousosikicd = pZtysuitousosikicd;
    }

    private String ztyhasseidenymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYHASSEIDENYMD)
    public String getZtyhasseidenymd() {
        return ztyhasseidenymd;
    }

    public void setZtyhasseidenymd(String pZtyhasseidenymd) {
        ztyhasseidenymd = pZtyhasseidenymd;
    }

    private String ztykarikanjyono;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKARIKANJYONO)
    public String getZtykarikanjyono() {
        return ztykarikanjyono;
    }

    public void setZtykarikanjyono(String pZtykarikanjyono) {
        ztykarikanjyono = pZtykarikanjyono;
    }

    private String ztynkkakusyounyuuryokuymd1;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNKKAKUSYOUNYUURYOKUYMD1)
    public String getZtynkkakusyounyuuryokuymd1() {
        return ztynkkakusyounyuuryokuymd1;
    }

    public void setZtynkkakusyounyuuryokuymd1(String pZtynkkakusyounyuuryokuymd1) {
        ztynkkakusyounyuuryokuymd1 = pZtynkkakusyounyuuryokuymd1;
    }

    private String ztyiktannaidantaizaikeikbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYIKTANNAIDANTAIZAIKEIKBN)
    public String getZtyiktannaidantaizaikeikbn() {
        return ztyiktannaidantaizaikeikbn;
    }

    public void setZtyiktannaidantaizaikeikbn(String pZtyiktannaidantaizaikeikbn) {
        ztyiktannaidantaizaikeikbn = pZtyiktannaidantaizaikeikbn;
    }

    private String ztykskmfanniskcd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFANNISKCD)
    public String getZtykskmfanniskcd() {
        return ztykskmfanniskcd;
    }

    public void setZtykskmfanniskcd(String pZtykskmfanniskcd) {
        ztykskmfanniskcd = pZtykskmfanniskcd;
    }

    private String ztydantaiannaijyuutouym1;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDANTAIANNAIJYUUTOUYM1)
    public String getZtydantaiannaijyuutouym1() {
        return ztydantaiannaijyuutouym1;
    }

    public void setZtydantaiannaijyuutouym1(String pZtydantaiannaijyuutouym1) {
        ztydantaiannaijyuutouym1 = pZtydantaiannaijyuutouym1;
    }

    private String ztyannaino1;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYANNAINO1)
    public String getZtyannaino1() {
        return ztyannaino1;
    }

    public void setZtyannaino1(String pZtyannaino1) {
        ztyannaino1 = pZtyannaino1;
    }

    private String ztybonusharaihyouji1;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYBONUSHARAIHYOUJI1)
    public String getZtybonusharaihyouji1() {
        return ztybonusharaihyouji1;
    }

    public void setZtybonusharaihyouji1(String pZtybonusharaihyouji1) {
        ztybonusharaihyouji1 = pZtybonusharaihyouji1;
    }

    private String ztykskmfkzhurikaebankcd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFKZHURIKAEBANKCD)
    public String getZtykskmfkzhurikaebankcd() {
        return ztykskmfkzhurikaebankcd;
    }

    public void setZtykskmfkzhurikaebankcd(String pZtykskmfkzhurikaebankcd) {
        ztykskmfkzhurikaebankcd = pZtykskmfkzhurikaebankcd;
    }

    private String ztykskmfhurikaeymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFHURIKAEYMD)
    public String getZtykskmfhurikaeymd() {
        return ztykskmfhurikaeymd;
    }

    public void setZtykskmfhurikaeymd(String pZtykskmfhurikaeymd) {
        ztykskmfhurikaeymd = pZtykskmfhurikaeymd;
    }

    private String ztydairitenuketukeno1;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDAIRITENUKETUKENO1)
    public String getZtydairitenuketukeno1() {
        return ztydairitenuketukeno1;
    }

    public void setZtydairitenuketukeno1(String pZtydairitenuketukeno1) {
        ztydairitenuketukeno1 = pZtydairitenuketukeno1;
    }

    private String ztyzaikeihrkkaisuukbn1;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYZAIKEIHRKKAISUUKBN1)
    public String getZtyzaikeihrkkaisuukbn1() {
        return ztyzaikeihrkkaisuukbn1;
    }

    public void setZtyzaikeihrkkaisuukbn1(String pZtyzaikeihrkkaisuukbn1) {
        ztyzaikeihrkkaisuukbn1 = pZtyzaikeihrkkaisuukbn1;
    }

    private String ztynoukinhyouno;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNOUKINHYOUNO)
    public String getZtynoukinhyouno() {
        return ztynoukinhyouno;
    }

    public void setZtynoukinhyouno(String pZtynoukinhyouno) {
        ztynoukinhyouno = pZtynoukinhyouno;
    }

    private String ztykskmfcreditkaisyacd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFCREDITKAISYACD)
    public String getZtykskmfcreditkaisyacd() {
        return ztykskmfcreditkaisyacd;
    }

    public void setZtykskmfcreditkaisyacd(String pZtykskmfcreditkaisyacd) {
        ztykskmfcreditkaisyacd = pZtykskmfcreditkaisyacd;
    }

    private String ztykinyuukikankbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKINYUUKIKANKBN)
    public String getZtykinyuukikankbn() {
        return ztykinyuukikankbn;
    }

    public void setZtykinyuukikankbn(String pZtykinyuukikankbn) {
        ztykinyuukikankbn = pZtykinyuukikankbn;
    }

    private String ztyyobiv18;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYYOBIV18)
    public String getZtyyobiv18() {
        return ztyyobiv18;
    }

    public void setZtyyobiv18(String pZtyyobiv18) {
        ztyyobiv18 = pZtyyobiv18;
    }

    @Id
    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFSYORIYMD)
    public String getZtykskmfsyoriymd() {
        return getPrimaryKey().getZtykskmfsyoriymd();
    }

    public void setZtykskmfsyoriymd(String pZtykskmfsyoriymd) {
        getPrimaryKey().setZtykskmfsyoriymd(pZtykskmfsyoriymd);
    }

    private String ztykskmfdenymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFDENYMD)
    public String getZtykskmfdenymd() {
        return ztykskmfdenymd;
    }

    public void setZtykskmfdenymd(String pZtykskmfdenymd) {
        ztykskmfdenymd = pZtykskmfdenymd;
    }

    private String ztydenatesakicd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDENATESAKICD)
    public String getZtydenatesakicd() {
        return ztydenatesakicd;
    }

    public void setZtydenatesakicd(String pZtydenatesakicd) {
        ztydenatesakicd = pZtydenatesakicd;
    }

    private String ztykskmftaisyakukbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFTAISYAKUKBN)
    public String getZtykskmftaisyakukbn() {
        return ztykskmftaisyakukbn;
    }

    public void setZtykskmftaisyakukbn(String pZtykskmftaisyakukbn) {
        ztykskmftaisyakukbn = pZtykskmftaisyakukbn;
    }

    private String ztyhutuuhokenkamokucd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYHUTUUHOKENKAMOKUCD)
    public String getZtyhutuuhokenkamokucd() {
        return ztyhutuuhokenkamokucd;
    }

    public void setZtyhutuuhokenkamokucd(String pZtyhutuuhokenkamokucd) {
        ztyhutuuhokenkamokucd = pZtyhutuuhokenkamokucd;
    }

    private Long ztydengk;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDENGK)
    public Long getZtydengk() {
        return ztydengk;
    }

    public void setZtydengk(Long pZtydengk) {
        ztydengk = pZtydengk;
    }

    private String ztytabakariknjykskmdatakbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYTABAKARIKNJYKSKMDATAKBN)
    public String getZtytabakariknjykskmdatakbn() {
        return ztytabakariknjykskmdatakbn;
    }

    public void setZtytabakariknjykskmdatakbn(String pZtytabakariknjykskmdatakbn) {
        ztytabakariknjykskmdatakbn = pZtytabakariknjykskmdatakbn;
    }

    private String ztykskmfryousyuuymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFRYOUSYUUYMD)
    public String getZtykskmfryousyuuymd() {
        return ztykskmfryousyuuymd;
    }

    public void setZtykskmfryousyuuymd(String pZtykskmfryousyuuymd) {
        ztykskmfryousyuuymd = pZtykskmfryousyuuymd;
    }

    private String ztyryousyuuhm;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYRYOUSYUUHM)
    public String getZtyryousyuuhm() {
        return ztyryousyuuhm;
    }

    public void setZtyryousyuuhm(String pZtyryousyuuhm) {
        ztyryousyuuhm = pZtyryousyuuhm;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztynkkakusyounyuuryokuymd2;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNKKAKUSYOUNYUURYOKUYMD2)
    public String getZtynkkakusyounyuuryokuymd2() {
        return ztynkkakusyounyuuryokuymd2;
    }

    public void setZtynkkakusyounyuuryokuymd2(String pZtynkkakusyounyuuryokuymd2) {
        ztynkkakusyounyuuryokuymd2 = pZtynkkakusyounyuuryokuymd2;
    }

    private String ztykskmfsyono;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFSYONO)
    public String getZtykskmfsyono() {
        return ztykskmfsyono;
    }

    public void setZtykskmfsyono(String pZtykskmfsyono) {
        ztykskmfsyono = pZtykskmfsyono;
    }

    private String ztynkhoukokuhyoutantouka;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNKHOUKOKUHYOUTANTOUKA)
    public String getZtynkhoukokuhyoutantouka() {
        return ztynkhoukokuhyoutantouka;
    }

    public void setZtynkhoukokuhyoutantouka(String pZtynkhoukokuhyoutantouka) {
        ztynkhoukokuhyoutantouka = pZtynkhoukokuhyoutantouka;
    }

    private String ztynkhoukokuhyoukihyouymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNKHOUKOKUHYOUKIHYOUYMD)
    public String getZtynkhoukokuhyoukihyouymd() {
        return ztynkhoukokuhyoukihyouymd;
    }

    public void setZtynkhoukokuhyoukihyouymd(String pZtynkhoukokuhyoukihyouymd) {
        ztynkhoukokuhyoukihyouymd = pZtynkhoukokuhyoukihyouymd;
    }

    private String ztynkhoukokuhyoubunkaino;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNKHOUKOKUHYOUBUNKAINO)
    public String getZtynkhoukokuhyoubunkaino() {
        return ztynkhoukokuhyoubunkaino;
    }

    public void setZtynkhoukokuhyoubunkaino(String pZtynkhoukokuhyoubunkaino) {
        ztynkhoukokuhyoubunkaino = pZtynkhoukokuhyoubunkaino;
    }

    private String ztynkkakusyounyuuryokuno;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNKKAKUSYOUNYUURYOKUNO)
    public String getZtynkkakusyounyuuryokuno() {
        return ztynkkakusyounyuuryokuno;
    }

    public void setZtynkkakusyounyuuryokuno(String pZtynkkakusyounyuuryokuno) {
        ztynkkakusyounyuuryokuno = pZtynkkakusyounyuuryokuno;
    }

    private String ztykskmfdantaicd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFDANTAICD)
    public String getZtykskmfdantaicd() {
        return ztykskmfdantaicd;
    }

    public void setZtykskmfdantaicd(String pZtykskmfdantaicd) {
        ztykskmfdantaicd = pZtykskmfdantaicd;
    }

    private String ztydantaiannaijyuutouym2;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDANTAIANNAIJYUUTOUYM2)
    public String getZtydantaiannaijyuutouym2() {
        return ztydantaiannaijyuutouym2;
    }

    public void setZtydantaiannaijyuutouym2(String pZtydantaiannaijyuutouym2) {
        ztydantaiannaijyuutouym2 = pZtydantaiannaijyuutouym2;
    }

    private String ztybonusharaihyouji2;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYBONUSHARAIHYOUJI2)
    public String getZtybonusharaihyouji2() {
        return ztybonusharaihyouji2;
    }

    public void setZtybonusharaihyouji2(String pZtybonusharaihyouji2) {
        ztybonusharaihyouji2 = pZtybonusharaihyouji2;
    }

    private String ztyannaino2;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYANNAINO2)
    public String getZtyannaino2() {
        return ztyannaino2;
    }

    public void setZtyannaino2(String pZtyannaino2) {
        ztyannaino2 = pZtyannaino2;
    }

    private String ztydantaipkbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDANTAIPKBN)
    public String getZtydantaipkbn() {
        return ztydantaipkbn;
    }

    public void setZtydantaipkbn(String pZtydantaipkbn) {
        ztydantaipkbn = pZtydantaipkbn;
    }

    private String ztydantainyuukinymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDANTAINYUUKINYMD)
    public String getZtydantainyuukinymd() {
        return ztydantainyuukinymd;
    }

    public void setZtydantainyuukinymd(String pZtydantainyuukinymd) {
        ztydantainyuukinymd = pZtydantainyuukinymd;
    }

    private String ztykskmfjyuutouym;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFJYUUTOUYM)
    public String getZtykskmfjyuutouym() {
        return ztykskmfjyuutouym;
    }

    public void setZtykskmfjyuutouym(String pZtykskmfjyuutouym) {
        ztykskmfjyuutouym = pZtykskmfjyuutouym;
    }

    private String ztysuitouymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYSUITOUYMD)
    public String getZtysuitouymd() {
        return ztysuitouymd;
    }

    public void setZtysuitouymd(String pZtysuitouymd) {
        ztysuitouymd = pZtysuitouymd;
    }

    private String ztynyuuryokuhouhoukbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYNYUURYOKUHOUHOUKBN)
    public String getZtynyuuryokuhouhoukbn() {
        return ztynyuuryokuhouhoukbn;
    }

    public void setZtynyuuryokuhouhoukbn(String pZtynyuuryokuhouhoukbn) {
        ztynyuuryokuhouhoukbn = pZtynyuuryokuhouhoukbn;
    }

    private String ztykskmfnyknaiyoukbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFNYKNAIYOUKBN)
    public String getZtykskmfnyknaiyoukbn() {
        return ztykskmfnyknaiyoukbn;
    }

    public void setZtykskmfnyknaiyoukbn(String pZtykskmfnyknaiyoukbn) {
        ztykskmfnyknaiyoukbn = pZtykskmfnyknaiyoukbn;
    }

    private String ztykzhurikaekykhndnkhyouji;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKZHURIKAEKYKHNDNKHYOUJI)
    public String getZtykzhurikaekykhndnkhyouji() {
        return ztykzhurikaekykhndnkhyouji;
    }

    public void setZtykzhurikaekykhndnkhyouji(String pZtykzhurikaekykhndnkhyouji) {
        ztykzhurikaekykhndnkhyouji = pZtykzhurikaekykhndnkhyouji;
    }

    private String ztykskmfdairitencd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFDAIRITENCD)
    public String getZtykskmfdairitencd() {
        return ztykskmfdairitencd;
    }

    public void setZtykskmfdairitencd(String pZtykskmfdairitencd) {
        ztykskmfdairitencd = pZtykskmfdairitencd;
    }

    private String ztydairitenuketukeno2;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYDAIRITENUKETUKENO2)
    public String getZtydairitenuketukeno2() {
        return ztydairitenuketukeno2;
    }

    public void setZtydairitenuketukeno2(String pZtydairitenuketukeno2) {
        ztydairitenuketukeno2 = pZtydairitenuketukeno2;
    }

    private String ztyikkatudantaicd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYIKKATUDANTAICD)
    public String getZtyikkatudantaicd() {
        return ztyikkatudantaicd;
    }

    public void setZtyikkatudantaicd(String pZtyikkatudantaicd) {
        ztyikkatudantaicd = pZtyikkatudantaicd;
    }

    private String ztyikkatuannaihikisariym;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYIKKATUANNAIHIKISARIYM)
    public String getZtyikkatuannaihikisariym() {
        return ztyikkatuannaihikisariym;
    }

    public void setZtyikkatuannaihikisariym(String pZtyikkatuannaihikisariym) {
        ztyikkatuannaihikisariym = pZtyikkatuannaihikisariym;
    }

    private String ztyikkatuannaino;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYIKKATUANNAINO)
    public String getZtyikkatuannaino() {
        return ztyikkatuannaino;
    }

    public void setZtyikkatuannaino(String pZtyikkatuannaino) {
        ztyikkatuannaino = pZtyikkatuannaino;
    }

    private String ztyzaikeihrkkaisuukbn2;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYZAIKEIHRKKAISUUKBN2)
    public String getZtyzaikeihrkkaisuukbn2() {
        return ztyzaikeihrkkaisuukbn2;
    }

    public void setZtyzaikeihrkkaisuukbn2(String pZtyzaikeihrkkaisuukbn2) {
        ztyzaikeihrkkaisuukbn2 = pZtyzaikeihrkkaisuukbn2;
    }

    private String ztyzaikeikyksyano;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYZAIKEIKYKSYANO)
    public String getZtyzaikeikyksyano() {
        return ztyzaikeikyksyano;
    }

    public void setZtyzaikeikyksyano(String pZtyzaikeikyksyano) {
        ztyzaikeikyksyano = pZtyzaikeikyksyano;
    }

    private String ztyhasseisosikicd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYHASSEISOSIKICD)
    public String getZtyhasseisosikicd() {
        return ztyhasseisosikicd;
    }

    public void setZtyhasseisosikicd(String pZtyhasseisosikicd) {
        ztyhasseisosikicd = pZtyhasseisosikicd;
    }

    private String ztyteikeisakikaisyacd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYTEIKEISAKIKAISYACD)
    public String getZtyteikeisakikaisyacd() {
        return ztyteikeisakikaisyacd;
    }

    public void setZtyteikeisakikaisyacd(String pZtyteikeisakikaisyacd) {
        ztyteikeisakikaisyacd = pZtyteikeisakikaisyacd;
    }

    private String ztykskmfbankcd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMFBANKCD)
    public String getZtykskmfbankcd() {
        return ztykskmfbankcd;
    }

    public void setZtykskmfbankcd(String pZtykskmfbankcd) {
        ztykskmfbankcd = pZtykskmfbankcd;
    }

    private String ztysuitousyorisosikicd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYSUITOUSYORISOSIKICD)
    public String getZtysuitousyorisosikicd() {
        return ztysuitousyorisosikicd;
    }

    public void setZtysuitousyorisosikicd(String pZtysuitousyorisosikicd) {
        ztysuitousyorisosikicd = pZtysuitousyorisosikicd;
    }

    private String ztyaitekanjyouyomikaekbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYAITEKANJYOUYOMIKAEKBN)
    public String getZtyaitekanjyouyomikaekbn() {
        return ztyaitekanjyouyomikaekbn;
    }

    public void setZtyaitekanjyouyomikaekbn(String pZtyaitekanjyouyomikaekbn) {
        ztyaitekanjyouyomikaekbn = pZtyaitekanjyouyomikaekbn;
    }

    private String ztycreditcardhrkskmkbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYCREDITCARDHRKSKMKBN)
    public String getZtycreditcardhrkskmkbn() {
        return ztycreditcardhrkskmkbn;
    }

    public void setZtycreditcardhrkskmkbn(String pZtycreditcardhrkskmkbn) {
        ztycreditcardhrkskmkbn = pZtycreditcardhrkskmkbn;
    }

    private String ztylastteiseiymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYLASTTEISEIYMD)
    public String getZtylastteiseiymd() {
        return ztylastteiseiymd;
    }

    public void setZtylastteiseiymd(String pZtylastteiseiymd) {
        ztylastteiseiymd = pZtylastteiseiymd;
    }

    private String ztykskmkanryouymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMKANRYOUYMD)
    public String getZtykskmkanryouymd() {
        return ztykskmkanryouymd;
    }

    public void setZtykskmkanryouymd(String pZtykskmkanryouymd) {
        ztykskmkanryouymd = pZtykskmkanryouymd;
    }

    private String ztykskmteiseino;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMTEISEINO)
    public String getZtykskmteiseino() {
        return ztykskmteiseino;
    }

    public void setZtykskmteiseino(String pZtykskmteiseino) {
        ztykskmteiseino = pZtykskmteiseino;
    }

    private String ztykskmkanryousijihyouji;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYKSKMKANRYOUSIJIHYOUJI)
    public String getZtykskmkanryousijihyouji() {
        return ztykskmkanryousijihyouji;
    }

    public void setZtykskmkanryousijihyouji(String pZtykskmkanryousijihyouji) {
        ztykskmkanryousijihyouji = pZtykskmkanryousijihyouji;
    }

    private String ztyuketuketencd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYUKETUKETENCD)
    public String getZtyuketuketencd() {
        return ztyuketuketencd;
    }

    public void setZtyuketuketencd(String pZtyuketuketencd) {
        ztyuketuketencd = pZtyuketuketencd;
    }

    private String ztycvscd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYCVSCD)
    public String getZtycvscd() {
        return ztycvscd;
    }

    public void setZtycvscd(String pZtycvscd) {
        ztycvscd = pZtycvscd;
    }

    private String ztyhurikomiyousinyuukinkbn;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYHURIKOMIYOUSINYUUKINKBN)
    public String getZtyhurikomiyousinyuukinkbn() {
        return ztyhurikomiyousinyuukinkbn;
    }

    public void setZtyhurikomiyousinyuukinkbn(String pZtyhurikomiyousinyuukinkbn) {
        ztyhurikomiyousinyuukinkbn = pZtyhurikomiyousinyuukinkbn;
    }

    private String ztyhurikomiyousiokyksmno;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYHURIKOMIYOUSIOKYKSMNO)
    public String getZtyhurikomiyousiokyksmno() {
        return ztyhurikomiyousiokyksmno;
    }

    public void setZtyhurikomiyousiokyksmno(String pZtyhurikomiyousiokyksmno) {
        ztyhurikomiyousiokyksmno = pZtyhurikomiyousiokyksmno;
    }

    private String ztyhurikomiyousikakuninno;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYHURIKOMIYOUSIKAKUNINNO)
    public String getZtyhurikomiyousikakuninno() {
        return ztyhurikomiyousikakuninno;
    }

    public void setZtyhurikomiyousikakuninno(String pZtyhurikomiyousikakuninno) {
        ztyhurikomiyousikakuninno = pZtyhurikomiyousikakuninno;
    }

    private String ztyegsyokuinhurikomiymd;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYEGSYOKUINHURIKOMIYMD)
    public String getZtyegsyokuinhurikomiymd() {
        return ztyegsyokuinhurikomiymd;
    }

    public void setZtyegsyokuinhurikomiymd(String pZtyegsyokuinhurikomiymd) {
        ztyegsyokuinhurikomiymd = pZtyegsyokuinhurikomiymd;
    }

    private String ztyvitkaiinno;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYVITKAIINNO)
    public String getZtyvitkaiinno() {
        return ztyvitkaiinno;
    }

    public void setZtyvitkaiinno(String pZtyvitkaiinno) {
        ztyvitkaiinno = pZtyvitkaiinno;
    }

    private String ztyyobiv74;

    @Column(name=GenZT_KesikomiSousinCreditTy.ZTYYOBIV74)
    public String getZtyyobiv74() {
        return ztyyobiv74;
    }

    public void setZtyyobiv74(String pZtyyobiv74) {
        ztyyobiv74 = pZtyyobiv74;
    }
}