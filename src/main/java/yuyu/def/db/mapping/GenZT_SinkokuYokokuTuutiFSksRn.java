package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.id.PKZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.meta.GenQZT_SinkokuYokokuTuutiFSksRn;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksRn;

/**
 * 申告予告通知Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SinkokuYokokuTuutiFSksRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinkokuYokokuTuutiFSksRn}</td><td colspan="3">申告予告通知Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SinkokuYokokuTuutiFSksRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SinkokuYokokuTuutiFSksRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkokunenkj zrnsinkokunenkj}</td><td>（連携用）申告年（漢字）</td><td align="center">{@link PKZT_SinkokuYokokuTuutiFSksRn ○}</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi1 zrnmidasi1}</td><td>（連携用）見出し１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi2 zrnmidasi2}</td><td>（連携用）見出し２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi3 zrnmidasi3}</td><td>（連携用）見出し３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi4 zrnmidasi4}</td><td>（連携用）見出し４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi5 zrnmidasi5}</td><td>（連携用）見出し５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi6 zrnmidasi6}</td><td>（連携用）見出し６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi7 zrnmidasi7}</td><td>（連携用）見出し７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon1 zrnkihonjouhoumongon1}</td><td>（連携用）基本情報文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon2 zrnkihonjouhoumongon2}</td><td>（連携用）基本情報文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon3 zrnkihonjouhoumongon3}</td><td>（連携用）基本情報文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon4 zrnkihonjouhoumongon4}</td><td>（連携用）基本情報文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon5 zrnkihonjouhoumongon5}</td><td>（連携用）基本情報文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon6 zrnkihonjouhoumongon6}</td><td>（連携用）基本情報文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonjouhoumongon7 zrnkihonjouhoumongon7}</td><td>（連携用）基本情報文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv78 zrnyobiv78}</td><td>（連携用）予備項目Ｖ７８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnippanseimeipyoteigk zrnippanseimeipyoteigk}</td><td>（連携用）一般生命保険料予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnippanhaitoukinyoteigk zrnippanhaitoukinyoteigk}</td><td>（連携用）一般配当金予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnippansinkokuyoteigk zrnippansinkokuyoteigk}</td><td>（連携用）一般申告予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoiryoupyoteigk zrnkaigoiryoupyoteigk}</td><td>（連携用）介護医療保険料予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoiryoudyoteigk zrnkaigoiryoudyoteigk}</td><td>（連携用）介護医療配当金予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoiryousinkokuyoteigk zrnkaigoiryousinkokuyoteigk}</td><td>（連携用）介護医療申告予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinpyoteigk zrnnenkinpyoteigk}</td><td>（連携用）年金保険料予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkindyoteigk zrnnenkindyoteigk}</td><td>（連携用）年金配当金予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsinkokuyoteigk zrnnenkinsinkokuyoteigk}</td><td>（連携用）年金申告予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnewhknjytukikan zrnnewhknjytukikan}</td><td>（連携用）新制度保険充当期間</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdkj zrnkykymdkj}</td><td>（連携用）契約年月日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuunm zrnhrkkaisuunm}</td><td>（連携用）払込回数（数）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymdkj zrnsakuseiymdkj}</td><td>（連携用）作成年月日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv34 zrnyobiv34}</td><td>（連携用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinkokuYokokuTuutiFSksRn
 * @see     PKZT_SinkokuYokokuTuutiFSksRn
 * @see     QZT_SinkokuYokokuTuutiFSksRn
 * @see     GenQZT_SinkokuYokokuTuutiFSksRn
 */
@MappedSuperclass
@Table(name=GenZT_SinkokuYokokuTuutiFSksRn.TABLE_NAME)
@IdClass(value=PKZT_SinkokuYokokuTuutiFSksRn.class)
public abstract class GenZT_SinkokuYokokuTuutiFSksRn extends AbstractExDBEntityForZDB<ZT_SinkokuYokokuTuutiFSksRn, PKZT_SinkokuYokokuTuutiFSksRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinkokuYokokuTuutiFSksRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
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
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNSINKOKUNENKJ          = "zrnsinkokunenkj";
    public static final String ZRNMIDASI1               = "zrnmidasi1";
    public static final String ZRNMIDASI2               = "zrnmidasi2";
    public static final String ZRNMIDASI3               = "zrnmidasi3";
    public static final String ZRNMIDASI4               = "zrnmidasi4";
    public static final String ZRNMIDASI5               = "zrnmidasi5";
    public static final String ZRNMIDASI6               = "zrnmidasi6";
    public static final String ZRNMIDASI7               = "zrnmidasi7";
    public static final String ZRNKIHONJOUHOUMONGON1    = "zrnkihonjouhoumongon1";
    public static final String ZRNKIHONJOUHOUMONGON2    = "zrnkihonjouhoumongon2";
    public static final String ZRNKIHONJOUHOUMONGON3    = "zrnkihonjouhoumongon3";
    public static final String ZRNKIHONJOUHOUMONGON4    = "zrnkihonjouhoumongon4";
    public static final String ZRNKIHONJOUHOUMONGON5    = "zrnkihonjouhoumongon5";
    public static final String ZRNKIHONJOUHOUMONGON6    = "zrnkihonjouhoumongon6";
    public static final String ZRNKIHONJOUHOUMONGON7    = "zrnkihonjouhoumongon7";
    public static final String ZRNYOBIV78               = "zrnyobiv78";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNIPPANSEIMEIPYOTEIGK   = "zrnippanseimeipyoteigk";
    public static final String ZRNIPPANHAITOUKINYOTEIGK = "zrnippanhaitoukinyoteigk";
    public static final String ZRNIPPANSINKOKUYOTEIGK   = "zrnippansinkokuyoteigk";
    public static final String ZRNKAIGOIRYOUPYOTEIGK    = "zrnkaigoiryoupyoteigk";
    public static final String ZRNKAIGOIRYOUDYOTEIGK    = "zrnkaigoiryoudyoteigk";
    public static final String ZRNKAIGOIRYOUSINKOKUYOTEIGK = "zrnkaigoiryousinkokuyoteigk";
    public static final String ZRNNENKINPYOTEIGK        = "zrnnenkinpyoteigk";
    public static final String ZRNNENKINDYOTEIGK        = "zrnnenkindyoteigk";
    public static final String ZRNNENKINSINKOKUYOTEIGK  = "zrnnenkinsinkokuyoteigk";
    public static final String ZRNNEWHKNJYTUKIKAN       = "zrnnewhknjytukikan";
    public static final String ZRNKYKYMDKJ              = "zrnkykymdkj";
    public static final String ZRNHRKKAISUUNM           = "zrnhrkkaisuunm";
    public static final String ZRNSAKUSEIYMDKJ          = "zrnsakuseiymdkj";
    public static final String ZRNYOBIV34               = "zrnyobiv34";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";

    private final PKZT_SinkokuYokokuTuutiFSksRn primaryKey;

    public GenZT_SinkokuYokokuTuutiFSksRn() {
        primaryKey = new PKZT_SinkokuYokokuTuutiFSksRn();
    }

    public GenZT_SinkokuYokokuTuutiFSksRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsinkokunenkj
    ) {
        primaryKey = new PKZT_SinkokuYokokuTuutiFSksRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsinkokunenkj
        );
    }

    @Transient
    @Override
    public PKZT_SinkokuYokokuTuutiFSksRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinkokuYokokuTuutiFSksRn> getMetaClass() {
        return QZT_SinkokuYokokuTuutiFSksRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnyobiv5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm15keta;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSAKUNM15KETA)
    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    private String zrnyobiv62;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNYOBIV62)
    public String getZrnyobiv62() {
        return zrnyobiv62;
    }

    public void setZrnyobiv62(String pZrnyobiv62) {
        zrnyobiv62 = pZrnyobiv62;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    @Id
    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSINKOKUNENKJ)
    public String getZrnsinkokunenkj() {
        return getPrimaryKey().getZrnsinkokunenkj();
    }

    @DataConvert("toMultiByte")
    public void setZrnsinkokunenkj(String pZrnsinkokunenkj) {
        getPrimaryKey().setZrnsinkokunenkj(pZrnsinkokunenkj);
    }

    private String zrnmidasi1;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI1)
    public String getZrnmidasi1() {
        return zrnmidasi1;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi1(String pZrnmidasi1) {
        zrnmidasi1 = pZrnmidasi1;
    }

    private String zrnmidasi2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI2)
    public String getZrnmidasi2() {
        return zrnmidasi2;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi2(String pZrnmidasi2) {
        zrnmidasi2 = pZrnmidasi2;
    }

    private String zrnmidasi3;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI3)
    public String getZrnmidasi3() {
        return zrnmidasi3;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi3(String pZrnmidasi3) {
        zrnmidasi3 = pZrnmidasi3;
    }

    private String zrnmidasi4;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI4)
    public String getZrnmidasi4() {
        return zrnmidasi4;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi4(String pZrnmidasi4) {
        zrnmidasi4 = pZrnmidasi4;
    }

    private String zrnmidasi5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI5)
    public String getZrnmidasi5() {
        return zrnmidasi5;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi5(String pZrnmidasi5) {
        zrnmidasi5 = pZrnmidasi5;
    }

    private String zrnmidasi6;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI6)
    public String getZrnmidasi6() {
        return zrnmidasi6;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi6(String pZrnmidasi6) {
        zrnmidasi6 = pZrnmidasi6;
    }

    private String zrnmidasi7;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNMIDASI7)
    public String getZrnmidasi7() {
        return zrnmidasi7;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi7(String pZrnmidasi7) {
        zrnmidasi7 = pZrnmidasi7;
    }

    private String zrnkihonjouhoumongon1;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON1)
    public String getZrnkihonjouhoumongon1() {
        return zrnkihonjouhoumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon1(String pZrnkihonjouhoumongon1) {
        zrnkihonjouhoumongon1 = pZrnkihonjouhoumongon1;
    }

    private String zrnkihonjouhoumongon2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON2)
    public String getZrnkihonjouhoumongon2() {
        return zrnkihonjouhoumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon2(String pZrnkihonjouhoumongon2) {
        zrnkihonjouhoumongon2 = pZrnkihonjouhoumongon2;
    }

    private String zrnkihonjouhoumongon3;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON3)
    public String getZrnkihonjouhoumongon3() {
        return zrnkihonjouhoumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon3(String pZrnkihonjouhoumongon3) {
        zrnkihonjouhoumongon3 = pZrnkihonjouhoumongon3;
    }

    private String zrnkihonjouhoumongon4;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON4)
    public String getZrnkihonjouhoumongon4() {
        return zrnkihonjouhoumongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon4(String pZrnkihonjouhoumongon4) {
        zrnkihonjouhoumongon4 = pZrnkihonjouhoumongon4;
    }

    private String zrnkihonjouhoumongon5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON5)
    public String getZrnkihonjouhoumongon5() {
        return zrnkihonjouhoumongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon5(String pZrnkihonjouhoumongon5) {
        zrnkihonjouhoumongon5 = pZrnkihonjouhoumongon5;
    }

    private String zrnkihonjouhoumongon6;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON6)
    public String getZrnkihonjouhoumongon6() {
        return zrnkihonjouhoumongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon6(String pZrnkihonjouhoumongon6) {
        zrnkihonjouhoumongon6 = pZrnkihonjouhoumongon6;
    }

    private String zrnkihonjouhoumongon7;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKIHONJOUHOUMONGON7)
    public String getZrnkihonjouhoumongon7() {
        return zrnkihonjouhoumongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkihonjouhoumongon7(String pZrnkihonjouhoumongon7) {
        zrnkihonjouhoumongon7 = pZrnkihonjouhoumongon7;
    }

    private String zrnyobiv78;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNYOBIV78)
    public String getZrnyobiv78() {
        return zrnyobiv78;
    }

    public void setZrnyobiv78(String pZrnyobiv78) {
        zrnyobiv78 = pZrnyobiv78;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnippanseimeipyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNIPPANSEIMEIPYOTEIGK)
    public String getZrnippanseimeipyoteigk() {
        return zrnippanseimeipyoteigk;
    }

    public void setZrnippanseimeipyoteigk(String pZrnippanseimeipyoteigk) {
        zrnippanseimeipyoteigk = pZrnippanseimeipyoteigk;
    }

    private String zrnippanhaitoukinyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNIPPANHAITOUKINYOTEIGK)
    public String getZrnippanhaitoukinyoteigk() {
        return zrnippanhaitoukinyoteigk;
    }

    public void setZrnippanhaitoukinyoteigk(String pZrnippanhaitoukinyoteigk) {
        zrnippanhaitoukinyoteigk = pZrnippanhaitoukinyoteigk;
    }

    private String zrnippansinkokuyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNIPPANSINKOKUYOTEIGK)
    public String getZrnippansinkokuyoteigk() {
        return zrnippansinkokuyoteigk;
    }

    public void setZrnippansinkokuyoteigk(String pZrnippansinkokuyoteigk) {
        zrnippansinkokuyoteigk = pZrnippansinkokuyoteigk;
    }

    private String zrnkaigoiryoupyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKAIGOIRYOUPYOTEIGK)
    public String getZrnkaigoiryoupyoteigk() {
        return zrnkaigoiryoupyoteigk;
    }

    public void setZrnkaigoiryoupyoteigk(String pZrnkaigoiryoupyoteigk) {
        zrnkaigoiryoupyoteigk = pZrnkaigoiryoupyoteigk;
    }

    private String zrnkaigoiryoudyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKAIGOIRYOUDYOTEIGK)
    public String getZrnkaigoiryoudyoteigk() {
        return zrnkaigoiryoudyoteigk;
    }

    public void setZrnkaigoiryoudyoteigk(String pZrnkaigoiryoudyoteigk) {
        zrnkaigoiryoudyoteigk = pZrnkaigoiryoudyoteigk;
    }

    private String zrnkaigoiryousinkokuyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKAIGOIRYOUSINKOKUYOTEIGK)
    public String getZrnkaigoiryousinkokuyoteigk() {
        return zrnkaigoiryousinkokuyoteigk;
    }

    public void setZrnkaigoiryousinkokuyoteigk(String pZrnkaigoiryousinkokuyoteigk) {
        zrnkaigoiryousinkokuyoteigk = pZrnkaigoiryousinkokuyoteigk;
    }

    private String zrnnenkinpyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNNENKINPYOTEIGK)
    public String getZrnnenkinpyoteigk() {
        return zrnnenkinpyoteigk;
    }

    public void setZrnnenkinpyoteigk(String pZrnnenkinpyoteigk) {
        zrnnenkinpyoteigk = pZrnnenkinpyoteigk;
    }

    private String zrnnenkindyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNNENKINDYOTEIGK)
    public String getZrnnenkindyoteigk() {
        return zrnnenkindyoteigk;
    }

    public void setZrnnenkindyoteigk(String pZrnnenkindyoteigk) {
        zrnnenkindyoteigk = pZrnnenkindyoteigk;
    }

    private String zrnnenkinsinkokuyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNNENKINSINKOKUYOTEIGK)
    public String getZrnnenkinsinkokuyoteigk() {
        return zrnnenkinsinkokuyoteigk;
    }

    public void setZrnnenkinsinkokuyoteigk(String pZrnnenkinsinkokuyoteigk) {
        zrnnenkinsinkokuyoteigk = pZrnnenkinsinkokuyoteigk;
    }

    private String zrnnewhknjytukikan;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNNEWHKNJYTUKIKAN)
    public String getZrnnewhknjytukikan() {
        return zrnnewhknjytukikan;
    }

    @DataConvert("toMultiByte")
    public void setZrnnewhknjytukikan(String pZrnnewhknjytukikan) {
        zrnnewhknjytukikan = pZrnnewhknjytukikan;
    }

    private String zrnkykymdkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNKYKYMDKJ)
    public String getZrnkykymdkj() {
        return zrnkykymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdkj(String pZrnkykymdkj) {
        zrnkykymdkj = pZrnkykymdkj;
    }

    private String zrnhrkkaisuunm;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNHRKKAISUUNM)
    public String getZrnhrkkaisuunm() {
        return zrnhrkkaisuunm;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnhrkkaisuunm(String pZrnhrkkaisuunm) {
        zrnhrkkaisuunm = pZrnhrkkaisuunm;
    }

    private String zrnsakuseiymdkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNSAKUSEIYMDKJ)
    public String getZrnsakuseiymdkj() {
        return zrnsakuseiymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnsakuseiymdkj(String pZrnsakuseiymdkj) {
        zrnsakuseiymdkj = pZrnsakuseiymdkj;
    }

    private String zrnyobiv34;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNYOBIV34)
    public String getZrnyobiv34() {
        return zrnyobiv34;
    }

    public void setZrnyobiv34(String pZrnyobiv34) {
        zrnyobiv34 = pZrnyobiv34;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }
}