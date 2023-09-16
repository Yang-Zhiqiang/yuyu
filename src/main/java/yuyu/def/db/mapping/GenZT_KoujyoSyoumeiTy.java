package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiTy;
import yuyu.def.db.id.PKZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.GenQZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiTy;

/**
 * 控除証明書Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KoujyoSyoumeiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KoujyoSyoumeiTy}</td><td colspan="3">控除証明書Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_KoujyoSyoumeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KoujyoSyoumeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn ztysyodouhuukbn}</td><td>（中継用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoujyosyoumeisentakukbn ztykoujyosyoumeisentakukbn}</td><td>（中継用）控除証明選択区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43 ztyyobiv43}</td><td>（中継用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkj ztyshsnmkj}</td><td>（中継用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkn ztykyknmkn}</td><td>（中継用）契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnmkn ztyuktnmkn}</td><td>（中継用）受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtysakunm15keta ztysakunm15keta}</td><td>（中継用）作成番号（１５桁）</td><td align="center">{@link PKZT_KoujyoSyoumeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv48 ztyyobiv48}</td><td>（中継用）予備項目Ｖ４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumeinndseireki ztysyoumeinndseireki}</td><td>（中継用）証明年度（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnmknmeikj ztyuktnmknmeikj}</td><td>（中継用）受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinuktseiymdseireki ztynenkinuktseiymdseireki}</td><td>（中継用）年金受取人生年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono3 ztysyono3}</td><td>（中継用）証券番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyurui ztyhknsyurui}</td><td>（中継用）保険種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshrynnm ztynknshrynnm}</td><td>（中継用）年金支払期間（数）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdseireki ztykykymdseireki}</td><td>（中継用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtkinuthoukbn ztyhtkinuthoukbn}</td><td>（中継用）配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkknnm ztyhknkknnm}</td><td>（中継用）保険期間（数）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrstartymdseireki ztynkshrstartymdseireki}</td><td>（中継用）年金支払開始日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkkn ztyphrkkkn}</td><td>（中継用）保険料払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuunm ztyhrkkaisuunm}</td><td>（中継用）払込回数（数）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjnnkkoujyum ztykjnnkkoujyum}</td><td>（中継用）個人年金控除有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasi ztyuktmidasi}</td><td>（中継用）受取人見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasisub ztymidasisub}</td><td>（中継用）見出し副題</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoujyosyoumeifreearea ztykoujyosyoumeifreearea}</td><td>（中継用）控除証明書フリーエリア</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoujyosyoumeimsgkbn ztykoujyosyoumeimsgkbn}</td><td>（中継用）控除証明メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyippanseimeip ztyippanseimeip}</td><td>（中継用）一般生命保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyippanhaitoukin ztyippanhaitoukin}</td><td>（中継用）一般配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyippansyoumeigk ztyippansyoumeigk}</td><td>（中継用）一般証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoiryoup ztykaigoiryoup}</td><td>（中継用）介護医療保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoiryoud ztykaigoiryoud}</td><td>（中継用）介護医療配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoiryousmgk ztykaigoiryousmgk}</td><td>（中継用）介護医療証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinp ztynenkinp}</td><td>（中継用）年金保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkind ztynenkind}</td><td>（中継用）年金配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsmgk ztynenkinsmgk}</td><td>（中継用）年金証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynewhknjytukikan ztynewhknjytukikan}</td><td>（中継用）新制度保険充当期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkknjyoutai ztyphrkkknjyoutai}</td><td>（中継用）保険料払込状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumeiymdseireki ztysyoumeiymdseireki}</td><td>（中継用）証明日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenippanseimeip ztynenippanseimeip}</td><td>（中継用）年間一般生命保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenippand ztynenippand}</td><td>（中継用）年間一般配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenippansymgk ztynenippansymgk}</td><td>（中継用）年間一般証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkaigoiryoup ztynenkaigoiryoup}</td><td>（中継用）年間介護医療保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkaigoiryoud ztynenkaigoiryoud}</td><td>（中継用）年間介護医療配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyneniryousymgk ztyneniryousymgk}</td><td>（中継用）年間介護医療証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynennenkinp ztynennenkinp}</td><td>（中継用）年間年金保険料（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynennenkind ztynennenkind}</td><td>（中継用）年間年金配当金（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynennenkinsmgk ztynennenkinsmgk}</td><td>（中継用）年間年金証明額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KoujyoSyoumeiTy
 * @see     PKZT_KoujyoSyoumeiTy
 * @see     QZT_KoujyoSyoumeiTy
 * @see     GenQZT_KoujyoSyoumeiTy
 */
@MappedSuperclass
@Table(name=GenZT_KoujyoSyoumeiTy.TABLE_NAME)
@IdClass(value=PKZT_KoujyoSyoumeiTy.class)
public abstract class GenZT_KoujyoSyoumeiTy extends AbstractExDBEntity<ZT_KoujyoSyoumeiTy, PKZT_KoujyoSyoumeiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KoujyoSyoumeiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYSYODOUHUUKBN          = "ztysyodouhuukbn";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYKOUJYOSYOUMEISENTAKUKBN = "ztykoujyosyoumeisentakukbn";
    public static final String ZTYYOBIV43               = "ztyyobiv43";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJ               = "ztyshsnmkj";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYKYKNMKN               = "ztykyknmkn";
    public static final String ZTYUKTNMKN               = "ztyuktnmkn";
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
    public static final String ZTYYOBIV48               = "ztyyobiv48";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYSYOUMEINNDSEIREKI     = "ztysyoumeinndseireki";
    public static final String ZTYUKTNMKNMEIKJ          = "ztyuktnmknmeikj";
    public static final String ZTYNENKINUKTSEIYMDSEIREKI = "ztynenkinuktseiymdseireki";
    public static final String ZTYSYONO3                = "ztysyono3";
    public static final String ZTYHKNSYURUI             = "ztyhknsyurui";
    public static final String ZTYNKNSHRYNNM            = "ztynknshrynnm";
    public static final String ZTYKYKYMDSEIREKI         = "ztykykymdseireki";
    public static final String ZTYHTKINUTHOUKBN         = "ztyhtkinuthoukbn";
    public static final String ZTYHKNKKNNM              = "ztyhknkknnm";
    public static final String ZTYNKSHRSTARTYMDSEIREKI  = "ztynkshrstartymdseireki";
    public static final String ZTYPHRKKKN               = "ztyphrkkkn";
    public static final String ZTYHRKKAISUUNM           = "ztyhrkkaisuunm";
    public static final String ZTYKJNNKKOUJYUM          = "ztykjnnkkoujyum";
    public static final String ZTYUKTMIDASI             = "ztyuktmidasi";
    public static final String ZTYMIDASISUB             = "ztymidasisub";
    public static final String ZTYKOUJYOSYOUMEIFREEAREA = "ztykoujyosyoumeifreearea";
    public static final String ZTYKOUJYOSYOUMEIMSGKBN   = "ztykoujyosyoumeimsgkbn";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYIPPANSEIMEIP          = "ztyippanseimeip";
    public static final String ZTYIPPANHAITOUKIN        = "ztyippanhaitoukin";
    public static final String ZTYIPPANSYOUMEIGK        = "ztyippansyoumeigk";
    public static final String ZTYKAIGOIRYOUP           = "ztykaigoiryoup";
    public static final String ZTYKAIGOIRYOUD           = "ztykaigoiryoud";
    public static final String ZTYKAIGOIRYOUSMGK        = "ztykaigoiryousmgk";
    public static final String ZTYNENKINP               = "ztynenkinp";
    public static final String ZTYNENKIND               = "ztynenkind";
    public static final String ZTYNENKINSMGK            = "ztynenkinsmgk";
    public static final String ZTYNEWHKNJYTUKIKAN       = "ztynewhknjytukikan";
    public static final String ZTYPHRKKKNJYOUTAI        = "ztyphrkkknjyoutai";
    public static final String ZTYSYOUMEIYMDSEIREKI     = "ztysyoumeiymdseireki";
    public static final String ZTYNENIPPANSEIMEIP       = "ztynenippanseimeip";
    public static final String ZTYNENIPPAND             = "ztynenippand";
    public static final String ZTYNENIPPANSYMGK         = "ztynenippansymgk";
    public static final String ZTYNENKAIGOIRYOUP        = "ztynenkaigoiryoup";
    public static final String ZTYNENKAIGOIRYOUD        = "ztynenkaigoiryoud";
    public static final String ZTYNENIRYOUSYMGK         = "ztyneniryousymgk";
    public static final String ZTYNENNENKINP            = "ztynennenkinp";
    public static final String ZTYNENNENKIND            = "ztynennenkind";
    public static final String ZTYNENNENKINSMGK         = "ztynennenkinsmgk";
    public static final String ZTYYOBIV24               = "ztyyobiv24";

    private final PKZT_KoujyoSyoumeiTy primaryKey;

    public GenZT_KoujyoSyoumeiTy() {
        primaryKey = new PKZT_KoujyoSyoumeiTy();
    }

    public GenZT_KoujyoSyoumeiTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysakunm15keta
    ) {
        primaryKey = new PKZT_KoujyoSyoumeiTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysakunm15keta
        );
    }

    @Transient
    @Override
    public PKZT_KoujyoSyoumeiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KoujyoSyoumeiTy> getMetaClass() {
        return QZT_KoujyoSyoumeiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztysyodouhuukbn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSYODOUHUUKBN)
    public String getZtysyodouhuukbn() {
        return ztysyodouhuukbn;
    }

    public void setZtysyodouhuukbn(String pZtysyodouhuukbn) {
        ztysyodouhuukbn = pZtysyodouhuukbn;
    }

    private String ztysikibetuno;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

    private String ztykoujyosyoumeisentakukbn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKOUJYOSYOUMEISENTAKUKBN)
    public String getZtykoujyosyoumeisentakukbn() {
        return ztykoujyosyoumeisentakukbn;
    }

    public void setZtykoujyosyoumeisentakukbn(String pZtykoujyosyoumeisentakukbn) {
        ztykoujyosyoumeisentakukbn = pZtykoujyosyoumeisentakukbn;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyshskyno;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztykyknmkn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKYKNMKN)
    public String getZtykyknmkn() {
        return ztykyknmkn;
    }

    public void setZtykyknmkn(String pZtykyknmkn) {
        ztykyknmkn = pZtykyknmkn;
    }

    private String ztyuktnmkn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYUKTNMKN)
    public String getZtyuktnmkn() {
        return ztyuktnmkn;
    }

    public void setZtyuktnmkn(String pZtyuktnmkn) {
        ztyuktnmkn = pZtyuktnmkn;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    @Id
    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return getPrimaryKey().getZtysakunm15keta();
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        getPrimaryKey().setZtysakunm15keta(pZtysakunm15keta);
    }

    private String ztyyobiv48;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYYOBIV48)
    public String getZtyyobiv48() {
        return ztyyobiv48;
    }

    public void setZtyyobiv48(String pZtyyobiv48) {
        ztyyobiv48 = pZtyyobiv48;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztysyoumeinndseireki;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSYOUMEINNDSEIREKI)
    public String getZtysyoumeinndseireki() {
        return ztysyoumeinndseireki;
    }

    public void setZtysyoumeinndseireki(String pZtysyoumeinndseireki) {
        ztysyoumeinndseireki = pZtysyoumeinndseireki;
    }

    private String ztyuktnmknmeikj;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYUKTNMKNMEIKJ)
    public String getZtyuktnmknmeikj() {
        return ztyuktnmknmeikj;
    }

    public void setZtyuktnmknmeikj(String pZtyuktnmknmeikj) {
        ztyuktnmknmeikj = pZtyuktnmknmeikj;
    }

    private String ztynenkinuktseiymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENKINUKTSEIYMDSEIREKI)
    public String getZtynenkinuktseiymdseireki() {
        return ztynenkinuktseiymdseireki;
    }

    public void setZtynenkinuktseiymdseireki(String pZtynenkinuktseiymdseireki) {
        ztynenkinuktseiymdseireki = pZtynenkinuktseiymdseireki;
    }

    private String ztysyono3;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSYONO3)
    public String getZtysyono3() {
        return ztysyono3;
    }

    public void setZtysyono3(String pZtysyono3) {
        ztysyono3 = pZtysyono3;
    }

    private String ztyhknsyurui;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYHKNSYURUI)
    public String getZtyhknsyurui() {
        return ztyhknsyurui;
    }

    public void setZtyhknsyurui(String pZtyhknsyurui) {
        ztyhknsyurui = pZtyhknsyurui;
    }

    private String ztynknshrynnm;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNKNSHRYNNM)
    public String getZtynknshrynnm() {
        return ztynknshrynnm;
    }

    public void setZtynknshrynnm(String pZtynknshrynnm) {
        ztynknshrynnm = pZtynknshrynnm;
    }

    private String ztykykymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKYKYMDSEIREKI)
    public String getZtykykymdseireki() {
        return ztykykymdseireki;
    }

    public void setZtykykymdseireki(String pZtykykymdseireki) {
        ztykykymdseireki = pZtykykymdseireki;
    }

    private String ztyhtkinuthoukbn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYHTKINUTHOUKBN)
    public String getZtyhtkinuthoukbn() {
        return ztyhtkinuthoukbn;
    }

    public void setZtyhtkinuthoukbn(String pZtyhtkinuthoukbn) {
        ztyhtkinuthoukbn = pZtyhtkinuthoukbn;
    }

    private String ztyhknkknnm;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYHKNKKNNM)
    public String getZtyhknkknnm() {
        return ztyhknkknnm;
    }

    public void setZtyhknkknnm(String pZtyhknkknnm) {
        ztyhknkknnm = pZtyhknkknnm;
    }

    private String ztynkshrstartymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNKSHRSTARTYMDSEIREKI)
    public String getZtynkshrstartymdseireki() {
        return ztynkshrstartymdseireki;
    }

    public void setZtynkshrstartymdseireki(String pZtynkshrstartymdseireki) {
        ztynkshrstartymdseireki = pZtynkshrstartymdseireki;
    }

    private String ztyphrkkkn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYPHRKKKN)
    public String getZtyphrkkkn() {
        return ztyphrkkkn;
    }

    public void setZtyphrkkkn(String pZtyphrkkkn) {
        ztyphrkkkn = pZtyphrkkkn;
    }

    private String ztyhrkkaisuunm;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYHRKKAISUUNM)
    public String getZtyhrkkaisuunm() {
        return ztyhrkkaisuunm;
    }

    public void setZtyhrkkaisuunm(String pZtyhrkkaisuunm) {
        ztyhrkkaisuunm = pZtyhrkkaisuunm;
    }

    private String ztykjnnkkoujyum;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKJNNKKOUJYUM)
    public String getZtykjnnkkoujyum() {
        return ztykjnnkkoujyum;
    }

    public void setZtykjnnkkoujyum(String pZtykjnnkkoujyum) {
        ztykjnnkkoujyum = pZtykjnnkkoujyum;
    }

    private String ztyuktmidasi;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYUKTMIDASI)
    public String getZtyuktmidasi() {
        return ztyuktmidasi;
    }

    public void setZtyuktmidasi(String pZtyuktmidasi) {
        ztyuktmidasi = pZtyuktmidasi;
    }

    private String ztymidasisub;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYMIDASISUB)
    public String getZtymidasisub() {
        return ztymidasisub;
    }

    public void setZtymidasisub(String pZtymidasisub) {
        ztymidasisub = pZtymidasisub;
    }

    private String ztykoujyosyoumeifreearea;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKOUJYOSYOUMEIFREEAREA)
    public String getZtykoujyosyoumeifreearea() {
        return ztykoujyosyoumeifreearea;
    }

    public void setZtykoujyosyoumeifreearea(String pZtykoujyosyoumeifreearea) {
        ztykoujyosyoumeifreearea = pZtykoujyosyoumeifreearea;
    }

    private String ztykoujyosyoumeimsgkbn;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKOUJYOSYOUMEIMSGKBN)
    public String getZtykoujyosyoumeimsgkbn() {
        return ztykoujyosyoumeimsgkbn;
    }

    public void setZtykoujyosyoumeimsgkbn(String pZtykoujyosyoumeimsgkbn) {
        ztykoujyosyoumeimsgkbn = pZtykoujyosyoumeimsgkbn;
    }

    private String ztyyobiv12;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztyippanseimeip;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYIPPANSEIMEIP)
    public String getZtyippanseimeip() {
        return ztyippanseimeip;
    }

    public void setZtyippanseimeip(String pZtyippanseimeip) {
        ztyippanseimeip = pZtyippanseimeip;
    }

    private String ztyippanhaitoukin;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYIPPANHAITOUKIN)
    public String getZtyippanhaitoukin() {
        return ztyippanhaitoukin;
    }

    public void setZtyippanhaitoukin(String pZtyippanhaitoukin) {
        ztyippanhaitoukin = pZtyippanhaitoukin;
    }

    private String ztyippansyoumeigk;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYIPPANSYOUMEIGK)
    public String getZtyippansyoumeigk() {
        return ztyippansyoumeigk;
    }

    public void setZtyippansyoumeigk(String pZtyippansyoumeigk) {
        ztyippansyoumeigk = pZtyippansyoumeigk;
    }

    private String ztykaigoiryoup;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKAIGOIRYOUP)
    public String getZtykaigoiryoup() {
        return ztykaigoiryoup;
    }

    public void setZtykaigoiryoup(String pZtykaigoiryoup) {
        ztykaigoiryoup = pZtykaigoiryoup;
    }

    private String ztykaigoiryoud;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKAIGOIRYOUD)
    public String getZtykaigoiryoud() {
        return ztykaigoiryoud;
    }

    public void setZtykaigoiryoud(String pZtykaigoiryoud) {
        ztykaigoiryoud = pZtykaigoiryoud;
    }

    private String ztykaigoiryousmgk;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYKAIGOIRYOUSMGK)
    public String getZtykaigoiryousmgk() {
        return ztykaigoiryousmgk;
    }

    public void setZtykaigoiryousmgk(String pZtykaigoiryousmgk) {
        ztykaigoiryousmgk = pZtykaigoiryousmgk;
    }

    private String ztynenkinp;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENKINP)
    public String getZtynenkinp() {
        return ztynenkinp;
    }

    public void setZtynenkinp(String pZtynenkinp) {
        ztynenkinp = pZtynenkinp;
    }

    private String ztynenkind;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENKIND)
    public String getZtynenkind() {
        return ztynenkind;
    }

    public void setZtynenkind(String pZtynenkind) {
        ztynenkind = pZtynenkind;
    }

    private String ztynenkinsmgk;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENKINSMGK)
    public String getZtynenkinsmgk() {
        return ztynenkinsmgk;
    }

    public void setZtynenkinsmgk(String pZtynenkinsmgk) {
        ztynenkinsmgk = pZtynenkinsmgk;
    }

    private String ztynewhknjytukikan;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNEWHKNJYTUKIKAN)
    public String getZtynewhknjytukikan() {
        return ztynewhknjytukikan;
    }

    public void setZtynewhknjytukikan(String pZtynewhknjytukikan) {
        ztynewhknjytukikan = pZtynewhknjytukikan;
    }

    private String ztyphrkkknjyoutai;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYPHRKKKNJYOUTAI)
    public String getZtyphrkkknjyoutai() {
        return ztyphrkkknjyoutai;
    }

    public void setZtyphrkkknjyoutai(String pZtyphrkkknjyoutai) {
        ztyphrkkknjyoutai = pZtyphrkkknjyoutai;
    }

    private String ztysyoumeiymdseireki;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYSYOUMEIYMDSEIREKI)
    public String getZtysyoumeiymdseireki() {
        return ztysyoumeiymdseireki;
    }

    public void setZtysyoumeiymdseireki(String pZtysyoumeiymdseireki) {
        ztysyoumeiymdseireki = pZtysyoumeiymdseireki;
    }

    private String ztynenippanseimeip;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENIPPANSEIMEIP)
    public String getZtynenippanseimeip() {
        return ztynenippanseimeip;
    }

    public void setZtynenippanseimeip(String pZtynenippanseimeip) {
        ztynenippanseimeip = pZtynenippanseimeip;
    }

    private String ztynenippand;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENIPPAND)
    public String getZtynenippand() {
        return ztynenippand;
    }

    public void setZtynenippand(String pZtynenippand) {
        ztynenippand = pZtynenippand;
    }

    private String ztynenippansymgk;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENIPPANSYMGK)
    public String getZtynenippansymgk() {
        return ztynenippansymgk;
    }

    public void setZtynenippansymgk(String pZtynenippansymgk) {
        ztynenippansymgk = pZtynenippansymgk;
    }

    private String ztynenkaigoiryoup;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENKAIGOIRYOUP)
    public String getZtynenkaigoiryoup() {
        return ztynenkaigoiryoup;
    }

    public void setZtynenkaigoiryoup(String pZtynenkaigoiryoup) {
        ztynenkaigoiryoup = pZtynenkaigoiryoup;
    }

    private String ztynenkaigoiryoud;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENKAIGOIRYOUD)
    public String getZtynenkaigoiryoud() {
        return ztynenkaigoiryoud;
    }

    public void setZtynenkaigoiryoud(String pZtynenkaigoiryoud) {
        ztynenkaigoiryoud = pZtynenkaigoiryoud;
    }

    private String ztyneniryousymgk;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENIRYOUSYMGK)
    public String getZtyneniryousymgk() {
        return ztyneniryousymgk;
    }

    public void setZtyneniryousymgk(String pZtyneniryousymgk) {
        ztyneniryousymgk = pZtyneniryousymgk;
    }

    private String ztynennenkinp;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENNENKINP)
    public String getZtynennenkinp() {
        return ztynennenkinp;
    }

    public void setZtynennenkinp(String pZtynennenkinp) {
        ztynennenkinp = pZtynennenkinp;
    }

    private String ztynennenkind;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENNENKIND)
    public String getZtynennenkind() {
        return ztynennenkind;
    }

    public void setZtynennenkind(String pZtynennenkind) {
        ztynennenkind = pZtynennenkind;
    }

    private String ztynennenkinsmgk;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYNENNENKINSMGK)
    public String getZtynennenkinsmgk() {
        return ztynennenkinsmgk;
    }

    public void setZtynennenkinsmgk(String pZtynennenkinsmgk) {
        ztynennenkinsmgk = pZtynennenkinsmgk;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_KoujyoSyoumeiTy.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }
}