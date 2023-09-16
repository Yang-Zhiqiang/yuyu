package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiRn;
import yuyu.def.db.id.PKZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.GenQZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiRn;

/**
 * 控除証明書Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KoujyoSyoumeiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KoujyoSyoumeiRn}</td><td colspan="3">控除証明書Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_KoujyoSyoumeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KoujyoSyoumeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn zrnsyodouhuukbn}</td><td>（連携用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoujyosyoumeisentakukbn zrnkoujyosyoumeisentakukbn}</td><td>（連携用）控除証明選択区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43 zrnyobiv43}</td><td>（連携用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkj zrnshsnmkj}</td><td>（連携用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkn zrnkyknmkn}</td><td>（連携用）契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnmkn zrnuktnmkn}</td><td>（連携用）受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnsakunm15keta zrnsakunm15keta}</td><td>（連携用）作成番号（１５桁）</td><td align="center">{@link PKZT_KoujyoSyoumeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv48 zrnyobiv48}</td><td>（連携用）予備項目Ｖ４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumeinndseireki zrnsyoumeinndseireki}</td><td>（連携用）証明年度（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnmknmeikj zrnuktnmknmeikj}</td><td>（連携用）受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinuktseiymdseireki zrnnenkinuktseiymdseireki}</td><td>（連携用）年金受取人生年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono3 zrnsyono3}</td><td>（連携用）証券番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyurui zrnhknsyurui}</td><td>（連携用）保険種類</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshrynnm zrnnknshrynnm}</td><td>（連携用）年金支払期間（数）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdseireki zrnkykymdseireki}</td><td>（連携用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtkinuthoukbn zrnhtkinuthoukbn}</td><td>（連携用）配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkknnm zrnhknkknnm}</td><td>（連携用）保険期間（数）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrstartymdseireki zrnnkshrstartymdseireki}</td><td>（連携用）年金支払開始日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkkn zrnphrkkkn}</td><td>（連携用）保険料払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuunm zrnhrkkaisuunm}</td><td>（連携用）払込回数（数）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjnnkkoujyum zrnkjnnkkoujyum}</td><td>（連携用）個人年金控除有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasi zrnuktmidasi}</td><td>（連携用）受取人見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasisub zrnmidasisub}</td><td>（連携用）見出し副題</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoujyosyoumeifreearea zrnkoujyosyoumeifreearea}</td><td>（連携用）控除証明書フリーエリア</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoujyosyoumeimsgkbn zrnkoujyosyoumeimsgkbn}</td><td>（連携用）控除証明メッセージ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnippanseimeip zrnippanseimeip}</td><td>（連携用）一般生命保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnippanhaitoukin zrnippanhaitoukin}</td><td>（連携用）一般配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnippansyoumeigk zrnippansyoumeigk}</td><td>（連携用）一般証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoiryoup zrnkaigoiryoup}</td><td>（連携用）介護医療保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoiryoud zrnkaigoiryoud}</td><td>（連携用）介護医療配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoiryousmgk zrnkaigoiryousmgk}</td><td>（連携用）介護医療証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinp zrnnenkinp}</td><td>（連携用）年金保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkind zrnnenkind}</td><td>（連携用）年金配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsmgk zrnnenkinsmgk}</td><td>（連携用）年金証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewhknjytukikan zrnnewhknjytukikan}</td><td>（連携用）新制度保険充当期間</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkknjyoutai zrnphrkkknjyoutai}</td><td>（連携用）保険料払込状態</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumeiymdseireki zrnsyoumeiymdseireki}</td><td>（連携用）証明日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenippanseimeip zrnnenippanseimeip}</td><td>（連携用）年間一般生命保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenippand zrnnenippand}</td><td>（連携用）年間一般配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenippansymgk zrnnenippansymgk}</td><td>（連携用）年間一般証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkaigoiryoup zrnnenkaigoiryoup}</td><td>（連携用）年間介護医療保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkaigoiryoud zrnnenkaigoiryoud}</td><td>（連携用）年間介護医療配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnneniryousymgk zrnneniryousymgk}</td><td>（連携用）年間介護医療証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnennenkinp zrnnennenkinp}</td><td>（連携用）年間年金保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnennenkind zrnnennenkind}</td><td>（連携用）年間年金配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnennenkinsmgk zrnnennenkinsmgk}</td><td>（連携用）年間年金証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KoujyoSyoumeiRn
 * @see     PKZT_KoujyoSyoumeiRn
 * @see     QZT_KoujyoSyoumeiRn
 * @see     GenQZT_KoujyoSyoumeiRn
 */
@MappedSuperclass
@Table(name=GenZT_KoujyoSyoumeiRn.TABLE_NAME)
@IdClass(value=PKZT_KoujyoSyoumeiRn.class)
public abstract class GenZT_KoujyoSyoumeiRn extends AbstractExDBEntityForZDB<ZT_KoujyoSyoumeiRn, PKZT_KoujyoSyoumeiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KoujyoSyoumeiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNSYODOUHUUKBN          = "zrnsyodouhuukbn";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNKOUJYOSYOUMEISENTAKUKBN = "zrnkoujyosyoumeisentakukbn";
    public static final String ZRNYOBIV43               = "zrnyobiv43";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJ               = "zrnshsnmkj";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNKYKNMKN               = "zrnkyknmkn";
    public static final String ZRNUKTNMKN               = "zrnuktnmkn";
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
    public static final String ZRNYOBIV48               = "zrnyobiv48";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNSYOUMEINNDSEIREKI     = "zrnsyoumeinndseireki";
    public static final String ZRNUKTNMKNMEIKJ          = "zrnuktnmknmeikj";
    public static final String ZRNNENKINUKTSEIYMDSEIREKI = "zrnnenkinuktseiymdseireki";
    public static final String ZRNSYONO3                = "zrnsyono3";
    public static final String ZRNHKNSYURUI             = "zrnhknsyurui";
    public static final String ZRNNKNSHRYNNM            = "zrnnknshrynnm";
    public static final String ZRNKYKYMDSEIREKI         = "zrnkykymdseireki";
    public static final String ZRNHTKINUTHOUKBN         = "zrnhtkinuthoukbn";
    public static final String ZRNHKNKKNNM              = "zrnhknkknnm";
    public static final String ZRNNKSHRSTARTYMDSEIREKI  = "zrnnkshrstartymdseireki";
    public static final String ZRNPHRKKKN               = "zrnphrkkkn";
    public static final String ZRNHRKKAISUUNM           = "zrnhrkkaisuunm";
    public static final String ZRNKJNNKKOUJYUM          = "zrnkjnnkkoujyum";
    public static final String ZRNUKTMIDASI             = "zrnuktmidasi";
    public static final String ZRNMIDASISUB             = "zrnmidasisub";
    public static final String ZRNKOUJYOSYOUMEIFREEAREA = "zrnkoujyosyoumeifreearea";
    public static final String ZRNKOUJYOSYOUMEIMSGKBN   = "zrnkoujyosyoumeimsgkbn";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNIPPANSEIMEIP          = "zrnippanseimeip";
    public static final String ZRNIPPANHAITOUKIN        = "zrnippanhaitoukin";
    public static final String ZRNIPPANSYOUMEIGK        = "zrnippansyoumeigk";
    public static final String ZRNKAIGOIRYOUP           = "zrnkaigoiryoup";
    public static final String ZRNKAIGOIRYOUD           = "zrnkaigoiryoud";
    public static final String ZRNKAIGOIRYOUSMGK        = "zrnkaigoiryousmgk";
    public static final String ZRNNENKINP               = "zrnnenkinp";
    public static final String ZRNNENKIND               = "zrnnenkind";
    public static final String ZRNNENKINSMGK            = "zrnnenkinsmgk";
    public static final String ZRNNEWHKNJYTUKIKAN       = "zrnnewhknjytukikan";
    public static final String ZRNPHRKKKNJYOUTAI        = "zrnphrkkknjyoutai";
    public static final String ZRNSYOUMEIYMDSEIREKI     = "zrnsyoumeiymdseireki";
    public static final String ZRNNENIPPANSEIMEIP       = "zrnnenippanseimeip";
    public static final String ZRNNENIPPAND             = "zrnnenippand";
    public static final String ZRNNENIPPANSYMGK         = "zrnnenippansymgk";
    public static final String ZRNNENKAIGOIRYOUP        = "zrnnenkaigoiryoup";
    public static final String ZRNNENKAIGOIRYOUD        = "zrnnenkaigoiryoud";
    public static final String ZRNNENIRYOUSYMGK         = "zrnneniryousymgk";
    public static final String ZRNNENNENKINP            = "zrnnennenkinp";
    public static final String ZRNNENNENKIND            = "zrnnennenkind";
    public static final String ZRNNENNENKINSMGK         = "zrnnennenkinsmgk";
    public static final String ZRNYOBIV24               = "zrnyobiv24";

    private final PKZT_KoujyoSyoumeiRn primaryKey;

    public GenZT_KoujyoSyoumeiRn() {
        primaryKey = new PKZT_KoujyoSyoumeiRn();
    }

    public GenZT_KoujyoSyoumeiRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsakunm15keta
    ) {
        primaryKey = new PKZT_KoujyoSyoumeiRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsakunm15keta
        );
    }

    @Transient
    @Override
    public PKZT_KoujyoSyoumeiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KoujyoSyoumeiRn> getMetaClass() {
        return QZT_KoujyoSyoumeiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnsyodouhuukbn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSYODOUHUUKBN)
    public String getZrnsyodouhuukbn() {
        return zrnsyodouhuukbn;
    }

    public void setZrnsyodouhuukbn(String pZrnsyodouhuukbn) {
        zrnsyodouhuukbn = pZrnsyodouhuukbn;
    }

    private String zrnsikibetuno;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return zrnsikibetuno;
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        zrnsikibetuno = pZrnsikibetuno;
    }

    private String zrnkoujyosyoumeisentakukbn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKOUJYOSYOUMEISENTAKUKBN)
    public String getZrnkoujyosyoumeisentakukbn() {
        return zrnkoujyosyoumeisentakukbn;
    }

    public void setZrnkoujyosyoumeisentakukbn(String pZrnkoujyosyoumeisentakukbn) {
        zrnkoujyosyoumeisentakukbn = pZrnkoujyosyoumeisentakukbn;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnshskyno;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnkyknmkn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKYKNMKN)
    public String getZrnkyknmkn() {
        return zrnkyknmkn;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkn(String pZrnkyknmkn) {
        zrnkyknmkn = pZrnkyknmkn;
    }

    private String zrnuktnmkn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNUKTNMKN)
    public String getZrnuktnmkn() {
        return zrnuktnmkn;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnmkn(String pZrnuktnmkn) {
        zrnuktnmkn = pZrnuktnmkn;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    @Id
    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return getPrimaryKey().getZrnsakunm15keta();
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        getPrimaryKey().setZrnsakunm15keta(pZrnsakunm15keta);
    }

    private String zrnyobiv48;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNYOBIV48)
    public String getZrnyobiv48() {
        return zrnyobiv48;
    }

    public void setZrnyobiv48(String pZrnyobiv48) {
        zrnyobiv48 = pZrnyobiv48;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnsyoumeinndseireki;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSYOUMEINNDSEIREKI)
    public String getZrnsyoumeinndseireki() {
        return zrnsyoumeinndseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyoumeinndseireki(String pZrnsyoumeinndseireki) {
        zrnsyoumeinndseireki = pZrnsyoumeinndseireki;
    }

    private String zrnuktnmknmeikj;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNUKTNMKNMEIKJ)
    public String getZrnuktnmknmeikj() {
        return zrnuktnmknmeikj;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnmknmeikj(String pZrnuktnmknmeikj) {
        zrnuktnmknmeikj = pZrnuktnmknmeikj;
    }

    private String zrnnenkinuktseiymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENKINUKTSEIYMDSEIREKI)
    public String getZrnnenkinuktseiymdseireki() {
        return zrnnenkinuktseiymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnnenkinuktseiymdseireki(String pZrnnenkinuktseiymdseireki) {
        zrnnenkinuktseiymdseireki = pZrnnenkinuktseiymdseireki;
    }

    private String zrnsyono3;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSYONO3)
    public String getZrnsyono3() {
        return zrnsyono3;
    }

    public void setZrnsyono3(String pZrnsyono3) {
        zrnsyono3 = pZrnsyono3;
    }

    private String zrnhknsyurui;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNHKNSYURUI)
    public String getZrnhknsyurui() {
        return zrnhknsyurui;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknsyurui(String pZrnhknsyurui) {
        zrnhknsyurui = pZrnhknsyurui;
    }

    private String zrnnknshrynnm;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNKNSHRYNNM)
    public String getZrnnknshrynnm() {
        return zrnnknshrynnm;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnnknshrynnm(String pZrnnknshrynnm) {
        zrnnknshrynnm = pZrnnknshrynnm;
    }

    private String zrnkykymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKYKYMDSEIREKI)
    public String getZrnkykymdseireki() {
        return zrnkykymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdseireki(String pZrnkykymdseireki) {
        zrnkykymdseireki = pZrnkykymdseireki;
    }

    private String zrnhtkinuthoukbn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNHTKINUTHOUKBN)
    public String getZrnhtkinuthoukbn() {
        return zrnhtkinuthoukbn;
    }

    public void setZrnhtkinuthoukbn(String pZrnhtkinuthoukbn) {
        zrnhtkinuthoukbn = pZrnhtkinuthoukbn;
    }

    private String zrnhknkknnm;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNHKNKKNNM)
    public String getZrnhknkknnm() {
        return zrnhknkknnm;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnhknkknnm(String pZrnhknkknnm) {
        zrnhknkknnm = pZrnhknkknnm;
    }

    private String zrnnkshrstartymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNKSHRSTARTYMDSEIREKI)
    public String getZrnnkshrstartymdseireki() {
        return zrnnkshrstartymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnnkshrstartymdseireki(String pZrnnkshrstartymdseireki) {
        zrnnkshrstartymdseireki = pZrnnkshrstartymdseireki;
    }

    private String zrnphrkkkn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNPHRKKKN)
    public String getZrnphrkkkn() {
        return zrnphrkkkn;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnphrkkkn(String pZrnphrkkkn) {
        zrnphrkkkn = pZrnphrkkkn;
    }

    private String zrnhrkkaisuunm;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNHRKKAISUUNM)
    public String getZrnhrkkaisuunm() {
        return zrnhrkkaisuunm;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnhrkkaisuunm(String pZrnhrkkaisuunm) {
        zrnhrkkaisuunm = pZrnhrkkaisuunm;
    }

    private String zrnkjnnkkoujyum;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKJNNKKOUJYUM)
    public String getZrnkjnnkkoujyum() {
        return zrnkjnnkkoujyum;
    }

    public void setZrnkjnnkkoujyum(String pZrnkjnnkkoujyum) {
        zrnkjnnkkoujyum = pZrnkjnnkkoujyum;
    }

    private String zrnuktmidasi;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNUKTMIDASI)
    public String getZrnuktmidasi() {
        return zrnuktmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktmidasi(String pZrnuktmidasi) {
        zrnuktmidasi = pZrnuktmidasi;
    }

    private String zrnmidasisub;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNMIDASISUB)
    public String getZrnmidasisub() {
        return zrnmidasisub;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasisub(String pZrnmidasisub) {
        zrnmidasisub = pZrnmidasisub;
    }

    private String zrnkoujyosyoumeifreearea;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKOUJYOSYOUMEIFREEAREA)
    public String getZrnkoujyosyoumeifreearea() {
        return zrnkoujyosyoumeifreearea;
    }

    @DataConvert("toMultiByte")
    public void setZrnkoujyosyoumeifreearea(String pZrnkoujyosyoumeifreearea) {
        zrnkoujyosyoumeifreearea = pZrnkoujyosyoumeifreearea;
    }

    private String zrnkoujyosyoumeimsgkbn;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKOUJYOSYOUMEIMSGKBN)
    public String getZrnkoujyosyoumeimsgkbn() {
        return zrnkoujyosyoumeimsgkbn;
    }

    public void setZrnkoujyosyoumeimsgkbn(String pZrnkoujyosyoumeimsgkbn) {
        zrnkoujyosyoumeimsgkbn = pZrnkoujyosyoumeimsgkbn;
    }

    private String zrnyobiv12;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private String zrnippanseimeip;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNIPPANSEIMEIP)
    public String getZrnippanseimeip() {
        return zrnippanseimeip;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnippanseimeip(String pZrnippanseimeip) {
        zrnippanseimeip = pZrnippanseimeip;
    }

    private String zrnippanhaitoukin;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNIPPANHAITOUKIN)
    public String getZrnippanhaitoukin() {
        return zrnippanhaitoukin;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnippanhaitoukin(String pZrnippanhaitoukin) {
        zrnippanhaitoukin = pZrnippanhaitoukin;
    }

    private String zrnippansyoumeigk;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNIPPANSYOUMEIGK)
    public String getZrnippansyoumeigk() {
        return zrnippansyoumeigk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnippansyoumeigk(String pZrnippansyoumeigk) {
        zrnippansyoumeigk = pZrnippansyoumeigk;
    }

    private String zrnkaigoiryoup;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKAIGOIRYOUP)
    public String getZrnkaigoiryoup() {
        return zrnkaigoiryoup;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnkaigoiryoup(String pZrnkaigoiryoup) {
        zrnkaigoiryoup = pZrnkaigoiryoup;
    }

    private String zrnkaigoiryoud;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKAIGOIRYOUD)
    public String getZrnkaigoiryoud() {
        return zrnkaigoiryoud;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnkaigoiryoud(String pZrnkaigoiryoud) {
        zrnkaigoiryoud = pZrnkaigoiryoud;
    }

    private String zrnkaigoiryousmgk;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNKAIGOIRYOUSMGK)
    public String getZrnkaigoiryousmgk() {
        return zrnkaigoiryousmgk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnkaigoiryousmgk(String pZrnkaigoiryousmgk) {
        zrnkaigoiryousmgk = pZrnkaigoiryousmgk;
    }

    private String zrnnenkinp;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENKINP)
    public String getZrnnenkinp() {
        return zrnnenkinp;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenkinp(String pZrnnenkinp) {
        zrnnenkinp = pZrnnenkinp;
    }

    private String zrnnenkind;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENKIND)
    public String getZrnnenkind() {
        return zrnnenkind;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenkind(String pZrnnenkind) {
        zrnnenkind = pZrnnenkind;
    }

    private String zrnnenkinsmgk;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENKINSMGK)
    public String getZrnnenkinsmgk() {
        return zrnnenkinsmgk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenkinsmgk(String pZrnnenkinsmgk) {
        zrnnenkinsmgk = pZrnnenkinsmgk;
    }

    private String zrnnewhknjytukikan;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNEWHKNJYTUKIKAN)
    public String getZrnnewhknjytukikan() {
        return zrnnewhknjytukikan;
    }

    @DataConvert("toMultiByte")
    public void setZrnnewhknjytukikan(String pZrnnewhknjytukikan) {
        zrnnewhknjytukikan = pZrnnewhknjytukikan;
    }

    private String zrnphrkkknjyoutai;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNPHRKKKNJYOUTAI)
    public String getZrnphrkkknjyoutai() {
        return zrnphrkkknjyoutai;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkkknjyoutai(String pZrnphrkkknjyoutai) {
        zrnphrkkknjyoutai = pZrnphrkkknjyoutai;
    }

    private String zrnsyoumeiymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNSYOUMEIYMDSEIREKI)
    public String getZrnsyoumeiymdseireki() {
        return zrnsyoumeiymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyoumeiymdseireki(String pZrnsyoumeiymdseireki) {
        zrnsyoumeiymdseireki = pZrnsyoumeiymdseireki;
    }

    private String zrnnenippanseimeip;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENIPPANSEIMEIP)
    public String getZrnnenippanseimeip() {
        return zrnnenippanseimeip;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenippanseimeip(String pZrnnenippanseimeip) {
        zrnnenippanseimeip = pZrnnenippanseimeip;
    }

    private String zrnnenippand;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENIPPAND)
    public String getZrnnenippand() {
        return zrnnenippand;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenippand(String pZrnnenippand) {
        zrnnenippand = pZrnnenippand;
    }

    private String zrnnenippansymgk;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENIPPANSYMGK)
    public String getZrnnenippansymgk() {
        return zrnnenippansymgk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenippansymgk(String pZrnnenippansymgk) {
        zrnnenippansymgk = pZrnnenippansymgk;
    }

    private String zrnnenkaigoiryoup;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENKAIGOIRYOUP)
    public String getZrnnenkaigoiryoup() {
        return zrnnenkaigoiryoup;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenkaigoiryoup(String pZrnnenkaigoiryoup) {
        zrnnenkaigoiryoup = pZrnnenkaigoiryoup;
    }

    private String zrnnenkaigoiryoud;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENKAIGOIRYOUD)
    public String getZrnnenkaigoiryoud() {
        return zrnnenkaigoiryoud;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnenkaigoiryoud(String pZrnnenkaigoiryoud) {
        zrnnenkaigoiryoud = pZrnnenkaigoiryoud;
    }

    private String zrnneniryousymgk;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENIRYOUSYMGK)
    public String getZrnneniryousymgk() {
        return zrnneniryousymgk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnneniryousymgk(String pZrnneniryousymgk) {
        zrnneniryousymgk = pZrnneniryousymgk;
    }

    private String zrnnennenkinp;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENNENKINP)
    public String getZrnnennenkinp() {
        return zrnnennenkinp;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnennenkinp(String pZrnnennenkinp) {
        zrnnennenkinp = pZrnnennenkinp;
    }

    private String zrnnennenkind;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENNENKIND)
    public String getZrnnennenkind() {
        return zrnnennenkind;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnennenkind(String pZrnnennenkind) {
        zrnnennenkind = pZrnnennenkind;
    }

    private String zrnnennenkinsmgk;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNNENNENKINSMGK)
    public String getZrnnennenkinsmgk() {
        return zrnnennenkinsmgk;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnnennenkinsmgk(String pZrnnennenkinsmgk) {
        zrnnennenkinsmgk = pZrnnennenkinsmgk;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_KoujyoSyoumeiRn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }
}