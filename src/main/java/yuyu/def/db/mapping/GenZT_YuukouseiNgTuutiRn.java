package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiRn;
import yuyu.def.db.id.PKZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.GenQZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiRn;

/**
 * 有効性確認ＮＧ通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_YuukouseiNgTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouseiNgTuutiRn}</td><td colspan="3">有効性確認ＮＧ通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_YuukouseiNgTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_YuukouseiNgTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnyobiv62 zrnyobiv62}</td><td>（連携用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta1 zrnosirasemongon46keta1}</td><td>（連携用）お知らせ文言（４６桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta2 zrnosirasemongon46keta2}</td><td>（連携用）お知らせ文言（４６桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta3 zrnosirasemongon46keta3}</td><td>（連携用）お知らせ文言（４６桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta4 zrnosirasemongon46keta4}</td><td>（連携用）お知らせ文言（４６桁）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta5 zrnosirasemongon46keta5}</td><td>（連携用）お知らせ文言（４６桁）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta6 zrnosirasemongon46keta6}</td><td>（連携用）お知らせ文言（４６桁）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta7 zrnosirasemongon46keta7}</td><td>（連携用）お知らせ文言（４６桁）７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta8 zrnosirasemongon46keta8}</td><td>（連携用）お知らせ文言（４６桁）８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta9 zrnosirasemongon46keta9}</td><td>（連携用）お知らせ文言（４６桁）９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46keta10 zrnosirasemongon46keta10}</td><td>（連携用）お知らせ文言（４６桁）１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv184 zrnyobiv184}</td><td>（連携用）予備項目Ｖ１８４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpkngk zrnpkngk}</td><td>（連携用）保険料金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditcardinfo1 zrncreditcardinfo1}</td><td>（連携用）クレジットカード情報１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditcardinfo2 zrncreditcardinfo2}</td><td>（連携用）クレジットカード情報２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditcardinfo3 zrncreditcardinfo3}</td><td>（連携用）クレジットカード情報３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditcardmaskingmsg zrncreditcardmaskingmsg}</td><td>（連携用）クレジットカードマスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoiraijikoutoumongon1 zrngoiraijikoutoumongon1}</td><td>（連携用）ご依頼事項等文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoiraijikoutoumongon2 zrngoiraijikoutoumongon2}</td><td>（連携用）ご依頼事項等文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoiraijikoutoumongon3 zrngoiraijikoutoumongon3}</td><td>（連携用）ご依頼事項等文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon1 zrnphrkmongon1}</td><td>（連携用）保険料のお払込み文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon2 zrnphrkmongon2}</td><td>（連携用）保険料のお払込み文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon3 zrnphrkmongon3}</td><td>（連携用）保険料のお払込み文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon4 zrnphrkmongon4}</td><td>（連携用）保険料のお払込み文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon5 zrnphrkmongon5}</td><td>（連携用）保険料のお払込み文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon6 zrnphrkmongon6}</td><td>（連携用）保険料のお払込み文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon7 zrnphrkmongon7}</td><td>（連携用）保険料のお払込み文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon8 zrnphrkmongon8}</td><td>（連携用）保険料のお払込み文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkmongon9 zrnphrkmongon9}</td><td>（連携用）保険料のお払込み文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250 zrnyobiv250}</td><td>（連携用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouseiNgTuutiRn
 * @see     PKZT_YuukouseiNgTuutiRn
 * @see     QZT_YuukouseiNgTuutiRn
 * @see     GenQZT_YuukouseiNgTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_YuukouseiNgTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_YuukouseiNgTuutiRn.class)
public abstract class GenZT_YuukouseiNgTuutiRn extends AbstractExDBEntityForZDB<ZT_YuukouseiNgTuutiRn, PKZT_YuukouseiNgTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YuukouseiNgTuutiRn";
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
    public static final String ZRNYOBIV62               = "zrnyobiv62";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNOSIRASEMONGON46KETA1  = "zrnosirasemongon46keta1";
    public static final String ZRNOSIRASEMONGON46KETA2  = "zrnosirasemongon46keta2";
    public static final String ZRNOSIRASEMONGON46KETA3  = "zrnosirasemongon46keta3";
    public static final String ZRNOSIRASEMONGON46KETA4  = "zrnosirasemongon46keta4";
    public static final String ZRNOSIRASEMONGON46KETA5  = "zrnosirasemongon46keta5";
    public static final String ZRNOSIRASEMONGON46KETA6  = "zrnosirasemongon46keta6";
    public static final String ZRNOSIRASEMONGON46KETA7  = "zrnosirasemongon46keta7";
    public static final String ZRNOSIRASEMONGON46KETA8  = "zrnosirasemongon46keta8";
    public static final String ZRNOSIRASEMONGON46KETA9  = "zrnosirasemongon46keta9";
    public static final String ZRNOSIRASEMONGON46KETA10 = "zrnosirasemongon46keta10";
    public static final String ZRNYOBIV184              = "zrnyobiv184";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNPKNGK                 = "zrnpkngk";
    public static final String ZRNCREDITCARDINFO1       = "zrncreditcardinfo1";
    public static final String ZRNCREDITCARDINFO2       = "zrncreditcardinfo2";
    public static final String ZRNCREDITCARDINFO3       = "zrncreditcardinfo3";
    public static final String ZRNCREDITCARDMASKINGMSG  = "zrncreditcardmaskingmsg";
    public static final String ZRNGOIRAIJIKOUTOUMONGON1 = "zrngoiraijikoutoumongon1";
    public static final String ZRNGOIRAIJIKOUTOUMONGON2 = "zrngoiraijikoutoumongon2";
    public static final String ZRNGOIRAIJIKOUTOUMONGON3 = "zrngoiraijikoutoumongon3";
    public static final String ZRNPHRKMONGON1           = "zrnphrkmongon1";
    public static final String ZRNPHRKMONGON2           = "zrnphrkmongon2";
    public static final String ZRNPHRKMONGON3           = "zrnphrkmongon3";
    public static final String ZRNPHRKMONGON4           = "zrnphrkmongon4";
    public static final String ZRNPHRKMONGON5           = "zrnphrkmongon5";
    public static final String ZRNPHRKMONGON6           = "zrnphrkmongon6";
    public static final String ZRNPHRKMONGON7           = "zrnphrkmongon7";
    public static final String ZRNPHRKMONGON8           = "zrnphrkmongon8";
    public static final String ZRNPHRKMONGON9           = "zrnphrkmongon9";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNYOBIV250              = "zrnyobiv250";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";

    private final PKZT_YuukouseiNgTuutiRn primaryKey;

    public GenZT_YuukouseiNgTuutiRn() {
        primaryKey = new PKZT_YuukouseiNgTuutiRn();
    }

    public GenZT_YuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_YuukouseiNgTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_YuukouseiNgTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YuukouseiNgTuutiRn> getMetaClass() {
        return QZT_YuukouseiNgTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    @Id
    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnyobiv9;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnyobiv62;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNYOBIV62)
    public String getZrnyobiv62() {
        return zrnyobiv62;
    }

    public void setZrnyobiv62(String pZrnyobiv62) {
        zrnyobiv62 = pZrnyobiv62;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrnosirasemongon46keta1;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA1)
    public String getZrnosirasemongon46keta1() {
        return zrnosirasemongon46keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta1(String pZrnosirasemongon46keta1) {
        zrnosirasemongon46keta1 = pZrnosirasemongon46keta1;
    }

    private String zrnosirasemongon46keta2;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA2)
    public String getZrnosirasemongon46keta2() {
        return zrnosirasemongon46keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta2(String pZrnosirasemongon46keta2) {
        zrnosirasemongon46keta2 = pZrnosirasemongon46keta2;
    }

    private String zrnosirasemongon46keta3;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA3)
    public String getZrnosirasemongon46keta3() {
        return zrnosirasemongon46keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta3(String pZrnosirasemongon46keta3) {
        zrnosirasemongon46keta3 = pZrnosirasemongon46keta3;
    }

    private String zrnosirasemongon46keta4;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA4)
    public String getZrnosirasemongon46keta4() {
        return zrnosirasemongon46keta4;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta4(String pZrnosirasemongon46keta4) {
        zrnosirasemongon46keta4 = pZrnosirasemongon46keta4;
    }

    private String zrnosirasemongon46keta5;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA5)
    public String getZrnosirasemongon46keta5() {
        return zrnosirasemongon46keta5;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta5(String pZrnosirasemongon46keta5) {
        zrnosirasemongon46keta5 = pZrnosirasemongon46keta5;
    }

    private String zrnosirasemongon46keta6;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA6)
    public String getZrnosirasemongon46keta6() {
        return zrnosirasemongon46keta6;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta6(String pZrnosirasemongon46keta6) {
        zrnosirasemongon46keta6 = pZrnosirasemongon46keta6;
    }

    private String zrnosirasemongon46keta7;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA7)
    public String getZrnosirasemongon46keta7() {
        return zrnosirasemongon46keta7;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta7(String pZrnosirasemongon46keta7) {
        zrnosirasemongon46keta7 = pZrnosirasemongon46keta7;
    }

    private String zrnosirasemongon46keta8;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA8)
    public String getZrnosirasemongon46keta8() {
        return zrnosirasemongon46keta8;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta8(String pZrnosirasemongon46keta8) {
        zrnosirasemongon46keta8 = pZrnosirasemongon46keta8;
    }

    private String zrnosirasemongon46keta9;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA9)
    public String getZrnosirasemongon46keta9() {
        return zrnosirasemongon46keta9;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta9(String pZrnosirasemongon46keta9) {
        zrnosirasemongon46keta9 = pZrnosirasemongon46keta9;
    }

    private String zrnosirasemongon46keta10;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNOSIRASEMONGON46KETA10)
    public String getZrnosirasemongon46keta10() {
        return zrnosirasemongon46keta10;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46keta10(String pZrnosirasemongon46keta10) {
        zrnosirasemongon46keta10 = pZrnosirasemongon46keta10;
    }

    private String zrnyobiv184;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNYOBIV184)
    public String getZrnyobiv184() {
        return zrnyobiv184;
    }

    public void setZrnyobiv184(String pZrnyobiv184) {
        zrnyobiv184 = pZrnyobiv184;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnpkngk;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPKNGK)
    public String getZrnpkngk() {
        return zrnpkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpkngk(String pZrnpkngk) {
        zrnpkngk = pZrnpkngk;
    }

    private String zrncreditcardinfo1;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNCREDITCARDINFO1)
    public String getZrncreditcardinfo1() {
        return zrncreditcardinfo1;
    }

    @DataConvert("toMultiByte")
    public void setZrncreditcardinfo1(String pZrncreditcardinfo1) {
        zrncreditcardinfo1 = pZrncreditcardinfo1;
    }

    private String zrncreditcardinfo2;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNCREDITCARDINFO2)
    public String getZrncreditcardinfo2() {
        return zrncreditcardinfo2;
    }

    @DataConvert("toMultiByte")
    public void setZrncreditcardinfo2(String pZrncreditcardinfo2) {
        zrncreditcardinfo2 = pZrncreditcardinfo2;
    }

    private String zrncreditcardinfo3;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNCREDITCARDINFO3)
    public String getZrncreditcardinfo3() {
        return zrncreditcardinfo3;
    }

    @DataConvert("toMultiByte")
    public void setZrncreditcardinfo3(String pZrncreditcardinfo3) {
        zrncreditcardinfo3 = pZrncreditcardinfo3;
    }

    private String zrncreditcardmaskingmsg;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNCREDITCARDMASKINGMSG)
    public String getZrncreditcardmaskingmsg() {
        return zrncreditcardmaskingmsg;
    }

    @DataConvert("toMultiByte")
    public void setZrncreditcardmaskingmsg(String pZrncreditcardmaskingmsg) {
        zrncreditcardmaskingmsg = pZrncreditcardmaskingmsg;
    }

    private String zrngoiraijikoutoumongon1;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNGOIRAIJIKOUTOUMONGON1)
    public String getZrngoiraijikoutoumongon1() {
        return zrngoiraijikoutoumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrngoiraijikoutoumongon1(String pZrngoiraijikoutoumongon1) {
        zrngoiraijikoutoumongon1 = pZrngoiraijikoutoumongon1;
    }

    private String zrngoiraijikoutoumongon2;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNGOIRAIJIKOUTOUMONGON2)
    public String getZrngoiraijikoutoumongon2() {
        return zrngoiraijikoutoumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrngoiraijikoutoumongon2(String pZrngoiraijikoutoumongon2) {
        zrngoiraijikoutoumongon2 = pZrngoiraijikoutoumongon2;
    }

    private String zrngoiraijikoutoumongon3;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNGOIRAIJIKOUTOUMONGON3)
    public String getZrngoiraijikoutoumongon3() {
        return zrngoiraijikoutoumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrngoiraijikoutoumongon3(String pZrngoiraijikoutoumongon3) {
        zrngoiraijikoutoumongon3 = pZrngoiraijikoutoumongon3;
    }

    private String zrnphrkmongon1;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON1)
    public String getZrnphrkmongon1() {
        return zrnphrkmongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon1(String pZrnphrkmongon1) {
        zrnphrkmongon1 = pZrnphrkmongon1;
    }

    private String zrnphrkmongon2;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON2)
    public String getZrnphrkmongon2() {
        return zrnphrkmongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon2(String pZrnphrkmongon2) {
        zrnphrkmongon2 = pZrnphrkmongon2;
    }

    private String zrnphrkmongon3;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON3)
    public String getZrnphrkmongon3() {
        return zrnphrkmongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon3(String pZrnphrkmongon3) {
        zrnphrkmongon3 = pZrnphrkmongon3;
    }

    private String zrnphrkmongon4;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON4)
    public String getZrnphrkmongon4() {
        return zrnphrkmongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon4(String pZrnphrkmongon4) {
        zrnphrkmongon4 = pZrnphrkmongon4;
    }

    private String zrnphrkmongon5;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON5)
    public String getZrnphrkmongon5() {
        return zrnphrkmongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon5(String pZrnphrkmongon5) {
        zrnphrkmongon5 = pZrnphrkmongon5;
    }

    private String zrnphrkmongon6;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON6)
    public String getZrnphrkmongon6() {
        return zrnphrkmongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon6(String pZrnphrkmongon6) {
        zrnphrkmongon6 = pZrnphrkmongon6;
    }

    private String zrnphrkmongon7;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON7)
    public String getZrnphrkmongon7() {
        return zrnphrkmongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon7(String pZrnphrkmongon7) {
        zrnphrkmongon7 = pZrnphrkmongon7;
    }

    private String zrnphrkmongon8;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON8)
    public String getZrnphrkmongon8() {
        return zrnphrkmongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon8(String pZrnphrkmongon8) {
        zrnphrkmongon8 = pZrnphrkmongon8;
    }

    private String zrnphrkmongon9;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNPHRKMONGON9)
    public String getZrnphrkmongon9() {
        return zrnphrkmongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkmongon9(String pZrnphrkmongon9) {
        zrnphrkmongon9 = pZrnphrkmongon9;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnyobiv250;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNYOBIV250)
    public String getZrnyobiv250() {
        return zrnyobiv250;
    }

    public void setZrnyobiv250(String pZrnyobiv250) {
        zrnyobiv250 = pZrnyobiv250;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_YuukouseiNgTuutiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }
}