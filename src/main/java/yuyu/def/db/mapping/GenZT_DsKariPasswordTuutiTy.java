package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.id.PKZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.GenQZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiTy;

/**
 * 仮パスワード通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DsKariPasswordTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsKariPasswordTuutiTy}</td><td colspan="3">仮パスワード通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykrpasswordtuutikey ztykrpasswordtuutikey}</td><td>（中継用）仮パスワード通知キー</td><td align="center">{@link PKZT_DsKariPasswordTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydskokno ztydskokno}</td><td>（中継用）ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiyno ztyatesakiyno}</td><td>（中継用）宛先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiynobarcode ztyatesakiynobarcode}</td><td>（中継用）宛先郵便番号バーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseimd ztysakuseimd}</td><td>（中継用）作成月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclakadskokno ztysclakadskokno}</td><td>（中継用）スクランブル化ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreigaisyorihyj ztyreigaisyorihyj}</td><td>（中継用）例外処理表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyuubinbutukanpusakiyno ztyyuubinbutukanpusakiyno}</td><td>（中継用）郵便物還付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyuubinbutukanpusakiadr ztyyuubinbutukanpusakiadr}</td><td>（中継用）郵便物還付先住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr1 ztyatesakiadr1}</td><td>（中継用）宛先住所１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr2 ztyatesakiadr2}</td><td>（中継用）宛先住所２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr3 ztyatesakiadr3}</td><td>（中継用）宛先住所３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatena1 ztyatena1}</td><td>（中継用）宛名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatena2 ztyatena2}</td><td>（中継用）宛名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea1 ztydai1syoukaisakifreearea1}</td><td>（中継用）第１照会先フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea2 ztydai1syoukaisakifreearea2}</td><td>（中継用）第１照会先フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea3 ztydai1syoukaisakifreearea3}</td><td>（中継用）第１照会先フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea4 ztydai1syoukaisakifreearea4}</td><td>（中継用）第１照会先フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaisakifreearea5 ztydai1syoukaisakifreearea5}</td><td>（中継用）第１照会先フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseino ztysakuseino}</td><td>（中継用）作成No</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyokyakusamanm ztyokyakusamanm}</td><td>（中継用）お客様氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhkymd ztyhkymd}</td><td>（中継用）発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydskrhnnkakcdyoken ztydskrhnnkakcdyoken}</td><td>（中継用）ＤＳ仮本人確認コード与件</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykrpasswordyuukouymd ztykrpasswordyuukouymd}</td><td>（中継用）仮パスワード有効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea1 ztyfreearea1}</td><td>（中継用）フリーエリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea2 ztyfreearea2}</td><td>（中継用）フリーエリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea3 ztyfreearea3}</td><td>（中継用）フリーエリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea4 ztyfreearea4}</td><td>（中継用）フリーエリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea5 ztyfreearea5}</td><td>（中継用）フリーエリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou1 ztytyuuijikou1}</td><td>（中継用）注意事項欄１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou2 ztytyuuijikou2}</td><td>（中継用）注意事項欄２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou3 ztytyuuijikou3}</td><td>（中継用）注意事項欄３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou4 ztytyuuijikou4}</td><td>（中継用）注意事項欄４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou5 ztytyuuijikou5}</td><td>（中継用）注意事項欄５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou6 ztytyuuijikou6}</td><td>（中継用）注意事項欄６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuuijikou7 ztytyuuijikou7}</td><td>（中継用）注意事項欄７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsKariPasswordTuutiTy
 * @see     PKZT_DsKariPasswordTuutiTy
 * @see     QZT_DsKariPasswordTuutiTy
 * @see     GenQZT_DsKariPasswordTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_DsKariPasswordTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_DsKariPasswordTuutiTy.class)
public abstract class GenZT_DsKariPasswordTuutiTy extends AbstractExDBEntity<ZT_DsKariPasswordTuutiTy, PKZT_DsKariPasswordTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DsKariPasswordTuutiTy";
    public static final String ZTYKRPASSWORDTUUTIKEY    = "ztykrpasswordtuutikey";
    public static final String ZTYDSKOKNO               = "ztydskokno";
    public static final String ZTYATESAKIYNO            = "ztyatesakiyno";
    public static final String ZTYATESAKIYNOBARCODE     = "ztyatesakiynobarcode";
    public static final String ZTYSAKUSEIMD             = "ztysakuseimd";
    public static final String ZTYSCLAKADSKOKNO         = "ztysclakadskokno";
    public static final String ZTYREIGAISYORIHYJ        = "ztyreigaisyorihyj";
    public static final String ZTYYUUBINBUTUKANPUSAKIYNO = "ztyyuubinbutukanpusakiyno";
    public static final String ZTYYUUBINBUTUKANPUSAKIADR = "ztyyuubinbutukanpusakiadr";
    public static final String ZTYATESAKIADR1           = "ztyatesakiadr1";
    public static final String ZTYATESAKIADR2           = "ztyatesakiadr2";
    public static final String ZTYATESAKIADR3           = "ztyatesakiadr3";
    public static final String ZTYATENA1                = "ztyatena1";
    public static final String ZTYATENA2                = "ztyatena2";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA1 = "ztydai1syoukaisakifreearea1";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA2 = "ztydai1syoukaisakifreearea2";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA3 = "ztydai1syoukaisakifreearea3";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA4 = "ztydai1syoukaisakifreearea4";
    public static final String ZTYDAI1SYOUKAISAKIFREEAREA5 = "ztydai1syoukaisakifreearea5";
    public static final String ZTYSAKUSEINO             = "ztysakuseino";
    public static final String ZTYOKYAKUSAMANM          = "ztyokyakusamanm";
    public static final String ZTYHKYMD                 = "ztyhkymd";
    public static final String ZTYDSKRHNNKAKCDYOKEN     = "ztydskrhnnkakcdyoken";
    public static final String ZTYKRPASSWORDYUUKOUYMD   = "ztykrpasswordyuukouymd";
    public static final String ZTYFREEAREA1             = "ztyfreearea1";
    public static final String ZTYFREEAREA2             = "ztyfreearea2";
    public static final String ZTYFREEAREA3             = "ztyfreearea3";
    public static final String ZTYFREEAREA4             = "ztyfreearea4";
    public static final String ZTYFREEAREA5             = "ztyfreearea5";
    public static final String ZTYTYUUIJIKOU1           = "ztytyuuijikou1";
    public static final String ZTYTYUUIJIKOU2           = "ztytyuuijikou2";
    public static final String ZTYTYUUIJIKOU3           = "ztytyuuijikou3";
    public static final String ZTYTYUUIJIKOU4           = "ztytyuuijikou4";
    public static final String ZTYTYUUIJIKOU5           = "ztytyuuijikou5";
    public static final String ZTYTYUUIJIKOU6           = "ztytyuuijikou6";
    public static final String ZTYTYUUIJIKOU7           = "ztytyuuijikou7";

    private final PKZT_DsKariPasswordTuutiTy primaryKey;

    public GenZT_DsKariPasswordTuutiTy() {
        primaryKey = new PKZT_DsKariPasswordTuutiTy();
    }

    public GenZT_DsKariPasswordTuutiTy(String pZtykrpasswordtuutikey) {
        primaryKey = new PKZT_DsKariPasswordTuutiTy(pZtykrpasswordtuutikey);
    }

    @Transient
    @Override
    public PKZT_DsKariPasswordTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DsKariPasswordTuutiTy> getMetaClass() {
        return QZT_DsKariPasswordTuutiTy.class;
    }

    @Id
    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYKRPASSWORDTUUTIKEY)
    public String getZtykrpasswordtuutikey() {
        return getPrimaryKey().getZtykrpasswordtuutikey();
    }

    public void setZtykrpasswordtuutikey(String pZtykrpasswordtuutikey) {
        getPrimaryKey().setZtykrpasswordtuutikey(pZtykrpasswordtuutikey);
    }

    private String ztydskokno;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDSKOKNO)
    public String getZtydskokno() {
        return ztydskokno;
    }

    public void setZtydskokno(String pZtydskokno) {
        ztydskokno = pZtydskokno;
    }

    private String ztyatesakiyno;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATESAKIYNO)
    public String getZtyatesakiyno() {
        return ztyatesakiyno;
    }

    public void setZtyatesakiyno(String pZtyatesakiyno) {
        ztyatesakiyno = pZtyatesakiyno;
    }

    private String ztyatesakiynobarcode;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATESAKIYNOBARCODE)
    public String getZtyatesakiynobarcode() {
        return ztyatesakiynobarcode;
    }

    public void setZtyatesakiynobarcode(String pZtyatesakiynobarcode) {
        ztyatesakiynobarcode = pZtyatesakiynobarcode;
    }

    private String ztysakuseimd;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYSAKUSEIMD)
    public String getZtysakuseimd() {
        return ztysakuseimd;
    }

    public void setZtysakuseimd(String pZtysakuseimd) {
        ztysakuseimd = pZtysakuseimd;
    }

    private String ztysclakadskokno;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYSCLAKADSKOKNO)
    public String getZtysclakadskokno() {
        return ztysclakadskokno;
    }

    public void setZtysclakadskokno(String pZtysclakadskokno) {
        ztysclakadskokno = pZtysclakadskokno;
    }

    private String ztyreigaisyorihyj;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYREIGAISYORIHYJ)
    public String getZtyreigaisyorihyj() {
        return ztyreigaisyorihyj;
    }

    public void setZtyreigaisyorihyj(String pZtyreigaisyorihyj) {
        ztyreigaisyorihyj = pZtyreigaisyorihyj;
    }

    private String ztyyuubinbutukanpusakiyno;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYYUUBINBUTUKANPUSAKIYNO)
    public String getZtyyuubinbutukanpusakiyno() {
        return ztyyuubinbutukanpusakiyno;
    }

    public void setZtyyuubinbutukanpusakiyno(String pZtyyuubinbutukanpusakiyno) {
        ztyyuubinbutukanpusakiyno = pZtyyuubinbutukanpusakiyno;
    }

    private String ztyyuubinbutukanpusakiadr;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYYUUBINBUTUKANPUSAKIADR)
    public String getZtyyuubinbutukanpusakiadr() {
        return ztyyuubinbutukanpusakiadr;
    }

    public void setZtyyuubinbutukanpusakiadr(String pZtyyuubinbutukanpusakiadr) {
        ztyyuubinbutukanpusakiadr = pZtyyuubinbutukanpusakiadr;
    }

    private String ztyatesakiadr1;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATESAKIADR1)
    public String getZtyatesakiadr1() {
        return ztyatesakiadr1;
    }

    public void setZtyatesakiadr1(String pZtyatesakiadr1) {
        ztyatesakiadr1 = pZtyatesakiadr1;
    }

    private String ztyatesakiadr2;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATESAKIADR2)
    public String getZtyatesakiadr2() {
        return ztyatesakiadr2;
    }

    public void setZtyatesakiadr2(String pZtyatesakiadr2) {
        ztyatesakiadr2 = pZtyatesakiadr2;
    }

    private String ztyatesakiadr3;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATESAKIADR3)
    public String getZtyatesakiadr3() {
        return ztyatesakiadr3;
    }

    public void setZtyatesakiadr3(String pZtyatesakiadr3) {
        ztyatesakiadr3 = pZtyatesakiadr3;
    }

    private String ztyatena1;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATENA1)
    public String getZtyatena1() {
        return ztyatena1;
    }

    public void setZtyatena1(String pZtyatena1) {
        ztyatena1 = pZtyatena1;
    }

    private String ztyatena2;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYATENA2)
    public String getZtyatena2() {
        return ztyatena2;
    }

    public void setZtyatena2(String pZtyatena2) {
        ztyatena2 = pZtyatena2;
    }

    private String ztydai1syoukaisakifreearea1;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA1)
    public String getZtydai1syoukaisakifreearea1() {
        return ztydai1syoukaisakifreearea1;
    }

    public void setZtydai1syoukaisakifreearea1(String pZtydai1syoukaisakifreearea1) {
        ztydai1syoukaisakifreearea1 = pZtydai1syoukaisakifreearea1;
    }

    private String ztydai1syoukaisakifreearea2;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA2)
    public String getZtydai1syoukaisakifreearea2() {
        return ztydai1syoukaisakifreearea2;
    }

    public void setZtydai1syoukaisakifreearea2(String pZtydai1syoukaisakifreearea2) {
        ztydai1syoukaisakifreearea2 = pZtydai1syoukaisakifreearea2;
    }

    private String ztydai1syoukaisakifreearea3;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA3)
    public String getZtydai1syoukaisakifreearea3() {
        return ztydai1syoukaisakifreearea3;
    }

    public void setZtydai1syoukaisakifreearea3(String pZtydai1syoukaisakifreearea3) {
        ztydai1syoukaisakifreearea3 = pZtydai1syoukaisakifreearea3;
    }

    private String ztydai1syoukaisakifreearea4;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA4)
    public String getZtydai1syoukaisakifreearea4() {
        return ztydai1syoukaisakifreearea4;
    }

    public void setZtydai1syoukaisakifreearea4(String pZtydai1syoukaisakifreearea4) {
        ztydai1syoukaisakifreearea4 = pZtydai1syoukaisakifreearea4;
    }

    private String ztydai1syoukaisakifreearea5;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDAI1SYOUKAISAKIFREEAREA5)
    public String getZtydai1syoukaisakifreearea5() {
        return ztydai1syoukaisakifreearea5;
    }

    public void setZtydai1syoukaisakifreearea5(String pZtydai1syoukaisakifreearea5) {
        ztydai1syoukaisakifreearea5 = pZtydai1syoukaisakifreearea5;
    }

    private String ztysakuseino;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYSAKUSEINO)
    public String getZtysakuseino() {
        return ztysakuseino;
    }

    public void setZtysakuseino(String pZtysakuseino) {
        ztysakuseino = pZtysakuseino;
    }

    private String ztyokyakusamanm;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYOKYAKUSAMANM)
    public String getZtyokyakusamanm() {
        return ztyokyakusamanm;
    }

    public void setZtyokyakusamanm(String pZtyokyakusamanm) {
        ztyokyakusamanm = pZtyokyakusamanm;
    }

    private String ztyhkymd;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYHKYMD)
    public String getZtyhkymd() {
        return ztyhkymd;
    }

    public void setZtyhkymd(String pZtyhkymd) {
        ztyhkymd = pZtyhkymd;
    }

    private String ztydskrhnnkakcdyoken;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYDSKRHNNKAKCDYOKEN)
    public String getZtydskrhnnkakcdyoken() {
        return ztydskrhnnkakcdyoken;
    }

    public void setZtydskrhnnkakcdyoken(String pZtydskrhnnkakcdyoken) {
        ztydskrhnnkakcdyoken = pZtydskrhnnkakcdyoken;
    }

    private String ztykrpasswordyuukouymd;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYKRPASSWORDYUUKOUYMD)
    public String getZtykrpasswordyuukouymd() {
        return ztykrpasswordyuukouymd;
    }

    public void setZtykrpasswordyuukouymd(String pZtykrpasswordyuukouymd) {
        ztykrpasswordyuukouymd = pZtykrpasswordyuukouymd;
    }

    private String ztyfreearea1;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYFREEAREA1)
    public String getZtyfreearea1() {
        return ztyfreearea1;
    }

    public void setZtyfreearea1(String pZtyfreearea1) {
        ztyfreearea1 = pZtyfreearea1;
    }

    private String ztyfreearea2;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYFREEAREA2)
    public String getZtyfreearea2() {
        return ztyfreearea2;
    }

    public void setZtyfreearea2(String pZtyfreearea2) {
        ztyfreearea2 = pZtyfreearea2;
    }

    private String ztyfreearea3;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYFREEAREA3)
    public String getZtyfreearea3() {
        return ztyfreearea3;
    }

    public void setZtyfreearea3(String pZtyfreearea3) {
        ztyfreearea3 = pZtyfreearea3;
    }

    private String ztyfreearea4;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYFREEAREA4)
    public String getZtyfreearea4() {
        return ztyfreearea4;
    }

    public void setZtyfreearea4(String pZtyfreearea4) {
        ztyfreearea4 = pZtyfreearea4;
    }

    private String ztyfreearea5;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYFREEAREA5)
    public String getZtyfreearea5() {
        return ztyfreearea5;
    }

    public void setZtyfreearea5(String pZtyfreearea5) {
        ztyfreearea5 = pZtyfreearea5;
    }

    private String ztytyuuijikou1;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU1)
    public String getZtytyuuijikou1() {
        return ztytyuuijikou1;
    }

    public void setZtytyuuijikou1(String pZtytyuuijikou1) {
        ztytyuuijikou1 = pZtytyuuijikou1;
    }

    private String ztytyuuijikou2;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU2)
    public String getZtytyuuijikou2() {
        return ztytyuuijikou2;
    }

    public void setZtytyuuijikou2(String pZtytyuuijikou2) {
        ztytyuuijikou2 = pZtytyuuijikou2;
    }

    private String ztytyuuijikou3;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU3)
    public String getZtytyuuijikou3() {
        return ztytyuuijikou3;
    }

    public void setZtytyuuijikou3(String pZtytyuuijikou3) {
        ztytyuuijikou3 = pZtytyuuijikou3;
    }

    private String ztytyuuijikou4;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU4)
    public String getZtytyuuijikou4() {
        return ztytyuuijikou4;
    }

    public void setZtytyuuijikou4(String pZtytyuuijikou4) {
        ztytyuuijikou4 = pZtytyuuijikou4;
    }

    private String ztytyuuijikou5;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU5)
    public String getZtytyuuijikou5() {
        return ztytyuuijikou5;
    }

    public void setZtytyuuijikou5(String pZtytyuuijikou5) {
        ztytyuuijikou5 = pZtytyuuijikou5;
    }

    private String ztytyuuijikou6;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU6)
    public String getZtytyuuijikou6() {
        return ztytyuuijikou6;
    }

    public void setZtytyuuijikou6(String pZtytyuuijikou6) {
        ztytyuuijikou6 = pZtytyuuijikou6;
    }

    private String ztytyuuijikou7;

    @Column(name=GenZT_DsKariPasswordTuutiTy.ZTYTYUUIJIKOU7)
    public String getZtytyuuijikou7() {
        return ztytyuuijikou7;
    }

    public void setZtytyuuijikou7(String pZtytyuuijikou7) {
        ztytyuuijikou7 = pZtytyuuijikou7;
    }
}
