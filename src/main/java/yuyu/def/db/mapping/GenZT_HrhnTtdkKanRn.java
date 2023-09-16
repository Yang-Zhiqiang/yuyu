package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_HrhnTtdkKanRn;
import yuyu.def.db.id.PKZT_HrhnTtdkKanRn;
import yuyu.def.db.meta.GenQZT_HrhnTtdkKanRn;
import yuyu.def.db.meta.QZT_HrhnTtdkKanRn;

/**
 * 手続完了（払方変更）テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_HrhnTtdkKanRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HrhnTtdkKanRn}</td><td colspan="3">手続完了（払方変更）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_HrhnTtdkKanRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_HrhnTtdkKanRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_HrhnTtdkKanRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnyobiv63 zrnyobiv63}</td><td>（連携用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzamaskingmsg zrnkouzamaskingmsg}</td><td>（連携用）口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuutkiktbrisyu zrnhrkkaisuutkiktbrisyu}</td><td>（連携用）払込回数・定期一括払種類</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeiro zrnhrkkeiro}</td><td>（連携用）払込経路</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkp zrnhrkp}</td><td>（連携用）払込保険料</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokuhasseiymmsg zrnkouryokuhasseiymmsg}</td><td>（連携用）効力発生年月ＭＳＧ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseijitenmsg zrnsakuseijitenmsg}</td><td>（連携用）作成時点メッセージ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingakumidasi1 zrnkingakumidasi1}</td><td>（連携用）金額見出し１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingaku1 zrnkingaku1}</td><td>（連携用）金額１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingakumidasi2 zrnkingakumidasi2}</td><td>（連携用）金額見出し２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingaku2 zrnkingaku2}</td><td>（連携用）金額２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingakumidasi3 zrnkingakumidasi3}</td><td>（連携用）金額見出し３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkingaku3 zrnkingaku3}</td><td>（連携用）金額３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptuukatype zrnptuukatype}</td><td>（連携用）保険料金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv61 zrnyobiv61}</td><td>（連携用）予備項目Ｖ６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta1 zrnmsgarea34keta1}</td><td>（連携用）メッセージエリア（３４桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta2 zrnmsgarea34keta2}</td><td>（連携用）メッセージエリア（３４桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta3 zrnmsgarea34keta3}</td><td>（連携用）メッセージエリア（３４桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta4 zrnmsgarea34keta4}</td><td>（連携用）メッセージエリア（３４桁）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta5 zrnmsgarea34keta5}</td><td>（連携用）メッセージエリア（３４桁）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta6 zrnmsgarea34keta6}</td><td>（連携用）メッセージエリア（３４桁）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgarea34keta7 zrnmsgarea34keta7}</td><td>（連携用）メッセージエリア（３４桁）７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv95 zrnyobiv95}</td><td>（連携用）予備項目Ｖ９５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta1 zrnhurikaeyokokumsg34keta1}</td><td>（連携用）振替予告メッセージ（３４桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta2 zrnhurikaeyokokumsg34keta2}</td><td>（連携用）振替予告メッセージ（３４桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta3 zrnhurikaeyokokumsg34keta3}</td><td>（連携用）振替予告メッセージ（３４桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta4 zrnhurikaeyokokumsg34keta4}</td><td>（連携用）振替予告メッセージ（３４桁）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta5 zrnhurikaeyokokumsg34keta5}</td><td>（連携用）振替予告メッセージ（３４桁）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta6 zrnhurikaeyokokumsg34keta6}</td><td>（連携用）振替予告メッセージ（３４桁）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta7 zrnhurikaeyokokumsg34keta7}</td><td>（連携用）振替予告メッセージ（３４桁）７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta8 zrnhurikaeyokokumsg34keta8}</td><td>（連携用）振替予告メッセージ（３４桁）８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta9 zrnhurikaeyokokumsg34keta9}</td><td>（連携用）振替予告メッセージ（３４桁）９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta10 zrnhurikaeyokokumsg34keta10}</td><td>（連携用）振替予告メッセージ（３４桁）１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta11 zrnhurikaeyokokumsg34keta11}</td><td>（連携用）振替予告メッセージ（３４桁）１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta12 zrnhurikaeyokokumsg34keta12}</td><td>（連携用）振替予告メッセージ（３４桁）１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta13 zrnhurikaeyokokumsg34keta13}</td><td>（連携用）振替予告メッセージ（３４桁）１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta14 zrnhurikaeyokokumsg34keta14}</td><td>（連携用）振替予告メッセージ（３４桁）１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta15 zrnhurikaeyokokumsg34keta15}</td><td>（連携用）振替予告メッセージ（３４桁）１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta16 zrnhurikaeyokokumsg34keta16}</td><td>（連携用）振替予告メッセージ（３４桁）１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta17 zrnhurikaeyokokumsg34keta17}</td><td>（連携用）振替予告メッセージ（３４桁）１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta18 zrnhurikaeyokokumsg34keta18}</td><td>（連携用）振替予告メッセージ（３４桁）１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta19 zrnhurikaeyokokumsg34keta19}</td><td>（連携用）振替予告メッセージ（３４桁）１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta20 zrnhurikaeyokokumsg34keta20}</td><td>（連携用）振替予告メッセージ（３４桁）２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta21 zrnhurikaeyokokumsg34keta21}</td><td>（連携用）振替予告メッセージ（３４桁）２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta22 zrnhurikaeyokokumsg34keta22}</td><td>（連携用）振替予告メッセージ（３４桁）２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta23 zrnhurikaeyokokumsg34keta23}</td><td>（連携用）振替予告メッセージ（３４桁）２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta24 zrnhurikaeyokokumsg34keta24}</td><td>（連携用）振替予告メッセージ（３４桁）２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta25 zrnhurikaeyokokumsg34keta25}</td><td>（連携用）振替予告メッセージ（３４桁）２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta26 zrnhurikaeyokokumsg34keta26}</td><td>（連携用）振替予告メッセージ（３４桁）２６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta27 zrnhurikaeyokokumsg34keta27}</td><td>（連携用）振替予告メッセージ（３４桁）２７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaeyokokumsg34keta28 zrnhurikaeyokokumsg34keta28}</td><td>（連携用）振替予告メッセージ（３４桁）２８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv131 zrnyobiv131}</td><td>（連携用）予備項目Ｖ１３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250 zrnyobiv250}</td><td>（連携用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x6 zrnansyuyouyobin10x6}</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HrhnTtdkKanRn
 * @see     PKZT_HrhnTtdkKanRn
 * @see     QZT_HrhnTtdkKanRn
 * @see     GenQZT_HrhnTtdkKanRn
 */
@MappedSuperclass
@Table(name=GenZT_HrhnTtdkKanRn.TABLE_NAME)
@IdClass(value=PKZT_HrhnTtdkKanRn.class)
public abstract class GenZT_HrhnTtdkKanRn extends AbstractExDBEntityForZDB<ZT_HrhnTtdkKanRn, PKZT_HrhnTtdkKanRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HrhnTtdkKanRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
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
    public static final String ZRNYOBIV63               = "zrnyobiv63";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNKOUZAMASKINGMSG       = "zrnkouzamaskingmsg";
    public static final String ZRNHRKKAISUUTKIKTBRISYU  = "zrnhrkkaisuutkiktbrisyu";
    public static final String ZRNHRKKEIRO              = "zrnhrkkeiro";
    public static final String ZRNHRKP                  = "zrnhrkp";
    public static final String ZRNKOURYOKUHASSEIYMMSG   = "zrnkouryokuhasseiymmsg";
    public static final String ZRNSAKUSEIJITENMSG       = "zrnsakuseijitenmsg";
    public static final String ZRNKINGAKUMIDASI1        = "zrnkingakumidasi1";
    public static final String ZRNKINGAKU1              = "zrnkingaku1";
    public static final String ZRNKINGAKUMIDASI2        = "zrnkingakumidasi2";
    public static final String ZRNKINGAKU2              = "zrnkingaku2";
    public static final String ZRNKINGAKUMIDASI3        = "zrnkingakumidasi3";
    public static final String ZRNKINGAKU3              = "zrnkingaku3";
    public static final String ZRNPTUUKATYPE            = "zrnptuukatype";
    public static final String ZRNYOBIV61               = "zrnyobiv61";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNMSGAREA34KETA1        = "zrnmsgarea34keta1";
    public static final String ZRNMSGAREA34KETA2        = "zrnmsgarea34keta2";
    public static final String ZRNMSGAREA34KETA3        = "zrnmsgarea34keta3";
    public static final String ZRNMSGAREA34KETA4        = "zrnmsgarea34keta4";
    public static final String ZRNMSGAREA34KETA5        = "zrnmsgarea34keta5";
    public static final String ZRNMSGAREA34KETA6        = "zrnmsgarea34keta6";
    public static final String ZRNMSGAREA34KETA7        = "zrnmsgarea34keta7";
    public static final String ZRNYOBIV95               = "zrnyobiv95";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA1 = "zrnhurikaeyokokumsg34keta1";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA2 = "zrnhurikaeyokokumsg34keta2";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA3 = "zrnhurikaeyokokumsg34keta3";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA4 = "zrnhurikaeyokokumsg34keta4";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA5 = "zrnhurikaeyokokumsg34keta5";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA6 = "zrnhurikaeyokokumsg34keta6";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA7 = "zrnhurikaeyokokumsg34keta7";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA8 = "zrnhurikaeyokokumsg34keta8";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA9 = "zrnhurikaeyokokumsg34keta9";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA10 = "zrnhurikaeyokokumsg34keta10";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA11 = "zrnhurikaeyokokumsg34keta11";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA12 = "zrnhurikaeyokokumsg34keta12";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA13 = "zrnhurikaeyokokumsg34keta13";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA14 = "zrnhurikaeyokokumsg34keta14";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA15 = "zrnhurikaeyokokumsg34keta15";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA16 = "zrnhurikaeyokokumsg34keta16";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA17 = "zrnhurikaeyokokumsg34keta17";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA18 = "zrnhurikaeyokokumsg34keta18";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA19 = "zrnhurikaeyokokumsg34keta19";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA20 = "zrnhurikaeyokokumsg34keta20";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA21 = "zrnhurikaeyokokumsg34keta21";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA22 = "zrnhurikaeyokokumsg34keta22";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA23 = "zrnhurikaeyokokumsg34keta23";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA24 = "zrnhurikaeyokokumsg34keta24";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA25 = "zrnhurikaeyokokumsg34keta25";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA26 = "zrnhurikaeyokokumsg34keta26";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA27 = "zrnhurikaeyokokumsg34keta27";
    public static final String ZRNHURIKAEYOKOKUMSG34KETA28 = "zrnhurikaeyokokumsg34keta28";
    public static final String ZRNYOBIV131              = "zrnyobiv131";
    public static final String ZRNYOBIV250              = "zrnyobiv250";
    public static final String ZRNANSYUYOUYOBIN10X6     = "zrnansyuyouyobin10x6";

    private final PKZT_HrhnTtdkKanRn primaryKey;

    public GenZT_HrhnTtdkKanRn() {
        primaryKey = new PKZT_HrhnTtdkKanRn();
    }

    public GenZT_HrhnTtdkKanRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_HrhnTtdkKanRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_HrhnTtdkKanRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HrhnTtdkKanRn> getMetaClass() {
        return QZT_HrhnTtdkKanRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnyobiv7;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv63;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV63)
    public String getZrnyobiv63() {
        return zrnyobiv63;
    }

    public void setZrnyobiv63(String pZrnyobiv63) {
        zrnyobiv63 = pZrnyobiv63;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrnkouzamaskingmsg;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKOUZAMASKINGMSG)
    public String getZrnkouzamaskingmsg() {
        return zrnkouzamaskingmsg;
    }

    @DataConvert("toMultiByte")
    public void setZrnkouzamaskingmsg(String pZrnkouzamaskingmsg) {
        zrnkouzamaskingmsg = pZrnkouzamaskingmsg;
    }

    private String zrnhrkkaisuutkiktbrisyu;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHRKKAISUUTKIKTBRISYU)
    public String getZrnhrkkaisuutkiktbrisyu() {
        return zrnhrkkaisuutkiktbrisyu;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrkkaisuutkiktbrisyu(String pZrnhrkkaisuutkiktbrisyu) {
        zrnhrkkaisuutkiktbrisyu = pZrnhrkkaisuutkiktbrisyu;
    }

    private String zrnhrkkeiro;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHRKKEIRO)
    public String getZrnhrkkeiro() {
        return zrnhrkkeiro;
    }

    public void setZrnhrkkeiro(String pZrnhrkkeiro) {
        zrnhrkkeiro = pZrnhrkkeiro;
    }

    private String zrnhrkp;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHRKP)
    public String getZrnhrkp() {
        return zrnhrkp;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnhrkp(String pZrnhrkp) {
        zrnhrkp = pZrnhrkp;
    }

    private String zrnkouryokuhasseiymmsg;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKOURYOKUHASSEIYMMSG)
    public String getZrnkouryokuhasseiymmsg() {
        return zrnkouryokuhasseiymmsg;
    }

    @DataConvert("toMultiByte")
    public void setZrnkouryokuhasseiymmsg(String pZrnkouryokuhasseiymmsg) {
        zrnkouryokuhasseiymmsg = pZrnkouryokuhasseiymmsg;
    }

    private String zrnsakuseijitenmsg;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNSAKUSEIJITENMSG)
    public String getZrnsakuseijitenmsg() {
        return zrnsakuseijitenmsg;
    }

    @DataConvert("toMultiByte")
    public void setZrnsakuseijitenmsg(String pZrnsakuseijitenmsg) {
        zrnsakuseijitenmsg = pZrnsakuseijitenmsg;
    }

    private String zrnkingakumidasi1;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKINGAKUMIDASI1)
    public String getZrnkingakumidasi1() {
        return zrnkingakumidasi1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkingakumidasi1(String pZrnkingakumidasi1) {
        zrnkingakumidasi1 = pZrnkingakumidasi1;
    }

    private String zrnkingaku1;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKINGAKU1)
    public String getZrnkingaku1() {
        return zrnkingaku1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkingaku1(String pZrnkingaku1) {
        zrnkingaku1 = pZrnkingaku1;
    }

    private String zrnkingakumidasi2;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKINGAKUMIDASI2)
    public String getZrnkingakumidasi2() {
        return zrnkingakumidasi2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkingakumidasi2(String pZrnkingakumidasi2) {
        zrnkingakumidasi2 = pZrnkingakumidasi2;
    }

    private String zrnkingaku2;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKINGAKU2)
    public String getZrnkingaku2() {
        return zrnkingaku2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkingaku2(String pZrnkingaku2) {
        zrnkingaku2 = pZrnkingaku2;
    }

    private String zrnkingakumidasi3;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKINGAKUMIDASI3)
    public String getZrnkingakumidasi3() {
        return zrnkingakumidasi3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkingakumidasi3(String pZrnkingakumidasi3) {
        zrnkingakumidasi3 = pZrnkingakumidasi3;
    }

    private String zrnkingaku3;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNKINGAKU3)
    public String getZrnkingaku3() {
        return zrnkingaku3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkingaku3(String pZrnkingaku3) {
        zrnkingaku3 = pZrnkingaku3;
    }

    private String zrnptuukatype;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNPTUUKATYPE)
    public String getZrnptuukatype() {
        return zrnptuukatype;
    }

    public void setZrnptuukatype(String pZrnptuukatype) {
        zrnptuukatype = pZrnptuukatype;
    }

    private String zrnyobiv61;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV61)
    public String getZrnyobiv61() {
        return zrnyobiv61;
    }

    public void setZrnyobiv61(String pZrnyobiv61) {
        zrnyobiv61 = pZrnyobiv61;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnmsgarea34keta1;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA1)
    public String getZrnmsgarea34keta1() {
        return zrnmsgarea34keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta1(String pZrnmsgarea34keta1) {
        zrnmsgarea34keta1 = pZrnmsgarea34keta1;
    }

    private String zrnmsgarea34keta2;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA2)
    public String getZrnmsgarea34keta2() {
        return zrnmsgarea34keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta2(String pZrnmsgarea34keta2) {
        zrnmsgarea34keta2 = pZrnmsgarea34keta2;
    }

    private String zrnmsgarea34keta3;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA3)
    public String getZrnmsgarea34keta3() {
        return zrnmsgarea34keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta3(String pZrnmsgarea34keta3) {
        zrnmsgarea34keta3 = pZrnmsgarea34keta3;
    }

    private String zrnmsgarea34keta4;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA4)
    public String getZrnmsgarea34keta4() {
        return zrnmsgarea34keta4;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta4(String pZrnmsgarea34keta4) {
        zrnmsgarea34keta4 = pZrnmsgarea34keta4;
    }

    private String zrnmsgarea34keta5;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA5)
    public String getZrnmsgarea34keta5() {
        return zrnmsgarea34keta5;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta5(String pZrnmsgarea34keta5) {
        zrnmsgarea34keta5 = pZrnmsgarea34keta5;
    }

    private String zrnmsgarea34keta6;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA6)
    public String getZrnmsgarea34keta6() {
        return zrnmsgarea34keta6;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta6(String pZrnmsgarea34keta6) {
        zrnmsgarea34keta6 = pZrnmsgarea34keta6;
    }

    private String zrnmsgarea34keta7;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNMSGAREA34KETA7)
    public String getZrnmsgarea34keta7() {
        return zrnmsgarea34keta7;
    }

    @DataConvert("toMultiByte")
    public void setZrnmsgarea34keta7(String pZrnmsgarea34keta7) {
        zrnmsgarea34keta7 = pZrnmsgarea34keta7;
    }

    private String zrnyobiv95;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV95)
    public String getZrnyobiv95() {
        return zrnyobiv95;
    }

    public void setZrnyobiv95(String pZrnyobiv95) {
        zrnyobiv95 = pZrnyobiv95;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }

    private String zrnhurikaeyokokumsg34keta1;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA1)
    public String getZrnhurikaeyokokumsg34keta1() {
        return zrnhurikaeyokokumsg34keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta1(String pZrnhurikaeyokokumsg34keta1) {
        zrnhurikaeyokokumsg34keta1 = pZrnhurikaeyokokumsg34keta1;
    }

    private String zrnhurikaeyokokumsg34keta2;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA2)
    public String getZrnhurikaeyokokumsg34keta2() {
        return zrnhurikaeyokokumsg34keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta2(String pZrnhurikaeyokokumsg34keta2) {
        zrnhurikaeyokokumsg34keta2 = pZrnhurikaeyokokumsg34keta2;
    }

    private String zrnhurikaeyokokumsg34keta3;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA3)
    public String getZrnhurikaeyokokumsg34keta3() {
        return zrnhurikaeyokokumsg34keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta3(String pZrnhurikaeyokokumsg34keta3) {
        zrnhurikaeyokokumsg34keta3 = pZrnhurikaeyokokumsg34keta3;
    }

    private String zrnhurikaeyokokumsg34keta4;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA4)
    public String getZrnhurikaeyokokumsg34keta4() {
        return zrnhurikaeyokokumsg34keta4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta4(String pZrnhurikaeyokokumsg34keta4) {
        zrnhurikaeyokokumsg34keta4 = pZrnhurikaeyokokumsg34keta4;
    }

    private String zrnhurikaeyokokumsg34keta5;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA5)
    public String getZrnhurikaeyokokumsg34keta5() {
        return zrnhurikaeyokokumsg34keta5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta5(String pZrnhurikaeyokokumsg34keta5) {
        zrnhurikaeyokokumsg34keta5 = pZrnhurikaeyokokumsg34keta5;
    }

    private String zrnhurikaeyokokumsg34keta6;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA6)
    public String getZrnhurikaeyokokumsg34keta6() {
        return zrnhurikaeyokokumsg34keta6;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta6(String pZrnhurikaeyokokumsg34keta6) {
        zrnhurikaeyokokumsg34keta6 = pZrnhurikaeyokokumsg34keta6;
    }

    private String zrnhurikaeyokokumsg34keta7;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA7)
    public String getZrnhurikaeyokokumsg34keta7() {
        return zrnhurikaeyokokumsg34keta7;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta7(String pZrnhurikaeyokokumsg34keta7) {
        zrnhurikaeyokokumsg34keta7 = pZrnhurikaeyokokumsg34keta7;
    }

    private String zrnhurikaeyokokumsg34keta8;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA8)
    public String getZrnhurikaeyokokumsg34keta8() {
        return zrnhurikaeyokokumsg34keta8;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta8(String pZrnhurikaeyokokumsg34keta8) {
        zrnhurikaeyokokumsg34keta8 = pZrnhurikaeyokokumsg34keta8;
    }

    private String zrnhurikaeyokokumsg34keta9;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA9)
    public String getZrnhurikaeyokokumsg34keta9() {
        return zrnhurikaeyokokumsg34keta9;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta9(String pZrnhurikaeyokokumsg34keta9) {
        zrnhurikaeyokokumsg34keta9 = pZrnhurikaeyokokumsg34keta9;
    }

    private String zrnhurikaeyokokumsg34keta10;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA10)
    public String getZrnhurikaeyokokumsg34keta10() {
        return zrnhurikaeyokokumsg34keta10;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta10(String pZrnhurikaeyokokumsg34keta10) {
        zrnhurikaeyokokumsg34keta10 = pZrnhurikaeyokokumsg34keta10;
    }

    private String zrnhurikaeyokokumsg34keta11;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA11)
    public String getZrnhurikaeyokokumsg34keta11() {
        return zrnhurikaeyokokumsg34keta11;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta11(String pZrnhurikaeyokokumsg34keta11) {
        zrnhurikaeyokokumsg34keta11 = pZrnhurikaeyokokumsg34keta11;
    }

    private String zrnhurikaeyokokumsg34keta12;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA12)
    public String getZrnhurikaeyokokumsg34keta12() {
        return zrnhurikaeyokokumsg34keta12;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta12(String pZrnhurikaeyokokumsg34keta12) {
        zrnhurikaeyokokumsg34keta12 = pZrnhurikaeyokokumsg34keta12;
    }

    private String zrnhurikaeyokokumsg34keta13;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA13)
    public String getZrnhurikaeyokokumsg34keta13() {
        return zrnhurikaeyokokumsg34keta13;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta13(String pZrnhurikaeyokokumsg34keta13) {
        zrnhurikaeyokokumsg34keta13 = pZrnhurikaeyokokumsg34keta13;
    }

    private String zrnhurikaeyokokumsg34keta14;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA14)
    public String getZrnhurikaeyokokumsg34keta14() {
        return zrnhurikaeyokokumsg34keta14;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta14(String pZrnhurikaeyokokumsg34keta14) {
        zrnhurikaeyokokumsg34keta14 = pZrnhurikaeyokokumsg34keta14;
    }

    private String zrnhurikaeyokokumsg34keta15;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA15)
    public String getZrnhurikaeyokokumsg34keta15() {
        return zrnhurikaeyokokumsg34keta15;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta15(String pZrnhurikaeyokokumsg34keta15) {
        zrnhurikaeyokokumsg34keta15 = pZrnhurikaeyokokumsg34keta15;
    }

    private String zrnhurikaeyokokumsg34keta16;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA16)
    public String getZrnhurikaeyokokumsg34keta16() {
        return zrnhurikaeyokokumsg34keta16;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta16(String pZrnhurikaeyokokumsg34keta16) {
        zrnhurikaeyokokumsg34keta16 = pZrnhurikaeyokokumsg34keta16;
    }

    private String zrnhurikaeyokokumsg34keta17;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA17)
    public String getZrnhurikaeyokokumsg34keta17() {
        return zrnhurikaeyokokumsg34keta17;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta17(String pZrnhurikaeyokokumsg34keta17) {
        zrnhurikaeyokokumsg34keta17 = pZrnhurikaeyokokumsg34keta17;
    }

    private String zrnhurikaeyokokumsg34keta18;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA18)
    public String getZrnhurikaeyokokumsg34keta18() {
        return zrnhurikaeyokokumsg34keta18;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta18(String pZrnhurikaeyokokumsg34keta18) {
        zrnhurikaeyokokumsg34keta18 = pZrnhurikaeyokokumsg34keta18;
    }

    private String zrnhurikaeyokokumsg34keta19;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA19)
    public String getZrnhurikaeyokokumsg34keta19() {
        return zrnhurikaeyokokumsg34keta19;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta19(String pZrnhurikaeyokokumsg34keta19) {
        zrnhurikaeyokokumsg34keta19 = pZrnhurikaeyokokumsg34keta19;
    }

    private String zrnhurikaeyokokumsg34keta20;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA20)
    public String getZrnhurikaeyokokumsg34keta20() {
        return zrnhurikaeyokokumsg34keta20;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta20(String pZrnhurikaeyokokumsg34keta20) {
        zrnhurikaeyokokumsg34keta20 = pZrnhurikaeyokokumsg34keta20;
    }

    private String zrnhurikaeyokokumsg34keta21;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA21)
    public String getZrnhurikaeyokokumsg34keta21() {
        return zrnhurikaeyokokumsg34keta21;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta21(String pZrnhurikaeyokokumsg34keta21) {
        zrnhurikaeyokokumsg34keta21 = pZrnhurikaeyokokumsg34keta21;
    }

    private String zrnhurikaeyokokumsg34keta22;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA22)
    public String getZrnhurikaeyokokumsg34keta22() {
        return zrnhurikaeyokokumsg34keta22;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta22(String pZrnhurikaeyokokumsg34keta22) {
        zrnhurikaeyokokumsg34keta22 = pZrnhurikaeyokokumsg34keta22;
    }

    private String zrnhurikaeyokokumsg34keta23;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA23)
    public String getZrnhurikaeyokokumsg34keta23() {
        return zrnhurikaeyokokumsg34keta23;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta23(String pZrnhurikaeyokokumsg34keta23) {
        zrnhurikaeyokokumsg34keta23 = pZrnhurikaeyokokumsg34keta23;
    }

    private String zrnhurikaeyokokumsg34keta24;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA24)
    public String getZrnhurikaeyokokumsg34keta24() {
        return zrnhurikaeyokokumsg34keta24;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta24(String pZrnhurikaeyokokumsg34keta24) {
        zrnhurikaeyokokumsg34keta24 = pZrnhurikaeyokokumsg34keta24;
    }

    private String zrnhurikaeyokokumsg34keta25;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA25)
    public String getZrnhurikaeyokokumsg34keta25() {
        return zrnhurikaeyokokumsg34keta25;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta25(String pZrnhurikaeyokokumsg34keta25) {
        zrnhurikaeyokokumsg34keta25 = pZrnhurikaeyokokumsg34keta25;
    }

    private String zrnhurikaeyokokumsg34keta26;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA26)
    public String getZrnhurikaeyokokumsg34keta26() {
        return zrnhurikaeyokokumsg34keta26;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta26(String pZrnhurikaeyokokumsg34keta26) {
        zrnhurikaeyokokumsg34keta26 = pZrnhurikaeyokokumsg34keta26;
    }

    private String zrnhurikaeyokokumsg34keta27;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA27)
    public String getZrnhurikaeyokokumsg34keta27() {
        return zrnhurikaeyokokumsg34keta27;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta27(String pZrnhurikaeyokokumsg34keta27) {
        zrnhurikaeyokokumsg34keta27 = pZrnhurikaeyokokumsg34keta27;
    }

    private String zrnhurikaeyokokumsg34keta28;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNHURIKAEYOKOKUMSG34KETA28)
    public String getZrnhurikaeyokokumsg34keta28() {
        return zrnhurikaeyokokumsg34keta28;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaeyokokumsg34keta28(String pZrnhurikaeyokokumsg34keta28) {
        zrnhurikaeyokokumsg34keta28 = pZrnhurikaeyokokumsg34keta28;
    }

    private String zrnyobiv131;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV131)
    public String getZrnyobiv131() {
        return zrnyobiv131;
    }

    public void setZrnyobiv131(String pZrnyobiv131) {
        zrnyobiv131 = pZrnyobiv131;
    }

    private String zrnyobiv250;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNYOBIV250)
    public String getZrnyobiv250() {
        return zrnyobiv250;
    }

    public void setZrnyobiv250(String pZrnyobiv250) {
        zrnyobiv250 = pZrnyobiv250;
    }

    private String zrnansyuyouyobin10x6;

    @Column(name=GenZT_HrhnTtdkKanRn.ZRNANSYUYOUYOBIN10X6)
    public String getZrnansyuyouyobin10x6() {
        return zrnansyuyouyobin10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x6(String pZrnansyuyouyobin10x6) {
        zrnansyuyouyobin10x6 = pZrnansyuyouyobin10x6;
    }
}