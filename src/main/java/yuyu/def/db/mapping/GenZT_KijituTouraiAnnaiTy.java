package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiTy;
import yuyu.def.db.id.PKZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.GenQZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiTy;

/**
 * 期日到来案内テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KijituTouraiAnnaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KijituTouraiAnnaiTy}</td><td colspan="3">期日到来案内テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_KijituTouraiAnnaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KijituTouraiAnnaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtyyobiv60 ztyyobiv60}</td><td>（中継用）予備項目Ｖ６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutinm ztytuutinm}</td><td>（中継用）通知名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta1 ztyhurikaeyokokumsg32keta1}</td><td>（中継用）振替予告メッセージ（３２桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta2 ztyhurikaeyokokumsg32keta2}</td><td>（中継用）振替予告メッセージ（３２桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta3 ztyhurikaeyokokumsg32keta3}</td><td>（中継用）振替予告メッセージ（３２桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta4 ztyhurikaeyokokumsg32keta4}</td><td>（中継用）振替予告メッセージ（３２桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta5 ztyhurikaeyokokumsg32keta5}</td><td>（中継用）振替予告メッセージ（３２桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta6 ztyhurikaeyokokumsg32keta6}</td><td>（中継用）振替予告メッセージ（３２桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta7 ztyhurikaeyokokumsg32keta7}</td><td>（中継用）振替予告メッセージ（３２桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg32keta8 ztyhurikaeyokokumsg32keta8}</td><td>（中継用）振替予告メッセージ（３２桁）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv110 ztyyobiv110}</td><td>（中継用）予備項目Ｖ１１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeiro ztyhrkkeiro}</td><td>（中継用）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhnnm ztysyouhnnm}</td><td>（中継用）商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdseireki ztykykymdseireki}</td><td>（中継用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv30 ztyyobiv30}</td><td>（中継用）予備項目Ｖ３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea1 ztykjttrnnfreearea1}</td><td>（中継用）期日到来案内フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea2 ztykjttrnnfreearea2}</td><td>（中継用）期日到来案内フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea3 ztykjttrnnfreearea3}</td><td>（中継用）期日到来案内フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea4 ztykjttrnnfreearea4}</td><td>（中継用）期日到来案内フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea5 ztykjttrnnfreearea5}</td><td>（中継用）期日到来案内フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea6 ztykjttrnnfreearea6}</td><td>（中継用）期日到来案内フリーエリア６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea7 ztykjttrnnfreearea7}</td><td>（中継用）期日到来案内フリーエリア７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv99 ztyyobiv99}</td><td>（中継用）予備項目Ｖ９９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x6 ztyansyuyouyobin10x6}</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutisakuseiymdseireki ztytuutisakuseiymdseireki}</td><td>（中継用）通知作成年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeymdseireki ztykzhurikaeymdseireki}</td><td>（中継用）口座振替日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo1 ztykzinfo1}</td><td>（中継用）口座情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo2 ztykzinfo2}</td><td>（中継用）口座情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo3 ztykzinfo3}</td><td>（中継用）口座情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo4 ztykzinfo4}</td><td>（中継用）口座情報４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo5 ztykzinfo5}</td><td>（中継用）口座情報５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo6 ztykzinfo6}</td><td>（中継用）口座情報６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo7 ztykzinfo7}</td><td>（中継用）口座情報７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzinfo8 ztykzinfo8}</td><td>（中継用）口座情報８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknjytukikan ztyhknjytukikan}</td><td>（中継用）保険料充当期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgk1 ztyhrkgk1}</td><td>（中継用）払込金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgk2 ztyhrkgk2}</td><td>（中継用）払込金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgk3 ztyhrkgk3}</td><td>（中継用）払込金額３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgk4 ztyhrkgk4}</td><td>（中継用）払込金額４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv146 ztyyobiv146}</td><td>（中継用）予備項目Ｖ１４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x7 ztyansyuyouyobin10x7}</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea8 ztykjttrnnfreearea8}</td><td>（中継用）期日到来案内フリーエリア８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea9 ztykjttrnnfreearea9}</td><td>（中継用）期日到来案内フリーエリア９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea10 ztykjttrnnfreearea10}</td><td>（中継用）期日到来案内フリーエリア１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea11 ztykjttrnnfreearea11}</td><td>（中継用）期日到来案内フリーエリア１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea12 ztykjttrnnfreearea12}</td><td>（中継用）期日到来案内フリーエリア１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjttrnnfreearea13 ztykjttrnnfreearea13}</td><td>（中継用）期日到来案内フリーエリア１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv84 ztyyobiv84}</td><td>（中継用）予備項目Ｖ８４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x8 ztyansyuyouyobin10x8}</td><td>（中継用）案内収納用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KijituTouraiAnnaiTy
 * @see     PKZT_KijituTouraiAnnaiTy
 * @see     QZT_KijituTouraiAnnaiTy
 * @see     GenQZT_KijituTouraiAnnaiTy
 */
@MappedSuperclass
@Table(name=GenZT_KijituTouraiAnnaiTy.TABLE_NAME)
@IdClass(value=PKZT_KijituTouraiAnnaiTy.class)
public abstract class GenZT_KijituTouraiAnnaiTy extends AbstractExDBEntity<ZT_KijituTouraiAnnaiTy, PKZT_KijituTouraiAnnaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KijituTouraiAnnaiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
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
    public static final String ZTYYOBIV60               = "ztyyobiv60";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYTUUTINM               = "ztytuutinm";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA1 = "ztyhurikaeyokokumsg32keta1";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA2 = "ztyhurikaeyokokumsg32keta2";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA3 = "ztyhurikaeyokokumsg32keta3";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA4 = "ztyhurikaeyokokumsg32keta4";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA5 = "ztyhurikaeyokokumsg32keta5";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA6 = "ztyhurikaeyokokumsg32keta6";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA7 = "ztyhurikaeyokokumsg32keta7";
    public static final String ZTYHURIKAEYOKOKUMSG32KETA8 = "ztyhurikaeyokokumsg32keta8";
    public static final String ZTYYOBIV110              = "ztyyobiv110";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYHRKKEIRO              = "ztyhrkkeiro";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYSYOUHNNM              = "ztysyouhnnm";
    public static final String ZTYKYKYMDSEIREKI         = "ztykykymdseireki";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYYOBIV30               = "ztyyobiv30";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";
    public static final String ZTYKJTTRNNFREEAREA1      = "ztykjttrnnfreearea1";
    public static final String ZTYKJTTRNNFREEAREA2      = "ztykjttrnnfreearea2";
    public static final String ZTYKJTTRNNFREEAREA3      = "ztykjttrnnfreearea3";
    public static final String ZTYKJTTRNNFREEAREA4      = "ztykjttrnnfreearea4";
    public static final String ZTYKJTTRNNFREEAREA5      = "ztykjttrnnfreearea5";
    public static final String ZTYKJTTRNNFREEAREA6      = "ztykjttrnnfreearea6";
    public static final String ZTYKJTTRNNFREEAREA7      = "ztykjttrnnfreearea7";
    public static final String ZTYYOBIV99               = "ztyyobiv99";
    public static final String ZTYANSYUYOUYOBIN10X6     = "ztyansyuyouyobin10x6";
    public static final String ZTYTUUTISAKUSEIYMDSEIREKI = "ztytuutisakuseiymdseireki";
    public static final String ZTYKZHURIKAEYMDSEIREKI   = "ztykzhurikaeymdseireki";
    public static final String ZTYKZINFO1               = "ztykzinfo1";
    public static final String ZTYKZINFO2               = "ztykzinfo2";
    public static final String ZTYKZINFO3               = "ztykzinfo3";
    public static final String ZTYKZINFO4               = "ztykzinfo4";
    public static final String ZTYKZINFO5               = "ztykzinfo5";
    public static final String ZTYKZINFO6               = "ztykzinfo6";
    public static final String ZTYKZINFO7               = "ztykzinfo7";
    public static final String ZTYKZINFO8               = "ztykzinfo8";
    public static final String ZTYHKNJYTUKIKAN          = "ztyhknjytukikan";
    public static final String ZTYHRKGK1                = "ztyhrkgk1";
    public static final String ZTYHRKGK2                = "ztyhrkgk2";
    public static final String ZTYHRKGK3                = "ztyhrkgk3";
    public static final String ZTYHRKGK4                = "ztyhrkgk4";
    public static final String ZTYYOBIV146              = "ztyyobiv146";
    public static final String ZTYANSYUYOUYOBIN10X7     = "ztyansyuyouyobin10x7";
    public static final String ZTYKJTTRNNFREEAREA8      = "ztykjttrnnfreearea8";
    public static final String ZTYKJTTRNNFREEAREA9      = "ztykjttrnnfreearea9";
    public static final String ZTYKJTTRNNFREEAREA10     = "ztykjttrnnfreearea10";
    public static final String ZTYKJTTRNNFREEAREA11     = "ztykjttrnnfreearea11";
    public static final String ZTYKJTTRNNFREEAREA12     = "ztykjttrnnfreearea12";
    public static final String ZTYKJTTRNNFREEAREA13     = "ztykjttrnnfreearea13";
    public static final String ZTYYOBIV84               = "ztyyobiv84";
    public static final String ZTYANSYUYOUYOBIN10X8     = "ztyansyuyouyobin10x8";

    private final PKZT_KijituTouraiAnnaiTy primaryKey;

    public GenZT_KijituTouraiAnnaiTy() {
        primaryKey = new PKZT_KijituTouraiAnnaiTy();
    }

    public GenZT_KijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_KijituTouraiAnnaiTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_KijituTouraiAnnaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KijituTouraiAnnaiTy> getMetaClass() {
        return QZT_KijituTouraiAnnaiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyyobiv9;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv60;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV60)
    public String getZtyyobiv60() {
        return ztyyobiv60;
    }

    public void setZtyyobiv60(String pZtyyobiv60) {
        ztyyobiv60 = pZtyyobiv60;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztytuutinm;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTUUTINM)
    public String getZtytuutinm() {
        return ztytuutinm;
    }

    public void setZtytuutinm(String pZtytuutinm) {
        ztytuutinm = pZtytuutinm;
    }

    private String ztyhurikaeyokokumsg32keta1;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA1)
    public String getZtyhurikaeyokokumsg32keta1() {
        return ztyhurikaeyokokumsg32keta1;
    }

    public void setZtyhurikaeyokokumsg32keta1(String pZtyhurikaeyokokumsg32keta1) {
        ztyhurikaeyokokumsg32keta1 = pZtyhurikaeyokokumsg32keta1;
    }

    private String ztyhurikaeyokokumsg32keta2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA2)
    public String getZtyhurikaeyokokumsg32keta2() {
        return ztyhurikaeyokokumsg32keta2;
    }

    public void setZtyhurikaeyokokumsg32keta2(String pZtyhurikaeyokokumsg32keta2) {
        ztyhurikaeyokokumsg32keta2 = pZtyhurikaeyokokumsg32keta2;
    }

    private String ztyhurikaeyokokumsg32keta3;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA3)
    public String getZtyhurikaeyokokumsg32keta3() {
        return ztyhurikaeyokokumsg32keta3;
    }

    public void setZtyhurikaeyokokumsg32keta3(String pZtyhurikaeyokokumsg32keta3) {
        ztyhurikaeyokokumsg32keta3 = pZtyhurikaeyokokumsg32keta3;
    }

    private String ztyhurikaeyokokumsg32keta4;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA4)
    public String getZtyhurikaeyokokumsg32keta4() {
        return ztyhurikaeyokokumsg32keta4;
    }

    public void setZtyhurikaeyokokumsg32keta4(String pZtyhurikaeyokokumsg32keta4) {
        ztyhurikaeyokokumsg32keta4 = pZtyhurikaeyokokumsg32keta4;
    }

    private String ztyhurikaeyokokumsg32keta5;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA5)
    public String getZtyhurikaeyokokumsg32keta5() {
        return ztyhurikaeyokokumsg32keta5;
    }

    public void setZtyhurikaeyokokumsg32keta5(String pZtyhurikaeyokokumsg32keta5) {
        ztyhurikaeyokokumsg32keta5 = pZtyhurikaeyokokumsg32keta5;
    }

    private String ztyhurikaeyokokumsg32keta6;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA6)
    public String getZtyhurikaeyokokumsg32keta6() {
        return ztyhurikaeyokokumsg32keta6;
    }

    public void setZtyhurikaeyokokumsg32keta6(String pZtyhurikaeyokokumsg32keta6) {
        ztyhurikaeyokokumsg32keta6 = pZtyhurikaeyokokumsg32keta6;
    }

    private String ztyhurikaeyokokumsg32keta7;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA7)
    public String getZtyhurikaeyokokumsg32keta7() {
        return ztyhurikaeyokokumsg32keta7;
    }

    public void setZtyhurikaeyokokumsg32keta7(String pZtyhurikaeyokokumsg32keta7) {
        ztyhurikaeyokokumsg32keta7 = pZtyhurikaeyokokumsg32keta7;
    }

    private String ztyhurikaeyokokumsg32keta8;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHURIKAEYOKOKUMSG32KETA8)
    public String getZtyhurikaeyokokumsg32keta8() {
        return ztyhurikaeyokokumsg32keta8;
    }

    public void setZtyhurikaeyokokumsg32keta8(String pZtyhurikaeyokokumsg32keta8) {
        ztyhurikaeyokokumsg32keta8 = pZtyhurikaeyokokumsg32keta8;
    }

    private String ztyyobiv110;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV110)
    public String getZtyyobiv110() {
        return ztyyobiv110;
    }

    public void setZtyyobiv110(String pZtyyobiv110) {
        ztyyobiv110 = pZtyyobiv110;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztyhrkkeiro;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHRKKEIRO)
    public String getZtyhrkkeiro() {
        return ztyhrkkeiro;
    }

    public void setZtyhrkkeiro(String pZtyhrkkeiro) {
        ztyhrkkeiro = pZtyhrkkeiro;
    }

    private String ztysyono2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztysyouhnnm;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYSYOUHNNM)
    public String getZtysyouhnnm() {
        return ztysyouhnnm;
    }

    public void setZtysyouhnnm(String pZtysyouhnnm) {
        ztysyouhnnm = pZtysyouhnnm;
    }

    private String ztykykymdseireki;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKYKYMDSEIREKI)
    public String getZtykykymdseireki() {
        return ztykykymdseireki;
    }

    public void setZtykykymdseireki(String pZtykykymdseireki) {
        ztykykymdseireki = pZtykykymdseireki;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyyobiv30;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV30)
    public String getZtyyobiv30() {
        return ztyyobiv30;
    }

    public void setZtyyobiv30(String pZtyyobiv30) {
        ztyyobiv30 = pZtyyobiv30;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }

    private String ztykjttrnnfreearea1;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA1)
    public String getZtykjttrnnfreearea1() {
        return ztykjttrnnfreearea1;
    }

    public void setZtykjttrnnfreearea1(String pZtykjttrnnfreearea1) {
        ztykjttrnnfreearea1 = pZtykjttrnnfreearea1;
    }

    private String ztykjttrnnfreearea2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA2)
    public String getZtykjttrnnfreearea2() {
        return ztykjttrnnfreearea2;
    }

    public void setZtykjttrnnfreearea2(String pZtykjttrnnfreearea2) {
        ztykjttrnnfreearea2 = pZtykjttrnnfreearea2;
    }

    private String ztykjttrnnfreearea3;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA3)
    public String getZtykjttrnnfreearea3() {
        return ztykjttrnnfreearea3;
    }

    public void setZtykjttrnnfreearea3(String pZtykjttrnnfreearea3) {
        ztykjttrnnfreearea3 = pZtykjttrnnfreearea3;
    }

    private String ztykjttrnnfreearea4;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA4)
    public String getZtykjttrnnfreearea4() {
        return ztykjttrnnfreearea4;
    }

    public void setZtykjttrnnfreearea4(String pZtykjttrnnfreearea4) {
        ztykjttrnnfreearea4 = pZtykjttrnnfreearea4;
    }

    private String ztykjttrnnfreearea5;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA5)
    public String getZtykjttrnnfreearea5() {
        return ztykjttrnnfreearea5;
    }

    public void setZtykjttrnnfreearea5(String pZtykjttrnnfreearea5) {
        ztykjttrnnfreearea5 = pZtykjttrnnfreearea5;
    }

    private String ztykjttrnnfreearea6;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA6)
    public String getZtykjttrnnfreearea6() {
        return ztykjttrnnfreearea6;
    }

    public void setZtykjttrnnfreearea6(String pZtykjttrnnfreearea6) {
        ztykjttrnnfreearea6 = pZtykjttrnnfreearea6;
    }

    private String ztykjttrnnfreearea7;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA7)
    public String getZtykjttrnnfreearea7() {
        return ztykjttrnnfreearea7;
    }

    public void setZtykjttrnnfreearea7(String pZtykjttrnnfreearea7) {
        ztykjttrnnfreearea7 = pZtykjttrnnfreearea7;
    }

    private String ztyyobiv99;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV99)
    public String getZtyyobiv99() {
        return ztyyobiv99;
    }

    public void setZtyyobiv99(String pZtyyobiv99) {
        ztyyobiv99 = pZtyyobiv99;
    }

    private String ztyansyuyouyobin10x6;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X6)
    public String getZtyansyuyouyobin10x6() {
        return ztyansyuyouyobin10x6;
    }

    public void setZtyansyuyouyobin10x6(String pZtyansyuyouyobin10x6) {
        ztyansyuyouyobin10x6 = pZtyansyuyouyobin10x6;
    }

    private String ztytuutisakuseiymdseireki;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYTUUTISAKUSEIYMDSEIREKI)
    public String getZtytuutisakuseiymdseireki() {
        return ztytuutisakuseiymdseireki;
    }

    public void setZtytuutisakuseiymdseireki(String pZtytuutisakuseiymdseireki) {
        ztytuutisakuseiymdseireki = pZtytuutisakuseiymdseireki;
    }

    private String ztykzhurikaeymdseireki;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZHURIKAEYMDSEIREKI)
    public String getZtykzhurikaeymdseireki() {
        return ztykzhurikaeymdseireki;
    }

    public void setZtykzhurikaeymdseireki(String pZtykzhurikaeymdseireki) {
        ztykzhurikaeymdseireki = pZtykzhurikaeymdseireki;
    }

    private String ztykzinfo1;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO1)
    public String getZtykzinfo1() {
        return ztykzinfo1;
    }

    public void setZtykzinfo1(String pZtykzinfo1) {
        ztykzinfo1 = pZtykzinfo1;
    }

    private String ztykzinfo2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO2)
    public String getZtykzinfo2() {
        return ztykzinfo2;
    }

    public void setZtykzinfo2(String pZtykzinfo2) {
        ztykzinfo2 = pZtykzinfo2;
    }

    private String ztykzinfo3;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO3)
    public String getZtykzinfo3() {
        return ztykzinfo3;
    }

    public void setZtykzinfo3(String pZtykzinfo3) {
        ztykzinfo3 = pZtykzinfo3;
    }

    private String ztykzinfo4;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO4)
    public String getZtykzinfo4() {
        return ztykzinfo4;
    }

    public void setZtykzinfo4(String pZtykzinfo4) {
        ztykzinfo4 = pZtykzinfo4;
    }

    private String ztykzinfo5;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO5)
    public String getZtykzinfo5() {
        return ztykzinfo5;
    }

    public void setZtykzinfo5(String pZtykzinfo5) {
        ztykzinfo5 = pZtykzinfo5;
    }

    private String ztykzinfo6;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO6)
    public String getZtykzinfo6() {
        return ztykzinfo6;
    }

    public void setZtykzinfo6(String pZtykzinfo6) {
        ztykzinfo6 = pZtykzinfo6;
    }

    private String ztykzinfo7;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO7)
    public String getZtykzinfo7() {
        return ztykzinfo7;
    }

    public void setZtykzinfo7(String pZtykzinfo7) {
        ztykzinfo7 = pZtykzinfo7;
    }

    private String ztykzinfo8;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKZINFO8)
    public String getZtykzinfo8() {
        return ztykzinfo8;
    }

    public void setZtykzinfo8(String pZtykzinfo8) {
        ztykzinfo8 = pZtykzinfo8;
    }

    private String ztyhknjytukikan;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHKNJYTUKIKAN)
    public String getZtyhknjytukikan() {
        return ztyhknjytukikan;
    }

    public void setZtyhknjytukikan(String pZtyhknjytukikan) {
        ztyhknjytukikan = pZtyhknjytukikan;
    }

    private String ztyhrkgk1;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHRKGK1)
    public String getZtyhrkgk1() {
        return ztyhrkgk1;
    }

    public void setZtyhrkgk1(String pZtyhrkgk1) {
        ztyhrkgk1 = pZtyhrkgk1;
    }

    private String ztyhrkgk2;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHRKGK2)
    public String getZtyhrkgk2() {
        return ztyhrkgk2;
    }

    public void setZtyhrkgk2(String pZtyhrkgk2) {
        ztyhrkgk2 = pZtyhrkgk2;
    }

    private String ztyhrkgk3;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHRKGK3)
    public String getZtyhrkgk3() {
        return ztyhrkgk3;
    }

    public void setZtyhrkgk3(String pZtyhrkgk3) {
        ztyhrkgk3 = pZtyhrkgk3;
    }

    private String ztyhrkgk4;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYHRKGK4)
    public String getZtyhrkgk4() {
        return ztyhrkgk4;
    }

    public void setZtyhrkgk4(String pZtyhrkgk4) {
        ztyhrkgk4 = pZtyhrkgk4;
    }

    private String ztyyobiv146;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV146)
    public String getZtyyobiv146() {
        return ztyyobiv146;
    }

    public void setZtyyobiv146(String pZtyyobiv146) {
        ztyyobiv146 = pZtyyobiv146;
    }

    private String ztyansyuyouyobin10x7;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X7)
    public String getZtyansyuyouyobin10x7() {
        return ztyansyuyouyobin10x7;
    }

    public void setZtyansyuyouyobin10x7(String pZtyansyuyouyobin10x7) {
        ztyansyuyouyobin10x7 = pZtyansyuyouyobin10x7;
    }

    private String ztykjttrnnfreearea8;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA8)
    public String getZtykjttrnnfreearea8() {
        return ztykjttrnnfreearea8;
    }

    public void setZtykjttrnnfreearea8(String pZtykjttrnnfreearea8) {
        ztykjttrnnfreearea8 = pZtykjttrnnfreearea8;
    }

    private String ztykjttrnnfreearea9;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA9)
    public String getZtykjttrnnfreearea9() {
        return ztykjttrnnfreearea9;
    }

    public void setZtykjttrnnfreearea9(String pZtykjttrnnfreearea9) {
        ztykjttrnnfreearea9 = pZtykjttrnnfreearea9;
    }

    private String ztykjttrnnfreearea10;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA10)
    public String getZtykjttrnnfreearea10() {
        return ztykjttrnnfreearea10;
    }

    public void setZtykjttrnnfreearea10(String pZtykjttrnnfreearea10) {
        ztykjttrnnfreearea10 = pZtykjttrnnfreearea10;
    }

    private String ztykjttrnnfreearea11;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA11)
    public String getZtykjttrnnfreearea11() {
        return ztykjttrnnfreearea11;
    }

    public void setZtykjttrnnfreearea11(String pZtykjttrnnfreearea11) {
        ztykjttrnnfreearea11 = pZtykjttrnnfreearea11;
    }

    private String ztykjttrnnfreearea12;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA12)
    public String getZtykjttrnnfreearea12() {
        return ztykjttrnnfreearea12;
    }

    public void setZtykjttrnnfreearea12(String pZtykjttrnnfreearea12) {
        ztykjttrnnfreearea12 = pZtykjttrnnfreearea12;
    }

    private String ztykjttrnnfreearea13;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYKJTTRNNFREEAREA13)
    public String getZtykjttrnnfreearea13() {
        return ztykjttrnnfreearea13;
    }

    public void setZtykjttrnnfreearea13(String pZtykjttrnnfreearea13) {
        ztykjttrnnfreearea13 = pZtykjttrnnfreearea13;
    }

    private String ztyyobiv84;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYYOBIV84)
    public String getZtyyobiv84() {
        return ztyyobiv84;
    }

    public void setZtyyobiv84(String pZtyyobiv84) {
        ztyyobiv84 = pZtyyobiv84;
    }

    private String ztyansyuyouyobin10x8;

    @Column(name=GenZT_KijituTouraiAnnaiTy.ZTYANSYUYOUYOBIN10X8)
    public String getZtyansyuyouyobin10x8() {
        return ztyansyuyouyobin10x8;
    }

    public void setZtyansyuyouyobin10x8(String pZtyansyuyouyobin10x8) {
        ztyansyuyouyobin10x8 = pZtyansyuyouyobin10x8;
    }
}