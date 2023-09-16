package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.id.PKZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.meta.GenQZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksTy;

/**
 * 申告予告通知Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SinkokuYokokuTuutiFSksTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SinkokuYokokuTuutiFSksTy}</td><td colspan="3">申告予告通知Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SinkokuYokokuTuutiFSksTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SinkokuYokokuTuutiFSksTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtyyobiv62 ztyyobiv62}</td><td>（中継用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkokunenkj ztysinkokunenkj}</td><td>（中継用）申告年（漢字）</td><td align="center">{@link PKZT_SinkokuYokokuTuutiFSksTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi1 ztymidasi1}</td><td>（中継用）見出し１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi2 ztymidasi2}</td><td>（中継用）見出し２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi3 ztymidasi3}</td><td>（中継用）見出し３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi4 ztymidasi4}</td><td>（中継用）見出し４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi5 ztymidasi5}</td><td>（中継用）見出し５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi6 ztymidasi6}</td><td>（中継用）見出し６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi7 ztymidasi7}</td><td>（中継用）見出し７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon1 ztykihonjouhoumongon1}</td><td>（中継用）基本情報文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon2 ztykihonjouhoumongon2}</td><td>（中継用）基本情報文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon3 ztykihonjouhoumongon3}</td><td>（中継用）基本情報文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon4 ztykihonjouhoumongon4}</td><td>（中継用）基本情報文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon5 ztykihonjouhoumongon5}</td><td>（中継用）基本情報文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon6 ztykihonjouhoumongon6}</td><td>（中継用）基本情報文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonjouhoumongon7 ztykihonjouhoumongon7}</td><td>（中継用）基本情報文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv78 ztyyobiv78}</td><td>（中継用）予備項目Ｖ７８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyippanseimeipyoteigk ztyippanseimeipyoteigk}</td><td>（中継用）一般生命保険料予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyippanhaitoukinyoteigk ztyippanhaitoukinyoteigk}</td><td>（中継用）一般配当金予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyippansinkokuyoteigk ztyippansinkokuyoteigk}</td><td>（中継用）一般申告予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoiryoupyoteigk ztykaigoiryoupyoteigk}</td><td>（中継用）介護医療保険料予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoiryoudyoteigk ztykaigoiryoudyoteigk}</td><td>（中継用）介護医療配当金予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoiryousinkokuyoteigk ztykaigoiryousinkokuyoteigk}</td><td>（中継用）介護医療申告予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinpyoteigk ztynenkinpyoteigk}</td><td>（中継用）年金保険料予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkindyoteigk ztynenkindyoteigk}</td><td>（中継用）年金配当金予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinsinkokuyoteigk ztynenkinsinkokuyoteigk}</td><td>（中継用）年金申告予定額（新制度）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynewhknjytukikan ztynewhknjytukikan}</td><td>（中継用）新制度保険充当期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdkj ztykykymdkj}</td><td>（中継用）契約年月日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuunm ztyhrkkaisuunm}</td><td>（中継用）払込回数（数）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiymdkj ztysakuseiymdkj}</td><td>（中継用）作成年月日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv34 ztyyobiv34}</td><td>（中継用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SinkokuYokokuTuutiFSksTy
 * @see     PKZT_SinkokuYokokuTuutiFSksTy
 * @see     QZT_SinkokuYokokuTuutiFSksTy
 * @see     GenQZT_SinkokuYokokuTuutiFSksTy
 */
@MappedSuperclass
@Table(name=GenZT_SinkokuYokokuTuutiFSksTy.TABLE_NAME)
@IdClass(value=PKZT_SinkokuYokokuTuutiFSksTy.class)
public abstract class GenZT_SinkokuYokokuTuutiFSksTy extends AbstractExDBEntity<ZT_SinkokuYokokuTuutiFSksTy, PKZT_SinkokuYokokuTuutiFSksTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SinkokuYokokuTuutiFSksTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
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
    public static final String ZTYYOBIV62               = "ztyyobiv62";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYSINKOKUNENKJ          = "ztysinkokunenkj";
    public static final String ZTYMIDASI1               = "ztymidasi1";
    public static final String ZTYMIDASI2               = "ztymidasi2";
    public static final String ZTYMIDASI3               = "ztymidasi3";
    public static final String ZTYMIDASI4               = "ztymidasi4";
    public static final String ZTYMIDASI5               = "ztymidasi5";
    public static final String ZTYMIDASI6               = "ztymidasi6";
    public static final String ZTYMIDASI7               = "ztymidasi7";
    public static final String ZTYKIHONJOUHOUMONGON1    = "ztykihonjouhoumongon1";
    public static final String ZTYKIHONJOUHOUMONGON2    = "ztykihonjouhoumongon2";
    public static final String ZTYKIHONJOUHOUMONGON3    = "ztykihonjouhoumongon3";
    public static final String ZTYKIHONJOUHOUMONGON4    = "ztykihonjouhoumongon4";
    public static final String ZTYKIHONJOUHOUMONGON5    = "ztykihonjouhoumongon5";
    public static final String ZTYKIHONJOUHOUMONGON6    = "ztykihonjouhoumongon6";
    public static final String ZTYKIHONJOUHOUMONGON7    = "ztykihonjouhoumongon7";
    public static final String ZTYYOBIV78               = "ztyyobiv78";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYIPPANSEIMEIPYOTEIGK   = "ztyippanseimeipyoteigk";
    public static final String ZTYIPPANHAITOUKINYOTEIGK = "ztyippanhaitoukinyoteigk";
    public static final String ZTYIPPANSINKOKUYOTEIGK   = "ztyippansinkokuyoteigk";
    public static final String ZTYKAIGOIRYOUPYOTEIGK    = "ztykaigoiryoupyoteigk";
    public static final String ZTYKAIGOIRYOUDYOTEIGK    = "ztykaigoiryoudyoteigk";
    public static final String ZTYKAIGOIRYOUSINKOKUYOTEIGK = "ztykaigoiryousinkokuyoteigk";
    public static final String ZTYNENKINPYOTEIGK        = "ztynenkinpyoteigk";
    public static final String ZTYNENKINDYOTEIGK        = "ztynenkindyoteigk";
    public static final String ZTYNENKINSINKOKUYOTEIGK  = "ztynenkinsinkokuyoteigk";
    public static final String ZTYNEWHKNJYTUKIKAN       = "ztynewhknjytukikan";
    public static final String ZTYKYKYMDKJ              = "ztykykymdkj";
    public static final String ZTYHRKKAISUUNM           = "ztyhrkkaisuunm";
    public static final String ZTYSAKUSEIYMDKJ          = "ztysakuseiymdkj";
    public static final String ZTYYOBIV34               = "ztyyobiv34";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";

    private final PKZT_SinkokuYokokuTuutiFSksTy primaryKey;

    public GenZT_SinkokuYokokuTuutiFSksTy() {
        primaryKey = new PKZT_SinkokuYokokuTuutiFSksTy();
    }

    public GenZT_SinkokuYokokuTuutiFSksTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysinkokunenkj
    ) {
        primaryKey = new PKZT_SinkokuYokokuTuutiFSksTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysinkokunenkj
        );
    }

    @Transient
    @Override
    public PKZT_SinkokuYokokuTuutiFSksTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SinkokuYokokuTuutiFSksTy> getMetaClass() {
        return QZT_SinkokuYokokuTuutiFSksTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyyobiv5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm15keta;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSAKUNM15KETA)
    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

    private String ztyyobiv62;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYYOBIV62)
    public String getZtyyobiv62() {
        return ztyyobiv62;
    }

    public void setZtyyobiv62(String pZtyyobiv62) {
        ztyyobiv62 = pZtyyobiv62;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    @Id
    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSINKOKUNENKJ)
    public String getZtysinkokunenkj() {
        return getPrimaryKey().getZtysinkokunenkj();
    }

    public void setZtysinkokunenkj(String pZtysinkokunenkj) {
        getPrimaryKey().setZtysinkokunenkj(pZtysinkokunenkj);
    }

    private String ztymidasi1;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI1)
    public String getZtymidasi1() {
        return ztymidasi1;
    }

    public void setZtymidasi1(String pZtymidasi1) {
        ztymidasi1 = pZtymidasi1;
    }

    private String ztymidasi2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI2)
    public String getZtymidasi2() {
        return ztymidasi2;
    }

    public void setZtymidasi2(String pZtymidasi2) {
        ztymidasi2 = pZtymidasi2;
    }

    private String ztymidasi3;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI3)
    public String getZtymidasi3() {
        return ztymidasi3;
    }

    public void setZtymidasi3(String pZtymidasi3) {
        ztymidasi3 = pZtymidasi3;
    }

    private String ztymidasi4;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI4)
    public String getZtymidasi4() {
        return ztymidasi4;
    }

    public void setZtymidasi4(String pZtymidasi4) {
        ztymidasi4 = pZtymidasi4;
    }

    private String ztymidasi5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI5)
    public String getZtymidasi5() {
        return ztymidasi5;
    }

    public void setZtymidasi5(String pZtymidasi5) {
        ztymidasi5 = pZtymidasi5;
    }

    private String ztymidasi6;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI6)
    public String getZtymidasi6() {
        return ztymidasi6;
    }

    public void setZtymidasi6(String pZtymidasi6) {
        ztymidasi6 = pZtymidasi6;
    }

    private String ztymidasi7;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYMIDASI7)
    public String getZtymidasi7() {
        return ztymidasi7;
    }

    public void setZtymidasi7(String pZtymidasi7) {
        ztymidasi7 = pZtymidasi7;
    }

    private String ztykihonjouhoumongon1;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON1)
    public String getZtykihonjouhoumongon1() {
        return ztykihonjouhoumongon1;
    }

    public void setZtykihonjouhoumongon1(String pZtykihonjouhoumongon1) {
        ztykihonjouhoumongon1 = pZtykihonjouhoumongon1;
    }

    private String ztykihonjouhoumongon2;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON2)
    public String getZtykihonjouhoumongon2() {
        return ztykihonjouhoumongon2;
    }

    public void setZtykihonjouhoumongon2(String pZtykihonjouhoumongon2) {
        ztykihonjouhoumongon2 = pZtykihonjouhoumongon2;
    }

    private String ztykihonjouhoumongon3;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON3)
    public String getZtykihonjouhoumongon3() {
        return ztykihonjouhoumongon3;
    }

    public void setZtykihonjouhoumongon3(String pZtykihonjouhoumongon3) {
        ztykihonjouhoumongon3 = pZtykihonjouhoumongon3;
    }

    private String ztykihonjouhoumongon4;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON4)
    public String getZtykihonjouhoumongon4() {
        return ztykihonjouhoumongon4;
    }

    public void setZtykihonjouhoumongon4(String pZtykihonjouhoumongon4) {
        ztykihonjouhoumongon4 = pZtykihonjouhoumongon4;
    }

    private String ztykihonjouhoumongon5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON5)
    public String getZtykihonjouhoumongon5() {
        return ztykihonjouhoumongon5;
    }

    public void setZtykihonjouhoumongon5(String pZtykihonjouhoumongon5) {
        ztykihonjouhoumongon5 = pZtykihonjouhoumongon5;
    }

    private String ztykihonjouhoumongon6;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON6)
    public String getZtykihonjouhoumongon6() {
        return ztykihonjouhoumongon6;
    }

    public void setZtykihonjouhoumongon6(String pZtykihonjouhoumongon6) {
        ztykihonjouhoumongon6 = pZtykihonjouhoumongon6;
    }

    private String ztykihonjouhoumongon7;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKIHONJOUHOUMONGON7)
    public String getZtykihonjouhoumongon7() {
        return ztykihonjouhoumongon7;
    }

    public void setZtykihonjouhoumongon7(String pZtykihonjouhoumongon7) {
        ztykihonjouhoumongon7 = pZtykihonjouhoumongon7;
    }

    private String ztyyobiv78;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYYOBIV78)
    public String getZtyyobiv78() {
        return ztyyobiv78;
    }

    public void setZtyyobiv78(String pZtyyobiv78) {
        ztyyobiv78 = pZtyyobiv78;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztyippanseimeipyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYIPPANSEIMEIPYOTEIGK)
    public String getZtyippanseimeipyoteigk() {
        return ztyippanseimeipyoteigk;
    }

    public void setZtyippanseimeipyoteigk(String pZtyippanseimeipyoteigk) {
        ztyippanseimeipyoteigk = pZtyippanseimeipyoteigk;
    }

    private String ztyippanhaitoukinyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYIPPANHAITOUKINYOTEIGK)
    public String getZtyippanhaitoukinyoteigk() {
        return ztyippanhaitoukinyoteigk;
    }

    public void setZtyippanhaitoukinyoteigk(String pZtyippanhaitoukinyoteigk) {
        ztyippanhaitoukinyoteigk = pZtyippanhaitoukinyoteigk;
    }

    private String ztyippansinkokuyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYIPPANSINKOKUYOTEIGK)
    public String getZtyippansinkokuyoteigk() {
        return ztyippansinkokuyoteigk;
    }

    public void setZtyippansinkokuyoteigk(String pZtyippansinkokuyoteigk) {
        ztyippansinkokuyoteigk = pZtyippansinkokuyoteigk;
    }

    private String ztykaigoiryoupyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKAIGOIRYOUPYOTEIGK)
    public String getZtykaigoiryoupyoteigk() {
        return ztykaigoiryoupyoteigk;
    }

    public void setZtykaigoiryoupyoteigk(String pZtykaigoiryoupyoteigk) {
        ztykaigoiryoupyoteigk = pZtykaigoiryoupyoteigk;
    }

    private String ztykaigoiryoudyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKAIGOIRYOUDYOTEIGK)
    public String getZtykaigoiryoudyoteigk() {
        return ztykaigoiryoudyoteigk;
    }

    public void setZtykaigoiryoudyoteigk(String pZtykaigoiryoudyoteigk) {
        ztykaigoiryoudyoteigk = pZtykaigoiryoudyoteigk;
    }

    private String ztykaigoiryousinkokuyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKAIGOIRYOUSINKOKUYOTEIGK)
    public String getZtykaigoiryousinkokuyoteigk() {
        return ztykaigoiryousinkokuyoteigk;
    }

    public void setZtykaigoiryousinkokuyoteigk(String pZtykaigoiryousinkokuyoteigk) {
        ztykaigoiryousinkokuyoteigk = pZtykaigoiryousinkokuyoteigk;
    }

    private String ztynenkinpyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYNENKINPYOTEIGK)
    public String getZtynenkinpyoteigk() {
        return ztynenkinpyoteigk;
    }

    public void setZtynenkinpyoteigk(String pZtynenkinpyoteigk) {
        ztynenkinpyoteigk = pZtynenkinpyoteigk;
    }

    private String ztynenkindyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYNENKINDYOTEIGK)
    public String getZtynenkindyoteigk() {
        return ztynenkindyoteigk;
    }

    public void setZtynenkindyoteigk(String pZtynenkindyoteigk) {
        ztynenkindyoteigk = pZtynenkindyoteigk;
    }

    private String ztynenkinsinkokuyoteigk;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYNENKINSINKOKUYOTEIGK)
    public String getZtynenkinsinkokuyoteigk() {
        return ztynenkinsinkokuyoteigk;
    }

    public void setZtynenkinsinkokuyoteigk(String pZtynenkinsinkokuyoteigk) {
        ztynenkinsinkokuyoteigk = pZtynenkinsinkokuyoteigk;
    }

    private String ztynewhknjytukikan;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYNEWHKNJYTUKIKAN)
    public String getZtynewhknjytukikan() {
        return ztynewhknjytukikan;
    }

    public void setZtynewhknjytukikan(String pZtynewhknjytukikan) {
        ztynewhknjytukikan = pZtynewhknjytukikan;
    }

    private String ztykykymdkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYKYKYMDKJ)
    public String getZtykykymdkj() {
        return ztykykymdkj;
    }

    public void setZtykykymdkj(String pZtykykymdkj) {
        ztykykymdkj = pZtykykymdkj;
    }

    private String ztyhrkkaisuunm;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYHRKKAISUUNM)
    public String getZtyhrkkaisuunm() {
        return ztyhrkkaisuunm;
    }

    public void setZtyhrkkaisuunm(String pZtyhrkkaisuunm) {
        ztyhrkkaisuunm = pZtyhrkkaisuunm;
    }

    private String ztysakuseiymdkj;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYSAKUSEIYMDKJ)
    public String getZtysakuseiymdkj() {
        return ztysakuseiymdkj;
    }

    public void setZtysakuseiymdkj(String pZtysakuseiymdkj) {
        ztysakuseiymdkj = pZtysakuseiymdkj;
    }

    private String ztyyobiv34;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYYOBIV34)
    public String getZtyyobiv34() {
        return ztyyobiv34;
    }

    public void setZtyyobiv34(String pZtyyobiv34) {
        ztyyobiv34 = pZtyyobiv34;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_SinkokuYokokuTuutiFSksTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }
}