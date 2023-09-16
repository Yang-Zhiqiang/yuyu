package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.id.PKZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.GenQZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiTy;

/**
 * 口座振替開始案内テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KouzahuriStartAnnaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriStartAnnaiTy}</td><td colspan="3">口座振替開始案内テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_KouzahuriStartAnnaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_KouzahuriStartAnnaiTy ○}</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtyyobiv61 ztyyobiv61}</td><td>（中継用）予備項目Ｖ６１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutinm ztytuutinm}</td><td>（中継用）通知名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon1 ztyaisatumongon1}</td><td>（中継用）挨拶文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon2 ztyaisatumongon2}</td><td>（中継用）挨拶文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon3 ztyaisatumongon3}</td><td>（中継用）挨拶文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon4 ztyaisatumongon4}</td><td>（中継用）挨拶文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon5 ztyaisatumongon5}</td><td>（中継用）挨拶文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv62 ztyyobiv62}</td><td>（中継用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai1 ztykzhurikaeonegai1}</td><td>（中継用）口座振替についてのお願い１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai2 ztykzhurikaeonegai2}</td><td>（中継用）口座振替についてのお願い２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai3 ztykzhurikaeonegai3}</td><td>（中継用）口座振替についてのお願い３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai4 ztykzhurikaeonegai4}</td><td>（中継用）口座振替についてのお願い４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai5 ztykzhurikaeonegai5}</td><td>（中継用）口座振替についてのお願い５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai6 ztykzhurikaeonegai6}</td><td>（中継用）口座振替についてのお願い６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai7 ztykzhurikaeonegai7}</td><td>（中継用）口座振替についてのお願い７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai8 ztykzhurikaeonegai8}</td><td>（中継用）口座振替についてのお願い８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai9 ztykzhurikaeonegai9}</td><td>（中継用）口座振替についてのお願い９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai10 ztykzhurikaeonegai10}</td><td>（中継用）口座振替についてのお願い１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai11 ztykzhurikaeonegai11}</td><td>（中継用）口座振替についてのお願い１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai12 ztykzhurikaeonegai12}</td><td>（中継用）口座振替についてのお願い１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai13 ztykzhurikaeonegai13}</td><td>（中継用）口座振替についてのお願い１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai14 ztykzhurikaeonegai14}</td><td>（中継用）口座振替についてのお願い１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeonegai15 ztykzhurikaeonegai15}</td><td>（中継用）口座振替についてのお願い１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv210 ztyyobiv210}</td><td>（中継用）予備項目Ｖ２１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutisakuseiymdseireki ztytuutisakuseiymdseireki}</td><td>（中継用）通知作成年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhnnm ztysyouhnnm}</td><td>（中継用）商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdseireki ztykykymdseireki}</td><td>（中継用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkbriphurikaeyoteigk ztytkbriphurikaeyoteigk}</td><td>（中継用）月払保険料（振替予定金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekzhosokumongon ztyhurikaekzhosokumongon}</td><td>（中継用）振替口座補足文言</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz1 ztyhurikaekz1}</td><td>（中継用）振替口座１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz2 ztyhurikaekz2}</td><td>（中継用）振替口座２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz3 ztyhurikaekz3}</td><td>（中継用）振替口座３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz4 ztyhurikaekz4}</td><td>（中継用）振替口座４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhurikaekz5 ztyhurikaekz5}</td><td>（中継用）振替口座５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv124 ztyyobiv124}</td><td>（中継用）予備項目Ｖ１２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x7 ztyansyuyouyobin10x7}</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea1 ztykzhuristartanfreearea1}</td><td>（中継用）口座振替開始案内フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea2 ztykzhuristartanfreearea2}</td><td>（中継用）口座振替開始案内フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea3 ztykzhuristartanfreearea3}</td><td>（中継用）口座振替開始案内フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea4 ztykzhuristartanfreearea4}</td><td>（中継用）口座振替開始案内フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea5 ztykzhuristartanfreearea5}</td><td>（中継用）口座振替開始案内フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea6 ztykzhuristartanfreearea6}</td><td>（中継用）口座振替開始案内フリーエリア６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea7 ztykzhuristartanfreearea7}</td><td>（中継用）口座振替開始案内フリーエリア７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea8 ztykzhuristartanfreearea8}</td><td>（中継用）口座振替開始案内フリーエリア８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea9 ztykzhuristartanfreearea9}</td><td>（中継用）口座振替開始案内フリーエリア９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuristartanfreearea10 ztykzhuristartanfreearea10}</td><td>（中継用）口座振替開始案内フリーエリア１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv140 ztyyobiv140}</td><td>（中継用）予備項目Ｖ１４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x8 ztyansyuyouyobin10x8}</td><td>（中継用）案内収納用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriStartAnnaiTy
 * @see     PKZT_KouzahuriStartAnnaiTy
 * @see     QZT_KouzahuriStartAnnaiTy
 * @see     GenQZT_KouzahuriStartAnnaiTy
 */
@MappedSuperclass
@Table(name=GenZT_KouzahuriStartAnnaiTy.TABLE_NAME)
@IdClass(value=PKZT_KouzahuriStartAnnaiTy.class)
public abstract class GenZT_KouzahuriStartAnnaiTy extends AbstractExDBEntity<ZT_KouzahuriStartAnnaiTy, PKZT_KouzahuriStartAnnaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KouzahuriStartAnnaiTy";
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
    public static final String ZTYYOBIV61               = "ztyyobiv61";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYTUUTINM               = "ztytuutinm";
    public static final String ZTYAISATUMONGON1         = "ztyaisatumongon1";
    public static final String ZTYAISATUMONGON2         = "ztyaisatumongon2";
    public static final String ZTYAISATUMONGON3         = "ztyaisatumongon3";
    public static final String ZTYAISATUMONGON4         = "ztyaisatumongon4";
    public static final String ZTYAISATUMONGON5         = "ztyaisatumongon5";
    public static final String ZTYYOBIV62               = "ztyyobiv62";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYKZHURIKAEONEGAI1      = "ztykzhurikaeonegai1";
    public static final String ZTYKZHURIKAEONEGAI2      = "ztykzhurikaeonegai2";
    public static final String ZTYKZHURIKAEONEGAI3      = "ztykzhurikaeonegai3";
    public static final String ZTYKZHURIKAEONEGAI4      = "ztykzhurikaeonegai4";
    public static final String ZTYKZHURIKAEONEGAI5      = "ztykzhurikaeonegai5";
    public static final String ZTYKZHURIKAEONEGAI6      = "ztykzhurikaeonegai6";
    public static final String ZTYKZHURIKAEONEGAI7      = "ztykzhurikaeonegai7";
    public static final String ZTYKZHURIKAEONEGAI8      = "ztykzhurikaeonegai8";
    public static final String ZTYKZHURIKAEONEGAI9      = "ztykzhurikaeonegai9";
    public static final String ZTYKZHURIKAEONEGAI10     = "ztykzhurikaeonegai10";
    public static final String ZTYKZHURIKAEONEGAI11     = "ztykzhurikaeonegai11";
    public static final String ZTYKZHURIKAEONEGAI12     = "ztykzhurikaeonegai12";
    public static final String ZTYKZHURIKAEONEGAI13     = "ztykzhurikaeonegai13";
    public static final String ZTYKZHURIKAEONEGAI14     = "ztykzhurikaeonegai14";
    public static final String ZTYKZHURIKAEONEGAI15     = "ztykzhurikaeonegai15";
    public static final String ZTYYOBIV210              = "ztyyobiv210";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";
    public static final String ZTYTUUTISAKUSEIYMDSEIREKI = "ztytuutisakuseiymdseireki";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYSYOUHNNM              = "ztysyouhnnm";
    public static final String ZTYKYKYMDSEIREKI         = "ztykykymdseireki";
    public static final String ZTYTKBRIPHURIKAEYOTEIGK  = "ztytkbriphurikaeyoteigk";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYHURIKAEKZHOSOKUMONGON = "ztyhurikaekzhosokumongon";
    public static final String ZTYHURIKAEKZ1            = "ztyhurikaekz1";
    public static final String ZTYHURIKAEKZ2            = "ztyhurikaekz2";
    public static final String ZTYHURIKAEKZ3            = "ztyhurikaekz3";
    public static final String ZTYHURIKAEKZ4            = "ztyhurikaekz4";
    public static final String ZTYHURIKAEKZ5            = "ztyhurikaekz5";
    public static final String ZTYYOBIV124              = "ztyyobiv124";
    public static final String ZTYANSYUYOUYOBIN10X7     = "ztyansyuyouyobin10x7";
    public static final String ZTYKZHURISTARTANFREEAREA1 = "ztykzhuristartanfreearea1";
    public static final String ZTYKZHURISTARTANFREEAREA2 = "ztykzhuristartanfreearea2";
    public static final String ZTYKZHURISTARTANFREEAREA3 = "ztykzhuristartanfreearea3";
    public static final String ZTYKZHURISTARTANFREEAREA4 = "ztykzhuristartanfreearea4";
    public static final String ZTYKZHURISTARTANFREEAREA5 = "ztykzhuristartanfreearea5";
    public static final String ZTYKZHURISTARTANFREEAREA6 = "ztykzhuristartanfreearea6";
    public static final String ZTYKZHURISTARTANFREEAREA7 = "ztykzhuristartanfreearea7";
    public static final String ZTYKZHURISTARTANFREEAREA8 = "ztykzhuristartanfreearea8";
    public static final String ZTYKZHURISTARTANFREEAREA9 = "ztykzhuristartanfreearea9";
    public static final String ZTYKZHURISTARTANFREEAREA10 = "ztykzhuristartanfreearea10";
    public static final String ZTYYOBIV140              = "ztyyobiv140";
    public static final String ZTYANSYUYOUYOBIN10X8     = "ztyansyuyouyobin10x8";

    private final PKZT_KouzahuriStartAnnaiTy primaryKey;

    public GenZT_KouzahuriStartAnnaiTy() {
        primaryKey = new PKZT_KouzahuriStartAnnaiTy();
    }

    public GenZT_KouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_KouzahuriStartAnnaiTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_KouzahuriStartAnnaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KouzahuriStartAnnaiTy> getMetaClass() {
        return QZT_KouzahuriStartAnnaiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyyobiv9;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv61;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV61)
    public String getZtyyobiv61() {
        return ztyyobiv61;
    }

    public void setZtyyobiv61(String pZtyyobiv61) {
        ztyyobiv61 = pZtyyobiv61;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztytuutinm;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTUUTINM)
    public String getZtytuutinm() {
        return ztytuutinm;
    }

    public void setZtytuutinm(String pZtytuutinm) {
        ztytuutinm = pZtytuutinm;
    }

    private String ztyaisatumongon1;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYAISATUMONGON1)
    public String getZtyaisatumongon1() {
        return ztyaisatumongon1;
    }

    public void setZtyaisatumongon1(String pZtyaisatumongon1) {
        ztyaisatumongon1 = pZtyaisatumongon1;
    }

    private String ztyaisatumongon2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYAISATUMONGON2)
    public String getZtyaisatumongon2() {
        return ztyaisatumongon2;
    }

    public void setZtyaisatumongon2(String pZtyaisatumongon2) {
        ztyaisatumongon2 = pZtyaisatumongon2;
    }

    private String ztyaisatumongon3;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYAISATUMONGON3)
    public String getZtyaisatumongon3() {
        return ztyaisatumongon3;
    }

    public void setZtyaisatumongon3(String pZtyaisatumongon3) {
        ztyaisatumongon3 = pZtyaisatumongon3;
    }

    private String ztyaisatumongon4;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYAISATUMONGON4)
    public String getZtyaisatumongon4() {
        return ztyaisatumongon4;
    }

    public void setZtyaisatumongon4(String pZtyaisatumongon4) {
        ztyaisatumongon4 = pZtyaisatumongon4;
    }

    private String ztyaisatumongon5;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYAISATUMONGON5)
    public String getZtyaisatumongon5() {
        return ztyaisatumongon5;
    }

    public void setZtyaisatumongon5(String pZtyaisatumongon5) {
        ztyaisatumongon5 = pZtyaisatumongon5;
    }

    private String ztyyobiv62;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV62)
    public String getZtyyobiv62() {
        return ztyyobiv62;
    }

    public void setZtyyobiv62(String pZtyyobiv62) {
        ztyyobiv62 = pZtyyobiv62;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztykzhurikaeonegai1;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI1)
    public String getZtykzhurikaeonegai1() {
        return ztykzhurikaeonegai1;
    }

    public void setZtykzhurikaeonegai1(String pZtykzhurikaeonegai1) {
        ztykzhurikaeonegai1 = pZtykzhurikaeonegai1;
    }

    private String ztykzhurikaeonegai2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI2)
    public String getZtykzhurikaeonegai2() {
        return ztykzhurikaeonegai2;
    }

    public void setZtykzhurikaeonegai2(String pZtykzhurikaeonegai2) {
        ztykzhurikaeonegai2 = pZtykzhurikaeonegai2;
    }

    private String ztykzhurikaeonegai3;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI3)
    public String getZtykzhurikaeonegai3() {
        return ztykzhurikaeonegai3;
    }

    public void setZtykzhurikaeonegai3(String pZtykzhurikaeonegai3) {
        ztykzhurikaeonegai3 = pZtykzhurikaeonegai3;
    }

    private String ztykzhurikaeonegai4;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI4)
    public String getZtykzhurikaeonegai4() {
        return ztykzhurikaeonegai4;
    }

    public void setZtykzhurikaeonegai4(String pZtykzhurikaeonegai4) {
        ztykzhurikaeonegai4 = pZtykzhurikaeonegai4;
    }

    private String ztykzhurikaeonegai5;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI5)
    public String getZtykzhurikaeonegai5() {
        return ztykzhurikaeonegai5;
    }

    public void setZtykzhurikaeonegai5(String pZtykzhurikaeonegai5) {
        ztykzhurikaeonegai5 = pZtykzhurikaeonegai5;
    }

    private String ztykzhurikaeonegai6;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI6)
    public String getZtykzhurikaeonegai6() {
        return ztykzhurikaeonegai6;
    }

    public void setZtykzhurikaeonegai6(String pZtykzhurikaeonegai6) {
        ztykzhurikaeonegai6 = pZtykzhurikaeonegai6;
    }

    private String ztykzhurikaeonegai7;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI7)
    public String getZtykzhurikaeonegai7() {
        return ztykzhurikaeonegai7;
    }

    public void setZtykzhurikaeonegai7(String pZtykzhurikaeonegai7) {
        ztykzhurikaeonegai7 = pZtykzhurikaeonegai7;
    }

    private String ztykzhurikaeonegai8;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI8)
    public String getZtykzhurikaeonegai8() {
        return ztykzhurikaeonegai8;
    }

    public void setZtykzhurikaeonegai8(String pZtykzhurikaeonegai8) {
        ztykzhurikaeonegai8 = pZtykzhurikaeonegai8;
    }

    private String ztykzhurikaeonegai9;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI9)
    public String getZtykzhurikaeonegai9() {
        return ztykzhurikaeonegai9;
    }

    public void setZtykzhurikaeonegai9(String pZtykzhurikaeonegai9) {
        ztykzhurikaeonegai9 = pZtykzhurikaeonegai9;
    }

    private String ztykzhurikaeonegai10;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI10)
    public String getZtykzhurikaeonegai10() {
        return ztykzhurikaeonegai10;
    }

    public void setZtykzhurikaeonegai10(String pZtykzhurikaeonegai10) {
        ztykzhurikaeonegai10 = pZtykzhurikaeonegai10;
    }

    private String ztykzhurikaeonegai11;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI11)
    public String getZtykzhurikaeonegai11() {
        return ztykzhurikaeonegai11;
    }

    public void setZtykzhurikaeonegai11(String pZtykzhurikaeonegai11) {
        ztykzhurikaeonegai11 = pZtykzhurikaeonegai11;
    }

    private String ztykzhurikaeonegai12;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI12)
    public String getZtykzhurikaeonegai12() {
        return ztykzhurikaeonegai12;
    }

    public void setZtykzhurikaeonegai12(String pZtykzhurikaeonegai12) {
        ztykzhurikaeonegai12 = pZtykzhurikaeonegai12;
    }

    private String ztykzhurikaeonegai13;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI13)
    public String getZtykzhurikaeonegai13() {
        return ztykzhurikaeonegai13;
    }

    public void setZtykzhurikaeonegai13(String pZtykzhurikaeonegai13) {
        ztykzhurikaeonegai13 = pZtykzhurikaeonegai13;
    }

    private String ztykzhurikaeonegai14;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI14)
    public String getZtykzhurikaeonegai14() {
        return ztykzhurikaeonegai14;
    }

    public void setZtykzhurikaeonegai14(String pZtykzhurikaeonegai14) {
        ztykzhurikaeonegai14 = pZtykzhurikaeonegai14;
    }

    private String ztykzhurikaeonegai15;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURIKAEONEGAI15)
    public String getZtykzhurikaeonegai15() {
        return ztykzhurikaeonegai15;
    }

    public void setZtykzhurikaeonegai15(String pZtykzhurikaeonegai15) {
        ztykzhurikaeonegai15 = pZtykzhurikaeonegai15;
    }

    private String ztyyobiv210;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV210)
    public String getZtyyobiv210() {
        return ztyyobiv210;
    }

    public void setZtyyobiv210(String pZtyyobiv210) {
        ztyyobiv210 = pZtyyobiv210;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }

    private String ztytuutisakuseiymdseireki;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTUUTISAKUSEIYMDSEIREKI)
    public String getZtytuutisakuseiymdseireki() {
        return ztytuutisakuseiymdseireki;
    }

    public void setZtytuutisakuseiymdseireki(String pZtytuutisakuseiymdseireki) {
        ztytuutisakuseiymdseireki = pZtytuutisakuseiymdseireki;
    }

    private String ztysyono2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztysyouhnnm;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYSYOUHNNM)
    public String getZtysyouhnnm() {
        return ztysyouhnnm;
    }

    public void setZtysyouhnnm(String pZtysyouhnnm) {
        ztysyouhnnm = pZtysyouhnnm;
    }

    private String ztykykymdseireki;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKYKYMDSEIREKI)
    public String getZtykykymdseireki() {
        return ztykykymdseireki;
    }

    public void setZtykykymdseireki(String pZtykykymdseireki) {
        ztykykymdseireki = pZtykykymdseireki;
    }

    private String ztytkbriphurikaeyoteigk;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYTKBRIPHURIKAEYOTEIGK)
    public String getZtytkbriphurikaeyoteigk() {
        return ztytkbriphurikaeyoteigk;
    }

    public void setZtytkbriphurikaeyoteigk(String pZtytkbriphurikaeyoteigk) {
        ztytkbriphurikaeyoteigk = pZtytkbriphurikaeyoteigk;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyhurikaekzhosokumongon;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHURIKAEKZHOSOKUMONGON)
    public String getZtyhurikaekzhosokumongon() {
        return ztyhurikaekzhosokumongon;
    }

    public void setZtyhurikaekzhosokumongon(String pZtyhurikaekzhosokumongon) {
        ztyhurikaekzhosokumongon = pZtyhurikaekzhosokumongon;
    }

    private String ztyhurikaekz1;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHURIKAEKZ1)
    public String getZtyhurikaekz1() {
        return ztyhurikaekz1;
    }

    public void setZtyhurikaekz1(String pZtyhurikaekz1) {
        ztyhurikaekz1 = pZtyhurikaekz1;
    }

    private String ztyhurikaekz2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHURIKAEKZ2)
    public String getZtyhurikaekz2() {
        return ztyhurikaekz2;
    }

    public void setZtyhurikaekz2(String pZtyhurikaekz2) {
        ztyhurikaekz2 = pZtyhurikaekz2;
    }

    private String ztyhurikaekz3;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHURIKAEKZ3)
    public String getZtyhurikaekz3() {
        return ztyhurikaekz3;
    }

    public void setZtyhurikaekz3(String pZtyhurikaekz3) {
        ztyhurikaekz3 = pZtyhurikaekz3;
    }

    private String ztyhurikaekz4;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHURIKAEKZ4)
    public String getZtyhurikaekz4() {
        return ztyhurikaekz4;
    }

    public void setZtyhurikaekz4(String pZtyhurikaekz4) {
        ztyhurikaekz4 = pZtyhurikaekz4;
    }

    private String ztyhurikaekz5;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYHURIKAEKZ5)
    public String getZtyhurikaekz5() {
        return ztyhurikaekz5;
    }

    public void setZtyhurikaekz5(String pZtyhurikaekz5) {
        ztyhurikaekz5 = pZtyhurikaekz5;
    }

    private String ztyyobiv124;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV124)
    public String getZtyyobiv124() {
        return ztyyobiv124;
    }

    public void setZtyyobiv124(String pZtyyobiv124) {
        ztyyobiv124 = pZtyyobiv124;
    }

    private String ztyansyuyouyobin10x7;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10X7)
    public String getZtyansyuyouyobin10x7() {
        return ztyansyuyouyobin10x7;
    }

    public void setZtyansyuyouyobin10x7(String pZtyansyuyouyobin10x7) {
        ztyansyuyouyobin10x7 = pZtyansyuyouyobin10x7;
    }

    private String ztykzhuristartanfreearea1;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA1)
    public String getZtykzhuristartanfreearea1() {
        return ztykzhuristartanfreearea1;
    }

    public void setZtykzhuristartanfreearea1(String pZtykzhuristartanfreearea1) {
        ztykzhuristartanfreearea1 = pZtykzhuristartanfreearea1;
    }

    private String ztykzhuristartanfreearea2;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA2)
    public String getZtykzhuristartanfreearea2() {
        return ztykzhuristartanfreearea2;
    }

    public void setZtykzhuristartanfreearea2(String pZtykzhuristartanfreearea2) {
        ztykzhuristartanfreearea2 = pZtykzhuristartanfreearea2;
    }

    private String ztykzhuristartanfreearea3;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA3)
    public String getZtykzhuristartanfreearea3() {
        return ztykzhuristartanfreearea3;
    }

    public void setZtykzhuristartanfreearea3(String pZtykzhuristartanfreearea3) {
        ztykzhuristartanfreearea3 = pZtykzhuristartanfreearea3;
    }

    private String ztykzhuristartanfreearea4;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA4)
    public String getZtykzhuristartanfreearea4() {
        return ztykzhuristartanfreearea4;
    }

    public void setZtykzhuristartanfreearea4(String pZtykzhuristartanfreearea4) {
        ztykzhuristartanfreearea4 = pZtykzhuristartanfreearea4;
    }

    private String ztykzhuristartanfreearea5;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA5)
    public String getZtykzhuristartanfreearea5() {
        return ztykzhuristartanfreearea5;
    }

    public void setZtykzhuristartanfreearea5(String pZtykzhuristartanfreearea5) {
        ztykzhuristartanfreearea5 = pZtykzhuristartanfreearea5;
    }

    private String ztykzhuristartanfreearea6;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA6)
    public String getZtykzhuristartanfreearea6() {
        return ztykzhuristartanfreearea6;
    }

    public void setZtykzhuristartanfreearea6(String pZtykzhuristartanfreearea6) {
        ztykzhuristartanfreearea6 = pZtykzhuristartanfreearea6;
    }

    private String ztykzhuristartanfreearea7;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA7)
    public String getZtykzhuristartanfreearea7() {
        return ztykzhuristartanfreearea7;
    }

    public void setZtykzhuristartanfreearea7(String pZtykzhuristartanfreearea7) {
        ztykzhuristartanfreearea7 = pZtykzhuristartanfreearea7;
    }

    private String ztykzhuristartanfreearea8;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA8)
    public String getZtykzhuristartanfreearea8() {
        return ztykzhuristartanfreearea8;
    }

    public void setZtykzhuristartanfreearea8(String pZtykzhuristartanfreearea8) {
        ztykzhuristartanfreearea8 = pZtykzhuristartanfreearea8;
    }

    private String ztykzhuristartanfreearea9;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA9)
    public String getZtykzhuristartanfreearea9() {
        return ztykzhuristartanfreearea9;
    }

    public void setZtykzhuristartanfreearea9(String pZtykzhuristartanfreearea9) {
        ztykzhuristartanfreearea9 = pZtykzhuristartanfreearea9;
    }

    private String ztykzhuristartanfreearea10;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYKZHURISTARTANFREEAREA10)
    public String getZtykzhuristartanfreearea10() {
        return ztykzhuristartanfreearea10;
    }

    public void setZtykzhuristartanfreearea10(String pZtykzhuristartanfreearea10) {
        ztykzhuristartanfreearea10 = pZtykzhuristartanfreearea10;
    }

    private String ztyyobiv140;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYYOBIV140)
    public String getZtyyobiv140() {
        return ztyyobiv140;
    }

    public void setZtyyobiv140(String pZtyyobiv140) {
        ztyyobiv140 = pZtyyobiv140;
    }

    private String ztyansyuyouyobin10x8;

    @Column(name=GenZT_KouzahuriStartAnnaiTy.ZTYANSYUYOUYOBIN10X8)
    public String getZtyansyuyouyobin10x8() {
        return ztyansyuyouyobin10x8;
    }

    public void setZtyansyuyouyobin10x8(String pZtyansyuyouyobin10x8) {
        ztyansyuyouyobin10x8 = pZtyansyuyouyobin10x8;
    }
}