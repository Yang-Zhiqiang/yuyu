package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.id.PKZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.GenQZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiRn;

/**
 * 精算Ｄ反映通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SeisanDHaneiTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeisanDHaneiTuutiRn}</td><td colspan="3">精算Ｄ反映通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SeisanDHaneiTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeysyono zrnkeysyono}</td><td>（連携用）キー証券番号</td><td align="center">{@link PKZT_SeisanDHaneiTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitounendo zrnhaitounendo}</td><td>（連携用）配当年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiyno zrnatesakiyno}</td><td>（連携用）宛先郵便番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrigikbn zrnrigikbn}</td><td>（連携用）例外区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeiro zrnhrkkeiro}</td><td>（連携用）払込経路</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr1 zrnatesakiadr1}</td><td>（連携用）宛先住所１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr2 zrnatesakiadr2}</td><td>（連携用）宛先住所２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr3 zrnatesakiadr3}</td><td>（連携用）宛先住所３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatena1 zrnatena1}</td><td>（連携用）宛名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea1 zrndai1syoukaisakifreearea1}</td><td>（連携用）第１照会先フリーエリア１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea2 zrndai1syoukaisakifreearea2}</td><td>（連携用）第１照会先フリーエリア２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea3 zrndai1syoukaisakifreearea3}</td><td>（連携用）第１照会先フリーエリア３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea4 zrndai1syoukaisakifreearea4}</td><td>（連携用）第１照会先フリーエリア４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea5 zrndai1syoukaisakifreearea5}</td><td>（連携用）第１照会先フリーエリア５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakunm zrnsakunm}</td><td>（連携用）作成番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymdseireki zrnsakuseiymdseireki}</td><td>（連携用）作成年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdseireki zrnkykymdseireki}</td><td>（連携用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisikihknnm zrnseisikihknnm}</td><td>（連携用）正式保険名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj17 zrnhhknnmkj17}</td><td>（連携用）被保険者名（漢字）（１７桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta11 zrnfreearea37keta11}</td><td>（連携用）フリーエリア（３７桁）１＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta12 zrnfreearea37keta12}</td><td>（連携用）フリーエリア（３７桁）１＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta13 zrnfreearea37keta13}</td><td>（連携用）フリーエリア（３７桁）１＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta14 zrnfreearea37keta14}</td><td>（連携用）フリーエリア（３７桁）１＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta15 zrnfreearea37keta15}</td><td>（連携用）フリーエリア（３７桁）１＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta16 zrnfreearea37keta16}</td><td>（連携用）フリーエリア（３７桁）１＿６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta17 zrnfreearea37keta17}</td><td>（連携用）フリーエリア（３７桁）１＿７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta18 zrnfreearea37keta18}</td><td>（連携用）フリーエリア（３７桁）１＿８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta19 zrnfreearea37keta19}</td><td>（連携用）フリーエリア（３７桁）１＿９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta110 zrnfreearea37keta110}</td><td>（連携用）フリーエリア（３７桁）１＿１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta111 zrnfreearea37keta111}</td><td>（連携用）フリーエリア（３７桁）１＿１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta112 zrnfreearea37keta112}</td><td>（連携用）フリーエリア（３７桁）１＿１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta113 zrnfreearea37keta113}</td><td>（連携用）フリーエリア（３７桁）１＿１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta114 zrnfreearea37keta114}</td><td>（連携用）フリーエリア（３７桁）１＿１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta115 zrnfreearea37keta115}</td><td>（連携用）フリーエリア（３７桁）１＿１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta116 zrnfreearea37keta116}</td><td>（連携用）フリーエリア（３７桁）１＿１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta117 zrnfreearea37keta117}</td><td>（連携用）フリーエリア（３７桁）１＿１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta118 zrnfreearea37keta118}</td><td>（連携用）フリーエリア（３７桁）１＿１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta119 zrnfreearea37keta119}</td><td>（連携用）フリーエリア（３７桁）１＿１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta120 zrnfreearea37keta120}</td><td>（連携用）フリーエリア（３７桁）１＿２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta121 zrnfreearea37keta121}</td><td>（連携用）フリーエリア（３７桁）１＿２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta122 zrnfreearea37keta122}</td><td>（連携用）フリーエリア（３７桁）１＿２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta123 zrnfreearea37keta123}</td><td>（連携用）フリーエリア（３７桁）１＿２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta124 zrnfreearea37keta124}</td><td>（連携用）フリーエリア（３７桁）１＿２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea37keta125 zrnfreearea37keta125}</td><td>（連携用）フリーエリア（３７桁）１＿２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi11 zrnmidasi11}</td><td>（連携用）見出し１＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntouduketorihouhou zrntouduketorihouhou}</td><td>（連携用）当Ｄ受取方法</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi21 zrnmidasi21}</td><td>（連携用）見出し２＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakuteidkgk zrnkakuteidkgk}</td><td>（連携用）確定Ｄ金額</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi31 zrnmidasi31}</td><td>（連携用）見出し３＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaiteidkgk zrnnaiteidkgk}</td><td>（連携用）内定Ｄ金額</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmidasi41 zrnmidasi41}</td><td>（連携用）見出し４＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisandkgk zrnseisandkgk}</td><td>（連携用）精算Ｄ金額</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea21 zrnfreearea21}</td><td>（連携用）フリーエリア２＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea22 zrnfreearea22}</td><td>（連携用）フリーエリア２＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea23 zrnfreearea23}</td><td>（連携用）フリーエリア２＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea24 zrnfreearea24}</td><td>（連携用）フリーエリア２＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea25 zrnfreearea25}</td><td>（連携用）フリーエリア２＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv141 zrnyobiv141}</td><td>（連携用）予備項目Ｖ１４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeisanDHaneiTuutiRn
 * @see     PKZT_SeisanDHaneiTuutiRn
 * @see     QZT_SeisanDHaneiTuutiRn
 * @see     GenQZT_SeisanDHaneiTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_SeisanDHaneiTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_SeisanDHaneiTuutiRn.class)
public abstract class GenZT_SeisanDHaneiTuutiRn extends AbstractExDBEntityForZDB<ZT_SeisanDHaneiTuutiRn, PKZT_SeisanDHaneiTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SeisanDHaneiTuutiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNKEYSYONO              = "zrnkeysyono";
    public static final String ZRNHAITOUNENDO           = "zrnhaitounendo";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNATESAKIYNO            = "zrnatesakiyno";
    public static final String ZRNRIGIKBN               = "zrnrigikbn";
    public static final String ZRNHRKKEIRO              = "zrnhrkkeiro";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNATESAKIADR1           = "zrnatesakiadr1";
    public static final String ZRNATESAKIADR2           = "zrnatesakiadr2";
    public static final String ZRNATESAKIADR3           = "zrnatesakiadr3";
    public static final String ZRNATENA1                = "zrnatena1";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA1 = "zrndai1syoukaisakifreearea1";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA2 = "zrndai1syoukaisakifreearea2";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA3 = "zrndai1syoukaisakifreearea3";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA4 = "zrndai1syoukaisakifreearea4";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA5 = "zrndai1syoukaisakifreearea5";
    public static final String ZRNSAKUNM                = "zrnsakunm";
    public static final String ZRNSAKUSEIYMDSEIREKI     = "zrnsakuseiymdseireki";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKYKYMDSEIREKI         = "zrnkykymdseireki";
    public static final String ZRNSEISIKIHKNNM          = "zrnseisikihknnm";
    public static final String ZRNHHKNNMKJ17            = "zrnhhknnmkj17";
    public static final String ZRNFREEAREA37KETA11      = "zrnfreearea37keta11";
    public static final String ZRNFREEAREA37KETA12      = "zrnfreearea37keta12";
    public static final String ZRNFREEAREA37KETA13      = "zrnfreearea37keta13";
    public static final String ZRNFREEAREA37KETA14      = "zrnfreearea37keta14";
    public static final String ZRNFREEAREA37KETA15      = "zrnfreearea37keta15";
    public static final String ZRNFREEAREA37KETA16      = "zrnfreearea37keta16";
    public static final String ZRNFREEAREA37KETA17      = "zrnfreearea37keta17";
    public static final String ZRNFREEAREA37KETA18      = "zrnfreearea37keta18";
    public static final String ZRNFREEAREA37KETA19      = "zrnfreearea37keta19";
    public static final String ZRNFREEAREA37KETA110     = "zrnfreearea37keta110";
    public static final String ZRNFREEAREA37KETA111     = "zrnfreearea37keta111";
    public static final String ZRNFREEAREA37KETA112     = "zrnfreearea37keta112";
    public static final String ZRNFREEAREA37KETA113     = "zrnfreearea37keta113";
    public static final String ZRNFREEAREA37KETA114     = "zrnfreearea37keta114";
    public static final String ZRNFREEAREA37KETA115     = "zrnfreearea37keta115";
    public static final String ZRNFREEAREA37KETA116     = "zrnfreearea37keta116";
    public static final String ZRNFREEAREA37KETA117     = "zrnfreearea37keta117";
    public static final String ZRNFREEAREA37KETA118     = "zrnfreearea37keta118";
    public static final String ZRNFREEAREA37KETA119     = "zrnfreearea37keta119";
    public static final String ZRNFREEAREA37KETA120     = "zrnfreearea37keta120";
    public static final String ZRNFREEAREA37KETA121     = "zrnfreearea37keta121";
    public static final String ZRNFREEAREA37KETA122     = "zrnfreearea37keta122";
    public static final String ZRNFREEAREA37KETA123     = "zrnfreearea37keta123";
    public static final String ZRNFREEAREA37KETA124     = "zrnfreearea37keta124";
    public static final String ZRNFREEAREA37KETA125     = "zrnfreearea37keta125";
    public static final String ZRNMIDASI11              = "zrnmidasi11";
    public static final String ZRNTOUDUKETORIHOUHOU     = "zrntouduketorihouhou";
    public static final String ZRNMIDASI21              = "zrnmidasi21";
    public static final String ZRNKAKUTEIDKGK           = "zrnkakuteidkgk";
    public static final String ZRNMIDASI31              = "zrnmidasi31";
    public static final String ZRNNAITEIDKGK            = "zrnnaiteidkgk";
    public static final String ZRNMIDASI41              = "zrnmidasi41";
    public static final String ZRNSEISANDKGK            = "zrnseisandkgk";
    public static final String ZRNFREEAREA21            = "zrnfreearea21";
    public static final String ZRNFREEAREA22            = "zrnfreearea22";
    public static final String ZRNFREEAREA23            = "zrnfreearea23";
    public static final String ZRNFREEAREA24            = "zrnfreearea24";
    public static final String ZRNFREEAREA25            = "zrnfreearea25";
    public static final String ZRNYOBIV141              = "zrnyobiv141";

    private final PKZT_SeisanDHaneiTuutiRn primaryKey;

    public GenZT_SeisanDHaneiTuutiRn() {
        primaryKey = new PKZT_SeisanDHaneiTuutiRn();
    }

    public GenZT_SeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono) {
        primaryKey = new PKZT_SeisanDHaneiTuutiRn(pZrntyouhyouymd, pZrnkeysyono);
    }

    @Transient
    @Override
    public PKZT_SeisanDHaneiTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SeisanDHaneiTuutiRn> getMetaClass() {
        return QZT_SeisanDHaneiTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNKEYSYONO)
    public String getZrnkeysyono() {
        return getPrimaryKey().getZrnkeysyono();
    }

    public void setZrnkeysyono(String pZrnkeysyono) {
        getPrimaryKey().setZrnkeysyono(pZrnkeysyono);
    }

    private String zrnhaitounendo;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNHAITOUNENDO)
    public String getZrnhaitounendo() {
        return zrnhaitounendo;
    }

    public void setZrnhaitounendo(String pZrnhaitounendo) {
        zrnhaitounendo = pZrnhaitounendo;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnatesakiyno;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNATESAKIYNO)
    public String getZrnatesakiyno() {
        return zrnatesakiyno;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiyno(String pZrnatesakiyno) {
        zrnatesakiyno = pZrnatesakiyno;
    }

    private String zrnrigikbn;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNRIGIKBN)
    public String getZrnrigikbn() {
        return zrnrigikbn;
    }

    public void setZrnrigikbn(String pZrnrigikbn) {
        zrnrigikbn = pZrnrigikbn;
    }

    private String zrnhrkkeiro;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNHRKKEIRO)
    public String getZrnhrkkeiro() {
        return zrnhrkkeiro;
    }

    public void setZrnhrkkeiro(String pZrnhrkkeiro) {
        zrnhrkkeiro = pZrnhrkkeiro;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnatesakiadr1;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNATESAKIADR1)
    public String getZrnatesakiadr1() {
        return zrnatesakiadr1;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr1(String pZrnatesakiadr1) {
        zrnatesakiadr1 = pZrnatesakiadr1;
    }

    private String zrnatesakiadr2;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNATESAKIADR2)
    public String getZrnatesakiadr2() {
        return zrnatesakiadr2;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr2(String pZrnatesakiadr2) {
        zrnatesakiadr2 = pZrnatesakiadr2;
    }

    private String zrnatesakiadr3;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNATESAKIADR3)
    public String getZrnatesakiadr3() {
        return zrnatesakiadr3;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr3(String pZrnatesakiadr3) {
        zrnatesakiadr3 = pZrnatesakiadr3;
    }

    private String zrnatena1;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNATENA1)
    public String getZrnatena1() {
        return zrnatena1;
    }

    @DataConvert("toMultiByte")
    public void setZrnatena1(String pZrnatena1) {
        zrnatena1 = pZrnatena1;
    }

    private String zrndai1syoukaisakifreearea1;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA1)
    public String getZrndai1syoukaisakifreearea1() {
        return zrndai1syoukaisakifreearea1;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea1(String pZrndai1syoukaisakifreearea1) {
        zrndai1syoukaisakifreearea1 = pZrndai1syoukaisakifreearea1;
    }

    private String zrndai1syoukaisakifreearea2;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA2)
    public String getZrndai1syoukaisakifreearea2() {
        return zrndai1syoukaisakifreearea2;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea2(String pZrndai1syoukaisakifreearea2) {
        zrndai1syoukaisakifreearea2 = pZrndai1syoukaisakifreearea2;
    }

    private String zrndai1syoukaisakifreearea3;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA3)
    public String getZrndai1syoukaisakifreearea3() {
        return zrndai1syoukaisakifreearea3;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea3(String pZrndai1syoukaisakifreearea3) {
        zrndai1syoukaisakifreearea3 = pZrndai1syoukaisakifreearea3;
    }

    private String zrndai1syoukaisakifreearea4;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA4)
    public String getZrndai1syoukaisakifreearea4() {
        return zrndai1syoukaisakifreearea4;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea4(String pZrndai1syoukaisakifreearea4) {
        zrndai1syoukaisakifreearea4 = pZrndai1syoukaisakifreearea4;
    }

    private String zrndai1syoukaisakifreearea5;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA5)
    public String getZrndai1syoukaisakifreearea5() {
        return zrndai1syoukaisakifreearea5;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea5(String pZrndai1syoukaisakifreearea5) {
        zrndai1syoukaisakifreearea5 = pZrndai1syoukaisakifreearea5;
    }

    private String zrnsakunm;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSAKUNM)
    public String getZrnsakunm() {
        return zrnsakunm;
    }

    public void setZrnsakunm(String pZrnsakunm) {
        zrnsakunm = pZrnsakunm;
    }

    private String zrnsakuseiymdseireki;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSAKUSEIYMDSEIREKI)
    public String getZrnsakuseiymdseireki() {
        return zrnsakuseiymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnsakuseiymdseireki(String pZrnsakuseiymdseireki) {
        zrnsakuseiymdseireki = pZrnsakuseiymdseireki;
    }

    private String zrnsyono;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnkykymdseireki;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNKYKYMDSEIREKI)
    public String getZrnkykymdseireki() {
        return zrnkykymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdseireki(String pZrnkykymdseireki) {
        zrnkykymdseireki = pZrnkykymdseireki;
    }

    private String zrnseisikihknnm;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSEISIKIHKNNM)
    public String getZrnseisikihknnm() {
        return zrnseisikihknnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseisikihknnm(String pZrnseisikihknnm) {
        zrnseisikihknnm = pZrnseisikihknnm;
    }

    private String zrnhhknnmkj17;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNHHKNNMKJ17)
    public String getZrnhhknnmkj17() {
        return zrnhhknnmkj17;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj17(String pZrnhhknnmkj17) {
        zrnhhknnmkj17 = pZrnhhknnmkj17;
    }

    private String zrnfreearea37keta11;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA11)
    public String getZrnfreearea37keta11() {
        return zrnfreearea37keta11;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta11(String pZrnfreearea37keta11) {
        zrnfreearea37keta11 = pZrnfreearea37keta11;
    }

    private String zrnfreearea37keta12;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA12)
    public String getZrnfreearea37keta12() {
        return zrnfreearea37keta12;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta12(String pZrnfreearea37keta12) {
        zrnfreearea37keta12 = pZrnfreearea37keta12;
    }

    private String zrnfreearea37keta13;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA13)
    public String getZrnfreearea37keta13() {
        return zrnfreearea37keta13;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta13(String pZrnfreearea37keta13) {
        zrnfreearea37keta13 = pZrnfreearea37keta13;
    }

    private String zrnfreearea37keta14;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA14)
    public String getZrnfreearea37keta14() {
        return zrnfreearea37keta14;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta14(String pZrnfreearea37keta14) {
        zrnfreearea37keta14 = pZrnfreearea37keta14;
    }

    private String zrnfreearea37keta15;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA15)
    public String getZrnfreearea37keta15() {
        return zrnfreearea37keta15;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta15(String pZrnfreearea37keta15) {
        zrnfreearea37keta15 = pZrnfreearea37keta15;
    }

    private String zrnfreearea37keta16;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA16)
    public String getZrnfreearea37keta16() {
        return zrnfreearea37keta16;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta16(String pZrnfreearea37keta16) {
        zrnfreearea37keta16 = pZrnfreearea37keta16;
    }

    private String zrnfreearea37keta17;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA17)
    public String getZrnfreearea37keta17() {
        return zrnfreearea37keta17;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta17(String pZrnfreearea37keta17) {
        zrnfreearea37keta17 = pZrnfreearea37keta17;
    }

    private String zrnfreearea37keta18;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA18)
    public String getZrnfreearea37keta18() {
        return zrnfreearea37keta18;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta18(String pZrnfreearea37keta18) {
        zrnfreearea37keta18 = pZrnfreearea37keta18;
    }

    private String zrnfreearea37keta19;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA19)
    public String getZrnfreearea37keta19() {
        return zrnfreearea37keta19;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta19(String pZrnfreearea37keta19) {
        zrnfreearea37keta19 = pZrnfreearea37keta19;
    }

    private String zrnfreearea37keta110;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA110)
    public String getZrnfreearea37keta110() {
        return zrnfreearea37keta110;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta110(String pZrnfreearea37keta110) {
        zrnfreearea37keta110 = pZrnfreearea37keta110;
    }

    private String zrnfreearea37keta111;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA111)
    public String getZrnfreearea37keta111() {
        return zrnfreearea37keta111;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta111(String pZrnfreearea37keta111) {
        zrnfreearea37keta111 = pZrnfreearea37keta111;
    }

    private String zrnfreearea37keta112;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA112)
    public String getZrnfreearea37keta112() {
        return zrnfreearea37keta112;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta112(String pZrnfreearea37keta112) {
        zrnfreearea37keta112 = pZrnfreearea37keta112;
    }

    private String zrnfreearea37keta113;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA113)
    public String getZrnfreearea37keta113() {
        return zrnfreearea37keta113;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta113(String pZrnfreearea37keta113) {
        zrnfreearea37keta113 = pZrnfreearea37keta113;
    }

    private String zrnfreearea37keta114;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA114)
    public String getZrnfreearea37keta114() {
        return zrnfreearea37keta114;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta114(String pZrnfreearea37keta114) {
        zrnfreearea37keta114 = pZrnfreearea37keta114;
    }

    private String zrnfreearea37keta115;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA115)
    public String getZrnfreearea37keta115() {
        return zrnfreearea37keta115;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta115(String pZrnfreearea37keta115) {
        zrnfreearea37keta115 = pZrnfreearea37keta115;
    }

    private String zrnfreearea37keta116;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA116)
    public String getZrnfreearea37keta116() {
        return zrnfreearea37keta116;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta116(String pZrnfreearea37keta116) {
        zrnfreearea37keta116 = pZrnfreearea37keta116;
    }

    private String zrnfreearea37keta117;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA117)
    public String getZrnfreearea37keta117() {
        return zrnfreearea37keta117;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta117(String pZrnfreearea37keta117) {
        zrnfreearea37keta117 = pZrnfreearea37keta117;
    }

    private String zrnfreearea37keta118;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA118)
    public String getZrnfreearea37keta118() {
        return zrnfreearea37keta118;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta118(String pZrnfreearea37keta118) {
        zrnfreearea37keta118 = pZrnfreearea37keta118;
    }

    private String zrnfreearea37keta119;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA119)
    public String getZrnfreearea37keta119() {
        return zrnfreearea37keta119;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta119(String pZrnfreearea37keta119) {
        zrnfreearea37keta119 = pZrnfreearea37keta119;
    }

    private String zrnfreearea37keta120;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA120)
    public String getZrnfreearea37keta120() {
        return zrnfreearea37keta120;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta120(String pZrnfreearea37keta120) {
        zrnfreearea37keta120 = pZrnfreearea37keta120;
    }

    private String zrnfreearea37keta121;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA121)
    public String getZrnfreearea37keta121() {
        return zrnfreearea37keta121;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta121(String pZrnfreearea37keta121) {
        zrnfreearea37keta121 = pZrnfreearea37keta121;
    }

    private String zrnfreearea37keta122;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA122)
    public String getZrnfreearea37keta122() {
        return zrnfreearea37keta122;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta122(String pZrnfreearea37keta122) {
        zrnfreearea37keta122 = pZrnfreearea37keta122;
    }

    private String zrnfreearea37keta123;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA123)
    public String getZrnfreearea37keta123() {
        return zrnfreearea37keta123;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta123(String pZrnfreearea37keta123) {
        zrnfreearea37keta123 = pZrnfreearea37keta123;
    }

    private String zrnfreearea37keta124;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA124)
    public String getZrnfreearea37keta124() {
        return zrnfreearea37keta124;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta124(String pZrnfreearea37keta124) {
        zrnfreearea37keta124 = pZrnfreearea37keta124;
    }

    private String zrnfreearea37keta125;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA37KETA125)
    public String getZrnfreearea37keta125() {
        return zrnfreearea37keta125;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea37keta125(String pZrnfreearea37keta125) {
        zrnfreearea37keta125 = pZrnfreearea37keta125;
    }

    private String zrnmidasi11;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNMIDASI11)
    public String getZrnmidasi11() {
        return zrnmidasi11;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi11(String pZrnmidasi11) {
        zrnmidasi11 = pZrnmidasi11;
    }

    private String zrntouduketorihouhou;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNTOUDUKETORIHOUHOU)
    public String getZrntouduketorihouhou() {
        return zrntouduketorihouhou;
    }

    @DataConvert("toMultiByte")
    @Padding(mode = "left", padChar = '　', length = 16)
    public void setZrntouduketorihouhou(String pZrntouduketorihouhou) {
        zrntouduketorihouhou = pZrntouduketorihouhou;
    }

    private String zrnmidasi21;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNMIDASI21)
    public String getZrnmidasi21() {
        return zrnmidasi21;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi21(String pZrnmidasi21) {
        zrnmidasi21 = pZrnmidasi21;
    }

    private String zrnkakuteidkgk;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNKAKUTEIDKGK)
    public String getZrnkakuteidkgk() {
        return zrnkakuteidkgk;
    }

    @DataConvert("toMultiByte")
    @Padding(mode = "left", padChar = '　', length = 17)
    public void setZrnkakuteidkgk(String pZrnkakuteidkgk) {
        zrnkakuteidkgk = pZrnkakuteidkgk;
    }

    private String zrnmidasi31;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNMIDASI31)
    public String getZrnmidasi31() {
        return zrnmidasi31;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi31(String pZrnmidasi31) {
        zrnmidasi31 = pZrnmidasi31;
    }

    private String zrnnaiteidkgk;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNNAITEIDKGK)
    public String getZrnnaiteidkgk() {
        return zrnnaiteidkgk;
    }

    @DataConvert("toMultiByte")
    @Padding(mode = "left", padChar = '　', length = 17)
    public void setZrnnaiteidkgk(String pZrnnaiteidkgk) {
        zrnnaiteidkgk = pZrnnaiteidkgk;
    }

    private String zrnmidasi41;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNMIDASI41)
    public String getZrnmidasi41() {
        return zrnmidasi41;
    }

    @DataConvert("toMultiByte")
    public void setZrnmidasi41(String pZrnmidasi41) {
        zrnmidasi41 = pZrnmidasi41;
    }

    private String zrnseisandkgk;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNSEISANDKGK)
    public String getZrnseisandkgk() {
        return zrnseisandkgk;
    }

    @DataConvert("toMultiByte")
    @Padding(mode = "left", padChar = '　', length = 17)
    public void setZrnseisandkgk(String pZrnseisandkgk) {
        zrnseisandkgk = pZrnseisandkgk;
    }

    private String zrnfreearea21;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA21)
    public String getZrnfreearea21() {
        return zrnfreearea21;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea21(String pZrnfreearea21) {
        zrnfreearea21 = pZrnfreearea21;
    }

    private String zrnfreearea22;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA22)
    public String getZrnfreearea22() {
        return zrnfreearea22;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea22(String pZrnfreearea22) {
        zrnfreearea22 = pZrnfreearea22;
    }

    private String zrnfreearea23;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA23)
    public String getZrnfreearea23() {
        return zrnfreearea23;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea23(String pZrnfreearea23) {
        zrnfreearea23 = pZrnfreearea23;
    }

    private String zrnfreearea24;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA24)
    public String getZrnfreearea24() {
        return zrnfreearea24;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea24(String pZrnfreearea24) {
        zrnfreearea24 = pZrnfreearea24;
    }

    private String zrnfreearea25;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNFREEAREA25)
    public String getZrnfreearea25() {
        return zrnfreearea25;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea25(String pZrnfreearea25) {
        zrnfreearea25 = pZrnfreearea25;
    }

    private String zrnyobiv141;

    @Column(name=GenZT_SeisanDHaneiTuutiRn.ZRNYOBIV141)
    public String getZrnyobiv141() {
        return zrnyobiv141;
    }

    public void setZrnyobiv141(String pZrnyobiv141) {
        zrnyobiv141 = pZrnyobiv141;
    }
}