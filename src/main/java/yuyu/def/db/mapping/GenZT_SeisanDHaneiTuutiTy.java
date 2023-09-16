package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.id.PKZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.GenQZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiTy;

/**
 * 精算Ｄ反映通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SeisanDHaneiTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeisanDHaneiTuutiTy}</td><td colspan="3">精算Ｄ反映通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SeisanDHaneiTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeysyono ztykeysyono}</td><td>（中継用）キー証券番号</td><td align="center">{@link PKZT_SeisanDHaneiTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitounendo ztyhaitounendo}</td><td>（中継用）配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiyno ztyatesakiyno}</td><td>（中継用）宛先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrigikbn ztyrigikbn}</td><td>（中継用）例外区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeiro ztyhrkkeiro}</td><td>（中継用）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr1 ztyatesakiadr1}</td><td>（中継用）宛先住所１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr2 ztyatesakiadr2}</td><td>（中継用）宛先住所２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr3 ztyatesakiadr3}</td><td>（中継用）宛先住所３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatena1 ztyatena1}</td><td>（中継用）宛名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea1 ztydai1syoukaisakifreearea1}</td><td>（中継用）第１照会先フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea2 ztydai1syoukaisakifreearea2}</td><td>（中継用）第１照会先フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea3 ztydai1syoukaisakifreearea3}</td><td>（中継用）第１照会先フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea4 ztydai1syoukaisakifreearea4}</td><td>（中継用）第１照会先フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea5 ztydai1syoukaisakifreearea5}</td><td>（中継用）第１照会先フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakunm ztysakunm}</td><td>（中継用）作成番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiymdseireki ztysakuseiymdseireki}</td><td>（中継用）作成年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdseireki ztykykymdseireki}</td><td>（中継用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisikihknnm ztyseisikihknnm}</td><td>（中継用）正式保険名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj17 ztyhhknnmkj17}</td><td>（中継用）被保険者名（漢字）（１７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta11 ztyfreearea37keta11}</td><td>（中継用）フリーエリア（３７桁）１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta12 ztyfreearea37keta12}</td><td>（中継用）フリーエリア（３７桁）１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta13 ztyfreearea37keta13}</td><td>（中継用）フリーエリア（３７桁）１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta14 ztyfreearea37keta14}</td><td>（中継用）フリーエリア（３７桁）１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta15 ztyfreearea37keta15}</td><td>（中継用）フリーエリア（３７桁）１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta16 ztyfreearea37keta16}</td><td>（中継用）フリーエリア（３７桁）１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta17 ztyfreearea37keta17}</td><td>（中継用）フリーエリア（３７桁）１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta18 ztyfreearea37keta18}</td><td>（中継用）フリーエリア（３７桁）１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta19 ztyfreearea37keta19}</td><td>（中継用）フリーエリア（３７桁）１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta110 ztyfreearea37keta110}</td><td>（中継用）フリーエリア（３７桁）１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta111 ztyfreearea37keta111}</td><td>（中継用）フリーエリア（３７桁）１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta112 ztyfreearea37keta112}</td><td>（中継用）フリーエリア（３７桁）１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta113 ztyfreearea37keta113}</td><td>（中継用）フリーエリア（３７桁）１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta114 ztyfreearea37keta114}</td><td>（中継用）フリーエリア（３７桁）１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta115 ztyfreearea37keta115}</td><td>（中継用）フリーエリア（３７桁）１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta116 ztyfreearea37keta116}</td><td>（中継用）フリーエリア（３７桁）１＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta117 ztyfreearea37keta117}</td><td>（中継用）フリーエリア（３７桁）１＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta118 ztyfreearea37keta118}</td><td>（中継用）フリーエリア（３７桁）１＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta119 ztyfreearea37keta119}</td><td>（中継用）フリーエリア（３７桁）１＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta120 ztyfreearea37keta120}</td><td>（中継用）フリーエリア（３７桁）１＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta121 ztyfreearea37keta121}</td><td>（中継用）フリーエリア（３７桁）１＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta122 ztyfreearea37keta122}</td><td>（中継用）フリーエリア（３７桁）１＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta123 ztyfreearea37keta123}</td><td>（中継用）フリーエリア（３７桁）１＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta124 ztyfreearea37keta124}</td><td>（中継用）フリーエリア（３７桁）１＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea37keta125 ztyfreearea37keta125}</td><td>（中継用）フリーエリア（３７桁）１＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi11 ztymidasi11}</td><td>（中継用）見出し１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytouduketorihouhou ztytouduketorihouhou}</td><td>（中継用）当Ｄ受取方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi21 ztymidasi21}</td><td>（中継用）見出し２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakuteidkgk ztykakuteidkgk}</td><td>（中継用）確定Ｄ金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi31 ztymidasi31}</td><td>（中継用）見出し３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaiteidkgk ztynaiteidkgk}</td><td>（中継用）内定Ｄ金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymidasi41 ztymidasi41}</td><td>（中継用）見出し４＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisandkgk ztyseisandkgk}</td><td>（中継用）精算Ｄ金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea21 ztyfreearea21}</td><td>（中継用）フリーエリア２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea22 ztyfreearea22}</td><td>（中継用）フリーエリア２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea23 ztyfreearea23}</td><td>（中継用）フリーエリア２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea24 ztyfreearea24}</td><td>（中継用）フリーエリア２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea25 ztyfreearea25}</td><td>（中継用）フリーエリア２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv141 ztyyobiv141}</td><td>（中継用）予備項目Ｖ１４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeisanDHaneiTuutiTy
 * @see     PKZT_SeisanDHaneiTuutiTy
 * @see     QZT_SeisanDHaneiTuutiTy
 * @see     GenQZT_SeisanDHaneiTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_SeisanDHaneiTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_SeisanDHaneiTuutiTy.class)
public abstract class GenZT_SeisanDHaneiTuutiTy extends AbstractExDBEntity<ZT_SeisanDHaneiTuutiTy, PKZT_SeisanDHaneiTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SeisanDHaneiTuutiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYKEYSYONO              = "ztykeysyono";
    public static final String ZTYHAITOUNENDO           = "ztyhaitounendo";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYATESAKIYNO            = "ztyatesakiyno";
    public static final String ZTYRIGIKBN               = "ztyrigikbn";
    public static final String ZTYHRKKEIRO              = "ztyhrkkeiro";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYATESAKIADR1           = "ztyatesakiadr1";
    public static final String ZTYATESAKIADR2           = "ztyatesakiadr2";
    public static final String ZTYATESAKIADR3           = "ztyatesakiadr3";
    public static final String ZTYATENA1                = "ztyatena1";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA1 = "ztydai1syoukaisakifreearea1";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA2 = "ztydai1syoukaisakifreearea2";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA3 = "ztydai1syoukaisakifreearea3";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA4 = "ztydai1syoukaisakifreearea4";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA5 = "ztydai1syoukaisakifreearea5";
    public static final String ZTYSAKUNM                = "ztysakunm";
    public static final String ZTYSAKUSEIYMDSEIREKI     = "ztysakuseiymdseireki";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKYKYMDSEIREKI         = "ztykykymdseireki";
    public static final String ZTYSEISIKIHKNNM          = "ztyseisikihknnm";
    public static final String ZTYHHKNNMKJ17            = "ztyhhknnmkj17";
    public static final String ZTYFREEAREA37KETA11      = "ztyfreearea37keta11";
    public static final String ZTYFREEAREA37KETA12      = "ztyfreearea37keta12";
    public static final String ZTYFREEAREA37KETA13      = "ztyfreearea37keta13";
    public static final String ZTYFREEAREA37KETA14      = "ztyfreearea37keta14";
    public static final String ZTYFREEAREA37KETA15      = "ztyfreearea37keta15";
    public static final String ZTYFREEAREA37KETA16      = "ztyfreearea37keta16";
    public static final String ZTYFREEAREA37KETA17      = "ztyfreearea37keta17";
    public static final String ZTYFREEAREA37KETA18      = "ztyfreearea37keta18";
    public static final String ZTYFREEAREA37KETA19      = "ztyfreearea37keta19";
    public static final String ZTYFREEAREA37KETA110     = "ztyfreearea37keta110";
    public static final String ZTYFREEAREA37KETA111     = "ztyfreearea37keta111";
    public static final String ZTYFREEAREA37KETA112     = "ztyfreearea37keta112";
    public static final String ZTYFREEAREA37KETA113     = "ztyfreearea37keta113";
    public static final String ZTYFREEAREA37KETA114     = "ztyfreearea37keta114";
    public static final String ZTYFREEAREA37KETA115     = "ztyfreearea37keta115";
    public static final String ZTYFREEAREA37KETA116     = "ztyfreearea37keta116";
    public static final String ZTYFREEAREA37KETA117     = "ztyfreearea37keta117";
    public static final String ZTYFREEAREA37KETA118     = "ztyfreearea37keta118";
    public static final String ZTYFREEAREA37KETA119     = "ztyfreearea37keta119";
    public static final String ZTYFREEAREA37KETA120     = "ztyfreearea37keta120";
    public static final String ZTYFREEAREA37KETA121     = "ztyfreearea37keta121";
    public static final String ZTYFREEAREA37KETA122     = "ztyfreearea37keta122";
    public static final String ZTYFREEAREA37KETA123     = "ztyfreearea37keta123";
    public static final String ZTYFREEAREA37KETA124     = "ztyfreearea37keta124";
    public static final String ZTYFREEAREA37KETA125     = "ztyfreearea37keta125";
    public static final String ZTYMIDASI11              = "ztymidasi11";
    public static final String ZTYTOUDUKETORIHOUHOU     = "ztytouduketorihouhou";
    public static final String ZTYMIDASI21              = "ztymidasi21";
    public static final String ZTYKAKUTEIDKGK           = "ztykakuteidkgk";
    public static final String ZTYMIDASI31              = "ztymidasi31";
    public static final String ZTYNAITEIDKGK            = "ztynaiteidkgk";
    public static final String ZTYMIDASI41              = "ztymidasi41";
    public static final String ZTYSEISANDKGK            = "ztyseisandkgk";
    public static final String ZTYFREEAREA21            = "ztyfreearea21";
    public static final String ZTYFREEAREA22            = "ztyfreearea22";
    public static final String ZTYFREEAREA23            = "ztyfreearea23";
    public static final String ZTYFREEAREA24            = "ztyfreearea24";
    public static final String ZTYFREEAREA25            = "ztyfreearea25";
    public static final String ZTYYOBIV141              = "ztyyobiv141";

    private final PKZT_SeisanDHaneiTuutiTy primaryKey;

    public GenZT_SeisanDHaneiTuutiTy() {
        primaryKey = new PKZT_SeisanDHaneiTuutiTy();
    }

    public GenZT_SeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono) {
        primaryKey = new PKZT_SeisanDHaneiTuutiTy(pZtytyouhyouymd, pZtykeysyono);
    }

    @Transient
    @Override
    public PKZT_SeisanDHaneiTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SeisanDHaneiTuutiTy> getMetaClass() {
        return QZT_SeisanDHaneiTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYKEYSYONO)
    public String getZtykeysyono() {
        return getPrimaryKey().getZtykeysyono();
    }

    public void setZtykeysyono(String pZtykeysyono) {
        getPrimaryKey().setZtykeysyono(pZtykeysyono);
    }

    private String ztyhaitounendo;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYHAITOUNENDO)
    public String getZtyhaitounendo() {
        return ztyhaitounendo;
    }

    public void setZtyhaitounendo(String pZtyhaitounendo) {
        ztyhaitounendo = pZtyhaitounendo;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztyatesakiyno;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYATESAKIYNO)
    public String getZtyatesakiyno() {
        return ztyatesakiyno;
    }

    public void setZtyatesakiyno(String pZtyatesakiyno) {
        ztyatesakiyno = pZtyatesakiyno;
    }

    private String ztyrigikbn;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYRIGIKBN)
    public String getZtyrigikbn() {
        return ztyrigikbn;
    }

    public void setZtyrigikbn(String pZtyrigikbn) {
        ztyrigikbn = pZtyrigikbn;
    }

    private String ztyhrkkeiro;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYHRKKEIRO)
    public String getZtyhrkkeiro() {
        return ztyhrkkeiro;
    }

    public void setZtyhrkkeiro(String pZtyhrkkeiro) {
        ztyhrkkeiro = pZtyhrkkeiro;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztyatesakiadr1;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYATESAKIADR1)
    public String getZtyatesakiadr1() {
        return ztyatesakiadr1;
    }

    public void setZtyatesakiadr1(String pZtyatesakiadr1) {
        ztyatesakiadr1 = pZtyatesakiadr1;
    }

    private String ztyatesakiadr2;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYATESAKIADR2)
    public String getZtyatesakiadr2() {
        return ztyatesakiadr2;
    }

    public void setZtyatesakiadr2(String pZtyatesakiadr2) {
        ztyatesakiadr2 = pZtyatesakiadr2;
    }

    private String ztyatesakiadr3;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYATESAKIADR3)
    public String getZtyatesakiadr3() {
        return ztyatesakiadr3;
    }

    public void setZtyatesakiadr3(String pZtyatesakiadr3) {
        ztyatesakiadr3 = pZtyatesakiadr3;
    }

    private String ztyatena1;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYATENA1)
    public String getZtyatena1() {
        return ztyatena1;
    }

    public void setZtyatena1(String pZtyatena1) {
        ztyatena1 = pZtyatena1;
    }

    private String ztydai1syoukaisakifreearea1;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA1)
    public String getZtydai1syoukaisakifreearea1() {
        return ztydai1syoukaisakifreearea1;
    }

    public void setZtydai1syoukaisakifreearea1(String pZtydai1syoukaisakifreearea1) {
        ztydai1syoukaisakifreearea1 = pZtydai1syoukaisakifreearea1;
    }

    private String ztydai1syoukaisakifreearea2;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA2)
    public String getZtydai1syoukaisakifreearea2() {
        return ztydai1syoukaisakifreearea2;
    }

    public void setZtydai1syoukaisakifreearea2(String pZtydai1syoukaisakifreearea2) {
        ztydai1syoukaisakifreearea2 = pZtydai1syoukaisakifreearea2;
    }

    private String ztydai1syoukaisakifreearea3;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA3)
    public String getZtydai1syoukaisakifreearea3() {
        return ztydai1syoukaisakifreearea3;
    }

    public void setZtydai1syoukaisakifreearea3(String pZtydai1syoukaisakifreearea3) {
        ztydai1syoukaisakifreearea3 = pZtydai1syoukaisakifreearea3;
    }

    private String ztydai1syoukaisakifreearea4;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA4)
    public String getZtydai1syoukaisakifreearea4() {
        return ztydai1syoukaisakifreearea4;
    }

    public void setZtydai1syoukaisakifreearea4(String pZtydai1syoukaisakifreearea4) {
        ztydai1syoukaisakifreearea4 = pZtydai1syoukaisakifreearea4;
    }

    private String ztydai1syoukaisakifreearea5;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA5)
    public String getZtydai1syoukaisakifreearea5() {
        return ztydai1syoukaisakifreearea5;
    }

    public void setZtydai1syoukaisakifreearea5(String pZtydai1syoukaisakifreearea5) {
        ztydai1syoukaisakifreearea5 = pZtydai1syoukaisakifreearea5;
    }

    private String ztysakunm;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSAKUNM)
    public String getZtysakunm() {
        return ztysakunm;
    }

    public void setZtysakunm(String pZtysakunm) {
        ztysakunm = pZtysakunm;
    }

    private String ztysakuseiymdseireki;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSAKUSEIYMDSEIREKI)
    public String getZtysakuseiymdseireki() {
        return ztysakuseiymdseireki;
    }

    public void setZtysakuseiymdseireki(String pZtysakuseiymdseireki) {
        ztysakuseiymdseireki = pZtysakuseiymdseireki;
    }

    private String ztysyono;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztykykymdseireki;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYKYKYMDSEIREKI)
    public String getZtykykymdseireki() {
        return ztykykymdseireki;
    }

    public void setZtykykymdseireki(String pZtykykymdseireki) {
        ztykykymdseireki = pZtykykymdseireki;
    }

    private String ztyseisikihknnm;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSEISIKIHKNNM)
    public String getZtyseisikihknnm() {
        return ztyseisikihknnm;
    }

    public void setZtyseisikihknnm(String pZtyseisikihknnm) {
        ztyseisikihknnm = pZtyseisikihknnm;
    }

    private String ztyhhknnmkj17;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYHHKNNMKJ17)
    public String getZtyhhknnmkj17() {
        return ztyhhknnmkj17;
    }

    public void setZtyhhknnmkj17(String pZtyhhknnmkj17) {
        ztyhhknnmkj17 = pZtyhhknnmkj17;
    }

    private String ztyfreearea37keta11;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA11)
    public String getZtyfreearea37keta11() {
        return ztyfreearea37keta11;
    }

    public void setZtyfreearea37keta11(String pZtyfreearea37keta11) {
        ztyfreearea37keta11 = pZtyfreearea37keta11;
    }

    private String ztyfreearea37keta12;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA12)
    public String getZtyfreearea37keta12() {
        return ztyfreearea37keta12;
    }

    public void setZtyfreearea37keta12(String pZtyfreearea37keta12) {
        ztyfreearea37keta12 = pZtyfreearea37keta12;
    }

    private String ztyfreearea37keta13;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA13)
    public String getZtyfreearea37keta13() {
        return ztyfreearea37keta13;
    }

    public void setZtyfreearea37keta13(String pZtyfreearea37keta13) {
        ztyfreearea37keta13 = pZtyfreearea37keta13;
    }

    private String ztyfreearea37keta14;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA14)
    public String getZtyfreearea37keta14() {
        return ztyfreearea37keta14;
    }

    public void setZtyfreearea37keta14(String pZtyfreearea37keta14) {
        ztyfreearea37keta14 = pZtyfreearea37keta14;
    }

    private String ztyfreearea37keta15;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA15)
    public String getZtyfreearea37keta15() {
        return ztyfreearea37keta15;
    }

    public void setZtyfreearea37keta15(String pZtyfreearea37keta15) {
        ztyfreearea37keta15 = pZtyfreearea37keta15;
    }

    private String ztyfreearea37keta16;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA16)
    public String getZtyfreearea37keta16() {
        return ztyfreearea37keta16;
    }

    public void setZtyfreearea37keta16(String pZtyfreearea37keta16) {
        ztyfreearea37keta16 = pZtyfreearea37keta16;
    }

    private String ztyfreearea37keta17;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA17)
    public String getZtyfreearea37keta17() {
        return ztyfreearea37keta17;
    }

    public void setZtyfreearea37keta17(String pZtyfreearea37keta17) {
        ztyfreearea37keta17 = pZtyfreearea37keta17;
    }

    private String ztyfreearea37keta18;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA18)
    public String getZtyfreearea37keta18() {
        return ztyfreearea37keta18;
    }

    public void setZtyfreearea37keta18(String pZtyfreearea37keta18) {
        ztyfreearea37keta18 = pZtyfreearea37keta18;
    }

    private String ztyfreearea37keta19;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA19)
    public String getZtyfreearea37keta19() {
        return ztyfreearea37keta19;
    }

    public void setZtyfreearea37keta19(String pZtyfreearea37keta19) {
        ztyfreearea37keta19 = pZtyfreearea37keta19;
    }

    private String ztyfreearea37keta110;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA110)
    public String getZtyfreearea37keta110() {
        return ztyfreearea37keta110;
    }

    public void setZtyfreearea37keta110(String pZtyfreearea37keta110) {
        ztyfreearea37keta110 = pZtyfreearea37keta110;
    }

    private String ztyfreearea37keta111;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA111)
    public String getZtyfreearea37keta111() {
        return ztyfreearea37keta111;
    }

    public void setZtyfreearea37keta111(String pZtyfreearea37keta111) {
        ztyfreearea37keta111 = pZtyfreearea37keta111;
    }

    private String ztyfreearea37keta112;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA112)
    public String getZtyfreearea37keta112() {
        return ztyfreearea37keta112;
    }

    public void setZtyfreearea37keta112(String pZtyfreearea37keta112) {
        ztyfreearea37keta112 = pZtyfreearea37keta112;
    }

    private String ztyfreearea37keta113;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA113)
    public String getZtyfreearea37keta113() {
        return ztyfreearea37keta113;
    }

    public void setZtyfreearea37keta113(String pZtyfreearea37keta113) {
        ztyfreearea37keta113 = pZtyfreearea37keta113;
    }

    private String ztyfreearea37keta114;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA114)
    public String getZtyfreearea37keta114() {
        return ztyfreearea37keta114;
    }

    public void setZtyfreearea37keta114(String pZtyfreearea37keta114) {
        ztyfreearea37keta114 = pZtyfreearea37keta114;
    }

    private String ztyfreearea37keta115;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA115)
    public String getZtyfreearea37keta115() {
        return ztyfreearea37keta115;
    }

    public void setZtyfreearea37keta115(String pZtyfreearea37keta115) {
        ztyfreearea37keta115 = pZtyfreearea37keta115;
    }

    private String ztyfreearea37keta116;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA116)
    public String getZtyfreearea37keta116() {
        return ztyfreearea37keta116;
    }

    public void setZtyfreearea37keta116(String pZtyfreearea37keta116) {
        ztyfreearea37keta116 = pZtyfreearea37keta116;
    }

    private String ztyfreearea37keta117;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA117)
    public String getZtyfreearea37keta117() {
        return ztyfreearea37keta117;
    }

    public void setZtyfreearea37keta117(String pZtyfreearea37keta117) {
        ztyfreearea37keta117 = pZtyfreearea37keta117;
    }

    private String ztyfreearea37keta118;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA118)
    public String getZtyfreearea37keta118() {
        return ztyfreearea37keta118;
    }

    public void setZtyfreearea37keta118(String pZtyfreearea37keta118) {
        ztyfreearea37keta118 = pZtyfreearea37keta118;
    }

    private String ztyfreearea37keta119;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA119)
    public String getZtyfreearea37keta119() {
        return ztyfreearea37keta119;
    }

    public void setZtyfreearea37keta119(String pZtyfreearea37keta119) {
        ztyfreearea37keta119 = pZtyfreearea37keta119;
    }

    private String ztyfreearea37keta120;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA120)
    public String getZtyfreearea37keta120() {
        return ztyfreearea37keta120;
    }

    public void setZtyfreearea37keta120(String pZtyfreearea37keta120) {
        ztyfreearea37keta120 = pZtyfreearea37keta120;
    }

    private String ztyfreearea37keta121;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA121)
    public String getZtyfreearea37keta121() {
        return ztyfreearea37keta121;
    }

    public void setZtyfreearea37keta121(String pZtyfreearea37keta121) {
        ztyfreearea37keta121 = pZtyfreearea37keta121;
    }

    private String ztyfreearea37keta122;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA122)
    public String getZtyfreearea37keta122() {
        return ztyfreearea37keta122;
    }

    public void setZtyfreearea37keta122(String pZtyfreearea37keta122) {
        ztyfreearea37keta122 = pZtyfreearea37keta122;
    }

    private String ztyfreearea37keta123;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA123)
    public String getZtyfreearea37keta123() {
        return ztyfreearea37keta123;
    }

    public void setZtyfreearea37keta123(String pZtyfreearea37keta123) {
        ztyfreearea37keta123 = pZtyfreearea37keta123;
    }

    private String ztyfreearea37keta124;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA124)
    public String getZtyfreearea37keta124() {
        return ztyfreearea37keta124;
    }

    public void setZtyfreearea37keta124(String pZtyfreearea37keta124) {
        ztyfreearea37keta124 = pZtyfreearea37keta124;
    }

    private String ztyfreearea37keta125;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA37KETA125)
    public String getZtyfreearea37keta125() {
        return ztyfreearea37keta125;
    }

    public void setZtyfreearea37keta125(String pZtyfreearea37keta125) {
        ztyfreearea37keta125 = pZtyfreearea37keta125;
    }

    private String ztymidasi11;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYMIDASI11)
    public String getZtymidasi11() {
        return ztymidasi11;
    }

    public void setZtymidasi11(String pZtymidasi11) {
        ztymidasi11 = pZtymidasi11;
    }

    private String ztytouduketorihouhou;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYTOUDUKETORIHOUHOU)
    public String getZtytouduketorihouhou() {
        return ztytouduketorihouhou;
    }

    public void setZtytouduketorihouhou(String pZtytouduketorihouhou) {
        ztytouduketorihouhou = pZtytouduketorihouhou;
    }

    private String ztymidasi21;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYMIDASI21)
    public String getZtymidasi21() {
        return ztymidasi21;
    }

    public void setZtymidasi21(String pZtymidasi21) {
        ztymidasi21 = pZtymidasi21;
    }

    private String ztykakuteidkgk;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYKAKUTEIDKGK)
    public String getZtykakuteidkgk() {
        return ztykakuteidkgk;
    }

    public void setZtykakuteidkgk(String pZtykakuteidkgk) {
        ztykakuteidkgk = pZtykakuteidkgk;
    }

    private String ztymidasi31;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYMIDASI31)
    public String getZtymidasi31() {
        return ztymidasi31;
    }

    public void setZtymidasi31(String pZtymidasi31) {
        ztymidasi31 = pZtymidasi31;
    }

    private String ztynaiteidkgk;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYNAITEIDKGK)
    public String getZtynaiteidkgk() {
        return ztynaiteidkgk;
    }

    public void setZtynaiteidkgk(String pZtynaiteidkgk) {
        ztynaiteidkgk = pZtynaiteidkgk;
    }

    private String ztymidasi41;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYMIDASI41)
    public String getZtymidasi41() {
        return ztymidasi41;
    }

    public void setZtymidasi41(String pZtymidasi41) {
        ztymidasi41 = pZtymidasi41;
    }

    private String ztyseisandkgk;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYSEISANDKGK)
    public String getZtyseisandkgk() {
        return ztyseisandkgk;
    }

    public void setZtyseisandkgk(String pZtyseisandkgk) {
        ztyseisandkgk = pZtyseisandkgk;
    }

    private String ztyfreearea21;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA21)
    public String getZtyfreearea21() {
        return ztyfreearea21;
    }

    public void setZtyfreearea21(String pZtyfreearea21) {
        ztyfreearea21 = pZtyfreearea21;
    }

    private String ztyfreearea22;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA22)
    public String getZtyfreearea22() {
        return ztyfreearea22;
    }

    public void setZtyfreearea22(String pZtyfreearea22) {
        ztyfreearea22 = pZtyfreearea22;
    }

    private String ztyfreearea23;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA23)
    public String getZtyfreearea23() {
        return ztyfreearea23;
    }

    public void setZtyfreearea23(String pZtyfreearea23) {
        ztyfreearea23 = pZtyfreearea23;
    }

    private String ztyfreearea24;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA24)
    public String getZtyfreearea24() {
        return ztyfreearea24;
    }

    public void setZtyfreearea24(String pZtyfreearea24) {
        ztyfreearea24 = pZtyfreearea24;
    }

    private String ztyfreearea25;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYFREEAREA25)
    public String getZtyfreearea25() {
        return ztyfreearea25;
    }

    public void setZtyfreearea25(String pZtyfreearea25) {
        ztyfreearea25 = pZtyfreearea25;
    }

    private String ztyyobiv141;

    @Column(name=GenZT_SeisanDHaneiTuutiTy.ZTYYOBIV141)
    public String getZtyyobiv141() {
        return ztyyobiv141;
    }

    public void setZtyyobiv141(String pZtyyobiv141) {
        ztyyobiv141 = pZtyyobiv141;
    }
}