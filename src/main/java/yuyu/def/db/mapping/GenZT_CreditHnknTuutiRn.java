package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_CreditHnknTuutiRn;
import yuyu.def.db.id.PKZT_CreditHnknTuutiRn;
import yuyu.def.db.meta.GenQZT_CreditHnknTuutiRn;
import yuyu.def.db.meta.QZT_CreditHnknTuutiRn;

/**
 * クレカ返金通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_CreditHnknTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_CreditHnknTuutiRn}</td><td colspan="3">クレカ返金通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_CreditHnknTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_CreditHnknTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_CreditHnknTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv14 zrnyobiv14}</td><td>（連携用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10 zrnansyuyouyobin10}</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkj zrnshsnmkj}</td><td>（連携用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43 zrnyobiv43}</td><td>（連携用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x2 zrnansyuyouyobin10x2}</td><td>（連携用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj zrntawadr3kj}</td><td>（連携用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelnov14 zrntawtelnov14}</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1 zrntawteluktkkanou1}</td><td>（連携用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2 zrntawteluktkkanou2}</td><td>（連携用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawsosikinmkj zrndai2tawsosikinmkj}</td><td>（連携用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawtelno zrndai2tawtelno}</td><td>（連携用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakunm15keta zrnsakunm15keta}</td><td>（連携用）作成番号（１５桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv62 zrnyobiv62}</td><td>（連携用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon1 zrnhnknmsgmongon1}</td><td>（連携用）返金メッセージ文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon2 zrnhnknmsgmongon2}</td><td>（連携用）返金メッセージ文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon3 zrnhnknmsgmongon3}</td><td>（連携用）返金メッセージ文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon4 zrnhnknmsgmongon4}</td><td>（連携用）返金メッセージ文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon5 zrnhnknmsgmongon5}</td><td>（連携用）返金メッセージ文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon6 zrnhnknmsgmongon6}</td><td>（連携用）返金メッセージ文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon7 zrnhnknmsgmongon7}</td><td>（連携用）返金メッセージ文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon8 zrnhnknmsgmongon8}</td><td>（連携用）返金メッセージ文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon9 zrnhnknmsgmongon9}</td><td>（連携用）返金メッセージ文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsgmongon10 zrnhnknmsgmongon10}</td><td>（連携用）返金メッセージ文言１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv128 zrnyobiv128}</td><td>（連携用）予備項目Ｖ１２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutisakuseiymdv32 zrntuutisakuseiymdv32}</td><td>（連携用）通知作成年月日Ｖ３２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv64 zrnyobiv64}</td><td>（連携用）予備項目Ｖ６４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon1 zrnhnknnaiyoumongon1}</td><td>（連携用）返金内容文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon2 zrnhnknnaiyoumongon2}</td><td>（連携用）返金内容文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon3 zrnhnknnaiyoumongon3}</td><td>（連携用）返金内容文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon4 zrnhnknnaiyoumongon4}</td><td>（連携用）返金内容文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon5 zrnhnknnaiyoumongon5}</td><td>（連携用）返金内容文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon6 zrnhnknnaiyoumongon6}</td><td>（連携用）返金内容文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon7 zrnhnknnaiyoumongon7}</td><td>（連携用）返金内容文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknnaiyoumongon8 zrnhnknnaiyoumongon8}</td><td>（連携用）返金内容文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv128x2 zrnyobiv128x2}</td><td>（連携用）予備項目Ｖ１２８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x6 zrnansyuyouyobin10x6}</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk1 zrnhnknmsghsk1}</td><td>（連携用）返金メッセージ補足１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk2 zrnhnknmsghsk2}</td><td>（連携用）返金メッセージ補足２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk3 zrnhnknmsghsk3}</td><td>（連携用）返金メッセージ補足３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk4 zrnhnknmsghsk4}</td><td>（連携用）返金メッセージ補足４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk5 zrnhnknmsghsk5}</td><td>（連携用）返金メッセージ補足５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk6 zrnhnknmsghsk6}</td><td>（連携用）返金メッセージ補足６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk7 zrnhnknmsghsk7}</td><td>（連携用）返金メッセージ補足７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk8 zrnhnknmsghsk8}</td><td>（連携用）返金メッセージ補足８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk9 zrnhnknmsghsk9}</td><td>（連携用）返金メッセージ補足９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk10 zrnhnknmsghsk10}</td><td>（連携用）返金メッセージ補足１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk11 zrnhnknmsghsk11}</td><td>（連携用）返金メッセージ補足１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk12 zrnhnknmsghsk12}</td><td>（連携用）返金メッセージ補足１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk13 zrnhnknmsghsk13}</td><td>（連携用）返金メッセージ補足１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk14 zrnhnknmsghsk14}</td><td>（連携用）返金メッセージ補足１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk15 zrnhnknmsghsk15}</td><td>（連携用）返金メッセージ補足１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk16 zrnhnknmsghsk16}</td><td>（連携用）返金メッセージ補足１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk17 zrnhnknmsghsk17}</td><td>（連携用）返金メッセージ補足１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk18 zrnhnknmsghsk18}</td><td>（連携用）返金メッセージ補足１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk19 zrnhnknmsghsk19}</td><td>（連携用）返金メッセージ補足１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnknmsghsk20 zrnhnknmsghsk20}</td><td>（連携用）返金メッセージ補足２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv128x3 zrnyobiv128x3}</td><td>（連携用）予備項目Ｖ１２８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x7 zrnansyuyouyobin10x7}</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_CreditHnknTuutiRn
 * @see     PKZT_CreditHnknTuutiRn
 * @see     QZT_CreditHnknTuutiRn
 * @see     GenQZT_CreditHnknTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_CreditHnknTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_CreditHnknTuutiRn.class)
public abstract class GenZT_CreditHnknTuutiRn extends AbstractExDBEntityForZDB<ZT_CreditHnknTuutiRn, PKZT_CreditHnknTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_CreditHnknTuutiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNYOBIV14               = "zrnyobiv14";
    public static final String ZRNANSYUYOUYOBIN10       = "zrnansyuyouyobin10";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJ               = "zrnshsnmkj";
    public static final String ZRNYOBIV43               = "zrnyobiv43";
    public static final String ZRNANSYUYOUYOBIN10X2     = "zrnansyuyouyobin10x2";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTAWADR3KJ             = "zrntawadr3kj";
    public static final String ZRNTAWTELNOV14           = "zrntawtelnov14";
    public static final String ZRNTAWTELUKTKKANOU1      = "zrntawteluktkkanou1";
    public static final String ZRNTAWTELUKTKKANOU2      = "zrntawteluktkkanou2";
    public static final String ZRNDAI2TAWSOSIKINMKJ     = "zrndai2tawsosikinmkj";
    public static final String ZRNDAI2TAWTELNO          = "zrndai2tawtelno";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNSAKUNM15KETA          = "zrnsakunm15keta";
    public static final String ZRNYOBIV62               = "zrnyobiv62";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNHNKNMSGMONGON1        = "zrnhnknmsgmongon1";
    public static final String ZRNHNKNMSGMONGON2        = "zrnhnknmsgmongon2";
    public static final String ZRNHNKNMSGMONGON3        = "zrnhnknmsgmongon3";
    public static final String ZRNHNKNMSGMONGON4        = "zrnhnknmsgmongon4";
    public static final String ZRNHNKNMSGMONGON5        = "zrnhnknmsgmongon5";
    public static final String ZRNHNKNMSGMONGON6        = "zrnhnknmsgmongon6";
    public static final String ZRNHNKNMSGMONGON7        = "zrnhnknmsgmongon7";
    public static final String ZRNHNKNMSGMONGON8        = "zrnhnknmsgmongon8";
    public static final String ZRNHNKNMSGMONGON9        = "zrnhnknmsgmongon9";
    public static final String ZRNHNKNMSGMONGON10       = "zrnhnknmsgmongon10";
    public static final String ZRNYOBIV128              = "zrnyobiv128";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNTUUTISAKUSEIYMDV32    = "zrntuutisakuseiymdv32";
    public static final String ZRNYOBIV64               = "zrnyobiv64";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";
    public static final String ZRNHNKNNAIYOUMONGON1     = "zrnhnknnaiyoumongon1";
    public static final String ZRNHNKNNAIYOUMONGON2     = "zrnhnknnaiyoumongon2";
    public static final String ZRNHNKNNAIYOUMONGON3     = "zrnhnknnaiyoumongon3";
    public static final String ZRNHNKNNAIYOUMONGON4     = "zrnhnknnaiyoumongon4";
    public static final String ZRNHNKNNAIYOUMONGON5     = "zrnhnknnaiyoumongon5";
    public static final String ZRNHNKNNAIYOUMONGON6     = "zrnhnknnaiyoumongon6";
    public static final String ZRNHNKNNAIYOUMONGON7     = "zrnhnknnaiyoumongon7";
    public static final String ZRNHNKNNAIYOUMONGON8     = "zrnhnknnaiyoumongon8";
    public static final String ZRNYOBIV128X2            = "zrnyobiv128x2";
    public static final String ZRNANSYUYOUYOBIN10X6     = "zrnansyuyouyobin10x6";
    public static final String ZRNHNKNMSGHSK1           = "zrnhnknmsghsk1";
    public static final String ZRNHNKNMSGHSK2           = "zrnhnknmsghsk2";
    public static final String ZRNHNKNMSGHSK3           = "zrnhnknmsghsk3";
    public static final String ZRNHNKNMSGHSK4           = "zrnhnknmsghsk4";
    public static final String ZRNHNKNMSGHSK5           = "zrnhnknmsghsk5";
    public static final String ZRNHNKNMSGHSK6           = "zrnhnknmsghsk6";
    public static final String ZRNHNKNMSGHSK7           = "zrnhnknmsghsk7";
    public static final String ZRNHNKNMSGHSK8           = "zrnhnknmsghsk8";
    public static final String ZRNHNKNMSGHSK9           = "zrnhnknmsghsk9";
    public static final String ZRNHNKNMSGHSK10          = "zrnhnknmsghsk10";
    public static final String ZRNHNKNMSGHSK11          = "zrnhnknmsghsk11";
    public static final String ZRNHNKNMSGHSK12          = "zrnhnknmsghsk12";
    public static final String ZRNHNKNMSGHSK13          = "zrnhnknmsghsk13";
    public static final String ZRNHNKNMSGHSK14          = "zrnhnknmsghsk14";
    public static final String ZRNHNKNMSGHSK15          = "zrnhnknmsghsk15";
    public static final String ZRNHNKNMSGHSK16          = "zrnhnknmsghsk16";
    public static final String ZRNHNKNMSGHSK17          = "zrnhnknmsghsk17";
    public static final String ZRNHNKNMSGHSK18          = "zrnhnknmsghsk18";
    public static final String ZRNHNKNMSGHSK19          = "zrnhnknmsghsk19";
    public static final String ZRNHNKNMSGHSK20          = "zrnhnknmsghsk20";
    public static final String ZRNYOBIV128X3            = "zrnyobiv128x3";
    public static final String ZRNANSYUYOUYOBIN10X7     = "zrnansyuyouyobin10x7";

    private final PKZT_CreditHnknTuutiRn primaryKey;

    public GenZT_CreditHnknTuutiRn() {
        primaryKey = new PKZT_CreditHnknTuutiRn();
    }

    public GenZT_CreditHnknTuutiRn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_CreditHnknTuutiRn(
            pZrnsyono,
            pZrntyouhyouymd,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_CreditHnknTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_CreditHnknTuutiRn> getMetaClass() {
        return QZT_CreditHnknTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnyobiv14;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV14)
    public String getZrnyobiv14() {
        return zrnyobiv14;
    }

    public void setZrnyobiv14(String pZrnyobiv14) {
        zrnyobiv14 = pZrnyobiv14;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv62;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV62)
    public String getZrnyobiv62() {
        return zrnyobiv62;
    }

    public void setZrnyobiv62(String pZrnyobiv62) {
        zrnyobiv62 = pZrnyobiv62;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrnhnknmsgmongon1;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON1)
    public String getZrnhnknmsgmongon1() {
        return zrnhnknmsgmongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon1(String pZrnhnknmsgmongon1) {
        zrnhnknmsgmongon1 = pZrnhnknmsgmongon1;
    }

    private String zrnhnknmsgmongon2;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON2)
    public String getZrnhnknmsgmongon2() {
        return zrnhnknmsgmongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon2(String pZrnhnknmsgmongon2) {
        zrnhnknmsgmongon2 = pZrnhnknmsgmongon2;
    }

    private String zrnhnknmsgmongon3;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON3)
    public String getZrnhnknmsgmongon3() {
        return zrnhnknmsgmongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon3(String pZrnhnknmsgmongon3) {
        zrnhnknmsgmongon3 = pZrnhnknmsgmongon3;
    }

    private String zrnhnknmsgmongon4;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON4)
    public String getZrnhnknmsgmongon4() {
        return zrnhnknmsgmongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon4(String pZrnhnknmsgmongon4) {
        zrnhnknmsgmongon4 = pZrnhnknmsgmongon4;
    }

    private String zrnhnknmsgmongon5;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON5)
    public String getZrnhnknmsgmongon5() {
        return zrnhnknmsgmongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon5(String pZrnhnknmsgmongon5) {
        zrnhnknmsgmongon5 = pZrnhnknmsgmongon5;
    }

    private String zrnhnknmsgmongon6;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON6)
    public String getZrnhnknmsgmongon6() {
        return zrnhnknmsgmongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon6(String pZrnhnknmsgmongon6) {
        zrnhnknmsgmongon6 = pZrnhnknmsgmongon6;
    }

    private String zrnhnknmsgmongon7;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON7)
    public String getZrnhnknmsgmongon7() {
        return zrnhnknmsgmongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon7(String pZrnhnknmsgmongon7) {
        zrnhnknmsgmongon7 = pZrnhnknmsgmongon7;
    }

    private String zrnhnknmsgmongon8;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON8)
    public String getZrnhnknmsgmongon8() {
        return zrnhnknmsgmongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon8(String pZrnhnknmsgmongon8) {
        zrnhnknmsgmongon8 = pZrnhnknmsgmongon8;
    }

    private String zrnhnknmsgmongon9;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON9)
    public String getZrnhnknmsgmongon9() {
        return zrnhnknmsgmongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon9(String pZrnhnknmsgmongon9) {
        zrnhnknmsgmongon9 = pZrnhnknmsgmongon9;
    }

    private String zrnhnknmsgmongon10;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGMONGON10)
    public String getZrnhnknmsgmongon10() {
        return zrnhnknmsgmongon10;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsgmongon10(String pZrnhnknmsgmongon10) {
        zrnhnknmsgmongon10 = pZrnhnknmsgmongon10;
    }

    private String zrnyobiv128;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV128)
    public String getZrnyobiv128() {
        return zrnyobiv128;
    }

    public void setZrnyobiv128(String pZrnyobiv128) {
        zrnyobiv128 = pZrnyobiv128;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrntuutisakuseiymdv32;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNTUUTISAKUSEIYMDV32)
    public String getZrntuutisakuseiymdv32() {
        return zrntuutisakuseiymdv32;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutisakuseiymdv32(String pZrntuutisakuseiymdv32) {
        zrntuutisakuseiymdv32 = pZrntuutisakuseiymdv32;
    }

    private String zrnyobiv64;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV64)
    public String getZrnyobiv64() {
        return zrnyobiv64;
    }

    public void setZrnyobiv64(String pZrnyobiv64) {
        zrnyobiv64 = pZrnyobiv64;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }

    private String zrnhnknnaiyoumongon1;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON1)
    public String getZrnhnknnaiyoumongon1() {
        return zrnhnknnaiyoumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon1(String pZrnhnknnaiyoumongon1) {
        zrnhnknnaiyoumongon1 = pZrnhnknnaiyoumongon1;
    }

    private String zrnhnknnaiyoumongon2;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON2)
    public String getZrnhnknnaiyoumongon2() {
        return zrnhnknnaiyoumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon2(String pZrnhnknnaiyoumongon2) {
        zrnhnknnaiyoumongon2 = pZrnhnknnaiyoumongon2;
    }

    private String zrnhnknnaiyoumongon3;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON3)
    public String getZrnhnknnaiyoumongon3() {
        return zrnhnknnaiyoumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon3(String pZrnhnknnaiyoumongon3) {
        zrnhnknnaiyoumongon3 = pZrnhnknnaiyoumongon3;
    }

    private String zrnhnknnaiyoumongon4;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON4)
    public String getZrnhnknnaiyoumongon4() {
        return zrnhnknnaiyoumongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon4(String pZrnhnknnaiyoumongon4) {
        zrnhnknnaiyoumongon4 = pZrnhnknnaiyoumongon4;
    }

    private String zrnhnknnaiyoumongon5;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON5)
    public String getZrnhnknnaiyoumongon5() {
        return zrnhnknnaiyoumongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon5(String pZrnhnknnaiyoumongon5) {
        zrnhnknnaiyoumongon5 = pZrnhnknnaiyoumongon5;
    }

    private String zrnhnknnaiyoumongon6;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON6)
    public String getZrnhnknnaiyoumongon6() {
        return zrnhnknnaiyoumongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon6(String pZrnhnknnaiyoumongon6) {
        zrnhnknnaiyoumongon6 = pZrnhnknnaiyoumongon6;
    }

    private String zrnhnknnaiyoumongon7;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON7)
    public String getZrnhnknnaiyoumongon7() {
        return zrnhnknnaiyoumongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon7(String pZrnhnknnaiyoumongon7) {
        zrnhnknnaiyoumongon7 = pZrnhnknnaiyoumongon7;
    }

    private String zrnhnknnaiyoumongon8;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNNAIYOUMONGON8)
    public String getZrnhnknnaiyoumongon8() {
        return zrnhnknnaiyoumongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknnaiyoumongon8(String pZrnhnknnaiyoumongon8) {
        zrnhnknnaiyoumongon8 = pZrnhnknnaiyoumongon8;
    }

    private String zrnyobiv128x2;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV128X2)
    public String getZrnyobiv128x2() {
        return zrnyobiv128x2;
    }

    @DataConvert("toMultiByte")
    public void setZrnyobiv128x2(String pZrnyobiv128x2) {
        zrnyobiv128x2 = pZrnyobiv128x2;
    }

    private String zrnansyuyouyobin10x6;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10X6)
    public String getZrnansyuyouyobin10x6() {
        return zrnansyuyouyobin10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x6(String pZrnansyuyouyobin10x6) {
        zrnansyuyouyobin10x6 = pZrnansyuyouyobin10x6;
    }

    private String zrnhnknmsghsk1;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK1)
    public String getZrnhnknmsghsk1() {
        return zrnhnknmsghsk1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk1(String pZrnhnknmsghsk1) {
        zrnhnknmsghsk1 = pZrnhnknmsghsk1;
    }

    private String zrnhnknmsghsk2;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK2)
    public String getZrnhnknmsghsk2() {
        return zrnhnknmsghsk2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk2(String pZrnhnknmsghsk2) {
        zrnhnknmsghsk2 = pZrnhnknmsghsk2;
    }

    private String zrnhnknmsghsk3;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK3)
    public String getZrnhnknmsghsk3() {
        return zrnhnknmsghsk3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk3(String pZrnhnknmsghsk3) {
        zrnhnknmsghsk3 = pZrnhnknmsghsk3;
    }

    private String zrnhnknmsghsk4;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK4)
    public String getZrnhnknmsghsk4() {
        return zrnhnknmsghsk4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk4(String pZrnhnknmsghsk4) {
        zrnhnknmsghsk4 = pZrnhnknmsghsk4;
    }

    private String zrnhnknmsghsk5;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK5)
    public String getZrnhnknmsghsk5() {
        return zrnhnknmsghsk5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk5(String pZrnhnknmsghsk5) {
        zrnhnknmsghsk5 = pZrnhnknmsghsk5;
    }

    private String zrnhnknmsghsk6;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK6)
    public String getZrnhnknmsghsk6() {
        return zrnhnknmsghsk6;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk6(String pZrnhnknmsghsk6) {
        zrnhnknmsghsk6 = pZrnhnknmsghsk6;
    }

    private String zrnhnknmsghsk7;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK7)
    public String getZrnhnknmsghsk7() {
        return zrnhnknmsghsk7;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk7(String pZrnhnknmsghsk7) {
        zrnhnknmsghsk7 = pZrnhnknmsghsk7;
    }

    private String zrnhnknmsghsk8;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK8)
    public String getZrnhnknmsghsk8() {
        return zrnhnknmsghsk8;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk8(String pZrnhnknmsghsk8) {
        zrnhnknmsghsk8 = pZrnhnknmsghsk8;
    }

    private String zrnhnknmsghsk9;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK9)
    public String getZrnhnknmsghsk9() {
        return zrnhnknmsghsk9;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk9(String pZrnhnknmsghsk9) {
        zrnhnknmsghsk9 = pZrnhnknmsghsk9;
    }

    private String zrnhnknmsghsk10;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK10)
    public String getZrnhnknmsghsk10() {
        return zrnhnknmsghsk10;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk10(String pZrnhnknmsghsk10) {
        zrnhnknmsghsk10 = pZrnhnknmsghsk10;
    }

    private String zrnhnknmsghsk11;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK11)
    public String getZrnhnknmsghsk11() {
        return zrnhnknmsghsk11;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk11(String pZrnhnknmsghsk11) {
        zrnhnknmsghsk11 = pZrnhnknmsghsk11;
    }

    private String zrnhnknmsghsk12;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK12)
    public String getZrnhnknmsghsk12() {
        return zrnhnknmsghsk12;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk12(String pZrnhnknmsghsk12) {
        zrnhnknmsghsk12 = pZrnhnknmsghsk12;
    }

    private String zrnhnknmsghsk13;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK13)
    public String getZrnhnknmsghsk13() {
        return zrnhnknmsghsk13;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk13(String pZrnhnknmsghsk13) {
        zrnhnknmsghsk13 = pZrnhnknmsghsk13;
    }

    private String zrnhnknmsghsk14;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK14)
    public String getZrnhnknmsghsk14() {
        return zrnhnknmsghsk14;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk14(String pZrnhnknmsghsk14) {
        zrnhnknmsghsk14 = pZrnhnknmsghsk14;
    }

    private String zrnhnknmsghsk15;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK15)
    public String getZrnhnknmsghsk15() {
        return zrnhnknmsghsk15;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk15(String pZrnhnknmsghsk15) {
        zrnhnknmsghsk15 = pZrnhnknmsghsk15;
    }

    private String zrnhnknmsghsk16;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK16)
    public String getZrnhnknmsghsk16() {
        return zrnhnknmsghsk16;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk16(String pZrnhnknmsghsk16) {
        zrnhnknmsghsk16 = pZrnhnknmsghsk16;
    }

    private String zrnhnknmsghsk17;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK17)
    public String getZrnhnknmsghsk17() {
        return zrnhnknmsghsk17;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk17(String pZrnhnknmsghsk17) {
        zrnhnknmsghsk17 = pZrnhnknmsghsk17;
    }

    private String zrnhnknmsghsk18;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK18)
    public String getZrnhnknmsghsk18() {
        return zrnhnknmsghsk18;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk18(String pZrnhnknmsghsk18) {
        zrnhnknmsghsk18 = pZrnhnknmsghsk18;
    }

    private String zrnhnknmsghsk19;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK19)
    public String getZrnhnknmsghsk19() {
        return zrnhnknmsghsk19;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk19(String pZrnhnknmsghsk19) {
        zrnhnknmsghsk19 = pZrnhnknmsghsk19;
    }

    private String zrnhnknmsghsk20;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNHNKNMSGHSK20)
    public String getZrnhnknmsghsk20() {
        return zrnhnknmsghsk20;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnknmsghsk20(String pZrnhnknmsghsk20) {
        zrnhnknmsghsk20 = pZrnhnknmsghsk20;
    }

    private String zrnyobiv128x3;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNYOBIV128X3)
    public String getZrnyobiv128x3() {
        return zrnyobiv128x3;
    }

    @DataConvert("toMultiByte")
    public void setZrnyobiv128x3(String pZrnyobiv128x3) {
        zrnyobiv128x3 = pZrnyobiv128x3;
    }

    private String zrnansyuyouyobin10x7;

    @Column(name=GenZT_CreditHnknTuutiRn.ZRNANSYUYOUYOBIN10X7)
    public String getZrnansyuyouyobin10x7() {
        return zrnansyuyouyobin10x7;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x7(String pZrnansyuyouyobin10x7) {
        zrnansyuyouyobin10x7 = pZrnansyuyouyobin10x7;
    }
}