package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_HrhnTtdkKanTy;
import yuyu.def.db.id.PKZT_HrhnTtdkKanTy;
import yuyu.def.db.meta.GenQZT_HrhnTtdkKanTy;
import yuyu.def.db.meta.QZT_HrhnTtdkKanTy;

/**
 * 手続完了（払方変更）テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_HrhnTtdkKanTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HrhnTtdkKanTy}</td><td colspan="3">手続完了（払方変更）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_HrhnTtdkKanTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_HrhnTtdkKanTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_HrhnTtdkKanTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtyyobiv63 ztyyobiv63}</td><td>（中継用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzamaskingmsg ztykouzamaskingmsg}</td><td>（中継用）口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuutkiktbrisyu ztyhrkkaisuutkiktbrisyu}</td><td>（中継用）払込回数・定期一括払種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeiro ztyhrkkeiro}</td><td>（中継用）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkp ztyhrkp}</td><td>（中継用）払込保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouryokuhasseiymmsg ztykouryokuhasseiymmsg}</td><td>（中継用）効力発生年月ＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseijitenmsg ztysakuseijitenmsg}</td><td>（中継用）作成時点メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingakumidasi1 ztykingakumidasi1}</td><td>（中継用）金額見出し１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingaku1 ztykingaku1}</td><td>（中継用）金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingakumidasi2 ztykingakumidasi2}</td><td>（中継用）金額見出し２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingaku2 ztykingaku2}</td><td>（中継用）金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingakumidasi3 ztykingakumidasi3}</td><td>（中継用）金額見出し３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykingaku3 ztykingaku3}</td><td>（中継用）金額３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptuukatype ztyptuukatype}</td><td>（中継用）保険料金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv61 ztyyobiv61}</td><td>（中継用）予備項目Ｖ６１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta1 ztymsgarea34keta1}</td><td>（中継用）メッセージエリア（３４桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta2 ztymsgarea34keta2}</td><td>（中継用）メッセージエリア（３４桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta3 ztymsgarea34keta3}</td><td>（中継用）メッセージエリア（３４桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta4 ztymsgarea34keta4}</td><td>（中継用）メッセージエリア（３４桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta5 ztymsgarea34keta5}</td><td>（中継用）メッセージエリア（３４桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta6 ztymsgarea34keta6}</td><td>（中継用）メッセージエリア（３４桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgarea34keta7 ztymsgarea34keta7}</td><td>（中継用）メッセージエリア（３４桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv95 ztyyobiv95}</td><td>（中継用）予備項目Ｖ９５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta1 ztyhurikaeyokokumsg34keta1}</td><td>（中継用）振替予告メッセージ（３４桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta2 ztyhurikaeyokokumsg34keta2}</td><td>（中継用）振替予告メッセージ（３４桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta3 ztyhurikaeyokokumsg34keta3}</td><td>（中継用）振替予告メッセージ（３４桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta4 ztyhurikaeyokokumsg34keta4}</td><td>（中継用）振替予告メッセージ（３４桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta5 ztyhurikaeyokokumsg34keta5}</td><td>（中継用）振替予告メッセージ（３４桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta6 ztyhurikaeyokokumsg34keta6}</td><td>（中継用）振替予告メッセージ（３４桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta7 ztyhurikaeyokokumsg34keta7}</td><td>（中継用）振替予告メッセージ（３４桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta8 ztyhurikaeyokokumsg34keta8}</td><td>（中継用）振替予告メッセージ（３４桁）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta9 ztyhurikaeyokokumsg34keta9}</td><td>（中継用）振替予告メッセージ（３４桁）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta10 ztyhurikaeyokokumsg34keta10}</td><td>（中継用）振替予告メッセージ（３４桁）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta11 ztyhurikaeyokokumsg34keta11}</td><td>（中継用）振替予告メッセージ（３４桁）１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta12 ztyhurikaeyokokumsg34keta12}</td><td>（中継用）振替予告メッセージ（３４桁）１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta13 ztyhurikaeyokokumsg34keta13}</td><td>（中継用）振替予告メッセージ（３４桁）１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta14 ztyhurikaeyokokumsg34keta14}</td><td>（中継用）振替予告メッセージ（３４桁）１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta15 ztyhurikaeyokokumsg34keta15}</td><td>（中継用）振替予告メッセージ（３４桁）１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta16 ztyhurikaeyokokumsg34keta16}</td><td>（中継用）振替予告メッセージ（３４桁）１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta17 ztyhurikaeyokokumsg34keta17}</td><td>（中継用）振替予告メッセージ（３４桁）１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta18 ztyhurikaeyokokumsg34keta18}</td><td>（中継用）振替予告メッセージ（３４桁）１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta19 ztyhurikaeyokokumsg34keta19}</td><td>（中継用）振替予告メッセージ（３４桁）１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta20 ztyhurikaeyokokumsg34keta20}</td><td>（中継用）振替予告メッセージ（３４桁）２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta21 ztyhurikaeyokokumsg34keta21}</td><td>（中継用）振替予告メッセージ（３４桁）２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta22 ztyhurikaeyokokumsg34keta22}</td><td>（中継用）振替予告メッセージ（３４桁）２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta23 ztyhurikaeyokokumsg34keta23}</td><td>（中継用）振替予告メッセージ（３４桁）２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta24 ztyhurikaeyokokumsg34keta24}</td><td>（中継用）振替予告メッセージ（３４桁）２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta25 ztyhurikaeyokokumsg34keta25}</td><td>（中継用）振替予告メッセージ（３４桁）２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta26 ztyhurikaeyokokumsg34keta26}</td><td>（中継用）振替予告メッセージ（３４桁）２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta27 ztyhurikaeyokokumsg34keta27}</td><td>（中継用）振替予告メッセージ（３４桁）２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaeyokokumsg34keta28 ztyhurikaeyokokumsg34keta28}</td><td>（中継用）振替予告メッセージ（３４桁）２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv131 ztyyobiv131}</td><td>（中継用）予備項目Ｖ１３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250 ztyyobiv250}</td><td>（中継用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x6 ztyansyuyouyobin10x6}</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HrhnTtdkKanTy
 * @see     PKZT_HrhnTtdkKanTy
 * @see     QZT_HrhnTtdkKanTy
 * @see     GenQZT_HrhnTtdkKanTy
 */
@MappedSuperclass
@Table(name=GenZT_HrhnTtdkKanTy.TABLE_NAME)
@IdClass(value=PKZT_HrhnTtdkKanTy.class)
public abstract class GenZT_HrhnTtdkKanTy extends AbstractExDBEntity<ZT_HrhnTtdkKanTy, PKZT_HrhnTtdkKanTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HrhnTtdkKanTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
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
    public static final String ZTYYOBIV63               = "ztyyobiv63";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYKOUZAMASKINGMSG       = "ztykouzamaskingmsg";
    public static final String ZTYHRKKAISUUTKIKTBRISYU  = "ztyhrkkaisuutkiktbrisyu";
    public static final String ZTYHRKKEIRO              = "ztyhrkkeiro";
    public static final String ZTYHRKP                  = "ztyhrkp";
    public static final String ZTYKOURYOKUHASSEIYMMSG   = "ztykouryokuhasseiymmsg";
    public static final String ZTYSAKUSEIJITENMSG       = "ztysakuseijitenmsg";
    public static final String ZTYKINGAKUMIDASI1        = "ztykingakumidasi1";
    public static final String ZTYKINGAKU1              = "ztykingaku1";
    public static final String ZTYKINGAKUMIDASI2        = "ztykingakumidasi2";
    public static final String ZTYKINGAKU2              = "ztykingaku2";
    public static final String ZTYKINGAKUMIDASI3        = "ztykingakumidasi3";
    public static final String ZTYKINGAKU3              = "ztykingaku3";
    public static final String ZTYPTUUKATYPE            = "ztyptuukatype";
    public static final String ZTYYOBIV61               = "ztyyobiv61";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYMSGAREA34KETA1        = "ztymsgarea34keta1";
    public static final String ZTYMSGAREA34KETA2        = "ztymsgarea34keta2";
    public static final String ZTYMSGAREA34KETA3        = "ztymsgarea34keta3";
    public static final String ZTYMSGAREA34KETA4        = "ztymsgarea34keta4";
    public static final String ZTYMSGAREA34KETA5        = "ztymsgarea34keta5";
    public static final String ZTYMSGAREA34KETA6        = "ztymsgarea34keta6";
    public static final String ZTYMSGAREA34KETA7        = "ztymsgarea34keta7";
    public static final String ZTYYOBIV95               = "ztyyobiv95";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA1 = "ztyhurikaeyokokumsg34keta1";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA2 = "ztyhurikaeyokokumsg34keta2";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA3 = "ztyhurikaeyokokumsg34keta3";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA4 = "ztyhurikaeyokokumsg34keta4";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA5 = "ztyhurikaeyokokumsg34keta5";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA6 = "ztyhurikaeyokokumsg34keta6";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA7 = "ztyhurikaeyokokumsg34keta7";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA8 = "ztyhurikaeyokokumsg34keta8";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA9 = "ztyhurikaeyokokumsg34keta9";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA10 = "ztyhurikaeyokokumsg34keta10";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA11 = "ztyhurikaeyokokumsg34keta11";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA12 = "ztyhurikaeyokokumsg34keta12";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA13 = "ztyhurikaeyokokumsg34keta13";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA14 = "ztyhurikaeyokokumsg34keta14";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA15 = "ztyhurikaeyokokumsg34keta15";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA16 = "ztyhurikaeyokokumsg34keta16";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA17 = "ztyhurikaeyokokumsg34keta17";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA18 = "ztyhurikaeyokokumsg34keta18";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA19 = "ztyhurikaeyokokumsg34keta19";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA20 = "ztyhurikaeyokokumsg34keta20";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA21 = "ztyhurikaeyokokumsg34keta21";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA22 = "ztyhurikaeyokokumsg34keta22";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA23 = "ztyhurikaeyokokumsg34keta23";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA24 = "ztyhurikaeyokokumsg34keta24";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA25 = "ztyhurikaeyokokumsg34keta25";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA26 = "ztyhurikaeyokokumsg34keta26";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA27 = "ztyhurikaeyokokumsg34keta27";
    public static final String ZTYHURIKAEYOKOKUMSG34KETA28 = "ztyhurikaeyokokumsg34keta28";
    public static final String ZTYYOBIV131              = "ztyyobiv131";
    public static final String ZTYYOBIV250              = "ztyyobiv250";
    public static final String ZTYANSYUYOUYOBIN10X6     = "ztyansyuyouyobin10x6";

    private final PKZT_HrhnTtdkKanTy primaryKey;

    public GenZT_HrhnTtdkKanTy() {
        primaryKey = new PKZT_HrhnTtdkKanTy();
    }

    public GenZT_HrhnTtdkKanTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_HrhnTtdkKanTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_HrhnTtdkKanTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HrhnTtdkKanTy> getMetaClass() {
        return QZT_HrhnTtdkKanTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    @Id
    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztyyobiv7;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv63;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV63)
    public String getZtyyobiv63() {
        return ztyyobiv63;
    }

    public void setZtyyobiv63(String pZtyyobiv63) {
        ztyyobiv63 = pZtyyobiv63;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztykouzamaskingmsg;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKOUZAMASKINGMSG)
    public String getZtykouzamaskingmsg() {
        return ztykouzamaskingmsg;
    }

    public void setZtykouzamaskingmsg(String pZtykouzamaskingmsg) {
        ztykouzamaskingmsg = pZtykouzamaskingmsg;
    }

    private String ztyhrkkaisuutkiktbrisyu;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHRKKAISUUTKIKTBRISYU)
    public String getZtyhrkkaisuutkiktbrisyu() {
        return ztyhrkkaisuutkiktbrisyu;
    }

    public void setZtyhrkkaisuutkiktbrisyu(String pZtyhrkkaisuutkiktbrisyu) {
        ztyhrkkaisuutkiktbrisyu = pZtyhrkkaisuutkiktbrisyu;
    }

    private String ztyhrkkeiro;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHRKKEIRO)
    public String getZtyhrkkeiro() {
        return ztyhrkkeiro;
    }

    public void setZtyhrkkeiro(String pZtyhrkkeiro) {
        ztyhrkkeiro = pZtyhrkkeiro;
    }

    private String ztyhrkp;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHRKP)
    public String getZtyhrkp() {
        return ztyhrkp;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZtyhrkp(String pZtyhrkp) {
        ztyhrkp = pZtyhrkp;
    }

    private String ztykouryokuhasseiymmsg;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKOURYOKUHASSEIYMMSG)
    public String getZtykouryokuhasseiymmsg() {
        return ztykouryokuhasseiymmsg;
    }

    public void setZtykouryokuhasseiymmsg(String pZtykouryokuhasseiymmsg) {
        ztykouryokuhasseiymmsg = pZtykouryokuhasseiymmsg;
    }

    private String ztysakuseijitenmsg;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYSAKUSEIJITENMSG)
    public String getZtysakuseijitenmsg() {
        return ztysakuseijitenmsg;
    }

    public void setZtysakuseijitenmsg(String pZtysakuseijitenmsg) {
        ztysakuseijitenmsg = pZtysakuseijitenmsg;
    }

    private String ztykingakumidasi1;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKINGAKUMIDASI1)
    public String getZtykingakumidasi1() {
        return ztykingakumidasi1;
    }

    public void setZtykingakumidasi1(String pZtykingakumidasi1) {
        ztykingakumidasi1 = pZtykingakumidasi1;
    }

    private String ztykingaku1;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKINGAKU1)
    public String getZtykingaku1() {
        return ztykingaku1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZtykingaku1(String pZtykingaku1) {
        ztykingaku1 = pZtykingaku1;
    }

    private String ztykingakumidasi2;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKINGAKUMIDASI2)
    public String getZtykingakumidasi2() {
        return ztykingakumidasi2;
    }

    public void setZtykingakumidasi2(String pZtykingakumidasi2) {
        ztykingakumidasi2 = pZtykingakumidasi2;
    }

    private String ztykingaku2;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKINGAKU2)
    public String getZtykingaku2() {
        return ztykingaku2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZtykingaku2(String pZtykingaku2) {
        ztykingaku2 = pZtykingaku2;
    }

    private String ztykingakumidasi3;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKINGAKUMIDASI3)
    public String getZtykingakumidasi3() {
        return ztykingakumidasi3;
    }

    public void setZtykingakumidasi3(String pZtykingakumidasi3) {
        ztykingakumidasi3 = pZtykingakumidasi3;
    }

    private String ztykingaku3;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYKINGAKU3)
    public String getZtykingaku3() {
        return ztykingaku3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZtykingaku3(String pZtykingaku3) {
        ztykingaku3 = pZtykingaku3;
    }

    private String ztyptuukatype;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYPTUUKATYPE)
    public String getZtyptuukatype() {
        return ztyptuukatype;
    }

    public void setZtyptuukatype(String pZtyptuukatype) {
        ztyptuukatype = pZtyptuukatype;
    }

    private String ztyyobiv61;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV61)
    public String getZtyyobiv61() {
        return ztyyobiv61;
    }

    public void setZtyyobiv61(String pZtyyobiv61) {
        ztyyobiv61 = pZtyyobiv61;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztymsgarea34keta1;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA1)
    public String getZtymsgarea34keta1() {
        return ztymsgarea34keta1;
    }

    public void setZtymsgarea34keta1(String pZtymsgarea34keta1) {
        ztymsgarea34keta1 = pZtymsgarea34keta1;
    }

    private String ztymsgarea34keta2;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA2)
    public String getZtymsgarea34keta2() {
        return ztymsgarea34keta2;
    }

    public void setZtymsgarea34keta2(String pZtymsgarea34keta2) {
        ztymsgarea34keta2 = pZtymsgarea34keta2;
    }

    private String ztymsgarea34keta3;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA3)
    public String getZtymsgarea34keta3() {
        return ztymsgarea34keta3;
    }

    public void setZtymsgarea34keta3(String pZtymsgarea34keta3) {
        ztymsgarea34keta3 = pZtymsgarea34keta3;
    }

    private String ztymsgarea34keta4;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA4)
    public String getZtymsgarea34keta4() {
        return ztymsgarea34keta4;
    }

    public void setZtymsgarea34keta4(String pZtymsgarea34keta4) {
        ztymsgarea34keta4 = pZtymsgarea34keta4;
    }

    private String ztymsgarea34keta5;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA5)
    public String getZtymsgarea34keta5() {
        return ztymsgarea34keta5;
    }

    public void setZtymsgarea34keta5(String pZtymsgarea34keta5) {
        ztymsgarea34keta5 = pZtymsgarea34keta5;
    }

    private String ztymsgarea34keta6;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA6)
    public String getZtymsgarea34keta6() {
        return ztymsgarea34keta6;
    }

    public void setZtymsgarea34keta6(String pZtymsgarea34keta6) {
        ztymsgarea34keta6 = pZtymsgarea34keta6;
    }

    private String ztymsgarea34keta7;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYMSGAREA34KETA7)
    public String getZtymsgarea34keta7() {
        return ztymsgarea34keta7;
    }

    public void setZtymsgarea34keta7(String pZtymsgarea34keta7) {
        ztymsgarea34keta7 = pZtymsgarea34keta7;
    }

    private String ztyyobiv95;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV95)
    public String getZtyyobiv95() {
        return ztyyobiv95;
    }

    public void setZtyyobiv95(String pZtyyobiv95) {
        ztyyobiv95 = pZtyyobiv95;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }

    private String ztyhurikaeyokokumsg34keta1;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA1)
    public String getZtyhurikaeyokokumsg34keta1() {
        return ztyhurikaeyokokumsg34keta1;
    }

    public void setZtyhurikaeyokokumsg34keta1(String pZtyhurikaeyokokumsg34keta1) {
        ztyhurikaeyokokumsg34keta1 = pZtyhurikaeyokokumsg34keta1;
    }

    private String ztyhurikaeyokokumsg34keta2;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA2)
    public String getZtyhurikaeyokokumsg34keta2() {
        return ztyhurikaeyokokumsg34keta2;
    }

    public void setZtyhurikaeyokokumsg34keta2(String pZtyhurikaeyokokumsg34keta2) {
        ztyhurikaeyokokumsg34keta2 = pZtyhurikaeyokokumsg34keta2;
    }

    private String ztyhurikaeyokokumsg34keta3;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA3)
    public String getZtyhurikaeyokokumsg34keta3() {
        return ztyhurikaeyokokumsg34keta3;
    }

    public void setZtyhurikaeyokokumsg34keta3(String pZtyhurikaeyokokumsg34keta3) {
        ztyhurikaeyokokumsg34keta3 = pZtyhurikaeyokokumsg34keta3;
    }

    private String ztyhurikaeyokokumsg34keta4;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA4)
    public String getZtyhurikaeyokokumsg34keta4() {
        return ztyhurikaeyokokumsg34keta4;
    }

    public void setZtyhurikaeyokokumsg34keta4(String pZtyhurikaeyokokumsg34keta4) {
        ztyhurikaeyokokumsg34keta4 = pZtyhurikaeyokokumsg34keta4;
    }

    private String ztyhurikaeyokokumsg34keta5;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA5)
    public String getZtyhurikaeyokokumsg34keta5() {
        return ztyhurikaeyokokumsg34keta5;
    }

    public void setZtyhurikaeyokokumsg34keta5(String pZtyhurikaeyokokumsg34keta5) {
        ztyhurikaeyokokumsg34keta5 = pZtyhurikaeyokokumsg34keta5;
    }

    private String ztyhurikaeyokokumsg34keta6;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA6)
    public String getZtyhurikaeyokokumsg34keta6() {
        return ztyhurikaeyokokumsg34keta6;
    }

    public void setZtyhurikaeyokokumsg34keta6(String pZtyhurikaeyokokumsg34keta6) {
        ztyhurikaeyokokumsg34keta6 = pZtyhurikaeyokokumsg34keta6;
    }

    private String ztyhurikaeyokokumsg34keta7;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA7)
    public String getZtyhurikaeyokokumsg34keta7() {
        return ztyhurikaeyokokumsg34keta7;
    }

    public void setZtyhurikaeyokokumsg34keta7(String pZtyhurikaeyokokumsg34keta7) {
        ztyhurikaeyokokumsg34keta7 = pZtyhurikaeyokokumsg34keta7;
    }

    private String ztyhurikaeyokokumsg34keta8;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA8)
    public String getZtyhurikaeyokokumsg34keta8() {
        return ztyhurikaeyokokumsg34keta8;
    }

    public void setZtyhurikaeyokokumsg34keta8(String pZtyhurikaeyokokumsg34keta8) {
        ztyhurikaeyokokumsg34keta8 = pZtyhurikaeyokokumsg34keta8;
    }

    private String ztyhurikaeyokokumsg34keta9;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA9)
    public String getZtyhurikaeyokokumsg34keta9() {
        return ztyhurikaeyokokumsg34keta9;
    }

    public void setZtyhurikaeyokokumsg34keta9(String pZtyhurikaeyokokumsg34keta9) {
        ztyhurikaeyokokumsg34keta9 = pZtyhurikaeyokokumsg34keta9;
    }

    private String ztyhurikaeyokokumsg34keta10;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA10)
    public String getZtyhurikaeyokokumsg34keta10() {
        return ztyhurikaeyokokumsg34keta10;
    }

    public void setZtyhurikaeyokokumsg34keta10(String pZtyhurikaeyokokumsg34keta10) {
        ztyhurikaeyokokumsg34keta10 = pZtyhurikaeyokokumsg34keta10;
    }

    private String ztyhurikaeyokokumsg34keta11;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA11)
    public String getZtyhurikaeyokokumsg34keta11() {
        return ztyhurikaeyokokumsg34keta11;
    }

    public void setZtyhurikaeyokokumsg34keta11(String pZtyhurikaeyokokumsg34keta11) {
        ztyhurikaeyokokumsg34keta11 = pZtyhurikaeyokokumsg34keta11;
    }

    private String ztyhurikaeyokokumsg34keta12;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA12)
    public String getZtyhurikaeyokokumsg34keta12() {
        return ztyhurikaeyokokumsg34keta12;
    }

    public void setZtyhurikaeyokokumsg34keta12(String pZtyhurikaeyokokumsg34keta12) {
        ztyhurikaeyokokumsg34keta12 = pZtyhurikaeyokokumsg34keta12;
    }

    private String ztyhurikaeyokokumsg34keta13;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA13)
    public String getZtyhurikaeyokokumsg34keta13() {
        return ztyhurikaeyokokumsg34keta13;
    }

    public void setZtyhurikaeyokokumsg34keta13(String pZtyhurikaeyokokumsg34keta13) {
        ztyhurikaeyokokumsg34keta13 = pZtyhurikaeyokokumsg34keta13;
    }

    private String ztyhurikaeyokokumsg34keta14;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA14)
    public String getZtyhurikaeyokokumsg34keta14() {
        return ztyhurikaeyokokumsg34keta14;
    }

    public void setZtyhurikaeyokokumsg34keta14(String pZtyhurikaeyokokumsg34keta14) {
        ztyhurikaeyokokumsg34keta14 = pZtyhurikaeyokokumsg34keta14;
    }

    private String ztyhurikaeyokokumsg34keta15;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA15)
    public String getZtyhurikaeyokokumsg34keta15() {
        return ztyhurikaeyokokumsg34keta15;
    }

    public void setZtyhurikaeyokokumsg34keta15(String pZtyhurikaeyokokumsg34keta15) {
        ztyhurikaeyokokumsg34keta15 = pZtyhurikaeyokokumsg34keta15;
    }

    private String ztyhurikaeyokokumsg34keta16;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA16)
    public String getZtyhurikaeyokokumsg34keta16() {
        return ztyhurikaeyokokumsg34keta16;
    }

    public void setZtyhurikaeyokokumsg34keta16(String pZtyhurikaeyokokumsg34keta16) {
        ztyhurikaeyokokumsg34keta16 = pZtyhurikaeyokokumsg34keta16;
    }

    private String ztyhurikaeyokokumsg34keta17;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA17)
    public String getZtyhurikaeyokokumsg34keta17() {
        return ztyhurikaeyokokumsg34keta17;
    }

    public void setZtyhurikaeyokokumsg34keta17(String pZtyhurikaeyokokumsg34keta17) {
        ztyhurikaeyokokumsg34keta17 = pZtyhurikaeyokokumsg34keta17;
    }

    private String ztyhurikaeyokokumsg34keta18;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA18)
    public String getZtyhurikaeyokokumsg34keta18() {
        return ztyhurikaeyokokumsg34keta18;
    }

    public void setZtyhurikaeyokokumsg34keta18(String pZtyhurikaeyokokumsg34keta18) {
        ztyhurikaeyokokumsg34keta18 = pZtyhurikaeyokokumsg34keta18;
    }

    private String ztyhurikaeyokokumsg34keta19;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA19)
    public String getZtyhurikaeyokokumsg34keta19() {
        return ztyhurikaeyokokumsg34keta19;
    }

    public void setZtyhurikaeyokokumsg34keta19(String pZtyhurikaeyokokumsg34keta19) {
        ztyhurikaeyokokumsg34keta19 = pZtyhurikaeyokokumsg34keta19;
    }

    private String ztyhurikaeyokokumsg34keta20;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA20)
    public String getZtyhurikaeyokokumsg34keta20() {
        return ztyhurikaeyokokumsg34keta20;
    }

    public void setZtyhurikaeyokokumsg34keta20(String pZtyhurikaeyokokumsg34keta20) {
        ztyhurikaeyokokumsg34keta20 = pZtyhurikaeyokokumsg34keta20;
    }

    private String ztyhurikaeyokokumsg34keta21;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA21)
    public String getZtyhurikaeyokokumsg34keta21() {
        return ztyhurikaeyokokumsg34keta21;
    }

    public void setZtyhurikaeyokokumsg34keta21(String pZtyhurikaeyokokumsg34keta21) {
        ztyhurikaeyokokumsg34keta21 = pZtyhurikaeyokokumsg34keta21;
    }

    private String ztyhurikaeyokokumsg34keta22;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA22)
    public String getZtyhurikaeyokokumsg34keta22() {
        return ztyhurikaeyokokumsg34keta22;
    }

    public void setZtyhurikaeyokokumsg34keta22(String pZtyhurikaeyokokumsg34keta22) {
        ztyhurikaeyokokumsg34keta22 = pZtyhurikaeyokokumsg34keta22;
    }

    private String ztyhurikaeyokokumsg34keta23;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA23)
    public String getZtyhurikaeyokokumsg34keta23() {
        return ztyhurikaeyokokumsg34keta23;
    }

    public void setZtyhurikaeyokokumsg34keta23(String pZtyhurikaeyokokumsg34keta23) {
        ztyhurikaeyokokumsg34keta23 = pZtyhurikaeyokokumsg34keta23;
    }

    private String ztyhurikaeyokokumsg34keta24;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA24)
    public String getZtyhurikaeyokokumsg34keta24() {
        return ztyhurikaeyokokumsg34keta24;
    }

    public void setZtyhurikaeyokokumsg34keta24(String pZtyhurikaeyokokumsg34keta24) {
        ztyhurikaeyokokumsg34keta24 = pZtyhurikaeyokokumsg34keta24;
    }

    private String ztyhurikaeyokokumsg34keta25;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA25)
    public String getZtyhurikaeyokokumsg34keta25() {
        return ztyhurikaeyokokumsg34keta25;
    }

    public void setZtyhurikaeyokokumsg34keta25(String pZtyhurikaeyokokumsg34keta25) {
        ztyhurikaeyokokumsg34keta25 = pZtyhurikaeyokokumsg34keta25;
    }

    private String ztyhurikaeyokokumsg34keta26;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA26)
    public String getZtyhurikaeyokokumsg34keta26() {
        return ztyhurikaeyokokumsg34keta26;
    }

    public void setZtyhurikaeyokokumsg34keta26(String pZtyhurikaeyokokumsg34keta26) {
        ztyhurikaeyokokumsg34keta26 = pZtyhurikaeyokokumsg34keta26;
    }

    private String ztyhurikaeyokokumsg34keta27;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA27)
    public String getZtyhurikaeyokokumsg34keta27() {
        return ztyhurikaeyokokumsg34keta27;
    }

    public void setZtyhurikaeyokokumsg34keta27(String pZtyhurikaeyokokumsg34keta27) {
        ztyhurikaeyokokumsg34keta27 = pZtyhurikaeyokokumsg34keta27;
    }

    private String ztyhurikaeyokokumsg34keta28;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYHURIKAEYOKOKUMSG34KETA28)
    public String getZtyhurikaeyokokumsg34keta28() {
        return ztyhurikaeyokokumsg34keta28;
    }

    public void setZtyhurikaeyokokumsg34keta28(String pZtyhurikaeyokokumsg34keta28) {
        ztyhurikaeyokokumsg34keta28 = pZtyhurikaeyokokumsg34keta28;
    }

    private String ztyyobiv131;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV131)
    public String getZtyyobiv131() {
        return ztyyobiv131;
    }

    public void setZtyyobiv131(String pZtyyobiv131) {
        ztyyobiv131 = pZtyyobiv131;
    }

    private String ztyyobiv250;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYYOBIV250)
    public String getZtyyobiv250() {
        return ztyyobiv250;
    }

    public void setZtyyobiv250(String pZtyyobiv250) {
        ztyyobiv250 = pZtyyobiv250;
    }

    private String ztyansyuyouyobin10x6;

    @Column(name=GenZT_HrhnTtdkKanTy.ZTYANSYUYOUYOBIN10X6)
    public String getZtyansyuyouyobin10x6() {
        return ztyansyuyouyobin10x6;
    }

    public void setZtyansyuyouyobin10x6(String pZtyansyuyouyobin10x6) {
        ztyansyuyouyobin10x6 = pZtyansyuyouyobin10x6;
    }
}