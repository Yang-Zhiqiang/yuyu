package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiTy;
import yuyu.def.db.id.PKZT_YuukouseiNgTuutiTy;
import yuyu.def.db.meta.GenQZT_YuukouseiNgTuutiTy;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiTy;

/**
 * 有効性確認ＮＧ通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_YuukouseiNgTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouseiNgTuutiTy}</td><td colspan="3">有効性確認ＮＧ通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_YuukouseiNgTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_YuukouseiNgTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtyyobiv62 ztyyobiv62}</td><td>（中継用）予備項目Ｖ６２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta1 ztyosirasemongon46keta1}</td><td>（中継用）お知らせ文言（４６桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta2 ztyosirasemongon46keta2}</td><td>（中継用）お知らせ文言（４６桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta3 ztyosirasemongon46keta3}</td><td>（中継用）お知らせ文言（４６桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta4 ztyosirasemongon46keta4}</td><td>（中継用）お知らせ文言（４６桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta5 ztyosirasemongon46keta5}</td><td>（中継用）お知らせ文言（４６桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta6 ztyosirasemongon46keta6}</td><td>（中継用）お知らせ文言（４６桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta7 ztyosirasemongon46keta7}</td><td>（中継用）お知らせ文言（４６桁）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta8 ztyosirasemongon46keta8}</td><td>（中継用）お知らせ文言（４６桁）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta9 ztyosirasemongon46keta9}</td><td>（中継用）お知らせ文言（４６桁）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46keta10 ztyosirasemongon46keta10}</td><td>（中継用）お知らせ文言（４６桁）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv184 ztyyobiv184}</td><td>（中継用）予備項目Ｖ１８４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypkngk ztypkngk}</td><td>（中継用）保険料金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditcardinfo1 ztycreditcardinfo1}</td><td>（中継用）クレジットカード情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditcardinfo2 ztycreditcardinfo2}</td><td>（中継用）クレジットカード情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditcardinfo3 ztycreditcardinfo3}</td><td>（中継用）クレジットカード情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditcardmaskingmsg ztycreditcardmaskingmsg}</td><td>（中継用）クレジットカードマスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoiraijikoutoumongon1 ztygoiraijikoutoumongon1}</td><td>（中継用）ご依頼事項等文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoiraijikoutoumongon2 ztygoiraijikoutoumongon2}</td><td>（中継用）ご依頼事項等文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoiraijikoutoumongon3 ztygoiraijikoutoumongon3}</td><td>（中継用）ご依頼事項等文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon1 ztyphrkmongon1}</td><td>（中継用）保険料のお払込み文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon2 ztyphrkmongon2}</td><td>（中継用）保険料のお払込み文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon3 ztyphrkmongon3}</td><td>（中継用）保険料のお払込み文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon4 ztyphrkmongon4}</td><td>（中継用）保険料のお払込み文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon5 ztyphrkmongon5}</td><td>（中継用）保険料のお払込み文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon6 ztyphrkmongon6}</td><td>（中継用）保険料のお払込み文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon7 ztyphrkmongon7}</td><td>（中継用）保険料のお払込み文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon8 ztyphrkmongon8}</td><td>（中継用）保険料のお払込み文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkmongon9 ztyphrkmongon9}</td><td>（中継用）保険料のお払込み文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250 ztyyobiv250}</td><td>（中継用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouseiNgTuutiTy
 * @see     PKZT_YuukouseiNgTuutiTy
 * @see     QZT_YuukouseiNgTuutiTy
 * @see     GenQZT_YuukouseiNgTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_YuukouseiNgTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_YuukouseiNgTuutiTy.class)
public abstract class GenZT_YuukouseiNgTuutiTy extends AbstractExDBEntity<ZT_YuukouseiNgTuutiTy, PKZT_YuukouseiNgTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YuukouseiNgTuutiTy";
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
    public static final String ZTYYOBIV62               = "ztyyobiv62";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYOSIRASEMONGON46KETA1  = "ztyosirasemongon46keta1";
    public static final String ZTYOSIRASEMONGON46KETA2  = "ztyosirasemongon46keta2";
    public static final String ZTYOSIRASEMONGON46KETA3  = "ztyosirasemongon46keta3";
    public static final String ZTYOSIRASEMONGON46KETA4  = "ztyosirasemongon46keta4";
    public static final String ZTYOSIRASEMONGON46KETA5  = "ztyosirasemongon46keta5";
    public static final String ZTYOSIRASEMONGON46KETA6  = "ztyosirasemongon46keta6";
    public static final String ZTYOSIRASEMONGON46KETA7  = "ztyosirasemongon46keta7";
    public static final String ZTYOSIRASEMONGON46KETA8  = "ztyosirasemongon46keta8";
    public static final String ZTYOSIRASEMONGON46KETA9  = "ztyosirasemongon46keta9";
    public static final String ZTYOSIRASEMONGON46KETA10 = "ztyosirasemongon46keta10";
    public static final String ZTYYOBIV184              = "ztyyobiv184";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYPKNGK                 = "ztypkngk";
    public static final String ZTYCREDITCARDINFO1       = "ztycreditcardinfo1";
    public static final String ZTYCREDITCARDINFO2       = "ztycreditcardinfo2";
    public static final String ZTYCREDITCARDINFO3       = "ztycreditcardinfo3";
    public static final String ZTYCREDITCARDMASKINGMSG  = "ztycreditcardmaskingmsg";
    public static final String ZTYGOIRAIJIKOUTOUMONGON1 = "ztygoiraijikoutoumongon1";
    public static final String ZTYGOIRAIJIKOUTOUMONGON2 = "ztygoiraijikoutoumongon2";
    public static final String ZTYGOIRAIJIKOUTOUMONGON3 = "ztygoiraijikoutoumongon3";
    public static final String ZTYPHRKMONGON1           = "ztyphrkmongon1";
    public static final String ZTYPHRKMONGON2           = "ztyphrkmongon2";
    public static final String ZTYPHRKMONGON3           = "ztyphrkmongon3";
    public static final String ZTYPHRKMONGON4           = "ztyphrkmongon4";
    public static final String ZTYPHRKMONGON5           = "ztyphrkmongon5";
    public static final String ZTYPHRKMONGON6           = "ztyphrkmongon6";
    public static final String ZTYPHRKMONGON7           = "ztyphrkmongon7";
    public static final String ZTYPHRKMONGON8           = "ztyphrkmongon8";
    public static final String ZTYPHRKMONGON9           = "ztyphrkmongon9";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYYOBIV250              = "ztyyobiv250";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";

    private final PKZT_YuukouseiNgTuutiTy primaryKey;

    public GenZT_YuukouseiNgTuutiTy() {
        primaryKey = new PKZT_YuukouseiNgTuutiTy();
    }

    public GenZT_YuukouseiNgTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_YuukouseiNgTuutiTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_YuukouseiNgTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YuukouseiNgTuutiTy> getMetaClass() {
        return QZT_YuukouseiNgTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    @Id
    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyyobiv9;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztyyobiv62;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYYOBIV62)
    public String getZtyyobiv62() {
        return ztyyobiv62;
    }

    public void setZtyyobiv62(String pZtyyobiv62) {
        ztyyobiv62 = pZtyyobiv62;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztyosirasemongon46keta1;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA1)
    public String getZtyosirasemongon46keta1() {
        return ztyosirasemongon46keta1;
    }

    public void setZtyosirasemongon46keta1(String pZtyosirasemongon46keta1) {
        ztyosirasemongon46keta1 = pZtyosirasemongon46keta1;
    }

    private String ztyosirasemongon46keta2;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA2)
    public String getZtyosirasemongon46keta2() {
        return ztyosirasemongon46keta2;
    }

    public void setZtyosirasemongon46keta2(String pZtyosirasemongon46keta2) {
        ztyosirasemongon46keta2 = pZtyosirasemongon46keta2;
    }

    private String ztyosirasemongon46keta3;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA3)
    public String getZtyosirasemongon46keta3() {
        return ztyosirasemongon46keta3;
    }

    public void setZtyosirasemongon46keta3(String pZtyosirasemongon46keta3) {
        ztyosirasemongon46keta3 = pZtyosirasemongon46keta3;
    }

    private String ztyosirasemongon46keta4;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA4)
    public String getZtyosirasemongon46keta4() {
        return ztyosirasemongon46keta4;
    }

    public void setZtyosirasemongon46keta4(String pZtyosirasemongon46keta4) {
        ztyosirasemongon46keta4 = pZtyosirasemongon46keta4;
    }

    private String ztyosirasemongon46keta5;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA5)
    public String getZtyosirasemongon46keta5() {
        return ztyosirasemongon46keta5;
    }

    public void setZtyosirasemongon46keta5(String pZtyosirasemongon46keta5) {
        ztyosirasemongon46keta5 = pZtyosirasemongon46keta5;
    }

    private String ztyosirasemongon46keta6;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA6)
    public String getZtyosirasemongon46keta6() {
        return ztyosirasemongon46keta6;
    }

    public void setZtyosirasemongon46keta6(String pZtyosirasemongon46keta6) {
        ztyosirasemongon46keta6 = pZtyosirasemongon46keta6;
    }

    private String ztyosirasemongon46keta7;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA7)
    public String getZtyosirasemongon46keta7() {
        return ztyosirasemongon46keta7;
    }

    public void setZtyosirasemongon46keta7(String pZtyosirasemongon46keta7) {
        ztyosirasemongon46keta7 = pZtyosirasemongon46keta7;
    }

    private String ztyosirasemongon46keta8;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA8)
    public String getZtyosirasemongon46keta8() {
        return ztyosirasemongon46keta8;
    }

    public void setZtyosirasemongon46keta8(String pZtyosirasemongon46keta8) {
        ztyosirasemongon46keta8 = pZtyosirasemongon46keta8;
    }

    private String ztyosirasemongon46keta9;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA9)
    public String getZtyosirasemongon46keta9() {
        return ztyosirasemongon46keta9;
    }

    public void setZtyosirasemongon46keta9(String pZtyosirasemongon46keta9) {
        ztyosirasemongon46keta9 = pZtyosirasemongon46keta9;
    }

    private String ztyosirasemongon46keta10;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYOSIRASEMONGON46KETA10)
    public String getZtyosirasemongon46keta10() {
        return ztyosirasemongon46keta10;
    }

    public void setZtyosirasemongon46keta10(String pZtyosirasemongon46keta10) {
        ztyosirasemongon46keta10 = pZtyosirasemongon46keta10;
    }

    private String ztyyobiv184;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYYOBIV184)
    public String getZtyyobiv184() {
        return ztyyobiv184;
    }

    public void setZtyyobiv184(String pZtyyobiv184) {
        ztyyobiv184 = pZtyyobiv184;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztypkngk;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPKNGK)
    public String getZtypkngk() {
        return ztypkngk;
    }

    public void setZtypkngk(String pZtypkngk) {
        ztypkngk = pZtypkngk;
    }

    private String ztycreditcardinfo1;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYCREDITCARDINFO1)
    public String getZtycreditcardinfo1() {
        return ztycreditcardinfo1;
    }

    public void setZtycreditcardinfo1(String pZtycreditcardinfo1) {
        ztycreditcardinfo1 = pZtycreditcardinfo1;
    }

    private String ztycreditcardinfo2;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYCREDITCARDINFO2)
    public String getZtycreditcardinfo2() {
        return ztycreditcardinfo2;
    }

    public void setZtycreditcardinfo2(String pZtycreditcardinfo2) {
        ztycreditcardinfo2 = pZtycreditcardinfo2;
    }

    private String ztycreditcardinfo3;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYCREDITCARDINFO3)
    public String getZtycreditcardinfo3() {
        return ztycreditcardinfo3;
    }

    public void setZtycreditcardinfo3(String pZtycreditcardinfo3) {
        ztycreditcardinfo3 = pZtycreditcardinfo3;
    }

    private String ztycreditcardmaskingmsg;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYCREDITCARDMASKINGMSG)
    public String getZtycreditcardmaskingmsg() {
        return ztycreditcardmaskingmsg;
    }

    public void setZtycreditcardmaskingmsg(String pZtycreditcardmaskingmsg) {
        ztycreditcardmaskingmsg = pZtycreditcardmaskingmsg;
    }

    private String ztygoiraijikoutoumongon1;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYGOIRAIJIKOUTOUMONGON1)
    public String getZtygoiraijikoutoumongon1() {
        return ztygoiraijikoutoumongon1;
    }

    public void setZtygoiraijikoutoumongon1(String pZtygoiraijikoutoumongon1) {
        ztygoiraijikoutoumongon1 = pZtygoiraijikoutoumongon1;
    }

    private String ztygoiraijikoutoumongon2;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYGOIRAIJIKOUTOUMONGON2)
    public String getZtygoiraijikoutoumongon2() {
        return ztygoiraijikoutoumongon2;
    }

    public void setZtygoiraijikoutoumongon2(String pZtygoiraijikoutoumongon2) {
        ztygoiraijikoutoumongon2 = pZtygoiraijikoutoumongon2;
    }

    private String ztygoiraijikoutoumongon3;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYGOIRAIJIKOUTOUMONGON3)
    public String getZtygoiraijikoutoumongon3() {
        return ztygoiraijikoutoumongon3;
    }

    public void setZtygoiraijikoutoumongon3(String pZtygoiraijikoutoumongon3) {
        ztygoiraijikoutoumongon3 = pZtygoiraijikoutoumongon3;
    }

    private String ztyphrkmongon1;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON1)
    public String getZtyphrkmongon1() {
        return ztyphrkmongon1;
    }

    public void setZtyphrkmongon1(String pZtyphrkmongon1) {
        ztyphrkmongon1 = pZtyphrkmongon1;
    }

    private String ztyphrkmongon2;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON2)
    public String getZtyphrkmongon2() {
        return ztyphrkmongon2;
    }

    public void setZtyphrkmongon2(String pZtyphrkmongon2) {
        ztyphrkmongon2 = pZtyphrkmongon2;
    }

    private String ztyphrkmongon3;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON3)
    public String getZtyphrkmongon3() {
        return ztyphrkmongon3;
    }

    public void setZtyphrkmongon3(String pZtyphrkmongon3) {
        ztyphrkmongon3 = pZtyphrkmongon3;
    }

    private String ztyphrkmongon4;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON4)
    public String getZtyphrkmongon4() {
        return ztyphrkmongon4;
    }

    public void setZtyphrkmongon4(String pZtyphrkmongon4) {
        ztyphrkmongon4 = pZtyphrkmongon4;
    }

    private String ztyphrkmongon5;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON5)
    public String getZtyphrkmongon5() {
        return ztyphrkmongon5;
    }

    public void setZtyphrkmongon5(String pZtyphrkmongon5) {
        ztyphrkmongon5 = pZtyphrkmongon5;
    }

    private String ztyphrkmongon6;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON6)
    public String getZtyphrkmongon6() {
        return ztyphrkmongon6;
    }

    public void setZtyphrkmongon6(String pZtyphrkmongon6) {
        ztyphrkmongon6 = pZtyphrkmongon6;
    }

    private String ztyphrkmongon7;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON7)
    public String getZtyphrkmongon7() {
        return ztyphrkmongon7;
    }

    public void setZtyphrkmongon7(String pZtyphrkmongon7) {
        ztyphrkmongon7 = pZtyphrkmongon7;
    }

    private String ztyphrkmongon8;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON8)
    public String getZtyphrkmongon8() {
        return ztyphrkmongon8;
    }

    public void setZtyphrkmongon8(String pZtyphrkmongon8) {
        ztyphrkmongon8 = pZtyphrkmongon8;
    }

    private String ztyphrkmongon9;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYPHRKMONGON9)
    public String getZtyphrkmongon9() {
        return ztyphrkmongon9;
    }

    public void setZtyphrkmongon9(String pZtyphrkmongon9) {
        ztyphrkmongon9 = pZtyphrkmongon9;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztyyobiv250;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYYOBIV250)
    public String getZtyyobiv250() {
        return ztyyobiv250;
    }

    public void setZtyyobiv250(String pZtyyobiv250) {
        ztyyobiv250 = pZtyyobiv250;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_YuukouseiNgTuutiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }
}