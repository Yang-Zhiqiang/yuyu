package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.id.PKZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.GenQZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiRn;

/**
 * 口座振替開始案内テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KouzahuriStartAnnaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriStartAnnaiRn}</td><td colspan="3">口座振替開始案内テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_KouzahuriStartAnnaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_KouzahuriStartAnnaiRn ○}</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnyobiv61 zrnyobiv61}</td><td>（連携用）予備項目Ｖ６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutinm zrntuutinm}</td><td>（連携用）通知名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon1 zrnaisatumongon1}</td><td>（連携用）挨拶文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon2 zrnaisatumongon2}</td><td>（連携用）挨拶文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon3 zrnaisatumongon3}</td><td>（連携用）挨拶文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon4 zrnaisatumongon4}</td><td>（連携用）挨拶文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon5 zrnaisatumongon5}</td><td>（連携用）挨拶文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv62 zrnyobiv62}</td><td>（連携用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai1 zrnkzhurikaeonegai1}</td><td>（連携用）口座振替についてのお願い１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai2 zrnkzhurikaeonegai2}</td><td>（連携用）口座振替についてのお願い２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai3 zrnkzhurikaeonegai3}</td><td>（連携用）口座振替についてのお願い３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai4 zrnkzhurikaeonegai4}</td><td>（連携用）口座振替についてのお願い４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai5 zrnkzhurikaeonegai5}</td><td>（連携用）口座振替についてのお願い５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai6 zrnkzhurikaeonegai6}</td><td>（連携用）口座振替についてのお願い６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai7 zrnkzhurikaeonegai7}</td><td>（連携用）口座振替についてのお願い７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai8 zrnkzhurikaeonegai8}</td><td>（連携用）口座振替についてのお願い８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai9 zrnkzhurikaeonegai9}</td><td>（連携用）口座振替についてのお願い９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai10 zrnkzhurikaeonegai10}</td><td>（連携用）口座振替についてのお願い１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai11 zrnkzhurikaeonegai11}</td><td>（連携用）口座振替についてのお願い１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai12 zrnkzhurikaeonegai12}</td><td>（連携用）口座振替についてのお願い１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai13 zrnkzhurikaeonegai13}</td><td>（連携用）口座振替についてのお願い１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai14 zrnkzhurikaeonegai14}</td><td>（連携用）口座振替についてのお願い１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeonegai15 zrnkzhurikaeonegai15}</td><td>（連携用）口座振替についてのお願い１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv210 zrnyobiv210}</td><td>（連携用）予備項目Ｖ２１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutisakuseiymdseireki zrntuutisakuseiymdseireki}</td><td>（連携用）通知作成年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhnnm zrnsyouhnnm}</td><td>（連携用）商品名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdseireki zrnkykymdseireki}</td><td>（連携用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkbriphurikaeyoteigk zrntkbriphurikaeyoteigk}</td><td>（連携用）月払保険料（振替予定金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekzhosokumongon zrnhurikaekzhosokumongon}</td><td>（連携用）振替口座補足文言</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz1 zrnhurikaekz1}</td><td>（連携用）振替口座１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz2 zrnhurikaekz2}</td><td>（連携用）振替口座２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz3 zrnhurikaekz3}</td><td>（連携用）振替口座３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz4 zrnhurikaekz4}</td><td>（連携用）振替口座４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhurikaekz5 zrnhurikaekz5}</td><td>（連携用）振替口座５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv124 zrnyobiv124}</td><td>（連携用）予備項目Ｖ１２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x7 zrnansyuyouyobin10x7}</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea1 zrnkzhuristartanfreearea1}</td><td>（連携用）口座振替開始案内フリーエリア１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea2 zrnkzhuristartanfreearea2}</td><td>（連携用）口座振替開始案内フリーエリア２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea3 zrnkzhuristartanfreearea3}</td><td>（連携用）口座振替開始案内フリーエリア３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea4 zrnkzhuristartanfreearea4}</td><td>（連携用）口座振替開始案内フリーエリア４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea5 zrnkzhuristartanfreearea5}</td><td>（連携用）口座振替開始案内フリーエリア５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea6 zrnkzhuristartanfreearea6}</td><td>（連携用）口座振替開始案内フリーエリア６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea7 zrnkzhuristartanfreearea7}</td><td>（連携用）口座振替開始案内フリーエリア７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea8 zrnkzhuristartanfreearea8}</td><td>（連携用）口座振替開始案内フリーエリア８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea9 zrnkzhuristartanfreearea9}</td><td>（連携用）口座振替開始案内フリーエリア９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuristartanfreearea10 zrnkzhuristartanfreearea10}</td><td>（連携用）口座振替開始案内フリーエリア１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv140 zrnyobiv140}</td><td>（連携用）予備項目Ｖ１４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x8 zrnansyuyouyobin10x8}</td><td>（連携用）案内収納用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriStartAnnaiRn
 * @see     PKZT_KouzahuriStartAnnaiRn
 * @see     QZT_KouzahuriStartAnnaiRn
 * @see     GenQZT_KouzahuriStartAnnaiRn
 */
@MappedSuperclass
@Table(name=GenZT_KouzahuriStartAnnaiRn.TABLE_NAME)
@IdClass(value=PKZT_KouzahuriStartAnnaiRn.class)
public abstract class GenZT_KouzahuriStartAnnaiRn extends AbstractExDBEntityForZDB<ZT_KouzahuriStartAnnaiRn, PKZT_KouzahuriStartAnnaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KouzahuriStartAnnaiRn";
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
    public static final String ZRNYOBIV61               = "zrnyobiv61";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNTUUTINM               = "zrntuutinm";
    public static final String ZRNAISATUMONGON1         = "zrnaisatumongon1";
    public static final String ZRNAISATUMONGON2         = "zrnaisatumongon2";
    public static final String ZRNAISATUMONGON3         = "zrnaisatumongon3";
    public static final String ZRNAISATUMONGON4         = "zrnaisatumongon4";
    public static final String ZRNAISATUMONGON5         = "zrnaisatumongon5";
    public static final String ZRNYOBIV62               = "zrnyobiv62";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNKZHURIKAEONEGAI1      = "zrnkzhurikaeonegai1";
    public static final String ZRNKZHURIKAEONEGAI2      = "zrnkzhurikaeonegai2";
    public static final String ZRNKZHURIKAEONEGAI3      = "zrnkzhurikaeonegai3";
    public static final String ZRNKZHURIKAEONEGAI4      = "zrnkzhurikaeonegai4";
    public static final String ZRNKZHURIKAEONEGAI5      = "zrnkzhurikaeonegai5";
    public static final String ZRNKZHURIKAEONEGAI6      = "zrnkzhurikaeonegai6";
    public static final String ZRNKZHURIKAEONEGAI7      = "zrnkzhurikaeonegai7";
    public static final String ZRNKZHURIKAEONEGAI8      = "zrnkzhurikaeonegai8";
    public static final String ZRNKZHURIKAEONEGAI9      = "zrnkzhurikaeonegai9";
    public static final String ZRNKZHURIKAEONEGAI10     = "zrnkzhurikaeonegai10";
    public static final String ZRNKZHURIKAEONEGAI11     = "zrnkzhurikaeonegai11";
    public static final String ZRNKZHURIKAEONEGAI12     = "zrnkzhurikaeonegai12";
    public static final String ZRNKZHURIKAEONEGAI13     = "zrnkzhurikaeonegai13";
    public static final String ZRNKZHURIKAEONEGAI14     = "zrnkzhurikaeonegai14";
    public static final String ZRNKZHURIKAEONEGAI15     = "zrnkzhurikaeonegai15";
    public static final String ZRNYOBIV210              = "zrnyobiv210";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";
    public static final String ZRNTUUTISAKUSEIYMDSEIREKI = "zrntuutisakuseiymdseireki";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNSYOUHNNM              = "zrnsyouhnnm";
    public static final String ZRNKYKYMDSEIREKI         = "zrnkykymdseireki";
    public static final String ZRNTKBRIPHURIKAEYOTEIGK  = "zrntkbriphurikaeyoteigk";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNHURIKAEKZHOSOKUMONGON = "zrnhurikaekzhosokumongon";
    public static final String ZRNHURIKAEKZ1            = "zrnhurikaekz1";
    public static final String ZRNHURIKAEKZ2            = "zrnhurikaekz2";
    public static final String ZRNHURIKAEKZ3            = "zrnhurikaekz3";
    public static final String ZRNHURIKAEKZ4            = "zrnhurikaekz4";
    public static final String ZRNHURIKAEKZ5            = "zrnhurikaekz5";
    public static final String ZRNYOBIV124              = "zrnyobiv124";
    public static final String ZRNANSYUYOUYOBIN10X7     = "zrnansyuyouyobin10x7";
    public static final String ZRNKZHURISTARTANFREEAREA1 = "zrnkzhuristartanfreearea1";
    public static final String ZRNKZHURISTARTANFREEAREA2 = "zrnkzhuristartanfreearea2";
    public static final String ZRNKZHURISTARTANFREEAREA3 = "zrnkzhuristartanfreearea3";
    public static final String ZRNKZHURISTARTANFREEAREA4 = "zrnkzhuristartanfreearea4";
    public static final String ZRNKZHURISTARTANFREEAREA5 = "zrnkzhuristartanfreearea5";
    public static final String ZRNKZHURISTARTANFREEAREA6 = "zrnkzhuristartanfreearea6";
    public static final String ZRNKZHURISTARTANFREEAREA7 = "zrnkzhuristartanfreearea7";
    public static final String ZRNKZHURISTARTANFREEAREA8 = "zrnkzhuristartanfreearea8";
    public static final String ZRNKZHURISTARTANFREEAREA9 = "zrnkzhuristartanfreearea9";
    public static final String ZRNKZHURISTARTANFREEAREA10 = "zrnkzhuristartanfreearea10";
    public static final String ZRNYOBIV140              = "zrnyobiv140";
    public static final String ZRNANSYUYOUYOBIN10X8     = "zrnansyuyouyobin10x8";

    private final PKZT_KouzahuriStartAnnaiRn primaryKey;

    public GenZT_KouzahuriStartAnnaiRn() {
        primaryKey = new PKZT_KouzahuriStartAnnaiRn();
    }

    public GenZT_KouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_KouzahuriStartAnnaiRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_KouzahuriStartAnnaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KouzahuriStartAnnaiRn> getMetaClass() {
        return QZT_KouzahuriStartAnnaiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnyobiv9;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv61;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV61)
    public String getZrnyobiv61() {
        return zrnyobiv61;
    }

    public void setZrnyobiv61(String pZrnyobiv61) {
        zrnyobiv61 = pZrnyobiv61;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrntuutinm;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTUUTINM)
    public String getZrntuutinm() {
        return zrntuutinm;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutinm(String pZrntuutinm) {
        zrntuutinm = pZrntuutinm;
    }

    private String zrnaisatumongon1;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNAISATUMONGON1)
    public String getZrnaisatumongon1() {
        return zrnaisatumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon1(String pZrnaisatumongon1) {
        zrnaisatumongon1 = pZrnaisatumongon1;
    }

    private String zrnaisatumongon2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNAISATUMONGON2)
    public String getZrnaisatumongon2() {
        return zrnaisatumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon2(String pZrnaisatumongon2) {
        zrnaisatumongon2 = pZrnaisatumongon2;
    }

    private String zrnaisatumongon3;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNAISATUMONGON3)
    public String getZrnaisatumongon3() {
        return zrnaisatumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon3(String pZrnaisatumongon3) {
        zrnaisatumongon3 = pZrnaisatumongon3;
    }

    private String zrnaisatumongon4;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNAISATUMONGON4)
    public String getZrnaisatumongon4() {
        return zrnaisatumongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon4(String pZrnaisatumongon4) {
        zrnaisatumongon4 = pZrnaisatumongon4;
    }

    private String zrnaisatumongon5;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNAISATUMONGON5)
    public String getZrnaisatumongon5() {
        return zrnaisatumongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon5(String pZrnaisatumongon5) {
        zrnaisatumongon5 = pZrnaisatumongon5;
    }

    private String zrnyobiv62;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV62)
    public String getZrnyobiv62() {
        return zrnyobiv62;
    }

    public void setZrnyobiv62(String pZrnyobiv62) {
        zrnyobiv62 = pZrnyobiv62;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnkzhurikaeonegai1;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI1)
    public String getZrnkzhurikaeonegai1() {
        return zrnkzhurikaeonegai1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai1(String pZrnkzhurikaeonegai1) {
        zrnkzhurikaeonegai1 = pZrnkzhurikaeonegai1;
    }

    private String zrnkzhurikaeonegai2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI2)
    public String getZrnkzhurikaeonegai2() {
        return zrnkzhurikaeonegai2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai2(String pZrnkzhurikaeonegai2) {
        zrnkzhurikaeonegai2 = pZrnkzhurikaeonegai2;
    }

    private String zrnkzhurikaeonegai3;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI3)
    public String getZrnkzhurikaeonegai3() {
        return zrnkzhurikaeonegai3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai3(String pZrnkzhurikaeonegai3) {
        zrnkzhurikaeonegai3 = pZrnkzhurikaeonegai3;
    }

    private String zrnkzhurikaeonegai4;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI4)
    public String getZrnkzhurikaeonegai4() {
        return zrnkzhurikaeonegai4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai4(String pZrnkzhurikaeonegai4) {
        zrnkzhurikaeonegai4 = pZrnkzhurikaeonegai4;
    }

    private String zrnkzhurikaeonegai5;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI5)
    public String getZrnkzhurikaeonegai5() {
        return zrnkzhurikaeonegai5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai5(String pZrnkzhurikaeonegai5) {
        zrnkzhurikaeonegai5 = pZrnkzhurikaeonegai5;
    }

    private String zrnkzhurikaeonegai6;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI6)
    public String getZrnkzhurikaeonegai6() {
        return zrnkzhurikaeonegai6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai6(String pZrnkzhurikaeonegai6) {
        zrnkzhurikaeonegai6 = pZrnkzhurikaeonegai6;
    }

    private String zrnkzhurikaeonegai7;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI7)
    public String getZrnkzhurikaeonegai7() {
        return zrnkzhurikaeonegai7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai7(String pZrnkzhurikaeonegai7) {
        zrnkzhurikaeonegai7 = pZrnkzhurikaeonegai7;
    }

    private String zrnkzhurikaeonegai8;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI8)
    public String getZrnkzhurikaeonegai8() {
        return zrnkzhurikaeonegai8;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai8(String pZrnkzhurikaeonegai8) {
        zrnkzhurikaeonegai8 = pZrnkzhurikaeonegai8;
    }

    private String zrnkzhurikaeonegai9;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI9)
    public String getZrnkzhurikaeonegai9() {
        return zrnkzhurikaeonegai9;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai9(String pZrnkzhurikaeonegai9) {
        zrnkzhurikaeonegai9 = pZrnkzhurikaeonegai9;
    }

    private String zrnkzhurikaeonegai10;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI10)
    public String getZrnkzhurikaeonegai10() {
        return zrnkzhurikaeonegai10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai10(String pZrnkzhurikaeonegai10) {
        zrnkzhurikaeonegai10 = pZrnkzhurikaeonegai10;
    }

    private String zrnkzhurikaeonegai11;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI11)
    public String getZrnkzhurikaeonegai11() {
        return zrnkzhurikaeonegai11;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai11(String pZrnkzhurikaeonegai11) {
        zrnkzhurikaeonegai11 = pZrnkzhurikaeonegai11;
    }

    private String zrnkzhurikaeonegai12;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI12)
    public String getZrnkzhurikaeonegai12() {
        return zrnkzhurikaeonegai12;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai12(String pZrnkzhurikaeonegai12) {
        zrnkzhurikaeonegai12 = pZrnkzhurikaeonegai12;
    }

    private String zrnkzhurikaeonegai13;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI13)
    public String getZrnkzhurikaeonegai13() {
        return zrnkzhurikaeonegai13;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai13(String pZrnkzhurikaeonegai13) {
        zrnkzhurikaeonegai13 = pZrnkzhurikaeonegai13;
    }

    private String zrnkzhurikaeonegai14;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI14)
    public String getZrnkzhurikaeonegai14() {
        return zrnkzhurikaeonegai14;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai14(String pZrnkzhurikaeonegai14) {
        zrnkzhurikaeonegai14 = pZrnkzhurikaeonegai14;
    }

    private String zrnkzhurikaeonegai15;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURIKAEONEGAI15)
    public String getZrnkzhurikaeonegai15() {
        return zrnkzhurikaeonegai15;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhurikaeonegai15(String pZrnkzhurikaeonegai15) {
        zrnkzhurikaeonegai15 = pZrnkzhurikaeonegai15;
    }

    private String zrnyobiv210;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV210)
    public String getZrnyobiv210() {
        return zrnyobiv210;
    }

    public void setZrnyobiv210(String pZrnyobiv210) {
        zrnyobiv210 = pZrnyobiv210;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }

    private String zrntuutisakuseiymdseireki;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTUUTISAKUSEIYMDSEIREKI)
    public String getZrntuutisakuseiymdseireki() {
        return zrntuutisakuseiymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutisakuseiymdseireki(String pZrntuutisakuseiymdseireki) {
        zrntuutisakuseiymdseireki = pZrntuutisakuseiymdseireki;
    }

    private String zrnsyono2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnsyouhnnm;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNSYOUHNNM)
    public String getZrnsyouhnnm() {
        return zrnsyouhnnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyouhnnm(String pZrnsyouhnnm) {
        zrnsyouhnnm = pZrnsyouhnnm;
    }

    private String zrnkykymdseireki;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKYKYMDSEIREKI)
    public String getZrnkykymdseireki() {
        return zrnkykymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdseireki(String pZrnkykymdseireki) {
        zrnkykymdseireki = pZrnkykymdseireki;
    }

    private String zrntkbriphurikaeyoteigk;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNTKBRIPHURIKAEYOTEIGK)
    public String getZrntkbriphurikaeyoteigk() {
        return zrntkbriphurikaeyoteigk;
    }

    @Padding(mode = "left", padChar = '0', length = 13)
    public void setZrntkbriphurikaeyoteigk(String pZrntkbriphurikaeyoteigk) {
        zrntkbriphurikaeyoteigk = pZrntkbriphurikaeyoteigk;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnhurikaekzhosokumongon;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHURIKAEKZHOSOKUMONGON)
    public String getZrnhurikaekzhosokumongon() {
        return zrnhurikaekzhosokumongon;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekzhosokumongon(String pZrnhurikaekzhosokumongon) {
        zrnhurikaekzhosokumongon = pZrnhurikaekzhosokumongon;
    }

    private String zrnhurikaekz1;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHURIKAEKZ1)
    public String getZrnhurikaekz1() {
        return zrnhurikaekz1;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz1(String pZrnhurikaekz1) {
        zrnhurikaekz1 = pZrnhurikaekz1;
    }

    private String zrnhurikaekz2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHURIKAEKZ2)
    public String getZrnhurikaekz2() {
        return zrnhurikaekz2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz2(String pZrnhurikaekz2) {
        zrnhurikaekz2 = pZrnhurikaekz2;
    }

    private String zrnhurikaekz3;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHURIKAEKZ3)
    public String getZrnhurikaekz3() {
        return zrnhurikaekz3;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz3(String pZrnhurikaekz3) {
        zrnhurikaekz3 = pZrnhurikaekz3;
    }

    private String zrnhurikaekz4;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHURIKAEKZ4)
    public String getZrnhurikaekz4() {
        return zrnhurikaekz4;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz4(String pZrnhurikaekz4) {
        zrnhurikaekz4 = pZrnhurikaekz4;
    }

    private String zrnhurikaekz5;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNHURIKAEKZ5)
    public String getZrnhurikaekz5() {
        return zrnhurikaekz5;
    }

    @DataConvert("toMultiByte")
    public void setZrnhurikaekz5(String pZrnhurikaekz5) {
        zrnhurikaekz5 = pZrnhurikaekz5;
    }

    private String zrnyobiv124;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV124)
    public String getZrnyobiv124() {
        return zrnyobiv124;
    }

    public void setZrnyobiv124(String pZrnyobiv124) {
        zrnyobiv124 = pZrnyobiv124;
    }

    private String zrnansyuyouyobin10x7;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10X7)
    public String getZrnansyuyouyobin10x7() {
        return zrnansyuyouyobin10x7;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x7(String pZrnansyuyouyobin10x7) {
        zrnansyuyouyobin10x7 = pZrnansyuyouyobin10x7;
    }

    private String zrnkzhuristartanfreearea1;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA1)
    public String getZrnkzhuristartanfreearea1() {
        return zrnkzhuristartanfreearea1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea1(String pZrnkzhuristartanfreearea1) {
        zrnkzhuristartanfreearea1 = pZrnkzhuristartanfreearea1;
    }

    private String zrnkzhuristartanfreearea2;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA2)
    public String getZrnkzhuristartanfreearea2() {
        return zrnkzhuristartanfreearea2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea2(String pZrnkzhuristartanfreearea2) {
        zrnkzhuristartanfreearea2 = pZrnkzhuristartanfreearea2;
    }

    private String zrnkzhuristartanfreearea3;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA3)
    public String getZrnkzhuristartanfreearea3() {
        return zrnkzhuristartanfreearea3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea3(String pZrnkzhuristartanfreearea3) {
        zrnkzhuristartanfreearea3 = pZrnkzhuristartanfreearea3;
    }

    private String zrnkzhuristartanfreearea4;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA4)
    public String getZrnkzhuristartanfreearea4() {
        return zrnkzhuristartanfreearea4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea4(String pZrnkzhuristartanfreearea4) {
        zrnkzhuristartanfreearea4 = pZrnkzhuristartanfreearea4;
    }

    private String zrnkzhuristartanfreearea5;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA5)
    public String getZrnkzhuristartanfreearea5() {
        return zrnkzhuristartanfreearea5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea5(String pZrnkzhuristartanfreearea5) {
        zrnkzhuristartanfreearea5 = pZrnkzhuristartanfreearea5;
    }

    private String zrnkzhuristartanfreearea6;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA6)
    public String getZrnkzhuristartanfreearea6() {
        return zrnkzhuristartanfreearea6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea6(String pZrnkzhuristartanfreearea6) {
        zrnkzhuristartanfreearea6 = pZrnkzhuristartanfreearea6;
    }

    private String zrnkzhuristartanfreearea7;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA7)
    public String getZrnkzhuristartanfreearea7() {
        return zrnkzhuristartanfreearea7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea7(String pZrnkzhuristartanfreearea7) {
        zrnkzhuristartanfreearea7 = pZrnkzhuristartanfreearea7;
    }

    private String zrnkzhuristartanfreearea8;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA8)
    public String getZrnkzhuristartanfreearea8() {
        return zrnkzhuristartanfreearea8;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea8(String pZrnkzhuristartanfreearea8) {
        zrnkzhuristartanfreearea8 = pZrnkzhuristartanfreearea8;
    }

    private String zrnkzhuristartanfreearea9;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA9)
    public String getZrnkzhuristartanfreearea9() {
        return zrnkzhuristartanfreearea9;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea9(String pZrnkzhuristartanfreearea9) {
        zrnkzhuristartanfreearea9 = pZrnkzhuristartanfreearea9;
    }

    private String zrnkzhuristartanfreearea10;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNKZHURISTARTANFREEAREA10)
    public String getZrnkzhuristartanfreearea10() {
        return zrnkzhuristartanfreearea10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzhuristartanfreearea10(String pZrnkzhuristartanfreearea10) {
        zrnkzhuristartanfreearea10 = pZrnkzhuristartanfreearea10;
    }

    private String zrnyobiv140;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNYOBIV140)
    public String getZrnyobiv140() {
        return zrnyobiv140;
    }

    public void setZrnyobiv140(String pZrnyobiv140) {
        zrnyobiv140 = pZrnyobiv140;
    }

    private String zrnansyuyouyobin10x8;

    @Column(name=GenZT_KouzahuriStartAnnaiRn.ZRNANSYUYOUYOBIN10X8)
    public String getZrnansyuyouyobin10x8() {
        return zrnansyuyouyobin10x8;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x8(String pZrnansyuyouyobin10x8) {
        zrnansyuyouyobin10x8 = pZrnansyuyouyobin10x8;
    }
}