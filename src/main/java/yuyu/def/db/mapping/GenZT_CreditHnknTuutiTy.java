package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_CreditHnknTuutiTy;
import yuyu.def.db.id.PKZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.GenQZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.QZT_CreditHnknTuutiTy;

/**
 * クレカ返金通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_CreditHnknTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_CreditHnknTuutiTy}</td><td colspan="3">クレカ返金通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_CreditHnknTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_CreditHnknTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_CreditHnknTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv14 ztyyobiv14}</td><td>（中継用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10 ztyansyuyouyobin10}</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkj ztyshsnmkj}</td><td>（中継用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43 ztyyobiv43}</td><td>（中継用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x2 ztyansyuyouyobin10x2}</td><td>（中継用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj ztytawadr3kj}</td><td>（中継用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelnov14 ztytawtelnov14}</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1 ztytawteluktkkanou1}</td><td>（中継用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2 ztytawteluktkkanou2}</td><td>（中継用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawsosikinmkj ztydai2tawsosikinmkj}</td><td>（中継用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawtelno ztydai2tawtelno}</td><td>（中継用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakunm15keta ztysakunm15keta}</td><td>（中継用）作成番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv62 ztyyobiv62}</td><td>（中継用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon1 ztyhnknmsgmongon1}</td><td>（中継用）返金メッセージ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon2 ztyhnknmsgmongon2}</td><td>（中継用）返金メッセージ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon3 ztyhnknmsgmongon3}</td><td>（中継用）返金メッセージ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon4 ztyhnknmsgmongon4}</td><td>（中継用）返金メッセージ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon5 ztyhnknmsgmongon5}</td><td>（中継用）返金メッセージ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon6 ztyhnknmsgmongon6}</td><td>（中継用）返金メッセージ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon7 ztyhnknmsgmongon7}</td><td>（中継用）返金メッセージ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon8 ztyhnknmsgmongon8}</td><td>（中継用）返金メッセージ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon9 ztyhnknmsgmongon9}</td><td>（中継用）返金メッセージ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsgmongon10 ztyhnknmsgmongon10}</td><td>（中継用）返金メッセージ文言１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv128 ztyyobiv128}</td><td>（中継用）予備項目Ｖ１２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutisakuseiymdv32 ztytuutisakuseiymdv32}</td><td>（中継用）通知作成年月日Ｖ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv64 ztyyobiv64}</td><td>（中継用）予備項目Ｖ６４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon1 ztyhnknnaiyoumongon1}</td><td>（中継用）返金内容文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon2 ztyhnknnaiyoumongon2}</td><td>（中継用）返金内容文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon3 ztyhnknnaiyoumongon3}</td><td>（中継用）返金内容文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon4 ztyhnknnaiyoumongon4}</td><td>（中継用）返金内容文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon5 ztyhnknnaiyoumongon5}</td><td>（中継用）返金内容文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon6 ztyhnknnaiyoumongon6}</td><td>（中継用）返金内容文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon7 ztyhnknnaiyoumongon7}</td><td>（中継用）返金内容文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknnaiyoumongon8 ztyhnknnaiyoumongon8}</td><td>（中継用）返金内容文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv128x2 ztyyobiv128x2}</td><td>（中継用）予備項目Ｖ１２８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x6 ztyansyuyouyobin10x6}</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk1 ztyhnknmsghsk1}</td><td>（中継用）返金メッセージ補足１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk2 ztyhnknmsghsk2}</td><td>（中継用）返金メッセージ補足２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk3 ztyhnknmsghsk3}</td><td>（中継用）返金メッセージ補足３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk4 ztyhnknmsghsk4}</td><td>（中継用）返金メッセージ補足４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk5 ztyhnknmsghsk5}</td><td>（中継用）返金メッセージ補足５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk6 ztyhnknmsghsk6}</td><td>（中継用）返金メッセージ補足６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk7 ztyhnknmsghsk7}</td><td>（中継用）返金メッセージ補足７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk8 ztyhnknmsghsk8}</td><td>（中継用）返金メッセージ補足８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk9 ztyhnknmsghsk9}</td><td>（中継用）返金メッセージ補足９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk10 ztyhnknmsghsk10}</td><td>（中継用）返金メッセージ補足１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk11 ztyhnknmsghsk11}</td><td>（中継用）返金メッセージ補足１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk12 ztyhnknmsghsk12}</td><td>（中継用）返金メッセージ補足１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk13 ztyhnknmsghsk13}</td><td>（中継用）返金メッセージ補足１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk14 ztyhnknmsghsk14}</td><td>（中継用）返金メッセージ補足１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk15 ztyhnknmsghsk15}</td><td>（中継用）返金メッセージ補足１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk16 ztyhnknmsghsk16}</td><td>（中継用）返金メッセージ補足１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk17 ztyhnknmsghsk17}</td><td>（中継用）返金メッセージ補足１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk18 ztyhnknmsghsk18}</td><td>（中継用）返金メッセージ補足１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk19 ztyhnknmsghsk19}</td><td>（中継用）返金メッセージ補足１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnknmsghsk20 ztyhnknmsghsk20}</td><td>（中継用）返金メッセージ補足２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv128x3 ztyyobiv128x3}</td><td>（中継用）予備項目Ｖ１２８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x7 ztyansyuyouyobin10x7}</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_CreditHnknTuutiTy
 * @see     PKZT_CreditHnknTuutiTy
 * @see     QZT_CreditHnknTuutiTy
 * @see     GenQZT_CreditHnknTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_CreditHnknTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_CreditHnknTuutiTy.class)
public abstract class GenZT_CreditHnknTuutiTy extends AbstractExDBEntity<ZT_CreditHnknTuutiTy, PKZT_CreditHnknTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_CreditHnknTuutiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYYOBIV14               = "ztyyobiv14";
    public static final String ZTYANSYUYOUYOBIN10       = "ztyansyuyouyobin10";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJ               = "ztyshsnmkj";
    public static final String ZTYYOBIV43               = "ztyyobiv43";
    public static final String ZTYANSYUYOUYOBIN10X2     = "ztyansyuyouyobin10x2";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTAWADR3KJ             = "ztytawadr3kj";
    public static final String ZTYTAWTELNOV14           = "ztytawtelnov14";
    public static final String ZTYTAWTELUKTKKANOU1      = "ztytawteluktkkanou1";
    public static final String ZTYTAWTELUKTKKANOU2      = "ztytawteluktkkanou2";
    public static final String ZTYDAI2TAWSOSIKINMKJ     = "ztydai2tawsosikinmkj";
    public static final String ZTYDAI2TAWTELNO          = "ztydai2tawtelno";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYSAKUNM15KETA          = "ztysakunm15keta";
    public static final String ZTYYOBIV62               = "ztyyobiv62";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYHNKNMSGMONGON1        = "ztyhnknmsgmongon1";
    public static final String ZTYHNKNMSGMONGON2        = "ztyhnknmsgmongon2";
    public static final String ZTYHNKNMSGMONGON3        = "ztyhnknmsgmongon3";
    public static final String ZTYHNKNMSGMONGON4        = "ztyhnknmsgmongon4";
    public static final String ZTYHNKNMSGMONGON5        = "ztyhnknmsgmongon5";
    public static final String ZTYHNKNMSGMONGON6        = "ztyhnknmsgmongon6";
    public static final String ZTYHNKNMSGMONGON7        = "ztyhnknmsgmongon7";
    public static final String ZTYHNKNMSGMONGON8        = "ztyhnknmsgmongon8";
    public static final String ZTYHNKNMSGMONGON9        = "ztyhnknmsgmongon9";
    public static final String ZTYHNKNMSGMONGON10       = "ztyhnknmsgmongon10";
    public static final String ZTYYOBIV128              = "ztyyobiv128";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYTUUTISAKUSEIYMDV32    = "ztytuutisakuseiymdv32";
    public static final String ZTYYOBIV64               = "ztyyobiv64";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";
    public static final String ZTYHNKNNAIYOUMONGON1     = "ztyhnknnaiyoumongon1";
    public static final String ZTYHNKNNAIYOUMONGON2     = "ztyhnknnaiyoumongon2";
    public static final String ZTYHNKNNAIYOUMONGON3     = "ztyhnknnaiyoumongon3";
    public static final String ZTYHNKNNAIYOUMONGON4     = "ztyhnknnaiyoumongon4";
    public static final String ZTYHNKNNAIYOUMONGON5     = "ztyhnknnaiyoumongon5";
    public static final String ZTYHNKNNAIYOUMONGON6     = "ztyhnknnaiyoumongon6";
    public static final String ZTYHNKNNAIYOUMONGON7     = "ztyhnknnaiyoumongon7";
    public static final String ZTYHNKNNAIYOUMONGON8     = "ztyhnknnaiyoumongon8";
    public static final String ZTYYOBIV128X2            = "ztyyobiv128x2";
    public static final String ZTYANSYUYOUYOBIN10X6     = "ztyansyuyouyobin10x6";
    public static final String ZTYHNKNMSGHSK1           = "ztyhnknmsghsk1";
    public static final String ZTYHNKNMSGHSK2           = "ztyhnknmsghsk2";
    public static final String ZTYHNKNMSGHSK3           = "ztyhnknmsghsk3";
    public static final String ZTYHNKNMSGHSK4           = "ztyhnknmsghsk4";
    public static final String ZTYHNKNMSGHSK5           = "ztyhnknmsghsk5";
    public static final String ZTYHNKNMSGHSK6           = "ztyhnknmsghsk6";
    public static final String ZTYHNKNMSGHSK7           = "ztyhnknmsghsk7";
    public static final String ZTYHNKNMSGHSK8           = "ztyhnknmsghsk8";
    public static final String ZTYHNKNMSGHSK9           = "ztyhnknmsghsk9";
    public static final String ZTYHNKNMSGHSK10          = "ztyhnknmsghsk10";
    public static final String ZTYHNKNMSGHSK11          = "ztyhnknmsghsk11";
    public static final String ZTYHNKNMSGHSK12          = "ztyhnknmsghsk12";
    public static final String ZTYHNKNMSGHSK13          = "ztyhnknmsghsk13";
    public static final String ZTYHNKNMSGHSK14          = "ztyhnknmsghsk14";
    public static final String ZTYHNKNMSGHSK15          = "ztyhnknmsghsk15";
    public static final String ZTYHNKNMSGHSK16          = "ztyhnknmsghsk16";
    public static final String ZTYHNKNMSGHSK17          = "ztyhnknmsghsk17";
    public static final String ZTYHNKNMSGHSK18          = "ztyhnknmsghsk18";
    public static final String ZTYHNKNMSGHSK19          = "ztyhnknmsghsk19";
    public static final String ZTYHNKNMSGHSK20          = "ztyhnknmsghsk20";
    public static final String ZTYYOBIV128X3            = "ztyyobiv128x3";
    public static final String ZTYANSYUYOUYOBIN10X7     = "ztyansyuyouyobin10x7";

    private final PKZT_CreditHnknTuutiTy primaryKey;

    public GenZT_CreditHnknTuutiTy() {
        primaryKey = new PKZT_CreditHnknTuutiTy();
    }

    public GenZT_CreditHnknTuutiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_CreditHnknTuutiTy(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_CreditHnknTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_CreditHnknTuutiTy> getMetaClass() {
        return QZT_CreditHnknTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztyyobiv14;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv62;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV62)
    public String getZtyyobiv62() {
        return ztyyobiv62;
    }

    public void setZtyyobiv62(String pZtyyobiv62) {
        ztyyobiv62 = pZtyyobiv62;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztyhnknmsgmongon1;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON1)
    public String getZtyhnknmsgmongon1() {
        return ztyhnknmsgmongon1;
    }

    public void setZtyhnknmsgmongon1(String pZtyhnknmsgmongon1) {
        ztyhnknmsgmongon1 = pZtyhnknmsgmongon1;
    }

    private String ztyhnknmsgmongon2;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON2)
    public String getZtyhnknmsgmongon2() {
        return ztyhnknmsgmongon2;
    }

    public void setZtyhnknmsgmongon2(String pZtyhnknmsgmongon2) {
        ztyhnknmsgmongon2 = pZtyhnknmsgmongon2;
    }

    private String ztyhnknmsgmongon3;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON3)
    public String getZtyhnknmsgmongon3() {
        return ztyhnknmsgmongon3;
    }

    public void setZtyhnknmsgmongon3(String pZtyhnknmsgmongon3) {
        ztyhnknmsgmongon3 = pZtyhnknmsgmongon3;
    }

    private String ztyhnknmsgmongon4;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON4)
    public String getZtyhnknmsgmongon4() {
        return ztyhnknmsgmongon4;
    }

    public void setZtyhnknmsgmongon4(String pZtyhnknmsgmongon4) {
        ztyhnknmsgmongon4 = pZtyhnknmsgmongon4;
    }

    private String ztyhnknmsgmongon5;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON5)
    public String getZtyhnknmsgmongon5() {
        return ztyhnknmsgmongon5;
    }

    public void setZtyhnknmsgmongon5(String pZtyhnknmsgmongon5) {
        ztyhnknmsgmongon5 = pZtyhnknmsgmongon5;
    }

    private String ztyhnknmsgmongon6;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON6)
    public String getZtyhnknmsgmongon6() {
        return ztyhnknmsgmongon6;
    }

    public void setZtyhnknmsgmongon6(String pZtyhnknmsgmongon6) {
        ztyhnknmsgmongon6 = pZtyhnknmsgmongon6;
    }

    private String ztyhnknmsgmongon7;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON7)
    public String getZtyhnknmsgmongon7() {
        return ztyhnknmsgmongon7;
    }

    public void setZtyhnknmsgmongon7(String pZtyhnknmsgmongon7) {
        ztyhnknmsgmongon7 = pZtyhnknmsgmongon7;
    }

    private String ztyhnknmsgmongon8;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON8)
    public String getZtyhnknmsgmongon8() {
        return ztyhnknmsgmongon8;
    }

    public void setZtyhnknmsgmongon8(String pZtyhnknmsgmongon8) {
        ztyhnknmsgmongon8 = pZtyhnknmsgmongon8;
    }

    private String ztyhnknmsgmongon9;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON9)
    public String getZtyhnknmsgmongon9() {
        return ztyhnknmsgmongon9;
    }

    public void setZtyhnknmsgmongon9(String pZtyhnknmsgmongon9) {
        ztyhnknmsgmongon9 = pZtyhnknmsgmongon9;
    }

    private String ztyhnknmsgmongon10;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGMONGON10)
    public String getZtyhnknmsgmongon10() {
        return ztyhnknmsgmongon10;
    }

    public void setZtyhnknmsgmongon10(String pZtyhnknmsgmongon10) {
        ztyhnknmsgmongon10 = pZtyhnknmsgmongon10;
    }

    private String ztyyobiv128;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV128)
    public String getZtyyobiv128() {
        return ztyyobiv128;
    }

    public void setZtyyobiv128(String pZtyyobiv128) {
        ztyyobiv128 = pZtyyobiv128;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztytuutisakuseiymdv32;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYTUUTISAKUSEIYMDV32)
    public String getZtytuutisakuseiymdv32() {
        return ztytuutisakuseiymdv32;
    }

    public void setZtytuutisakuseiymdv32(String pZtytuutisakuseiymdv32) {
        ztytuutisakuseiymdv32 = pZtytuutisakuseiymdv32;
    }

    private String ztyyobiv64;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV64)
    public String getZtyyobiv64() {
        return ztyyobiv64;
    }

    public void setZtyyobiv64(String pZtyyobiv64) {
        ztyyobiv64 = pZtyyobiv64;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }

    private String ztyhnknnaiyoumongon1;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON1)
    public String getZtyhnknnaiyoumongon1() {
        return ztyhnknnaiyoumongon1;
    }

    public void setZtyhnknnaiyoumongon1(String pZtyhnknnaiyoumongon1) {
        ztyhnknnaiyoumongon1 = pZtyhnknnaiyoumongon1;
    }

    private String ztyhnknnaiyoumongon2;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON2)
    public String getZtyhnknnaiyoumongon2() {
        return ztyhnknnaiyoumongon2;
    }

    public void setZtyhnknnaiyoumongon2(String pZtyhnknnaiyoumongon2) {
        ztyhnknnaiyoumongon2 = pZtyhnknnaiyoumongon2;
    }

    private String ztyhnknnaiyoumongon3;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON3)
    public String getZtyhnknnaiyoumongon3() {
        return ztyhnknnaiyoumongon3;
    }

    public void setZtyhnknnaiyoumongon3(String pZtyhnknnaiyoumongon3) {
        ztyhnknnaiyoumongon3 = pZtyhnknnaiyoumongon3;
    }

    private String ztyhnknnaiyoumongon4;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON4)
    public String getZtyhnknnaiyoumongon4() {
        return ztyhnknnaiyoumongon4;
    }

    public void setZtyhnknnaiyoumongon4(String pZtyhnknnaiyoumongon4) {
        ztyhnknnaiyoumongon4 = pZtyhnknnaiyoumongon4;
    }

    private String ztyhnknnaiyoumongon5;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON5)
    public String getZtyhnknnaiyoumongon5() {
        return ztyhnknnaiyoumongon5;
    }

    public void setZtyhnknnaiyoumongon5(String pZtyhnknnaiyoumongon5) {
        ztyhnknnaiyoumongon5 = pZtyhnknnaiyoumongon5;
    }

    private String ztyhnknnaiyoumongon6;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON6)
    public String getZtyhnknnaiyoumongon6() {
        return ztyhnknnaiyoumongon6;
    }

    public void setZtyhnknnaiyoumongon6(String pZtyhnknnaiyoumongon6) {
        ztyhnknnaiyoumongon6 = pZtyhnknnaiyoumongon6;
    }

    private String ztyhnknnaiyoumongon7;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON7)
    public String getZtyhnknnaiyoumongon7() {
        return ztyhnknnaiyoumongon7;
    }

    public void setZtyhnknnaiyoumongon7(String pZtyhnknnaiyoumongon7) {
        ztyhnknnaiyoumongon7 = pZtyhnknnaiyoumongon7;
    }

    private String ztyhnknnaiyoumongon8;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNNAIYOUMONGON8)
    public String getZtyhnknnaiyoumongon8() {
        return ztyhnknnaiyoumongon8;
    }

    public void setZtyhnknnaiyoumongon8(String pZtyhnknnaiyoumongon8) {
        ztyhnknnaiyoumongon8 = pZtyhnknnaiyoumongon8;
    }

    private String ztyyobiv128x2;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV128X2)
    public String getZtyyobiv128x2() {
        return ztyyobiv128x2;
    }

    public void setZtyyobiv128x2(String pZtyyobiv128x2) {
        ztyyobiv128x2 = pZtyyobiv128x2;
    }

    private String ztyansyuyouyobin10x6;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10X6)
    public String getZtyansyuyouyobin10x6() {
        return ztyansyuyouyobin10x6;
    }

    public void setZtyansyuyouyobin10x6(String pZtyansyuyouyobin10x6) {
        ztyansyuyouyobin10x6 = pZtyansyuyouyobin10x6;
    }

    private String ztyhnknmsghsk1;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK1)
    public String getZtyhnknmsghsk1() {
        return ztyhnknmsghsk1;
    }

    public void setZtyhnknmsghsk1(String pZtyhnknmsghsk1) {
        ztyhnknmsghsk1 = pZtyhnknmsghsk1;
    }

    private String ztyhnknmsghsk2;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK2)
    public String getZtyhnknmsghsk2() {
        return ztyhnknmsghsk2;
    }

    public void setZtyhnknmsghsk2(String pZtyhnknmsghsk2) {
        ztyhnknmsghsk2 = pZtyhnknmsghsk2;
    }

    private String ztyhnknmsghsk3;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK3)
    public String getZtyhnknmsghsk3() {
        return ztyhnknmsghsk3;
    }

    public void setZtyhnknmsghsk3(String pZtyhnknmsghsk3) {
        ztyhnknmsghsk3 = pZtyhnknmsghsk3;
    }

    private String ztyhnknmsghsk4;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK4)
    public String getZtyhnknmsghsk4() {
        return ztyhnknmsghsk4;
    }

    public void setZtyhnknmsghsk4(String pZtyhnknmsghsk4) {
        ztyhnknmsghsk4 = pZtyhnknmsghsk4;
    }

    private String ztyhnknmsghsk5;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK5)
    public String getZtyhnknmsghsk5() {
        return ztyhnknmsghsk5;
    }

    public void setZtyhnknmsghsk5(String pZtyhnknmsghsk5) {
        ztyhnknmsghsk5 = pZtyhnknmsghsk5;
    }

    private String ztyhnknmsghsk6;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK6)
    public String getZtyhnknmsghsk6() {
        return ztyhnknmsghsk6;
    }

    public void setZtyhnknmsghsk6(String pZtyhnknmsghsk6) {
        ztyhnknmsghsk6 = pZtyhnknmsghsk6;
    }

    private String ztyhnknmsghsk7;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK7)
    public String getZtyhnknmsghsk7() {
        return ztyhnknmsghsk7;
    }

    public void setZtyhnknmsghsk7(String pZtyhnknmsghsk7) {
        ztyhnknmsghsk7 = pZtyhnknmsghsk7;
    }

    private String ztyhnknmsghsk8;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK8)
    public String getZtyhnknmsghsk8() {
        return ztyhnknmsghsk8;
    }

    public void setZtyhnknmsghsk8(String pZtyhnknmsghsk8) {
        ztyhnknmsghsk8 = pZtyhnknmsghsk8;
    }

    private String ztyhnknmsghsk9;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK9)
    public String getZtyhnknmsghsk9() {
        return ztyhnknmsghsk9;
    }

    public void setZtyhnknmsghsk9(String pZtyhnknmsghsk9) {
        ztyhnknmsghsk9 = pZtyhnknmsghsk9;
    }

    private String ztyhnknmsghsk10;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK10)
    public String getZtyhnknmsghsk10() {
        return ztyhnknmsghsk10;
    }

    public void setZtyhnknmsghsk10(String pZtyhnknmsghsk10) {
        ztyhnknmsghsk10 = pZtyhnknmsghsk10;
    }

    private String ztyhnknmsghsk11;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK11)
    public String getZtyhnknmsghsk11() {
        return ztyhnknmsghsk11;
    }

    public void setZtyhnknmsghsk11(String pZtyhnknmsghsk11) {
        ztyhnknmsghsk11 = pZtyhnknmsghsk11;
    }

    private String ztyhnknmsghsk12;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK12)
    public String getZtyhnknmsghsk12() {
        return ztyhnknmsghsk12;
    }

    public void setZtyhnknmsghsk12(String pZtyhnknmsghsk12) {
        ztyhnknmsghsk12 = pZtyhnknmsghsk12;
    }

    private String ztyhnknmsghsk13;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK13)
    public String getZtyhnknmsghsk13() {
        return ztyhnknmsghsk13;
    }

    public void setZtyhnknmsghsk13(String pZtyhnknmsghsk13) {
        ztyhnknmsghsk13 = pZtyhnknmsghsk13;
    }

    private String ztyhnknmsghsk14;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK14)
    public String getZtyhnknmsghsk14() {
        return ztyhnknmsghsk14;
    }

    public void setZtyhnknmsghsk14(String pZtyhnknmsghsk14) {
        ztyhnknmsghsk14 = pZtyhnknmsghsk14;
    }

    private String ztyhnknmsghsk15;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK15)
    public String getZtyhnknmsghsk15() {
        return ztyhnknmsghsk15;
    }

    public void setZtyhnknmsghsk15(String pZtyhnknmsghsk15) {
        ztyhnknmsghsk15 = pZtyhnknmsghsk15;
    }

    private String ztyhnknmsghsk16;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK16)
    public String getZtyhnknmsghsk16() {
        return ztyhnknmsghsk16;
    }

    public void setZtyhnknmsghsk16(String pZtyhnknmsghsk16) {
        ztyhnknmsghsk16 = pZtyhnknmsghsk16;
    }

    private String ztyhnknmsghsk17;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK17)
    public String getZtyhnknmsghsk17() {
        return ztyhnknmsghsk17;
    }

    public void setZtyhnknmsghsk17(String pZtyhnknmsghsk17) {
        ztyhnknmsghsk17 = pZtyhnknmsghsk17;
    }

    private String ztyhnknmsghsk18;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK18)
    public String getZtyhnknmsghsk18() {
        return ztyhnknmsghsk18;
    }

    public void setZtyhnknmsghsk18(String pZtyhnknmsghsk18) {
        ztyhnknmsghsk18 = pZtyhnknmsghsk18;
    }

    private String ztyhnknmsghsk19;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK19)
    public String getZtyhnknmsghsk19() {
        return ztyhnknmsghsk19;
    }

    public void setZtyhnknmsghsk19(String pZtyhnknmsghsk19) {
        ztyhnknmsghsk19 = pZtyhnknmsghsk19;
    }

    private String ztyhnknmsghsk20;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYHNKNMSGHSK20)
    public String getZtyhnknmsghsk20() {
        return ztyhnknmsghsk20;
    }

    public void setZtyhnknmsghsk20(String pZtyhnknmsghsk20) {
        ztyhnknmsghsk20 = pZtyhnknmsghsk20;
    }

    private String ztyyobiv128x3;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYYOBIV128X3)
    public String getZtyyobiv128x3() {
        return ztyyobiv128x3;
    }

    public void setZtyyobiv128x3(String pZtyyobiv128x3) {
        ztyyobiv128x3 = pZtyyobiv128x3;
    }

    private String ztyansyuyouyobin10x7;

    @Column(name=GenZT_CreditHnknTuutiTy.ZTYANSYUYOUYOBIN10X7)
    public String getZtyansyuyouyobin10x7() {
        return ztyansyuyouyobin10x7;
    }

    public void setZtyansyuyouyobin10x7(String pZtyansyuyouyobin10x7) {
        ztyansyuyouyobin10x7 = pZtyansyuyouyobin10x7;
    }
}