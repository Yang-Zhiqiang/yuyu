package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiRn;
import yuyu.def.db.id.PKZT_KijituTouraiAnnaiRn;
import yuyu.def.db.meta.GenQZT_KijituTouraiAnnaiRn;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiRn;

/**
 * 期日到来案内テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KijituTouraiAnnaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KijituTouraiAnnaiRn}</td><td colspan="3">期日到来案内テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_KijituTouraiAnnaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KijituTouraiAnnaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnyobiv60 zrnyobiv60}</td><td>（連携用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutinm zrntuutinm}</td><td>（連携用）通知名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta1 zrnhurikaeyokokumsg32keta1}</td><td>（連携用）振替予告メッセージ（３２桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta2 zrnhurikaeyokokumsg32keta2}</td><td>（連携用）振替予告メッセージ（３２桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta3 zrnhurikaeyokokumsg32keta3}</td><td>（連携用）振替予告メッセージ（３２桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta4 zrnhurikaeyokokumsg32keta4}</td><td>（連携用）振替予告メッセージ（３２桁）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta5 zrnhurikaeyokokumsg32keta5}</td><td>（連携用）振替予告メッセージ（３２桁）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta6 zrnhurikaeyokokumsg32keta6}</td><td>（連携用）振替予告メッセージ（３２桁）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta7 zrnhurikaeyokokumsg32keta7}</td><td>（連携用）振替予告メッセージ（３２桁）７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg32keta8 zrnhurikaeyokokumsg32keta8}</td><td>（連携用）振替予告メッセージ（３２桁）８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv110 zrnyobiv110}</td><td>（連携用）予備項目Ｖ１１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeiro zrnhrkkeiro}</td><td>（連携用）払込経路</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhnnm zrnsyouhnnm}</td><td>（連携用）商品名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdseireki zrnkykymdseireki}</td><td>（連携用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv30 zrnyobiv30}</td><td>（連携用）予備項目Ｖ３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea1 zrnkjttrnnfreearea1}</td><td>（連携用）期日到来案内フリーエリア１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea2 zrnkjttrnnfreearea2}</td><td>（連携用）期日到来案内フリーエリア２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea3 zrnkjttrnnfreearea3}</td><td>（連携用）期日到来案内フリーエリア３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea4 zrnkjttrnnfreearea4}</td><td>（連携用）期日到来案内フリーエリア４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea5 zrnkjttrnnfreearea5}</td><td>（連携用）期日到来案内フリーエリア５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea6 zrnkjttrnnfreearea6}</td><td>（連携用）期日到来案内フリーエリア６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea7 zrnkjttrnnfreearea7}</td><td>（連携用）期日到来案内フリーエリア７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv99 zrnyobiv99}</td><td>（連携用）予備項目Ｖ９９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x6 zrnansyuyouyobin10x6}</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutisakuseiymdseireki zrntuutisakuseiymdseireki}</td><td>（連携用）通知作成年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeymdseireki zrnkzhurikaeymdseireki}</td><td>（連携用）口座振替日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo1 zrnkzinfo1}</td><td>（連携用）口座情報１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo2 zrnkzinfo2}</td><td>（連携用）口座情報２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo3 zrnkzinfo3}</td><td>（連携用）口座情報３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo4 zrnkzinfo4}</td><td>（連携用）口座情報４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo5 zrnkzinfo5}</td><td>（連携用）口座情報５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo6 zrnkzinfo6}</td><td>（連携用）口座情報６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo7 zrnkzinfo7}</td><td>（連携用）口座情報７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzinfo8 zrnkzinfo8}</td><td>（連携用）口座情報８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknjytukikan zrnhknjytukikan}</td><td>（連携用）保険料充当期間</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgk1 zrnhrkgk1}</td><td>（連携用）払込金額１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgk2 zrnhrkgk2}</td><td>（連携用）払込金額２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgk3 zrnhrkgk3}</td><td>（連携用）払込金額３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgk4 zrnhrkgk4}</td><td>（連携用）払込金額４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv146 zrnyobiv146}</td><td>（連携用）予備項目Ｖ１４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x7 zrnansyuyouyobin10x7}</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea8 zrnkjttrnnfreearea8}</td><td>（連携用）期日到来案内フリーエリア８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea9 zrnkjttrnnfreearea9}</td><td>（連携用）期日到来案内フリーエリア９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea10 zrnkjttrnnfreearea10}</td><td>（連携用）期日到来案内フリーエリア１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea11 zrnkjttrnnfreearea11}</td><td>（連携用）期日到来案内フリーエリア１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea12 zrnkjttrnnfreearea12}</td><td>（連携用）期日到来案内フリーエリア１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjttrnnfreearea13 zrnkjttrnnfreearea13}</td><td>（連携用）期日到来案内フリーエリア１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv84 zrnyobiv84}</td><td>（連携用）予備項目Ｖ８４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x8 zrnansyuyouyobin10x8}</td><td>（連携用）案内収納用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KijituTouraiAnnaiRn
 * @see     PKZT_KijituTouraiAnnaiRn
 * @see     QZT_KijituTouraiAnnaiRn
 * @see     GenQZT_KijituTouraiAnnaiRn
 */
@MappedSuperclass
@Table(name=GenZT_KijituTouraiAnnaiRn.TABLE_NAME)
@IdClass(value=PKZT_KijituTouraiAnnaiRn.class)
public abstract class GenZT_KijituTouraiAnnaiRn extends AbstractExDBEntityForZDB<ZT_KijituTouraiAnnaiRn, PKZT_KijituTouraiAnnaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KijituTouraiAnnaiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
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
    public static final String ZRNYOBIV60               = "zrnyobiv60";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNTUUTINM               = "zrntuutinm";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA1 = "zrnhurikaeyokokumsg32keta1";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA2 = "zrnhurikaeyokokumsg32keta2";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA3 = "zrnhurikaeyokokumsg32keta3";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA4 = "zrnhurikaeyokokumsg32keta4";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA5 = "zrnhurikaeyokokumsg32keta5";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA6 = "zrnhurikaeyokokumsg32keta6";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA7 = "zrnhurikaeyokokumsg32keta7";
    public static final String ZRNHURIKAEYOKOKUMSG32KETA8 = "zrnhurikaeyokokumsg32keta8";
    public static final String ZRNYOBIV110              = "zrnyobiv110";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNHRKKEIRO              = "zrnhrkkeiro";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNSYOUHNNM              = "zrnsyouhnnm";
    public static final String ZRNKYKYMDSEIREKI         = "zrnkykymdseireki";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNYOBIV30               = "zrnyobiv30";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";
    public static final String ZRNKJTTRNNFREEAREA1      = "zrnkjttrnnfreearea1";
    public static final String ZRNKJTTRNNFREEAREA2      = "zrnkjttrnnfreearea2";
    public static final String ZRNKJTTRNNFREEAREA3      = "zrnkjttrnnfreearea3";
    public static final String ZRNKJTTRNNFREEAREA4      = "zrnkjttrnnfreearea4";
    public static final String ZRNKJTTRNNFREEAREA5      = "zrnkjttrnnfreearea5";
    public static final String ZRNKJTTRNNFREEAREA6      = "zrnkjttrnnfreearea6";
    public static final String ZRNKJTTRNNFREEAREA7      = "zrnkjttrnnfreearea7";
    public static final String ZRNYOBIV99               = "zrnyobiv99";
    public static final String ZRNANSYUYOUYOBIN10X6     = "zrnansyuyouyobin10x6";
    public static final String ZRNTUUTISAKUSEIYMDSEIREKI = "zrntuutisakuseiymdseireki";
    public static final String ZRNKZHURIKAEYMDSEIREKI   = "zrnkzhurikaeymdseireki";
    public static final String ZRNKZINFO1               = "zrnkzinfo1";
    public static final String ZRNKZINFO2               = "zrnkzinfo2";
    public static final String ZRNKZINFO3               = "zrnkzinfo3";
    public static final String ZRNKZINFO4               = "zrnkzinfo4";
    public static final String ZRNKZINFO5               = "zrnkzinfo5";
    public static final String ZRNKZINFO6               = "zrnkzinfo6";
    public static final String ZRNKZINFO7               = "zrnkzinfo7";
    public static final String ZRNKZINFO8               = "zrnkzinfo8";
    public static final String ZRNHKNJYTUKIKAN          = "zrnhknjytukikan";
    public static final String ZRNHRKGK1                = "zrnhrkgk1";
    public static final String ZRNHRKGK2                = "zrnhrkgk2";
    public static final String ZRNHRKGK3                = "zrnhrkgk3";
    public static final String ZRNHRKGK4                = "zrnhrkgk4";
    public static final String ZRNYOBIV146              = "zrnyobiv146";
    public static final String ZRNANSYUYOUYOBIN10X7     = "zrnansyuyouyobin10x7";
    public static final String ZRNKJTTRNNFREEAREA8      = "zrnkjttrnnfreearea8";
    public static final String ZRNKJTTRNNFREEAREA9      = "zrnkjttrnnfreearea9";
    public static final String ZRNKJTTRNNFREEAREA10     = "zrnkjttrnnfreearea10";
    public static final String ZRNKJTTRNNFREEAREA11     = "zrnkjttrnnfreearea11";
    public static final String ZRNKJTTRNNFREEAREA12     = "zrnkjttrnnfreearea12";
    public static final String ZRNKJTTRNNFREEAREA13     = "zrnkjttrnnfreearea13";
    public static final String ZRNYOBIV84               = "zrnyobiv84";
    public static final String ZRNANSYUYOUYOBIN10X8     = "zrnansyuyouyobin10x8";

    private final PKZT_KijituTouraiAnnaiRn primaryKey;

    public GenZT_KijituTouraiAnnaiRn() {
        primaryKey = new PKZT_KijituTouraiAnnaiRn();
    }

    public GenZT_KijituTouraiAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_KijituTouraiAnnaiRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_KijituTouraiAnnaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KijituTouraiAnnaiRn> getMetaClass() {
        return QZT_KijituTouraiAnnaiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnyobiv9;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv60;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV60)
    public String getZrnyobiv60() {
        return zrnyobiv60;
    }

    public void setZrnyobiv60(String pZrnyobiv60) {
        zrnyobiv60 = pZrnyobiv60;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrntuutinm;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTUUTINM)
    public String getZrntuutinm() {
        return zrntuutinm;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutinm(String pZrntuutinm) {
        zrntuutinm = pZrntuutinm;
    }

    private String zrnhurikaeyokokumsg32keta1;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA1)
    public String getZrnhurikaeyokokumsg32keta1() {
        return zrnhurikaeyokokumsg32keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta1(String pZrnhurikaeyokokumsg32keta1) {
        zrnhurikaeyokokumsg32keta1 = pZrnhurikaeyokokumsg32keta1;
    }

    private String zrnhurikaeyokokumsg32keta2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA2)
    public String getZrnhurikaeyokokumsg32keta2() {
        return zrnhurikaeyokokumsg32keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta2(String pZrnhurikaeyokokumsg32keta2) {
        zrnhurikaeyokokumsg32keta2 = pZrnhurikaeyokokumsg32keta2;
    }

    private String zrnhurikaeyokokumsg32keta3;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA3)
    public String getZrnhurikaeyokokumsg32keta3() {
        return zrnhurikaeyokokumsg32keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta3(String pZrnhurikaeyokokumsg32keta3) {
        zrnhurikaeyokokumsg32keta3 = pZrnhurikaeyokokumsg32keta3;
    }

    private String zrnhurikaeyokokumsg32keta4;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA4)
    public String getZrnhurikaeyokokumsg32keta4() {
        return zrnhurikaeyokokumsg32keta4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta4(String pZrnhurikaeyokokumsg32keta4) {
        zrnhurikaeyokokumsg32keta4 = pZrnhurikaeyokokumsg32keta4;
    }

    private String zrnhurikaeyokokumsg32keta5;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA5)
    public String getZrnhurikaeyokokumsg32keta5() {
        return zrnhurikaeyokokumsg32keta5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta5(String pZrnhurikaeyokokumsg32keta5) {
        zrnhurikaeyokokumsg32keta5 = pZrnhurikaeyokokumsg32keta5;
    }

    private String zrnhurikaeyokokumsg32keta6;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA6)
    public String getZrnhurikaeyokokumsg32keta6() {
        return zrnhurikaeyokokumsg32keta6;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta6(String pZrnhurikaeyokokumsg32keta6) {
        zrnhurikaeyokokumsg32keta6 = pZrnhurikaeyokokumsg32keta6;
    }

    private String zrnhurikaeyokokumsg32keta7;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA7)
    public String getZrnhurikaeyokokumsg32keta7() {
        return zrnhurikaeyokokumsg32keta7;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta7(String pZrnhurikaeyokokumsg32keta7) {
        zrnhurikaeyokokumsg32keta7 = pZrnhurikaeyokokumsg32keta7;
    }

    private String zrnhurikaeyokokumsg32keta8;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHURIKAEYOKOKUMSG32KETA8)
    public String getZrnhurikaeyokokumsg32keta8() {
        return zrnhurikaeyokokumsg32keta8;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg32keta8(String pZrnhurikaeyokokumsg32keta8) {
        zrnhurikaeyokokumsg32keta8 = pZrnhurikaeyokokumsg32keta8;
    }

    private String zrnyobiv110;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV110)
    public String getZrnyobiv110() {
        return zrnyobiv110;
    }

    public void setZrnyobiv110(String pZrnyobiv110) {
        zrnyobiv110 = pZrnyobiv110;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnhrkkeiro;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHRKKEIRO)
    public String getZrnhrkkeiro() {
        return zrnhrkkeiro;
    }

    public void setZrnhrkkeiro(String pZrnhrkkeiro) {
        zrnhrkkeiro = pZrnhrkkeiro;
    }

    private String zrnsyono2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnsyouhnnm;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNSYOUHNNM)
    public String getZrnsyouhnnm() {
        return zrnsyouhnnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyouhnnm(String pZrnsyouhnnm) {
        zrnsyouhnnm = pZrnsyouhnnm;
    }

    private String zrnkykymdseireki;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKYKYMDSEIREKI)
    public String getZrnkykymdseireki() {
        return zrnkykymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdseireki(String pZrnkykymdseireki) {
        zrnkykymdseireki = pZrnkykymdseireki;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnyobiv30;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV30)
    public String getZrnyobiv30() {
        return zrnyobiv30;
    }

    public void setZrnyobiv30(String pZrnyobiv30) {
        zrnyobiv30 = pZrnyobiv30;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }

    private String zrnkjttrnnfreearea1;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA1)
    public String getZrnkjttrnnfreearea1() {
        return zrnkjttrnnfreearea1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea1(String pZrnkjttrnnfreearea1) {
        zrnkjttrnnfreearea1 = pZrnkjttrnnfreearea1;
    }

    private String zrnkjttrnnfreearea2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA2)
    public String getZrnkjttrnnfreearea2() {
        return zrnkjttrnnfreearea2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea2(String pZrnkjttrnnfreearea2) {
        zrnkjttrnnfreearea2 = pZrnkjttrnnfreearea2;
    }

    private String zrnkjttrnnfreearea3;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA3)
    public String getZrnkjttrnnfreearea3() {
        return zrnkjttrnnfreearea3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea3(String pZrnkjttrnnfreearea3) {
        zrnkjttrnnfreearea3 = pZrnkjttrnnfreearea3;
    }

    private String zrnkjttrnnfreearea4;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA4)
    public String getZrnkjttrnnfreearea4() {
        return zrnkjttrnnfreearea4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea4(String pZrnkjttrnnfreearea4) {
        zrnkjttrnnfreearea4 = pZrnkjttrnnfreearea4;
    }

    private String zrnkjttrnnfreearea5;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA5)
    public String getZrnkjttrnnfreearea5() {
        return zrnkjttrnnfreearea5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea5(String pZrnkjttrnnfreearea5) {
        zrnkjttrnnfreearea5 = pZrnkjttrnnfreearea5;
    }

    private String zrnkjttrnnfreearea6;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA6)
    public String getZrnkjttrnnfreearea6() {
        return zrnkjttrnnfreearea6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea6(String pZrnkjttrnnfreearea6) {
        zrnkjttrnnfreearea6 = pZrnkjttrnnfreearea6;
    }

    private String zrnkjttrnnfreearea7;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA7)
    public String getZrnkjttrnnfreearea7() {
        return zrnkjttrnnfreearea7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea7(String pZrnkjttrnnfreearea7) {
        zrnkjttrnnfreearea7 = pZrnkjttrnnfreearea7;
    }

    private String zrnyobiv99;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV99)
    public String getZrnyobiv99() {
        return zrnyobiv99;
    }

    public void setZrnyobiv99(String pZrnyobiv99) {
        zrnyobiv99 = pZrnyobiv99;
    }

    private String zrnansyuyouyobin10x6;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X6)
    public String getZrnansyuyouyobin10x6() {
        return zrnansyuyouyobin10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x6(String pZrnansyuyouyobin10x6) {
        zrnansyuyouyobin10x6 = pZrnansyuyouyobin10x6;
    }

    private String zrntuutisakuseiymdseireki;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNTUUTISAKUSEIYMDSEIREKI)
    public String getZrntuutisakuseiymdseireki() {
        return zrntuutisakuseiymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutisakuseiymdseireki(String pZrntuutisakuseiymdseireki) {
        zrntuutisakuseiymdseireki = pZrntuutisakuseiymdseireki;
    }

    private String zrnkzhurikaeymdseireki;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZHURIKAEYMDSEIREKI)
    public String getZrnkzhurikaeymdseireki() {
        return zrnkzhurikaeymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeymdseireki(String pZrnkzhurikaeymdseireki) {
        zrnkzhurikaeymdseireki = pZrnkzhurikaeymdseireki;
    }

    private String zrnkzinfo1;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO1)
    public String getZrnkzinfo1() {
        return zrnkzinfo1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo1(String pZrnkzinfo1) {
        zrnkzinfo1 = pZrnkzinfo1;
    }

    private String zrnkzinfo2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO2)
    public String getZrnkzinfo2() {
        return zrnkzinfo2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo2(String pZrnkzinfo2) {
        zrnkzinfo2 = pZrnkzinfo2;
    }

    private String zrnkzinfo3;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO3)
    public String getZrnkzinfo3() {
        return zrnkzinfo3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo3(String pZrnkzinfo3) {
        zrnkzinfo3 = pZrnkzinfo3;
    }

    private String zrnkzinfo4;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO4)
    public String getZrnkzinfo4() {
        return zrnkzinfo4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo4(String pZrnkzinfo4) {
        zrnkzinfo4 = pZrnkzinfo4;
    }

    private String zrnkzinfo5;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO5)
    public String getZrnkzinfo5() {
        return zrnkzinfo5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo5(String pZrnkzinfo5) {
        zrnkzinfo5 = pZrnkzinfo5;
    }

    private String zrnkzinfo6;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO6)
    public String getZrnkzinfo6() {
        return zrnkzinfo6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo6(String pZrnkzinfo6) {
        zrnkzinfo6 = pZrnkzinfo6;
    }

    private String zrnkzinfo7;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO7)
    public String getZrnkzinfo7() {
        return zrnkzinfo7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo7(String pZrnkzinfo7) {
        zrnkzinfo7 = pZrnkzinfo7;
    }

    private String zrnkzinfo8;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKZINFO8)
    public String getZrnkzinfo8() {
        return zrnkzinfo8;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzinfo8(String pZrnkzinfo8) {
        zrnkzinfo8 = pZrnkzinfo8;
    }

    private String zrnhknjytukikan;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHKNJYTUKIKAN)
    public String getZrnhknjytukikan() {
        return zrnhknjytukikan;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknjytukikan(String pZrnhknjytukikan) {
        zrnhknjytukikan = pZrnhknjytukikan;
    }

    private String zrnhrkgk1;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHRKGK1)
    public String getZrnhrkgk1() {
        return zrnhrkgk1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkgk1(String pZrnhrkgk1) {
        zrnhrkgk1 = pZrnhrkgk1;
    }

    private String zrnhrkgk2;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHRKGK2)
    public String getZrnhrkgk2() {
        return zrnhrkgk2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkgk2(String pZrnhrkgk2) {
        zrnhrkgk2 = pZrnhrkgk2;
    }

    private String zrnhrkgk3;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHRKGK3)
    public String getZrnhrkgk3() {
        return zrnhrkgk3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkgk3(String pZrnhrkgk3) {
        zrnhrkgk3 = pZrnhrkgk3;
    }

    private String zrnhrkgk4;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNHRKGK4)
    public String getZrnhrkgk4() {
        return zrnhrkgk4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkgk4(String pZrnhrkgk4) {
        zrnhrkgk4 = pZrnhrkgk4;
    }

    private String zrnyobiv146;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV146)
    public String getZrnyobiv146() {
        return zrnyobiv146;
    }

    public void setZrnyobiv146(String pZrnyobiv146) {
        zrnyobiv146 = pZrnyobiv146;
    }

    private String zrnansyuyouyobin10x7;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X7)
    public String getZrnansyuyouyobin10x7() {
        return zrnansyuyouyobin10x7;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x7(String pZrnansyuyouyobin10x7) {
        zrnansyuyouyobin10x7 = pZrnansyuyouyobin10x7;
    }

    private String zrnkjttrnnfreearea8;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA8)
    public String getZrnkjttrnnfreearea8() {
        return zrnkjttrnnfreearea8;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea8(String pZrnkjttrnnfreearea8) {
        zrnkjttrnnfreearea8 = pZrnkjttrnnfreearea8;
    }

    private String zrnkjttrnnfreearea9;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA9)
    public String getZrnkjttrnnfreearea9() {
        return zrnkjttrnnfreearea9;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea9(String pZrnkjttrnnfreearea9) {
        zrnkjttrnnfreearea9 = pZrnkjttrnnfreearea9;
    }

    private String zrnkjttrnnfreearea10;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA10)
    public String getZrnkjttrnnfreearea10() {
        return zrnkjttrnnfreearea10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea10(String pZrnkjttrnnfreearea10) {
        zrnkjttrnnfreearea10 = pZrnkjttrnnfreearea10;
    }

    private String zrnkjttrnnfreearea11;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA11)
    public String getZrnkjttrnnfreearea11() {
        return zrnkjttrnnfreearea11;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea11(String pZrnkjttrnnfreearea11) {
        zrnkjttrnnfreearea11 = pZrnkjttrnnfreearea11;
    }

    private String zrnkjttrnnfreearea12;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA12)
    public String getZrnkjttrnnfreearea12() {
        return zrnkjttrnnfreearea12;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea12(String pZrnkjttrnnfreearea12) {
        zrnkjttrnnfreearea12 = pZrnkjttrnnfreearea12;
    }

    private String zrnkjttrnnfreearea13;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNKJTTRNNFREEAREA13)
    public String getZrnkjttrnnfreearea13() {
        return zrnkjttrnnfreearea13;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjttrnnfreearea13(String pZrnkjttrnnfreearea13) {
        zrnkjttrnnfreearea13 = pZrnkjttrnnfreearea13;
    }

    private String zrnyobiv84;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNYOBIV84)
    public String getZrnyobiv84() {
        return zrnyobiv84;
    }

    public void setZrnyobiv84(String pZrnyobiv84) {
        zrnyobiv84 = pZrnyobiv84;
    }

    private String zrnansyuyouyobin10x8;

    @Column(name=GenZT_KijituTouraiAnnaiRn.ZRNANSYUYOUYOBIN10X8)
    public String getZrnansyuyouyobin10x8() {
        return zrnansyuyouyobin10x8;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x8(String pZrnansyuyouyobin10x8) {
        zrnansyuyouyobin10x8 = pZrnansyuyouyobin10x8;
    }
}